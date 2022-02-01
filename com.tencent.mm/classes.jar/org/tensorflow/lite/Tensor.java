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
  public final a Ujq;
  int[] Ujr;
  private final int[] Ujs;
  private final Tensor.a Ujt;
  public long nativeHandle;
  
  private Tensor(long paramLong)
  {
    AppMethodBeat.i(238984);
    this.nativeHandle = paramLong;
    this.Ujq = a.awm(dtype(paramLong));
    this.Ujr = shape(paramLong);
    this.Ujs = shapeSignature(paramLong);
    this.Ujt = new Tensor.a(quantizationScale(paramLong), quantizationZeroPoint(paramLong));
    AppMethodBeat.o(238984);
  }
  
  private static void a(Object paramObject, int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    AppMethodBeat.i(238982);
    if ((paramArrayOfInt == null) || (paramInt == paramArrayOfInt.length))
    {
      AppMethodBeat.o(238982);
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
        AppMethodBeat.o(238982);
        throw paramObject;
      }
    }
    AppMethodBeat.o(238982);
  }
  
  static Tensor ax(long paramLong, int paramInt)
  {
    AppMethodBeat.i(238976);
    Tensor localTensor = new Tensor(create(paramLong, paramInt));
    AppMethodBeat.o(238976);
    return localTensor;
  }
  
  private static native ByteBuffer buffer(long paramLong);
  
  private static native long create(long paramLong, int paramInt);
  
  private static native void delete(long paramLong);
  
  private static native int dtype(long paramLong);
  
  private a gH(Object paramObject)
  {
    AppMethodBeat.i(238979);
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
          paramObject = a.UiN;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Integer.TYPE.equals(localClass))
        {
          paramObject = a.UiO;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Byte.TYPE.equals(localClass))
        {
          if (this.Ujq == a.UiR)
          {
            paramObject = a.UiR;
            AppMethodBeat.o(238979);
            return paramObject;
          }
          paramObject = a.UiP;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Long.TYPE.equals(localClass))
        {
          paramObject = a.UiQ;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Boolean.TYPE.equals(localClass))
        {
          paramObject = a.UiS;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.UiR;
          AppMethodBeat.o(238979);
          return paramObject;
        }
      }
      else
      {
        if ((Float.class.equals(localClass)) || ((paramObject instanceof FloatBuffer)))
        {
          paramObject = a.UiN;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if ((Integer.class.equals(localClass)) || ((paramObject instanceof IntBuffer)))
        {
          paramObject = a.UiO;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Byte.class.equals(localClass))
        {
          paramObject = a.UiP;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if ((Long.class.equals(localClass)) || ((paramObject instanceof LongBuffer)))
        {
          paramObject = a.UiQ;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (Boolean.class.equals(localClass))
        {
          paramObject = a.UiS;
          AppMethodBeat.o(238979);
          return paramObject;
        }
        if (String.class.equals(localClass))
        {
          paramObject = a.UiR;
          AppMethodBeat.o(238979);
          return paramObject;
        }
      }
    }
    paramObject = new IllegalArgumentException("DataType error: cannot resolve DataType of " + paramObject.getClass().getName());
    AppMethodBeat.o(238979);
    throw paramObject;
  }
  
  private static int gJ(Object paramObject)
  {
    AppMethodBeat.i(238981);
    if ((paramObject == null) || (!paramObject.getClass().isArray()))
    {
      AppMethodBeat.o(238981);
      return 0;
    }
    if (Array.getLength(paramObject) == 0)
    {
      paramObject = new IllegalArgumentException("Array lengths cannot be 0.");
      AppMethodBeat.o(238981);
      throw paramObject;
    }
    int i = gJ(Array.get(paramObject, 0));
    AppMethodBeat.o(238981);
    return i + 1;
  }
  
  static native boolean hasDelegateBufferHandle(long paramLong);
  
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
  
  final ByteBuffer Pf()
  {
    AppMethodBeat.i(238985);
    ByteBuffer localByteBuffer = buffer(this.nativeHandle).order(ByteOrder.nativeOrder());
    AppMethodBeat.o(238985);
    return localByteBuffer;
  }
  
  final void close()
  {
    AppMethodBeat.i(238977);
    delete(this.nativeHandle);
    this.nativeHandle = 0L;
    AppMethodBeat.o(238977);
  }
  
  final int[] gI(Object paramObject)
  {
    AppMethodBeat.i(238980);
    int i = gJ(paramObject);
    Object localObject;
    if (this.Ujq == a.UiR)
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
      AppMethodBeat.o(238980);
      return localObject;
    }
  }
  
  final void gK(Object paramObject)
  {
    AppMethodBeat.i(238983);
    if ((paramObject instanceof ByteBuffer))
    {
      AppMethodBeat.o(238983);
      return;
    }
    a locala = gH(paramObject);
    if (locala != this.Ujq)
    {
      if (locala.hQr().equals(this.Ujq.hQr()))
      {
        AppMethodBeat.o(238983);
        return;
      }
      paramObject = new IllegalArgumentException(String.format("Cannot convert between a TensorFlowLite tensor with type %s and a Java object of type %s (which is compatible with the TensorFlowLite type %s).", new Object[] { this.Ujq, paramObject.getClass().getName(), locala }));
      AppMethodBeat.o(238983);
      throw paramObject;
    }
    AppMethodBeat.o(238983);
  }
  
  final void hQs()
  {
    AppMethodBeat.i(238978);
    this.Ujr = shape(this.nativeHandle);
    AppMethodBeat.o(238978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.Tensor
 * JD-Core Version:    0.7.0.1
 */