package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_video_shuoshuo_upload_finish_rsp
  extends JceStruct
{
  public int iRet;
  public String strErrMsg = "";
  
  public mobile_video_shuoshuo_upload_finish_rsp() {}
  
  public mobile_video_shuoshuo_upload_finish_rsp(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.strErrMsg = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, false);
    this.strErrMsg = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    String str = this.strErrMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_video_shuoshuo_upload_finish_rsp
 * JD-Core Version:    0.7.0.1
 */