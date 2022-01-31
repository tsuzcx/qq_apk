package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetAllBgMusicListReq
  extends JceStruct
{
  public long host_uin;
  
  public GetAllBgMusicListReq() {}
  
  public GetAllBgMusicListReq(long paramLong)
  {
    this.host_uin = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.host_uin = paramJceInputStream.read(this.host_uin, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.host_uin, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_MUSIC.GetAllBgMusicListReq
 * JD-Core Version:    0.7.0.1
 */