package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_games_req
  extends JceStruct
{
  static Map<String, String> cache_mapExt;
  static Map<Integer, String> cache_mapRsp;
  static st_Games_OpData cache_opData = new st_Games_OpData();
  public int iLastGamesRes = -1;
  public int iNextGamesStatus = -1;
  public int iType = -1;
  public Map<String, String> mapExt;
  public Map<Integer, String> mapRsp;
  public st_Games_OpData opData;
  
  static
  {
    cache_mapRsp = new HashMap();
    cache_mapRsp.put(Integer.valueOf(0), "");
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public mobile_feeds_games_req() {}
  
  public mobile_feeds_games_req(int paramInt1, int paramInt2, st_Games_OpData paramst_Games_OpData, int paramInt3, Map<Integer, String> paramMap, Map<String, String> paramMap1)
  {
    this.iType = paramInt1;
    this.iLastGamesRes = paramInt2;
    this.opData = paramst_Games_OpData;
    this.iNextGamesStatus = paramInt3;
    this.mapRsp = paramMap;
    this.mapExt = paramMap1;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iType = paramJceInputStream.read(this.iType, 0, true);
    this.iLastGamesRes = paramJceInputStream.read(this.iLastGamesRes, 1, false);
    this.opData = ((st_Games_OpData)paramJceInputStream.read(cache_opData, 2, false));
    this.iNextGamesStatus = paramJceInputStream.read(this.iNextGamesStatus, 3, false);
    this.mapRsp = ((Map)paramJceInputStream.read(cache_mapRsp, 4, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iType, 0);
    paramJceOutputStream.write(this.iLastGamesRes, 1);
    if (this.opData != null) {
      paramJceOutputStream.write(this.opData, 2);
    }
    paramJceOutputStream.write(this.iNextGamesStatus, 3);
    if (this.mapRsp != null) {
      paramJceOutputStream.write(this.mapRsp, 4);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS_GAMES.mobile_feeds_games_req
 * JD-Core Version:    0.7.0.1
 */