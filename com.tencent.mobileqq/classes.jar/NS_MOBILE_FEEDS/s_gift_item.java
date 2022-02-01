package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class s_gift_item
  extends JceStruct
{
  static Map<Integer, String> cache_gifturl = new HashMap();
  public int actiontype = 0;
  public String actionurl = "";
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map<Integer, String> gifturl = null;
  public boolean istiming = true;
  public int moreflag = 0;
  public String sendtime = "";
  
  static
  {
    cache_gifturl.put(Integer.valueOf(0), "");
  }
  
  public s_gift_item() {}
  
  public s_gift_item(String paramString1, String paramString2, String paramString3, Map<Integer, String> paramMap, String paramString4, String paramString5, int paramInt1, String paramString6, int paramInt2, boolean paramBoolean, String paramString7)
  {
    this.giftname = paramString1;
    this.gifttype = paramString2;
    this.giftid = paramString3;
    this.gifturl = paramMap;
    this.giftdesc = paramString4;
    this.giftbackid = paramString5;
    this.actiontype = paramInt1;
    this.actionurl = paramString6;
    this.moreflag = paramInt2;
    this.istiming = paramBoolean;
    this.sendtime = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.giftname = paramJceInputStream.readString(0, false);
    this.gifttype = paramJceInputStream.readString(1, false);
    this.giftid = paramJceInputStream.readString(2, false);
    this.gifturl = ((Map)paramJceInputStream.read(cache_gifturl, 3, false));
    this.giftdesc = paramJceInputStream.readString(4, false);
    this.giftbackid = paramJceInputStream.readString(5, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 6, false);
    this.actionurl = paramJceInputStream.readString(7, false);
    this.moreflag = paramJceInputStream.read(this.moreflag, 8, false);
    this.istiming = paramJceInputStream.read(this.istiming, 9, false);
    this.sendtime = paramJceInputStream.readString(10, false);
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
    paramJceOutputStream.write(this.actiontype, 6);
    localObject = this.actionurl;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    paramJceOutputStream.write(this.moreflag, 8);
    paramJceOutputStream.write(this.istiming, 9);
    localObject = this.sendtime;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_gift_item
 * JD-Core Version:    0.7.0.1
 */