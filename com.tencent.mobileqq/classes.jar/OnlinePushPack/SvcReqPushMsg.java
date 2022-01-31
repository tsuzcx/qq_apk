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
  static Map cache_mPreviews;
  static ArrayList cache_vMsgInfos;
  static byte[] cache_vSyncCookie;
  static ArrayList cache_vUinPairMsg;
  public long lUin;
  public Map mPreviews;
  public int svrip;
  public long uMsgTime;
  public ArrayList vMsgInfos;
  public byte[] vSyncCookie;
  public ArrayList vUinPairMsg;
  public int wUserActive;
  
  public SvcReqPushMsg() {}
  
  public SvcReqPushMsg(long paramLong1, long paramLong2, ArrayList paramArrayList1, int paramInt1, byte[] paramArrayOfByte, ArrayList paramArrayList2, Map paramMap, int paramInt2)
  {
    this.lUin = paramLong1;
    this.uMsgTime = paramLong2;
    this.vMsgInfos = paramArrayList1;
    this.svrip = paramInt1;
    this.vSyncCookie = paramArrayOfByte;
    this.vUinPairMsg = paramArrayList2;
    this.mPreviews = paramMap;
    this.wUserActive = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 1, true);
    Object localObject;
    if (cache_vMsgInfos == null)
    {
      cache_vMsgInfos = new ArrayList();
      localObject = new MsgInfo();
      cache_vMsgInfos.add(localObject);
    }
    this.vMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vMsgInfos, 2, true));
    this.svrip = paramJceInputStream.read(this.svrip, 3, true);
    if (cache_vSyncCookie == null)
    {
      cache_vSyncCookie = (byte[])new byte[1];
      ((byte[])cache_vSyncCookie)[0] = 0;
    }
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 4, false));
    if (cache_vUinPairMsg == null)
    {
      cache_vUinPairMsg = new ArrayList();
      localObject = new UinPairMsg();
      cache_vUinPairMsg.add(localObject);
    }
    this.vUinPairMsg = ((ArrayList)paramJceInputStream.read(cache_vUinPairMsg, 5, false));
    if (cache_mPreviews == null)
    {
      cache_mPreviews = new HashMap();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      cache_mPreviews.put("", localObject);
    }
    this.mPreviews = ((Map)paramJceInputStream.read(cache_mPreviews, 6, false));
    this.wUserActive = paramJceInputStream.read(this.wUserActive, 7, false);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     OnlinePushPack.SvcReqPushMsg
 * JD-Core Version:    0.7.0.1
 */