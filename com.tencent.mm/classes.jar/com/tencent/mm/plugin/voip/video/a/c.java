package com.tencent.mm.plugin.voip.video.a;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.filter.BeautyFaceList;
import com.tencent.ttpic.filter.BeautyTransformList;
import com.tencent.ttpic.filter.BrightnessAdjustmentFilter;
import com.tencent.ttpic.filter.RemodelFilter;
import com.tencent.ttpic.filter.SmoothBFilters;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public final class c
{
  public static final float[] eZq = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final float[] eZr = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  public static final float[] tHO = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  public volatile boolean eLc;
  private boolean eYf;
  public FloatBuffer eYu;
  public FloatBuffer eYv;
  public int eZe;
  public int eZf;
  public int eZg;
  public int eZh;
  public int eZi;
  public int eZj;
  public int eZk;
  public int eZl;
  private ByteBuffer eZm;
  private ByteBuffer eZn;
  private int gNA;
  private int gNB;
  private float[] gND;
  public float[] gNF;
  private int jgD;
  private int jgE;
  public int lBA;
  public FloatBuffer lBE;
  public FloatBuffer lBF;
  public float[] lBI;
  public float[] lBJ;
  public int lBK;
  public int lBL;
  public int lBM;
  public int lBO;
  public byte[] lBP;
  public int lBw;
  public int lBx;
  public int lBy;
  public int lBz;
  private int rotate;
  public byte[] tCl;
  int tGS;
  public int tHP;
  private ByteBuffer tHQ;
  private int tHR;
  private int tHS;
  public volatile b tHT;
  private boolean tHU;
  
  public c()
  {
    AppMethodBeat.i(5125);
    this.gND = new float[16];
    this.gNF = eZq;
    this.lBI = eZq;
    this.tHU = false;
    this.eLc = false;
    AppMethodBeat.o(5125);
  }
  
  private void HW(int paramInt)
  {
    AppMethodBeat.i(140212);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    GLES20.glViewport(0, 0, this.jgD, this.jgE);
    GLES20.glUseProgram(this.tHP);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glUniform1i(this.lBz, 0);
    int i;
    if ((this.rotate == 0) || (this.rotate == 180))
    {
      paramInt = this.tHR;
      if ((this.rotate != 0) && (this.rotate != 180)) {
        break label482;
      }
      i = this.tHS;
      label147:
      if (paramInt / i >= this.jgD / this.jgE) {
        break label491;
      }
    }
    label482:
    label491:
    for (float f1 = this.jgD / paramInt;; f1 = this.jgE / i)
    {
      int j = (int)(this.jgD / f1);
      int k = (int)(this.jgE / f1);
      Matrix.setIdentityM(this.gND, 0);
      if (this.rotate > 0) {
        Matrix.setRotateM(this.gND, 0, Math.abs(this.rotate - 180), 0.0F, 0.0F, -1.0F);
      }
      GLES20.glUniformMatrix4fv(this.lBA, 1, false, this.gND, 0);
      this.lBF.put(this.lBI);
      this.lBF.position(0);
      GLES20.glVertexAttribPointer(this.lBy, 2, 5126, false, 0, this.lBF);
      GLES20.glEnableVertexAttribArray(this.lBy);
      f1 = (paramInt - j) / 2.0F / paramInt;
      float f2 = 1.0F - f1;
      float f3 = (i - k) / 2.0F / i;
      float f4 = 1.0F - f3;
      this.lBJ[0] = f3;
      this.lBJ[1] = f1;
      this.lBJ[2] = f4;
      this.lBJ[3] = f1;
      this.lBJ[4] = f3;
      this.lBJ[5] = f2;
      this.lBJ[6] = f4;
      this.lBJ[7] = f2;
      this.lBE.put(this.lBJ);
      this.lBE.position(0);
      GLES20.glVertexAttribPointer(this.lBx, 2, 5126, false, 0, this.lBE);
      GLES20.glEnableVertexAttribArray(this.lBx);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.lBy);
      GLES20.glDisableVertexAttribArray(this.lBx);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUseProgram(0);
      AppMethodBeat.o(140212);
      return;
      paramInt = this.tHS;
      break;
      i = this.tHR;
      break label147;
    }
  }
  
  private static int M(String paramString, int paramInt)
  {
    AppMethodBeat.i(5130);
    int[] arrayOfInt = new int[1];
    paramInt = GLES20.glCreateShader(paramInt);
    GLES20.glShaderSource(paramInt, paramString);
    GLES20.glCompileShader(paramInt);
    GLES20.glGetShaderiv(paramInt, 35713, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(paramInt));
      AppMethodBeat.o(5130);
      return 0;
    }
    AppMethodBeat.o(5130);
    return paramInt;
  }
  
  public static int Vm()
  {
    AppMethodBeat.i(5129);
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, arrayOfInt[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9728);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glBindTexture(3553, 0);
    int i = arrayOfInt[0];
    AppMethodBeat.o(5129);
    return i;
  }
  
  public static int Vn()
  {
    AppMethodBeat.i(5132);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    if (arrayOfInt[0] == 0)
    {
      ab.e("MicroMsg.FilterRenderer", "gen frame buffer error");
      AppMethodBeat.o(5132);
      return 0;
    }
    int i = arrayOfInt[0];
    AppMethodBeat.o(5132);
    return i;
  }
  
  public static int Z(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5131);
    int[] arrayOfInt = new int[1];
    int i = M(paramString1, 35633);
    if (i == 0)
    {
      ab.e("MicroMsg.FilterRenderer", "load vertex shader failed");
      AppMethodBeat.o(5131);
      return 0;
    }
    int j = M(paramString2, 35632);
    if (j == 0)
    {
      ab.e("MicroMsg.FilterRenderer", "load fragment shader failed");
      AppMethodBeat.o(5131);
      return 0;
    }
    int k = GLES20.glCreateProgram();
    GLES20.glAttachShader(k, i);
    GLES20.glAttachShader(k, j);
    GLES20.glLinkProgram(k);
    GLES20.glGetProgramiv(k, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] <= 0)
    {
      ab.e("MicroMsg.FilterRenderer", "link program failed");
      AppMethodBeat.o(5131);
      return 0;
    }
    GLES20.glDeleteShader(i);
    GLES20.glDeleteShader(j);
    AppMethodBeat.o(5131);
    return k;
  }
  
  /* Error */
  public final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 5126
    //   5: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   12: iload_2
    //   13: if_icmpne +2482 -> 2495
    //   16: aload_0
    //   17: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   20: iload_3
    //   21: if_icmpeq +2468 -> 2489
    //   24: goto +2471 -> 2495
    //   27: aload_0
    //   28: iload_2
    //   29: putfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   32: aload_0
    //   33: iload_3
    //   34: putfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   37: iload 4
    //   39: iconst_2
    //   40: ishr
    //   41: iconst_3
    //   42: iand
    //   43: istore_2
    //   44: iload_2
    //   45: iconst_3
    //   46: if_icmpne +1207 -> 1253
    //   49: aload_0
    //   50: sipush 270
    //   53: putfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   56: goto +2445 -> 2501
    //   59: aload_0
    //   60: iload 10
    //   62: putfield 278	com/tencent/mm/plugin/voip/video/a/c:eYf	Z
    //   65: getstatic 283	com/tencent/mm/plugin/voip/video/OpenGlRender:tGO	I
    //   68: iconst_1
    //   69: if_icmpeq +1209 -> 1278
    //   72: iconst_1
    //   73: istore 10
    //   75: aload_0
    //   76: iload 10
    //   78: putfield 84	com/tencent/mm/plugin/voip/video/a/c:tHU	Z
    //   81: aload_0
    //   82: iload 5
    //   84: putfield 285	com/tencent/mm/plugin/voip/video/a/c:tGS	I
    //   87: aload_0
    //   88: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   91: ifnonnull +34 -> 125
    //   94: iload 5
    //   96: ifeq +29 -> 125
    //   99: aload_0
    //   100: new 289	com/tencent/mm/plugin/voip/video/a/b
    //   103: dup
    //   104: invokespecial 290	com/tencent/mm/plugin/voip/video/a/b:<init>	()V
    //   107: putfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   110: aload_0
    //   111: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   114: aload_0
    //   115: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   118: aload_0
    //   119: getfield 294	com/tencent/mm/plugin/voip/video/a/c:lBO	I
    //   122: invokevirtual 297	com/tencent/mm/plugin/voip/video/a/b:initial	(II)V
    //   125: fconst_0
    //   126: fconst_0
    //   127: fconst_0
    //   128: fconst_0
    //   129: invokestatic 97	android/opengl/GLES20:glClearColor	(FFFF)V
    //   132: sipush 16640
    //   135: invokestatic 100	android/opengl/GLES20:glClear	(I)V
    //   138: aload_0
    //   139: getfield 84	com/tencent/mm/plugin/voip/video/a/c:tHU	Z
    //   142: ifeq +1156 -> 1298
    //   145: aload_0
    //   146: getfield 299	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   149: ifeq +664 -> 813
    //   152: aload_0
    //   153: getfield 301	com/tencent/mm/plugin/voip/video/a/c:eZe	I
    //   156: iconst_m1
    //   157: if_icmpeq +656 -> 813
    //   160: aload_0
    //   161: getfield 303	com/tencent/mm/plugin/voip/video/a/c:eZf	I
    //   164: iconst_m1
    //   165: if_icmpeq +648 -> 813
    //   168: aload_0
    //   169: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   172: ifle +641 -> 813
    //   175: aload_0
    //   176: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   179: ifle +634 -> 813
    //   182: aload_1
    //   183: ifnull +630 -> 813
    //   186: aload_0
    //   187: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   190: ifnull +50 -> 240
    //   193: aload_0
    //   194: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   197: ifnull +43 -> 240
    //   200: aload_0
    //   201: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   204: invokevirtual 312	java/nio/ByteBuffer:capacity	()I
    //   207: aload_0
    //   208: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   211: aload_0
    //   212: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   215: imul
    //   216: if_icmpne +24 -> 240
    //   219: aload_0
    //   220: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   223: invokevirtual 312	java/nio/ByteBuffer:capacity	()I
    //   226: aload_0
    //   227: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   230: aload_0
    //   231: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   234: imul
    //   235: iconst_2
    //   236: idiv
    //   237: if_icmpeq +59 -> 296
    //   240: aload_0
    //   241: aload_0
    //   242: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   245: aload_0
    //   246: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   249: imul
    //   250: invokestatic 316	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   253: putfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   256: aload_0
    //   257: aload_0
    //   258: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   261: aload_0
    //   262: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   265: imul
    //   266: iconst_2
    //   267: idiv
    //   268: invokestatic 316	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   271: putfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   274: aload_0
    //   275: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   278: invokestatic 322	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   281: invokevirtual 326	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   284: pop
    //   285: aload_0
    //   286: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   289: invokestatic 322	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   292: invokevirtual 326	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   295: pop
    //   296: aload_0
    //   297: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   300: aload_1
    //   301: iconst_0
    //   302: aload_0
    //   303: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   306: aload_0
    //   307: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   310: imul
    //   311: invokevirtual 329	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   314: pop
    //   315: aload_0
    //   316: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   319: iconst_0
    //   320: invokevirtual 330	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   323: pop
    //   324: aload_0
    //   325: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   328: aload_1
    //   329: aload_0
    //   330: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   333: aload_0
    //   334: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   337: imul
    //   338: aload_0
    //   339: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   342: aload_0
    //   343: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   346: imul
    //   347: iconst_2
    //   348: idiv
    //   349: invokevirtual 329	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   352: pop
    //   353: aload_0
    //   354: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   357: iconst_0
    //   358: invokevirtual 330	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   361: pop
    //   362: ldc_w 331
    //   365: aload_0
    //   366: getfield 333	com/tencent/mm/plugin/voip/video/a/c:lBK	I
    //   369: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   372: sipush 3553
    //   375: aload_0
    //   376: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   379: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   387: putfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   395: putfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   398: sipush 3553
    //   401: iconst_0
    //   402: sipush 6408
    //   405: aload_0
    //   406: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   409: aload_0
    //   410: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   413: iconst_0
    //   414: sipush 6408
    //   417: sipush 5121
    //   420: aconst_null
    //   421: invokestatic 340	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   424: ldc_w 331
    //   427: ldc_w 341
    //   430: sipush 3553
    //   433: aload_0
    //   434: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   437: iconst_0
    //   438: invokestatic 345	android/opengl/GLES20:glFramebufferTexture2D	(IIIII)V
    //   441: sipush 3553
    //   444: iconst_0
    //   445: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_0
    //   451: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   454: aload_0
    //   455: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   458: invokestatic 108	android/opengl/GLES20:glViewport	(IIII)V
    //   461: aload_0
    //   462: getfield 299	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   465: invokestatic 113	android/opengl/GLES20:glUseProgram	(I)V
    //   468: ldc 114
    //   470: invokestatic 117	android/opengl/GLES20:glActiveTexture	(I)V
    //   473: sipush 3553
    //   476: aload_0
    //   477: getfield 301	com/tencent/mm/plugin/voip/video/a/c:eZe	I
    //   480: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   483: sipush 3553
    //   486: iconst_0
    //   487: sipush 6409
    //   490: aload_0
    //   491: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   494: aload_0
    //   495: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   498: iconst_0
    //   499: sipush 6409
    //   502: sipush 5121
    //   505: aload_0
    //   506: getfield 305	com/tencent/mm/plugin/voip/video/a/c:eZm	Ljava/nio/ByteBuffer;
    //   509: invokestatic 340	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   512: sipush 3553
    //   515: sipush 10241
    //   518: ldc 122
    //   520: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   523: sipush 3553
    //   526: sipush 10240
    //   529: ldc 122
    //   531: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   534: sipush 3553
    //   537: sipush 10242
    //   540: ldc 127
    //   542: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   545: sipush 3553
    //   548: sipush 10243
    //   551: ldc 127
    //   553: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   556: aload_0
    //   557: getfield 347	com/tencent/mm/plugin/voip/video/a/c:eZj	I
    //   560: iconst_0
    //   561: invokestatic 132	android/opengl/GLES20:glUniform1i	(II)V
    //   564: ldc_w 348
    //   567: invokestatic 117	android/opengl/GLES20:glActiveTexture	(I)V
    //   570: sipush 3553
    //   573: aload_0
    //   574: getfield 303	com/tencent/mm/plugin/voip/video/a/c:eZf	I
    //   577: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   580: sipush 3553
    //   583: iconst_0
    //   584: sipush 6410
    //   587: aload_0
    //   588: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   591: iconst_2
    //   592: idiv
    //   593: aload_0
    //   594: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   597: iconst_2
    //   598: idiv
    //   599: iconst_0
    //   600: sipush 6410
    //   603: sipush 5121
    //   606: aload_0
    //   607: getfield 307	com/tencent/mm/plugin/voip/video/a/c:eZn	Ljava/nio/ByteBuffer;
    //   610: invokestatic 340	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   613: sipush 3553
    //   616: sipush 10241
    //   619: ldc 122
    //   621: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   624: sipush 3553
    //   627: sipush 10240
    //   630: ldc 122
    //   632: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   635: sipush 3553
    //   638: sipush 10242
    //   641: ldc 127
    //   643: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   646: sipush 3553
    //   649: sipush 10243
    //   652: ldc 127
    //   654: invokestatic 126	android/opengl/GLES20:glTexParameterf	(IIF)V
    //   657: aload_0
    //   658: getfield 350	com/tencent/mm/plugin/voip/video/a/c:eZk	I
    //   661: iconst_1
    //   662: invokestatic 132	android/opengl/GLES20:glUniform1i	(II)V
    //   665: aload_0
    //   666: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   669: iconst_0
    //   670: invokestatic 144	android/opengl/Matrix:setIdentityM	([FI)V
    //   673: aload_0
    //   674: getfield 278	com/tencent/mm/plugin/voip/video/a/c:eYf	Z
    //   677: ifeq +607 -> 1284
    //   680: aload_0
    //   681: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   684: iconst_0
    //   685: ldc 60
    //   687: fconst_1
    //   688: fconst_1
    //   689: invokestatic 354	android/opengl/Matrix:scaleM	([FIFFF)V
    //   692: aload_0
    //   693: getfield 356	com/tencent/mm/plugin/voip/video/a/c:eZl	I
    //   696: iconst_1
    //   697: iconst_0
    //   698: aload_0
    //   699: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   702: iconst_0
    //   703: invokestatic 160	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   706: aload_0
    //   707: getfield 358	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   710: iconst_0
    //   711: invokevirtual 172	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   714: pop
    //   715: aload_0
    //   716: getfield 360	com/tencent/mm/plugin/voip/video/a/c:eZi	I
    //   719: iconst_2
    //   720: sipush 5126
    //   723: iconst_0
    //   724: iconst_0
    //   725: aload_0
    //   726: getfield 358	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   729: invokestatic 178	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   732: aload_0
    //   733: getfield 360	com/tencent/mm/plugin/voip/video/a/c:eZi	I
    //   736: invokestatic 181	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   739: aload_0
    //   740: getfield 362	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   743: iconst_0
    //   744: invokevirtual 172	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   747: pop
    //   748: aload_0
    //   749: getfield 364	com/tencent/mm/plugin/voip/video/a/c:eZh	I
    //   752: iconst_2
    //   753: sipush 5126
    //   756: iconst_0
    //   757: iconst_0
    //   758: aload_0
    //   759: getfield 362	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   762: invokestatic 178	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   765: aload_0
    //   766: getfield 364	com/tencent/mm/plugin/voip/video/a/c:eZh	I
    //   769: invokestatic 181	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   772: iconst_5
    //   773: iconst_0
    //   774: iconst_4
    //   775: invokestatic 191	android/opengl/GLES20:glDrawArrays	(III)V
    //   778: aload_0
    //   779: getfield 360	com/tencent/mm/plugin/voip/video/a/c:eZi	I
    //   782: invokestatic 194	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   785: aload_0
    //   786: getfield 364	com/tencent/mm/plugin/voip/video/a/c:eZh	I
    //   789: invokestatic 194	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   792: sipush 3553
    //   795: iconst_0
    //   796: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   799: ldc_w 331
    //   802: iconst_0
    //   803: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   806: iconst_0
    //   807: invokestatic 113	android/opengl/GLES20:glUseProgram	(I)V
    //   810: invokestatic 367	android/opengl/GLES20:glFinish	()V
    //   813: iload 5
    //   815: ifeq +105 -> 920
    //   818: aload_0
    //   819: getfield 369	com/tencent/mm/plugin/voip/video/a/c:lBP	[B
    //   822: ifnull +8 -> 830
    //   825: iload 9
    //   827: ifeq +93 -> 920
    //   830: ldc 239
    //   832: ldc_w 371
    //   835: iconst_5
    //   836: anewarray 4	java/lang/Object
    //   839: dup
    //   840: iconst_0
    //   841: aload_0
    //   842: invokevirtual 374	java/lang/Object:hashCode	()I
    //   845: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   848: aastore
    //   849: dup
    //   850: iconst_1
    //   851: aload_0
    //   852: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   855: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   858: aastore
    //   859: dup
    //   860: iconst_2
    //   861: aload_0
    //   862: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   865: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: dup
    //   870: iconst_3
    //   871: aload_0
    //   872: getfield 102	com/tencent/mm/plugin/voip/video/a/c:jgD	I
    //   875: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   878: aastore
    //   879: dup
    //   880: iconst_4
    //   881: aload_0
    //   882: getfield 104	com/tencent/mm/plugin/voip/video/a/c:jgE	I
    //   885: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   888: aastore
    //   889: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   892: aload_0
    //   893: aload_0
    //   894: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   897: aload_0
    //   898: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   901: imul
    //   902: iconst_4
    //   903: imul
    //   904: newarray byte
    //   906: putfield 369	com/tencent/mm/plugin/voip/video/a/c:lBP	[B
    //   909: aload_0
    //   910: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   913: aload_0
    //   914: getfield 369	com/tencent/mm/plugin/voip/video/a/c:lBP	[B
    //   917: putfield 386	com/tencent/mm/plugin/voip/video/a/b:ltm	[B
    //   920: iload 5
    //   922: ifeq +1541 -> 2463
    //   925: aload_0
    //   926: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   929: astore_1
    //   930: aload_0
    //   931: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   934: istore_2
    //   935: aload_0
    //   936: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   939: istore_3
    //   940: iload_3
    //   941: aload_1
    //   942: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   945: if_icmpne +11 -> 956
    //   948: iload_2
    //   949: aload_1
    //   950: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   953: if_icmpeq +48 -> 1001
    //   956: aload_1
    //   957: iload_2
    //   958: putfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   961: aload_1
    //   962: iload_3
    //   963: putfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   966: iload_2
    //   967: putstatic 397	com/tencent/ttpic/config/MediaConfig:VIDEO_OUTPUT_WIDTH	I
    //   970: iload_3
    //   971: putstatic 400	com/tencent/ttpic/config/MediaConfig:VIDEO_OUTPUT_HEIGHT	I
    //   974: ldc_w 402
    //   977: ldc_w 404
    //   980: iconst_2
    //   981: anewarray 4	java/lang/Object
    //   984: dup
    //   985: iconst_0
    //   986: iload_2
    //   987: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   990: aastore
    //   991: dup
    //   992: iconst_1
    //   993: iload_3
    //   994: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   997: aastore
    //   998: invokestatic 383	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1001: aload_0
    //   1002: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   1005: aload_0
    //   1006: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   1009: putfield 407	com/tencent/mm/plugin/voip/video/a/b:eYd	I
    //   1012: aload_0
    //   1013: getfield 287	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   1016: astore 16
    //   1018: aload_0
    //   1019: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1022: istore_2
    //   1023: invokestatic 413	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   1026: lstore 13
    //   1028: aload 16
    //   1030: aload 16
    //   1032: getfield 416	com/tencent/mm/plugin/voip/video/a/b:frameIndex	I
    //   1035: iconst_1
    //   1036: iadd
    //   1037: iconst_2
    //   1038: irem
    //   1039: putfield 416	com/tencent/mm/plugin/voip/video/a/b:frameIndex	I
    //   1042: aload 16
    //   1044: getfield 420	com/tencent/mm/plugin/voip/video/a/b:lth	Lcom/tencent/filter/BaseFilter;
    //   1047: aload 16
    //   1049: getfield 407	com/tencent/mm/plugin/voip/video/a/b:eYd	I
    //   1052: aload 16
    //   1054: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   1057: aload 16
    //   1059: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   1062: iconst_m1
    //   1063: dconst_1
    //   1064: aload 16
    //   1066: getfield 424	com/tencent/mm/plugin/voip/video/a/b:lti	Lcom/tencent/filter/h;
    //   1069: invokevirtual 430	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/filter/h;)V
    //   1072: aload 16
    //   1074: getfield 424	com/tencent/mm/plugin/voip/video/a/b:lti	Lcom/tencent/filter/h;
    //   1077: invokestatic 436	com/tencent/ttpic/util/FrameUtil:getLastRenderFrame	(Lcom/tencent/filter/h;)Lcom/tencent/filter/h;
    //   1080: astore_1
    //   1081: aload 16
    //   1083: getfield 439	com/tencent/mm/plugin/voip/video/a/b:mSwapCopyFilter	Lcom/tencent/filter/BaseFilter;
    //   1086: aload_1
    //   1087: getfield 445	com/tencent/filter/h:texture	[I
    //   1090: iconst_0
    //   1091: iaload
    //   1092: aload 16
    //   1094: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   1097: aload 16
    //   1099: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   1102: iconst_m1
    //   1103: dconst_0
    //   1104: aload 16
    //   1106: getfield 449	com/tencent/mm/plugin/voip/video/a/b:mSwapFrames	[Lcom/tencent/filter/h;
    //   1109: aload 16
    //   1111: getfield 416	com/tencent/mm/plugin/voip/video/a/b:frameIndex	I
    //   1114: aaload
    //   1115: invokevirtual 430	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/filter/h;)V
    //   1118: aload 16
    //   1120: getfield 449	com/tencent/mm/plugin/voip/video/a/b:mSwapFrames	[Lcom/tencent/filter/h;
    //   1123: aload 16
    //   1125: getfield 416	com/tencent/mm/plugin/voip/video/a/b:frameIndex	I
    //   1128: aaload
    //   1129: astore_1
    //   1130: getstatic 452	com/tencent/mm/plugin/voip/video/a/b:lte	Z
    //   1133: ifne +645 -> 1778
    //   1136: aload 16
    //   1138: getfield 455	com/tencent/mm/plugin/voip/video/a/b:mCopyFilter	Lcom/tencent/filter/BaseFilter;
    //   1141: aload_1
    //   1142: getfield 445	com/tencent/filter/h:texture	[I
    //   1145: iconst_0
    //   1146: iaload
    //   1147: aload 16
    //   1149: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   1152: aload 16
    //   1154: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   1157: aload 16
    //   1159: getfield 458	com/tencent/mm/plugin/voip/video/a/b:ltl	I
    //   1162: dconst_1
    //   1163: aload 16
    //   1165: getfield 461	com/tencent/mm/plugin/voip/video/a/b:mTempFrame	Lcom/tencent/filter/h;
    //   1168: invokevirtual 430	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/filter/h;)V
    //   1171: aload 16
    //   1173: getfield 386	com/tencent/mm/plugin/voip/video/a/b:ltm	[B
    //   1176: ifnull +32 -> 1208
    //   1179: aload_1
    //   1180: getfield 445	com/tencent/filter/h:texture	[I
    //   1183: iconst_0
    //   1184: iaload
    //   1185: aload 16
    //   1187: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   1190: aload 16
    //   1192: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   1195: aload 16
    //   1197: getfield 386	com/tencent/mm/plugin/voip/video/a/b:ltm	[B
    //   1200: aload 16
    //   1202: getfield 464	com/tencent/mm/plugin/voip/video/a/b:ltn	I
    //   1205: invokestatic 470	com/tencent/view/g:a	(III[BI)V
    //   1208: ldc_w 331
    //   1211: iconst_0
    //   1212: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1215: sipush 3553
    //   1218: iconst_0
    //   1219: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1222: aload_0
    //   1223: aload_0
    //   1224: getfield 294	com/tencent/mm/plugin/voip/video/a/c:lBO	I
    //   1227: invokespecial 472	com/tencent/mm/plugin/voip/video/a/c:HW	(I)V
    //   1230: ldc_w 331
    //   1233: iconst_0
    //   1234: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1237: sipush 3553
    //   1240: iconst_0
    //   1241: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1244: sipush 5126
    //   1247: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1250: aload_0
    //   1251: monitorexit
    //   1252: return
    //   1253: iload_2
    //   1254: iconst_1
    //   1255: if_icmpne +1246 -> 2501
    //   1258: aload_0
    //   1259: bipush 90
    //   1261: putfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1264: goto +1237 -> 2501
    //   1267: astore_1
    //   1268: aload_0
    //   1269: monitorexit
    //   1270: aload_1
    //   1271: athrow
    //   1272: iconst_0
    //   1273: istore 10
    //   1275: goto -1216 -> 59
    //   1278: iconst_0
    //   1279: istore 10
    //   1281: goto -1206 -> 75
    //   1284: aload_0
    //   1285: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   1288: iconst_0
    //   1289: fconst_1
    //   1290: fconst_1
    //   1291: fconst_1
    //   1292: invokestatic 354	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1295: goto -603 -> 692
    //   1298: aload_0
    //   1299: getfield 110	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   1302: ifeq -489 -> 813
    //   1305: aload_0
    //   1306: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   1309: iconst_m1
    //   1310: if_icmpeq -497 -> 813
    //   1313: aload_0
    //   1314: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1317: ifle -504 -> 813
    //   1320: aload_0
    //   1321: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1324: ifle -511 -> 813
    //   1327: aload_1
    //   1328: ifnull -515 -> 813
    //   1331: aload_0
    //   1332: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1335: ifnull +24 -> 1359
    //   1338: aload_0
    //   1339: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1342: invokevirtual 312	java/nio/ByteBuffer:capacity	()I
    //   1345: aload_0
    //   1346: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1349: aload_0
    //   1350: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1353: imul
    //   1354: iconst_4
    //   1355: imul
    //   1356: if_icmpeq +32 -> 1388
    //   1359: aload_0
    //   1360: aload_0
    //   1361: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1364: aload_0
    //   1365: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1368: imul
    //   1369: iconst_4
    //   1370: imul
    //   1371: invokestatic 316	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1374: putfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1377: aload_0
    //   1378: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1381: invokestatic 322	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   1384: invokevirtual 326	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   1387: pop
    //   1388: aload_0
    //   1389: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1392: aload_1
    //   1393: iconst_0
    //   1394: aload_0
    //   1395: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1398: aload_0
    //   1399: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1402: imul
    //   1403: iconst_4
    //   1404: imul
    //   1405: invokevirtual 329	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1408: pop
    //   1409: aload_0
    //   1410: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1413: iconst_0
    //   1414: invokevirtual 330	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1417: pop
    //   1418: ldc_w 331
    //   1421: aload_0
    //   1422: getfield 333	com/tencent/mm/plugin/voip/video/a/c:lBK	I
    //   1425: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1428: sipush 3553
    //   1431: aload_0
    //   1432: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   1435: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1438: aload_0
    //   1439: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1442: sipush 180
    //   1445: if_icmpeq +10 -> 1455
    //   1448: aload_0
    //   1449: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1452: ifne +310 -> 1762
    //   1455: aload_0
    //   1456: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1459: istore_2
    //   1460: aload_0
    //   1461: iload_2
    //   1462: putfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   1465: aload_0
    //   1466: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1469: sipush 180
    //   1472: if_icmpeq +10 -> 1482
    //   1475: aload_0
    //   1476: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1479: ifne +291 -> 1770
    //   1482: aload_0
    //   1483: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1486: istore_2
    //   1487: aload_0
    //   1488: iload_2
    //   1489: putfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   1492: sipush 3553
    //   1495: iconst_0
    //   1496: sipush 6408
    //   1499: aload_0
    //   1500: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   1503: aload_0
    //   1504: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   1507: iconst_0
    //   1508: sipush 6408
    //   1511: sipush 5121
    //   1514: aconst_null
    //   1515: invokestatic 340	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   1518: sipush 3553
    //   1521: iconst_0
    //   1522: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1525: ldc_w 331
    //   1528: ldc_w 341
    //   1531: sipush 3553
    //   1534: aload_0
    //   1535: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   1538: iconst_0
    //   1539: invokestatic 345	android/opengl/GLES20:glFramebufferTexture2D	(IIIII)V
    //   1542: aload_0
    //   1543: getfield 110	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   1546: invokestatic 113	android/opengl/GLES20:glUseProgram	(I)V
    //   1549: ldc 114
    //   1551: invokestatic 117	android/opengl/GLES20:glActiveTexture	(I)V
    //   1554: sipush 3553
    //   1557: aload_0
    //   1558: getfield 476	com/tencent/mm/plugin/voip/video/a/c:lBw	I
    //   1561: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1564: sipush 3553
    //   1567: iconst_0
    //   1568: sipush 6408
    //   1571: aload_0
    //   1572: getfield 136	com/tencent/mm/plugin/voip/video/a/c:tHR	I
    //   1575: aload_0
    //   1576: getfield 138	com/tencent/mm/plugin/voip/video/a/c:tHS	I
    //   1579: iconst_0
    //   1580: sipush 6408
    //   1583: sipush 5121
    //   1586: aload_0
    //   1587: getfield 474	com/tencent/mm/plugin/voip/video/a/c:tHQ	Ljava/nio/ByteBuffer;
    //   1590: invokestatic 340	android/opengl/GLES20:glTexImage2D	(IIIIIIIILjava/nio/Buffer;)V
    //   1593: aload_0
    //   1594: getfield 129	com/tencent/mm/plugin/voip/video/a/c:lBz	I
    //   1597: iconst_0
    //   1598: invokestatic 132	android/opengl/GLES20:glUniform1i	(II)V
    //   1601: aload_0
    //   1602: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   1605: iconst_0
    //   1606: invokestatic 144	android/opengl/Matrix:setIdentityM	([FI)V
    //   1609: aload_0
    //   1610: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   1613: iconst_0
    //   1614: aload_0
    //   1615: getfield 134	com/tencent/mm/plugin/voip/video/a/c:rotate	I
    //   1618: i2f
    //   1619: fconst_0
    //   1620: fconst_0
    //   1621: ldc 60
    //   1623: invokestatic 154	android/opengl/Matrix:setRotateM	([FIFFFF)V
    //   1626: aload_0
    //   1627: getfield 278	com/tencent/mm/plugin/voip/video/a/c:eYf	Z
    //   1630: ifeq +15 -> 1645
    //   1633: aload_0
    //   1634: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   1637: iconst_0
    //   1638: fconst_1
    //   1639: ldc 60
    //   1641: fconst_1
    //   1642: invokestatic 354	android/opengl/Matrix:scaleM	([FIFFF)V
    //   1645: aload_0
    //   1646: getfield 156	com/tencent/mm/plugin/voip/video/a/c:lBA	I
    //   1649: iconst_1
    //   1650: iconst_0
    //   1651: aload_0
    //   1652: getfield 78	com/tencent/mm/plugin/voip/video/a/c:gND	[F
    //   1655: iconst_0
    //   1656: invokestatic 160	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   1659: aload_0
    //   1660: getfield 358	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   1663: iconst_0
    //   1664: invokevirtual 172	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1667: pop
    //   1668: aload_0
    //   1669: getfield 174	com/tencent/mm/plugin/voip/video/a/c:lBy	I
    //   1672: iconst_2
    //   1673: sipush 5126
    //   1676: iconst_0
    //   1677: iconst_0
    //   1678: aload_0
    //   1679: getfield 358	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   1682: invokestatic 178	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   1685: aload_0
    //   1686: getfield 174	com/tencent/mm/plugin/voip/video/a/c:lBy	I
    //   1689: invokestatic 181	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   1692: aload_0
    //   1693: getfield 362	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   1696: iconst_0
    //   1697: invokevirtual 172	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   1700: pop
    //   1701: aload_0
    //   1702: getfield 187	com/tencent/mm/plugin/voip/video/a/c:lBx	I
    //   1705: iconst_2
    //   1706: sipush 5126
    //   1709: iconst_0
    //   1710: iconst_0
    //   1711: aload_0
    //   1712: getfield 362	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   1715: invokestatic 178	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   1718: aload_0
    //   1719: getfield 187	com/tencent/mm/plugin/voip/video/a/c:lBx	I
    //   1722: invokestatic 181	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   1725: iconst_5
    //   1726: iconst_0
    //   1727: iconst_4
    //   1728: invokestatic 191	android/opengl/GLES20:glDrawArrays	(III)V
    //   1731: aload_0
    //   1732: getfield 174	com/tencent/mm/plugin/voip/video/a/c:lBy	I
    //   1735: invokestatic 194	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   1738: aload_0
    //   1739: getfield 187	com/tencent/mm/plugin/voip/video/a/c:lBx	I
    //   1742: invokestatic 194	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   1745: sipush 3553
    //   1748: iconst_0
    //   1749: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   1752: ldc_w 331
    //   1755: iconst_0
    //   1756: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   1759: goto -946 -> 813
    //   1762: aload_0
    //   1763: getfield 276	com/tencent/mm/plugin/voip/video/a/c:gNB	I
    //   1766: istore_2
    //   1767: goto -307 -> 1460
    //   1770: aload_0
    //   1771: getfield 274	com/tencent/mm/plugin/voip/video/a/c:gNA	I
    //   1774: istore_2
    //   1775: goto -288 -> 1487
    //   1778: iload 5
    //   1780: iconst_1
    //   1781: iand
    //   1782: ifeq +750 -> 2532
    //   1785: iconst_1
    //   1786: istore 11
    //   1788: iload 5
    //   1790: iconst_2
    //   1791: iand
    //   1792: ifeq +746 -> 2538
    //   1795: iconst_1
    //   1796: istore 10
    //   1798: iload 5
    //   1800: iconst_4
    //   1801: iand
    //   1802: ifeq +742 -> 2544
    //   1805: iconst_1
    //   1806: istore 12
    //   1808: ldc_w 402
    //   1811: ldc_w 478
    //   1814: iconst_4
    //   1815: anewarray 4	java/lang/Object
    //   1818: dup
    //   1819: iconst_0
    //   1820: iload 11
    //   1822: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1825: aastore
    //   1826: dup
    //   1827: iconst_1
    //   1828: iload 10
    //   1830: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1833: aastore
    //   1834: dup
    //   1835: iconst_2
    //   1836: iload 12
    //   1838: invokestatic 483	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1841: aastore
    //   1842: dup
    //   1843: iconst_3
    //   1844: iload_2
    //   1845: invokestatic 380	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1848: aastore
    //   1849: invokestatic 486	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1852: aload 16
    //   1854: getfield 490	com/tencent/mm/plugin/voip/video/a/b:ltk	Lcom/tencent/mm/bw/a;
    //   1857: aload_1
    //   1858: iconst_0
    //   1859: iconst_0
    //   1860: iconst_0
    //   1861: iload_2
    //   1862: invokevirtual 495	com/tencent/mm/bw/a:a	(Lcom/tencent/filter/h;ZZZI)Lcom/tencent/ttpic/PTFaceAttr;
    //   1865: astore 17
    //   1867: aload 17
    //   1869: ifnull +617 -> 2486
    //   1872: aload 17
    //   1874: invokevirtual 501	com/tencent/ttpic/PTFaceAttr:getOrigFrame	()Lcom/tencent/filter/h;
    //   1877: astore_1
    //   1878: aload 17
    //   1880: invokevirtual 505	com/tencent/ttpic/PTFaceAttr:getHistogram	()Landroid/util/Pair;
    //   1883: getfield 511	android/util/Pair:first	Ljava/lang/Object;
    //   1886: checkcast 376	java/lang/Integer
    //   1889: invokevirtual 514	java/lang/Integer:intValue	()I
    //   1892: istore_2
    //   1893: iload_2
    //   1894: bipush 40
    //   1896: if_icmpgt +654 -> 2550
    //   1899: fconst_0
    //   1900: fstore 8
    //   1902: aload 16
    //   1904: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   1907: ifnull +610 -> 2517
    //   1910: aload 16
    //   1912: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   1915: fload 8
    //   1917: invokevirtual 524	com/tencent/ttpic/filter/BeautyFaceList:setNormalAlphaFactor	(F)V
    //   1920: goto +597 -> 2517
    //   1923: iload 12
    //   1925: ifeq +558 -> 2483
    //   1928: aload_1
    //   1929: astore 15
    //   1931: aload 17
    //   1933: ifnull +587 -> 2520
    //   1936: aload_1
    //   1937: astore 15
    //   1939: aload 17
    //   1941: invokevirtual 528	com/tencent/ttpic/PTFaceAttr:getBrightnessAdjustmentCurve	()[I
    //   1944: ifnull +576 -> 2520
    //   1947: aload_1
    //   1948: astore 15
    //   1950: aload 16
    //   1952: getfield 532	com/tencent/mm/plugin/voip/video/a/b:ltf	Lcom/tencent/ttpic/filter/BrightnessAdjustmentFilter;
    //   1955: ifnull +565 -> 2520
    //   1958: aload 16
    //   1960: getfield 532	com/tencent/mm/plugin/voip/video/a/b:ltf	Lcom/tencent/ttpic/filter/BrightnessAdjustmentFilter;
    //   1963: aload 17
    //   1965: invokevirtual 528	com/tencent/ttpic/PTFaceAttr:getBrightnessAdjustmentCurve	()[I
    //   1968: iconst_1
    //   1969: invokevirtual 538	com/tencent/ttpic/filter/BrightnessAdjustmentFilter:updateCurve	([IZ)V
    //   1972: aload 16
    //   1974: getfield 532	com/tencent/mm/plugin/voip/video/a/b:ltf	Lcom/tencent/ttpic/filter/BrightnessAdjustmentFilter;
    //   1977: aload_1
    //   1978: getfield 445	com/tencent/filter/h:texture	[I
    //   1981: iconst_0
    //   1982: iaload
    //   1983: aload 16
    //   1985: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   1988: aload 16
    //   1990: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   1993: iconst_m1
    //   1994: dconst_0
    //   1995: aload 16
    //   1997: getfield 541	com/tencent/mm/plugin/voip/video/a/b:ltj	Lcom/tencent/filter/h;
    //   2000: invokevirtual 542	com/tencent/ttpic/filter/BrightnessAdjustmentFilter:RenderProcess	(IIIIDLcom/tencent/filter/h;)V
    //   2003: aload 16
    //   2005: getfield 541	com/tencent/mm/plugin/voip/video/a/b:ltj	Lcom/tencent/filter/h;
    //   2008: astore 15
    //   2010: goto +510 -> 2520
    //   2013: iload 11
    //   2015: ifeq +465 -> 2480
    //   2018: aload_1
    //   2019: getfield 545	com/tencent/filter/h:width	I
    //   2022: ifle +455 -> 2477
    //   2025: aload_1
    //   2026: getfield 548	com/tencent/filter/h:height	I
    //   2029: ifle +448 -> 2477
    //   2032: aload 17
    //   2034: ifnull +443 -> 2477
    //   2037: aload 16
    //   2039: getfield 552	com/tencent/mm/plugin/voip/video/a/b:mSmoothBFilters	Lcom/tencent/ttpic/filter/SmoothBFilters;
    //   2042: ifnull +435 -> 2477
    //   2045: aload 17
    //   2047: invokevirtual 556	com/tencent/ttpic/PTFaceAttr:getAllFacePoints	()Ljava/util/List;
    //   2050: astore 15
    //   2052: aload_1
    //   2053: getfield 545	com/tencent/filter/h:width	I
    //   2056: i2d
    //   2057: aload 17
    //   2059: invokevirtual 560	com/tencent/ttpic/PTFaceAttr:getFaceDetectScale	()D
    //   2062: dmul
    //   2063: d2i
    //   2064: istore_2
    //   2065: aload_1
    //   2066: getfield 548	com/tencent/filter/h:height	I
    //   2069: i2d
    //   2070: aload 17
    //   2072: invokevirtual 560	com/tencent/ttpic/PTFaceAttr:getFaceDetectScale	()D
    //   2075: dmul
    //   2076: d2i
    //   2077: istore_3
    //   2078: aload 17
    //   2080: invokevirtual 563	com/tencent/ttpic/PTFaceAttr:getRotation	()I
    //   2083: istore 4
    //   2085: aload 16
    //   2087: getfield 552	com/tencent/mm/plugin/voip/video/a/b:mSmoothBFilters	Lcom/tencent/ttpic/filter/SmoothBFilters;
    //   2090: astore 18
    //   2092: aload 16
    //   2094: getfield 566	com/tencent/mm/plugin/voip/video/a/b:ltg	Z
    //   2097: ifne +465 -> 2562
    //   2100: iconst_1
    //   2101: istore 11
    //   2103: aload 18
    //   2105: iload 11
    //   2107: invokevirtual 572	com/tencent/ttpic/filter/SmoothBFilters:setOnlyDetFaceRectSkin	(Z)V
    //   2110: aload 16
    //   2112: getfield 552	com/tencent/mm/plugin/voip/video/a/b:mSmoothBFilters	Lcom/tencent/ttpic/filter/SmoothBFilters;
    //   2115: aload_1
    //   2116: aload 16
    //   2118: getfield 575	com/tencent/mm/plugin/voip/video/a/b:mBeautyFrame2	Lcom/tencent/filter/h;
    //   2121: aload 15
    //   2123: iload_2
    //   2124: iload_3
    //   2125: iload 4
    //   2127: invokevirtual 579	com/tencent/ttpic/filter/SmoothBFilters:updateAndRender	(Lcom/tencent/filter/h;Lcom/tencent/filter/h;Ljava/util/List;III)V
    //   2130: aload 16
    //   2132: getfield 575	com/tencent/mm/plugin/voip/video/a/b:mBeautyFrame2	Lcom/tencent/filter/h;
    //   2135: astore_1
    //   2136: aload_1
    //   2137: astore 15
    //   2139: aload 17
    //   2141: ifnull +385 -> 2526
    //   2144: aload_1
    //   2145: astore 15
    //   2147: aload 16
    //   2149: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   2152: ifnull +374 -> 2526
    //   2155: aload 16
    //   2157: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   2160: aload 16
    //   2162: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   2165: aload 16
    //   2167: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   2170: aload 17
    //   2172: invokevirtual 560	com/tencent/ttpic/PTFaceAttr:getFaceDetectScale	()D
    //   2175: invokevirtual 583	com/tencent/ttpic/filter/BeautyFaceList:updateVideoSize	(IID)V
    //   2178: aload 16
    //   2180: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   2183: aload 16
    //   2185: getfield 552	com/tencent/mm/plugin/voip/video/a/b:mSmoothBFilters	Lcom/tencent/ttpic/filter/SmoothBFilters;
    //   2188: invokevirtual 586	com/tencent/ttpic/filter/SmoothBFilters:getVarianceFrame	()Lcom/tencent/filter/h;
    //   2191: getfield 445	com/tencent/filter/h:texture	[I
    //   2194: iconst_0
    //   2195: iaload
    //   2196: invokevirtual 589	com/tencent/ttpic/filter/BeautyFaceList:setLightRemovePouchSkinTexture	(I)V
    //   2199: aload 16
    //   2201: getfield 518	com/tencent/mm/plugin/voip/video/a/b:mBeautyFaceList	Lcom/tencent/ttpic/filter/BeautyFaceList;
    //   2204: aload_1
    //   2205: aload 17
    //   2207: invokevirtual 556	com/tencent/ttpic/PTFaceAttr:getAllFacePoints	()Ljava/util/List;
    //   2210: invokevirtual 593	com/tencent/ttpic/filter/BeautyFaceList:render	(Lcom/tencent/filter/h;Ljava/util/List;)Lcom/tencent/filter/h;
    //   2213: astore 15
    //   2215: goto +311 -> 2526
    //   2218: aload_1
    //   2219: astore 15
    //   2221: iload 10
    //   2223: ifeq +94 -> 2317
    //   2226: aload_1
    //   2227: astore 15
    //   2229: aload 16
    //   2231: getfield 597	com/tencent/mm/plugin/voip/video/a/b:mBeautyTransformList	Lcom/tencent/ttpic/filter/BeautyTransformList;
    //   2234: ifnull +83 -> 2317
    //   2237: aload_1
    //   2238: astore 15
    //   2240: aload 17
    //   2242: ifnull +75 -> 2317
    //   2245: aload 17
    //   2247: invokevirtual 556	com/tencent/ttpic/PTFaceAttr:getAllFacePoints	()Ljava/util/List;
    //   2250: astore 18
    //   2252: aload 17
    //   2254: invokevirtual 560	com/tencent/ttpic/PTFaceAttr:getFaceDetectScale	()D
    //   2257: dstore 6
    //   2259: aload 17
    //   2261: invokevirtual 600	com/tencent/ttpic/PTFaceAttr:getAllFaceAngles	()Ljava/util/List;
    //   2264: astore 19
    //   2266: aload 17
    //   2268: invokevirtual 563	com/tencent/ttpic/PTFaceAttr:getRotation	()I
    //   2271: istore_2
    //   2272: aload 16
    //   2274: getfield 597	com/tencent/mm/plugin/voip/video/a/b:mBeautyTransformList	Lcom/tencent/ttpic/filter/BeautyTransformList;
    //   2277: aload_1
    //   2278: aload 18
    //   2280: dload 6
    //   2282: aload 19
    //   2284: iload_2
    //   2285: i2f
    //   2286: invokevirtual 606	com/tencent/ttpic/filter/BeautyTransformList:process	(Lcom/tencent/filter/h;Ljava/util/List;DLjava/util/List;F)Lcom/tencent/filter/h;
    //   2289: astore 15
    //   2291: aload 16
    //   2293: getfield 610	com/tencent/mm/plugin/voip/video/a/b:mRemodelFilter	Lcom/tencent/ttpic/filter/RemodelFilter;
    //   2296: ifnull +178 -> 2474
    //   2299: aload 16
    //   2301: getfield 610	com/tencent/mm/plugin/voip/video/a/b:mRemodelFilter	Lcom/tencent/ttpic/filter/RemodelFilter;
    //   2304: aload 15
    //   2306: aload 18
    //   2308: aload 19
    //   2310: dload 6
    //   2312: invokevirtual 615	com/tencent/ttpic/filter/RemodelFilter:process	(Lcom/tencent/filter/h;Ljava/util/List;Ljava/util/List;D)Lcom/tencent/filter/h;
    //   2315: astore 15
    //   2317: aload 16
    //   2319: getfield 455	com/tencent/mm/plugin/voip/video/a/b:mCopyFilter	Lcom/tencent/filter/BaseFilter;
    //   2322: aload 15
    //   2324: getfield 445	com/tencent/filter/h:texture	[I
    //   2327: iconst_0
    //   2328: iaload
    //   2329: aload 16
    //   2331: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   2334: aload 16
    //   2336: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   2339: aload 16
    //   2341: getfield 458	com/tencent/mm/plugin/voip/video/a/b:ltl	I
    //   2344: dconst_1
    //   2345: aload 16
    //   2347: getfield 461	com/tencent/mm/plugin/voip/video/a/b:mTempFrame	Lcom/tencent/filter/h;
    //   2350: invokevirtual 430	com/tencent/filter/BaseFilter:RenderProcess	(IIIIDLcom/tencent/filter/h;)V
    //   2353: aload 16
    //   2355: getfield 386	com/tencent/mm/plugin/voip/video/a/b:ltm	[B
    //   2358: ifnull +31 -> 2389
    //   2361: aload 16
    //   2363: getfield 458	com/tencent/mm/plugin/voip/video/a/b:ltl	I
    //   2366: aload 16
    //   2368: getfield 392	com/tencent/mm/plugin/voip/video/a/b:eYj	I
    //   2371: aload 16
    //   2373: getfield 389	com/tencent/mm/plugin/voip/video/a/b:eYk	I
    //   2376: aload 16
    //   2378: getfield 386	com/tencent/mm/plugin/voip/video/a/b:ltm	[B
    //   2381: aload 16
    //   2383: getfield 464	com/tencent/mm/plugin/voip/video/a/b:ltn	I
    //   2386: invokestatic 470	com/tencent/view/g:a	(III[BI)V
    //   2389: ldc_w 331
    //   2392: iconst_0
    //   2393: invokestatic 336	android/opengl/GLES20:glBindFramebuffer	(II)V
    //   2396: sipush 3553
    //   2399: iconst_0
    //   2400: invokestatic 121	android/opengl/GLES20:glBindTexture	(II)V
    //   2403: ldc_w 402
    //   2406: ldc_w 617
    //   2409: iconst_1
    //   2410: anewarray 4	java/lang/Object
    //   2413: dup
    //   2414: iconst_0
    //   2415: lload 13
    //   2417: invokestatic 621	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   2420: invokestatic 626	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2423: aastore
    //   2424: invokestatic 486	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2427: goto -1205 -> 1222
    //   2430: iload_2
    //   2431: i2f
    //   2432: ldc_w 627
    //   2435: fsub
    //   2436: ldc_w 627
    //   2439: fdiv
    //   2440: fstore 8
    //   2442: goto -540 -> 1902
    //   2445: astore_1
    //   2446: ldc_w 402
    //   2449: aload_1
    //   2450: ldc_w 629
    //   2453: iconst_0
    //   2454: anewarray 4	java/lang/Object
    //   2457: invokestatic 633	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2460: goto -57 -> 2403
    //   2463: aload_0
    //   2464: aload_0
    //   2465: getfield 292	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   2468: invokespecial 472	com/tencent/mm/plugin/voip/video/a/c:HW	(I)V
    //   2471: goto -1241 -> 1230
    //   2474: goto -157 -> 2317
    //   2477: goto -341 -> 2136
    //   2480: goto -262 -> 2218
    //   2483: goto -470 -> 2013
    //   2486: goto -563 -> 1923
    //   2489: iconst_0
    //   2490: istore 9
    //   2492: goto -2465 -> 27
    //   2495: iconst_1
    //   2496: istore 9
    //   2498: goto -2471 -> 27
    //   2501: iload 4
    //   2503: iconst_4
    //   2504: ishr
    //   2505: iconst_1
    //   2506: iand
    //   2507: iconst_1
    //   2508: if_icmpne -1236 -> 1272
    //   2511: iconst_1
    //   2512: istore 10
    //   2514: goto -2455 -> 59
    //   2517: goto -594 -> 1923
    //   2520: aload 15
    //   2522: astore_1
    //   2523: goto -510 -> 2013
    //   2526: aload 15
    //   2528: astore_1
    //   2529: goto -311 -> 2218
    //   2532: iconst_0
    //   2533: istore 11
    //   2535: goto -747 -> 1788
    //   2538: iconst_0
    //   2539: istore 10
    //   2541: goto -743 -> 1798
    //   2544: iconst_0
    //   2545: istore 12
    //   2547: goto -739 -> 1808
    //   2550: iload_2
    //   2551: bipush 80
    //   2553: if_icmplt -123 -> 2430
    //   2556: fconst_1
    //   2557: fstore 8
    //   2559: goto -657 -> 1902
    //   2562: iconst_0
    //   2563: istore 11
    //   2565: goto -462 -> 2103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2568	0	this	c
    //   0	2568	1	paramArrayOfByte	byte[]
    //   0	2568	2	paramInt1	int
    //   0	2568	3	paramInt2	int
    //   0	2568	4	paramInt3	int
    //   0	2568	5	paramInt4	int
    //   2257	54	6	d	double
    //   1900	658	8	f	float
    //   825	1672	9	i	int
    //   60	2480	10	bool1	boolean
    //   1786	778	11	bool2	boolean
    //   1806	740	12	bool3	boolean
    //   1026	1390	13	l	long
    //   1929	598	15	localObject1	Object
    //   1016	1366	16	localb	b
    //   1865	402	17	localPTFaceAttr	com.tencent.ttpic.PTFaceAttr
    //   2090	217	18	localObject2	Object
    //   2264	45	19	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   2	24	1267	finally
    //   27	37	1267	finally
    //   49	56	1267	finally
    //   59	72	1267	finally
    //   75	94	1267	finally
    //   99	125	1267	finally
    //   125	182	1267	finally
    //   186	240	1267	finally
    //   240	296	1267	finally
    //   296	692	1267	finally
    //   692	813	1267	finally
    //   818	825	1267	finally
    //   830	920	1267	finally
    //   925	956	1267	finally
    //   956	1001	1267	finally
    //   1001	1028	1267	finally
    //   1028	1208	1267	finally
    //   1208	1222	1267	finally
    //   1222	1230	1267	finally
    //   1230	1250	1267	finally
    //   1258	1264	1267	finally
    //   1284	1295	1267	finally
    //   1298	1327	1267	finally
    //   1331	1359	1267	finally
    //   1359	1388	1267	finally
    //   1388	1455	1267	finally
    //   1455	1460	1267	finally
    //   1460	1482	1267	finally
    //   1482	1487	1267	finally
    //   1487	1645	1267	finally
    //   1645	1759	1267	finally
    //   1762	1767	1267	finally
    //   1770	1775	1267	finally
    //   1808	1867	1267	finally
    //   1872	1893	1267	finally
    //   1902	1920	1267	finally
    //   1939	1947	1267	finally
    //   1950	2010	1267	finally
    //   2018	2032	1267	finally
    //   2037	2100	1267	finally
    //   2103	2136	1267	finally
    //   2147	2215	1267	finally
    //   2229	2237	1267	finally
    //   2245	2317	1267	finally
    //   2317	2389	1267	finally
    //   2389	2403	1267	finally
    //   2403	2427	1267	finally
    //   2430	2442	1267	finally
    //   2446	2460	1267	finally
    //   2463	2471	1267	finally
    //   1028	1208	2445	java/lang/Exception
    //   1208	1222	2445	java/lang/Exception
    //   1808	1867	2445	java/lang/Exception
    //   1872	1893	2445	java/lang/Exception
    //   1902	1920	2445	java/lang/Exception
    //   1939	1947	2445	java/lang/Exception
    //   1950	2010	2445	java/lang/Exception
    //   2018	2032	2445	java/lang/Exception
    //   2037	2100	2445	java/lang/Exception
    //   2103	2136	2445	java/lang/Exception
    //   2147	2215	2445	java/lang/Exception
    //   2229	2237	2445	java/lang/Exception
    //   2245	2317	2445	java/lang/Exception
    //   2317	2389	2445	java/lang/Exception
    //   2389	2403	2445	java/lang/Exception
  }
  
  public final byte[] cPS()
  {
    AppMethodBeat.i(5133);
    if ((this.tHT != null) && (this.tHT.ltm != null) && (this.tGS != 0))
    {
      if ((this.tCl == null) || (this.tCl.length != this.tHT.ltm.length)) {
        this.tCl = new byte[this.tHT.ltm.length];
      }
      System.arraycopy(this.tHT.ltm, 0, this.tCl, 0, this.tHT.ltm.length);
      byte[] arrayOfByte = this.tCl;
      AppMethodBeat.o(5133);
      return arrayOfByte;
    }
    AppMethodBeat.o(5133);
    return null;
  }
  
  public final void destroy()
  {
    i = 0;
    for (;;)
    {
      b localb;
      h[] arrayOfh;
      int j;
      try
      {
        AppMethodBeat.i(5128);
        if (!this.eLc)
        {
          AppMethodBeat.o(5128);
          return;
        }
        ab.i("MicroMsg.FilterRenderer", "%s do destroy", new Object[] { Integer.valueOf(hashCode()) });
        if (this.tHT != null)
        {
          localb = this.tHT;
          ab.i("MicroMsg.FilterProcessTex", "clear %s %d", new Object[] { localb, Long.valueOf(Thread.currentThread().getId()) });
        }
      }
      finally {}
      try
      {
        if (localb.lth != null) {
          localb.lth.ClearGLSL();
        }
        if (localb.lti != null) {
          localb.lti.clear();
        }
        if (localb.mSwapCopyFilter != null) {
          localb.mSwapCopyFilter.ClearGLSL();
        }
        arrayOfh = localb.mSwapFrames;
        j = arrayOfh.length;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.FilterProcessTex", localException, "clear error: %s", new Object[] { localException.getMessage() });
        continue;
        i += 1;
        continue;
      }
      if (i < j)
      {
        h localh = arrayOfh[i];
        if (localh == null) {
          break label537;
        }
        localh.clear();
        break label537;
      }
      if (localb.mCopyFilter != null) {
        localb.mCopyFilter.ClearGLSL();
      }
      if (localb.mTempFrame != null) {
        localb.mTempFrame.clear();
      }
      if (localb.ltf != null) {
        localb.ltf.ClearGLSL();
      }
      if (localb.mSmoothBFilters != null) {
        localb.mSmoothBFilters.clear();
      }
      if (localb.mBeautyFaceList != null) {
        localb.mBeautyFaceList.clear();
      }
      if (localb.mRemodelFilter != null) {
        localb.mRemodelFilter.clear();
      }
      if (localb.mBeautyTransformList != null) {
        localb.mBeautyTransformList.clear();
      }
      if (localb.ltj != null) {
        localb.ltj.clear();
      }
      if (localb.mBeautyTransformCopyFrame != null) {
        localb.mBeautyTransformCopyFrame.clear();
      }
      if (localb.mBeautyFrame2 != null) {
        localb.mBeautyFrame2.clear();
      }
      if (localb.ltk != null) {
        localb.ltk.destroy();
      }
      GLES20.glDeleteFramebuffers(1, new int[] { localb.ltn }, 0);
      this.tHT = null;
      GLES20.glDeleteTextures(5, new int[] { this.eZe, this.eZf, this.lBw, this.lBM, this.lBO }, 0);
      GLES20.glDeleteFramebuffers(2, new int[] { this.lBK, this.lBL }, 0);
      GLES20.glDeleteProgram(this.eZg);
      GLES20.glDeleteProgram(this.tHP);
      this.lBP = null;
      GLES20.glBindTexture(3553, 0);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      GLES20.glFinish();
      if (this.eZm != null) {
        this.eZm.clear();
      }
      if (this.eZn != null) {
        this.eZn.clear();
      }
      this.eZm = null;
      this.eZn = null;
      this.eLc = false;
      AppMethodBeat.o(5128);
    }
  }
  
  public final void updateSize(int paramInt1, int paramInt2)
  {
    this.jgD = paramInt1;
    this.jgE = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.c
 * JD-Core Version:    0.7.0.1
 */