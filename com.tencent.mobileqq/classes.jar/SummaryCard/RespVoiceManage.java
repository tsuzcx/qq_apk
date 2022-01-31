package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespVoiceManage
  extends JceStruct
{
  static int cache_eOpType;
  public int eOpType;
  
  public RespVoiceManage() {}
  
  public RespVoiceManage(int paramInt)
  {
    this.eOpType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eOpType = paramJceInputStream.read(this.eOpType, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eOpType, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     SummaryCard.RespVoiceManage
 * JD-Core Version:    0.7.0.1
 */