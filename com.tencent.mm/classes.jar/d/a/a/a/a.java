package d.a.a.a;

import java.util.LinkedList;

public final class a
{
  private final d.a.a.a.a.b unknownTagHandler;
  public final d.a.a.b.a.a xpH;
  public int xpI = 0;
  
  public a(byte[] paramArrayOfByte, d.a.a.a.a.b paramb)
  {
    this.xpH = new d.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
  }
  
  public final LinkedList<byte[]> KN(int paramInt)
  {
    return this.xpH.KN(paramInt);
  }
  
  public final int cUo()
  {
    return this.xpH.oD();
  }
  
  public final LinkedList<Integer> cUp()
  {
    d.a.a.b.a.a locala = this.xpH;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (locala.aUB >= locala.bufferSize) {
        return localLinkedList;
      }
      localLinkedList.add(Integer.valueOf(locala.oD()));
    }
  }
  
  public final String cUq()
  {
    return this.xpH.readString();
  }
  
  public final boolean cUr()
  {
    return this.xpH.oD() != 0;
  }
  
  public final com.tencent.mm.bv.b cUs()
  {
    d.a.a.b.a.a locala = this.xpH;
    int i = locala.oD();
    if ((i < locala.bufferSize - locala.aUB) && (i > 0))
    {
      com.tencent.mm.bv.b localb = com.tencent.mm.bv.b.v(locala.buffer, locala.aUB, i);
      locala.aUB = (i + locala.aUB);
      return localb;
    }
    return com.tencent.mm.bv.b.bk(locala.dM(i));
  }
  
  public final void cUt()
  {
    int i = d.a.a.b.a.dT(this.xpI);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(d.a.a.b.a.dU(this.xpI)).append(" - ");
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      localStringBuffer.append("float value: ").append(Float.toString(this.xpH.readFloat()));
      return;
    case 1: 
      localStringBuffer.append("double value: ").append(Double.toString(this.xpH.readDouble()));
      return;
    case 2: 
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.xpH.readString());
      return;
    }
    localStringBuffer.append("varint (long, int or boolean) value: ").append(this.xpH.oE());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */