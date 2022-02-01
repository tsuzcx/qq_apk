package MOBILE_QZMALL_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VideoInfo
  extends JceStruct
{
  static VideoSpec cache_stVideoSpec = new VideoSpec();
  static VideoUrl cache_stVideoUrl = new VideoUrl();
  public VideoSpec stVideoSpec = null;
  public VideoUrl stVideoUrl = null;
  
  public VideoInfo() {}
  
  public VideoInfo(VideoUrl paramVideoUrl, VideoSpec paramVideoSpec)
  {
    this.stVideoUrl = paramVideoUrl;
    this.stVideoSpec = paramVideoSpec;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stVideoUrl = ((VideoUrl)paramJceInputStream.read(cache_stVideoUrl, 0, false));
    this.stVideoSpec = ((VideoSpec)paramJceInputStream.read(cache_stVideoSpec, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.stVideoUrl;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.stVideoSpec;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MOBILE_QZMALL_PROTOCOL.VideoInfo
 * JD-Core Version:    0.7.0.1
 */