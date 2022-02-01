package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RspWalletConfig
  extends JceStruct
{
  public static final int ACTION_ALL_CHANGE = 0;
  public static final int ACTION_BATCH_CHANGE = 3;
  public static final int ACTION_INCRE_CHANGE = 2;
  public static final int ACTION_NOT_CHANGE = 1;
  public static int RET_SUCC;
  static Map<String, String> cache_mConfig = new HashMap();
  public int action = 0;
  public String commonMsg = "";
  public Map<String, String> mConfig = null;
  public int refreshTime = 0;
  public int refreshType = 0;
  public long reqType = 0L;
  public int result = 0;
  public long seriesNo = 0L;
  
  static
  {
    cache_mConfig.put("", "");
  }
  
  public RspWalletConfig() {}
  
  public RspWalletConfig(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, String paramString, Map<String, String> paramMap)
  {
    this.result = paramInt1;
    this.reqType = paramLong1;
    this.seriesNo = paramLong2;
    this.refreshType = paramInt2;
    this.refreshTime = paramInt3;
    this.action = paramInt4;
    this.commonMsg = paramString;
    this.mConfig = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.reqType = paramJceInputStream.read(this.reqType, 1, true);
    this.seriesNo = paramJceInputStream.read(this.seriesNo, 2, true);
    this.refreshType = paramJceInputStream.read(this.refreshType, 3, false);
    this.refreshTime = paramJceInputStream.read(this.refreshTime, 4, false);
    this.action = paramJceInputStream.read(this.action, 5, false);
    this.commonMsg = paramJceInputStream.readString(6, false);
    this.mConfig = ((Map)paramJceInputStream.read(cache_mConfig, 7, false));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RspWalletConfig{result=");
    localStringBuilder.append(this.result);
    localStringBuilder.append(", reqType=");
    localStringBuilder.append(this.reqType);
    localStringBuilder.append(", seriesNo=");
    localStringBuilder.append(this.seriesNo);
    localStringBuilder.append(", refreshType=");
    localStringBuilder.append(this.refreshType);
    localStringBuilder.append(", refreshTime=");
    localStringBuilder.append(this.refreshTime);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", commonMsg='");
    localStringBuilder.append(this.commonMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mConfig=");
    localStringBuilder.append(this.mConfig);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.reqType, 1);
    paramJceOutputStream.write(this.seriesNo, 2);
    paramJceOutputStream.write(this.refreshType, 3);
    paramJceOutputStream.write(this.refreshTime, 4);
    paramJceOutputStream.write(this.action, 5);
    Object localObject = this.commonMsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 6);
    }
    localObject = this.mConfig;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.RspWalletConfig
 * JD-Core Version:    0.7.0.1
 */