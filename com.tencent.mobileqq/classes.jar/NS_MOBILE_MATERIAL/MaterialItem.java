package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MaterialItem
  extends JceStruct
{
  static Map<String, String> cache_mapExtInfo;
  static MaterialFile cache_stBanner;
  static MaterialFile cache_stExtFile1 = new MaterialFile();
  static MaterialFile cache_stExtFile2 = new MaterialFile();
  static MaterialFile cache_stThumb;
  static byte[] cache_strExtFields;
  static ArrayList<MaterialFile> cache_vecFile = new ArrayList();
  public int iItemId = 0;
  public int iItemType = 0;
  public int iPrice = 0;
  public int iTypeId = 0;
  public Map<String, String> mapExtInfo = null;
  public MaterialFile stBanner = null;
  public MaterialFile stExtFile1 = null;
  public MaterialFile stExtFile2 = null;
  public MaterialFile stThumb = null;
  public String strDescription = "";
  public byte[] strExtFields = null;
  public String strItemName = "";
  public String strItemSummary = "";
  public String strJumpUrl = "";
  public String strTraceInfo = "";
  public long uiSettleTime = 0L;
  public ArrayList<MaterialFile> vecFile = null;
  
  static
  {
    MaterialFile localMaterialFile = new MaterialFile();
    cache_vecFile.add(localMaterialFile);
    cache_stThumb = new MaterialFile();
    cache_stBanner = new MaterialFile();
    cache_strExtFields = (byte[])new byte[1];
    ((byte[])cache_strExtFields)[0] = 0;
    cache_mapExtInfo = new HashMap();
    cache_mapExtInfo.put("", "");
  }
  
  public MaterialItem() {}
  
  public MaterialItem(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, ArrayList<MaterialFile> paramArrayList, String paramString2, String paramString3, MaterialFile paramMaterialFile1, MaterialFile paramMaterialFile2, long paramLong, String paramString4, String paramString5, byte[] paramArrayOfByte, Map<String, String> paramMap, MaterialFile paramMaterialFile3, MaterialFile paramMaterialFile4)
  {
    this.iItemId = paramInt1;
    this.iTypeId = paramInt2;
    this.iItemType = paramInt3;
    this.strItemName = paramString1;
    this.iPrice = paramInt4;
    this.vecFile = paramArrayList;
    this.strItemSummary = paramString2;
    this.strDescription = paramString3;
    this.stThumb = paramMaterialFile1;
    this.stBanner = paramMaterialFile2;
    this.uiSettleTime = paramLong;
    this.strTraceInfo = paramString4;
    this.strJumpUrl = paramString5;
    this.strExtFields = paramArrayOfByte;
    this.mapExtInfo = paramMap;
    this.stExtFile1 = paramMaterialFile3;
    this.stExtFile2 = paramMaterialFile4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.iTypeId = paramJceInputStream.read(this.iTypeId, 1, true);
    this.iItemType = paramJceInputStream.read(this.iItemType, 2, true);
    this.strItemName = paramJceInputStream.readString(3, true);
    this.iPrice = paramJceInputStream.read(this.iPrice, 4, false);
    this.vecFile = ((ArrayList)paramJceInputStream.read(cache_vecFile, 5, false));
    this.strItemSummary = paramJceInputStream.readString(6, false);
    this.strDescription = paramJceInputStream.readString(7, false);
    this.stThumb = ((MaterialFile)paramJceInputStream.read(cache_stThumb, 8, false));
    this.stBanner = ((MaterialFile)paramJceInputStream.read(cache_stBanner, 9, false));
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 10, false);
    this.strTraceInfo = paramJceInputStream.readString(11, false);
    this.strJumpUrl = paramJceInputStream.readString(12, false);
    this.strExtFields = ((byte[])paramJceInputStream.read(cache_strExtFields, 13, false));
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 14, false));
    this.stExtFile1 = ((MaterialFile)paramJceInputStream.read(cache_stExtFile1, 15, false));
    this.stExtFile2 = ((MaterialFile)paramJceInputStream.read(cache_stExtFile2, 16, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    paramJceOutputStream.write(this.iTypeId, 1);
    paramJceOutputStream.write(this.iItemType, 2);
    paramJceOutputStream.write(this.strItemName, 3);
    paramJceOutputStream.write(this.iPrice, 4);
    if (this.vecFile != null) {
      paramJceOutputStream.write(this.vecFile, 5);
    }
    if (this.strItemSummary != null) {
      paramJceOutputStream.write(this.strItemSummary, 6);
    }
    if (this.strDescription != null) {
      paramJceOutputStream.write(this.strDescription, 7);
    }
    if (this.stThumb != null) {
      paramJceOutputStream.write(this.stThumb, 8);
    }
    if (this.stBanner != null) {
      paramJceOutputStream.write(this.stBanner, 9);
    }
    paramJceOutputStream.write(this.uiSettleTime, 10);
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 11);
    }
    if (this.strJumpUrl != null) {
      paramJceOutputStream.write(this.strJumpUrl, 12);
    }
    if (this.strExtFields != null) {
      paramJceOutputStream.write(this.strExtFields, 13);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 14);
    }
    if (this.stExtFile1 != null) {
      paramJceOutputStream.write(this.stExtFile1, 15);
    }
    if (this.stExtFile2 != null) {
      paramJceOutputStream.write(this.stExtFile2, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MATERIAL.MaterialItem
 * JD-Core Version:    0.7.0.1
 */