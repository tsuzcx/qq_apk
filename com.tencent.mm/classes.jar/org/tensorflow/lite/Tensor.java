package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public final class Tensor
{
  public final a abML;
  int[] abMM;
  private final int[] abMN;
  private final a abMO;
  public long nativeHandle;
  
  private Tensor(long paramLong)
  {
    AppMethodBeat.i(239294);
    this.nativeHandle = paramLong;
    this.abML = a.aGh(dtype(paramLong));
    this.abMM = shape(paramLong);
    this.abMN = shapeSignature(paramLong);
    this.abMO = new a(quantizationScale(paramLong), quantizationZeroPoint(paramLong));
    AppMethodBeat.o(239294);
  }
  
  private static void a(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(239290);
    if ((paramArrayOfInt == null) || (paramInt == paramArrayOfInt.length))
    {
      AppMethodBeat.o(239290);
      return;
    }
    int j = Array.getLength(paramObject);
    if (paramArrayOfInt[paramInt] == 0) {
      paramArrayOfInt[paramInt] = j;
    }
    while (i < j)
    {
      a(Array.get(paramObject, i), paramInt + 1, paramArrayOfInt);
      i += 1;
      continue;
      if (paramArrayOfInt[paramInt] != j)
      {
        paramObject = new IllegalArgumentException(String.format("Mismatched lengths (%d and %d) in dimension %d", new Object[] { Integer.valueOf(paramArrayOfInt[paramInt]), Integer.valueOf(j), Integer.valueOf(paramInt) }));
        AppMethodBeat.o(239290);
        throw paramObject;
      }
    }
    AppMethodBeat.o(239290);
  }
  
  static Tensor aG(long paramLong, int paramInt)
  {
    AppMethodBeat.i(239282);
    Tensor localTensor = new Tensor(create(paramLong, paramInt));
    AppMethodBeat.o(239282);
    return localTensor;
  }
  
  private static native ByteBuffer buffer(long paramLong);
  
  private static native long create(long paramLong, int paramInt);
  
  private static native void delete(long paramLong);
  
  private static native int dtype(long paramLong);
  
  private a gZ(Object paramObject)
  {
    AppMethodBeat.i(239285);
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      if (localClass.isArray())
      {
        while (localClass.isArray()) {
          localClass = localClass.getComponentType();
        }
        if (Float.TYPE.equals(localClass))
        {
          paramObject = a.abMi;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Integer.TYPE.equals(localClass))
        {
          paramObject = a.abMj;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Byte.TYPE.equals(localClass))
        {
          if (this.abML == a.abMm)
          {
            paramObject = a.abMm;
            AppMethodBeat.o(239285);
            return paramObject;
          }
          paramObject = a.abMk;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Long.TYPE.equals(localClass))
        {
          paramObject = a.abMl;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Boolean.TYPE.equals(localClass))
        {
          paramObject = a.abMn;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.abMm;
          AppMethodBeat.o(239285);
          return paramObject;
        }
      }
      else
      {
        if ((Float.class.equals(localClass)) || ((paramObject instanceof FloatBuffer)))
        {
          paramObject = a.abMi;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if ((Integer.class.equals(localClass)) || ((paramObject instanceof IntBuffer)))
        {
          paramObject = a.abMj;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Byte.class.equals(localClass))
        {
          paramObject = a.abMk;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if ((Long.class.equals(localClass)) || ((paramObject instanceof LongBuffer)))
        {
          paramObject = a.abMl;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (Boolean.class.equals(localClass))
        {
          paramObject = a.abMn;
          AppMethodBeat.o(239285);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.abMm;
          AppMethodBeat.o(239285);
          return paramObject;
        }
      }
    }
    paramObject = new IllegalArgumentException("DataType error: cannot resolve DataType of " + paramObject.getClass().getName());
    AppMethodBeat.o(239285);
    throw paramObject;
  }
  
  static native boolean hasDelegateBufferHandle(long paramLong);
  
  private static int hb(Object paramObject)
  {
    AppMethodBeat.i(239288);
    if ((paramObject == null) || (!paramObject.getClass().isArray()))
    {
      AppMethodBeat.o(239288);
      return 0;
    }
    if (Array.getLength(paramObject) == 0)
    {
      paramObject = new IllegalArgumentException("Array lengths cannot be 0.");
      AppMethodBeat.o(239288);
      throw paramObject;
    }
    int i = hb(Array.get(paramObject, 0));
    AppMethodBeat.o(239288);
    return i + 1;
  }
  
  private static native int index(long paramLong);
  
  public static native String name(long paramLong);
  
  public static native int numBytes(long paramLong);
  
  private static native float quantizationScale(long paramLong);
  
  private static native int quantizationZeroPoint(long paramLong);
  
  static native void readMultiDimensionalArray(long paramLong, Object paramObject);
  
  private static native int[] shape(long paramLong);
  
  private static native int[] shapeSignature(long paramLong);
  
  static native void writeDirectBuffer(long paramLong, Buffer paramBuffer);
  
  static native void writeMultiDimensionalArray(long paramLong, Object paramObject);
  
  static native void writeScalar(long paramLong, Object paramObject);
  
  final ByteBuffer SE()
  {
    AppMethodBeat.i(239297);
    ByteBuffer localByteBuffer = buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    AppMethodBeat.o(239297);
    return localByteBuffer;
  }
  
  final void close()
  {
    AppMethodBeat.i(239283);
    delete(this.nativeHandle);
    this.nativeHandle = 0L;
    AppMethodBeat.o(239283);
  }
  
  final int[] ha(Object paramObject)
  {
    AppMethodBeat.i(239287);
    int i = hb(paramObject);
    Object localObject;
    if (this.abML == a.abMm)
    {
      localObject = paramObject.getClass();
      if (((Class)localObject).isArray())
      {
        while (((Class)localObject).isArray()) {
          localObject = ((Class)localObject).getComponentType();
        }
        if (Byte.TYPE.equals(localObject)) {
          i -= 1;
        }
      }
    }
    for (;;)
    {
      localObject = new int[i];
      a(paramObject, 0, (int[])localObject);
      AppMethodBeat.o(239287);
      return localObject;
    }
  }
  
  final void hc(Object paramObject)
  {
    AppMethodBeat.i(239292);
    if ((paramObject instanceof ByteBuffer))
    {
      AppMethodBeat.o(239292);
      return;
    }
    a locala = gZ(paramObject);
    if (locala != this.abML)
    {
      if (locala.iVB().equals(this.abML.iVB()))
      {
        AppMethodBeat.o(239292);
        return;
      }
      paramObject = new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[] { this.abML, paramObject.getClass().getName(), locala }));
      AppMethodBeat.o(239292);
      throw paramObject;
    }
    AppMethodBeat.o(239292);
  }
  
  final void iVC()
  {
    AppMethodBeat.i(239284);
    this.abMM = shape(this.nativeHandle);
    AppMethodBeat.o(239284);
  }
  
  public static final class a
  {
    private final int abMP;
    private final float scale;
    
    public a(float paramFloat, int paramInt)
    {
      this.scale = paramFloat;
      this.abMP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.Tensor
 * JD-Core Version:    0.7.0.1
 */