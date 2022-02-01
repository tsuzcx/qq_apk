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
  public final a ajZE;
  int[] ajZF;
  private final int[] ajZG;
  private final a ajZH;
  public long nativeHandle;
  
  private Tensor(long paramLong)
  {
    AppMethodBeat.i(187295);
    this.nativeHandle = paramLong;
    this.ajZE = a.aNw(dtype(paramLong));
    this.ajZF = shape(paramLong);
    this.ajZG = shapeSignature(paramLong);
    this.ajZH = new a(quantizationScale(paramLong), quantizationZeroPoint(paramLong));
    AppMethodBeat.o(187295);
  }
  
  private static void a(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(187285);
    if ((paramArrayOfInt == null) || (paramInt == paramArrayOfInt.length))
    {
      AppMethodBeat.o(187285);
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
        AppMethodBeat.o(187285);
        throw paramObject;
      }
    }
    AppMethodBeat.o(187285);
  }
  
  static Tensor aX(long paramLong, int paramInt)
  {
    AppMethodBeat.i(187248);
    Tensor localTensor = new Tensor(create(paramLong, paramInt));
    AppMethodBeat.o(187248);
    return localTensor;
  }
  
  private static native ByteBuffer buffer(long paramLong);
  
  private static native long create(long paramLong, int paramInt);
  
  private static native void delete(long paramLong);
  
  private static native int dtype(long paramLong);
  
  static native boolean hasDelegateBufferHandle(long paramLong);
  
  private static native int index(long paramLong);
  
  private a jQ(Object paramObject)
  {
    AppMethodBeat.i(187265);
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
          paramObject = a.ajZc;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Integer.TYPE.equals(localClass))
        {
          paramObject = a.ajZd;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Byte.TYPE.equals(localClass))
        {
          if (this.ajZE == a.ajZg)
          {
            paramObject = a.ajZg;
            AppMethodBeat.o(187265);
            return paramObject;
          }
          paramObject = a.ajZe;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Long.TYPE.equals(localClass))
        {
          paramObject = a.ajZf;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Boolean.TYPE.equals(localClass))
        {
          paramObject = a.ajZh;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.ajZg;
          AppMethodBeat.o(187265);
          return paramObject;
        }
      }
      else
      {
        if ((Float.class.equals(localClass)) || ((paramObject instanceof FloatBuffer)))
        {
          paramObject = a.ajZc;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if ((Integer.class.equals(localClass)) || ((paramObject instanceof IntBuffer)))
        {
          paramObject = a.ajZd;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Byte.class.equals(localClass))
        {
          paramObject = a.ajZe;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if ((Long.class.equals(localClass)) || ((paramObject instanceof LongBuffer)))
        {
          paramObject = a.ajZf;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (Boolean.class.equals(localClass))
        {
          paramObject = a.ajZh;
          AppMethodBeat.o(187265);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.ajZg;
          AppMethodBeat.o(187265);
          return paramObject;
        }
      }
    }
    paramObject = new IllegalArgumentException("DataType error: cannot resolve DataType of " + paramObject.getClass().getName());
    AppMethodBeat.o(187265);
    throw paramObject;
  }
  
  private static int jS(Object paramObject)
  {
    AppMethodBeat.i(187271);
    if ((paramObject == null) || (!paramObject.getClass().isArray()))
    {
      AppMethodBeat.o(187271);
      return 0;
    }
    if (Array.getLength(paramObject) == 0)
    {
      paramObject = new IllegalArgumentException("Array lengths cannot be 0.");
      AppMethodBeat.o(187271);
      throw paramObject;
    }
    int i = jS(Array.get(paramObject, 0));
    AppMethodBeat.o(187271);
    return i + 1;
  }
  
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
  
  final void close()
  {
    AppMethodBeat.i(187414);
    delete(this.nativeHandle);
    this.nativeHandle = 0L;
    AppMethodBeat.o(187414);
  }
  
  final int[] jR(Object paramObject)
  {
    AppMethodBeat.i(187436);
    int i = jS(paramObject);
    Object localObject;
    if (this.ajZE == a.ajZg)
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
      AppMethodBeat.o(187436);
      return localObject;
    }
  }
  
  final void jT(Object paramObject)
  {
    AppMethodBeat.i(187445);
    if ((paramObject instanceof ByteBuffer))
    {
      AppMethodBeat.o(187445);
      return;
    }
    a locala = jQ(paramObject);
    if (locala != this.ajZE)
    {
      if (locala.kJZ().equals(this.ajZE.kJZ()))
      {
        AppMethodBeat.o(187445);
        return;
      }
      paramObject = new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[] { this.ajZE, paramObject.getClass().getName(), locala }));
      AppMethodBeat.o(187445);
      throw paramObject;
    }
    AppMethodBeat.o(187445);
  }
  
  final void kKa()
  {
    AppMethodBeat.i(187421);
    this.ajZF = shape(this.nativeHandle);
    AppMethodBeat.o(187421);
  }
  
  final ByteBuffer kKb()
  {
    AppMethodBeat.i(187454);
    ByteBuffer localByteBuffer = buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    AppMethodBeat.o(187454);
    return localByteBuffer;
  }
  
  public static final class a
  {
    private final int ajZI;
    private final float scale;
    
    public a(float paramFloat, int paramInt)
    {
      this.scale = paramFloat;
      this.ajZI = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.tensorflow.lite.Tensor
 * JD-Core Version:    0.7.0.1
 */