package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qzone_quote_photo_from_qun_req
  extends JceStruct
{
  static ArrayList<s_quote_photo_info> cache_photos;
  public long albumhandset;
  public String albumid = "";
  public long batchid;
  public String desc = "";
  public ArrayList<s_quote_photo_info> photos;
  public String qunid = "";
  
  public qzone_quote_photo_from_qun_req() {}
  
  public qzone_quote_photo_from_qun_req(String paramString1, String paramString2, String paramString3, ArrayList<s_quote_photo_info> paramArrayList, long paramLong1, long paramLong2)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.desc = paramString3;
    this.photos = paramArrayList;
    this.batchid = paramLong1;
    this.albumhandset = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.desc = paramJceInputStream.readString(2, false);
    if (cache_photos == null)
    {
      cache_photos = new ArrayList();
      s_quote_photo_info locals_quote_photo_info = new s_quote_photo_info();
      cache_photos.add(locals_quote_photo_info);
    }
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 3, true));
    this.batchid = paramJceInputStream.read(this.batchid, 4, false);
    this.albumhandset = paramJceInputStream.read(this.albumhandset, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 2);
    }
    paramJceOutputStream.write(this.photos, 3);
    paramJceOutputStream.write(this.batchid, 4);
    paramJceOutputStream.write(this.albumhandset, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_QUN.qzone_quote_photo_from_qun_req
 * JD-Core Version:    0.7.0.1
 */