package com.tencent.ttpic.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GLSurfaceView$GLThread
  extends Thread
{
  private GLSurfaceView.EglHelper mEglHelper;
  private ArrayList<Runnable> mEventQueue;
  private boolean mExited;
  private Runnable mFinishDrawingRunnable;
  private boolean mFinishedCreatingEglSurface;
  private WeakReference<GLSurfaceView> mGLSurfaceViewWeakRef;
  private boolean mHasSurface;
  private boolean mHaveEglContext;
  private boolean mHaveEglSurface;
  private int mHeight;
  private boolean mPaused;
  private boolean mRenderComplete;
  private int mRenderMode;
  private boolean mRequestPaused;
  private boolean mRequestRender;
  private boolean mShouldExit;
  private boolean mShouldReleaseEglContext;
  private boolean mSizeChanged;
  private boolean mSurfaceIsBad;
  private boolean mWaitingForSurface;
  private boolean mWantRenderNotification;
  private int mWidth;
  
  GLSurfaceView$GLThread(WeakReference<GLSurfaceView> paramWeakReference)
  {
    AppMethodBeat.i(84446);
    this.mEventQueue = new ArrayList();
    this.mSizeChanged = true;
    this.mFinishDrawingRunnable = null;
    this.mWidth = 0;
    this.mHeight = 0;
    this.mRequestRender = true;
    this.mRenderMode = 1;
    this.mWantRenderNotification = false;
    this.mGLSurfaceViewWeakRef = paramWeakReference;
    AppMethodBeat.o(84446);
  }
  
  /* Error */
  private void guardedRun()
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: new 86	com/tencent/ttpic/view/GLSurfaceView$EglHelper
    //   9: dup
    //   10: aload_0
    //   11: getfield 70	com/tencent/ttpic/view/GLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   14: invokespecial 88	com/tencent/ttpic/view/GLSurfaceView$EglHelper:<init>	(Ljava/lang/ref/WeakReference;)V
    //   17: putfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   20: aload_0
    //   21: iconst_0
    //   22: putfield 92	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglContext	Z
    //   25: aload_0
    //   26: iconst_0
    //   27: putfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 68	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWantRenderNotification	Z
    //   35: iconst_0
    //   36: istore_3
    //   37: iconst_0
    //   38: istore 4
    //   40: iconst_0
    //   41: istore 6
    //   43: iconst_0
    //   44: istore_2
    //   45: iconst_0
    //   46: istore 5
    //   48: iconst_0
    //   49: istore 9
    //   51: iconst_0
    //   52: istore_1
    //   53: iconst_0
    //   54: istore 8
    //   56: iconst_0
    //   57: istore 10
    //   59: iconst_0
    //   60: istore 11
    //   62: aconst_null
    //   63: astore 21
    //   65: aconst_null
    //   66: astore 20
    //   68: aconst_null
    //   69: astore 23
    //   71: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   74: astore 24
    //   76: aload 24
    //   78: monitorenter
    //   79: iload 8
    //   81: istore 7
    //   83: aload_0
    //   84: getfield 54	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   87: invokevirtual 102	java/util/ArrayList:isEmpty	()Z
    //   90: ifne +63 -> 153
    //   93: aload_0
    //   94: getfield 54	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEventQueue	Ljava/util/ArrayList;
    //   97: iconst_0
    //   98: invokevirtual 106	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   101: checkcast 108	java/lang/Runnable
    //   104: astore 22
    //   106: iload 7
    //   108: istore 8
    //   110: iload 10
    //   112: istore 13
    //   114: iload 4
    //   116: istore 7
    //   118: iload_1
    //   119: istore 4
    //   121: aload 24
    //   123: monitorexit
    //   124: aload 22
    //   126: ifnull +702 -> 828
    //   129: aload 22
    //   131: invokeinterface 111 1 0
    //   136: aconst_null
    //   137: astore 21
    //   139: iload 4
    //   141: istore_1
    //   142: iload 7
    //   144: istore 4
    //   146: iload 13
    //   148: istore 10
    //   150: goto -79 -> 71
    //   153: aload_0
    //   154: getfield 113	com/tencent/ttpic/view/GLSurfaceView$GLThread:mShouldExit	Z
    //   157: ifeq +44 -> 201
    //   160: aload 24
    //   162: monitorexit
    //   163: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   166: astore 20
    //   168: aload 20
    //   170: monitorenter
    //   171: aload_0
    //   172: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   175: aload_0
    //   176: invokespecial 119	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglContextLocked	()V
    //   179: aload 20
    //   181: monitorexit
    //   182: ldc 84
    //   184: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: return
    //   188: astore 21
    //   190: aload 20
    //   192: monitorexit
    //   193: ldc 84
    //   195: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 21
    //   200: athrow
    //   201: iconst_0
    //   202: istore 19
    //   204: aload_0
    //   205: getfield 121	com/tencent/ttpic/view/GLSurfaceView$GLThread:mPaused	Z
    //   208: aload_0
    //   209: getfield 123	com/tencent/ttpic/view/GLSurfaceView$GLThread:mRequestPaused	Z
    //   212: if_icmpeq +23 -> 235
    //   215: aload_0
    //   216: getfield 123	com/tencent/ttpic/view/GLSurfaceView$GLThread:mRequestPaused	Z
    //   219: istore 19
    //   221: aload_0
    //   222: aload_0
    //   223: getfield 123	com/tencent/ttpic/view/GLSurfaceView$GLThread:mRequestPaused	Z
    //   226: putfield 121	com/tencent/ttpic/view/GLSurfaceView$GLThread:mPaused	Z
    //   229: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   232: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   235: aload_0
    //   236: getfield 130	com/tencent/ttpic/view/GLSurfaceView$GLThread:mShouldReleaseEglContext	Z
    //   239: ifeq +19 -> 258
    //   242: aload_0
    //   243: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   246: aload_0
    //   247: invokespecial 119	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglContextLocked	()V
    //   250: aload_0
    //   251: iconst_0
    //   252: putfield 130	com/tencent/ttpic/view/GLSurfaceView$GLThread:mShouldReleaseEglContext	Z
    //   255: iconst_1
    //   256: istore 7
    //   258: iload_2
    //   259: istore 12
    //   261: iload_2
    //   262: ifeq +14 -> 276
    //   265: aload_0
    //   266: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   269: aload_0
    //   270: invokespecial 119	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglContextLocked	()V
    //   273: iconst_0
    //   274: istore 12
    //   276: iload 19
    //   278: ifeq +14 -> 292
    //   281: aload_0
    //   282: getfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   285: ifeq +7 -> 292
    //   288: aload_0
    //   289: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   292: iload 19
    //   294: ifeq +39 -> 333
    //   297: aload_0
    //   298: getfield 92	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglContext	Z
    //   301: ifeq +32 -> 333
    //   304: aload_0
    //   305: getfield 70	com/tencent/ttpic/view/GLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   308: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   311: checkcast 6	com/tencent/ttpic/view/GLSurfaceView
    //   314: astore 22
    //   316: aload 22
    //   318: ifnonnull +320 -> 638
    //   321: iconst_0
    //   322: istore 19
    //   324: iload 19
    //   326: ifne +7 -> 333
    //   329: aload_0
    //   330: invokespecial 119	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglContextLocked	()V
    //   333: aload_0
    //   334: getfield 138	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHasSurface	Z
    //   337: ifne +37 -> 374
    //   340: aload_0
    //   341: getfield 140	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWaitingForSurface	Z
    //   344: ifne +30 -> 374
    //   347: aload_0
    //   348: getfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   351: ifeq +7 -> 358
    //   354: aload_0
    //   355: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   358: aload_0
    //   359: iconst_1
    //   360: putfield 140	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWaitingForSurface	Z
    //   363: aload_0
    //   364: iconst_0
    //   365: putfield 142	com/tencent/ttpic/view/GLSurfaceView$GLThread:mSurfaceIsBad	Z
    //   368: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   371: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   374: aload_0
    //   375: getfield 138	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHasSurface	Z
    //   378: ifeq +21 -> 399
    //   381: aload_0
    //   382: getfield 140	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWaitingForSurface	Z
    //   385: ifeq +14 -> 399
    //   388: aload_0
    //   389: iconst_0
    //   390: putfield 140	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWaitingForSurface	Z
    //   393: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   396: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   399: iload_1
    //   400: istore 13
    //   402: iload_1
    //   403: ifeq +22 -> 425
    //   406: aload_0
    //   407: iconst_0
    //   408: putfield 68	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWantRenderNotification	Z
    //   411: iconst_0
    //   412: istore 13
    //   414: aload_0
    //   415: iconst_1
    //   416: putfield 144	com/tencent/ttpic/view/GLSurfaceView$GLThread:mRenderComplete	Z
    //   419: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   422: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   425: aload_0
    //   426: getfield 58	com/tencent/ttpic/view/GLSurfaceView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   429: ifnull +855 -> 1284
    //   432: aload_0
    //   433: getfield 58	com/tencent/ttpic/view/GLSurfaceView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   436: astore 20
    //   438: aload_0
    //   439: aconst_null
    //   440: putfield 58	com/tencent/ttpic/view/GLSurfaceView$GLThread:mFinishDrawingRunnable	Ljava/lang/Runnable;
    //   443: aload_0
    //   444: invokespecial 147	com/tencent/ttpic/view/GLSurfaceView$GLThread:readyToDraw	()Z
    //   447: ifeq +286 -> 733
    //   450: iload 7
    //   452: istore_2
    //   453: iload_3
    //   454: istore_1
    //   455: aload_0
    //   456: getfield 92	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglContext	Z
    //   459: ifne +12 -> 471
    //   462: iload 7
    //   464: ifeq +184 -> 648
    //   467: iconst_0
    //   468: istore_2
    //   469: iload_3
    //   470: istore_1
    //   471: iload 4
    //   473: istore 8
    //   475: iload 5
    //   477: istore 7
    //   479: iload 6
    //   481: istore_3
    //   482: aload_0
    //   483: getfield 92	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglContext	Z
    //   486: ifeq +34 -> 520
    //   489: iload 4
    //   491: istore 8
    //   493: iload 5
    //   495: istore 7
    //   497: iload 6
    //   499: istore_3
    //   500: aload_0
    //   501: getfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   504: ifne +16 -> 520
    //   507: aload_0
    //   508: iconst_1
    //   509: putfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   512: iconst_1
    //   513: istore 8
    //   515: iconst_1
    //   516: istore_3
    //   517: iconst_1
    //   518: istore 7
    //   520: aload 20
    //   522: astore 22
    //   524: iload 8
    //   526: istore 18
    //   528: iload_2
    //   529: istore 14
    //   531: iload 7
    //   533: istore 17
    //   535: iload_3
    //   536: istore 15
    //   538: iload_1
    //   539: istore 16
    //   541: aload_0
    //   542: getfield 94	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglSurface	Z
    //   545: ifeq +245 -> 790
    //   548: iload 7
    //   550: istore 5
    //   552: aload_0
    //   553: getfield 56	com/tencent/ttpic/view/GLSurfaceView$GLThread:mSizeChanged	Z
    //   556: ifeq +31 -> 587
    //   559: iconst_1
    //   560: istore 5
    //   562: aload_0
    //   563: getfield 60	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWidth	I
    //   566: istore 10
    //   568: aload_0
    //   569: getfield 62	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHeight	I
    //   572: istore 11
    //   574: aload_0
    //   575: iconst_1
    //   576: putfield 68	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWantRenderNotification	Z
    //   579: iconst_1
    //   580: istore 8
    //   582: aload_0
    //   583: iconst_0
    //   584: putfield 56	com/tencent/ttpic/view/GLSurfaceView$GLThread:mSizeChanged	Z
    //   587: aload_0
    //   588: iconst_0
    //   589: putfield 64	com/tencent/ttpic/view/GLSurfaceView$GLThread:mRequestRender	Z
    //   592: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   595: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   598: aload_0
    //   599: getfield 68	com/tencent/ttpic/view/GLSurfaceView$GLThread:mWantRenderNotification	Z
    //   602: ifeq +652 -> 1254
    //   605: iconst_1
    //   606: istore 9
    //   608: iload 13
    //   610: istore 4
    //   612: iload 8
    //   614: istore 7
    //   616: aload 21
    //   618: astore 22
    //   620: iload 10
    //   622: istore 13
    //   624: iload_2
    //   625: istore 8
    //   627: iload 12
    //   629: istore_2
    //   630: iload_3
    //   631: istore 6
    //   633: iload_1
    //   634: istore_3
    //   635: goto -514 -> 121
    //   638: aload 22
    //   640: invokestatic 151	com/tencent/ttpic/view/GLSurfaceView:access$900	(Lcom/tencent/ttpic/view/GLSurfaceView;)Z
    //   643: istore 19
    //   645: goto -321 -> 324
    //   648: aload_0
    //   649: getfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   652: invokevirtual 154	com/tencent/ttpic/view/GLSurfaceView$EglHelper:start	()V
    //   655: aload_0
    //   656: iconst_1
    //   657: putfield 92	com/tencent/ttpic/view/GLSurfaceView$GLThread:mHaveEglContext	Z
    //   660: iconst_1
    //   661: istore_1
    //   662: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   665: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   668: iload 7
    //   670: istore_2
    //   671: goto -200 -> 471
    //   674: astore 20
    //   676: aload 24
    //   678: monitorexit
    //   679: ldc 84
    //   681: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   684: aload 20
    //   686: athrow
    //   687: astore 21
    //   689: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   692: astore 20
    //   694: aload 20
    //   696: monitorenter
    //   697: aload_0
    //   698: invokespecial 116	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglSurfaceLocked	()V
    //   701: aload_0
    //   702: invokespecial 119	com/tencent/ttpic/view/GLSurfaceView$GLThread:stopEglContextLocked	()V
    //   705: aload 20
    //   707: monitorexit
    //   708: ldc 84
    //   710: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   713: aload 21
    //   715: athrow
    //   716: astore 20
    //   718: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   721: aload_0
    //   722: invokevirtual 160	com/tencent/ttpic/view/GLSurfaceView$GLThreadManager:releaseEglContextLocked	(Lcom/tencent/ttpic/view/GLSurfaceView$GLThread;)V
    //   725: ldc 84
    //   727: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   730: aload 20
    //   732: athrow
    //   733: aload 20
    //   735: astore 22
    //   737: iload 4
    //   739: istore 18
    //   741: iload 7
    //   743: istore 14
    //   745: iload 5
    //   747: istore 17
    //   749: iload 6
    //   751: istore 15
    //   753: iload_3
    //   754: istore 16
    //   756: aload 20
    //   758: ifnull +32 -> 790
    //   761: aload 20
    //   763: invokeinterface 111 1 0
    //   768: aconst_null
    //   769: astore 22
    //   771: iload_3
    //   772: istore 16
    //   774: iload 6
    //   776: istore 15
    //   778: iload 5
    //   780: istore 17
    //   782: iload 7
    //   784: istore 14
    //   786: iload 4
    //   788: istore 18
    //   790: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   793: invokevirtual 163	java/lang/Object:wait	()V
    //   796: aload 22
    //   798: astore 20
    //   800: iload 13
    //   802: istore_1
    //   803: iload 18
    //   805: istore 4
    //   807: iload 14
    //   809: istore 7
    //   811: iload 17
    //   813: istore 5
    //   815: iload 12
    //   817: istore_2
    //   818: iload 15
    //   820: istore 6
    //   822: iload 16
    //   824: istore_3
    //   825: goto -742 -> 83
    //   828: iload 7
    //   830: istore 10
    //   832: iload 7
    //   834: ifeq +38 -> 872
    //   837: aload_0
    //   838: getfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   841: invokevirtual 166	com/tencent/ttpic/view/GLSurfaceView$EglHelper:createSurface	()Z
    //   844: ifeq +320 -> 1164
    //   847: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   850: astore 21
    //   852: aload 21
    //   854: monitorenter
    //   855: aload_0
    //   856: iconst_1
    //   857: putfield 168	com/tencent/ttpic/view/GLSurfaceView$GLThread:mFinishedCreatingEglSurface	Z
    //   860: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   863: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   866: aload 21
    //   868: monitorexit
    //   869: iconst_0
    //   870: istore 10
    //   872: iload 6
    //   874: istore 7
    //   876: iload 6
    //   878: ifeq +18 -> 896
    //   881: aload_0
    //   882: getfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   885: invokevirtual 172	com/tencent/ttpic/view/GLSurfaceView$EglHelper:createGL	()Ljavax/microedition/khronos/opengles/GL;
    //   888: checkcast 174	javax/microedition/khronos/opengles/GL10
    //   891: astore 23
    //   893: iconst_0
    //   894: istore 7
    //   896: iload_3
    //   897: istore 12
    //   899: iload_3
    //   900: ifeq +42 -> 942
    //   903: aload_0
    //   904: getfield 70	com/tencent/ttpic/view/GLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   907: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   910: checkcast 6	com/tencent/ttpic/view/GLSurfaceView
    //   913: astore 21
    //   915: aload 21
    //   917: ifnull +376 -> 1293
    //   920: aload 21
    //   922: invokestatic 178	com/tencent/ttpic/view/GLSurfaceView:access$1000	(Lcom/tencent/ttpic/view/GLSurfaceView;)Lcom/tencent/ttpic/view/GLSurfaceView$Renderer;
    //   925: aload 23
    //   927: aload_0
    //   928: getfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   931: getfield 182	com/tencent/ttpic/view/GLSurfaceView$EglHelper:mEglConfig	Ljavax/microedition/khronos/egl/EGLConfig;
    //   934: invokeinterface 188 3 0
    //   939: goto +354 -> 1293
    //   942: iload 5
    //   944: istore_3
    //   945: iload 5
    //   947: ifeq +39 -> 986
    //   950: aload_0
    //   951: getfield 70	com/tencent/ttpic/view/GLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   954: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   957: checkcast 6	com/tencent/ttpic/view/GLSurfaceView
    //   960: astore 21
    //   962: aload 21
    //   964: ifnull +335 -> 1299
    //   967: aload 21
    //   969: invokestatic 178	com/tencent/ttpic/view/GLSurfaceView:access$1000	(Lcom/tencent/ttpic/view/GLSurfaceView;)Lcom/tencent/ttpic/view/GLSurfaceView$Renderer;
    //   972: aload 23
    //   974: iload 13
    //   976: iload 11
    //   978: invokeinterface 192 4 0
    //   983: goto +316 -> 1299
    //   986: aload_0
    //   987: getfield 70	com/tencent/ttpic/view/GLSurfaceView$GLThread:mGLSurfaceViewWeakRef	Ljava/lang/ref/WeakReference;
    //   990: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   993: checkcast 6	com/tencent/ttpic/view/GLSurfaceView
    //   996: astore 24
    //   998: aload 20
    //   1000: astore 21
    //   1002: aload 24
    //   1004: ifnull +34 -> 1038
    //   1007: aload 24
    //   1009: invokestatic 178	com/tencent/ttpic/view/GLSurfaceView:access$1000	(Lcom/tencent/ttpic/view/GLSurfaceView;)Lcom/tencent/ttpic/view/GLSurfaceView$Renderer;
    //   1012: aload 23
    //   1014: invokeinterface 196 2 0
    //   1019: aload 20
    //   1021: astore 21
    //   1023: aload 20
    //   1025: ifnull +13 -> 1038
    //   1028: aload 20
    //   1030: invokeinterface 111 1 0
    //   1035: aconst_null
    //   1036: astore 21
    //   1038: aload_0
    //   1039: getfield 90	com/tencent/ttpic/view/GLSurfaceView$GLThread:mEglHelper	Lcom/tencent/ttpic/view/GLSurfaceView$EglHelper;
    //   1042: invokevirtual 200	com/tencent/ttpic/view/GLSurfaceView$EglHelper:swap	()I
    //   1045: istore_1
    //   1046: iload_2
    //   1047: istore 6
    //   1049: iload_1
    //   1050: lookupswitch	default:+254->1304, 12288:+59->1109, 12302:+172->1222
    //   1077: jsr_w 18 203 27 184
    //   1082: nop
    //   1083: <illegal opcode>
    //   1084: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   1087: astore 20
    //   1089: aload 20
    //   1091: monitorenter
    //   1092: aload_0
    //   1093: iconst_1
    //   1094: putfield 142	com/tencent/ttpic/view/GLSurfaceView$GLThread:mSurfaceIsBad	Z
    //   1097: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   1100: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   1103: aload 20
    //   1105: monitorexit
    //   1106: iload_2
    //   1107: istore 6
    //   1109: iload 9
    //   1111: ifeq +176 -> 1287
    //   1114: iconst_1
    //   1115: istore_1
    //   1116: iconst_0
    //   1117: istore 9
    //   1119: iload 10
    //   1121: istore 4
    //   1123: aload 21
    //   1125: astore 20
    //   1127: aload 22
    //   1129: astore 21
    //   1131: iload 13
    //   1133: istore 10
    //   1135: iload_3
    //   1136: istore 5
    //   1138: iload 6
    //   1140: istore_2
    //   1141: iload 7
    //   1143: istore 6
    //   1145: iload 12
    //   1147: istore_3
    //   1148: goto -1077 -> 71
    //   1151: astore 20
    //   1153: aload 21
    //   1155: monitorexit
    //   1156: ldc 84
    //   1158: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1161: aload 20
    //   1163: athrow
    //   1164: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   1167: astore 21
    //   1169: aload 21
    //   1171: monitorenter
    //   1172: aload_0
    //   1173: iconst_1
    //   1174: putfield 168	com/tencent/ttpic/view/GLSurfaceView$GLThread:mFinishedCreatingEglSurface	Z
    //   1177: aload_0
    //   1178: iconst_1
    //   1179: putfield 142	com/tencent/ttpic/view/GLSurfaceView$GLThread:mSurfaceIsBad	Z
    //   1182: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   1185: invokevirtual 128	java/lang/Object:notifyAll	()V
    //   1188: aload 21
    //   1190: monitorexit
    //   1191: iload 4
    //   1193: istore_1
    //   1194: iload 7
    //   1196: istore 4
    //   1198: aload 22
    //   1200: astore 21
    //   1202: iload 13
    //   1204: istore 10
    //   1206: goto -1135 -> 71
    //   1209: astore 20
    //   1211: aload 21
    //   1213: monitorexit
    //   1214: ldc 84
    //   1216: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1219: aload 20
    //   1221: athrow
    //   1222: iconst_1
    //   1223: istore 6
    //   1225: goto -116 -> 1109
    //   1228: astore 21
    //   1230: aload 20
    //   1232: monitorexit
    //   1233: ldc 84
    //   1235: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1238: aload 21
    //   1240: athrow
    //   1241: astore 21
    //   1243: aload 20
    //   1245: monitorexit
    //   1246: ldc 84
    //   1248: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1251: aload 21
    //   1253: athrow
    //   1254: iload 13
    //   1256: istore 4
    //   1258: iload 8
    //   1260: istore 7
    //   1262: aload 21
    //   1264: astore 22
    //   1266: iload 10
    //   1268: istore 13
    //   1270: iload_2
    //   1271: istore 8
    //   1273: iload 12
    //   1275: istore_2
    //   1276: iload_3
    //   1277: istore 6
    //   1279: iload_1
    //   1280: istore_3
    //   1281: goto -1160 -> 121
    //   1284: goto -841 -> 443
    //   1287: iload 4
    //   1289: istore_1
    //   1290: goto -171 -> 1119
    //   1293: iconst_0
    //   1294: istore 12
    //   1296: goto -354 -> 942
    //   1299: iconst_0
    //   1300: istore_3
    //   1301: goto -315 -> 986
    //   1304: goto -228 -> 1076
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1307	0	this	GLThread
    //   52	1238	1	i	int
    //   44	1232	2	j	int
    //   36	1265	3	k	int
    //   38	1250	4	m	int
    //   46	1091	5	n	int
    //   41	1237	6	i1	int
    //   81	1180	7	i2	int
    //   54	1218	8	i3	int
    //   49	1069	9	i4	int
    //   57	1210	10	i5	int
    //   60	917	11	i6	int
    //   259	1036	12	i7	int
    //   112	1157	13	i8	int
    //   529	279	14	i9	int
    //   536	283	15	i10	int
    //   539	284	16	i11	int
    //   533	279	17	i12	int
    //   526	278	18	i13	int
    //   202	442	19	bool	boolean
    //   66	455	20	localObject1	Object
    //   674	11	20	localObject2	Object
    //   716	46	20	localRuntimeException	java.lang.RuntimeException
    //   1151	11	20	localObject4	Object
    //   1209	35	20	localObject5	Object
    //   63	75	21	localObject6	Object
    //   188	429	21	localObject7	Object
    //   687	27	21	localObject8	Object
    //   1228	11	21	localObject10	Object
    //   1241	22	21	localObject11	Object
    //   104	1161	22	localObject12	Object
    //   69	944	23	localGL10	javax.microedition.khronos.opengles.GL10
    //   74	934	24	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   171	182	188	finally
    //   190	193	188	finally
    //   83	106	674	finally
    //   121	124	674	finally
    //   153	163	674	finally
    //   204	235	674	finally
    //   235	255	674	finally
    //   265	273	674	finally
    //   281	292	674	finally
    //   297	316	674	finally
    //   329	333	674	finally
    //   333	358	674	finally
    //   358	374	674	finally
    //   374	399	674	finally
    //   406	411	674	finally
    //   414	425	674	finally
    //   425	443	674	finally
    //   443	450	674	finally
    //   455	462	674	finally
    //   482	489	674	finally
    //   500	512	674	finally
    //   541	548	674	finally
    //   552	559	674	finally
    //   562	579	674	finally
    //   582	587	674	finally
    //   587	605	674	finally
    //   638	645	674	finally
    //   648	655	674	finally
    //   655	660	674	finally
    //   662	668	674	finally
    //   676	679	674	finally
    //   718	733	674	finally
    //   761	768	674	finally
    //   790	796	674	finally
    //   71	79	687	finally
    //   129	136	687	finally
    //   679	687	687	finally
    //   837	855	687	finally
    //   881	893	687	finally
    //   903	915	687	finally
    //   920	939	687	finally
    //   950	962	687	finally
    //   967	983	687	finally
    //   986	998	687	finally
    //   1007	1019	687	finally
    //   1028	1035	687	finally
    //   1038	1046	687	finally
    //   1076	1092	687	finally
    //   1156	1164	687	finally
    //   1164	1172	687	finally
    //   1214	1222	687	finally
    //   1233	1241	687	finally
    //   648	655	716	java/lang/RuntimeException
    //   855	869	1151	finally
    //   1153	1156	1151	finally
    //   1172	1191	1209	finally
    //   1211	1214	1209	finally
    //   1092	1106	1228	finally
    //   1230	1233	1228	finally
    //   697	708	1241	finally
    //   1243	1246	1241	finally
  }
  
  private boolean readyToDraw()
  {
    return (!this.mPaused) && (this.mHasSurface) && (!this.mSurfaceIsBad) && (this.mWidth > 0) && (this.mHeight > 0) && ((this.mRequestRender) || (this.mRenderMode == 1));
  }
  
  private void stopEglContextLocked()
  {
    AppMethodBeat.i(84449);
    if (this.mHaveEglContext)
    {
      this.mEglHelper.finish();
      this.mHaveEglContext = false;
      GLSurfaceView.access$800().releaseEglContextLocked(this);
    }
    AppMethodBeat.o(84449);
  }
  
  private void stopEglSurfaceLocked()
  {
    AppMethodBeat.i(84448);
    if (this.mHaveEglSurface)
    {
      this.mHaveEglSurface = false;
      this.mEglHelper.destroySurface();
    }
    AppMethodBeat.o(84448);
  }
  
  public boolean ableToDraw()
  {
    AppMethodBeat.i(84451);
    if ((this.mHaveEglContext) && (this.mHaveEglSurface) && (readyToDraw()))
    {
      AppMethodBeat.o(84451);
      return true;
    }
    AppMethodBeat.o(84451);
    return false;
  }
  
  public int getRenderMode()
  {
    AppMethodBeat.i(84453);
    synchronized (GLSurfaceView.access$800())
    {
      int i = this.mRenderMode;
      AppMethodBeat.o(84453);
      return i;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(84458);
    synchronized (GLSurfaceView.access$800())
    {
      this.mRequestPaused = true;
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        if (!this.mExited)
        {
          boolean bool = this.mPaused;
          if (!bool) {
            try
            {
              GLSurfaceView.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(84458);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(84459);
    synchronized (GLSurfaceView.access$800())
    {
      this.mRequestPaused = false;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        if ((!this.mExited) && (this.mPaused))
        {
          boolean bool = this.mRenderComplete;
          if (!bool) {
            try
            {
              GLSurfaceView.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(84459);
  }
  
  public void onWindowResize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84460);
    synchronized (GLSurfaceView.access$800())
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSizeChanged = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      if (Thread.currentThread() == this)
      {
        AppMethodBeat.o(84460);
        return;
      }
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        if ((!this.mExited) && (!this.mPaused) && (!this.mRenderComplete))
        {
          boolean bool = ableToDraw();
          if (bool) {
            try
            {
              GLSurfaceView.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(84460);
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    AppMethodBeat.i(84463);
    if (paramRunnable == null)
    {
      paramRunnable = new IllegalArgumentException("r must not be null");
      AppMethodBeat.o(84463);
      throw paramRunnable;
    }
    synchronized (GLSurfaceView.access$800())
    {
      this.mEventQueue.add(paramRunnable);
      GLSurfaceView.access$800().notifyAll();
      AppMethodBeat.o(84463);
      return;
    }
  }
  
  public void requestExitAndWait()
  {
    AppMethodBeat.i(84461);
    synchronized (GLSurfaceView.access$800())
    {
      this.mShouldExit = true;
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        boolean bool = this.mExited;
        if (!bool) {
          try
          {
            GLSurfaceView.access$800().wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
    AppMethodBeat.o(84461);
  }
  
  public void requestReleaseEglContextLocked()
  {
    AppMethodBeat.i(84462);
    this.mShouldReleaseEglContext = true;
    GLSurfaceView.access$800().notifyAll();
    AppMethodBeat.o(84462);
  }
  
  public void requestRender()
  {
    AppMethodBeat.i(84454);
    synchronized (GLSurfaceView.access$800())
    {
      this.mRequestRender = true;
      GLSurfaceView.access$800().notifyAll();
      AppMethodBeat.o(84454);
      return;
    }
  }
  
  public void requestRenderAndNotify(Runnable paramRunnable)
  {
    AppMethodBeat.i(84455);
    synchronized (GLSurfaceView.access$800())
    {
      if (Thread.currentThread() == this)
      {
        AppMethodBeat.o(84455);
        return;
      }
      this.mWantRenderNotification = true;
      this.mRequestRender = true;
      this.mRenderComplete = false;
      this.mFinishDrawingRunnable = paramRunnable;
      GLSurfaceView.access$800().notifyAll();
      AppMethodBeat.o(84455);
      return;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc_w 260
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: new 262	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 264
    //   14: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 269	com/tencent/ttpic/view/GLSurfaceView$GLThread:getId	()J
    //   21: invokevirtual 273	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokevirtual 280	com/tencent/ttpic/view/GLSurfaceView$GLThread:setName	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 282	com/tencent/ttpic/view/GLSurfaceView$GLThread:guardedRun	()V
    //   34: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   37: aload_0
    //   38: invokevirtual 285	com/tencent/ttpic/view/GLSurfaceView$GLThreadManager:threadExiting	(Lcom/tencent/ttpic/view/GLSurfaceView$GLThread;)V
    //   41: ldc_w 260
    //   44: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: astore_1
    //   49: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   52: aload_0
    //   53: invokevirtual 285	com/tencent/ttpic/view/GLSurfaceView$GLThreadManager:threadExiting	(Lcom/tencent/ttpic/view/GLSurfaceView$GLThread;)V
    //   56: ldc_w 260
    //   59: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_1
    //   64: invokestatic 98	com/tencent/ttpic/view/GLSurfaceView:access$800	()Lcom/tencent/ttpic/view/GLSurfaceView$GLThreadManager;
    //   67: aload_0
    //   68: invokevirtual 285	com/tencent/ttpic/view/GLSurfaceView$GLThreadManager:threadExiting	(Lcom/tencent/ttpic/view/GLSurfaceView$GLThread;)V
    //   71: ldc_w 260
    //   74: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	GLThread
    //   48	1	1	localInterruptedException	InterruptedException
    //   63	15	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	34	48	java/lang/InterruptedException
    //   30	34	63	finally
  }
  
  public void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(84452);
    if ((paramInt < 0) || (paramInt > 1))
    {
      ??? = new IllegalArgumentException("renderMode");
      AppMethodBeat.o(84452);
      throw ((Throwable)???);
    }
    synchronized (GLSurfaceView.access$800())
    {
      this.mRenderMode = paramInt;
      GLSurfaceView.access$800().notifyAll();
      AppMethodBeat.o(84452);
      return;
    }
  }
  
  public void surfaceCreated()
  {
    AppMethodBeat.i(84456);
    synchronized (GLSurfaceView.access$800())
    {
      this.mHasSurface = true;
      this.mFinishedCreatingEglSurface = false;
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        if ((this.mWaitingForSurface) && (!this.mFinishedCreatingEglSurface))
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              GLSurfaceView.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(84456);
  }
  
  public void surfaceDestroyed()
  {
    AppMethodBeat.i(84457);
    synchronized (GLSurfaceView.access$800())
    {
      this.mHasSurface = false;
      GLSurfaceView.access$800().notifyAll();
      for (;;)
      {
        if (!this.mWaitingForSurface)
        {
          boolean bool = this.mExited;
          if (!bool) {
            try
            {
              GLSurfaceView.access$800().wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              Thread.currentThread().interrupt();
            }
          }
        }
      }
    }
    AppMethodBeat.o(84457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.view.GLSurfaceView.GLThread
 * JD-Core Version:    0.7.0.1
 */