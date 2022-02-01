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
  
  static
  {
    if (!RespTmpChatPicDownload.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
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
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.lSeq, "lSeq");
    paramStringBuilder.display(this.lReplyCode, "lReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
    paramStringBuilder.display(this.strDownloadURL, "strDownloadURL");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespTmpChatPicDownload)paramObject;
    } while ((!JceUtil.equals(this.lUIN, paramObject.lUIN)) || (!JceUtil.equals(this.lSeq, paramObject.lSeq)) || (!JceUtil.equals(this.lReplyCode, paramObject.lReplyCode)) || (!JceUtil.equals(this.strResult, paramObject.strResult)) || (!JceUtil.equals(this.strDownloadURL, paramObject.strDownloadURL)));
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     QQService.RespTmpChatPicDownload
 * JD-Core Version:    0.7.0.1
 */