package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class material_report_req
  extends JceStruct
{
  public int iBannerType = 0;
  public int iOperType = 0;
  public int iSource = 0;
  public long lUin = 0L;
  public String strQbossTraceinfo = "";
  
  public material_report_req() {}
  
  public material_report_req(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.lUin = paramLong;
    this.iOperType = paramInt1;
    this.iSource = paramInt2;
    this.iBannerType = paramInt3;
    this.strQbossTraceinfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iOperType = paramJceInputStream.read(this.iOperType, 1, true);
    this.iSource = paramJceInputStream.read(this.iSource, 2, false);
    this.iBannerType = paramJceInputStream.read(this.iBannerType, 3, false);
    this.strQbossTraceinfo = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iOperType, 1);
    paramJceOutputStream.write(this.iSource, 2);
    paramJceOutputStream.write(this.iBannerType, 3);
    if (this.strQbossTraceinfo != null) {
      paramJceOutputStream.write(this.strQbossTraceinfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_report_req
 * JD-Core Version:    0.7.0.1
 */