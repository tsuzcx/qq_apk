package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.network.v;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.File;

public final class b
  extends c
{
  private int GRO;
  private int Irk;
  private com.tencent.mm.sandbox.b.a Irl;
  private a Irm;
  private com.tencent.mm.sandbox.b.a Irn;
  private String[] cni;
  private byte[] dMA;
  private byte[] iHf;
  private byte[] iHj;
  private final int sza;
  private int uin;
  
  public b(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32665);
    this.Irk = 0;
    this.sza = 5;
    this.GRO = 0;
    this.Irm = null;
    this.Irn = new com.tencent.mm.sandbox.b.a()
    {
      public final void Dm(long paramAnonymousLong)
      {
        AppMethodBeat.i(32658);
        b.c(b.this).Dm(paramAnonymousLong);
        AppMethodBeat.o(32658);
      }
      
      public final void Dn(long paramAnonymousLong)
      {
        AppMethodBeat.i(32659);
        b.c(b.this).Dn(paramAnonymousLong);
        AppMethodBeat.o(32659);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cwj paramAnonymouscwj)
      {
        AppMethodBeat.i(32657);
        if ((paramAnonymousInt1 != 200) || (paramAnonymousInt2 != 0) || ((paramAnonymouscwj != null) && (paramAnonymouscwj.getBaseResponse().Ret != 0)))
        {
          if ((!b.this.fmm()) && (b.a(b.this) < b.b(b.this).length * 5))
          {
            b.this.a(b.c(b.this));
            AppMethodBeat.o(32657);
            return;
          }
          b.c(b.this).b(paramAnonymousInt1, paramAnonymousInt2, paramAnonymouscwj);
          AppMethodBeat.o(32657);
          return;
        }
        bkh localbkh = (bkh)paramAnonymouscwj;
        ae.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.loader.j.b.asd());
        ae.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + localbkh.xsB);
        ae.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + localbkh.xsC);
        ae.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + localbkh.xsD);
        if ((localbkh.xsD <= 0) || (localbkh.xsE == null))
        {
          ae.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
          b.c(b.this).b(paramAnonymousInt1, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if (localbkh.xsE.getILen() != localbkh.xsD)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + localbkh.xsD + " data buf len = " + localbkh.xsE.getILen());
          b.c(b.this).b(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if ((localbkh.xsC < 0) || (localbkh.xsC + localbkh.xsD > localbkh.xsB))
        {
          ae.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + localbkh.xsC + " dataLen = " + localbkh.xsD + " totalLen = " + localbkh.xsB);
          b.c(b.this).b(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if (localbkh.xsB <= 0)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + localbkh.xsB);
          b.c(b.this).b(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        paramAnonymousInt1 = d.A(c.IqQ + b.d(b.this) + ".temp", localbkh.xsE.getBuffer().toByteArray());
        if (paramAnonymousInt1 != 0)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(paramAnonymousInt1)));
          b.c(b.this).b(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        b.a(b.this, localbkh.xsD + localbkh.xsC);
        b.b(b.this, localbkh.xsB);
        b.c(b.this).fa(localbkh.xsB, localbkh.xsC);
        if (localbkh.xsC + localbkh.xsD >= localbkh.xsB)
        {
          try
          {
            if (b.f(b.this).equalsIgnoreCase(d.aRh(b.e(b.this))))
            {
              d.bc(c.IqQ, b.g(b.this) + ".temp", b.h(b.this) + ".apk");
              b.c(b.this).b(200, 0, paramAnonymouscwj);
              AppMethodBeat.o(32657);
              return;
            }
          }
          catch (Exception paramAnonymouscwj)
          {
            ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", paramAnonymouscwj, "", new Object[0]);
            AppMethodBeat.o(32657);
            return;
          }
          ae.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
          new File(b.i(b.this)).delete();
          b.c(b.this).b(-1, -1, paramAnonymouscwj);
          AppMethodBeat.o(32657);
          return;
        }
        b.this.a(b.c(b.this));
        AppMethodBeat.o(32657);
      }
      
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2) {}
    };
    this.cni = paramArrayOfString;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this.cni = new String[] { "short.weixin.qq.com" };
    }
    this.uin = paramInt3;
    this.iHf = paramArrayOfByte1;
    this.dMA = paramArrayOfByte2;
    AppMethodBeat.o(32665);
  }
  
  public final void a(com.tencent.mm.sandbox.b.a parama)
  {
    AppMethodBeat.i(32666);
    this.Irl = parama;
    int i = this.Irk + 1;
    this.Irk = i;
    if (i > 1000)
    {
      ae.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
      this.Irl.b(-1, -1, null);
      AppMethodBeat.o(32666);
      return;
    }
    if (!e.re(this.IqS))
    {
      ae.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[] { Integer.valueOf(this.IqS) });
      parama.b(-1, -1, null);
      AppMethodBeat.o(32666);
      return;
    }
    parama = new bkg();
    Object localObject = new jc();
    ((jc)localObject).FUA = com.tencent.mm.protocal.d.FFH;
    ((jc)localObject).Scene = 0;
    ((jc)localObject).qkC = this.uin;
    ((jc)localObject).FUz = com.tencent.mm.bw.b.cm(q.aaH().getBytes());
    if (((jc)localObject).FUz.zr.length >= 16) {
      ((jc)localObject).FUz = ((jc)localObject).FUz.aaf(16);
    }
    ((jc)localObject).FUB = com.tencent.mm.bw.b.cm(com.tencent.mm.protocal.d.hjv.getBytes());
    if (((jc)localObject).FUB.zr.length >= 132) {
      ((jc)localObject).FUB = ((jc)localObject).FUB.aaf(132);
    }
    ((jc)localObject).FUy = com.tencent.mm.bw.b.cm(this.iHf);
    if (((jc)localObject).FUy.zr.length >= 36) {
      ((jc)localObject).FUy = ((jc)localObject).FUy.aaf(36);
    }
    parama.setBaseRequest((jc)localObject);
    parama.GXv = this.IqR;
    parama.xsC = this.IqT;
    parama.xsB = this.IqS;
    localObject = new a(this.cni[(this.GRO / 5)], this.Irn);
    this.Irm = ((a)localObject);
    ((a)localObject).execute(new bkg[] { parama });
    AppMethodBeat.o(32666);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32667);
    ae.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.IqR);
    if ((this.Irm != null) && (!this.Irm.isCancelled())) {
      this.Irm.cancel(true);
    }
    AppMethodBeat.o(32667);
  }
  
  final class a
    extends AsyncTask<bkg, Integer, bkh>
  {
    private com.tencent.mm.sandbox.b.a Irl;
    private v Irp;
    private int Irq;
    private PInt Irr;
    private String host;
    
    public a(String paramString, com.tencent.mm.sandbox.b.a parama)
    {
      AppMethodBeat.i(32660);
      this.Irp = null;
      this.Irq = 200;
      this.Irr = new PInt();
      this.host = null;
      this.Irl = null;
      this.host = paramString;
      this.Irl = parama;
      AppMethodBeat.o(32660);
    }
    
    /* Error */
    private bkh a(bkg... paramVarArgs)
    {
      // Byte code:
      //   0: sipush 32661
      //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_1
      //   7: arraylength
      //   8: ifeq +9 -> 17
      //   11: aload_1
      //   12: iconst_0
      //   13: aaload
      //   14: ifnonnull +16 -> 30
      //   17: aload_0
      //   18: iconst_m1
      //   19: putfield 37	com/tencent/mm/sandbox/updater/b$a:Irq	I
      //   22: sipush 32661
      //   25: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   28: aconst_null
      //   29: areturn
      //   30: ldc 57
      //   32: new 59	java/lang/StringBuilder
      //   35: dup
      //   36: ldc 61
      //   38: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   41: aload_1
      //   42: iconst_0
      //   43: aaload
      //   44: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: invokestatic 78	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   53: aload_1
      //   54: iconst_0
      //   55: aaload
      //   56: astore_1
      //   57: new 80	com/tencent/mm/pointers/PByteArray
      //   60: dup
      //   61: invokespecial 81	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   64: astore 10
      //   66: bipush 6
      //   68: istore_2
      //   69: getstatic 87	com/tencent/mm/sdk/a/b:foreground	Z
      //   72: ifeq +6 -> 78
      //   75: bipush 7
      //   77: istore_2
      //   78: aload_1
      //   79: invokevirtual 93	com/tencent/mm/protocal/protobuf/bkg:toByteArray	()[B
      //   82: astore_1
      //   83: iconst_0
      //   84: istore 4
      //   86: iload 4
      //   88: istore_3
      //   89: aload_0
      //   90: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   93: invokestatic 97	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   96: invokestatic 103	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
      //   99: ifne +32 -> 131
      //   102: iload 4
      //   104: istore_3
      //   105: aload_1
      //   106: invokestatic 103	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
      //   109: ifne +22 -> 131
      //   112: aload_0
      //   113: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   116: invokestatic 107	com/tencent/mm/sandbox/updater/b:k	(Lcom/tencent/mm/sandbox/updater/b;)I
      //   119: aload_0
      //   120: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   123: invokestatic 97	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   126: aload_1
      //   127: invokestatic 113	com/tencent/mm/protocal/MMProtocalJni:genSignature	(I[B[B)I
      //   130: istore_3
      //   131: aload_1
      //   132: aload 10
      //   134: aload_0
      //   135: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   138: invokestatic 116	com/tencent/mm/sandbox/updater/b:l	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   141: iconst_0
      //   142: aload_0
      //   143: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   146: invokestatic 119	com/tencent/mm/sandbox/updater/b:m	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   149: invokestatic 124	com/tencent/mm/compatible/deviceinfo/q:aaH	()Ljava/lang/String;
      //   152: aload_0
      //   153: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   156: invokestatic 107	com/tencent/mm/sandbox/updater/b:k	(Lcom/tencent/mm/sandbox/updater/b;)I
      //   159: bipush 113
      //   161: iconst_0
      //   162: iconst_0
      //   163: newarray byte
      //   165: iconst_0
      //   166: newarray byte
      //   168: iload_3
      //   169: iload_2
      //   170: iconst_0
      //   171: iconst_0
      //   172: invokestatic 128	com/tencent/mm/protocal/MMProtocalJni:pack	([BLcom/tencent/mm/pointers/PByteArray;[BI[BLjava/lang/String;III[B[BIIII)Z
      //   175: pop
      //   176: aconst_null
      //   177: astore 9
      //   179: aconst_null
      //   180: astore 7
      //   182: aconst_null
      //   183: astore 8
      //   185: aload_0
      //   186: new 59	java/lang/StringBuilder
      //   189: dup
      //   190: ldc 130
      //   192: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   195: aload_0
      //   196: getfield 44	com/tencent/mm/sandbox/updater/b$a:host	Ljava/lang/String;
      //   199: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   202: ldc 135
      //   204: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   207: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   210: aconst_null
      //   211: invokestatic 140	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
      //   214: putfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   217: aload_0
      //   218: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   221: ldc 142
      //   223: invokevirtual 147	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
      //   226: aload_0
      //   227: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   230: getfield 151	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
      //   233: iconst_1
      //   234: invokevirtual 157	java/net/HttpURLConnection:setDoInput	(Z)V
      //   237: aload_0
      //   238: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   241: getfield 151	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
      //   244: iconst_1
      //   245: invokevirtual 160	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   248: aload_0
      //   249: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   252: iconst_0
      //   253: invokevirtual 163	com/tencent/mm/network/v:setUseCaches	(Z)V
      //   256: aload_0
      //   257: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   260: ldc 165
      //   262: ldc 167
      //   264: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   267: aload_0
      //   268: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   271: ldc 172
      //   273: ldc 174
      //   275: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: aload_0
      //   279: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   282: ldc 176
      //   284: ldc 178
      //   286: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   289: aload_0
      //   290: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   293: ldc 180
      //   295: ldc 182
      //   297: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   300: aload_0
      //   301: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   304: ldc 184
      //   306: ldc 186
      //   308: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   311: aload_0
      //   312: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   315: ldc 188
      //   317: ldc 190
      //   319: invokevirtual 170	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   322: aload_0
      //   323: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   326: sipush 15000
      //   329: invokevirtual 193	com/tencent/mm/network/v:setConnectTimeout	(I)V
      //   332: aload_0
      //   333: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   336: invokevirtual 196	com/tencent/mm/network/v:connect	()V
      //   339: aload_0
      //   340: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   343: astore_1
      //   344: iconst_1
      //   345: aload_1
      //   346: getfield 199	com/tencent/mm/network/v:iHs	I
      //   349: if_icmpne +26 -> 375
      //   352: aload_1
      //   353: getfield 203	com/tencent/mm/network/v:requestProperties	Ljava/util/Map;
      //   356: ifnonnull +14 -> 370
      //   359: aload_1
      //   360: aload_1
      //   361: getfield 151	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
      //   364: invokevirtual 207	java/net/HttpURLConnection:getRequestProperties	()Ljava/util/Map;
      //   367: putfield 203	com/tencent/mm/network/v:requestProperties	Ljava/util/Map;
      //   370: aload_1
      //   371: invokevirtual 211	com/tencent/mm/network/v:getResponseCode	()I
      //   374: pop
      //   375: aload_1
      //   376: getfield 151	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
      //   379: invokevirtual 215	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   382: astore_1
      //   383: aload_1
      //   384: aload 10
      //   386: getfield 219	com/tencent/mm/pointers/PByteArray:value	[B
      //   389: invokevirtual 225	java/io/OutputStream:write	([B)V
      //   392: aload_1
      //   393: invokevirtual 228	java/io/OutputStream:flush	()V
      //   396: aload_0
      //   397: getfield 46	com/tencent/mm/sandbox/updater/b$a:Irl	Lcom/tencent/mm/sandbox/b$a;
      //   400: ldc2_w 229
      //   403: aload 10
      //   405: getfield 219	com/tencent/mm/pointers/PByteArray:value	[B
      //   408: arraylength
      //   409: i2l
      //   410: ladd
      //   411: invokeinterface 236 3 0
      //   416: aload_0
      //   417: aload_0
      //   418: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   421: invokevirtual 211	com/tencent/mm/network/v:getResponseCode	()I
      //   424: putfield 37	com/tencent/mm/sandbox/updater/b$a:Irq	I
      //   427: aload_0
      //   428: getfield 37	com/tencent/mm/sandbox/updater/b$a:Irq	I
      //   431: istore_2
      //   432: iload_2
      //   433: sipush 200
      //   436: if_icmpeq +93 -> 529
      //   439: aload_1
      //   440: ifnull +7 -> 447
      //   443: aload_1
      //   444: invokevirtual 239	java/io/OutputStream:close	()V
      //   447: aload_0
      //   448: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   451: ifnull +15 -> 466
      //   454: aload_0
      //   455: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   458: invokevirtual 242	com/tencent/mm/network/v:disconnect	()V
      //   461: aload_0
      //   462: aconst_null
      //   463: putfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   466: sipush 32661
      //   469: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   472: aconst_null
      //   473: areturn
      //   474: astore_1
      //   475: ldc 57
      //   477: ldc 244
      //   479: iconst_1
      //   480: anewarray 246	java/lang/Object
      //   483: dup
      //   484: iconst_0
      //   485: aload_1
      //   486: invokevirtual 249	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   489: aastore
      //   490: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   493: ldc 57
      //   495: aload_1
      //   496: ldc 255
      //   498: iconst_0
      //   499: anewarray 246	java/lang/Object
      //   502: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   505: sipush 32661
      //   508: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   511: aconst_null
      //   512: areturn
      //   513: astore_1
      //   514: ldc 57
      //   516: aload_1
      //   517: ldc 255
      //   519: iconst_0
      //   520: anewarray 246	java/lang/Object
      //   523: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   526: goto -79 -> 447
      //   529: aload_0
      //   530: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   533: ldc_w 261
      //   536: invokevirtual 265	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   539: astore 7
      //   541: aload_0
      //   542: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   545: invokevirtual 269	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
      //   548: astore 9
      //   550: ldc2_w 229
      //   553: lstore 5
      //   555: aload 7
      //   557: ifnull +604 -> 1161
      //   560: aload 7
      //   562: ldc_w 271
      //   565: invokevirtual 277	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   568: ifeq +593 -> 1161
      //   571: new 279	java/util/zip/GZIPInputStream
      //   574: dup
      //   575: aload 9
      //   577: invokespecial 282	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   580: astore 7
      //   582: iconst_1
      //   583: istore_2
      //   584: new 284	java/io/ByteArrayOutputStream
      //   587: dup
      //   588: invokespecial 285	java/io/ByteArrayOutputStream:<init>	()V
      //   591: astore 8
      //   593: sipush 1024
      //   596: newarray byte
      //   598: astore 10
      //   600: aload 7
      //   602: aload 10
      //   604: invokevirtual 291	java/io/InputStream:read	([B)I
      //   607: istore_3
      //   608: iload_3
      //   609: ifle +22 -> 631
      //   612: aload 8
      //   614: aload 10
      //   616: iconst_0
      //   617: iload_3
      //   618: invokevirtual 294	java/io/ByteArrayOutputStream:write	([BII)V
      //   621: lload 5
      //   623: iload_3
      //   624: i2l
      //   625: ladd
      //   626: lstore 5
      //   628: goto -28 -> 600
      //   631: iload_2
      //   632: ifeq +200 -> 832
      //   635: aload 9
      //   637: invokevirtual 298	java/io/InputStream:markSupported	()Z
      //   640: ifeq +192 -> 832
      //   643: aload 9
      //   645: iconst_1
      //   646: invokevirtual 301	java/io/InputStream:mark	(I)V
      //   649: ldc2_w 229
      //   652: lstore 5
      //   654: aload 9
      //   656: aload 10
      //   658: invokevirtual 291	java/io/InputStream:read	([B)I
      //   661: istore_2
      //   662: iload_2
      //   663: ifle +13 -> 676
      //   666: lload 5
      //   668: iload_2
      //   669: i2l
      //   670: ladd
      //   671: lstore 5
      //   673: goto -19 -> 654
      //   676: aload_0
      //   677: getfield 46	com/tencent/mm/sandbox/updater/b$a:Irl	Lcom/tencent/mm/sandbox/b$a;
      //   680: lload 5
      //   682: invokeinterface 304 3 0
      //   687: new 80	com/tencent/mm/pointers/PByteArray
      //   690: dup
      //   691: invokespecial 81	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   694: astore 9
      //   696: new 80	com/tencent/mm/pointers/PByteArray
      //   699: dup
      //   700: invokespecial 81	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   703: astore 10
      //   705: new 39	com/tencent/mm/pointers/PInt
      //   708: dup
      //   709: invokespecial 40	com/tencent/mm/pointers/PInt:<init>	()V
      //   712: astore 11
      //   714: new 39	com/tencent/mm/pointers/PInt
      //   717: dup
      //   718: iconst_0
      //   719: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	(I)V
      //   722: astore 12
      //   724: new 39	com/tencent/mm/pointers/PInt
      //   727: dup
      //   728: sipush 255
      //   731: invokespecial 306	com/tencent/mm/pointers/PInt:<init>	(I)V
      //   734: astore 13
      //   736: aload 9
      //   738: aload 8
      //   740: invokevirtual 307	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   743: aload_0
      //   744: getfield 24	com/tencent/mm/sandbox/updater/b$a:Iro	Lcom/tencent/mm/sandbox/updater/b;
      //   747: invokestatic 116	com/tencent/mm/sandbox/updater/b:l	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   750: aload 10
      //   752: aload_0
      //   753: getfield 42	com/tencent/mm/sandbox/updater/b$a:Irr	Lcom/tencent/mm/pointers/PInt;
      //   756: aload 11
      //   758: aload 12
      //   760: aload 13
      //   762: invokestatic 311	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
      //   765: pop
      //   766: new 313	com/tencent/mm/protocal/protobuf/bkh
      //   769: dup
      //   770: invokespecial 314	com/tencent/mm/protocal/protobuf/bkh:<init>	()V
      //   773: aload 9
      //   775: getfield 219	com/tencent/mm/pointers/PByteArray:value	[B
      //   778: invokevirtual 318	com/tencent/mm/protocal/protobuf/bkh:parseFrom	([B)Lcom/tencent/mm/bw/a;
      //   781: checkcast 313	com/tencent/mm/protocal/protobuf/bkh
      //   784: astore 8
      //   786: aload_1
      //   787: ifnull +7 -> 794
      //   790: aload_1
      //   791: invokevirtual 239	java/io/OutputStream:close	()V
      //   794: aload 7
      //   796: ifnull +8 -> 804
      //   799: aload 7
      //   801: invokevirtual 319	java/io/InputStream:close	()V
      //   804: aload_0
      //   805: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   808: ifnull +15 -> 823
      //   811: aload_0
      //   812: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   815: invokevirtual 242	com/tencent/mm/network/v:disconnect	()V
      //   818: aload_0
      //   819: aconst_null
      //   820: putfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   823: sipush 32661
      //   826: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   829: aload 8
      //   831: areturn
      //   832: aload_0
      //   833: getfield 46	com/tencent/mm/sandbox/updater/b$a:Irl	Lcom/tencent/mm/sandbox/b$a;
      //   836: lload 5
      //   838: invokeinterface 304 3 0
      //   843: goto -156 -> 687
      //   846: astore 9
      //   848: aload 7
      //   850: astore 8
      //   852: aload_1
      //   853: astore 7
      //   855: aload 8
      //   857: astore_1
      //   858: aload 9
      //   860: astore 8
      //   862: ldc 57
      //   864: ldc_w 321
      //   867: iconst_1
      //   868: anewarray 246	java/lang/Object
      //   871: dup
      //   872: iconst_0
      //   873: aload 8
      //   875: invokevirtual 249	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   878: aastore
      //   879: invokestatic 253	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   882: ldc 57
      //   884: aload 8
      //   886: ldc 255
      //   888: iconst_0
      //   889: anewarray 246	java/lang/Object
      //   892: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   895: aload_0
      //   896: iconst_m1
      //   897: putfield 37	com/tencent/mm/sandbox/updater/b$a:Irq	I
      //   900: aload 7
      //   902: ifnull +8 -> 910
      //   905: aload 7
      //   907: invokevirtual 239	java/io/OutputStream:close	()V
      //   910: aload_1
      //   911: ifnull +7 -> 918
      //   914: aload_1
      //   915: invokevirtual 319	java/io/InputStream:close	()V
      //   918: aload_0
      //   919: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   922: ifnull +15 -> 937
      //   925: aload_0
      //   926: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   929: invokevirtual 242	com/tencent/mm/network/v:disconnect	()V
      //   932: aload_0
      //   933: aconst_null
      //   934: putfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   937: sipush 32661
      //   940: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   943: aconst_null
      //   944: areturn
      //   945: astore_1
      //   946: ldc 57
      //   948: aload_1
      //   949: ldc 255
      //   951: iconst_0
      //   952: anewarray 246	java/lang/Object
      //   955: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   958: goto -164 -> 794
      //   961: astore_1
      //   962: ldc 57
      //   964: aload_1
      //   965: ldc 255
      //   967: iconst_0
      //   968: anewarray 246	java/lang/Object
      //   971: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   974: goto -170 -> 804
      //   977: astore 7
      //   979: ldc 57
      //   981: aload 7
      //   983: ldc 255
      //   985: iconst_0
      //   986: anewarray 246	java/lang/Object
      //   989: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   992: goto -82 -> 910
      //   995: astore_1
      //   996: ldc 57
      //   998: aload_1
      //   999: ldc 255
      //   1001: iconst_0
      //   1002: anewarray 246	java/lang/Object
      //   1005: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1008: goto -90 -> 918
      //   1011: astore_1
      //   1012: aload 9
      //   1014: astore 7
      //   1016: aload 7
      //   1018: ifnull +8 -> 1026
      //   1021: aload 7
      //   1023: invokevirtual 239	java/io/OutputStream:close	()V
      //   1026: aload 8
      //   1028: ifnull +8 -> 1036
      //   1031: aload 8
      //   1033: invokevirtual 319	java/io/InputStream:close	()V
      //   1036: aload_0
      //   1037: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   1040: ifnull +15 -> 1055
      //   1043: aload_0
      //   1044: getfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   1047: invokevirtual 242	com/tencent/mm/network/v:disconnect	()V
      //   1050: aload_0
      //   1051: aconst_null
      //   1052: putfield 35	com/tencent/mm/sandbox/updater/b$a:Irp	Lcom/tencent/mm/network/v;
      //   1055: sipush 32661
      //   1058: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1061: aload_1
      //   1062: athrow
      //   1063: astore 7
      //   1065: ldc 57
      //   1067: aload 7
      //   1069: ldc 255
      //   1071: iconst_0
      //   1072: anewarray 246	java/lang/Object
      //   1075: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1078: goto -52 -> 1026
      //   1081: astore 7
      //   1083: ldc 57
      //   1085: aload 7
      //   1087: ldc 255
      //   1089: iconst_0
      //   1090: anewarray 246	java/lang/Object
      //   1093: invokestatic 259	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1096: goto -60 -> 1036
      //   1099: astore 9
      //   1101: aload_1
      //   1102: astore 7
      //   1104: aload 9
      //   1106: astore_1
      //   1107: goto -91 -> 1016
      //   1110: astore 8
      //   1112: aload_1
      //   1113: astore 9
      //   1115: aload 8
      //   1117: astore_1
      //   1118: aload 7
      //   1120: astore 8
      //   1122: aload 9
      //   1124: astore 7
      //   1126: goto -110 -> 1016
      //   1129: astore 9
      //   1131: aload_1
      //   1132: astore 8
      //   1134: aload 9
      //   1136: astore_1
      //   1137: goto -121 -> 1016
      //   1140: astore 8
      //   1142: aconst_null
      //   1143: astore_1
      //   1144: goto -282 -> 862
      //   1147: astore 8
      //   1149: aconst_null
      //   1150: astore 9
      //   1152: aload_1
      //   1153: astore 7
      //   1155: aload 9
      //   1157: astore_1
      //   1158: goto -296 -> 862
      //   1161: iconst_0
      //   1162: istore_2
      //   1163: aload 9
      //   1165: astore 7
      //   1167: goto -583 -> 584
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1170	0	this	a
      //   0	1170	1	paramVarArgs	bkg[]
      //   68	1095	2	i	int
      //   88	536	3	j	int
      //   84	19	4	k	int
      //   553	284	5	l	long
      //   180	726	7	localObject1	Object
      //   977	5	7	localIOException1	java.io.IOException
      //   1014	8	7	localException1	Exception
      //   1063	5	7	localIOException2	java.io.IOException
      //   1081	5	7	localIOException3	java.io.IOException
      //   1102	64	7	localObject2	Object
      //   183	849	8	localObject3	Object
      //   1110	6	8	localObject4	Object
      //   1120	13	8	localObject5	Object
      //   1140	1	8	localException2	Exception
      //   1147	1	8	localException3	Exception
      //   177	597	9	localObject6	Object
      //   846	167	9	localException4	Exception
      //   1099	6	9	localObject7	Object
      //   1113	10	9	arrayOfbkg	bkg[]
      //   1129	6	9	localObject8	Object
      //   1150	14	9	localObject9	Object
      //   64	687	10	localObject10	Object
      //   712	45	11	localPInt1	PInt
      //   722	37	12	localPInt2	PInt
      //   734	27	13	localPInt3	PInt
      // Exception table:
      //   from	to	target	type
      //   78	83	474	java/lang/Exception
      //   89	102	474	java/lang/Exception
      //   105	131	474	java/lang/Exception
      //   131	176	474	java/lang/Exception
      //   443	447	513	java/io/IOException
      //   584	600	846	java/lang/Exception
      //   600	608	846	java/lang/Exception
      //   612	621	846	java/lang/Exception
      //   635	649	846	java/lang/Exception
      //   654	662	846	java/lang/Exception
      //   676	687	846	java/lang/Exception
      //   687	786	846	java/lang/Exception
      //   832	843	846	java/lang/Exception
      //   790	794	945	java/io/IOException
      //   799	804	961	java/io/IOException
      //   905	910	977	java/io/IOException
      //   914	918	995	java/io/IOException
      //   185	370	1011	finally
      //   370	375	1011	finally
      //   375	383	1011	finally
      //   1021	1026	1063	java/io/IOException
      //   1031	1036	1081	java/io/IOException
      //   383	432	1099	finally
      //   529	550	1099	finally
      //   560	582	1099	finally
      //   584	600	1110	finally
      //   600	608	1110	finally
      //   612	621	1110	finally
      //   635	649	1110	finally
      //   654	662	1110	finally
      //   676	687	1110	finally
      //   687	786	1110	finally
      //   832	843	1110	finally
      //   862	900	1129	finally
      //   185	370	1140	java/lang/Exception
      //   370	375	1140	java/lang/Exception
      //   375	383	1140	java/lang/Exception
      //   383	432	1147	java/lang/Exception
      //   529	550	1147	java/lang/Exception
      //   560	582	1147	java/lang/Exception
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32662);
      ae.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
      if (this.Irp != null) {
        this.Irp.disconnect();
      }
      AppMethodBeat.o(32662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b
 * JD-Core Version:    0.7.0.1
 */