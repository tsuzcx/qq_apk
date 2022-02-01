package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class BottomCell
  extends JceStruct
{
  static ArrayList<String> cache_userAvatar = new ArrayList();
  public String content = "";
  public String jumpUrl = "";
  public int total = 0;
  public ArrayList<String> userAvatar = null;
  
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
    Object localObject = this.userAvatar;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    localObject = this.content;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.jumpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QZONE_MQMSG.BottomCell
 * JD-Core Version:    0.7.0.1
 */