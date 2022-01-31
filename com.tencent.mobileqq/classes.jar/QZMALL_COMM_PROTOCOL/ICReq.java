package QZMALL_COMM_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ICReq
  extends JceStruct
{
  public String device_info = "";
  public String qua = "";
  public int scence;
  public long uObjUin;
  public long uUin;
  
  public ICReq() {}
  
  public ICReq(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2)
  {
    this.uUin = paramLong1;
    this.uObjUin = paramLong2;
    this.scence = paramInt;
    this.device_info = paramString1;
    this.qua = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uUin = paramJceInputStream.read(this.uUin, 0, false);
    this.uObjUin = paramJceInputStream.read(this.uObjUin, 1, false);
    this.scence = paramJceInputStream.read(this.scence, 2, false);
    this.device_info = paramJceInputStream.readString(3, false);
    this.qua = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uUin, 0);
    paramJceOutputStream.write(this.uObjUin, 1);
    paramJceOutputStream.write(this.scence, 2);
    if (this.device_info != null) {
      paramJceOutputStream.write(this.device_info, 3);
    }
    if (this.qua != null) {
      paramJceOutputStream.write(this.qua, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QZMALL_COMM_PROTOCOL.ICReq
 * JD-Core Version:    0.7.0.1
 */