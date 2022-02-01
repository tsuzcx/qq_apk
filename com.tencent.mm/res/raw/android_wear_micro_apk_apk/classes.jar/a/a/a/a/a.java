package a.a.a.a;

import java.util.LinkedList;

public final class a
{
  private final a.a.a.a.a.b Xe;
  private final a.a.a.b.a.a aqk;
  private int aql = 0;
  
  public a(byte[] paramArrayOfByte, a.a.a.a.a.b paramb)
  {
    this.aqk = a.a.a.b.a.a.q(paramArrayOfByte);
    this.Xe = paramb;
  }
  
  public final LinkedList<byte[]> cE(int paramInt)
  {
    return this.aqk.cE(paramInt);
  }
  
  public final int pg()
  {
    return this.aqk.pp();
  }
  
  public final String ph()
  {
    return this.aqk.readString();
  }
  
  public final boolean pi()
  {
    return this.aqk.pq();
  }
  
  public final long pj()
  {
    return this.aqk.pt();
  }
  
  public final com.tencent.mm.d.b pk()
  {
    return this.aqk.pr();
  }
  
  public final int pl()
  {
    this.aql = this.aqk.po();
    return a.a.a.b.a.cG(this.aql);
  }
  
  public final void pm()
  {
    int i = a.a.a.b.a.cF(this.aql);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(a.a.a.b.a.cG(this.aql)).append(" - ");
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      localStringBuffer.append("float value: ").append(Float.toString(this.aqk.readFloat()));
      return;
    case 1: 
      localStringBuffer.append("double value: ").append(Double.toString(this.aqk.readDouble()));
      return;
    case 2: 
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.aqk.readString());
      return;
    }
    localStringBuffer.append("varint (long, int or boolean) value: ").append(this.aqk.pt());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */