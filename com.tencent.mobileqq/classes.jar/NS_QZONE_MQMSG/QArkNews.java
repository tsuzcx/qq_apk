package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QArkNews
  extends JceStruct
{
  public String content = "";
  public String img_url = "";
  public String jump_url = "";
  public String title = "";
  public int type = 0;
  public String type_content = "";
  public long utime = 0L;
  
  public QArkNews() {}
  
  public QArkNews(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5)
  {
    this.type = paramInt;
    this.img_url = paramString1;
    this.content = paramString2;
    this.utime = paramLong;
    this.jump_url = paramString3;
    this.type_content = paramString4;
    this.title = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.img_url = paramJceInputStream.readString(1, true);
    this.content = paramJceInputStream.readString(2, true);
    this.utime = paramJceInputStream.read(this.utime, 3, true);
    this.jump_url = paramJceInputStream.readString(4, true);
    this.type_content = paramJceInputStream.readString(5, true);
    this.title = paramJceInputStream.readString(6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.img_url, 1);
    paramJceOutputStream.write(this.content, 2);
    paramJceOutputStream.write(this.utime, 3);
    paramJceOutputStream.write(this.jump_url, 4);
    paramJceOutputStream.write(this.type_content, 5);
    paramJceOutputStream.write(this.title, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.QArkNews
 * JD-Core Version:    0.7.0.1
 */