package f.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.a.a.b;
import java.util.LinkedList;

public final class a
{
  public final f.a.a.b.a.a NPN;
  private int NPO;
  private final b unknownTagHandler;
  
  public a(byte[] paramArrayOfByte, b paramb)
  {
    AppMethodBeat.i(2399);
    this.NPO = 0;
    this.NPN = new f.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
    AppMethodBeat.o(2399);
  }
  
  public final LinkedList<byte[]> alQ(int paramInt)
  {
    AppMethodBeat.i(2404);
    LinkedList localLinkedList = this.NPN.alQ(paramInt);
    AppMethodBeat.o(2404);
    return localLinkedList;
  }
  
  public final int gxA()
  {
    AppMethodBeat.i(2400);
    int i = this.NPN.zc();
    AppMethodBeat.o(2400);
    return i;
  }
  
  public final String gxB()
  {
    AppMethodBeat.i(221593);
    String str = this.NPN.readString();
    AppMethodBeat.o(221593);
    return str;
  }
  
  public final boolean gxC()
  {
    AppMethodBeat.i(221594);
    boolean bool = this.NPN.grw();
    AppMethodBeat.o(221594);
    return bool;
  }
  
  public final int gxD()
  {
    AppMethodBeat.i(168735);
    this.NPO = this.NPN.zb();
    int i = f.a.a.b.a.fR(this.NPO);
    AppMethodBeat.o(168735);
    return i;
  }
  
  public final void gxE()
  {
    AppMethodBeat.i(2403);
    int i = f.a.a.b.a.fQ(this.NPO);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(f.a.a.b.a.fR(this.NPO)).append(" - ");
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("float value: ").append(Float.toString(Float.intBitsToFloat(this.NPN.grz())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("double value: ").append(Double.toString(Double.longBitsToDouble(this.NPN.grA())));
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.NPN.readString());
      AppMethodBeat.o(2403);
      return;
      localStringBuffer.append("varint (long, int or boolean) value: ").append(this.NPN.zd());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     f.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */