package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
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
  public int iCateId = 0;
  public int iQZInitShowCount = 0;
  public int iSQInitShowCount = 0;
  public Map<String, String> mapExtInfo = null;
  public MaterialFile stBanner = null;
  public MaterialFile stThumb = null;
  public String strCateKey = "";
  public String strCateName = "";
  public String strDescription = "";
  public byte[] strExtFields = null;
  public String strTraceInfo = "";
  public long uiSettleTime = 0L;
  public long uiTotalItems = 0L;
  public ArrayList<OperBanner> vecBanner = null;
  public ArrayList<MaterialItem> vecItem = null;
  
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
    Object localObject = this.strCateKey;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    localObject = this.strCateName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.vecItem;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 3);
    }
    paramJceOutputStream.write(this.iSQInitShowCount, 4);
    paramJceOutputStream.write(this.iQZInitShowCount, 5);
    paramJceOutputStream.write(this.uiTotalItems, 6);
    localObject = this.vecBanner;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.strDescription;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.stThumb;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 9);
    }
    localObject = this.stBanner;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 10);
    }
    paramJceOutputStream.write(this.uiSettleTime, 11);
    localObject = this.strTraceInfo;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 12);
    }
    localObject = this.strExtFields;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 13);
    }
    localObject = this.mapExtInfo;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialCate
 * JD-Core Version:    0.7.0.1
 */