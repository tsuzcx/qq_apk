package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FaceRsp
  extends JceStruct
{
  static CommonRsp cache_stRet = new CommonRsp();
  public int authRet = 0;
  public CommonRsp stRet = null;
  public String url = "";
  
  public FaceRsp() {}
  
  public FaceRsp(CommonRsp paramCommonRsp, int paramInt, String paramString)
  {
    this.stRet = paramCommonRsp;
    this.authRet = paramInt;
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stRet = ((CommonRsp)paramJceInputStream.read(cache_stRet, 0, false));
    this.authRet = paramJceInputStream.read(this.authRet, 1, false);
    this.url = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stRet;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.authRet, 1);
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.FaceRsp
 * JD-Core Version:    0.7.0.1
 */