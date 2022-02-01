package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class ReqResUpdate
  extends JceStruct
  implements Cloneable
{
  static int cache_ResID;
  public int ResID = 0;
  public long SeqID = 0L;
  public byte SeqOnly = 0;
  
  public ReqResUpdate() {}
  
  public ReqResUpdate(int paramInt, long paramLong, byte paramByte)
  {
    this.ResID = paramInt;
    this.SeqID = paramLong;
    this.SeqOnly = paramByte;
  }
  
  public String className()
  {
    return "ResPackage.ReqResUpdate";
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
    paramStringBuilder.display(this.ResID, "ResID");
    paramStringBuilder.display(this.SeqID, "SeqID");
    paramStringBuilder.display(this.SeqOnly, "SeqOnly");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.ResID, true);
    paramStringBuilder.displaySimple(this.SeqID, true);
    paramStringBuilder.displaySimple(this.SeqOnly, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (ReqResUpdate)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.ResID, paramObject.ResID))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.SeqID, paramObject.SeqID))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.SeqOnly, paramObject.SeqOnly)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "ResPackage.ReqResUpdate";
  }
  
  public int getResID()
  {
    return this.ResID;
  }
  
  public long getSeqID()
  {
    return this.SeqID;
  }
  
  public byte getSeqOnly()
  {
    return this.SeqOnly;
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
    this.ResID = paramJceInputStream.read(this.ResID, 0, true);
    this.SeqID = paramJceInputStream.read(this.SeqID, 1, true);
    this.SeqOnly = paramJceInputStream.read(this.SeqOnly, 2, false);
  }
  
  public void setResID(int paramInt)
  {
    this.ResID = paramInt;
  }
  
  public void setSeqID(long paramLong)
  {
    this.SeqID = paramLong;
  }
  
  public void setSeqOnly(byte paramByte)
  {
    this.SeqOnly = paramByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ResID, 0);
    paramJceOutputStream.write(this.SeqID, 1);
    paramJceOutputStream.write(this.SeqOnly, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ResPackage.ReqResUpdate
 * JD-Core Version:    0.7.0.1
 */