package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.msgb_rapidemotion;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_msgb_rapidemotion
  extends JceStruct
{
  static msgb_rapidemotion cache_emotion = new msgb_rapidemotion();
  public msgb_rapidemotion emotion;
  
  public cell_msgb_rapidemotion() {}
  
  public cell_msgb_rapidemotion(msgb_rapidemotion parammsgb_rapidemotion)
  {
    this.emotion = parammsgb_rapidemotion;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.emotion = ((msgb_rapidemotion)paramJceInputStream.read(cache_emotion, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.emotion != null) {
      paramJceOutputStream.write(this.emotion, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_msgb_rapidemotion
 * JD-Core Version:    0.7.0.1
 */