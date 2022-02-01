package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Conch
  extends JceStruct
{
  static byte[] cache_params = (byte[])new byte[1];
  static TimeCtrl cache_time = new TimeCtrl();
  static TipsInfo cache_tips = new TipsInfo();
  public int cmdId = 0;
  public int conchSeqno = 0;
  public byte[] params = null;
  public TimeCtrl time = null;
  public TipsInfo tips = null;
  
  static
  {
    ((byte[])cache_params)[0] = 0;
  }
  
  public JceStruct newInit()
  {
    return new Conch();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cmdId = paramJceInputStream.read(this.cmdId, 0, false);
    this.params = ((byte[])paramJceInputStream.read(cache_params, 1, false));
    this.conchSeqno = paramJceInputStream.read(this.conchSeqno, 2, false);
    this.time = ((TimeCtrl)paramJceInputStream.read(cache_time, 3, false));
    this.tips = ((TipsInfo)paramJceInputStream.read(cache_tips, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cmdId, 0);
    Object localObject = this.params;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 1);
    }
    int i = this.conchSeqno;
    if (i != 0) {
      paramJceOutputStream.write(i, 2);
    }
    localObject = this.time;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 3);
    }
    localObject = this.tips;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MConch.Conch
 * JD-Core Version:    0.7.0.1
 */