package com.tencent.mm.plugin.voip.video.render;

import android.graphics.Point;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.plugin.voip.video.c.f;
import com.tencent.mm.plugin.voip.video.c.g;
import com.tencent.mm.plugin.voip.video.c.i;
import d.g.b.p;
import java.nio.FloatBuffer;
import java.util.Arrays;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "renderSide", "", "textureWidth", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIIII)V", "inputTexture", "mRenderOnScreenProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "renderMode", "beforeRender", "", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderMode", "release", "renderImpl", "setInputTexture", "texture", "setShowMode", "mode", "updateDrawViewSize", "width", "height", "plugin-voip_release"})
public final class l
  extends a
{
  int Abn;
  public f CKK;
  int gNq;
  
  private l(int paramInt)
  {
    super(0, 0, 0, 0, 1, 2);
    AppMethodBeat.i(210644);
    this.CKK = new f(paramInt);
    this.gNq = -1;
    if (paramInt == 0) {}
    for (paramInt = i;; paramInt = 0)
    {
      this.Abn = paramInt;
      AppMethodBeat.o(210644);
      return;
    }
  }
  
  public final void amF()
  {
    AppMethodBeat.i(210640);
    float f7 = this.hqw.x / this.gNs;
    float f4 = (this.hqw.y - 1.0F) / this.gNt;
    float f6 = (this.hqx.x - 1.0F) / this.gNs;
    float f5 = this.hqx.y / this.gNt;
    float[] arrayOfFloat = com.tencent.mm.media.k.c.hrx;
    arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
    int i;
    int j;
    int k;
    int m;
    label153:
    label158:
    float f1;
    float f2;
    if ((this.hpY == 90) || (this.hpY == 270))
    {
      i = 1;
      j = this.hqx.x - this.hqw.x;
      k = this.hqw.y - this.hqx.y;
      if (i == 0) {
        break label403;
      }
      m = k;
      if (i == 0) {
        break label410;
      }
      f1 = this.gOm / m;
      f2 = this.gOn / j;
      if (f1 >= f2) {
        break label417;
      }
      f2 = m - this.gOm / f2;
      f1 = 0.0F;
    }
    for (;;)
    {
      label198:
      this.hqt = (m - (int)f2);
      this.hqu = (j - (int)f1);
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
        this.gNU.position(0);
        FloatBuffer localFloatBuffer = this.gNU;
        p.g(arrayOfFloat, "cropTextureCoord");
        localFloatBuffer.put(k(arrayOfFloat));
        this.gNU.position(0);
        this.gNV.position(0);
        this.gNV.put(com.tencent.mm.media.k.c.hrw);
        this.gNV.position(0);
        GLES20.glViewport(0, 0, this.gOm, this.gOn);
        AppMethodBeat.o(210640);
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
        f1 = j - this.gOn / f1;
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
  public final void aut()
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 65	com/tencent/mm/plugin/voip/video/render/l:CKK	Lcom/tencent/mm/plugin/voip/video/c/f;
    //   9: astore 15
    //   11: aload_0
    //   12: getfield 155	com/tencent/mm/media/j/b/a:gNV	Ljava/nio/FloatBuffer;
    //   15: astore 13
    //   17: aload_0
    //   18: getfield 130	com/tencent/mm/media/j/b/a:gNU	Ljava/nio/FloatBuffer;
    //   21: astore 14
    //   23: aload_0
    //   24: getfield 67	com/tencent/mm/plugin/voip/video/render/l:gNq	I
    //   27: istore 5
    //   29: aload_0
    //   30: getfield 69	com/tencent/mm/plugin/voip/video/render/l:Abn	I
    //   33: istore 6
    //   35: aload 13
    //   37: ldc 170
    //   39: invokestatic 172	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   42: aload 14
    //   44: ldc 174
    //   46: invokestatic 172	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   49: iload 6
    //   51: iconst_1
    //   52: if_icmpne +296 -> 348
    //   55: aload 15
    //   57: getfield 178	com/tencent/mm/plugin/voip/video/c/f:CIC	Lcom/tencent/mm/plugin/voip/video/c/g;
    //   60: astore 15
    //   62: aload 13
    //   64: ldc 170
    //   66: invokestatic 172	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   69: aload 14
    //   71: ldc 174
    //   73: invokestatic 172	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload 15
    //   78: getfield 184	com/tencent/mm/plugin/voip/video/c/g:CIF	Z
    //   81: ifeq +136 -> 217
    //   84: iload 5
    //   86: iconst_m1
    //   87: if_icmpeq +124 -> 211
    //   90: aload 15
    //   92: getfield 187	com/tencent/mm/plugin/voip/video/c/g:gOv	I
    //   95: invokestatic 190	android/opengl/GLES20:glUseProgram	(I)V
    //   98: ldc 191
    //   100: invokestatic 194	android/opengl/GLES20:glActiveTexture	(I)V
    //   103: ldc 195
    //   105: iload 5
    //   107: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   110: aload 15
    //   112: getfield 202	com/tencent/mm/plugin/voip/video/c/g:gOy	I
    //   115: iconst_0
    //   116: invokestatic 205	android/opengl/GLES20:glUniform1i	(II)V
    //   119: aload 13
    //   121: iconst_0
    //   122: invokevirtual 136	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   125: pop
    //   126: aload 15
    //   128: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   131: iconst_2
    //   132: sipush 5126
    //   135: iconst_0
    //   136: bipush 8
    //   138: aload 13
    //   140: checkcast 210	java/nio/Buffer
    //   143: invokestatic 214	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   146: aload 15
    //   148: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   151: invokestatic 217	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   154: aload 14
    //   156: iconst_0
    //   157: invokevirtual 136	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   160: pop
    //   161: aload 15
    //   163: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   166: iconst_2
    //   167: sipush 5126
    //   170: iconst_0
    //   171: bipush 8
    //   173: aload 14
    //   175: checkcast 210	java/nio/Buffer
    //   178: invokestatic 214	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   181: aload 15
    //   183: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   186: invokestatic 217	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   189: iconst_5
    //   190: iconst_0
    //   191: iconst_4
    //   192: invokestatic 224	android/opengl/GLES20:glDrawArrays	(III)V
    //   195: aload 15
    //   197: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   200: invokestatic 227	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   203: aload 15
    //   205: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   208: invokestatic 227	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   211: ldc 168
    //   213: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: return
    //   217: iload 5
    //   219: iconst_m1
    //   220: if_icmpeq +122 -> 342
    //   223: aload 15
    //   225: getfield 187	com/tencent/mm/plugin/voip/video/c/g:gOv	I
    //   228: invokestatic 190	android/opengl/GLES20:glUseProgram	(I)V
    //   231: ldc 191
    //   233: invokestatic 194	android/opengl/GLES20:glActiveTexture	(I)V
    //   236: sipush 3553
    //   239: iload 5
    //   241: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   244: aload 15
    //   246: getfield 202	com/tencent/mm/plugin/voip/video/c/g:gOy	I
    //   249: iconst_0
    //   250: invokestatic 205	android/opengl/GLES20:glUniform1i	(II)V
    //   253: aload 15
    //   255: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   258: iconst_2
    //   259: sipush 5126
    //   262: iconst_0
    //   263: iconst_0
    //   264: aload 13
    //   266: checkcast 210	java/nio/Buffer
    //   269: invokestatic 214	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   272: aload 15
    //   274: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   277: invokestatic 217	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   280: aload 15
    //   282: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   285: iconst_2
    //   286: sipush 5126
    //   289: iconst_0
    //   290: iconst_0
    //   291: aload 14
    //   293: checkcast 210	java/nio/Buffer
    //   296: invokestatic 214	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   299: aload 15
    //   301: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   304: invokestatic 217	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   307: iconst_5
    //   308: iconst_0
    //   309: iconst_4
    //   310: invokestatic 224	android/opengl/GLES20:glDrawArrays	(III)V
    //   313: aload 15
    //   315: getfield 208	com/tencent/mm/plugin/voip/video/c/g:gOw	I
    //   318: invokestatic 227	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   321: aload 15
    //   323: getfield 220	com/tencent/mm/plugin/voip/video/c/g:gOx	I
    //   326: invokestatic 227	android/opengl/GLES20:glDisableVertexAttribArray	(I)V
    //   329: sipush 3553
    //   332: iconst_0
    //   333: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   336: ldc 195
    //   338: iconst_0
    //   339: invokestatic 199	android/opengl/GLES20:glBindTexture	(II)V
    //   342: ldc 168
    //   344: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: return
    //   348: aload 15
    //   350: getfield 231	com/tencent/mm/plugin/voip/video/c/f:CID	Lcom/tencent/mm/plugin/voip/video/c/i;
    //   353: astore 13
    //   355: aload 13
    //   357: ifnull +1839 -> 2196
    //   360: aload 13
    //   362: getfield 237	com/tencent/mm/plugin/voip/video/c/i:CFa	[B
    //   365: ifnull +1825 -> 2190
    //   368: aload 13
    //   370: getfield 240	com/tencent/mm/plugin/voip/video/c/i:mWidth	I
    //   373: istore 5
    //   375: aload 13
    //   377: getfield 243	com/tencent/mm/plugin/voip/video/c/i:mHeight	I
    //   380: istore 6
    //   382: aload 13
    //   384: getfield 246	com/tencent/mm/plugin/voip/video/c/i:CET	I
    //   387: istore 7
    //   389: aload 13
    //   391: getfield 249	com/tencent/mm/plugin/voip/video/c/i:CEU	I
    //   394: istore 8
    //   396: aload 13
    //   398: getfield 252	com/tencent/mm/plugin/voip/video/c/i:wSY	I
    //   401: istore 9
    //   403: iload 5
    //   405: ifle +568 -> 973
    //   408: iload 6
    //   410: ifle +563 -> 973
    //   413: iload 9
    //   415: iconst_2
    //   416: ishr
    //   417: iconst_3
    //   418: iand
    //   419: istore 10
    //   421: iload 9
    //   423: iconst_4
    //   424: ishr
    //   425: iconst_1
    //   426: iand
    //   427: iconst_1
    //   428: if_icmpne +756 -> 1184
    //   431: iconst_1
    //   432: istore 12
    //   434: iload 5
    //   436: aload 13
    //   438: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   441: if_icmpne +53 -> 494
    //   444: iload 6
    //   446: aload 13
    //   448: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   451: if_icmpne +43 -> 494
    //   454: iload 7
    //   456: aload 13
    //   458: getfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   461: if_icmpne +33 -> 494
    //   464: iload 8
    //   466: aload 13
    //   468: getfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   471: if_icmpne +23 -> 494
    //   474: aload 13
    //   476: getfield 267	com/tencent/mm/plugin/voip/video/c/i:AVh	I
    //   479: iload 10
    //   481: if_icmpne +13 -> 494
    //   484: aload 13
    //   486: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   489: iload 12
    //   491: if_icmpeq +482 -> 973
    //   494: aload 13
    //   496: iload 10
    //   498: putfield 267	com/tencent/mm/plugin/voip/video/c/i:AVh	I
    //   501: aload 13
    //   503: iload 12
    //   505: putfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   508: ldc_w 272
    //   511: ldc_w 274
    //   514: bipush 9
    //   516: anewarray 276	java/lang/Object
    //   519: dup
    //   520: iconst_0
    //   521: aload 13
    //   523: getfield 267	com/tencent/mm/plugin/voip/video/c/i:AVh	I
    //   526: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: aload 13
    //   534: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   537: invokestatic 287	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   540: aastore
    //   541: dup
    //   542: iconst_2
    //   543: iload 5
    //   545: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   548: aastore
    //   549: dup
    //   550: iconst_3
    //   551: iload 6
    //   553: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   556: aastore
    //   557: dup
    //   558: iconst_4
    //   559: iload 7
    //   561: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: aastore
    //   565: dup
    //   566: iconst_5
    //   567: iload 8
    //   569: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   572: aastore
    //   573: dup
    //   574: bipush 6
    //   576: aload 13
    //   578: getfield 290	com/tencent/mm/plugin/voip/video/c/i:gOj	I
    //   581: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   584: aastore
    //   585: dup
    //   586: bipush 7
    //   588: aload 13
    //   590: getfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   593: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   596: aastore
    //   597: dup
    //   598: bipush 8
    //   600: aload 13
    //   602: getfield 296	com/tencent/mm/plugin/voip/video/c/i:CIg	I
    //   605: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   608: aastore
    //   609: invokestatic 301	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   612: aload 13
    //   614: iload 5
    //   616: putfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   619: aload 13
    //   621: iload 6
    //   623: putfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   626: aload 13
    //   628: iload 7
    //   630: putfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   633: aload 13
    //   635: iload 8
    //   637: putfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   640: aload 13
    //   642: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   645: istore 7
    //   647: aload 13
    //   649: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   652: istore 8
    //   654: aload 13
    //   656: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   659: astore 14
    //   661: aload 14
    //   663: ifnonnull +6 -> 669
    //   666: invokestatic 308	d/g/b/p:gkB	()V
    //   669: aload 14
    //   671: getfield 313	com/tencent/mm/plugin/voip/video/c/c:CHJ	[F
    //   674: astore 14
    //   676: aload 14
    //   678: ldc_w 315
    //   681: invokestatic 144	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   684: aload 13
    //   686: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   689: astore 15
    //   691: aload 15
    //   693: ifnonnull +6 -> 699
    //   696: invokestatic 308	d/g/b/p:gkB	()V
    //   699: aload 15
    //   701: getfield 318	com/tencent/mm/plugin/voip/video/c/c:CHI	[F
    //   704: astore 15
    //   706: aload 15
    //   708: ldc_w 320
    //   711: invokestatic 144	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   714: fconst_0
    //   715: fstore_2
    //   716: fconst_0
    //   717: fstore_1
    //   718: ldc_w 321
    //   721: ldc_w 322
    //   724: iload 7
    //   726: i2f
    //   727: fdiv
    //   728: fconst_2
    //   729: fdiv
    //   730: fadd
    //   731: fstore 4
    //   733: ldc_w 322
    //   736: iload 8
    //   738: i2f
    //   739: fdiv
    //   740: fconst_2
    //   741: fdiv
    //   742: ldc_w 321
    //   745: fadd
    //   746: fstore_3
    //   747: iload 7
    //   749: bipush 64
    //   751: isub
    //   752: istore 9
    //   754: iload 8
    //   756: bipush 64
    //   758: isub
    //   759: istore 10
    //   761: aload 13
    //   763: getfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   766: iload 9
    //   768: imul
    //   769: aload 13
    //   771: getfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   774: iload 10
    //   776: imul
    //   777: if_icmpge +413 -> 1190
    //   780: ldc_w 323
    //   783: fconst_1
    //   784: iload 9
    //   786: i2f
    //   787: fmul
    //   788: aload 13
    //   790: getfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   793: i2f
    //   794: fmul
    //   795: iload 8
    //   797: i2f
    //   798: fconst_2
    //   799: fmul
    //   800: aload 13
    //   802: getfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   805: i2f
    //   806: fmul
    //   807: fdiv
    //   808: fsub
    //   809: ldc_w 321
    //   812: fadd
    //   813: fstore_1
    //   814: fload_2
    //   815: fload 4
    //   817: fcmpl
    //   818: ifle +409 -> 1227
    //   821: fload_1
    //   822: fload_3
    //   823: fcmpl
    //   824: ifle +409 -> 1233
    //   827: aload 13
    //   829: getfield 267	com/tencent/mm/plugin/voip/video/c/i:AVh	I
    //   832: tableswitch	default:+28 -> 860, 1:+571->1403, 2:+28->860, 3:+406->1238
    //   861: fconst_2
    //   862: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   865: ifnull +27 -> 892
    //   868: aload 13
    //   870: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   873: astore 16
    //   875: aload 16
    //   877: ifnonnull +6 -> 883
    //   880: invokestatic 308	d/g/b/p:gkB	()V
    //   883: aload 16
    //   885: aload 15
    //   887: aload 14
    //   889: invokevirtual 327	com/tencent/mm/plugin/voip/video/c/c:c	([F[F)V
    //   892: iload 5
    //   894: iload 6
    //   896: imul
    //   897: istore 5
    //   899: iload 5
    //   901: iconst_4
    //   902: idiv
    //   903: istore 6
    //   905: aload 13
    //   907: monitorenter
    //   908: aload 13
    //   910: iload 6
    //   912: iconst_2
    //   913: imul
    //   914: iload 5
    //   916: iadd
    //   917: invokestatic 333	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   920: putfield 337	com/tencent/mm/plugin/voip/video/c/i:CHX	Ljava/nio/ByteBuffer;
    //   923: aload 13
    //   925: iload 5
    //   927: invokestatic 333	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   930: putfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   933: aload 13
    //   935: iload 6
    //   937: invokestatic 333	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   940: putfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   943: aload 13
    //   945: iload 6
    //   947: invokestatic 333	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   950: putfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   953: aload 13
    //   955: iload 6
    //   957: iconst_2
    //   958: imul
    //   959: invokestatic 333	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   962: putfield 348	com/tencent/mm/plugin/voip/video/c/i:CIa	Ljava/nio/ByteBuffer;
    //   965: getstatic 354	d/z:Nhr	Ld/z;
    //   968: astore 14
    //   970: aload 13
    //   972: monitorexit
    //   973: aload 13
    //   975: getfield 237	com/tencent/mm/plugin/voip/video/c/i:CFa	[B
    //   978: astore 14
    //   980: aload 13
    //   982: monitorenter
    //   983: aload 13
    //   985: iconst_0
    //   986: putfield 357	com/tencent/mm/plugin/voip/video/c/i:CIe	Z
    //   989: aload 14
    //   991: ifnull +738 -> 1729
    //   994: aload 13
    //   996: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   999: aload 13
    //   1001: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1004: imul
    //   1005: iconst_3
    //   1006: imul
    //   1007: iconst_2
    //   1008: idiv
    //   1009: istore 8
    //   1011: aload 13
    //   1013: aload 13
    //   1015: getfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   1018: iconst_1
    //   1019: iadd
    //   1020: putfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   1023: aload 13
    //   1025: getfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   1028: bipush 100
    //   1030: irem
    //   1031: ifne +49 -> 1080
    //   1034: ldc_w 272
    //   1037: ldc_w 359
    //   1040: iconst_3
    //   1041: anewarray 276	java/lang/Object
    //   1044: dup
    //   1045: iconst_0
    //   1046: aload 13
    //   1048: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1051: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_1
    //   1057: aload 13
    //   1059: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1062: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1065: aastore
    //   1066: dup
    //   1067: iconst_2
    //   1068: aload 13
    //   1070: getfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   1073: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1076: aastore
    //   1077: invokestatic 301	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1080: aload 14
    //   1082: arraylength
    //   1083: iload 8
    //   1085: if_icmplt +742 -> 1827
    //   1088: aload 13
    //   1090: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1093: istore 9
    //   1095: aload 13
    //   1097: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1100: istore 10
    //   1102: aload 13
    //   1104: getfield 293	com/tencent/mm/plugin/voip/video/c/i:CIf	I
    //   1107: bipush 100
    //   1109: irem
    //   1110: ifne +711 -> 1821
    //   1113: aload 14
    //   1115: ifnull +700 -> 1815
    //   1118: aload 14
    //   1120: arraylength
    //   1121: iload 9
    //   1123: iload 10
    //   1125: imul
    //   1126: iconst_3
    //   1127: imul
    //   1128: iconst_2
    //   1129: idiv
    //   1130: if_icmple +685 -> 1815
    //   1133: iconst_0
    //   1134: istore 6
    //   1136: iconst_0
    //   1137: istore 5
    //   1139: iload 5
    //   1141: iload 9
    //   1143: iload 10
    //   1145: imul
    //   1146: if_icmpge +435 -> 1581
    //   1149: aload 14
    //   1151: iload 5
    //   1153: baload
    //   1154: istore 11
    //   1156: iload 6
    //   1158: istore 7
    //   1160: iload 11
    //   1162: ifne +9 -> 1171
    //   1165: iload 6
    //   1167: iconst_1
    //   1168: iadd
    //   1169: istore 7
    //   1171: iload 5
    //   1173: iconst_1
    //   1174: iadd
    //   1175: istore 5
    //   1177: iload 7
    //   1179: istore 6
    //   1181: goto -42 -> 1139
    //   1184: iconst_0
    //   1185: istore 12
    //   1187: goto -753 -> 434
    //   1190: ldc_w 323
    //   1193: fconst_1
    //   1194: iload 10
    //   1196: i2f
    //   1197: fmul
    //   1198: aload 13
    //   1200: getfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   1203: i2f
    //   1204: fmul
    //   1205: iload 7
    //   1207: i2f
    //   1208: fconst_2
    //   1209: fmul
    //   1210: aload 13
    //   1212: getfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   1215: i2f
    //   1216: fmul
    //   1217: fdiv
    //   1218: fsub
    //   1219: ldc_w 321
    //   1222: fadd
    //   1223: fstore_2
    //   1224: goto -410 -> 814
    //   1227: fload 4
    //   1229: fstore_2
    //   1230: goto -409 -> 821
    //   1233: fload_3
    //   1234: fstore_1
    //   1235: goto -408 -> 827
    //   1238: aload 14
    //   1240: iconst_0
    //   1241: fload_2
    //   1242: fastore
    //   1243: aload 13
    //   1245: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1248: ifeq +131 -> 1379
    //   1251: fconst_1
    //   1252: fload_1
    //   1253: fsub
    //   1254: fstore_3
    //   1255: aload 14
    //   1257: iconst_1
    //   1258: fload_3
    //   1259: fastore
    //   1260: aload 14
    //   1262: iconst_2
    //   1263: fconst_1
    //   1264: fload_2
    //   1265: fsub
    //   1266: fastore
    //   1267: aload 13
    //   1269: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1272: ifeq +112 -> 1384
    //   1275: fconst_1
    //   1276: fload_1
    //   1277: fsub
    //   1278: fstore_3
    //   1279: aload 14
    //   1281: iconst_3
    //   1282: fload_3
    //   1283: fastore
    //   1284: aload 14
    //   1286: iconst_4
    //   1287: fload_2
    //   1288: fastore
    //   1289: aload 13
    //   1291: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1294: ifeq +95 -> 1389
    //   1297: fload_1
    //   1298: fstore_3
    //   1299: aload 14
    //   1301: iconst_5
    //   1302: fload_3
    //   1303: fastore
    //   1304: aload 14
    //   1306: bipush 6
    //   1308: fconst_1
    //   1309: fload_2
    //   1310: fsub
    //   1311: fastore
    //   1312: aload 13
    //   1314: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1317: ifeq +79 -> 1396
    //   1320: aload 14
    //   1322: bipush 7
    //   1324: fload_1
    //   1325: fastore
    //   1326: aload 15
    //   1328: iconst_0
    //   1329: ldc_w 360
    //   1332: fastore
    //   1333: aload 15
    //   1335: iconst_1
    //   1336: ldc_w 360
    //   1339: fastore
    //   1340: aload 15
    //   1342: iconst_2
    //   1343: ldc_w 360
    //   1346: fastore
    //   1347: aload 15
    //   1349: iconst_3
    //   1350: fconst_1
    //   1351: fastore
    //   1352: aload 15
    //   1354: iconst_4
    //   1355: fconst_1
    //   1356: fastore
    //   1357: aload 15
    //   1359: iconst_5
    //   1360: ldc_w 360
    //   1363: fastore
    //   1364: aload 15
    //   1366: bipush 6
    //   1368: fconst_1
    //   1369: fastore
    //   1370: aload 15
    //   1372: bipush 7
    //   1374: fconst_1
    //   1375: fastore
    //   1376: goto -516 -> 860
    //   1379: fload_1
    //   1380: fstore_3
    //   1381: goto -126 -> 1255
    //   1384: fload_1
    //   1385: fstore_3
    //   1386: goto -107 -> 1279
    //   1389: fconst_1
    //   1390: fload_1
    //   1391: fsub
    //   1392: fstore_3
    //   1393: goto -94 -> 1299
    //   1396: fconst_1
    //   1397: fload_1
    //   1398: fsub
    //   1399: fstore_1
    //   1400: goto -80 -> 1320
    //   1403: aload 14
    //   1405: iconst_0
    //   1406: fload_2
    //   1407: fastore
    //   1408: aload 13
    //   1410: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1413: ifeq +131 -> 1544
    //   1416: fconst_1
    //   1417: fload_1
    //   1418: fsub
    //   1419: fstore_3
    //   1420: aload 14
    //   1422: iconst_1
    //   1423: fload_3
    //   1424: fastore
    //   1425: aload 14
    //   1427: iconst_2
    //   1428: fconst_1
    //   1429: fload_2
    //   1430: fsub
    //   1431: fastore
    //   1432: aload 13
    //   1434: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1437: ifeq +112 -> 1549
    //   1440: fconst_1
    //   1441: fload_1
    //   1442: fsub
    //   1443: fstore_3
    //   1444: aload 14
    //   1446: iconst_3
    //   1447: fload_3
    //   1448: fastore
    //   1449: aload 14
    //   1451: iconst_4
    //   1452: fload_2
    //   1453: fastore
    //   1454: aload 13
    //   1456: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1459: ifeq +95 -> 1554
    //   1462: fload_1
    //   1463: fstore_3
    //   1464: aload 14
    //   1466: iconst_5
    //   1467: fload_3
    //   1468: fastore
    //   1469: aload 14
    //   1471: bipush 6
    //   1473: fconst_1
    //   1474: fload_2
    //   1475: fsub
    //   1476: fastore
    //   1477: aload 13
    //   1479: getfield 270	com/tencent/mm/plugin/voip/video/c/i:CIb	Z
    //   1482: ifeq +79 -> 1561
    //   1485: aload 14
    //   1487: bipush 7
    //   1489: fload_1
    //   1490: fastore
    //   1491: aload 15
    //   1493: iconst_0
    //   1494: fconst_1
    //   1495: fastore
    //   1496: aload 15
    //   1498: iconst_1
    //   1499: fconst_1
    //   1500: fastore
    //   1501: aload 15
    //   1503: iconst_2
    //   1504: fconst_1
    //   1505: fastore
    //   1506: aload 15
    //   1508: iconst_3
    //   1509: ldc_w 360
    //   1512: fastore
    //   1513: aload 15
    //   1515: iconst_4
    //   1516: ldc_w 360
    //   1519: fastore
    //   1520: aload 15
    //   1522: iconst_5
    //   1523: fconst_1
    //   1524: fastore
    //   1525: aload 15
    //   1527: bipush 6
    //   1529: ldc_w 360
    //   1532: fastore
    //   1533: aload 15
    //   1535: bipush 7
    //   1537: ldc_w 360
    //   1540: fastore
    //   1541: goto -681 -> 860
    //   1544: fload_1
    //   1545: fstore_3
    //   1546: goto -126 -> 1420
    //   1549: fload_1
    //   1550: fstore_3
    //   1551: goto -107 -> 1444
    //   1554: fconst_1
    //   1555: fload_1
    //   1556: fsub
    //   1557: fstore_3
    //   1558: goto -94 -> 1464
    //   1561: fconst_1
    //   1562: fload_1
    //   1563: fsub
    //   1564: fstore_1
    //   1565: goto -80 -> 1485
    //   1568: astore 14
    //   1570: aload 13
    //   1572: monitorexit
    //   1573: ldc 168
    //   1575: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1578: aload 14
    //   1580: athrow
    //   1581: iload 6
    //   1583: iload 9
    //   1585: iload 10
    //   1587: imul
    //   1588: if_icmplt +233 -> 1821
    //   1591: iconst_0
    //   1592: istore 5
    //   1594: iload 5
    //   1596: ifeq +231 -> 1827
    //   1599: aload 13
    //   1601: getfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   1604: invokevirtual 364	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1607: pop
    //   1608: aload 13
    //   1610: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   1613: invokevirtual 364	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1616: pop
    //   1617: aload 13
    //   1619: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   1622: invokevirtual 364	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1625: pop
    //   1626: aload 13
    //   1628: getfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   1631: aload 14
    //   1633: iconst_0
    //   1634: aload 13
    //   1636: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1639: aload 13
    //   1641: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1644: imul
    //   1645: invokevirtual 367	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1648: pop
    //   1649: aload 13
    //   1651: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   1654: aload 14
    //   1656: aload 13
    //   1658: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1661: aload 13
    //   1663: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1666: imul
    //   1667: aload 13
    //   1669: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1672: aload 13
    //   1674: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1677: imul
    //   1678: iconst_4
    //   1679: idiv
    //   1680: invokevirtual 367	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1683: pop
    //   1684: aload 13
    //   1686: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   1689: aload 14
    //   1691: aload 13
    //   1693: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1696: aload 13
    //   1698: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1701: imul
    //   1702: iconst_5
    //   1703: imul
    //   1704: iconst_4
    //   1705: idiv
    //   1706: aload 13
    //   1708: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1711: aload 13
    //   1713: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1716: imul
    //   1717: iconst_4
    //   1718: idiv
    //   1719: invokevirtual 367	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1722: pop
    //   1723: aload 13
    //   1725: iconst_1
    //   1726: putfield 357	com/tencent/mm/plugin/voip/video/c/i:CIe	Z
    //   1729: getstatic 354	d/z:Nhr	Ld/z;
    //   1732: astore 14
    //   1734: aload 13
    //   1736: monitorexit
    //   1737: aload 13
    //   1739: monitorenter
    //   1740: iconst_0
    //   1741: iconst_0
    //   1742: aload 13
    //   1744: getfield 261	com/tencent/mm/plugin/voip/video/c/i:mScreenWidth	I
    //   1747: aload 13
    //   1749: getfield 264	com/tencent/mm/plugin/voip/video/c/i:mScreenHeight	I
    //   1752: invokestatic 164	android/opengl/GLES20:glViewport	(IIII)V
    //   1755: sipush 16640
    //   1758: invokestatic 370	android/opengl/GLES20:glClear	(I)V
    //   1761: fconst_0
    //   1762: fconst_0
    //   1763: fconst_0
    //   1764: fconst_0
    //   1765: invokestatic 374	android/opengl/GLES20:glClearColor	(FFFF)V
    //   1768: aload 13
    //   1770: getfield 377	com/tencent/mm/plugin/voip/video/c/i:hpW	Z
    //   1773: ifeq +136 -> 1909
    //   1776: ldc_w 272
    //   1779: ldc_w 379
    //   1782: iconst_1
    //   1783: anewarray 276	java/lang/Object
    //   1786: dup
    //   1787: iconst_0
    //   1788: aload 13
    //   1790: getfield 290	com/tencent/mm/plugin/voip/video/c/i:gOj	I
    //   1793: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1796: aastore
    //   1797: invokestatic 301	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1800: aload 13
    //   1802: iconst_0
    //   1803: putfield 377	com/tencent/mm/plugin/voip/video/c/i:hpW	Z
    //   1806: aload 13
    //   1808: monitorexit
    //   1809: ldc 168
    //   1811: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1814: return
    //   1815: iconst_0
    //   1816: istore 5
    //   1818: goto -224 -> 1594
    //   1821: iconst_1
    //   1822: istore 5
    //   1824: goto -230 -> 1594
    //   1827: ldc_w 272
    //   1830: ldc_w 381
    //   1833: iconst_4
    //   1834: anewarray 276	java/lang/Object
    //   1837: dup
    //   1838: iconst_0
    //   1839: aload 14
    //   1841: arraylength
    //   1842: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1845: aastore
    //   1846: dup
    //   1847: iconst_1
    //   1848: iload 8
    //   1850: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1853: aastore
    //   1854: dup
    //   1855: iconst_2
    //   1856: aload 13
    //   1858: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1861: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1864: aastore
    //   1865: dup
    //   1866: iconst_3
    //   1867: aload 13
    //   1869: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1872: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1875: aastore
    //   1876: invokestatic 384	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1879: aload 13
    //   1881: iconst_0
    //   1882: putfield 357	com/tencent/mm/plugin/voip/video/c/i:CIe	Z
    //   1885: getstatic 390	com/tencent/mm/plugin/voip/model/t:Cvc	Lcom/tencent/mm/plugin/voip/model/t;
    //   1888: astore 14
    //   1890: invokestatic 393	com/tencent/mm/plugin/voip/model/t:eAV	()V
    //   1893: goto -164 -> 1729
    //   1896: astore 14
    //   1898: aload 13
    //   1900: monitorexit
    //   1901: ldc 168
    //   1903: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1906: aload 14
    //   1908: athrow
    //   1909: aload 13
    //   1911: getfield 357	com/tencent/mm/plugin/voip/video/c/i:CIe	Z
    //   1914: ifne +21 -> 1935
    //   1917: ldc_w 272
    //   1920: ldc_w 395
    //   1923: invokestatic 398	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1926: aload 13
    //   1928: monitorexit
    //   1929: ldc 168
    //   1931: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1934: return
    //   1935: aload 13
    //   1937: getfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   1940: invokevirtual 402	java/nio/ByteBuffer:capacity	()I
    //   1943: aload 13
    //   1945: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1948: aload 13
    //   1950: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1953: imul
    //   1954: if_icmpne +107 -> 2061
    //   1957: aload 13
    //   1959: getfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   1962: iconst_0
    //   1963: invokevirtual 403	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1966: pop
    //   1967: aload 13
    //   1969: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   1972: aload 13
    //   1974: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   1977: imul
    //   1978: iconst_4
    //   1979: idiv
    //   1980: istore 5
    //   1982: aload 13
    //   1984: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   1987: invokevirtual 402	java/nio/ByteBuffer:capacity	()I
    //   1990: iload 5
    //   1992: if_icmpne +103 -> 2095
    //   1995: aload 13
    //   1997: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   2000: invokevirtual 402	java/nio/ByteBuffer:capacity	()I
    //   2003: iload 5
    //   2005: if_icmpne +90 -> 2095
    //   2008: aload 13
    //   2010: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   2013: iconst_0
    //   2014: invokevirtual 403	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2017: pop
    //   2018: aload 13
    //   2020: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   2023: iconst_0
    //   2024: invokevirtual 403	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2027: pop
    //   2028: aload 13
    //   2030: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   2033: aload 13
    //   2035: getfield 339	com/tencent/mm/plugin/voip/video/c/i:y	Ljava/nio/ByteBuffer;
    //   2038: aload 13
    //   2040: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   2043: aload 13
    //   2045: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   2048: aload 13
    //   2050: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   2053: aload 13
    //   2055: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   2058: invokevirtual 407	com/tencent/mm/plugin/voip/video/c/c:a	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;II)V
    //   2061: aload 13
    //   2063: getfield 305	com/tencent/mm/plugin/voip/video/c/i:CIJ	Lcom/tencent/mm/plugin/voip/video/c/c;
    //   2066: invokevirtual 410	com/tencent/mm/plugin/voip/video/c/c:eEH	()V
    //   2069: aload 13
    //   2071: aconst_null
    //   2072: putfield 237	com/tencent/mm/plugin/voip/video/c/i:CFa	[B
    //   2075: aload 13
    //   2077: aconst_null
    //   2078: putfield 414	com/tencent/mm/plugin/voip/video/c/i:CFb	[I
    //   2081: getstatic 354	d/z:Nhr	Ld/z;
    //   2084: astore 14
    //   2086: aload 13
    //   2088: monitorexit
    //   2089: ldc 168
    //   2091: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2094: return
    //   2095: ldc_w 272
    //   2098: ldc_w 416
    //   2101: iconst_4
    //   2102: anewarray 276	java/lang/Object
    //   2105: dup
    //   2106: iconst_0
    //   2107: aload 13
    //   2109: getfield 342	com/tencent/mm/plugin/voip/video/c/i:CHY	Ljava/nio/ByteBuffer;
    //   2112: invokevirtual 402	java/nio/ByteBuffer:capacity	()I
    //   2115: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2118: aastore
    //   2119: dup
    //   2120: iconst_1
    //   2121: aload 13
    //   2123: getfield 345	com/tencent/mm/plugin/voip/video/c/i:CHZ	Ljava/nio/ByteBuffer;
    //   2126: invokevirtual 402	java/nio/ByteBuffer:capacity	()I
    //   2129: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2132: aastore
    //   2133: dup
    //   2134: iconst_2
    //   2135: aload 13
    //   2137: getfield 255	com/tencent/mm/plugin/voip/video/c/i:mVideoWidth	I
    //   2140: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2143: aastore
    //   2144: dup
    //   2145: iconst_3
    //   2146: aload 13
    //   2148: getfield 258	com/tencent/mm/plugin/voip/video/c/i:mVideoHeight	I
    //   2151: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2154: aastore
    //   2155: invokestatic 384	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2158: goto -97 -> 2061
    //   2161: astore 14
    //   2163: aload 13
    //   2165: monitorexit
    //   2166: ldc 168
    //   2168: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2171: aload 14
    //   2173: athrow
    //   2174: astore 14
    //   2176: ldc_w 272
    //   2179: aload 14
    //   2181: invokevirtual 420	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2184: invokestatic 422	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2187: goto -118 -> 2069
    //   2190: ldc 168
    //   2192: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2195: return
    //   2196: ldc 168
    //   2198: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2201: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2202	0	this	l
    //   717	848	1	f1	float
    //   715	760	2	f2	float
    //   746	812	3	f3	float
    //   731	497	4	f4	float
    //   27	1979	5	i	int
    //   33	1556	6	j	int
    //   387	819	7	k	int
    //   394	1455	8	m	int
    //   401	1187	9	n	int
    //   419	1169	10	i1	int
    //   1154	7	11	i2	int
    //   432	754	12	bool	boolean
    //   15	2149	13	localObject1	java.lang.Object
    //   21	1465	14	localObject2	java.lang.Object
    //   1568	122	14	arrayOfByte	byte[]
    //   1732	157	14	localObject3	java.lang.Object
    //   1896	11	14	localObject4	java.lang.Object
    //   2084	1	14	localz	d.z
    //   2161	11	14	localObject5	java.lang.Object
    //   2174	6	14	localException	java.lang.Exception
    //   9	1525	15	localObject6	java.lang.Object
    //   873	11	16	localc	com.tencent.mm.plugin.voip.video.c.c
    // Exception table:
    //   from	to	target	type
    //   908	970	1568	finally
    //   983	989	1896	finally
    //   994	1080	1896	finally
    //   1080	1113	1896	finally
    //   1118	1133	1896	finally
    //   1599	1729	1896	finally
    //   1729	1734	1896	finally
    //   1827	1893	1896	finally
    //   1740	1806	2161	finally
    //   1909	1926	2161	finally
    //   1935	2061	2161	finally
    //   2061	2069	2161	finally
    //   2069	2086	2161	finally
    //   2095	2158	2161	finally
    //   2176	2187	2161	finally
    //   2061	2069	2174	java/lang/Exception
  }
  
  public final void cT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210642);
    if ((paramInt1 != this.gOm) || (paramInt2 != this.gOn))
    {
      super.cT(paramInt1, paramInt2);
      i locali = this.CKK.CID;
      if (locali != null)
      {
        locali.CET = paramInt1;
        locali.CEU = paramInt2;
        AppMethodBeat.o(210642);
        return;
      }
    }
    AppMethodBeat.o(210642);
  }
  
  public final void nQ(int paramInt)
  {
    this.gNq = paramInt;
  }
  
  public final void release()
  {
    AppMethodBeat.i(210643);
    super.release();
    f localf = this.CKK;
    i locali = localf.CID;
    if (locali != null) {
      locali.CIJ.eEy();
    }
    GLES20.glDeleteProgram(localf.CIC.gOv);
    AppMethodBeat.o(210643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.l
 * JD-Core Version:    0.7.0.1
 */