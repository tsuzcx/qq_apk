package com.tencent.mm.sensitive.business;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sensitive.d.a;
import com.tencent.mm.sensitive.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/business/BusinessStackRecorder;", "Landroid/content/BroadcastReceiver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "HANDLER_WHAT", "", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "initJson2Map", "", "markBusiness", "action", "", "activityName", "activityRef", "onActivityCreated", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityPreCreated", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "registActivityLife", "sendMsg", "Companion", "MsgData", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BusinessStackRecorder
  extends BroadcastReceiver
  implements Application.ActivityLifecycleCallbacks
{
  private static final String TAG;
  private static final HashMap<String, String> acuA;
  private static final HashMap<String, String> acuB;
  private static final LinkedList<BusinessStackRecorder.c> acuC;
  private static final LinkedList<BusinessStackRecorder.c> acuD;
  private static final j<BusinessStackRecorder> acuE;
  public static final a acuv;
  private static final String acux;
  private static final String acuy;
  private static final String acuz;
  private static final MultiProcessMMKV eMf;
  private final int acuw;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(241100);
    acuv = new a((byte)0);
    TAG = "BusinessStackRecorder";
    acux = "com.tencent.mm.sensitive.SENSITIVE_PAGE_ENTER";
    acuy = "com.tencent.mm.sensitive.SENSITIVE_PAGE_EXIT";
    acuz = "SENSITIVE_BUSINESS_STR";
    acuA = new HashMap();
    acuB = new HashMap();
    acuC = new LinkedList();
    acuD = new LinkedList();
    eMf = MultiProcessMMKV.getMMKV(TAG);
    acuE = kotlin.k.cm((kotlin.g.a.a)b.acuF);
    AppMethodBeat.o(241100);
  }
  
  public BusinessStackRecorder()
  {
    AppMethodBeat.i(241047);
    this.acuw = 1000;
    iTI();
    this.rdm = kotlin.k.cm((kotlin.g.a.a)d.acuI);
    AppMethodBeat.o(241047);
  }
  
  private void bZ(Intent paramIntent)
  {
    AppMethodBeat.i(241079);
    String str1;
    String str2;
    String str3;
    if (paramIntent != null)
    {
      str1 = paramIntent.getAction();
      str2 = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_CLASS_NAME");
      str3 = paramIntent.getStringExtra("_application_context_process_");
      paramIntent = paramIntent.getStringExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_REF");
      if ((str1 == null) || (str2 == null) || (str3 == null) || (paramIntent == null)) {
        break label111;
      }
    }
    label111:
    for (paramIntent = new BusinessStackRecorder.c(str1, str2, paramIntent, str3, SystemClock.uptimeMillis());; paramIntent = null)
    {
      if (paramIntent != null)
      {
        Log.i(TAG, s.X("receive ", paramIntent));
        getHandler().sendMessage(getHandler().obtainMessage(this.acuw, paramIntent));
      }
      AppMethodBeat.o(241079);
      return;
    }
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(241073);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(241073);
    return localMMHandler;
  }
  
  private static void iTI()
  {
    AppMethodBeat.i(241067);
    try
    {
      Object localObject1 = com.tencent.mm.sensitive.k.acud;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      localObject1 = new JSONObject(com.tencent.mm.sensitive.k.cl((Context)localObject1, "businessToActivityName.json"));
      Object localObject2 = ((JSONObject)localObject1).keys();
      s.s(localObject2, "json.keys()");
      String str1;
      Object localObject3;
      Map localMap;
      while (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        localObject3 = ((JSONObject)localObject1).getJSONArray(str1);
        int k = ((JSONArray)localObject3).length();
        if (k > 0)
        {
          int j;
          for (int i = 0;; i = j)
          {
            j = i + 1;
            localMap = (Map)acuA;
            String str2 = ((JSONArray)localObject3).get(i).toString();
            s.s(str1, "it");
            localMap.put(str2, str1);
            if (j >= k) {
              break;
            }
          }
        }
      }
      localObject1 = com.tencent.mm.sensitive.k.acud;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      localObject1 = new JSONObject(com.tencent.mm.sensitive.k.cl((Context)localObject1, "keywordToBusinessMap.json"));
      localObject2 = ((JSONObject)localObject1).keys();
      s.s(localObject2, "json2.keys()");
      while (((Iterator)localObject2).hasNext())
      {
        str1 = (String)((Iterator)localObject2).next();
        localObject3 = ((JSONObject)localObject1).optString(str1);
        localMap = (Map)acuB;
        s.s(str1, "it");
        s.s(localObject3, "businessName");
        localMap.put(str1, localObject3);
      }
      AppMethodBeat.o(241067);
    }
    catch (Exception localException)
    {
      Log.i(TAG, s.X("catch exception: ", localException.getMessage()));
      localObject2 = com.tencent.mm.sensitive.d.a.acvx;
      com.tencent.mm.sensitive.d.a.pC("initJson2Map", s.X("[throwAbleStr] catch: ", localException.getCause()));
      AppMethodBeat.o(241067);
      return;
    }
  }
  
  public static void iTM()
  {
    AppMethodBeat.i(241054);
    Object localObject = MMApplicationContext.getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(241054);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)a.iTY());
    AppMethodBeat.o(241054);
  }
  
  public final void bG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(241106);
    s.u(paramString1, "action");
    s.u(paramString2, "activityName");
    s.u(paramString3, "activityRef");
    Intent localIntent = new Intent();
    localIntent.setAction(paramString1);
    localIntent.putExtra("_application_context_process_", MMApplicationContext.getProcessName() + '@' + Process.myPid());
    localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_CLASS_NAME", paramString2);
    localIntent.putExtra("com.tencent.mm.AppForegroundDelegate.ACTIVITY_REF", paramString3);
    if (MMApplicationContext.isMainProcess())
    {
      bZ(localIntent);
      AppMethodBeat.o(241106);
      return;
    }
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(241106);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(241109);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(241109);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(241130);
    s.u(paramActivity, "activity");
    String str = paramActivity.getClass().getName();
    s.s(str, "activity.javaClass.name");
    bG("com.tencent.mm.sensitive.SENSITIVE_PAGE_EXIT", str, String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(241130);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(241119);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(241119);
  }
  
  public final void onActivityPreCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(241137);
    s.u(paramActivity, "activity");
    paramBundle = paramActivity.getClass().getName();
    s.s(paramBundle, "activity.javaClass.name");
    bG("com.tencent.mm.sensitive.SENSITIVE_PAGE_ENTER", paramBundle, String.valueOf(paramActivity.hashCode()));
    AppMethodBeat.o(241137);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(241117);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(241117);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(241125);
    s.u(paramActivity, "activity");
    s.u(paramBundle, "outState");
    AppMethodBeat.o(241125);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(241112);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(241112);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(241121);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(241121);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(241102);
    bZ(paramIntent);
    AppMethodBeat.o(241102);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/business/BusinessStackRecorder$Companion;", "", "()V", "ACTION_ENTER", "", "getACTION_ENTER", "()Ljava/lang/String;", "ACTION_EXIT", "getACTION_EXIT", "BUSINESS_MMKV_TAG", "getBUSINESS_MMKV_TAG", "TAG", "activityName2BusinessName", "Ljava/util/HashMap;", "getActivityName2BusinessName", "()Ljava/util/HashMap;", "businessStack", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sensitive/business/BusinessStackRecorder$MsgData;", "currentPageList", "keyWord2BusinessName", "getKeyWord2BusinessName", "mInstance", "Lcom/tencent/mm/sensitive/business/BusinessStackRecorder;", "getMInstance", "()Lcom/tencent/mm/sensitive/business/BusinessStackRecorder;", "mInstance$delegate", "Lkotlin/Lazy;", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "businessList2String", "", "getBusinessMultiProcess", "getInstance", "getTopBusiness", "getTopPage", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static String iTV()
    {
      AppMethodBeat.i(241052);
      Object localObject = BusinessStackRecorder.iTS().getString(BusinessStackRecorder.iTP(), null);
      if (localObject == null)
      {
        AppMethodBeat.o(241052);
        return null;
      }
      localObject = Util.stringToList((String)localObject, ",");
      s.s(localObject, "stringToList(it, \",\")");
      localObject = (String)p.oN((List)localObject);
      AppMethodBeat.o(241052);
      return localObject;
    }
    
    public static String iTW()
    {
      AppMethodBeat.i(241057);
      if (MMApplicationContext.isMainProcess())
      {
        localObject = (BusinessStackRecorder.c)p.oN((List)BusinessStackRecorder.iTR());
        if (localObject == null)
        {
          AppMethodBeat.o(241057);
          return null;
        }
        localObject = ((BusinessStackRecorder.c)localObject).acuH;
        if (localObject == null)
        {
          AppMethodBeat.o(241057);
          return null;
        }
        localObject = ((d.a)localObject).value;
        AppMethodBeat.o(241057);
        return localObject;
      }
      Object localObject = iTV();
      AppMethodBeat.o(241057);
      return localObject;
    }
    
    public static String iTX()
    {
      AppMethodBeat.i(241063);
      Object localObject = (BusinessStackRecorder.c)p.oN((List)BusinessStackRecorder.iTT());
      if (localObject == null)
      {
        AppMethodBeat.o(241063);
        return null;
      }
      localObject = ((BusinessStackRecorder.c)localObject).hJW;
      AppMethodBeat.o(241063);
      return localObject;
    }
    
    public static BusinessStackRecorder iTY()
    {
      AppMethodBeat.i(241071);
      BusinessStackRecorder localBusinessStackRecorder = (BusinessStackRecorder)BusinessStackRecorder.iTU().getValue();
      AppMethodBeat.o(241071);
      return localBusinessStackRecorder;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sensitive/business/BusinessStackRecorder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<BusinessStackRecorder>
  {
    public static final b acuF;
    
    static
    {
      AppMethodBeat.i(241044);
      acuF = new b();
      AppMethodBeat.o(241044);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<MMHandler>
  {
    public static final d acuI;
    
    static
    {
      AppMethodBeat.i(241060);
      acuI = new d();
      AppMethodBeat.o(241060);
    }
    
    d()
    {
      super();
    }
    
    private static final boolean v(Message paramMessage)
    {
      AppMethodBeat.i(241056);
      s.u(paramMessage, "msg");
      for (;;)
      {
        synchronized (BusinessStackRecorder.iTT())
        {
          if ((paramMessage.obj instanceof BusinessStackRecorder.c))
          {
            if (paramMessage == null) {
              break label198;
            }
            paramMessage = paramMessage.obj;
            if (paramMessage != null) {
              break;
            }
            paramMessage = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.sensitive.business.BusinessStackRecorder.MsgData");
            AppMethodBeat.o(241056);
            throw paramMessage;
          }
        }
        paramMessage = null;
      }
      BusinessStackRecorder.c localc = (BusinessStackRecorder.c)paramMessage;
      paramMessage = localc.action;
      Object localObject = BusinessStackRecorder.acuv;
      int i;
      if (s.p(paramMessage, BusinessStackRecorder.iTN()))
      {
        paramMessage = BusinessStackRecorder.iTT();
        if (!BusinessStackRecorder.iTT().contains(localc))
        {
          i = 1;
          break label335;
        }
      }
      for (;;)
      {
        if (paramMessage != null) {
          paramMessage.add(localc);
        }
        paramMessage = BusinessStackRecorder.acuv;
        paramMessage = (String)BusinessStackRecorder.iTQ().get(localc.hJW);
        if (paramMessage != null)
        {
          localObject = i.actT;
          paramMessage = i.bup(paramMessage);
          if (paramMessage != null)
          {
            localc.acuH = paramMessage;
            Log.i(BusinessStackRecorder.access$getTAG$cp(), s.X("enter business:", paramMessage));
            BusinessStackRecorder.iTR().add(localc);
            paramMessage = BusinessStackRecorder.acuv;
            BusinessStackRecorder.a.iTZ();
            paramMessage = ah.aiuX;
          }
        }
        label198:
        AppMethodBeat.o(241056);
        return true;
        i = 0;
        label335:
        while (i == 0)
        {
          paramMessage = null;
          break;
          localObject = BusinessStackRecorder.acuv;
          if (s.p(paramMessage, BusinessStackRecorder.iTO()))
          {
            BusinessStackRecorder.iTT().remove(localc);
            paramMessage = BusinessStackRecorder.acuv;
            paramMessage = (String)BusinessStackRecorder.iTQ().get(localc.hJW);
            if (paramMessage == null) {
              break label198;
            }
            localObject = i.actT;
            paramMessage = i.bup(paramMessage);
            if (paramMessage == null) {
              break label198;
            }
            Log.i(BusinessStackRecorder.access$getTAG$cp(), s.X("exit business:", paramMessage));
            d.a(BusinessStackRecorder.iTR(), (b)new BusinessStackRecorder.d.a(localc));
            paramMessage = BusinessStackRecorder.acuv;
            BusinessStackRecorder.a.iTZ();
            paramMessage = ah.aiuX;
            break label198;
          }
          Log.i(BusinessStackRecorder.access$getTAG$cp(), "handle illegal msg, do nothing");
          paramMessage = ah.aiuX;
          break label198;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sensitive.business.BusinessStackRecorder
 * JD-Core Version:    0.7.0.1
 */