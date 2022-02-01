package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DumpBussinessReq
  extends JceStruct
{
  static byte[] cache_biz_req = (byte[])new byte[1];
  public String IMEI = "";
  public byte[] biz_req = null;
  
  static
  {
    ((byte[])cache_biz_req)[0] = 0;
  }
  
  public DumpBussinessReq() {}
  
  public DumpBussinessReq(byte[] paramArrayOfByte, String paramString)
  {
    this.biz_req = paramArrayOfByte;
    this.IMEI = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.biz_req = ((byte[])paramJceInputStream.read(cache_biz_req, 0, false));
    this.IMEI = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.biz_req;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 0);
    }
    localObject = this.IMEI;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SLICE_UPLOAD.DumpBussinessReq
 * JD-Core Version:    0.7.0.1
 */