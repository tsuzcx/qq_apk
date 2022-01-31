package SLICE_UPLOAD;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stSession
  extends JceStruct
{
  public long process_ip = 0L;
  public short process_port = 0;
  public String sid = "";
  
  public stSession() {}
  
  public stSession(String paramString, long paramLong, short paramShort)
  {
    this.sid = paramString;
    this.process_ip = paramLong;
    this.process_port = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sid = paramJceInputStream.readString(1, true);
    this.process_ip = paramJceInputStream.read(this.process_ip, 2, true);
    this.process_port = paramJceInputStream.read(this.process_port, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sid, 1);
    paramJceOutputStream.write(this.process_ip, 2);
    paramJceOutputStream.write(this.process_port, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     SLICE_UPLOAD.stSession
 * JD-Core Version:    0.7.0.1
 */