package FileUpload;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PreUploadVideoInfo
  extends JceStruct
  implements Cloneable
{
  static UploadVideoInfoReq cache_videoInfoReq;
  public String seq = "";
  public String session = "";
  public UploadVideoInfoReq videoInfoReq = null;
  
  static
  {
    if (!PreUploadVideoInfo.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      cache_videoInfoReq = new UploadVideoInfoReq();
      return;
    }
  }
  
  public PreUploadVideoInfo() {}
  
  public PreUploadVideoInfo(String paramString1, String paramString2, UploadVideoInfoReq paramUploadVideoInfoReq)
  {
    this.seq = paramString1;
    this.session = paramString2;
    this.videoInfoReq = paramUploadVideoInfoReq;
  }
  
  public String className()
  {
    return "FileUpload.PreUploadVideoInfo";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.seq, "seq");
    paramStringBuilder.display(this.session, "session");
    paramStringBuilder.display(this.videoInfoReq, "videoInfoReq");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.seq, true);
    paramStringBuilder.displaySimple(this.session, true);
    paramStringBuilder.displaySimple(this.videoInfoReq, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (PreUploadVideoInfo)paramObject;
    } while ((!JceUtil.equals(this.seq, paramObject.seq)) || (!JceUtil.equals(this.session, paramObject.session)) || (!JceUtil.equals(this.videoInfoReq, paramObject.videoInfoReq)));
    return true;
  }
  
  public String fullClassName()
  {
    return "FileUpload.PreUploadVideoInfo";
  }
  
  public String getSeq()
  {
    return this.seq;
  }
  
  public String getSession()
  {
    return this.session;
  }
  
  public UploadVideoInfoReq getVideoInfoReq()
  {
    return this.videoInfoReq;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.seq = paramJceInputStream.readString(0, true);
    this.session = paramJceInputStream.readString(1, true);
    this.videoInfoReq = ((UploadVideoInfoReq)paramJceInputStream.read(cache_videoInfoReq, 2, true));
  }
  
  public void setSeq(String paramString)
  {
    this.seq = paramString;
  }
  
  public void setSession(String paramString)
  {
    this.session = paramString;
  }
  
  public void setVideoInfoReq(UploadVideoInfoReq paramUploadVideoInfoReq)
  {
    this.videoInfoReq = paramUploadVideoInfoReq;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.seq, 0);
    paramJceOutputStream.write(this.session, 1);
    paramJceOutputStream.write(this.videoInfoReq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     FileUpload.PreUploadVideoInfo
 * JD-Core Version:    0.7.0.1
 */