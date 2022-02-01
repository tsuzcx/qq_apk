package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestGetConfMsgNum
  extends JceStruct
{
  static ArrayList<Long> cache_vConfUin;
  public byte cVerifyType = 0;
  public ArrayList<Long> vConfUin = null;
  
  public SvcRequestGetConfMsgNum() {}
  
  public SvcRequestGetConfMsgNum(ArrayList<Long> paramArrayList, byte paramByte)
  {
    this.vConfUin = paramArrayList;
    this.cVerifyType = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vConfUin == null)
    {
      cache_vConfUin = new ArrayList();
      cache_vConfUin.add(Long.valueOf(0L));
    }
    this.vConfUin = ((ArrayList)paramJceInputStream.read(cache_vConfUin, 0, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vConfUin, 0);
    paramJceOutputStream.write(this.cVerifyType, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGetConfMsgNum
 * JD-Core Version:    0.7.0.1
 */