package com.tencent.scanlib.b;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import com.tencent.qbar.a.a;
import com.tencent.qbar.d;
import com.tencent.scanlib.b;
import com.tencent.stubs.logger.Log;
import java.util.List;

public class a
{
  protected Object GXz;
  protected String TAG;
  protected com.tencent.qbar.a ahvY;
  protected boolean lYs;
  
  public a(String paramString)
  {
    AppMethodBeat.i(3546);
    this.TAG = "BaseQBarAIDecoder";
    this.GXz = new Object();
    this.ahvY = new com.tencent.qbar.a();
    this.TAG = (this.TAG + "_" + paramString);
    AppMethodBeat.o(3546);
  }
  
  private List<a.a> S(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3549);
    long l = System.currentTimeMillis();
    paramInt1 = this.ahvY.R(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      Log.e(this.TAG, "scanImage result ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(3549);
      return null;
    }
    paramArrayOfByte = this.ahvY.jWG();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0)) {
      Log.e(this.TAG, String.format("get no results ,cost %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    Log.i(this.TAG, String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramArrayOfByte.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(3549);
    return paramArrayOfByte;
  }
  
  public final List<a.a> T(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3553);
    synchronized (this.GXz)
    {
      paramArrayOfByte = S(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(3553);
      return paramArrayOfByte;
    }
  }
  
  public final int U(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(3554);
    if (paramArrayOfInt != null)
    {
      int[] arrayOfInt2 = new int[paramArrayOfInt.length];
      int k = paramArrayOfInt.length;
      int j = 0;
      i = 0;
      for (;;)
      {
        arrayOfInt1 = arrayOfInt2;
        if (j >= k) {
          break;
        }
        arrayOfInt2[i] = paramArrayOfInt[j];
        j += 1;
        i += 1;
      }
    }
    int[] arrayOfInt1 = new int[5];
    arrayOfInt1[0] = 2;
    arrayOfInt1[1] = 1;
    arrayOfInt1[2] = 4;
    arrayOfInt1[3] = 5;
    int i = this.ahvY.y(arrayOfInt1, arrayOfInt1.length);
    AppMethodBeat.o(3554);
    return i;
  }
  
  public final List<a.a> a(int[] paramArrayOfInt, Point paramPoint)
  {
    AppMethodBeat.i(3548);
    Log.i(this.TAG, String.format("decode, size %s", new Object[] { paramPoint.toString() }));
    if (paramArrayOfInt.length <= 0)
    {
      Log.w(this.TAG, "prepareGrayData , data is null");
      AppMethodBeat.o(3548);
      return null;
    }
    byte[] arrayOfByte = new byte[paramPoint.x * paramPoint.y];
    int i = d.a(paramArrayOfInt, arrayOfByte, paramPoint.x, paramPoint.y);
    if (i != 0)
    {
      Log.e(this.TAG, "rotate result ".concat(String.valueOf(i)));
      AppMethodBeat.o(3548);
      return null;
    }
    paramArrayOfInt = S(arrayOfByte, paramPoint.x, paramPoint.y);
    AppMethodBeat.o(3548);
    return paramArrayOfInt;
  }
  
  /* Error */
  public final void a(android.content.Context paramContext, int paramInt, com.tencent.qbar.QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    // Byte code:
    //   0: ldc 152
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 154	com/tencent/scanlib/b/a:lYs	Z
    //   9: ifeq +9 -> 18
    //   12: ldc 152
    //   14: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: getstatic 159	com/tencent/scanlib/b:ahvB	Ljava/lang/Object;
    //   21: astore 6
    //   23: aload 6
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield 29	com/tencent/scanlib/b/a:GXz	Ljava/lang/Object;
    //   30: astore 7
    //   32: aload 7
    //   34: monitorenter
    //   35: aload_0
    //   36: invokevirtual 162	java/lang/Object:hashCode	()I
    //   39: istore 4
    //   41: aload_0
    //   42: getfield 27	com/tencent/scanlib/b/a:TAG	Ljava/lang/String;
    //   45: ldc 164
    //   47: iload 4
    //   49: invokestatic 71	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 75	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokestatic 111	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_1
    //   59: invokestatic 168	com/tencent/scanlib/b:of	(Landroid/content/Context;)I
    //   62: istore 5
    //   64: aload_0
    //   65: getfield 34	com/tencent/scanlib/b/a:ahvY	Lcom/tencent/qbar/a;
    //   68: iload 5
    //   70: iload_2
    //   71: ldc 170
    //   73: ldc 172
    //   75: aload_3
    //   76: invokevirtual 175	com/tencent/qbar/a:a	(IILjava/lang/String;Ljava/lang/String;Lcom/tencent/qbar/QbarNative$QbarAiModelParam;)I
    //   79: istore_2
    //   80: iload_2
    //   81: ifeq +48 -> 129
    //   84: aload_0
    //   85: getfield 27	com/tencent/scanlib/b/a:TAG	Ljava/lang/String;
    //   88: new 36	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 177
    //   94: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: iload_2
    //   98: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: ldc 184
    //   103: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload 4
    //   108: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 81	com/tencent/stubs/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 7
    //   119: monitorexit
    //   120: aload 6
    //   122: monitorexit
    //   123: ldc 152
    //   125: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: aload_0
    //   130: iconst_1
    //   131: putfield 154	com/tencent/scanlib/b/a:lYs	Z
    //   134: aload_0
    //   135: getfield 27	com/tencent/scanlib/b/a:TAG	Ljava/lang/String;
    //   138: new 36	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 186
    //   144: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: iload 5
    //   149: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: ldc 184
    //   154: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 4
    //   159: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 111	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 7
    //   170: monitorexit
    //   171: aload 6
    //   173: monitorexit
    //   174: ldc 152
    //   176: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: astore_1
    //   181: ldc 152
    //   183: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: return
    //   187: astore_1
    //   188: aload 7
    //   190: monitorexit
    //   191: ldc 152
    //   193: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload 6
    //   201: monitorexit
    //   202: ldc 152
    //   204: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	a
    //   0	209	1	paramContext	android.content.Context
    //   0	209	2	paramInt	int
    //   0	209	3	paramQbarAiModelParam	com.tencent.qbar.QbarNative.QbarAiModelParam
    //   39	119	4	i	int
    //   62	86	5	j	int
    // Exception table:
    //   from	to	target	type
    //   18	26	180	java/lang/Exception
    //   174	179	180	java/lang/Exception
    //   199	209	180	java/lang/Exception
    //   35	80	187	finally
    //   84	120	187	finally
    //   129	171	187	finally
    //   26	35	198	finally
    //   120	123	198	finally
    //   171	174	198	finally
    //   188	198	198	finally
  }
  
  public final byte[] a(byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect arg4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(3552);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      Log.w(this.TAG, "prepareGrayData , data is null");
      AppMethodBeat.o(3552);
      return null;
    }
    Log.i(this.TAG, String.format("cropGrayData, size %s, rect %s, rotation %d", new Object[] { paramPoint, ???, Integer.valueOf(paramInt) }));
    int i;
    if (??? != null) {
      i = ???.width();
    }
    for (;;)
    {
      int j;
      label88:
      int k;
      label100:
      int m;
      label112:
      byte[] arrayOfByte;
      if (??? != null)
      {
        j = ???.height();
        if (??? == null) {
          break label209;
        }
        k = ???.left;
        if (??? == null) {
          break label215;
        }
        m = ???.top;
        arrayOfByte = new byte[i * j * 3 / 2];
      }
      synchronized (this.GXz)
      {
        paramInt = d.a(arrayOfByte, paramArrayOfInt, paramArrayOfByte, paramPoint.x, paramPoint.y, k, m, i, j, paramInt);
        if (paramInt != 0)
        {
          Log.e(this.TAG, "rotate result ".concat(String.valueOf(paramInt)));
          AppMethodBeat.o(3552);
          return null;
          i = paramPoint.x;
          continue;
          j = paramPoint.y;
          break label88;
          label209:
          k = 0;
          break label100;
          label215:
          m = 0;
          break label112;
        }
        AppMethodBeat.o(3552);
        return arrayOfByte;
      }
    }
  }
  
  public final void aa(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
  {
    AppMethodBeat.i(3550);
    this.ahvY.Y(paramList, paramList1);
    Log.i(this.TAG, String.format("get detect code result %d", new Object[] { Integer.valueOf(paramList.size()) }));
    AppMethodBeat.o(3550);
  }
  
  public final boolean hasInited()
  {
    return this.lYs;
  }
  
  public final QbarNative.QBarZoomInfo jXN()
  {
    AppMethodBeat.i(3551);
    QbarNative.QBarZoomInfo localQBarZoomInfo = this.ahvY.jWH();
    AppMethodBeat.o(3551);
    return localQBarZoomInfo;
  }
  
  public final void release()
  {
    AppMethodBeat.i(3555);
    synchronized (b.ahvB)
    {
      synchronized (this.GXz)
      {
        this.lYs = false;
        Log.i(this.TAG, "qbar release , hashCode:" + hashCode());
        if (this.ahvY != null) {
          this.ahvY.release();
        }
        AppMethodBeat.o(3555);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.scanlib.b.a
 * JD-Core Version:    0.7.0.1
 */