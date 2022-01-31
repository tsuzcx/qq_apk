package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileCommitReq
  extends JceStruct
{
  static byte[] cache_biz_req = (byte[])new byte[1];
  public String appid = "";
  public byte[] biz_req = null;
  public String session = "";
  public String uin = "";
  
  static
  {
    ((byte[])cache_biz_req)[0] = 0;
  }
  
  public FileCommitReq() {}
  
  public FileCommitReq(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    this.uin = paramString1;
    this.session = paramString2;
    this.biz_req = paramArrayOfByte;
    this.appid = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, true);
    this.session = paramJceInputStream.readString(1, true);
    this.biz_req = ((byte[])paramJceInputStream.read(cache_biz_req, 2, false));
    this.appid = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.session, 1);
    if (this.biz_req != null) {
      paramJceOutputStream.write(this.biz_req, 2);
    }
    if (this.appid != null) {
      paramJceOutputStream.write(this.appid, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileCommitReq
 * JD-Core Version:    0.7.0.1
 */