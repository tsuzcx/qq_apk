package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserOnlineReq
  extends JceStruct
{
  public String anchorId = "";
  public int relativeTime = 0;
  public String roomId = "";
  public int type = 0;
  public String uid = "";
  
  public UserOnlineReq() {}
  
  public UserOnlineReq(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    this.uid = paramString1;
    this.roomId = paramString2;
    this.type = paramInt1;
    this.relativeTime = paramInt2;
    this.anchorId = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, false);
    this.roomId = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.relativeTime = paramJceInputStream.read(this.relativeTime, 3, false);
    this.anchorId = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.roomId;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.type, 2);
    paramJceOutputStream.write(this.relativeTime, 3);
    str = this.anchorId;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.UserOnlineReq
 * JD-Core Version:    0.7.0.1
 */