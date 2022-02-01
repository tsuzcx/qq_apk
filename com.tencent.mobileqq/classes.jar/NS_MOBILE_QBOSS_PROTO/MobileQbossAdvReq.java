package NS_MOBILE_QBOSS_PROTO;

import BOSSStrategyCenter.tAdvAppInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class MobileQbossAdvReq
  extends JceStruct
{
  static Map<Integer, SceneExt> cache_mapSceneExt;
  static ArrayList<tAdvAppInfo> cache_vecReqApp;
  public int iNeedExposeTime;
  public int iPullAsExposeOper;
  public int iReqFlag;
  public String idfa = "";
  public Map<Integer, SceneExt> mapSceneExt;
  public long uiUin;
  public ArrayList<tAdvAppInfo> vecReqApp;
  
  public MobileQbossAdvReq() {}
  
  public MobileQbossAdvReq(long paramLong, ArrayList<tAdvAppInfo> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString, Map<Integer, SceneExt> paramMap)
  {
    this.uiUin = paramLong;
    this.vecReqApp = paramArrayList;
    this.iPullAsExposeOper = paramInt1;
    this.iNeedExposeTime = paramInt2;
    this.iReqFlag = paramInt3;
    this.idfa = paramString;
    this.mapSceneExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiUin = paramJceInputStream.read(this.uiUin, 0, true);
    Object localObject;
    if (cache_vecReqApp == null)
    {
      cache_vecReqApp = new ArrayList();
      localObject = new tAdvAppInfo();
      cache_vecReqApp.add(localObject);
    }
    this.vecReqApp = ((ArrayList)paramJceInputStream.read(cache_vecReqApp, 1, true));
    this.iPullAsExposeOper = paramJceInputStream.read(this.iPullAsExposeOper, 2, false);
    this.iNeedExposeTime = paramJceInputStream.read(this.iNeedExposeTime, 3, false);
    this.iReqFlag = paramJceInputStream.read(this.iReqFlag, 4, false);
    this.idfa = paramJceInputStream.readString(5, false);
    if (cache_mapSceneExt == null)
    {
      cache_mapSceneExt = new HashMap();
      localObject = new SceneExt();
      cache_mapSceneExt.put(Integer.valueOf(0), localObject);
    }
    this.mapSceneExt = ((Map)paramJceInputStream.read(cache_mapSceneExt, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiUin, 0);
    paramJceOutputStream.write(this.vecReqApp, 1);
    paramJceOutputStream.write(this.iPullAsExposeOper, 2);
    paramJceOutputStream.write(this.iNeedExposeTime, 3);
    paramJceOutputStream.write(this.iReqFlag, 4);
    Object localObject = this.idfa;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 5);
    }
    localObject = this.mapSceneExt;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.MobileQbossAdvReq
 * JD-Core Version:    0.7.0.1
 */