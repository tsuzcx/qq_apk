package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SetMusicPosReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  public int iPos = 0;
  public long iUin = 0L;
  public String sSongId = "";
  public SourceInfo stSource = null;
  
  public SetMusicPosReq() {}
  
  public SetMusicPosReq(long paramLong, String paramString, int paramInt, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.sSongId = paramString;
    this.iPos = paramInt;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sSongId = paramJceInputStream.readString(1, false);
    this.iPos = paramJceInputStream.read(this.iPos, 2, false);
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.sSongId != null) {
      paramJceOutputStream.write(this.sSongId, 1);
    }
    paramJceOutputStream.write(this.iPos, 2);
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.SetMusicPosReq
 * JD-Core Version:    0.7.0.1
 */