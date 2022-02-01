package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class qun_quote_photo_from_qzone_rsp
  extends JceStruct
{
  static ArrayList<String> cache_url = new ArrayList();
  public ArrayList<String> url = null;
  
  static
  {
    cache_url.add("");
  }
  
  public qun_quote_photo_from_qzone_rsp() {}
  
  public qun_quote_photo_from_qzone_rsp(ArrayList<String> paramArrayList)
  {
    this.url = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = ((ArrayList)paramJceInputStream.read(cache_url, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.url;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_quote_photo_from_qzone_rsp
 * JD-Core Version:    0.7.0.1
 */