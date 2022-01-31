package ColorNick.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class readItemInfoRsp
  extends JceStruct
{
  static ArrayList<GroupNickEmoji> cache_emojilist = new ArrayList();
  static ArrayList<GroupNickItem> cache_itemlist;
  public ArrayList<GroupNickEmoji> emojilist;
  public int index;
  public ArrayList<GroupNickItem> itemlist;
  public int left;
  public String urlprefix = "";
  
  static
  {
    Object localObject = new GroupNickEmoji();
    cache_emojilist.add(localObject);
    cache_itemlist = new ArrayList();
    localObject = new GroupNickItem();
    cache_itemlist.add(localObject);
  }
  
  public readItemInfoRsp() {}
  
  public readItemInfoRsp(ArrayList<GroupNickEmoji> paramArrayList, ArrayList<GroupNickItem> paramArrayList1, int paramInt1, int paramInt2, String paramString)
  {
    this.emojilist = paramArrayList;
    this.itemlist = paramArrayList1;
    this.index = paramInt1;
    this.left = paramInt2;
    this.urlprefix = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.emojilist = ((ArrayList)paramJceInputStream.read(cache_emojilist, 0, false));
    this.itemlist = ((ArrayList)paramJceInputStream.read(cache_itemlist, 1, false));
    this.index = paramJceInputStream.read(this.index, 2, false);
    this.left = paramJceInputStream.read(this.left, 3, false);
    this.urlprefix = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.emojilist != null) {
      paramJceOutputStream.write(this.emojilist, 0);
    }
    if (this.itemlist != null) {
      paramJceOutputStream.write(this.itemlist, 1);
    }
    paramJceOutputStream.write(this.index, 2);
    paramJceOutputStream.write(this.left, 3);
    if (this.urlprefix != null) {
      paramJceOutputStream.write(this.urlprefix, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ColorNick.QC.readItemInfoRsp
 * JD-Core Version:    0.7.0.1
 */