package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class cell_live
  extends JceStruct
{
  static Map<String, String> cache_extendInfo = new HashMap();
  static Map<Integer, String> cache_mapExtendInfo;
  static ArrayList<SpecialMsg> cache_vctCommentList;
  static ArrayList<liveUser> cache_vctLiveUserList;
  public String exception_tips = "";
  public Map<String, String> extendInfo = null;
  public int giftNum = 0;
  public int likeNum = 0;
  public int liveType = 0;
  public int livetime = 0;
  public Map<Integer, String> mapExtendInfo = null;
  public String roomid = "";
  public int roomstat = 0;
  public String tipsMessage = "";
  public int usercount = 0;
  public ArrayList<SpecialMsg> vctCommentList = null;
  public ArrayList<liveUser> vctLiveUserList = null;
  
  static
  {
    cache_extendInfo.put("", "");
    cache_vctCommentList = new ArrayList();
    Object localObject = new SpecialMsg();
    cache_vctCommentList.add(localObject);
    cache_vctLiveUserList = new ArrayList();
    localObject = new liveUser();
    cache_vctLiveUserList.add(localObject);
    cache_mapExtendInfo = new HashMap();
    cache_mapExtendInfo.put(Integer.valueOf(0), "");
  }
  
  public cell_live() {}
  
  public cell_live(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, Map<String, String> paramMap, String paramString3, ArrayList<SpecialMsg> paramArrayList, ArrayList<liveUser> paramArrayList1, int paramInt6, Map<Integer, String> paramMap1)
  {
    this.roomid = paramString1;
    this.roomstat = paramInt1;
    this.usercount = paramInt2;
    this.livetime = paramInt3;
    this.giftNum = paramInt4;
    this.likeNum = paramInt5;
    this.tipsMessage = paramString2;
    this.extendInfo = paramMap;
    this.exception_tips = paramString3;
    this.vctCommentList = paramArrayList;
    this.vctLiveUserList = paramArrayList1;
    this.liveType = paramInt6;
    this.mapExtendInfo = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.roomid = paramJceInputStream.readString(0, false);
    this.roomstat = paramJceInputStream.read(this.roomstat, 1, false);
    this.usercount = paramJceInputStream.read(this.usercount, 2, false);
    this.livetime = paramJceInputStream.read(this.livetime, 3, false);
    this.giftNum = paramJceInputStream.read(this.giftNum, 5, false);
    this.likeNum = paramJceInputStream.read(this.likeNum, 6, false);
    this.tipsMessage = paramJceInputStream.readString(7, false);
    this.extendInfo = ((Map)paramJceInputStream.read(cache_extendInfo, 8, false));
    this.exception_tips = paramJceInputStream.readString(9, false);
    this.vctCommentList = ((ArrayList)paramJceInputStream.read(cache_vctCommentList, 10, false));
    this.vctLiveUserList = ((ArrayList)paramJceInputStream.read(cache_vctLiveUserList, 11, false));
    this.liveType = paramJceInputStream.read(this.liveType, 12, false);
    this.mapExtendInfo = ((Map)paramJceInputStream.read(cache_mapExtendInfo, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.roomid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.roomstat, 1);
    paramJceOutputStream.write(this.usercount, 2);
    paramJceOutputStream.write(this.livetime, 3);
    paramJceOutputStream.write(this.giftNum, 5);
    paramJceOutputStream.write(this.likeNum, 6);
    localObject = this.tipsMessage;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.extendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.exception_tips;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.vctCommentList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    localObject = this.vctLiveUserList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 11);
    }
    paramJceOutputStream.write(this.liveType, 12);
    localObject = this.mapExtendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_live
 * JD-Core Version:    0.7.0.1
 */