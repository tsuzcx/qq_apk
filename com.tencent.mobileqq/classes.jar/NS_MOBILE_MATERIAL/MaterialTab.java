package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MaterialTab
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static byte[] cache_strExtFields;
  static ArrayList cache_vecBanner = new ArrayList();
  static ArrayList cache_vecCate;
  public int iTabId;
  public Map mapExtInfo;
  public byte[] strExtFields;
  public String strTabKey = "";
  public String strTabName = "";
  public String strTraceInfo = "";
  public long uiSettleTime;
  public ArrayList vecBanner;
  public ArrayList vecCate;
  
  static
  {
    Object localObject = new OperBanner();
    cache_vecBanner.add(localObject);
    cache_vecCate = new ArrayList();
    localObject = new MaterialCate();
    cache_vecCate.add(localObject);
    cache_strExtFields = (byte[])new byte[1];
    ((byte[])cache_strExtFields)[0] = 0;
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public MaterialTab() {}
  
  public MaterialTab(int paramInt, String paramString1, String paramString2, ArrayList paramArrayList1, ArrayList paramArrayList2, long paramLong, String paramString3, byte[] paramArrayOfByte, Map paramMap)
  {
    this.iTabId = paramInt;
    this.strTabKey = paramString1;
    this.strTabName = paramString2;
    this.vecBanner = paramArrayList1;
    this.vecCate = paramArrayList2;
    this.uiSettleTime = paramLong;
    this.strTraceInfo = paramString3;
    this.strExtFields = paramArrayOfByte;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iTabId = paramJceInputStream.read(this.iTabId, 0, true);
    this.strTabKey = paramJceInputStream.readString(1, false);
    this.strTabName = paramJceInputStream.readString(2, false);
    this.vecBanner = ((ArrayList)paramJceInputStream.read(cache_vecBanner, 3, false));
    this.vecCate = ((ArrayList)paramJceInputStream.read(cache_vecCate, 4, false));
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 5, false);
    this.strTraceInfo = paramJceInputStream.readString(6, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 7, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iTabId, 0);
    if (this.strTabKey != null) {
      paramJceOutputStream.write(this.strTabKey, 1);
    }
    if (this.strTabName != null) {
      paramJceOutputStream.write(this.strTabName, 2);
    }
    if (this.vecBanner != null) {
      paramJceOutputStream.write(this.vecBanner, 3);
    }
    if (this.vecCate != null) {
      paramJceOutputStream.write(this.vecCate, 4);
    }
    paramJceOutputStream.write(this.uiSettleTime, 5);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 6);
    }
    if (this.strExtFields != null) {
      paramJceOutputStream.write(this.strExtFields, 7);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialTab
 * JD-Core Version:    0.7.0.1
 */