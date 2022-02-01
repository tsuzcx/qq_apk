package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final f.a.a.b.a.a OmT;
  private int OmU;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.OmU = 0;
    this.OmT = new f.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> amA(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.OmT.amA(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int gCc()
  {
    AppMethodBeat.i(2400);
    int i = this.OmT.zc();
    AppMethodBeat.o(2400);
    return i;
  }
  
  public final String gCd()
  {
    AppMethodBeat.i(224312);
    String str = this.OmT.readString();
    AppMethodBeat.o(224312);
    return str;
  }
  
  public final boolean gCe()
  {
    AppMethodBeat.i(224313);
    boolean bool = this.OmT.gvY();
    AppMethodBeat.o(224313);
    return bool;
  }
  
  public final int gCf()
  {
    AppMethodBeat.i(168735);
    this.OmU = this.OmT.zb();
    int i = f.a.a.b.a.fR(this.OmU);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void gCg()
  {
    AppMethodBeat.i(2403);
    int i = f.a.a.b.a.fQ(this.OmU);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(f.a.a.b.a.fR(this.OmU)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.OmT.gwb())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.OmT.gwc())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.OmT.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.OmT.zd());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */