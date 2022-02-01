package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DCacheUserInfo
  extends JceStruct
{
  static byte[] cache_strBlackList;
  public byte cPushNbTimes = 0;
  public int iAtoRTimes = 0;
  public int iRtoATimes = 0;
  public int lTime = 0;
  public byte[] strBlackList = null;
  
  public DCacheUserInfo() {}
  
  public DCacheUserInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, byte paramByte)
  {
    this.strBlackList = paramArrayOfByte;
    this.lTime = paramInt1;
    this.iAtoRTimes = paramInt2;
    this.iRtoATimes = paramInt3;
    this.cPushNbTimes = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strBlackList == null)
    {
      cache_strBlackList = (byte[])new byte[1];
      ((byte[])cache_strBlackList)[0] = 0;
    }
    this.strBlackList = ((byte[])paramJceInputStream.read(cache_strBlackList, 0, true));
    this.lTime = paramJceInputStream.read(this.lTime, 1, false);
    this.iAtoRTimes = paramJceInputStream.read(this.iAtoRTimes, 2, false);
    this.iRtoATimes = paramJceInputStream.read(this.iRtoATimes, 3, false);
    this.cPushNbTimes = paramJceInputStream.read(this.cPushNbTimes, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strBlackList, 0);
    paramJceOutputStream.write(this.lTime, 1);
    paramJceOutputStream.write(this.iAtoRTimes, 2);
    paramJceOutputStream.write(this.iRtoATimes, 3);
    paramJceOutputStream.write(this.cPushNbTimes, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     AccostSvc.DCacheUserInfo
 * JD-Core Version:    0.7.0.1
 */