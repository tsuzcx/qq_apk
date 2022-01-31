package navsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.i;
import com.tencent.tencentmap.mapsdk.maps.a.k;
import com.tencent.tencentmap.mapsdk.maps.a.l;
import com.tencent.tencentmap.mapsdk.maps.a.m;
import com.tencent.tencentmap.mapsdk.maps.a.n;

public final class RttResponse
  extends m
  implements Cloneable
{
  static byte[] a;
  public byte[] result = null;
  
  static
  {
    AppMethodBeat.i(101143);
    if (!RttResponse.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      byte[] arrayOfByte = (byte[])new byte[1];
      a = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
      AppMethodBeat.o(101143);
      return;
    }
  }
  
  public RttResponse() {}
  
  public RttResponse(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final String className()
  {
    return "navsns.RttResponse";
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(101138);
    localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while (b) {}
      localObject1 = new AssertionError();
      AppMethodBeat.o(101138);
      throw ((Throwable)localObject1);
    }
    AppMethodBeat.o(101138);
    return localObject1;
  }
  
  public final void display(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(101141);
    new i(paramStringBuilder, paramInt).a(this.result, "result");
    AppMethodBeat.o(101141);
  }
  
  public final void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    AppMethodBeat.i(101142);
    new i(paramStringBuilder, paramInt).a(this.result, false);
    AppMethodBeat.o(101142);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(101136);
    if (paramObject == null)
    {
      AppMethodBeat.o(101136);
      return false;
    }
    paramObject = (RttResponse)paramObject;
    boolean bool = n.a(this.result, paramObject.result);
    AppMethodBeat.o(101136);
    return bool;
  }
  
  public final String fullClassName()
  {
    return "navsns.RttResponse";
  }
  
  public final byte[] getResult()
  {
    return this.result;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(101137);
    try
    {
      Exception localException1 = new Exception("Need define key first!");
      AppMethodBeat.o(101137);
      throw localException1;
    }
    catch (Exception localException2)
    {
      AppMethodBeat.o(101137);
    }
    return 0;
  }
  
  public final void readFrom(k paramk)
  {
    AppMethodBeat.i(101140);
    this.result = ((byte[])paramk.a(a, 0, true));
    AppMethodBeat.o(101140);
  }
  
  public final void setResult(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final void writeTo(l paraml)
  {
    AppMethodBeat.i(101139);
    paraml.a(this.result, 0);
    AppMethodBeat.o(101139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     navsns.RttResponse
 * JD-Core Version:    0.7.0.1
 */