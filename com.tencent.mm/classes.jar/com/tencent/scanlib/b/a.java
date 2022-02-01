package com.tencent.scanlib.b;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative.QBarCodeDetectInfo;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.QbarNative.QBarZoomInfo;
import com.tencent.qbar.a.a;
import com.tencent.qbar.d;
import com.tencent.stubs.logger.Log;
import java.util.List;

public class a
{
  protected com.tencent.qbar.a LPj;
  protected String TAG;
  protected boolean gcX;
  protected Object ylo;
  
  public a(String paramString)
  {
    AppMethodBeat.i(3546);
    this.TAG = "BaseQBarAIDecoder";
    this.ylo = new Object();
    this.LPj = new com.tencent.qbar.a();
    this.TAG = (this.TAG + "_" + paramString);
    AppMethodBeat.o(3546);
  }
  
  private List<a.a> H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3549);
    long l = System.currentTimeMillis();
    paramInt1 = this.LPj.G(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 < 0)
    {
      Log.e(this.TAG, "scanImage result ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(3549);
      return null;
    }
    paramArrayOfByte = this.LPj.fTq();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0)) {
      Log.e(this.TAG, String.format("get no results ,cost %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
    }
    Log.i(this.TAG, String.format("get %d results ,cost %dms", new Object[] { Integer.valueOf(paramArrayOfByte.size()), Long.valueOf(System.currentTimeMillis() - l) }));
    AppMethodBeat.o(3549);
    return paramArrayOfByte;
  }
  
  public final List<a.a> I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(3553);
    synchronized (this.ylo)
    {
      paramArrayOfByte = H(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(3553);
      return paramArrayOfByte;
    }
  }
  
  public final int L(int[] paramArrayOfInt)
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
    int i = this.LPj.l(arrayOfInt1, arrayOfInt1.length);
    AppMethodBeat.o(3554);
    return i;
  }
  
  public final void M(List<QbarNative.QBarCodeDetectInfo> paramList, List<QbarNative.QBarPoint> paramList1)
  {
    AppMethodBeat.i(3550);
    this.LPj.K(paramList, paramList1);
    Log.i(this.TAG, String.format("get detect code result %d", new Object[] { Integer.valueOf(paramList.size()) }));
    AppMethodBeat.o(3550);
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
    paramArrayOfInt = H(arrayOfByte, paramPoint.x, paramPoint.y);
    AppMethodBeat.o(3548);
    return paramArrayOfInt;
  }
  
  /* Error */
  public final void a(int paramInt, com.tencent.qbar.QbarNative.QbarAiModelParam paramQbarAiModelParam)
  {
    // Byte code:
    //   0: sipush 3547
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 162	com/tencent/scanlib/b/a:gcX	Z
    //   10: ifeq +10 -> 20
    //   13: sipush 3547
    //   16: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_0
    //   21: getfield 29	com/tencent/scanlib/b/a:ylo	Ljava/lang/Object;
    //   24: astore_3
    //   25: aload_3
    //   26: monitorenter
    //   27: aload_0
    //   28: getfield 34	com/tencent/scanlib/b/a:LPj	Lcom/tencent/qbar/a;
    //   31: iload_1
    //   32: ldc 164
    //   34: ldc 166
    //   36: aload_2
    //   37: invokevirtual 169	com/tencent/qbar/a:a	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/qbar/QbarNative$QbarAiModelParam;)I
    //   40: istore_1
    //   41: iload_1
    //   42: ifeq +28 -> 70
    //   45: aload_0
    //   46: getfield 27	com/tencent/scanlib/b/a:TAG	Ljava/lang/String;
    //   49: ldc 171
    //   51: iload_1
    //   52: invokestatic 71	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   55: invokevirtual 75	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokestatic 111	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_3
    //   62: monitorexit
    //   63: sipush 3547
    //   66: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: return
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 162	com/tencent/scanlib/b/a:gcX	Z
    //   75: aload_0
    //   76: getfield 27	com/tencent/scanlib/b/a:TAG	Ljava/lang/String;
    //   79: ldc 173
    //   81: invokestatic 111	com/tencent/stubs/logger/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_3
    //   85: monitorexit
    //   86: sipush 3547
    //   89: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore_2
    //   94: sipush 3547
    //   97: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_2
    //   102: aload_3
    //   103: monitorexit
    //   104: sipush 3547
    //   107: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	a
    //   0	112	1	paramInt	int
    //   0	112	2	paramQbarAiModelParam	com.tencent.qbar.QbarNative.QbarAiModelParam
    // Exception table:
    //   from	to	target	type
    //   20	27	93	java/lang/Exception
    //   86	92	93	java/lang/Exception
    //   104	112	93	java/lang/Exception
    //   27	41	101	finally
    //   45	63	101	finally
    //   70	86	101	finally
    //   102	104	101	finally
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
      synchronized (this.ylo)
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
  
  public final QbarNative.QBarZoomInfo fUr()
  {
    AppMethodBeat.i(3551);
    QbarNative.QBarZoomInfo localQBarZoomInfo = this.LPj.fTr();
    AppMethodBeat.o(3551);
    return localQBarZoomInfo;
  }
  
  public final boolean hasInited()
  {
    return this.gcX;
  }
  
  public final void release()
  {
    AppMethodBeat.i(3555);
    synchronized (this.ylo)
    {
      this.gcX = false;
      if (this.LPj != null) {
        this.LPj.release();
      }
      AppMethodBeat.o(3555);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.b.a
 * JD-Core Version:    0.7.0.1
 */