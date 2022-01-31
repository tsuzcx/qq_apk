package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CategoryOpRsp
  extends JceStruct
{
  static Map<String, String> cache_oldkey_2_newkey = new HashMap();
  public String msg = "";
  public Map<String, String> oldkey_2_newkey;
  public int ret;
  
  static
  {
    cache_oldkey_2_newkey.put("", "");
  }
  
  public CategoryOpRsp() {}
  
  public CategoryOpRsp(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.oldkey_2_newkey = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.oldkey_2_newkey = ((Map)paramJceInputStream.read(cache_oldkey_2_newkey, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.oldkey_2_newkey != null) {
      paramJceOutputStream.write(this.oldkey_2_newkey, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_PHOTO.CategoryOpRsp
 * JD-Core Version:    0.7.0.1
 */