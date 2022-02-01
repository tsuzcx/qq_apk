package MessageSvcPack;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class PullGroupSeqParam
  extends JceStruct
  implements Cloneable
{
  public long lGroupCode = 0L;
  public long lLastSeqId = 0L;
  
  public PullGroupSeqParam() {}
  
  public PullGroupSeqParam(long paramLong1, long paramLong2)
  {
    this.lGroupCode = paramLong1;
    this.lLastSeqId = paramLong2;
  }
  
  public String className()
  {
    return "MessageSvcPack.PullGroupSeqParam";
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
    paramStringBuilder.display(this.lGroupCode, "lGroupCode");
    paramStringBuilder.display(this.lLastSeqId, "lLastSeqId");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.lGroupCode, true);
    paramStringBuilder.displaySimple(this.lLastSeqId, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (PullGroupSeqParam)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.lGroupCode, paramObject.lGroupCode))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.lLastSeqId, paramObject.lLastSeqId)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "MessageSvcPack.PullGroupSeqParam";
  }
  
  public long getLGroupCode()
  {
    return this.lGroupCode;
  }
  
  public long getLLastSeqId()
  {
    return this.lLastSeqId;
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
    this.lGroupCode = paramJceInputStream.read(this.lGroupCode, 0, true);
    this.lLastSeqId = paramJceInputStream.read(this.lLastSeqId, 1, true);
  }
  
  public void setLGroupCode(long paramLong)
  {
    this.lGroupCode = paramLong;
  }
  
  public void setLLastSeqId(long paramLong)
  {
    this.lLastSeqId = paramLong;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lGroupCode, 0);
    paramJceOutputStream.write(this.lLastSeqId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     MessageSvcPack.PullGroupSeqParam
 * JD-Core Version:    0.7.0.1
 */