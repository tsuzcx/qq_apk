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
  private static final ArrayList<String> ZYg;
  private static final ArrayList<String> ZYh;
  private static final ArrayList<String> ZYm;
  private String ZYf;
  private BroadcastReceiver ZYi;
  private Map<String, Object> callbacks;
  private Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(233327);
    ZYg = new ArrayList() {};
    ZYh = new ArrayList() {};
    ZYm = new ArrayList() {};
    AppMethodBeat.o(233327);
  }
  
  WWAPIImplLocal(Context paramContext)
  {
    AppMethodBeat.i(233300);
    this.callbacks = new HashMap();
    this.ZYi = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(233299);
        try
        {
          boolean bool = WWAPIImplLocal.a(WWAPIImplLocal.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(233299);
            return;
          }
          paramAnonymousContext = BaseMessage.t(paramAnonymousIntent.getData());
          paramAnonymousContext.bEy(WWAPIImplLocal.b(WWAPIImplLocal.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(233297);
                try
                {
                  WWAPIImplLocal.c(WWAPIImplLocal.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImplLocal.c(WWAPIImplLocal.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(233297);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(233297);
                }
              }
            });
          }
          AppMethodBeat.o(233299);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(233299);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(233300);
  }
  
  private int bEv(String paramString)
  {
    AppMethodBeat.i(233308);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null)
      {
        AppMethodBeat.o(233308);
        return 0;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(233308);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(233308);
    }
    return 0;
  }
  
  private String bEw(String paramString)
  {
    AppMethodBeat.i(233316);
    try
    {
      paramString = dA(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      AppMethodBeat.o(233316);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(233316);
    }
    return "";
  }
  
  private boolean bEx(String paramString)
  {
    AppMethodBeat.i(233321);
    paramString = bEw(paramString);
    boolean bool = ZYm.contains(paramString);
    AppMethodBeat.o(233321);
    return bool;
  }
  
  private boolean bP(Intent paramIntent)
  {
    AppMethodBeat.i(233304);
    if (this.context.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0)
    {
      AppMethodBeat.o(233304);
      return true;
    }
    AppMethodBeat.o(233304);
    return false;
  }
  
  private String bQ(Intent paramIntent)
  {
    AppMethodBeat.i(233305);
    List localList = this.context.getPackageManager().queryIntentActivities(paramIntent, 65536);
    paramIntent = "";
    if (localList.size() > 0) {
      paramIntent = ((ResolveInfo)localList.get(0)).activityInfo.applicationInfo.packageName;
    }
    AppMethodBeat.o(233305);
    return paramIntent;
  }
  
  private static String dA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(233319);
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
      AppMethodBeat.o(233319);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(233319);
    }
    return "";
  }
  
  public final boolean a(IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(233302);
    if (paramWWAppType == IWWAPI.WWAppType.ZYb)
    {
      boolean bool = bEx("com.tencent.wework");
      AppMethodBeat.o(233302);
      return bool;
    }
    Intent localIntent;
    if (paramWWAppType == IWWAPI.WWAppType.ZYc)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentuniform://jump"));
      localIntent = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentcustomized://jump"));
      if ((bEx("com.tencent.wework")) || (bEx("com.tencent.wwgovernment")) || (bP(paramWWAppType)) || (bP(localIntent)))
      {
        AppMethodBeat.o(233302);
        return true;
      }
      AppMethodBeat.o(233302);
      return false;
    }
    if (paramWWAppType == IWWAPI.WWAppType.ZYd)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
      localIntent = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
      if ((bEx("com.tencent.wwgovernment")) || (bP(paramWWAppType)) || (bP(localIntent)))
      {
        AppMethodBeat.o(233302);
        return true;
      }
      AppMethodBeat.o(233302);
      return false;
    }
    AppMethodBeat.o(233302);
    return false;
  }
  
  public final boolean a(BaseMessage paramBaseMessage, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(233315);
    Object localObject1 = new ArrayList();
    if (paramWWAppType == IWWAPI.WWAppType.ZYb)
    {
      ((List)localObject1).add("com.tencent.wework");
      localObject1 = ((List)localObject1).iterator();
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      long l;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label904;
        }
        localObject2 = (String)((Iterator)localObject1).next();
        if (((((String)localObject2).equals("com.tencent.wework")) || (((String)localObject2).equals("com.tencent.wwgovernment"))) && (bEx((String)localObject2)))
        {
          paramWWAppType = new Intent("com.tencent.wework.apihost");
          paramWWAppType.setClassName((String)localObject2, "com.tencent.wework.apihost.WWAPIActivity");
          paramWWAppType.addFlags(411041792);
          try
          {
            paramBaseMessage.bEz((String)localObject2);
            paramBaseMessage.setContext(this.context);
            localObject3 = BaseMessage.a(paramBaseMessage);
            l = OpenDataUtils.c(this.context, this.context.getPackageName(), (String)localObject2, (Bundle)localObject3);
            if (l > 0L)
            {
              paramWWAppType.putExtra("data_id", l);
              paramWWAppType.putExtra("data_pkg", this.context.getPackageName());
            }
            for (;;)
            {
              paramWWAppType.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.ZYi.getClass()), 134217728));
              paramBaseMessage.u(paramWWAppType, (String)localObject2);
              localObject2 = this.context;
              paramWWAppType = new com.tencent.mm.hellhoundlib.b.a().bm(paramWWAppType);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramWWAppType.aFh(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)paramWWAppType.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(233315);
              return true;
              if (paramWWAppType == IWWAPI.WWAppType.ZYc)
              {
                ((List)localObject1).add("com.tencent.wework");
                ((List)localObject1).add("com.tencent.weworkenterprise");
                break;
              }
              if (paramWWAppType != IWWAPI.WWAppType.ZYd) {
                break;
              }
              ((List)localObject1).add("com.tencent.wwgovernment");
              ((List)localObject1).add("com.tencent.weworklocal");
              break;
              paramWWAppType.putExtras((Bundle)localObject3);
            }
          }
          catch (Throwable paramWWAppType) {}
        }
      }
      if (((String)localObject2).equals("com.tencent.weworkenterprise"))
      {
        paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentuniform://jump"));
        localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentcustomized://jump"));
        if (bP(paramWWAppType)) {
          if (bEx(bQ(paramWWAppType)))
          {
            paramWWAppType = "wxworkentuniform";
            label467:
            localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse(paramWWAppType + "://jump"));
            ((Intent)localObject3).addFlags(411041792);
          }
        }
      }
      try
      {
        paramBaseMessage.bEz((String)localObject2);
        paramBaseMessage.setContext(this.context);
        Object localObject4 = BaseMessage.a(paramBaseMessage);
        l = OpenDataUtils.c(this.context, this.context.getPackageName(), (String)localObject2, (Bundle)localObject4);
        if (l > 0L)
        {
          ((Intent)localObject3).putExtra("data_id", l);
          ((Intent)localObject3).putExtra("data_pkg", this.context.getPackageName());
        }
        for (;;)
        {
          ((Intent)localObject3).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.ZYi.getClass()), 134217728));
          paramBaseMessage.u((Intent)localObject3, (String)localObject2);
          localObject4 = this.context;
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
          com.tencent.mm.hellhoundlib.a.a.b(localObject4, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject4).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject4, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          new StringBuilder("sendMessage, start WWAPIActivity, pkg: ").append((String)localObject2).append(",scheme:").append(paramWWAppType);
          AppMethodBeat.o(233315);
          return true;
          AppMethodBeat.o(233315);
          return false;
          if (bEx(bQ((Intent)localObject3)))
          {
            paramWWAppType = "wxworkentcustomized";
            break label467;
          }
          AppMethodBeat.o(233315);
          return false;
          if (!((String)localObject2).equals("com.tencent.weworklocal")) {
            break;
          }
          paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
          localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
          if (bP(paramWWAppType))
          {
            if (bEx(bQ(paramWWAppType)))
            {
              paramWWAppType = "wxworkgovuniform";
              break label467;
            }
            AppMethodBeat.o(233315);
            return false;
          }
          if (bEx(bQ((Intent)localObject3)))
          {
            paramWWAppType = "wxworkgovcustomized";
            break label467;
          }
          AppMethodBeat.o(233315);
          return false;
          ((Intent)localObject3).putExtras((Bundle)localObject4);
        }
      }
      catch (Throwable paramWWAppType) {}
    }
    label904:
    AppMethodBeat.o(233315);
    return false;
  }
  
  public final String b(IWWAPI.WWAppType paramWWAppType)
  {
    if (paramWWAppType == IWWAPI.WWAppType.ZYd) {
      return "政务微信";
    }
    return "企业微信";
  }
  
  public final boolean ivm()
  {
    AppMethodBeat.i(233306);
    ArrayList localArrayList = ZYg;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = ZYh;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = bEv((String)((Iterator)localObject).next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(233306);
      return true;
      i = 0;
    }
    AppMethodBeat.o(233306);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImplLocal
 * JD-Core Version:    0.7.0.1
 */