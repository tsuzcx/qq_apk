package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final f.a.a.b.a.a LVo;
  private int LVp;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.LVp = 0;
    this.LVo = new f.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> ajj(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.LVo.ajj(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int gfc()
  {
    AppMethodBeat.i(2400);
    int i = this.LVo.xF();
    AppMethodBeat.o(2400);
    return i;
  }
  
  public final String gfd()
  {
    AppMethodBeat.i(210386);
    String str = this.LVo.readString();
    AppMethodBeat.o(210386);
    return str;
  }
  
  public final boolean gfe()
  {
    AppMethodBeat.i(210387);
    boolean bool = this.LVo.fZX();
    AppMethodBeat.o(210387);
    return bool;
  }
  
  public final int gff()
  {
    AppMethodBeat.i(168735);
    this.LVp = this.LVo.xE();
    int i = f.a.a.b.a.fO(this.LVp);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void gfg()
  {
    AppMethodBeat.i(2403);
    int i = f.a.a.b.a.fN(this.LVp);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(f.a.a.b.a.fO(this.LVp)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.LVo.gaa())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.LVo.gab())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.LVo.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.LVo.xG());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */