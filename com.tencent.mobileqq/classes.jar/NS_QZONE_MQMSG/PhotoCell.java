package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PhotoCell
  extends JceStruct
{
  public String coverUrl = "";
  public int type = 0;
  
  public PhotoCell() {}
  
  public PhotoCell(int paramInt, String paramString)
  {
    this.type = paramInt;
    this.coverUrl = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, false);
    this.coverUrl = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    if (this.coverUrl != null) {
      paramJceOutputStream.write(this.coverUrl, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.PhotoCell
 * JD-Core Version:    0.7.0.1
 */