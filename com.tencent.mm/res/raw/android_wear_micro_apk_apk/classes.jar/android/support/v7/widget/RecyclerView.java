package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.j;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements android.support.v4.view.h
{
  private static final boolean sV;
  private static final Class<?>[] sW;
  private static final Interpolator tZ;
  private int kD;
  private final Rect kd;
  private int kl;
  private VelocityTracker lA;
  private final int[] ph;
  private final int[] pi;
  private final ah sX;
  final af sY;
  private RecyclerView.SavedState sZ;
  private android.support.v4.widget.h tA;
  private android.support.v4.widget.h tB;
  x tC;
  private int tD;
  private int tE;
  private int tF;
  private int tG;
  private int tH;
  private final int tI;
  private final int tJ;
  private float tK;
  private final am tL;
  final ak tM;
  private ad tN;
  private List<ad> tO;
  boolean tP;
  boolean tQ;
  private y tR;
  private boolean tS;
  private ao tT;
  private w tU;
  private final int[] tV;
  private final j tW;
  private final int[] tX;
  private Runnable tY;
  a ta;
  d tb;
  private boolean tc;
  private final Runnable td;
  private t te;
  private ab tf;
  private ag tg;
  private final ArrayList<Object> th;
  private final ArrayList<ac> ti;
  private ac tj;
  private boolean tk;
  private boolean tl;
  private boolean tm;
  private boolean tn;
  private boolean to;
  private boolean tp;
  private boolean tq;
  private int tr;
  private boolean ts;
  private final boolean tt;
  private final AccessibilityManager tu;
  private List<Object> tv;
  private boolean tw;
  private int tx;
  private android.support.v4.widget.h ty;
  private android.support.v4.widget.h tz;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20)) {}
    for (boolean bool = true;; bool = false)
    {
      sV = bool;
      sW = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      tZ = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * (paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat) + 1.0F;
        }
      };
      return;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 163	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 165	android/support/v7/widget/ah
    //   11: dup
    //   12: aload_0
    //   13: iconst_0
    //   14: invokespecial 168	android/support/v7/widget/ah:<init>	(Landroid/support/v7/widget/RecyclerView;B)V
    //   17: putfield 170	android/support/v7/widget/RecyclerView:sX	Landroid/support/v7/widget/ah;
    //   20: aload_0
    //   21: new 172	android/support/v7/widget/af
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 175	android/support/v7/widget/af:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   29: putfield 177	android/support/v7/widget/RecyclerView:sY	Landroid/support/v7/widget/af;
    //   32: aload_0
    //   33: new 8	android/support/v7/widget/RecyclerView$1
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 178	android/support/v7/widget/RecyclerView$1:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   41: putfield 180	android/support/v7/widget/RecyclerView:td	Ljava/lang/Runnable;
    //   44: aload_0
    //   45: new 182	android/graphics/Rect
    //   48: dup
    //   49: invokespecial 183	android/graphics/Rect:<init>	()V
    //   52: putfield 185	android/support/v7/widget/RecyclerView:kd	Landroid/graphics/Rect;
    //   55: aload_0
    //   56: new 187	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 188	java/util/ArrayList:<init>	()V
    //   63: putfield 190	android/support/v7/widget/RecyclerView:th	Ljava/util/ArrayList;
    //   66: aload_0
    //   67: new 187	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 188	java/util/ArrayList:<init>	()V
    //   74: putfield 192	android/support/v7/widget/RecyclerView:ti	Ljava/util/ArrayList;
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 194	android/support/v7/widget/RecyclerView:tw	Z
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 196	android/support/v7/widget/RecyclerView:tx	I
    //   87: aload_0
    //   88: new 198	android/support/v7/widget/g
    //   91: dup
    //   92: invokespecial 199	android/support/v7/widget/g:<init>	()V
    //   95: putfield 201	android/support/v7/widget/RecyclerView:tC	Landroid/support/v7/widget/x;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 203	android/support/v7/widget/RecyclerView:kD	I
    //   103: aload_0
    //   104: iconst_m1
    //   105: putfield 205	android/support/v7/widget/RecyclerView:tD	I
    //   108: aload_0
    //   109: ldc 206
    //   111: putfield 208	android/support/v7/widget/RecyclerView:tK	F
    //   114: aload_0
    //   115: new 210	android/support/v7/widget/am
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 211	android/support/v7/widget/am:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   123: putfield 213	android/support/v7/widget/RecyclerView:tL	Landroid/support/v7/widget/am;
    //   126: aload_0
    //   127: new 215	android/support/v7/widget/ak
    //   130: dup
    //   131: invokespecial 216	android/support/v7/widget/ak:<init>	()V
    //   134: putfield 218	android/support/v7/widget/RecyclerView:tM	Landroid/support/v7/widget/ak;
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 220	android/support/v7/widget/RecyclerView:tP	Z
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 222	android/support/v7/widget/RecyclerView:tQ	Z
    //   147: aload_0
    //   148: new 224	android/support/v7/widget/z
    //   151: dup
    //   152: aload_0
    //   153: iconst_0
    //   154: invokespecial 225	android/support/v7/widget/z:<init>	(Landroid/support/v7/widget/RecyclerView;B)V
    //   157: putfield 227	android/support/v7/widget/RecyclerView:tR	Landroid/support/v7/widget/y;
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 229	android/support/v7/widget/RecyclerView:tS	Z
    //   165: aload_0
    //   166: iconst_2
    //   167: newarray int
    //   169: putfield 231	android/support/v7/widget/RecyclerView:tV	[I
    //   172: aload_0
    //   173: iconst_2
    //   174: newarray int
    //   176: putfield 233	android/support/v7/widget/RecyclerView:ph	[I
    //   179: aload_0
    //   180: iconst_2
    //   181: newarray int
    //   183: putfield 235	android/support/v7/widget/RecyclerView:pi	[I
    //   186: aload_0
    //   187: iconst_2
    //   188: newarray int
    //   190: putfield 237	android/support/v7/widget/RecyclerView:tX	[I
    //   193: aload_0
    //   194: new 10	android/support/v7/widget/RecyclerView$2
    //   197: dup
    //   198: aload_0
    //   199: invokespecial 238	android/support/v7/widget/RecyclerView$2:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   202: putfield 240	android/support/v7/widget/RecyclerView:tY	Ljava/lang/Runnable;
    //   205: aload_0
    //   206: iconst_1
    //   207: invokevirtual 244	android/support/v7/widget/RecyclerView:setScrollContainer	(Z)V
    //   210: aload_0
    //   211: iconst_1
    //   212: invokevirtual 247	android/support/v7/widget/RecyclerView:setFocusableInTouchMode	(Z)V
    //   215: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   218: bipush 16
    //   220: if_icmplt +359 -> 579
    //   223: iconst_1
    //   224: istore 4
    //   226: aload_0
    //   227: iload 4
    //   229: putfield 249	android/support/v7/widget/RecyclerView:tt	Z
    //   232: aload_1
    //   233: invokestatic 255	android/view/ViewConfiguration:get	(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   236: astore 5
    //   238: aload_0
    //   239: aload 5
    //   241: invokevirtual 259	android/view/ViewConfiguration:getScaledTouchSlop	()I
    //   244: putfield 261	android/support/v7/widget/RecyclerView:kl	I
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 264	android/view/ViewConfiguration:getScaledMinimumFlingVelocity	()I
    //   253: putfield 266	android/support/v7/widget/RecyclerView:tI	I
    //   256: aload_0
    //   257: aload 5
    //   259: invokevirtual 269	android/view/ViewConfiguration:getScaledMaximumFlingVelocity	()I
    //   262: putfield 271	android/support/v7/widget/RecyclerView:tJ	I
    //   265: aload_0
    //   266: invokestatic 277	android/support/v4/view/r:c	(Landroid/view/View;)I
    //   269: iconst_2
    //   270: if_icmpne +315 -> 585
    //   273: iconst_1
    //   274: istore 4
    //   276: aload_0
    //   277: iload 4
    //   279: invokevirtual 280	android/support/v7/widget/RecyclerView:setWillNotDraw	(Z)V
    //   282: aload_0
    //   283: getfield 201	android/support/v7/widget/RecyclerView:tC	Landroid/support/v7/widget/x;
    //   286: aload_0
    //   287: getfield 227	android/support/v7/widget/RecyclerView:tR	Landroid/support/v7/widget/y;
    //   290: invokevirtual 286	android/support/v7/widget/x:a	(Landroid/support/v7/widget/y;)V
    //   293: aload_0
    //   294: new 288	android/support/v7/widget/a
    //   297: dup
    //   298: new 16	android/support/v7/widget/RecyclerView$5
    //   301: dup
    //   302: aload_0
    //   303: invokespecial 289	android/support/v7/widget/RecyclerView$5:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   306: invokespecial 292	android/support/v7/widget/a:<init>	(Landroid/support/v7/widget/b;)V
    //   309: putfield 294	android/support/v7/widget/RecyclerView:ta	Landroid/support/v7/widget/a;
    //   312: aload_0
    //   313: new 296	android/support/v7/widget/d
    //   316: dup
    //   317: new 14	android/support/v7/widget/RecyclerView$4
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 297	android/support/v7/widget/RecyclerView$4:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   325: invokespecial 300	android/support/v7/widget/d:<init>	(Landroid/support/v7/widget/f;)V
    //   328: putfield 302	android/support/v7/widget/RecyclerView:tb	Landroid/support/v7/widget/d;
    //   331: aload_0
    //   332: invokestatic 305	android/support/v4/view/r:g	(Landroid/view/View;)I
    //   335: ifne +8 -> 343
    //   338: aload_0
    //   339: iconst_1
    //   340: invokestatic 308	android/support/v4/view/r:c	(Landroid/view/View;I)V
    //   343: aload_0
    //   344: aload_0
    //   345: invokevirtual 312	android/support/v7/widget/RecyclerView:getContext	()Landroid/content/Context;
    //   348: ldc_w 314
    //   351: invokevirtual 318	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   354: checkcast 320	android/view/accessibility/AccessibilityManager
    //   357: putfield 322	android/support/v7/widget/RecyclerView:tu	Landroid/view/accessibility/AccessibilityManager;
    //   360: aload_0
    //   361: new 324	android/support/v7/widget/ao
    //   364: dup
    //   365: aload_0
    //   366: invokespecial 325	android/support/v7/widget/ao:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   369: putfield 327	android/support/v7/widget/RecyclerView:tT	Landroid/support/v7/widget/ao;
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 327	android/support/v7/widget/RecyclerView:tT	Landroid/support/v7/widget/ao;
    //   377: invokestatic 330	android/support/v4/view/r:a	(Landroid/view/View;Landroid/support/v4/view/a;)V
    //   380: aload_2
    //   381: ifnull +180 -> 561
    //   384: aload_1
    //   385: aload_2
    //   386: getstatic 335	android/support/v7/a/b:qV	[I
    //   389: iload_3
    //   390: iconst_0
    //   391: invokevirtual 339	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   394: astore 5
    //   396: aload 5
    //   398: getstatic 342	android/support/v7/a/b:qW	I
    //   401: invokevirtual 348	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   404: astore 6
    //   406: aload 5
    //   408: invokevirtual 351	android/content/res/TypedArray:recycle	()V
    //   411: aload 6
    //   413: ifnull +148 -> 561
    //   416: aload 6
    //   418: invokevirtual 357	java/lang/String:trim	()Ljava/lang/String;
    //   421: astore 5
    //   423: aload 5
    //   425: invokevirtual 360	java/lang/String:length	()I
    //   428: ifeq +133 -> 561
    //   431: aload 5
    //   433: iconst_0
    //   434: invokevirtual 364	java/lang/String:charAt	(I)C
    //   437: bipush 46
    //   439: if_icmpne +152 -> 591
    //   442: new 366	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   449: aload_1
    //   450: invokevirtual 370	android/content/Context:getPackageName	()Ljava/lang/String;
    //   453: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 5
    //   458: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: astore 5
    //   466: aload_0
    //   467: invokevirtual 381	android/support/v7/widget/RecyclerView:isInEditMode	()Z
    //   470: ifeq +171 -> 641
    //   473: aload_0
    //   474: invokevirtual 387	java/lang/Object:getClass	()Ljava/lang/Class;
    //   477: invokevirtual 391	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   480: astore 6
    //   482: aload 6
    //   484: aload 5
    //   486: invokevirtual 397	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   489: ldc_w 399
    //   492: invokevirtual 403	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   495: astore 8
    //   497: aload 8
    //   499: getstatic 137	android/support/v7/widget/RecyclerView:sW	[Ljava/lang/Class;
    //   502: invokevirtual 407	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   505: astore 6
    //   507: iconst_4
    //   508: anewarray 383	java/lang/Object
    //   511: astore 7
    //   513: aload 7
    //   515: iconst_0
    //   516: aload_1
    //   517: aastore
    //   518: aload 7
    //   520: iconst_1
    //   521: aload_2
    //   522: aastore
    //   523: aload 7
    //   525: iconst_2
    //   526: iload_3
    //   527: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: aload 7
    //   533: iconst_3
    //   534: iconst_0
    //   535: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: aload 7
    //   541: astore_1
    //   542: aload 6
    //   544: iconst_1
    //   545: invokevirtual 416	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   548: aload_0
    //   549: aload 6
    //   551: aload_1
    //   552: invokevirtual 420	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   555: checkcast 399	android/support/v7/widget/ab
    //   558: invokevirtual 423	android/support/v7/widget/RecyclerView:a	(Landroid/support/v7/widget/ab;)V
    //   561: aload_0
    //   562: new 425	android/support/v4/view/j
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 428	android/support/v4/view/j:<init>	(Landroid/view/View;)V
    //   570: putfield 430	android/support/v7/widget/RecyclerView:tW	Landroid/support/v4/view/j;
    //   573: aload_0
    //   574: iconst_1
    //   575: invokevirtual 433	android/support/v7/widget/RecyclerView:setNestedScrollingEnabled	(Z)V
    //   578: return
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -356 -> 226
    //   585: iconst_0
    //   586: istore 4
    //   588: goto -312 -> 276
    //   591: aload 5
    //   593: ldc_w 435
    //   596: invokevirtual 439	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   599: ifeq +6 -> 605
    //   602: goto -136 -> 466
    //   605: new 366	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   612: ldc 2
    //   614: invokevirtual 443	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   617: invokevirtual 448	java/lang/Package:getName	()Ljava/lang/String;
    //   620: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: bipush 46
    //   625: invokevirtual 451	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   628: aload 5
    //   630: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: astore 5
    //   638: goto -172 -> 466
    //   641: aload_1
    //   642: invokevirtual 452	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   645: astore 6
    //   647: goto -165 -> 482
    //   650: astore_1
    //   651: aload 8
    //   653: iconst_0
    //   654: anewarray 125	java/lang/Class
    //   657: invokevirtual 407	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   660: astore 6
    //   662: aconst_null
    //   663: astore_1
    //   664: goto -122 -> 542
    //   667: astore 6
    //   669: aload 6
    //   671: aload_1
    //   672: invokevirtual 456	java/lang/NoSuchMethodException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   675: pop
    //   676: new 458	java/lang/IllegalStateException
    //   679: dup
    //   680: new 366	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   687: aload_2
    //   688: invokeinterface 461 1 0
    //   693: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 463
    //   699: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 5
    //   704: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: aload 6
    //   712: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   715: athrow
    //   716: astore_1
    //   717: new 458	java/lang/IllegalStateException
    //   720: dup
    //   721: new 366	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   728: aload_2
    //   729: invokeinterface 461 1 0
    //   734: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: ldc_w 468
    //   740: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 5
    //   745: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: aload_1
    //   752: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   755: athrow
    //   756: astore_1
    //   757: new 458	java/lang/IllegalStateException
    //   760: dup
    //   761: new 366	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   768: aload_2
    //   769: invokeinterface 461 1 0
    //   774: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 470
    //   780: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 5
    //   785: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: aload_1
    //   792: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   795: athrow
    //   796: astore_1
    //   797: new 458	java/lang/IllegalStateException
    //   800: dup
    //   801: new 366	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   808: aload_2
    //   809: invokeinterface 461 1 0
    //   814: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 470
    //   820: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 5
    //   825: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: aload_1
    //   832: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   835: athrow
    //   836: astore_1
    //   837: new 458	java/lang/IllegalStateException
    //   840: dup
    //   841: new 366	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   848: aload_2
    //   849: invokeinterface 461 1 0
    //   854: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 472
    //   860: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 5
    //   865: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: aload_1
    //   872: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   875: athrow
    //   876: astore_1
    //   877: new 458	java/lang/IllegalStateException
    //   880: dup
    //   881: new 366	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   888: aload_2
    //   889: invokeinterface 461 1 0
    //   894: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: ldc_w 474
    //   900: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 5
    //   905: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: aload_1
    //   912: invokespecial 466	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   915: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	916	0	this	RecyclerView
    //   0	916	1	paramContext	Context
    //   0	916	2	paramAttributeSet	AttributeSet
    //   0	916	3	paramInt	int
    //   224	363	4	bool	boolean
    //   236	668	5	localObject1	Object
    //   404	257	6	localObject2	Object
    //   667	44	6	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   511	29	7	arrayOfObject	Object[]
    //   495	157	8	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   497	513	650	java/lang/NoSuchMethodException
    //   523	539	650	java/lang/NoSuchMethodException
    //   651	662	667	java/lang/NoSuchMethodException
    //   466	482	716	java/lang/ClassNotFoundException
    //   482	497	716	java/lang/ClassNotFoundException
    //   497	513	716	java/lang/ClassNotFoundException
    //   523	539	716	java/lang/ClassNotFoundException
    //   542	561	716	java/lang/ClassNotFoundException
    //   641	647	716	java/lang/ClassNotFoundException
    //   651	662	716	java/lang/ClassNotFoundException
    //   669	716	716	java/lang/ClassNotFoundException
    //   466	482	756	java/lang/reflect/InvocationTargetException
    //   482	497	756	java/lang/reflect/InvocationTargetException
    //   497	513	756	java/lang/reflect/InvocationTargetException
    //   523	539	756	java/lang/reflect/InvocationTargetException
    //   542	561	756	java/lang/reflect/InvocationTargetException
    //   641	647	756	java/lang/reflect/InvocationTargetException
    //   651	662	756	java/lang/reflect/InvocationTargetException
    //   669	716	756	java/lang/reflect/InvocationTargetException
    //   466	482	796	java/lang/InstantiationException
    //   482	497	796	java/lang/InstantiationException
    //   497	513	796	java/lang/InstantiationException
    //   523	539	796	java/lang/InstantiationException
    //   542	561	796	java/lang/InstantiationException
    //   641	647	796	java/lang/InstantiationException
    //   651	662	796	java/lang/InstantiationException
    //   669	716	796	java/lang/InstantiationException
    //   466	482	836	java/lang/IllegalAccessException
    //   482	497	836	java/lang/IllegalAccessException
    //   497	513	836	java/lang/IllegalAccessException
    //   523	539	836	java/lang/IllegalAccessException
    //   542	561	836	java/lang/IllegalAccessException
    //   641	647	836	java/lang/IllegalAccessException
    //   651	662	836	java/lang/IllegalAccessException
    //   669	716	836	java/lang/IllegalAccessException
    //   466	482	876	java/lang/ClassCastException
    //   482	497	876	java/lang/ClassCastException
    //   497	513	876	java/lang/ClassCastException
    //   523	539	876	java/lang/ClassCastException
    //   542	561	876	java/lang/ClassCastException
    //   641	647	876	java/lang/ClassCastException
    //   651	662	876	java/lang/ClassCastException
    //   669	716	876	java/lang/ClassCastException
  }
  
  private void B(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.ty != null)
    {
      bool1 = bool2;
      if (!this.ty.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = this.ty.ci();
        }
      }
    }
    bool2 = bool1;
    if (this.tA != null)
    {
      bool2 = bool1;
      if (!this.tA.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | this.tA.ci();
        }
      }
    }
    bool1 = bool2;
    if (this.tz != null)
    {
      bool1 = bool2;
      if (!this.tz.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | this.tz.ci();
        }
      }
    }
    bool2 = bool1;
    if (this.tB != null)
    {
      bool2 = bool1;
      if (!this.tB.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | this.tB.ci();
        }
      }
    }
    if (bool2) {
      r.f(this);
    }
  }
  
  private void D(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (j)
    {
    default: 
      paramInt1 = r.m(this);
    }
    switch (i)
    {
    default: 
      paramInt2 = r.n(this);
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  private boolean E(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int j = this.tb.getChildCount();
    boolean bool1;
    if (j == 0)
    {
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      an localan = ai(this.tb.getChildAt(i));
      if (!localan.ef())
      {
        int k = localan.eg();
        if ((k < paramInt1) || (k > paramInt2)) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  private void a(android.support.v4.b.a<View, Rect> parama)
  {
    List localList = this.tM.uQ;
    int i = localList.size() - 1;
    if (i >= 0)
    {
      View localView = (View)localList.get(i);
      an localan = ai(localView);
      aa localaa = (aa)this.tM.uN.remove(localan);
      if (!this.tM.dY()) {
        this.tM.uO.remove(localan);
      }
      if (parama.remove(localView) != null) {
        this.tf.a(localView, this.sY);
      }
      for (;;)
      {
        i -= 1;
        break;
        if (localaa != null) {
          a(localaa);
        } else {
          a(new aa(localan, localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
        }
      }
    }
    localList.clear();
  }
  
  private void a(aa paramaa)
  {
    View localView = paramaa.rP.ve;
    e(paramaa.rP);
    int i = paramaa.left;
    int j = paramaa.top;
    int k = localView.getLeft();
    int m = localView.getTop();
    if ((!paramaa.rP.isRemoved()) && ((i != k) || (j != m)))
    {
      paramaa.rP.p(false);
      localView.layout(k, m, localView.getWidth() + k, localView.getHeight() + m);
      if (this.tC.a(paramaa.rP, i, j, k, m)) {
        dw();
      }
      return;
    }
    paramaa.rP.p(false);
    this.tC.a(paramaa.rP);
    dw();
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int i1 = 0;
    int m = 0;
    dh();
    if (this.te != null)
    {
      di();
      dr();
      android.support.v4.os.f.beginSection("RV Scroll");
      if (paramInt1 != 0)
      {
        j = this.tf.a(paramInt1, this.sY, this.tM);
        i = paramInt1 - j;
        if (paramInt2 != 0)
        {
          m = this.tf.b(paramInt2, this.sY, this.tM);
          k = paramInt2 - m;
        }
        android.support.v4.os.f.endSection();
        if (dv())
        {
          i1 = this.tb.getChildCount();
          n = 0;
          if (n < i1)
          {
            View localView = this.tb.getChildAt(n);
            Object localObject = Z(localView);
            if ((localObject != null) && (((an)localObject).vk != null))
            {
              localObject = ((an)localObject).vk;
              if (localObject == null) {
                break label252;
              }
            }
            label252:
            for (localObject = ((an)localObject).ve;; localObject = null)
            {
              if (localObject != null)
              {
                int i2 = localView.getLeft();
                int i3 = localView.getTop();
                if ((i2 != ((View)localObject).getLeft()) || (i3 != ((View)localObject).getTop())) {
                  ((View)localObject).layout(i2, i3, ((View)localObject).getWidth() + i2, ((View)localObject).getHeight() + i3);
                }
              }
              n += 1;
              break;
            }
          }
        }
        ds();
        o(false);
        n = k;
        k = m;
      }
    }
    for (;;)
    {
      if (!this.th.isEmpty()) {
        invalidate();
      }
      if (dispatchNestedScroll(j, k, i, n, this.ph))
      {
        this.tG -= this.ph[0];
        this.tH -= this.ph[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.ph[0], this.ph[1]);
        }
        paramMotionEvent = this.tX;
        paramMotionEvent[0] += this.ph[0];
        paramMotionEvent = this.tX;
        paramMotionEvent[1] += this.ph[1];
      }
      while (r.c(this) == 2)
      {
        if ((j != 0) || (k != 0)) {
          ak(k);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((j == 0) && (k == 0)) {
          break;
        }
        return true;
      }
      float f1;
      float f2;
      float f3;
      float f4;
      if (paramMotionEvent != null)
      {
        f1 = paramMotionEvent.getX();
        f2 = i;
        f3 = paramMotionEvent.getY();
        f4 = n;
        i = 0;
        if (f2 >= 0.0F) {
          break label584;
        }
        dk();
        this.ty.b(-f2 / getWidth(), 1.0F - f3 / getHeight());
        i = 1;
        label513:
        if (f4 >= 0.0F) {
          break label625;
        }
        dm();
        this.tz.b(-f4 / getHeight(), f1 / getWidth());
        i = 1;
      }
      for (;;)
      {
        if ((i != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
          r.f(this);
        }
        B(paramInt1, paramInt2);
        break;
        label584:
        if (f2 <= 0.0F) {
          break label513;
        }
        dl();
        this.tA.b(f2 / getWidth(), f3 / getHeight());
        i = 1;
        break label513;
        label625:
        if (f4 > 0.0F)
        {
          dn();
          this.tB.b(f4 / getHeight(), 1.0F - f1 / getWidth());
          i = 1;
        }
      }
      return false;
      n = 0;
      i = j;
      j = n;
      break;
      k = 0;
      j = i1;
    }
  }
  
  static an ai(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).uo;
  }
  
  @Deprecated
  public static int aj(View paramView)
  {
    paramView = ai(paramView);
    if ((paramView != null) && (paramView.vr != null))
    {
      Object localObject = paramView.vr;
      if ((paramView.ay(524)) || (!paramView.isBound())) {
        i = -1;
      }
      int j;
      int n;
      int m;
      do
      {
        return i;
        localObject = ((RecyclerView)localObject).ta;
        j = paramView.sx;
        n = ((a)localObject).qY.size();
        m = 0;
        i = j;
      } while (m >= n);
      paramView = (c)((a)localObject).qY.get(m);
      int i = j;
      switch (paramView.al)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        m += 1;
        j = i;
        break;
        i = j;
        if (paramView.re <= j)
        {
          i = j + paramView.rg;
          continue;
          i = j;
          if (paramView.re <= j)
          {
            if (paramView.re + paramView.rg > j) {
              break label241;
            }
            i = j - paramView.rg;
            continue;
            if (paramView.re == j)
            {
              i = paramView.rg;
            }
            else
            {
              int k = j;
              if (paramView.re < j) {
                k = j - 1;
              }
              i = k;
              if (paramView.rg <= k) {
                i = k + 1;
              }
            }
          }
        }
      }
    }
    label241:
    return -1;
  }
  
  public static int ak(View paramView)
  {
    paramView = ai(paramView);
    if (paramView != null) {
      return paramView.eg();
    }
    return -1;
  }
  
  private void am(View paramView)
  {
    ai(paramView);
    if (this.tv != null)
    {
      int i = this.tv.size() - 1;
      while (i >= 0)
      {
        this.tv.get(i);
        i -= 1;
      }
    }
  }
  
  private void dB()
  {
    int j = 0;
    int k = this.tb.cE();
    int i = 0;
    while (i < k)
    {
      localObject1 = ai(this.tb.ab(i));
      if ((localObject1 != null) && (!((an)localObject1).ef())) {
        ((an)localObject1).addFlags(6);
      }
      i += 1;
    }
    k = this.tb.cE();
    i = 0;
    while (i < k)
    {
      ((RecyclerView.LayoutParams)this.tb.ab(i).getLayoutParams()).up = true;
      i += 1;
    }
    Object localObject1 = this.sY;
    k = ((af)localObject1).uw.size();
    i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = (RecyclerView.LayoutParams)((an)((af)localObject1).uw.get(i)).ve.getLayoutParams();
      if (localObject2 != null) {
        ((RecyclerView.LayoutParams)localObject2).up = true;
      }
      i += 1;
    }
    localObject1 = this.sY;
    if ((((af)localObject1).ua.te != null) && (((af)localObject1).ua.te.hasStableIds()))
    {
      k = ((af)localObject1).uw.size();
      i = j;
    }
    while (i < k)
    {
      localObject2 = (an)((af)localObject1).uw.get(i);
      if (localObject2 != null)
      {
        ((an)localObject2).addFlags(6);
        ((an)localObject2).q(null);
      }
      i += 1;
      continue;
      ((af)localObject1).dT();
    }
  }
  
  private void dh()
  {
    this.td.run();
  }
  
  private void dj()
  {
    this.tL.stop();
    if (this.tf != null) {
      this.tf.dP();
    }
  }
  
  private void dk()
  {
    if (this.ty != null) {
      return;
    }
    this.ty = new android.support.v4.widget.h(getContext());
    if (this.tc)
    {
      this.ty.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.ty.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void dl()
  {
    if (this.tA != null) {
      return;
    }
    this.tA = new android.support.v4.widget.h(getContext());
    if (this.tc)
    {
      this.tA.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.tA.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void dm()
  {
    if (this.tz != null) {
      return;
    }
    this.tz = new android.support.v4.widget.h(getContext());
    if (this.tc)
    {
      this.tz.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.tz.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void dn()
  {
    if (this.tB != null) {
      return;
    }
    this.tB = new android.support.v4.widget.h(getContext());
    if (this.tc)
    {
      this.tB.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.tB.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void jdMethod_do()
  {
    this.tB = null;
    this.tz = null;
    this.tA = null;
    this.ty = null;
  }
  
  private void dp()
  {
    if (this.lA != null) {
      this.lA.clear();
    }
    stopNestedScroll();
    boolean bool2 = false;
    if (this.ty != null) {
      bool2 = this.ty.ci();
    }
    boolean bool1 = bool2;
    if (this.tz != null) {
      bool1 = bool2 | this.tz.ci();
    }
    bool2 = bool1;
    if (this.tA != null) {
      bool2 = bool1 | this.tA.ci();
    }
    bool1 = bool2;
    if (this.tB != null) {
      bool1 = bool2 | this.tB.ci();
    }
    if (bool1) {
      r.f(this);
    }
  }
  
  private void dq()
  {
    dp();
    z(0);
  }
  
  private void dr()
  {
    this.tx += 1;
  }
  
  private void ds()
  {
    this.tx -= 1;
    if (this.tx <= 0)
    {
      this.tx = 0;
      int i = this.tr;
      this.tr = 0;
      if ((i != 0) && (dt()))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        localAccessibilityEvent.setEventType(2048);
        android.support.v4.view.a.a.a(localAccessibilityEvent, i);
        sendAccessibilityEventUnchecked(localAccessibilityEvent);
      }
    }
  }
  
  private boolean du()
  {
    return this.tx > 0;
  }
  
  private boolean dv()
  {
    return (this.tC != null) && (this.tC.dK());
  }
  
  private void dw()
  {
    if ((!this.tS) && (this.tk))
    {
      r.b(this, this.tY);
      this.tS = true;
    }
  }
  
  private void dx()
  {
    boolean bool2 = true;
    if (this.tw)
    {
      this.ta.reset();
      dB();
      this.tf.cJ();
    }
    int i;
    label88:
    ak localak;
    if ((this.tC != null) && (this.tf.cL()))
    {
      this.ta.cA();
      if (((!this.tP) || (this.tQ)) && (!this.tP) && ((!this.tQ) || (!dv()))) {
        break label225;
      }
      i = 1;
      localak = this.tM;
      if ((!this.tm) || (this.tC == null) || ((!this.tw) && (i == 0) && (!ab.b(this.tf))) || ((this.tw) && (!this.te.hasStableIds()))) {
        break label230;
      }
      bool1 = true;
      label148:
      ak.c(localak, bool1);
      localak = this.tM;
      if ((!ak.m(this.tM)) || (i == 0) || (this.tw)) {
        break label240;
      }
      if ((this.tC == null) || (!this.tf.cL())) {
        break label235;
      }
      i = 1;
      label201:
      if (i == 0) {
        break label240;
      }
    }
    label225:
    label230:
    label235:
    label240:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ak.d(localak, bool1);
      return;
      this.ta.cD();
      break;
      i = 0;
      break label88;
      bool1 = false;
      break label148;
      i = 0;
      break label201;
    }
  }
  
  private void dz()
  {
    int j = this.tb.cE();
    int i = 0;
    while (i < j)
    {
      an localan = ai(this.tb.ab(i));
      if (!localan.ef()) {
        localan.ee();
      }
      i += 1;
    }
    this.sY.dz();
  }
  
  private void e(an paraman)
  {
    View localView = paraman.ve;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.sY.r(Z(localView));
      if (!paraman.ep()) {
        break;
      }
      this.tb.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.tb.V(localView);
      return;
    }
    this.tb.X(localView);
  }
  
  private void e(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.tD) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.tD = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.tG = j;
      this.tE = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.tH = i;
      this.tF = i;
      return;
    }
  }
  
  private long f(an paraman)
  {
    if (this.te.hasStableIds()) {
      return paraman.vg;
    }
    return paraman.sx;
  }
  
  private void z(int paramInt)
  {
    if (paramInt == this.kD) {}
    for (;;)
    {
      return;
      this.kD = paramInt;
      if (paramInt != 2) {
        dj();
      }
      if (this.tf != null) {
        this.tf.ao(paramInt);
      }
      if (this.tN != null) {
        this.tN.ap(paramInt);
      }
      if (this.tO != null)
      {
        int i = this.tO.size() - 1;
        while (i >= 0)
        {
          ((ad)this.tO.get(i)).ap(paramInt);
          i -= 1;
        }
      }
    }
  }
  
  public boolean A(int paramInt1, int paramInt2)
  {
    if (this.tf == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    int i;
    do
    {
      do
      {
        return false;
      } while (this.tp);
      bool1 = this.tf.cP();
      bool2 = this.tf.cQ();
      if (bool1)
      {
        i = paramInt1;
        if (Math.abs(paramInt1) >= this.tI) {}
      }
      else
      {
        i = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= this.tI) {}
      }
      else
      {
        paramInt1 = 0;
      }
    } while (((i == 0) && (paramInt1 == 0)) || (dispatchNestedPreFling(i, paramInt1)));
    if ((bool1) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      dispatchNestedFling(i, paramInt1, bool1);
      if (!bool1) {
        break;
      }
      paramInt2 = Math.max(-this.tJ, Math.min(i, this.tJ));
      paramInt1 = Math.max(-this.tJ, Math.min(paramInt1, this.tJ));
      this.tL.F(paramInt2, paramInt1);
      return true;
    }
  }
  
  final void C(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      dk();
      this.ty.L(-paramInt1);
      if (paramInt2 >= 0) {
        break label69;
      }
      dm();
      this.tz.L(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        r.f(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      dl();
      this.tA.L(paramInt1);
      break;
      label69:
      if (paramInt2 > 0)
      {
        dn();
        this.tB.L(paramInt2);
      }
    }
  }
  
  public an Z(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return ai(paramView);
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.tb.cE();
    int i = 0;
    if (i < j)
    {
      localObject = ai(this.tb.ab(i));
      if ((localObject != null) && (!((an)localObject).ef()))
      {
        if (((an)localObject).sx < paramInt1 + paramInt2) {
          break label83;
        }
        ((an)localObject).d(-paramInt2, paramBoolean);
        ak.a(this.tM, true);
      }
      for (;;)
      {
        i += 1;
        break;
        label83:
        if (((an)localObject).sx >= paramInt1)
        {
          int k = -paramInt2;
          ((an)localObject).addFlags(8);
          ((an)localObject).d(k, paramBoolean);
          ((an)localObject).sx = (paramInt1 - 1);
          ak.a(this.tM, true);
        }
      }
    }
    Object localObject = this.sY;
    i = ((af)localObject).uw.size() - 1;
    if (i >= 0)
    {
      an localan = (an)((af)localObject).uw.get(i);
      if (localan != null)
      {
        if (localan.eg() < paramInt1 + paramInt2) {
          break label202;
        }
        localan.d(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label202:
        if (localan.eg() >= paramInt1)
        {
          localan.addFlags(8);
          ((af)localObject).au(i);
        }
      }
    }
    requestLayout();
  }
  
  public final void a(ab paramab)
  {
    if (paramab == this.tf) {
      return;
    }
    if (this.tf != null)
    {
      if (this.tk) {
        this.tf.b(this, this.sY);
      }
      this.tf.r(null);
    }
    this.sY.clear();
    d locald = this.tb;
    for (e locale = locald.ri;; locale = locale.rl)
    {
      locale.rk = 0L;
      if (locale.rl == null) {
        break;
      }
    }
    int i = locald.rj.size() - 1;
    while (i >= 0)
    {
      locald.rh.ab((View)locald.rj.get(i));
      locald.rj.remove(i);
      i -= 1;
    }
    locald.rh.removeAllViews();
    this.tf = paramab;
    if (paramab != null)
    {
      if (paramab.uk != null) {
        throw new IllegalArgumentException("LayoutManager " + paramab + " is already attached to a RecyclerView: " + paramab.uk);
      }
      this.tf.r(this);
      if (this.tk) {
        this.tf.dM();
      }
    }
    requestLayout();
  }
  
  @Deprecated
  public final void a(ad paramad)
  {
    this.tN = paramad;
  }
  
  public void a(t paramt)
  {
    if (this.tp)
    {
      f("Do not setLayoutFrozen in layout or scroll");
      this.tp = false;
      if ((this.to) && (this.tf != null) && (this.te != null)) {
        requestLayout();
      }
      this.to = false;
    }
    if (this.te != null) {
      this.te.b(this.sX);
    }
    if (this.tC != null) {
      this.tC.cI();
    }
    if (this.tf != null)
    {
      this.tf.d(this.sY);
      this.tf.c(this.sY);
    }
    this.sY.clear();
    this.ta.reset();
    t localt1 = this.te;
    this.te = paramt;
    if (paramt != null) {
      paramt.a(this.sX);
    }
    if (this.tf != null) {
      this.tf.dO();
    }
    paramt = this.sY;
    t localt2 = this.te;
    paramt.clear();
    paramt.dU().a(localt1, localt2, false);
    ak.a(this.tM, true);
    dB();
    requestLayout();
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  final void ak(int paramInt)
  {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.tN != null) {
      this.tN.aq(paramInt);
    }
    if (this.tO != null)
    {
      i = this.tO.size() - 1;
      while (i >= 0)
      {
        ((ad)this.tO.get(i)).aq(paramInt);
        i -= 1;
      }
    }
  }
  
  final Rect al(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.up) {
      return localLayoutParams.rY;
    }
    Rect localRect1 = localLayoutParams.rY;
    localRect1.set(0, 0, 0, 0);
    int j = this.th.size();
    int i = 0;
    while (i < j)
    {
      this.kd.set(0, 0, 0, 0);
      this.th.get(i);
      Rect localRect2 = this.kd;
      ((RecyclerView.LayoutParams)paramView.getLayoutParams()).uo.eg();
      localRect2.set(0, 0, 0, 0);
      localRect1.left += this.kd.left;
      localRect1.top += this.kd.top;
      localRect1.right += this.kd.right;
      localRect1.bottom += this.kd.bottom;
      i += 1;
    }
    localLayoutParams.up = false;
    return localRect1;
  }
  
  final void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = this.tb.cE();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = this.tb.ab(i);
      an localan = ai((View)localObject);
      if ((localan != null) && (!localan.ef()) && (localan.sx >= paramInt1) && (localan.sx < paramInt1 + paramInt2))
      {
        localan.addFlags(2);
        localan.q(paramObject);
        if (dv()) {
          localan.addFlags(64);
        }
        ((RecyclerView.LayoutParams)((View)localObject).getLayoutParams()).up = true;
      }
      i += 1;
    }
    paramObject = this.sY;
    i = paramObject.uw.size() - 1;
    while (i >= 0)
    {
      localObject = (an)paramObject.uw.get(i);
      if (localObject != null)
      {
        j = ((an)localObject).eg();
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((an)localObject).addFlags(2);
          paramObject.au(i);
        }
      }
      i -= 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.tf.a((RecyclerView.LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.tf.cP()) {
      return this.tf.d(this.tM);
    }
    return 0;
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.tf.cP()) {
      return this.tf.b(this.tM);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.tf.cP()) {
      return this.tf.f(this.tM);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.tf.cQ()) {
      return this.tf.e(this.tM);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.tf.cQ()) {
      return this.tf.c(this.tM);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.tf.cQ()) {
      return this.tf.g(this.tM);
    }
    return 0;
  }
  
  final void dA()
  {
    int j = this.tb.getChildCount();
    int i = 0;
    if (i < j)
    {
      an localan = ai(this.tb.getChildAt(i));
      if ((localan != null) && (!localan.ef()))
      {
        if ((!localan.isRemoved()) && (!localan.em())) {
          break label68;
        }
        requestLayout();
      }
      for (;;)
      {
        i += 1;
        break;
        label68:
        if (localan.en())
        {
          int k = localan.sx;
          if (localan.vh != 0) {
            break label129;
          }
          if ((!localan.eo()) || (!dv())) {
            this.te.b(localan, localan.sx);
          } else {
            requestLayout();
          }
        }
      }
      label129:
      requestLayout();
    }
  }
  
  public final boolean dC()
  {
    return (!this.tm) || (this.tw) || (this.ta.cC());
  }
  
  public final void dd()
  {
    this.tl = true;
  }
  
  public final t de()
  {
    return this.te;
  }
  
  public final ab df()
  {
    return this.tf;
  }
  
  public final int dg()
  {
    return this.kD;
  }
  
  final void di()
  {
    if (!this.tn)
    {
      this.tn = true;
      if (!this.tp) {
        this.to = false;
      }
    }
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.tW.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.tW.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.tW.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.tW.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.th.size();
    int i = 0;
    while (i < j)
    {
      this.th.get(i);
      i += 1;
    }
    int n;
    if ((this.ty != null) && (!this.ty.isFinished()))
    {
      n = paramCanvas.save();
      if (this.tc)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.ty == null) || (!this.ty.draw(paramCanvas))) {
          break label445;
        }
        j = 1;
        label117:
        paramCanvas.restoreToCount(n);
      }
    }
    for (;;)
    {
      i = j;
      if (this.tz != null)
      {
        i = j;
        if (!this.tz.isFinished())
        {
          n = paramCanvas.save();
          if (this.tc) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.tz == null) || (!this.tz.draw(paramCanvas))) {
            break label450;
          }
          i = 1;
          label191:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.tA != null)
      {
        j = i;
        if (!this.tA.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.tc) {
            break label455;
          }
          j = getPaddingTop();
          label246:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.tA == null) || (!this.tA.draw(paramCanvas))) {
            break label460;
          }
          j = 1;
          label284:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.tB != null)
      {
        i = j;
        if (!this.tB.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.tc) {
            break label465;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label361:
          i = m;
          if (this.tB != null)
          {
            i = m;
            if (this.tB.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.tC != null) && (this.th.size() > 0) && (this.tC.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          r.f(this);
        }
        return;
        i = 0;
        break;
        label445:
        j = 0;
        break label117;
        label450:
        i = 0;
        break label191;
        label455:
        j = 0;
        break label246;
        label460:
        j = 0;
        break label284;
        label465:
        paramCanvas.translate(-getWidth(), -getHeight());
        break label361;
      }
      j = 0;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  final boolean dt()
  {
    return (this.tu != null) && (this.tu.isEnabled());
  }
  
  final void dy()
  {
    if (this.te == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.tf == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.tM.uQ.clear();
    di();
    dr();
    dx();
    Object localObject2 = this.tM;
    if ((ak.m(this.tM)) && (this.tQ) && (dv())) {}
    int i2;
    label175:
    int j;
    for (Object localObject1 = new android.support.v4.b.a();; localObject1 = null)
    {
      ((ak)localObject2).uP = ((android.support.v4.b.a)localObject1);
      this.tQ = false;
      this.tP = false;
      ak.b(this.tM, ak.l(this.tM));
      this.tM.uS = this.te.getItemCount();
      localObject1 = this.tV;
      i2 = this.tb.getChildCount();
      if (i2 != 0) {
        break;
      }
      localObject1[0] = 0;
      localObject1[1] = 0;
      if (!ak.m(this.tM)) {
        break label420;
      }
      this.tM.uN.clear();
      this.tM.uO.clear();
      j = this.tb.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject1 = ai(this.tb.getChildAt(i));
        if ((!((an)localObject1).ef()) && ((!((an)localObject1).em()) || (this.te.hasStableIds())))
        {
          localObject2 = ((an)localObject1).ve;
          this.tM.uN.put(localObject1, new aa((an)localObject1, ((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom()));
        }
        i += 1;
      }
    }
    int i = 2147483647;
    int k = -2147483648;
    int n = 0;
    label332:
    int m;
    if (n < i2)
    {
      localObject2 = ai(this.tb.getChildAt(n));
      m = i;
      if (((an)localObject2).ef()) {
        break label2067;
      }
      int i1 = ((an)localObject2).eg();
      j = i;
      if (i1 < i) {
        j = i1;
      }
      m = j;
      if (i1 <= k) {
        break label2067;
      }
      i = j;
      j = i1;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break label332;
      localObject1[0] = i;
      localObject1[1] = k;
      break label175;
      label420:
      long l;
      boolean bool;
      if (ak.l(this.tM))
      {
        j = this.tb.cE();
        i = 0;
        while (i < j)
        {
          localObject1 = ai(this.tb.ab(i));
          if ((!((an)localObject1).ef()) && (((an)localObject1).vf == -1)) {
            ((an)localObject1).vf = ((an)localObject1).sx;
          }
          i += 1;
        }
        if (this.tM.uP != null)
        {
          j = this.tb.getChildCount();
          i = 0;
          while (i < j)
          {
            localObject1 = ai(this.tb.getChildAt(i));
            if ((((an)localObject1).eo()) && (!((an)localObject1).isRemoved()) && (!((an)localObject1).ef()))
            {
              l = f((an)localObject1);
              this.tM.uP.put(Long.valueOf(l), localObject1);
              this.tM.uN.remove(localObject1);
            }
            i += 1;
          }
        }
        bool = ak.n(this.tM);
        ak.a(this.tM, false);
        this.tf.c(this.sY, this.tM);
        ak.a(this.tM, bool);
        localObject2 = new android.support.v4.b.a();
        i = 0;
        label654:
        if (i < this.tb.getChildCount())
        {
          localObject1 = this.tb.getChildAt(i);
          if (!ai((View)localObject1).ef())
          {
            j = 0;
            label688:
            if (j >= this.tM.uN.size()) {
              break label2062;
            }
            if (((an)this.tM.uN.keyAt(j)).ve != localObject1) {
              break label772;
            }
          }
        }
      }
      label772:
      label1415:
      label2056:
      label2062:
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          ((android.support.v4.b.a)localObject2).put(localObject1, new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()));
        }
        i += 1;
        break label654;
        j += 1;
        break label688;
        dz();
        this.ta.cB();
        for (;;)
        {
          this.tM.uS = this.te.getItemCount();
          ak.o(this.tM);
          ak.b(this.tM, false);
          this.tf.c(this.sY, this.tM);
          ak.a(this.tM, false);
          this.sZ = null;
          localObject1 = this.tM;
          label913:
          label923:
          Object localObject3;
          Object localObject4;
          if ((ak.m(this.tM)) && (this.tC != null))
          {
            bool = true;
            ak.c((ak)localObject1, bool);
            if (!ak.m(this.tM)) {
              break label1937;
            }
            if (this.tM.uP == null) {
              break label1132;
            }
            localObject1 = new android.support.v4.b.a();
            j = this.tb.getChildCount();
            i = 0;
            if (i >= j) {
              break label1183;
            }
            localObject3 = ai(this.tb.getChildAt(i));
            if (!((an)localObject3).ef())
            {
              localObject4 = ((an)localObject3).ve;
              l = f((an)localObject3);
              if ((localObject1 == null) || (this.tM.uP.get(Long.valueOf(l)) == null)) {
                break label1138;
              }
              ((android.support.v4.b.a)localObject1).put(Long.valueOf(l), localObject3);
            }
          }
          for (;;)
          {
            i += 1;
            break label923;
            dz();
            this.ta.cD();
            if (this.tM.uP == null) {
              break label2056;
            }
            j = this.tb.getChildCount();
            i = 0;
            while (i < j)
            {
              localObject1 = ai(this.tb.getChildAt(i));
              if ((((an)localObject1).eo()) && (!((an)localObject1).isRemoved()) && (!((an)localObject1).ef()))
              {
                l = f((an)localObject1);
                this.tM.uP.put(Long.valueOf(l), localObject1);
                this.tM.uN.remove(localObject1);
              }
              i += 1;
            }
            bool = false;
            break;
            label1132:
            localObject1 = null;
            break label913;
            label1138:
            this.tM.uO.put(localObject3, new aa((an)localObject3, ((View)localObject4).getLeft(), ((View)localObject4).getTop(), ((View)localObject4).getRight(), ((View)localObject4).getBottom()));
          }
          label1183:
          a((android.support.v4.b.a)localObject2);
          i = this.tM.uN.size() - 1;
          while (i >= 0)
          {
            localObject3 = (an)this.tM.uN.keyAt(i);
            if (!this.tM.uO.containsKey(localObject3))
            {
              localObject3 = (aa)this.tM.uN.valueAt(i);
              this.tM.uN.removeAt(i);
              localObject4 = ((aa)localObject3).rP.ve;
              this.sY.r(((aa)localObject3).rP);
              a((aa)localObject3);
            }
            i -= 1;
          }
          i = this.tM.uO.size();
          if (i > 0)
          {
            i -= 1;
            if (i >= 0)
            {
              localObject4 = (an)this.tM.uO.keyAt(i);
              Object localObject5 = (aa)this.tM.uO.valueAt(i);
              if ((this.tM.uN.isEmpty()) || (!this.tM.uN.containsKey(localObject4)))
              {
                this.tM.uO.removeAt(i);
                if (localObject2 == null) {
                  break label1498;
                }
                localObject3 = (Rect)((android.support.v4.b.a)localObject2).get(((an)localObject4).ve);
                j = ((aa)localObject5).left;
                k = ((aa)localObject5).top;
                localObject5 = ((an)localObject4).ve;
                if ((localObject3 == null) || ((((Rect)localObject3).left == j) && (((Rect)localObject3).top == k))) {
                  break label1504;
                }
                ((an)localObject4).p(false);
                if (this.tC.a((an)localObject4, ((Rect)localObject3).left, ((Rect)localObject3).top, j, k)) {
                  dw();
                }
              }
              for (;;)
              {
                i -= 1;
                break;
                label1498:
                localObject3 = null;
                break label1415;
                label1504:
                ((an)localObject4).p(false);
                this.tC.b((an)localObject4);
                dw();
              }
            }
          }
          j = this.tM.uO.size();
          i = 0;
          while (i < j)
          {
            localObject2 = (an)this.tM.uO.keyAt(i);
            localObject3 = (aa)this.tM.uO.valueAt(i);
            localObject4 = (aa)this.tM.uN.get(localObject2);
            if ((localObject4 != null) && (localObject3 != null) && ((((aa)localObject4).left != ((aa)localObject3).left) || (((aa)localObject4).top != ((aa)localObject3).top)))
            {
              ((an)localObject2).p(false);
              if (this.tC.a((an)localObject2, ((aa)localObject4).left, ((aa)localObject4).top, ((aa)localObject3).left, ((aa)localObject3).top)) {
                dw();
              }
            }
            i += 1;
          }
          if (this.tM.uP != null)
          {
            i = this.tM.uP.size();
            i -= 1;
            label1704:
            if (i < 0) {
              break label1937;
            }
            l = ((Long)this.tM.uP.keyAt(i)).longValue();
            localObject2 = (an)this.tM.uP.get(Long.valueOf(l));
            localObject3 = ((an)localObject2).ve;
            if ((!((an)localObject2).ef()) && (af.e(this.sY) != null) && (af.e(this.sY).contains(localObject2)))
            {
              localObject3 = (an)((android.support.v4.b.a)localObject1).get(Long.valueOf(l));
              ((an)localObject2).p(false);
              e((an)localObject2);
              ((an)localObject2).vj = ((an)localObject3);
              this.sY.r((an)localObject2);
              m = ((an)localObject2).ve.getLeft();
              n = ((an)localObject2).ve.getTop();
              if ((localObject3 != null) && (!((an)localObject3).ef())) {
                break label1903;
              }
              k = n;
              j = m;
            }
          }
          for (;;)
          {
            this.tC.a((an)localObject2, (an)localObject3, m, n, j, k);
            dw();
            i -= 1;
            break label1704;
            i = 0;
            break;
            label1903:
            j = ((an)localObject3).ve.getLeft();
            k = ((an)localObject3).ve.getTop();
            ((an)localObject3).p(false);
            ((an)localObject3).vk = ((an)localObject2);
          }
          label1937:
          o(false);
          this.tf.c(this.sY);
          ak.b(this.tM, this.tM.uS);
          this.tw = false;
          ak.c(this.tM, false);
          ak.d(this.tM, false);
          ds();
          ab.c(this.tf);
          if (af.e(this.sY) != null) {
            af.e(this.sY).clear();
          }
          this.tM.uP = null;
          if (!E(this.tV[0], this.tV[1])) {
            break;
          }
          ak(0);
          return;
          localObject2 = null;
        }
      }
      label2067:
      j = k;
      i = m;
    }
  }
  
  final void f(String paramString)
  {
    if (du())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (this.te != null)
      {
        localView1 = localView2;
        if (this.tf != null)
        {
          localView1 = localView2;
          if (!du())
          {
            localView1 = localView2;
            if (!this.tp)
            {
              di();
              localView1 = this.tf.d(paramInt, this.sY, this.tM);
              o(false);
            }
          }
        }
      }
    }
    if (localView1 != null) {
      return localView1;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.tf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.tf.cK();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.tf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.tf.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.tf == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.tf.a(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (this.tf != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.tU == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.tU.dF();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.tW.hasNestedScrollingParent();
  }
  
  public boolean isAttachedToWindow()
  {
    return this.tk;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.tW.isNestedScrollingEnabled();
  }
  
  final void o(boolean paramBoolean)
  {
    if (this.tn)
    {
      if ((paramBoolean) && (this.to) && (!this.tp) && (this.tf != null) && (this.te != null)) {
        dy();
      }
      this.tn = false;
      if (!this.tp) {
        this.to = false;
      }
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.tx = 0;
    this.tk = true;
    this.tm = false;
    if (this.tf != null) {
      this.tf.dM();
    }
    this.tS = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.tC != null) {
      this.tC.cI();
    }
    this.tm = false;
    z(0);
    dj();
    this.tk = false;
    if (this.tf != null) {
      this.tf.b(this, this.sY);
    }
    removeCallbacks(this.tY);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.th.size();
    int i = 0;
    while (i < j)
    {
      this.th.get(i);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (this.tf == null) {}
    label170:
    label173:
    for (;;)
    {
      return false;
      if ((!this.tp) && ((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (this.tf.cQ())
        {
          f1 = -paramMotionEvent.getAxisValue(9);
          if (!this.tf.cP()) {
            break label170;
          }
        }
        for (float f2 = paramMotionEvent.getAxisValue(10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label173;
          }
          if (this.tK == 1.4E-45F)
          {
            TypedValue localTypedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
              this.tK = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
          }
          else
          {
            f3 = this.tK;
          }
          a((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = -1;
    boolean bool1 = true;
    if (this.tp)
    {
      bool1 = false;
      return bool1;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.tj = null;
    }
    int m = this.ti.size();
    int i = 0;
    if (i < m)
    {
      ac localac = (ac)this.ti.get(i);
      if ((localac.dR()) && (j != 3)) {
        this.tj = localac;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label113;
      }
      dq();
      return true;
      i += 1;
      break;
    }
    label113:
    if (this.tf == null) {
      return false;
    }
    boolean bool2 = this.tf.cP();
    boolean bool3 = this.tf.cQ();
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
    this.lA.addMovement(paramMotionEvent);
    j = paramMotionEvent.getActionMasked();
    i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.kD != 1) {
        return false;
      }
      break;
    case 0: 
      label216:
      if (this.tq) {
        this.tq = false;
      }
      this.tD = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.tG = i;
      this.tE = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.tH = i;
      this.tF = i;
      if (this.kD == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        z(1);
      }
      if (!bool2) {}
      break;
    }
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool3) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      break label216;
      this.tD = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.tG = j;
      this.tE = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.tH = i;
      this.tF = i;
      break label216;
      j = paramMotionEvent.findPointerIndex(this.tD);
      if (j < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.tD + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      j = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.kD == 1) {
        break label216;
      }
      i -= this.tE;
      m = j - this.tF;
      int n;
      if ((bool2) && (Math.abs(i) > this.kl))
      {
        j = this.tE;
        n = this.kl;
        if (i < 0)
        {
          i = -1;
          label517:
          this.tG = (i * n + j);
        }
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool3)
        {
          j = i;
          if (Math.abs(m) > this.kl)
          {
            j = this.tF;
            n = this.kl;
            if (m >= 0) {
              break label614;
            }
          }
        }
        label614:
        for (i = k;; i = 1)
        {
          this.tH = (j + i * n);
          j = 1;
          if (j == 0) {
            break;
          }
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          z(1);
          break;
          i = 1;
          break label517;
        }
        e(paramMotionEvent);
        break label216;
        this.lA.clear();
        stopNestedScroll();
        break label216;
        dq();
        break label216;
        break;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    di();
    android.support.v4.os.f.beginSection("RV OnLayout");
    dy();
    android.support.v4.os.f.endSection();
    o(false);
    this.tm = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.ts)
    {
      di();
      dx();
      if (ak.l(this.tM))
      {
        ak.b(this.tM, true);
        this.ts = false;
        o(false);
      }
    }
    else
    {
      if (this.te == null) {
        break label107;
      }
      this.tM.uS = this.te.getItemCount();
      label65:
      if (this.tf != null) {
        break label118;
      }
      D(paramInt1, paramInt2);
    }
    for (;;)
    {
      ak.b(this.tM, false);
      return;
      this.ta.cD();
      ak.b(this.tM, false);
      break;
      label107:
      this.tM.uS = 0;
      break label65;
      label118:
      this.tf.uk.D(paramInt1, paramInt2);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.sZ = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.sZ.getSuperState());
    if ((this.tf != null) && (this.sZ.uB != null)) {
      this.tf.onRestoreInstanceState(this.sZ.uB);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.sZ != null)
    {
      RecyclerView.SavedState.a(localSavedState, this.sZ);
      return localSavedState;
    }
    if (this.tf != null)
    {
      localSavedState.uB = this.tf.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.uB = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      jdMethod_do();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.tp) || (this.tq)) {}
    label133:
    label142:
    label148:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.tj != null)
      {
        if (i == 0) {
          this.tj = null;
        }
      }
      else
      {
        if (i == 0) {
          break label142;
        }
        j = this.ti.size();
        i = 0;
        if (i >= j) {
          break label142;
        }
        localObject = (ac)this.ti.get(i);
        if (!((ac)localObject).dR()) {
          break label133;
        }
        this.tj = ((ac)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label148;
        }
        dq();
        return true;
        if ((i == 3) || (i == 1)) {
          this.tj = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.tf == null);
    boolean bool1 = this.tf.cP();
    boolean bool2 = this.tf.cQ();
    if (this.lA == null) {
      this.lA = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.tX;
      this.tX[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.tX[0], this.tX[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.lA.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.tD = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.tG = i;
      this.tE = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.tH = i;
      this.tF = i;
      if (!bool1) {
        break;
      }
    }
    label775:
    label914:
    label932:
    label1069:
    for (i = 1;; i = 0)
    {
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      i = i2;
      break;
      this.tD = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.tG = i;
      this.tE = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.tH = i;
      this.tF = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.tD);
      if (i < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.tD + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.tG - i3;
      k = this.tH - i4;
      i = k;
      j = m;
      if (dispatchNestedPreScroll(m, k, this.pi, this.ph))
      {
        j = m - this.pi[0];
        i = k - this.pi[1];
        ((MotionEvent)localObject).offsetLocation(this.ph[0], this.ph[1]);
        paramMotionEvent = this.tX;
        paramMotionEvent[0] += this.ph[0];
        paramMotionEvent = this.tX;
        paramMotionEvent[1] += this.ph[1];
      }
      k = i;
      m = j;
      if (this.kD != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.kl)) {
          break label1069;
        }
        if (j <= 0) {
          break label902;
        }
        j -= this.kl;
      }
      label725:
      for (k = 1;; k = 0)
      {
        int n = i;
        int i1 = k;
        if (bool2)
        {
          n = i;
          i1 = k;
          if (Math.abs(i) > this.kl)
          {
            if (i <= 0) {
              break label914;
            }
            n = i - this.kl;
            i1 = 1;
          }
        }
        k = n;
        m = j;
        if (i1 != 0)
        {
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          z(1);
          m = j;
          k = n;
        }
        i = i2;
        if (this.kD != 1) {
          break;
        }
        this.tG = (i3 - this.ph[0]);
        this.tH = (i4 - this.ph[1]);
        if (bool1) {
          label863:
          if (!bool2) {
            break label932;
          }
        }
        for (;;)
        {
          i = i2;
          if (!a(m, k, (MotionEvent)localObject)) {
            break;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          i = i2;
          break;
          j += this.kl;
          break label725;
          n = i + this.kl;
          break label775;
          m = 0;
          break label863;
          k = 0;
        }
        e(paramMotionEvent);
        i = i2;
        break;
        this.lA.addMovement((MotionEvent)localObject);
        this.lA.computeCurrentVelocity(1000, this.tJ);
        float f1;
        if (bool1)
        {
          f1 = -this.lA.getXVelocity(this.tD);
          label992:
          if (!bool2) {
            break label1053;
          }
        }
        for (float f2 = -this.lA.getYVelocity(this.tD);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!A((int)f1, (int)f2))) {
            z(0);
          }
          dp();
          i = 1;
          break;
          f1 = 0.0F;
          break label992;
        }
        dq();
        i = i2;
        break;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    an localan = ai(paramView);
    if (localan != null)
    {
      if (!localan.ep()) {
        break label32;
      }
      localan.el();
    }
    label32:
    while (localan.ef())
    {
      am(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localan);
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    int i;
    Object localObject;
    if ((this.tf.dN()) || (du()))
    {
      i = 1;
      if ((i == 0) && (paramView2 != null))
      {
        this.kd.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        localObject = paramView2.getLayoutParams();
        if ((localObject instanceof RecyclerView.LayoutParams))
        {
          localObject = (RecyclerView.LayoutParams)localObject;
          if (!((RecyclerView.LayoutParams)localObject).up)
          {
            localObject = ((RecyclerView.LayoutParams)localObject).rY;
            Rect localRect = this.kd;
            localRect.left -= ((Rect)localObject).left;
            localRect = this.kd;
            localRect.right += ((Rect)localObject).right;
            localRect = this.kd;
            localRect.top -= ((Rect)localObject).top;
            localRect = this.kd;
            i = localRect.bottom;
            localRect.bottom = (((Rect)localObject).bottom + i);
          }
        }
        offsetDescendantRectToMyCoords(paramView2, this.kd);
        offsetRectIntoDescendantCoords(paramView1, this.kd);
        localObject = this.kd;
        if (this.tm) {
          break label226;
        }
      }
    }
    label226:
    for (boolean bool = true;; bool = false)
    {
      requestChildRectangleOnScreen(paramView1, (Rect)localObject, bool);
      super.requestChildFocus(paramView1, paramView2);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    ab localab = this.tf;
    int i2 = localab.getPaddingLeft();
    int m = localab.getPaddingTop();
    int i3 = localab.getWidth() - localab.getPaddingRight();
    int i1 = localab.getHeight();
    int i6 = localab.getPaddingBottom();
    int i4 = paramView.getLeft() + paramRect.left;
    int n = paramView.getTop() + paramRect.top;
    int i5 = i4 + paramRect.width();
    int i7 = paramRect.height();
    int i = Math.min(0, i4 - i2);
    int j = Math.min(0, n - m);
    int k = Math.max(0, i5 - i3);
    i1 = Math.max(0, n + i7 - (i1 - i6));
    if (r.i(localab.uk) == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label222;
        }
        label160:
        if ((i == 0) && (j == 0)) {
          break label314;
        }
        if (!paramBoolean) {
          break label237;
        }
        scrollBy(i, j);
      }
    }
    for (;;)
    {
      return true;
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      i = Math.min(i4 - i2, k);
      break;
      label222:
      j = Math.min(n - m, i1);
      break label160;
      label237:
      if (this.tf == null)
      {
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      }
      else if (!this.tp)
      {
        if (!this.tf.cP()) {
          i = 0;
        }
        if (!this.tf.cQ()) {
          j = 0;
        }
        if ((i != 0) || (j != 0)) {
          this.tL.smoothScrollBy(i, j);
        }
      }
    }
    label314:
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.ti.size();
    int i = 0;
    while (i < j)
    {
      this.ti.get(i);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.tn) && (!this.tp))
    {
      super.requestLayout();
      return;
    }
    this.to = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.tf == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.tp);
      bool1 = this.tf.cP();
      bool2 = this.tf.cQ();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label74;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label74:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    if (du()) {
      if (paramAccessibilityEvent == null) {
        break label52;
      }
    }
    label52:
    for (i = android.support.v4.view.a.a.b(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.tr = (i | this.tr);
        i = 1;
        if (i != 0) {
          return;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.tc) {
      jdMethod_do();
    }
    this.tc = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.tm) {
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.tW.setNestedScrollingEnabled(paramBoolean);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    if (this.tp) {
      return;
    }
    if (this.tf == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.tf.a(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.tW.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.tW.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */