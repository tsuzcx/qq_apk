package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_videourl
  extends JceStruct
{
  public String url = "";
  public byte videoprior;
  public int videorate;
  
  public s_videourl() {}
  
  public s_videourl(String paramString, byte paramByte, int paramInt)
  {
    this.url = paramString;
    this.videoprior = paramByte;
    this.videorate = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.url = paramJceInputStream.readString(0, false);
    this.videoprior = paramJceInputStream.read(this.videoprior, 1, false);
    this.videorate = paramJceInputStream.read(this.videorate, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 0);
    }
    paramJceOutputStream.write(this.videoprior, 1);
    paramJceOutputStream.write(this.videorate, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     NS_MOBILE_FEEDS.s_videourl
 * JD-Core Version:    0.7.0.1
 */