package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileStorageServerListInfo
  extends JceStruct
{
  public int iPort = 0;
  public String sIP = "";
  
  public FileStorageServerListInfo() {}
  
  public FileStorageServerListInfo(String paramString, int paramInt)
  {
    this.sIP = paramString;
    this.iPort = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sIP = paramJceInputStream.readString(1, true);
    this.iPort = paramJceInputStream.read(this.iPort, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sIP, 1);
    paramJceOutputStream.write(this.iPort, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ConfigPush.FileStorageServerListInfo
 * JD-Core Version:    0.7.0.1
 */