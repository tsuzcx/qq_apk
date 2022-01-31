package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelMusicReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  public long iUin;
  public String sSongId = "";
  public SourceInfo stSource;
  
  public DelMusicReq() {}
  
  public DelMusicReq(long paramLong, String paramString, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.sSongId = paramString;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.sSongId = paramJceInputStream.readString(1, false);
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.sSongId != null) {
      paramJceOutputStream.write(this.sSongId, 1);
    }
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.DelMusicReq
 * JD-Core Version:    0.7.0.1
 */