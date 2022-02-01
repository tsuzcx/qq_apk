package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.c;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public final class b
{
  public static final float[] APz = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public static final float[] gWC = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] gWD = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  int AOs;
  public d APA;
  public d APB;
  public int APC;
  public d APD;
  public int APF;
  public int APG;
  public int APH;
  public int APJ;
  public FloatBuffer APK;
  public FloatBuffer APL;
  private ByteBuffer APM;
  public float[] APN;
  public float[] APO;
  public com.tencent.mm.media.f.a APQ;
  public com.tencent.mm.media.f.a APR;
  public d APS;
  private int APT;
  private int APU;
  public volatile a APV;
  private boolean APW;
  public byte[] APX;
  public byte[] APY;
  private com.tencent.mm.plugin.voip.video.b.a APZ;
  private int duc;
  private int fMt;
  private int fMu;
  private boolean gVi;
  public int gWl;
  public int gWm;
  public int gWn;
  public int gWo;
  public int gWr;
  private ByteBuffer gWs;
  public int gWy;
  private ByteBuffer gWz;
  public volatile boolean gkP;
  public FloatBuffer grD;
  public FloatBuffer grE;
  public d gsb;
  private int jbj;
  private int jbk;
  private float[] jbo;
  public float[] jbq;
  
  public b()
  {
    AppMethodBeat.i(115706);
    this.jbo = new float[16];
    this.jbq = gWC;
    this.APN = gWC;
    this.APV = null;
    this.APW = false;
    this.APZ = new com.tencent.mm.plugin.voip.video.b.a(this.jbj, this.jbk, 2, null);
    this.gkP = false;
    AppMethodBeat.o(115706);
  }
  
  private static int V(String paramString, int paramInt)
  {
    AppMethodBeat.i(115711);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ac.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(115711);
      return 0;
    }
    AppMethodBeat.o(115711);
    return paramInt;
  }
  
  private void a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(115708);
    if (paramd == null)
    {
      AppMethodBeat.o(115708);
      return;
    }
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glViewport(0, 0, this.fMt, this.fMu);
    GLES20.glUseProgram(this.APC);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramd.gRW);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.APH, 0);
    int i = this.APT;
    int j = this.APU;
    if (i / j < this.fMt / this.fMu) {}
    for (float f1 = this.fMt / i;; f1 = this.fMu / j)
    {
      int k = (int)(this.fMt / f1);
      int m = (int)(this.fMu / f1);
      Matrix.setIdentityM(this.jbo, 0);
      if (paramBoolean) {
        Matrix.setRotateM(this.jbo, 0, 180.0F, 0.0F, 0.0F, -1.0F);
      }
      GLES20.glUniformMatrix4fv(this.APJ, 1, false, this.jbo, 0);
      this.APL.put(this.APN);
      this.APL.position(0);
      GLES20.glVertexAttribPointer(this.APG, 2, 5126, false, 0, this.APL);
      GLES20.glEnableVertexAttribArray(this.APG);
      f1 = (j - m) / 2.0F / j;
      float f2 = 1.0F - f1;
      float f3 = (i - k) / 2.0F / i;
      float f4 = 1.0F - f3;
      this.APO[0] = f3;
      this.APO[1] = f1;
      this.APO[2] = f4;
      this.APO[3] = f1;
      this.APO[4] = f3;
      this.APO[5] = f2;
      this.APO[6] = f4;
      this.APO[7] = f2;
      this.APK.put(this.APO);
      this.APK.position(0);
      GLES20.glVertexAttribPointer(this.APF, 2, 5126, false, 0, this.APK);
      GLES20.glEnableVertexAttribArray(this.APF);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.APG);
      GLES20.glDisableVertexAttribArray(this.APF);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      AppMethodBeat.o(115708);
      return;
    }
  }
  
  public static int ax(String paramString1, String paramString2)
  {
    AppMethodBeat.i(115712);
    int[] arrayOfInt = new int[1];
    int i = V(paramString1, 35633);
    if (i == 0)
    {
      ac.e("MicroMsg.FilterRenderer", "load vertex shader failed");
      AppMethodBeat.o(115712);
      return 0;
    }
    int j = V(paramString2, 35632);
    if (j == 0)
    {
      ac.e("MicroMsg.FilterRenderer", "load fragment shader failed");
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
      ac.e("MicroMsg.FilterRenderer", "link program failed");
      AppMethodBeat.o(115712);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(115712);
    return k;
  }
  
  public static d emO()
  {
    AppMethodBeat.i(115710);
    d locald = c.a(true, 14L);
    AppMethodBeat.o(115710);
    return locald;
  }
  
  public static com.tencent.mm.media.f.a emP()
  {
    AppMethodBeat.i(115713);
    Object localObject = c.gRV;
    localObject = c.pq(14L);
    AppMethodBeat.o(115713);
    return localObject;
  }
  
  /* Error */
  public final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc_w 300
    //   8: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   15: iload_2
    //   16: if_icmpne +1812 -> 1828
    //   19: aload_0
    //   20: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   23: iload_3
    //   24: if_icmpeq +1798 -> 1822
    //   27: goto +1801 -> 1828
    //   30: aload_0
    //   31: iload_2
    //   32: putfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   35: aload_0
    //   36: iload_3
    //   37: putfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   40: iload 4
    //   42: iconst_2
    //   43: ishr
    //   44: iconst_3
    //   45: iand
    //   46: istore_2
    //   47: iload_2
    //   48: iconst_3
    //   49: if_icmpne +1107 -> 1156
    //   52: aload_0
    //   53: sipush 270
    //   56: putfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   59: goto +1775 -> 1834
    //   62: aload_0
    //   63: iload 7
    //   65: putfield 304	com/tencent/mm/plugin/voip/video/a/b:gVi	Z
    //   68: getstatic 309	com/tencent/mm/plugin/voip/video/OpenGlRender:AOo	I
    //   71: iconst_1
    //   72: if_icmpeq +1109 -> 1181
    //   75: iload 8
    //   77: istore 7
    //   79: aload_0
    //   80: iload 7
    //   82: putfield 91	com/tencent/mm/plugin/voip/video/a/b:APW	Z
    //   85: aload_0
    //   86: iload 5
    //   88: putfield 311	com/tencent/mm/plugin/voip/video/a/b:AOs	I
    //   91: aload_0
    //   92: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   95: ifnonnull +36 -> 131
    //   98: iload 5
    //   100: ifeq +31 -> 131
    //   103: aload_0
    //   104: new 313	com/tencent/mm/plugin/voip/video/a/a
    //   107: dup
    //   108: invokespecial 314	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   111: putfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   114: aload_0
    //   115: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   118: aload_0
    //   119: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   122: aload_0
    //   123: getfield 318	com/tencent/mm/plugin/voip/video/a/b:gsb	Lcom/tencent/mm/media/f/d;
    //   126: iload 5
    //   128: invokevirtual 321	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/f/d;Lcom/tencent/mm/media/f/d;I)V
    //   131: fconst_0
    //   132: fconst_0
    //   133: fconst_0
    //   134: fconst_0
    //   135: invokestatic 147	android/opengl/GLES20:glClearColor	(FFFF)V
    //   138: sipush 16640
    //   141: invokestatic 150	android/opengl/GLES20:glClear	(I)V
    //   144: aload_0
    //   145: getfield 91	com/tencent/mm/plugin/voip/video/a/b:APW	Z
    //   148: ifeq +1069 -> 1217
    //   151: aload_0
    //   152: getfield 323	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   155: ifeq +556 -> 711
    //   158: aload_0
    //   159: getfield 325	com/tencent/mm/plugin/voip/video/a/b:APA	Lcom/tencent/mm/media/f/d;
    //   162: ifnull +549 -> 711
    //   165: aload_0
    //   166: getfield 327	com/tencent/mm/plugin/voip/video/a/b:APB	Lcom/tencent/mm/media/f/d;
    //   169: ifnull +542 -> 711
    //   172: aload_0
    //   173: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   176: ifle +535 -> 711
    //   179: aload_0
    //   180: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   183: ifle +528 -> 711
    //   186: aload_1
    //   187: ifnull +524 -> 711
    //   190: aload_0
    //   191: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   194: ifnull +50 -> 244
    //   197: aload_0
    //   198: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   201: ifnull +43 -> 244
    //   204: aload_0
    //   205: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   208: invokevirtual 336	java/nio/ByteBuffer:capacity	()I
    //   211: aload_0
    //   212: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   215: aload_0
    //   216: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   219: imul
    //   220: if_icmpne +24 -> 244
    //   223: aload_0
    //   224: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   227: invokevirtual 336	java/nio/ByteBuffer:capacity	()I
    //   230: aload_0
    //   231: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   234: aload_0
    //   235: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   238: imul
    //   239: iconst_2
    //   240: idiv
    //   241: if_icmpeq +59 -> 300
    //   244: aload_0
    //   245: aload_0
    //   246: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   249: aload_0
    //   250: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   253: imul
    //   254: invokestatic 340	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   257: putfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   260: aload_0
    //   261: aload_0
    //   262: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   265: aload_0
    //   266: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   269: imul
    //   270: iconst_2
    //   271: idiv
    //   272: invokestatic 340	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   275: putfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   278: aload_0
    //   279: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   282: invokestatic 346	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   285: invokevirtual 350	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   288: pop
    //   289: aload_0
    //   290: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   293: invokestatic 346	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   296: invokevirtual 350	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   299: pop
    //   300: aload_0
    //   301: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   304: aload_1
    //   305: iconst_0
    //   306: aload_0
    //   307: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   310: aload_0
    //   311: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   314: imul
    //   315: invokevirtual 353	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   318: pop
    //   319: aload_0
    //   320: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   323: iconst_0
    //   324: invokevirtual 354	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   327: pop
    //   328: aload_0
    //   329: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   332: aload_1
    //   333: aload_0
    //   334: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   337: aload_0
    //   338: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   341: imul
    //   342: aload_0
    //   343: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   346: aload_0
    //   347: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   350: imul
    //   351: iconst_2
    //   352: idiv
    //   353: invokevirtual 353	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   356: pop
    //   357: aload_0
    //   358: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   361: iconst_0
    //   362: invokevirtual 354	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   365: pop
    //   366: aload_0
    //   367: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   370: sipush 180
    //   373: if_icmpeq +10 -> 383
    //   376: aload_0
    //   377: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   380: ifne +807 -> 1187
    //   383: aload_0
    //   384: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   387: istore_2
    //   388: aload_0
    //   389: iload_2
    //   390: putfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   393: aload_0
    //   394: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   397: sipush 180
    //   400: if_icmpeq +10 -> 410
    //   403: aload_0
    //   404: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   407: ifne +788 -> 1195
    //   410: aload_0
    //   411: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   414: istore_2
    //   415: aload_0
    //   416: iload_2
    //   417: putfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   420: aload_0
    //   421: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   424: aload_0
    //   425: getfield 356	com/tencent/mm/plugin/voip/video/a/b:APQ	Lcom/tencent/mm/media/f/a;
    //   428: aload_0
    //   429: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   432: aload_0
    //   433: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   436: invokevirtual 359	com/tencent/mm/media/f/d:a	(Lcom/tencent/mm/media/f/a;II)V
    //   439: iconst_0
    //   440: iconst_0
    //   441: aload_0
    //   442: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   445: aload_0
    //   446: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   449: invokestatic 158	android/opengl/GLES20:glViewport	(IIII)V
    //   452: aload_0
    //   453: getfield 323	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   456: invokestatic 163	android/opengl/GLES20:glUseProgram	(I)V
    //   459: ldc 164
    //   461: invokestatic 167	android/opengl/GLES20:glActiveTexture	(I)V
    //   464: aload_0
    //   465: getfield 325	com/tencent/mm/plugin/voip/video/a/b:APA	Lcom/tencent/mm/media/f/d;
    //   468: aload_0
    //   469: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   472: aload_0
    //   473: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   476: sipush 6409
    //   479: aload_0
    //   480: getfield 329	com/tencent/mm/plugin/voip/video/a/b:gWs	Ljava/nio/ByteBuffer;
    //   483: sipush 9729
    //   486: ldc_w 360
    //   489: invokevirtual 363	com/tencent/mm/media/f/d:a	(IIILjava/nio/Buffer;II)V
    //   492: aload_0
    //   493: getfield 365	com/tencent/mm/plugin/voip/video/a/b:gWo	I
    //   496: iconst_0
    //   497: invokestatic 187	android/opengl/GLES20:glUniform1i	(II)V
    //   500: ldc_w 366
    //   503: invokestatic 167	android/opengl/GLES20:glActiveTexture	(I)V
    //   506: aload_0
    //   507: getfield 327	com/tencent/mm/plugin/voip/video/a/b:APB	Lcom/tencent/mm/media/f/d;
    //   510: aload_0
    //   511: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   514: iconst_2
    //   515: idiv
    //   516: aload_0
    //   517: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   520: iconst_2
    //   521: idiv
    //   522: sipush 6410
    //   525: aload_0
    //   526: getfield 331	com/tencent/mm/plugin/voip/video/a/b:gWz	Ljava/nio/ByteBuffer;
    //   529: sipush 9729
    //   532: ldc_w 360
    //   535: invokevirtual 363	com/tencent/mm/media/f/d:a	(IIILjava/nio/Buffer;II)V
    //   538: aload_0
    //   539: getfield 368	com/tencent/mm/plugin/voip/video/a/b:gWy	I
    //   542: iconst_1
    //   543: invokestatic 187	android/opengl/GLES20:glUniform1i	(II)V
    //   546: aload_0
    //   547: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   550: iconst_0
    //   551: invokestatic 197	android/opengl/Matrix:setIdentityM	([FI)V
    //   554: aload_0
    //   555: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   558: iconst_0
    //   559: aload_0
    //   560: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   563: i2f
    //   564: fconst_0
    //   565: fconst_0
    //   566: ldc 64
    //   568: invokestatic 202	android/opengl/Matrix:setRotateM	([FIFFFF)V
    //   571: aload_0
    //   572: getfield 304	com/tencent/mm/plugin/voip/video/a/b:gVi	Z
    //   575: ifeq +628 -> 1203
    //   578: aload_0
    //   579: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   582: iconst_0
    //   583: ldc 64
    //   585: fconst_1
    //   586: fconst_1
    //   587: invokestatic 372	android/opengl/Matrix:scaleM	([FIFFF)V
    //   590: aload_0
    //   591: getfield 374	com/tencent/mm/plugin/voip/video/a/b:gWr	I
    //   594: iconst_1
    //   595: iconst_0
    //   596: aload_0
    //   597: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   600: iconst_0
    //   601: invokestatic 208	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   604: aload_0
    //   605: getfield 376	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   608: iconst_0
    //   609: invokevirtual 220	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   612: pop
    //   613: aload_0
    //   614: getfield 378	com/tencent/mm/plugin/voip/video/a/b:gWn	I
    //   617: iconst_2
    //   618: sipush 5126
    //   621: iconst_0
    //   622: iconst_0
    //   623: aload_0
    //   624: getfield 376	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   627: invokestatic 226	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   630: aload_0
    //   631: getfield 378	com/tencent/mm/plugin/voip/video/a/b:gWn	I
    //   634: invokestatic 229	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   637: aload_0
    //   638: getfield 380	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   641: iconst_0
    //   642: invokevirtual 220	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   645: pop
    //   646: aload_0
    //   647: getfield 382	com/tencent/mm/plugin/voip/video/a/b:gWm	I
    //   650: iconst_2
    //   651: sipush 5126
    //   654: iconst_0
    //   655: iconst_0
    //   656: aload_0
    //   657: getfield 380	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   660: invokestatic 226	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   663: aload_0
    //   664: getfield 382	com/tencent/mm/plugin/voip/video/a/b:gWm	I
    //   667: invokestatic 229	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   670: iconst_5
    //   671: iconst_0
    //   672: iconst_4
    //   673: invokestatic 239	android/opengl/GLES20:glDrawArrays	(III)V
    //   676: aload_0
    //   677: getfield 378	com/tencent/mm/plugin/voip/video/a/b:gWn	I
    //   680: invokestatic 242	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   683: aload_0
    //   684: getfield 382	com/tencent/mm/plugin/voip/video/a/b:gWm	I
    //   687: invokestatic 242	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   690: sipush 3553
    //   693: iconst_0
    //   694: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   697: ldc_w 383
    //   700: iconst_0
    //   701: invokestatic 386	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   704: iconst_0
    //   705: invokestatic 163	android/opengl/GLES20:glUseProgram	(I)V
    //   708: invokestatic 389	android/opengl/GLES20:glFinish	()V
    //   711: iload 5
    //   713: ifeq +105 -> 818
    //   716: aload_0
    //   717: getfield 391	com/tencent/mm/plugin/voip/video/a/b:APX	[B
    //   720: ifnull +8 -> 728
    //   723: iload 6
    //   725: ifeq +93 -> 818
    //   728: ldc 250
    //   730: ldc_w 393
    //   733: iconst_5
    //   734: anewarray 4	java/lang/Object
    //   737: dup
    //   738: iconst_0
    //   739: aload_0
    //   740: invokevirtual 396	java/lang/Object:hashCode	()I
    //   743: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   746: aastore
    //   747: dup
    //   748: iconst_1
    //   749: aload_0
    //   750: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   753: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   756: aastore
    //   757: dup
    //   758: iconst_2
    //   759: aload_0
    //   760: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   763: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   766: aastore
    //   767: dup
    //   768: iconst_3
    //   769: aload_0
    //   770: getfield 152	com/tencent/mm/plugin/voip/video/a/b:fMt	I
    //   773: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   776: aastore
    //   777: dup
    //   778: iconst_4
    //   779: aload_0
    //   780: getfield 154	com/tencent/mm/plugin/voip/video/a/b:fMu	I
    //   783: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   786: aastore
    //   787: invokestatic 405	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   790: aload_0
    //   791: aload_0
    //   792: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   795: aload_0
    //   796: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   799: imul
    //   800: iconst_4
    //   801: imul
    //   802: newarray byte
    //   804: putfield 391	com/tencent/mm/plugin/voip/video/a/b:APX	[B
    //   807: aload_0
    //   808: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   811: aload_0
    //   812: getfield 391	com/tencent/mm/plugin/voip/video/a/b:APX	[B
    //   815: putfield 408	com/tencent/mm/plugin/voip/video/a/a:APv	[B
    //   818: iload 5
    //   820: ifeq +990 -> 1810
    //   823: aload_0
    //   824: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   827: astore_1
    //   828: aload_0
    //   829: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   832: istore_2
    //   833: aload_0
    //   834: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   837: istore_3
    //   838: iload_3
    //   839: aload_1
    //   840: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   843: if_icmpne +11 -> 854
    //   846: iload_2
    //   847: aload_1
    //   848: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   851: if_icmpeq +30 -> 881
    //   854: ldc_w 416
    //   857: ldc_w 418
    //   860: iconst_2
    //   861: anewarray 4	java/lang/Object
    //   864: dup
    //   865: iconst_0
    //   866: iload_2
    //   867: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   870: aastore
    //   871: dup
    //   872: iconst_1
    //   873: iload_3
    //   874: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   877: aastore
    //   878: invokestatic 405	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   881: aload_1
    //   882: iload_2
    //   883: putfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   886: aload_1
    //   887: iload_3
    //   888: putfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   891: aload_1
    //   892: getfield 422	com/tencent/mm/plugin/voip/video/a/a:fZP	Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;
    //   895: ifnull +12 -> 907
    //   898: aload_1
    //   899: getfield 422	com/tencent/mm/plugin/voip/video/a/a:fZP	Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;
    //   902: iload_2
    //   903: iload_3
    //   904: invokevirtual 427	com/tencent/mm/plugin/xlabeffect/XLabEffect:setSize	(II)V
    //   907: aload_1
    //   908: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   911: iload_2
    //   912: iload_3
    //   913: invokevirtual 436	com/tencent/mm/media/i/b/a:cS	(II)V
    //   916: aload_1
    //   917: aconst_null
    //   918: putfield 439	com/tencent/mm/plugin/voip/video/a/a:APw	Ljava/nio/ByteBuffer;
    //   921: aload_0
    //   922: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   925: aload_0
    //   926: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   929: putfield 442	com/tencent/mm/plugin/voip/video/a/a:APu	Lcom/tencent/mm/media/f/d;
    //   932: aload_0
    //   933: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   936: astore_1
    //   937: aload_0
    //   938: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   941: istore_2
    //   942: ldc_w 416
    //   945: ldc_w 444
    //   948: iconst_1
    //   949: anewarray 4	java/lang/Object
    //   952: dup
    //   953: iconst_0
    //   954: iload_2
    //   955: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   958: aastore
    //   959: invokestatic 446	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   962: aload_1
    //   963: iload_2
    //   964: putfield 449	com/tencent/mm/plugin/voip/video/a/a:APx	I
    //   967: aload_1
    //   968: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   971: iload_2
    //   972: invokevirtual 452	com/tencent/mm/media/i/b/a:mE	(I)V
    //   975: aload_0
    //   976: getfield 89	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   979: astore_1
    //   980: invokestatic 458	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   983: lstore 9
    //   985: aload_1
    //   986: getfield 422	com/tencent/mm/plugin/voip/video/a/a:fZP	Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;
    //   989: aload_1
    //   990: getfield 442	com/tencent/mm/plugin/voip/video/a/a:APu	Lcom/tencent/mm/media/f/d;
    //   993: invokevirtual 462	com/tencent/mm/plugin/xlabeffect/XLabEffect:c	(Lcom/tencent/mm/media/f/d;)V
    //   996: ldc_w 383
    //   999: iconst_0
    //   1000: invokestatic 386	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1003: sipush 3553
    //   1006: iconst_0
    //   1007: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   1010: aload_1
    //   1011: getfield 465	com/tencent/mm/plugin/voip/video/a/a:gqY	Lcom/tencent/mm/media/f/d;
    //   1014: aload_1
    //   1015: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1018: aload_1
    //   1019: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1022: sipush 6408
    //   1025: aconst_null
    //   1026: sipush 9729
    //   1029: sipush 10497
    //   1032: invokevirtual 363	com/tencent/mm/media/f/d:a	(IIILjava/nio/Buffer;II)V
    //   1035: iconst_0
    //   1036: iconst_0
    //   1037: aload_1
    //   1038: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1041: aload_1
    //   1042: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1045: invokestatic 158	android/opengl/GLES20:glViewport	(IIII)V
    //   1048: aload_1
    //   1049: getfield 422	com/tencent/mm/plugin/voip/video/a/a:fZP	Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;
    //   1052: aload_1
    //   1053: getfield 442	com/tencent/mm/plugin/voip/video/a/a:APu	Lcom/tencent/mm/media/f/d;
    //   1056: aload_1
    //   1057: getfield 465	com/tencent/mm/plugin/voip/video/a/a:gqY	Lcom/tencent/mm/media/f/d;
    //   1060: iconst_0
    //   1061: bipush 48
    //   1063: invokestatic 468	com/tencent/mm/plugin/xlabeffect/XLabEffect:a	(Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;Lcom/tencent/mm/media/f/d;Lcom/tencent/mm/media/f/d;ZI)I
    //   1066: pop
    //   1067: invokestatic 389	android/opengl/GLES20:glFinish	()V
    //   1070: ldc_w 383
    //   1073: iconst_0
    //   1074: invokestatic 386	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1077: sipush 3553
    //   1080: iconst_0
    //   1081: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   1084: aload_1
    //   1085: getfield 465	com/tencent/mm/plugin/voip/video/a/a:gqY	Lcom/tencent/mm/media/f/d;
    //   1088: ifnonnull +560 -> 1648
    //   1091: ldc_w 416
    //   1094: ldc_w 470
    //   1097: invokestatic 140	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1100: ldc_w 416
    //   1103: ldc_w 472
    //   1106: iconst_1
    //   1107: anewarray 4	java/lang/Object
    //   1110: dup
    //   1111: iconst_0
    //   1112: lload 9
    //   1114: invokestatic 476	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   1117: invokestatic 481	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1120: aastore
    //   1121: invokestatic 446	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1124: aload_0
    //   1125: aload_0
    //   1126: getfield 318	com/tencent/mm/plugin/voip/video/a/b:gsb	Lcom/tencent/mm/media/f/d;
    //   1129: iconst_1
    //   1130: invokespecial 483	com/tencent/mm/plugin/voip/video/a/b:a	(Lcom/tencent/mm/media/f/d;Z)V
    //   1133: ldc_w 383
    //   1136: iconst_0
    //   1137: invokestatic 386	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1140: sipush 3553
    //   1143: iconst_0
    //   1144: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   1147: ldc_w 300
    //   1150: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1153: aload_0
    //   1154: monitorexit
    //   1155: return
    //   1156: iload_2
    //   1157: iconst_1
    //   1158: if_icmpne +676 -> 1834
    //   1161: aload_0
    //   1162: bipush 90
    //   1164: putfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1167: goto +667 -> 1834
    //   1170: astore_1
    //   1171: aload_0
    //   1172: monitorexit
    //   1173: aload_1
    //   1174: athrow
    //   1175: iconst_0
    //   1176: istore 7
    //   1178: goto -1116 -> 62
    //   1181: iconst_0
    //   1182: istore 7
    //   1184: goto -1105 -> 79
    //   1187: aload_0
    //   1188: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1191: istore_2
    //   1192: goto -804 -> 388
    //   1195: aload_0
    //   1196: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1199: istore_2
    //   1200: goto -785 -> 415
    //   1203: aload_0
    //   1204: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   1207: iconst_0
    //   1208: fconst_1
    //   1209: fconst_1
    //   1210: fconst_1
    //   1211: invokestatic 372	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1214: goto -624 -> 590
    //   1217: aload_0
    //   1218: getfield 160	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   1221: ifeq -510 -> 711
    //   1224: aload_0
    //   1225: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   1228: ifnull -517 -> 711
    //   1231: aload_0
    //   1232: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1235: ifle -524 -> 711
    //   1238: aload_0
    //   1239: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1242: ifle -531 -> 711
    //   1245: aload_1
    //   1246: ifnull -535 -> 711
    //   1249: aload_0
    //   1250: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1253: ifnull +24 -> 1277
    //   1256: aload_0
    //   1257: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1260: invokevirtual 336	java/nio/ByteBuffer:capacity	()I
    //   1263: aload_0
    //   1264: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1267: aload_0
    //   1268: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1271: imul
    //   1272: iconst_4
    //   1273: imul
    //   1274: if_icmpeq +32 -> 1306
    //   1277: aload_0
    //   1278: aload_0
    //   1279: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1282: aload_0
    //   1283: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1286: imul
    //   1287: iconst_4
    //   1288: imul
    //   1289: invokestatic 340	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1292: putfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1295: aload_0
    //   1296: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1299: invokestatic 346	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   1302: invokevirtual 350	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1305: pop
    //   1306: aload_0
    //   1307: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1310: aload_1
    //   1311: iconst_0
    //   1312: aload_0
    //   1313: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1316: aload_0
    //   1317: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1320: imul
    //   1321: iconst_4
    //   1322: imul
    //   1323: invokevirtual 353	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1326: pop
    //   1327: aload_0
    //   1328: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1331: iconst_0
    //   1332: invokevirtual 354	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1335: pop
    //   1336: aload_0
    //   1337: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1340: sipush 180
    //   1343: if_icmpeq +10 -> 1353
    //   1346: aload_0
    //   1347: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1350: ifne +282 -> 1632
    //   1353: aload_0
    //   1354: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1357: istore_2
    //   1358: aload_0
    //   1359: iload_2
    //   1360: putfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   1363: aload_0
    //   1364: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1367: sipush 180
    //   1370: if_icmpeq +10 -> 1380
    //   1373: aload_0
    //   1374: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1377: ifne +263 -> 1640
    //   1380: aload_0
    //   1381: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1384: istore_2
    //   1385: aload_0
    //   1386: iload_2
    //   1387: putfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   1390: aload_0
    //   1391: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   1394: aload_0
    //   1395: getfield 356	com/tencent/mm/plugin/voip/video/a/b:APQ	Lcom/tencent/mm/media/f/a;
    //   1398: aload_0
    //   1399: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   1402: aload_0
    //   1403: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   1406: invokevirtual 359	com/tencent/mm/media/f/d:a	(Lcom/tencent/mm/media/f/a;II)V
    //   1409: aload_0
    //   1410: getfield 160	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   1413: invokestatic 163	android/opengl/GLES20:glUseProgram	(I)V
    //   1416: ldc 164
    //   1418: invokestatic 167	android/opengl/GLES20:glActiveTexture	(I)V
    //   1421: sipush 3553
    //   1424: aload_0
    //   1425: getfield 487	com/tencent/mm/plugin/voip/video/a/b:APD	Lcom/tencent/mm/media/f/d;
    //   1428: getfield 172	com/tencent/mm/media/f/d:gRW	I
    //   1431: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   1434: sipush 3553
    //   1437: iconst_0
    //   1438: sipush 6408
    //   1441: aload_0
    //   1442: getfield 189	com/tencent/mm/plugin/voip/video/a/b:APT	I
    //   1445: aload_0
    //   1446: getfield 191	com/tencent/mm/plugin/voip/video/a/b:APU	I
    //   1449: iconst_0
    //   1450: sipush 6408
    //   1453: sipush 5121
    //   1456: aload_0
    //   1457: getfield 485	com/tencent/mm/plugin/voip/video/a/b:APM	Ljava/nio/ByteBuffer;
    //   1460: invokestatic 491	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   1463: aload_0
    //   1464: getfield 184	com/tencent/mm/plugin/voip/video/a/b:APH	I
    //   1467: iconst_0
    //   1468: invokestatic 187	android/opengl/GLES20:glUniform1i	(II)V
    //   1471: aload_0
    //   1472: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   1475: iconst_0
    //   1476: invokestatic 197	android/opengl/Matrix:setIdentityM	([FI)V
    //   1479: aload_0
    //   1480: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   1483: iconst_0
    //   1484: aload_0
    //   1485: getfield 302	com/tencent/mm/plugin/voip/video/a/b:duc	I
    //   1488: i2f
    //   1489: fconst_0
    //   1490: fconst_0
    //   1491: ldc 64
    //   1493: invokestatic 202	android/opengl/Matrix:setRotateM	([FIFFFF)V
    //   1496: aload_0
    //   1497: getfield 304	com/tencent/mm/plugin/voip/video/a/b:gVi	Z
    //   1500: ifeq +15 -> 1515
    //   1503: aload_0
    //   1504: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   1507: iconst_0
    //   1508: fconst_1
    //   1509: ldc 64
    //   1511: fconst_1
    //   1512: invokestatic 372	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1515: aload_0
    //   1516: getfield 204	com/tencent/mm/plugin/voip/video/a/b:APJ	I
    //   1519: iconst_1
    //   1520: iconst_0
    //   1521: aload_0
    //   1522: getfield 83	com/tencent/mm/plugin/voip/video/a/b:jbo	[F
    //   1525: iconst_0
    //   1526: invokestatic 208	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   1529: aload_0
    //   1530: getfield 376	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   1533: iconst_0
    //   1534: invokevirtual 220	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1537: pop
    //   1538: aload_0
    //   1539: getfield 222	com/tencent/mm/plugin/voip/video/a/b:APG	I
    //   1542: iconst_2
    //   1543: sipush 5126
    //   1546: iconst_0
    //   1547: iconst_0
    //   1548: aload_0
    //   1549: getfield 376	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   1552: invokestatic 226	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   1555: aload_0
    //   1556: getfield 222	com/tencent/mm/plugin/voip/video/a/b:APG	I
    //   1559: invokestatic 229	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   1562: aload_0
    //   1563: getfield 380	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   1566: iconst_0
    //   1567: invokevirtual 220	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1570: pop
    //   1571: aload_0
    //   1572: getfield 235	com/tencent/mm/plugin/voip/video/a/b:APF	I
    //   1575: iconst_2
    //   1576: sipush 5126
    //   1579: iconst_0
    //   1580: iconst_0
    //   1581: aload_0
    //   1582: getfield 380	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   1585: invokestatic 226	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   1588: aload_0
    //   1589: getfield 235	com/tencent/mm/plugin/voip/video/a/b:APF	I
    //   1592: invokestatic 229	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   1595: iconst_5
    //   1596: iconst_0
    //   1597: iconst_4
    //   1598: invokestatic 239	android/opengl/GLES20:glDrawArrays	(III)V
    //   1601: aload_0
    //   1602: getfield 222	com/tencent/mm/plugin/voip/video/a/b:APG	I
    //   1605: invokestatic 242	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   1608: aload_0
    //   1609: getfield 235	com/tencent/mm/plugin/voip/video/a/b:APF	I
    //   1612: invokestatic 242	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   1615: sipush 3553
    //   1618: iconst_0
    //   1619: invokestatic 176	android/opengl/GLES20:glBindTexture	(II)V
    //   1622: ldc_w 383
    //   1625: iconst_0
    //   1626: invokestatic 386	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1629: goto -918 -> 711
    //   1632: aload_0
    //   1633: getfield 97	com/tencent/mm/plugin/voip/video/a/b:jbk	I
    //   1636: istore_2
    //   1637: goto -279 -> 1358
    //   1640: aload_0
    //   1641: getfield 95	com/tencent/mm/plugin/voip/video/a/b:jbj	I
    //   1644: istore_2
    //   1645: goto -260 -> 1385
    //   1648: ldc_w 416
    //   1651: ldc_w 493
    //   1654: iconst_3
    //   1655: anewarray 4	java/lang/Object
    //   1658: dup
    //   1659: iconst_0
    //   1660: aload_1
    //   1661: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1664: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1667: aastore
    //   1668: dup
    //   1669: iconst_1
    //   1670: aload_1
    //   1671: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1674: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1677: aastore
    //   1678: dup
    //   1679: iconst_2
    //   1680: aload_1
    //   1681: getfield 449	com/tencent/mm/plugin/voip/video/a/a:APx	I
    //   1684: invokestatic 402	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1687: aastore
    //   1688: invokestatic 446	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1691: aload_1
    //   1692: getfield 449	com/tencent/mm/plugin/voip/video/a/a:APx	I
    //   1695: bipush 90
    //   1697: if_icmpeq +13 -> 1710
    //   1700: aload_1
    //   1701: getfield 449	com/tencent/mm/plugin/voip/video/a/a:APx	I
    //   1704: sipush 270
    //   1707: if_icmpne +90 -> 1797
    //   1710: aload_1
    //   1711: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1714: istore_3
    //   1715: aload_1
    //   1716: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1719: istore_2
    //   1720: aload_1
    //   1721: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   1724: iload_3
    //   1725: iload_2
    //   1726: invokevirtual 496	com/tencent/mm/media/i/b/a:cR	(II)V
    //   1729: aload_1
    //   1730: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   1733: aload_1
    //   1734: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1737: aload_1
    //   1738: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1741: invokevirtual 436	com/tencent/mm/media/i/b/a:cS	(II)V
    //   1744: aload_1
    //   1745: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   1748: aload_1
    //   1749: getfield 465	com/tencent/mm/plugin/voip/video/a/a:gqY	Lcom/tencent/mm/media/f/d;
    //   1752: getfield 172	com/tencent/mm/media/f/d:gRW	I
    //   1755: invokevirtual 499	com/tencent/mm/media/i/b/a:no	(I)V
    //   1758: aload_1
    //   1759: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   1762: iconst_1
    //   1763: putfield 502	com/tencent/mm/media/i/b/a:gVz	Z
    //   1766: aload_1
    //   1767: getfield 431	com/tencent/mm/plugin/voip/video/a/a:wxR	Lcom/tencent/mm/media/i/b/a;
    //   1770: invokevirtual 505	com/tencent/mm/media/i/b/a:ajG	()V
    //   1773: invokestatic 510	com/tencent/mm/media/j/c:art	()V
    //   1776: goto -676 -> 1100
    //   1779: astore_1
    //   1780: ldc_w 416
    //   1783: aload_1
    //   1784: ldc_w 512
    //   1787: iconst_0
    //   1788: anewarray 4	java/lang/Object
    //   1791: invokestatic 516	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1794: goto -694 -> 1100
    //   1797: aload_1
    //   1798: getfield 414	com/tencent/mm/plugin/voip/video/a/a:gqZ	I
    //   1801: istore_3
    //   1802: aload_1
    //   1803: getfield 411	com/tencent/mm/plugin/voip/video/a/a:gra	I
    //   1806: istore_2
    //   1807: goto -87 -> 1720
    //   1810: aload_0
    //   1811: aload_0
    //   1812: getfield 316	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   1815: iconst_0
    //   1816: invokespecial 483	com/tencent/mm/plugin/voip/video/a/b:a	(Lcom/tencent/mm/media/f/d;Z)V
    //   1819: goto -686 -> 1133
    //   1822: iconst_0
    //   1823: istore 6
    //   1825: goto -1795 -> 30
    //   1828: iconst_1
    //   1829: istore 6
    //   1831: goto -1801 -> 30
    //   1834: iload 4
    //   1836: iconst_4
    //   1837: ishr
    //   1838: iconst_1
    //   1839: iand
    //   1840: iconst_1
    //   1841: if_icmpne -666 -> 1175
    //   1844: iconst_1
    //   1845: istore 7
    //   1847: goto -1785 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1850	0	this	b
    //   0	1850	1	paramArrayOfByte	byte[]
    //   0	1850	2	paramInt1	int
    //   0	1850	3	paramInt2	int
    //   0	1850	4	paramInt3	int
    //   0	1850	5	paramInt4	int
    //   723	1107	6	i	int
    //   63	1783	7	bool1	boolean
    //   1	75	8	bool2	boolean
    //   983	130	9	l	long
    // Exception table:
    //   from	to	target	type
    //   5	27	1170	finally
    //   30	40	1170	finally
    //   52	59	1170	finally
    //   62	75	1170	finally
    //   79	98	1170	finally
    //   103	131	1170	finally
    //   131	186	1170	finally
    //   190	244	1170	finally
    //   244	300	1170	finally
    //   300	383	1170	finally
    //   383	388	1170	finally
    //   388	410	1170	finally
    //   410	415	1170	finally
    //   415	590	1170	finally
    //   590	711	1170	finally
    //   716	723	1170	finally
    //   728	818	1170	finally
    //   823	854	1170	finally
    //   854	881	1170	finally
    //   881	907	1170	finally
    //   907	985	1170	finally
    //   985	1100	1170	finally
    //   1100	1133	1170	finally
    //   1133	1153	1170	finally
    //   1161	1167	1170	finally
    //   1187	1192	1170	finally
    //   1195	1200	1170	finally
    //   1203	1214	1170	finally
    //   1217	1245	1170	finally
    //   1249	1277	1170	finally
    //   1277	1306	1170	finally
    //   1306	1353	1170	finally
    //   1353	1358	1170	finally
    //   1358	1380	1170	finally
    //   1380	1385	1170	finally
    //   1385	1515	1170	finally
    //   1515	1629	1170	finally
    //   1632	1637	1170	finally
    //   1640	1645	1170	finally
    //   1648	1710	1170	finally
    //   1710	1720	1170	finally
    //   1720	1776	1170	finally
    //   1780	1794	1170	finally
    //   1797	1807	1170	finally
    //   1810	1819	1170	finally
    //   985	1100	1779	java/lang/Exception
    //   1648	1710	1779	java/lang/Exception
    //   1710	1720	1779	java/lang/Exception
    //   1720	1776	1779	java/lang/Exception
    //   1797	1807	1779	java/lang/Exception
  }
  
  public final void destroy()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(115709);
        if (!this.gkP)
        {
          AppMethodBeat.o(115709);
          return;
        }
        ac.i("MicroMsg.FilterRenderer", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        if (this.APV != null)
        {
          localObject1 = this.APV;
          ac.i("MicroMsg.FilterProcessTex", "clear %s %d", new Object[] { localObject1, Long.valueOf(Thread.currentThread().getId()) });
        }
        try
        {
          if (((a)localObject1).fZP != null)
          {
            ((a)localObject1).fZP.destroy();
            ((a)localObject1).fZP = null;
          }
          ((a)localObject1).APv = null;
          ((a)localObject1).APw = null;
          ((a)localObject1).aVG = false;
          if (((a)localObject1).wxR != null)
          {
            ((a)localObject1).wxR.release();
            ((a)localObject1).wxR = null;
          }
        }
        catch (Exception localException)
        {
          d locald1;
          d locald2;
          d locald3;
          d locald4;
          d locald5;
          ac.printErrStackTrace("MicroMsg.FilterProcessTex", localException, "clear error: %s", new Object[] { localException.getMessage() });
          continue;
        }
        this.APV = null;
        Object localObject1 = this.APA;
        locald1 = this.APB;
        locald2 = this.APD;
        locald3 = this.APS;
        locald4 = this.gsb;
        i = 0;
        if (i < 5)
        {
          locald5 = new d[] { localObject1, locald1, locald2, locald3, locald4 }[i];
          if (locald5 == null) {
            break label385;
          }
          locald5.close();
        }
      }
      finally {}
      if (this.APQ != null) {
        this.APQ.close();
      }
      if (this.APR != null) {
        this.APR.close();
      }
      GLES20.glDeleteProgram(this.gWl);
      GLES20.glDeleteProgram(this.APC);
      this.APX = null;
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFinish();
      if (this.gWs != null) {
        this.gWs.clear();
      }
      if (this.gWz != null) {
        this.gWz.clear();
      }
      this.gWs = null;
      this.gWz = null;
      this.gkP = false;
      AppMethodBeat.o(115709);
      continue;
      label385:
      i += 1;
    }
  }
  
  public final com.tencent.mm.plugin.voip.video.b.a emQ()
  {
    AppMethodBeat.i(115714);
    if ((this.APV != null) && (this.APV.emN() != null) && (this.AOs != 0))
    {
      this.APZ.a(this.jbj, this.jbk, 2, this.APV.emN());
      com.tencent.mm.plugin.voip.video.b.a locala = this.APZ;
      AppMethodBeat.o(115714);
      return locala;
    }
    AppMethodBeat.o(115714);
    return null;
  }
  
  public final void in(int paramInt1, int paramInt2)
  {
    this.fMt = paramInt1;
    this.fMu = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.b
 * JD-Core Version:    0.7.0.1
 */