package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MenumItem
  extends JceStruct
{
  public String icon = "";
  public int item_id = 0;
  public String jumpurl = "";
  public String title = "";
  public int user_group = 0;
  
  public MenumItem() {}
  
  public MenumItem(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    this.item_id = paramInt1;
    this.icon = paramString1;
    this.title = paramString2;
    this.jumpurl = paramString3;
    this.user_group = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.item_id = paramJceInputStream.read(this.item_id, 0, false);
    this.icon = paramJceInputStream.readString(1, false);
    this.title = paramJceInputStream.readString(2, false);
    this.jumpurl = paramJceInputStream.readString(4, false);
    this.user_group = paramJceInputStream.read(this.user_group, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.item_id, 0);
    String str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.title;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.jumpurl;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    paramJceOutputStream.write(this.user_group, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MQQ.MenumItem
 * JD-Core Version:    0.7.0.1
 */