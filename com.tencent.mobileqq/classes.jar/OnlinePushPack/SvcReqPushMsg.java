package OnlinePushPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class SvcReqPushMsg
  extends JceStruct
{
  static Map<String, byte[]> cache_mPreviews;
  static ArrayList<MsgInfo> cache_vMsgInfos = new ArrayList();
  static byte[] cache_vSyncCookie;
  static ArrayList<UinPairMsg> cache_vUinPairMsg;
  public long lUin;
  public Map<String, byte[]> mPreviews;
  public int svrip;
  public long uMsgTime;
  public ArrayList<MsgInfo> vMsgInfos;
  public byte[] vSyncCookie;
  public ArrayList<UinPairMsg> vUinPairMsg;
  public int wGeneralFlag;
  public int wUserActive;
  
  static
  {
    Object localObject = new MsgInfo();
    cache_vMsgInfos.add(localObject);
    cache_vSyncCookie = (byte[])new byte[1];
    ((byte[])cache_vSyncCookie)[0] = 0;
    cache_vUinPairMsg = new ArrayList();
    localObject = new UinPairMsg();
    cache_vUinPairMsg.add(localObject);
    cache_mPreviews = new HashMap();
    localObject = (byte[])new byte[1];
    ((byte[])localObject)[0] = 0;
    cache_mPreviews.put("", localObject);
  }
  
  public SvcReqPushMsg() {}
  
  public SvcReqPushMsg(long paramLong1, long paramLong2, ArrayList<MsgInfo> paramArrayList, int paramInt1, byte[] paramArrayOfByte, ArrayList<UinPairMsg> paramArrayList1, Map<String, byte[]> paramMap, int paramInt2, int paramInt3)
  {
    this.lUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.vMsgInfos = paramArrayList;
    this.svrip = paramInt1;
    this.vSyncCookie = paramArrayOfByte;
    this.vUinPairMsg = paramArrayList1;
    this.mPreviews = paramMap;
    this.wUserActive = paramInt2;
    this.wGeneralFlag = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    this.vMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vMsgInfos, 2, true));
    this.svrip = paramJceInputStream.read(this.svrip, 3, true);
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 4, false));
    this.vUinPairMsg = ((ArrayList)paramJceInputStream.read(cache_vUinPairMsg, 5, false));
    this.mPreviews = ((Map)paramJceInputStream.read(cache_mPreviews, 6, false));
    this.wUserActive = paramJceInputStream.read(this.wUserActive, 7, false);
    this.wGeneralFlag = paramJceInputStream.read(this.wGeneralFlag, 12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.uMsgTime, 1);
    paramJceOutputStream.write(this.vMsgInfos, 2);
    paramJceOutputStream.write(this.svrip, 3);
    if (this.vSyncCookie != null) {
      paramJceOutputStream.write(this.vSyncCookie, 4);
    }
    if (this.vUinPairMsg != null) {
      paramJceOutputStream.write(this.vUinPairMsg, 5);
    }
    if (this.mPreviews != null) {
      paramJceOutputStream.write(this.mPreviews, 6);
    }
    paramJceOutputStream.write(this.wUserActive, 7);
    paramJceOutputStream.write(this.wGeneralFlag, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     OnlinePushPack.SvcReqPushMsg
 * JD-Core Version:    0.7.0.1
 */