package com.tencent.wework.api;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class WWAPIImpl
  implements IWWAPI
{
  private static final ArrayList<String> BCE;
  private String BCD;
  private BroadcastReceiver BCF;
  private Map<String, Object> callbacks;
  private Context context;
  
  static
  {
    AppMethodBeat.i(140110);
    BCE = new WWAPIImpl.1();
    AppMethodBeat.o(140110);
  }
  
  public WWAPIImpl(Context paramContext)
  {
    AppMethodBeat.i(80493);
    this.callbacks = new HashMap();
    this.BCF = new WWAPIImpl.2(this);
    this.context = paramContext;
    AppMethodBeat.o(80493);
  }
  
  private int axE(String paramString)
  {
    AppMethodBeat.i(140107);
    try
    {
      paramString = this.context.getPackageManager().getPackageInfo(paramString, 128);
      if (paramString == null)
      {
        AppMethodBeat.o(140107);
        return 0;
      }
      int i = paramString.versionCode;
      AppMethodBeat.o(140107);
      return i;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(140107);
    }
    return 0;
  }
  
  private String axF(String paramString)
  {
    AppMethodBeat.i(140108);
    try
    {
      paramString = cx(this.context.getPackageManager().getPackageInfo(paramString, 64).signatures[0].toByteArray());
      AppMethodBeat.o(140108);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(140108);
    }
    return "";
  }
  
  private static String cx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(140109);
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
      AppMethodBeat.o(140109);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      AppMethodBeat.o(140109);
    }
    return "";
  }
  
  public final boolean a(BaseMessage paramBaseMessage)
  {
    AppMethodBeat.i(80496);
    Iterator localIterator = BCE.iterator();
    for (;;)
    {
      Intent localIntent;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ("011A40266C8C75D181DDD8E4DDC50075".equals(axF(str)))
        {
          localIntent = new Intent("com.tencent.wework.apihost");
          localIntent.setClassName(str, "com.tencent.wework.apihost.WWAPIActivity");
          localIntent.addFlags(411041792);
        }
      }
      else
      {
        try
        {
          paramBaseMessage.setContext(this.context);
          localIntent.putExtras(BaseMessage.b(paramBaseMessage));
          localIntent.putExtra("PendingIntent", PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, this.BCF.getClass()), 134217728));
          this.context.startActivity(localIntent);
          AppMethodBeat.o(80496);
          return true;
        }
        catch (Throwable localThrowable) {}
        AppMethodBeat.o(80496);
        return false;
      }
    }
  }
  
  public final boolean dXY()
  {
    AppMethodBeat.i(80494);
    Iterator localIterator = BCE.iterator();
    int i;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      i = axE((String)localIterator.next());
    } while (i == 0);
    while (i >= 100)
    {
      AppMethodBeat.o(80494);
      return true;
      i = 0;
    }
    AppMethodBeat.o(80494);
    return false;
  }
  
  public final String dXZ()
  {
    AppMethodBeat.i(140106);
    Object localObject = BCE.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localObject = (String)((Iterator)localObject).next();
      try
      {
        PackageManager localPackageManager = this.context.getPackageManager();
        localObject = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo((String)localObject, 0)).toString();
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          AppMethodBeat.o(140106);
          return "企业微信";
        }
        AppMethodBeat.o(140106);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(140106);
        return "企业微信";
      }
    }
    AppMethodBeat.o(140106);
    return "企业微信";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIImpl
 * JD-Core Version:    0.7.0.1
 */