package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class qun_upload_finish_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param;
  public String albumid = "";
  public int albumtype;
  public long batchid;
  public Map<Integer, String> busi_param;
  public String clientkey = "";
  public long photosucc;
  public long photototal;
  public String qunid = "";
  public int retry_count;
  
  public qun_upload_finish_req() {}
  
  public qun_upload_finish_req(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, String paramString3, Map<Integer, String> paramMap, int paramInt1, int paramInt2)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.batchid = paramLong1;
    this.photototal = paramLong2;
    this.photosucc = paramLong3;
    this.clientkey = paramString3;
    this.busi_param = paramMap;
    this.retry_count = paramInt1;
    this.albumtype = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.batchid = paramJceInputStream.read(this.batchid, 2, false);
    this.photototal = paramJceInputStream.read(this.photototal, 3, false);
    this.photosucc = paramJceInputStream.read(this.photosucc, 4, false);
    this.clientkey = paramJceInputStream.readString(5, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 6, false));
    this.retry_count = paramJceInputStream.read(this.retry_count, 7, false);
    this.albumtype = paramJceInputStream.read(this.albumtype, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.batchid, 2);
    paramJceOutputStream.write(this.photototal, 3);
    paramJceOutputStream.write(this.photosucc, 4);
    Object localObject = this.clientkey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
    paramJceOutputStream.write(this.retry_count, 7);
    paramJceOutputStream.write(this.albumtype, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_upload_finish_req
 * JD-Core Version:    0.7.0.1
 */