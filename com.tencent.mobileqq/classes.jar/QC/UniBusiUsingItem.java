package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UniBusiUsingItem
  extends JceStruct
{
  static ArrayList<String> cache_Nick;
  static ArrayList<String> cache_faceurl;
  static UniBusiItemDetail cache_stUniBusiItem = new UniBusiItemDetail();
  static ArrayList<UniBusiUsingUid> cache_stUniBusiUsingUidList;
  public ArrayList<String> Nick;
  public ArrayList<String> faceurl;
  public int friendcnt;
  public int groupcnt;
  public int isglobal;
  public UniBusiItemDetail stUniBusiItem;
  public ArrayList<UniBusiUsingUid> stUniBusiUsingUidList;
  
  static
  {
    cache_faceurl = new ArrayList();
    cache_faceurl.add("");
    cache_stUniBusiUsingUidList = new ArrayList();
    UniBusiUsingUid localUniBusiUsingUid = new UniBusiUsingUid();
    cache_stUniBusiUsingUidList.add(localUniBusiUsingUid);
    cache_Nick = new ArrayList();
    cache_Nick.add("");
  }
  
  public UniBusiUsingItem() {}
  
  public UniBusiUsingItem(UniBusiItemDetail paramUniBusiItemDetail, int paramInt1, int paramInt2, ArrayList<String> paramArrayList1, ArrayList<UniBusiUsingUid> paramArrayList, int paramInt3, ArrayList<String> paramArrayList2)
  {
    this.stUniBusiItem = paramUniBusiItemDetail;
    this.friendcnt = paramInt1;
    this.groupcnt = paramInt2;
    this.faceurl = paramArrayList1;
    this.stUniBusiUsingUidList = paramArrayList;
    this.isglobal = paramInt3;
    this.Nick = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stUniBusiItem = ((UniBusiItemDetail)paramJceInputStream.read(cache_stUniBusiItem, 0, false));
    this.friendcnt = paramJceInputStream.read(this.friendcnt, 1, false);
    this.groupcnt = paramJceInputStream.read(this.groupcnt, 2, false);
    this.faceurl = ((ArrayList)paramJceInputStream.read(cache_faceurl, 3, false));
    this.stUniBusiUsingUidList = ((ArrayList)paramJceInputStream.read(cache_stUniBusiUsingUidList, 4, false));
    this.isglobal = paramJceInputStream.read(this.isglobal, 5, false);
    this.Nick = ((ArrayList)paramJceInputStream.read(cache_Nick, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stUniBusiItem != null) {
      paramJceOutputStream.write(this.stUniBusiItem, 0);
    }
    paramJceOutputStream.write(this.friendcnt, 1);
    paramJceOutputStream.write(this.groupcnt, 2);
    if (this.faceurl != null) {
      paramJceOutputStream.write(this.faceurl, 3);
    }
    if (this.stUniBusiUsingUidList != null) {
      paramJceOutputStream.write(this.stUniBusiUsingUidList, 4);
    }
    paramJceOutputStream.write(this.isglobal, 5);
    if (this.Nick != null) {
      paramJceOutputStream.write(this.Nick, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.UniBusiUsingItem
 * JD-Core Version:    0.7.0.1
 */