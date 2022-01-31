package a.a.a.a;

import java.util.LinkedList;

public final class a
{
  private final a.a.a.a.a.b Vj;
  private final a.a.a.b.a.a amI;
  private int amJ = 0;
  
  public a(byte[] paramArrayOfByte, a.a.a.a.a.b paramb)
  {
    this.amI = a.a.a.b.a.a.q(paramArrayOfByte);
    this.Vj = paramb;
  }
  
  public final LinkedList<byte[]> ci(int paramInt)
  {
    return this.amI.ci(paramInt);
  }
  
  public final int ot()
  {
    return this.amI.oC();
  }
  
  public final String ou()
  {
    return this.amI.readString();
  }
  
  public final boolean ov()
  {
    return this.amI.oD();
  }
  
  public final long ow()
  {
    return this.amI.oG();
  }
  
  public final com.tencent.mm.d.b ox()
  {
    return this.amI.oE();
  }
  
  public final int oy()
  {
    this.amJ = this.amI.oB();
    return a.a.a.b.a.ck(this.amJ);
  }
  
  public final void oz()
  {
    int i = a.a.a.b.a.cj(this.amJ);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(a.a.a.b.a.ck(this.amJ)).append(" - ");
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      localStringBuffer.append("float value: ").append(Float.toString(this.amI.readFloat()));
      return;
    case 1: 
      localStringBuffer.append("double value: ").append(Double.toString(this.amI.readDouble()));
      return;
    case 2: 
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.amI.readString());
      return;
    }
    localStringBuffer.append("varint (long, int or boolean) value: ").append(this.amI.oG());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */