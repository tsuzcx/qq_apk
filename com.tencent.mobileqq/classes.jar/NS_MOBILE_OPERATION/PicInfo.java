package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PicInfo
  extends JceStruct
{
  static Map<String, String> cache_mapWaterMarkParams = new HashMap();
  static Map<String, String> cache_pic_extend;
  static Map<String, String> cache_through_to_adapt_server;
  static byte[] cache_vectPicBin;
  public String albumid = "";
  public int hdheight;
  public String hdid = "";
  public int hdwidth;
  public String imageId = "";
  public int is_appext_pic;
  public boolean ishd = true;
  public Map<String, String> mapWaterMarkParams;
  public Map<String, String> pic_extend;
  public String pic_url = "";
  public int picheight;
  public String picmd5 = "";
  public String pictureid = "";
  public int pictype;
  public int picwidth;
  public String quan_key = "";
  public String richval = "";
  public String sloc = "";
  public int sourceType;
  public String strWaterMarkID = "";
  public String strWaterMarkMemo = "";
  public Map<String, String> through_to_adapt_server;
  public long uploadtime;
  public byte[] vectPicBin;
  public String video_id = "";
  
  static
  {
    cache_mapWaterMarkParams.put("", "");
    cache_vectPicBin = (byte[])new byte[1];
    ((byte[])cache_vectPicBin)[0] = 0;
    cache_through_to_adapt_server = new HashMap();
    cache_through_to_adapt_server.put("", "");
    cache_pic_extend = new HashMap();
    cache_pic_extend.put("", "");
  }
  
  public PicInfo() {}
  
  public PicInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Map<String, String> paramMap1, String paramString7, int paramInt6, String paramString8, byte[] paramArrayOfByte, long paramLong, int paramInt7, String paramString9, String paramString10, Map<String, String> paramMap2, String paramString11, String paramString12, Map<String, String> paramMap3)
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
    this.mapWaterMarkParams = paramMap1;
    this.pic_url = paramString7;
    this.is_appext_pic = paramInt6;
    this.richval = paramString8;
    this.vectPicBin = paramArrayOfByte;
    this.uploadtime = paramLong;
    this.sourceType = paramInt7;
    this.imageId = paramString9;
    this.picmd5 = paramString10;
    this.through_to_adapt_server = paramMap2;
    this.video_id = paramString11;
    this.quan_key = paramString12;
    this.pic_extend = paramMap3;
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
    this.vectPicBin = ((byte[])paramJceInputStream.read(cache_vectPicBin, 16, false));
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 17, false);
    this.sourceType = paramJceInputStream.read(this.sourceType, 18, false);
    this.imageId = paramJceInputStream.readString(19, false);
    this.picmd5 = paramJceInputStream.readString(20, false);
    this.through_to_adapt_server = ((Map)paramJceInputStream.read(cache_through_to_adapt_server, 21, false));
    this.video_id = paramJceInputStream.readString(22, false);
    this.quan_key = paramJceInputStream.readString(23, false);
    this.pic_extend = ((Map)paramJceInputStream.read(cache_pic_extend, 24, false));
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
    if (this.vectPicBin != null) {
      paramJceOutputStream.write(this.vectPicBin, 16);
    }
    paramJceOutputStream.write(this.uploadtime, 17);
    paramJceOutputStream.write(this.sourceType, 18);
    if (this.imageId != null) {
      paramJceOutputStream.write(this.imageId, 19);
    }
    if (this.picmd5 != null) {
      paramJceOutputStream.write(this.picmd5, 20);
    }
    if (this.through_to_adapt_server != null) {
      paramJceOutputStream.write(this.through_to_adapt_server, 21);
    }
    if (this.video_id != null) {
      paramJceOutputStream.write(this.video_id, 22);
    }
    if (this.quan_key != null) {
      paramJceOutputStream.write(this.quan_key, 23);
    }
    if (this.pic_extend != null) {
      paramJceOutputStream.write(this.pic_extend, 24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PicInfo
 * JD-Core Version:    0.7.0.1
 */