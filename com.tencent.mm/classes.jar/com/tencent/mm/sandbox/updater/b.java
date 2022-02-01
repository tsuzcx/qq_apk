package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.network.v;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.File;

public final class b
  extends c
{
  private int EPg;
  private int Glq;
  private final int Glr;
  private com.tencent.mm.sandbox.b.a Gls;
  private a Glt;
  private com.tencent.mm.sandbox.b.a Glu;
  private String[] ccP;
  private byte[] dyZ;
  private byte[] ikV;
  private byte[] ikZ;
  private int uin;
  
  public b(int paramInt1, String paramString, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32665);
    this.Glq = 0;
    this.Glr = 5;
    this.EPg = 0;
    this.Glt = null;
    this.Glu = new com.tencent.mm.sandbox.b.a()
    {
      public final void Aa(long paramAnonymousLong)
      {
        AppMethodBeat.i(32659);
        b.c(b.this).Aa(paramAnonymousLong);
        AppMethodBeat.o(32659);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, cqk paramAnonymouscqk)
      {
        AppMethodBeat.i(32657);
        if ((paramAnonymousInt1 != 200) || (paramAnonymousInt2 != 0) || ((paramAnonymouscqk != null) && (paramAnonymouscqk.getBaseResponse().Ret != 0)))
        {
          if ((!b.this.eSS()) && (b.a(b.this) < b.b(b.this).length * 5))
          {
            b.this.a(b.c(b.this));
            AppMethodBeat.o(32657);
            return;
          }
          b.c(b.this).d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymouscqk);
          AppMethodBeat.o(32657);
          return;
        }
        bfh localbfh = (bfh)paramAnonymouscqk;
        ac.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.loader.j.b.apb());
        ac.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + localbfh.vTH);
        ac.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + localbfh.vTI);
        ac.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + localbfh.vTJ);
        if ((localbfh.vTJ <= 0) || (localbfh.vTK == null))
        {
          ac.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
          b.c(b.this).d(paramAnonymousInt1, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if (localbfh.vTK.getILen() != localbfh.vTJ)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + localbfh.vTJ + " data buf len = " + localbfh.vTK.getILen());
          b.c(b.this).d(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if ((localbfh.vTI < 0) || (localbfh.vTI + localbfh.vTJ > localbfh.vTH))
        {
          ac.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + localbfh.vTI + " dataLen = " + localbfh.vTJ + " totalLen = " + localbfh.vTH);
          b.c(b.this).d(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        if (localbfh.vTH <= 0)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + localbfh.vTH);
          b.c(b.this).d(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        paramAnonymousInt1 = d.z(c.GkW + b.d(b.this) + ".temp", localbfh.vTK.getBuffer().toByteArray());
        if (paramAnonymousInt1 != 0)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(paramAnonymousInt1)));
          b.c(b.this).d(4, -1, null);
          AppMethodBeat.o(32657);
          return;
        }
        b.a(b.this, localbfh.vTJ + localbfh.vTI);
        b.b(b.this, localbfh.vTH);
        b.c(b.this).eV(localbfh.vTH, localbfh.vTI);
        if (localbfh.vTI + localbfh.vTJ >= localbfh.vTH)
        {
          try
          {
            if (b.f(b.this).equalsIgnoreCase(d.aKe(b.e(b.this))))
            {
              d.aT(c.GkW, b.g(b.this) + ".temp", b.h(b.this) + ".apk");
              b.c(b.this).d(200, 0, paramAnonymouscqk);
              AppMethodBeat.o(32657);
              return;
            }
          }
          catch (Exception paramAnonymouscqk)
          {
            ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", paramAnonymouscqk, "", new Object[0]);
            AppMethodBeat.o(32657);
            return;
          }
          ac.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
          new File(b.i(b.this)).delete();
          b.c(b.this).d(-1, -1, paramAnonymouscqk);
          AppMethodBeat.o(32657);
          return;
        }
        b.this.a(b.c(b.this));
        AppMethodBeat.o(32657);
      }
      
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void zZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(32658);
        b.c(b.this).zZ(paramAnonymousLong);
        AppMethodBeat.o(32658);
      }
    };
    this.ccP = paramArrayOfString;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      this.ccP = new String[] { "short.weixin.qq.com" };
    }
    this.uin = paramInt3;
    this.ikV = paramArrayOfByte1;
    this.dyZ = paramArrayOfByte2;
    AppMethodBeat.o(32665);
  }
  
  public final void a(com.tencent.mm.sandbox.b.a parama)
  {
    AppMethodBeat.i(32666);
    this.Gls = parama;
    int i = this.Glq + 1;
    this.Glq = i;
    if (i > 1000)
    {
      ac.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
      this.Gls.d(-1, -1, null);
      AppMethodBeat.o(32666);
      return;
    }
    if (!e.oR(this.GkY))
    {
      ac.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[] { Integer.valueOf(this.GkY) });
      parama.d(-1, -1, null);
      AppMethodBeat.o(32666);
      return;
    }
    parama = new bfg();
    Object localObject = new iv();
    ((iv)localObject).DWJ = com.tencent.mm.protocal.d.DIc;
    ((iv)localObject).Scene = 0;
    ((iv)localObject).pAs = this.uin;
    ((iv)localObject).DWI = com.tencent.mm.bw.b.cc(q.XX().getBytes());
    if (((iv)localObject).DWI.xy.length >= 16) {
      ((iv)localObject).DWI = ((iv)localObject).DWI.XD(16);
    }
    ((iv)localObject).DWK = com.tencent.mm.bw.b.cc(com.tencent.mm.protocal.d.gMK.getBytes());
    if (((iv)localObject).DWK.xy.length >= 132) {
      ((iv)localObject).DWK = ((iv)localObject).DWK.XD(132);
    }
    ((iv)localObject).DWH = com.tencent.mm.bw.b.cc(this.ikV);
    if (((iv)localObject).DWH.xy.length >= 36) {
      ((iv)localObject).DWH = ((iv)localObject).DWH.XD(36);
    }
    parama.setBaseRequest((iv)localObject);
    parama.EUv = this.GkX;
    parama.vTI = this.GkZ;
    parama.vTH = this.GkY;
    localObject = new a(this.ccP[(this.EPg / 5)], this.Glu);
    this.Glt = ((a)localObject);
    ((a)localObject).execute(new bfg[] { parama });
    AppMethodBeat.o(32666);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32667);
    ac.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.GkX);
    if ((this.Glt != null) && (!this.Glt.isCancelled())) {
      this.Glt.cancel(true);
    }
    AppMethodBeat.o(32667);
  }
  
  final class a
    extends AsyncTask<bfg, Integer, bfh>
  {
    private com.tencent.mm.sandbox.b.a Gls;
    private int Glw;
    private PInt Glx;
    private String host;
    private v vVJ;
    
    public a(String paramString, com.tencent.mm.sandbox.b.a parama)
    {
      AppMethodBeat.i(32660);
      this.vVJ = null;
      this.Glw = 200;
      this.Glx = new PInt();
      this.host = null;
      this.Gls = null;
      this.host = paramString;
      this.Gls = parama;
      AppMethodBeat.o(32660);
    }
    
    /* Error */
    private bfh a(bfg... paramVarArgs)
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
      //   19: putfield 37	com/tencent/mm/sandbox/updater/b$a:Glw	I
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
      //   50: invokestatic 78	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   79: invokevirtual 93	com/tencent/mm/protocal/protobuf/bfg:toByteArray	()[B
      //   82: astore_1
      //   83: iconst_0
      //   84: istore 4
      //   86: iload 4
      //   88: istore_3
      //   89: aload_0
      //   90: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   93: invokestatic 97	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   96: invokestatic 103	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
      //   99: ifne +32 -> 131
      //   102: iload 4
      //   104: istore_3
      //   105: aload_1
      //   106: invokestatic 103	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
      //   109: ifne +22 -> 131
      //   112: aload_0
      //   113: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   116: invokestatic 107	com/tencent/mm/sandbox/updater/b:k	(Lcom/tencent/mm/sandbox/updater/b;)I
      //   119: aload_0
      //   120: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   123: invokestatic 97	com/tencent/mm/sandbox/updater/b:j	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   126: aload_1
      //   127: invokestatic 113	com/tencent/mm/protocal/MMProtocalJni:genSignature	(I[B[B)I
      //   130: istore_3
      //   131: aload_1
      //   132: aload 10
      //   134: aload_0
      //   135: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   138: invokestatic 116	com/tencent/mm/sandbox/updater/b:l	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   141: iconst_0
      //   142: aload_0
      //   143: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   146: invokestatic 119	com/tencent/mm/sandbox/updater/b:m	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   149: invokestatic 124	com/tencent/mm/compatible/deviceinfo/q:XX	()Ljava/lang/String;
      //   152: aload_0
      //   153: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
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
      //   171: invokestatic 128	com/tencent/mm/protocal/MMProtocalJni:pack	([BLcom/tencent/mm/pointers/PByteArray;[BI[BLjava/lang/String;III[B[BIII)Z
      //   174: pop
      //   175: aconst_null
      //   176: astore 9
      //   178: aconst_null
      //   179: astore 7
      //   181: aconst_null
      //   182: astore 8
      //   184: aload_0
      //   185: new 59	java/lang/StringBuilder
      //   188: dup
      //   189: ldc 130
      //   191: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   194: aload_0
      //   195: getfield 44	com/tencent/mm/sandbox/updater/b$a:host	Ljava/lang/String;
      //   198: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   201: ldc 135
      //   203: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   206: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   209: aconst_null
      //   210: invokestatic 140	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
      //   213: putfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   216: aload_0
      //   217: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   220: ldc 142
      //   222: invokevirtual 147	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
      //   225: aload_0
      //   226: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   229: invokevirtual 150	com/tencent/mm/network/v:aLH	()V
      //   232: aload_0
      //   233: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   236: invokevirtual 153	com/tencent/mm/network/v:aLI	()V
      //   239: aload_0
      //   240: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   243: iconst_0
      //   244: invokevirtual 157	com/tencent/mm/network/v:setUseCaches	(Z)V
      //   247: aload_0
      //   248: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   251: ldc 159
      //   253: ldc 161
      //   255: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   258: aload_0
      //   259: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   262: ldc 166
      //   264: ldc 168
      //   266: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   269: aload_0
      //   270: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   273: ldc 170
      //   275: ldc 172
      //   277: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   280: aload_0
      //   281: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   284: ldc 174
      //   286: ldc 176
      //   288: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   291: aload_0
      //   292: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   295: ldc 178
      //   297: ldc 180
      //   299: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   302: aload_0
      //   303: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   306: ldc 182
      //   308: ldc 184
      //   310: invokevirtual 164	com/tencent/mm/network/v:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   313: aload_0
      //   314: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   317: sipush 15000
      //   320: invokevirtual 187	com/tencent/mm/network/v:setConnectTimeout	(I)V
      //   323: aload_0
      //   324: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   327: invokevirtual 190	com/tencent/mm/network/v:connect	()V
      //   330: aload_0
      //   331: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   334: invokevirtual 194	com/tencent/mm/network/v:getOutputStream	()Ljava/io/OutputStream;
      //   337: astore_1
      //   338: aload_1
      //   339: aload 10
      //   341: getfield 198	com/tencent/mm/pointers/PByteArray:value	[B
      //   344: invokevirtual 204	java/io/OutputStream:write	([B)V
      //   347: aload_1
      //   348: invokevirtual 207	java/io/OutputStream:flush	()V
      //   351: aload_0
      //   352: getfield 46	com/tencent/mm/sandbox/updater/b$a:Gls	Lcom/tencent/mm/sandbox/b$a;
      //   355: ldc2_w 208
      //   358: aload 10
      //   360: getfield 198	com/tencent/mm/pointers/PByteArray:value	[B
      //   363: arraylength
      //   364: i2l
      //   365: ladd
      //   366: invokeinterface 215 3 0
      //   371: aload_0
      //   372: aload_0
      //   373: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   376: invokevirtual 219	com/tencent/mm/network/v:getResponseCode	()I
      //   379: putfield 37	com/tencent/mm/sandbox/updater/b$a:Glw	I
      //   382: aload_0
      //   383: getfield 37	com/tencent/mm/sandbox/updater/b$a:Glw	I
      //   386: istore_2
      //   387: iload_2
      //   388: sipush 200
      //   391: if_icmpeq +93 -> 484
      //   394: aload_1
      //   395: ifnull +7 -> 402
      //   398: aload_1
      //   399: invokevirtual 222	java/io/OutputStream:close	()V
      //   402: aload_0
      //   403: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   406: ifnull +15 -> 421
      //   409: aload_0
      //   410: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   413: invokevirtual 225	com/tencent/mm/network/v:disconnect	()V
      //   416: aload_0
      //   417: aconst_null
      //   418: putfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   421: sipush 32661
      //   424: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   427: aconst_null
      //   428: areturn
      //   429: astore_1
      //   430: ldc 57
      //   432: ldc 227
      //   434: iconst_1
      //   435: anewarray 229	java/lang/Object
      //   438: dup
      //   439: iconst_0
      //   440: aload_1
      //   441: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   444: aastore
      //   445: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   448: ldc 57
      //   450: aload_1
      //   451: ldc 238
      //   453: iconst_0
      //   454: anewarray 229	java/lang/Object
      //   457: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   460: sipush 32661
      //   463: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   466: aconst_null
      //   467: areturn
      //   468: astore_1
      //   469: ldc 57
      //   471: aload_1
      //   472: ldc 238
      //   474: iconst_0
      //   475: anewarray 229	java/lang/Object
      //   478: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   481: goto -79 -> 402
      //   484: aload_0
      //   485: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   488: ldc 244
      //   490: invokevirtual 248	com/tencent/mm/network/v:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
      //   493: astore 7
      //   495: aload_0
      //   496: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   499: invokevirtual 252	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
      //   502: astore 9
      //   504: ldc2_w 208
      //   507: lstore 5
      //   509: aload 7
      //   511: ifnull +603 -> 1114
      //   514: aload 7
      //   516: ldc 254
      //   518: invokevirtual 260	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   521: ifeq +593 -> 1114
      //   524: new 262	java/util/zip/GZIPInputStream
      //   527: dup
      //   528: aload 9
      //   530: invokespecial 265	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   533: astore 7
      //   535: iconst_1
      //   536: istore_2
      //   537: new 267	java/io/ByteArrayOutputStream
      //   540: dup
      //   541: invokespecial 268	java/io/ByteArrayOutputStream:<init>	()V
      //   544: astore 8
      //   546: sipush 1024
      //   549: newarray byte
      //   551: astore 10
      //   553: aload 7
      //   555: aload 10
      //   557: invokevirtual 274	java/io/InputStream:read	([B)I
      //   560: istore_3
      //   561: iload_3
      //   562: ifle +22 -> 584
      //   565: aload 8
      //   567: aload 10
      //   569: iconst_0
      //   570: iload_3
      //   571: invokevirtual 277	java/io/ByteArrayOutputStream:write	([BII)V
      //   574: lload 5
      //   576: iload_3
      //   577: i2l
      //   578: ladd
      //   579: lstore 5
      //   581: goto -28 -> 553
      //   584: iload_2
      //   585: ifeq +200 -> 785
      //   588: aload 9
      //   590: invokevirtual 281	java/io/InputStream:markSupported	()Z
      //   593: ifeq +192 -> 785
      //   596: aload 9
      //   598: iconst_1
      //   599: invokevirtual 284	java/io/InputStream:mark	(I)V
      //   602: ldc2_w 208
      //   605: lstore 5
      //   607: aload 9
      //   609: aload 10
      //   611: invokevirtual 274	java/io/InputStream:read	([B)I
      //   614: istore_2
      //   615: iload_2
      //   616: ifle +13 -> 629
      //   619: lload 5
      //   621: iload_2
      //   622: i2l
      //   623: ladd
      //   624: lstore 5
      //   626: goto -19 -> 607
      //   629: aload_0
      //   630: getfield 46	com/tencent/mm/sandbox/updater/b$a:Gls	Lcom/tencent/mm/sandbox/b$a;
      //   633: lload 5
      //   635: invokeinterface 287 3 0
      //   640: new 80	com/tencent/mm/pointers/PByteArray
      //   643: dup
      //   644: invokespecial 81	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   647: astore 9
      //   649: new 80	com/tencent/mm/pointers/PByteArray
      //   652: dup
      //   653: invokespecial 81	com/tencent/mm/pointers/PByteArray:<init>	()V
      //   656: astore 10
      //   658: new 39	com/tencent/mm/pointers/PInt
      //   661: dup
      //   662: invokespecial 40	com/tencent/mm/pointers/PInt:<init>	()V
      //   665: astore 11
      //   667: new 39	com/tencent/mm/pointers/PInt
      //   670: dup
      //   671: iconst_0
      //   672: invokespecial 289	com/tencent/mm/pointers/PInt:<init>	(I)V
      //   675: astore 12
      //   677: new 39	com/tencent/mm/pointers/PInt
      //   680: dup
      //   681: sipush 255
      //   684: invokespecial 289	com/tencent/mm/pointers/PInt:<init>	(I)V
      //   687: astore 13
      //   689: aload 9
      //   691: aload 8
      //   693: invokevirtual 290	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   696: aload_0
      //   697: getfield 24	com/tencent/mm/sandbox/updater/b$a:Glv	Lcom/tencent/mm/sandbox/updater/b;
      //   700: invokestatic 116	com/tencent/mm/sandbox/updater/b:l	(Lcom/tencent/mm/sandbox/updater/b;)[B
      //   703: aload 10
      //   705: aload_0
      //   706: getfield 42	com/tencent/mm/sandbox/updater/b$a:Glx	Lcom/tencent/mm/pointers/PInt;
      //   709: aload 11
      //   711: aload 12
      //   713: aload 13
      //   715: invokestatic 294	com/tencent/mm/protocal/MMProtocalJni:unpack	(Lcom/tencent/mm/pointers/PByteArray;[B[BLcom/tencent/mm/pointers/PByteArray;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
      //   718: pop
      //   719: new 296	com/tencent/mm/protocal/protobuf/bfh
      //   722: dup
      //   723: invokespecial 297	com/tencent/mm/protocal/protobuf/bfh:<init>	()V
      //   726: aload 9
      //   728: getfield 198	com/tencent/mm/pointers/PByteArray:value	[B
      //   731: invokevirtual 301	com/tencent/mm/protocal/protobuf/bfh:parseFrom	([B)Lcom/tencent/mm/bw/a;
      //   734: checkcast 296	com/tencent/mm/protocal/protobuf/bfh
      //   737: astore 8
      //   739: aload_1
      //   740: ifnull +7 -> 747
      //   743: aload_1
      //   744: invokevirtual 222	java/io/OutputStream:close	()V
      //   747: aload 7
      //   749: ifnull +8 -> 757
      //   752: aload 7
      //   754: invokevirtual 302	java/io/InputStream:close	()V
      //   757: aload_0
      //   758: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   761: ifnull +15 -> 776
      //   764: aload_0
      //   765: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   768: invokevirtual 225	com/tencent/mm/network/v:disconnect	()V
      //   771: aload_0
      //   772: aconst_null
      //   773: putfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   776: sipush 32661
      //   779: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   782: aload 8
      //   784: areturn
      //   785: aload_0
      //   786: getfield 46	com/tencent/mm/sandbox/updater/b$a:Gls	Lcom/tencent/mm/sandbox/b$a;
      //   789: lload 5
      //   791: invokeinterface 287 3 0
      //   796: goto -156 -> 640
      //   799: astore 9
      //   801: aload 7
      //   803: astore 8
      //   805: aload_1
      //   806: astore 7
      //   808: aload 8
      //   810: astore_1
      //   811: aload 9
      //   813: astore 8
      //   815: ldc 57
      //   817: ldc_w 304
      //   820: iconst_1
      //   821: anewarray 229	java/lang/Object
      //   824: dup
      //   825: iconst_0
      //   826: aload 8
      //   828: invokevirtual 232	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   831: aastore
      //   832: invokestatic 236	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   835: ldc 57
      //   837: aload 8
      //   839: ldc 238
      //   841: iconst_0
      //   842: anewarray 229	java/lang/Object
      //   845: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   848: aload_0
      //   849: iconst_m1
      //   850: putfield 37	com/tencent/mm/sandbox/updater/b$a:Glw	I
      //   853: aload 7
      //   855: ifnull +8 -> 863
      //   858: aload 7
      //   860: invokevirtual 222	java/io/OutputStream:close	()V
      //   863: aload_1
      //   864: ifnull +7 -> 871
      //   867: aload_1
      //   868: invokevirtual 302	java/io/InputStream:close	()V
      //   871: aload_0
      //   872: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   875: ifnull +15 -> 890
      //   878: aload_0
      //   879: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   882: invokevirtual 225	com/tencent/mm/network/v:disconnect	()V
      //   885: aload_0
      //   886: aconst_null
      //   887: putfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   890: sipush 32661
      //   893: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   896: aconst_null
      //   897: areturn
      //   898: astore_1
      //   899: ldc 57
      //   901: aload_1
      //   902: ldc 238
      //   904: iconst_0
      //   905: anewarray 229	java/lang/Object
      //   908: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   911: goto -164 -> 747
      //   914: astore_1
      //   915: ldc 57
      //   917: aload_1
      //   918: ldc 238
      //   920: iconst_0
      //   921: anewarray 229	java/lang/Object
      //   924: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   927: goto -170 -> 757
      //   930: astore 7
      //   932: ldc 57
      //   934: aload 7
      //   936: ldc 238
      //   938: iconst_0
      //   939: anewarray 229	java/lang/Object
      //   942: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   945: goto -82 -> 863
      //   948: astore_1
      //   949: ldc 57
      //   951: aload_1
      //   952: ldc 238
      //   954: iconst_0
      //   955: anewarray 229	java/lang/Object
      //   958: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   961: goto -90 -> 871
      //   964: astore_1
      //   965: aload 9
      //   967: astore 7
      //   969: aload 7
      //   971: ifnull +8 -> 979
      //   974: aload 7
      //   976: invokevirtual 222	java/io/OutputStream:close	()V
      //   979: aload 8
      //   981: ifnull +8 -> 989
      //   984: aload 8
      //   986: invokevirtual 302	java/io/InputStream:close	()V
      //   989: aload_0
      //   990: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   993: ifnull +15 -> 1008
      //   996: aload_0
      //   997: getfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   1000: invokevirtual 225	com/tencent/mm/network/v:disconnect	()V
      //   1003: aload_0
      //   1004: aconst_null
      //   1005: putfield 35	com/tencent/mm/sandbox/updater/b$a:vVJ	Lcom/tencent/mm/network/v;
      //   1008: sipush 32661
      //   1011: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1014: aload_1
      //   1015: athrow
      //   1016: astore 7
      //   1018: ldc 57
      //   1020: aload 7
      //   1022: ldc 238
      //   1024: iconst_0
      //   1025: anewarray 229	java/lang/Object
      //   1028: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1031: goto -52 -> 979
      //   1034: astore 7
      //   1036: ldc 57
      //   1038: aload 7
      //   1040: ldc 238
      //   1042: iconst_0
      //   1043: anewarray 229	java/lang/Object
      //   1046: invokestatic 242	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1049: goto -60 -> 989
      //   1052: astore 9
      //   1054: aload_1
      //   1055: astore 7
      //   1057: aload 9
      //   1059: astore_1
      //   1060: goto -91 -> 969
      //   1063: astore 8
      //   1065: aload_1
      //   1066: astore 9
      //   1068: aload 8
      //   1070: astore_1
      //   1071: aload 7
      //   1073: astore 8
      //   1075: aload 9
      //   1077: astore 7
      //   1079: goto -110 -> 969
      //   1082: astore 9
      //   1084: aload_1
      //   1085: astore 8
      //   1087: aload 9
      //   1089: astore_1
      //   1090: goto -121 -> 969
      //   1093: astore 8
      //   1095: aconst_null
      //   1096: astore_1
      //   1097: goto -282 -> 815
      //   1100: astore 8
      //   1102: aconst_null
      //   1103: astore 9
      //   1105: aload_1
      //   1106: astore 7
      //   1108: aload 9
      //   1110: astore_1
      //   1111: goto -296 -> 815
      //   1114: iconst_0
      //   1115: istore_2
      //   1116: aload 9
      //   1118: astore 7
      //   1120: goto -583 -> 537
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1123	0	this	a
      //   0	1123	1	paramVarArgs	bfg[]
      //   68	1048	2	i	int
      //   88	489	3	j	int
      //   84	19	4	k	int
      //   507	283	5	l	long
      //   179	680	7	localObject1	Object
      //   930	5	7	localIOException1	java.io.IOException
      //   967	8	7	localException1	Exception
      //   1016	5	7	localIOException2	java.io.IOException
      //   1034	5	7	localIOException3	java.io.IOException
      //   1055	64	7	localObject2	Object
      //   182	803	8	localObject3	Object
      //   1063	6	8	localObject4	Object
      //   1073	13	8	localObject5	Object
      //   1093	1	8	localException2	Exception
      //   1100	1	8	localException3	Exception
      //   176	551	9	localObject6	Object
      //   799	167	9	localException4	Exception
      //   1052	6	9	localObject7	Object
      //   1066	10	9	arrayOfbfg	bfg[]
      //   1082	6	9	localObject8	Object
      //   1103	14	9	localObject9	Object
      //   64	640	10	localObject10	Object
      //   665	45	11	localPInt1	PInt
      //   675	37	12	localPInt2	PInt
      //   687	27	13	localPInt3	PInt
      // Exception table:
      //   from	to	target	type
      //   78	83	429	java/lang/Exception
      //   89	102	429	java/lang/Exception
      //   105	131	429	java/lang/Exception
      //   131	175	429	java/lang/Exception
      //   398	402	468	java/io/IOException
      //   537	553	799	java/lang/Exception
      //   553	561	799	java/lang/Exception
      //   565	574	799	java/lang/Exception
      //   588	602	799	java/lang/Exception
      //   607	615	799	java/lang/Exception
      //   629	640	799	java/lang/Exception
      //   640	739	799	java/lang/Exception
      //   785	796	799	java/lang/Exception
      //   743	747	898	java/io/IOException
      //   752	757	914	java/io/IOException
      //   858	863	930	java/io/IOException
      //   867	871	948	java/io/IOException
      //   184	338	964	finally
      //   974	979	1016	java/io/IOException
      //   984	989	1034	java/io/IOException
      //   338	387	1052	finally
      //   484	504	1052	finally
      //   514	535	1052	finally
      //   537	553	1063	finally
      //   553	561	1063	finally
      //   565	574	1063	finally
      //   588	602	1063	finally
      //   607	615	1063	finally
      //   629	640	1063	finally
      //   640	739	1063	finally
      //   785	796	1063	finally
      //   815	853	1082	finally
      //   184	338	1093	java/lang/Exception
      //   338	387	1100	java/lang/Exception
      //   484	504	1100	java/lang/Exception
      //   514	535	1100	java/lang/Exception
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32662);
      ac.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
      if (this.vVJ != null) {
        this.vVJ.disconnect();
      }
      AppMethodBeat.o(32662);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.b
 * JD-Core Version:    0.7.0.1
 */