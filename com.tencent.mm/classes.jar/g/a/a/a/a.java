package g.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final g.a.a.b.a.a UbS;
  private int UbT;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.UbT = 0;
    this.UbS = new g.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> awh(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.UbS.awh(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int hPk()
  {
    AppMethodBeat.i(168735);
    this.UbT = this.UbS.yT();
    int i = g.a.a.b.a.gY(this.UbT);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void hPl()
  {
    AppMethodBeat.i(2403);
    int i = g.a.a.b.a.gX(this.UbT);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(g.a.a.b.a.gY(this.UbT)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.UbS.zm())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.UbS.zn())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.UbS.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.UbS.zl());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     g.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */