package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReportRecommendedPhotosRsp
  extends JceStruct
{
  public String msg = "";
  public int ret;
  
  public ReportRecommendedPhotosRsp() {}
  
  public ReportRecommendedPhotosRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.msg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.ReportRecommendedPhotosRsp
 * JD-Core Version:    0.7.0.1
 */