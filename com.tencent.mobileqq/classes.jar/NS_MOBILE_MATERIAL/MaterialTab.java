package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class MaterialTab
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static byte[] cache_strExtFields;
  static ArrayList<OperBanner> cache_vecBanner = new ArrayList();
  static ArrayList<MaterialCate> cache_vecCate;
  public int iTabId = 0;
  public Map<String, String> mapExtInfo = null;
  public byte[] strExtFields = null;
  public String strTabKey = "";
  public String strTabName = "";
  public String strTraceInfo = "";
  public long uiSettleTime = 0L;
  public ArrayList<OperBanner> vecBanner = null;
  public ArrayList<MaterialCate> vecCate = null;
  
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
  
  public MaterialTab(int paramInt, String paramString1, String paramString2, ArrayList<OperBanner> paramArrayList, ArrayList<MaterialCate> paramArrayList1, long paramLong, String paramString3, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this.iTabId = paramInt;
    this.strTabKey = paramString1;
    this.strTabName = paramString2;
    this.vecBanner = paramArrayList;
    this.vecCate = paramArrayList1;
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
    Object localObject = this.strTabKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strTabName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.vecBanner;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    localObject = this.vecCate;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 4);
    }
    paramJceOutputStream.write(this.uiSettleTime, 5);
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.strExtFields;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 7);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialTab
 * JD-Core Version:    0.7.0.1
 */