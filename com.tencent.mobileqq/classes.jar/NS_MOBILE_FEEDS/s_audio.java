package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_audio
  extends JceStruct
{
  public String audiokey = "";
  public int audiotime;
  public String errormessge = "";
  public int isplay;
  
  public s_audio() {}
  
  public s_audio(String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    this.audiokey = paramString1;
    this.audiotime = paramInt1;
    this.errormessge = paramString2;
    this.isplay = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.audiokey = paramJceInputStream.readString(0, false);
    this.audiotime = paramJceInputStream.read(this.audiotime, 1, false);
    this.errormessge = paramJceInputStream.readString(2, false);
    this.isplay = paramJceInputStream.read(this.isplay, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.audiokey != null) {
      paramJceOutputStream.write(this.audiokey, 0);
    }
    paramJceOutputStream.write(this.audiotime, 1);
    if (this.errormessge != null) {
      paramJceOutputStream.write(this.errormessge, 2);
    }
    paramJceOutputStream.write(this.isplay, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_audio
 * JD-Core Version:    0.7.0.1
 */