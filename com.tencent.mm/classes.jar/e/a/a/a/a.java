package e.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final e.a.a.b.a.a CLY;
  public int CLZ;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(51865);
    this.CLZ = 0;
    this.CLY = new e.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(51865);
  }
  
  public final LinkedList<byte[]> Wp(int paramInt)
  {
    AppMethodBeat.i(51870);
    LinkedList localLinkedList = this.CLY.Wp(paramInt);
    AppMethodBeat.o(51870);
    return localLinkedList;
  }
  
  public final int eqN()
  {
    AppMethodBeat.i(51866);
    int i = this.CLY.sl();
    AppMethodBeat.o(51866);
    return i;
  }
  
  public final String eqO()
  {
    AppMethodBeat.i(156877);
    String str = this.CLY.readString();
    AppMethodBeat.o(156877);
    return str;
  }
  
  public final boolean eqP()
  {
    AppMethodBeat.i(156878);
    boolean bool = this.CLY.emu();
    AppMethodBeat.o(156878);
    return bool;
  }
  
  public final void eqQ()
  {
    AppMethodBeat.i(51869);
    int i = e.a.a.b.a.eZ(this.CLZ);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(e.a.a.b.a.fa(this.CLZ)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(51869);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.CLY.emx())));
      AppMethodBeat.o(51869);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.CLY.emy())));
      AppMethodBeat.o(51869);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.CLY.readString());
      AppMethodBeat.o(51869);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.CLY.sm());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     e.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */