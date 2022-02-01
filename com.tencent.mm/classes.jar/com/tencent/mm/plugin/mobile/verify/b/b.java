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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.HttpURLConnection;
import java.net.URL;

public final class b
  extends a
{
  private int hRl;
  private String url;
  private a.a wkh;
  private Network wki;
  private ConnectivityManager.NetworkCallback wkj;
  
  public b(String paramString1, String paramString2)
  {
    super(paramString1);
    AppMethodBeat.i(221136);
    this.hRl = 0;
    this.wkj = new ConnectivityManager.NetworkCallback()
    {
      public final void onAvailable(Network paramAnonymousNetwork)
      {
        AppMethodBeat.i(221134);
        super.onAvailable(paramAnonymousNetwork);
        ae.i("MicroMsg.GetMobileToken", "network %s is available", new Object[] { ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getNetworkInfo(paramAnonymousNetwork).getTypeName() });
        b.a(b.this, paramAnonymousNetwork);
        b.a(b.this);
        com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 7);
        AppMethodBeat.o(221134);
      }
      
      public final void onUnavailable()
      {
        AppMethodBeat.i(221135);
        super.onUnavailable();
        ae.i("MicroMsg.GetMobileToken", "network %s is unavailable", new Object[] { ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).getNetworkInfo(b.b(b.this)).getTypeName() });
        b.a(b.this, null);
        com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 6);
        AppMethodBeat.o(221135);
      }
    };
    this.url = paramString2;
    this.wkh = ((PluginMobileVerify)com.tencent.mm.kernel.g.ad(PluginMobileVerify.class)).getCallback(paramString1);
    AppMethodBeat.o(221136);
  }
  
  private void arW(String paramString)
  {
    AppMethodBeat.i(221138);
    ae.i("MicroMsg.GetMobileToken", "callback %s", new Object[] { paramString });
    if (!bu.isNullOrNil(paramString)) {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 8);
    }
    for (;;)
    {
      if (this.wkh != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("session", this.sessionId);
        localBundle.putString("token", paramString);
        this.wkh.z(localBundle);
        this.wkh = null;
      }
      AppMethodBeat.o(221138);
      return;
      com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 9);
    }
  }
  
  private void drm()
  {
    AppMethodBeat.i(221139);
    try
    {
      ae.i("MicroMsg.GetMobileToken", "use mobile network directly");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.url).openConnection();
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.connect();
      e(localHttpURLConnection);
      AppMethodBeat.o(221139);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      arW(null);
      AppMethodBeat.o(221139);
    }
  }
  
  private void drn()
  {
    AppMethodBeat.i(221140);
    try
    {
      ae.i("MicroMsg.GetMobileToken", "select mobile network");
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)this.wki.openConnection(new URL(this.url));
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(5000);
      localHttpURLConnection.connect();
      e(localHttpURLConnection);
      AppMethodBeat.o(221140);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      arW(null);
      AppMethodBeat.o(221140);
    }
  }
  
  private void dro()
  {
    AppMethodBeat.i(221141);
    com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 5);
    ae.i("MicroMsg.GetMobileToken", "request mobile network");
    Object localObject = new NetworkRequest.Builder();
    ((NetworkRequest.Builder)localObject).addCapability(12);
    ((NetworkRequest.Builder)localObject).addTransportType(0);
    localObject = ((NetworkRequest.Builder)localObject).build();
    ((ConnectivityManager)ak.getContext().getSystemService("connectivity")).requestNetwork((NetworkRequest)localObject, this.wkj);
    AppMethodBeat.o(221141);
  }
  
  private void drp()
  {
    AppMethodBeat.i(221142);
    if (az.isMobile(ak.getContext()))
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 2);
      drm();
      AppMethodBeat.o(221142);
      return;
    }
    if (this.wki == null)
    {
      dro();
      AppMethodBeat.o(221142);
      return;
    }
    drn();
    AppMethodBeat.o(221142);
  }
  
  private void e(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(221143);
    int i = paramHttpURLConnection.getResponseCode();
    ae.i("MicroMsg.GetMobileToken", "httpCode %d, message %s, redirectCount %d", new Object[] { Integer.valueOf(i), paramHttpURLConnection.getResponseMessage(), Integer.valueOf(this.hRl) });
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(221143);
      return;
      arW(f(paramHttpURLConnection));
      AppMethodBeat.o(221143);
      return;
      if (this.hRl < 2)
      {
        this.hRl += 1;
        this.url = paramHttpURLConnection.getHeaderField("location");
        ae.i("MicroMsg.GetMobileToken", "redirect to url: %s", new Object[] { this.url });
        drp();
        AppMethodBeat.o(221143);
        return;
      }
      ae.i("MicroMsg.GetMobileToken", "redirect exceed %d times", new Object[] { Integer.valueOf(2) });
      arW("");
    }
  }
  
  /* Error */
  private static String f(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: ldc 250
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 254	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   9: astore_3
    //   10: sipush 1024
    //   13: newarray byte
    //   15: astore_0
    //   16: new 256	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 257	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore_2
    //   24: aload_3
    //   25: aload_0
    //   26: invokevirtual 263	java/io/InputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: ifle +70 -> 101
    //   34: aload_2
    //   35: aload_0
    //   36: iconst_0
    //   37: iload_1
    //   38: invokevirtual 267	java/io/ByteArrayOutputStream:write	([BII)V
    //   41: aload_2
    //   42: invokevirtual 270	java/io/ByteArrayOutputStream:flush	()V
    //   45: goto -21 -> 24
    //   48: astore_0
    //   49: aload_3
    //   50: ifnull +7 -> 57
    //   53: aload_3
    //   54: invokevirtual 273	java/io/InputStream:close	()V
    //   57: aload_2
    //   58: ifnull +7 -> 65
    //   61: aload_2
    //   62: invokevirtual 274	java/io/ByteArrayOutputStream:close	()V
    //   65: ldc 250
    //   67: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: athrow
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_0
    //   75: ldc 68
    //   77: ldc_w 276
    //   80: iconst_1
    //   81: anewarray 72	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_2
    //   87: invokevirtual 277	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 153	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: ldc 250
    //   96: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: areturn
    //   101: new 279	java/lang/String
    //   104: dup
    //   105: aload_2
    //   106: invokevirtual 283	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   109: invokespecial 286	java/lang/String:<init>	([B)V
    //   112: astore_0
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 273	java/io/InputStream:close	()V
    //   121: aload_2
    //   122: invokevirtual 274	java/io/ByteArrayOutputStream:close	()V
    //   125: goto -31 -> 94
    //   128: astore_2
    //   129: goto -54 -> 75
    //   132: astore_0
    //   133: aconst_null
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_3
    //   137: goto -88 -> 49
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_2
    //   143: goto -94 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramHttpURLConnection	HttpURLConnection
    //   29	9	1	i	int
    //   23	39	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   72	50	2	localIOException1	java.io.IOException
    //   128	1	2	localIOException2	java.io.IOException
    //   134	9	2	localObject	Object
    //   9	128	3	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	48	finally
    //   34	45	48	finally
    //   101	113	48	finally
    //   53	57	72	java/io/IOException
    //   61	65	72	java/io/IOException
    //   65	72	72	java/io/IOException
    //   117	121	128	java/io/IOException
    //   121	125	128	java/io/IOException
    //   5	10	132	finally
    //   10	24	140	finally
  }
  
  public final void run()
  {
    AppMethodBeat.i(221137);
    try
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 0);
      if ((!bu.isNullOrNil(q.getSimCountryIso())) && (az.iZ(ak.getContext())))
      {
        drp();
        AppMethodBeat.o(221137);
        return;
      }
      if (bu.isNullOrNil(q.getSimCountryIso())) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 1);
      }
      for (;;)
      {
        ae.w("MicroMsg.GetMobileToken", "get mobile token failed, mobile network is not open");
        arW(null);
        AppMethodBeat.o(221137);
        return;
        if (!az.iZ(ak.getContext())) {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1360, 3);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.GetMobileToken", "http exception:%s", new Object[] { localException.getMessage() });
      arW(null);
      AppMethodBeat.o(221137);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mobile.verify.b.b
 * JD-Core Version:    0.7.0.1
 */