package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class SvcResponseGetMsgV2
  extends JceStruct
{
  static int cache_cSyncFlag;
  static ArrayList<AccostMsg> cache_vAccostMsg;
  static byte[] cache_vCookies;
  static ArrayList<SvcGetMsgInfo> cache_vMsgInfos;
  static byte[] cache_vSyncCookie;
  static ArrayList<UinPairMsg> cache_vUinPairMsg;
  public byte cMoreMsg = 0;
  public byte cReplyCode = 0;
  public int cSyncFlag = 0;
  public int iAccostTotalUnread = 0;
  public long lUin = 0L;
  public short shSumMsg = 0;
  public String strResult = "";
  public int uMsgTime = 0;
  public ArrayList<AccostMsg> vAccostMsg = null;
  public byte[] vCookies = null;
  public ArrayList<SvcGetMsgInfo> vMsgInfos = null;
  public byte[] vSyncCookie = null;
  public ArrayList<UinPairMsg> vUinPairMsg = null;
  
  public SvcResponseGetMsgV2() {}
  
  public SvcResponseGetMsgV2(long paramLong, byte paramByte1, String paramString, int paramInt1, byte paramByte2, short paramShort, ArrayList<SvcGetMsgInfo> paramArrayList, ArrayList<AccostMsg> paramArrayList1, byte[] paramArrayOfByte1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, ArrayList<UinPairMsg> paramArrayList2)
  {
    this.lUin = paramLong;
    this.cReplyCode = paramByte1;
    this.strResult = paramString;
    this.uMsgTime = paramInt1;
    this.cMoreMsg = paramByte2;
    this.shSumMsg = paramShort;
    this.vMsgInfos = paramArrayList;
    this.vAccostMsg = paramArrayList1;
    this.vCookies = paramArrayOfByte1;
    this.iAccostTotalUnread = paramInt2;
    this.vSyncCookie = paramArrayOfByte2;
    this.cSyncFlag = paramInt3;
    this.vUinPairMsg = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
    this.uMsgTime = paramJceInputStream.read(this.uMsgTime, 3, true);
    this.cMoreMsg = paramJceInputStream.read(this.cMoreMsg, 4, true);
    this.shSumMsg = paramJceInputStream.read(this.shSumMsg, 5, true);
    Object localObject;
    if (cache_vMsgInfos == null)
    {
      cache_vMsgInfos = new ArrayList();
      localObject = new SvcGetMsgInfo();
      cache_vMsgInfos.add(localObject);
    }
    this.vMsgInfos = ((ArrayList)paramJceInputStream.read(cache_vMsgInfos, 6, true));
    if (cache_vAccostMsg == null)
    {
      cache_vAccostMsg = new ArrayList();
      localObject = new AccostMsg();
      cache_vAccostMsg.add(localObject);
    }
    this.vAccostMsg = ((ArrayList)paramJceInputStream.read(cache_vAccostMsg, 7, true));
    if (cache_vCookies == null)
    {
      cache_vCookies = (byte[])new byte[1];
      ((byte[])cache_vCookies)[0] = 0;
    }
    this.vCookies = ((byte[])paramJceInputStream.read(cache_vCookies, 8, false));
    this.iAccostTotalUnread = paramJceInputStream.read(this.iAccostTotalUnread, 9, false);
    if (cache_vSyncCookie == null)
    {
      cache_vSyncCookie = (byte[])new byte[1];
      ((byte[])cache_vSyncCookie)[0] = 0;
    }
    this.vSyncCookie = ((byte[])paramJceInputStream.read(cache_vSyncCookie, 10, false));
    this.cSyncFlag = paramJceInputStream.read(this.cSyncFlag, 11, false);
    if (cache_vUinPairMsg == null)
    {
      cache_vUinPairMsg = new ArrayList();
      localObject = new UinPairMsg();
      cache_vUinPairMsg.add(localObject);
    }
    this.vUinPairMsg = ((ArrayList)paramJceInputStream.read(cache_vUinPairMsg, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
    paramJceOutputStream.write(this.uMsgTime, 3);
    paramJceOutputStream.write(this.cMoreMsg, 4);
    paramJceOutputStream.write(this.shSumMsg, 5);
    paramJceOutputStream.write(this.vMsgInfos, 6);
    paramJceOutputStream.write(this.vAccostMsg, 7);
    Object localObject = this.vCookies;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 8);
    }
    paramJceOutputStream.write(this.iAccostTotalUnread, 9);
    localObject = this.vSyncCookie;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 10);
    }
    paramJceOutputStream.write(this.cSyncFlag, 11);
    localObject = this.vUinPairMsg;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.SvcResponseGetMsgV2
 * JD-Core Version:    0.7.0.1
 */