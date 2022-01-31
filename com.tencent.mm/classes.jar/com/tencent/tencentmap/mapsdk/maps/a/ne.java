package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.d;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public class ne
  implements nb
{
  private static List<nm> A;
  private static ConcurrentHashMap<String, Bitmap> B;
  private static List<String> C;
  private static ReentrantReadWriteLock F;
  private static final int[] H;
  private String D;
  private AtomicInteger E;
  private int G;
  private String I;
  private int J;
  private int K;
  private float L;
  private int M;
  private double N;
  private b O;
  private boolean P;
  private LinearLayout Q;
  private LinearLayout R;
  private final int S;
  private final int T;
  private final int U;
  private float V;
  private Animation W;
  private int X;
  private List<ne.a> Y;
  private int Z;
  private final int a;
  private int aa;
  private int ab;
  private int ac;
  private boolean ad;
  private final int b;
  private Context c;
  private ImageView d;
  private Bitmap e;
  private Bitmap f;
  private nb.b g;
  private nb.b h;
  private boolean i;
  private ViewGroup j;
  private float[] k;
  private int[] l;
  private int[] m;
  private int[] n;
  private int[] o;
  private float[] p;
  private float[] q;
  private float[] r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private boolean y;
  private TextView z;
  
  static
  {
    AppMethodBeat.i(149450);
    A = new CopyOnWriteArrayList();
    B = new ConcurrentHashMap();
    C = new CopyOnWriteArrayList();
    F = new ReentrantReadWriteLock();
    H = new int[] { 1, 2, 5 };
    AppMethodBeat.o(149450);
  }
  
  public ne(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149408);
    this.a = 500;
    this.b = 1000;
    this.g = nb.b.c;
    this.h = nb.b.a;
    this.i = true;
    this.k = new float[] { -1.0F, -1.0F, -1.0F, -1.0F };
    this.l = new int[] { -1, -1, -1, -1 };
    this.m = new int[] { -1, -1, -1, -1 };
    this.n = new int[nb.a.values().length];
    this.o = new int[nb.a.values().length];
    this.p = new float[] { 0.02F, 0.02F, 0.012F, 0.012F };
    this.q = new float[] { 0.022F, 0.022F, 0.0125F, 0.0125F };
    this.r = new float[] { 0.0185F, 0.0185F, 0.0104F, 0.0104F };
    this.s = 0;
    this.t = 0;
    this.u = 0;
    this.v = 0;
    this.w = 0;
    this.x = 0;
    this.y = false;
    this.D = null;
    this.E = new AtomicInteger(0);
    this.G = 0;
    this.I = "50m";
    this.J = 11;
    this.K = 109;
    this.L = 1.0F;
    this.P = true;
    this.U = 18;
    this.V = 1.4E-45F;
    this.X = 40;
    this.Y = new ArrayList();
    this.Z = -1;
    this.aa = -1;
    this.ab = -1;
    this.ac = -1;
    this.ad = true;
    this.c = paramContext;
    this.S = paramInt1;
    this.T = paramInt2;
    this.L = paramContext.getResources().getDisplayMetrics().density;
    this.X = ((int)(40.0F * this.L + 0.5D));
    this.d = new ImageView(paramContext);
    this.O = new b(this.c);
    this.z = new TextView(this.c);
    this.z.setText(this.I);
    this.z.setContentDescription("地图");
    this.z.setTextSize(12.0F);
    this.z.setTextColor(-16777216);
    this.z.setGravity(1);
    if (this.L <= 0.0F) {
      this.L = 1.0F;
    }
    this.Q = new LinearLayout(this.c);
    this.Q.setOrientation(1);
    this.Q.setGravity(16);
    this.R = new LinearLayout(this.c);
    this.R.setOrientation(1);
    this.R.setGravity(16);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.R.addView(this.z, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.R.addView(this.O, paramContext);
    this.R.setVisibility(8);
    o();
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.Q.addView(this.d, paramContext);
    a(nn.g());
    AppMethodBeat.o(149408);
  }
  
  private void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(149421);
    try
    {
      this.e = paramBitmap;
      if (this.e != null)
      {
        this.u = this.e.getWidth();
        this.v = this.e.getHeight();
      }
      u();
      v();
      AppMethodBeat.o(149421);
      return;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(149421);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149413);
    if (C.contains(paramString2))
    {
      AppMethodBeat.o(149413);
      return;
    }
    C.add(paramString2);
    new ne.2(this, paramString1, paramString2).start();
    AppMethodBeat.o(149413);
  }
  
  /* Error */
  private boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 375
    //   6: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   12: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   15: invokevirtual 384	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   18: aload_2
    //   19: ifnonnull +11 -> 30
    //   22: ldc_w 375
    //   25: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 387	com/tencent/tencentmap/mapsdk/maps/a/ne:b	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_1
    //   36: new 389	java/io/File
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 395	java/io/File:exists	()Z
    //   49: istore_3
    //   50: iload_3
    //   51: ifeq +24 -> 75
    //   54: aconst_null
    //   55: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   58: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   61: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   64: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   67: ldc_w 375
    //   70: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_0
    //   74: ireturn
    //   75: new 405	java/io/FileOutputStream
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 408	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_1
    //   84: aload_2
    //   85: getstatic 414	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   88: bipush 100
    //   90: aload_1
    //   91: invokevirtual 418	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   94: istore_3
    //   95: aload_1
    //   96: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   99: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: ldc_w 375
    //   111: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iload_3
    //   115: ireturn
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   123: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   126: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   129: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   132: ldc_w 375
    //   135: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_1
    //   141: aload 4
    //   143: astore_2
    //   144: aload_2
    //   145: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   148: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   151: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   154: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   157: ldc_w 375
    //   160: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_1
    //   164: athrow
    //   165: astore 4
    //   167: aload_1
    //   168: astore_2
    //   169: aload 4
    //   171: astore_1
    //   172: goto -28 -> 144
    //   175: astore_2
    //   176: goto -57 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	ne
    //   0	179	1	paramString	String
    //   0	179	2	paramBitmap	Bitmap
    //   49	66	3	bool	boolean
    //   1	141	4	localObject1	Object
    //   165	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	50	116	java/lang/Throwable
    //   75	84	116	java/lang/Throwable
    //   36	50	140	finally
    //   75	84	140	finally
    //   84	95	165	finally
    //   84	95	175	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    AppMethodBeat.i(149416);
    String str = q();
    t.a(str);
    paramString = str + "/" + paramString;
    AppMethodBeat.o(149416);
    return paramString;
  }
  
  private int[] b(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    float f1;
    if (this.V != 1.4E-45F) {
      f1 = this.V;
    }
    for (;;)
    {
      return new int[] { (int)(paramInt1 * f1), (int)(f1 * paramInt2) };
      f1 = f2;
      switch (this.G)
      {
      case 0: 
      default: 
        f1 = f2;
        break;
      case -3: 
        f1 = 0.7F;
        break;
      case 1: 
        f1 = 1.2F;
        break;
      case -1: 
        f1 = 0.8333333F;
        break;
      case -2: 
        f1 = 0.8F;
      }
    }
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: ldc_w 445
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 449	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   12: invokevirtual 452	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   15: new 389	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 387	com/tencent/tencentmap/mapsdk/maps/a/ne:b	(Ljava/lang/String;)Ljava/lang/String;
    //   24: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: invokevirtual 395	java/io/File:exists	()Z
    //   32: istore_2
    //   33: iload_2
    //   34: ifne +24 -> 58
    //   37: aconst_null
    //   38: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   41: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   44: invokevirtual 449	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   47: invokevirtual 453	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   50: ldc_w 445
    //   53: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: new 455	java/io/FileInputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 456	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: astore_1
    //   67: aload_1
    //   68: invokestatic 462	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   71: astore_3
    //   72: aload_1
    //   73: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   76: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   79: invokevirtual 449	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   82: invokevirtual 453	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   85: ldc_w 445
    //   88: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_3
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   100: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   103: invokevirtual 449	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 453	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: ldc_w 445
    //   112: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_3
    //   120: aload_3
    //   121: invokestatic 400	com/tencent/tencentmap/mapsdk/a/t:a	(Ljava/io/Closeable;)V
    //   124: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   127: invokevirtual 449	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   130: invokevirtual 453	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   133: ldc_w 445
    //   136: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_3
    //   142: aload_1
    //   143: astore 4
    //   145: aload_3
    //   146: astore_1
    //   147: aload 4
    //   149: astore_3
    //   150: goto -30 -> 120
    //   153: astore_3
    //   154: goto -58 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ne
    //   0	157	1	paramString	String
    //   32	2	2	bool	boolean
    //   71	50	3	localBitmap	Bitmap
    //   141	5	3	localObject1	Object
    //   149	1	3	localObject2	Object
    //   153	1	3	localThrowable	Throwable
    //   143	5	4	str	String
    // Exception table:
    //   from	to	target	type
    //   15	33	93	java/lang/Throwable
    //   58	67	93	java/lang/Throwable
    //   15	33	117	finally
    //   58	67	117	finally
    //   67	72	141	finally
    //   67	72	153	java/lang/Throwable
  }
  
  private void o()
  {
    AppMethodBeat.i(149409);
    this.W = new AlphaAnimation(1.0F, 0.0F);
    this.W.setDuration(1000L);
    this.W.setStartOffset(500L);
    this.W.setAnimationListener(new ne.1(this));
    AppMethodBeat.o(149409);
  }
  
  private void p()
  {
    AppMethodBeat.i(149411);
    a(this.j);
    AppMethodBeat.o(149411);
  }
  
  private String q()
  {
    AppMethodBeat.i(149414);
    String str = this.c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
    AppMethodBeat.o(149414);
    return str;
  }
  
  private String r()
  {
    AppMethodBeat.i(149415);
    String str = this.c.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
    AppMethodBeat.o(149415);
    return str;
  }
  
  private FrameLayout.LayoutParams s()
  {
    AppMethodBeat.i(149426);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    if (this.f == null)
    {
      AppMethodBeat.o(149426);
      return localLayoutParams;
    }
    switch (ne.4.a[this.g.ordinal()])
    {
    default: 
      d.b("Unknown position:" + this.g);
    }
    for (;;)
    {
      AppMethodBeat.o(149426);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.n[nb.a.c.e];
      localLayoutParams.leftMargin = this.n[nb.a.a.e];
      this.aa = (this.t - localLayoutParams.bottomMargin - this.f.getHeight());
      this.Z = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.n[nb.a.c.e];
      this.aa = (this.t - localLayoutParams.bottomMargin - this.f.getHeight());
      this.Z = ((this.s - this.f.getWidth()) / 2);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.n[nb.a.c.e];
      localLayoutParams.rightMargin = this.n[nb.a.b.e];
      this.aa = (this.t - localLayoutParams.bottomMargin - this.f.getHeight());
      this.Z = (this.s - localLayoutParams.rightMargin - this.f.getWidth());
      continue;
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.n[nb.a.d.e];
      localLayoutParams.leftMargin = this.n[nb.a.a.e];
      this.aa = localLayoutParams.topMargin;
      this.Z = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.n[nb.a.d.e];
      this.aa = localLayoutParams.topMargin;
      this.Z = ((this.s - this.f.getWidth()) / 2);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = this.n[nb.a.d.e];
      localLayoutParams.rightMargin = this.n[nb.a.b.e];
      this.aa = localLayoutParams.topMargin;
      this.Z = (this.s - localLayoutParams.rightMargin - this.f.getWidth());
    }
  }
  
  private FrameLayout.LayoutParams t()
  {
    AppMethodBeat.i(149427);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    if (this.R == null)
    {
      AppMethodBeat.o(149427);
      return localLayoutParams;
    }
    int i1 = this.R.getMeasuredWidth();
    int i2 = this.R.getMeasuredHeight();
    switch (ne.4.a[this.h.ordinal()])
    {
    default: 
      d.b("Unknown positionScale:" + this.h);
    }
    for (;;)
    {
      AppMethodBeat.o(149427);
      return localLayoutParams;
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.o[nb.a.c.e];
      localLayoutParams.leftMargin = this.o[nb.a.a.e];
      this.ac = (this.t - localLayoutParams.bottomMargin - i2);
      this.ab = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.o[nb.a.c.e];
      this.ac = (this.t - localLayoutParams.bottomMargin - i2);
      this.ab = ((this.s - i1) / 2);
      continue;
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.o[nb.a.c.e];
      localLayoutParams.rightMargin = this.o[nb.a.b.e];
      this.ac = (this.t - localLayoutParams.bottomMargin - i2);
      this.ab = (this.s - localLayoutParams.rightMargin - i1);
      continue;
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.o[nb.a.d.e];
      localLayoutParams.leftMargin = this.o[nb.a.a.e];
      this.ac = localLayoutParams.topMargin;
      this.ab = localLayoutParams.leftMargin;
      continue;
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.o[nb.a.d.e];
      this.ac = localLayoutParams.topMargin;
      this.ab = ((this.s - i1) / 2);
      continue;
      localLayoutParams.gravity = 53;
      localLayoutParams.topMargin = this.o[nb.a.d.e];
      localLayoutParams.rightMargin = this.o[nb.a.b.e];
      this.ac = localLayoutParams.topMargin;
      this.ab = (this.s - localLayoutParams.rightMargin - i1);
    }
  }
  
  private void u()
  {
    AppMethodBeat.i(149433);
    if ((this.s == 0) || (this.t == 0))
    {
      AppMethodBeat.o(149433);
      return;
    }
    this.w = ((int)(this.u * this.L / 3.0F));
    this.x = ((int)(this.v * this.L / 3.0F));
    float[] arrayOfFloat = this.p;
    if (this.s >= 1080) {
      arrayOfFloat = this.r;
    }
    for (;;)
    {
      int i1 = nb.a.a.e;
      float f1 = arrayOfFloat[i1];
      if (this.k[i1] >= 0.0F) {
        f1 = this.k[i1];
      }
      this.n[i1] = ((int)(f1 * this.s));
      if (this.ad) {
        this.m[nb.a.c.e] = this.x;
      }
      if ((this.l[i1] >= 0) && (this.l[i1] < this.s - this.w)) {
        this.n[i1] = this.l[i1];
      }
      i1 = nb.a.b.e;
      f1 = arrayOfFloat[i1];
      if (this.k[i1] >= 0.0F) {
        f1 = this.k[i1];
      }
      this.n[i1] = ((int)(f1 * this.s));
      if ((this.l[i1] >= 0) && (this.l[i1] < this.s - this.w)) {
        this.n[i1] = this.l[i1];
      }
      i1 = nb.a.c.e;
      f1 = arrayOfFloat[i1];
      if (this.k[i1] >= 0.0F) {
        f1 = this.k[i1];
      }
      this.n[i1] = ((int)(f1 * this.t));
      if ((this.l[i1] >= 0) && (this.l[i1] < this.t - this.x)) {
        this.n[i1] = this.l[i1];
      }
      i1 = nb.a.d.e;
      f1 = arrayOfFloat[i1];
      if (this.k[i1] >= 0.0F) {
        f1 = this.k[i1];
      }
      this.n[i1] = ((int)(f1 * this.t));
      if ((this.l[i1] >= 0) && (this.l[i1] < this.t - this.x)) {
        this.n[i1] = this.l[i1];
      }
      this.y = true;
      p();
      AppMethodBeat.o(149433);
      return;
      if (this.s >= 720) {
        arrayOfFloat = this.q;
      }
    }
  }
  
  private void v()
  {
    AppMethodBeat.i(149434);
    if ((this.s == 0) || (this.t == 0))
    {
      AppMethodBeat.o(149434);
      return;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.R.measure(i1, i2);
    i1 = this.R.getMeasuredHeight();
    i2 = this.R.getMeasuredWidth();
    float[] arrayOfFloat = this.p;
    if (this.s >= 1080) {
      arrayOfFloat = this.r;
    }
    for (;;)
    {
      int i3 = nb.a.a.e;
      float f1 = arrayOfFloat[i3];
      if (this.k[i3] >= 0.0F) {
        f1 = this.k[i3];
      }
      this.o[i3] = ((int)(f1 * this.s));
      if ((this.m[i3] >= 0) && (this.m[i3] < this.s - i2)) {
        this.o[i3] = this.m[i3];
      }
      i3 = nb.a.b.e;
      f1 = arrayOfFloat[i3];
      if (this.k[i3] >= 0.0F) {
        f1 = this.k[i3];
      }
      this.o[i3] = ((int)(f1 * this.s));
      if ((this.m[i3] >= 0) && (this.m[i3] < this.s - i2)) {
        this.o[i3] = this.m[i3];
      }
      i2 = nb.a.c.e;
      f1 = arrayOfFloat[i2];
      if (this.k[i2] >= 0.0F) {
        f1 = this.k[i2];
      }
      this.o[i2] = ((int)(f1 * this.t));
      if ((this.m[i2] >= 0) && (this.m[i2] < this.t - i1)) {
        this.o[i2] = this.m[i2];
      }
      i2 = nb.a.d.e;
      f1 = arrayOfFloat[i2];
      if (this.k[i2] >= 0.0F) {
        f1 = this.k[i2];
      }
      this.o[i2] = ((int)(f1 * this.t));
      if ((this.m[i2] >= 0) && (this.m[i2] < this.t - i1)) {
        this.o[i2] = this.m[i2];
      }
      p();
      AppMethodBeat.o(149434);
      return;
      if (this.s >= 720) {
        arrayOfFloat = this.q;
      }
    }
  }
  
  private void w()
  {
    int i3 = 0;
    AppMethodBeat.i(149440);
    int i4 = (int)Math.log10(this.X * this.N);
    int i1 = (int)(H[0] * Math.pow(10.0D, i4));
    int i2 = (int)(i1 / this.N);
    if ((i2 <= 0) || (Double.isNaN(this.N)))
    {
      AppMethodBeat.o(149440);
      return;
    }
    while (i2 < this.X)
    {
      i3 += 1;
      i1 = H.length;
      i1 = (int)(H[(i3 % i1)] * Math.pow(10.0D, i3 / H.length + i4));
      i2 = (int)(i1 / this.N);
    }
    String str = "m";
    i3 = i1;
    if (i1 >= 1000)
    {
      i3 = i1 / 1000;
      str = "km";
    }
    this.I = (i3 + str);
    this.K = i2;
    this.z.setText(this.I);
    AppMethodBeat.o(149440);
  }
  
  public void a()
  {
    AppMethodBeat.i(149423);
    if (this.E.decrementAndGet() == 0)
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        Iterator localIterator = B.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
      B.clear();
    }
    t.a(this.f);
    AppMethodBeat.o(149423);
  }
  
  public void a(float paramFloat)
  {
    float f2 = 1.3F;
    float f1 = 0.7F;
    AppMethodBeat.i(149442);
    if (paramFloat > 1.3F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat < 0.7F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.G = 0;
        this.V = paramFloat;
        d();
        AppMethodBeat.o(149442);
        return;
      }
    }
  }
  
  @Deprecated
  public void a(int paramInt)
  {
    AppMethodBeat.i(149441);
    this.G = paramInt;
    this.V = 1.4E-45F;
    d();
    AppMethodBeat.o(149441);
  }
  
  public void a(int paramInt, double paramDouble)
  {
    AppMethodBeat.i(149439);
    this.M = paramInt;
    this.N = paramDouble;
    w();
    p();
    AppMethodBeat.o(149439);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149422);
    this.s = paramInt1;
    this.t = paramInt2;
    u();
    v();
    AppMethodBeat.o(149422);
  }
  
  public void a(a parama, int paramInt)
  {
    AppMethodBeat.i(149412);
    int i2 = (int)parama.c();
    int i1 = i2;
    if (i2 > 18) {
      i1 = 18;
    }
    Object localObject2 = A.iterator();
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (nm)((Iterator)localObject2).next();
    } while ((i1 < ((nm)localObject1).a()) || (i1 > ((nm)localObject1).b()));
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(149412);
        return;
      }
      localObject1 = ((nm)localObject1).a(parama, paramInt);
      if (localObject1 == null)
      {
        AppMethodBeat.o(149412);
        return;
      }
      parama = localObject1[0];
      localObject1 = localObject1[1];
      if (!StringUtil.isEqual(parama, this.D)) {
        paramInt = 1;
      }
      while (paramInt != 0)
      {
        localObject2 = (Bitmap)B.get(parama);
        if (localObject2 != null)
        {
          if (!((Bitmap)localObject2).isRecycled())
          {
            a((Bitmap)localObject2);
            this.D = parama;
            AppMethodBeat.o(149412);
            return;
            paramInt = 0;
          }
          else
          {
            B.remove(parama);
          }
        }
        else
        {
          localObject2 = c(parama);
          if (localObject2 != null)
          {
            this.D = parama;
            B.put(this.D, localObject2);
            a((Bitmap)localObject2);
            AppMethodBeat.o(149412);
            return;
          }
          this.D = null;
          a((String)localObject1, parama);
        }
      }
      AppMethodBeat.o(149412);
      return;
      localObject1 = null;
    }
  }
  
  public void a(nb.a parama, int paramInt)
  {
    this.l[parama.e] = paramInt;
  }
  
  public void a(nb.b paramb)
  {
    AppMethodBeat.i(149424);
    if (this.g != paramb) {
      p();
    }
    this.g = paramb;
    AppMethodBeat.o(149424);
  }
  
  public void a(ne.a parama)
  {
    AppMethodBeat.i(149445);
    if ((this.Y != null) && (parama != null)) {
      this.Y.add(parama);
    }
    AppMethodBeat.o(149445);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(149419);
    if (paramString == null)
    {
      AppMethodBeat.o(149419);
      return;
    }
    A.clear();
    try
    {
      paramString = new JSONArray(paramString);
      int i1 = 0;
      while (i1 < paramString.length())
      {
        Object localObject2 = paramString.getJSONObject(i1);
        Object localObject1 = ((JSONObject)localObject2).getJSONArray("level");
        int i3 = ((JSONArray)localObject1).getInt(0);
        int i4 = ((JSONArray)localObject1).getInt(1);
        localObject1 = new ArrayList();
        localObject2 = ((JSONObject)localObject2).getJSONArray("districts");
        int i2 = 0;
        while (i2 < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(i2);
          int i5 = localJSONObject.getInt("rule");
          int i6 = localJSONObject.getInt("priority");
          String str = localJSONObject.getString("frontier");
          ((List)localObject1).add(new nj(i5, i6, localJSONObject.getString("logo_name"), localJSONObject.getString("logo"), localJSONObject.optString("logo_night"), str));
          i2 += 1;
        }
        A.add(new nm(i3, i4, (List)localObject1));
        i1 += 1;
      }
      AppMethodBeat.o(149419);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(149419);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149429);
    this.i = paramBoolean;
    ImageView localImageView;
    if (this.d != null)
    {
      localImageView = this.d;
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (int i1 = 0;; i1 = 4)
    {
      localImageView.setVisibility(i1);
      AppMethodBeat.o(149429);
      return;
    }
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(149410);
    if (paramViewGroup == null)
    {
      AppMethodBeat.o(149410);
      return false;
    }
    Object localObject;
    if (this.y)
    {
      this.y = false;
      t.a(this.f);
      localObject = b(this.w, this.x);
      this.f = jr.a(this.e, this.c, localObject[0], localObject[1]);
    }
    try
    {
      this.d.setImageBitmap(this.f);
      this.j = paramViewGroup;
      localObject = s();
      if (paramViewGroup.indexOfChild(this.Q) < 0)
      {
        paramViewGroup.addView(this.Q, (ViewGroup.LayoutParams)localObject);
        localObject = t();
        if (paramViewGroup.indexOfChild(this.R) >= 0) {
          break label398;
        }
        paramViewGroup.addView(this.R, (ViewGroup.LayoutParams)localObject);
        if ((this.z != null) && (this.O != null))
        {
          localObject = (LinearLayout.LayoutParams)this.z.getLayoutParams();
          this.O.measure(0, 0);
          this.z.measure(0, 0);
          ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)((this.K + 6.0F * this.L - this.z.getWidth()) / 2.0F));
          this.R.updateViewLayout(this.z, (ViewGroup.LayoutParams)localObject);
          this.R.updateViewLayout(this.O, this.O.getLayoutParams());
        }
        localObject = this.d;
        if (!this.i) {
          break label410;
        }
        i1 = 0;
        ((ImageView)localObject).setVisibility(i1);
        if (this.Y == null) {
          break label415;
        }
        this.Q.requestLayout();
        this.R.requestLayout();
        localObject = this.Y.iterator();
        while (((Iterator)localObject).hasNext())
        {
          ne.a locala = (ne.a)((Iterator)localObject).next();
          locala.a(this.Q, new Rect(this.Z, this.aa, 0, 0), this.i);
          locala.b(this.R, new Rect(this.ab, this.ac, 0, 0), this.P);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.getStackTraceString(localThrowable);
        continue;
        paramViewGroup.updateViewLayout(this.Q, localThrowable);
        continue;
        label398:
        paramViewGroup.updateViewLayout(this.R, localThrowable);
        continue;
        label410:
        int i1 = 4;
      }
      label415:
      paramViewGroup.requestLayout();
      AppMethodBeat.o(149410);
    }
    return true;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: ldc_w 827
    //   3: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   9: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   12: invokevirtual 384	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   15: getstatic 106	com/tencent/tencentmap/mapsdk/maps/a/ne:B	Ljava/util/concurrent/ConcurrentHashMap;
    //   18: invokevirtual 654	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   21: new 389	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 422	com/tencent/tencentmap/mapsdk/maps/a/ne:q	()Ljava/lang/String;
    //   29: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 395	java/io/File:exists	()Z
    //   37: ifeq +35 -> 72
    //   40: new 389	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 829	com/tencent/tencentmap/mapsdk/maps/a/ne:r	()Ljava/lang/String;
    //   48: invokespecial 391	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 833	java/io/File:renameTo	(Ljava/io/File;)Z
    //   57: ifeq +31 -> 88
    //   60: new 835	com/tencent/tencentmap/mapsdk/maps/a/ne$3
    //   63: dup
    //   64: aload_0
    //   65: aload_2
    //   66: invokespecial 838	com/tencent/tencentmap/mapsdk/maps/a/ne$3:<init>	(Lcom/tencent/tencentmap/mapsdk/maps/a/ne;Ljava/io/File;)V
    //   69: invokevirtual 839	com/tencent/tencentmap/mapsdk/maps/a/ne$3:start	()V
    //   72: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   75: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   78: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   81: ldc_w 827
    //   84: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: return
    //   88: aload_1
    //   89: invokevirtual 509	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokestatic 841	com/tencent/tencentmap/mapsdk/a/t:c	(Ljava/lang/String;)Z
    //   95: pop
    //   96: goto -24 -> 72
    //   99: astore_1
    //   100: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   103: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   106: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   109: ldc_w 827
    //   112: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: astore_1
    //   117: getstatic 113	com/tencent/tencentmap/mapsdk/maps/a/ne:F	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   120: invokevirtual 379	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   123: invokevirtual 403	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   126: ldc_w 827
    //   129: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	ne
    //   32	57	1	localFile1	File
    //   99	1	1	localThrowable	Throwable
    //   116	17	1	localObject	Object
    //   51	15	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   21	72	99	java/lang/Throwable
    //   88	96	99	java/lang/Throwable
    //   21	72	116	finally
    //   88	96	116	finally
  }
  
  public void b(nb.a parama, int paramInt)
  {
    AppMethodBeat.i(149430);
    if (this.ad) {
      this.ad = false;
    }
    this.m[parama.e] = paramInt;
    v();
    AppMethodBeat.o(149430);
  }
  
  public void b(nb.b paramb)
  {
    AppMethodBeat.i(149425);
    if (this.h != paramb) {
      p();
    }
    this.h = paramb;
    AppMethodBeat.o(149425);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149435);
    this.P = paramBoolean;
    if ((this.O != null) && (!paramBoolean)) {
      this.R.setVisibility(8);
    }
    if (this.Y != null)
    {
      Iterator localIterator = this.Y.iterator();
      while (localIterator.hasNext()) {
        ((ne.a)localIterator.next()).b(this.R, new Rect(this.ab, this.ac, 0, 0), this.P);
      }
    }
    AppMethodBeat.o(149435);
  }
  
  public Rect c()
  {
    AppMethodBeat.i(149428);
    Rect localRect = new Rect();
    if (this.Q != null)
    {
      localRect.left = this.Q.getLeft();
      localRect.bottom = this.Q.getBottom();
      localRect.right = this.Q.getRight();
      localRect.top = this.Q.getTop();
    }
    AppMethodBeat.o(149428);
    return localRect;
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(149436);
    LinearLayout localLinearLayout;
    if (this.O != null)
    {
      localLinearLayout = this.R;
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      AppMethodBeat.o(149436);
      return;
    }
  }
  
  public void d()
  {
    AppMethodBeat.i(149431);
    u();
    AppMethodBeat.o(149431);
  }
  
  public void e()
  {
    AppMethodBeat.i(149432);
    v();
    AppMethodBeat.o(149432);
  }
  
  public boolean f()
  {
    return this.P;
  }
  
  public void g()
  {
    AppMethodBeat.i(149437);
    if (!this.P)
    {
      AppMethodBeat.o(149437);
      return;
    }
    if (this.O != null) {
      this.O.postInvalidate();
    }
    if (this.R != null)
    {
      if (this.R.getVisibility() != 0)
      {
        this.R.setVisibility(0);
        AppMethodBeat.o(149437);
        return;
      }
      this.R.clearAnimation();
    }
    AppMethodBeat.o(149437);
  }
  
  public void h()
  {
    AppMethodBeat.i(149438);
    if (this.R.getVisibility() != 0)
    {
      AppMethodBeat.o(149438);
      return;
    }
    this.R.clearAnimation();
    this.W.reset();
    this.R.startAnimation(this.W);
    AppMethodBeat.o(149438);
  }
  
  public Bitmap i()
  {
    AppMethodBeat.i(149443);
    if (this.d == null)
    {
      AppMethodBeat.o(149443);
      return null;
    }
    Object localObject = this.d.getDrawable();
    if (localObject == null)
    {
      AppMethodBeat.o(149443);
      return null;
    }
    localObject = ((BitmapDrawable)localObject).getBitmap();
    AppMethodBeat.o(149443);
    return localObject;
  }
  
  public boolean j()
  {
    AppMethodBeat.i(149444);
    if (StringUtil.isEmpty(this.D))
    {
      AppMethodBeat.o(149444);
      return true;
    }
    if ((this.D.contains("tencent")) || (this.D.contains("taiwan")))
    {
      AppMethodBeat.o(149444);
      return true;
    }
    AppMethodBeat.o(149444);
    return false;
  }
  
  public void k()
  {
    AppMethodBeat.i(149446);
    if (this.Y != null)
    {
      Iterator localIterator = this.Y.iterator();
      while (localIterator.hasNext()) {
        ((ne.a)localIterator.next()).a(this);
      }
    }
    AppMethodBeat.o(149446);
  }
  
  public void l()
  {
    AppMethodBeat.i(149447);
    if (this.Y != null)
    {
      Iterator localIterator = this.Y.iterator();
      while (localIterator.hasNext()) {
        ((ne.a)localIterator.next()).b(this);
      }
    }
    AppMethodBeat.o(149447);
  }
  
  class b
    extends View
  {
    private Paint b;
    private Paint c;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(149404);
      this.b = new Paint();
      this.b.setAntiAlias(true);
      this.b.setColor(-16777216);
      this.b.setStrokeWidth(1.0F * ne.c(ne.this));
      this.b.setStyle(Paint.Style.STROKE);
      this.c = new Paint(65);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setColor(0);
      AppMethodBeat.o(149404);
    }
    
    private void a(Canvas paramCanvas, int paramInt)
    {
      AppMethodBeat.i(149407);
      int i = (int)(6.0F * ne.c(ne.this));
      paramInt /= 2;
      paramCanvas.drawPaint(this.c);
      paramCanvas.drawLine(i, paramInt, ne.d(ne.this) + i, paramInt, this.b);
      paramCanvas.drawLine(i, paramInt - ne.c(ne.this) * 3.0F, i, paramInt + 1, this.b);
      paramCanvas.drawLine(ne.d(ne.this) + i, paramInt - ne.c(ne.this) * 3.0F, ne.d(ne.this) + i, paramInt + 1, this.b);
      AppMethodBeat.o(149407);
    }
    
    public void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(149405);
      super.draw(paramCanvas);
      a(paramCanvas, getHeight());
      AppMethodBeat.o(149405);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(149406);
      super.onMeasure(paramInt1, paramInt2);
      setMeasuredDimension(Math.min(Math.round(ne.d(ne.this) + 12.0F * ne.c(ne.this)), ne.e(ne.this) / 2), Math.round(ne.f(ne.this) * ne.c(ne.this)));
      AppMethodBeat.o(149406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ne
 * JD-Core Version:    0.7.0.1
 */