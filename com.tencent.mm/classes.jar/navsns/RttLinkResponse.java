package navsns;

import com.tencent.tencentmap.mapsdk.a.nk;
import com.tencent.tencentmap.mapsdk.a.nl;
import com.tencent.tencentmap.mapsdk.a.nm;

public final class RttLinkResponse
  extends nm
{
  static byte[] a;
  public byte[] result = null;
  
  static
  {
    byte[] arrayOfByte = (byte[])new byte[1];
    a = arrayOfByte;
    ((byte[])arrayOfByte)[0] = 0;
  }
  
  public RttLinkResponse() {}
  
  public RttLinkResponse(byte[] paramArrayOfByte)
  {
    this.result = paramArrayOfByte;
  }
  
  public final void readFrom(nk paramnk)
  {
    this.result = ((byte[])paramnk.a(a, 0, true));
  }
  
  public final void writeTo(nl paramnl)
  {
    paramnl.a(this.result, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     navsns.RttLinkResponse
 * JD-Core Version:    0.7.0.1
 */