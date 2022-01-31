package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class PicInfo
  extends JceStruct
{
  static Map cache_mapWaterMarkParams;
  static byte[] cache_vectPicBin;
  public String albumid = "";
  public int hdheight;
  public String hdid = "";
  public int hdwidth;
  public String imageId = "";
  public int is_appext_pic;
  public boolean ishd = true;
  public Map mapWaterMarkParams;
  public String pic_url = "";
  public int picheight;
  public String pictureid = "";
  public int pictype;
  public int picwidth;
  public String richval = "";
  public String sloc = "";
  public int sourceType;
  public String strWaterMarkID = "";
  public String strWaterMarkMemo = "";
  public long uploadtime;
  public byte[] vectPicBin;
  
  public PicInfo() {}
  
  public PicInfo(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString4, int paramInt4, int paramInt5, String paramString5, String paramString6, Map paramMap, String paramString7, int paramInt6, String paramString8, byte[] paramArrayOfByte, long paramLong, int paramInt7, String paramString9)
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
    this.vectPicBin = paramArrayOfByte;
    this.uploadtime = paramLong;
    this.sourceType = paramInt7;
    this.imageId = paramString9;
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
    if (cache_mapWaterMarkParams == null)
    {
      cache_mapWaterMarkParams = new HashMap();
      cache_mapWaterMarkParams.put("", "");
    }
    this.mapWaterMarkParams = ((Map)paramJceInputStream.read(cache_mapWaterMarkParams, 12, false));
    this.pic_url = paramJceInputStream.readString(13, false);
    this.is_appext_pic = paramJceInputStream.read(this.is_appext_pic, 14, false);
    this.richval = paramJceInputStream.readString(15, false);
    if (cache_vectPicBin == null)
    {
      cache_vectPicBin = (byte[])new byte[1];
      ((byte[])cache_vectPicBin)[0] = 0;
    }
    this.vectPicBin = ((byte[])paramJceInputStream.read(cache_vectPicBin, 16, false));
    this.uploadtime = paramJceInputStream.read(this.uploadtime, 17, false);
    this.sourceType = paramJceInputStream.read(this.sourceType, 18, false);
    this.imageId = paramJceInputStream.readString(19, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_OPERATION.PicInfo
 * JD-Core Version:    0.7.0.1
 */