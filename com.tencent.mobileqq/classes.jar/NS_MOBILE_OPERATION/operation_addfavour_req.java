package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class operation_addfavour_req
  extends JceStruct
{
  static Map<String, String> cache_busi_params;
  static ArrayList<PhotoInformation> cache_photo_url;
  public long appid;
  public Map<String, String> busi_params;
  public String cellid = "";
  public long owner_uin;
  public ArrayList<PhotoInformation> photo_url;
  public String sid = "";
  public long subid;
  public String text = "";
  public String ugc_key = "";
  
  public operation_addfavour_req() {}
  
  public operation_addfavour_req(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, ArrayList<PhotoInformation> paramArrayList, String paramString4, Map<String, String> paramMap)
  {
    this.owner_uin = paramLong1;
    this.appid = paramLong2;
    this.subid = paramLong3;
    this.cellid = paramString1;
    this.sid = paramString2;
    this.ugc_key = paramString3;
    this.photo_url = paramArrayList;
    this.text = paramString4;
    this.busi_params = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner_uin = paramJceInputStream.read(this.owner_uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.subid = paramJceInputStream.read(this.subid, 2, false);
    this.cellid = paramJceInputStream.readString(3, false);
    this.sid = paramJceInputStream.readString(4, false);
    this.ugc_key = paramJceInputStream.readString(5, false);
    if (cache_photo_url == null)
    {
      cache_photo_url = new ArrayList();
      PhotoInformation localPhotoInformation = new PhotoInformation();
      cache_photo_url.add(localPhotoInformation);
    }
    this.photo_url = ((ArrayList)paramJceInputStream.read(cache_photo_url, 6, false));
    this.text = paramJceInputStream.readString(7, false);
    if (cache_busi_params == null)
    {
      cache_busi_params = new HashMap();
      cache_busi_params.put("", "");
    }
    this.busi_params = ((Map)paramJceInputStream.read(cache_busi_params, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner_uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.subid, 2);
    Object localObject = this.cellid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.sid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.ugc_key;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.photo_url;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 6);
    }
    localObject = this.text;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.busi_params;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addfavour_req
 * JD-Core Version:    0.7.0.1
 */