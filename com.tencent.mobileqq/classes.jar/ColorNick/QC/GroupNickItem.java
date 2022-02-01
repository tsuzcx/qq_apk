package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GroupNickItem
  extends JceStruct
{
  public int itemid = 0;
  public String url = "";
  
  public GroupNickItem() {}
  
  public GroupNickItem(int paramInt, String paramString)
  {
    this.itemid = paramInt;
    this.url = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.itemid = paramJceInputStream.read(this.itemid, 0, false);
    this.url = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.itemid, 0);
    String str = this.url;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ColorNick.QC.GroupNickItem
 * JD-Core Version:    0.7.0.1
 */