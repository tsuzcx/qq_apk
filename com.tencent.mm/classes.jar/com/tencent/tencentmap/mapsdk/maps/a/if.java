package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.MapPoi;
import com.tencent.map.lib.element.d;
import com.tencent.map.lib.gl.JNI;
import com.tencent.map.lib.gl.JNICallback.a;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.map.lib.gl.JNICallback.d;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.i;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.gl.JNICallback.l;
import com.tencent.map.lib.mapstructure.BlockRouteCityData;
import com.tencent.map.lib.mapstructure.CircleInfo;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import javax.microedition.khronos.opengles.GL10;

public class if
  implements JNICallback.a, JNICallback.e, JNICallback.h, JNICallback.i, hi, je
{
  private static boolean i = true;
  private JNI a;
  private long b;
  private is c;
  private jf d;
  private je e;
  private JNICallback.e f;
  private ik g;
  private long h;
  private int j;
  private float k;
  private String l;
  private ReentrantReadWriteLock m;
  
  public if(Context paramContext, ik paramik)
  {
    AppMethodBeat.i(148211);
    this.h = 0L;
    this.j = 0;
    this.k = 1.0F;
    this.l = null;
    this.m = new ReentrantReadWriteLock();
    this.a = new JNI();
    this.d = new jf();
    this.d.a(this);
    this.g = paramik;
    this.k = paramContext.getResources().getDisplayMetrics().density;
    if (i) {
      jh.a(paramContext, "txmapengine");
    }
    AppMethodBeat.o(148211);
  }
  
  private void F()
  {
    AppMethodBeat.i(148321);
    this.m.readLock().lock();
    AppMethodBeat.o(148321);
  }
  
  private void G()
  {
    AppMethodBeat.i(148322);
    this.m.readLock().unlock();
    AppMethodBeat.o(148322);
  }
  
  private void H()
  {
    AppMethodBeat.i(148323);
    this.m.writeLock().lock();
    AppMethodBeat.o(148323);
  }
  
  private void I()
  {
    AppMethodBeat.i(148324);
    this.m.writeLock().unlock();
    AppMethodBeat.o(148324);
  }
  
  /* Error */
  public int A()
  {
    // Byte code:
    //   0: ldc 161
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   9: aload_0
    //   10: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   13: lstore_2
    //   14: lload_2
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +14 -> 31
    //   20: aload_0
    //   21: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   24: ldc 161
    //   26: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iconst_0
    //   30: ireturn
    //   31: aload_0
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   37: aload_0
    //   38: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   41: invokevirtual 169	com/tencent/map/lib/gl/JNI:nativeGetLanguage	(J)I
    //   44: istore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   51: ldc 161
    //   53: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iload_1
    //   57: ireturn
    //   58: astore 4
    //   60: aload_0
    //   61: monitorexit
    //   62: ldc 161
    //   64: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload 4
    //   69: athrow
    //   70: astore 4
    //   72: aload_0
    //   73: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   76: ldc 161
    //   78: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	if
    //   44	13	1	n	int
    //   13	2	2	l1	long
    //   58	10	4	localObject1	Object
    //   70	12	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	47	58	finally
    //   60	62	58	finally
    //   5	14	70	finally
    //   31	33	70	finally
    //   62	70	70	finally
  }
  
  public String B()
  {
    AppMethodBeat.i(148316);
    try
    {
      F();
      if (this.b == 0L) {
        return "";
      }
      String str = this.a.nativeGetDataEngineVersion(this.b);
      return str;
    }
    finally
    {
      G();
      AppMethodBeat.o(148316);
    }
  }
  
  public String C()
  {
    AppMethodBeat.i(148318);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return null;
      }
      String str = this.a.getMapEngineRenderStatus(this.b);
      return str;
    }
    finally
    {
      G();
      AppMethodBeat.o(148318);
    }
  }
  
  public ArrayList<MapPoi> D()
  {
    AppMethodBeat.i(148319);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return null;
      }
      ArrayList localArrayList = this.a.nativeGetPoisInScreen(this.b);
      return localArrayList;
    }
    finally
    {
      G();
      AppMethodBeat.o(148319);
    }
  }
  
  public String E()
  {
    String str = this.l;
    this.l = null;
    return str;
  }
  
  /* Error */
  public double a(Rect paramRect1, Rect paramRect2)
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   9: aload_0
    //   10: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   13: lstore 5
    //   15: lconst_0
    //   16: lload 5
    //   18: lcmp
    //   19: ifne +14 -> 33
    //   22: aload_0
    //   23: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   26: ldc 195
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: dconst_1
    //   32: dreturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 199	com/tencent/map/lib/gl/JNI:nativeGetTargetScale	(JLandroid/graphics/Rect;Landroid/graphics/Rect;)D
    //   48: dstore_3
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   55: ldc 195
    //   57: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: dload_3
    //   61: dreturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc 195
    //   67: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: aload_0
    //   74: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   77: ldc 195
    //   79: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	if
    //   0	84	1	paramRect1	Rect
    //   0	84	2	paramRect2	Rect
    //   48	13	3	d1	double
    //   13	4	5	l1	long
    // Exception table:
    //   from	to	target	type
    //   35	51	62	finally
    //   63	65	62	finally
    //   5	15	72	finally
    //   33	35	72	finally
    //   65	72	72	finally
  }
  
  public int a(d paramd)
  {
    AppMethodBeat.i(148242);
    for (;;)
    {
      long l1;
      int i1;
      boolean bool1;
      int n;
      boolean bool2;
      Object localObject1;
      try
      {
        F();
        l1 = this.b;
        if (l1 == 0L) {
          return -1;
        }
        G();
        i1 = paramd.m();
        bool1 = false;
        n = i1;
        if (i1 == 3)
        {
          n = 0;
          bool1 = true;
        }
        bool2 = false;
        localObject1 = paramd.c();
        if (localObject1[0] == 33)
        {
          n = 2;
          localObject1 = new int[0];
          if (paramd.z() == null) {
            break label175;
          }
          localObject2 = new int[paramd.z().size()];
          i1 = 0;
          localObject1 = localObject2;
          if (i1 >= paramd.z().size()) {
            break label175;
          }
          localObject2[i1] = ((Integer)paramd.z().get(i1)).intValue();
          i1 += 1;
          continue;
        }
      }
      finally
      {
        G();
        AppMethodBeat.o(148242);
      }
      label175:
      Object localObject2 = new int[0];
      if (paramd.f() != null)
      {
        int[] arrayOfInt = new int[paramd.f().length];
        i1 = 0;
        for (;;)
        {
          localObject2 = arrayOfInt;
          if (i1 >= paramd.f().length) {
            break;
          }
          arrayOfInt[i1] = paramd.f()[i1];
          i1 += 1;
        }
      }
      try
      {
        F();
        l1 = this.b;
        if (l1 == 0L) {
          return -1;
        }
        try
        {
          n = this.a.nativeCreateLine(this.b, paramd.c(), paramd.b(), (GeoPoint[])paramd.a().toArray(new GeoPoint[0]), paramd.r(), paramd.n(), n, bool1, bool2, paramd.l(), paramd.j(), paramd.v(), paramd.d(), paramd.e(), (int[])localObject2, paramd.g(), (int[])localObject1, paramd.o(), paramd.A());
          return n;
        }
        finally
        {
          AppMethodBeat.o(148242);
        }
      }
      finally
      {
        G();
        AppMethodBeat.o(148242);
      }
    }
  }
  
  public int a(CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(148225);
    if (this.b == 0L)
    {
      AppMethodBeat.o(148225);
      return 0;
    }
    try
    {
      int n = this.a.nativeAddCircle(this.b, paramCircleInfo);
      return n;
    }
    finally
    {
      AppMethodBeat.o(148225);
    }
  }
  
  public int a(MaskLayer paramMaskLayer)
  {
    AppMethodBeat.i(148230);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return 0;
      }
      int n = this.a.nativeAddMaskLayer(this.b, paramMaskLayer);
      return n;
    }
    finally
    {
      G();
      AppMethodBeat.o(148230);
    }
  }
  
  /* Error */
  public int a(com.tencent.map.lib.mapstructure.Polygon2D paramPolygon2D)
  {
    // Byte code:
    //   0: ldc_w 285
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 285
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: aload_1
    //   44: invokevirtual 289	com/tencent/map/lib/gl/JNI:nativeAddPolygon	(JLcom/tencent/map/lib/mapstructure/Polygon2D;)I
    //   47: istore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   54: ldc_w 285
    //   57: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iload_2
    //   61: ireturn
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc_w 285
    //   68: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_1
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 285
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	if
    //   0	86	1	paramPolygon2D	com.tencent.map.lib.mapstructure.Polygon2D
    //   47	14	2	n	int
    //   14	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   35	50	62	finally
    //   63	65	62	finally
    //   6	15	73	finally
    //   33	35	73	finally
    //   65	73	73	finally
  }
  
  /* Error */
  public int a(String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore 18
    //   16: lconst_0
    //   17: lload 18
    //   19: lcmp
    //   20: ifne +15 -> 35
    //   23: aload_0
    //   24: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   27: ldc_w 291
    //   30: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_0
    //   34: ireturn
    //   35: aload_0
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   41: aload_0
    //   42: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   45: aload_1
    //   46: dload_2
    //   47: dload 4
    //   49: fload 6
    //   51: fload 7
    //   53: fload 8
    //   55: fload 9
    //   57: fload 10
    //   59: fload 11
    //   61: iload 12
    //   63: iload 13
    //   65: iload 14
    //   67: iload 15
    //   69: iload 16
    //   71: iload 17
    //   73: invokevirtual 295	com/tencent/map/lib/gl/JNI:nativeAddMarker	(JLjava/lang/String;DDFFFFFFZZZZII)I
    //   76: istore 16
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_0
    //   81: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   84: ldc_w 291
    //   87: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: iload 16
    //   92: ireturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: ldc_w 291
    //   99: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: aload_0
    //   106: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   109: ldc_w 291
    //   112: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	if
    //   0	117	1	paramString	String
    //   0	117	2	paramDouble1	double
    //   0	117	4	paramDouble2	double
    //   0	117	6	paramFloat1	float
    //   0	117	7	paramFloat2	float
    //   0	117	8	paramFloat3	float
    //   0	117	9	paramFloat4	float
    //   0	117	10	paramFloat5	float
    //   0	117	11	paramFloat6	float
    //   0	117	12	paramBoolean1	boolean
    //   0	117	13	paramBoolean2	boolean
    //   0	117	14	paramBoolean3	boolean
    //   0	117	15	paramBoolean4	boolean
    //   0	117	16	paramInt1	int
    //   0	117	17	paramInt2	int
    //   14	4	18	l1	long
    // Exception table:
    //   from	to	target	type
    //   37	80	93	finally
    //   94	96	93	finally
    //   6	16	104	finally
    //   35	37	104	finally
    //   96	104	104	finally
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 297
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +17 -> 35
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_0
    //   24: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   27: ldc_w 297
    //   30: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: iconst_m1
    //   34: ireturn
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: aload_1
    //   44: iload_2
    //   45: iload_3
    //   46: iload 4
    //   48: invokevirtual 301	com/tencent/map/lib/gl/JNI:nativeRefreshTrafficData	(J[BIZZ)I
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   58: ldc_w 297
    //   61: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iload_2
    //   65: ireturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: ldc_w 297
    //   72: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   82: ldc_w 297
    //   85: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	if
    //   0	90	1	paramArrayOfByte	byte[]
    //   0	90	2	paramInt	int
    //   0	90	3	paramBoolean1	boolean
    //   0	90	4	paramBoolean2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	23	66	finally
    //   35	54	66	finally
    //   67	69	66	finally
    //   6	12	77	finally
    //   69	77	77	finally
  }
  
  /* Error */
  public android.graphics.PointF a(byte[] paramArrayOfByte, double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifne +23 -> 39
    //   19: new 305	android/graphics/PointF
    //   22: dup
    //   23: invokespecial 306	android/graphics/PointF:<init>	()V
    //   26: astore_1
    //   27: aload_0
    //   28: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   31: ldc_w 303
    //   34: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: monitorenter
    //   41: iconst_2
    //   42: newarray float
    //   44: astore 6
    //   46: aload_0
    //   47: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   50: aload_0
    //   51: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   54: aload_1
    //   55: dload_2
    //   56: dload 4
    //   58: aload 6
    //   60: invokevirtual 310	com/tencent/map/lib/gl/JNI:nativeToScreenLocation	(J[BDD[F)V
    //   63: new 305	android/graphics/PointF
    //   66: dup
    //   67: aload 6
    //   69: iconst_0
    //   70: faload
    //   71: aload 6
    //   73: iconst_1
    //   74: faload
    //   75: invokespecial 313	android/graphics/PointF:<init>	(FF)V
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_0
    //   82: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   85: ldc_w 303
    //   88: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: ldc_w 303
    //   99: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: aload_0
    //   106: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   109: ldc_w 303
    //   112: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	if
    //   0	117	1	paramArrayOfByte	byte[]
    //   0	117	2	paramDouble1	double
    //   0	117	4	paramDouble2	double
    //   44	28	6	arrayOfFloat	float[]
    // Exception table:
    //   from	to	target	type
    //   41	81	93	finally
    //   94	96	93	finally
    //   6	27	104	finally
    //   39	41	104	finally
    //   96	104	104	finally
  }
  
  /* Error */
  public GeoPoint a(byte[] paramArrayOfByte, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: ldc_w 315
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifne +23 -> 39
    //   19: new 234	com/tencent/map/lib/basemap/data/GeoPoint
    //   22: dup
    //   23: invokespecial 316	com/tencent/map/lib/basemap/data/GeoPoint:<init>	()V
    //   26: astore_1
    //   27: aload_0
    //   28: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   31: ldc_w 315
    //   34: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_1
    //   38: areturn
    //   39: aload_0
    //   40: monitorenter
    //   41: iconst_2
    //   42: newarray double
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   50: aload_0
    //   51: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   54: aload_1
    //   55: fload_2
    //   56: fload_3
    //   57: aload 5
    //   59: invokevirtual 320	com/tencent/map/lib/gl/JNI:nativeFromScreenLocation	(J[BFF[D)V
    //   62: aload 5
    //   64: iconst_0
    //   65: daload
    //   66: ldc2_w 321
    //   69: dmul
    //   70: d2i
    //   71: istore 4
    //   73: new 234	com/tencent/map/lib/basemap/data/GeoPoint
    //   76: dup
    //   77: aload 5
    //   79: iconst_1
    //   80: daload
    //   81: ldc2_w 321
    //   84: dmul
    //   85: d2i
    //   86: iload 4
    //   88: invokespecial 325	com/tencent/map/lib/basemap/data/GeoPoint:<init>	(II)V
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_0
    //   95: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   98: ldc_w 315
    //   101: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_1
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: ldc_w 315
    //   112: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: aload_0
    //   119: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   122: ldc_w 315
    //   125: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_1
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	if
    //   0	130	1	paramArrayOfByte	byte[]
    //   0	130	2	paramFloat1	float
    //   0	130	3	paramFloat2	float
    //   71	16	4	n	int
    //   44	34	5	arrayOfDouble	double[]
    // Exception table:
    //   from	to	target	type
    //   41	62	106	finally
    //   73	94	106	finally
    //   107	109	106	finally
    //   6	27	117	finally
    //   39	41	117	finally
    //   109	117	117	finally
  }
  
  /* Error */
  public com.tencent.map.lib.mapstructure.TappedElement a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: ldc_w 329
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 329
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: fload_1
    //   44: fload_2
    //   45: invokevirtual 333	com/tencent/map/lib/gl/JNI:nativeOnTap	(JFF)[B
    //   48: astore 5
    //   50: aload 5
    //   52: ifnonnull +17 -> 69
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_0
    //   58: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   61: ldc_w 329
    //   64: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aconst_null
    //   68: areturn
    //   69: aload 5
    //   71: invokestatic 339	com/tencent/map/lib/mapstructure/TappedElement:fromBytes	([B)Lcom/tencent/map/lib/mapstructure/TappedElement;
    //   74: astore 5
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   82: ldc_w 329
    //   85: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 5
    //   90: areturn
    //   91: astore 5
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_0
    //   96: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   99: ldc_w 329
    //   102: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aconst_null
    //   106: areturn
    //   107: astore 5
    //   109: aload_0
    //   110: monitorexit
    //   111: ldc_w 329
    //   114: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 5
    //   119: athrow
    //   120: astore 5
    //   122: aload_0
    //   123: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   126: ldc_w 329
    //   129: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload 5
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	if
    //   0	135	1	paramFloat1	float
    //   0	135	2	paramFloat2	float
    //   14	2	3	l1	long
    //   48	41	5	localObject1	Object
    //   91	1	5	localException	java.lang.Exception
    //   107	11	5	localObject2	Object
    //   120	13	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   69	76	91	java/lang/Exception
    //   35	50	107	finally
    //   55	57	107	finally
    //   69	76	107	finally
    //   76	78	107	finally
    //   93	95	107	finally
    //   109	111	107	finally
    //   6	15	120	finally
    //   33	35	120	finally
    //   111	120	120	finally
  }
  
  public String a(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148240);
    try
    {
      F();
      if (this.b == 0L) {
        return "";
      }
      paramGeoPoint = this.a.nativeGetCityName(this.b, paramGeoPoint);
      if (paramGeoPoint != null) {
        try
        {
          paramGeoPoint = new String(paramGeoPoint, "GBK").trim();
          return paramGeoPoint;
        }
        catch (UnsupportedEncodingException paramGeoPoint) {}
      }
      return "";
    }
    finally
    {
      G();
      AppMethodBeat.o(148240);
    }
  }
  
  /* Error */
  public List<Integer> a(Rect paramRect, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 359
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore 4
    //   16: lconst_0
    //   17: lload 4
    //   19: lcmp
    //   20: ifne +15 -> 35
    //   23: aload_0
    //   24: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   27: ldc_w 359
    //   30: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: monitorenter
    //   37: bipush 100
    //   39: newarray int
    //   41: astore 6
    //   43: aload_0
    //   44: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   47: aload_0
    //   48: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   51: aload_1
    //   52: iload_2
    //   53: aload 6
    //   55: bipush 100
    //   57: invokevirtual 363	com/tencent/map/lib/gl/JNI:nativeQueryCityCodeList	(JLandroid/graphics/Rect;I[II)I
    //   60: istore_3
    //   61: iload_3
    //   62: ifle +54 -> 116
    //   65: new 236	java/util/ArrayList
    //   68: dup
    //   69: iload_3
    //   70: invokespecial 365	java/util/ArrayList:<init>	(I)V
    //   73: astore_1
    //   74: iconst_0
    //   75: istore_2
    //   76: iload_2
    //   77: iload_3
    //   78: if_icmpge +24 -> 102
    //   81: aload_1
    //   82: aload 6
    //   84: iload_2
    //   85: iaload
    //   86: invokestatic 369	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokeinterface 373 2 0
    //   94: pop
    //   95: iload_2
    //   96: iconst_1
    //   97: iadd
    //   98: istore_2
    //   99: goto -23 -> 76
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_0
    //   105: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   108: ldc_w 359
    //   111: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_1
    //   115: areturn
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_0
    //   119: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   122: ldc_w 359
    //   125: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: ldc_w 359
    //   136: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aload_0
    //   143: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   146: ldc_w 359
    //   149: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_1
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	if
    //   0	154	1	paramRect	Rect
    //   0	154	2	paramInt	int
    //   60	19	3	n	int
    //   14	4	4	l1	long
    //   41	42	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   37	61	130	finally
    //   65	74	130	finally
    //   81	95	130	finally
    //   102	104	130	finally
    //   116	118	130	finally
    //   131	133	130	finally
    //   6	16	141	finally
    //   35	37	141	finally
    //   133	141	141	finally
  }
  
  public void a()
  {
    AppMethodBeat.i(148213);
    try
    {
      H();
      this.d.a();
      if (this.d != null) {
        this.d.a(null);
      }
      if (this.b != 0L)
      {
        this.a.nativeDestroyEngine(this.b);
        this.b = 0L;
      }
      return;
    }
    finally
    {
      I();
      AppMethodBeat.o(148213);
    }
  }
  
  public void a(double paramDouble)
  {
    AppMethodBeat.i(148275);
    try
    {
      F();
      if (0L != this.b)
      {
        ik localik = this.g;
        if (localik != null) {}
      }
      else
      {
        return;
      }
      this.a.nativeSetScale(this.b, paramDouble, false);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148275);
    }
  }
  
  public void a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(148274);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148274);
      return;
    }
    this.g.a(new if.18(this, paramDouble, paramBoolean));
    AppMethodBeat.o(148274);
  }
  
  /* Error */
  public void a(float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 405
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 405
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: fload_1
    //   43: iconst_0
    //   44: invokevirtual 409	com/tencent/map/lib/gl/JNI:nativeSetRotate	(JFZ)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 405
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore 4
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc_w 405
    //   67: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload 4
    //   72: athrow
    //   73: astore 4
    //   75: aload_0
    //   76: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   79: ldc_w 405
    //   82: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	if
    //   0	88	1	paramFloat	float
    //   14	3	2	l1	long
    //   60	11	4	localObject1	Object
    //   73	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	49	60	finally
    //   62	64	60	finally
    //   6	15	73	finally
    //   32	34	73	finally
    //   64	73	73	finally
  }
  
  public void a(final float paramFloat1, final float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(148270);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148270);
      return;
    }
    this.g.a(new ik.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(148185);
        if (if.a(if.this) != 0L) {
          if.b(if.this).nativeMoveBy(if.a(if.this), paramFloat1, paramFloat2, paramBoolean);
        }
        AppMethodBeat.o(148185);
      }
    });
    AppMethodBeat.o(148270);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(148227);
    if ((this.b == 0L) || (paramInt < 0) || (this.g == null))
    {
      AppMethodBeat.o(148227);
      return;
    }
    this.g.a(new if.1(this, paramInt));
    AppMethodBeat.o(148227);
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(148229);
    try
    {
      F();
      if ((this.b != 0L) && (paramInt1 >= 0))
      {
        ik localik = this.g;
        if (localik != null) {}
      }
      else
      {
        return;
      }
      this.g.a(new ik.a()
      {
        public void a(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(148210);
          if.b(if.this).nativeDeletePolygon(if.a(if.this), paramInt1, paramInt2);
          AppMethodBeat.o(148210);
        }
      });
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148229);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148294);
    if ((this.b == 0L) || (this.g == null))
    {
      AppMethodBeat.o(148294);
      return;
    }
    this.g.a(new if.26(this, paramInt1, paramInt2, paramInt3));
    AppMethodBeat.o(148294);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148282);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148282);
      return;
    }
    this.g.a(new if.24(this, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(148282);
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: ldc_w 440
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifeq +25 -> 41
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   25: aload_0
    //   26: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   29: iload_1
    //   30: iload_2
    //   31: iload_3
    //   32: iload 4
    //   34: iload 5
    //   36: invokevirtual 444	com/tencent/map/lib/gl/JNI:nativeCheckTrafficBlockCache	(JIIIII)V
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   45: ldc_w 440
    //   48: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: return
    //   52: astore 6
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc_w 440
    //   59: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload 6
    //   64: athrow
    //   65: astore 6
    //   67: aload_0
    //   68: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   71: ldc_w 440
    //   74: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload 6
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	if
    //   0	80	1	paramInt1	int
    //   0	80	2	paramInt2	int
    //   0	80	3	paramInt3	int
    //   0	80	4	paramInt4	int
    //   0	80	5	paramInt5	int
    //   52	11	6	localObject1	Object
    //   65	13	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	41	52	finally
    //   54	56	52	finally
    //   6	21	65	finally
    //   56	65	65	finally
  }
  
  public void a(int paramInt, CircleInfo paramCircleInfo)
  {
    AppMethodBeat.i(148226);
    if (this.b == 0L)
    {
      AppMethodBeat.o(148226);
      return;
    }
    try
    {
      this.a.nativeUpdateCircle(this.b, paramInt, paramCircleInfo);
      return;
    }
    finally
    {
      AppMethodBeat.o(148226);
    }
  }
  
  public void a(int paramInt1, String paramString, double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148259);
    if (0L == this.b)
    {
      AppMethodBeat.o(148259);
      return;
    }
    this.g.a(new if.6(this, paramInt1, paramString, paramDouble1, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt2, paramInt3));
    AppMethodBeat.o(148259);
  }
  
  /* Error */
  public void a(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 459
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 459
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: iload_1
    //   33: iconst_m1
    //   34: if_icmpne +14 -> 48
    //   37: aload_0
    //   38: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   41: ldc_w 459
    //   44: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: return
    //   48: aload_0
    //   49: monitorenter
    //   50: aload_0
    //   51: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   54: aload_0
    //   55: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   58: iload_1
    //   59: i2l
    //   60: iload_2
    //   61: invokevirtual 463	com/tencent/map/lib/gl/JNI:nativeDeleteLine	(JJZ)V
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_0
    //   67: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   70: ldc_w 459
    //   73: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore 5
    //   79: aload_0
    //   80: monitorexit
    //   81: ldc_w 459
    //   84: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload 5
    //   89: athrow
    //   90: astore 5
    //   92: aload_0
    //   93: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   96: ldc_w 459
    //   99: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload 5
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	if
    //   0	105	1	paramInt	int
    //   0	105	2	paramBoolean	boolean
    //   14	2	3	l1	long
    //   77	11	5	localObject1	Object
    //   90	13	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   50	66	77	finally
    //   79	81	77	finally
    //   6	15	90	finally
    //   48	50	90	finally
    //   81	90	90	finally
  }
  
  public void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    AppMethodBeat.i(148264);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148264);
      return;
    }
    this.g.a(new if.10(this, paramRect1, paramRect2, paramBoolean));
    AppMethodBeat.o(148264);
  }
  
  public void a(GeoPoint paramGeoPoint, boolean paramBoolean)
  {
    AppMethodBeat.i(148271);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148271);
      return;
    }
    this.g.a(new if.17(this, paramGeoPoint, paramBoolean));
    AppMethodBeat.o(148271);
  }
  
  public void a(JNICallback.b paramb)
  {
    AppMethodBeat.i(148301);
    this.a.setHandDrawTileLoadCallback(paramb);
    AppMethodBeat.o(148301);
  }
  
  public void a(JNICallback.c paramc)
  {
    AppMethodBeat.i(148302);
    this.a.setHandDrawTileWriteCallback(paramc);
    AppMethodBeat.o(148302);
  }
  
  public void a(JNICallback.d paramd)
  {
    AppMethodBeat.i(148299);
    this.a.setHeatTileLoadCallback(paramd);
    AppMethodBeat.o(148299);
  }
  
  public void a(JNICallback.e parame)
  {
    this.f = parame;
  }
  
  public void a(JNICallback.k paramk)
  {
    AppMethodBeat.i(148300);
    this.a.setWorldTileLoadCallback(paramk);
    AppMethodBeat.o(148300);
  }
  
  public void a(JNICallback.l paraml)
  {
    AppMethodBeat.i(148303);
    this.a.setTileWriteCallback(paraml);
    AppMethodBeat.o(148303);
  }
  
  public void a(is paramis)
  {
    this.c = paramis;
  }
  
  public void a(jd paramjd)
  {
    AppMethodBeat.i(148212);
    this.d.a(paramjd);
    AppMethodBeat.o(148212);
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(148317);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeSetBuildingToSpecificFloor(this.b, paramString1, paramString2);
      if (this.f != null) {
        this.f.y();
      }
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148317);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148254);
    this.g.a(new if.3(this, paramString, paramArrayOfByte));
    if (this.e != null) {
      this.e.a(paramString, paramArrayOfByte);
    }
    AppMethodBeat.o(148254);
  }
  
  public void a(List<BlockRouteCityData> paramList)
  {
    AppMethodBeat.i(148309);
    for (;;)
    {
      try
      {
        F();
        long l1 = this.b;
        if (0L == l1) {
          return;
        }
        if (paramList != null) {}
        int n;
        try
        {
          if (paramList.isEmpty()) {
            return;
          }
          int i1 = paramList.size();
          int[] arrayOfInt1 = new int[i1];
          int[] arrayOfInt2 = new int[i1];
          n = 0;
          if (n < i1)
          {
            BlockRouteCityData localBlockRouteCityData = (BlockRouteCityData)paramList.get(n);
            if (localBlockRouteCityData != null)
            {
              arrayOfInt1[n] = localBlockRouteCityData.cityCode;
              arrayOfInt2[n] = localBlockRouteCityData.version;
            }
          }
          else
          {
            this.a.nativeLoadBlockRouteCityList(this.b, arrayOfInt1, arrayOfInt2, i1);
            return;
          }
        }
        finally
        {
          AppMethodBeat.o(148309);
        }
        n += 1;
      }
      finally
      {
        G();
        AppMethodBeat.o(148309);
      }
    }
  }
  
  public void a(List<MapRouteSectionWithName> paramList, List<GeoPoint> paramList1)
  {
    AppMethodBeat.i(148305);
    for (;;)
    {
      try
      {
        F();
        long l1 = this.b;
        if (0L == l1) {
          return;
        }
        if (paramList != null) {}
        int n;
        try
        {
          if ((!paramList.isEmpty()) && (paramList1 != null) && (!paramList1.isEmpty()))
          {
            int i1 = paramList.size();
            byte[][] arrayOfByte = new byte[i1][];
            n = 0;
            if (n < i1)
            {
              MapRouteSectionWithName localMapRouteSectionWithName = (MapRouteSectionWithName)paramList.get(n);
              if (localMapRouteSectionWithName != null) {
                arrayOfByte[n] = localMapRouteSectionWithName.toBytes();
              }
            }
            else
            {
              n = paramList1.size();
              this.a.nativeAddRouteNameSegments(this.b, arrayOfByte, i1, (GeoPoint[])paramList1.toArray(new GeoPoint[n]), n);
            }
          }
          else
          {
            return;
          }
        }
        finally
        {
          AppMethodBeat.o(148305);
        }
        n += 1;
      }
      finally
      {
        G();
        AppMethodBeat.o(148305);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148237);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.g.a(new if.22(this, paramBoolean));
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148237);
    }
  }
  
  /* Error */
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 576
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lconst_0
    //   16: lload_3
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 576
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: aload_1
    //   43: iload_2
    //   44: invokevirtual 580	com/tencent/map/lib/gl/JNI:nativeDeleteIcons	(J[II)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 576
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: ldc_w 576
    //   66: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload_1
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   76: ldc_w 576
    //   79: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	if
    //   0	84	1	paramArrayOfInt	int[]
    //   0	84	2	paramInt	int
    //   14	3	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   34	49	60	finally
    //   61	63	60	finally
    //   6	15	71	finally
    //   32	34	71	finally
    //   63	71	71	finally
  }
  
  public void a(final String[] paramArrayOfString)
  {
    AppMethodBeat.i(148268);
    if (this.b == 0L)
    {
      AppMethodBeat.o(148268);
      return;
    }
    this.g.a(new ik.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(148182);
        if (if.a(if.this) != 0L) {
          if.b(if.this).nativeSetShowIndoorBuildingWhiteList(if.a(if.this), paramArrayOfString);
        }
        AppMethodBeat.o(148182);
      }
    });
    AppMethodBeat.o(148268);
  }
  
  /* Error */
  public boolean a(Context paramContext, it paramit, String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 587
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 591	com/tencent/tencentmap/mapsdk/maps/a/il:a	()Z
    //   9: istore 7
    //   11: iconst_1
    //   12: newarray int
    //   14: astore 8
    //   16: aload_0
    //   17: invokespecial 377	com/tencent/tencentmap/mapsdk/maps/a/if:H	()V
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   25: aload_3
    //   26: aload 4
    //   28: aload 5
    //   30: aload_1
    //   31: invokestatic 597	com/tencent/map/lib/util/SystemUtil:getDensity	(Landroid/content/Context;)F
    //   34: sipush 256
    //   37: aload_1
    //   38: invokestatic 597	com/tencent/map/lib/util/SystemUtil:getDensity	(Landroid/content/Context;)F
    //   41: aload 8
    //   43: iload 7
    //   45: getstatic 603	com/tencent/map/lib/MapLanguage:LAN_CHINESE	Lcom/tencent/map/lib/MapLanguage;
    //   48: invokevirtual 606	com/tencent/map/lib/MapLanguage:ordinal	()I
    //   51: invokevirtual 610	com/tencent/map/lib/gl/JNI:nativeInitEngine	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FIF[IZI)J
    //   54: putfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   57: aload 8
    //   59: iconst_0
    //   60: iaload
    //   61: ifeq +43 -> 104
    //   64: new 612	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 614
    //   71: invokespecial 616	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload 8
    //   76: iconst_0
    //   77: iaload
    //   78: invokevirtual 620	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 623	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 627	com/tencent/map/lib/d:a	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   92: aload_0
    //   93: invokespecial 385	com/tencent/tencentmap/mapsdk/maps/a/if:I	()V
    //   96: ldc_w 587
    //   99: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: iconst_0
    //   103: ireturn
    //   104: aload_0
    //   105: invokespecial 385	com/tencent/tencentmap/mapsdk/maps/a/if:I	()V
    //   108: aload_0
    //   109: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   112: aload_0
    //   113: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   116: lconst_0
    //   117: lcmp
    //   118: ifeq +50 -> 168
    //   121: aload_0
    //   122: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   125: aload_2
    //   126: aload_0
    //   127: aload_0
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 100	com/tencent/tencentmap/mapsdk/maps/a/if:g	Lcom/tencent/tencentmap/mapsdk/maps/a/ik;
    //   133: invokevirtual 630	com/tencent/tencentmap/mapsdk/maps/a/ik:a	()Lcom/tencent/tencentmap/mapsdk/maps/a/ii;
    //   136: aload_0
    //   137: aload_0
    //   138: aload_0
    //   139: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   142: invokevirtual 634	com/tencent/map/lib/gl/JNI:initCallback	(Lcom/tencent/tencentmap/mapsdk/maps/a/it;Lcom/tencent/map/lib/gl/JNICallback$a;Lcom/tencent/map/lib/gl/JNICallback$h;Lcom/tencent/map/lib/gl/JNICallback$e;Lcom/tencent/map/lib/gl/JNICallback$g;Lcom/tencent/tencentmap/mapsdk/maps/a/hi;Lcom/tencent/map/lib/gl/JNICallback$i;J)V
    //   145: aload_0
    //   146: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   149: aload_0
    //   150: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   153: ldc_w 635
    //   156: ldc_w 636
    //   159: ldc_w 637
    //   162: ldc_w 638
    //   165: invokevirtual 642	com/tencent/map/lib/gl/JNI:nativeSetTrafficColor	(JIIII)V
    //   168: aload_0
    //   169: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   172: ldc_w 587
    //   175: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_1
    //   181: aload_0
    //   182: invokespecial 385	com/tencent/tencentmap/mapsdk/maps/a/if:I	()V
    //   185: ldc_w 587
    //   188: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: aload_0
    //   195: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   198: ldc_w 587
    //   201: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	if
    //   0	206	1	paramContext	Context
    //   0	206	2	paramit	it
    //   0	206	3	paramString1	String
    //   0	206	4	paramString2	String
    //   0	206	5	paramString3	String
    //   0	206	6	paramFloat	float
    //   9	35	7	bool	boolean
    //   14	61	8	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   16	57	180	finally
    //   64	92	180	finally
    //   108	168	193	finally
  }
  
  /* Error */
  public com.tencent.map.lib.element.c b(GeoPoint paramGeoPoint)
  {
    // Byte code:
    //   0: ldc_w 644
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lconst_0
    //   16: lload_3
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 644
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_1
    //   34: astore 5
    //   36: aload_1
    //   37: ifnonnull +12 -> 49
    //   40: new 234	com/tencent/map/lib/basemap/data/GeoPoint
    //   43: dup
    //   44: invokespecial 316	com/tencent/map/lib/basemap/data/GeoPoint:<init>	()V
    //   47: astore 5
    //   49: aload_0
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   55: aload_0
    //   56: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   59: invokevirtual 647	com/tencent/map/lib/gl/JNI:nativeGetActiveIndoorBuildingGUID	(J)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   67: aload_0
    //   68: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   71: aload 5
    //   73: invokevirtual 651	com/tencent/map/lib/gl/JNI:nativeGetCurIndoorName	(JLcom/tencent/map/lib/basemap/data/GeoPoint;)Ljava/lang/String;
    //   76: astore 5
    //   78: aload_0
    //   79: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   82: aload_0
    //   83: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   86: invokevirtual 654	com/tencent/map/lib/gl/JNI:nativeGetIndoorCurrentFloorId	(J)I
    //   89: istore_2
    //   90: new 656	com/tencent/map/lib/element/c
    //   93: dup
    //   94: aload_1
    //   95: aload 5
    //   97: aload_0
    //   98: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   101: aload_0
    //   102: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   105: invokevirtual 660	com/tencent/map/lib/gl/JNI:nativeGetIndoorFloorNames	(J)[Ljava/lang/String;
    //   108: iload_2
    //   109: invokespecial 663	com/tencent/map/lib/element/c:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;I)V
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_0
    //   116: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   119: ldc_w 644
    //   122: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_1
    //   126: areturn
    //   127: astore_1
    //   128: aload_0
    //   129: monitorexit
    //   130: ldc_w 644
    //   133: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   143: ldc_w 644
    //   146: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_1
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	if
    //   0	151	1	paramGeoPoint	GeoPoint
    //   89	20	2	n	int
    //   14	3	3	l1	long
    //   34	62	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	115	127	finally
    //   128	130	127	finally
    //   6	15	138	finally
    //   40	49	138	finally
    //   49	51	138	finally
    //   130	138	138	finally
  }
  
  /* Error */
  public void b(float paramFloat)
  {
    // Byte code:
    //   0: ldc_w 664
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 664
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: fload_1
    //   43: iconst_0
    //   44: invokevirtual 667	com/tencent/map/lib/gl/JNI:nativeSetSkew	(JFZ)V
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 664
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore 4
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc_w 664
    //   67: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload 4
    //   72: athrow
    //   73: astore 4
    //   75: aload_0
    //   76: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   79: ldc_w 664
    //   82: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	if
    //   0	88	1	paramFloat	float
    //   14	3	2	l1	long
    //   60	11	4	localObject1	Object
    //   73	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	49	60	finally
    //   62	64	60	finally
    //   6	15	73	finally
    //   32	34	73	finally
    //   64	73	73	finally
  }
  
  public void b(final float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(148279);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148279);
      return;
    }
    this.g.a(new ik.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(148190);
        if (if.a(if.this) != 0L) {
          if.b(if.this).nativeZoomIn(if.a(if.this), paramFloat1, paramFloat2);
        }
        AppMethodBeat.o(148190);
      }
    });
    AppMethodBeat.o(148279);
  }
  
  public void b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(148281);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148281);
      return;
    }
    this.g.a(new if.23(this, paramBoolean, paramFloat1, paramFloat2));
    AppMethodBeat.o(148281);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(148232);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeRemoveMaskLayer(this.b, paramInt);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148232);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148231);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeUpdateMaskLayer(this.b, paramInt1, paramInt2);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148231);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(148277);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148277);
      return;
    }
    this.g.a(new if.19(this, paramInt, paramBoolean));
    AppMethodBeat.o(148277);
  }
  
  /* Error */
  public void b(d paramd)
  {
    // Byte code:
    //   0: ldc_w 695
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 695
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 695
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_1
    //   56: invokevirtual 702	com/tencent/map/lib/element/d:q	()Lcom/tencent/map/lib/element/d$a;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnonnull +16 -> 77
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_0
    //   67: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   70: ldc_w 695
    //   73: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: aload_0
    //   78: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   81: aload_0
    //   82: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   85: iload_2
    //   86: i2l
    //   87: aload_1
    //   88: getfield 706	com/tencent/map/lib/element/d$a:a	I
    //   91: aload_1
    //   92: getfield 708	com/tencent/map/lib/element/d$a:b	I
    //   95: invokevirtual 712	com/tencent/map/lib/gl/JNI:nativeSetTurnArrow	(JJII)V
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   104: ldc_w 695
    //   107: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: ldc_w 695
    //   117: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   127: ldc_w 695
    //   130: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	if
    //   0	135	1	paramd	d
    //   36	50	2	n	int
    //   14	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   55	60	111	finally
    //   64	66	111	finally
    //   77	100	111	finally
    //   112	114	111	finally
    //   6	15	122	finally
    //   32	37	122	finally
    //   53	55	122	finally
    //   114	122	122	finally
  }
  
  /* Error */
  public void b(com.tencent.map.lib.mapstructure.Polygon2D paramPolygon2D)
  {
    // Byte code:
    //   0: ldc_w 714
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lload_2
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 714
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: aload_1
    //   43: getfield 719	com/tencent/map/lib/mapstructure/Polygon2D:polygonId	I
    //   46: aload_1
    //   47: getfield 722	com/tencent/map/lib/mapstructure/Polygon2D:borldLineId	I
    //   50: aload_1
    //   51: invokevirtual 726	com/tencent/map/lib/gl/JNI:nativeUpdatePolygon	(JIILcom/tencent/map/lib/mapstructure/Polygon2D;)V
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_0
    //   57: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   60: ldc_w 714
    //   63: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: return
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: ldc_w 714
    //   73: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_1
    //   77: athrow
    //   78: astore_1
    //   79: aload_0
    //   80: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   83: ldc_w 714
    //   86: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	if
    //   0	91	1	paramPolygon2D	com.tencent.map.lib.mapstructure.Polygon2D
    //   14	2	2	l1	long
    // Exception table:
    //   from	to	target	type
    //   34	56	67	finally
    //   68	70	67	finally
    //   6	15	78	finally
    //   32	34	78	finally
    //   70	78	78	finally
  }
  
  public void b(String paramString)
  {
    AppMethodBeat.i(148241);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.g.a(new if.32(this, paramString));
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148241);
    }
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 733
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: lconst_0
    //   11: aload_0
    //   12: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   15: lcmp
    //   16: ifeq +19 -> 35
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   25: aload_0
    //   26: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   29: iload_1
    //   30: invokevirtual 737	com/tencent/map/lib/gl/JNI:nativeSetBuilding3DEffect	(JZ)V
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   39: ldc_w 733
    //   42: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: return
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: ldc_w 733
    //   52: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: athrow
    //   57: astore_2
    //   58: aload_0
    //   59: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   62: ldc_w 733
    //   65: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_2
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	if
    //   0	70	1	paramBoolean	boolean
    //   46	10	2	localObject1	Object
    //   57	12	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	35	46	finally
    //   47	49	46	finally
    //   6	21	57	finally
    //   49	57	57	finally
  }
  
  public boolean b()
  {
    AppMethodBeat.i(148215);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      boolean bool = this.a.nativeGenerateTextures(this.b);
      return bool;
    }
    finally
    {
      G();
      AppMethodBeat.o(148215);
    }
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(148266);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148266);
      return;
    }
    this.g.a(new if.12(this, paramInt));
    AppMethodBeat.o(148266);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148262);
    if (0L == this.b)
    {
      AppMethodBeat.o(148262);
      return;
    }
    this.g.a(new if.8(this, paramInt1, paramInt2));
    AppMethodBeat.o(148262);
  }
  
  public void c(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(148289);
    if (0L == this.b)
    {
      AppMethodBeat.o(148289);
      return;
    }
    this.g.a(new if.25(this, paramInt, paramBoolean));
    AppMethodBeat.o(148289);
  }
  
  public void c(GeoPoint paramGeoPoint)
  {
    AppMethodBeat.i(148272);
    try
    {
      F();
      if (0L != this.b)
      {
        ik localik = this.g;
        if (localik != null) {}
      }
      else
      {
        return;
      }
      this.a.nativeSetCenter(this.b, paramGeoPoint, false);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148272);
    }
  }
  
  public void c(final d paramd)
  {
    AppMethodBeat.i(148245);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      final int n = paramd.s();
      if (n == -1) {
        return;
      }
      paramd = paramd.y();
      this.g.a(new ik.a()
      {
        public void a(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(148204);
          if.b(if.this).nativeSetTurnArrowStyle(if.a(if.this), n, paramd[0], paramd[1]);
          AppMethodBeat.o(148204);
        }
      });
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148245);
    }
  }
  
  public void c(String paramString)
  {
    AppMethodBeat.i(148255);
    this.j += 1;
    if (this.j >= 30)
    {
      m();
      this.j = 0;
    }
    this.g.a(new if.4(this, paramString));
    if (this.e != null) {
      this.e.c(paramString);
    }
    AppMethodBeat.o(148255);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(148261);
    if (0L == this.b)
    {
      AppMethodBeat.o(148261);
      return;
    }
    this.g.a(new if.7(this, paramBoolean));
    AppMethodBeat.o(148261);
  }
  
  public boolean c()
  {
    AppMethodBeat.i(148216);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      this.a.nativeDrawFrame(this.b);
      return true;
    }
    finally
    {
      G();
      AppMethodBeat.o(148216);
    }
  }
  
  public int d()
  {
    AppMethodBeat.i(148217);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return -1;
      }
      int n = this.a.nativeClearCache(this.b);
      return n;
    }
    finally
    {
      G();
      AppMethodBeat.o(148217);
    }
  }
  
  /* Error */
  public int d(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 788
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 788
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_m1
    //   32: ireturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: iload_1
    //   44: iload_2
    //   45: invokevirtual 792	com/tencent/map/lib/gl/JNI:nativeAddHeatTileOverlay	(JIZ)I
    //   48: istore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_0
    //   52: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   55: ldc_w 788
    //   58: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_1
    //   62: ireturn
    //   63: astore 5
    //   65: aload_0
    //   66: monitorexit
    //   67: ldc_w 788
    //   70: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aload 5
    //   75: athrow
    //   76: astore 5
    //   78: aload_0
    //   79: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   82: ldc_w 788
    //   85: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aload 5
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	if
    //   0	91	1	paramInt	int
    //   0	91	2	paramBoolean	boolean
    //   14	2	3	l1	long
    //   63	11	5	localObject1	Object
    //   76	13	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	51	63	finally
    //   65	67	63	finally
    //   6	15	76	finally
    //   33	35	76	finally
    //   67	76	76	finally
  }
  
  /* Error */
  public void d(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 793
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 793
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: iload_1
    //   43: invokevirtual 796	com/tencent/map/lib/gl/JNI:nativeSetMaxScaleLevel	(JI)V
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   52: ldc_w 793
    //   55: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore 4
    //   61: aload_0
    //   62: monitorexit
    //   63: ldc_w 793
    //   66: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload 4
    //   71: athrow
    //   72: astore 4
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 793
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	if
    //   0	87	1	paramInt	int
    //   14	3	2	l1	long
    //   59	11	4	localObject1	Object
    //   72	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	48	59	finally
    //   61	63	59	finally
    //   6	15	72	finally
    //   32	34	72	finally
    //   63	72	72	finally
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(148304);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeBringElementAbove(this.b, paramInt1, paramInt2);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148304);
    }
  }
  
  /* Error */
  public void d(d paramd)
  {
    // Byte code:
    //   0: ldc_w 801
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 801
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 801
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   59: aload_0
    //   60: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   63: iload_2
    //   64: i2l
    //   65: aload_1
    //   66: invokevirtual 254	com/tencent/map/lib/element/d:j	()Z
    //   69: invokevirtual 804	com/tencent/map/lib/gl/JNI:nativeSetLineDrawArrow	(JJZ)V
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 801
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: ldc_w 801
    //   91: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   101: ldc_w 801
    //   104: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	if
    //   0	109	1	paramd	d
    //   36	28	2	n	int
    //   14	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   55	74	85	finally
    //   86	88	85	finally
    //   6	15	96	finally
    //   32	37	96	finally
    //   53	55	96	finally
    //   88	96	96	finally
  }
  
  public void d(String paramString)
  {
    AppMethodBeat.i(148256);
    this.d.a(paramString);
    AppMethodBeat.o(148256);
  }
  
  public void d(boolean paramBoolean)
  {
    AppMethodBeat.i(148265);
    if ((this.b == 0L) || (this.g == null))
    {
      AppMethodBeat.o(148265);
      return;
    }
    this.g.a(new if.11(this, paramBoolean));
    AppMethodBeat.o(148265);
  }
  
  public void e()
  {
    AppMethodBeat.i(148218);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeLockEngine(this.b);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148218);
    }
  }
  
  /* Error */
  public void e(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 815
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 815
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: iload_1
    //   43: invokevirtual 818	com/tencent/map/lib/gl/JNI:nativeSetMinScaleLevel	(JI)V
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   52: ldc_w 815
    //   55: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore 4
    //   61: aload_0
    //   62: monitorexit
    //   63: ldc_w 815
    //   66: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: aload 4
    //   71: athrow
    //   72: astore 4
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 815
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload 4
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	if
    //   0	87	1	paramInt	int
    //   14	3	2	l1	long
    //   59	11	4	localObject1	Object
    //   72	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	48	59	finally
    //   61	63	59	finally
    //   6	15	72	finally
    //   32	34	72	finally
    //   63	72	72	finally
  }
  
  /* Error */
  public void e(d paramd)
  {
    // Byte code:
    //   0: ldc_w 819
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 819
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 819
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   59: aload_0
    //   60: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   63: iload_2
    //   64: i2l
    //   65: aload_1
    //   66: invokevirtual 822	com/tencent/map/lib/element/d:w	()Ljava/lang/String;
    //   69: invokevirtual 826	com/tencent/map/lib/gl/JNI:nativeSetLineDirectionArrowTextureName	(JJLjava/lang/String;)V
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 819
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: ldc_w 819
    //   91: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   101: ldc_w 819
    //   104: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	if
    //   0	109	1	paramd	d
    //   36	28	2	n	int
    //   14	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   55	74	85	finally
    //   86	88	85	finally
    //   6	15	96	finally
    //   32	37	96	finally
    //   53	55	96	finally
    //   88	96	96	finally
  }
  
  /* Error */
  public void e(String paramString)
  {
    // Byte code:
    //   0: ldc_w 827
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lload_2
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 827
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: aload_1
    //   43: invokevirtual 831	com/tencent/map/lib/gl/JNI:nativeMapLoadKMLFile	(JLjava/lang/String;)V
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_0
    //   49: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   52: ldc_w 827
    //   55: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: return
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: ldc_w 827
    //   65: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_1
    //   69: athrow
    //   70: astore_1
    //   71: aload_0
    //   72: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   75: ldc_w 827
    //   78: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	if
    //   0	83	1	paramString	String
    //   14	2	2	l1	long
    // Exception table:
    //   from	to	target	type
    //   34	48	59	finally
    //   60	62	59	finally
    //   6	15	70	finally
    //   32	34	70	finally
    //   62	70	70	finally
  }
  
  public void e(final boolean paramBoolean)
  {
    AppMethodBeat.i(148269);
    if (0L == this.b)
    {
      AppMethodBeat.o(148269);
      return;
    }
    this.g.a(new ik.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(148184);
        if (if.a(if.this) != 0L) {
          if.b(if.this).nativeSetCompassMarkerHidden(if.a(if.this), paramBoolean);
        }
        AppMethodBeat.o(148184);
      }
    });
    AppMethodBeat.o(148269);
  }
  
  public void f()
  {
    AppMethodBeat.i(148219);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeUnlockEngine(this.b);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148219);
    }
  }
  
  public void f(final int paramInt)
  {
    AppMethodBeat.i(148295);
    if ((this.b == 0L) || (this.g == null))
    {
      AppMethodBeat.o(148295);
      return;
    }
    this.g.a(new ik.a()
    {
      public void a(GL10 paramAnonymousGL10)
      {
        AppMethodBeat.i(148197);
        if (if.a(if.this) != 0L) {
          if.b(if.this).nativeRemoveHeatTileOverlay(if.a(if.this), paramInt);
        }
        AppMethodBeat.o(148197);
      }
    });
    AppMethodBeat.o(148295);
  }
  
  /* Error */
  public void f(d paramd)
  {
    // Byte code:
    //   0: ldc_w 840
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 840
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 840
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   59: aload_0
    //   60: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   63: iload_2
    //   64: i2l
    //   65: aload_1
    //   66: invokevirtual 842	com/tencent/map/lib/element/d:k	()Z
    //   69: invokevirtual 845	com/tencent/map/lib/gl/JNI:nativeSetDrawCap	(JJZ)V
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_0
    //   75: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   78: ldc_w 840
    //   81: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: return
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: ldc_w 840
    //   91: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_1
    //   95: athrow
    //   96: astore_1
    //   97: aload_0
    //   98: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   101: ldc_w 840
    //   104: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	if
    //   0	109	1	paramd	d
    //   36	28	2	n	int
    //   14	2	3	l1	long
    // Exception table:
    //   from	to	target	type
    //   55	74	85	finally
    //   86	88	85	finally
    //   6	15	96	finally
    //   32	37	96	finally
    //   53	55	96	finally
    //   88	96	96	finally
  }
  
  public void f(String paramString)
  {
    AppMethodBeat.i(148313);
    if (this.b == 0L)
    {
      AppMethodBeat.o(148313);
      return;
    }
    this.g.a(new if.29(this, paramString));
    AppMethodBeat.o(148313);
  }
  
  public void f(boolean paramBoolean)
  {
    AppMethodBeat.i(148310);
    try
    {
      F();
      long l1 = this.b;
      if (0L == l1) {
        return;
      }
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148310);
    }
  }
  
  public void g(int paramInt)
  {
    AppMethodBeat.i(148296);
    if ((this.b == 0L) || (this.g == null))
    {
      AppMethodBeat.o(148296);
      return;
    }
    this.g.a(new if.28(this, paramInt));
    AppMethodBeat.o(148296);
  }
  
  /* Error */
  public void g(d paramd)
  {
    // Byte code:
    //   0: ldc_w 855
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 855
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 855
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_1
    //   56: invokevirtual 858	com/tencent/map/lib/element/d:h	()Lcom/tencent/map/lib/basemap/data/GeoPoint;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnonnull +16 -> 79
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_0
    //   69: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   72: ldc_w 855
    //   75: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: aload_0
    //   80: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   83: aload_0
    //   84: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   87: iload_2
    //   88: i2l
    //   89: aload 5
    //   91: aload_1
    //   92: invokevirtual 860	com/tencent/map/lib/element/d:i	()I
    //   95: invokevirtual 864	com/tencent/map/lib/gl/JNI:nativeLineInsertPoint	(JJLcom/tencent/map/lib/basemap/data/GeoPoint;I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   104: ldc_w 855
    //   107: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: ldc_w 855
    //   117: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   127: ldc_w 855
    //   130: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	if
    //   0	135	1	paramd	d
    //   36	52	2	n	int
    //   14	2	3	l1	long
    //   59	31	5	localGeoPoint	GeoPoint
    // Exception table:
    //   from	to	target	type
    //   55	61	111	finally
    //   66	68	111	finally
    //   79	100	111	finally
    //   112	114	111	finally
    //   6	15	122	finally
    //   32	37	122	finally
    //   53	55	122	finally
    //   114	122	122	finally
  }
  
  public void g(boolean paramBoolean)
  {
    AppMethodBeat.i(148314);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeEnablePOI(this.b, paramBoolean);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148314);
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public boolean g()
  {
    // Byte code:
    //   0: ldc_w 870
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_1
    //   15: lload_1
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 870
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: invokevirtual 873	com/tencent/map/lib/gl/JNI:nativeIsMapDrawFinished	(J)Z
    //   46: istore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 870
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload_3
    //   60: ireturn
    //   61: astore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc_w 870
    //   68: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: athrow
    //   74: astore 4
    //   76: aload_0
    //   77: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   80: ldc_w 870
    //   83: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	if
    //   14	2	1	l1	long
    //   46	14	3	bool	boolean
    //   61	11	4	localObject1	Object
    //   74	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	49	61	finally
    //   63	65	61	finally
    //   6	15	74	finally
    //   33	35	74	finally
    //   65	74	74	finally
  }
  
  public void h(int paramInt)
  {
    AppMethodBeat.i(148297);
    if (this.g != null)
    {
      iq localiq = this.g.e();
      if (localiq != null) {
        localiq.a();
      }
    }
    AppMethodBeat.o(148297);
  }
  
  /* Error */
  public void h(d paramd)
  {
    // Byte code:
    //   0: ldc_w 882
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_3
    //   15: lload_3
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 882
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_1
    //   33: invokevirtual 698	com/tencent/map/lib/element/d:s	()I
    //   36: istore_2
    //   37: iload_2
    //   38: iconst_m1
    //   39: if_icmpne +14 -> 53
    //   42: aload_0
    //   43: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   46: ldc_w 882
    //   49: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload_0
    //   54: monitorenter
    //   55: aload_1
    //   56: invokevirtual 858	com/tencent/map/lib/element/d:h	()Lcom/tencent/map/lib/basemap/data/GeoPoint;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnonnull +16 -> 79
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_0
    //   69: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   72: ldc_w 882
    //   75: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: aload_0
    //   80: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   83: aload_0
    //   84: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   87: iload_2
    //   88: i2l
    //   89: aload 5
    //   91: aload_1
    //   92: invokevirtual 860	com/tencent/map/lib/element/d:i	()I
    //   95: invokevirtual 885	com/tencent/map/lib/gl/JNI:nativeLineClearPoint	(JJLcom/tencent/map/lib/basemap/data/GeoPoint;I)V
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_0
    //   101: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   104: ldc_w 882
    //   107: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: ldc_w 882
    //   117: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   127: ldc_w 882
    //   130: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_1
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	if
    //   0	135	1	paramd	d
    //   36	52	2	n	int
    //   14	2	3	l1	long
    //   59	31	5	localGeoPoint	GeoPoint
    // Exception table:
    //   from	to	target	type
    //   55	61	111	finally
    //   66	68	111	finally
    //   79	100	111	finally
    //   112	114	111	finally
    //   6	15	122	finally
    //   32	37	122	finally
    //   53	55	122	finally
    //   114	122	122	finally
  }
  
  public void h(boolean paramBoolean)
  {
    AppMethodBeat.i(148315);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.a.nativeEnableVectorMap(this.b, paramBoolean);
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148315);
    }
  }
  
  /* Error */
  public com.tencent.map.lib.mapstructure.TrafficRequestItem[] h()
  {
    // Byte code:
    //   0: ldc_w 891
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lload_2
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 891
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: invokevirtual 895	com/tencent/map/lib/gl/JNI:nativeFetchLackedTrafficBlocks	(J)[I
    //   46: astore 4
    //   48: aload 4
    //   50: ifnull +9 -> 59
    //   53: aload 4
    //   55: arraylength
    //   56: ifne +17 -> 73
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_0
    //   62: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   65: ldc_w 891
    //   68: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aconst_null
    //   72: areturn
    //   73: aload 4
    //   75: arraylength
    //   76: bipush 7
    //   78: idiv
    //   79: anewarray 897	com/tencent/map/lib/mapstructure/TrafficRequestItem
    //   82: astore 5
    //   84: iconst_0
    //   85: istore_1
    //   86: iload_1
    //   87: aload 4
    //   89: arraylength
    //   90: bipush 7
    //   92: idiv
    //   93: if_icmpge +132 -> 225
    //   96: aload 5
    //   98: iload_1
    //   99: new 897	com/tencent/map/lib/mapstructure/TrafficRequestItem
    //   102: dup
    //   103: invokespecial 898	com/tencent/map/lib/mapstructure/TrafficRequestItem:<init>	()V
    //   106: aastore
    //   107: aload 5
    //   109: iload_1
    //   110: aaload
    //   111: aload 4
    //   113: iload_1
    //   114: bipush 7
    //   116: imul
    //   117: iaload
    //   118: putfield 901	com/tencent/map/lib/mapstructure/TrafficRequestItem:level	I
    //   121: aload 5
    //   123: iload_1
    //   124: aaload
    //   125: aload 4
    //   127: iload_1
    //   128: bipush 7
    //   130: imul
    //   131: iconst_1
    //   132: iadd
    //   133: iaload
    //   134: putfield 904	com/tencent/map/lib/mapstructure/TrafficRequestItem:blockNo	I
    //   137: aload 5
    //   139: iload_1
    //   140: aaload
    //   141: aload 4
    //   143: iload_1
    //   144: bipush 7
    //   146: imul
    //   147: iconst_2
    //   148: iadd
    //   149: iaload
    //   150: putfield 907	com/tencent/map/lib/mapstructure/TrafficRequestItem:left	I
    //   153: aload 5
    //   155: iload_1
    //   156: aaload
    //   157: aload 4
    //   159: iload_1
    //   160: bipush 7
    //   162: imul
    //   163: iconst_3
    //   164: iadd
    //   165: iaload
    //   166: putfield 910	com/tencent/map/lib/mapstructure/TrafficRequestItem:top	I
    //   169: aload 5
    //   171: iload_1
    //   172: aaload
    //   173: aload 4
    //   175: iload_1
    //   176: bipush 7
    //   178: imul
    //   179: iconst_4
    //   180: iadd
    //   181: iaload
    //   182: putfield 913	com/tencent/map/lib/mapstructure/TrafficRequestItem:right	I
    //   185: aload 5
    //   187: iload_1
    //   188: aaload
    //   189: aload 4
    //   191: iload_1
    //   192: bipush 7
    //   194: imul
    //   195: iconst_5
    //   196: iadd
    //   197: iaload
    //   198: putfield 916	com/tencent/map/lib/mapstructure/TrafficRequestItem:bottom	I
    //   201: aload 5
    //   203: iload_1
    //   204: aaload
    //   205: aload 4
    //   207: iload_1
    //   208: bipush 7
    //   210: imul
    //   211: bipush 6
    //   213: iadd
    //   214: iaload
    //   215: putfield 919	com/tencent/map/lib/mapstructure/TrafficRequestItem:timestamp	I
    //   218: iload_1
    //   219: iconst_1
    //   220: iadd
    //   221: istore_1
    //   222: goto -136 -> 86
    //   225: aload_0
    //   226: monitorexit
    //   227: aload_0
    //   228: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   231: ldc_w 891
    //   234: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload 5
    //   239: areturn
    //   240: astore 4
    //   242: aload_0
    //   243: monitorexit
    //   244: ldc_w 891
    //   247: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload 4
    //   252: athrow
    //   253: astore 4
    //   255: aload_0
    //   256: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   259: ldc_w 891
    //   262: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload 4
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	if
    //   85	137	1	n	int
    //   14	2	2	l1	long
    //   46	160	4	arrayOfInt	int[]
    //   240	11	4	localObject1	Object
    //   253	13	4	localObject2	Object
    //   82	156	5	arrayOfTrafficRequestItem	com.tencent.map.lib.mapstructure.TrafficRequestItem[]
    // Exception table:
    //   from	to	target	type
    //   35	48	240	finally
    //   53	59	240	finally
    //   59	61	240	finally
    //   73	84	240	finally
    //   86	218	240	finally
    //   225	227	240	finally
    //   242	244	240	finally
    //   6	15	253	finally
    //   33	35	253	finally
    //   244	253	253	finally
  }
  
  public void i()
  {
    AppMethodBeat.i(148235);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.g.a(new if.14(this));
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148235);
    }
  }
  
  public void i(d paramd)
  {
    AppMethodBeat.i(148312);
    for (;;)
    {
      int n;
      try
      {
        F();
        long l1 = this.b;
        if (l1 == 0L) {
          return;
        }
        n = paramd.s();
        if (n == -1) {
          return;
        }
        float f1 = paramd.x();
        if (f1 < 0.0F) {
          return;
        }
        int i1 = paramd.m();
        if ((i1 == 3) || (i1 == 0)) {
          try
          {
            this.a.nativeSetLineArrowSpacing(this.b, n, paramd.x());
            return;
          }
          finally
          {
            AppMethodBeat.o(148312);
          }
        }
      }
      finally
      {
        G();
        AppMethodBeat.o(148312);
      }
      try
      {
        this.a.nativeSetLineFootPrintSpacing(this.b, n, paramd.x());
      }
      finally
      {
        AppMethodBeat.o(148312);
      }
    }
  }
  
  public boolean i(int paramInt)
  {
    AppMethodBeat.i(148320);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return false;
      }
      boolean bool = this.a.checkMapLoadFinishedTask(this.b, paramInt);
      return bool;
    }
    finally
    {
      G();
      AppMethodBeat.o(148320);
    }
  }
  
  /* Error */
  public void j()
  {
    // Byte code:
    //   0: ldc_w 943
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lconst_0
    //   15: lcmp
    //   16: ifeq +18 -> 34
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   25: aload_0
    //   26: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   29: invokevirtual 946	com/tencent/map/lib/gl/JNI:nativeHideStreetRoad	(J)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_0
    //   35: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   38: ldc_w 943
    //   41: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: return
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: ldc_w 943
    //   51: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_1
    //   55: athrow
    //   56: astore_1
    //   57: aload_0
    //   58: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   61: ldc_w 943
    //   64: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	if
    //   45	10	1	localObject1	Object
    //   56	12	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   21	34	45	finally
    //   46	48	45	finally
    //   6	21	56	finally
    //   48	56	56	finally
  }
  
  public void k()
  {
    AppMethodBeat.i(148238);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.g.a(new if.30(this));
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148238);
    }
  }
  
  public void l()
  {
    AppMethodBeat.i(148239);
    try
    {
      F();
      long l1 = this.b;
      if (l1 == 0L) {
        return;
      }
      this.g.a(new ik.a()
      {
        public void a(GL10 paramAnonymousGL10)
        {
          AppMethodBeat.i(148202);
          if.b(if.this).nativeHideTraffic(if.a(if.this));
          AppMethodBeat.o(148202);
        }
      });
      return;
    }
    finally
    {
      G();
      AppMethodBeat.o(148239);
    }
  }
  
  public void m()
  {
    AppMethodBeat.i(148253);
    if (this.b != 0L) {
      this.g.a(new if.2(this));
    }
    AppMethodBeat.o(148253);
  }
  
  public void n()
  {
    AppMethodBeat.i(148257);
    if (0L == this.b)
    {
      AppMethodBeat.o(148257);
      return;
    }
    this.g.a(new if.5(this));
    AppMethodBeat.o(148257);
  }
  
  /* Error */
  public GeoPoint o()
  {
    // Byte code:
    //   0: ldc_w 961
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_1
    //   15: lconst_0
    //   16: lload_1
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 961
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: monitorenter
    //   35: new 234	com/tencent/map/lib/basemap/data/GeoPoint
    //   38: dup
    //   39: invokespecial 316	com/tencent/map/lib/basemap/data/GeoPoint:<init>	()V
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   47: aload_0
    //   48: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   51: aload_3
    //   52: invokevirtual 965	com/tencent/map/lib/gl/JNI:nativeGetCenterMapPoint	(JLcom/tencent/map/lib/basemap/data/GeoPoint;)V
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_0
    //   58: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   61: ldc_w 961
    //   64: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_3
    //   68: areturn
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: ldc_w 961
    //   75: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: athrow
    //   80: astore_3
    //   81: aload_0
    //   82: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   85: ldc_w 961
    //   88: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	if
    //   14	3	1	l1	long
    //   42	26	3	localGeoPoint	GeoPoint
    //   69	10	3	localObject1	Object
    //   80	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	57	69	finally
    //   70	72	69	finally
    //   6	15	80	finally
    //   33	35	80	finally
    //   72	80	80	finally
  }
  
  /* Error */
  public float p()
  {
    // Byte code:
    //   0: ldc_w 967
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 967
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: fconst_1
    //   32: freturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: invokevirtual 971	com/tencent/map/lib/gl/JNI:nativeGetScale	(J)D
    //   46: d2f
    //   47: fstore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   54: ldc_w 967
    //   57: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: fload_1
    //   61: freturn
    //   62: astore 4
    //   64: aload_0
    //   65: monitorexit
    //   66: ldc_w 967
    //   69: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload 4
    //   74: athrow
    //   75: astore 4
    //   77: aload_0
    //   78: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   81: ldc_w 967
    //   84: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload 4
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	if
    //   47	14	1	f1	float
    //   14	3	2	l1	long
    //   62	11	4	localObject1	Object
    //   75	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	50	62	finally
    //   64	66	62	finally
    //   6	15	75	finally
    //   33	35	75	finally
    //   66	75	75	finally
  }
  
  public void q()
  {
    AppMethodBeat.i(148325);
    if (this.g != null) {
      this.g.I();
    }
    AppMethodBeat.o(148325);
  }
  
  /* Error */
  public int r()
  {
    // Byte code:
    //   0: ldc_w 974
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +16 -> 34
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 974
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: bipush 20
    //   33: ireturn
    //   34: aload_0
    //   35: monitorenter
    //   36: aload_0
    //   37: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   40: aload_0
    //   41: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   44: invokevirtual 977	com/tencent/map/lib/gl/JNI:nativeGetScaleLevel	(J)I
    //   47: istore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_0
    //   51: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   54: ldc_w 974
    //   57: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: iload_1
    //   61: ireturn
    //   62: astore 4
    //   64: aload_0
    //   65: monitorexit
    //   66: ldc_w 974
    //   69: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload 4
    //   74: athrow
    //   75: astore 4
    //   77: aload_0
    //   78: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   81: ldc_w 974
    //   84: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload 4
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	if
    //   47	14	1	n	int
    //   14	3	2	l1	long
    //   62	11	4	localObject1	Object
    //   75	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	50	62	finally
    //   64	66	62	finally
    //   6	15	75	finally
    //   34	36	75	finally
    //   66	75	75	finally
  }
  
  public void s()
  {
    AppMethodBeat.i(148280);
    if ((0L == this.b) || (this.g == null))
    {
      AppMethodBeat.o(148280);
      return;
    }
    this.g.a(new if.21(this));
    AppMethodBeat.o(148280);
  }
  
  /* Error */
  public void t()
  {
    // Byte code:
    //   0: ldc_w 983
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_1
    //   15: lconst_0
    //   16: lload_1
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 983
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: invokestatic 989	java/lang/System:currentTimeMillis	()J
    //   37: lstore_1
    //   38: aload_0
    //   39: getfield 74	com/tencent/tencentmap/mapsdk/maps/a/if:h	J
    //   42: lconst_0
    //   43: lcmp
    //   44: ifne +33 -> 77
    //   47: aload_0
    //   48: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   51: aload_0
    //   52: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   55: dconst_0
    //   56: invokevirtual 993	com/tencent/map/lib/gl/JNI:nativeUpdateFrame	(JD)V
    //   59: aload_0
    //   60: lload_1
    //   61: putfield 74	com/tencent/tencentmap/mapsdk/maps/a/if:h	J
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_0
    //   67: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   70: ldc_w 983
    //   73: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: aload_0
    //   78: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   81: aload_0
    //   82: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   85: lload_1
    //   86: aload_0
    //   87: getfield 74	com/tencent/tencentmap/mapsdk/maps/a/if:h	J
    //   90: lsub
    //   91: l2d
    //   92: invokevirtual 993	com/tencent/map/lib/gl/JNI:nativeUpdateFrame	(JD)V
    //   95: goto -36 -> 59
    //   98: astore_3
    //   99: aload_0
    //   100: monitorexit
    //   101: ldc_w 983
    //   104: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_3
    //   108: athrow
    //   109: astore_3
    //   110: aload_0
    //   111: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   114: ldc_w 983
    //   117: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_3
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	if
    //   14	72	1	l1	long
    //   98	10	3	localObject1	Object
    //   109	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	59	98	finally
    //   59	66	98	finally
    //   77	95	98	finally
    //   99	101	98	finally
    //   6	15	109	finally
    //   32	34	109	finally
    //   101	109	109	finally
  }
  
  /* Error */
  public boolean u()
  {
    // Byte code:
    //   0: ldc_w 995
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_1
    //   15: lconst_0
    //   16: lload_1
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 995
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: invokevirtual 998	com/tencent/map/lib/gl/JNI:nativeNeedDispaly	(J)Z
    //   46: istore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 995
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload_3
    //   60: ireturn
    //   61: astore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc_w 995
    //   68: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: athrow
    //   74: astore 4
    //   76: aload_0
    //   77: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   80: ldc_w 995
    //   83: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	if
    //   14	3	1	l1	long
    //   46	14	3	bool	boolean
    //   61	11	4	localObject1	Object
    //   74	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	49	61	finally
    //   63	65	61	finally
    //   6	15	74	finally
    //   33	35	74	finally
    //   65	74	74	finally
  }
  
  public float v()
  {
    AppMethodBeat.i(148290);
    try
    {
      F();
      long l1 = this.b;
      if (0L == l1) {
        return 0.0F;
      }
      float f1 = this.a.nativeGetSkew(this.b);
      return f1;
    }
    finally
    {
      G();
      AppMethodBeat.o(148290);
    }
  }
  
  public float w()
  {
    AppMethodBeat.i(148291);
    try
    {
      F();
      long l1 = this.b;
      if (0L == l1) {
        return 0.0F;
      }
      float f1 = this.a.nativeGetRotate(this.b);
      return f1;
    }
    finally
    {
      G();
      AppMethodBeat.o(148291);
    }
  }
  
  /* Error */
  public int x()
  {
    // Byte code:
    //   0: ldc_w 1008
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_2
    //   15: lconst_0
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +15 -> 33
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 1008
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   39: aload_0
    //   40: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   43: invokevirtual 1011	com/tencent/map/lib/gl/JNI:nativeGetMapMode	(J)I
    //   46: istore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   53: ldc_w 1008
    //   56: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload_1
    //   60: ireturn
    //   61: astore 4
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc_w 1008
    //   68: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 4
    //   73: athrow
    //   74: astore 4
    //   76: aload_0
    //   77: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   80: ldc_w 1008
    //   83: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	if
    //   46	14	1	n	int
    //   14	3	2	l1	long
    //   61	11	4	localObject1	Object
    //   74	13	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	49	61	finally
    //   63	65	61	finally
    //   6	15	74	finally
    //   33	35	74	finally
    //   65	74	74	finally
  }
  
  public void y()
  {
    AppMethodBeat.i(148298);
    if (this.f != null) {
      this.f.y();
    }
    AppMethodBeat.o(148298);
  }
  
  /* Error */
  public void z()
  {
    // Byte code:
    //   0: ldc_w 1013
    //   3: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokespecial 163	com/tencent/tencentmap/mapsdk/maps/a/if:F	()V
    //   10: aload_0
    //   11: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   14: lstore_1
    //   15: lconst_0
    //   16: lload_1
    //   17: lcmp
    //   18: ifne +14 -> 32
    //   21: aload_0
    //   22: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   25: ldc_w 1013
    //   28: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: return
    //   32: aload_0
    //   33: monitorenter
    //   34: aload_0
    //   35: getfield 90	com/tencent/tencentmap/mapsdk/maps/a/if:a	Lcom/tencent/map/lib/gl/JNI;
    //   38: aload_0
    //   39: getfield 156	com/tencent/tencentmap/mapsdk/maps/a/if:b	J
    //   42: invokevirtual 1016	com/tencent/map/lib/gl/JNI:nativeClearRouteNameSegments	(J)V
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_0
    //   48: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   51: ldc_w 1013
    //   54: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: astore_3
    //   59: aload_0
    //   60: monitorexit
    //   61: ldc_w 1013
    //   64: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_3
    //   68: athrow
    //   69: astore_3
    //   70: aload_0
    //   71: invokespecial 165	com/tencent/tencentmap/mapsdk/maps/a/if:G	()V
    //   74: ldc_w 1013
    //   77: invokestatic 127	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	if
    //   14	3	1	l1	long
    //   58	10	3	localObject1	Object
    //   69	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	47	58	finally
    //   59	61	58	finally
    //   6	15	69	finally
    //   32	34	69	finally
    //   61	69	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.if
 * JD-Core Version:    0.7.0.1
 */