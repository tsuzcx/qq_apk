package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcResponsePullGroupMsgSeq
  extends JceStruct
{
  static ArrayList cache_vGroupInfo;
  public byte cReplyCode;
  public String strResult = "";
  public ArrayList vGroupInfo;
  public short wGroupNum;
  
  public SvcResponsePullGroupMsgSeq() {}
  
  public SvcResponsePullGroupMsgSeq(byte paramByte, String paramString, short paramShort, ArrayList paramArrayList)
  {
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.wGroupNum = paramShort;
    this.vGroupInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 0, true);
    this.strResult = paramJceInputStream.readString(1, true);
    this.wGroupNum = paramJceInputStream.read(this.wGroupNum, 2, true);
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      GroupInfo localGroupInfo = new GroupInfo();
      cache_vGroupInfo.add(localGroupInfo);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cReplyCode, 0);
    paramJceOutputStream.write(this.strResult, 1);
    paramJceOutputStream.write(this.wGroupNum, 2);
    paramJceOutputStream.write(this.vGroupInfo, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponsePullGroupMsgSeq
 * JD-Core Version:    0.7.0.1
 */