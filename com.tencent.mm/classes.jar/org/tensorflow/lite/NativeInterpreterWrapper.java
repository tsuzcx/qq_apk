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
  private final List<b> aaLF;
  private long abMA;
  private long abMB;
  private long abMC;
  private long abMD;
  private ByteBuffer abME;
  private Map<String, Integer> abMF;
  private Map<String, Integer> abMG;
  public Tensor[] abMH;
  public Tensor[] abMI;
  private boolean abMJ;
  private final List<AutoCloseable> abMK;
  private long abMz;
  
  NativeInterpreterWrapper(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(239657);
    this.abMC = 0L;
    this.abMD = -1L;
    this.abMJ = false;
    this.aaLF = new ArrayList();
    this.abMK = new ArrayList();
    TensorFlowLite.init();
    if ((paramByteBuffer == null) || ((!(paramByteBuffer instanceof MappedByteBuffer)) && ((!paramByteBuffer.isDirect()) || (paramByteBuffer.order() != ByteOrder.nativeOrder()))))
    {
      paramByteBuffer = new IllegalArgumentException("Model ByteBuffer should be either a MappedByteBuffer of the model file, or a direct ByteBuffer using ByteOrder.nativeOrder() which contains bytes of model content.");
      AppMethodBeat.o(239657);
      throw paramByteBuffer;
    }
    this.abME = paramByteBuffer;
    long l1 = createErrorReporter(512);
    long l2 = createModelWithBuffer(this.abME, l1);
    paramByteBuffer = new c.a();
    this.abMz = l1;
    this.abMB = l2;
    this.abMA = createInterpreter(l2, l1, paramByteBuffer.abMt);
    if ((paramByteBuffer.abMx != null) && (paramByteBuffer.abMx.booleanValue())) {
      this.abMC = createCancellationFlag(this.abMA);
    }
    this.abMH = new Tensor[getInputCount(this.abMA)];
    this.abMI = new Tensor[getOutputCount(this.abMA)];
    if (paramByteBuffer.abMv != null) {
      allowFp16PrecisionForFp32(this.abMA, paramByteBuffer.abMv.booleanValue());
    }
    if (paramByteBuffer.abMw != null) {
      allowBufferHandleOutput(this.abMA, paramByteBuffer.abMw.booleanValue());
    }
    a(paramByteBuffer);
    if (paramByteBuffer.abMy != null) {
      useXNNPACK(this.abMA, l1, paramByteBuffer.abMy.booleanValue(), paramByteBuffer.abMt);
    }
    allocateTensors(this.abMA, l1);
    this.abMJ = true;
    AppMethodBeat.o(239657);
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(239687);
    boolean bool = hasUnresolvedFlexOp(this.abMA);
    Object localObject;
    if (bool)
    {
      localObject = lL(parama.aaLF);
      if (localObject != null)
      {
        this.abMK.add((AutoCloseable)localObject);
        applyDelegate(this.abMA, this.abMz, ((b)localObject).getNativeHandle());
      }
    }
    try
    {
      localObject = parama.aaLF.iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        applyDelegate(this.abMA, this.abMz, localb.getNativeHandle());
        this.aaLF.add(localb);
      }
      int i;
      return;
    }
    catch (IllegalArgumentException parama)
    {
      if ((bool) && (!hasUnresolvedFlexOp(this.abMA))) {}
      for (i = 1; i == 0; i = 0)
      {
        AppMethodBeat.o(239687);
        throw parama;
        if ((parama.abMu != null) && (parama.abMu.booleanValue()))
        {
          parama = new NnApiDelegate();
          this.abMK.add(parama);
          applyDelegate(this.abMA, this.abMz, parama.abMR);
        }
        AppMethodBeat.o(239687);
        return;
      }
      System.err.println("Ignoring failed delegate application: ".concat(String.valueOf(parama)));
      AppMethodBeat.o(239687);
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
  
  private static b lL(List<b> paramList)
  {
    AppMethodBeat.i(239690);
    try
    {
      Class localClass = Class.forName("org.tensorflow.lite.flex.FlexDelegate");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        boolean bool = localClass.isInstance((b)paramList.next());
        if (bool)
        {
          AppMethodBeat.o(239690);
          return null;
        }
      }
      paramList = (b)localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      AppMethodBeat.o(239690);
      return paramList;
    }
    catch (Exception paramList)
    {
      AppMethodBeat.o(239690);
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
    AppMethodBeat.i(239670);
    this.abMD = -1L;
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Inputs should not be null or empty.");
      AppMethodBeat.o(239670);
      throw paramArrayOfObject;
    }
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      paramArrayOfObject = new IllegalArgumentException("Input error: Outputs should not be null or empty.");
      AppMethodBeat.o(239670);
      throw paramArrayOfObject;
    }
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (i < paramArrayOfObject.length)
    {
      localObject3 = aGi(i);
      localObject1 = paramArrayOfObject[i];
      if (localObject1 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject1 != null) && (resizeInput(this.abMA, this.abMz, i, (int[])localObject1, false)))
        {
          this.abMJ = false;
          if (this.abMH[i] != null) {
            this.abMH[i].iVC();
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
          ((Tensor)localObject3).hc(localObject1);
          localObject2 = ((Tensor)localObject3).ha(localObject1);
          localObject1 = localObject2;
          if (Arrays.equals(((Tensor)localObject3).abMM, (int[])localObject2)) {
            localObject1 = null;
          }
        }
      }
    }
    if (!this.abMJ) {}
    int j;
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        allocateTensors(this.abMA, this.abMz);
        this.abMJ = true;
      }
      j = 0;
      if (j >= paramArrayOfObject.length) {
        break label843;
      }
      localObject1 = aGi(j);
      localObject2 = paramArrayOfObject[j];
      if (localObject2 != null) {
        break;
      }
      if (Tensor.hasDelegateBufferHandle(((Tensor)localObject1).nativeHandle)) {
        break label564;
      }
      paramArrayOfObject = new IllegalArgumentException("Null inputs are allowed only if the Tensor is bound to a buffer handle.");
      AppMethodBeat.o(239670);
      throw paramArrayOfObject;
    }
    ((Tensor)localObject1).hc(localObject2);
    if ((localObject2 instanceof Buffer))
    {
      localObject3 = (Buffer)localObject2;
      int m = Tensor.numBytes(((Tensor)localObject1).nativeHandle);
      if ((localObject2 instanceof ByteBuffer)) {}
      for (int k = ((Buffer)localObject3).capacity(); m != k; k = ((Buffer)localObject3).capacity() * ((Tensor)localObject1).abML.iVA())
      {
        paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with %d bytes from a Java Buffer with %d bytes.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Integer.valueOf(m), Integer.valueOf(k) }));
        AppMethodBeat.o(239670);
        throw paramArrayOfObject;
      }
    }
    Object localObject3 = ((Tensor)localObject1).ha(localObject2);
    if (!Arrays.equals((int[])localObject3, ((Tensor)localObject1).abMM))
    {
      paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy to a TensorFlowLite tensor (%s) with shape %s from a Java object with shape %s.", new Object[] { Tensor.name(((Tensor)localObject1).nativeHandle), Arrays.toString(((Tensor)localObject1).abMM), Arrays.toString((int[])localObject3) }));
      AppMethodBeat.o(239670);
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
      ((Tensor)localObject1).SE().put((ByteBuffer)localObject3);
      continue;
      if ((localObject2 instanceof LongBuffer))
      {
        localObject3 = (LongBuffer)localObject2;
        if ((((LongBuffer)localObject3).isDirect()) && (((LongBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).SE().asLongBuffer().put((LongBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof FloatBuffer))
      {
        localObject3 = (FloatBuffer)localObject2;
        if ((((FloatBuffer)localObject3).isDirect()) && (((FloatBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).SE().asFloatBuffer().put((FloatBuffer)localObject3);
        }
      }
      else if ((localObject2 instanceof IntBuffer))
      {
        localObject3 = (IntBuffer)localObject2;
        if ((((IntBuffer)localObject3).isDirect()) && (((IntBuffer)localObject3).order() == ByteOrder.nativeOrder())) {
          Tensor.writeDirectBuffer(((Tensor)localObject1).nativeHandle, (Buffer)localObject2);
        } else {
          ((Tensor)localObject1).SE().asIntBuffer().put((IntBuffer)localObject3);
        }
      }
      else
      {
        paramArrayOfObject = new IllegalArgumentException("Unexpected input buffer type: ".concat(String.valueOf(localObject2)));
        AppMethodBeat.o(239670);
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
    run(this.abMA, this.abMz);
    long l2 = System.nanoTime();
    if (i != 0)
    {
      i = 0;
      while (i < this.abMI.length)
      {
        if (this.abMI[i] != null) {
          this.abMI[i].iVC();
        }
        i += 1;
      }
    }
    paramArrayOfObject = paramMap.entrySet().iterator();
    while (paramArrayOfObject.hasNext())
    {
      localObject1 = (Map.Entry)paramArrayOfObject.next();
      paramMap = aGj(((Integer)((Map.Entry)localObject1).getKey()).intValue());
      localObject1 = ((Map.Entry)localObject1).getValue();
      if (localObject1 == null)
      {
        if (!Tensor.hasDelegateBufferHandle(paramMap.nativeHandle))
        {
          paramArrayOfObject = new IllegalArgumentException("Null outputs are allowed only if the Tensor is bound to a buffer handle.");
          AppMethodBeat.o(239670);
          throw paramArrayOfObject;
        }
      }
      else
      {
        paramMap.hc(localObject1);
        if ((localObject1 instanceof Buffer))
        {
          localObject2 = (Buffer)localObject1;
          j = Tensor.numBytes(paramMap.nativeHandle);
          if ((localObject1 instanceof ByteBuffer)) {}
          for (i = ((Buffer)localObject2).capacity(); j > i; i = ((Buffer)localObject2).capacity() * paramMap.abML.iVA())
          {
            paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with %d bytes to a Java Buffer with %d bytes.", new Object[] { Tensor.name(paramMap.nativeHandle), Integer.valueOf(j), Integer.valueOf(i) }));
            AppMethodBeat.o(239670);
            throw paramArrayOfObject;
          }
        }
        localObject2 = paramMap.ha(localObject1);
        if (!Arrays.equals((int[])localObject2, paramMap.abMM))
        {
          paramArrayOfObject = new IllegalArgumentException(String.format("Cannot copy from a TensorFlowLite tensor (%s) with shape %s to a Java object with shape %s.", new Object[] { Tensor.name(paramMap.nativeHandle), Arrays.toString(paramMap.abMM), Arrays.toString((int[])localObject2) }));
          AppMethodBeat.o(239670);
          throw paramArrayOfObject;
        }
        if ((localObject1 instanceof Buffer))
        {
          localObject1 = (Buffer)localObject1;
          if ((localObject1 instanceof ByteBuffer))
          {
            ((ByteBuffer)localObject1).put(paramMap.SE());
          }
          else if ((localObject1 instanceof FloatBuffer))
          {
            ((FloatBuffer)localObject1).put(paramMap.SE().asFloatBuffer());
          }
          else if ((localObject1 instanceof LongBuffer))
          {
            ((LongBuffer)localObject1).put(paramMap.SE().asLongBuffer());
          }
          else if ((localObject1 instanceof IntBuffer))
          {
            ((IntBuffer)localObject1).put(paramMap.SE().asIntBuffer());
          }
          else
          {
            paramArrayOfObject = new IllegalArgumentException("Unexpected output buffer type: ".concat(String.valueOf(localObject1)));
            AppMethodBeat.o(239670);
            throw paramArrayOfObject;
          }
        }
        else
        {
          Tensor.readMultiDimensionalArray(paramMap.nativeHandle, localObject1);
        }
      }
    }
    this.abMD = (l2 - l1);
    AppMethodBeat.o(239670);
  }
  
  public final Tensor aGi(int paramInt)
  {
    AppMethodBeat.i(239678);
    if ((paramInt < 0) || (paramInt >= this.abMH.length))
    {
      localObject1 = new IllegalArgumentException("Invalid input Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(239678);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.abMH[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.abMH;
      localObject1 = Tensor.aG(this.abMA, getInputTensorIndex(this.abMA, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(239678);
    return localObject1;
  }
  
  public final Tensor aGj(int paramInt)
  {
    AppMethodBeat.i(239683);
    if ((paramInt < 0) || (paramInt >= this.abMI.length))
    {
      localObject1 = new IllegalArgumentException("Invalid output Tensor index: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(239683);
      throw ((Throwable)localObject1);
    }
    Object localObject2 = this.abMI[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.abMI;
      localObject1 = Tensor.aG(this.abMA, getOutputTensorIndex(this.abMA, paramInt));
      localObject2[paramInt] = localObject1;
    }
    AppMethodBeat.o(239683);
    return localObject1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(239661);
    int i = 0;
    while (i < this.abMH.length)
    {
      if (this.abMH[i] != null)
      {
        this.abMH[i].close();
        this.abMH[i] = null;
      }
      i += 1;
    }
    i = 0;
    while (i < this.abMI.length)
    {
      if (this.abMI[i] != null)
      {
        this.abMI[i].close();
        this.abMI[i] = null;
      }
      i += 1;
    }
    delete(this.abMz, this.abMB, this.abMA);
    deleteCancellationFlag(this.abMC);
    this.abMz = 0L;
    this.abMB = 0L;
    this.abMA = 0L;
    this.abMC = 0L;
    this.abME = null;
    this.abMF = null;
    this.abMG = null;
    this.abMJ = false;
    this.aaLF.clear();
    Iterator localIterator = this.abMK.iterator();
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
    this.abMK.clear();
    AppMethodBeat.o(239661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.tensorflow.lite.NativeInterpreterWrapper
 * JD-Core Version:    0.7.0.1
 */