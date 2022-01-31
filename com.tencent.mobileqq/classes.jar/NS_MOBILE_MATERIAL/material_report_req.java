package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_report_req
  extends JceStruct
{
  public int iOperType;
  public int iSource;
  public long lUin;
  
  public material_report_req() {}
  
  public material_report_req(long paramLong, int paramInt1, int paramInt2)
  {
    this.lUin = paramLong;
    this.iOperType = paramInt1;
    this.iSource = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iOperType = paramJceInputStream.read(this.iOperType, 1, true);
    this.iSource = paramJceInputStream.read(this.iSource, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iOperType, 1);
    paramJceOutputStream.write(this.iSource, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_report_req
 * JD-Core Version:    0.7.0.1
 */