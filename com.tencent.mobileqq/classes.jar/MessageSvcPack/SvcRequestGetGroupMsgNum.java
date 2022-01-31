package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestGetGroupMsgNum
  extends JceStruct
{
  static ArrayList cache_vGroupInfo;
  public byte cVerifyType;
  public long lUin;
  public ArrayList vGroupInfo;
  
  public SvcRequestGetGroupMsgNum() {}
  
  public SvcRequestGetGroupMsgNum(long paramLong, ArrayList paramArrayList, byte paramByte)
  {
    this.lUin = paramLong;
    this.vGroupInfo = paramArrayList;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      SvcRequestGroupInfo localSvcRequestGroupInfo = new SvcRequestGroupInfo();
      cache_vGroupInfo.add(localSvcRequestGroupInfo);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 1, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vGroupInfo, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetGroupMsgNum
 * JD-Core Version:    0.7.0.1
 */