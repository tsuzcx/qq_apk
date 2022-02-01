package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class CustomTrackAction
  extends JceStruct
{
  static Map<String, String> cache_ExtendInfo = new HashMap();
  public String Button = "";
  public Map<String, String> ExtendInfo = null;
  public String ID = "";
  public String Name = "";
  public int Type = 0;
  public String Url = "";
  public int is_block = 0;
  
  static
  {
    cache_ExtendInfo.put("", "");
  }
  
  public CustomTrackAction() {}
  
  public CustomTrackAction(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    this.ID = paramString1;
    this.Type = paramInt1;
    this.Name = paramString2;
    this.is_block = paramInt2;
    this.Url = paramString3;
    this.Button = paramString4;
    this.ExtendInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ID = paramJceInputStream.readString(0, false);
    this.Type = paramJceInputStream.read(this.Type, 1, false);
    this.Name = paramJceInputStream.readString(2, false);
    this.is_block = paramJceInputStream.read(this.is_block, 3, false);
    this.Url = paramJceInputStream.readString(4, false);
    this.Button = paramJceInputStream.readString(5, false);
    this.ExtendInfo = ((Map)paramJceInputStream.read(cache_ExtendInfo, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.ID;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 0);
    }
    paramJceOutputStream.write(this.Type, 1);
    localObject = this.Name;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.is_block, 3);
    localObject = this.Url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    localObject = this.Button;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.ExtendInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.CustomTrackAction
 * JD-Core Version:    0.7.0.1
 */