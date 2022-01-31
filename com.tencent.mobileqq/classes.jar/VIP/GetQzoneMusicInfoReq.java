package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetQzoneMusicInfoReq
  extends JceStruct
{
  static SourceInfo cache_stSource = new SourceInfo();
  static ArrayList<String> cache_vSongIdList = new ArrayList();
  public long iUin;
  public SourceInfo stSource;
  public ArrayList<String> vSongIdList;
  
  static
  {
    cache_vSongIdList.add("");
  }
  
  public GetQzoneMusicInfoReq() {}
  
  public GetQzoneMusicInfoReq(long paramLong, ArrayList<String> paramArrayList, SourceInfo paramSourceInfo)
  {
    this.iUin = paramLong;
    this.vSongIdList = paramArrayList;
    this.stSource = paramSourceInfo;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iUin = paramJceInputStream.read(this.iUin, 0, false);
    this.vSongIdList = ((ArrayList)paramJceInputStream.read(cache_vSongIdList, 1, false));
    this.stSource = ((SourceInfo)paramJceInputStream.read(cache_stSource, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iUin, 0);
    if (this.vSongIdList != null) {
      paramJceOutputStream.write(this.vSongIdList, 1);
    }
    if (this.stSource != null) {
      paramJceOutputStream.write(this.stSource, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VIP.GetQzoneMusicInfoReq
 * JD-Core Version:    0.7.0.1
 */