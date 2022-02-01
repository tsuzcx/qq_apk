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
  public Map<String, String> busi_param = null;
  public int button_actiontype = -1;
  public String button_title = "";
  public String guide_icon = "";
  public String guide_title = "";
  public String guide_url = "";
  public int iAttr = 0;
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
    Object localObject = this.guide_icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    localObject = this.guide_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.button_title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.guide_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.button_actiontype, 4);
    paramJceOutputStream.write(this.iAttr, 5);
    localObject = this.strButtonColor;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.busi_param;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_album_entrance
 * JD-Core Version:    0.7.0.1
 */