package g.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.a.a.b;
import java.util.LinkedList;

public class a
{
  public final g.a.a.b.a.a abFh;
  private int abFi;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.abFi = 0;
    this.abFh = new g.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> aGc(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.abFh.aGc(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int iUr()
  {
    AppMethodBeat.i(168735);
    this.abFi = this.abFh.Av();
    int i = g.a.a.b.a.hP(this.abFi);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void iUs()
  {
    AppMethodBeat.i(2403);
    int i = g.a.a.b.a.hO(this.abFi);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(g.a.a.b.a.hP(this.abFi)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.abFh.AO())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.abFh.AP())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.abFh.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.abFh.AN());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     g.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */