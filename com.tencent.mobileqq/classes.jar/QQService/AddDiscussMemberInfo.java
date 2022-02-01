package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class AddDiscussMemberInfo
  extends JceStruct
{
  public String RefStr = "";
  public long RefUin = 0L;
  public int Type = 0;
  public long Uin = 0L;
  
  public AddDiscussMemberInfo() {}
  
  public AddDiscussMemberInfo(long paramLong1, int paramInt, long paramLong2, String paramString)
  {
    this.Uin = paramLong1;
    this.Type = paramInt;
    this.RefUin = paramLong2;
    this.RefStr = paramString;
  }
  
  public String className()
  {
    return "QQService.AddDiscussMemberInfo";
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
    paramStringBuilder.display(this.Uin, "Uin");
    paramStringBuilder.display(this.Type, "Type");
    paramStringBuilder.display(this.RefUin, "RefUin");
    paramStringBuilder.display(this.RefStr, "RefStr");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.Uin, true);
    paramStringBuilder.displaySimple(this.Type, true);
    paramStringBuilder.displaySimple(this.RefUin, true);
    paramStringBuilder.displaySimple(this.RefStr, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (AddDiscussMemberInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.Uin, paramObject.Uin))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.Type, paramObject.Type))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.RefUin, paramObject.RefUin))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.RefStr, paramObject.RefStr)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "QQService.AddDiscussMemberInfo";
  }
  
  public long getUin()
  {
    return this.Uin;
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
    this.Uin = paramJceInputStream.read(this.Uin, 0, true);
    this.Type = paramJceInputStream.read(this.Type, 1, true);
    this.RefUin = paramJceInputStream.read(this.RefUin, 2, false);
    this.RefStr = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Uin, 0);
    paramJceOutputStream.write(this.Type, 1);
    paramJceOutputStream.write(this.RefUin, 2);
    String str = this.RefStr;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QQService.AddDiscussMemberInfo
 * JD-Core Version:    0.7.0.1
 */