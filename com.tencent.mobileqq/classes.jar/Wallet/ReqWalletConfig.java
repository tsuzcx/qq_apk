package Wallet;

import LBS.LBSInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.HashMap;
import java.util.Map;

public final class ReqWalletConfig
  extends JceStruct
{
  static LBSInfo cache_lbsInfo = new LBSInfo();
  static Map<String, String> cache_mParameter = new HashMap();
  public String adcode = "";
  public String commonMsg = "";
  public int iNetType;
  public LBSInfo lbsInfo;
  public Map<String, String> mParameter;
  public String platform = "";
  public long reqType;
  public long seriesNo;
  public long uin;
  public String version = "";
  
  static
  {
    cache_mParameter.put("", "");
  }
  
  public static ReqWalletConfig createReq(long paramLong1, long paramLong2, long paramLong3, String paramString, Map<String, String> paramMap)
  {
    ReqWalletConfig localReqWalletConfig = new ReqWalletConfig();
    localReqWalletConfig.reqType = paramLong1;
    localReqWalletConfig.uin = paramLong2;
    localReqWalletConfig.platform = ("Android|" + DeviceInfoUtil.getDeviceOSVersion() + "|" + DeviceInfoUtil.getModel());
    localReqWalletConfig.version = DeviceInfoUtil.getQQVersion();
    localReqWalletConfig.iNetType = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getContext());
    localReqWalletConfig.seriesNo = paramLong3;
    if (!TextUtils.isEmpty(paramString)) {
      localReqWalletConfig.commonMsg = paramString;
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
    return "ReqWalletConfig{reqType=" + this.reqType + ", uin=" + this.uin + ", platform='" + this.platform + '\'' + ", version='" + this.version + '\'' + ", iNetType=" + this.iNetType + ", seriesNo=" + this.seriesNo + ", commonMsg='" + this.commonMsg + '\'' + ", mParameter=" + this.mParameter + ", adcode='" + this.adcode + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.reqType, 0);
    paramJceOutputStream.write(this.uin, 1);
    if (this.platform != null) {
      paramJceOutputStream.write(this.platform, 2);
    }
    if (this.version != null) {
      paramJceOutputStream.write(this.version, 3);
    }
    paramJceOutputStream.write(this.iNetType, 4);
    if (this.lbsInfo != null) {
      paramJceOutputStream.write(this.lbsInfo, 5);
    }
    paramJceOutputStream.write(this.seriesNo, 6);
    if (this.commonMsg != null) {
      paramJceOutputStream.write(this.commonMsg, 7);
    }
    if (this.mParameter != null) {
      paramJceOutputStream.write(this.mParameter, 8);
    }
    if (this.adcode != null) {
      paramJceOutputStream.write(this.adcode, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.ReqWalletConfig
 * JD-Core Version:    0.7.0.1
 */