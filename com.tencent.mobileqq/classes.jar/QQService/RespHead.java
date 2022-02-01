package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RespHead
  extends JceStruct
  implements Cloneable
{
  public int iReplyCode = 0;
  public int iSeq = 0;
  public long lUIN = 0L;
  public short shVersion = 0;
  public String strResult = "";
  
  public RespHead() {}
  
  public RespHead(short paramShort, int paramInt1, long paramLong, int paramInt2, String paramString)
  {
    this.shVersion = paramShort;
    this.iSeq = paramInt1;
    this.lUIN = paramLong;
    this.iReplyCode = paramInt2;
    this.strResult = paramString;
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
    paramStringBuilder.display(this.shVersion, "shVersion");
    paramStringBuilder.display(this.iSeq, "iSeq");
    paramStringBuilder.display(this.lUIN, "lUIN");
    paramStringBuilder.display(this.iReplyCode, "iReplyCode");
    paramStringBuilder.display(this.strResult, "strResult");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RespHead)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.shVersion, paramObject.shVersion))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.iSeq, paramObject.iSeq))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.lUIN, paramObject.lUIN))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.iReplyCode, paramObject.iReplyCode))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strResult, paramObject.strResult)) {
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
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.iSeq = paramJceInputStream.read(this.iSeq, 1, true);
    this.lUIN = paramJceInputStream.read(this.lUIN, 2, true);
    this.iReplyCode = paramJceInputStream.read(this.iReplyCode, 3, true);
    this.strResult = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.iSeq, 1);
    paramJceOutputStream.write(this.lUIN, 2);
    paramJceOutputStream.write(this.iReplyCode, 3);
    String str = this.strResult;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.RespHead
 * JD-Core Version:    0.7.0.1
 */