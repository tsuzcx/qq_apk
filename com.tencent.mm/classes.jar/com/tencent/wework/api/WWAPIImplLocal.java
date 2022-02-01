package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.util.OpenDataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class WWAPIImplLocal
  implements IWWAPI
{
  private static final ArrayList<String> aicF;
  private static final ArrayList<String> aicG;
  private static final ArrayList<String> aicN;
  private Map<String, Object> Lfc;
  private String aicE;
  private BroadcastReceiver aicI;
  private final Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(210618);
    aicF = new ArrayList() {};
    aicG = new ArrayList() {};
    aicN = new ArrayList() {};
    AppMethodBeat.o(210618);
  }
  
  WWAPIImplLocal(Context paramContext)
  {
    AppMethodBeat.i(210558);
    this.Lfc = new HashMap();
    this.aicI = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(210570);
        try
        {
          boolean bool = WWAPIImplLocal.a(WWAPIImplLocal.this).equals(paramAnonymousIntent.getScheme());
          if (!bool) {
            return;
          }
          paramAnonymousContext = BaseMessage.w(paramAnonymousIntent.getData());
          paramAnonymousContext.bGX(WWAPIImplLocal.b(WWAPIImplLocal.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(210557);
                try
                {
                  WWAPIImplLocal.c(WWAPIImplLocal.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImplLocal.c(WWAPIImplLocal.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  return;
                }
                finally
                {
                  AppMethodBeat.o(210557);
                }
              }
            });
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(210570);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(210558);
  }
  
  private int bGU(String paramString)
  {
    AppMethodBeat.i(210581);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null) {
        return 0;
      }
      int i = paramString.versionCode;
      return i;
    }
    finally
    {
      AppMethodBeat.o(210581);
    }
    return 0;
  }
  
  private String bGV(String paramString)
  {
    AppMethodBeat.i(210588);
    try
    {
      paramString = dC(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(210588);
    }
    return "";
  }
  
  private boolean bGW(String paramString)
  {
    AppMethodBeat.i(210601);
    paramString = bGV(paramString);
    boolean bool = aicN.contains(paramString);
    AppMethodBeat.o(210601);
    return bool;
  }
  
  private boolean cu(Intent paramIntent)
  {
    AppMethodBeat.i(210565);
    if (this.context.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0)
    {
      AppMethodBeat.o(210565);
      return true;
    }
    AppMethodBeat.o(210565);
    return false;
  }
  
  private String cv(Intent paramIntent)
  {
    AppMethodBeat.i(210573);
    List localList = this.context.getPackageManager().queryIntentActivities(paramIntent, 65536);
    paramIntent = "";
    if (localList.size() > 0) {
      paramIntent = ((ResolveInfo)localList.get(0)).activityInfo.applicationInfo.packageName;
    }
    AppMethodBeat.o(210573);
    return paramIntent;
  }
  
  private static String dC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210594);
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).reset();
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      localObject = new StringBuilder(paramArrayOfByte.length * 2);
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        int k = paramArrayOfByte[i];
        ((StringBuilder)localObject).append(Integer.toHexString((k & 0xF0) >>> 4));
        ((StringBuilder)localObject).append(Integer.toHexString(k & 0xF));
        i += 1;
      }
      paramArrayOfByte = ((StringBuilder)localObject).toString().toUpperCase();
      AppMethodBeat.o(210594);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(210594);
    }
    return "";
  }
  
  public final boolean a(IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(210624);
    if (paramWWAppType == IWWAPI.WWAppType.aicA)
    {
      boolean bool = bGW("com.tencent.wework");
      AppMethodBeat.o(210624);
      return bool;
    }
    if (paramWWAppType == IWWAPI.WWAppType.aicB)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxwork://jump"));
      if ((bGW("com.tencent.wework")) || (bGW("com.tencent.wwgovernment")) || (cu(paramWWAppType)))
      {
        AppMethodBeat.o(210624);
        return true;
      }
      AppMethodBeat.o(210624);
      return false;
    }
    if (paramWWAppType == IWWAPI.WWAppType.aicC)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
      if ((bGW("com.tencent.wwgovernment")) || (cu(paramWWAppType)))
      {
        AppMethodBeat.o(210624);
        return true;
      }
      AppMethodBeat.o(210624);
      return false;
    }
    AppMethodBeat.o(210624);
    return false;
  }
  
  public final boolean a(BaseMessage paramBaseMessage, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(210641);
    Object localObject1 = new ArrayList();
    Iterator localIterator;
    if (paramWWAppType == IWWAPI.WWAppType.aicA)
    {
      ((List)localObject1).add("com.tencent.wework");
      localIterator = ((List)localObject1).iterator();
    }
    label907:
    label915:
    label920:
    for (;;)
    {
      Object localObject4;
      long l;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label907;
        }
        localObject1 = (String)localIterator.next();
        if (((((String)localObject1).equals("com.tencent.wework")) || (((String)localObject1).equals("com.tencent.wwgovernment"))) && (bGW((String)localObject1)))
        {
          localObject3 = new Intent("com.tencent.wework.apihost");
          ((Intent)localObject3).setClassName((String)localObject1, "com.tencent.wework.apihost.WWAPIActivity");
          ((Intent)localObject3).addFlags(411041792);
          try
          {
            paramBaseMessage.bGY((String)localObject1);
            paramBaseMessage.setContext(this.context);
            localObject4 = BaseMessage.a(paramBaseMessage);
            l = OpenDataUtils.c(this.context, this.context.getPackageName(), (String)localObject1, (Bundle)localObject4);
            if (l > 0L)
            {
              ((Intent)localObject3).putExtra("data_id", l);
              ((Intent)localObject3).putExtra("data_pkg", this.context.getPackageName());
            }
            for (;;)
            {
              ((Intent)localObject3).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.aicI.getClass()), 134217728));
              paramBaseMessage.w((Intent)localObject3, (String)localObject1);
              localObject1 = this.context;
              localObject3 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject3);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(210641);
              return true;
              if (paramWWAppType == IWWAPI.WWAppType.aicB)
              {
                ((List)localObject1).add("com.tencent.wework");
                ((List)localObject1).add("com.tencent.weworkenterprise");
                break;
              }
              if (paramWWAppType != IWWAPI.WWAppType.aicC) {
                break;
              }
              ((List)localObject1).add("com.tencent.wwgovernment");
              ((List)localObject1).add("com.tencent.weworklocal");
              break;
              ((Intent)localObject3).putExtras((Bundle)localObject4);
            }
          }
          finally {}
        }
      }
      String str;
      if (localObject2.equals("com.tencent.weworkenterprise"))
      {
        localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxwork://jump"));
        if (cu((Intent)localObject3))
        {
          str = cv((Intent)localObject3);
          if (!bGW(str)) {}
        }
      }
      for (Object localObject3 = "wxwork";; localObject3 = "")
      {
        for (;;)
        {
          label470:
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label920;
          }
          localObject4 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse((String)localObject3 + "://jump"));
          ((Intent)localObject4).addFlags(411041792);
          try
          {
            paramBaseMessage.bGY(str);
            paramBaseMessage.setContext(this.context);
            Object localObject6 = BaseMessage.a(paramBaseMessage);
            l = OpenDataUtils.c(this.context, this.context.getPackageName(), str, (Bundle)localObject6);
            if (l > 0L)
            {
              ((Intent)localObject4).putExtra("data_id", l);
              ((Intent)localObject4).putExtra("data_pkg", this.context.getPackageName());
            }
            for (;;)
            {
              ((Intent)localObject4).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.aicI.getClass()), 134217728));
              paramBaseMessage.w((Intent)localObject4, str);
              localObject6 = this.context;
              localObject4 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject4);
              com.tencent.mm.hellhoundlib.a.a.b(localObject6, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aYi(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject6).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject4).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject6, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              new StringBuilder("sendMessage, start WWAPIActivity, pkg: ").append(str).append(",scheme:").append((String)localObject3).append(", appType:").append(paramWWAppType);
              AppMethodBeat.o(210641);
              return true;
              AppMethodBeat.o(210641);
              return false;
              localObject3 = "";
              break label470;
              if (!str.equals("com.tencent.weworklocal")) {
                break;
              }
              localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
              if (!cu((Intent)localObject3)) {
                break label915;
              }
              str = cv((Intent)localObject3);
              if (bGW(str))
              {
                localObject3 = "wxworkgovuniform";
                break label470;
              }
              AppMethodBeat.o(210641);
              return false;
              ((Intent)localObject4).putExtras((Bundle)localObject6);
            }
            break;
          }
          finally
          {
            new StringBuilder("sendMessage failed, pkg: ").append(str).append(",scheme:").append((String)localObject3).append(", appType:").append(paramWWAppType);
          }
        }
        AppMethodBeat.o(210641);
        return false;
      }
    }
  }
  
  public final String b(IWWAPI.WWAppType paramWWAppType)
  {
    if (paramWWAppType == IWWAPI.WWAppType.aicC) {
      return "政务微信";
    }
    return "企业微信";
  }
  
  public final boolean keI()
  {
    AppMethodBeat.i(210628);
    ArrayList localArrayList = aicF;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = aicG;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = bGU((String)((Iterator)localObject).next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(210628);
      return true;
      i = 0;
    }
    AppMethodBeat.o(210628);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImplLocal
 * JD-Core Version:    0.7.0.1
 */