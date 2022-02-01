package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PreUploadVideoInfo
  extends JceStruct
{
  static UploadVideoInfoReq cache_videoInfoReq = new UploadVideoInfoReq();
  public String seq = "";
  public String session = "";
  public UploadVideoInfoReq videoInfoReq = null;
  
  public PreUploadVideoInfo() {}
  
  public PreUploadVideoInfo(String paramString1, String paramString2, UploadVideoInfoReq paramUploadVideoInfoReq)
  {
    this.seq = paramString1;
    this.session = paramString2;
    this.videoInfoReq = paramUploadVideoInfoReq;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seq = paramJceInputStream.readString(0, true);
    this.session = paramJceInputStream.readString(1, true);
    this.videoInfoReq = ((UploadVideoInfoReq)paramJceInputStream.read(cache_videoInfoReq, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seq, 0);
    paramJceOutputStream.write(this.session, 1);
    paramJceOutputStream.write(this.videoInfoReq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     FileUpload.PreUploadVideoInfo
 * JD-Core Version:    0.7.0.1
 */