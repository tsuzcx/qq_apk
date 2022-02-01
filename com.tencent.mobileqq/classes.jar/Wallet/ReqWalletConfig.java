package Wallet;

import LBS.LBSInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class ReqWalletConfig
  extends JceStruct
{
  static LBSInfo cache_lbsInfo = new LBSInfo();
  static Map<String, String> cache_mParameter = new HashMap();
  public String adcode = "";
  public String commonMsg = "";
  public int iNetType = 0;
  public LBSInfo lbsInfo = null;
  public Map<String, String> mParameter = null;
  public String platform = "";
  public long reqType = 0L;
  public long seriesNo = 0L;
  public long uin = 0L;
  public String version = "";
  
  static
  {
    cache_mParameter.put("", "");
  }
  
  public static ReqWalletConfig createReq(long paramLong1, long paramLong2, long paramLong3, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3, int paramInt)
  {
    ReqWalletConfig localReqWalletConfig = new ReqWalletConfig();
    localReqWalletConfig.reqType = paramLong1;
    localReqWalletConfig.uin = paramLong2;
    localReqWalletConfig.platform = paramString2;
    localReqWalletConfig.version = paramString3;
    localReqWalletConfig.iNetType = paramInt;
    localReqWalletConfig.seriesNo = paramLong3;
    if (!TextUtils.isEmpty(paramString1)) {
      localReqWalletConfig.commonMsg = paramString1;
    }
    if (paramMap != null) {
      localReqWalletConfig.mParameter = paramMap;
    }
    return localReqWalletConfig;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.reqType = paramJceInputStream.read(this.reqType, 0, true);
    this.uin = paramJceInputStream.read(this.uin, 1, false);
    this.platform = paramJceInputStream.readString(2, false);
    this.version = paramJceInputStream.readString(3, false);
    this.iNetType = paramJceInputStream.read(this.iNetType, 4, false);
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 5, false));
    this.seriesNo = paramJceInputStream.read(this.seriesNo, 6, false);
    this.commonMsg = paramJceInputStream.readString(7, false);
    this.mParameter = ((Map)paramJceInputStream.read(cache_mParameter, 8, false));
    this.adcode = paramJceInputStream.readString(9, false);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReqWalletConfig{reqType=");
    localStringBuilder.append(this.reqType);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(", platform='");
    localStringBuilder.append(this.platform);
    localStringBuilder.append('\'');
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iNetType=");
    localStringBuilder.append(this.iNetType);
    localStringBuilder.append(", seriesNo=");
    localStringBuilder.append(this.seriesNo);
    localStringBuilder.append(", commonMsg='");
    localStringBuilder.append(this.commonMsg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mParameter=");
    localStringBuilder.append(this.mParameter);
    localStringBuilder.append(", adcode='");
    localStringBuilder.append(this.adcode);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqType, 0);
    paramJceOutputStream.write(this.uin, 1);
    Object localObject = this.platform;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    localObject = this.version;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    paramJceOutputStream.write(this.iNetType, 4);
    localObject = this.lbsInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    paramJceOutputStream.write(this.seriesNo, 6);
    localObject = this.commonMsg;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 7);
    }
    localObject = this.mParameter;
    if (localObject != null) {
      paramJceOutputStream.write((Map)localObject, 8);
    }
    localObject = this.adcode;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.ReqWalletConfig
 * JD-Core Version:    0.7.0.1
 */