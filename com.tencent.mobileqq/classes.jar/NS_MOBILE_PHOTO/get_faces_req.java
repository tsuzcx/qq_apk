package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class get_faces_req
  extends JceStruct
{
  static ArrayList cache_photoid;
  static int cache_quanstate;
  static ArrayList cache_urls;
  public String albumid = "";
  public int num;
  public long owneruin;
  public ArrayList photoid;
  public int quanstate;
  public int start;
  public ArrayList urls;
  
  public get_faces_req() {}
  
  public get_faces_req(String paramString, ArrayList paramArrayList1, int paramInt1, long paramLong, ArrayList paramArrayList2, int paramInt2, int paramInt3)
  {
    this.albumid = paramString;
    this.photoid = paramArrayList1;
    this.quanstate = paramInt1;
    this.owneruin = paramLong;
    this.urls = paramArrayList2;
    this.start = paramInt2;
    this.num = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    if (cache_photoid == null)
    {
      cache_photoid = new ArrayList();
      cache_photoid.add("");
    }
    this.photoid = ((ArrayList)paramJceInputStream.read(cache_photoid, 1, true));
    this.quanstate = paramJceInputStream.read(this.quanstate, 2, true);
    this.owneruin = paramJceInputStream.read(this.owneruin, 3, false);
    if (cache_urls == null)
    {
      cache_urls = new ArrayList();
      cache_urls.add("");
    }
    this.urls = ((ArrayList)paramJceInputStream.read(cache_urls, 4, false));
    this.start = paramJceInputStream.read(this.start, 5, false);
    this.num = paramJceInputStream.read(this.num, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.photoid, 1);
    paramJceOutputStream.write(this.quanstate, 2);
    paramJceOutputStream.write(this.owneruin, 3);
    if (this.urls != null) {
      paramJceOutputStream.write(this.urls, 4);
    }
    paramJceOutputStream.write(this.start, 5);
    paramJceOutputStream.write(this.num, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_PHOTO.get_faces_req
 * JD-Core Version:    0.7.0.1
 */