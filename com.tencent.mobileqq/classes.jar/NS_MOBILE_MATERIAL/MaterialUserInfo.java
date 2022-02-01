package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class MaterialUserInfo
  extends JceStruct
{
  static int cache_iSwitchState = 0;
  static MaterialUserItem cache_stCurrentItem = new MaterialUserItem();
  static ArrayList<MaterialUserItem> cache_vecHistoryItem;
  static ArrayList<MaterialUserItem> cache_vecUserItem = new ArrayList();
  public int iSwitchState = 0;
  public MaterialUserItem stCurrentItem = null;
  public ArrayList<MaterialUserItem> vecHistoryItem = null;
  public ArrayList<MaterialUserItem> vecUserItem = null;
  
  static
  {
    MaterialUserItem localMaterialUserItem = new MaterialUserItem();
    cache_vecUserItem.add(localMaterialUserItem);
    cache_vecHistoryItem = new ArrayList();
    localMaterialUserItem = new MaterialUserItem();
    cache_vecHistoryItem.add(localMaterialUserItem);
  }
  
  public MaterialUserInfo() {}
  
  public MaterialUserInfo(ArrayList<MaterialUserItem> paramArrayList1, ArrayList<MaterialUserItem> paramArrayList2, int paramInt, MaterialUserItem paramMaterialUserItem)
  {
    this.vecUserItem = paramArrayList1;
    this.vecHistoryItem = paramArrayList2;
    this.iSwitchState = paramInt;
    this.stCurrentItem = paramMaterialUserItem;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecUserItem = ((ArrayList)paramJceInputStream.read(cache_vecUserItem, 0, false));
    this.vecHistoryItem = ((ArrayList)paramJceInputStream.read(cache_vecHistoryItem, 1, false));
    this.iSwitchState = paramJceInputStream.read(this.iSwitchState, 2, false);
    this.stCurrentItem = ((MaterialUserItem)paramJceInputStream.read(cache_stCurrentItem, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecUserItem != null) {
      paramJceOutputStream.write(this.vecUserItem, 0);
    }
    if (this.vecHistoryItem != null) {
      paramJceOutputStream.write(this.vecHistoryItem, 1);
    }
    paramJceOutputStream.write(this.iSwitchState, 2);
    if (this.stCurrentItem != null) {
      paramJceOutputStream.write(this.stCurrentItem, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialUserInfo
 * JD-Core Version:    0.7.0.1
 */