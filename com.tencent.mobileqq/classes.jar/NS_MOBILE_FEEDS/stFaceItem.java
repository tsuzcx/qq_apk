package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stFaceItem
  extends JceStruct
{
  static int cache_quanstate = 0;
  static ArrayList<FaceRecommendInfo> cache_recommend_infos = new ArrayList();
  public boolean FromSys = true;
  public String faceUrl = "";
  public String faceid = "";
  public String groupid = "";
  public long h;
  public boolean is_recommend;
  public long opertime;
  public String photo_id = "";
  public String quanid = "";
  public int quanstate;
  public ArrayList<FaceRecommendInfo> recommend_infos;
  public String target_groupid = "";
  public String targetnick = "";
  public long targetuin;
  public long w;
  public String writernick = "";
  public long writeruin;
  public long x;
  public long y;
  
  static
  {
    FaceRecommendInfo localFaceRecommendInfo = new FaceRecommendInfo();
    cache_recommend_infos.add(localFaceRecommendInfo);
  }
  
  public stFaceItem() {}
  
  public stFaceItem(String paramString1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, String paramString2, String paramString3, long paramLong6, String paramString4, long paramLong7, String paramString5, String paramString6, boolean paramBoolean1, String paramString7, ArrayList<FaceRecommendInfo> paramArrayList, String paramString8, boolean paramBoolean2)
  {
    this.photo_id = paramString1;
    this.x = paramLong1;
    this.y = paramLong2;
    this.w = paramLong3;
    this.h = paramLong4;
    this.quanstate = paramInt;
    this.opertime = paramLong5;
    this.faceid = paramString2;
    this.quanid = paramString3;
    this.targetuin = paramLong6;
    this.targetnick = paramString4;
    this.writeruin = paramLong7;
    this.writernick = paramString5;
    this.faceUrl = paramString6;
    this.FromSys = paramBoolean1;
    this.groupid = paramString7;
    this.recommend_infos = paramArrayList;
    this.target_groupid = paramString8;
    this.is_recommend = paramBoolean2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.photo_id = paramJceInputStream.readString(0, true);
    this.x = paramJceInputStream.read(this.x, 1, true);
    this.y = paramJceInputStream.read(this.y, 2, true);
    this.w = paramJceInputStream.read(this.w, 3, true);
    this.h = paramJceInputStream.read(this.h, 4, true);
    this.quanstate = paramJceInputStream.read(this.quanstate, 5, true);
    this.opertime = paramJceInputStream.read(this.opertime, 6, true);
    this.faceid = paramJceInputStream.readString(7, false);
    this.quanid = paramJceInputStream.readString(8, false);
    this.targetuin = paramJceInputStream.read(this.targetuin, 9, false);
    this.targetnick = paramJceInputStream.readString(10, false);
    this.writeruin = paramJceInputStream.read(this.writeruin, 11, false);
    this.writernick = paramJceInputStream.readString(12, false);
    this.faceUrl = paramJceInputStream.readString(13, false);
    this.FromSys = paramJceInputStream.read(this.FromSys, 14, false);
    this.groupid = paramJceInputStream.readString(15, false);
    this.recommend_infos = ((ArrayList)paramJceInputStream.read(cache_recommend_infos, 16, false));
    this.target_groupid = paramJceInputStream.readString(17, false);
    this.is_recommend = paramJceInputStream.read(this.is_recommend, 18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.photo_id, 0);
    paramJceOutputStream.write(this.x, 1);
    paramJceOutputStream.write(this.y, 2);
    paramJceOutputStream.write(this.w, 3);
    paramJceOutputStream.write(this.h, 4);
    paramJceOutputStream.write(this.quanstate, 5);
    paramJceOutputStream.write(this.opertime, 6);
    if (this.faceid != null) {
      paramJceOutputStream.write(this.faceid, 7);
    }
    if (this.quanid != null) {
      paramJceOutputStream.write(this.quanid, 8);
    }
    paramJceOutputStream.write(this.targetuin, 9);
    if (this.targetnick != null) {
      paramJceOutputStream.write(this.targetnick, 10);
    }
    paramJceOutputStream.write(this.writeruin, 11);
    if (this.writernick != null) {
      paramJceOutputStream.write(this.writernick, 12);
    }
    if (this.faceUrl != null) {
      paramJceOutputStream.write(this.faceUrl, 13);
    }
    paramJceOutputStream.write(this.FromSys, 14);
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 15);
    }
    if (this.recommend_infos != null) {
      paramJceOutputStream.write(this.recommend_infos, 16);
    }
    if (this.target_groupid != null) {
      paramJceOutputStream.write(this.target_groupid, 17);
    }
    paramJceOutputStream.write(this.is_recommend, 18);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS.stFaceItem
 * JD-Core Version:    0.7.0.1
 */