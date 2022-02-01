package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWBaseRespMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class WWAPIImpl
  implements IWWAPI
{
  private static final ArrayList<String> Kyk;
  private String Kyj;
  private BroadcastReceiver Kyl;
  private Map<String, Object> callbacks;
  private Context context;
  
  static
  {
    AppMethodBeat.i(106537);
    Kyk = new ArrayList() {};
    AppMethodBeat.o(106537);
  }
  
  public WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(106530);
    this.callbacks = new HashMap();
    this.Kyl = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(106529);
        try
        {
          boolean bool = WWAPIImpl.a(WWAPIImpl.this).equals(paramAnonymousIntent.getScheme());
          if (!bool)
          {
            AppMethodBeat.o(106529);
            return;
          }
          paramAnonymousContext = BaseMessage.C(paramAnonymousIntent.getData());
          if ((paramAnonymousContext instanceof WWBaseRespMessage)) {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public void run()
              {
                AppMethodBeat.i(106528);
                try
                {
                  WWAPIImpl.b(WWAPIImpl.this).get(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  WWAPIImpl.b(WWAPIImpl.this).remove(((WWBaseRespMessage)paramAnonymousContext).transaction);
                  AppMethodBeat.o(106528);
                  return;
                }
                catch (Throwable localThrowable)
                {
                  AppMethodBeat.o(106528);
                }
              }
            });
          }
          AppMethodBeat.o(106529);
          return;
        }
        catch (Throwable paramAnonymousContext)
        {
          AppMethodBeat.o(106529);
        }
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(106530);
  }
  
  private int aUq(String paramString)
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
  
  private String aUr(String paramString)
  {
    AppMethodBeat.i(106535);
    try
    {
      paramString = cP(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      AppMethodBeat.o(106535);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(106535);
    }
    return "";
  }
  
  private static String cP(byte[] paramArrayOfByte)
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
  
  public final boolean a(BaseMessage paramBaseMessage)
  {
    AppMethodBeat.i(106534);
    Iterator localIterator = Kyk.iterator();
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (String)localIterator.next();
        if ("011A40266C8C75D181DDD8E4DDC50075".equals(aUr((String)localObject2)))
        {
          localObject1 = new Intent("com.tencent.wework.apihost");
          ((Intent)localObject1).setClassName((String)localObject2, "com.tencent.wework.apihost.WWAPIActivity");
          ((Intent)localObject1).addFlags(411041792);
        }
      }
      else
      {
        try
        {
          paramBaseMessage.setContext(this.context);
          ((Intent)localObject1).putExtras(BaseMessage.b(paramBaseMessage));
          ((Intent)localObject1).putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.Kyl.getClass()), 134217728));
          localObject2 = this.context;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/wework/api/WWAPIImpl", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/wework/api/WWAPIImpl", "sendMessage", "(Lcom/tencent/wework/api/model/BaseMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(106534);
          return true;
        }
        catch (Throwable localThrowable) {}
        AppMethodBeat.o(106534);
        return false;
      }
    }
  }
  
  public final boolean fIK()
  {
    AppMethodBeat.i(106531);
    Iterator localIterator = Kyk.iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = aUq((String)localIterator.next());
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
  
  public final String fIL()
  {
    AppMethodBeat.i(106532);
    Object localObject = Kyk.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */