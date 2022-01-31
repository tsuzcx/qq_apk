package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MaterialCate
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static MaterialFile cache_stBanner;
  static MaterialFile cache_stThumb;
  static byte[] cache_strExtFields;
  static ArrayList<OperBanner> cache_vecBanner;
  static ArrayList<MaterialItem> cache_vecItem = new ArrayList();
  public int iCateId;
  public int iQZInitShowCount;
  public int iSQInitShowCount;
  public Map<String, String> mapExtInfo;
  public MaterialFile stBanner;
  public MaterialFile stThumb;
  public String strCateKey = "";
  public String strCateName = "";
  public String strDescription = "";
  public byte[] strExtFields;
  public String strTraceInfo = "";
  public long uiSettleTime;
  public long uiTotalItems;
  public ArrayList<OperBanner> vecBanner;
  public ArrayList<MaterialItem> vecItem;
  
  static
  {
    Object localObject = new MaterialItem();
    cache_vecItem.add(localObject);
    cache_vecBanner = new ArrayList();
    localObject = new OperBanner();
    cache_vecBanner.add(localObject);
    cache_stThumb = new MaterialFile();
    cache_stBanner = new MaterialFile();
    cache_strExtFields = (byte[])new byte[1];
    ((byte[])cache_strExtFields)[0] = 0;
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public MaterialCate() {}
  
  public MaterialCate(int paramInt1, String paramString1, String paramString2, ArrayList<MaterialItem> paramArrayList, int paramInt2, int paramInt3, long paramLong1, ArrayList<OperBanner> paramArrayList1, String paramString3, MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, long paramLong2, String paramString4, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this.iCateId = paramInt1;
    this.strCateKey = paramString1;
    this.strCateName = paramString2;
    this.vecItem = paramArrayList;
    this.iSQInitShowCount = paramInt2;
    this.iQZInitShowCount = paramInt3;
    this.uiTotalItems = paramLong1;
    this.vecBanner = paramArrayList1;
    this.strDescription = paramString3;
    this.stThumb = paramMaterialFile1;
    this.stBanner = paramMaterialFile2;
    this.uiSettleTime = paramLong2;
    this.strTraceInfo = paramString4;
    this.strExtFields = paramArrayOfByte;
    this.mapExtInfo = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCateId = paramJceInputStream.read(this.iCateId, 0, true);
    this.strCateKey = paramJceInputStream.readString(1, false);
    this.strCateName = paramJceInputStream.readString(2, false);
    this.vecItem = ((ArrayList)paramJceInputStream.read(cache_vecItem, 3, false));
    this.iSQInitShowCount = paramJceInputStream.read(this.iSQInitShowCount, 4, false);
    this.iQZInitShowCount = paramJceInputStream.read(this.iQZInitShowCount, 5, false);
    this.uiTotalItems = paramJceInputStream.read(this.uiTotalItems, 6, false);
    this.vecBanner = ((ArrayList)paramJceInputStream.read(cache_vecBanner, 7, false));
    this.strDescription = paramJceInputStream.readString(8, false);
    this.stThumb = ((MaterialFile)paramJceInputStream.read(cache_stThumb, 9, false));
    this.stBanner = ((MaterialFile)paramJceInputStream.read(cache_stBanner, 10, false));
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 11, false);
    this.strTraceInfo = paramJceInputStream.readString(12, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 13, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 14, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCateId, 0);
    if (this.strCateKey != null) {
      paramJceOutputStream.write(this.strCateKey, 1);
    }
    if (this.strCateName != null) {
      paramJceOutputStream.write(this.strCateName, 2);
    }
    if (this.vecItem != null) {
      paramJceOutputStream.write(this.vecItem, 3);
    }
    paramJceOutputStream.write(this.iSQInitShowCount, 4);
    paramJceOutputStream.write(this.iQZInitShowCount, 5);
    paramJceOutputStream.write(this.uiTotalItems, 6);
    if (this.vecBanner != null) {
      paramJceOutputStream.write(this.vecBanner, 7);
    }
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 8);
    }
    if (this.stThumb != null) {
      paramJceOutputStream.write(this.stThumb, 9);
    }
    if (this.stBanner != null) {
      paramJceOutputStream.write(this.stBanner, 10);
    }
    paramJceOutputStream.write(this.uiSettleTime, 11);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 12);
    }
    if (this.strExtFields != null) {
      paramJceOutputStream.write(this.strExtFields, 13);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialCate
 * JD-Core Version:    0.7.0.1
 */