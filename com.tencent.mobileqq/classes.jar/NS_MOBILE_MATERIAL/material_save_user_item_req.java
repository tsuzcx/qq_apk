package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class material_save_user_item_req
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo = new HashMap();
  public int iAppid = 0;
  public int iSendFeed = 0;
  public long lUin = 0L;
  public Map<String, String> mapExtInfo = null;
  public String strItemId = "";
  public String strQua = "";
  public String strSkey = "";
  
  static
  {
    cache_mapExtInfo.put("", "");
  }
  
  public material_save_user_item_req() {}
  
  public material_save_user_item_req(long paramLong, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, Map<String, String> paramMap)
  {
    this.lUin = paramLong;
    this.iAppid = paramInt1;
    this.strItemId = paramString1;
    this.strQua = paramString2;
    this.iSendFeed = paramInt2;
    this.strSkey = paramString3;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.iAppid = paramJceInputStream.read(this.iAppid, 1, true);
    this.strItemId = paramJceInputStream.readString(2, true);
    this.strQua = paramJceInputStream.readString(3, false);
    this.iSendFeed = paramJceInputStream.read(this.iSendFeed, 4, false);
    this.strSkey = paramJceInputStream.readString(5, false);
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.iAppid, 1);
    paramJceOutputStream.write(this.strItemId, 2);
    if (this.strQua != null) {
      paramJceOutputStream.write(this.strQua, 3);
    }
    paramJceOutputStream.write(this.iSendFeed, 4);
    if (this.strSkey != null) {
      paramJceOutputStream.write(this.strSkey, 5);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.material_save_user_item_req
 * JD-Core Version:    0.7.0.1
 */