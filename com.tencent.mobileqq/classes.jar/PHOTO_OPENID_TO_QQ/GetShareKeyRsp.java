package PHOTO_OPENID_TO_QQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetShareKeyRsp
  extends JceStruct
{
  public int ret;
  public String share_key = "";
  
  public GetShareKeyRsp() {}
  
  public GetShareKeyRsp(int paramInt, String paramString)
  {
    this.ret = paramInt;
    this.share_key = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.share_key = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.share_key, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     PHOTO_OPENID_TO_QQ.GetShareKeyRsp
 * JD-Core Version:    0.7.0.1
 */