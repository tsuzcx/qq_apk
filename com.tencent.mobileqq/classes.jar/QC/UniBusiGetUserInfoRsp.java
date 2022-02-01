package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniBusiGetUserInfoRsp
  extends JceStruct
{
  static UniBusiItemDetail cache_globalUsingItem = new UniBusiItemDetail();
  static ArrayList<UniBusiItemDetail> cache_uniBusiHistoryItemList;
  static ArrayList<UniBusiUsingItem> cache_uniBusiUsingItemList = new ArrayList();
  public String errmsg = "";
  public UniBusiItemDetail globalUsingItem;
  public int ret;
  public ArrayList<UniBusiItemDetail> uniBusiHistoryItemList;
  public ArrayList<UniBusiUsingItem> uniBusiUsingItemList;
  
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
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    if (this.globalUsingItem != null) {
      paramJceOutputStream.write(this.globalUsingItem, 2);
    }
    if (this.uniBusiUsingItemList != null) {
      paramJceOutputStream.write(this.uniBusiUsingItemList, 3);
    }
    if (this.uniBusiHistoryItemList != null) {
      paramJceOutputStream.write(this.uniBusiHistoryItemList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiGetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */