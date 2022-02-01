package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqTmpChatPicDownload
  extends JceStruct
  implements Cloneable
{
  public byte getPicSize = 0;
  public long lSeq = 0L;
  public long lUIN = 0L;
  public String strFlieKey = "";
  
  public ReqTmpChatPicDownload() {}
  
  public ReqTmpChatPicDownload(long paramLong1, long paramLong2, String paramString, byte paramByte)
  {
    this.lUIN = paramLong1;
    this.lSeq = paramLong2;
    this.strFlieKey = paramString;
    this.getPicSize = paramByte;
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
    paramStringBuilder.display(this.strFlieKey, "strFlieKey");
    paramStringBuilder.display(this.getPicSize, "getPicSize");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ReqTmpChatPicDownload)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lUIN, paramObject.lUIN))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.lSeq, paramObject.lSeq))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.strFlieKey, paramObject.strFlieKey))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.getPicSize, paramObject.getPicSize)) {
            bool1 = true;
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
    this.strFlieKey = paramJceInputStream.readString(2, true);
    this.getPicSize = paramJceInputStream.read(this.getPicSize, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUIN, 0);
    paramJceOutputStream.write(this.lSeq, 1);
    paramJceOutputStream.write(this.strFlieKey, 2);
    paramJceOutputStream.write(this.getPicSize, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.ReqTmpChatPicDownload
 * JD-Core Version:    0.7.0.1
 */