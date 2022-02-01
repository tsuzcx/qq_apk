package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class st_Games_OpData
  extends JceStruct
{
  static ArrayList<Long> cache_vcDataSec = new ArrayList();
  public String uBattleNickName = "";
  public long uBattleuin = 0L;
  public long uOpuin = 0L;
  public ArrayList<Long> vcDataSec = null;
  
  static
  {
    cache_vcDataSec.add(Long.valueOf(0L));
  }
  
  public st_Games_OpData() {}
  
  public st_Games_OpData(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, String paramString)
  {
    this.uOpuin = paramLong1;
    this.vcDataSec = paramArrayList;
    this.uBattleuin = paramLong2;
    this.uBattleNickName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uOpuin = paramJceInputStream.read(this.uOpuin, 0, false);
    this.vcDataSec = ((ArrayList)paramJceInputStream.read(cache_vcDataSec, 1, false));
    this.uBattleuin = paramJceInputStream.read(this.uBattleuin, 2, false);
    this.uBattleNickName = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uOpuin, 0);
    Object localObject = this.vcDataSec;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 1);
    }
    paramJceOutputStream.write(this.uBattleuin, 2);
    localObject = this.uBattleNickName;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS_GAMES.st_Games_OpData
 * JD-Core Version:    0.7.0.1
 */