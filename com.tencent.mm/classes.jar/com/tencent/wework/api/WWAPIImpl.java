package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import com.tencent.wework.api.util.OpenDataUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class WWAPIImpl
  implements IWWAPI
{
  private static boolean BPH;
  private static final ArrayList<String> Mol;
  private static final ArrayList<String> Mom;
  private String Mok;
  private BroadcastReceiver Mon;
  private Map<String, Object> callbacks;
  private Context context;
  private SharedPreferences mPreferences;
  
  static
  {
    AppMethodBeat.i(106537);
    Mol = new WWAPIImpl.1();
    Mom = new WWAPIImpl.2();
    BPH = false;
    AppMethodBeat.o(106537);
  }
  
  public WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(106530);
    this.callbacks = new HashMap();
    this.Mon = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(190353);
        try
        {
          boolean bool = WWAPIImpl.a(WWAPIImpl.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(190353);
            return;
          }
          paramAnonymousContext = BaseMessage.C(paramAnonymousIntent.getData());
          paramAnonymousContext.baq(WWAPIImpl.b(WWAPIImpl.this).getString("sk", ""));
          paramAnonymousContext.fromBundle(paramAnonymousIntent.getExtras());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(190352);
                try
                {
                  WWAPIImpl.c(WWAPIImpl.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImpl.c(WWAPIImpl.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(190352);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(190352);
                }
              }
            });
          }
          AppMethodBeat.o(190353);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(190353);
        }
      }
    };
    this.mPreferences = null;
    this.context = paramContext;
    this.mPreferences = paramContext.getSharedPreferences("wxwork_wwapi_store", 0);
    AppMethodBeat.o(106530);
  }
  
  private int bao(String paramString)
  {
    AppMethodBeat.i(106533);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null)
      {
        AppMethodBeat.o(106533);
        return 0;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(106533);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(106533);
    }
    return 0;
  }
  
  private String bap(String paramString)
  {
    AppMethodBeat.i(106535);
    try
    {
      paramString = cV(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      AppMethodBeat.o(106535);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(106535);
    }
    return "";
  }
  
  private static String cV(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(106536);
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
      AppMethodBeat.o(106536);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(106536);
    }
    return "";
  }
  
  private List<String> gad()
  {
    AppMethodBeat.i(190354);
    ArrayList localArrayList2 = Mol;
    ArrayList localArrayList1 = localArrayList2;
    if (this.context != null)
    {
      localArrayList1 = localArrayList2;
      if (!TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
        localArrayList1 = Mom;
      }
    }
    AppMethodBeat.o(190354);
    return localArrayList1;
  }
  
  public final boolean a(BaseMessage paramBaseMessage)
  {
    AppMethodBeat.i(106534);
    paramBaseMessage.baq(this.mPreferences.getString("sk", ""));
    Object localObject1 = Mom;
    if (((paramBaseMessage instanceof WWBaseMessage)) && (TextUtils.equals(((WWBaseMessage)paramBaseMessage).Mos, "com.tencent.mm"))) {
      localObject1 = Mol;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (this.context != null)
      {
        localObject2 = localObject1;
        if (TextUtils.equals(this.context.getPackageName(), "com.tencent.mm")) {
          localObject2 = Mol;
        }
      }
      localObject1 = ((ArrayList)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (String)((Iterator)localObject1).next();
          if (!"011A40266C8C75D181DDD8E4DDC50075".equals(bap((String)localObject3))) {
            continue;
          }
          localObject2 = new Intent("com.tencent.wework.apihost");
          ((Intent)localObject2).setClassName((String)localObject3, "com.tencent.wework.apihost.WWAPIActivity");
          ((Intent)localObject2).addFlags(411041792);
          try
          {
            paramBaseMessage.setContext(this.context);
            Bundle localBundle = BaseMessage.b(paramBaseMessage);
            long l = OpenDataUtils.b(this.context, this.context.getPackageName(), (String)localObject3, localBundle);
            if (l > 0L)
            {
              ((Intent)localObject2).putExtra("data_id", l);
              ((Intent)localObject2).putExtra("data_pkg", this.context.getPackageName());
            }
            for (;;)
            {
              ((Intent)localObject2).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Mon.getClass()), 134217728));
              paramBaseMessage.x((Intent)localObject2, (String)localObject3);
              localObject3 = this.context;
              localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/wework/api/WWAPIImpl", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/wework/api/WWAPIImpl", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(106534);
              return true;
              ((Intent)localObject2).putExtras(localBundle);
            }
          }
          catch (Throwable localThrowable) {}
        }
      }
      AppMethodBeat.o(106534);
      return false;
    }
  }
  
  public final boolean gab()
  {
    AppMethodBeat.i(106531);
    Iterator localIterator = gad().iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = bao((String)localIterator.next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(106531);
      return true;
      i = 0;
    }
    AppMethodBeat.o(106531);
    return false;
  }
  
  public final String gac()
  {
    AppMethodBeat.i(106532);
    Object localObject = gad().iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (String)((Iterator)localObject).next();
      try
      {
        PackageManager localPackageManager = this.context.getPackageManager();
        localObject = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo((String)localObject, 0)).toString();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          AppMethodBeat.o(106532);
          return "企业微信";
        }
        AppMethodBeat.o(106532);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(106532);
        return "企业微信";
      }
    }
    AppMethodBeat.o(106532);
    return "企业微信";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */