package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cancelPacket
  extends JceStruct
{
  static ArrayList<FileId> cache_fileIds = new ArrayList();
  public ArrayList<FileId> fileIds = null;
  
  static
  {
    FileId localFileId = new FileId();
    cache_fileIds.add(localFileId);
  }
  
  public cancelPacket() {}
  
  public cancelPacket(ArrayList<FileId> paramArrayList)
  {
    this.fileIds = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.fileIds = ((ArrayList)paramJceInputStream.read(cache_fileIds, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.fileIds, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.cancelPacket
 * JD-Core Version:    0.7.0.1
 */