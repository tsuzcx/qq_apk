package org.tensorflow.lite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.tensorflow.lite.nnapi.NnApiDelegate;

public final class NativeInterpreterWrapper
  implements AutoCloseable
{
  private final List<b> aiIp;
  public Tensor[] ajZA;
  public Tensor[] ajZB;
  private boolean ajZC;
  private final List<AutoCloseable> ajZD;
  private long ajZs;
  private long ajZt;
  private long ajZu;
  private long ajZv;
  private long ajZw;
  private ByteBuffer ajZx;
  private Map<String, Integer> ajZy;
  private Map<String, Integer> ajZz;
  
  NativeInterpreterWrapper(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(187259);
    this.ajZv = 0L;
    this.ajZw = -1L;
    this.ajZC = false;
    this.aiIp = new ArrayList();
    this.ajZD = new ArrayList();
    TensorFlowLite.init();
    if ((paramByteBuffer == null) || ((!(paramByteBuffer instanceof MappedByteBuffer)) && ((!paramByteBuffer.isDirect()) || (paramByteBuffer.order() != ByteOrder.nativeOrder()))))
    {
      paramByteBuffer = new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
      AppMethodBeat.o(187259);
      throw paramByteBuffer;
    }
    this.ajZx = paramByteBuffer;
    long l1 = createErrorReporter(512);
    long l2 = createModelWithBuffer(this.ajZx, l1);
    paramByteBuffer = new c.a();
    this.ajZs = l1;
    this.ajZu = l2;
    this.ajZt = createInterpreter(l2, l1, paramByteBuffer.numThreads);
    if ((paramByteBuffer.ajZq != null) && (paramByteBuffer.ajZq.booleanValue())) {
      this.ajZv = createCancellationFlag(this.ajZt);
    }
    this.ajZA = new Tensor[getInputCount(this.ajZt)];
    this.ajZB = new Tensor[getOutputCount(this.ajZt)];
    if (paramByteBuffer.ajZo != null) {
      allowFp16PrecisionForFp32(this.ajZt, paramByteBuffer.ajZo.booleanValue());
    }
    if (paramByteBuffer.ajZp != null) {
      allowBufferHandleOutput(this.ajZt, paramByteBuffer.ajZp.booleanValue());
    }
    a(paramByteBuffer);
    if (paramByteBuffer.ajZr != null) {
      useXNNPACK(this.ajZt, l1, paramByteBuffer.ajZr.booleanValue(), paramByteBuffer.numThreads);
    }
    allocateTensors(this.ajZt, l1);
    this.ajZC = true;
    AppMethodBeat.o(187259);
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(187293);
    boolean bool = hasUnresolvedFlexOp(this.ajZt);
    Object localObject;
    if (bool)
    {
      localObject = po(parama.aiIp);
      if (localObject != null)
      {
        this.ajZD.add((AutoCloseable)localObject);
        applyDelegate(this.ajZt, this.ajZs, ((b)localObject).getNativeHandle());
      }
    }
    try
    {
      localObject = parama.aiIp.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        applyDelegate(this.ajZt, this.ajZs, localb.getNativeHandle());
        this.aiIp.add(localb);
      }
      int i;
      return;
    }
    catch (IllegalArgumentException parama)
    {
      if ((bool) && (!hasUnresolvedFlexOp(this.ajZt))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(187293);
        throw parama;
        if ((parama.ajZn != null) && (parama.ajZn.booleanValue()))
        {
          parama = new NnApiDelegate();
          this.ajZD.add(parama);
          applyDelegate(this.ajZt, this.ajZs, parama.ajZK);
        }
        AppMethodBeat.o(187293);
        return;
      }
      System.err.println("Ignoring failed delegate application: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(187293);
    }
  }
  
  private static native long allocateTensors(long paramLong1, long paramLong2);
  
  private static native void allowBufferHandleOutput(long paramLong, boolean paramBoolean);
  
  private static native void allowFp16PrecisionForFp32(long paramLong, boolean paramBoolean);
  
  private static native void applyDelegate(long paramLong1, long paramLong2, long paramLong3);
  
  private static native long createCancellationFlag(long paramLong);
  
  private static native long createErrorReporter(int paramInt);
  
  private static native long createInterpreter(long paramLong1, long paramLong2, int paramInt);
  
  private static native long createModel(String paramString, long paramLong);
  
  private static native long createModelWithBuffer(ByteBuffer paramByteBuffer, long paramLong);
  
  private static native void delete(long paramLong1, long paramLong2, long paramLong3);
  
  private static native long deleteCancellationFlag(long paramLong);
  
  private static native int getExecutionPlanLength(long paramLong);
  
  private static native int getInputCount(long paramLong);
  
  private static native String[] getInputNames(long paramLong);
  
  private static native int getInputTensorIndex(long paramLong, int paramInt);
  
  private static native int getOutputCount(long paramLong);
  
  private static native int getOutputDataType(long paramLong, int paramInt);
  
  private static native String[] getOutputNames(long paramLong);
  
  private static native int getOutputTensorIndex(long paramLong, int paramInt);
  
  private static native boolean hasUnresolvedFlexOp(long paramLong);
  
  private static native void numThreads(long paramLong, int paramInt);
  
  private static b po(List<b> paramList)
  {
    AppMethodBeat.i(187301);
    try
    {
      Class localClass = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        boolean bool = localClass.isInstance((b)paramList.next());
        if (bool)
        {
          AppMethodBeat.o(187301);
          return null;
        }
      }
      paramList = (b)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(187301);
      return paramList;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(187301);
    }
    return null;
  }
  
  private static native void resetVariableTensors(long paramLong1, long paramLong2);
  
  private static native boolean resizeInput(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfInt, boolean paramBoolean);
  
  private static native void run(long paramLong1, long paramLong2);
  
  private static native void setCancelled(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native void useXNNPACK(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt);
  
  public final void a(Object[] paramArrayOfObject, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(187456);
    this.ajZw = -1L;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Inputs should not be null or empty.");
      AppMethodBeat.o(187456);
      throw paramArrayOfObject;
    }
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Outputs should not be null or empty.");
      AppMethodBeat.o(187456);
      throw paramArrayOfObject;
    }
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramArrayOfObject.length)
    {
      localObject3 = aNx(i);
      localObject1 = paramArrayOfObject[i];
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 != null) && (resizeInput(this.ajZt, this.ajZs, i, (int[])localObject1, false)))
        {
          this.ajZC = false;
          if (this.ajZA[i] != null) {
            this.ajZA[i].kKa();
          }
        }
        i += 1;
        break;
        if ((localObject1 instanceof Buffer))
        {
          localObject1 = null;
        }
        else
        {
          ((Tensor)localObject3).jT(localObject1);
          localObject2 = ((Tensor)localObject3).jR(localObject1);
          localObject1 = localObject2;
          if (Arrays.equals(((Tensor)localObject3).ajZF, (int[])localObject2)) {
            localObject1 = null;
          }
        }
      }
    }
    if (!this.ajZC) {}
    int j;
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        allocateTensors(this.ajZt, this.ajZs);
        this.ajZC = true;
      }
      j = 0;
      if (j >= paramArrayOfObject.length) {
        break label843;
      }
      localObject1 = aNx(j);
      localObject2 = paramArrayOfObject[j];
      if (localObject2 != null) {
        break;
      }
      if (Tensor.hasDelegateBufferHandle(((Tensor)localObject1).nativeHandle)) {
        break label564;
      }
      paramArrayOfObject = new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
      AppMethodBeat.o(187456);
      throw paramArrayOfObject;
    }
    ((Tensor)localObject1).jT(localObject2);
    if ((localObject2 instanceof Buffer))
    {
      localObject3 = (Buffer)localObject2;
      int m = Tensor.numBytes(((Tensor)localObject1).nativeHandle);
      if ((localObject2 instanceof ByteBuffer)) {}
      for (int k = ((Buffer)localObject3).capacity(); m != k; k = ((Buffer)localObject3).capacity() * ((Tensor)localObject1).ajZE.kJY())
      {
        paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Integer.valueOf(m), Integer.valueOf(k) }));
        AppMethodBeat.o(187456);
        throw paramArrayOfObject;
      }
    }
    Object localObject3 = ((Tensor)localObject1).jR(localObject2);
    if (!Arrays.equals((int[])localObject3, ((Tensor)localObject1).ajZF))
    {
      paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Arrays.toString(((Tensor)localObject1).ajZF), Arrays.toString((int[])localObject3) }));
      AppMethodBeat.o(187456);
      throw paramArrayOfObject;
    }
    if ((localObject2 instanceof Buffer))
    {
      localObject2 = (Buffer)localObject2;
      if ((localObject2 instanceof ByteBuffer))
      {
        localObject3 = (ByteBuffer)localObject2;
        if ((((ByteBuffer)localObject3).isDirect()) && (((ByteBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        }
      }
    }
    for (;;)
    {
      label564:
      j += 1;
      break;
      ((Tensor)localObject1).kKb().put((ByteBuffer)localObject3);
      continue;
      if ((localObject2 instanceof LongBuffer))
      {
        localObject3 = (LongBuffer)localObject2;
        if ((((LongBuffer)localObject3).isDirect()) && (((LongBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).kKb().asLongBuffer().put((LongBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof FloatBuffer))
      {
        localObject3 = (FloatBuffer)localObject2;
        if ((((FloatBuffer)localObject3).isDirect()) && (((FloatBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).kKb().asFloatBuffer().put((FloatBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof IntBuffer))
      {
        localObject3 = (IntBuffer)localObject2;
        if ((((IntBuffer)localObject3).isDirect()) && (((IntBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).kKb().asIntBuffer().put((IntBuffer)localObject3);
        }
      }
      else
      {
        paramArrayOfObject = new IllegalArgumentException("Unexpected input buffer type: ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(187456);
        throw paramArrayOfObject;
        if (localObject2.getClass().isArray()) {
          Tensor.writeMultiDimensionalArray(((Tensor)localObject1).nativeHandle, localObject2);
        } else {
          Tensor.writeScalar(((Tensor)localObject1).nativeHandle, localObject2);
        }
      }
    }
    label843:
    long l1 = System.nanoTime();
    run(this.ajZt, this.ajZs);
    long l2 = System.nanoTime();
    if (i != 0)
    {
      i = 0;
      while (i < this.ajZB.length)
      {
        if (this.ajZB[i] != null) {
          this.ajZB[i].kKa();
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramMap.entrySet().iterator();
    while (paramArrayOfObject.hasNext())
    {
      localObject1 = (Map.Entry)paramArrayOfObject.next();
      paramMap = aNy(((Integer)((Map.Entry)localObject1).getKey()).intValue());
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 == null)
      {
        if (!Tensor.hasDelegateBufferHandle(paramMap.nativeHandle))
        {
          paramArrayOfObject = new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
          AppMethodBeat.o(187456);
          throw paramArrayOfObject;
        }
      }
      else
      {
        paramMap.jT(localObject1);
        if ((localObject1 instanceof Buffer))
        {
          localObject2 = (Buffer)localObject1;
          j = Tensor.numBytes(paramMap.nativeHandle);
          if ((localObject1 instanceof ByteBuffer)) {}
          for (i = ((Buffer)localObject2).capacity(); j > i; i = ((Buffer)localObject2).capacity() * paramMap.ajZE.kJY())
          {
            paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[] { Tensor.name(paramMap.nativeHandle), Integer.valueOf(j), Integer.valueOf(i) }));
            AppMethodBeat.o(187456);
            throw paramArrayOfObject;
          }
        }
        localObject2 = paramMap.jR(localObject1);
        if (!Arrays.equals((int[])localObject2, paramMap.ajZF))
        {
          paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", new Object[] { Tensor.name(paramMap.nativeHandle), Arrays.toString(paramMap.ajZF), Arrays.toString((int[])localObject2) }));
          AppMethodBeat.o(187456);
          throw paramArrayOfObject;
        }
        if ((localObject1 instanceof Buffer))
        {
          localObject1 = (Buffer)localObject1;
          if ((localObject1 instanceof ByteBuffer))
          {
            ((ByteBuffer)localObject1).put(paramMap.kKb());
          }
          else if ((localObject1 instanceof FloatBuffer))
          {
            ((FloatBuffer)localObject1).put(paramMap.kKb().asFloatBuffer());
          }
          else if ((localObject1 instanceof LongBuffer))
          {
            ((LongBuffer)localObject1).put(paramMap.kKb().asLongBuffer());
          }
          else if ((localObject1 instanceof IntBuffer))
          {
            ((IntBuffer)localObject1).put(paramMap.kKb().asIntBuffer());
          }
          else
          {
            paramArrayOfObject = new IllegalArgumentException("Unexpected output buffer type: ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(187456);
            throw paramArrayOfObject;
          }
        }
        else
        {
          Tensor.readMultiDimensionalArray(paramMap.nativeHandle, localObject1);
        }
      }
    }
    this.ajZw = (l2 - l1);
    AppMethodBeat.o(187456);
  }
  
  public final Tensor aNx(int paramInt)
  {
    AppMethodBeat.i(187464);
    if ((paramInt < 0) || (paramInt >= this.ajZA.length))
    {
      localObject1 = new IllegalArgumentException("Invalid input Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187464);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.ajZA[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.ajZA;
      localObject1 = Tensor.aX(this.ajZt, getInputTensorIndex(this.ajZt, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(187464);
    return localObject1;
  }
  
  public final Tensor aNy(int paramInt)
  {
    AppMethodBeat.i(187471);
    if ((paramInt < 0) || (paramInt >= this.ajZB.length))
    {
      localObject1 = new IllegalArgumentException("Invalid output Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(187471);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.ajZB[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.ajZB;
      localObject1 = Tensor.aX(this.ajZt, getOutputTensorIndex(this.ajZt, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(187471);
    return localObject1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(187425);
    int i = 0;
    while (i < this.ajZA.length)
    {
      if (this.ajZA[i] != null)
      {
        this.ajZA[i].close();
        this.ajZA[i] = null;
      }
      i += 1;
    }
    i = 0;
    while (i < this.ajZB.length)
    {
      if (this.ajZB[i] != null)
      {
        this.ajZB[i].close();
        this.ajZB[i] = null;
      }
      i += 1;
    }
    delete(this.ajZs, this.ajZu, this.ajZt);
    deleteCancellationFlag(this.ajZv);
    this.ajZs = 0L;
    this.ajZu = 0L;
    this.ajZt = 0L;
    this.ajZv = 0L;
    this.ajZx = null;
    this.ajZy = null;
    this.ajZz = null;
    this.ajZC = false;
    this.aiIp.clear();
    Iterator localIterator = this.ajZD.iterator();
    while (localIterator.hasNext())
    {
      AutoCloseable localAutoCloseable = (AutoCloseable)localIterator.next();
      try
      {
        localAutoCloseable.close();
      }
      catch (Exception localException)
      {
        System.err.println("Failed to close flex delegate: ".concat(String.valueOf(localException)));
      }
    }
    this.ajZD.clear();
    AppMethodBeat.o(187425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.tensorflow.lite.NativeInterpreterWrapper
 * JD-Core Version:    0.7.0.1
 */