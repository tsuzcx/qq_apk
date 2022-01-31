package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FileId
  extends JceStruct
{
  public String sDescMD5 = "";
  public String sFileMD5 = "";
  
  public FileId() {}
  
  public FileId(String paramString1, String paramString2)
  {
    this.sFileMD5 = paramString1;
    this.sDescMD5 = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sFileMD5 = paramJceInputStream.readString(0, true);
    this.sDescMD5 = paramJceInputStream.readString(1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.sFileMD5, 0);
    paramJceOutputStream.write(this.sDescMD5, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.FileId
 * JD-Core Version:    0.7.0.1
 */