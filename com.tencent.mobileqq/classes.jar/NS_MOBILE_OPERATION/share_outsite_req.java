package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class share_outsite_req
  extends JceStruct
{
  static Map<Integer, String> cache_busi_param = new HashMap();
  public String albumid = "";
  public int appid = 0;
  public String batchid = "";
  public Map<Integer, String> busi_param = null;
  public String cellid = "";
  public int iIsShareTo = 0;
  public String lloc = "";
  public int shareScene = 0;
  public String strMd5Key = "";
  public long uHostUin = 0L;
  public int ugc_type = 0;
  
  static
  {
    cache_busi_param.put(Integer.valueOf(0), "");
  }
  
  public share_outsite_req() {}
  
  public share_outsite_req(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt3, String paramString5, int paramInt4, Map<Integer, String> paramMap)
  {
    this.appid = paramInt1;
    this.cellid = paramString1;
    this.ugc_type = paramInt2;
    this.albumid = paramString2;
    this.lloc = paramString3;
    this.batchid = paramString4;
    this.uHostUin = paramLong;
    this.iIsShareTo = paramInt3;
    this.strMd5Key = paramString5;
    this.shareScene = paramInt4;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.appid = paramJceInputStream.read(this.appid, 0, false);
    this.cellid = paramJceInputStream.readString(1, false);
    this.ugc_type = paramJceInputStream.read(this.ugc_type, 2, false);
    this.albumid = paramJceInputStream.readString(3, false);
    this.lloc = paramJceInputStream.readString(4, false);
    this.batchid = paramJceInputStream.readString(5, false);
    this.uHostUin = paramJceInputStream.read(this.uHostUin, 6, false);
    this.iIsShareTo = paramJceInputStream.read(this.iIsShareTo, 7, false);
    this.strMd5Key = paramJceInputStream.readString(8, false);
    this.shareScene = paramJceInputStream.read(this.shareScene, 9, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 10, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.appid, 0);
    Object localObject = this.cellid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.ugc_type, 2);
    localObject = this.albumid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.lloc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.batchid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.uHostUin, 6);
    paramJceOutputStream.write(this.iIsShareTo, 7);
    localObject = this.strMd5Key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    paramJceOutputStream.write(this.shareScene, 9);
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.share_outsite_req
 * JD-Core Version:    0.7.0.1
 */