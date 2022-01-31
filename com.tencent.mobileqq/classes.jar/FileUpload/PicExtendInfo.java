package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PicExtendInfo
  extends JceStruct
{
  static Map<String, String> cache_mapExif;
  static Map<String, String> cache_mapParams;
  static ArrayList<QuanInfo> cache_vQuanInfo = new ArrayList();
  public int iEffect = 0;
  public Map<String, String> mapExif = null;
  public Map<String, String> mapParams = null;
  public String sUserDefineSource = "";
  public ArrayList<QuanInfo> vQuanInfo = null;
  
  static
  {
    QuanInfo localQuanInfo = new QuanInfo();
    cache_vQuanInfo.add(localQuanInfo);
    cache_mapExif = new HashMap();
    cache_mapExif.put("", "");
    cache_mapParams = new HashMap();
    cache_mapParams.put("", "");
  }
  
  public PicExtendInfo() {}
  
  public PicExtendInfo(int paramInt, ArrayList<QuanInfo> paramArrayList, Map<String, String> paramMap1, String paramString, Map<String, String> paramMap2)
  {
    this.iEffect = paramInt;
    this.vQuanInfo = paramArrayList;
    this.mapExif = paramMap1;
    this.sUserDefineSource = paramString;
    this.mapParams = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iEffect = paramJceInputStream.read(this.iEffect, 0, false);
    this.vQuanInfo = ((ArrayList)paramJceInputStream.read(cache_vQuanInfo, 1, false));
    this.mapExif = ((Map)paramJceInputStream.read(cache_mapExif, 2, false));
    this.sUserDefineSource = paramJceInputStream.readString(3, false);
    this.mapParams = ((Map)paramJceInputStream.read(cache_mapParams, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iEffect, 0);
    if (this.vQuanInfo != null) {
      paramJceOutputStream.write(this.vQuanInfo, 1);
    }
    if (this.mapExif != null) {
      paramJceOutputStream.write(this.mapExif, 2);
    }
    if (this.sUserDefineSource != null) {
      paramJceOutputStream.write(this.sUserDefineSource, 3);
    }
    if (this.mapParams != null) {
      paramJceOutputStream.write(this.mapParams, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.PicExtendInfo
 * JD-Core Version:    0.7.0.1
 */