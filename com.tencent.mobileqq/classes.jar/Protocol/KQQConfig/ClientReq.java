package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ClientReq
  extends JceStruct
{
  static ClientUinConfReq cache_stClientUinConfReq;
  static GetServerListReq cache_stGetServerListReq;
  static GetResourceReqV2 cache_stResourceReqV2;
  static SDKUpgradeReq cache_stSDKUpgradeReq;
  static SDKConfReq cache_stSdkConfReq;
  static ReqUserInfo cache_stUserInfo;
  public int iCmdType = 0;
  public ClientUinConfReq stClientUinConfReq = null;
  public GetServerListReq stGetServerListReq = null;
  public GetResourceReqV2 stResourceReqV2 = null;
  public SDKUpgradeReq stSDKUpgradeReq = null;
  public SDKConfReq stSdkConfReq = null;
  public ReqUserInfo stUserInfo = null;
  
  public ClientReq() {}
  
  public ClientReq(int paramInt, SDKUpgradeReq paramSDKUpgradeReq, SDKConfReq paramSDKConfReq, GetServerListReq paramGetServerListReq, ReqUserInfo paramReqUserInfo, GetResourceReqV2 paramGetResourceReqV2, ClientUinConfReq paramClientUinConfReq)
  {
    this.iCmdType = paramInt;
    this.stSDKUpgradeReq = paramSDKUpgradeReq;
    this.stSdkConfReq = paramSDKConfReq;
    this.stGetServerListReq = paramGetServerListReq;
    this.stUserInfo = paramReqUserInfo;
    this.stResourceReqV2 = paramGetResourceReqV2;
    this.stClientUinConfReq = paramClientUinConfReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iCmdType = paramJceInputStream.read(this.iCmdType, 1, true);
    if (cache_stSDKUpgradeReq == null) {
      cache_stSDKUpgradeReq = new SDKUpgradeReq();
    }
    this.stSDKUpgradeReq = ((SDKUpgradeReq)paramJceInputStream.read(cache_stSDKUpgradeReq, 2, false));
    if (cache_stSdkConfReq == null) {
      cache_stSdkConfReq = new SDKConfReq();
    }
    this.stSdkConfReq = ((SDKConfReq)paramJceInputStream.read(cache_stSdkConfReq, 3, false));
    if (cache_stGetServerListReq == null) {
      cache_stGetServerListReq = new GetServerListReq();
    }
    this.stGetServerListReq = ((GetServerListReq)paramJceInputStream.read(cache_stGetServerListReq, 4, false));
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 5, false));
    if (cache_stResourceReqV2 == null) {
      cache_stResourceReqV2 = new GetResourceReqV2();
    }
    this.stResourceReqV2 = ((GetResourceReqV2)paramJceInputStream.read(cache_stResourceReqV2, 6, false));
    if (cache_stClientUinConfReq == null) {
      cache_stClientUinConfReq = new ClientUinConfReq();
    }
    this.stClientUinConfReq = ((ClientUinConfReq)paramJceInputStream.read(cache_stClientUinConfReq, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iCmdType, 1);
    Object localObject = this.stSDKUpgradeReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
    localObject = this.stSdkConfReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.stGetServerListReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
    localObject = this.stUserInfo;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 5);
    }
    localObject = this.stResourceReqV2;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 6);
    }
    localObject = this.stClientUinConfReq;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     protocol.KQQConfig.ClientReq
 * JD-Core Version:    0.7.0.1
 */