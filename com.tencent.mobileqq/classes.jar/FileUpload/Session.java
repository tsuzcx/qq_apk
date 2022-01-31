package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Session
  extends JceStruct
{
  public String process_ip = "";
  public int process_port = 0;
  
  public Session() {}
  
  public Session(String paramString, int paramInt)
  {
    this.process_ip = paramString;
    this.process_port = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.process_ip = paramJceInputStream.readString(0, true);
    this.process_port = paramJceInputStream.read(this.process_port, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.process_ip, 0);
    paramJceOutputStream.write(this.process_port, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.Session
 * JD-Core Version:    0.7.0.1
 */