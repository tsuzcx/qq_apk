package FACADE_DIY;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class BatchGetFacadeReq
  extends JceStruct
{
  static Map<Long, GetFacadeReqExt> cache_ext;
  static ArrayList<Long> cache_uins = new ArrayList();
  public Map<Long, GetFacadeReqExt> ext = null;
  public long loginUin = 0L;
  public int needElementInfo = 0;
  public String qua = "";
  public ArrayList<Long> uins = null;
  
  static
  {
    Long localLong = Long.valueOf(0L);
    cache_uins.add(localLong);
    cache_ext = new HashMap();
    GetFacadeReqExt localGetFacadeReqExt = new GetFacadeReqExt();
    cache_ext.put(localLong, localGetFacadeReqExt);
  }
  
  public BatchGetFacadeReq() {}
  
  public BatchGetFacadeReq(ArrayList<Long> paramArrayList, String paramString, int paramInt, Map<Long, GetFacadeReqExt> paramMap, long paramLong)
  {
    this.uins = paramArrayList;
    this.qua = paramString;
    this.needElementInfo = paramInt;
    this.ext = paramMap;
    this.loginUin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uins = ((ArrayList)paramJceInputStream.read(cache_uins, 0, false));
    this.qua = paramJceInputStream.readString(1, false);
    this.needElementInfo = paramJceInputStream.read(this.needElementInfo, 2, false);
    this.ext = ((Map)paramJceInputStream.read(cache_ext, 3, false));
    this.loginUin = paramJceInputStream.read(this.loginUin, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.uins;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 0);
    }
    localObject = this.qua;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 1);
    }
    paramJceOutputStream.write(this.needElementInfo, 2);
    localObject = this.ext;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 3);
    }
    paramJceOutputStream.write(this.loginUin, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FACADE_DIY.BatchGetFacadeReq
 * JD-Core Version:    0.7.0.1
 */