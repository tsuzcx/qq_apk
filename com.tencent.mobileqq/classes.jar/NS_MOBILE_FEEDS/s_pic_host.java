package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_pic_host
  extends JceStruct
{
  public String nick = "";
  public long uin;
  
  public s_pic_host() {}
  
  public s_pic_host(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_pic_host
 * JD-Core Version:    0.7.0.1
 */