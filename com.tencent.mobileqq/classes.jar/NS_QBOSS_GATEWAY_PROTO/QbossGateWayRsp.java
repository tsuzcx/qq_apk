package NS_QBOSS_GATEWAY_PROTO;

import BOSSStrategyCenter.tAdvDesc;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class QbossGateWayRsp
  extends JceStruct
{
  static Map<Integer, ArrayList<tAdvDesc>> cache_mapAdv = new HashMap();
  public int iRet = 0;
  public Map<Integer, ArrayList<tAdvDesc>> mapAdv = null;
  public String strMsg = "";
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new tAdvDesc());
    cache_mapAdv.put(Integer.valueOf(0), localArrayList);
  }
  
  public QbossGateWayRsp() {}
  
  public QbossGateWayRsp(int paramInt, String paramString, Map<Integer, ArrayList<tAdvDesc>> paramMap)
  {
    this.iRet = paramInt;
    this.strMsg = paramString;
    this.mapAdv = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.strMsg = paramJceInputStream.readString(1, true);
    this.mapAdv = ((Map)paramJceInputStream.read(cache_mapAdv, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.strMsg, 1);
    paramJceOutputStream.write(this.mapAdv, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QBOSS_GATEWAY_PROTO.QbossGateWayRsp
 * JD-Core Version:    0.7.0.1
 */