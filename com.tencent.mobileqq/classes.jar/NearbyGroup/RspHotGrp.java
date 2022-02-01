package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RspHotGrp
  extends JceStruct
{
  static byte[] cache_strRspHotGrp;
  public short shShowPos = 0;
  public byte[] strRspHotGrp = null;
  
  public RspHotGrp() {}
  
  public RspHotGrp(byte[] paramArrayOfByte, short paramShort)
  {
    this.strRspHotGrp = paramArrayOfByte;
    this.shShowPos = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strRspHotGrp == null)
    {
      cache_strRspHotGrp = (byte[])new byte[1];
      ((byte[])cache_strRspHotGrp)[0] = 0;
    }
    this.strRspHotGrp = ((byte[])paramJceInputStream.read(cache_strRspHotGrp, 0, true));
    this.shShowPos = paramJceInputStream.read(this.shShowPos, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strRspHotGrp, 0);
    paramJceOutputStream.write(this.shShowPos, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NearbyGroup.RspHotGrp
 * JD-Core Version:    0.7.0.1
 */