package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ShuoshuoPicInfo
  extends JceStruct
{
  static Map<String, String> cache_mapWaterMarkParams = new HashMap();
  public String albumid = "";
  public int hdheight = 0;
  public String hdid = "";
  public int hdwidth = 0;
  public String imageId = "";
  public int is_appext_pic = 0;
  public boolean ishd = true;
  public Map<String, String> mapWaterMarkParams = null;
  public String pic_url = "";
  public int picheight = 0;
  public String pictureid = "";
  public int pictype = 0;
  public int picwidth = 0;
  public String richval = "";
  public String sloc = "";
  public int sourceType = 0;
  public String strWaterMarkID = "";
  public String strWaterMarkMemo = "";
  public String video_id = "";
  
  static
  {
    cache_mapWaterMarkParams.put("", "");
  }
  
  public ShuoshuoPicInfo() {}
  
  public ShuoshuoPicInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Map<String, String> paramMap, String paramString7, int paramInt6, String paramString8, int paramInt7, String paramString9, String paramString10)
  {
    this.albumid = paramString1;
    this.pictureid = paramString2;
    this.sloc = paramString3;
    this.pictype = paramInt1;
    this.picheight = paramInt2;
    this.picwidth = paramInt3;
    this.ishd = paramBoolean;
    this.hdid = paramString4;
    this.hdheight = paramInt4;
    this.hdwidth = paramInt5;
    this.strWaterMarkID = paramString5;
    this.strWaterMarkMemo = paramString6;
    this.mapWaterMarkParams = paramMap;
    this.pic_url = paramString7;
    this.is_appext_pic = paramInt6;
    this.richval = paramString8;
    this.sourceType = paramInt7;
    this.imageId = paramString9;
    this.video_id = paramString10;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, false);
    this.pictureid = paramJceInputStream.readString(1, false);
    this.sloc = paramJceInputStream.readString(2, false);
    this.pictype = paramJceInputStream.read(this.pictype, 3, false);
    this.picheight = paramJceInputStream.read(this.picheight, 4, false);
    this.picwidth = paramJceInputStream.read(this.picwidth, 5, false);
    this.ishd = paramJceInputStream.read(this.ishd, 6, false);
    this.hdid = paramJceInputStream.readString(7, false);
    this.hdheight = paramJceInputStream.read(this.hdheight, 8, false);
    this.hdwidth = paramJceInputStream.read(this.hdwidth, 9, false);
    this.strWaterMarkID = paramJceInputStream.readString(10, false);
    this.strWaterMarkMemo = paramJceInputStream.readString(11, false);
    this.mapWaterMarkParams = ((Map)paramJceInputStream.read(cache_mapWaterMarkParams, 12, false));
    this.pic_url = paramJceInputStream.readString(13, false);
    this.is_appext_pic = paramJceInputStream.read(this.is_appext_pic, 14, false);
    this.richval = paramJceInputStream.readString(15, false);
    this.sourceType = paramJceInputStream.read(this.sourceType, 16, false);
    this.imageId = paramJceInputStream.readString(17, false);
    this.video_id = paramJceInputStream.readString(18, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.albumid != null) {
      paramJceOutputStream.write(this.albumid, 0);
    }
    if (this.pictureid != null) {
      paramJceOutputStream.write(this.pictureid, 1);
    }
    if (this.sloc != null) {
      paramJceOutputStream.write(this.sloc, 2);
    }
    paramJceOutputStream.write(this.pictype, 3);
    paramJceOutputStream.write(this.picheight, 4);
    paramJceOutputStream.write(this.picwidth, 5);
    paramJceOutputStream.write(this.ishd, 6);
    if (this.hdid != null) {
      paramJceOutputStream.write(this.hdid, 7);
    }
    paramJceOutputStream.write(this.hdheight, 8);
    paramJceOutputStream.write(this.hdwidth, 9);
    if (this.strWaterMarkID != null) {
      paramJceOutputStream.write(this.strWaterMarkID, 10);
    }
    if (this.strWaterMarkMemo != null) {
      paramJceOutputStream.write(this.strWaterMarkMemo, 11);
    }
    if (this.mapWaterMarkParams != null) {
      paramJceOutputStream.write(this.mapWaterMarkParams, 12);
    }
    if (this.pic_url != null) {
      paramJceOutputStream.write(this.pic_url, 13);
    }
    paramJceOutputStream.write(this.is_appext_pic, 14);
    if (this.richval != null) {
      paramJceOutputStream.write(this.richval, 15);
    }
    paramJceOutputStream.write(this.sourceType, 16);
    if (this.imageId != null) {
      paramJceOutputStream.write(this.imageId, 17);
    }
    if (this.video_id != null) {
      paramJceOutputStream.write(this.video_id, 18);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     FileUpload.ShuoshuoPicInfo
 * JD-Core Version:    0.7.0.1
 */