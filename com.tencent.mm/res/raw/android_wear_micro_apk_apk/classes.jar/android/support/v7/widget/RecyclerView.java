package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.h;
import android.support.v4.view.j;
import android.support.v4.view.r;
import android.support.v4.widget.i;
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
  implements h
{
  private static final boolean uL;
  private static final Class<?>[] uM;
  private static final Interpolator vP;
  private final Rect ma;
  private int mi;
  private int mz;
  private VelocityTracker nw;
  private final int[] qX;
  private final int[] qY;
  private final ah uN;
  final af uO;
  private RecyclerView.SavedState uP;
  a uQ;
  d uR;
  private boolean uS;
  private final Runnable uT;
  private t uU;
  private ab uV;
  private ag uW;
  private final ArrayList<Object> uX;
  private final ArrayList<ac> uY;
  private ac uZ;
  private float vA;
  private final am vB;
  final ak vC;
  private ad vD;
  private List<ad> vE;
  boolean vF;
  boolean vG;
  private y vH;
  private boolean vI;
  private ao vJ;
  private w vK;
  private final int[] vL;
  private final j vM;
  private final int[] vN;
  private Runnable vO;
  private boolean va;
  private boolean vb;
  private boolean vc;
  private boolean vd;
  private boolean ve;
  private boolean vf;
  private boolean vg;
  private int vh;
  private boolean vi;
  private final boolean vj;
  private final AccessibilityManager vk;
  private List<Object> vl;
  private boolean vm;
  private int vn;
  private i vo;
  private i vp;
  private i vq;
  private i vr;
  x vs;
  private int vt;
  private int vu;
  private int vv;
  private int vw;
  private int vx;
  private final int vy;
  private final int vz;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20)) {}
    for (boolean bool = true;; bool = false)
    {
      uL = bool;
      uM = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      vP = new Interpolator()
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
    //   17: putfield 170	android/support/v7/widget/RecyclerView:uN	Landroid/support/v7/widget/ah;
    //   20: aload_0
    //   21: new 172	android/support/v7/widget/af
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 175	android/support/v7/widget/af:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   29: putfield 177	android/support/v7/widget/RecyclerView:uO	Landroid/support/v7/widget/af;
    //   32: aload_0
    //   33: new 8	android/support/v7/widget/RecyclerView$1
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 178	android/support/v7/widget/RecyclerView$1:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   41: putfield 180	android/support/v7/widget/RecyclerView:uT	Ljava/lang/Runnable;
    //   44: aload_0
    //   45: new 182	android/graphics/Rect
    //   48: dup
    //   49: invokespecial 183	android/graphics/Rect:<init>	()V
    //   52: putfield 185	android/support/v7/widget/RecyclerView:ma	Landroid/graphics/Rect;
    //   55: aload_0
    //   56: new 187	java/util/ArrayList
    //   59: dup
    //   60: invokespecial 188	java/util/ArrayList:<init>	()V
    //   63: putfield 190	android/support/v7/widget/RecyclerView:uX	Ljava/util/ArrayList;
    //   66: aload_0
    //   67: new 187	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 188	java/util/ArrayList:<init>	()V
    //   74: putfield 192	android/support/v7/widget/RecyclerView:uY	Ljava/util/ArrayList;
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 194	android/support/v7/widget/RecyclerView:vm	Z
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 196	android/support/v7/widget/RecyclerView:vn	I
    //   87: aload_0
    //   88: new 198	android/support/v7/widget/g
    //   91: dup
    //   92: invokespecial 199	android/support/v7/widget/g:<init>	()V
    //   95: putfield 201	android/support/v7/widget/RecyclerView:vs	Landroid/support/v7/widget/x;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 203	android/support/v7/widget/RecyclerView:mz	I
    //   103: aload_0
    //   104: iconst_m1
    //   105: putfield 205	android/support/v7/widget/RecyclerView:vt	I
    //   108: aload_0
    //   109: ldc 206
    //   111: putfield 208	android/support/v7/widget/RecyclerView:vA	F
    //   114: aload_0
    //   115: new 210	android/support/v7/widget/am
    //   118: dup
    //   119: aload_0
    //   120: invokespecial 211	android/support/v7/widget/am:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   123: putfield 213	android/support/v7/widget/RecyclerView:vB	Landroid/support/v7/widget/am;
    //   126: aload_0
    //   127: new 215	android/support/v7/widget/ak
    //   130: dup
    //   131: invokespecial 216	android/support/v7/widget/ak:<init>	()V
    //   134: putfield 218	android/support/v7/widget/RecyclerView:vC	Landroid/support/v7/widget/ak;
    //   137: aload_0
    //   138: iconst_0
    //   139: putfield 220	android/support/v7/widget/RecyclerView:vF	Z
    //   142: aload_0
    //   143: iconst_0
    //   144: putfield 222	android/support/v7/widget/RecyclerView:vG	Z
    //   147: aload_0
    //   148: new 224	android/support/v7/widget/z
    //   151: dup
    //   152: aload_0
    //   153: iconst_0
    //   154: invokespecial 225	android/support/v7/widget/z:<init>	(Landroid/support/v7/widget/RecyclerView;B)V
    //   157: putfield 227	android/support/v7/widget/RecyclerView:vH	Landroid/support/v7/widget/y;
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 229	android/support/v7/widget/RecyclerView:vI	Z
    //   165: aload_0
    //   166: iconst_2
    //   167: newarray int
    //   169: putfield 231	android/support/v7/widget/RecyclerView:vL	[I
    //   172: aload_0
    //   173: iconst_2
    //   174: newarray int
    //   176: putfield 233	android/support/v7/widget/RecyclerView:qX	[I
    //   179: aload_0
    //   180: iconst_2
    //   181: newarray int
    //   183: putfield 235	android/support/v7/widget/RecyclerView:qY	[I
    //   186: aload_0
    //   187: iconst_2
    //   188: newarray int
    //   190: putfield 237	android/support/v7/widget/RecyclerView:vN	[I
    //   193: aload_0
    //   194: new 10	android/support/v7/widget/RecyclerView$2
    //   197: dup
    //   198: aload_0
    //   199: invokespecial 238	android/support/v7/widget/RecyclerView$2:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   202: putfield 240	android/support/v7/widget/RecyclerView:vO	Ljava/lang/Runnable;
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
    //   229: putfield 249	android/support/v7/widget/RecyclerView:vj	Z
    //   232: aload_1
    //   233: invokestatic 255	android/view/ViewConfiguration:get	(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   236: astore 5
    //   238: aload_0
    //   239: aload 5
    //   241: invokevirtual 259	android/view/ViewConfiguration:getScaledTouchSlop	()I
    //   244: putfield 261	android/support/v7/widget/RecyclerView:mi	I
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 264	android/view/ViewConfiguration:getScaledMinimumFlingVelocity	()I
    //   253: putfield 266	android/support/v7/widget/RecyclerView:vy	I
    //   256: aload_0
    //   257: aload 5
    //   259: invokevirtual 269	android/view/ViewConfiguration:getScaledMaximumFlingVelocity	()I
    //   262: putfield 271	android/support/v7/widget/RecyclerView:vz	I
    //   265: aload_0
    //   266: invokestatic 277	android/support/v4/view/r:d	(Landroid/view/View;)I
    //   269: iconst_2
    //   270: if_icmpne +315 -> 585
    //   273: iconst_1
    //   274: istore 4
    //   276: aload_0
    //   277: iload 4
    //   279: invokevirtual 280	android/support/v7/widget/RecyclerView:setWillNotDraw	(Z)V
    //   282: aload_0
    //   283: getfield 201	android/support/v7/widget/RecyclerView:vs	Landroid/support/v7/widget/x;
    //   286: aload_0
    //   287: getfield 227	android/support/v7/widget/RecyclerView:vH	Landroid/support/v7/widget/y;
    //   290: invokevirtual 286	android/support/v7/widget/x:a	(Landroid/support/v7/widget/y;)V
    //   293: aload_0
    //   294: new 288	android/support/v7/widget/a
    //   297: dup
    //   298: new 16	android/support/v7/widget/RecyclerView$5
    //   301: dup
    //   302: aload_0
    //   303: invokespecial 289	android/support/v7/widget/RecyclerView$5:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   306: invokespecial 292	android/support/v7/widget/a:<init>	(Landroid/support/v7/widget/b;)V
    //   309: putfield 294	android/support/v7/widget/RecyclerView:uQ	Landroid/support/v7/widget/a;
    //   312: aload_0
    //   313: new 296	android/support/v7/widget/d
    //   316: dup
    //   317: new 14	android/support/v7/widget/RecyclerView$4
    //   320: dup
    //   321: aload_0
    //   322: invokespecial 297	android/support/v7/widget/RecyclerView$4:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   325: invokespecial 300	android/support/v7/widget/d:<init>	(Landroid/support/v7/widget/f;)V
    //   328: putfield 302	android/support/v7/widget/RecyclerView:uR	Landroid/support/v7/widget/d;
    //   331: aload_0
    //   332: invokestatic 305	android/support/v4/view/r:h	(Landroid/view/View;)I
    //   335: ifne +8 -> 343
    //   338: aload_0
    //   339: iconst_1
    //   340: invokestatic 309	android/support/v4/view/r:f	(Landroid/view/View;I)V
    //   343: aload_0
    //   344: aload_0
    //   345: invokevirtual 313	android/support/v7/widget/RecyclerView:getContext	()Landroid/content/Context;
    //   348: ldc_w 315
    //   351: invokevirtual 319	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   354: checkcast 321	android/view/accessibility/AccessibilityManager
    //   357: putfield 323	android/support/v7/widget/RecyclerView:vk	Landroid/view/accessibility/AccessibilityManager;
    //   360: aload_0
    //   361: new 325	android/support/v7/widget/ao
    //   364: dup
    //   365: aload_0
    //   366: invokespecial 326	android/support/v7/widget/ao:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   369: putfield 328	android/support/v7/widget/RecyclerView:vJ	Landroid/support/v7/widget/ao;
    //   372: aload_0
    //   373: aload_0
    //   374: getfield 328	android/support/v7/widget/RecyclerView:vJ	Landroid/support/v7/widget/ao;
    //   377: invokestatic 331	android/support/v4/view/r:a	(Landroid/view/View;Landroid/support/v4/view/a;)V
    //   380: aload_2
    //   381: ifnull +180 -> 561
    //   384: aload_1
    //   385: aload_2
    //   386: getstatic 336	android/support/v7/a/b:sL	[I
    //   389: iload_3
    //   390: iconst_0
    //   391: invokevirtual 340	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   394: astore 5
    //   396: aload 5
    //   398: getstatic 343	android/support/v7/a/b:sM	I
    //   401: invokevirtual 349	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   404: astore 6
    //   406: aload 5
    //   408: invokevirtual 352	android/content/res/TypedArray:recycle	()V
    //   411: aload 6
    //   413: ifnull +148 -> 561
    //   416: aload 6
    //   418: invokevirtual 358	java/lang/String:trim	()Ljava/lang/String;
    //   421: astore 5
    //   423: aload 5
    //   425: invokevirtual 361	java/lang/String:length	()I
    //   428: ifeq +133 -> 561
    //   431: aload 5
    //   433: iconst_0
    //   434: invokevirtual 365	java/lang/String:charAt	(I)C
    //   437: bipush 46
    //   439: if_icmpne +152 -> 591
    //   442: new 367	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   449: aload_1
    //   450: invokevirtual 371	android/content/Context:getPackageName	()Ljava/lang/String;
    //   453: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: aload 5
    //   458: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: astore 5
    //   466: aload_0
    //   467: invokevirtual 382	android/support/v7/widget/RecyclerView:isInEditMode	()Z
    //   470: ifeq +171 -> 641
    //   473: aload_0
    //   474: invokevirtual 388	java/lang/Object:getClass	()Ljava/lang/Class;
    //   477: invokevirtual 392	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   480: astore 6
    //   482: aload 6
    //   484: aload 5
    //   486: invokevirtual 398	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   489: ldc_w 400
    //   492: invokevirtual 404	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   495: astore 8
    //   497: aload 8
    //   499: getstatic 137	android/support/v7/widget/RecyclerView:uM	[Ljava/lang/Class;
    //   502: invokevirtual 408	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   505: astore 6
    //   507: iconst_4
    //   508: anewarray 384	java/lang/Object
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
    //   527: invokestatic 412	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: aload 7
    //   533: iconst_3
    //   534: iconst_0
    //   535: invokestatic 412	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: aload 7
    //   541: astore_1
    //   542: aload 6
    //   544: iconst_1
    //   545: invokevirtual 417	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   548: aload_0
    //   549: aload 6
    //   551: aload_1
    //   552: invokevirtual 421	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   555: checkcast 400	android/support/v7/widget/ab
    //   558: invokevirtual 424	android/support/v7/widget/RecyclerView:a	(Landroid/support/v7/widget/ab;)V
    //   561: aload_0
    //   562: new 426	android/support/v4/view/j
    //   565: dup
    //   566: aload_0
    //   567: invokespecial 429	android/support/v4/view/j:<init>	(Landroid/view/View;)V
    //   570: putfield 431	android/support/v7/widget/RecyclerView:vM	Landroid/support/v4/view/j;
    //   573: aload_0
    //   574: iconst_1
    //   575: invokevirtual 434	android/support/v7/widget/RecyclerView:setNestedScrollingEnabled	(Z)V
    //   578: return
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -356 -> 226
    //   585: iconst_0
    //   586: istore 4
    //   588: goto -312 -> 276
    //   591: aload 5
    //   593: ldc_w 436
    //   596: invokevirtual 440	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   599: ifeq +6 -> 605
    //   602: goto -136 -> 466
    //   605: new 367	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   612: ldc 2
    //   614: invokevirtual 444	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   617: invokevirtual 449	java/lang/Package:getName	()Ljava/lang/String;
    //   620: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: bipush 46
    //   625: invokevirtual 452	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   628: aload 5
    //   630: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: astore 5
    //   638: goto -172 -> 466
    //   641: aload_1
    //   642: invokevirtual 453	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   645: astore 6
    //   647: goto -165 -> 482
    //   650: astore_1
    //   651: aload 8
    //   653: iconst_0
    //   654: anewarray 125	java/lang/Class
    //   657: invokevirtual 408	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   660: astore 6
    //   662: aconst_null
    //   663: astore_1
    //   664: goto -122 -> 542
    //   667: astore 6
    //   669: aload 6
    //   671: aload_1
    //   672: invokevirtual 457	java/lang/NoSuchMethodException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   675: pop
    //   676: new 459	java/lang/IllegalStateException
    //   679: dup
    //   680: new 367	java/lang/StringBuilder
    //   683: dup
    //   684: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   687: aload_2
    //   688: invokeinterface 462 1 0
    //   693: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 464
    //   699: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 5
    //   704: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: aload 6
    //   712: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   715: athrow
    //   716: astore_1
    //   717: new 459	java/lang/IllegalStateException
    //   720: dup
    //   721: new 367	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   728: aload_2
    //   729: invokeinterface 462 1 0
    //   734: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: ldc_w 469
    //   740: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 5
    //   745: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: aload_1
    //   752: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   755: athrow
    //   756: astore_1
    //   757: new 459	java/lang/IllegalStateException
    //   760: dup
    //   761: new 367	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   768: aload_2
    //   769: invokeinterface 462 1 0
    //   774: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 471
    //   780: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload 5
    //   785: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: aload_1
    //   792: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   795: athrow
    //   796: astore_1
    //   797: new 459	java/lang/IllegalStateException
    //   800: dup
    //   801: new 367	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   808: aload_2
    //   809: invokeinterface 462 1 0
    //   814: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: ldc_w 471
    //   820: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 5
    //   825: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: aload_1
    //   832: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   835: athrow
    //   836: astore_1
    //   837: new 459	java/lang/IllegalStateException
    //   840: dup
    //   841: new 367	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   848: aload_2
    //   849: invokeinterface 462 1 0
    //   854: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: ldc_w 473
    //   860: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 5
    //   865: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: aload_1
    //   872: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   875: athrow
    //   876: astore_1
    //   877: new 459	java/lang/IllegalStateException
    //   880: dup
    //   881: new 367	java/lang/StringBuilder
    //   884: dup
    //   885: invokespecial 368	java/lang/StringBuilder:<init>	()V
    //   888: aload_2
    //   889: invokeinterface 462 1 0
    //   894: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: ldc_w 475
    //   900: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: aload 5
    //   905: invokevirtual 375	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: aload_1
    //   912: invokespecial 467	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
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
  
  private void C(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.vo != null)
    {
      bool1 = bool2;
      if (!this.vo.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = this.vo.cn();
        }
      }
    }
    bool2 = bool1;
    if (this.vq != null)
    {
      bool2 = bool1;
      if (!this.vq.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | this.vq.cn();
        }
      }
    }
    bool1 = bool2;
    if (this.vp != null)
    {
      bool1 = bool2;
      if (!this.vp.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | this.vp.cn();
        }
      }
    }
    bool2 = bool1;
    if (this.vr != null)
    {
      bool2 = bool1;
      if (!this.vr.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | this.vr.cn();
        }
      }
    }
    if (bool2) {
      r.g(this);
    }
  }
  
  private void E(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (j)
    {
    default: 
      paramInt1 = r.n(this);
    }
    switch (i)
    {
    default: 
      paramInt2 = r.o(this);
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  private boolean F(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    int j = this.uR.getChildCount();
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
      an localan = ap(this.uR.getChildAt(i));
      if (!localan.eu())
      {
        int k = localan.ev();
        if ((k < paramInt1) || (k > paramInt2)) {
          return true;
        }
      }
      i += 1;
    }
  }
  
  private void K(int paramInt)
  {
    if (paramInt == this.mz) {}
    for (;;)
    {
      return;
      this.mz = paramInt;
      if (paramInt != 2) {
        ds();
      }
      if (this.uV != null) {
        this.uV.aA(paramInt);
      }
      if (this.vD != null) {
        this.vD.aB(paramInt);
      }
      if (this.vE != null)
      {
        int i = this.vE.size() - 1;
        while (i >= 0)
        {
          ((ad)this.vE.get(i)).aB(paramInt);
          i -= 1;
        }
      }
    }
  }
  
  private void a(android.support.v4.b.a<View, Rect> parama)
  {
    List localList = this.vC.wF;
    int i = localList.size() - 1;
    if (i >= 0)
    {
      View localView = (View)localList.get(i);
      an localan = ap(localView);
      aa localaa = (aa)this.vC.wC.remove(localan);
      if (!this.vC.em()) {
        this.vC.wD.remove(localan);
      }
      if (parama.remove(localView) != null) {
        this.uV.a(localView, this.uO);
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
    View localView = paramaa.tF.wT;
    e(paramaa.tF);
    int i = paramaa.left;
    int j = paramaa.top;
    int k = localView.getLeft();
    int m = localView.getTop();
    if ((!paramaa.tF.isRemoved()) && ((i != k) || (j != m)))
    {
      paramaa.tF.s(false);
      localView.layout(k, m, localView.getWidth() + k, localView.getHeight() + m);
      if (this.vs.a(paramaa.tF, i, j, k, m)) {
        dH();
      }
      return;
    }
    paramaa.tF.s(false);
    this.vs.a(paramaa.tF);
    dH();
  }
  
  private void a(an paraman, Rect paramRect, int paramInt1, int paramInt2)
  {
    if ((paramRect != null) && ((paramRect.left != paramInt1) || (paramRect.top != paramInt2)))
    {
      paraman.s(false);
      if (this.vs.a(paraman, paramRect.left, paramRect.top, paramInt1, paramInt2)) {
        dH();
      }
      return;
    }
    paraman.s(false);
    this.vs.b(paraman);
    dH();
  }
  
  private void a(an paraman1, an paraman2)
  {
    paraman1.s(false);
    e(paraman1);
    paraman1.wY = paraman2;
    this.uO.r(paraman1);
    int k = paraman1.wT.getLeft();
    int m = paraman1.wT.getTop();
    int j;
    int i;
    if ((paraman2 == null) || (paraman2.eu()))
    {
      j = m;
      i = k;
    }
    for (;;)
    {
      this.vs.a(paraman1, paraman2, k, m, i, j);
      dH();
      return;
      i = paraman2.wT.getLeft();
      j = paraman2.wT.getTop();
      paraman2.s(false);
      paraman2.wZ = paraman1;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int i = 0;
    int j = 0;
    int n = 0;
    int k = 0;
    int i1 = 0;
    int m = 0;
    dq();
    if (this.uU != null)
    {
      dr();
      dB();
      android.support.v4.os.f.beginSection("RV Scroll");
      if (paramInt1 != 0)
      {
        j = this.uV.a(paramInt1, this.uO, this.vC);
        i = paramInt1 - j;
        if (paramInt2 != 0)
        {
          m = this.uV.b(paramInt2, this.uO, this.vC);
          k = paramInt2 - m;
        }
        android.support.v4.os.f.endSection();
        if (dG())
        {
          i1 = this.uR.getChildCount();
          n = 0;
          if (n < i1)
          {
            View localView = this.uR.getChildAt(n);
            Object localObject = af(localView);
            if ((localObject != null) && (((an)localObject).wZ != null))
            {
              localObject = ((an)localObject).wZ;
              if (localObject == null) {
                break label252;
              }
            }
            label252:
            for (localObject = ((an)localObject).wT;; localObject = null)
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
        dC();
        r(false);
      }
    }
    for (;;)
    {
      if (!this.uX.isEmpty()) {
        invalidate();
      }
      if (dispatchNestedScroll(j, m, i, k, this.qX))
      {
        this.vw -= this.qX[0];
        this.vx -= this.qX[1];
        if (paramMotionEvent != null) {
          paramMotionEvent.offsetLocation(this.qX[0], this.qX[1]);
        }
        paramMotionEvent = this.vN;
        paramMotionEvent[0] += this.qX[0];
        paramMotionEvent = this.vN;
        paramMotionEvent[1] += this.qX[1];
      }
      for (;;)
      {
        if ((j != 0) || (m != 0)) {
          aw(m);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((j == 0) && (m == 0)) {
          break;
        }
        return true;
        if (r.d(this) != 2)
        {
          if (paramMotionEvent != null) {
            b(paramMotionEvent.getX(), i, paramMotionEvent.getY(), k);
          }
          C(paramInt1, paramInt2);
        }
      }
      return false;
      n = 0;
      i = j;
      j = n;
      break;
      m = 0;
      j = i1;
      k = n;
    }
  }
  
  static an ap(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).wd;
  }
  
  @Deprecated
  public static int aq(View paramView)
  {
    paramView = ap(paramView);
    if ((paramView != null) && (paramView.xg != null))
    {
      Object localObject = paramView.xg;
      if ((paramView.aK(524)) || (!paramView.isBound())) {
        i = -1;
      }
      int j;
      int n;
      int m;
      do
      {
        return i;
        localObject = ((RecyclerView)localObject).uQ;
        j = paramView.un;
        n = ((a)localObject).sO.size();
        m = 0;
        i = j;
      } while (m >= n);
      paramView = (c)((a)localObject).sO.get(m);
      int i = j;
      switch (paramView.bU)
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
        if (paramView.sU <= j)
        {
          i = j + paramView.sW;
          continue;
          i = j;
          if (paramView.sU <= j)
          {
            if (paramView.sU + paramView.sW > j) {
              break label241;
            }
            i = j - paramView.sW;
            continue;
            if (paramView.sU == j)
            {
              i = paramView.sW;
            }
            else
            {
              int k = j;
              if (paramView.sU < j) {
                k = j - 1;
              }
              i = k;
              if (paramView.sW <= k) {
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
  
  public static int ar(View paramView)
  {
    paramView = ap(paramView);
    if (paramView != null) {
      return paramView.ev();
    }
    return -1;
  }
  
  private void at(View paramView)
  {
    ap(paramView);
    if (this.vl != null)
    {
      int i = this.vl.size() - 1;
      while (i >= 0)
      {
        this.vl.get(i);
        i -= 1;
      }
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    int i = 0;
    if (paramFloat2 < 0.0F)
    {
      du();
      this.vo.b(-paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
      i = 1;
      if (paramFloat4 >= 0.0F) {
        break label144;
      }
      dw();
      this.vp.b(-paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    for (;;)
    {
      if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
        r.g(this);
      }
      return;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      dv();
      this.vq.b(paramFloat2 / getWidth(), paramFloat3 / getHeight());
      i = 1;
      break;
      label144:
      if (paramFloat4 > 0.0F)
      {
        dx();
        this.vr.b(paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
        i = j;
      }
    }
  }
  
  private void b(int[] paramArrayOfInt)
  {
    int i2 = this.uR.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int i = 2147483647;
    int k = -2147483648;
    int n = 0;
    int m;
    int j;
    if (n < i2)
    {
      an localan = ap(this.uR.getChildAt(n));
      m = i;
      if (localan.eu()) {
        break label122;
      }
      int i1 = localan.ev();
      j = i;
      if (i1 < i) {
        j = i1;
      }
      m = j;
      if (i1 <= k) {
        break label122;
      }
      i = j;
      j = i1;
    }
    for (;;)
    {
      n += 1;
      k = j;
      break;
      paramArrayOfInt[0] = i;
      paramArrayOfInt[1] = k;
      return;
      label122:
      j = k;
      i = m;
    }
  }
  
  private void dA()
  {
    dz();
    K(0);
  }
  
  private void dB()
  {
    this.vn += 1;
  }
  
  private void dC()
  {
    this.vn -= 1;
    if (this.vn <= 0)
    {
      this.vn = 0;
      dE();
    }
  }
  
  private void dE()
  {
    int i = this.vh;
    this.vh = 0;
    if ((i != 0) && (dD()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      android.support.v4.view.a.a.a(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private boolean dF()
  {
    return this.vn > 0;
  }
  
  private boolean dG()
  {
    return (this.vs != null) && (this.vs.dY());
  }
  
  private void dH()
  {
    if ((!this.vI) && (this.va))
    {
      r.b(this, this.vO);
      this.vI = true;
    }
  }
  
  private boolean dI()
  {
    return (this.vs != null) && (this.uV.cT());
  }
  
  private void dJ()
  {
    boolean bool2 = true;
    if (this.vm)
    {
      this.uQ.reset();
      dP();
      this.uV.cR();
    }
    int i;
    label88:
    ak localak;
    if ((this.vs != null) && (this.uV.cT()))
    {
      this.uQ.cH();
      if (((!this.vF) || (this.vG)) && (!this.vF) && ((!this.vG) || (!dG()))) {
        break label209;
      }
      i = 1;
      localak = this.vC;
      if ((!this.vc) || (this.vs == null) || ((!this.vm) && (i == 0) && (!ab.b(this.uV))) || ((this.vm) && (!this.uU.hasStableIds()))) {
        break label214;
      }
      bool1 = true;
      label148:
      ak.c(localak, bool1);
      localak = this.vC;
      if ((!ak.m(this.vC)) || (i == 0) || (this.vm) || (!dI())) {
        break label219;
      }
    }
    label209:
    label214:
    label219:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ak.d(localak, bool1);
      return;
      this.uQ.cK();
      break;
      i = 0;
      break label88;
      bool1 = false;
      break label148;
    }
  }
  
  private void dL()
  {
    int j = 0;
    int k = this.uR.cM();
    int i = 0;
    while (i < k)
    {
      ((RecyclerView.LayoutParams)this.uR.am(i).getLayoutParams()).we = true;
      i += 1;
    }
    af localaf = this.uO;
    k = localaf.wl.size();
    i = j;
    while (i < k)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((an)localaf.wl.get(i)).wT.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.we = true;
      }
      i += 1;
    }
  }
  
  private void dM()
  {
    int j = this.uR.cM();
    int i = 0;
    while (i < j)
    {
      an localan = ap(this.uR.am(i));
      if (!localan.eu()) {
        localan.et();
      }
      i += 1;
    }
  }
  
  private void dN()
  {
    int j = this.uR.cM();
    int i = 0;
    while (i < j)
    {
      an localan = ap(this.uR.am(i));
      if (!localan.eu()) {
        localan.es();
      }
      i += 1;
    }
    this.uO.dN();
  }
  
  private void dP()
  {
    int j = this.uR.cM();
    int i = 0;
    while (i < j)
    {
      an localan = ap(this.uR.am(i));
      if ((localan != null) && (!localan.eu())) {
        localan.addFlags(6);
      }
      i += 1;
    }
    dL();
    this.uO.dP();
  }
  
  private void dq()
  {
    this.uT.run();
  }
  
  private void ds()
  {
    this.vB.stop();
    if (this.uV != null) {
      this.uV.ed();
    }
  }
  
  private void dt()
  {
    boolean bool2 = false;
    if (this.vo != null) {
      bool2 = this.vo.cn();
    }
    boolean bool1 = bool2;
    if (this.vp != null) {
      bool1 = bool2 | this.vp.cn();
    }
    bool2 = bool1;
    if (this.vq != null) {
      bool2 = bool1 | this.vq.cn();
    }
    bool1 = bool2;
    if (this.vr != null) {
      bool1 = bool2 | this.vr.cn();
    }
    if (bool1) {
      r.g(this);
    }
  }
  
  private void du()
  {
    if (this.vo != null) {
      return;
    }
    this.vo = new i(getContext());
    if (this.uS)
    {
      this.vo.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.vo.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void dv()
  {
    if (this.vq != null) {
      return;
    }
    this.vq = new i(getContext());
    if (this.uS)
    {
      this.vq.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.vq.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  private void dw()
  {
    if (this.vp != null) {
      return;
    }
    this.vp = new i(getContext());
    if (this.uS)
    {
      this.vp.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.vp.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void dx()
  {
    if (this.vr != null) {
      return;
    }
    this.vr = new i(getContext());
    if (this.uS)
    {
      this.vr.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.vr.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  private void dy()
  {
    this.vr = null;
    this.vp = null;
    this.vq = null;
    this.vo = null;
  }
  
  private void dz()
  {
    if (this.nw != null) {
      this.nw.clear();
    }
    stopNestedScroll();
    dt();
  }
  
  private void e(an paraman)
  {
    View localView = paraman.wT;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      this.uO.r(af(localView));
      if (!paraman.eE()) {
        break;
      }
      this.uR.a(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.uR.ab(localView);
      return;
    }
    this.uR.ad(localView);
  }
  
  private long f(an paraman)
  {
    if (this.uU.hasStableIds()) {
      return paraman.wV;
    }
    return paraman.un;
  }
  
  private void f(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.vt) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      this.vt = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.vw = j;
      this.vu = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.vx = i;
      this.vv = i;
      return;
    }
  }
  
  public boolean B(int paramInt1, int paramInt2)
  {
    if (this.uV == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    int i;
    do
    {
      do
      {
        return false;
      } while (this.vf);
      bool1 = this.uV.cX();
      bool2 = this.uV.cY();
      if (bool1)
      {
        i = paramInt1;
        if (Math.abs(paramInt1) >= this.vy) {}
      }
      else
      {
        i = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= this.vy) {}
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
      paramInt2 = Math.max(-this.vz, Math.min(i, this.vz));
      paramInt1 = Math.max(-this.vz, Math.min(paramInt1, this.vz));
      this.vB.H(paramInt2, paramInt1);
      return true;
    }
  }
  
  final void D(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      du();
      this.vo.W(-paramInt1);
      if (paramInt2 >= 0) {
        break label69;
      }
      dw();
      this.vp.W(-paramInt2);
    }
    for (;;)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        r.g(this);
      }
      return;
      if (paramInt1 <= 0) {
        break;
      }
      dv();
      this.vq.W(paramInt1);
      break;
      label69:
      if (paramInt2 > 0)
      {
        dx();
        this.vr.W(paramInt2);
      }
    }
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.uR.cM();
    int i = 0;
    if (i < j)
    {
      localObject = ap(this.uR.am(i));
      if ((localObject != null) && (!((an)localObject).eu()))
      {
        if (((an)localObject).un < paramInt1 + paramInt2) {
          break label83;
        }
        ((an)localObject).e(-paramInt2, paramBoolean);
        ak.a(this.vC, true);
      }
      for (;;)
      {
        i += 1;
        break;
        label83:
        if (((an)localObject).un >= paramInt1)
        {
          int k = -paramInt2;
          ((an)localObject).addFlags(8);
          ((an)localObject).e(k, paramBoolean);
          ((an)localObject).un = (paramInt1 - 1);
          ak.a(this.vC, true);
        }
      }
    }
    Object localObject = this.uO;
    i = ((af)localObject).wl.size() - 1;
    if (i >= 0)
    {
      an localan = (an)((af)localObject).wl.get(i);
      if (localan != null)
      {
        if (localan.ev() < paramInt1 + paramInt2) {
          break label202;
        }
        localan.e(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label202:
        if (localan.ev() >= paramInt1)
        {
          localan.addFlags(8);
          ((af)localObject).aG(i);
        }
      }
    }
    requestLayout();
  }
  
  public final void a(ab paramab)
  {
    if (paramab == this.uV) {
      return;
    }
    if (this.uV != null)
    {
      if (this.va) {
        this.uV.b(this, this.uO);
      }
      this.uV.r(null);
    }
    this.uO.clear();
    this.uR.cL();
    this.uV = paramab;
    if (paramab != null)
    {
      if (paramab.wa != null) {
        throw new IllegalArgumentException("LayoutManager " + paramab + " is already attached to a RecyclerView: " + paramab.wa);
      }
      this.uV.r(this);
      if (this.va) {
        this.uV.ea();
      }
    }
    requestLayout();
  }
  
  @Deprecated
  public final void a(ad paramad)
  {
    this.vD = paramad;
  }
  
  public void a(t paramt)
  {
    if (this.vf)
    {
      f("Do not setLayoutFrozen in layout or scroll");
      this.vf = false;
      if ((this.ve) && (this.uV != null) && (this.uU != null)) {
        requestLayout();
      }
      this.ve = false;
    }
    if (this.uU != null) {
      this.uU.b(this.uN);
    }
    if (this.vs != null) {
      this.vs.cQ();
    }
    if (this.uV != null)
    {
      this.uV.d(this.uO);
      this.uV.c(this.uO);
    }
    this.uO.clear();
    this.uQ.reset();
    t localt1 = this.uU;
    this.uU = paramt;
    if (paramt != null) {
      paramt.a(this.uN);
    }
    if (this.uV != null) {
      this.uV.ec();
    }
    paramt = this.uO;
    t localt2 = this.uU;
    paramt.clear();
    paramt.ei().a(localt1, localt2, false);
    ak.a(this.vC, true);
    dP();
    requestLayout();
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  public an af(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return ap(paramView);
  }
  
  final Rect as(View paramView)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.we) {
      return localLayoutParams.tO;
    }
    Rect localRect1 = localLayoutParams.tO;
    localRect1.set(0, 0, 0, 0);
    int j = this.uX.size();
    int i = 0;
    while (i < j)
    {
      this.ma.set(0, 0, 0, 0);
      this.uX.get(i);
      Rect localRect2 = this.ma;
      paramView.getLayoutParams();
      localRect2.set(0, 0, 0, 0);
      localRect1.left += this.ma.left;
      localRect1.top += this.ma.top;
      localRect1.right += this.ma.right;
      localRect1.bottom += this.ma.bottom;
      i += 1;
    }
    localLayoutParams.we = false;
    return localRect1;
  }
  
  final void aw(int paramInt)
  {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (this.vD != null) {
      this.vD.aC(paramInt);
    }
    if (this.vE != null)
    {
      i = this.vE.size() - 1;
      while (i >= 0)
      {
        ((ad)this.vE.get(i)).aC(paramInt);
        i -= 1;
      }
    }
  }
  
  final void b(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = this.uR.cM();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = this.uR.am(i);
      an localan = ap((View)localObject);
      if ((localan != null) && (!localan.eu()) && (localan.un >= paramInt1) && (localan.un < paramInt1 + paramInt2))
      {
        localan.addFlags(2);
        localan.z(paramObject);
        if (dG()) {
          localan.addFlags(64);
        }
        ((RecyclerView.LayoutParams)((View)localObject).getLayoutParams()).we = true;
      }
      i += 1;
    }
    paramObject = this.uO;
    i = paramObject.wl.size() - 1;
    while (i >= 0)
    {
      localObject = (an)paramObject.wl.get(i);
      if (localObject != null)
      {
        j = ((an)localObject).ev();
        if ((j >= paramInt1) && (j < paramInt1 + paramInt2))
        {
          ((an)localObject).addFlags(2);
          paramObject.aG(i);
        }
      }
      i -= 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof RecyclerView.LayoutParams)) && (this.uV.a((RecyclerView.LayoutParams)paramLayoutParams));
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (this.uV.cX()) {
      return this.uV.e(this.vC);
    }
    return 0;
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (this.uV.cX()) {
      return this.uV.c(this.vC);
    }
    return 0;
  }
  
  public int computeHorizontalScrollRange()
  {
    if (this.uV.cX()) {
      return this.uV.g(this.vC);
    }
    return 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    if (this.uV.cY()) {
      return this.uV.f(this.vC);
    }
    return 0;
  }
  
  public int computeVerticalScrollOffset()
  {
    if (this.uV.cY()) {
      return this.uV.d(this.vC);
    }
    return 0;
  }
  
  public int computeVerticalScrollRange()
  {
    if (this.uV.cY()) {
      return this.uV.h(this.vC);
    }
    return 0;
  }
  
  final boolean dD()
  {
    return (this.vk != null) && (this.vk.isEnabled());
  }
  
  final void dK()
  {
    if (this.uU == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.uV == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.vC.wF.clear();
    dr();
    dB();
    dJ();
    Object localObject2 = this.vC;
    if ((ak.m(this.vC)) && (this.vG) && (dG())) {}
    int i;
    for (Object localObject1 = new android.support.v4.b.a();; localObject1 = null)
    {
      ((ak)localObject2).wE = ((android.support.v4.b.a)localObject1);
      this.vG = false;
      this.vF = false;
      ak.b(this.vC, ak.l(this.vC));
      this.vC.wH = this.uU.getItemCount();
      b(this.vL);
      if (!ak.m(this.vC)) {
        break;
      }
      this.vC.wC.clear();
      this.vC.wD.clear();
      j = this.uR.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject1 = ap(this.uR.getChildAt(i));
        if ((!((an)localObject1).eu()) && ((!((an)localObject1).eB()) || (this.uU.hasStableIds())))
        {
          localObject2 = ((an)localObject1).wT;
          this.vC.wC.put(localObject1, new aa((an)localObject1, ((View)localObject2).getLeft(), ((View)localObject2).getTop(), ((View)localObject2).getRight(), ((View)localObject2).getBottom()));
        }
        i += 1;
      }
    }
    long l;
    boolean bool;
    if (ak.l(this.vC))
    {
      dM();
      if (this.vC.wE != null)
      {
        j = this.uR.getChildCount();
        i = 0;
        while (i < j)
        {
          localObject1 = ap(this.uR.getChildAt(i));
          if ((((an)localObject1).eD()) && (!((an)localObject1).isRemoved()) && (!((an)localObject1).eu()))
          {
            l = f((an)localObject1);
            this.vC.wE.put(Long.valueOf(l), localObject1);
            this.vC.wC.remove(localObject1);
          }
          i += 1;
        }
      }
      bool = ak.n(this.vC);
      ak.a(this.vC, false);
      this.uV.c(this.uO, this.vC);
      ak.a(this.vC, bool);
      localObject2 = new android.support.v4.b.a();
      i = 0;
      label473:
      if (i < this.uR.getChildCount())
      {
        localObject1 = this.uR.getChildAt(i);
        if (!ap((View)localObject1).eu())
        {
          j = 0;
          label507:
          if (j >= this.vC.wC.size()) {
            break label1656;
          }
          if (((an)this.vC.wC.keyAt(j)).wT != localObject1) {
            break label591;
          }
        }
      }
    }
    label591:
    label732:
    label742:
    label1650:
    label1656:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        ((android.support.v4.b.a)localObject2).put(localObject1, new Rect(((View)localObject1).getLeft(), ((View)localObject1).getTop(), ((View)localObject1).getRight(), ((View)localObject1).getBottom()));
      }
      i += 1;
      break label473;
      j += 1;
      break label507;
      dN();
      this.uQ.cI();
      for (;;)
      {
        this.vC.wH = this.uU.getItemCount();
        ak.o(this.vC);
        ak.b(this.vC, false);
        this.uV.c(this.uO, this.vC);
        ak.a(this.vC, false);
        this.uP = null;
        localObject1 = this.vC;
        Object localObject3;
        Object localObject4;
        if ((ak.m(this.vC)) && (this.vs != null))
        {
          bool = true;
          ak.c((ak)localObject1, bool);
          if (!ak.m(this.vC)) {
            break label1531;
          }
          if (this.vC.wE == null) {
            break label946;
          }
          localObject1 = new android.support.v4.b.a();
          j = this.uR.getChildCount();
          i = 0;
          if (i >= j) {
            break label997;
          }
          localObject3 = ap(this.uR.getChildAt(i));
          if (!((an)localObject3).eu())
          {
            localObject4 = ((an)localObject3).wT;
            l = f((an)localObject3);
            if ((localObject1 == null) || (this.vC.wE.get(Long.valueOf(l)) == null)) {
              break label952;
            }
            ((android.support.v4.b.a)localObject1).put(Long.valueOf(l), localObject3);
          }
        }
        for (;;)
        {
          i += 1;
          break label742;
          dN();
          this.uQ.cK();
          if (this.vC.wE == null) {
            break label1650;
          }
          j = this.uR.getChildCount();
          i = 0;
          while (i < j)
          {
            localObject1 = ap(this.uR.getChildAt(i));
            if ((((an)localObject1).eD()) && (!((an)localObject1).isRemoved()) && (!((an)localObject1).eu()))
            {
              l = f((an)localObject1);
              this.vC.wE.put(Long.valueOf(l), localObject1);
              this.vC.wC.remove(localObject1);
            }
            i += 1;
          }
          bool = false;
          break;
          localObject1 = null;
          break label732;
          this.vC.wD.put(localObject3, new aa((an)localObject3, ((View)localObject4).getLeft(), ((View)localObject4).getTop(), ((View)localObject4).getRight(), ((View)localObject4).getBottom()));
        }
        a((android.support.v4.b.a)localObject2);
        i = this.vC.wC.size() - 1;
        while (i >= 0)
        {
          localObject3 = (an)this.vC.wC.keyAt(i);
          if (!this.vC.wD.containsKey(localObject3))
          {
            localObject3 = (aa)this.vC.wC.valueAt(i);
            this.vC.wC.removeAt(i);
            this.uO.r(((aa)localObject3).tF);
            a((aa)localObject3);
          }
          i -= 1;
        }
        i = this.vC.wD.size();
        if (i > 0)
        {
          i -= 1;
          if (i >= 0)
          {
            localObject4 = (an)this.vC.wD.keyAt(i);
            aa localaa = (aa)this.vC.wD.valueAt(i);
            if ((this.vC.wC.isEmpty()) || (!this.vC.wC.containsKey(localObject4)))
            {
              this.vC.wD.removeAt(i);
              if (localObject2 == null) {
                break label1244;
              }
            }
            for (localObject3 = (Rect)((android.support.v4.b.a)localObject2).get(((an)localObject4).wT);; localObject3 = null)
            {
              a((an)localObject4, (Rect)localObject3, localaa.left, localaa.top);
              i -= 1;
              break;
            }
          }
        }
        j = this.vC.wD.size();
        i = 0;
        while (i < j)
        {
          localObject2 = (an)this.vC.wD.keyAt(i);
          localObject3 = (aa)this.vC.wD.valueAt(i);
          localObject4 = (aa)this.vC.wC.get(localObject2);
          if ((localObject4 != null) && (localObject3 != null) && ((((aa)localObject4).left != ((aa)localObject3).left) || (((aa)localObject4).top != ((aa)localObject3).top)))
          {
            ((an)localObject2).s(false);
            if (this.vs.a((an)localObject2, ((aa)localObject4).left, ((aa)localObject4).top, ((aa)localObject3).left, ((aa)localObject3).top)) {
              dH();
            }
          }
          i += 1;
        }
        if (this.vC.wE != null) {}
        for (i = this.vC.wE.size();; i = 0)
        {
          i -= 1;
          while (i >= 0)
          {
            l = ((Long)this.vC.wE.keyAt(i)).longValue();
            localObject2 = (an)this.vC.wE.get(Long.valueOf(l));
            if ((!((an)localObject2).eu()) && (af.e(this.uO) != null) && (af.e(this.uO).contains(localObject2))) {
              a((an)localObject2, (an)((android.support.v4.b.a)localObject1).get(Long.valueOf(l)));
            }
            i -= 1;
          }
        }
        label1531:
        r(false);
        this.uV.c(this.uO);
        ak.b(this.vC, this.vC.wH);
        this.vm = false;
        ak.c(this.vC, false);
        ak.d(this.vC, false);
        dC();
        ab.c(this.uV);
        if (af.e(this.uO) != null) {
          af.e(this.uO).clear();
        }
        this.vC.wE = null;
        if (!F(this.vL[0], this.vL[1])) {
          break;
        }
        aw(0);
        return;
        localObject2 = null;
      }
    }
  }
  
  final void dO()
  {
    int j = this.uR.getChildCount();
    int i = 0;
    if (i < j)
    {
      an localan = ap(this.uR.getChildAt(i));
      if ((localan != null) && (!localan.eu()))
      {
        if ((!localan.isRemoved()) && (!localan.eB())) {
          break label63;
        }
        requestLayout();
      }
      for (;;)
      {
        i += 1;
        break;
        label63:
        if (localan.eC())
        {
          if (localan.wW != 0) {
            break label113;
          }
          if ((!localan.eD()) || (!dG())) {
            this.uU.b(localan, localan.un);
          } else {
            requestLayout();
          }
        }
      }
      label113:
      requestLayout();
    }
  }
  
  public final boolean dQ()
  {
    return (!this.vc) || (this.vm) || (this.uQ.cJ());
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.vM.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.vM.dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.vM.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.vM.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public final void dm()
  {
    this.vb = true;
  }
  
  public final t dn()
  {
    return this.uU;
  }
  
  public final ab jdMethod_do()
  {
    return this.uV;
  }
  
  public final int dp()
  {
    return this.mz;
  }
  
  final void dr()
  {
    if (!this.vd)
    {
      this.vd = true;
      if (!this.vf) {
        this.ve = false;
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    int m = 0;
    super.draw(paramCanvas);
    int j = this.uX.size();
    int i = 0;
    while (i < j)
    {
      this.uX.get(i);
      i += 1;
    }
    int n;
    if ((this.vo != null) && (!this.vo.isFinished()))
    {
      n = paramCanvas.save();
      if (this.uS)
      {
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(i + -getHeight(), 0.0F);
        if ((this.vo == null) || (!this.vo.draw(paramCanvas))) {
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
      if (this.vp != null)
      {
        i = j;
        if (!this.vp.isFinished())
        {
          n = paramCanvas.save();
          if (this.uS) {
            paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          }
          if ((this.vp == null) || (!this.vp.draw(paramCanvas))) {
            break label450;
          }
          i = 1;
          label191:
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      j = i;
      if (this.vq != null)
      {
        j = i;
        if (!this.vq.isFinished())
        {
          n = paramCanvas.save();
          int i1 = getWidth();
          if (!this.uS) {
            break label455;
          }
          j = getPaddingTop();
          label246:
          paramCanvas.rotate(90.0F);
          paramCanvas.translate(-j, -i1);
          if ((this.vq == null) || (!this.vq.draw(paramCanvas))) {
            break label460;
          }
          j = 1;
          label284:
          j = i | j;
          paramCanvas.restoreToCount(n);
        }
      }
      i = j;
      if (this.vr != null)
      {
        i = j;
        if (!this.vr.isFinished())
        {
          n = paramCanvas.save();
          paramCanvas.rotate(180.0F);
          if (!this.uS) {
            break label465;
          }
          paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
          label361:
          i = m;
          if (this.vr != null)
          {
            i = m;
            if (this.vr.draw(paramCanvas)) {
              i = 1;
            }
          }
          i = j | i;
          paramCanvas.restoreToCount(n);
        }
      }
      if ((i == 0) && (this.vs != null) && (this.uX.size() > 0) && (this.vs.isRunning())) {
        i = k;
      }
      for (;;)
      {
        if (i != 0) {
          r.g(this);
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
  
  final void f(String paramString)
  {
    if (dF())
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
      if (this.uU != null)
      {
        localView1 = localView2;
        if (this.uV != null)
        {
          localView1 = localView2;
          if (!dF())
          {
            localView1 = localView2;
            if (!this.vf)
            {
              dr();
              localView1 = this.uV.d(paramInt, this.uO, this.vC);
              r(false);
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
    if (this.uV == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.uV.cS();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.uV == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.uV.a(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.uV == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return this.uV.a(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    if (this.uV != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.vK == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.vK.dT();
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.vM.hasNestedScrollingParent();
  }
  
  public boolean isAttachedToWindow()
  {
    return this.va;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.vM.isNestedScrollingEnabled();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.vn = 0;
    this.va = true;
    this.vc = false;
    if (this.uV != null) {
      this.uV.ea();
    }
    this.vI = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.vs != null) {
      this.vs.cQ();
    }
    this.vc = false;
    K(0);
    ds();
    this.va = false;
    if (this.uV != null) {
      this.uV.b(this, this.uO);
    }
    removeCallbacks(this.vO);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.uX.size();
    int i = 0;
    while (i < j)
    {
      this.uX.get(i);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    if (this.uV == null) {}
    label170:
    label173:
    for (;;)
    {
      return false;
      if ((!this.vf) && ((paramMotionEvent.getSource() & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (this.uV.cY())
        {
          f1 = -paramMotionEvent.getAxisValue(9);
          if (!this.uV.cX()) {
            break label170;
          }
        }
        for (float f2 = paramMotionEvent.getAxisValue(10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label173;
          }
          if (this.vA == 1.4E-45F)
          {
            TypedValue localTypedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
              this.vA = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
            }
          }
          else
          {
            f3 = this.vA;
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
    if (this.vf)
    {
      bool1 = false;
      return bool1;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.uZ = null;
    }
    int m = this.uY.size();
    int i = 0;
    if (i < m)
    {
      ac localac = (ac)this.uY.get(i);
      if ((localac.ef()) && (j != 3)) {
        this.uZ = localac;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label113;
      }
      dA();
      return true;
      i += 1;
      break;
    }
    label113:
    if (this.uV == null) {
      return false;
    }
    boolean bool2 = this.uV.cX();
    boolean bool3 = this.uV.cY();
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
    this.nw.addMovement(paramMotionEvent);
    j = paramMotionEvent.getActionMasked();
    i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      if (this.mz != 1) {
        return false;
      }
      break;
    case 0: 
      label216:
      if (this.vg) {
        this.vg = false;
      }
      this.vt = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.vw = i;
      this.vu = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.vx = i;
      this.vv = i;
      if (this.mz == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        K(1);
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
      this.vt = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.vw = j;
      this.vu = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.vx = i;
      this.vv = i;
      break label216;
      j = paramMotionEvent.findPointerIndex(this.vt);
      if (j < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.vt + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      j = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mz == 1) {
        break label216;
      }
      i -= this.vu;
      m = j - this.vv;
      int n;
      if ((bool2) && (Math.abs(i) > this.mi))
      {
        j = this.vu;
        n = this.mi;
        if (i < 0)
        {
          i = -1;
          label517:
          this.vw = (i * n + j);
        }
      }
      for (i = 1;; i = 0)
      {
        j = i;
        if (bool3)
        {
          j = i;
          if (Math.abs(m) > this.mi)
          {
            j = this.vv;
            n = this.mi;
            if (m >= 0) {
              break label614;
            }
          }
        }
        label614:
        for (i = k;; i = 1)
        {
          this.vx = (j + i * n);
          j = 1;
          if (j == 0) {
            break;
          }
          paramMotionEvent = getParent();
          if (paramMotionEvent != null) {
            paramMotionEvent.requestDisallowInterceptTouchEvent(true);
          }
          K(1);
          break;
          i = 1;
          break label517;
        }
        f(paramMotionEvent);
        break label216;
        this.nw.clear();
        stopNestedScroll();
        break label216;
        dA();
        break label216;
        break;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    dr();
    android.support.v4.os.f.beginSection("RV OnLayout");
    dK();
    android.support.v4.os.f.endSection();
    r(false);
    this.vc = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.vi)
    {
      dr();
      dJ();
      if (ak.l(this.vC))
      {
        ak.b(this.vC, true);
        this.vi = false;
        r(false);
      }
    }
    else
    {
      if (this.uU == null) {
        break label107;
      }
      this.vC.wH = this.uU.getItemCount();
      label65:
      if (this.uV != null) {
        break label118;
      }
      E(paramInt1, paramInt2);
    }
    for (;;)
    {
      ak.b(this.vC, false);
      return;
      this.uQ.cK();
      ak.b(this.vC, false);
      break;
      label107:
      this.vC.wH = 0;
      break label65;
      label118:
      this.uV.wa.E(paramInt1, paramInt2);
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.uP = ((RecyclerView.SavedState)paramParcelable);
    super.onRestoreInstanceState(this.uP.getSuperState());
    if ((this.uV != null) && (this.uP.wq != null)) {
      this.uV.onRestoreInstanceState(this.uP.wq);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    RecyclerView.SavedState localSavedState = new RecyclerView.SavedState(super.onSaveInstanceState());
    if (this.uP != null)
    {
      RecyclerView.SavedState.a(localSavedState, this.uP);
      return localSavedState;
    }
    if (this.uV != null)
    {
      localSavedState.wq = this.uV.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.wq = null;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      dy();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 0;
    if ((this.vf) || (this.vg)) {}
    label133:
    label142:
    label148:
    do
    {
      return false;
      i = paramMotionEvent.getAction();
      if (this.uZ != null)
      {
        if (i == 0) {
          this.uZ = null;
        }
      }
      else
      {
        if (i == 0) {
          break label142;
        }
        j = this.uY.size();
        i = 0;
        if (i >= j) {
          break label142;
        }
        localObject = (ac)this.uY.get(i);
        if (!((ac)localObject).ef()) {
          break label133;
        }
        this.uZ = ((ac)localObject);
        i = 1;
      }
      for (;;)
      {
        if (i == 0) {
          break label148;
        }
        dA();
        return true;
        if ((i == 3) || (i == 1)) {
          this.uZ = null;
        }
        i = 1;
        continue;
        i += 1;
        break;
        i = 0;
      }
    } while (this.uV == null);
    boolean bool1 = this.uV.cX();
    boolean bool2 = this.uV.cY();
    if (this.nw == null) {
      this.nw = VelocityTracker.obtain();
    }
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    if (k == 0)
    {
      int[] arrayOfInt = this.vN;
      this.vN[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(this.vN[0], this.vN[1]);
    int i = i2;
    switch (k)
    {
    default: 
      i = i2;
    case 4: 
      if (i == 0) {
        this.nw.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
    case 0: 
      this.vt = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.vw = i;
      this.vu = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.vx = i;
      this.vv = i;
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
      this.vt = paramMotionEvent.getPointerId(j);
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      this.vw = i;
      this.vu = i;
      i = (int)(paramMotionEvent.getY(j) + 0.5F);
      this.vx = i;
      this.vv = i;
      i = i2;
      break;
      i = paramMotionEvent.findPointerIndex(this.vt);
      if (i < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.vt + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
      int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
      int m = this.vw - i3;
      k = this.vx - i4;
      i = k;
      j = m;
      if (dispatchNestedPreScroll(m, k, this.qY, this.qX))
      {
        j = m - this.qY[0];
        i = k - this.qY[1];
        ((MotionEvent)localObject).offsetLocation(this.qX[0], this.qX[1]);
        paramMotionEvent = this.vN;
        paramMotionEvent[0] += this.qX[0];
        paramMotionEvent = this.vN;
        paramMotionEvent[1] += this.qX[1];
      }
      k = i;
      m = j;
      if (this.mz != 1)
      {
        if ((!bool1) || (Math.abs(j) <= this.mi)) {
          break label1069;
        }
        if (j <= 0) {
          break label902;
        }
        j -= this.mi;
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
          if (Math.abs(i) > this.mi)
          {
            if (i <= 0) {
              break label914;
            }
            n = i - this.mi;
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
          K(1);
          m = j;
          k = n;
        }
        i = i2;
        if (this.mz != 1) {
          break;
        }
        this.vw = (i3 - this.qX[0]);
        this.vx = (i4 - this.qX[1]);
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
          j += this.mi;
          break label725;
          n = i + this.mi;
          break label775;
          m = 0;
          break label863;
          k = 0;
        }
        f(paramMotionEvent);
        i = i2;
        break;
        this.nw.addMovement((MotionEvent)localObject);
        this.nw.computeCurrentVelocity(1000, this.vz);
        float f1;
        if (bool1)
        {
          f1 = -this.nw.getXVelocity(this.vt);
          label992:
          if (!bool2) {
            break label1053;
          }
        }
        for (float f2 = -this.nw.getYVelocity(this.vt);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!B((int)f1, (int)f2))) {
            K(0);
          }
          dz();
          i = 1;
          break;
          f1 = 0.0F;
          break label992;
        }
        dA();
        i = i2;
        break;
      }
    }
  }
  
  final void r(boolean paramBoolean)
  {
    if (this.vd)
    {
      if ((paramBoolean) && (this.ve) && (!this.vf) && (this.uV != null) && (this.uU != null)) {
        dK();
      }
      this.vd = false;
      if (!this.vf) {
        this.ve = false;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    an localan = ap(paramView);
    if (localan != null)
    {
      if (!localan.eE()) {
        break label32;
      }
      localan.eA();
    }
    label32:
    while (localan.eu())
    {
      at(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached.".concat(String.valueOf(localan)));
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    int i;
    Object localObject;
    if ((this.uV.eb()) || (dF()))
    {
      i = 1;
      if ((i == 0) && (paramView2 != null))
      {
        this.ma.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        localObject = paramView2.getLayoutParams();
        if ((localObject instanceof RecyclerView.LayoutParams))
        {
          localObject = (RecyclerView.LayoutParams)localObject;
          if (!((RecyclerView.LayoutParams)localObject).we)
          {
            localObject = ((RecyclerView.LayoutParams)localObject).tO;
            Rect localRect = this.ma;
            localRect.left -= ((Rect)localObject).left;
            localRect = this.ma;
            localRect.right += ((Rect)localObject).right;
            localRect = this.ma;
            localRect.top -= ((Rect)localObject).top;
            localRect = this.ma;
            i = localRect.bottom;
            localRect.bottom = (((Rect)localObject).bottom + i);
          }
        }
        offsetDescendantRectToMyCoords(paramView2, this.ma);
        offsetRectIntoDescendantCoords(paramView1, this.ma);
        localObject = this.ma;
        if (this.vc) {
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
    ab localab = this.uV;
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
    if (r.j(localab.wa) == 1) {
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
      if (this.uV == null)
      {
        Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      }
      else if (!this.vf)
      {
        if (!this.uV.cX()) {
          i = 0;
        }
        if (!this.uV.cY()) {
          j = 0;
        }
        if ((i != 0) || (j != 0)) {
          this.vB.smoothScrollBy(i, j);
        }
      }
    }
    label314:
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.uY.size();
    int i = 0;
    while (i < j)
    {
      this.uY.get(i);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((!this.vd) && (!this.vf))
    {
      super.requestLayout();
      return;
    }
    this.ve = true;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.uV == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (this.vf);
      bool1 = this.uV.cX();
      bool2 = this.uV.cY();
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
    if (dF())
    {
      if (paramAccessibilityEvent == null) {
        break label65;
      }
      if (Build.VERSION.SDK_INT < 19) {
        break label51;
      }
      i = paramAccessibilityEvent.getContentChangeTypes();
    }
    for (;;)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        this.vh |= i;
        i = 1;
        if (i != 0)
        {
          return;
          label51:
          i = 0;
          break;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
      label65:
      i = 0;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.uS) {
      dy();
    }
    this.uS = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.vc) {
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.vM.setNestedScrollingEnabled(paramBoolean);
  }
  
  public final void smoothScrollToPosition(int paramInt)
  {
    if (this.vf) {
      return;
    }
    if (this.uV == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.uV.a(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.vM.startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    this.vM.stopNestedScroll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * JD-Core Version:    0.7.0.1
 */