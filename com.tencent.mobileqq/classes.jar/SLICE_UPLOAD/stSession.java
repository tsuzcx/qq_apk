package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSession
  extends JceStruct
{
  public int dumpBussinessID = 0;
  public long process_ip = 0L;
  public short process_port = 0;
  public String sid = "";
  
  public stSession() {}
  
  public stSession(String paramString, long paramLong, short paramShort, int paramInt)
  {
    this.sid = paramString;
    this.process_ip = paramLong;
    this.process_port = paramShort;
    this.dumpBussinessID = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sid = paramJceInputStream.readString(1, true);
    this.process_ip = paramJceInputStream.read(this.process_ip, 2, true);
    this.process_port = paramJceInputStream.read(this.process_port, 3, true);
    this.dumpBussinessID = paramJceInputStream.read(this.dumpBussinessID, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sid, 1);
    paramJceOutputStream.write(this.process_ip, 2);
    paramJceOutputStream.write(this.process_port, 3);
    paramJceOutputStream.write(this.dumpBussinessID, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SLICE_UPLOAD.stSession
 * JD-Core Version:    0.7.0.1
 */