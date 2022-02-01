package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_quote_photo_info
  extends JceStruct
{
  static Map<Integer, String> cache_mapAttr;
  public long chatDstUin;
  public long chatSrcUin;
  public String clientkey = "";
  public long groupUin;
  public Map<Integer, String> mapAttr;
  public long msgtime;
  public long qunPicFileID;
  public long upload_time;
  public String url = "";
  public String uuid = "";
  
  public s_quote_photo_info() {}
  
  public s_quote_photo_info(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, Map<Integer, String> paramMap)
  {
    this.url = paramString1;
    this.clientkey = paramString2;
    this.uuid = paramString3;
    this.msgtime = paramLong1;
    this.groupUin = paramLong2;
    this.upload_time = paramLong3;
    this.chatSrcUin = paramLong4;
    this.chatDstUin = paramLong5;
    this.qunPicFileID = paramLong6;
    this.mapAttr = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.clientkey = paramJceInputStream.readString(1, false);
    this.uuid = paramJceInputStream.readString(2, false);
    this.msgtime = paramJceInputStream.read(this.msgtime, 3, false);
    this.groupUin = paramJceInputStream.read(this.groupUin, 4, false);
    this.upload_time = paramJceInputStream.read(this.upload_time, 5, false);
    this.chatSrcUin = paramJceInputStream.read(this.chatSrcUin, 6, false);
    this.chatDstUin = paramJceInputStream.read(this.chatDstUin, 7, false);
    this.qunPicFileID = paramJceInputStream.read(this.qunPicFileID, 8, false);
    if (cache_mapAttr == null)
    {
      cache_mapAttr = new HashMap();
      cache_mapAttr.put(Integer.valueOf(0), "");
    }
    this.mapAttr = ((Map)paramJceInputStream.read(cache_mapAttr, 9, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.uuid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.msgtime, 3);
    paramJceOutputStream.write(this.groupUin, 4);
    paramJceOutputStream.write(this.upload_time, 5);
    paramJceOutputStream.write(this.chatSrcUin, 6);
    paramJceOutputStream.write(this.chatDstUin, 7);
    paramJceOutputStream.write(this.qunPicFileID, 8);
    localObject = this.mapAttr;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.s_quote_photo_info
 * JD-Core Version:    0.7.0.1
 */