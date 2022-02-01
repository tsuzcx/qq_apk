package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddMusicReq
  extends JceStruct
{
  static MusicInfo cache_stMusic = new MusicInfo();
  static SourceInfo cache_stSource = new SourceInfo();
  public long iUin = 0L;
  public MusicInfo stMusic = null;
  public SourceInfo stSource = null;
  
  public AddMusicReq() {}
  
  public AddMusicReq(long paramLong, MusicInfo paramMusicInfo, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.stMusic = paramMusicInfo;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.stMusic = ((MusicInfo)paramJceInputStream.read(cache_stMusic, 1, false));
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    Object localObject = this.stMusic;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.stSource;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VIP.AddMusicReq
 * JD-Core Version:    0.7.0.1
 */