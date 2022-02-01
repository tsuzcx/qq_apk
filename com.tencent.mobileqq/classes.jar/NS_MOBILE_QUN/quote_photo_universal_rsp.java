package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class quote_photo_universal_rsp
  extends JceStruct
{
  static ArrayList<String> cache_url;
  public String msg = "";
  public int ret;
  public ArrayList<String> url;
  
  public quote_photo_universal_rsp() {}
  
  public quote_photo_universal_rsp(int paramInt, String paramString, ArrayList<String> paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.url = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_url == null)
    {
      cache_url = new ArrayList();
      cache_url.add("");
    }
    this.url = ((ArrayList)paramJceInputStream.read(cache_url, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    Object localObject = this.msg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.url;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.quote_photo_universal_rsp
 * JD-Core Version:    0.7.0.1
 */