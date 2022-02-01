package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class CGetMoreRsp
  extends JceStruct
{
  static Map<String, String> cache_extParams;
  static ArrayList<ItemDisDetail> cache_itemList = new ArrayList();
  public String errmsg = "";
  public Map<String, String> extParams = null;
  public int isListEnd = 0;
  public ArrayList<ItemDisDetail> itemList = null;
  public int nextIndex = 0;
  public int ret = 0;
  public long ruleid = 0L;
  
  static
  {
    ItemDisDetail localItemDisDetail = new ItemDisDetail();
    cache_itemList.add(localItemDisDetail);
    cache_extParams = new HashMap();
    cache_extParams.put("", "");
  }
  
  public CGetMoreRsp() {}
  
  public CGetMoreRsp(int paramInt1, String paramString, int paramInt2, int paramInt3, ArrayList<ItemDisDetail> paramArrayList, long paramLong, Map<String, String> paramMap)
  {
    this.ret = paramInt1;
    this.errmsg = paramString;
    this.nextIndex = paramInt2;
    this.isListEnd = paramInt3;
    this.itemList = paramArrayList;
    this.ruleid = paramLong;
    this.extParams = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.errmsg = paramJceInputStream.readString(1, false);
    this.nextIndex = paramJceInputStream.read(this.nextIndex, 2, false);
    this.isListEnd = paramJceInputStream.read(this.isListEnd, 3, false);
    this.itemList = ((ArrayList)paramJceInputStream.read(cache_itemList, 4, false));
    this.ruleid = paramJceInputStream.read(this.ruleid, 5, false);
    this.extParams = ((Map)paramJceInputStream.read(cache_extParams, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.errmsg != null) {
      paramJceOutputStream.write(this.errmsg, 1);
    }
    paramJceOutputStream.write(this.nextIndex, 2);
    paramJceOutputStream.write(this.isListEnd, 3);
    if (this.itemList != null) {
      paramJceOutputStream.write(this.itemList, 4);
    }
    paramJceOutputStream.write(this.ruleid, 5);
    if (this.extParams != null) {
      paramJceOutputStream.write(this.extParams, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QC.CGetMoreRsp
 * JD-Core Version:    0.7.0.1
 */