package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Facade
  extends JceStruct
{
  static int cache_iProperty;
  static int cache_iStyle;
  static int cache_iType;
  static Map cache_mapExtInfo;
  static ArrayList cache_vecView;
  public int iCanEdit;
  public int iHasNewFlag;
  public int iProperty;
  public int iStyle;
  public int iType;
  public Map mapExtInfo;
  public String strDescription = "";
  public String strFacadeName = "";
  public String strId = "";
  public String strThumbUrl = "";
  public String strTraceInfo = "";
  public ArrayList vecView;
  
  public Facade() {}
  
  public Facade(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, ArrayList paramArrayList, int paramInt3, int paramInt4, int paramInt5, String paramString5, Map paramMap)
  {
    this.strId = paramString1;
    this.iType = paramInt1;
    this.iProperty = paramInt2;
    this.strFacadeName = paramString2;
    this.strDescription = paramString3;
    this.strThumbUrl = paramString4;
    this.vecView = paramArrayList;
    this.iHasNewFlag = paramInt3;
    this.iCanEdit = paramInt4;
    this.iStyle = paramInt5;
    this.strTraceInfo = paramString5;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strId = paramJceInputStream.readString(0, true);
    this.iType = paramJceInputStream.read(this.iType, 1, false);
    this.iProperty = paramJceInputStream.read(this.iProperty, 2, false);
    this.strFacadeName = paramJceInputStream.readString(3, false);
    this.strDescription = paramJceInputStream.readString(4, false);
    this.strThumbUrl = paramJceInputStream.readString(5, false);
    if (cache_vecView == null)
    {
      cache_vecView = new ArrayList();
      FacadeView localFacadeView = new FacadeView();
      cache_vecView.add(localFacadeView);
    }
    this.vecView = ((ArrayList)paramJceInputStream.read(cache_vecView, 6, false));
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 7, false);
    this.iCanEdit = paramJceInputStream.read(this.iCanEdit, 8, false);
    this.iStyle = paramJceInputStream.read(this.iStyle, 9, false);
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
    if (this.strFacadeName != null) {
      paramJceOutputStream.write(this.strFacadeName, 3);
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
    paramJceOutputStream.write(this.iCanEdit, 8);
    paramJceOutputStream.write(this.iStyle, 9);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 10);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aac.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.Facade
 * JD-Core Version:    0.7.0.1
 */