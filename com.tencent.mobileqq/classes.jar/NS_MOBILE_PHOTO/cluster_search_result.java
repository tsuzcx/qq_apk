package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cluster_search_result
  extends JceStruct
{
  public String categoryid = "";
  public float confidence;
  public String groupid = "";
  public boolean has_identify;
  public String nickname = "";
  public long uin;
  
  public cluster_search_result() {}
  
  public cluster_search_result(String paramString1, float paramFloat, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
  {
    this.categoryid = paramString1;
    this.confidence = paramFloat;
    this.uin = paramLong;
    this.has_identify = paramBoolean;
    this.groupid = paramString2;
    this.nickname = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.categoryid = paramJceInputStream.readString(0, false);
    this.confidence = paramJceInputStream.read(this.confidence, 1, false);
    this.uin = paramJceInputStream.read(this.uin, 2, false);
    this.has_identify = paramJceInputStream.read(this.has_identify, 3, false);
    this.groupid = paramJceInputStream.readString(4, false);
    this.nickname = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.categoryid != null) {
      paramJceOutputStream.write(this.categoryid, 0);
    }
    paramJceOutputStream.write(this.confidence, 1);
    paramJceOutputStream.write(this.uin, 2);
    paramJceOutputStream.write(this.has_identify, 3);
    if (this.groupid != null) {
      paramJceOutputStream.write(this.groupid, 4);
    }
    if (this.nickname != null) {
      paramJceOutputStream.write(this.nickname, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.cluster_search_result
 * JD-Core Version:    0.7.0.1
 */