package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.u;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.f;
import com.tencent.xweb.xwalk.a.g;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkEnvironment;

public final class e
{
  private static ClassLoader mClassLoader;
  
  /* Error */
  public static b a(Context paramContext, com.tencent.xweb.WebView paramWebView, View paramView, String paramString)
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 27	org/xwalk/core/XWalkEnvironment:activityFromContext	(Landroid/content/Context;)Landroid/app/Activity;
    //   9: astore 7
    //   11: ldc 29
    //   13: ldc 31
    //   15: aload 7
    //   17: invokestatic 37	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 41	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: invokestatic 52	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   29: ifnull +127 -> 156
    //   32: ldc 29
    //   34: ldc 54
    //   36: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: invokestatic 52	org/xwalk/core/XWalkCoreWrapper:getInstance	()Lorg/xwalk/core/XWalkCoreWrapper;
    //   42: ldc 56
    //   44: invokevirtual 60	org/xwalk/core/XWalkCoreWrapper:getClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   47: astore 5
    //   49: aconst_null
    //   50: astore 4
    //   52: aload 5
    //   54: ifnull +764 -> 818
    //   57: ldc 29
    //   59: ldc 62
    //   61: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 6	com/tencent/xweb/extension/video/e$a
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 68	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   73: invokespecial 72	com/tencent/xweb/extension/video/e$a:<init>	(Ljava/lang/Object;)V
    //   76: astore 5
    //   78: aload_0
    //   79: instanceof 74
    //   82: ifne +756 -> 838
    //   85: new 74	org/xwalk/core/resource/XWalkContextWrapper
    //   88: dup
    //   89: aload_1
    //   90: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   93: invokestatic 84	org/xwalk/core/XWalkEnvironment:getAvailableVersion	()I
    //   96: invokespecial 87	org/xwalk/core/resource/XWalkContextWrapper:<init>	(Landroid/content/Context;I)V
    //   99: astore_0
    //   100: aload 4
    //   102: ifnull +12 -> 114
    //   105: aload_0
    //   106: checkcast 74	org/xwalk/core/resource/XWalkContextWrapper
    //   109: aload 4
    //   111: invokevirtual 91	org/xwalk/core/resource/XWalkContextWrapper:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   114: aload 5
    //   116: getfield 95	com/tencent/xweb/extension/video/e$a:KBR	Lorg/xwalk/core/ReflectMethod;
    //   119: iconst_5
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload 7
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: aload_1
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: aload_2
    //   135: aastore
    //   136: dup
    //   137: iconst_3
    //   138: aload_0
    //   139: aastore
    //   140: dup
    //   141: iconst_4
    //   142: aload_3
    //   143: aastore
    //   144: invokevirtual 101	org/xwalk/core/ReflectMethod:invoke	([Ljava/lang/Object;)Ljava/lang/Object;
    //   147: pop
    //   148: ldc 15
    //   150: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 5
    //   155: areturn
    //   156: ldc 29
    //   158: ldc 106
    //   160: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: ldc 108
    //   165: iconst_0
    //   166: invokestatic 112	org/xwalk/core/XWalkEnvironment:getXWebInitArgs	(Ljava/lang/String;Z)Z
    //   169: invokestatic 117	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   172: astore 4
    //   174: aload 4
    //   176: ifnull +83 -> 259
    //   179: aload 4
    //   181: instanceof 114
    //   184: ifeq +75 -> 259
    //   187: aload 4
    //   189: checkcast 114	java/lang/Boolean
    //   192: invokevirtual 121	java/lang/Boolean:booleanValue	()Z
    //   195: ifne +48 -> 243
    //   198: invokestatic 125	com/tencent/xweb/extension/video/e:fKc	()Ljava/lang/ClassLoader;
    //   201: astore 5
    //   203: aload 5
    //   205: ifnull +636 -> 841
    //   208: aload 5
    //   210: ldc 56
    //   212: invokevirtual 130	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   215: astore 4
    //   217: aload 4
    //   219: astore 6
    //   221: aload 5
    //   223: astore 4
    //   225: aload 6
    //   227: astore 5
    //   229: goto -177 -> 52
    //   232: astore 4
    //   234: aconst_null
    //   235: astore 4
    //   237: aconst_null
    //   238: astore 5
    //   240: goto -188 -> 52
    //   243: ldc 29
    //   245: ldc 132
    //   247: invokestatic 135	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aconst_null
    //   251: astore 4
    //   253: aconst_null
    //   254: astore 5
    //   256: goto -204 -> 52
    //   259: ldc 29
    //   261: ldc 137
    //   263: invokestatic 135	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aconst_null
    //   267: astore 4
    //   269: aconst_null
    //   270: astore 5
    //   272: goto -220 -> 52
    //   275: astore_0
    //   276: ldc 29
    //   278: new 139	java/lang/StringBuilder
    //   281: dup
    //   282: ldc 141
    //   284: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: aload_0
    //   288: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 135	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: goto -152 -> 148
    //   303: astore_0
    //   304: ldc 29
    //   306: new 139	java/lang/StringBuilder
    //   309: dup
    //   310: ldc 157
    //   312: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: aload_0
    //   316: invokevirtual 148	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 135	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: ldc 29
    //   330: ldc 159
    //   332: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: new 161	com/tencent/xweb/extension/video/d
    //   338: dup
    //   339: invokespecial 164	com/tencent/xweb/extension/video/d:<init>	()V
    //   342: astore_0
    //   343: aload_2
    //   344: invokevirtual 167	android/view/View:getContext	()Landroid/content/Context;
    //   347: pop
    //   348: aload_0
    //   349: aload 7
    //   351: putfield 171	com/tencent/xweb/extension/video/d:mActivity	Landroid/app/Activity;
    //   354: aload_0
    //   355: aload_1
    //   356: checkcast 76	com/tencent/xweb/WebView
    //   359: putfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   362: aload_0
    //   363: aload_3
    //   364: putfield 179	com/tencent/xweb/extension/video/d:KBt	Ljava/lang/String;
    //   367: aload_0
    //   368: new 181	android/widget/FrameLayout
    //   371: dup
    //   372: aload_0
    //   373: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   376: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   379: invokespecial 184	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   382: putfield 188	com/tencent/xweb/extension/video/d:mRootView	Landroid/widget/FrameLayout;
    //   385: aload_0
    //   386: getfield 188	com/tencent/xweb/extension/video/d:mRootView	Landroid/widget/FrameLayout;
    //   389: ldc 189
    //   391: invokevirtual 192	android/widget/FrameLayout:setBackgroundColor	(I)V
    //   394: aload_0
    //   395: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   398: invokevirtual 195	com/tencent/xweb/WebView:isXWalkKernel	()Z
    //   401: ifeq +82 -> 483
    //   404: aload_0
    //   405: new 197	android/view/SurfaceView
    //   408: dup
    //   409: aload_0
    //   410: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   413: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   416: invokespecial 198	android/view/SurfaceView:<init>	(Landroid/content/Context;)V
    //   419: putfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   422: aload_0
    //   423: getfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   426: invokevirtual 206	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   429: bipush 253
    //   431: invokeinterface 211 2 0
    //   436: aload_0
    //   437: getfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   440: invokevirtual 206	android/view/SurfaceView:getHolder	()Landroid/view/SurfaceHolder;
    //   443: new 213	com/tencent/xweb/extension/video/d$1
    //   446: dup
    //   447: aload_0
    //   448: invokespecial 216	com/tencent/xweb/extension/video/d$1:<init>	(Lcom/tencent/xweb/extension/video/d;)V
    //   451: invokeinterface 220 2 0
    //   456: aload_0
    //   457: getfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   460: iconst_0
    //   461: invokevirtual 224	android/view/SurfaceView:setZOrderOnTop	(Z)V
    //   464: aload_0
    //   465: getfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   468: iconst_0
    //   469: invokevirtual 227	android/view/SurfaceView:setZOrderMediaOverlay	(Z)V
    //   472: aload_0
    //   473: getfield 188	com/tencent/xweb/extension/video/d:mRootView	Landroid/widget/FrameLayout;
    //   476: aload_0
    //   477: getfield 202	com/tencent/xweb/extension/video/d:KAQ	Landroid/view/SurfaceView;
    //   480: invokevirtual 231	android/widget/FrameLayout:addView	(Landroid/view/View;)V
    //   483: aload_0
    //   484: new 233	android/view/GestureDetector
    //   487: dup
    //   488: aload_0
    //   489: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   492: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   495: aload_0
    //   496: invokespecial 236	android/view/GestureDetector:<init>	(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V
    //   499: putfield 240	com/tencent/xweb/extension/video/d:NL	Landroid/view/GestureDetector;
    //   502: aload_0
    //   503: new 242	android/view/ScaleGestureDetector
    //   506: dup
    //   507: aload_0
    //   508: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   511: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   514: aload_0
    //   515: invokespecial 245	android/view/ScaleGestureDetector:<init>	(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    //   518: putfield 249	com/tencent/xweb/extension/video/d:Jwk	Landroid/view/ScaleGestureDetector;
    //   521: aload_0
    //   522: getfield 240	com/tencent/xweb/extension/video/d:NL	Landroid/view/GestureDetector;
    //   525: iconst_0
    //   526: invokevirtual 252	android/view/GestureDetector:setIsLongpressEnabled	(Z)V
    //   529: aload_0
    //   530: aload_0
    //   531: getfield 175	com/tencent/xweb/extension/video/d:CcI	Lcom/tencent/xweb/WebView;
    //   534: invokevirtual 80	com/tencent/xweb/WebView:getContext	()Landroid/content/Context;
    //   537: invokestatic 258	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   540: ldc_w 259
    //   543: aconst_null
    //   544: invokevirtual 263	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   547: checkcast 265	android/view/ViewGroup
    //   550: putfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   553: aload_0
    //   554: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   557: bipush 8
    //   559: invokevirtual 272	android/view/ViewGroup:setVisibility	(I)V
    //   562: aload_0
    //   563: new 274	com/tencent/xweb/extension/video/c
    //   566: dup
    //   567: aload_0
    //   568: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   571: ldc_w 275
    //   574: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   577: checkcast 181	android/widget/FrameLayout
    //   580: new 281	com/tencent/xweb/extension/video/d$10
    //   583: dup
    //   584: aload_0
    //   585: invokespecial 282	com/tencent/xweb/extension/video/d$10:<init>	(Lcom/tencent/xweb/extension/video/d;)V
    //   588: invokespecial 285	com/tencent/xweb/extension/video/c:<init>	(Landroid/widget/FrameLayout;Lcom/tencent/xweb/extension/video/c$a;)V
    //   591: putfield 289	com/tencent/xweb/extension/video/d:KBc	Lcom/tencent/xweb/extension/video/c;
    //   594: aload_0
    //   595: aload_0
    //   596: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   599: ldc_w 290
    //   602: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   605: checkcast 292	android/widget/ProgressBar
    //   608: putfield 296	com/tencent/xweb/extension/video/d:KAU	Landroid/widget/ProgressBar;
    //   611: aload_0
    //   612: aload_0
    //   613: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   616: ldc_w 297
    //   619: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   622: checkcast 299	android/widget/TextView
    //   625: putfield 303	com/tencent/xweb/extension/video/d:KAV	Landroid/widget/TextView;
    //   628: aload_0
    //   629: aload_0
    //   630: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   633: ldc_w 304
    //   636: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   639: checkcast 299	android/widget/TextView
    //   642: putfield 307	com/tencent/xweb/extension/video/d:KAW	Landroid/widget/TextView;
    //   645: aload_0
    //   646: aload_0
    //   647: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   650: ldc_w 308
    //   653: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   656: checkcast 310	android/widget/ImageView
    //   659: putfield 314	com/tencent/xweb/extension/video/d:KAZ	Landroid/widget/ImageView;
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   667: ldc_w 315
    //   670: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   673: checkcast 317	com/tencent/xweb/extension/video/VideoStatusLayout
    //   676: putfield 321	com/tencent/xweb/extension/video/d:KAT	Lcom/tencent/xweb/extension/video/VideoStatusLayout;
    //   679: aload_0
    //   680: aload_0
    //   681: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   684: ldc_w 322
    //   687: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   690: checkcast 324	com/tencent/xweb/extension/video/ClickableFrameLayout
    //   693: putfield 328	com/tencent/xweb/extension/video/d:KAX	Lcom/tencent/xweb/extension/video/ClickableFrameLayout;
    //   696: aload_0
    //   697: getfield 328	com/tencent/xweb/extension/video/d:KAX	Lcom/tencent/xweb/extension/video/ClickableFrameLayout;
    //   700: aload_0
    //   701: getfield 240	com/tencent/xweb/extension/video/d:NL	Landroid/view/GestureDetector;
    //   704: invokevirtual 332	com/tencent/xweb/extension/video/ClickableFrameLayout:setGestureDetector	(Landroid/view/GestureDetector;)V
    //   707: aload_0
    //   708: getfield 328	com/tencent/xweb/extension/video/d:KAX	Lcom/tencent/xweb/extension/video/ClickableFrameLayout;
    //   711: new 334	com/tencent/xweb/extension/video/d$17
    //   714: dup
    //   715: aload_0
    //   716: invokespecial 335	com/tencent/xweb/extension/video/d$17:<init>	(Lcom/tencent/xweb/extension/video/d;)V
    //   719: invokevirtual 339	com/tencent/xweb/extension/video/ClickableFrameLayout:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   722: aload_0
    //   723: aload_0
    //   724: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   727: ldc_w 340
    //   730: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   733: checkcast 310	android/widget/ImageView
    //   736: putfield 343	com/tencent/xweb/extension/video/d:KBa	Landroid/widget/ImageView;
    //   739: aload_0
    //   740: getfield 343	com/tencent/xweb/extension/video/d:KBa	Landroid/widget/ImageView;
    //   743: new 345	com/tencent/xweb/extension/video/d$18
    //   746: dup
    //   747: aload_0
    //   748: invokespecial 346	com/tencent/xweb/extension/video/d$18:<init>	(Lcom/tencent/xweb/extension/video/d;)V
    //   751: invokevirtual 350	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   754: aload_0
    //   755: aload_0
    //   756: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   759: ldc_w 351
    //   762: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   765: checkcast 353	android/widget/LinearLayout
    //   768: putfield 357	com/tencent/xweb/extension/video/d:KAY	Landroid/widget/LinearLayout;
    //   771: aload_0
    //   772: getfield 357	com/tencent/xweb/extension/video/d:KAY	Landroid/widget/LinearLayout;
    //   775: iconst_4
    //   776: invokevirtual 358	android/widget/LinearLayout:setVisibility	(I)V
    //   779: aload_0
    //   780: aload_0
    //   781: getfield 269	com/tencent/xweb/extension/video/d:KAS	Landroid/view/ViewGroup;
    //   784: ldc_w 359
    //   787: invokevirtual 279	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   790: checkcast 310	android/widget/ImageView
    //   793: putfield 362	com/tencent/xweb/extension/video/d:KBb	Landroid/widget/ImageView;
    //   796: aload_0
    //   797: getfield 362	com/tencent/xweb/extension/video/d:KBb	Landroid/widget/ImageView;
    //   800: new 364	com/tencent/xweb/extension/video/d$19
    //   803: dup
    //   804: aload_0
    //   805: invokespecial 365	com/tencent/xweb/extension/video/d$19:<init>	(Lcom/tencent/xweb/extension/video/d;)V
    //   808: invokevirtual 350	android/widget/ImageView:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   811: ldc 15
    //   813: invokestatic 104	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: aload_0
    //   817: areturn
    //   818: ldc 29
    //   820: ldc_w 367
    //   823: invokestatic 46	org/xwalk/core/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   826: goto -498 -> 328
    //   829: astore 4
    //   831: aload 5
    //   833: astore 4
    //   835: goto -598 -> 237
    //   838: goto -738 -> 100
    //   841: aconst_null
    //   842: astore 4
    //   844: goto -627 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	paramContext	Context
    //   0	847	1	paramWebView	com.tencent.xweb.WebView
    //   0	847	2	paramView	View
    //   0	847	3	paramString	String
    //   50	174	4	localObject1	Object
    //   232	1	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   235	33	4	localObject2	Object
    //   829	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   833	10	4	localObject3	Object
    //   47	785	5	localObject4	Object
    //   219	7	6	localObject5	Object
    //   9	341	7	localActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   198	203	232	java/lang/ClassNotFoundException
    //   114	148	275	java/lang/Exception
    //   57	100	303	java/lang/Exception
    //   105	114	303	java/lang/Exception
    //   276	300	303	java/lang/Exception
    //   818	826	303	java/lang/Exception
    //   208	217	829	java/lang/ClassNotFoundException
  }
  
  private static ClassLoader fKc()
  {
    AppMethodBeat.i(153646);
    Object localObject;
    if (mClassLoader != null)
    {
      localObject = mClassLoader;
      AppMethodBeat.o(153646);
      return localObject;
    }
    try
    {
      int i = XWalkEnvironment.getAvailableVersion();
      if (i == -1)
      {
        Log.i("VideoNativeInterface", "getXWalkClassLoader version = -1");
        AppMethodBeat.o(153646);
        return null;
      }
      localObject = XWalkEnvironment.getExtractedCoreDir(i);
      String str = XWalkEnvironment.getClassDexFilePath(i);
      boolean bool = new File(str).exists();
      if (!bool)
      {
        AppMethodBeat.o(153646);
        return null;
      }
      mClassLoader = h.bf(str, XWalkEnvironment.getOptimizedDexDir(i), (String)localObject);
      localObject = mClassLoader;
      AppMethodBeat.o(153646);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + localException.getMessage());
      AppMethodBeat.o(153646);
    }
    return null;
  }
  
  public static final class a
    implements b, u
  {
    ReflectMethod KBR;
    private ReflectMethod KBS;
    private ReflectMethod KBT;
    private ReflectMethod KBU;
    private ReflectMethod KBV;
    private ReflectMethod KBW;
    private ReflectMethod KBX;
    private ReflectMethod KBY;
    private ReflectMethod KBZ;
    private ReflectMethod KCa;
    private ReflectMethod KCb;
    private ReflectMethod KCc;
    private Object KCd;
    private ReflectMethod hasEnteredFullscreenMethod;
    private ReflectMethod onHideCustomViewMethod;
    
    public a(Object paramObject)
    {
      AppMethodBeat.i(153636);
      this.KCd = paramObject;
      this.KBR = new ReflectMethod(paramObject, "init", new Class[] { Activity.class, View.class, View.class, Context.class, String.class });
      this.KBS = new ReflectMethod(paramObject, "evaluteJavascript", new Class[] { Boolean.TYPE, Boolean.TYPE });
      this.KBT = new ReflectMethod(paramObject, "onShowCustomView", new Class[] { View.class, WebChromeClient.CustomViewCallback.class });
      this.onHideCustomViewMethod = new ReflectMethod(paramObject, "onHideCustomView", new Class[0]);
      this.hasEnteredFullscreenMethod = new ReflectMethod(paramObject, "hasEnteredFullscreen", new Class[0]);
      this.KBU = new ReflectMethod(paramObject, "registerJavascriptInterface", new Class[] { Object.class });
      this.KBV = new ReflectMethod(paramObject, "disableJsCallback", new Class[] { Boolean.TYPE });
      this.KBW = new ReflectMethod(paramObject, "setVideoJsCallback", new Class[] { Object.class });
      this.KBZ = new ReflectMethod(paramObject, "videoChangeStatus", new Class[0]);
      this.KBX = new ReflectMethod(paramObject, "videoPlay", new Class[0]);
      this.KBY = new ReflectMethod(paramObject, "videoPause", new Class[0]);
      this.KCa = new ReflectMethod(paramObject, "videoSeek", new Class[] { Double.TYPE });
      this.KCb = new ReflectMethod(paramObject, "videoExitFullscreen", new Class[0]);
      this.KCc = new ReflectMethod(paramObject, "supportSetRequestedOrientationCallback", new Class[0]);
      AppMethodBeat.o(153636);
    }
    
    public final void F(double paramDouble)
    {
      AppMethodBeat.i(153645);
      try
      {
        this.KCa.invoke(new Object[] { Double.valueOf(paramDouble) });
        AppMethodBeat.o(153645);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoSeek invoke error:" + localException.getMessage());
        AppMethodBeat.o(153645);
      }
    }
    
    public final void aT(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(153637);
      try
      {
        this.KBS.invoke(new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
        AppMethodBeat.o(153637);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime evaluteJavascript error:" + localException.getMessage());
        AppMethodBeat.o(153637);
      }
    }
    
    public final void ex(Object paramObject)
    {
      AppMethodBeat.i(153638);
      try
      {
        this.KBU.invoke(new Object[] { paramObject });
        AppMethodBeat.o(153638);
        return;
      }
      catch (Exception paramObject)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime registerJavascriptInterface error:" + paramObject.getMessage());
        AppMethodBeat.o(153638);
      }
    }
    
    public final boolean ey(Object paramObject)
    {
      AppMethodBeat.i(153642);
      f localf = g.aUJ("FullScreenVideo");
      if ((localf != null) && (localf.KHj >= 10)) {
        try
        {
          boolean bool = ((Boolean)this.KBW.invoke(new Object[] { paramObject })).booleanValue();
          AppMethodBeat.o(153642);
          return bool;
        }
        catch (Exception paramObject)
        {
          Log.i("VideoNativeInterface", "setVideoJsCallback invoke error:" + paramObject.getMessage());
          AppMethodBeat.o(153642);
          return false;
        }
      }
      if (localf != null) {
        Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available version:" + localf.KHj);
      }
      for (;;)
      {
        AppMethodBeat.o(153642);
        return false;
        Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available");
      }
    }
    
    public final void fJl()
    {
      AppMethodBeat.i(153643);
      try
      {
        this.KBX.invoke(new Object[0]);
        AppMethodBeat.o(153643);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoPlay invoke error:" + localException.getMessage());
        AppMethodBeat.o(153643);
      }
    }
    
    public final void fJm()
    {
      AppMethodBeat.i(153644);
      try
      {
        this.KBY.invoke(new Object[0]);
        AppMethodBeat.o(153644);
        return;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "videoPause invoke error:" + localException.getMessage());
        AppMethodBeat.o(153644);
      }
    }
    
    public final boolean fJn()
    {
      AppMethodBeat.i(208874);
      try
      {
        boolean bool = ((Boolean)this.KCc.invoke(new Object[0])).booleanValue();
        AppMethodBeat.o(208874);
        return bool;
      }
      catch (Exception localException)
      {
        Log.i("VideoNativeInterface", "supportSetRequestedOrientationCallback invoke error:" + localException.getMessage());
        AppMethodBeat.o(208874);
      }
      return false;
    }
    
    public final void onHideCustomView()
    {
      AppMethodBeat.i(153641);
      try
      {
        this.onHideCustomViewMethod.invoke(new Object[0]);
        AppMethodBeat.o(153641);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onHideCustomView error:" + localException.getMessage());
        AppMethodBeat.o(153641);
      }
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(153639);
      try
      {
        this.KBT.invoke(new Object[] { paramView, paramCustomViewCallback });
        AppMethodBeat.o(153639);
        return;
      }
      catch (Exception paramView)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onShowCustomView error:" + paramView.getMessage());
        AppMethodBeat.o(153639);
      }
    }
    
    public final void yW(boolean paramBoolean)
    {
      AppMethodBeat.i(153640);
      try
      {
        this.KBV.invoke(new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(153640);
        return;
      }
      catch (Exception localException)
      {
        Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime disableJsCallback error:" + localException.getMessage());
        AppMethodBeat.o(153640);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.extension.video.e
 * JD-Core Version:    0.7.0.1
 */