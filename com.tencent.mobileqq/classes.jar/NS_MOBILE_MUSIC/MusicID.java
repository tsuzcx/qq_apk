package NS_MOBILE_MUSIC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MusicID
  extends JceStruct
{
  public long song_id;
  public int type;
  
  public MusicID() {}
  
  public MusicID(long paramLong, int paramInt)
  {
    this.song_id = paramLong;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.song_id = paramJceInputStream.read(this.song_id, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.song_id, 0);
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_MUSIC.MusicID
 * JD-Core Version:    0.7.0.1
 */