package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UniBusiGetUserInfoRsp
  extends JceStruct
{
  static UniBusiItemDetail cache_globalUsingItem = new UniBusiItemDetail();
  static ArrayList<UniBusiItemDetail> cache_uniBusiHistoryItemList;
  static ArrayList<UniBusiUsingItem> cache_uniBusiUsingItemList = new ArrayList();
  public String errmsg = "";
  public UniBusiItemDetail globalUsingItem = null;
  public int ret = 0;
  public ArrayList<UniBusiItemDetail> uniBusiHistoryItemList = null;
  public ArrayList<UniBusiUsingItem> uniBusiUsingItemList = null;
  
  static
  {
    Object localObject = new UniBusiUsingItem();
    cache_uniBusiUsingItemList.add(localObject);
    cache_uniBusiHistoryItemList = new ArrayList();
    localObject = new UniBusiItemDetail();
    cache_uniBusiHistoryItemList.add(localObject);
  }
  
  public UniBusiGetUserInfoRsp() {}
  
  public UniBusiGetUserInfoRsp(int paramInt, String paramString, UniBusiItemDetail paramUniBusiItemDetail, ArrayList<UniBusiUsingItem> paramArrayList, ArrayList<UniBusiItemDetail> paramArrayList1)
  {
    this.ret = paramInt;
    this.errmsg = paramString;
    this.globalUsingItem = paramUniBusiItemDetail;
    this.uniBusiUsingItemList = paramArrayList;
    this.uniBusiHistoryItemList = paramArrayList1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.globalUsingItem = ((UniBusiItemDetail)paramJceInputStream.read(cache_globalUsingItem, 2, false));
    this.uniBusiUsingItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusiUsingItemList, 3, false));
    this.uniBusiHistoryItemList = ((ArrayList)paramJceInputStream.read(cache_uniBusiHistoryItemList, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.errmsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.globalUsingItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.uniBusiUsingItemList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.uniBusiHistoryItemList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiGetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */