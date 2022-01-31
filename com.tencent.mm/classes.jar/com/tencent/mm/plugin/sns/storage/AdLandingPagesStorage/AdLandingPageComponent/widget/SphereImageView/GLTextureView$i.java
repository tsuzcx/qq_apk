package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class GLTextureView$i
  extends Thread
{
  int height;
  boolean kH;
  boolean rAA;
  boolean rAB;
  private boolean rAC;
  private int rAD;
  boolean rAE;
  boolean rAF;
  ArrayList<Runnable> rAG;
  boolean rAH;
  private GLTextureView.h rAI;
  private WeakReference<GLTextureView> rAo;
  private boolean rAu;
  boolean rAv;
  private boolean rAw;
  boolean rAx;
  private boolean rAy;
  boolean rAz;
  int width;
  
  GLTextureView$i(WeakReference<GLTextureView> paramWeakReference)
  {
    AppMethodBeat.i(145345);
    this.rAG = new ArrayList();
    this.rAH = true;
    this.width = 0;
    this.height = 0;
    this.rAE = true;
    this.rAD = 1;
    this.rAo = paramWeakReference;
    AppMethodBeat.o(145345);
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: ldc 75
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 77	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h
    //   9: dup
    //   10: aload_0
    //   11: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAo	Ljava/lang/ref/WeakReference;
    //   14: invokespecial 79	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:<init>	(Ljava/lang/ref/WeakReference;)V
    //   17: putfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAA	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   30: iconst_0
    //   31: istore 6
    //   33: iconst_0
    //   34: istore 8
    //   36: iconst_0
    //   37: istore 4
    //   39: iconst_0
    //   40: istore 5
    //   42: iconst_0
    //   43: istore 7
    //   45: iconst_0
    //   46: istore 10
    //   48: iconst_0
    //   49: istore 11
    //   51: aconst_null
    //   52: astore 16
    //   54: iconst_0
    //   55: istore_2
    //   56: iconst_0
    //   57: istore_1
    //   58: iconst_0
    //   59: istore_3
    //   60: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   63: astore 17
    //   65: aload 17
    //   67: monitorenter
    //   68: iload_1
    //   69: istore 9
    //   71: iload 5
    //   73: istore 12
    //   75: iload_2
    //   76: istore 5
    //   78: iload 8
    //   80: istore_1
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: getfield 91	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAu	Z
    //   88: ifeq +44 -> 132
    //   91: aload 17
    //   93: monitorexit
    //   94: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   97: astore 16
    //   99: aload 16
    //   101: monitorenter
    //   102: aload_0
    //   103: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   106: aload_0
    //   107: invokespecial 97	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglContextLocked	()V
    //   110: aload 16
    //   112: monitorexit
    //   113: ldc 75
    //   115: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: astore 17
    //   121: aload 16
    //   123: monitorexit
    //   124: ldc 75
    //   126: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload 17
    //   131: athrow
    //   132: aload_0
    //   133: getfield 49	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAG	Ljava/util/ArrayList;
    //   136: invokevirtual 101	java/util/ArrayList:isEmpty	()Z
    //   139: ifne +57 -> 196
    //   142: aload_0
    //   143: getfield 49	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAG	Ljava/util/ArrayList;
    //   146: iconst_0
    //   147: invokevirtual 105	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   150: checkcast 107	java/lang/Runnable
    //   153: astore 18
    //   155: iload 5
    //   157: istore 13
    //   159: iload 12
    //   161: istore 5
    //   163: iload_1
    //   164: istore 8
    //   166: iload_2
    //   167: istore 4
    //   169: iload 9
    //   171: istore_1
    //   172: iload 13
    //   174: istore_2
    //   175: aload 17
    //   177: monitorexit
    //   178: aload 18
    //   180: ifnull +861 -> 1041
    //   183: aload 18
    //   185: invokeinterface 110 1 0
    //   190: aconst_null
    //   191: astore 16
    //   193: goto -133 -> 60
    //   196: aload_0
    //   197: getfield 112	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:kH	Z
    //   200: aload_0
    //   201: getfield 114	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAw	Z
    //   204: if_icmpeq +1553 -> 1757
    //   207: aload_0
    //   208: getfield 114	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAw	Z
    //   211: istore 14
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 114	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAw	Z
    //   218: putfield 112	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:kH	Z
    //   221: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   224: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   227: aload_0
    //   228: getfield 121	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAC	Z
    //   231: ifeq +1523 -> 1754
    //   234: aload_0
    //   235: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   238: aload_0
    //   239: invokespecial 97	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglContextLocked	()V
    //   242: aload_0
    //   243: iconst_0
    //   244: putfield 121	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAC	Z
    //   247: iconst_1
    //   248: istore 7
    //   250: iload 9
    //   252: ifeq +1495 -> 1747
    //   255: aload_0
    //   256: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   259: aload_0
    //   260: invokespecial 97	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglContextLocked	()V
    //   263: iconst_0
    //   264: istore 4
    //   266: iload 14
    //   268: ifeq +14 -> 282
    //   271: aload_0
    //   272: getfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   275: ifeq +7 -> 282
    //   278: aload_0
    //   279: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   282: iload 14
    //   284: ifeq +48 -> 332
    //   287: aload_0
    //   288: getfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAA	Z
    //   291: ifeq +41 -> 332
    //   294: aload_0
    //   295: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAo	Ljava/lang/ref/WeakReference;
    //   298: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   301: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   304: astore 18
    //   306: aload 18
    //   308: ifnonnull +275 -> 583
    //   311: iconst_0
    //   312: istore 15
    //   314: iload 15
    //   316: ifeq +12 -> 328
    //   319: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   322: invokevirtual 132	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:crO	()Z
    //   325: ifeq +7 -> 332
    //   328: aload_0
    //   329: invokespecial 97	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglContextLocked	()V
    //   332: iload 14
    //   334: ifeq +19 -> 353
    //   337: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   340: invokevirtual 135	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:crP	()Z
    //   343: ifeq +10 -> 353
    //   346: aload_0
    //   347: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   350: invokevirtual 138	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:finish	()V
    //   353: aload_0
    //   354: getfield 140	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAx	Z
    //   357: ifne +37 -> 394
    //   360: aload_0
    //   361: getfield 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAz	Z
    //   364: ifne +30 -> 394
    //   367: aload_0
    //   368: getfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   371: ifeq +7 -> 378
    //   374: aload_0
    //   375: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   378: aload_0
    //   379: iconst_1
    //   380: putfield 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAz	Z
    //   383: aload_0
    //   384: iconst_0
    //   385: putfield 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAy	Z
    //   388: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   391: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   394: aload_0
    //   395: getfield 140	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAx	Z
    //   398: ifeq +21 -> 419
    //   401: aload_0
    //   402: getfield 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAz	Z
    //   405: ifeq +14 -> 419
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 142	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAz	Z
    //   413: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   416: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   419: iload 5
    //   421: ifeq +1319 -> 1740
    //   424: iconst_0
    //   425: istore 9
    //   427: aload_0
    //   428: iconst_1
    //   429: putfield 146	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAF	Z
    //   432: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   435: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   438: iconst_0
    //   439: istore 5
    //   441: aload_0
    //   442: invokevirtual 149	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:readyToDraw	()Z
    //   445: ifeq +1289 -> 1734
    //   448: iload_3
    //   449: istore 8
    //   451: aload_0
    //   452: getfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAA	Z
    //   455: ifne +488 -> 943
    //   458: iload 7
    //   460: ifeq +133 -> 593
    //   463: iconst_0
    //   464: istore 8
    //   466: iload_3
    //   467: istore 7
    //   469: iload 8
    //   471: istore_3
    //   472: aload_0
    //   473: getfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAA	Z
    //   476: ifeq +1252 -> 1728
    //   479: aload_0
    //   480: getfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   483: ifne +1245 -> 1728
    //   486: aload_0
    //   487: iconst_1
    //   488: putfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   491: iconst_1
    //   492: istore 6
    //   494: iconst_1
    //   495: istore 8
    //   497: iconst_1
    //   498: istore_2
    //   499: aload_0
    //   500: getfield 85	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAB	Z
    //   503: ifeq +508 -> 1011
    //   506: aload_0
    //   507: getfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAH	Z
    //   510: ifeq +1210 -> 1720
    //   513: aload_0
    //   514: getfield 53	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:width	I
    //   517: istore 10
    //   519: aload_0
    //   520: getfield 55	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:height	I
    //   523: istore_2
    //   524: iconst_1
    //   525: istore 6
    //   527: aload_0
    //   528: iconst_0
    //   529: putfield 51	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAH	Z
    //   532: iconst_1
    //   533: istore 9
    //   535: iconst_1
    //   536: istore_1
    //   537: aload_0
    //   538: iconst_0
    //   539: putfield 57	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAE	Z
    //   542: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   545: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   548: iload_2
    //   549: istore 11
    //   551: iload_3
    //   552: istore 12
    //   554: iload 5
    //   556: istore_2
    //   557: iload_1
    //   558: istore_3
    //   559: iload 4
    //   561: istore_1
    //   562: iload_3
    //   563: istore 4
    //   565: iload 7
    //   567: istore_3
    //   568: iload 9
    //   570: istore 5
    //   572: iload 12
    //   574: istore 7
    //   576: aload 16
    //   578: astore 18
    //   580: goto -405 -> 175
    //   583: aload 18
    //   585: invokestatic 153	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:g	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Z
    //   588: istore 15
    //   590: goto -276 -> 314
    //   593: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   596: astore 18
    //   598: aload 18
    //   600: getfield 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
    //   603: aload_0
    //   604: if_acmpeq +11 -> 615
    //   607: aload 18
    //   609: getfield 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
    //   612: ifnonnull +149 -> 761
    //   615: aload 18
    //   617: aload_0
    //   618: putfield 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
    //   621: aload 18
    //   623: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   626: iconst_1
    //   627: istore 12
    //   629: iload_3
    //   630: istore 8
    //   632: iload 12
    //   634: ifeq +309 -> 943
    //   637: aload_0
    //   638: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   641: astore 18
    //   643: aload 18
    //   645: invokestatic 163	javax/microedition/khronos/egl/EGLContext:getEGL	()Ljavax/microedition/khronos/egl/EGL;
    //   648: checkcast 165	javax/microedition/khronos/egl/EGL10
    //   651: putfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   654: aload 18
    //   656: aload 18
    //   658: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   661: getstatic 173	javax/microedition/khronos/egl/EGL10:EGL_DEFAULT_DISPLAY	Ljava/lang/Object;
    //   664: invokeinterface 177 2 0
    //   669: putfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   672: aload 18
    //   674: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   677: getstatic 184	javax/microedition/khronos/egl/EGL10:EGL_NO_DISPLAY	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   680: if_acmpne +129 -> 809
    //   683: new 74	java/lang/RuntimeException
    //   686: dup
    //   687: ldc 186
    //   689: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   692: astore 16
    //   694: ldc 75
    //   696: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   699: aload 16
    //   701: athrow
    //   702: astore 16
    //   704: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   707: aload_0
    //   708: invokevirtual 193	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:c	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
    //   711: ldc 75
    //   713: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   716: aload 16
    //   718: athrow
    //   719: astore 16
    //   721: aload 17
    //   723: monitorexit
    //   724: ldc 75
    //   726: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   729: aload 16
    //   731: athrow
    //   732: astore 17
    //   734: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   737: astore 16
    //   739: aload 16
    //   741: monitorenter
    //   742: aload_0
    //   743: invokespecial 94	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglSurfaceLocked	()V
    //   746: aload_0
    //   747: invokespecial 97	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:stopEglContextLocked	()V
    //   750: aload 16
    //   752: monitorexit
    //   753: ldc 75
    //   755: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   758: aload 17
    //   760: athrow
    //   761: aload 18
    //   763: invokevirtual 196	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:crQ	()V
    //   766: aload 18
    //   768: getfield 199	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAM	Z
    //   771: ifeq +9 -> 780
    //   774: iconst_1
    //   775: istore 12
    //   777: goto -148 -> 629
    //   780: aload 18
    //   782: getfield 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
    //   785: ifnull +18 -> 803
    //   788: aload 18
    //   790: getfield 157	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:rAO	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;
    //   793: iconst_1
    //   794: putfield 121	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAC	Z
    //   797: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   800: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   803: iconst_0
    //   804: istore 12
    //   806: goto -177 -> 629
    //   809: iconst_2
    //   810: newarray int
    //   812: astore 19
    //   814: aload 18
    //   816: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   819: aload 18
    //   821: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   824: aload 19
    //   826: invokeinterface 203 3 0
    //   831: ifne +22 -> 853
    //   834: new 74	java/lang/RuntimeException
    //   837: dup
    //   838: ldc 205
    //   840: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   843: astore 16
    //   845: ldc 75
    //   847: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   850: aload 16
    //   852: athrow
    //   853: aload 18
    //   855: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAo	Ljava/lang/ref/WeakReference;
    //   858: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   861: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   864: astore 19
    //   866: aload 19
    //   868: ifnonnull +85 -> 953
    //   871: aload 18
    //   873: aconst_null
    //   874: putfield 210	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAs	Ljavax/microedition/khronos/egl/EGLConfig;
    //   877: aload 18
    //   879: aconst_null
    //   880: putfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   883: aload 18
    //   885: getfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   888: ifnull +14 -> 902
    //   891: aload 18
    //   893: getfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   896: getstatic 217	javax/microedition/khronos/egl/EGL10:EGL_NO_CONTEXT	Ljavax/microedition/khronos/egl/EGLContext;
    //   899: if_acmpne +24 -> 923
    //   902: aload 18
    //   904: aconst_null
    //   905: putfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   908: ldc 219
    //   910: aload 18
    //   912: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   915: invokeinterface 223 1 0
    //   920: invokestatic 227	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:throwEglException	(Ljava/lang/String;I)V
    //   923: aload 18
    //   925: aconst_null
    //   926: putfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   929: aload_0
    //   930: iconst_1
    //   931: putfield 83	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAA	Z
    //   934: iconst_1
    //   935: istore 8
    //   937: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   940: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   943: iload 7
    //   945: istore_3
    //   946: iload 8
    //   948: istore 7
    //   950: goto -478 -> 472
    //   953: aload 18
    //   955: aload 19
    //   957: invokestatic 235	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$e;
    //   960: aload 18
    //   962: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   965: aload 18
    //   967: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   970: invokeinterface 241 3 0
    //   975: putfield 210	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAs	Ljavax/microedition/khronos/egl/EGLConfig;
    //   978: aload 18
    //   980: aload 19
    //   982: invokestatic 244	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:c	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$f;
    //   985: aload 18
    //   987: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   990: aload 18
    //   992: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   995: aload 18
    //   997: getfield 210	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAs	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1000: invokeinterface 249 4 0
    //   1005: putfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   1008: goto -125 -> 883
    //   1011: iload 8
    //   1013: istore_1
    //   1014: iload 7
    //   1016: istore 8
    //   1018: iload_3
    //   1019: istore 7
    //   1021: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1024: invokevirtual 252	java/lang/Object:wait	()V
    //   1027: iload 8
    //   1029: istore_3
    //   1030: iload 9
    //   1032: istore 12
    //   1034: iload 4
    //   1036: istore 9
    //   1038: goto -954 -> 84
    //   1041: iload 6
    //   1043: ifeq +720 -> 1763
    //   1046: aload_0
    //   1047: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   1050: astore 16
    //   1052: aload 16
    //   1054: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1057: ifnonnull +22 -> 1079
    //   1060: new 74	java/lang/RuntimeException
    //   1063: dup
    //   1064: ldc 254
    //   1066: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1069: astore 16
    //   1071: ldc 75
    //   1073: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1076: aload 16
    //   1078: athrow
    //   1079: aload 16
    //   1081: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1084: ifnonnull +23 -> 1107
    //   1087: new 74	java/lang/RuntimeException
    //   1090: dup
    //   1091: ldc_w 256
    //   1094: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1097: astore 16
    //   1099: ldc 75
    //   1101: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1104: aload 16
    //   1106: athrow
    //   1107: aload 16
    //   1109: getfield 210	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAs	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1112: ifnonnull +23 -> 1135
    //   1115: new 74	java/lang/RuntimeException
    //   1118: dup
    //   1119: ldc_w 258
    //   1122: invokespecial 189	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   1125: astore 16
    //   1127: ldc 75
    //   1129: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1132: aload 16
    //   1134: athrow
    //   1135: aload 16
    //   1137: invokevirtual 261	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:destroySurfaceImp	()V
    //   1140: aload 16
    //   1142: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAo	Ljava/lang/ref/WeakReference;
    //   1145: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1148: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   1151: astore 17
    //   1153: aload 17
    //   1155: ifnull +105 -> 1260
    //   1158: aload 16
    //   1160: aload 17
    //   1162: invokestatic 265	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:d	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$g;
    //   1165: aload 16
    //   1167: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1170: aload 16
    //   1172: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1175: aload 16
    //   1177: getfield 210	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAs	Ljavax/microedition/khronos/egl/EGLConfig;
    //   1180: aload 17
    //   1182: invokevirtual 269	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:getSurfaceTexture	()Landroid/graphics/SurfaceTexture;
    //   1185: invokeinterface 275 5 0
    //   1190: putfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1193: aload 16
    //   1195: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1198: ifnull +14 -> 1212
    //   1201: aload 16
    //   1203: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1206: getstatic 278	javax/microedition/khronos/egl/EGL10:EGL_NO_SURFACE	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1209: if_acmpne +60 -> 1269
    //   1212: aload 16
    //   1214: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1217: invokeinterface 223 1 0
    //   1222: pop
    //   1223: iconst_0
    //   1224: istore 9
    //   1226: iload 9
    //   1228: ifne +538 -> 1766
    //   1231: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1234: astore 16
    //   1236: aload 16
    //   1238: monitorenter
    //   1239: aload_0
    //   1240: iconst_1
    //   1241: putfield 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAy	Z
    //   1244: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1247: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   1250: aload 16
    //   1252: monitorexit
    //   1253: aload 18
    //   1255: astore 16
    //   1257: goto -1197 -> 60
    //   1260: aload 16
    //   1262: aconst_null
    //   1263: putfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1266: goto -73 -> 1193
    //   1269: aload 16
    //   1271: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1274: aload 16
    //   1276: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1279: aload 16
    //   1281: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1284: aload 16
    //   1286: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1289: aload 16
    //   1291: getfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   1294: invokeinterface 282 5 0
    //   1299: ifne +26 -> 1325
    //   1302: ldc_w 283
    //   1305: aload 16
    //   1307: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1310: invokeinterface 223 1 0
    //   1315: invokestatic 287	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:formatEglError	(Ljava/lang/String;I)Ljava/lang/String;
    //   1318: pop
    //   1319: iconst_0
    //   1320: istore 9
    //   1322: goto -96 -> 1226
    //   1325: iconst_1
    //   1326: istore 9
    //   1328: goto -102 -> 1226
    //   1331: astore 17
    //   1333: aload 16
    //   1335: monitorexit
    //   1336: ldc 75
    //   1338: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1341: aload 17
    //   1343: athrow
    //   1344: iload 8
    //   1346: istore 9
    //   1348: iload 8
    //   1350: ifeq +139 -> 1489
    //   1353: aload_0
    //   1354: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   1357: astore 17
    //   1359: aload 17
    //   1361: getfield 214	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAt	Ljavax/microedition/khronos/egl/EGLContext;
    //   1364: invokevirtual 291	javax/microedition/khronos/egl/EGLContext:getGL	()Ljavax/microedition/khronos/opengles/GL;
    //   1367: astore 16
    //   1369: aload 17
    //   1371: getfield 206	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAo	Ljava/lang/ref/WeakReference;
    //   1374: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1377: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   1380: astore 19
    //   1382: aload 16
    //   1384: astore 17
    //   1386: aload 19
    //   1388: ifnull +325 -> 1713
    //   1391: aload 19
    //   1393: invokestatic 295	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:e	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$k;
    //   1396: ifnull +15 -> 1411
    //   1399: aload 19
    //   1401: invokestatic 295	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:e	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$k;
    //   1404: invokeinterface 300 1 0
    //   1409: astore 16
    //   1411: aload 16
    //   1413: astore 17
    //   1415: aload 19
    //   1417: invokestatic 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
    //   1420: iconst_3
    //   1421: iand
    //   1422: ifeq +291 -> 1713
    //   1425: iconst_0
    //   1426: istore 8
    //   1428: aload 19
    //   1430: invokestatic 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
    //   1433: iconst_1
    //   1434: iand
    //   1435: ifeq +6 -> 1441
    //   1438: iconst_1
    //   1439: istore 8
    //   1441: aload 19
    //   1443: invokestatic 304	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:f	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)I
    //   1446: iconst_2
    //   1447: iand
    //   1448: ifeq +259 -> 1707
    //   1451: new 306	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$l
    //   1454: dup
    //   1455: invokespecial 307	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$l:<init>	()V
    //   1458: astore 17
    //   1460: aload 16
    //   1462: iload 8
    //   1464: aload 17
    //   1466: invokestatic 313	android/opengl/GLDebugHelper:wrap	(Ljavax/microedition/khronos/opengles/GL;ILjava/io/Writer;)Ljavax/microedition/khronos/opengles/GL;
    //   1469: astore 16
    //   1471: aload 16
    //   1473: checkcast 315	javax/microedition/khronos/opengles/GL10
    //   1476: astore 16
    //   1478: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1481: aload 16
    //   1483: invokevirtual 318	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:e	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1486: iconst_0
    //   1487: istore 9
    //   1489: iload_3
    //   1490: istore 8
    //   1492: iload_3
    //   1493: ifeq +33 -> 1526
    //   1496: aload_0
    //   1497: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAo	Ljava/lang/ref/WeakReference;
    //   1500: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1503: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   1506: astore 16
    //   1508: aload 16
    //   1510: ifnull +262 -> 1772
    //   1513: aload 16
    //   1515: invokestatic 322	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
    //   1518: invokeinterface 327 1 0
    //   1523: goto +249 -> 1772
    //   1526: iload 4
    //   1528: istore_3
    //   1529: iload 4
    //   1531: ifeq +37 -> 1568
    //   1534: aload_0
    //   1535: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAo	Ljava/lang/ref/WeakReference;
    //   1538: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1541: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   1544: astore 16
    //   1546: aload 16
    //   1548: ifnull +230 -> 1778
    //   1551: aload 16
    //   1553: invokestatic 322	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
    //   1556: iload 10
    //   1558: iload 11
    //   1560: invokeinterface 331 3 0
    //   1565: goto +213 -> 1778
    //   1568: aload_0
    //   1569: getfield 61	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAo	Ljava/lang/ref/WeakReference;
    //   1572: invokevirtual 127	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1575: checkcast 6	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView
    //   1578: astore 16
    //   1580: aload 16
    //   1582: ifnull +13 -> 1595
    //   1585: aload 16
    //   1587: invokestatic 322	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:h	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView;)Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$m;
    //   1590: invokeinterface 334 1 0
    //   1595: aload_0
    //   1596: getfield 81	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h;
    //   1599: astore 16
    //   1601: aload 16
    //   1603: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1606: aload 16
    //   1608: getfield 181	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAq	Ljavax/microedition/khronos/egl/EGLDisplay;
    //   1611: aload 16
    //   1613: getfield 231	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAr	Ljavax/microedition/khronos/egl/EGLSurface;
    //   1616: invokeinterface 338 3 0
    //   1621: ifne +231 -> 1852
    //   1624: aload 16
    //   1626: getfield 169	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:rAp	Ljavax/microedition/khronos/egl/EGL10;
    //   1629: invokeinterface 223 1 0
    //   1634: istore 12
    //   1636: goto +147 -> 1783
    //   1639: ldc_w 339
    //   1642: iload 12
    //   1644: invokestatic 287	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$h:formatEglError	(Ljava/lang/String;I)Ljava/lang/String;
    //   1647: pop
    //   1648: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1651: astore 16
    //   1653: aload 16
    //   1655: monitorenter
    //   1656: aload_0
    //   1657: iconst_1
    //   1658: putfield 144	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:rAy	Z
    //   1661: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   1664: invokevirtual 119	java/lang/Object:notifyAll	()V
    //   1667: aload 16
    //   1669: monitorexit
    //   1670: iload_1
    //   1671: istore 4
    //   1673: goto +146 -> 1819
    //   1676: astore 17
    //   1678: aload 16
    //   1680: monitorexit
    //   1681: ldc 75
    //   1683: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1686: aload 17
    //   1688: athrow
    //   1689: astore 17
    //   1691: aload 16
    //   1693: monitorexit
    //   1694: ldc 75
    //   1696: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1699: aload 17
    //   1701: athrow
    //   1702: iload_2
    //   1703: istore_1
    //   1704: goto +122 -> 1826
    //   1707: aconst_null
    //   1708: astore 17
    //   1710: goto -250 -> 1460
    //   1713: aload 17
    //   1715: astore 16
    //   1717: goto -246 -> 1471
    //   1720: iload_2
    //   1721: istore_1
    //   1722: iload 11
    //   1724: istore_2
    //   1725: goto -1188 -> 537
    //   1728: iload_1
    //   1729: istore 8
    //   1731: goto -1232 -> 499
    //   1734: iload_3
    //   1735: istore 8
    //   1737: goto -716 -> 1021
    //   1740: iload 12
    //   1742: istore 9
    //   1744: goto -1303 -> 441
    //   1747: iload 9
    //   1749: istore 4
    //   1751: goto -1485 -> 266
    //   1754: goto -1504 -> 250
    //   1757: iconst_0
    //   1758: istore 14
    //   1760: goto -1533 -> 227
    //   1763: goto -419 -> 1344
    //   1766: iconst_0
    //   1767: istore 6
    //   1769: goto -425 -> 1344
    //   1772: iconst_0
    //   1773: istore 8
    //   1775: goto -249 -> 1526
    //   1778: iconst_0
    //   1779: istore_3
    //   1780: goto -212 -> 1568
    //   1783: iload_1
    //   1784: istore 4
    //   1786: iload 12
    //   1788: lookupswitch	default:+28->1816, 12288:+31->1819, 12302:+72->1860
    //   1817: impdep2
    //   1818: iastore
    //   1819: iload 5
    //   1821: ifeq -119 -> 1702
    //   1824: iconst_1
    //   1825: istore_1
    //   1826: iload_1
    //   1827: istore_2
    //   1828: iload 4
    //   1830: istore_1
    //   1831: iload 8
    //   1833: istore 12
    //   1835: iload_3
    //   1836: istore 4
    //   1838: iload 9
    //   1840: istore 8
    //   1842: iload 12
    //   1844: istore_3
    //   1845: aload 18
    //   1847: astore 16
    //   1849: goto -1789 -> 60
    //   1852: sipush 12288
    //   1855: istore 12
    //   1857: goto -74 -> 1783
    //   1860: iconst_1
    //   1861: istore 4
    //   1863: goto -44 -> 1819
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1866	0	this	i
    //   57	1774	1	i	int
    //   55	1773	2	j	int
    //   59	1786	3	k	int
    //   37	1825	4	m	int
    //   40	1780	5	n	int
    //   31	1737	6	i1	int
    //   43	977	7	i2	int
    //   34	1807	8	i3	int
    //   69	1770	9	i4	int
    //   46	1511	10	i5	int
    //   49	1674	11	i6	int
    //   73	1783	12	i7	int
    //   157	16	13	i8	int
    //   211	1548	14	bool1	boolean
    //   312	277	15	bool2	boolean
    //   702	15	16	localRuntimeException	java.lang.RuntimeException
    //   719	11	16	localObject2	Object
    //   63	29	17	localj	GLTextureView.j
    //   119	603	17	localObject4	Object
    //   732	27	17	localObject5	Object
    //   1151	30	17	localGLTextureView	GLTextureView
    //   1331	11	17	localObject6	Object
    //   1357	108	17	localObject7	Object
    //   1676	11	17	localObject8	Object
    //   1689	11	17	localObject9	Object
    //   1708	6	17	localObject10	Object
    //   153	1693	18	localObject11	Object
    //   812	630	19	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   102	113	119	finally
    //   121	124	119	finally
    //   637	702	702	java/lang/RuntimeException
    //   809	853	702	java/lang/RuntimeException
    //   853	866	702	java/lang/RuntimeException
    //   871	883	702	java/lang/RuntimeException
    //   883	902	702	java/lang/RuntimeException
    //   902	923	702	java/lang/RuntimeException
    //   923	929	702	java/lang/RuntimeException
    //   953	1008	702	java/lang/RuntimeException
    //   84	94	719	finally
    //   132	155	719	finally
    //   175	178	719	finally
    //   196	227	719	finally
    //   227	247	719	finally
    //   255	263	719	finally
    //   271	282	719	finally
    //   287	306	719	finally
    //   319	328	719	finally
    //   328	332	719	finally
    //   337	353	719	finally
    //   353	378	719	finally
    //   378	394	719	finally
    //   394	419	719	finally
    //   427	438	719	finally
    //   441	448	719	finally
    //   451	458	719	finally
    //   472	491	719	finally
    //   499	524	719	finally
    //   527	532	719	finally
    //   537	548	719	finally
    //   583	590	719	finally
    //   593	615	719	finally
    //   615	626	719	finally
    //   637	702	719	finally
    //   704	719	719	finally
    //   721	724	719	finally
    //   761	774	719	finally
    //   780	803	719	finally
    //   809	853	719	finally
    //   853	866	719	finally
    //   871	883	719	finally
    //   883	902	719	finally
    //   902	923	719	finally
    //   923	929	719	finally
    //   929	934	719	finally
    //   937	943	719	finally
    //   953	1008	719	finally
    //   1021	1027	719	finally
    //   60	68	732	finally
    //   183	190	732	finally
    //   724	732	732	finally
    //   1046	1079	732	finally
    //   1079	1107	732	finally
    //   1107	1135	732	finally
    //   1135	1153	732	finally
    //   1158	1193	732	finally
    //   1193	1212	732	finally
    //   1212	1223	732	finally
    //   1231	1239	732	finally
    //   1260	1266	732	finally
    //   1269	1319	732	finally
    //   1336	1344	732	finally
    //   1353	1382	732	finally
    //   1391	1411	732	finally
    //   1415	1425	732	finally
    //   1428	1438	732	finally
    //   1441	1460	732	finally
    //   1460	1471	732	finally
    //   1471	1486	732	finally
    //   1496	1508	732	finally
    //   1513	1523	732	finally
    //   1534	1546	732	finally
    //   1551	1565	732	finally
    //   1568	1580	732	finally
    //   1585	1595	732	finally
    //   1595	1636	732	finally
    //   1639	1656	732	finally
    //   1681	1689	732	finally
    //   1239	1253	1331	finally
    //   1333	1336	1331	finally
    //   1656	1670	1676	finally
    //   1678	1681	1676	finally
    //   742	753	1689	finally
    //   1691	1694	1689	finally
  }
  
  private void stopEglContextLocked()
  {
    AppMethodBeat.i(145348);
    if (this.rAA)
    {
      this.rAI.finish();
      this.rAA = false;
      GLTextureView.crN().c(this);
    }
    AppMethodBeat.o(145348);
  }
  
  private void stopEglSurfaceLocked()
  {
    AppMethodBeat.i(145347);
    if (this.rAB)
    {
      this.rAB = false;
      this.rAI.destroySurfaceImp();
    }
    AppMethodBeat.o(145347);
  }
  
  public final int getRenderMode()
  {
    AppMethodBeat.i(145351);
    synchronized (GLTextureView.crN())
    {
      int i = this.rAD;
      AppMethodBeat.o(145351);
      return i;
    }
  }
  
  final boolean readyToDraw()
  {
    return (!this.kH) && (this.rAx) && (!this.rAy) && (this.width > 0) && (this.height > 0) && ((this.rAE) || (this.rAD == 1));
  }
  
  public final void requestExitAndWait()
  {
    AppMethodBeat.i(145353);
    synchronized (GLTextureView.crN())
    {
      this.rAu = true;
      GLTextureView.crN().notifyAll();
      for (;;)
      {
        boolean bool = this.rAv;
        if (!bool) {
          try
          {
            GLTextureView.crN().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(145353);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(145352);
    synchronized (GLTextureView.crN())
    {
      this.rAE = true;
      GLTextureView.crN().notifyAll();
      AppMethodBeat.o(145352);
      return;
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 357
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: new 359	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 361
    //   14: invokespecial 362	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 366	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:getId	()J
    //   21: invokevirtual 370	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 374	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokevirtual 377	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:setName	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 379	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i:guardedRun	()V
    //   34: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   37: aload_0
    //   38: invokevirtual 381	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
    //   41: ldc_w 357
    //   44: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   52: aload_0
    //   53: invokevirtual 381	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
    //   56: ldc_w 357
    //   59: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_1
    //   64: invokestatic 89	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView:crN	()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j;
    //   67: aload_0
    //   68: invokevirtual 381	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$j:b	(Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/GLTextureView$i;)V
    //   71: ldc_w 357
    //   74: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	i
    //   48	1	1	localInterruptedException	InterruptedException
    //   63	15	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	48	java/lang/InterruptedException
    //   30	34	63	finally
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(145350);
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(145350);
      throw ((Throwable)???);
    }
    synchronized (GLTextureView.crN())
    {
      this.rAD = paramInt;
      GLTextureView.crN().notifyAll();
      AppMethodBeat.o(145350);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i
 * JD-Core Version:    0.7.0.1
 */