package NS_MOBILE_AIONewestFeed;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class NewestFeedInfo
  extends JceStruct
{
  static Map<String, String> cache_mapEx;
  static ArrayList<Media_Data> cache_mediaData = new ArrayList();
  public Map<String, String> mapEx = null;
  public ArrayList<Media_Data> mediaData = null;
  public String strContent = "";
  public String strImgUrl = "";
  public String strJmpUrl = "";
  public String strLBSInfo = "";
  public String strSummary = "";
  public String strTitle = "";
  public long uAppid = 0L;
  public long uCommentNum = 0L;
  public long uHostUin = 0L;
  public long uImgCount = 0L;
  public long uLikeNum = 0L;
  public long uTime = 0L;
  
  static
  {
    Media_Data localMedia_Data = new Media_Data();
    cache_mediaData.add(localMedia_Data);
    cache_mapEx = new HashMap();
    cache_mapEx.put("", "");
  }
  
  public NewestFeedInfo() {}
  
  public NewestFeedInfo(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong4, String paramString6, ArrayList<Media_Data> paramArrayList, long paramLong5, long paramLong6, Map<String, String> paramMap)
  {
    this.uAppid = paramLong1;
    this.uHostUin = paramLong2;
    this.uTime = paramLong3;
    this.strLBSInfo = paramString1;
    this.strSummary = paramString2;
    this.strTitle = paramString3;
    this.strContent = paramString4;
    this.strImgUrl = paramString5;
    this.uImgCount = paramLong4;
    this.strJmpUrl = paramString6;
    this.mediaData = paramArrayList;
    this.uLikeNum = paramLong5;
    this.uCommentNum = paramLong6;
    this.mapEx = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uAppid = paramJceInputStream.read(this.uAppid, 0, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 1, false);
    this.uTime = paramJceInputStream.read(this.uTime, 2, false);
    this.strLBSInfo = paramJceInputStream.readString(3, false);
    this.strSummary = paramJceInputStream.readString(4, false);
    this.strTitle = paramJceInputStream.readString(5, false);
    this.strContent = paramJceInputStream.readString(6, false);
    this.strImgUrl = paramJceInputStream.readString(7, false);
    this.uImgCount = paramJceInputStream.read(this.uImgCount, 8, false);
    this.strJmpUrl = paramJceInputStream.readString(9, false);
    this.mediaData = ((ArrayList)paramJceInputStream.read(cache_mediaData, 10, false));
    this.uLikeNum = paramJceInputStream.read(this.uLikeNum, 11, false);
    this.uCommentNum = paramJceInputStream.read(this.uCommentNum, 12, false);
    this.mapEx = ((Map)paramJceInputStream.read(cache_mapEx, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uAppid, 0);
    paramJceOutputStream.write(this.uHostUin, 1);
    paramJceOutputStream.write(this.uTime, 2);
    Object localObject = this.strLBSInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.strSummary;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.strTitle;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.strContent;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.strImgUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.uImgCount, 8);
    localObject = this.strJmpUrl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.mediaData;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 10);
    }
    paramJceOutputStream.write(this.uLikeNum, 11);
    paramJceOutputStream.write(this.uCommentNum, 12);
    localObject = this.mapEx;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_AIONewestFeed.NewestFeedInfo
 * JD-Core Version:    0.7.0.1
 */