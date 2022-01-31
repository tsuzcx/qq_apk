package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class cell_album_entrance
  extends JceStruct
{
  static Map<String, String> cache_busi_param = new HashMap();
  public Map<String, String> busi_param;
  public int button_actiontype = -1;
  public String button_title = "";
  public String guide_icon = "";
  public String guide_title = "";
  public String guide_url = "";
  public int iAttr;
  public String strButtonColor = "";
  
  static
  {
    cache_busi_param.put("", "");
  }
  
  public cell_album_entrance() {}
  
  public cell_album_entrance(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, Map<String, String> paramMap)
  {
    this.guide_icon = paramString1;
    this.guide_title = paramString2;
    this.button_title = paramString3;
    this.guide_url = paramString4;
    this.button_actiontype = paramInt1;
    this.iAttr = paramInt2;
    this.strButtonColor = paramString5;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.guide_icon = paramJceInputStream.readString(0, false);
    this.guide_title = paramJceInputStream.readString(1, false);
    this.button_title = paramJceInputStream.readString(2, false);
    this.guide_url = paramJceInputStream.readString(3, false);
    this.button_actiontype = paramJceInputStream.read(this.button_actiontype, 4, false);
    this.iAttr = paramJceInputStream.read(this.iAttr, 5, false);
    this.strButtonColor = paramJceInputStream.readString(6, false);
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.guide_icon != null) {
      paramJceOutputStream.write(this.guide_icon, 0);
    }
    if (this.guide_title != null) {
      paramJceOutputStream.write(this.guide_title, 1);
    }
    if (this.button_title != null) {
      paramJceOutputStream.write(this.button_title, 2);
    }
    if (this.guide_url != null) {
      paramJceOutputStream.write(this.guide_url, 3);
    }
    paramJceOutputStream.write(this.button_actiontype, 4);
    paramJceOutputStream.write(this.iAttr, 5);
    if (this.strButtonColor != null) {
      paramJceOutputStream.write(this.strButtonColor, 6);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_album_entrance
 * JD-Core Version:    0.7.0.1
 */