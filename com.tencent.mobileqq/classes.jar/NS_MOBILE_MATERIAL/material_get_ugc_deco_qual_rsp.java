package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_get_ugc_deco_qual_rsp
  extends JceStruct
{
  static byte[] cache_vecBuf = (byte[])new byte[1];
  public int iCode = 0;
  public byte[] vecBuf = null;
  
  static
  {
    ((byte[])cache_vecBuf)[0] = 0;
  }
  
  public material_get_ugc_deco_qual_rsp() {}
  
  public material_get_ugc_deco_qual_rsp(int paramInt, byte[] paramArrayOfByte)
  {
    this.iCode = paramInt;
    this.vecBuf = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCode = paramJceInputStream.read(this.iCode, 0, false);
    this.vecBuf = ((byte[])paramJceInputStream.read(cache_vecBuf, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCode, 0);
    if (this.vecBuf != null) {
      paramJceOutputStream.write(this.vecBuf, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_get_ugc_deco_qual_rsp
 * JD-Core Version:    0.7.0.1
 */