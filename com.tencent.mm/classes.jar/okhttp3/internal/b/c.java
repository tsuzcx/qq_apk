package okhttp3.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import j.aa;
import j.f;
import j.h;
import j.q;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.c.e;
import okhttp3.internal.e.g.a;
import okhttp3.internal.e.g.c;
import okhttp3.internal.i.d;
import okhttp3.q.a;
import okhttp3.r;
import okhttp3.v;
import okhttp3.x;
import okhttp3.x.a;
import okhttp3.z;
import okhttp3.z.a;

public final class c
  extends g.c
{
  private v ajJs;
  public okhttp3.p ajJu;
  private final okhttp3.i ajNn;
  public final okhttp3.ab ajPk;
  public Socket ajPl;
  okhttp3.internal.e.g ajPm;
  j.g ajPn;
  public boolean ajPo;
  public int ajPp;
  public final List<Reference<g>> ajPq;
  public long ajPr;
  public Socket cBb;
  h cnO;
  public int successCount;
  
  public c(okhttp3.i parami, okhttp3.ab paramab)
  {
    AppMethodBeat.i(186843);
    this.ajPp = 1;
    this.ajPq = new ArrayList();
    this.ajPr = 9223372036854775807L;
    this.ajNn = parami;
    this.ajPk = paramab;
    AppMethodBeat.o(186843);
  }
  
  private void aMV(int paramInt)
  {
    AppMethodBeat.i(186891);
    this.cBb.setSoTimeout(0);
    g.a locala = new g.a().a(this.cBb, this.ajPk.ajNZ.ajIN.host, this.cnO, this.ajPn);
    locala.ajQS = this;
    locala.ajRu = paramInt;
    this.ajPm = locala.kHR();
    this.ajPm.kHP();
    AppMethodBeat.o(186891);
  }
  
  private void bS(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(186874);
    Object localObject1 = new x.a().b(this.ajPk.ajNZ.ajIN).a("CONNECT", null).rE("Host", okhttp3.internal.c.a(this.ajPk.ajNZ.ajIN, true)).rE("Proxy-Connection", "Keep-Alive").rE("User-Agent", "okhttp/3.12.13").kHh();
    Object localObject2 = new z.a();
    ((z.a)localObject2).ajNQ = ((x)localObject1);
    ((z.a)localObject2).ajJs = v.ajNv;
    ((z.a)localObject2).code = 407;
    ((z.a)localObject2).message = "Preemptive Authenticate";
    ((z.a)localObject2).ajNR = okhttp3.internal.c.ajOi;
    ((z.a)localObject2).ajNV = -1L;
    ((z.a)localObject2).ajNW = -1L;
    ((z.a)localObject2).cpH.rD("Proxy-Authenticate", "OkHttp-Preemptive");
    ((z.a)localObject2).kHj();
    localObject2 = this.ajPk.ajNZ.ajIQ.kGw();
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    int i;
    label228:
    Object localObject3;
    for (;;)
    {
      r localr = ((x)localObject1).ajIN;
      i = 0;
      if (i >= 21) {
        break;
      }
      qF(paramInt1, paramInt2);
      String str = "CONNECT " + okhttp3.internal.c.a(localr, true) + " HTTP/1.1";
      localObject2 = new okhttp3.internal.d.a(null, null, this.cnO, this.ajPn);
      this.cnO.kHm().b(paramInt2, TimeUnit.MILLISECONDS);
      this.ajPn.kHm().b(paramInt3, TimeUnit.MILLISECONDS);
      ((okhttp3.internal.d.a)localObject2).a(((x)localObject1).cnu, str);
      ((okhttp3.internal.d.a)localObject2).kHE();
      localObject3 = ((okhttp3.internal.d.a)localObject2).PT(false);
      ((z.a)localObject3).ajNQ = ((x)localObject1);
      localObject3 = ((z.a)localObject3).kHj();
      long l2 = e.f((z)localObject3);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      localObject1 = ((okhttp3.internal.d.a)localObject2).BY(l1);
      okhttp3.internal.c.a((aa)localObject1, 2147483647, TimeUnit.MILLISECONDS);
      ((aa)localObject1).close();
      switch (((z)localObject3).code)
      {
      default: 
        localObject1 = new IOException("Unexpected response code for CONNECT: " + ((z)localObject3).code);
        AppMethodBeat.o(186874);
        throw ((Throwable)localObject1);
      }
    }
    if ((!this.cnO.kIv().kIy()) || (!this.ajPn.kIv().kIy()))
    {
      localObject1 = new IOException("TLS tunnel buffered too many bytes!");
      AppMethodBeat.o(186874);
      throw ((Throwable)localObject1);
    }
    for (localObject1 = null;; localObject1 = localObject2)
    {
      if (localObject1 == null) {
        break label604;
      }
      okhttp3.internal.c.closeQuietly(this.ajPl);
      this.ajPl = null;
      this.ajPn = null;
      this.cnO = null;
      i += 1;
      break;
      localObject2 = this.ajPk.ajNZ.ajIQ.kGw();
      if (localObject2 == null)
      {
        localObject1 = new IOException("Failed to authenticate with proxy");
        AppMethodBeat.o(186874);
        throw ((Throwable)localObject1);
      }
      localObject1 = localObject2;
      if (!"close".equalsIgnoreCase(((z)localObject3).bKv("Connection"))) {
        break label228;
      }
    }
    label604:
    AppMethodBeat.o(186874);
  }
  
  private void qF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186885);
    Object localObject1 = this.ajPk.uuH;
    Object localObject2 = this.ajPk.ajNZ;
    if ((((Proxy)localObject1).type() == Proxy.Type.DIRECT) || (((Proxy)localObject1).type() == Proxy.Type.HTTP)) {}
    for (localObject1 = ((okhttp3.a)localObject2).ajIP.createSocket();; localObject1 = new Socket((Proxy)localObject1))
    {
      this.ajPl = ((Socket)localObject1);
      this.ajPl.setSoTimeout(paramInt2);
      try
      {
        okhttp3.internal.g.g.kIq().a(this.ajPl, this.ajPk.ajOa, paramInt1);
      }
      catch (ConnectException localConnectException)
      {
        localObject2 = new ConnectException("Failed to connect to " + this.ajPk.ajOa);
        ((ConnectException)localObject2).initCause(localConnectException);
        AppMethodBeat.o(186885);
        throw ((Throwable)localObject2);
      }
      try
      {
        this.cnO = q.b(j.p.f(this.ajPl));
        this.ajPn = q.b(j.p.e(this.ajPl));
        AppMethodBeat.o(186885);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (!"throw with null exception".equals(localNullPointerException.getMessage())) {
          break label210;
        }
        IOException localIOException = new IOException(localNullPointerException);
        AppMethodBeat.o(186885);
        throw localIOException;
        AppMethodBeat.o(186885);
      }
    }
    label210:
  }
  
  public final boolean PS(boolean paramBoolean)
  {
    AppMethodBeat.i(186980);
    if ((this.cBb.isClosed()) || (this.cBb.isInputShutdown()) || (this.cBb.isOutputShutdown()))
    {
      AppMethodBeat.o(186980);
      return false;
    }
    if (this.ajPm != null)
    {
      paramBoolean = this.ajPm.Ca(System.nanoTime());
      AppMethodBeat.o(186980);
      return paramBoolean;
    }
    if (paramBoolean) {}
    try
    {
      int i = this.cBb.getSoTimeout();
      try
      {
        this.cBb.setSoTimeout(1);
        paramBoolean = this.cnO.kIy();
        return !paramBoolean;
      }
      finally
      {
        this.cBb.setSoTimeout(i);
        AppMethodBeat.o(186980);
      }
      return false;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      AppMethodBeat.o(186980);
      return true;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(186980);
    }
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, okhttp3.e arg6, okhttp3.o paramo)
  {
    // Byte code:
    //   0: ldc_w 469
    //   3: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   10: ifnull +24 -> 34
    //   13: new 472	java/lang/IllegalStateException
    //   16: dup
    //   17: ldc_w 474
    //   20: invokespecial 475	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   23: astore 6
    //   25: ldc_w 469
    //   28: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload 6
    //   33: athrow
    //   34: aload_0
    //   35: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   38: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   41: getfield 478	okhttp3/a:ajIS	Ljava/util/List;
    //   44: astore 6
    //   46: new 480	okhttp3/internal/b/b
    //   49: dup
    //   50: aload 6
    //   52: invokespecial 483	okhttp3/internal/b/b:<init>	(Ljava/util/List;)V
    //   55: astore 12
    //   57: aload_0
    //   58: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   61: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   64: getfield 487	okhttp3/a:ajIU	Ljavax/net/ssl/SSLSocketFactory;
    //   67: ifnonnull +195 -> 262
    //   70: aload 6
    //   72: getstatic 493	okhttp3/j:ajMr	Lokhttp3/j;
    //   75: invokeinterface 498 2 0
    //   80: ifne +31 -> 111
    //   83: new 500	okhttp3/internal/b/e
    //   86: dup
    //   87: new 502	java/net/UnknownServiceException
    //   90: dup
    //   91: ldc_w 504
    //   94: invokespecial 505	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   97: invokespecial 508	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   100: astore 6
    //   102: ldc_w 469
    //   105: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload 6
    //   110: athrow
    //   111: aload_0
    //   112: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   115: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   118: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   121: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   124: astore 6
    //   126: invokestatic 387	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   129: aload 6
    //   131: invokevirtual 511	okhttp3/internal/g/g:bKL	(Ljava/lang/String;)Z
    //   134: ifne +52 -> 186
    //   137: new 500	okhttp3/internal/b/e
    //   140: dup
    //   141: new 502	java/net/UnknownServiceException
    //   144: dup
    //   145: new 229	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 513
    //   152: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload 6
    //   157: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 515
    //   163: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 505	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   172: invokespecial 508	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   175: astore 6
    //   177: ldc_w 469
    //   180: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload 6
    //   185: athrow
    //   186: aconst_null
    //   187: astore 6
    //   189: aload_0
    //   190: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   193: invokevirtual 518	okhttp3/ab:kHk	()Z
    //   196: ifeq +115 -> 311
    //   199: aload_0
    //   200: iload_1
    //   201: iload_2
    //   202: iload_3
    //   203: invokespecial 520	okhttp3/internal/b/c:bS	(III)V
    //   206: aload_0
    //   207: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   210: astore 7
    //   212: aload 7
    //   214: ifnonnull +103 -> 317
    //   217: aload_0
    //   218: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   221: invokevirtual 518	okhttp3/ab:kHk	()Z
    //   224: ifeq +903 -> 1127
    //   227: aload_0
    //   228: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   231: ifnonnull +896 -> 1127
    //   234: new 500	okhttp3/internal/b/e
    //   237: dup
    //   238: new 522	java/net/ProtocolException
    //   241: dup
    //   242: ldc_w 524
    //   245: invokespecial 525	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   248: invokespecial 508	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   251: astore 6
    //   253: ldc_w 469
    //   256: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload 6
    //   261: athrow
    //   262: aload_0
    //   263: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   266: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   269: getfield 528	okhttp3/a:ajIR	Ljava/util/List;
    //   272: getstatic 531	okhttp3/v:ajNy	Lokhttp3/v;
    //   275: invokeinterface 498 2 0
    //   280: ifeq +914 -> 1194
    //   283: new 500	okhttp3/internal/b/e
    //   286: dup
    //   287: new 502	java/net/UnknownServiceException
    //   290: dup
    //   291: ldc_w 533
    //   294: invokespecial 505	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   297: invokespecial 508	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   300: astore 6
    //   302: ldc_w 469
    //   305: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aload 6
    //   310: athrow
    //   311: aload_0
    //   312: iload_1
    //   313: iload_2
    //   314: invokespecial 227	okhttp3/internal/b/c:qF	(II)V
    //   317: aload_0
    //   318: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   321: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   324: getfield 487	okhttp3/a:ajIU	Ljavax/net/ssl/SSLSocketFactory;
    //   327: ifnonnull +236 -> 563
    //   330: aload_0
    //   331: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   334: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   337: getfield 528	okhttp3/a:ajIR	Ljava/util/List;
    //   340: getstatic 531	okhttp3/v:ajNy	Lokhttp3/v;
    //   343: invokeinterface 498 2 0
    //   348: ifeq +197 -> 545
    //   351: aload_0
    //   352: aload_0
    //   353: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   356: putfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   359: aload_0
    //   360: getstatic 531	okhttp3/v:ajNy	Lokhttp3/v;
    //   363: putfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   366: aload_0
    //   367: iload 4
    //   369: invokespecial 535	okhttp3/internal/b/c:aMV	(I)V
    //   372: goto -155 -> 217
    //   375: astore 7
    //   377: aload_0
    //   378: getfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   381: invokestatic 332	okhttp3/internal/c:closeQuietly	(Ljava/net/Socket;)V
    //   384: aload_0
    //   385: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   388: invokestatic 332	okhttp3/internal/c:closeQuietly	(Ljava/net/Socket;)V
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield 94	okhttp3/internal/b/c:cnO	Lj/h;
    //   406: aload_0
    //   407: aconst_null
    //   408: putfield 96	okhttp3/internal/b/c:ajPn	Lj/g;
    //   411: aload_0
    //   412: aconst_null
    //   413: putfield 537	okhttp3/internal/b/c:ajJu	Lokhttp3/p;
    //   416: aload_0
    //   417: aconst_null
    //   418: putfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   421: aload_0
    //   422: aconst_null
    //   423: putfield 113	okhttp3/internal/b/c:ajPm	Lokhttp3/internal/e/g;
    //   426: aload 6
    //   428: ifnonnull +670 -> 1098
    //   431: new 500	okhttp3/internal/b/e
    //   434: dup
    //   435: aload 7
    //   437: invokespecial 508	okhttp3/internal/b/e:<init>	(Ljava/io/IOException;)V
    //   440: astore 6
    //   442: iload 5
    //   444: ifeq +92 -> 536
    //   447: aload 12
    //   449: iconst_1
    //   450: putfield 540	okhttp3/internal/b/b:ajnd	Z
    //   453: aload 12
    //   455: getfield 543	okhttp3/internal/b/b:ajPj	Z
    //   458: ifeq +660 -> 1118
    //   461: aload 7
    //   463: instanceof 522
    //   466: ifne +652 -> 1118
    //   469: aload 7
    //   471: instanceof 545
    //   474: ifne +644 -> 1118
    //   477: aload 7
    //   479: instanceof 547
    //   482: ifeq +14 -> 496
    //   485: aload 7
    //   487: invokevirtual 551	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   490: instanceof 553
    //   493: ifne +625 -> 1118
    //   496: aload 7
    //   498: instanceof 555
    //   501: ifne +617 -> 1118
    //   504: aload 7
    //   506: instanceof 547
    //   509: ifne +19 -> 528
    //   512: aload 7
    //   514: instanceof 557
    //   517: ifne +11 -> 528
    //   520: aload 7
    //   522: instanceof 559
    //   525: ifeq +593 -> 1118
    //   528: iconst_1
    //   529: istore 8
    //   531: iload 8
    //   533: ifne +591 -> 1124
    //   536: ldc_w 469
    //   539: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   542: aload 6
    //   544: athrow
    //   545: aload_0
    //   546: aload_0
    //   547: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   550: putfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   553: aload_0
    //   554: getstatic 168	okhttp3/v:ajNv	Lokhttp3/v;
    //   557: putfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   560: goto -343 -> 217
    //   563: aload_0
    //   564: getfield 58	okhttp3/internal/b/c:ajPk	Lokhttp3/ab;
    //   567: getfield 80	okhttp3/ab:ajNZ	Lokhttp3/a;
    //   570: astore 10
    //   572: aload 10
    //   574: getfield 487	okhttp3/a:ajIU	Ljavax/net/ssl/SSLSocketFactory;
    //   577: astore 9
    //   579: aconst_null
    //   580: astore 7
    //   582: aconst_null
    //   583: astore 11
    //   585: aload 9
    //   587: aload_0
    //   588: getfield 328	okhttp3/internal/b/c:ajPl	Ljava/net/Socket;
    //   591: aload 10
    //   593: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   596: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   599: aload 10
    //   601: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   604: getfield 562	okhttp3/r:port	I
    //   607: iconst_1
    //   608: invokevirtual 567	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   611: checkcast 569	javax/net/ssl/SSLSocket
    //   614: astore 9
    //   616: aload 12
    //   618: aload 9
    //   620: invokevirtual 572	okhttp3/internal/b/b:b	(Ljavax/net/ssl/SSLSocket;)Lokhttp3/j;
    //   623: astore 7
    //   625: aload 7
    //   627: getfield 575	okhttp3/j:ajMt	Z
    //   630: ifeq +24 -> 654
    //   633: invokestatic 387	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   636: aload 9
    //   638: aload 10
    //   640: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   643: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   646: aload 10
    //   648: getfield 528	okhttp3/a:ajIR	Ljava/util/List;
    //   651: invokevirtual 578	okhttp3/internal/g/g:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   654: aload 9
    //   656: invokevirtual 581	javax/net/ssl/SSLSocket:startHandshake	()V
    //   659: aload 9
    //   661: invokevirtual 585	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   664: astore 13
    //   666: aload 13
    //   668: invokestatic 590	okhttp3/p:a	(Ljavax/net/ssl/SSLSession;)Lokhttp3/p;
    //   671: astore 11
    //   673: aload 10
    //   675: getfield 594	okhttp3/a:ajIV	Ljavax/net/ssl/HostnameVerifier;
    //   678: aload 10
    //   680: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   683: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   686: aload 13
    //   688: invokeinterface 600 3 0
    //   693: ifne +245 -> 938
    //   696: aload 11
    //   698: getfield 603	okhttp3/p:ajMQ	Ljava/util/List;
    //   701: astore 7
    //   703: aload 7
    //   705: invokeinterface 606 1 0
    //   710: ifne +180 -> 890
    //   713: aload 7
    //   715: iconst_0
    //   716: invokeinterface 610 2 0
    //   721: checkcast 612	java/security/cert/X509Certificate
    //   724: astore 7
    //   726: new 555	javax/net/ssl/SSLPeerUnverifiedException
    //   729: dup
    //   730: new 229	java/lang/StringBuilder
    //   733: dup
    //   734: ldc_w 614
    //   737: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   740: aload 10
    //   742: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   745: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   748: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: ldc_w 616
    //   754: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 7
    //   759: invokestatic 621	okhttp3/g:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   762: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: ldc_w 623
    //   768: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload 7
    //   773: invokevirtual 627	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   776: invokeinterface 632 1 0
    //   781: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: ldc_w 634
    //   787: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 7
    //   792: invokestatic 639	okhttp3/internal/i/d:e	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   795: invokevirtual 419	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokespecial 640	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   804: astore 7
    //   806: ldc_w 469
    //   809: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   812: aload 7
    //   814: athrow
    //   815: astore 10
    //   817: aload 9
    //   819: astore 7
    //   821: aload 10
    //   823: invokestatic 643	okhttp3/internal/c:a	(Ljava/lang/AssertionError;)Z
    //   826: ifeq +255 -> 1081
    //   829: aload 9
    //   831: astore 7
    //   833: new 307	java/io/IOException
    //   836: dup
    //   837: aload 10
    //   839: invokespecial 436	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   842: astore 10
    //   844: aload 9
    //   846: astore 7
    //   848: ldc_w 469
    //   851: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: aload 9
    //   856: astore 7
    //   858: aload 10
    //   860: athrow
    //   861: astore 9
    //   863: aload 7
    //   865: ifnull +11 -> 876
    //   868: invokestatic 387	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   871: aload 7
    //   873: invokevirtual 646	okhttp3/internal/g/g:e	(Ljavax/net/ssl/SSLSocket;)V
    //   876: aload 7
    //   878: invokestatic 332	okhttp3/internal/c:closeQuietly	(Ljava/net/Socket;)V
    //   881: ldc_w 469
    //   884: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   887: aload 9
    //   889: athrow
    //   890: new 555	javax/net/ssl/SSLPeerUnverifiedException
    //   893: dup
    //   894: new 229	java/lang/StringBuilder
    //   897: dup
    //   898: ldc_w 614
    //   901: invokespecial 234	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   904: aload 10
    //   906: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   909: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   912: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: ldc_w 648
    //   918: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokespecial 640	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   927: astore 7
    //   929: ldc_w 469
    //   932: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   935: aload 7
    //   937: athrow
    //   938: aload 10
    //   940: getfield 652	okhttp3/a:ajIW	Lokhttp3/g;
    //   943: aload 10
    //   945: getfield 86	okhttp3/a:ajIN	Lokhttp3/r;
    //   948: getfield 92	okhttp3/r:host	Ljava/lang/String;
    //   951: aload 11
    //   953: getfield 603	okhttp3/p:ajMQ	Ljava/util/List;
    //   956: invokevirtual 656	okhttp3/g:ab	(Ljava/lang/String;Ljava/util/List;)V
    //   959: aload 7
    //   961: getfield 575	okhttp3/j:ajMt	Z
    //   964: ifeq +103 -> 1067
    //   967: invokestatic 387	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   970: aload 9
    //   972: invokevirtual 660	okhttp3/internal/g/g:d	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   975: astore 7
    //   977: aload_0
    //   978: aload 9
    //   980: putfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   983: aload_0
    //   984: aload_0
    //   985: getfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   988: invokestatic 399	j/p:f	(Ljava/net/Socket;)Lj/aa;
    //   991: invokestatic 404	j/q:b	(Lj/aa;)Lj/h;
    //   994: putfield 94	okhttp3/internal/b/c:cnO	Lj/h;
    //   997: aload_0
    //   998: aload_0
    //   999: getfield 66	okhttp3/internal/b/c:cBb	Ljava/net/Socket;
    //   1002: invokestatic 408	j/p:e	(Ljava/net/Socket;)Lj/y;
    //   1005: invokestatic 411	j/q:b	(Lj/y;)Lj/g;
    //   1008: putfield 96	okhttp3/internal/b/c:ajPn	Lj/g;
    //   1011: aload_0
    //   1012: aload 11
    //   1014: putfield 537	okhttp3/internal/b/c:ajJu	Lokhttp3/p;
    //   1017: aload 7
    //   1019: ifnull +54 -> 1073
    //   1022: aload 7
    //   1024: invokestatic 664	okhttp3/v:bKu	(Ljava/lang/String;)Lokhttp3/v;
    //   1027: astore 7
    //   1029: aload_0
    //   1030: aload 7
    //   1032: putfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   1035: aload 9
    //   1037: ifnull +11 -> 1048
    //   1040: invokestatic 387	okhttp3/internal/g/g:kIq	()Lokhttp3/internal/g/g;
    //   1043: aload 9
    //   1045: invokevirtual 646	okhttp3/internal/g/g:e	(Ljavax/net/ssl/SSLSocket;)V
    //   1048: aload_0
    //   1049: getfield 470	okhttp3/internal/b/c:ajJs	Lokhttp3/v;
    //   1052: getstatic 667	okhttp3/v:ajNx	Lokhttp3/v;
    //   1055: if_acmpne -838 -> 217
    //   1058: aload_0
    //   1059: iload 4
    //   1061: invokespecial 535	okhttp3/internal/b/c:aMV	(I)V
    //   1064: goto -847 -> 217
    //   1067: aconst_null
    //   1068: astore 7
    //   1070: goto -93 -> 977
    //   1073: getstatic 168	okhttp3/v:ajNv	Lokhttp3/v;
    //   1076: astore 7
    //   1078: goto -49 -> 1029
    //   1081: aload 9
    //   1083: astore 7
    //   1085: ldc_w 469
    //   1088: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1091: aload 9
    //   1093: astore 7
    //   1095: aload 10
    //   1097: athrow
    //   1098: aload 6
    //   1100: getfield 671	okhttp3/internal/b/e:ajPt	Ljava/io/IOException;
    //   1103: aload 7
    //   1105: invokestatic 674	okhttp3/internal/c:e	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   1108: aload 6
    //   1110: aload 7
    //   1112: putfield 677	okhttp3/internal/b/e:ajPu	Ljava/io/IOException;
    //   1115: goto -673 -> 442
    //   1118: iconst_0
    //   1119: istore 8
    //   1121: goto -590 -> 531
    //   1124: goto -935 -> 189
    //   1127: aload_0
    //   1128: getfield 113	okhttp3/internal/b/c:ajPm	Lokhttp3/internal/e/g;
    //   1131: ifnull +47 -> 1178
    //   1134: aload_0
    //   1135: getfield 56	okhttp3/internal/b/c:ajNn	Lokhttp3/i;
    //   1138: astore 6
    //   1140: aload 6
    //   1142: monitorenter
    //   1143: aload_0
    //   1144: aload_0
    //   1145: getfield 113	okhttp3/internal/b/c:ajPm	Lokhttp3/internal/e/g;
    //   1148: invokevirtual 680	okhttp3/internal/e/g:kHN	()I
    //   1151: putfield 45	okhttp3/internal/b/c:ajPp	I
    //   1154: aload 6
    //   1156: monitorexit
    //   1157: ldc_w 469
    //   1160: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1163: return
    //   1164: astore 7
    //   1166: aload 6
    //   1168: monitorexit
    //   1169: ldc_w 469
    //   1172: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1175: aload 7
    //   1177: athrow
    //   1178: ldc_w 469
    //   1181: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1184: return
    //   1185: astore 10
    //   1187: aload 11
    //   1189: astore 9
    //   1191: goto -374 -> 817
    //   1194: aconst_null
    //   1195: astore 6
    //   1197: goto -1008 -> 189
    //   1200: astore 10
    //   1202: aload 9
    //   1204: astore 7
    //   1206: aload 10
    //   1208: astore 9
    //   1210: goto -347 -> 863
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1213	0	this	c
    //   0	1213	1	paramInt1	int
    //   0	1213	2	paramInt2	int
    //   0	1213	3	paramInt3	int
    //   0	1213	4	paramInt4	int
    //   0	1213	5	paramBoolean	boolean
    //   0	1213	7	paramo	okhttp3.o
    //   529	591	8	i	int
    //   577	278	9	localObject1	Object
    //   861	231	9	localSSLSocket	javax.net.ssl.SSLSocket
    //   1189	20	9	localObject2	Object
    //   570	171	10	locala	okhttp3.a
    //   815	23	10	localAssertionError1	java.lang.AssertionError
    //   842	254	10	localIOException	IOException
    //   1185	1	10	localAssertionError2	java.lang.AssertionError
    //   1200	7	10	localObject3	Object
    //   583	605	11	localp	okhttp3.p
    //   55	562	12	localb	b
    //   664	23	13	localSSLSession	javax.net.ssl.SSLSession
    // Exception table:
    //   from	to	target	type
    //   189	212	375	java/io/IOException
    //   311	317	375	java/io/IOException
    //   317	372	375	java/io/IOException
    //   545	560	375	java/io/IOException
    //   563	579	375	java/io/IOException
    //   868	876	375	java/io/IOException
    //   876	890	375	java/io/IOException
    //   1040	1048	375	java/io/IOException
    //   1048	1064	375	java/io/IOException
    //   616	654	815	java/lang/AssertionError
    //   654	815	815	java/lang/AssertionError
    //   890	938	815	java/lang/AssertionError
    //   938	977	815	java/lang/AssertionError
    //   977	1017	815	java/lang/AssertionError
    //   1022	1029	815	java/lang/AssertionError
    //   1029	1035	815	java/lang/AssertionError
    //   1073	1078	815	java/lang/AssertionError
    //   585	616	861	finally
    //   821	829	861	finally
    //   833	844	861	finally
    //   848	854	861	finally
    //   858	861	861	finally
    //   1085	1091	861	finally
    //   1095	1098	861	finally
    //   1143	1157	1164	finally
    //   585	616	1185	java/lang/AssertionError
    //   616	654	1200	finally
    //   654	815	1200	finally
    //   890	938	1200	finally
    //   938	977	1200	finally
    //   977	1017	1200	finally
    //   1022	1029	1200	finally
    //   1029	1035	1200	finally
    //   1073	1078	1200	finally
  }
  
  public final void a(okhttp3.internal.e.g paramg)
  {
    AppMethodBeat.i(186990);
    synchronized (this.ajNn)
    {
      this.ajPp = paramg.kHN();
      AppMethodBeat.o(186990);
      return;
    }
  }
  
  public final void a(okhttp3.internal.e.i parami)
  {
    AppMethodBeat.i(186984);
    parami.b(okhttp3.internal.e.b.ajQc);
    AppMethodBeat.o(186984);
  }
  
  public final boolean a(okhttp3.a parama, okhttp3.ab paramab)
  {
    AppMethodBeat.i(186953);
    if ((this.ajPq.size() >= this.ajPp) || (this.ajPo))
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (!okhttp3.internal.a.ajOh.a(this.ajPk.ajNZ, parama))
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (parama.ajIN.host.equals(this.ajPk.ajNZ.ajIN.host))
    {
      AppMethodBeat.o(186953);
      return true;
    }
    if (this.ajPm == null)
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (paramab == null)
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (paramab.uuH.type() != Proxy.Type.DIRECT)
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (this.ajPk.uuH.type() != Proxy.Type.DIRECT)
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (!this.ajPk.ajOa.equals(paramab.ajOa))
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (paramab.ajNZ.ajIV != d.ajSO)
    {
      AppMethodBeat.o(186953);
      return false;
    }
    if (!c(parama.ajIN))
    {
      AppMethodBeat.o(186953);
      return false;
    }
    try
    {
      parama.ajIW.ab(parama.ajIN.host, this.ajJu.ajMQ);
      AppMethodBeat.o(186953);
      return true;
    }
    catch (SSLPeerUnverifiedException parama)
    {
      AppMethodBeat.o(186953);
    }
    return false;
  }
  
  public final boolean c(r paramr)
  {
    AppMethodBeat.i(186964);
    if (paramr.port != this.ajPk.ajNZ.ajIN.port)
    {
      AppMethodBeat.o(186964);
      return false;
    }
    if (!paramr.host.equals(this.ajPk.ajNZ.ajIN.host))
    {
      if (this.ajJu != null)
      {
        d locald = d.ajSO;
        if (d.a(paramr.host, (X509Certificate)this.ajJu.ajMQ.get(0)))
        {
          AppMethodBeat.o(186964);
          return true;
        }
      }
      AppMethodBeat.o(186964);
      return false;
    }
    AppMethodBeat.o(186964);
    return true;
  }
  
  public final boolean kHv()
  {
    return this.ajPm != null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187009);
    StringBuilder localStringBuilder = new StringBuilder("Connection{").append(this.ajPk.ajNZ.ajIN.host).append(":").append(this.ajPk.ajNZ.ajIN.port).append(", proxy=").append(this.ajPk.uuH).append(" hostAddress=").append(this.ajPk.ajOa).append(" cipherSuite=");
    if (this.ajJu != null) {}
    for (Object localObject = this.ajJu.ajMP;; localObject = "none")
    {
      localObject = localObject + " protocol=" + this.ajJs + '}';
      AppMethodBeat.o(187009);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     okhttp3.internal.b.c
 * JD-Core Version:    0.7.0.1
 */