package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.voip.video.c.d;
import com.tencent.mm.plugin.voip.video.c.f;
import com.tencent.mm.plugin.voip.video.c.h;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "renderSide", "", "textureWidth", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIIII)V", "TAG", "", "inputTexture", "mRenderOnScreenProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "renderMode", "beforeRender", "", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderMode", "release", "renderImpl", "setInputTexture", "texture", "setShowMode", "mode", "updateDrawViewSize", "width", "height", "plugin-voip_release"})
public final class l
  extends com.tencent.mm.media.j.b.a
{
  public d Hpi;
  private final String TAG;
  public int hDl;
  int hEi;
  
  public l(int paramInt1, int paramInt2)
  {
    super(0, 0, 0, 0, paramInt2, 2);
    AppMethodBeat.i(236334);
    this.Hpi = new d(paramInt1);
    this.hDl = -1;
    this.TAG = "MicroMsg.VoipRenderProcExternalTexture";
    paramInt2 = i;
    if (paramInt1 == 0) {
      paramInt2 = 1;
    }
    this.hEi = paramInt2;
    AppMethodBeat.o(236334);
  }
  
  public final void aEB()
  {
    AppMethodBeat.i(236330);
    float f7 = this.ijS.x / this.hDn;
    float f4 = (this.ijS.y - 1.0F) / this.hDo;
    float f6 = (this.ijT.x - 1.0F) / this.hDn;
    float f5 = this.ijT.y / this.hDo;
    float[] arrayOfFloat = c.iln;
    arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    int i;
    int j;
    int k;
    int m;
    label153:
    label158:
    float f1;
    float f2;
    if ((this.ijt == 90) || (this.ijt == 270))
    {
      i = 1;
      j = this.ijT.x - this.ijS.x;
      k = this.ijS.y - this.ijT.y;
      if (i == 0) {
        break label403;
      }
      m = k;
      if (i == 0) {
        break label410;
      }
      f1 = this.hEp / m;
      f2 = this.hEq / j;
      if (f1 >= f2) {
        break label417;
      }
      f2 = m - this.hEp / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label198:
      this.ijO = (m - (int)f2);
      this.ijP = (j - (int)f1);
      float f3;
      if (i != 0)
      {
        f1 = f1 / 2.0F / j;
        f3 = f2 / 2.0F / m;
        f2 = f1;
      }
      for (f1 = f3;; f1 = f1 / 2.0F / j)
      {
        f3 = f7 + f2;
        f2 = f6 - f2;
        f5 += f1;
        f1 = f4 - f1;
        arrayOfFloat[0] = f3;
        arrayOfFloat[1] = f1;
        arrayOfFloat[2] = f2;
        arrayOfFloat[3] = f1;
        arrayOfFloat[4] = f3;
        arrayOfFloat[5] = f5;
        arrayOfFloat[6] = f2;
        arrayOfFloat[7] = f5;
        this.hDT.position(0);
        FloatBuffer localFloatBuffer = this.hDT;
        p.g(arrayOfFloat, "cropTextureCoord");
        localFloatBuffer.put(k(arrayOfFloat));
        this.hDT.position(0);
        this.hDU.position(0);
        this.hDU.put(c.ilm);
        this.hDU.position(0);
        GLES20.glViewport(0, 0, this.hEp, this.hEq);
        AppMethodBeat.o(236330);
        return;
        i = 0;
        break;
        label403:
        m = j;
        break label153;
        label410:
        j = k;
        break label158;
        label417:
        if (f1 <= f2) {
          break label459;
        }
        f1 = j - this.hEq / f1;
        f2 = 0.0F;
        break label198;
        f2 = f2 / 2.0F / m;
      }
      label459:
      f1 = 0.0F;
      f2 = 0.0F;
    }
  }
  
  /* Error */
  public final void aMV()
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 71	com/tencent/mm/plugin/voip/video/render/l:Hpi	Lcom/tencent/mm/plugin/voip/video/c/d;
    //   9: astore 14
    //   11: aload_0
    //   12: getfield 162	com/tencent/mm/media/j/b/a:hDU	Ljava/nio/FloatBuffer;
    //   15: astore 12
    //   17: aload_0
    //   18: getfield 137	com/tencent/mm/media/j/b/a:hDT	Ljava/nio/FloatBuffer;
    //   21: astore 13
    //   23: aload_0
    //   24: getfield 73	com/tencent/mm/plugin/voip/video/render/l:hDl	I
    //   27: istore 5
    //   29: aload_0
    //   30: getfield 79	com/tencent/mm/plugin/voip/video/render/l:hEi	I
    //   33: istore 6
    //   35: aload 12
    //   37: ldc 177
    //   39: invokestatic 179	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 13
    //   44: ldc 181
    //   46: invokestatic 179	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   49: iload 6
    //   51: iconst_1
    //   52: if_icmpne +296 -> 348
    //   55: aload 14
    //   57: getfield 185	com/tencent/mm/plugin/voip/video/c/d:Hmx	Lcom/tencent/mm/plugin/voip/video/c/f;
    //   60: astore 14
    //   62: aload 12
    //   64: ldc 177
    //   66: invokestatic 179	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   69: aload 13
    //   71: ldc 181
    //   73: invokestatic 179	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload 14
    //   78: getfield 191	com/tencent/mm/plugin/voip/video/c/f:HmG	Z
    //   81: ifeq +136 -> 217
    //   84: iload 5
    //   86: iconst_m1
    //   87: if_icmpeq +124 -> 211
    //   90: aload 14
    //   92: getfield 194	com/tencent/mm/plugin/voip/video/c/f:programId	I
    //   95: invokestatic 197	android/opengl/GLES20:glUseProgram	(I)V
    //   98: ldc 198
    //   100: invokestatic 201	android/opengl/GLES20:glActiveTexture	(I)V
    //   103: ldc 202
    //   105: iload 5
    //   107: invokestatic 205	android/opengl/GLES20:glBindTexture	(II)V
    //   110: aload 14
    //   112: getfield 208	com/tencent/mm/plugin/voip/video/c/f:hEA	I
    //   115: iconst_0
    //   116: invokestatic 211	android/opengl/GLES20:glUniform1i	(II)V
    //   119: aload 12
    //   121: iconst_0
    //   122: invokevirtual 143	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   125: pop
    //   126: aload 14
    //   128: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   131: iconst_2
    //   132: sipush 5126
    //   135: iconst_0
    //   136: bipush 8
    //   138: aload 12
    //   140: checkcast 216	java/nio/Buffer
    //   143: invokestatic 220	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   146: aload 14
    //   148: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   151: invokestatic 223	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   154: aload 13
    //   156: iconst_0
    //   157: invokevirtual 143	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   160: pop
    //   161: aload 14
    //   163: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   166: iconst_2
    //   167: sipush 5126
    //   170: iconst_0
    //   171: bipush 8
    //   173: aload 13
    //   175: checkcast 216	java/nio/Buffer
    //   178: invokestatic 220	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   181: aload 14
    //   183: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   186: invokestatic 223	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   189: iconst_5
    //   190: iconst_0
    //   191: iconst_4
    //   192: invokestatic 230	android/opengl/GLES20:glDrawArrays	(III)V
    //   195: aload 14
    //   197: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   200: invokestatic 233	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   203: aload 14
    //   205: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   208: invokestatic 233	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   211: ldc 175
    //   213: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: iload 5
    //   219: iconst_m1
    //   220: if_icmpeq +122 -> 342
    //   223: aload 14
    //   225: getfield 194	com/tencent/mm/plugin/voip/video/c/f:programId	I
    //   228: invokestatic 197	android/opengl/GLES20:glUseProgram	(I)V
    //   231: ldc 198
    //   233: invokestatic 201	android/opengl/GLES20:glActiveTexture	(I)V
    //   236: sipush 3553
    //   239: iload 5
    //   241: invokestatic 205	android/opengl/GLES20:glBindTexture	(II)V
    //   244: aload 14
    //   246: getfield 208	com/tencent/mm/plugin/voip/video/c/f:hEA	I
    //   249: iconst_0
    //   250: invokestatic 211	android/opengl/GLES20:glUniform1i	(II)V
    //   253: aload 14
    //   255: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   258: iconst_2
    //   259: sipush 5126
    //   262: iconst_0
    //   263: iconst_0
    //   264: aload 12
    //   266: checkcast 216	java/nio/Buffer
    //   269: invokestatic 220	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   272: aload 14
    //   274: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   277: invokestatic 223	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   280: aload 14
    //   282: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   285: iconst_2
    //   286: sipush 5126
    //   289: iconst_0
    //   290: iconst_0
    //   291: aload 13
    //   293: checkcast 216	java/nio/Buffer
    //   296: invokestatic 220	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   299: aload 14
    //   301: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   304: invokestatic 223	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   307: iconst_5
    //   308: iconst_0
    //   309: iconst_4
    //   310: invokestatic 230	android/opengl/GLES20:glDrawArrays	(III)V
    //   313: aload 14
    //   315: getfield 214	com/tencent/mm/plugin/voip/video/c/f:hEy	I
    //   318: invokestatic 233	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   321: aload 14
    //   323: getfield 226	com/tencent/mm/plugin/voip/video/c/f:hEz	I
    //   326: invokestatic 233	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   329: sipush 3553
    //   332: iconst_0
    //   333: invokestatic 205	android/opengl/GLES20:glBindTexture	(II)V
    //   336: ldc 202
    //   338: iconst_0
    //   339: invokestatic 205	android/opengl/GLES20:glBindTexture	(II)V
    //   342: ldc 175
    //   344: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: return
    //   348: aload 14
    //   350: getfield 237	com/tencent/mm/plugin/voip/video/c/d:Hmy	Lcom/tencent/mm/plugin/voip/video/c/h;
    //   353: astore 12
    //   355: aload 12
    //   357: ifnull +1671 -> 2028
    //   360: aload 12
    //   362: monitorenter
    //   363: aload 12
    //   365: getfield 243	com/tencent/mm/plugin/voip/video/c/h:Him	[B
    //   368: ifnull +1290 -> 1658
    //   371: aload 12
    //   373: getfield 246	com/tencent/mm/plugin/voip/video/c/h:mWidth	I
    //   376: istore 5
    //   378: aload 12
    //   380: getfield 249	com/tencent/mm/plugin/voip/video/c/h:mHeight	I
    //   383: istore 6
    //   385: aload 12
    //   387: getfield 252	com/tencent/mm/plugin/voip/video/c/h:Hif	I
    //   390: istore 7
    //   392: aload 12
    //   394: getfield 255	com/tencent/mm/plugin/voip/video/c/h:Hig	I
    //   397: istore 8
    //   399: aload 12
    //   401: getfield 258	com/tencent/mm/plugin/voip/video/c/h:AOS	I
    //   404: istore 9
    //   406: iload 5
    //   408: ifle +557 -> 965
    //   411: iload 6
    //   413: ifle +552 -> 965
    //   416: iload 9
    //   418: iconst_2
    //   419: ishr
    //   420: iconst_3
    //   421: iand
    //   422: istore 10
    //   424: iload 9
    //   426: iconst_4
    //   427: ishr
    //   428: iconst_1
    //   429: iand
    //   430: iconst_1
    //   431: if_icmpne +1660 -> 2091
    //   434: iconst_1
    //   435: istore 11
    //   437: iload 5
    //   439: aload 12
    //   441: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   444: if_icmpne +53 -> 497
    //   447: iload 6
    //   449: aload 12
    //   451: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   454: if_icmpne +43 -> 497
    //   457: iload 7
    //   459: aload 12
    //   461: getfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   464: if_icmpne +33 -> 497
    //   467: iload 8
    //   469: aload 12
    //   471: getfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   474: if_icmpne +23 -> 497
    //   477: aload 12
    //   479: getfield 273	com/tencent/mm/plugin/voip/video/c/h:FfM	I
    //   482: iload 10
    //   484: if_icmpne +13 -> 497
    //   487: aload 12
    //   489: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   492: iload 11
    //   494: if_icmpeq +471 -> 965
    //   497: aload 12
    //   499: iload 10
    //   501: putfield 273	com/tencent/mm/plugin/voip/video/c/h:FfM	I
    //   504: aload 12
    //   506: iload 11
    //   508: putfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   511: ldc_w 278
    //   514: ldc_w 280
    //   517: bipush 9
    //   519: anewarray 282	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: aload 12
    //   526: getfield 273	com/tencent/mm/plugin/voip/video/c/h:FfM	I
    //   529: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   532: aastore
    //   533: dup
    //   534: iconst_1
    //   535: aload 12
    //   537: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   540: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   543: aastore
    //   544: dup
    //   545: iconst_2
    //   546: iload 5
    //   548: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: aastore
    //   552: dup
    //   553: iconst_3
    //   554: iload 6
    //   556: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: aastore
    //   560: dup
    //   561: iconst_4
    //   562: iload 7
    //   564: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   567: aastore
    //   568: dup
    //   569: iconst_5
    //   570: iload 8
    //   572: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: aastore
    //   576: dup
    //   577: bipush 6
    //   579: aload 12
    //   581: getfield 296	com/tencent/mm/plugin/voip/video/c/h:hEm	I
    //   584: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: bipush 7
    //   591: aload 12
    //   593: getfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   596: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   599: aastore
    //   600: dup
    //   601: bipush 8
    //   603: aload 12
    //   605: getfield 302	com/tencent/mm/plugin/voip/video/c/h:Hmq	I
    //   608: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   611: aastore
    //   612: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   615: aload 12
    //   617: iload 5
    //   619: putfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   622: aload 12
    //   624: iload 6
    //   626: putfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   629: aload 12
    //   631: iload 7
    //   633: putfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   636: aload 12
    //   638: iload 8
    //   640: putfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   643: aload 12
    //   645: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   648: istore 7
    //   650: aload 12
    //   652: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   655: istore 8
    //   657: aload 12
    //   659: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   662: astore 13
    //   664: aload 13
    //   666: ifnonnull +6 -> 672
    //   669: invokestatic 314	kotlin/g/b/p:hyc	()V
    //   672: aload 13
    //   674: getfield 319	com/tencent/mm/plugin/voip/video/c/a:HlS	[F
    //   677: astore 13
    //   679: aload 13
    //   681: ldc_w 321
    //   684: invokestatic 151	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   687: aload 12
    //   689: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   692: astore 14
    //   694: aload 14
    //   696: ifnonnull +6 -> 702
    //   699: invokestatic 314	kotlin/g/b/p:hyc	()V
    //   702: aload 14
    //   704: getfield 324	com/tencent/mm/plugin/voip/video/c/a:HlR	[F
    //   707: astore 14
    //   709: aload 14
    //   711: ldc_w 326
    //   714: invokestatic 151	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   717: fconst_0
    //   718: fstore_2
    //   719: fconst_0
    //   720: fstore_1
    //   721: ldc_w 327
    //   724: ldc_w 328
    //   727: iload 7
    //   729: i2f
    //   730: fdiv
    //   731: fconst_2
    //   732: fdiv
    //   733: fadd
    //   734: fstore 4
    //   736: ldc_w 328
    //   739: iload 8
    //   741: i2f
    //   742: fdiv
    //   743: fconst_2
    //   744: fdiv
    //   745: ldc_w 327
    //   748: fadd
    //   749: fstore_3
    //   750: iload 7
    //   752: bipush 64
    //   754: isub
    //   755: istore 9
    //   757: iload 8
    //   759: bipush 64
    //   761: isub
    //   762: istore 10
    //   764: aload 12
    //   766: getfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   769: iload 9
    //   771: imul
    //   772: aload 12
    //   774: getfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   777: iload 10
    //   779: imul
    //   780: if_icmpge +358 -> 1138
    //   783: ldc_w 329
    //   786: fconst_1
    //   787: iload 9
    //   789: i2f
    //   790: fmul
    //   791: aload 12
    //   793: getfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   796: i2f
    //   797: fmul
    //   798: iload 8
    //   800: i2f
    //   801: fconst_2
    //   802: fmul
    //   803: aload 12
    //   805: getfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   808: i2f
    //   809: fmul
    //   810: fdiv
    //   811: fsub
    //   812: ldc_w 327
    //   815: fadd
    //   816: fstore_1
    //   817: goto +1217 -> 2034
    //   820: aload 12
    //   822: getfield 273	com/tencent/mm/plugin/voip/video/c/h:FfM	I
    //   825: tableswitch	default:+1225 -> 2050, 1:+528->1353, 2:+27->852, 3:+350->1175
    //   853: fconst_1
    //   854: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   857: ifnull +27 -> 884
    //   860: aload 12
    //   862: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   865: astore 15
    //   867: aload 15
    //   869: ifnonnull +6 -> 875
    //   872: invokestatic 314	kotlin/g/b/p:hyc	()V
    //   875: aload 15
    //   877: aload 14
    //   879: aload 13
    //   881: invokevirtual 333	com/tencent/mm/plugin/voip/video/c/a:d	([F[F)V
    //   884: iload 5
    //   886: iload 6
    //   888: imul
    //   889: istore 5
    //   891: iload 5
    //   893: iconst_4
    //   894: idiv
    //   895: istore 6
    //   897: aload 12
    //   899: monitorenter
    //   900: aload 12
    //   902: iload 6
    //   904: iconst_2
    //   905: imul
    //   906: iload 5
    //   908: iadd
    //   909: invokestatic 339	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   912: putfield 343	com/tencent/mm/plugin/voip/video/c/h:Hmg	Ljava/nio/ByteBuffer;
    //   915: aload 12
    //   917: iload 5
    //   919: invokestatic 339	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   922: putfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   925: aload 12
    //   927: iload 6
    //   929: invokestatic 339	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   932: putfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   935: aload 12
    //   937: iload 6
    //   939: invokestatic 339	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   942: putfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   945: aload 12
    //   947: iload 6
    //   949: iconst_2
    //   950: imul
    //   951: invokestatic 339	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   954: putfield 354	com/tencent/mm/plugin/voip/video/c/h:Hmj	Ljava/nio/ByteBuffer;
    //   957: getstatic 360	kotlin/x:SXb	Lkotlin/x;
    //   960: astore 13
    //   962: aload 12
    //   964: monitorexit
    //   965: aload 12
    //   967: getfield 243	com/tencent/mm/plugin/voip/video/c/h:Him	[B
    //   970: astore 13
    //   972: aload 12
    //   974: iconst_0
    //   975: putfield 363	com/tencent/mm/plugin/voip/video/c/h:Hmo	Z
    //   978: aload 13
    //   980: ifnull +606 -> 1586
    //   983: aload 12
    //   985: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   988: aload 12
    //   990: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   993: imul
    //   994: iconst_3
    //   995: imul
    //   996: iconst_2
    //   997: idiv
    //   998: istore 8
    //   1000: aload 12
    //   1002: aload 12
    //   1004: getfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   1007: iconst_1
    //   1008: iadd
    //   1009: putfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   1012: aload 12
    //   1014: getfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   1017: bipush 100
    //   1019: irem
    //   1020: ifne +49 -> 1069
    //   1023: ldc_w 278
    //   1026: ldc_w 365
    //   1029: iconst_3
    //   1030: anewarray 282	java/lang/Object
    //   1033: dup
    //   1034: iconst_0
    //   1035: aload 12
    //   1037: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1040: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1043: aastore
    //   1044: dup
    //   1045: iconst_1
    //   1046: aload 12
    //   1048: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1051: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_2
    //   1057: aload 12
    //   1059: getfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   1062: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1065: aastore
    //   1066: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1069: aload 13
    //   1071: arraylength
    //   1072: iload 8
    //   1074: if_icmplt +610 -> 1684
    //   1077: aload 12
    //   1079: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1082: istore 7
    //   1084: aload 12
    //   1086: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1089: istore 9
    //   1091: aload 12
    //   1093: getfield 299	com/tencent/mm/plugin/voip/video/c/h:Hmp	I
    //   1096: bipush 100
    //   1098: irem
    //   1099: ifne +579 -> 1678
    //   1102: aload 13
    //   1104: ifnull +568 -> 1672
    //   1107: aload 13
    //   1109: arraylength
    //   1110: iload 7
    //   1112: iload 9
    //   1114: imul
    //   1115: iconst_3
    //   1116: imul
    //   1117: iconst_2
    //   1118: idiv
    //   1119: if_icmple +553 -> 1672
    //   1122: iconst_0
    //   1123: istore 5
    //   1125: iconst_0
    //   1126: istore 6
    //   1128: iload 7
    //   1130: iload 9
    //   1132: imul
    //   1133: istore 9
    //   1135: goto +918 -> 2053
    //   1138: ldc_w 329
    //   1141: fconst_1
    //   1142: iload 10
    //   1144: i2f
    //   1145: fmul
    //   1146: aload 12
    //   1148: getfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   1151: i2f
    //   1152: fmul
    //   1153: iload 7
    //   1155: i2f
    //   1156: fconst_2
    //   1157: fmul
    //   1158: aload 12
    //   1160: getfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   1163: i2f
    //   1164: fmul
    //   1165: fdiv
    //   1166: fsub
    //   1167: ldc_w 327
    //   1170: fadd
    //   1171: fstore_2
    //   1172: goto +862 -> 2034
    //   1175: aload 13
    //   1177: iconst_0
    //   1178: fload_2
    //   1179: fastore
    //   1180: aload 12
    //   1182: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1185: ifeq +144 -> 1329
    //   1188: fconst_1
    //   1189: fload_1
    //   1190: fsub
    //   1191: fstore_3
    //   1192: aload 13
    //   1194: iconst_1
    //   1195: fload_3
    //   1196: fastore
    //   1197: aload 13
    //   1199: iconst_2
    //   1200: fconst_1
    //   1201: fload_2
    //   1202: fsub
    //   1203: fastore
    //   1204: aload 12
    //   1206: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1209: ifeq +125 -> 1334
    //   1212: fconst_1
    //   1213: fload_1
    //   1214: fsub
    //   1215: fstore_3
    //   1216: aload 13
    //   1218: iconst_3
    //   1219: fload_3
    //   1220: fastore
    //   1221: aload 13
    //   1223: iconst_4
    //   1224: fload_2
    //   1225: fastore
    //   1226: aload 12
    //   1228: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1231: ifeq +108 -> 1339
    //   1234: fload_1
    //   1235: fstore_3
    //   1236: aload 13
    //   1238: iconst_5
    //   1239: fload_3
    //   1240: fastore
    //   1241: aload 13
    //   1243: bipush 6
    //   1245: fconst_1
    //   1246: fload_2
    //   1247: fsub
    //   1248: fastore
    //   1249: aload 12
    //   1251: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1254: ifeq +92 -> 1346
    //   1257: aload 13
    //   1259: bipush 7
    //   1261: fload_1
    //   1262: fastore
    //   1263: aload 14
    //   1265: iconst_0
    //   1266: ldc_w 366
    //   1269: fastore
    //   1270: aload 14
    //   1272: iconst_1
    //   1273: ldc_w 366
    //   1276: fastore
    //   1277: aload 14
    //   1279: iconst_2
    //   1280: ldc_w 366
    //   1283: fastore
    //   1284: aload 14
    //   1286: iconst_3
    //   1287: fconst_1
    //   1288: fastore
    //   1289: aload 14
    //   1291: iconst_4
    //   1292: fconst_1
    //   1293: fastore
    //   1294: aload 14
    //   1296: iconst_5
    //   1297: ldc_w 366
    //   1300: fastore
    //   1301: aload 14
    //   1303: bipush 6
    //   1305: fconst_1
    //   1306: fastore
    //   1307: aload 14
    //   1309: bipush 7
    //   1311: fconst_1
    //   1312: fastore
    //   1313: goto -461 -> 852
    //   1316: astore 13
    //   1318: aload 12
    //   1320: monitorexit
    //   1321: ldc 175
    //   1323: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1326: aload 13
    //   1328: athrow
    //   1329: fload_1
    //   1330: fstore_3
    //   1331: goto -139 -> 1192
    //   1334: fload_1
    //   1335: fstore_3
    //   1336: goto -120 -> 1216
    //   1339: fconst_1
    //   1340: fload_1
    //   1341: fsub
    //   1342: fstore_3
    //   1343: goto -107 -> 1236
    //   1346: fconst_1
    //   1347: fload_1
    //   1348: fsub
    //   1349: fstore_1
    //   1350: goto -93 -> 1257
    //   1353: aload 13
    //   1355: iconst_0
    //   1356: fload_2
    //   1357: fastore
    //   1358: aload 12
    //   1360: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1363: ifeq +804 -> 2167
    //   1366: fconst_1
    //   1367: fload_1
    //   1368: fsub
    //   1369: fstore_3
    //   1370: aload 13
    //   1372: iconst_1
    //   1373: fload_3
    //   1374: fastore
    //   1375: aload 13
    //   1377: iconst_2
    //   1378: fconst_1
    //   1379: fload_2
    //   1380: fsub
    //   1381: fastore
    //   1382: aload 12
    //   1384: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1387: ifeq +785 -> 2172
    //   1390: fconst_1
    //   1391: fload_1
    //   1392: fsub
    //   1393: fstore_3
    //   1394: aload 13
    //   1396: iconst_3
    //   1397: fload_3
    //   1398: fastore
    //   1399: aload 13
    //   1401: iconst_4
    //   1402: fload_2
    //   1403: fastore
    //   1404: aload 12
    //   1406: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1409: ifeq +768 -> 2177
    //   1412: fload_1
    //   1413: fstore_3
    //   1414: aload 13
    //   1416: iconst_5
    //   1417: fload_3
    //   1418: fastore
    //   1419: aload 13
    //   1421: bipush 6
    //   1423: fconst_1
    //   1424: fload_2
    //   1425: fsub
    //   1426: fastore
    //   1427: aload 12
    //   1429: getfield 276	com/tencent/mm/plugin/voip/video/c/h:Hmk	Z
    //   1432: ifeq +752 -> 2184
    //   1435: goto +673 -> 2108
    //   1438: astore 13
    //   1440: aload 12
    //   1442: monitorexit
    //   1443: ldc 175
    //   1445: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1448: aload 13
    //   1450: athrow
    //   1451: iload 5
    //   1453: ifeq +231 -> 1684
    //   1456: aload 12
    //   1458: getfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   1461: invokevirtual 370	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1464: pop
    //   1465: aload 12
    //   1467: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1470: invokevirtual 370	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1473: pop
    //   1474: aload 12
    //   1476: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1479: invokevirtual 370	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1482: pop
    //   1483: aload 12
    //   1485: getfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   1488: aload 13
    //   1490: iconst_0
    //   1491: aload 12
    //   1493: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1496: aload 12
    //   1498: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1501: imul
    //   1502: invokevirtual 373	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1505: pop
    //   1506: aload 12
    //   1508: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1511: aload 13
    //   1513: aload 12
    //   1515: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1518: aload 12
    //   1520: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1523: imul
    //   1524: aload 12
    //   1526: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1529: aload 12
    //   1531: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1534: imul
    //   1535: iconst_4
    //   1536: idiv
    //   1537: invokevirtual 373	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1540: pop
    //   1541: aload 12
    //   1543: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1546: aload 13
    //   1548: aload 12
    //   1550: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1553: aload 12
    //   1555: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1558: imul
    //   1559: iconst_5
    //   1560: imul
    //   1561: iconst_4
    //   1562: idiv
    //   1563: aload 12
    //   1565: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1568: aload 12
    //   1570: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1573: imul
    //   1574: iconst_4
    //   1575: idiv
    //   1576: invokevirtual 373	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1579: pop
    //   1580: aload 12
    //   1582: iconst_1
    //   1583: putfield 363	com/tencent/mm/plugin/voip/video/c/h:Hmo	Z
    //   1586: aload 12
    //   1588: monitorenter
    //   1589: iconst_0
    //   1590: iconst_0
    //   1591: aload 12
    //   1593: getfield 267	com/tencent/mm/plugin/voip/video/c/h:mScreenWidth	I
    //   1596: aload 12
    //   1598: getfield 270	com/tencent/mm/plugin/voip/video/c/h:mScreenHeight	I
    //   1601: invokestatic 171	android/opengl/GLES20:glViewport	(IIII)V
    //   1604: sipush 16640
    //   1607: invokestatic 376	android/opengl/GLES20:glClear	(I)V
    //   1610: fconst_0
    //   1611: fconst_0
    //   1612: fconst_0
    //   1613: fconst_0
    //   1614: invokestatic 380	android/opengl/GLES20:glClearColor	(FFFF)V
    //   1617: aload 12
    //   1619: getfield 383	com/tencent/mm/plugin/voip/video/c/h:ijr	Z
    //   1622: ifeq +131 -> 1753
    //   1625: ldc_w 278
    //   1628: ldc_w 385
    //   1631: iconst_1
    //   1632: anewarray 282	java/lang/Object
    //   1635: dup
    //   1636: iconst_0
    //   1637: aload 12
    //   1639: getfield 296	com/tencent/mm/plugin/voip/video/c/h:hEm	I
    //   1642: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1645: aastore
    //   1646: invokestatic 307	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1649: aload 12
    //   1651: iconst_0
    //   1652: putfield 383	com/tencent/mm/plugin/voip/video/c/h:ijr	Z
    //   1655: aload 12
    //   1657: monitorexit
    //   1658: getstatic 360	kotlin/x:SXb	Lkotlin/x;
    //   1661: astore 13
    //   1663: aload 12
    //   1665: monitorexit
    //   1666: ldc 175
    //   1668: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1671: return
    //   1672: iconst_0
    //   1673: istore 5
    //   1675: goto -224 -> 1451
    //   1678: iconst_1
    //   1679: istore 5
    //   1681: goto -230 -> 1451
    //   1684: ldc_w 278
    //   1687: ldc_w 387
    //   1690: iconst_4
    //   1691: anewarray 282	java/lang/Object
    //   1694: dup
    //   1695: iconst_0
    //   1696: aload 13
    //   1698: arraylength
    //   1699: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1702: aastore
    //   1703: dup
    //   1704: iconst_1
    //   1705: iload 8
    //   1707: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1710: aastore
    //   1711: dup
    //   1712: iconst_2
    //   1713: aload 12
    //   1715: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1718: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1721: aastore
    //   1722: dup
    //   1723: iconst_3
    //   1724: aload 12
    //   1726: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1729: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1732: aastore
    //   1733: invokestatic 390	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1736: aload 12
    //   1738: iconst_0
    //   1739: putfield 363	com/tencent/mm/plugin/voip/video/c/h:Hmo	Z
    //   1742: getstatic 396	com/tencent/mm/plugin/voip/model/t:GYO	Lcom/tencent/mm/plugin/voip/model/t;
    //   1745: astore 13
    //   1747: invokestatic 399	com/tencent/mm/plugin/voip/model/t:fHM	()V
    //   1750: goto -164 -> 1586
    //   1753: aload 12
    //   1755: getfield 363	com/tencent/mm/plugin/voip/video/c/h:Hmo	Z
    //   1758: ifne +18 -> 1776
    //   1761: ldc_w 278
    //   1764: ldc_w 401
    //   1767: invokestatic 404	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1770: aload 12
    //   1772: monitorexit
    //   1773: goto -115 -> 1658
    //   1776: aload 12
    //   1778: getfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   1781: invokevirtual 408	java/nio/ByteBuffer:capacity	()I
    //   1784: aload 12
    //   1786: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1789: aload 12
    //   1791: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1794: imul
    //   1795: if_icmpne +107 -> 1902
    //   1798: aload 12
    //   1800: getfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   1803: iconst_0
    //   1804: invokevirtual 409	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1807: pop
    //   1808: aload 12
    //   1810: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1813: aload 12
    //   1815: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1818: imul
    //   1819: iconst_4
    //   1820: idiv
    //   1821: istore 5
    //   1823: aload 12
    //   1825: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1828: invokevirtual 408	java/nio/ByteBuffer:capacity	()I
    //   1831: iload 5
    //   1833: if_icmpne +100 -> 1933
    //   1836: aload 12
    //   1838: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1841: invokevirtual 408	java/nio/ByteBuffer:capacity	()I
    //   1844: iload 5
    //   1846: if_icmpne +87 -> 1933
    //   1849: aload 12
    //   1851: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1854: iconst_0
    //   1855: invokevirtual 409	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1858: pop
    //   1859: aload 12
    //   1861: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1864: iconst_0
    //   1865: invokevirtual 409	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1868: pop
    //   1869: aload 12
    //   1871: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   1874: aload 12
    //   1876: getfield 345	com/tencent/mm/plugin/voip/video/c/h:y	Ljava/nio/ByteBuffer;
    //   1879: aload 12
    //   1881: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1884: aload 12
    //   1886: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1889: aload 12
    //   1891: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1894: aload 12
    //   1896: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1899: invokevirtual 413	com/tencent/mm/plugin/voip/video/c/a:a	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;II)V
    //   1902: aload 12
    //   1904: getfield 311	com/tencent/mm/plugin/voip/video/c/h:HmK	Lcom/tencent/mm/plugin/voip/video/c/a;
    //   1907: invokevirtual 416	com/tencent/mm/plugin/voip/video/c/a:fLO	()V
    //   1910: aload 12
    //   1912: aconst_null
    //   1913: putfield 243	com/tencent/mm/plugin/voip/video/c/h:Him	[B
    //   1916: aload 12
    //   1918: aconst_null
    //   1919: putfield 420	com/tencent/mm/plugin/voip/video/c/h:Hin	[I
    //   1922: getstatic 360	kotlin/x:SXb	Lkotlin/x;
    //   1925: astore 13
    //   1927: aload 12
    //   1929: monitorexit
    //   1930: goto -272 -> 1658
    //   1933: ldc_w 278
    //   1936: ldc_w 422
    //   1939: iconst_4
    //   1940: anewarray 282	java/lang/Object
    //   1943: dup
    //   1944: iconst_0
    //   1945: aload 12
    //   1947: getfield 348	com/tencent/mm/plugin/voip/video/c/h:Hmh	Ljava/nio/ByteBuffer;
    //   1950: invokevirtual 408	java/nio/ByteBuffer:capacity	()I
    //   1953: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1956: aastore
    //   1957: dup
    //   1958: iconst_1
    //   1959: aload 12
    //   1961: getfield 351	com/tencent/mm/plugin/voip/video/c/h:Hmi	Ljava/nio/ByteBuffer;
    //   1964: invokevirtual 408	java/nio/ByteBuffer:capacity	()I
    //   1967: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1970: aastore
    //   1971: dup
    //   1972: iconst_2
    //   1973: aload 12
    //   1975: getfield 261	com/tencent/mm/plugin/voip/video/c/h:mVideoWidth	I
    //   1978: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1981: aastore
    //   1982: dup
    //   1983: iconst_3
    //   1984: aload 12
    //   1986: getfield 264	com/tencent/mm/plugin/voip/video/c/h:mVideoHeight	I
    //   1989: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1992: aastore
    //   1993: invokestatic 390	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1996: goto -94 -> 1902
    //   1999: astore 13
    //   2001: aload 12
    //   2003: monitorexit
    //   2004: ldc 175
    //   2006: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2009: aload 13
    //   2011: athrow
    //   2012: astore 13
    //   2014: ldc_w 278
    //   2017: aload 13
    //   2019: invokevirtual 426	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2022: invokestatic 428	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2025: goto -115 -> 1910
    //   2028: ldc 175
    //   2030: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2033: return
    //   2034: fload_2
    //   2035: fload 4
    //   2037: fcmpl
    //   2038: ifle +59 -> 2097
    //   2041: fload_1
    //   2042: fload_3
    //   2043: fcmpl
    //   2044: ifle +59 -> 2103
    //   2047: goto -1227 -> 820
    //   2050: goto -1198 -> 852
    //   2053: iload 6
    //   2055: iload 9
    //   2057: if_icmpge +134 -> 2191
    //   2060: iload 5
    //   2062: istore 7
    //   2064: aload 13
    //   2066: iload 6
    //   2068: baload
    //   2069: ifne +9 -> 2078
    //   2072: iload 5
    //   2074: iconst_1
    //   2075: iadd
    //   2076: istore 7
    //   2078: iload 6
    //   2080: iconst_1
    //   2081: iadd
    //   2082: istore 6
    //   2084: iload 7
    //   2086: istore 5
    //   2088: goto -35 -> 2053
    //   2091: iconst_0
    //   2092: istore 11
    //   2094: goto -1657 -> 437
    //   2097: fload 4
    //   2099: fstore_2
    //   2100: goto -59 -> 2041
    //   2103: fload_3
    //   2104: fstore_1
    //   2105: goto -1285 -> 820
    //   2108: aload 13
    //   2110: bipush 7
    //   2112: fload_1
    //   2113: fastore
    //   2114: aload 14
    //   2116: iconst_0
    //   2117: fconst_1
    //   2118: fastore
    //   2119: aload 14
    //   2121: iconst_1
    //   2122: fconst_1
    //   2123: fastore
    //   2124: aload 14
    //   2126: iconst_2
    //   2127: fconst_1
    //   2128: fastore
    //   2129: aload 14
    //   2131: iconst_3
    //   2132: ldc_w 366
    //   2135: fastore
    //   2136: aload 14
    //   2138: iconst_4
    //   2139: ldc_w 366
    //   2142: fastore
    //   2143: aload 14
    //   2145: iconst_5
    //   2146: fconst_1
    //   2147: fastore
    //   2148: aload 14
    //   2150: bipush 6
    //   2152: ldc_w 366
    //   2155: fastore
    //   2156: aload 14
    //   2158: bipush 7
    //   2160: ldc_w 366
    //   2163: fastore
    //   2164: goto -1312 -> 852
    //   2167: fload_1
    //   2168: fstore_3
    //   2169: goto -799 -> 1370
    //   2172: fload_1
    //   2173: fstore_3
    //   2174: goto -780 -> 1394
    //   2177: fconst_1
    //   2178: fload_1
    //   2179: fsub
    //   2180: fstore_3
    //   2181: goto -767 -> 1414
    //   2184: fconst_1
    //   2185: fload_1
    //   2186: fsub
    //   2187: fstore_1
    //   2188: goto -80 -> 2108
    //   2191: iload 5
    //   2193: iload 9
    //   2195: if_icmplt -517 -> 1678
    //   2198: iconst_0
    //   2199: istore 5
    //   2201: goto -750 -> 1451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2204	0	this	l
    //   720	1468	1	f1	float
    //   718	1382	2	f2	float
    //   749	1432	3	f3	float
    //   734	1364	4	f4	float
    //   27	2173	5	i	int
    //   33	2050	6	j	int
    //   390	1695	7	k	int
    //   397	1309	8	m	int
    //   404	1792	9	n	int
    //   422	721	10	i1	int
    //   435	1658	11	bool	boolean
    //   15	1987	12	localObject1	java.lang.Object
    //   21	1237	13	localObject2	java.lang.Object
    //   1316	104	13	localObject3	java.lang.Object
    //   1438	109	13	arrayOfByte	byte[]
    //   1661	265	13	localObject4	java.lang.Object
    //   1999	11	13	localObject5	java.lang.Object
    //   2012	97	13	localException	java.lang.Exception
    //   9	2148	14	localObject6	java.lang.Object
    //   865	11	15	locala	com.tencent.mm.plugin.voip.video.c.a
    // Exception table:
    //   from	to	target	type
    //   363	406	1316	finally
    //   437	497	1316	finally
    //   497	664	1316	finally
    //   669	672	1316	finally
    //   672	694	1316	finally
    //   699	702	1316	finally
    //   702	717	1316	finally
    //   721	750	1316	finally
    //   764	817	1316	finally
    //   820	852	1316	finally
    //   852	867	1316	finally
    //   872	875	1316	finally
    //   875	884	1316	finally
    //   891	900	1316	finally
    //   962	965	1316	finally
    //   965	978	1316	finally
    //   983	1069	1316	finally
    //   1069	1102	1316	finally
    //   1107	1122	1316	finally
    //   1138	1172	1316	finally
    //   1180	1188	1316	finally
    //   1204	1212	1316	finally
    //   1226	1234	1316	finally
    //   1249	1257	1316	finally
    //   1358	1366	1316	finally
    //   1382	1390	1316	finally
    //   1404	1412	1316	finally
    //   1427	1435	1316	finally
    //   1440	1451	1316	finally
    //   1456	1586	1316	finally
    //   1586	1589	1316	finally
    //   1655	1658	1316	finally
    //   1658	1663	1316	finally
    //   1684	1750	1316	finally
    //   1770	1773	1316	finally
    //   1927	1930	1316	finally
    //   2001	2012	1316	finally
    //   900	962	1438	finally
    //   1589	1655	1999	finally
    //   1753	1770	1999	finally
    //   1776	1902	1999	finally
    //   1902	1910	1999	finally
    //   1910	1927	1999	finally
    //   1933	1996	1999	finally
    //   2014	2025	1999	finally
    //   1902	1910	2012	java/lang/Exception
  }
  
  public final void cY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(236332);
    if ((paramInt1 != this.hEp) || (paramInt2 != this.hEq))
    {
      super.cY(paramInt1, paramInt2);
      h localh = this.Hpi.Hmy;
      if (localh != null)
      {
        localh.Hif = paramInt1;
        localh.Hig = paramInt2;
        AppMethodBeat.o(236332);
        return;
      }
    }
    AppMethodBeat.o(236332);
  }
  
  public final void release()
  {
    AppMethodBeat.i(236333);
    super.release();
    d locald = this.Hpi;
    h localh = locald.Hmy;
    if (localh != null) {
      localh.HmK.fLF();
    }
    GLES20.glDeleteProgram(locald.Hmx.programId);
    AppMethodBeat.o(236333);
  }
  
  public final void rl(int paramInt)
  {
    this.hDl = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.l
 * JD-Core Version:    0.7.0.1
 */