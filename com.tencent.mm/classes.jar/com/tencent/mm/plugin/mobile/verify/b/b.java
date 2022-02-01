package com.tencent.mm.plugin.mobile.verify.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.NetworkRequest.Builder;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.mobile.verify.PluginMobileVerify;
import com.tencent.mm.plugin.mobile.verify.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b
  extends a
{
  private a.a Lfd;
  private Network Lfe;
  private ConnectivityManager.NetworkCallback networkCallback;
  private int ouk;
  private String url;
  
  public b(String paramString1, String paramString2)
  {
    super(paramString1);
    AppMethodBeat.i(260323);
    this.ouk = 0;
    this.networkCallback = new ConnectivityManager.NetworkCallback()
    {
      public final void onAvailable(Network paramAnonymousNetwork)
      {
        AppMethodBeat.i(260325);
        super.onAvailable(paramAnonymousNetwork);
        Log.i("MicroMsg.GetMobileToken", "network %s is available", new Object[] { ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(paramAnonymousNetwork).getTypeName() });
        b.a(b.this, paramAnonymousNetwork);
        b.a(b.this);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 7);
        AppMethodBeat.o(260325);
      }
      
      public final void onUnavailable()
      {
        AppMethodBeat.i(260327);
        super.onUnavailable();
        Log.i("MicroMsg.GetMobileToken", "network %s is unavailable", new Object[] { ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).getNetworkInfo(b.b(b.this)).getTypeName() });
        b.a(b.this, null);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 6);
        AppMethodBeat.o(260327);
      }
    };
    this.url = paramString2;
    this.Lfd = ((PluginMobileVerify)com.tencent.mm.kernel.h.az(PluginMobileVerify.class)).getCallback(paramString1);
    AppMethodBeat.o(260323);
  }
  
  private void aMy(String paramString)
  {
    AppMethodBeat.i(260326);
    Log.i("MicroMsg.GetMobileToken", "callback %s", new Object[] { paramString });
    if (!Util.isNullOrNil(paramString)) {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 8);
    }
    for (;;)
    {
      if (this.Lfd != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("session", this.sessionId);
        localBundle.putString("token", paramString);
        this.Lfd.U(localBundle);
        this.Lfd = null;
      }
      AppMethodBeat.o(260326);
      return;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 9);
    }
  }
  
  private void e(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(260339);
    int i = paramHttpURLConnection.getResponseCode();
    Log.i("MicroMsg.GetMobileToken", "httpCode %d, message %s, redirectCount %d", new Object[] { Integer.valueOf(i), paramHttpURLConnection.getResponseMessage(), Integer.valueOf(this.ouk) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(260339);
      return;
      aMy(f(paramHttpURLConnection));
      AppMethodBeat.o(260339);
      return;
      if (this.ouk < 2)
      {
        this.ouk += 1;
        this.url = paramHttpURLConnection.getHeaderField("location");
        Log.i("MicroMsg.GetMobileToken", "redirect to url: %s", new Object[] { this.url });
        gdE();
        AppMethodBeat.o(260339);
        return;
      }
      Log.i("MicroMsg.GetMobileToken", "redirect exceed %d times", new Object[] { Integer.valueOf(2) });
      aMy("");
    }
  }
  
  /* Error */
  private static String f(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc 160
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 164	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   9: astore_3
    //   10: sipush 1024
    //   13: newarray byte
    //   15: astore_0
    //   16: new 166	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 167	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: aload_0
    //   26: invokevirtual 173	java/io/InputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: ifle +69 -> 100
    //   34: aload_2
    //   35: aload_0
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 177	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: aload_2
    //   42: invokevirtual 180	java/io/ByteArrayOutputStream:flush	()V
    //   45: goto -21 -> 24
    //   48: astore_0
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 183	java/io/InputStream:close	()V
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 184	java/io/ByteArrayOutputStream:close	()V
    //   65: ldc 160
    //   67: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: athrow
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: ldc 68
    //   77: ldc 186
    //   79: iconst_1
    //   80: anewarray 72	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_2
    //   86: invokevirtual 189	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: ldc 160
    //   95: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: aload_0
    //   99: areturn
    //   100: new 193	java/lang/String
    //   103: dup
    //   104: aload_2
    //   105: invokevirtual 197	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   108: invokespecial 200	java/lang/String:<init>	([B)V
    //   111: astore_0
    //   112: aload_3
    //   113: ifnull +7 -> 120
    //   116: aload_3
    //   117: invokevirtual 183	java/io/InputStream:close	()V
    //   120: aload_2
    //   121: invokevirtual 184	java/io/ByteArrayOutputStream:close	()V
    //   124: goto -31 -> 93
    //   127: astore_2
    //   128: goto -53 -> 75
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_3
    //   136: goto -87 -> 49
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_2
    //   142: goto -93 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramHttpURLConnection	HttpURLConnection
    //   29	9	1	i	int
    //   23	39	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   72	49	2	localIOException1	java.io.IOException
    //   127	1	2	localIOException2	java.io.IOException
    //   133	9	2	localObject	Object
    //   9	127	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	48	finally
    //   34	45	48	finally
    //   100	112	48	finally
    //   53	57	72	java/io/IOException
    //   61	65	72	java/io/IOException
    //   65	72	72	java/io/IOException
    //   116	120	127	java/io/IOException
    //   120	124	127	java/io/IOException
    //   5	10	131	finally
    //   10	24	139	finally
  }
  
  private void gdB()
  {
    AppMethodBeat.i(260329);
    try
    {
      Log.i("MicroMsg.GetMobileToken", "use mobile network directly");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.url).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.connect();
      e(localHttpURLConnection);
      AppMethodBeat.o(260329);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      aMy(null);
      AppMethodBeat.o(260329);
    }
  }
  
  private void gdC()
  {
    AppMethodBeat.i(260331);
    try
    {
      Log.i("MicroMsg.GetMobileToken", "select mobile network");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)this.Lfe.openConnection(new URL(this.url));
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.connect();
      e(localHttpURLConnection);
      AppMethodBeat.o(260331);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      aMy(null);
      AppMethodBeat.o(260331);
    }
  }
  
  private void gdD()
  {
    AppMethodBeat.i(260334);
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 5);
    Log.i("MicroMsg.GetMobileToken", "request mobile network");
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    ((ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity")).requestNetwork((NetworkRequest)localObject, this.networkCallback);
    AppMethodBeat.o(260334);
  }
  
  private void gdE()
  {
    AppMethodBeat.i(260336);
    if (NetStatusUtil.isMobile(MMApplicationContext.getContext()))
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 2);
      gdB();
      AppMethodBeat.o(260336);
      return;
    }
    if (this.Lfe == null)
    {
      gdD();
      AppMethodBeat.o(260336);
      return;
    }
    gdC();
    AppMethodBeat.o(260336);
  }
  
  public final void run()
  {
    AppMethodBeat.i(260348);
    try
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 0);
      if ((!Util.isNullOrNil(q.aPc())) && (NetStatusUtil.isMobileNetworkOpen(MMApplicationContext.getContext())))
      {
        gdE();
        AppMethodBeat.o(260348);
        return;
      }
      if (Util.isNullOrNil(q.aPc())) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 1);
      }
      for (;;)
      {
        Log.w("MicroMsg.GetMobileToken", "get mobile token failed, mobile network is not open");
        aMy(null);
        AppMethodBeat.o(260348);
        return;
        if (!NetStatusUtil.isMobileNetworkOpen(MMApplicationContext.getContext())) {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(1360, 3);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      aMy(null);
      AppMethodBeat.o(260348);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.b.b
 * JD-Core Version:    0.7.0.1
 */