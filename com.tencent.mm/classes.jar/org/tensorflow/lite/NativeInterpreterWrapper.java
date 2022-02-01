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
  private final List<b> TiL;
  private long Uje;
  private long Ujf;
  private long Ujg;
  private long Ujh;
  private long Uji;
  private ByteBuffer Ujj;
  private Map<String, Integer> Ujk;
  private Map<String, Integer> Ujl;
  public Tensor[] Ujm;
  public Tensor[] Ujn;
  private boolean Ujo;
  private final List<AutoCloseable> Ujp;
  
  NativeInterpreterWrapper(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(238969);
    this.Ujh = 0L;
    this.Uji = -1L;
    this.Ujo = false;
    this.TiL = new ArrayList();
    this.Ujp = new ArrayList();
    TensorFlowLite.init();
    if ((paramByteBuffer == null) || ((!(paramByteBuffer instanceof MappedByteBuffer)) && ((!paramByteBuffer.isDirect()) || (paramByteBuffer.order() != ByteOrder.nativeOrder()))))
    {
      paramByteBuffer = new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
      AppMethodBeat.o(238969);
      throw paramByteBuffer;
    }
    this.Ujj = paramByteBuffer;
    long l1 = createErrorReporter(512);
    long l2 = createModelWithBuffer(this.Ujj, l1);
    paramByteBuffer = new c.a();
    this.Uje = l1;
    this.Ujg = l2;
    this.Ujf = createInterpreter(l2, l1, paramByteBuffer.UiY);
    if ((paramByteBuffer.Ujc != null) && (paramByteBuffer.Ujc.booleanValue())) {
      this.Ujh = createCancellationFlag(this.Ujf);
    }
    this.Ujm = new Tensor[getInputCount(this.Ujf)];
    this.Ujn = new Tensor[getOutputCount(this.Ujf)];
    if (paramByteBuffer.Uja != null) {
      allowFp16PrecisionForFp32(this.Ujf, paramByteBuffer.Uja.booleanValue());
    }
    if (paramByteBuffer.Ujb != null) {
      allowBufferHandleOutput(this.Ujf, paramByteBuffer.Ujb.booleanValue());
    }
    a(paramByteBuffer);
    if (paramByteBuffer.Ujd != null) {
      useXNNPACK(this.Ujf, l1, paramByteBuffer.Ujd.booleanValue(), paramByteBuffer.UiY);
    }
    allocateTensors(this.Ujf, l1);
    this.Ujo = true;
    AppMethodBeat.o(238969);
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(238974);
    boolean bool = hasUnresolvedFlexOp(this.Ujf);
    Object localObject;
    if (bool)
    {
      localObject = kO(parama.TiL);
      if (localObject != null)
      {
        this.Ujp.add((AutoCloseable)localObject);
        applyDelegate(this.Ujf, this.Uje, ((b)localObject).getNativeHandle());
      }
    }
    try
    {
      localObject = parama.TiL.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        applyDelegate(this.Ujf, this.Uje, localb.getNativeHandle());
        this.TiL.add(localb);
      }
      int i;
      return;
    }
    catch (IllegalArgumentException parama)
    {
      if ((bool) && (!hasUnresolvedFlexOp(this.Ujf))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(238974);
        throw parama;
        if ((parama.UiZ != null) && (parama.UiZ.booleanValue()))
        {
          parama = new NnApiDelegate();
          this.Ujp.add(parama);
          applyDelegate(this.Ujf, this.Uje, parama.Ujw);
        }
        AppMethodBeat.o(238974);
        return;
      }
      System.err.println("Ignoring failed delegate application: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(238974);
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
  
  private static b kO(List<b> paramList)
  {
    AppMethodBeat.i(238975);
    try
    {
      Class localClass = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        boolean bool = localClass.isInstance((b)paramList.next());
        if (bool)
        {
          AppMethodBeat.o(238975);
          return null;
        }
      }
      paramList = (b)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(238975);
      return paramList;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(238975);
    }
    return null;
  }
  
  private static native void numThreads(long paramLong, int paramInt);
  
  private static native void resetVariableTensors(long paramLong1, long paramLong2);
  
  private static native boolean resizeInput(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfInt, boolean paramBoolean);
  
  private static native void run(long paramLong1, long paramLong2);
  
  private static native void setCancelled(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native void useXNNPACK(long paramLong1, long paramLong2, boolean paramBoolean, int paramInt);
  
  public final void a(Object[] paramArrayOfObject, Map<Integer, Object> paramMap)
  {
    AppMethodBeat.i(238971);
    this.Uji = -1L;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Inputs should not be null or empty.");
      AppMethodBeat.o(238971);
      throw paramArrayOfObject;
    }
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Outputs should not be null or empty.");
      AppMethodBeat.o(238971);
      throw paramArrayOfObject;
    }
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramArrayOfObject.length)
    {
      localObject3 = awn(i);
      localObject1 = paramArrayOfObject[i];
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 != null) && (resizeInput(this.Ujf, this.Uje, i, (int[])localObject1, false)))
        {
          this.Ujo = false;
          if (this.Ujm[i] != null) {
            this.Ujm[i].hQs();
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
          ((Tensor)localObject3).gK(localObject1);
          localObject2 = ((Tensor)localObject3).gI(localObject1);
          localObject1 = localObject2;
          if (Arrays.equals(((Tensor)localObject3).Ujr, (int[])localObject2)) {
            localObject1 = null;
          }
        }
      }
    }
    if (!this.Ujo) {}
    int j;
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        allocateTensors(this.Ujf, this.Uje);
        this.Ujo = true;
      }
      j = 0;
      if (j >= paramArrayOfObject.length) {
        break label843;
      }
      localObject1 = awn(j);
      localObject2 = paramArrayOfObject[j];
      if (localObject2 != null) {
        break;
      }
      if (Tensor.hasDelegateBufferHandle(((Tensor)localObject1).nativeHandle)) {
        break label564;
      }
      paramArrayOfObject = new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
      AppMethodBeat.o(238971);
      throw paramArrayOfObject;
    }
    ((Tensor)localObject1).gK(localObject2);
    if ((localObject2 instanceof Buffer))
    {
      localObject3 = (Buffer)localObject2;
      int m = Tensor.numBytes(((Tensor)localObject1).nativeHandle);
      if ((localObject2 instanceof ByteBuffer)) {}
      for (int k = ((Buffer)localObject3).capacity(); m != k; k = ((Buffer)localObject3).capacity() * ((Tensor)localObject1).Ujq.hQq())
      {
        paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Integer.valueOf(m), Integer.valueOf(k) }));
        AppMethodBeat.o(238971);
        throw paramArrayOfObject;
      }
    }
    Object localObject3 = ((Tensor)localObject1).gI(localObject2);
    if (!Arrays.equals((int[])localObject3, ((Tensor)localObject1).Ujr))
    {
      paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Arrays.toString(((Tensor)localObject1).Ujr), Arrays.toString((int[])localObject3) }));
      AppMethodBeat.o(238971);
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
      ((Tensor)localObject1).Pf().put((ByteBuffer)localObject3);
      continue;
      if ((localObject2 instanceof LongBuffer))
      {
        localObject3 = (LongBuffer)localObject2;
        if ((((LongBuffer)localObject3).isDirect()) && (((LongBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).Pf().asLongBuffer().put((LongBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof FloatBuffer))
      {
        localObject3 = (FloatBuffer)localObject2;
        if ((((FloatBuffer)localObject3).isDirect()) && (((FloatBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).Pf().asFloatBuffer().put((FloatBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof IntBuffer))
      {
        localObject3 = (IntBuffer)localObject2;
        if ((((IntBuffer)localObject3).isDirect()) && (((IntBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).Pf().asIntBuffer().put((IntBuffer)localObject3);
        }
      }
      else
      {
        paramArrayOfObject = new IllegalArgumentException("Unexpected input buffer type: ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(238971);
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
    run(this.Ujf, this.Uje);
    long l2 = System.nanoTime();
    if (i != 0)
    {
      i = 0;
      while (i < this.Ujn.length)
      {
        if (this.Ujn[i] != null) {
          this.Ujn[i].hQs();
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramMap.entrySet().iterator();
    while (paramArrayOfObject.hasNext())
    {
      localObject1 = (Map.Entry)paramArrayOfObject.next();
      paramMap = awo(((Integer)((Map.Entry)localObject1).getKey()).intValue());
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 == null)
      {
        if (!Tensor.hasDelegateBufferHandle(paramMap.nativeHandle))
        {
          paramArrayOfObject = new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
          AppMethodBeat.o(238971);
          throw paramArrayOfObject;
        }
      }
      else
      {
        paramMap.gK(localObject1);
        if ((localObject1 instanceof Buffer))
        {
          localObject2 = (Buffer)localObject1;
          j = Tensor.numBytes(paramMap.nativeHandle);
          if ((localObject1 instanceof ByteBuffer)) {}
          for (i = ((Buffer)localObject2).capacity(); j > i; i = ((Buffer)localObject2).capacity() * paramMap.Ujq.hQq())
          {
            paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[] { Tensor.name(paramMap.nativeHandle), Integer.valueOf(j), Integer.valueOf(i) }));
            AppMethodBeat.o(238971);
            throw paramArrayOfObject;
          }
        }
        localObject2 = paramMap.gI(localObject1);
        if (!Arrays.equals((int[])localObject2, paramMap.Ujr))
        {
          paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", new Object[] { Tensor.name(paramMap.nativeHandle), Arrays.toString(paramMap.Ujr), Arrays.toString((int[])localObject2) }));
          AppMethodBeat.o(238971);
          throw paramArrayOfObject;
        }
        if ((localObject1 instanceof Buffer))
        {
          localObject1 = (Buffer)localObject1;
          if ((localObject1 instanceof ByteBuffer))
          {
            ((ByteBuffer)localObject1).put(paramMap.Pf());
          }
          else if ((localObject1 instanceof FloatBuffer))
          {
            ((FloatBuffer)localObject1).put(paramMap.Pf().asFloatBuffer());
          }
          else if ((localObject1 instanceof LongBuffer))
          {
            ((LongBuffer)localObject1).put(paramMap.Pf().asLongBuffer());
          }
          else if ((localObject1 instanceof IntBuffer))
          {
            ((IntBuffer)localObject1).put(paramMap.Pf().asIntBuffer());
          }
          else
          {
            paramArrayOfObject = new IllegalArgumentException("Unexpected output buffer type: ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(238971);
            throw paramArrayOfObject;
          }
        }
        else
        {
          Tensor.readMultiDimensionalArray(paramMap.nativeHandle, localObject1);
        }
      }
    }
    this.Uji = (l2 - l1);
    AppMethodBeat.o(238971);
  }
  
  public final Tensor awn(int paramInt)
  {
    AppMethodBeat.i(238972);
    if ((paramInt < 0) || (paramInt >= this.Ujm.length))
    {
      localObject1 = new IllegalArgumentException("Invalid input Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(238972);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.Ujm[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.Ujm;
      localObject1 = Tensor.ax(this.Ujf, getInputTensorIndex(this.Ujf, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(238972);
    return localObject1;
  }
  
  public final Tensor awo(int paramInt)
  {
    AppMethodBeat.i(238973);
    if ((paramInt < 0) || (paramInt >= this.Ujn.length))
    {
      localObject1 = new IllegalArgumentException("Invalid output Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(238973);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.Ujn[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.Ujn;
      localObject1 = Tensor.ax(this.Ujf, getOutputTensorIndex(this.Ujf, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(238973);
    return localObject1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(238970);
    int i = 0;
    while (i < this.Ujm.length)
    {
      if (this.Ujm[i] != null)
      {
        this.Ujm[i].close();
        this.Ujm[i] = null;
      }
      i += 1;
    }
    i = 0;
    while (i < this.Ujn.length)
    {
      if (this.Ujn[i] != null)
      {
        this.Ujn[i].close();
        this.Ujn[i] = null;
      }
      i += 1;
    }
    delete(this.Uje, this.Ujg, this.Ujf);
    deleteCancellationFlag(this.Ujh);
    this.Uje = 0L;
    this.Ujg = 0L;
    this.Ujf = 0L;
    this.Ujh = 0L;
    this.Ujj = null;
    this.Ujk = null;
    this.Ujl = null;
    this.Ujo = false;
    this.TiL.clear();
    Iterator localIterator = this.Ujp.iterator();
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
    this.Ujp.clear();
    AppMethodBeat.o(238970);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.tensorflow.lite.NativeInterpreterWrapper
 * JD-Core Version:    0.7.0.1
 */