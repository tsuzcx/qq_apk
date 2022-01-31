package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MessageShow
  extends JceStruct
{
  public boolean bOpen = true;
  
  public MessageShow() {}
  
  public MessageShow(boolean paramBoolean)
  {
    this.bOpen = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bOpen = paramJceInputStream.read(this.bOpen, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bOpen, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.MessageShow
 * JD-Core Version:    0.7.0.1
 */