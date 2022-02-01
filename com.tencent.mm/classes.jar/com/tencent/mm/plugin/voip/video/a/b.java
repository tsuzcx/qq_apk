package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.e;
import com.tencent.mm.cm.a.j;
import com.tencent.mm.media.g.c;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.voip.video.render.n;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public final class b
{
  public static final float[] UPe = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] nFt = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] nFu = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  int UNp;
  public byte[] UPA;
  public byte[] UPB;
  private com.tencent.mm.plugin.voip.video.b.a UPC;
  public n UPD;
  public int UPE;
  public j UPF;
  private int UPG;
  private float UPH;
  private FloatBuffer UPI;
  private FloatBuffer UPJ;
  public e UPK;
  public d UPf;
  public d UPg;
  public int UPh;
  public d UPi;
  public int UPj;
  public int UPk;
  public int UPl;
  public int UPm;
  public FloatBuffer UPn;
  public FloatBuffer UPo;
  private ByteBuffer UPp;
  public float[] UPq;
  public float[] UPr;
  public com.tencent.mm.media.g.a UPs;
  public com.tencent.mm.media.g.a UPt;
  public d UPu;
  public d UPv;
  private int UPw;
  private int UPx;
  public volatile a UPy;
  private boolean UPz;
  private int hYK;
  public volatile boolean mGp;
  public FloatBuffer mVU;
  public FloatBuffer mVV;
  public d mWs;
  private int mbM;
  private int mbN;
  public int nEC;
  public int nED;
  public int nEE;
  public int nEF;
  public int nEI;
  private ByteBuffer nEJ;
  public int nEP;
  private ByteBuffer nEQ;
  private boolean nvG;
  private int orientation;
  private int qpD;
  private int qpE;
  private float[] qpI;
  public float[] qpK;
  
  public b()
  {
    AppMethodBeat.i(115706);
    this.qpI = new float[16];
    this.qpK = nFt;
    this.UPq = nFt;
    this.UPy = null;
    this.UPz = false;
    this.UPC = new com.tencent.mm.plugin.voip.video.b.a(this.qpD, this.qpE, 2);
    this.UPG = 5;
    this.UPH = 0.0F;
    this.mGp = false;
    AppMethodBeat.o(115706);
  }
  
  private static int aD(String paramString, int paramInt)
  {
    AppMethodBeat.i(115711);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      Log.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(115711);
      return 0;
    }
    AppMethodBeat.o(115711);
    return paramInt;
  }
  
  public static int aN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115712);
    int[] arrayOfInt = new int[1];
    int i = aD(paramString1, 35633);
    if (i == 0)
    {
      Log.e("MicroMsg.FilterRenderer", "load vertex shader failed");
      AppMethodBeat.o(115712);
      return 0;
    }
    int j = aD(paramString2, 35632);
    if (j == 0)
    {
      Log.e("MicroMsg.FilterRenderer", "load fragment shader failed");
      AppMethodBeat.o(115712);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      Log.e("MicroMsg.FilterRenderer", "link program failed");
      AppMethodBeat.o(115712);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(115712);
    return k;
  }
  
  public static d icO()
  {
    AppMethodBeat.i(115710);
    d locald = c.d(true, 14L);
    AppMethodBeat.o(115710);
    return locald;
  }
  
  public static com.tencent.mm.media.g.a icP()
  {
    AppMethodBeat.i(115713);
    Object localObject = c.nAB;
    localObject = c.hX(14L);
    AppMethodBeat.o(115713);
    return localObject;
  }
  
  /* Error */
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 218
    //   4: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   11: iload_2
    //   12: if_icmpne +2293 -> 2305
    //   15: aload_0
    //   16: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   19: iload_3
    //   20: if_icmpne +2285 -> 2305
    //   23: aload_0
    //   24: getfield 220	com/tencent/mm/plugin/voip/video/a/b:orientation	I
    //   27: iload 6
    //   29: if_icmpeq +2270 -> 2299
    //   32: goto +2273 -> 2305
    //   35: aload_0
    //   36: getfield 222	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   39: ifeq +50 -> 89
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 224	com/tencent/mm/plugin/voip/video/a/b:UPF	Lcom/tencent/mm/cm/a/j;
    //   47: aload_1
    //   48: iload_2
    //   49: iload_3
    //   50: invokevirtual 230	com/tencent/mm/cm/a/j:Q	([BII)I
    //   53: putfield 118	com/tencent/mm/plugin/voip/video/a/b:UPG	I
    //   56: aload_0
    //   57: aload_0
    //   58: getfield 224	com/tencent/mm/plugin/voip/video/a/b:UPF	Lcom/tencent/mm/cm/a/j;
    //   61: invokevirtual 234	com/tencent/mm/cm/a/j:jLL	()F
    //   64: putfield 120	com/tencent/mm/plugin/voip/video/a/b:UPH	F
    //   67: aload_0
    //   68: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   71: aload_0
    //   72: getfield 118	com/tencent/mm/plugin/voip/video/a/b:UPG	I
    //   75: invokevirtual 241	com/tencent/mm/cm/a/e:aFK	(I)V
    //   78: aload_0
    //   79: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   82: aload_0
    //   83: getfield 120	com/tencent/mm/plugin/voip/video/a/b:UPH	F
    //   86: invokevirtual 245	com/tencent/mm/cm/a/e:er	(F)V
    //   89: aload_0
    //   90: iload_2
    //   91: putfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   94: aload_0
    //   95: iload_3
    //   96: putfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   99: aload_0
    //   100: iload 6
    //   102: putfield 220	com/tencent/mm/plugin/voip/video/a/b:orientation	I
    //   105: iload 4
    //   107: iconst_2
    //   108: ishr
    //   109: iconst_3
    //   110: iand
    //   111: istore_2
    //   112: iload_2
    //   113: iconst_3
    //   114: if_icmpne +1443 -> 1557
    //   117: aload_0
    //   118: sipush 270
    //   121: putfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   124: goto +2187 -> 2311
    //   127: aload_0
    //   128: iload 8
    //   130: putfield 249	com/tencent/mm/plugin/voip/video/a/b:nvG	Z
    //   133: getstatic 254	com/tencent/mm/plugin/voip/video/OpenGlRender:UNe	I
    //   136: iconst_1
    //   137: if_icmpeq +1445 -> 1582
    //   140: iconst_1
    //   141: istore 8
    //   143: aload_0
    //   144: iload 8
    //   146: putfield 105	com/tencent/mm/plugin/voip/video/a/b:UPz	Z
    //   149: aload_0
    //   150: iload 5
    //   152: putfield 256	com/tencent/mm/plugin/voip/video/a/b:UNp	I
    //   155: aload_0
    //   156: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   159: ifnonnull +43 -> 202
    //   162: iload 5
    //   164: ifeq +38 -> 202
    //   167: aload_0
    //   168: getfield 222	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   171: ifeq +1417 -> 1588
    //   174: aload_0
    //   175: new 258	com/tencent/mm/plugin/voip/video/a/a
    //   178: dup
    //   179: invokespecial 259	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   182: putfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   185: aload_0
    //   186: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   189: aload_0
    //   190: getfield 261	com/tencent/mm/plugin/voip/video/a/b:UPv	Lcom/tencent/mm/media/g/d;
    //   193: aload_0
    //   194: getfield 263	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   197: iload 5
    //   199: invokevirtual 267	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   202: fconst_0
    //   203: fconst_0
    //   204: fconst_0
    //   205: fconst_0
    //   206: invokestatic 271	android/opengl/GLES20:glClearColor	(FFFF)V
    //   209: sipush 16640
    //   212: invokestatic 274	android/opengl/GLES20:glClear	(I)V
    //   215: aload_0
    //   216: getfield 105	com/tencent/mm/plugin/voip/video/a/b:UPz	Z
    //   219: ifeq +1430 -> 1649
    //   222: aload_0
    //   223: getfield 276	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   226: ifeq +557 -> 783
    //   229: aload_0
    //   230: getfield 278	com/tencent/mm/plugin/voip/video/a/b:UPf	Lcom/tencent/mm/media/g/d;
    //   233: ifnull +550 -> 783
    //   236: aload_0
    //   237: getfield 280	com/tencent/mm/plugin/voip/video/a/b:UPg	Lcom/tencent/mm/media/g/d;
    //   240: ifnull +543 -> 783
    //   243: aload_0
    //   244: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   247: ifle +536 -> 783
    //   250: aload_0
    //   251: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   254: ifle +529 -> 783
    //   257: aload_1
    //   258: ifnull +525 -> 783
    //   261: aload_0
    //   262: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   265: ifnull +50 -> 315
    //   268: aload_0
    //   269: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   272: ifnull +43 -> 315
    //   275: aload_0
    //   276: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   279: invokevirtual 289	java/nio/ByteBuffer:capacity	()I
    //   282: aload_0
    //   283: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   286: aload_0
    //   287: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   290: imul
    //   291: if_icmpne +24 -> 315
    //   294: aload_0
    //   295: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   298: invokevirtual 289	java/nio/ByteBuffer:capacity	()I
    //   301: aload_0
    //   302: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   305: aload_0
    //   306: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   309: imul
    //   310: iconst_2
    //   311: idiv
    //   312: if_icmpeq +59 -> 371
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   320: aload_0
    //   321: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   324: imul
    //   325: invokestatic 293	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   328: putfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   331: aload_0
    //   332: aload_0
    //   333: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   336: aload_0
    //   337: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   340: imul
    //   341: iconst_2
    //   342: idiv
    //   343: invokestatic 293	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   346: putfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   349: aload_0
    //   350: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   353: invokestatic 299	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   356: invokevirtual 303	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   359: pop
    //   360: aload_0
    //   361: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   364: invokestatic 299	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   367: invokevirtual 303	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   370: pop
    //   371: aload_0
    //   372: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   375: aload_1
    //   376: iconst_0
    //   377: aload_0
    //   378: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   381: aload_0
    //   382: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   385: imul
    //   386: invokevirtual 307	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   389: pop
    //   390: aload_0
    //   391: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   394: iconst_0
    //   395: invokevirtual 311	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   398: pop
    //   399: aload_0
    //   400: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   403: aload_1
    //   404: aload_0
    //   405: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   408: aload_0
    //   409: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   412: imul
    //   413: aload_0
    //   414: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   417: aload_0
    //   418: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   421: imul
    //   422: iconst_2
    //   423: idiv
    //   424: invokevirtual 307	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   427: pop
    //   428: aload_0
    //   429: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   432: iconst_0
    //   433: invokevirtual 311	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   436: pop
    //   437: aload_0
    //   438: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   441: sipush 180
    //   444: if_icmpeq +10 -> 454
    //   447: aload_0
    //   448: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   451: ifne +1168 -> 1619
    //   454: aload_0
    //   455: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   458: istore_2
    //   459: aload_0
    //   460: iload_2
    //   461: putfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   464: aload_0
    //   465: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   468: sipush 180
    //   471: if_icmpeq +10 -> 481
    //   474: aload_0
    //   475: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   478: ifne +1149 -> 1627
    //   481: aload_0
    //   482: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   485: istore_2
    //   486: aload_0
    //   487: iload_2
    //   488: putfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   491: aload_0
    //   492: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   495: aload_0
    //   496: getfield 319	com/tencent/mm/plugin/voip/video/a/b:UPs	Lcom/tencent/mm/media/g/a;
    //   499: aload_0
    //   500: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   503: aload_0
    //   504: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   507: invokevirtual 324	com/tencent/mm/media/g/d:a	(Lcom/tencent/mm/media/g/a;II)V
    //   510: iconst_0
    //   511: iconst_0
    //   512: aload_0
    //   513: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   516: aload_0
    //   517: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   520: invokestatic 328	android/opengl/GLES20:glViewport	(IIII)V
    //   523: aload_0
    //   524: getfield 276	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   527: invokestatic 331	android/opengl/GLES20:glUseProgram	(I)V
    //   530: ldc_w 332
    //   533: invokestatic 335	android/opengl/GLES20:glActiveTexture	(I)V
    //   536: aload_0
    //   537: getfield 278	com/tencent/mm/plugin/voip/video/a/b:UPf	Lcom/tencent/mm/media/g/d;
    //   540: aload_0
    //   541: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   544: aload_0
    //   545: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   548: sipush 6409
    //   551: aload_0
    //   552: getfield 282	com/tencent/mm/plugin/voip/video/a/b:nEJ	Ljava/nio/ByteBuffer;
    //   555: sipush 9729
    //   558: ldc_w 336
    //   561: invokevirtual 339	com/tencent/mm/media/g/d:a	(IIILjava/nio/Buffer;II)V
    //   564: aload_0
    //   565: getfield 341	com/tencent/mm/plugin/voip/video/a/b:nEF	I
    //   568: iconst_0
    //   569: invokestatic 344	android/opengl/GLES20:glUniform1i	(II)V
    //   572: ldc_w 345
    //   575: invokestatic 335	android/opengl/GLES20:glActiveTexture	(I)V
    //   578: aload_0
    //   579: getfield 280	com/tencent/mm/plugin/voip/video/a/b:UPg	Lcom/tencent/mm/media/g/d;
    //   582: aload_0
    //   583: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   586: iconst_2
    //   587: idiv
    //   588: aload_0
    //   589: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   592: iconst_2
    //   593: idiv
    //   594: sipush 6410
    //   597: aload_0
    //   598: getfield 284	com/tencent/mm/plugin/voip/video/a/b:nEQ	Ljava/nio/ByteBuffer;
    //   601: sipush 9729
    //   604: ldc_w 336
    //   607: invokevirtual 339	com/tencent/mm/media/g/d:a	(IIILjava/nio/Buffer;II)V
    //   610: aload_0
    //   611: getfield 347	com/tencent/mm/plugin/voip/video/a/b:nEP	I
    //   614: iconst_1
    //   615: invokestatic 344	android/opengl/GLES20:glUniform1i	(II)V
    //   618: aload_0
    //   619: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   622: iconst_0
    //   623: invokestatic 353	android/opengl/Matrix:setIdentityM	([FI)V
    //   626: aload_0
    //   627: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   630: iconst_0
    //   631: aload_0
    //   632: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   635: i2f
    //   636: fconst_0
    //   637: fconst_0
    //   638: ldc 78
    //   640: invokestatic 357	android/opengl/Matrix:setRotateM	([FIFFFF)V
    //   643: aload_0
    //   644: getfield 249	com/tencent/mm/plugin/voip/video/a/b:nvG	Z
    //   647: ifeq +988 -> 1635
    //   650: aload_0
    //   651: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   654: iconst_0
    //   655: ldc 78
    //   657: fconst_1
    //   658: fconst_1
    //   659: invokestatic 361	android/opengl/Matrix:scaleM	([FIFFF)V
    //   662: aload_0
    //   663: getfield 363	com/tencent/mm/plugin/voip/video/a/b:nEI	I
    //   666: iconst_1
    //   667: iconst_0
    //   668: aload_0
    //   669: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   672: iconst_0
    //   673: invokestatic 367	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   676: aload_0
    //   677: getfield 369	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   680: iconst_0
    //   681: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   684: pop
    //   685: aload_0
    //   686: getfield 374	com/tencent/mm/plugin/voip/video/a/b:nEE	I
    //   689: iconst_2
    //   690: sipush 5126
    //   693: iconst_0
    //   694: iconst_0
    //   695: aload_0
    //   696: getfield 369	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   699: invokestatic 378	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   702: aload_0
    //   703: getfield 374	com/tencent/mm/plugin/voip/video/a/b:nEE	I
    //   706: invokestatic 381	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   709: aload_0
    //   710: getfield 383	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   713: iconst_0
    //   714: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   717: pop
    //   718: aload_0
    //   719: getfield 385	com/tencent/mm/plugin/voip/video/a/b:nED	I
    //   722: iconst_2
    //   723: sipush 5126
    //   726: iconst_0
    //   727: iconst_0
    //   728: aload_0
    //   729: getfield 383	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   732: invokestatic 378	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   735: aload_0
    //   736: getfield 385	com/tencent/mm/plugin/voip/video/a/b:nED	I
    //   739: invokestatic 381	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   742: iconst_5
    //   743: iconst_0
    //   744: iconst_4
    //   745: invokestatic 388	android/opengl/GLES20:glDrawArrays	(III)V
    //   748: aload_0
    //   749: getfield 374	com/tencent/mm/plugin/voip/video/a/b:nEE	I
    //   752: invokestatic 391	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   755: aload_0
    //   756: getfield 385	com/tencent/mm/plugin/voip/video/a/b:nED	I
    //   759: invokestatic 391	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   762: sipush 3553
    //   765: iconst_0
    //   766: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   769: ldc_w 395
    //   772: iconst_0
    //   773: invokestatic 398	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   776: iconst_0
    //   777: invokestatic 331	android/opengl/GLES20:glUseProgram	(I)V
    //   780: invokestatic 401	android/opengl/GLES20:glFinish	()V
    //   783: iload 5
    //   785: ifeq +105 -> 890
    //   788: aload_0
    //   789: getfield 403	com/tencent/mm/plugin/voip/video/a/b:UPA	[B
    //   792: ifnull +8 -> 800
    //   795: iload 7
    //   797: ifeq +93 -> 890
    //   800: ldc 166
    //   802: ldc_w 405
    //   805: iconst_5
    //   806: anewarray 4	java/lang/Object
    //   809: dup
    //   810: iconst_0
    //   811: aload_0
    //   812: invokevirtual 408	java/lang/Object:hashCode	()I
    //   815: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   818: aastore
    //   819: dup
    //   820: iconst_1
    //   821: aload_0
    //   822: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   825: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   828: aastore
    //   829: dup
    //   830: iconst_2
    //   831: aload_0
    //   832: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   835: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   838: aastore
    //   839: dup
    //   840: iconst_3
    //   841: aload_0
    //   842: getfield 416	com/tencent/mm/plugin/voip/video/a/b:mbM	I
    //   845: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   848: aastore
    //   849: dup
    //   850: iconst_4
    //   851: aload_0
    //   852: getfield 418	com/tencent/mm/plugin/voip/video/a/b:mbN	I
    //   855: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: aastore
    //   859: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   862: aload_0
    //   863: aload_0
    //   864: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   867: aload_0
    //   868: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   871: imul
    //   872: iconst_4
    //   873: imul
    //   874: newarray byte
    //   876: putfield 403	com/tencent/mm/plugin/voip/video/a/b:UPA	[B
    //   879: aload_0
    //   880: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   883: aload_0
    //   884: getfield 403	com/tencent/mm/plugin/voip/video/a/b:UPA	[B
    //   887: putfield 424	com/tencent/mm/plugin/voip/video/a/a:UPa	[B
    //   890: aload_0
    //   891: getfield 222	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   894: ifeq +44 -> 938
    //   897: aload_0
    //   898: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   901: ifnull +37 -> 938
    //   904: aload_0
    //   905: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   908: aload_0
    //   909: getfield 261	com/tencent/mm/plugin/voip/video/a/b:UPv	Lcom/tencent/mm/media/g/d;
    //   912: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   915: invokevirtual 430	com/tencent/mm/cm/a/e:aFN	(I)V
    //   918: iload 7
    //   920: ifeq +18 -> 938
    //   923: aload_0
    //   924: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   927: aload_0
    //   928: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   931: aload_0
    //   932: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   935: invokevirtual 433	com/tencent/mm/cm/a/e:pg	(II)V
    //   938: aload_0
    //   939: getfield 222	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   942: ifeq +180 -> 1122
    //   945: aload_0
    //   946: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   949: ifnull +173 -> 1122
    //   952: aload_0
    //   953: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   956: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   959: istore_2
    //   960: getstatic 80	com/tencent/mm/plugin/voip/video/a/b:nFt	[F
    //   963: astore_1
    //   964: getstatic 82	com/tencent/mm/plugin/voip/video/a/b:nFu	[F
    //   967: astore 11
    //   969: getstatic 84	com/tencent/mm/plugin/voip/video/a/b:UPe	[F
    //   972: astore 12
    //   974: aload_0
    //   975: getfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   978: ifnull +15 -> 993
    //   981: aload_0
    //   982: getfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   985: invokevirtual 436	java/nio/FloatBuffer:capacity	()I
    //   988: aload_1
    //   989: arraylength
    //   990: if_icmpeq +23 -> 1013
    //   993: aload_0
    //   994: aload_1
    //   995: arraylength
    //   996: iconst_4
    //   997: imul
    //   998: invokestatic 293	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1001: invokestatic 299	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   1004: invokevirtual 303	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1007: invokevirtual 440	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   1010: putfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   1013: aload_0
    //   1014: getfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   1017: aload_1
    //   1018: invokevirtual 443	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   1026: iconst_0
    //   1027: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1030: pop
    //   1031: aload 11
    //   1033: aload 12
    //   1035: invokestatic 446	com/tencent/mm/cm/a/e:i	([F[F)V
    //   1038: aload_0
    //   1039: getfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1042: ifnull +16 -> 1058
    //   1045: aload_0
    //   1046: getfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1049: invokevirtual 436	java/nio/FloatBuffer:capacity	()I
    //   1052: aload 12
    //   1054: arraylength
    //   1055: if_icmpeq +24 -> 1079
    //   1058: aload_0
    //   1059: aload 12
    //   1061: arraylength
    //   1062: iconst_4
    //   1063: imul
    //   1064: invokestatic 293	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1067: invokestatic 299	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   1070: invokevirtual 303	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1073: invokevirtual 440	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   1076: putfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1079: aload_0
    //   1080: getfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1083: aload 12
    //   1085: invokevirtual 443	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   1088: pop
    //   1089: aload_0
    //   1090: getfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1093: iconst_0
    //   1094: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1097: pop
    //   1098: aload_0
    //   1099: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   1102: aload_0
    //   1103: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   1106: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   1109: iload_2
    //   1110: iload_2
    //   1111: aload_0
    //   1112: getfield 435	com/tencent/mm/plugin/voip/video/a/b:UPI	Ljava/nio/FloatBuffer;
    //   1115: aload_0
    //   1116: getfield 448	com/tencent/mm/plugin/voip/video/a/b:UPJ	Ljava/nio/FloatBuffer;
    //   1119: invokevirtual 451	com/tencent/mm/cm/a/e:a	(IIILjava/nio/FloatBuffer;Ljava/nio/FloatBuffer;)V
    //   1122: iload 5
    //   1124: ifeq +1133 -> 2257
    //   1127: aload_0
    //   1128: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1131: astore_1
    //   1132: aload_0
    //   1133: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   1136: istore_2
    //   1137: aload_0
    //   1138: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   1141: istore_3
    //   1142: iload_3
    //   1143: aload_1
    //   1144: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   1147: if_icmpne +11 -> 1158
    //   1150: iload_2
    //   1151: aload_1
    //   1152: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   1155: if_icmpeq +30 -> 1185
    //   1158: ldc_w 459
    //   1161: ldc_w 461
    //   1164: iconst_2
    //   1165: anewarray 4	java/lang/Object
    //   1168: dup
    //   1169: iconst_0
    //   1170: iload_2
    //   1171: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1174: aastore
    //   1175: dup
    //   1176: iconst_1
    //   1177: iload_3
    //   1178: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1181: aastore
    //   1182: invokestatic 421	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1185: aload_1
    //   1186: iload_2
    //   1187: putfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   1190: aload_1
    //   1191: iload_3
    //   1192: putfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   1195: aload_1
    //   1196: getfield 465	com/tencent/mm/plugin/voip/video/a/a:muW	Lcom/tencent/mm/plugin/xlabeffect/k;
    //   1199: ifnull +12 -> 1211
    //   1202: aload_1
    //   1203: getfield 465	com/tencent/mm/plugin/voip/video/a/a:muW	Lcom/tencent/mm/plugin/xlabeffect/k;
    //   1206: iload_2
    //   1207: iload_3
    //   1208: invokevirtual 470	com/tencent/mm/plugin/xlabeffect/k:setSize	(II)V
    //   1211: aload_1
    //   1212: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   1215: iload_2
    //   1216: iload_3
    //   1217: invokevirtual 479	com/tencent/mm/media/j/b/a:el	(II)V
    //   1220: aload_1
    //   1221: aconst_null
    //   1222: putfield 482	com/tencent/mm/plugin/voip/video/a/a:UPb	Ljava/nio/ByteBuffer;
    //   1225: aload_0
    //   1226: getfield 222	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   1229: ifeq +852 -> 2081
    //   1232: aload_0
    //   1233: getfield 236	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   1236: ifnull +845 -> 2081
    //   1239: aload_0
    //   1240: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1243: aload_0
    //   1244: getfield 261	com/tencent/mm/plugin/voip/video/a/b:UPv	Lcom/tencent/mm/media/g/d;
    //   1247: putfield 485	com/tencent/mm/plugin/voip/video/a/a:ntz	Lcom/tencent/mm/media/g/d;
    //   1250: aload_0
    //   1251: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1254: astore_1
    //   1255: aload_0
    //   1256: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1259: istore_2
    //   1260: ldc_w 459
    //   1263: ldc_w 487
    //   1266: iconst_1
    //   1267: anewarray 4	java/lang/Object
    //   1270: dup
    //   1271: iconst_0
    //   1272: iload_2
    //   1273: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1276: aastore
    //   1277: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1280: aload_1
    //   1281: iload_2
    //   1282: putfield 492	com/tencent/mm/plugin/voip/video/a/a:UPc	I
    //   1285: aload_1
    //   1286: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   1289: iload_2
    //   1290: invokevirtual 495	com/tencent/mm/media/j/b/a:th	(I)V
    //   1293: aload_0
    //   1294: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1297: astore_1
    //   1298: invokestatic 501	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   1301: lstore 9
    //   1303: aload_1
    //   1304: getfield 465	com/tencent/mm/plugin/voip/video/a/a:muW	Lcom/tencent/mm/plugin/xlabeffect/k;
    //   1307: aload_1
    //   1308: getfield 485	com/tencent/mm/plugin/voip/video/a/a:ntz	Lcom/tencent/mm/media/g/d;
    //   1311: invokevirtual 504	com/tencent/mm/plugin/xlabeffect/k:d	(Lcom/tencent/mm/media/g/d;)V
    //   1314: ldc_w 395
    //   1317: iconst_0
    //   1318: invokestatic 398	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1321: sipush 3553
    //   1324: iconst_0
    //   1325: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   1328: aload_1
    //   1329: getfield 507	com/tencent/mm/plugin/voip/video/a/a:mVc	Lcom/tencent/mm/media/g/d;
    //   1332: aload_1
    //   1333: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   1336: aload_1
    //   1337: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   1340: sipush 6408
    //   1343: aconst_null
    //   1344: sipush 9729
    //   1347: sipush 10497
    //   1350: invokevirtual 339	com/tencent/mm/media/g/d:a	(IIILjava/nio/Buffer;II)V
    //   1353: iconst_0
    //   1354: iconst_0
    //   1355: aload_1
    //   1356: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   1359: aload_1
    //   1360: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   1363: invokestatic 328	android/opengl/GLES20:glViewport	(IIII)V
    //   1366: aload_1
    //   1367: getfield 465	com/tencent/mm/plugin/voip/video/a/a:muW	Lcom/tencent/mm/plugin/xlabeffect/k;
    //   1370: aload_1
    //   1371: getfield 485	com/tencent/mm/plugin/voip/video/a/a:ntz	Lcom/tencent/mm/media/g/d;
    //   1374: aload_1
    //   1375: getfield 507	com/tencent/mm/plugin/voip/video/a/a:mVc	Lcom/tencent/mm/media/g/d;
    //   1378: iconst_0
    //   1379: bipush 48
    //   1381: invokestatic 510	com/tencent/mm/plugin/xlabeffect/k:a	(Lcom/tencent/mm/plugin/xlabeffect/k;Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;ZI)I
    //   1384: pop
    //   1385: invokestatic 401	android/opengl/GLES20:glFinish	()V
    //   1388: ldc_w 395
    //   1391: iconst_0
    //   1392: invokestatic 398	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1395: sipush 3553
    //   1398: iconst_0
    //   1399: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   1402: aload_1
    //   1403: getfield 507	com/tencent/mm/plugin/voip/video/a/a:mVc	Lcom/tencent/mm/media/g/d;
    //   1406: ifnonnull +689 -> 2095
    //   1409: ldc_w 459
    //   1412: ldc_w 512
    //   1415: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1418: ldc_w 459
    //   1421: ldc_w 514
    //   1424: iconst_1
    //   1425: anewarray 4	java/lang/Object
    //   1428: dup
    //   1429: iconst_0
    //   1430: lload 9
    //   1432: invokestatic 518	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   1435: invokestatic 523	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1438: aastore
    //   1439: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1442: aload_0
    //   1443: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1446: aload_0
    //   1447: getfield 263	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   1450: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   1453: invokevirtual 530	com/tencent/mm/plugin/voip/video/render/n:uc	(I)V
    //   1456: aload_0
    //   1457: getfield 249	com/tencent/mm/plugin/voip/video/a/b:nvG	Z
    //   1460: ifeq +874 -> 2334
    //   1463: iload 6
    //   1465: ifeq +862 -> 2327
    //   1468: iload 6
    //   1470: istore_2
    //   1471: iload 6
    //   1473: sipush 180
    //   1476: if_icmpne +6 -> 1482
    //   1479: goto +848 -> 2327
    //   1482: aload_0
    //   1483: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1486: iload_2
    //   1487: invokevirtual 531	com/tencent/mm/plugin/voip/video/render/n:th	(I)V
    //   1490: aload_0
    //   1491: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1494: iconst_1
    //   1495: invokevirtual 535	com/tencent/mm/plugin/voip/video/render/n:gr	(Z)V
    //   1498: aload_0
    //   1499: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1502: aload_0
    //   1503: getfield 416	com/tencent/mm/plugin/voip/video/a/b:mbM	I
    //   1506: aload_0
    //   1507: getfield 418	com/tencent/mm/plugin/voip/video/a/b:mbN	I
    //   1510: invokevirtual 538	com/tencent/mm/plugin/voip/video/render/n:ek	(II)V
    //   1513: aload_0
    //   1514: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1517: aload_0
    //   1518: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1521: aload_0
    //   1522: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1525: invokevirtual 539	com/tencent/mm/plugin/voip/video/render/n:el	(II)V
    //   1528: aload_0
    //   1529: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   1532: invokevirtual 542	com/tencent/mm/plugin/voip/video/render/n:bgE	()V
    //   1535: ldc_w 395
    //   1538: iconst_0
    //   1539: invokestatic 398	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1542: sipush 3553
    //   1545: iconst_0
    //   1546: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   1549: ldc 218
    //   1551: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1554: aload_0
    //   1555: monitorexit
    //   1556: return
    //   1557: iload_2
    //   1558: iconst_1
    //   1559: if_icmpne +752 -> 2311
    //   1562: aload_0
    //   1563: bipush 90
    //   1565: putfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1568: goto +743 -> 2311
    //   1571: astore_1
    //   1572: aload_0
    //   1573: monitorexit
    //   1574: aload_1
    //   1575: athrow
    //   1576: iconst_0
    //   1577: istore 8
    //   1579: goto -1452 -> 127
    //   1582: iconst_0
    //   1583: istore 8
    //   1585: goto -1442 -> 143
    //   1588: aload_0
    //   1589: new 258	com/tencent/mm/plugin/voip/video/a/a
    //   1592: dup
    //   1593: invokespecial 259	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   1596: putfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1599: aload_0
    //   1600: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   1603: aload_0
    //   1604: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   1607: aload_0
    //   1608: getfield 263	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   1611: iload 5
    //   1613: invokevirtual 267	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   1616: goto -1414 -> 202
    //   1619: aload_0
    //   1620: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1623: istore_2
    //   1624: goto -1165 -> 459
    //   1627: aload_0
    //   1628: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1631: istore_2
    //   1632: goto -1146 -> 486
    //   1635: aload_0
    //   1636: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   1639: iconst_0
    //   1640: fconst_1
    //   1641: fconst_1
    //   1642: fconst_1
    //   1643: invokestatic 361	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1646: goto -984 -> 662
    //   1649: aload_0
    //   1650: getfield 544	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   1653: ifeq -870 -> 783
    //   1656: aload_0
    //   1657: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   1660: ifnull -877 -> 783
    //   1663: aload_0
    //   1664: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1667: ifle -884 -> 783
    //   1670: aload_0
    //   1671: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1674: ifle -891 -> 783
    //   1677: aload_1
    //   1678: ifnull -895 -> 783
    //   1681: aload_0
    //   1682: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1685: ifnull +24 -> 1709
    //   1688: aload_0
    //   1689: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1692: invokevirtual 289	java/nio/ByteBuffer:capacity	()I
    //   1695: aload_0
    //   1696: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1699: aload_0
    //   1700: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1703: imul
    //   1704: iconst_4
    //   1705: imul
    //   1706: if_icmpeq +32 -> 1738
    //   1709: aload_0
    //   1710: aload_0
    //   1711: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1714: aload_0
    //   1715: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1718: imul
    //   1719: iconst_4
    //   1720: imul
    //   1721: invokestatic 293	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1724: putfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1727: aload_0
    //   1728: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1731: invokestatic 299	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   1734: invokevirtual 303	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1737: pop
    //   1738: aload_0
    //   1739: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1742: aload_1
    //   1743: iconst_0
    //   1744: aload_0
    //   1745: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1748: aload_0
    //   1749: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1752: imul
    //   1753: iconst_4
    //   1754: imul
    //   1755: invokevirtual 307	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1758: pop
    //   1759: aload_0
    //   1760: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1763: iconst_0
    //   1764: invokevirtual 311	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1767: pop
    //   1768: aload_0
    //   1769: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1772: sipush 180
    //   1775: if_icmpeq +10 -> 1785
    //   1778: aload_0
    //   1779: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1782: ifne +283 -> 2065
    //   1785: aload_0
    //   1786: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   1789: istore_2
    //   1790: aload_0
    //   1791: iload_2
    //   1792: putfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   1795: aload_0
    //   1796: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1799: sipush 180
    //   1802: if_icmpeq +10 -> 1812
    //   1805: aload_0
    //   1806: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1809: ifne +264 -> 2073
    //   1812: aload_0
    //   1813: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   1816: istore_2
    //   1817: aload_0
    //   1818: iload_2
    //   1819: putfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   1822: aload_0
    //   1823: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   1826: aload_0
    //   1827: getfield 319	com/tencent/mm/plugin/voip/video/a/b:UPs	Lcom/tencent/mm/media/g/a;
    //   1830: aload_0
    //   1831: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   1834: aload_0
    //   1835: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   1838: invokevirtual 324	com/tencent/mm/media/g/d:a	(Lcom/tencent/mm/media/g/a;II)V
    //   1841: aload_0
    //   1842: getfield 544	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   1845: invokestatic 331	android/opengl/GLES20:glUseProgram	(I)V
    //   1848: ldc_w 332
    //   1851: invokestatic 335	android/opengl/GLES20:glActiveTexture	(I)V
    //   1854: sipush 3553
    //   1857: aload_0
    //   1858: getfield 548	com/tencent/mm/plugin/voip/video/a/b:UPi	Lcom/tencent/mm/media/g/d;
    //   1861: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   1864: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   1867: sipush 3553
    //   1870: iconst_0
    //   1871: sipush 6408
    //   1874: aload_0
    //   1875: getfield 313	com/tencent/mm/plugin/voip/video/a/b:UPw	I
    //   1878: aload_0
    //   1879: getfield 315	com/tencent/mm/plugin/voip/video/a/b:UPx	I
    //   1882: iconst_0
    //   1883: sipush 6408
    //   1886: sipush 5121
    //   1889: aload_0
    //   1890: getfield 546	com/tencent/mm/plugin/voip/video/a/b:UPp	Ljava/nio/ByteBuffer;
    //   1893: invokestatic 552	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   1896: aload_0
    //   1897: getfield 554	com/tencent/mm/plugin/voip/video/a/b:UPl	I
    //   1900: iconst_0
    //   1901: invokestatic 344	android/opengl/GLES20:glUniform1i	(II)V
    //   1904: aload_0
    //   1905: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   1908: iconst_0
    //   1909: invokestatic 353	android/opengl/Matrix:setIdentityM	([FI)V
    //   1912: aload_0
    //   1913: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   1916: iconst_0
    //   1917: aload_0
    //   1918: getfield 247	com/tencent/mm/plugin/voip/video/a/b:hYK	I
    //   1921: i2f
    //   1922: fconst_0
    //   1923: fconst_0
    //   1924: ldc 78
    //   1926: invokestatic 357	android/opengl/Matrix:setRotateM	([FIFFFF)V
    //   1929: aload_0
    //   1930: getfield 249	com/tencent/mm/plugin/voip/video/a/b:nvG	Z
    //   1933: ifeq +15 -> 1948
    //   1936: aload_0
    //   1937: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   1940: iconst_0
    //   1941: fconst_1
    //   1942: ldc 78
    //   1944: fconst_1
    //   1945: invokestatic 361	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1948: aload_0
    //   1949: getfield 556	com/tencent/mm/plugin/voip/video/a/b:UPm	I
    //   1952: iconst_1
    //   1953: iconst_0
    //   1954: aload_0
    //   1955: getfield 97	com/tencent/mm/plugin/voip/video/a/b:qpI	[F
    //   1958: iconst_0
    //   1959: invokestatic 367	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   1962: aload_0
    //   1963: getfield 369	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   1966: iconst_0
    //   1967: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1970: pop
    //   1971: aload_0
    //   1972: getfield 558	com/tencent/mm/plugin/voip/video/a/b:UPk	I
    //   1975: iconst_2
    //   1976: sipush 5126
    //   1979: iconst_0
    //   1980: iconst_0
    //   1981: aload_0
    //   1982: getfield 369	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   1985: invokestatic 378	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   1988: aload_0
    //   1989: getfield 558	com/tencent/mm/plugin/voip/video/a/b:UPk	I
    //   1992: invokestatic 381	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   1995: aload_0
    //   1996: getfield 383	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   1999: iconst_0
    //   2000: invokevirtual 372	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   2003: pop
    //   2004: aload_0
    //   2005: getfield 560	com/tencent/mm/plugin/voip/video/a/b:UPj	I
    //   2008: iconst_2
    //   2009: sipush 5126
    //   2012: iconst_0
    //   2013: iconst_0
    //   2014: aload_0
    //   2015: getfield 383	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   2018: invokestatic 378	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   2021: aload_0
    //   2022: getfield 560	com/tencent/mm/plugin/voip/video/a/b:UPj	I
    //   2025: invokestatic 381	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   2028: iconst_5
    //   2029: iconst_0
    //   2030: iconst_4
    //   2031: invokestatic 388	android/opengl/GLES20:glDrawArrays	(III)V
    //   2034: aload_0
    //   2035: getfield 558	com/tencent/mm/plugin/voip/video/a/b:UPk	I
    //   2038: invokestatic 391	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   2041: aload_0
    //   2042: getfield 560	com/tencent/mm/plugin/voip/video/a/b:UPj	I
    //   2045: invokestatic 391	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   2048: sipush 3553
    //   2051: iconst_0
    //   2052: invokestatic 394	android/opengl/GLES20:glBindTexture	(II)V
    //   2055: ldc_w 395
    //   2058: iconst_0
    //   2059: invokestatic 398	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   2062: goto -1279 -> 783
    //   2065: aload_0
    //   2066: getfield 111	com/tencent/mm/plugin/voip/video/a/b:qpE	I
    //   2069: istore_2
    //   2070: goto -280 -> 1790
    //   2073: aload_0
    //   2074: getfield 109	com/tencent/mm/plugin/voip/video/a/b:qpD	I
    //   2077: istore_2
    //   2078: goto -261 -> 1817
    //   2081: aload_0
    //   2082: getfield 103	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   2085: aload_0
    //   2086: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   2089: putfield 485	com/tencent/mm/plugin/voip/video/a/a:ntz	Lcom/tencent/mm/media/g/d;
    //   2092: goto -842 -> 1250
    //   2095: ldc_w 459
    //   2098: ldc_w 562
    //   2101: iconst_3
    //   2102: anewarray 4	java/lang/Object
    //   2105: dup
    //   2106: iconst_0
    //   2107: aload_1
    //   2108: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   2111: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2114: aastore
    //   2115: dup
    //   2116: iconst_1
    //   2117: aload_1
    //   2118: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   2121: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2124: aastore
    //   2125: dup
    //   2126: iconst_2
    //   2127: aload_1
    //   2128: getfield 492	com/tencent/mm/plugin/voip/video/a/a:UPc	I
    //   2131: invokestatic 414	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2134: aastore
    //   2135: invokestatic 489	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2138: aload_1
    //   2139: getfield 492	com/tencent/mm/plugin/voip/video/a/a:UPc	I
    //   2142: bipush 90
    //   2144: if_icmpeq +13 -> 2157
    //   2147: aload_1
    //   2148: getfield 492	com/tencent/mm/plugin/voip/video/a/a:UPc	I
    //   2151: sipush 270
    //   2154: if_icmpne +90 -> 2244
    //   2157: aload_1
    //   2158: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   2161: istore_3
    //   2162: aload_1
    //   2163: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   2166: istore_2
    //   2167: aload_1
    //   2168: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   2171: iload_3
    //   2172: iload_2
    //   2173: invokevirtual 563	com/tencent/mm/media/j/b/a:ek	(II)V
    //   2176: aload_1
    //   2177: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   2180: aload_1
    //   2181: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   2184: aload_1
    //   2185: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   2188: invokevirtual 479	com/tencent/mm/media/j/b/a:el	(II)V
    //   2191: aload_1
    //   2192: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   2195: aload_1
    //   2196: getfield 507	com/tencent/mm/plugin/voip/video/a/a:mVc	Lcom/tencent/mm/media/g/d;
    //   2199: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   2202: invokevirtual 564	com/tencent/mm/media/j/b/a:uc	(I)V
    //   2205: aload_1
    //   2206: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   2209: iconst_1
    //   2210: putfield 567	com/tencent/mm/media/j/b/a:nDP	Z
    //   2213: aload_1
    //   2214: getfield 474	com/tencent/mm/plugin/voip/video/a/a:NQX	Lcom/tencent/mm/media/j/b/a;
    //   2217: invokevirtual 568	com/tencent/mm/media/j/b/a:bgE	()V
    //   2220: invokestatic 573	com/tencent/mm/media/util/c:bqi	()V
    //   2223: goto -805 -> 1418
    //   2226: astore_1
    //   2227: ldc_w 459
    //   2230: aload_1
    //   2231: ldc_w 575
    //   2234: iconst_0
    //   2235: anewarray 4	java/lang/Object
    //   2238: invokestatic 579	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2241: goto -823 -> 1418
    //   2244: aload_1
    //   2245: getfield 457	com/tencent/mm/plugin/voip/video/a/a:mVd	I
    //   2248: istore_3
    //   2249: aload_1
    //   2250: getfield 454	com/tencent/mm/plugin/voip/video/a/a:mVe	I
    //   2253: istore_2
    //   2254: goto -87 -> 2167
    //   2257: aload_0
    //   2258: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   2261: aload_0
    //   2262: getfield 317	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   2265: getfield 427	com/tencent/mm/media/g/d:nAF	I
    //   2268: invokevirtual 530	com/tencent/mm/plugin/voip/video/render/n:uc	(I)V
    //   2271: goto -815 -> 1456
    //   2274: aload_0
    //   2275: getfield 525	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   2278: iload_2
    //   2279: invokevirtual 531	com/tencent/mm/plugin/voip/video/render/n:th	(I)V
    //   2282: goto -792 -> 1490
    //   2285: sipush 360
    //   2288: iload 6
    //   2290: isub
    //   2291: sipush 360
    //   2294: irem
    //   2295: istore_2
    //   2296: goto -22 -> 2274
    //   2299: iconst_0
    //   2300: istore 7
    //   2302: goto -2267 -> 35
    //   2305: iconst_1
    //   2306: istore 7
    //   2308: goto -2273 -> 35
    //   2311: iload 4
    //   2313: iconst_4
    //   2314: ishr
    //   2315: iconst_1
    //   2316: iand
    //   2317: iconst_1
    //   2318: if_icmpne -742 -> 1576
    //   2321: iconst_1
    //   2322: istore 8
    //   2324: goto -2197 -> 127
    //   2327: sipush 180
    //   2330: istore_2
    //   2331: goto -849 -> 1482
    //   2334: iload 6
    //   2336: ifeq +11 -> 2347
    //   2339: iload 6
    //   2341: sipush 180
    //   2344: if_icmpne -59 -> 2285
    //   2347: iconst_0
    //   2348: istore_2
    //   2349: goto -75 -> 2274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2352	0	this	b
    //   0	2352	1	paramArrayOfByte	byte[]
    //   0	2352	2	paramInt1	int
    //   0	2352	3	paramInt2	int
    //   0	2352	4	paramInt3	int
    //   0	2352	5	paramInt4	int
    //   0	2352	6	paramInt5	int
    //   795	1512	7	i	int
    //   128	2195	8	bool	boolean
    //   1301	130	9	l	long
    //   967	65	11	arrayOfFloat1	float[]
    //   972	112	12	arrayOfFloat2	float[]
    // Exception table:
    //   from	to	target	type
    //   2	32	1571	finally
    //   35	89	1571	finally
    //   89	105	1571	finally
    //   117	124	1571	finally
    //   127	140	1571	finally
    //   143	162	1571	finally
    //   167	202	1571	finally
    //   202	257	1571	finally
    //   261	315	1571	finally
    //   315	371	1571	finally
    //   371	454	1571	finally
    //   454	459	1571	finally
    //   459	481	1571	finally
    //   481	486	1571	finally
    //   486	662	1571	finally
    //   662	783	1571	finally
    //   788	795	1571	finally
    //   800	890	1571	finally
    //   890	918	1571	finally
    //   923	938	1571	finally
    //   938	993	1571	finally
    //   993	1013	1571	finally
    //   1013	1058	1571	finally
    //   1058	1079	1571	finally
    //   1079	1122	1571	finally
    //   1127	1158	1571	finally
    //   1158	1185	1571	finally
    //   1185	1211	1571	finally
    //   1211	1250	1571	finally
    //   1250	1303	1571	finally
    //   1303	1418	1571	finally
    //   1418	1456	1571	finally
    //   1456	1463	1571	finally
    //   1482	1490	1571	finally
    //   1490	1554	1571	finally
    //   1562	1568	1571	finally
    //   1588	1616	1571	finally
    //   1619	1624	1571	finally
    //   1627	1632	1571	finally
    //   1635	1646	1571	finally
    //   1649	1677	1571	finally
    //   1681	1709	1571	finally
    //   1709	1738	1571	finally
    //   1738	1785	1571	finally
    //   1785	1790	1571	finally
    //   1790	1812	1571	finally
    //   1812	1817	1571	finally
    //   1817	1948	1571	finally
    //   1948	2062	1571	finally
    //   2065	2070	1571	finally
    //   2073	2078	1571	finally
    //   2081	2092	1571	finally
    //   2095	2157	1571	finally
    //   2157	2167	1571	finally
    //   2167	2223	1571	finally
    //   2227	2241	1571	finally
    //   2244	2254	1571	finally
    //   2257	2271	1571	finally
    //   2274	2282	1571	finally
    //   1303	1418	2226	java/lang/Exception
    //   2095	2157	2226	java/lang/Exception
    //   2157	2167	2226	java/lang/Exception
    //   2167	2223	2226	java/lang/Exception
    //   2244	2254	2226	java/lang/Exception
  }
  
  public final void destroy()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(115709);
        if (!this.mGp)
        {
          AppMethodBeat.o(115709);
          return;
        }
        Log.i("MicroMsg.FilterRenderer", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        if (this.UPy != null)
        {
          localObject1 = this.UPy;
          Log.i("MicroMsg.FilterProcessTex", "clear %s %d", new Object[] { localObject1, Long.valueOf(Thread.currentThread().getId()) });
        }
        try
        {
          if (((a)localObject1).muW != null)
          {
            ((a)localObject1).muW.destroy();
            ((a)localObject1).muW = null;
          }
          ((a)localObject1).UPa = null;
          ((a)localObject1).UPb = null;
          ((a)localObject1).cJu = false;
          if (((a)localObject1).NQX != null)
          {
            ((a)localObject1).NQX.release();
            ((a)localObject1).NQX = null;
          }
        }
        catch (Exception localException)
        {
          d locald1;
          d locald2;
          d locald3;
          d locald4;
          d locald5;
          Log.printErrStackTrace("MicroMsg.FilterProcessTex", localException, "clear error: %s", new Object[] { localException.getMessage() });
          continue;
        }
        this.UPy = null;
        if (this.UPD != null)
        {
          this.UPD.release();
          this.UPD = null;
        }
        if (this.UPK != null) {
          this.UPK.onDestroy();
        }
        Object localObject1 = this.UPf;
        locald1 = this.UPg;
        locald2 = this.UPi;
        locald3 = this.UPu;
        locald4 = this.mWs;
        i = 0;
        if (i < 5)
        {
          locald5 = new d[] { localObject1, locald1, locald2, locald3, locald4 }[i];
          if (locald5 == null) {
            break label418;
          }
          locald5.close();
        }
      }
      finally {}
      if (this.UPs != null) {
        this.UPs.close();
      }
      if (this.UPt != null) {
        this.UPt.close();
      }
      GLES20.glDeleteProgram(this.nEC);
      GLES20.glDeleteProgram(this.UPh);
      this.UPA = null;
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFinish();
      if (this.nEJ != null) {
        this.nEJ.clear();
      }
      if (this.nEQ != null) {
        this.nEQ.clear();
      }
      this.nEJ = null;
      this.nEQ = null;
      this.mGp = false;
      AppMethodBeat.o(115709);
      continue;
      label418:
      i += 1;
    }
  }
  
  public final void mh(int paramInt1, int paramInt2)
  {
    this.mbM = paramInt1;
    this.mbN = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.b
 * JD-Core Version:    0.7.0.1
 */