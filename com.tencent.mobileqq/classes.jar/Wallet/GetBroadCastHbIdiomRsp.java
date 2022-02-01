package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class GetBroadCastHbIdiomRsp
  extends JceStruct
{
  static Map<String, BroadCastInfo> cache_sendlistIdiomInfoDict = new HashMap();
  public Map<String, BroadCastInfo> sendlistIdiomInfoDict = null;
  
  static
  {
    BroadCastInfo localBroadCastInfo = new BroadCastInfo();
    cache_sendlistIdiomInfoDict.put("", localBroadCastInfo);
  }
  
  public GetBroadCastHbIdiomRsp() {}
  
  public GetBroadCastHbIdiomRsp(Map<String, BroadCastInfo> paramMap)
  {
    this.sendlistIdiomInfoDict = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sendlistIdiomInfoDict = ((Map)paramJceInputStream.read(cache_sendlistIdiomInfoDict, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Map localMap = this.sendlistIdiomInfoDict;
    if (localMap != null) {
      paramJceOutputStream.write(localMap, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetBroadCastHbIdiomRsp
 * JD-Core Version:    0.7.0.1
 */