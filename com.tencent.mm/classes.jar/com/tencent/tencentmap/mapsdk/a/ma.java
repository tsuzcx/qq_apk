package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.basemap.data.b;
import com.tencent.map.lib.e;
import com.tencent.map.lib.f;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.util.d;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.opengles.GL10;

public class ma
  extends ly
  implements com.tencent.map.lib.listener.a, ah.f
{
  private static final String L = ma.class.getSimpleName();
  public int A = 0;
  public int B = 0;
  public int C = 0;
  public int D = 0;
  public int E = 0;
  public ah.a F = null;
  public ah.d G = null;
  public float H = 0.5F;
  public float I = 0.5F;
  public float J = 0.5F;
  public float K = 0.5F;
  private String M = "";
  private boolean N = false;
  private mt.a O = null;
  private ArrayList<ln> P = new ArrayList();
  private List<ln> Q = new ArrayList();
  private List<ln> R = new ArrayList();
  private List<ln> S = new ArrayList();
  private List<ln> T = new ArrayList();
  private ot U;
  private Map<Class<? extends ln>, pg> V = new HashMap();
  private List<nw> W = null;
  private ah.k aA = null;
  private int aB = 0;
  private AtomicBoolean aC = new AtomicBoolean(false);
  private Comparator<ln> aD = new ma.1(this);
  private e aE = new ma.b(this);
  private final jp aF = new ma.c(this);
  private boolean aG = true;
  private boolean aH = true;
  private volatile boolean aI = false;
  private volatile boolean aJ = false;
  private int aK = 0;
  private final iq aL = new ma.d(this);
  private final Handler aM = new ma.a(this);
  private Handler aN;
  private Bitmap.Config aO = Bitmap.Config.RGB_565;
  private boolean aP = true;
  private nv.a aQ = null;
  private int aR = -2147483648;
  private int aS = -2147483648;
  private int aT = -2147483648;
  private int aU = -2147483648;
  private GeoPoint aV = null;
  private boolean aW = false;
  private long aX = 9223372036854775807L;
  private final jl aY = new ma.2(this);
  private is aZ = new ma.e(this);
  private ah.e aa = null;
  private float ab = 100.0F;
  private float ac = 100.0F;
  private boolean ad = true;
  private nd ae = null;
  private mj af;
  private boolean ag = false;
  private ms ah;
  private mq ai;
  private ah.f aj;
  private int ak = 10;
  private com.tencent.map.lib.basemap.data.a al;
  private int am = 0;
  private int an = 0;
  private boolean ao = false;
  private qp ap = null;
  private ol aq;
  private boolean ar = true;
  private boolean as = true;
  private boolean at = true;
  private boolean au = true;
  private boolean av = true;
  private boolean aw = true;
  private int ax = 19;
  private int ay = 3;
  private pm az = null;
  private boolean ba = false;
  public final byte[] e = new byte[0];
  public ll f = null;
  public lt g = null;
  public lt h = null;
  public lt i = null;
  public lt j = null;
  public pq k = null;
  public ah.h l = null;
  public oa.a m = null;
  public ah.c n = null;
  public ah.j o = null;
  public volatile ah.i p = null;
  public boolean q = false;
  public ll r = null;
  public ah.l s = null;
  public ah.g t = null;
  protected volatile py u;
  public Handler v = null;
  public qc w = null;
  public qc x = null;
  public int y = 0;
  public int z = 0;
  
  public ma(Context paramContext, ai paramai)
  {
    super(paramContext, paramai);
    mh.a(paramContext);
    this.ax = ok.a(getMap().c());
    this.ay = getMap().b();
    a(this.aY);
    getMap().a(this.aF);
    getMap().a(this.aZ);
    getMap().a(this.aE);
    getMap().a(this.aL);
    getMap().a(this);
    if (this.v == null) {
      this.v = new Handler();
    }
    paramContext = (WindowManager)getContext().getSystemService("window");
    this.D = paramContext.getDefaultDisplay().getWidth();
    this.E = paramContext.getDefaultDisplay().getHeight();
    this.az = new pm(this);
    this.az.a(new ma.f(this));
    this.ae = new nd(this);
    if (paramai != null)
    {
      this.aW = paramai.c();
      this.q = paramai.g();
    }
  }
  
  private boolean a(ln paramln, float paramFloat1, float paramFloat2)
  {
    if ((paramln == null) || (!paramln.a()) || (!paramln.n())) {
      return false;
    }
    if (!paramln.a(paramFloat1, paramFloat2)) {
      return false;
    }
    pg localpg = (pg)this.V.get(paramln.getClass());
    if (localpg != null) {
      return localpg.a(paramln, true, getMap().t().a(new DoublePoint(paramFloat1, paramFloat2)));
    }
    return false;
  }
  
  private void b(GL10 paramGL10)
  {
    int i3 = this.D;
    int i4 = this.E;
    int[] arrayOfInt1 = new int[i3 * i4];
    int[] arrayOfInt2 = new int[i3 * i4];
    IntBuffer localIntBuffer = IntBuffer.wrap(arrayOfInt1);
    localIntBuffer.position(0);
    paramGL10.glReadPixels(0, 0, i3, i4, 6408, 5121, localIntBuffer);
    int i1 = 0;
    while (i1 < i4)
    {
      int i2 = 0;
      while (i2 < i3)
      {
        int i5 = arrayOfInt1[(i1 * i3 + i2)];
        arrayOfInt2[((i4 - i1 - 1) * i3 + i2)] = (i5 & 0xFF00FF00 | i5 << 16 & 0xFF0000 | i5 >> 16 & 0xFF);
        i2 += 1;
      }
      i1 += 1;
    }
    try
    {
      paramGL10 = Bitmap.createBitmap(arrayOfInt2, i3, i4, this.aO);
      this.aN.sendMessage(this.aN.obtainMessage(0, paramGL10));
      this.aX = 9223372036854775807L;
      this.aN = null;
      return;
    }
    catch (OutOfMemoryError paramGL10)
    {
      for (;;)
      {
        paramGL10 = null;
      }
    }
  }
  
  private boolean b(float paramFloat1, float paramFloat2)
  {
    Object localObject;
    if (this.m != null)
    {
      localObject = a(paramFloat1, paramFloat2);
      if ((localObject != null) && (((String)localObject).trim().length() != 0))
      {
        this.m.a((String)localObject);
        return true;
      }
    }
    if ((this.o != null) && (this.aw))
    {
      localObject = new DoublePoint(paramFloat1, paramFloat2);
      localObject = lq.a(getMap().t().a((DoublePoint)localObject));
      this.o.a((qc)localObject);
    }
    return false;
  }
  
  private void c(GL10 paramGL10)
  {
    byte[] arrayOfByte = this.e;
    Object localObject1 = null;
    int i1;
    Object localObject2;
    try
    {
      int i2 = this.P.size();
      i1 = 0;
      if (i1 < i2)
      {
        ln localln = (ln)this.P.get(i1);
        if (localln == null) {
          break label174;
        }
        if (TextUtils.equals(localln.u(), this.M))
        {
          localObject2 = localln;
          if (!localln.a())
          {
            localObject2 = localln;
            if (!this.ao)
            {
              localln.b();
              localObject2 = localObject1;
            }
          }
        }
        else if ((localln instanceof lo))
        {
          ((lo)localln).a(getMap().B(), getMap().t(), paramGL10);
          localObject2 = localObject1;
        }
        else
        {
          localln.a(paramGL10);
          break label174;
        }
      }
      else
      {
        if (localObject1 != null) {
          localObject1.a(paramGL10);
        }
        return;
      }
    }
    finally {}
    for (;;)
    {
      i1 += 1;
      localObject1 = localObject2;
      break;
      label174:
      localObject2 = localObject1;
    }
  }
  
  /* Error */
  private boolean c(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 184	com/tencent/tencentmap/mapsdk/a/ma:e	[B
    //   4: astore 9
    //   6: aload 9
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 188	com/tencent/tencentmap/mapsdk/a/ma:M	Ljava/lang/String;
    //   13: ldc 186
    //   15: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifne +696 -> 714
    //   21: aload_0
    //   22: aload_0
    //   23: getfield 188	com/tencent/tencentmap/mapsdk/a/ma:M	Ljava/lang/String;
    //   26: invokevirtual 627	com/tencent/tencentmap/mapsdk/a/ma:a	(Ljava/lang/String;)Lcom/tencent/tencentmap/mapsdk/a/ln;
    //   29: checkcast 629	com/tencent/tencentmap/mapsdk/a/lm
    //   32: astore 7
    //   34: aload 7
    //   36: ifnull +233 -> 269
    //   39: aload 7
    //   41: getfield 631	com/tencent/tencentmap/mapsdk/a/lm:z	Lcom/tencent/tencentmap/mapsdk/a/ll;
    //   44: astore 6
    //   46: aload 7
    //   48: ifnull +653 -> 701
    //   51: aload 6
    //   53: ifnull +648 -> 701
    //   56: aload 6
    //   58: invokevirtual 635	com/tencent/tencentmap/mapsdk/a/ll:j	()Z
    //   61: ifeq +640 -> 701
    //   64: aload 6
    //   66: fload_1
    //   67: fload_2
    //   68: invokevirtual 636	com/tencent/tencentmap/mapsdk/a/ll:a	(FF)Z
    //   71: istore 4
    //   73: iload 4
    //   75: ifeq +616 -> 691
    //   78: aload 7
    //   80: getfield 639	com/tencent/tencentmap/mapsdk/a/lm:y	Lcom/tencent/tencentmap/mapsdk/a/qf;
    //   83: astore 8
    //   85: aload 6
    //   87: astore 7
    //   89: aload 8
    //   91: astore 6
    //   93: iload 4
    //   95: istore 5
    //   97: iload 4
    //   99: ifne +585 -> 684
    //   102: aload_0
    //   103: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   106: invokeinterface 642 1 0
    //   111: iconst_1
    //   112: isub
    //   113: istore_3
    //   114: iload 4
    //   116: istore 5
    //   118: iload_3
    //   119: iflt +565 -> 684
    //   122: aload_0
    //   123: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   126: iload_3
    //   127: invokeinterface 643 2 0
    //   132: checkcast 629	com/tencent/tencentmap/mapsdk/a/lm
    //   135: astore 8
    //   137: aload 8
    //   139: getfield 631	com/tencent/tencentmap/mapsdk/a/lm:z	Lcom/tencent/tencentmap/mapsdk/a/ll;
    //   142: astore 10
    //   144: aload 8
    //   146: invokevirtual 644	com/tencent/tencentmap/mapsdk/a/lm:u	()Ljava/lang/String;
    //   149: aload_0
    //   150: getfield 188	com/tencent/tencentmap/mapsdk/a/ma:M	Ljava/lang/String;
    //   153: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   156: ifne +525 -> 681
    //   159: aload 10
    //   161: ifnull +520 -> 681
    //   164: aload 10
    //   166: invokevirtual 635	com/tencent/tencentmap/mapsdk/a/ll:j	()Z
    //   169: ifeq +512 -> 681
    //   172: aload 10
    //   174: fload_1
    //   175: fload_2
    //   176: invokevirtual 636	com/tencent/tencentmap/mapsdk/a/ll:a	(FF)Z
    //   179: istore 4
    //   181: iload 4
    //   183: ifeq +92 -> 275
    //   186: aload 8
    //   188: getfield 639	com/tencent/tencentmap/mapsdk/a/lm:y	Lcom/tencent/tencentmap/mapsdk/a/qf;
    //   191: astore 6
    //   193: aload 9
    //   195: monitorexit
    //   196: iload 4
    //   198: iconst_1
    //   199: if_icmpne +91 -> 290
    //   202: aload_0
    //   203: getfield 282	com/tencent/tencentmap/mapsdk/a/ma:t	Lcom/tencent/tencentmap/mapsdk/a/ah$g;
    //   206: ifnull +61 -> 267
    //   209: aload 6
    //   211: ifnull +56 -> 267
    //   214: aload 7
    //   216: ifnull +51 -> 267
    //   219: aload 6
    //   221: invokevirtual 648	com/tencent/tencentmap/mapsdk/a/qf:l	()Z
    //   224: ifeq +43 -> 267
    //   227: aload_0
    //   228: getfield 282	com/tencent/tencentmap/mapsdk/a/ma:t	Lcom/tencent/tencentmap/mapsdk/a/ah$g;
    //   231: aload 6
    //   233: invokeinterface 653 2 0
    //   238: aload_0
    //   239: getfield 282	com/tencent/tencentmap/mapsdk/a/ma:t	Lcom/tencent/tencentmap/mapsdk/a/ah$g;
    //   242: aload 7
    //   244: getfield 655	com/tencent/tencentmap/mapsdk/a/ll:l	I
    //   247: aload 7
    //   249: getfield 657	com/tencent/tencentmap/mapsdk/a/ll:m	I
    //   252: aload 7
    //   254: getfield 659	com/tencent/tencentmap/mapsdk/a/ll:G	I
    //   257: aload 7
    //   259: getfield 661	com/tencent/tencentmap/mapsdk/a/ll:H	I
    //   262: invokeinterface 664 5 0
    //   267: iconst_1
    //   268: ireturn
    //   269: aconst_null
    //   270: astore 6
    //   272: goto -226 -> 46
    //   275: iload_3
    //   276: iconst_1
    //   277: isub
    //   278: istore_3
    //   279: goto -165 -> 114
    //   282: astore 6
    //   284: aload 9
    //   286: monitorexit
    //   287: aload 6
    //   289: athrow
    //   290: aload_0
    //   291: getfield 184	com/tencent/tencentmap/mapsdk/a/ma:e	[B
    //   294: astore 6
    //   296: aload 6
    //   298: monitorenter
    //   299: aload_0
    //   300: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   303: invokeinterface 642 1 0
    //   308: iconst_1
    //   309: isub
    //   310: istore_3
    //   311: iconst_0
    //   312: istore 4
    //   314: iload_3
    //   315: iflt +44 -> 359
    //   318: aload_0
    //   319: aload_0
    //   320: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   323: iload_3
    //   324: invokeinterface 643 2 0
    //   329: checkcast 487	com/tencent/tencentmap/mapsdk/a/ln
    //   332: fload_1
    //   333: fload_2
    //   334: invokespecial 666	com/tencent/tencentmap/mapsdk/a/ma:a	(Lcom/tencent/tencentmap/mapsdk/a/ln;FF)Z
    //   337: istore 5
    //   339: iload 5
    //   341: istore 4
    //   343: iload 5
    //   345: ifne +14 -> 359
    //   348: iload_3
    //   349: iconst_1
    //   350: isub
    //   351: istore_3
    //   352: iload 5
    //   354: istore 4
    //   356: goto -42 -> 314
    //   359: iload 4
    //   361: ifeq +17 -> 378
    //   364: aload 6
    //   366: monitorexit
    //   367: iload 4
    //   369: ireturn
    //   370: astore 7
    //   372: aload 6
    //   374: monitorexit
    //   375: aload 7
    //   377: athrow
    //   378: aload_0
    //   379: getfield 216	com/tencent/tencentmap/mapsdk/a/ma:S	Ljava/util/List;
    //   382: invokeinterface 642 1 0
    //   387: iconst_1
    //   388: isub
    //   389: istore_3
    //   390: iload_3
    //   391: iflt +44 -> 435
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 216	com/tencent/tencentmap/mapsdk/a/ma:S	Ljava/util/List;
    //   399: iload_3
    //   400: invokeinterface 643 2 0
    //   405: checkcast 487	com/tencent/tencentmap/mapsdk/a/ln
    //   408: fload_1
    //   409: fload_2
    //   410: invokespecial 666	com/tencent/tencentmap/mapsdk/a/ma:a	(Lcom/tencent/tencentmap/mapsdk/a/ln;FF)Z
    //   413: istore 5
    //   415: iload 5
    //   417: istore 4
    //   419: iload 5
    //   421: ifne +14 -> 435
    //   424: iload_3
    //   425: iconst_1
    //   426: isub
    //   427: istore_3
    //   428: iload 5
    //   430: istore 4
    //   432: goto -42 -> 390
    //   435: iload 4
    //   437: ifeq +9 -> 446
    //   440: aload 6
    //   442: monitorexit
    //   443: iload 4
    //   445: ireturn
    //   446: aload_0
    //   447: getfield 218	com/tencent/tencentmap/mapsdk/a/ma:T	Ljava/util/List;
    //   450: invokeinterface 642 1 0
    //   455: iconst_1
    //   456: isub
    //   457: istore_3
    //   458: iload 4
    //   460: istore 5
    //   462: iload_3
    //   463: iflt +40 -> 503
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 218	com/tencent/tencentmap/mapsdk/a/ma:T	Ljava/util/List;
    //   471: iload_3
    //   472: invokeinterface 643 2 0
    //   477: checkcast 487	com/tencent/tencentmap/mapsdk/a/ln
    //   480: fload_1
    //   481: fload_2
    //   482: invokespecial 666	com/tencent/tencentmap/mapsdk/a/ma:a	(Lcom/tencent/tencentmap/mapsdk/a/ln;FF)Z
    //   485: istore 4
    //   487: iload 4
    //   489: istore 5
    //   491: iload 4
    //   493: ifne +10 -> 503
    //   496: iload_3
    //   497: iconst_1
    //   498: isub
    //   499: istore_3
    //   500: goto -42 -> 458
    //   503: iload 5
    //   505: ifeq +9 -> 514
    //   508: aload 6
    //   510: monitorexit
    //   511: iload 5
    //   513: ireturn
    //   514: aload 6
    //   516: monitorexit
    //   517: aload_0
    //   518: getfield 192	com/tencent/tencentmap/mapsdk/a/ma:N	Z
    //   521: ifeq +65 -> 586
    //   524: aload_0
    //   525: getfield 184	com/tencent/tencentmap/mapsdk/a/ma:e	[B
    //   528: astore 6
    //   530: aload 6
    //   532: monitorenter
    //   533: iconst_0
    //   534: istore_3
    //   535: iload_3
    //   536: aload_0
    //   537: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   540: invokeinterface 642 1 0
    //   545: if_icmpge +38 -> 583
    //   548: aload_0
    //   549: getfield 214	com/tencent/tencentmap/mapsdk/a/ma:R	Ljava/util/List;
    //   552: iload_3
    //   553: invokeinterface 643 2 0
    //   558: checkcast 629	com/tencent/tencentmap/mapsdk/a/lm
    //   561: astore 7
    //   563: aload 7
    //   565: getfield 631	com/tencent/tencentmap/mapsdk/a/lm:z	Lcom/tencent/tencentmap/mapsdk/a/ll;
    //   568: ifnull +158 -> 726
    //   571: aload 7
    //   573: getfield 631	com/tencent/tencentmap/mapsdk/a/lm:z	Lcom/tencent/tencentmap/mapsdk/a/ll;
    //   576: iconst_0
    //   577: invokevirtual 668	com/tencent/tencentmap/mapsdk/a/ll:d	(Z)V
    //   580: goto +146 -> 726
    //   583: aload 6
    //   585: monitorexit
    //   586: aload_0
    //   587: getfield 227	com/tencent/tencentmap/mapsdk/a/ma:l	Lcom/tencent/tencentmap/mapsdk/a/ah$h;
    //   590: ifnull +53 -> 643
    //   593: aload_0
    //   594: getfield 270	com/tencent/tencentmap/mapsdk/a/ma:aw	Z
    //   597: ifeq +46 -> 643
    //   600: new 513	com/tencent/map/lib/basemap/data/DoublePoint
    //   603: dup
    //   604: fload_1
    //   605: f2d
    //   606: fload_2
    //   607: f2d
    //   608: invokespecial 516	com/tencent/map/lib/basemap/data/DoublePoint:<init>	(DD)V
    //   611: astore 6
    //   613: aload_0
    //   614: invokevirtual 405	com/tencent/tencentmap/mapsdk/a/ma:getMap	()Lcom/tencent/map/lib/f;
    //   617: invokevirtual 511	com/tencent/map/lib/f:t	()Lcom/tencent/tencentmap/mapsdk/a/iu;
    //   620: aload 6
    //   622: invokeinterface 521 2 0
    //   627: invokestatic 588	com/tencent/tencentmap/mapsdk/a/lq:a	(Lcom/tencent/map/lib/basemap/data/GeoPoint;)Lcom/tencent/tencentmap/mapsdk/a/qc;
    //   630: astore 6
    //   632: aload_0
    //   633: getfield 227	com/tencent/tencentmap/mapsdk/a/ma:l	Lcom/tencent/tencentmap/mapsdk/a/ah$h;
    //   636: aload 6
    //   638: invokeinterface 671 2 0
    //   643: aload_0
    //   644: getfield 184	com/tencent/tencentmap/mapsdk/a/ma:e	[B
    //   647: astore 6
    //   649: aload 6
    //   651: monitorenter
    //   652: aload_0
    //   653: invokevirtual 673	com/tencent/tencentmap/mapsdk/a/ma:m	()V
    //   656: aload 6
    //   658: monitorexit
    //   659: aload_0
    //   660: invokevirtual 675	com/tencent/tencentmap/mapsdk/a/ma:g	()V
    //   663: iconst_0
    //   664: ireturn
    //   665: astore 7
    //   667: aload 6
    //   669: monitorexit
    //   670: aload 7
    //   672: athrow
    //   673: astore 7
    //   675: aload 6
    //   677: monitorexit
    //   678: aload 7
    //   680: athrow
    //   681: goto -406 -> 275
    //   684: iload 5
    //   686: istore 4
    //   688: goto -495 -> 193
    //   691: aload 6
    //   693: astore 7
    //   695: aconst_null
    //   696: astore 6
    //   698: goto -605 -> 93
    //   701: aload 6
    //   703: astore 7
    //   705: aconst_null
    //   706: astore 6
    //   708: iconst_0
    //   709: istore 4
    //   711: goto -618 -> 93
    //   714: aconst_null
    //   715: astore 7
    //   717: aconst_null
    //   718: astore 6
    //   720: iconst_0
    //   721: istore 4
    //   723: goto -630 -> 93
    //   726: iload_3
    //   727: iconst_1
    //   728: iadd
    //   729: istore_3
    //   730: goto -195 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	733	0	this	ma
    //   0	733	1	paramFloat1	float
    //   0	733	2	paramFloat2	float
    //   113	617	3	i1	int
    //   71	651	4	bool1	boolean
    //   95	590	5	bool2	boolean
    //   44	227	6	localObject1	Object
    //   282	6	6	localObject2	Object
    //   32	226	7	localObject4	Object
    //   370	6	7	localObject5	Object
    //   561	11	7	locallm	lm
    //   665	6	7	localObject6	Object
    //   673	6	7	localObject7	Object
    //   693	23	7	localObject8	Object
    //   83	104	8	localObject9	Object
    //   4	281	9	arrayOfByte	byte[]
    //   142	31	10	localll	ll
    // Exception table:
    //   from	to	target	type
    //   9	34	282	finally
    //   39	46	282	finally
    //   56	73	282	finally
    //   78	85	282	finally
    //   102	114	282	finally
    //   122	159	282	finally
    //   164	181	282	finally
    //   186	193	282	finally
    //   193	196	282	finally
    //   284	287	282	finally
    //   299	311	370	finally
    //   318	339	370	finally
    //   364	367	370	finally
    //   372	375	370	finally
    //   378	390	370	finally
    //   394	415	370	finally
    //   440	443	370	finally
    //   446	458	370	finally
    //   466	487	370	finally
    //   508	511	370	finally
    //   514	517	370	finally
    //   535	580	665	finally
    //   583	586	665	finally
    //   667	670	665	finally
    //   652	659	673	finally
    //   675	678	673	finally
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.W != null)
    {
      int i2 = this.W.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ??? = (nw)this.W.get(i1);
        if (??? != null) {
          ((nw)???).a(paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    if ((this.e != null) && (this.P != null)) {
      synchronized (this.e)
      {
        Iterator localIterator = this.P.iterator();
        if (localIterator.hasNext()) {
          ((ln)localIterator.next()).t();
        }
      }
    }
  }
  
  private boolean d(float paramFloat1, float paramFloat2)
  {
    if (!this.aw) {
      return false;
    }
    return getMap().a(paramFloat1, paramFloat2);
  }
  
  private void e(float paramFloat1, float paramFloat2)
  {
    Object localObject = getMap().b(paramFloat1, paramFloat2);
    if ((localObject != null) && (1 == ((TappedElement)localObject).type) && (this.aA != null))
    {
      qe localqe = new qe();
      localqe.a = ((TappedElement)localObject).name;
      localObject = d.a(((TappedElement)localObject).pixelX, ((TappedElement)localObject).pixelY);
      if (localObject != null) {
        localqe.b = new qc(((GeoPoint)localObject).getLatitudeE6() / 1000000.0D, ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D);
      }
      this.aA.a(localqe);
    }
  }
  
  private pu getCurrentCameraPosition()
  {
    f localf = getMap();
    Object localObject = localf.f();
    if ((localObject == null) || ((this.n == null) && (this.aY == null))) {
      return null;
    }
    localObject = lq.a((GeoPoint)localObject);
    float f1 = localf.q();
    float f2 = f1;
    if (f1 < 0.0F) {
      f2 = f1 % 360.0F + 360.0F;
    }
    float f4 = localf.r();
    f1 = localf.h();
    double d = localf.k();
    float f3 = (float)(f1 + Math.log(d) / Math.log(2.0D));
    if (f3 < this.ay) {
      f1 = this.ay;
    }
    for (;;)
    {
      return pu.a().a(f1).a((qc)localObject).c(f2).b(f4).a();
      f1 = f3;
      if (f3 > ok.b(this.ax)) {
        f1 = ok.b(this.ax);
      }
    }
  }
  
  private void v()
  {
    int i1 = getMap().h();
    this.aG = true;
    this.aH = true;
    if (i1 <= this.ay) {
      this.aH = false;
    }
    for (;;)
    {
      if (this.O != null)
      {
        mt localmt = new mt();
        localmt.a = 0;
        localmt.b = this.aG;
        localmt.c = this.aH;
        this.O.a(localmt);
      }
      return;
      if (i1 >= ok.b(this.ax)) {
        this.aG = false;
      }
    }
  }
  
  private void w()
  {
    if (this.O != null)
    {
      mt localmt = new mt();
      localmt.a = 0;
      localmt.b = this.aG;
      localmt.c = this.aH;
      this.O.a(localmt);
    }
  }
  
  private boolean x()
  {
    return nb.d();
  }
  
  public ln a(String paramString)
  {
    int i2 = this.P.size();
    int i1 = 0;
    Object localObject = null;
    while (i1 < i2)
    {
      ln localln = (ln)this.P.get(i1);
      localObject = localln;
      if (localln != null)
      {
        localObject = localln;
        if (TextUtils.equals(localln.u(), paramString)) {
          break;
        }
        localObject = null;
      }
      i1 += 1;
    }
    return localObject;
  }
  
  public pg a(Class<? extends ln> paramClass)
  {
    return (pg)this.V.get(paramClass);
  }
  
  public String a(float paramFloat1, float paramFloat2)
  {
    for (;;)
    {
      int i1;
      synchronized (this.e)
      {
        i1 = this.P.size() - 1;
        if (i1 >= 0)
        {
          Object localObject1 = (ln)this.P.get(i1);
          if ((localObject1 == null) || (!((ln)localObject1).a()) || (!(localObject1 instanceof lm)) || (!((ln)localObject1).a(paramFloat1, paramFloat2))) {
            break label94;
          }
          localObject1 = ((ln)localObject1).u();
          return localObject1;
        }
      }
      Object localObject3 = null;
      continue;
      label94:
      i1 -= 1;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.aB == paramInt) {}
    do
    {
      return;
      this.aB = paramInt;
    } while (this.O == null);
    mt localmt = new mt();
    localmt.a = 1;
    localmt.d = getMap().h();
    localmt.e = getMap().t().a(new Point(0, getHeight() / 2), new Point(getWidth(), getHeight() / 2));
    this.O.a(localmt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return;
    }
    if (this.aV == null)
    {
      GeoPoint localGeoPoint = getMap().f();
      this.aV = new GeoPoint(localGeoPoint.getLatitudeE6(), localGeoPoint.getLongitudeE6());
    }
    this.aV.setLatitudeE6(paramInt1);
    this.aV.setLongitudeE6(paramInt2);
  }
  
  public void a(Context paramContext)
  {
    super.k();
    qq.a(paramContext.getApplicationContext());
    if (!getMap().g()) {
      getMap().a(0);
    }
    for (;;)
    {
      if (this.aW) {
        s();
      }
      return;
      getMap().a(5);
    }
  }
  
  public void a(Handler paramHandler, Bitmap.Config paramConfig)
  {
    this.aN = paramHandler;
    this.aX = System.currentTimeMillis();
    this.aO = paramConfig;
    getMap().a();
  }
  
  public void a(nw paramnw)
  {
    if (paramnw == null) {}
    do
    {
      return;
      if (this.W == null) {
        this.W = new ArrayList();
      }
    } while (this.W.contains(paramnw) == true);
    this.W.add(paramnw);
  }
  
  public void a(qn paramqn)
  {
    try
    {
      if (this.ap == null) {
        this.ap = new qp();
      }
      this.ap.a(paramqn);
      return;
    }
    finally {}
  }
  
  public void a(Class<? extends ln> paramClass, pg parampg)
  {
    this.V.put(paramClass, parampg);
  }
  
  public void a(String paramString, float paramFloat)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    for (;;)
    {
      int i2;
      int i3;
      int i1;
      int i4;
      synchronized (this.e)
      {
        int i5 = this.P.size();
        i2 = 0;
        i3 = -1;
        i1 = i5;
        if (i2 < i5)
        {
          ln localln = (ln)this.P.get(i2);
          i4 = i1;
          if (localln != null)
          {
            if (localln.x() > paramFloat) {
              i1 = i2;
            }
            i4 = i1;
            if (TextUtils.equals(localln.u(), paramString))
            {
              i3 = i2;
              break label167;
              label105:
              return;
            }
          }
        }
      }
      label167:
      do
      {
        i2 = i1;
        if (i1 >= i3) {
          i2 = i1 - 1;
        }
        paramString = (ln)this.P.remove(i3);
        if (paramString == null) {
          return;
        }
        this.P.add(i2, paramString);
        return;
        i1 = i4;
        i2 += 1;
        break;
        if (i3 == -1) {
          break label105;
        }
      } while (i3 != i1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, false);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 == true)
    {
      byte[] arrayOfByte = this.e;
      if (!paramBoolean2) {}
      try
      {
        this.M = paramString;
        return;
      }
      finally {}
    }
    if (!paramBoolean2) {
      this.M = paramString;
    }
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    super.a(paramGL10, paramInt1, paramInt2);
    this.D = paramInt1;
    this.E = paramInt2;
    b((int)(this.D * this.H), (int)(this.E * this.I));
    c((int)(this.D * this.J), (int)(this.E * this.K));
    if (this.aQ != null) {
      this.aQ.a();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(ln paramln)
  {
    if (paramln == null) {
      return false;
    }
    for (;;)
    {
      int i1;
      synchronized (this.e)
      {
        int i4 = this.P.size();
        i1 = 0;
        int i2 = 0;
        int i3 = i4;
        if (i1 < i4)
        {
          ln localln = (ln)this.P.get(i1);
          if ((localln == null) || (i2 != 0) || (localln.x() < paramln.x())) {
            break label225;
          }
          i2 = 1;
          i3 = i1;
          break label225;
        }
        this.P.add(i3, paramln);
        if ((paramln != null) && (paramln.v() != null))
        {
          if (this.u != null) {
            paramln.a(this.u);
          }
          this.Q.add(paramln);
        }
        if ((paramln instanceof lm))
        {
          this.R.add(paramln);
          Collections.sort(this.R, this.aD);
          return true;
        }
      }
      if ((paramln instanceof lp))
      {
        this.S.add(paramln);
        Collections.sort(this.S, this.aD);
      }
      else
      {
        this.T.add(paramln);
        Collections.sort(this.T, this.aD);
        continue;
        label225:
        i1 += 1;
      }
    }
  }
  
  public boolean a(py parampy)
  {
    synchronized (this.e)
    {
      this.u = parampy;
      Iterator localIterator = this.Q.iterator();
      if (localIterator.hasNext()) {
        ((ln)localIterator.next()).a(parampy);
      }
    }
    return false;
  }
  
  public boolean a(GL10 paramGL10)
  {
    c(paramGL10);
    boolean bool1 = super.a(paramGL10);
    boolean bool2 = j();
    long l1 = System.currentTimeMillis();
    long l2 = this.aX;
    if ((this.aN != null) && ((bool2) || (l1 - l2 >= 2500L))) {
      b(paramGL10);
    }
    return bool1;
  }
  
  public ln b(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      synchronized (this.e)
      {
        Iterator localIterator = this.P.iterator();
        if (localIterator.hasNext())
        {
          localObject = (ln)localIterator.next();
          if ((localObject == null) || (!TextUtils.equals(((ln)localObject).u(), paramString))) {
            continue;
          }
          localIterator.remove();
          paramString = (String)localObject;
          if (paramBoolean)
          {
            ((ln)localObject).d();
            paramString = (String)localObject;
          }
          localObject = paramString;
          if (paramString == null) {
            break;
          }
          this.R.remove(paramString);
          this.S.remove(paramString);
          this.T.remove(paramString);
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public pg b(Class<? extends ln> paramClass)
  {
    return (pg)this.V.remove(paramClass);
  }
  
  public void b()
  {
    super.b();
    this.aK = 0;
    this.aJ = false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.aR = paramInt1;
    this.aS = paramInt2;
  }
  
  /* Error */
  public void b(qn paramqn)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 258	com/tencent/tencentmap/mapsdk/a/ma:ap	Lcom/tencent/tencentmap/mapsdk/a/qp;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 258	com/tencent/tencentmap/mapsdk/a/ma:ap	Lcom/tencent/tencentmap/mapsdk/a/qp;
    //   18: aload_1
    //   19: invokevirtual 967	com/tencent/tencentmap/mapsdk/a/qp:b	(Lcom/tencent/tencentmap/mapsdk/a/qn;)V
    //   22: goto -11 -> 11
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	ma
    //   0	30	1	paramqn	qn
    //   6	2	2	localqp	qp
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   14	22	25	finally
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.aT = paramInt1;
    this.aU = paramInt2;
  }
  
  public void c(Class<? extends ln> paramClass)
  {
    if (paramClass == null) {
      return;
    }
    synchronized (this.e)
    {
      Iterator localIterator = this.P.iterator();
      while (localIterator.hasNext())
      {
        ln localln = (ln)localIterator.next();
        if ((localln != null) && (paramClass.isInstance(localln)))
        {
          localln.d();
          localIterator.remove();
          this.R.remove(localln);
          this.S.remove(localln);
          this.T.remove(localln);
        }
      }
    }
    getMap().a();
  }
  
  public boolean d()
  {
    synchronized (this.e)
    {
      this.u = null;
      Iterator localIterator = this.Q.iterator();
      if (localIterator.hasNext()) {
        ((ln)localIterator.next()).w();
      }
    }
    return false;
  }
  
  public void e()
  {
    getMap().l();
    if (this.G != null) {
      this.G.a();
    }
  }
  
  public void f()
  {
    g();
  }
  
  public ot getBubblesOverlay()
  {
    synchronized (this.e)
    {
      ot localot = this.U;
      return localot;
    }
  }
  
  public mq getIndoorFloorControlManager()
  {
    return this.ai;
  }
  
  public pm getIndoorMapControl()
  {
    return this.az;
  }
  
  public com.tencent.map.lib.basemap.data.a getMapRegion()
  {
    b[] arrayOfb = getScreenFrontierPoint();
    b localb = im.a(getMap().f());
    float f1 = getMap().h();
    if (this.al == null) {
      this.al = new com.tencent.map.lib.basemap.data.a(localb, arrayOfb, f1);
    }
    for (;;)
    {
      return this.al;
      this.al.a(localb, arrayOfb, f1);
    }
  }
  
  public int getMarkerOnTapedAnchorPointXOffSet()
  {
    synchronized (this.e)
    {
      if ((this.M == null) || (this.M.trim().length() == 0)) {
        return 0;
      }
      ln localln = a(this.M);
      if (localln == null) {
        return 0;
      }
      int i1 = ((lm)localln).m();
      return i1;
    }
  }
  
  public String getMarkerOnTapedId()
  {
    return this.M;
  }
  
  public GeoPoint getMarkerOnTapedPosition()
  {
    synchronized (this.e)
    {
      if ((this.M == null) || (this.M.trim().length() == 0)) {
        return null;
      }
      Object localObject1 = a(this.M);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = ((lm)localObject1).g();
      return localObject1;
    }
  }
  
  public GeoPoint getNaviCenter()
  {
    if (this.aV == null)
    {
      if (this.aR == -2147483648) {
        this.aR = (this.D / 2);
      }
      if (this.aS == -2147483648) {
        this.aS = (this.E / 2);
      }
      DoublePoint localDoublePoint = new DoublePoint(this.aR, this.aS);
      this.aV = getMap().t().a(localDoublePoint);
    }
    return this.aV;
  }
  
  public int getNaviFixX()
  {
    return this.aR;
  }
  
  public int getNaviFixX2D()
  {
    return this.aT;
  }
  
  public int getNaviFixY()
  {
    return this.aS;
  }
  
  public int getNaviFixY2D()
  {
    return this.aU;
  }
  
  public b[] getScreenFrontierPoint()
  {
    b[] arrayOfb = new b[8];
    float f1 = getWidth();
    float f2 = getHeight();
    DoublePoint localDoublePoint1 = new DoublePoint(0.0D, 0.0D);
    DoublePoint localDoublePoint2 = new DoublePoint(f1 / 2.0F, 0.0D);
    DoublePoint localDoublePoint3 = new DoublePoint(f1, 0.0D);
    DoublePoint localDoublePoint4 = new DoublePoint(f1, f2 / 2.0F);
    DoublePoint localDoublePoint5 = new DoublePoint(f1, f2);
    DoublePoint localDoublePoint6 = new DoublePoint(f1 / 2.0F, f2);
    DoublePoint localDoublePoint7 = new DoublePoint(0.0D, f2);
    DoublePoint localDoublePoint8 = new DoublePoint(0.0D, f2 / 2.0F);
    int i1 = 0;
    while (i1 < 8)
    {
      arrayOfb[i1] = im.a(getMap().t().a(new DoublePoint[] { localDoublePoint1, localDoublePoint2, localDoublePoint3, localDoublePoint4, localDoublePoint5, localDoublePoint6, localDoublePoint7, localDoublePoint8 }[i1]));
      i1 += 1;
    }
    return arrayOfb;
  }
  
  public nd getWorldMapOverlayManager()
  {
    return this.ae;
  }
  
  public boolean getZoomInEnable()
  {
    return this.aG;
  }
  
  public boolean getZoomOutEnable()
  {
    return this.aH;
  }
  
  public void i()
  {
    getMap().a(null);
    if (this.az != null) {
      this.az.a(null);
    }
    if (this.ae != null) {
      this.ae.b();
    }
    this.ag = true;
    super.i();
    qq.a();
  }
  
  public void l()
  {
    synchronized (this.e)
    {
      if (this.U != null)
      {
        this.U.e();
        this.U = null;
      }
      return;
    }
  }
  
  public void m()
  {
    synchronized (this.e)
    {
      if (this.U != null) {
        this.U.f();
      }
      return;
    }
  }
  
  public boolean n()
  {
    return this.ad;
  }
  
  public boolean o()
  {
    return this.au;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.m != null) {
      this.m.a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean p()
  {
    return this.av;
  }
  
  public void q()
  {
    if (this.v != null) {
      this.v.removeCallbacksAndMessages(null);
    }
    if (this.aM != null) {
      this.aM.removeCallbacksAndMessages(null);
    }
    if (this.aN != null) {
      this.aN.removeCallbacksAndMessages(null);
    }
    if (this.W != null)
    {
      this.W.clear();
      this.W = null;
    }
    r();
    if (this.V != null) {
      this.V.clear();
    }
  }
  
  public void r()
  {
    if (this.P == null) {
      return;
    }
    Iterator localIterator = this.P.iterator();
    while (localIterator.hasNext())
    {
      ln localln = (ln)localIterator.next();
      if (localln != null) {
        localln.d();
      }
      localIterator.remove();
    }
    this.R.clear();
    this.S.clear();
    this.T.clear();
  }
  
  public void s()
  {
    if (this.af == null)
    {
      this.af = new mj(new mi(this));
      a(this.af);
      new ml(getContext().getApplicationContext(), this.af).a();
    }
  }
  
  public void setAllGestureEnable(boolean paramBoolean)
  {
    this.aw = paramBoolean;
  }
  
  public void setCamerChangeListener(boolean paramBoolean)
  {
    if ((!paramBoolean) || (x()))
    {
      getMap().a(this.aF);
      return;
    }
    getMap().a(null);
  }
  
  public void setCompassEnable(boolean paramBoolean)
  {
    this.ad = paramBoolean;
    getMap().f(paramBoolean);
    getMap().a();
  }
  
  public void setCompassExtraPadding(int paramInt)
  {
    this.an = paramInt;
    getMap().e(this.am, paramInt);
    g();
  }
  
  public void setFlingGestureEnabled(boolean paramBoolean)
  {
    this.ar = paramBoolean;
  }
  
  public void setGestureScaleByMapCenter(boolean paramBoolean)
  {
    this.ba = paramBoolean;
  }
  
  public void setIndoorFloorControlManager(mq parammq)
  {
    this.ai = parammq;
  }
  
  public void setInfoWindowStill(boolean paramBoolean)
  {
    this.ao = paramBoolean;
  }
  
  public void setLogoAndScaleManager(ms paramms)
  {
    this.ah = paramms;
  }
  
  public void setMapEventHandler(mt.a parama)
  {
    this.O = parama;
  }
  
  public void setOnAnnocationClickedCallback(ah.k paramk)
  {
    this.aA = paramk;
  }
  
  public void setOnDismissCallback(ah.e parame)
  {
    this.aa = parame;
  }
  
  public void setOnIndoorMapStateChangeCallback(ah.f paramf)
  {
    this.aj = paramf;
  }
  
  public void setOnSurfaceChangedListener(nv.a parama)
  {
    this.aQ = parama;
  }
  
  public void setOnTapMapViewInfoWindowHidden(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }
  
  public void setRotateGestureEnable(boolean paramBoolean)
  {
    this.av = paramBoolean;
  }
  
  public void setScrollGestureEnable(boolean paramBoolean)
  {
    this.as = paramBoolean;
  }
  
  public void setSkewGestureEnable(boolean paramBoolean)
  {
    this.au = paramBoolean;
  }
  
  public void setZoomGestureEnable(boolean paramBoolean)
  {
    this.at = paramBoolean;
  }
  
  public void t()
  {
    if (this.af != null)
    {
      this.af.e();
      this.af = null;
    }
  }
  
  public boolean u()
  {
    return this.af != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ma
 * JD-Core Version:    0.7.0.1
 */