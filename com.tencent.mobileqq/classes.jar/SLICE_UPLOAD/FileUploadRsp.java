package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileUploadRsp
  extends JceStruct
{
  static byte[] cache_biz_rsp;
  static stResult cache_result = new stResult();
  public byte[] biz_rsp = null;
  public long offset = 0L;
  public stResult result = null;
  public String session = "";
  
  static
  {
    cache_biz_rsp = (byte[])new byte[1];
    ((byte[])cache_biz_rsp)[0] = 0;
  }
  
  public FileUploadRsp() {}
  
  public FileUploadRsp(stResult paramstResult, String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.result = paramstResult;
    this.session = paramString;
    this.offset = paramLong;
    this.biz_rsp = paramArrayOfByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = ((stResult)paramJceInputStream.read(cache_result, 1, true));
    this.session = paramJceInputStream.readString(2, false);
    this.offset = paramJceInputStream.read(this.offset, 3, false);
    this.biz_rsp = ((byte[])paramJceInputStream.read(cache_biz_rsp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 1);
    if (this.session != null) {
      paramJceOutputStream.write(this.session, 2);
    }
    paramJceOutputStream.write(this.offset, 3);
    if (this.biz_rsp != null) {
      paramJceOutputStream.write(this.biz_rsp, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.FileUploadRsp
 * JD-Core Version:    0.7.0.1
 */