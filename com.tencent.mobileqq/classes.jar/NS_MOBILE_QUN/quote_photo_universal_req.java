package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class quote_photo_universal_req
  extends JceStruct
{
  static ArrayList<s_quote_photo_info> cache_photos;
  static quote_photo_dst cache_quote_dst;
  static quote_photo_src cache_quote_src;
  public ArrayList<s_quote_photo_info> photos;
  public quote_photo_dst quote_dst;
  public quote_photo_src quote_src;
  
  public quote_photo_universal_req() {}
  
  public quote_photo_universal_req(quote_photo_src paramquote_photo_src, quote_photo_dst paramquote_photo_dst, ArrayList<s_quote_photo_info> paramArrayList)
  {
    this.quote_src = paramquote_photo_src;
    this.quote_dst = paramquote_photo_dst;
    this.photos = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_quote_src == null) {
      cache_quote_src = new quote_photo_src();
    }
    this.quote_src = ((quote_photo_src)paramJceInputStream.read(cache_quote_src, 0, false));
    if (cache_quote_dst == null) {
      cache_quote_dst = new quote_photo_dst();
    }
    this.quote_dst = ((quote_photo_dst)paramJceInputStream.read(cache_quote_dst, 1, false));
    if (cache_photos == null)
    {
      cache_photos = new ArrayList();
      s_quote_photo_info locals_quote_photo_info = new s_quote_photo_info();
      cache_photos.add(locals_quote_photo_info);
    }
    this.photos = ((ArrayList)paramJceInputStream.read(cache_photos, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.quote_src;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.quote_dst;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.photos;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.quote_photo_universal_req
 * JD-Core Version:    0.7.0.1
 */