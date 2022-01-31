package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.a;
import com.tencent.map.lib.d;
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

public class ms
  implements mp
{
  private static ReentrantReadWriteLock C = new ReentrantReadWriteLock();
  private static List<na> y = new CopyOnWriteArrayList();
  private static ConcurrentHashMap<String, Bitmap> z = new ConcurrentHashMap();
  private String A = null;
  private AtomicInteger B = new AtomicInteger(0);
  private int D = 0;
  private final int[] E = { 2000000, 1000000, 500000, 200000, 100000, 50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5 };
  private String F = "50m";
  private Paint G;
  private Paint H;
  private int I = 11;
  private int J = 109;
  private float K = 1.0F;
  private int L;
  private double M;
  private ms.a N;
  private boolean O = true;
  private LinearLayout P;
  private LinearLayout Q;
  private final int R;
  private final int S;
  private final int T = 18;
  private float U = 1.4E-45F;
  private boolean V = true;
  private Context a;
  private ImageView b;
  private Bitmap c;
  private Bitmap d;
  private mp.b e = mp.b.c;
  private mp.b f = mp.b.a;
  private boolean g = true;
  private ViewGroup h;
  private float[] i = { -1.0F, -1.0F, -1.0F, -1.0F };
  private int[] j = { -1, -1, -1, -1 };
  private int[] k = { -1, -1, -1, -1 };
  private int[] l = new int[mp.a.values().length];
  private int[] m = new int[mp.a.values().length];
  private float[] n = { 0.02F, 0.02F, 0.012F, 0.012F };
  private float[] o = { 0.022F, 0.022F, 0.0125F, 0.0125F };
  private float[] p = { 0.0185F, 0.0185F, 0.0104F, 0.0104F };
  private int q = 0;
  private int r = 0;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private boolean w = false;
  private TextView x;
  
  public ms(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.R = paramInt1;
    this.S = paramInt2;
    this.b = new ImageView(paramContext);
    this.N = new ms.a(this, this.a);
    this.x = new TextView(this.a);
    this.x.setText(this.F);
    this.x.setTextSize(12.0F);
    this.x.setTextColor(-16777216);
    this.x.setGravity(1);
    this.K = paramContext.getResources().getDisplayMetrics().density;
    if (this.K <= 0.0F) {
      this.K = 1.0F;
    }
    this.G = new Paint();
    this.G.setAntiAlias(true);
    this.G.setColor(-16777216);
    this.G.setStrokeWidth(this.K * 1.0F);
    this.G.setStyle(Paint.Style.STROKE);
    this.H = new Paint(65);
    this.H.setStyle(Paint.Style.FILL);
    this.H.setColor(0);
    this.P = new LinearLayout(this.a);
    this.P.setOrientation(1);
    this.P.setGravity(16);
    this.Q = new LinearLayout(this.a);
    this.Q.setOrientation(1);
    this.Q.setGravity(16);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.Q.addView(this.x, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.Q.addView(this.N, paramContext);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 3;
    this.P.addView(this.b, paramContext);
    a(nb.g());
  }
  
  private void a(Bitmap paramBitmap)
  {
    try
    {
      this.c = paramBitmap;
      if (this.c != null)
      {
        this.s = this.c.getWidth();
        this.t = this.c.getHeight();
      }
      l();
      m();
      return;
    }
    catch (Exception paramBitmap) {}
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    int i1 = (int)(6.0F * this.K);
    paramInt /= 2;
    paramCanvas.drawPaint(this.H);
    paramCanvas.drawLine(i1, paramInt, this.J + i1, paramInt, this.G);
    paramCanvas.drawLine(i1, paramInt - this.K * 3.0F, i1, paramInt + 1, this.G);
    paramCanvas.drawLine(this.J + i1, paramInt - this.K * 3.0F, this.J + i1, paramInt + 1, this.G);
  }
  
  /* Error */
  private boolean a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   6: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   9: invokevirtual 361	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   12: aload_2
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial 364	com/tencent/tencentmap/mapsdk/a/ms:b	(Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_1
    //   24: new 366	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 372	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +18 -> 57
    //   42: aconst_null
    //   43: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   46: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   49: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   52: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   55: iconst_0
    //   56: ireturn
    //   57: new 382	java/io/FileOutputStream
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 385	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_1
    //   66: aload_2
    //   67: getstatic 391	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   70: bipush 100
    //   72: aload_1
    //   73: invokevirtual 395	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   76: istore_3
    //   77: aload_1
    //   78: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   81: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   84: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   87: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   90: iload_3
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   99: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: aload 4
    //   113: astore_2
    //   114: aload_2
    //   115: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   118: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   121: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   124: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   127: aload_1
    //   128: athrow
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: astore_1
    //   136: goto -22 -> 114
    //   139: astore_2
    //   140: goto -45 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ms
    //   0	143	1	paramString	String
    //   0	143	2	paramBitmap	Bitmap
    //   37	54	3	bool	boolean
    //   1	111	4	localObject1	Object
    //   129	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	38	92	java/lang/Throwable
    //   57	66	92	java/lang/Throwable
    //   24	38	110	finally
    //   57	66	110	finally
    //   66	77	129	finally
    //   66	77	139	java/lang/Throwable
  }
  
  private String b(String paramString)
  {
    String str = h();
    v.a(str);
    return str + "/" + paramString;
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i3 = this.E.length;
    int i2 = this.L - this.R;
    int i1 = i2;
    if (i2 < 0) {
      i1 = 0;
    }
    i2 = i1;
    if (i1 >= i3) {
      i2 = i3 - 1;
    }
    i1 = this.E[i2];
    float f1 = paramInt1;
    if (this.M != 0.0D) {
      f1 = (float)(i1 / this.M);
    }
    this.J = Math.round(f1);
    String str;
    if (this.J > paramInt2)
    {
      this.J = paramInt2;
      str = "m";
      if (i1 <= 2000) {
        break label164;
      }
      paramInt1 = i1 / 1000;
      str = "km";
    }
    for (;;)
    {
      this.F = (paramInt1 + str);
      return;
      if (this.J >= paramInt1) {
        break;
      }
      this.J = paramInt1;
      break;
      label164:
      paramInt1 = i1;
    }
  }
  
  /* Error */
  private Bitmap c(String paramString)
  {
    // Byte code:
    //   0: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 435	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 438	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: new 366	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 364	com/tencent/tencentmap/mapsdk/a/ms:b	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 372	java/io/File:exists	()Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifne +18 -> 46
    //   31: aconst_null
    //   32: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   35: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   38: invokevirtual 435	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   41: invokevirtual 439	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   44: aconst_null
    //   45: areturn
    //   46: new 441	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 442	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 448	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   59: astore_3
    //   60: aload_1
    //   61: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   64: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   67: invokevirtual 435	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   70: invokevirtual 439	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   82: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   85: invokevirtual 435	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   88: invokevirtual 439	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_3
    //   96: aload_3
    //   97: invokestatic 377	com/tencent/tencentmap/mapsdk/a/v:a	(Ljava/io/Closeable;)V
    //   100: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   103: invokevirtual 435	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   106: invokevirtual 439	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   109: aload_1
    //   110: athrow
    //   111: astore_3
    //   112: aload_1
    //   113: astore 4
    //   115: aload_3
    //   116: astore_1
    //   117: aload 4
    //   119: astore_3
    //   120: goto -24 -> 96
    //   123: astore_3
    //   124: goto -46 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ms
    //   0	127	1	paramString	String
    //   26	2	2	bool	boolean
    //   59	38	3	localBitmap	Bitmap
    //   111	5	3	localObject1	Object
    //   119	1	3	localObject2	Object
    //   123	1	3	localThrowable	Throwable
    //   113	5	4	str	String
    // Exception table:
    //   from	to	target	type
    //   9	27	75	java/lang/Throwable
    //   46	55	75	java/lang/Throwable
    //   9	27	93	finally
    //   46	55	93	finally
    //   55	60	111	finally
    //   55	60	123	java/lang/Throwable
  }
  
  private int[] c(int paramInt1, int paramInt2)
  {
    float f2 = 1.0F;
    float f1;
    if (this.U != 1.4E-45F) {
      f1 = this.U;
    }
    for (;;)
    {
      return new int[] { (int)(paramInt1 * f1), (int)(f1 * paramInt2) };
      f1 = f2;
      switch (this.D)
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
  
  private void g()
  {
    a(this.h);
  }
  
  private String h()
  {
    return this.a.getFilesDir().getAbsolutePath() + "/tencentMapSdk/logos";
  }
  
  private String i()
  {
    return this.a.getFilesDir().getAbsolutePath() + "/tencentMapSdk/oldLogos";
  }
  
  private FrameLayout.LayoutParams j()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (ms.3.a[this.e.ordinal()])
    {
    default: 
      d.b("Unknown position:" + this.e);
      return localLayoutParams;
    case 1: 
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.l[mp.a.c.e];
      localLayoutParams.leftMargin = this.l[mp.a.a.e];
      return localLayoutParams;
    case 2: 
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.l[mp.a.c.e];
      return localLayoutParams;
    case 3: 
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.l[mp.a.c.e];
      localLayoutParams.rightMargin = this.l[mp.a.b.e];
      return localLayoutParams;
    case 4: 
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.l[mp.a.d.e];
      localLayoutParams.leftMargin = this.l[mp.a.a.e];
      return localLayoutParams;
    case 5: 
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.l[mp.a.d.e];
      return localLayoutParams;
    }
    localLayoutParams.gravity = 53;
    localLayoutParams.topMargin = this.l[mp.a.d.e];
    localLayoutParams.rightMargin = this.l[mp.a.b.e];
    return localLayoutParams;
  }
  
  private FrameLayout.LayoutParams k()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    switch (ms.3.a[this.f.ordinal()])
    {
    default: 
      d.b("Unknown positionScale:" + this.f);
      return localLayoutParams;
    case 1: 
      localLayoutParams.gravity = 83;
      localLayoutParams.bottomMargin = this.m[mp.a.c.e];
      localLayoutParams.leftMargin = this.m[mp.a.a.e];
      return localLayoutParams;
    case 2: 
      localLayoutParams.gravity = 81;
      localLayoutParams.bottomMargin = this.m[mp.a.c.e];
      return localLayoutParams;
    case 3: 
      localLayoutParams.gravity = 85;
      localLayoutParams.bottomMargin = this.m[mp.a.c.e];
      localLayoutParams.rightMargin = this.m[mp.a.b.e];
      return localLayoutParams;
    case 4: 
      localLayoutParams.gravity = 51;
      localLayoutParams.topMargin = this.m[mp.a.d.e];
      localLayoutParams.leftMargin = this.m[mp.a.a.e];
      return localLayoutParams;
    case 5: 
      localLayoutParams.gravity = 49;
      localLayoutParams.topMargin = this.m[mp.a.d.e];
      return localLayoutParams;
    }
    localLayoutParams.gravity = 53;
    localLayoutParams.topMargin = this.m[mp.a.d.e];
    localLayoutParams.rightMargin = this.m[mp.a.b.e];
    return localLayoutParams;
  }
  
  private void l()
  {
    if ((this.q == 0) || (this.r == 0)) {
      return;
    }
    this.u = ((int)(this.s * this.K / 3.0F));
    this.v = ((int)(this.t * this.K / 3.0F));
    float[] arrayOfFloat = this.n;
    if (this.q >= 1080) {
      arrayOfFloat = this.p;
    }
    for (;;)
    {
      int i1 = mp.a.a.e;
      float f1 = arrayOfFloat[i1];
      if (this.i[i1] >= 0.0F) {
        f1 = this.i[i1];
      }
      this.l[i1] = ((int)(f1 * this.q));
      if (this.V) {
        this.k[mp.a.c.e] = this.v;
      }
      if ((this.j[i1] >= 0) && (this.j[i1] < this.q - this.u)) {
        this.l[i1] = this.j[i1];
      }
      i1 = mp.a.b.e;
      f1 = arrayOfFloat[i1];
      if (this.i[i1] >= 0.0F) {
        f1 = this.i[i1];
      }
      this.l[i1] = ((int)(f1 * this.q));
      if ((this.j[i1] >= 0) && (this.j[i1] < this.q - this.u)) {
        this.l[i1] = this.j[i1];
      }
      i1 = mp.a.c.e;
      f1 = arrayOfFloat[i1];
      if (this.i[i1] >= 0.0F) {
        f1 = this.i[i1];
      }
      this.l[i1] = ((int)(f1 * this.r));
      if ((this.j[i1] >= 0) && (this.j[i1] < this.r - this.v)) {
        this.l[i1] = this.j[i1];
      }
      i1 = mp.a.d.e;
      f1 = arrayOfFloat[i1];
      if (this.i[i1] >= 0.0F) {
        f1 = this.i[i1];
      }
      this.l[i1] = ((int)(f1 * this.r));
      if ((this.j[i1] >= 0) && (this.j[i1] < this.r - this.v)) {
        this.l[i1] = this.j[i1];
      }
      this.w = true;
      g();
      return;
      if (this.q >= 720) {
        arrayOfFloat = this.o;
      }
    }
  }
  
  private void m()
  {
    if ((this.q == 0) || (this.r == 0)) {
      return;
    }
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.Q.measure(i1, i2);
    i1 = this.Q.getMeasuredHeight();
    i2 = this.Q.getMeasuredWidth();
    float[] arrayOfFloat = this.n;
    if (this.q >= 1080) {
      arrayOfFloat = this.p;
    }
    for (;;)
    {
      int i3 = mp.a.a.e;
      float f1 = arrayOfFloat[i3];
      if (this.i[i3] >= 0.0F) {
        f1 = this.i[i3];
      }
      this.m[i3] = ((int)(f1 * this.q));
      if ((this.k[i3] >= 0) && (this.k[i3] < this.q - i2)) {
        this.m[i3] = this.k[i3];
      }
      i3 = mp.a.b.e;
      f1 = arrayOfFloat[i3];
      if (this.i[i3] >= 0.0F) {
        f1 = this.i[i3];
      }
      this.m[i3] = ((int)(f1 * this.q));
      if ((this.k[i3] >= 0) && (this.k[i3] < this.q - i2)) {
        this.m[i3] = this.k[i3];
      }
      i2 = mp.a.c.e;
      f1 = arrayOfFloat[i2];
      if (this.i[i2] >= 0.0F) {
        f1 = this.i[i2];
      }
      this.m[i2] = ((int)(f1 * this.r));
      if ((this.k[i2] >= 0) && (this.k[i2] < this.r - i1)) {
        this.m[i2] = this.k[i2];
      }
      i2 = mp.a.d.e;
      f1 = arrayOfFloat[i2];
      if (this.i[i2] >= 0.0F) {
        f1 = this.i[i2];
      }
      this.m[i2] = ((int)(f1 * this.r));
      if ((this.k[i2] >= 0) && (this.k[i2] < this.r - i1)) {
        this.m[i2] = this.k[i2];
      }
      g();
      return;
      if (this.q >= 720) {
        arrayOfFloat = this.o;
      }
    }
  }
  
  private void n()
  {
    int i2 = this.b.getWidth();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 1000;
    }
    b((int)Math.ceil(i1 / 4.0F), (int)(Math.ceil(this.q * 3.0F / 8.0F) - 6.0F * this.K));
    this.x.setText(this.F);
  }
  
  public void a()
  {
    if (this.B.decrementAndGet() == 0)
    {
      if (Build.VERSION.SDK_INT < 11)
      {
        Iterator localIterator = z.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Bitmap localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
          if ((localBitmap != null) && (!localBitmap.isRecycled())) {
            localBitmap.recycle();
          }
        }
      }
      z.clear();
    }
    v.a(this.d);
  }
  
  public void a(float paramFloat)
  {
    float f2 = 1.3F;
    float f1 = 0.7F;
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
        this.D = 0;
        this.U = paramFloat;
        c();
        return;
      }
    }
  }
  
  public void a(int paramInt, double paramDouble)
  {
    this.L = paramInt;
    this.M = paramDouble;
    n();
    g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.q = paramInt1;
    this.r = paramInt2;
    l();
    m();
  }
  
  public void a(a parama, int paramInt)
  {
    int i2 = (int)parama.c();
    int i1 = i2;
    if (i2 > 18) {
      i1 = 18;
    }
    Object localObject2 = y.iterator();
    Object localObject1;
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (na)((Iterator)localObject2).next();
    } while ((i1 < ((na)localObject1).a()) || (i1 > ((na)localObject1).b()));
    for (;;)
    {
      if (localObject1 == null) {}
      for (;;)
      {
        return;
        localObject1 = ((na)localObject1).a(parama, paramInt);
        if (localObject1 != null)
        {
          parama = localObject1[0];
          localObject1 = localObject1[1];
          if (parama != this.A) {}
          for (paramInt = 1; paramInt != 0; paramInt = 0)
          {
            localObject2 = (Bitmap)z.get(parama);
            if (localObject2 == null) {
              break label165;
            }
            if (((Bitmap)localObject2).isRecycled()) {
              break label157;
            }
            a((Bitmap)localObject2);
            this.A = parama;
            return;
          }
        }
      }
      label157:
      z.remove(parama);
      label165:
      localObject2 = c(parama);
      if (localObject2 != null)
      {
        this.A = parama;
        z.put(this.A, localObject2);
        a((Bitmap)localObject2);
        return;
      }
      this.A = null;
      new ms.1(this, (String)localObject1, parama).start();
      return;
      localObject1 = null;
    }
  }
  
  public void a(mp.a parama, int paramInt)
  {
    this.j[parama.e] = paramInt;
  }
  
  public void a(mp.b paramb)
  {
    if (this.e != paramb) {
      g();
    }
    this.e = paramb;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      y.clear();
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
            ((List)localObject1).add(new mx(i5, i6, localJSONObject.getString("logo_name"), localJSONObject.getString("logo"), localJSONObject.optString("logo_night"), str));
            i2 += 1;
          }
          y.add(new na(i3, i4, (List)localObject1));
          i1 += 1;
        }
        return;
      }
      catch (Throwable paramString) {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.O = paramBoolean;
    LinearLayout localLinearLayout;
    if (this.N != null)
    {
      localLinearLayout = this.Q;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i1 = 0;; i1 = 8)
    {
      localLinearLayout.setVisibility(i1);
      return;
    }
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    int i2 = 0;
    if (paramViewGroup == null) {
      return false;
    }
    Object localObject;
    if (this.w)
    {
      this.w = false;
      v.a(this.d);
      localObject = c(this.u, this.v);
      this.d = li.a(this.c, this.a, localObject[0], localObject[1]);
      if (this.d == null) {}
    }
    try
    {
      this.b.setImageBitmap(this.d);
      this.h = paramViewGroup;
      localObject = j();
      if (paramViewGroup.indexOfChild(this.P) < 0)
      {
        paramViewGroup.addView(this.P, (ViewGroup.LayoutParams)localObject);
        localObject = k();
        if (paramViewGroup.indexOfChild(this.Q) >= 0) {
          break label332;
        }
        paramViewGroup.addView(this.Q, (ViewGroup.LayoutParams)localObject);
        if ((this.x != null) && (this.N != null))
        {
          localObject = (LinearLayout.LayoutParams)this.x.getLayoutParams();
          this.N.measure(0, 0);
          this.x.measure(0, 0);
          ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)((this.J + 6.0F * this.K - this.x.getWidth()) / 2.0F));
          this.Q.updateViewLayout(this.x, (ViewGroup.LayoutParams)localObject);
          this.Q.updateViewLayout(this.N, this.N.getLayoutParams());
        }
        localObject = this.b;
        if (!this.g) {
          break label345;
        }
        i1 = 0;
        ((ImageView)localObject).setVisibility(i1);
        localObject = this.Q;
        if (!this.O) {
          break label350;
        }
        i1 = i2;
        ((LinearLayout)localObject).setVisibility(i1);
        paramViewGroup.requestLayout();
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("updateLogoError:").append(localThrowable.toString());
        continue;
        paramViewGroup.updateViewLayout(this.P, localThrowable);
        continue;
        label332:
        paramViewGroup.updateViewLayout(this.Q, localThrowable);
        continue;
        label345:
        int i1 = 4;
        continue;
        label350:
        i1 = 8;
      }
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   6: invokevirtual 361	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   9: getstatic 89	com/tencent/tencentmap/mapsdk/a/ms:z	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: invokevirtual 584	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   15: new 366	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 398	com/tencent/tencentmap/mapsdk/a/ms:h	()Ljava/lang/String;
    //   23: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: aload_1
    //   28: invokevirtual 372	java/io/File:exists	()Z
    //   31: ifeq +35 -> 66
    //   34: new 366	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 741	com/tencent/tencentmap/mapsdk/a/ms:i	()Ljava/lang/String;
    //   42: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 745	java/io/File:renameTo	(Ljava/io/File;)Z
    //   51: ifeq +25 -> 76
    //   54: new 747	com/tencent/tencentmap/mapsdk/a/ms$2
    //   57: dup
    //   58: aload_0
    //   59: aload_2
    //   60: invokespecial 750	com/tencent/tencentmap/mapsdk/a/ms$2:<init>	(Lcom/tencent/tencentmap/mapsdk/a/ms;Ljava/io/File;)V
    //   63: invokevirtual 751	com/tencent/tencentmap/mapsdk/a/ms$2:start	()V
    //   66: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   69: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   72: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   75: return
    //   76: aload_1
    //   77: invokevirtual 466	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokestatic 753	com/tencent/tencentmap/mapsdk/a/v:c	(Ljava/lang/String;)Z
    //   83: pop
    //   84: goto -18 -> 66
    //   87: astore_1
    //   88: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   91: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   94: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   97: return
    //   98: astore_1
    //   99: getstatic 94	com/tencent/tencentmap/mapsdk/a/ms:C	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   102: invokevirtual 356	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   105: invokevirtual 380	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   108: aload_1
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	ms
    //   26	51	1	localFile1	File
    //   87	1	1	localThrowable	Throwable
    //   98	11	1	localObject	Object
    //   45	15	2	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   15	66	87	java/lang/Throwable
    //   76	84	87	java/lang/Throwable
    //   15	66	98	finally
    //   76	84	98	finally
  }
  
  public void b(mp.b paramb)
  {
    if (this.f != paramb) {
      g();
    }
    this.f = paramb;
  }
  
  public void c()
  {
    l();
  }
  
  public boolean d()
  {
    return this.O;
  }
  
  public void e()
  {
    if (this.N != null) {
      this.N.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ms
 * JD-Core Version:    0.7.0.1
 */