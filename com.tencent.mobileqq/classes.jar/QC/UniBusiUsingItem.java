package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class UniBusiUsingItem
  extends JceStruct
{
  static ArrayList<String> cache_Nick;
  static ArrayList<String> cache_faceurl;
  static UniBusiItemDetail cache_stUniBusiItem = new UniBusiItemDetail();
  static ArrayList<UniBusiUsingUid> cache_stUniBusiUsingUidList;
  public ArrayList<String> Nick = null;
  public ArrayList<String> faceurl = null;
  public int friendcnt = 0;
  public int groupcnt = 0;
  public int isglobal = 0;
  public UniBusiItemDetail stUniBusiItem = null;
  public ArrayList<UniBusiUsingUid> stUniBusiUsingUidList = null;
  
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
    Object localObject = this.stUniBusiItem;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    paramJceOutputStream.write(this.friendcnt, 1);
    paramJceOutputStream.write(this.groupcnt, 2);
    localObject = this.faceurl;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.stUniBusiUsingUidList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    paramJceOutputStream.write(this.isglobal, 5);
    localObject = this.Nick;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiUsingItem
 * JD-Core Version:    0.7.0.1
 */