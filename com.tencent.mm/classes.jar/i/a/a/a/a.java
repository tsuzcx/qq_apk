package i.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.a.a.b;
import java.util.LinkedList;

public class a
{
  public final i.a.a.b.a.a ajGk;
  private int ajGl;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.ajGl = 0;
    this.ajGk = new i.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> aMP(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.ajGk.aMP(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int kFS()
  {
    AppMethodBeat.i(168735);
    this.ajGl = this.ajGk.aac();
    int i = i.a.a.b.a.lE(this.ajGl);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void kFT()
  {
    AppMethodBeat.i(2403);
    int i = i.a.a.b.a.lD(this.ajGl);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(i.a.a.b.a.lE(this.ajGl)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.ajGk.aax())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.ajGk.aay())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.ajGk.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.ajGk.aaw());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     i.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */