package ProfileLogic.QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class readUserInfoRsp
  extends JceStruct
{
  static ArrayList<profileItem> cache_itemlist = new ArrayList();
  public int flag = 0;
  public int index = 0;
  public int itemid = 0;
  public ArrayList<profileItem> itemlist = null;
  public int listend = 0;
  public String urlprefix = "";
  
  static
  {
    profileItem localprofileItem = new profileItem();
    cache_itemlist.add(localprofileItem);
  }
  
  public readUserInfoRsp() {}
  
  public readUserInfoRsp(ArrayList<profileItem> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    this.itemlist = paramArrayList;
    this.index = paramInt1;
    this.listend = paramInt2;
    this.urlprefix = paramString;
    this.itemid = paramInt3;
    this.flag = paramInt4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.itemlist = ((ArrayList)paramJceInputStream.read(cache_itemlist, 0, false));
    this.index = paramJceInputStream.read(this.index, 1, false);
    this.listend = paramJceInputStream.read(this.listend, 2, false);
    this.urlprefix = paramJceInputStream.readString(3, false);
    this.itemid = paramJceInputStream.read(this.itemid, 4, false);
    this.flag = paramJceInputStream.read(this.flag, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.itemlist != null) {
      paramJceOutputStream.write(this.itemlist, 0);
    }
    paramJceOutputStream.write(this.index, 1);
    paramJceOutputStream.write(this.listend, 2);
    if (this.urlprefix != null) {
      paramJceOutputStream.write(this.urlprefix, 3);
    }
    paramJceOutputStream.write(this.itemid, 4);
    paramJceOutputStream.write(this.flag, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ProfileLogic.QC.readUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */