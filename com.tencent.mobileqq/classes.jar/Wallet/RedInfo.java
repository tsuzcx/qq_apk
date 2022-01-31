package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RedInfo
  extends JceStruct
{
  public int isShow;
  public String path = "";
  public long taskId;
  
  public RedInfo() {}
  
  public RedInfo(String paramString, long paramLong, int paramInt)
  {
    this.path = paramString;
    this.taskId = paramLong;
    this.isShow = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.path = paramJceInputStream.readString(0, false);
    this.taskId = paramJceInputStream.read(this.taskId, 1, false);
    this.isShow = paramJceInputStream.read(this.isShow, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.path != null) {
      paramJceOutputStream.write(this.path, 0);
    }
    paramJceOutputStream.write(this.taskId, 1);
    paramJceOutputStream.write(this.isShow, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.RedInfo
 * JD-Core Version:    0.7.0.1
 */