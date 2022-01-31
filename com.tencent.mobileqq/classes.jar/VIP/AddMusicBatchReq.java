package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class AddMusicBatchReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  static ArrayList<MusicInfo> cache_vMusicList = new ArrayList();
  public long iUin;
  public SourceInfo stSource;
  public ArrayList<MusicInfo> vMusicList;
  
  static
  {
    MusicInfo localMusicInfo = new MusicInfo();
    cache_vMusicList.add(localMusicInfo);
  }
  
  public AddMusicBatchReq() {}
  
  public AddMusicBatchReq(long paramLong, ArrayList<MusicInfo> paramArrayList, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.vMusicList = paramArrayList;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.vMusicList = ((ArrayList)paramJceInputStream.read(cache_vMusicList, 1, false));
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.vMusicList != null) {
      paramJceOutputStream.write(this.vMusicList, 1);
    }
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.AddMusicBatchReq
 * JD-Core Version:    0.7.0.1
 */