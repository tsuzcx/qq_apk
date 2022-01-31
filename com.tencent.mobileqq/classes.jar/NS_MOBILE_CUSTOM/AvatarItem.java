package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class AvatarItem
  extends JceStruct
{
  static int cache_iProperty;
  static int cache_iType;
  static Map<String, String> cache_mapExtInfo;
  static ArrayList<AvatarItemView> cache_vecView;
  public int iHasNewFlag;
  public int iProperty;
  public int iType;
  public Map<String, String> mapExtInfo;
  public String strAvatarName = "";
  public String strDescription = "";
  public String strId = "";
  public String strThumbUrl = "";
  public String strTraceInfo = "";
  public ArrayList<AvatarItemView> vecView;
  
  public AvatarItem() {}
  
  public AvatarItem(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArrayList<AvatarItemView> paramArrayList, int paramInt3, String paramString5, Map<String, String> paramMap)
  {
    this.strId = paramString1;
    this.iType = paramInt1;
    this.iProperty = paramInt2;
    this.strAvatarName = paramString2;
    this.strDescription = paramString3;
    this.strThumbUrl = paramString4;
    this.vecView = paramArrayList;
    this.iHasNewFlag = paramInt3;
    this.strTraceInfo = paramString5;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strId = paramJceInputStream.readString(0, true);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.iProperty = paramJceInputStream.read(this.iProperty, 2, false);
    this.strAvatarName = paramJceInputStream.readString(3, false);
    this.strDescription = paramJceInputStream.readString(4, false);
    this.strThumbUrl = paramJceInputStream.readString(5, false);
    if (cache_vecView == null)
    {
      cache_vecView = new ArrayList();
      AvatarItemView localAvatarItemView = new AvatarItemView();
      cache_vecView.add(localAvatarItemView);
    }
    this.vecView = ((ArrayList)paramJceInputStream.read(cache_vecView, 6, false));
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 7, false);
    this.strTraceInfo = paramJceInputStream.readString(10, false);
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 11, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strId, 0);
    paramJceOutputStream.write(this.iType, 1);
    paramJceOutputStream.write(this.iProperty, 2);
    if (this.strAvatarName != null) {
      paramJceOutputStream.write(this.strAvatarName, 3);
    }
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 4);
    }
    if (this.strThumbUrl != null) {
      paramJceOutputStream.write(this.strThumbUrl, 5);
    }
    if (this.vecView != null) {
      paramJceOutputStream.write(this.vecView, 6);
    }
    paramJceOutputStream.write(this.iHasNewFlag, 7);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 10);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.AvatarItem
 * JD-Core Version:    0.7.0.1
 */