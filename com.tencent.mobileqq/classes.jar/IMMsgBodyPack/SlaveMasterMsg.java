package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SlaveMasterMsg
  extends JceStruct
{
  static ArrayList cache_vMarketFace;
  static byte[] cache_vOrigMsg;
  static byte[] cache_vReserved;
  public long lFromUin;
  public long lToUin;
  public long uCmd;
  public long uFromInstId;
  public long uLastChangeTime;
  public long uMsgType;
  public long uSeq;
  public long uSuperQQBubbleId;
  public long uToInstId;
  public ArrayList vMarketFace;
  public byte[] vOrigMsg;
  public byte[] vReserved;
  public short wFromApp;
  public short wToApp;
  
  public SlaveMasterMsg() {}
  
  public SlaveMasterMsg(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short paramShort1, long paramLong5, long paramLong6, short paramShort2, long paramLong7, byte[] paramArrayOfByte1, long paramLong8, byte[] paramArrayOfByte2, ArrayList paramArrayList, long paramLong9)
  {
    this.uMsgType = paramLong1;
    this.uCmd = paramLong2;
    this.uSeq = paramLong3;
    this.lFromUin = paramLong4;
    this.wFromApp = paramShort1;
    this.uFromInstId = paramLong5;
    this.lToUin = paramLong6;
    this.wToApp = paramShort2;
    this.uToInstId = paramLong7;
    this.vOrigMsg = paramArrayOfByte1;
    this.uLastChangeTime = paramLong8;
    this.vReserved = paramArrayOfByte2;
    this.vMarketFace = paramArrayList;
    this.uSuperQQBubbleId = paramLong9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMsgType = paramJceInputStream.read(this.uMsgType, 0, false);
    this.uCmd = paramJceInputStream.read(this.uCmd, 1, false);
    this.uSeq = paramJceInputStream.read(this.uSeq, 2, false);
    this.lFromUin = paramJceInputStream.read(this.lFromUin, 3, false);
    this.wFromApp = paramJceInputStream.read(this.wFromApp, 4, false);
    this.uFromInstId = paramJceInputStream.read(this.uFromInstId, 5, false);
    this.lToUin = paramJceInputStream.read(this.lToUin, 6, false);
    this.wToApp = paramJceInputStream.read(this.wToApp, 7, false);
    this.uToInstId = paramJceInputStream.read(this.uToInstId, 8, false);
    if (cache_vOrigMsg == null)
    {
      cache_vOrigMsg = (byte[])new byte[1];
      ((byte[])cache_vOrigMsg)[0] = 0;
    }
    this.vOrigMsg = ((byte[])paramJceInputStream.read(cache_vOrigMsg, 9, false));
    this.uLastChangeTime = paramJceInputStream.read(this.uLastChangeTime, 10, false);
    if (cache_vReserved == null)
    {
      cache_vReserved = (byte[])new byte[1];
      ((byte[])cache_vReserved)[0] = 0;
    }
    this.vReserved = ((byte[])paramJceInputStream.read(cache_vReserved, 11, false));
    if (cache_vMarketFace == null)
    {
      cache_vMarketFace = new ArrayList();
      MarketFaceInfo localMarketFaceInfo = new MarketFaceInfo();
      cache_vMarketFace.add(localMarketFaceInfo);
    }
    this.vMarketFace = ((ArrayList)paramJceInputStream.read(cache_vMarketFace, 12, false));
    this.uSuperQQBubbleId = paramJceInputStream.read(this.uSuperQQBubbleId, 13, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMsgType, 0);
    paramJceOutputStream.write(this.uCmd, 1);
    paramJceOutputStream.write(this.uSeq, 2);
    paramJceOutputStream.write(this.lFromUin, 3);
    paramJceOutputStream.write(this.wFromApp, 4);
    paramJceOutputStream.write(this.uFromInstId, 5);
    paramJceOutputStream.write(this.lToUin, 6);
    paramJceOutputStream.write(this.wToApp, 7);
    paramJceOutputStream.write(this.uToInstId, 8);
    if (this.vOrigMsg != null) {
      paramJceOutputStream.write(this.vOrigMsg, 9);
    }
    paramJceOutputStream.write(this.uLastChangeTime, 10);
    if (this.vReserved != null) {
      paramJceOutputStream.write(this.vReserved, 11);
    }
    if (this.vMarketFace != null) {
      paramJceOutputStream.write(this.vMarketFace, 12);
    }
    paramJceOutputStream.write(this.uSuperQQBubbleId, 13);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     IMMsgBodyPack.SlaveMasterMsg
 * JD-Core Version:    0.7.0.1
 */