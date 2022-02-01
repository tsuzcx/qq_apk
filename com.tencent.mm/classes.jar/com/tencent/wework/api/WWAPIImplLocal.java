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
  private static final ArrayList<String> Sxg;
  private static final ArrayList<String> Sxh;
  private static final ArrayList<String> Sxm;
  private String Sxf;
  private BroadcastReceiver Sxi;
  private Map<String, Object> callbacks;
  private Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(199000);
    Sxg = new WWAPIImplLocal.1();
    Sxh = new WWAPIImplLocal.2();
    Sxm = new WWAPIImplLocal.3();
    AppMethodBeat.o(199000);
  }
  
  WWAPIImplLocal(Context paramContext)
  {
    AppMethodBeat.i(198990);
    this.callbacks = new HashMap();
    this.Sxi = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(198989);
        try
        {
          boolean bool = WWAPIImplLocal.a(WWAPIImplLocal.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(198989);
            return;
          }
          paramAnonymousContext = BaseMessage.A(paramAnonymousIntent.getData());
          paramAnonymousContext.brz(WWAPIImplLocal.b(WWAPIImplLocal.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(198988);
                try
                {
                  WWAPIImplLocal.c(WWAPIImplLocal.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImplLocal.c(WWAPIImplLocal.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(198988);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(198988);
                }
              }
            });
          }
          AppMethodBeat.o(198989);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(198989);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(198990);
  }
  
  private boolean bL(Intent paramIntent)
  {
    AppMethodBeat.i(198992);
    if (this.context.getPackageManager().queryIntentActivities(paramIntent, 65536).size() > 0)
    {
      AppMethodBeat.o(198992);
      return true;
    }
    AppMethodBeat.o(198992);
    return false;
  }
  
  private String bM(Intent paramIntent)
  {
    AppMethodBeat.i(198993);
    List localList = this.context.getPackageManager().queryIntentActivities(paramIntent, 65536);
    paramIntent = "";
    if (localList.size() > 0) {
      paramIntent = ((ResolveInfo)localList.get(0)).activityInfo.applicationInfo.packageName;
    }
    AppMethodBeat.o(198993);
    return paramIntent;
  }
  
  private int brw(String paramString)
  {
    AppMethodBeat.i(198995);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null)
      {
        AppMethodBeat.o(198995);
        return 0;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(198995);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(198995);
    }
    return 0;
  }
  
  private String brx(String paramString)
  {
    AppMethodBeat.i(198997);
    try
    {
      paramString = dd(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      AppMethodBeat.o(198997);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(198997);
    }
    return "";
  }
  
  private boolean bry(String paramString)
  {
    AppMethodBeat.i(198999);
    paramString = brx(paramString);
    boolean bool = Sxm.contains(paramString);
    AppMethodBeat.o(198999);
    return bool;
  }
  
  private static String dd(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(198998);
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
      AppMethodBeat.o(198998);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(198998);
    }
    return "";
  }
  
  public final boolean a(IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(198991);
    if (paramWWAppType == IWWAPI.WWAppType.Sxb)
    {
      boolean bool = bry("com.tencent.wework");
      AppMethodBeat.o(198991);
      return bool;
    }
    Intent localIntent;
    if (paramWWAppType == IWWAPI.WWAppType.Sxc)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentuniform://jump"));
      localIntent = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkentcustomized://jump"));
      if ((bry("com.tencent.wework")) || (bry("com.tencent.wwgovernment")) || (bL(paramWWAppType)) || (bL(localIntent)))
      {
        AppMethodBeat.o(198991);
        return true;
      }
      AppMethodBeat.o(198991);
      return false;
    }
    if (paramWWAppType == IWWAPI.WWAppType.Sxd)
    {
      paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
      localIntent = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
      if ((bry("com.tencent.wwgovernment")) || (bL(paramWWAppType)) || (bL(localIntent)))
      {
        AppMethodBeat.o(198991);
        return true;
      }
      AppMethodBeat.o(198991);
      return false;
    }
    AppMethodBeat.o(198991);
    return false;
  }
  
  public final boolean a(BaseMessage paramBaseMessage, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(198996);
    Object localObject1 = new ArrayList();
    if (paramWWAppType == IWWAPI.WWAppType.Sxb)
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
        if (((((String)localObject2).equals("com.tencent.wework")) || (((String)localObject2).equals("com.tencent.wwgovernment"))) && (bry((String)localObject2)))
        {
          paramWWAppType = new Intent("com.tencent.wework.apihost");
          paramWWAppType.setClassName((String)localObject2, "com.tencent.wework.apihost.WWAPIActivity");
          paramWWAppType.addFlags(411041792);
          try
          {
            paramBaseMessage.brA((String)localObject2);
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
              paramWWAppType.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Sxi.getClass()), 134217728));
              paramBaseMessage.v(paramWWAppType, (String)localObject2);
              localObject2 = this.context;
              paramWWAppType = new com.tencent.mm.hellhoundlib.b.a().bl(paramWWAppType);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramWWAppType.axQ(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)paramWWAppType.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(198996);
              return true;
              if (paramWWAppType == IWWAPI.WWAppType.Sxc)
              {
                ((List)localObject1).add("com.tencent.wework");
                ((List)localObject1).add("com.tencent.weworkenterprise");
                break;
              }
              if (paramWWAppType != IWWAPI.WWAppType.Sxd) {
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
        if (bL(paramWWAppType)) {
          if (bry(bM(paramWWAppType)))
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
        paramBaseMessage.brA((String)localObject2);
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
          ((Intent)localObject3).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Sxi.getClass()), 134217728));
          paramBaseMessage.v((Intent)localObject3, (String)localObject2);
          localObject4 = this.context;
          localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
          com.tencent.mm.hellhoundlib.a.a.a(localObject4, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject4).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject4, "com/tencent/wework/api/WWAPIImplLocal", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;Lcom/tencent/wework/api/IWWAPI$WWAppType;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          new StringBuilder("sendMessage, start WWAPIActivity, pkg: ").append((String)localObject2).append(",scheme:").append(paramWWAppType);
          AppMethodBeat.o(198996);
          return true;
          AppMethodBeat.o(198996);
          return false;
          if (bry(bM((Intent)localObject3)))
          {
            paramWWAppType = "wxworkentcustomized";
            break label467;
          }
          AppMethodBeat.o(198996);
          return false;
          if (!((String)localObject2).equals("com.tencent.weworklocal")) {
            break;
          }
          paramWWAppType = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovuniform://jump"));
          localObject3 = new Intent("com.tencent.wework.api.sharemsg", Uri.parse("wxworkgovcustomized://jump"));
          if (bL(paramWWAppType))
          {
            if (bry(bM(paramWWAppType)))
            {
              paramWWAppType = "wxworkgovuniform";
              break label467;
            }
            AppMethodBeat.o(198996);
            return false;
          }
          if (bry(bM((Intent)localObject3)))
          {
            paramWWAppType = "wxworkgovcustomized";
            break label467;
          }
          AppMethodBeat.o(198996);
          return false;
          ((Intent)localObject3).putExtras((Bundle)localObject4);
        }
      }
      catch (Throwable paramWWAppType) {}
    }
    label904:
    AppMethodBeat.o(198996);
    return false;
  }
  
  public final String b(IWWAPI.WWAppType paramWWAppType)
  {
    if (paramWWAppType == IWWAPI.WWAppType.Sxd) {
      return "政务微信";
    }
    return "企业微信";
  }
  
  public final boolean hrE()
  {
    AppMethodBeat.i(198994);
    ArrayList localArrayList = Sxg;
    Object localObject = localArrayList;
    if (this.context != null)
    {
      localObject = localArrayList;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localObject = Sxh;
      }
    }
    localObject = ((List)localObject).iterator();
    int i;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      i = brw((String)((Iterator)localObject).next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(198994);
      return true;
      i = 0;
    }
    AppMethodBeat.o(198994);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImplLocal
 * JD-Core Version:    0.7.0.1
 */