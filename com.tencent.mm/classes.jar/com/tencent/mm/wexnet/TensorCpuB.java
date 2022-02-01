package com.tencent.mm.wexnet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/wexnet/TensorCpuB;", "", "dateType", "", "dataShape", "", "data", "", "(I[I[B)V", "getData", "()[B", "getDataShape", "()[I", "getDateType", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TensorCpuB
{
  private final byte[] data;
  private final int[] dataShape;
  private final int dateType;
  
  public TensorCpuB(int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231512);
    this.dateType = paramInt;
    this.dataShape = paramArrayOfInt;
    this.data = paramArrayOfByte;
    AppMethodBeat.o(231512);
  }
  
  public final int component1()
  {
    return this.dateType;
  }
  
  public final int[] component2()
  {
    return this.dataShape;
  }
  
  public final byte[] component3()
  {
    return this.data;
  }
  
  public final TensorCpuB copy(int paramInt, int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(231536);
    s.u(paramArrayOfInt, "dataShape");
    s.u(paramArrayOfByte, "data");
    paramArrayOfInt = new TensorCpuB(paramInt, paramArrayOfInt, paramArrayOfByte);
    AppMethodBeat.o(231536);
    return paramArrayOfInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(231555);
    if (this == paramObject)
    {
      AppMethodBeat.o(231555);
      return true;
    }
    if (!(paramObject instanceof TensorCpuB))
    {
      AppMethodBeat.o(231555);
      return false;
    }
    paramObject = (TensorCpuB)paramObject;
    if (this.dateType != paramObject.dateType)
    {
      AppMethodBeat.o(231555);
      return false;
    }
    if (!s.p(this.dataShape, paramObject.dataShape))
    {
      AppMethodBeat.o(231555);
      return false;
    }
    if (!s.p(this.data, paramObject.data))
    {
      AppMethodBeat.o(231555);
      return false;
    }
    AppMethodBeat.o(231555);
    return true;
  }
  
  public final byte[] getData()
  {
    return this.data;
  }
  
  public final int[] getDataShape()
  {
    return this.dataShape;
  }
  
  public final int getDateType()
  {
    return this.dateType;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(231547);
    int i = this.dateType;
    int j = Arrays.hashCode(this.dataShape);
    int k = Arrays.hashCode(this.data);
    AppMethodBeat.o(231547);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(231541);
    String str = "TensorCpuB(dateType=" + this.dateType + ", dataShape=" + Arrays.toString(this.dataShape) + ", data=" + Arrays.toString(this.data) + ')';
    AppMethodBeat.o(231541);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wexnet.TensorCpuB
 * JD-Core Version:    0.7.0.1
 */