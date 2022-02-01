package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_gift
  extends JceStruct
{
  static int cache_giftactiontype = 0;
  static Map<Integer, String> cache_gifturl = new HashMap();
  public String actionurl = "";
  public int giftactiontype = 1;
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map<Integer, String> gifturl = null;
  
  static
  {
    cache_gifturl.put(Integer.valueOf(0), "");
  }
  
  public cell_gift() {}
  
  public cell_gift(String paramString1, String paramString2, String paramString3, Map<Integer, String> paramMap, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    this.giftname = paramString1;
    this.gifttype = paramString2;
    this.giftid = paramString3;
    this.gifturl = paramMap;
    this.giftdesc = paramString4;
    this.giftbackid = paramString5;
    this.giftactiontype = paramInt;
    this.actionurl = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftname = paramJceInputStream.readString(0, false);
    this.gifttype = paramJceInputStream.readString(1, false);
    this.giftid = paramJceInputStream.readString(2, false);
    this.gifturl = ((Map)paramJceInputStream.read(cache_gifturl, 3, false));
    this.giftdesc = paramJceInputStream.readString(4, false);
    this.giftbackid = paramJceInputStream.readString(5, false);
    this.giftactiontype = paramJceInputStream.read(this.giftactiontype, 6, false);
    this.actionurl = paramJceInputStream.readString(7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.giftname;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.gifttype;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.giftid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.gifturl;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    localObject = this.giftdesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.giftbackid;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    paramJceOutputStream.write(this.giftactiontype, 6);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_gift
 * JD-Core Version:    0.7.0.1
 */