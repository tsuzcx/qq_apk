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
  public int actiontype;
  public String actionurl = "";
  public String giftbackid = "";
  public String giftdesc = "";
  public String giftid = "";
  public String giftname = "";
  public String gifttype = "";
  public Map<Integer, String> gifturl;
  public boolean istiming = true;
  public int moreflag;
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
    if (this.giftname != null) {
      paramJceOutputStream.write(this.giftname, 0);
    }
    if (this.gifttype != null) {
      paramJceOutputStream.write(this.gifttype, 1);
    }
    if (this.giftid != null) {
      paramJceOutputStream.write(this.giftid, 2);
    }
    if (this.gifturl != null) {
      paramJceOutputStream.write(this.gifturl, 3);
    }
    if (this.giftdesc != null) {
      paramJceOutputStream.write(this.giftdesc, 4);
    }
    if (this.giftbackid != null) {
      paramJceOutputStream.write(this.giftbackid, 5);
    }
    paramJceOutputStream.write(this.actiontype, 6);
    if (this.actionurl != null) {
      paramJceOutputStream.write(this.actionurl, 7);
    }
    paramJceOutputStream.write(this.moreflag, 8);
    paramJceOutputStream.write(this.istiming, 9);
    if (this.sendtime != null) {
      paramJceOutputStream.write(this.sendtime, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_gift_item
 * JD-Core Version:    0.7.0.1
 */