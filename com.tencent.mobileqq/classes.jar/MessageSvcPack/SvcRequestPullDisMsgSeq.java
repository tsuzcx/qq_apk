package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestPullDisMsgSeq
  extends JceStruct
{
  static ArrayList<PullDisSeqParam> cache_vDisInfo;
  public byte cVerifyType;
  public ArrayList<PullDisSeqParam> vDisInfo;
  
  public SvcRequestPullDisMsgSeq() {}
  
  public SvcRequestPullDisMsgSeq(ArrayList<PullDisSeqParam> paramArrayList, byte paramByte)
  {
    this.vDisInfo = paramArrayList;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vDisInfo == null)
    {
      cache_vDisInfo = new ArrayList();
      PullDisSeqParam localPullDisSeqParam = new PullDisSeqParam();
      cache_vDisInfo.add(localPullDisSeqParam);
    }
    this.vDisInfo = ((ArrayList)paramJceInputStream.read(cache_vDisInfo, 0, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vDisInfo, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestPullDisMsgSeq
 * JD-Core Version:    0.7.0.1
 */