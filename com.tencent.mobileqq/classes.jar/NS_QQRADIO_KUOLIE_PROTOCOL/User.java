package NS_QQRADIO_KUOLIE_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class User
  extends JceStruct
{
  public String nickname = "";
  public String recomReason = "";
  public String uid = "";
  
  public User() {}
  
  public User(String paramString1, String paramString2, String paramString3)
  {
    this.uid = paramString1;
    this.nickname = paramString2;
    this.recomReason = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uid = paramJceInputStream.readString(0, false);
    this.nickname = paramJceInputStream.readString(1, false);
    this.recomReason = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uid;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.nickname;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.recomReason;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQRADIO_KUOLIE_PROTOCOL.User
 * JD-Core Version:    0.7.0.1
 */