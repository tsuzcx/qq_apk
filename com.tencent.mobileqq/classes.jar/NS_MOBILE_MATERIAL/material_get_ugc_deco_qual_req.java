package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_get_ugc_deco_qual_req
  extends JceStruct
{
  static int cache_eType = 0;
  static byte[] cache_vecBuf = (byte[])new byte[1];
  public int eType;
  public long lUin;
  public byte[] vecBuf;
  
  static
  {
    ((byte[])cache_vecBuf)[0] = 0;
  }
  
  public material_get_ugc_deco_qual_req() {}
  
  public material_get_ugc_deco_qual_req(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.lUin = paramLong;
    this.eType = paramInt;
    this.vecBuf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, false);
    this.eType = paramJceInputStream.read(this.eType, 1, false);
    this.vecBuf = ((byte[])paramJceInputStream.read(cache_vecBuf, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.eType, 1);
    if (this.vecBuf != null) {
      paramJceOutputStream.write(this.vecBuf, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_get_ugc_deco_qual_req
 * JD-Core Version:    0.7.0.1
 */