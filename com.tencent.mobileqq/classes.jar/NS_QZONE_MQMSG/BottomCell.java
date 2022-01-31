package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class BottomCell
  extends JceStruct
{
  static ArrayList<String> cache_userAvatar = new ArrayList();
  public String content = "";
  public String jumpUrl = "";
  public int total;
  public ArrayList<String> userAvatar;
  
  static
  {
    cache_userAvatar.add("");
  }
  
  public BottomCell() {}
  
  public BottomCell(int paramInt, ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    this.total = paramInt;
    this.userAvatar = paramArrayList;
    this.content = paramString1;
    this.jumpUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.total = paramJceInputStream.read(this.total, 0, false);
    this.userAvatar = ((ArrayList)paramJceInputStream.read(cache_userAvatar, 1, false));
    this.content = paramJceInputStream.readString(2, false);
    this.jumpUrl = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.total, 0);
    if (this.userAvatar != null) {
      paramJceOutputStream.write(this.userAvatar, 1);
    }
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 2);
    }
    if (this.jumpUrl != null) {
      paramJceOutputStream.write(this.jumpUrl, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QZONE_MQMSG.BottomCell
 * JD-Core Version:    0.7.0.1
 */