package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TEIMInfo
  extends JceStruct
  implements Cloneable
{
  public int iBindCompanyEmailStatus = 0;
  public String sBindCompanyEmail = "";
  
  public TEIMInfo() {}
  
  public TEIMInfo(int paramInt, String paramString)
  {
    this.iBindCompanyEmailStatus = paramInt;
    this.sBindCompanyEmail = paramString;
  }
  
  public String className()
  {
    return "SummaryCard.TEIMInfo";
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
    paramStringBuilder.display(this.iBindCompanyEmailStatus, "iBindCompanyEmailStatus");
    paramStringBuilder.display(this.sBindCompanyEmail, "sBindCompanyEmail");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iBindCompanyEmailStatus, true);
    paramStringBuilder.displaySimple(this.sBindCompanyEmail, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (TEIMInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.iBindCompanyEmailStatus, paramObject.iBindCompanyEmailStatus))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.sBindCompanyEmail, paramObject.sBindCompanyEmail)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "SummaryCard.TEIMInfo";
  }
  
  public int getIBindCompanyEmailStatus()
  {
    return this.iBindCompanyEmailStatus;
  }
  
  public String getSBindCompanyEmail()
  {
    return this.sBindCompanyEmail;
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
    this.iBindCompanyEmailStatus = paramJceInputStream.read(this.iBindCompanyEmailStatus, 0, false);
    this.sBindCompanyEmail = paramJceInputStream.readString(1, false);
  }
  
  public void setIBindCompanyEmailStatus(int paramInt)
  {
    this.iBindCompanyEmailStatus = paramInt;
  }
  
  public void setSBindCompanyEmail(String paramString)
  {
    this.sBindCompanyEmail = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iBindCompanyEmailStatus, 0);
    String str = this.sBindCompanyEmail;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TEIMInfo
 * JD-Core Version:    0.7.0.1
 */