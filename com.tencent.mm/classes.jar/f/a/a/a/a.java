package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final f.a.a.b.a.a KhF;
  private int KhG;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.KhG = 0;
    this.KhF = new f.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> agn(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.KhF.agn(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int fMm()
  {
    AppMethodBeat.i(2400);
    int i = this.KhF.xS();
    AppMethodBeat.o(2400);
    return i;
  }
  
  public final String fMn()
  {
    AppMethodBeat.i(205061);
    String str = this.KhF.readString();
    AppMethodBeat.o(205061);
    return str;
  }
  
  public final boolean fMo()
  {
    AppMethodBeat.i(205062);
    boolean bool = this.KhF.fHu();
    AppMethodBeat.o(205062);
    return bool;
  }
  
  public final int fMp()
  {
    AppMethodBeat.i(168735);
    this.KhG = this.KhF.xR();
    int i = f.a.a.b.a.gc(this.KhG);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void fMq()
  {
    AppMethodBeat.i(2403);
    int i = f.a.a.b.a.gb(this.KhG);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(f.a.a.b.a.gc(this.KhG)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.KhF.fHx())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.KhF.fHy())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.KhF.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.KhF.xT());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */