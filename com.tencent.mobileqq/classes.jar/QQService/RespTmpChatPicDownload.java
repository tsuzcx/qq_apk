package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespTmpChatPicDownload
  extends JceStruct
  implements Cloneable
{
  public int lReplyCode = 0;
  public long lSeq = 0L;
  public long lUIN = 0L;
  public String strDownloadURL = "";
  public String strResult = "";
  
  public RespTmpChatPicDownload() {}
  
  public RespTmpChatPicDownload(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2)
  {
    this.lUIN = paramLong1;
    this.lSeq = paramLong2;
    this.lReplyCode = paramInt;
    this.strResult = paramString1;
    this.strDownloadURL = paramString2;
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.lSeq, "lSeq");
    paramStringBuilder.display(this.lReplyCode, "lReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
    paramStringBuilder.display(this.strDownloadURL, "strDownloadURL");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RespTmpChatPicDownload)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lUIN, paramObject.lUIN))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.lSeq, paramObject.lSeq))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.lReplyCode, paramObject.lReplyCode))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.strResult, paramObject.strResult))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strDownloadURL, paramObject.strDownloadURL)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
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
    this.lUIN = paramJceInputStream.read(this.lUIN, 0, true);
    this.lSeq = paramJceInputStream.read(this.lSeq, 1, true);
    this.lReplyCode = paramJceInputStream.read(this.lReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, true);
    this.strDownloadURL = paramJceInputStream.readString(4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.lSeq, 1);
    paramJceOutputStream.write(this.lReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
    paramJceOutputStream.write(this.strDownloadURL, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespTmpChatPicDownload
 * JD-Core Version:    0.7.0.1
 */