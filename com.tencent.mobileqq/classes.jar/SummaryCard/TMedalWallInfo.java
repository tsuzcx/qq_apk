package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class TMedalWallInfo
  extends JceStruct
  implements Cloneable
{
  public int iMedalCount = 0;
  public int iNewCount = 0;
  public int iOpenFlag = 0;
  public int iUpgradeCount = 0;
  public String strPromptParams = "";
  
  public TMedalWallInfo() {}
  
  public TMedalWallInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.iOpenFlag = paramInt1;
    this.iMedalCount = paramInt2;
    this.iNewCount = paramInt3;
    this.iUpgradeCount = paramInt4;
    this.strPromptParams = paramString;
  }
  
  public String className()
  {
    return "SummaryCard.TMedalWallInfo";
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
    paramStringBuilder.display(this.iOpenFlag, "iOpenFlag");
    paramStringBuilder.display(this.iMedalCount, "iMedalCount");
    paramStringBuilder.display(this.iNewCount, "iNewCount");
    paramStringBuilder.display(this.iUpgradeCount, "iUpgradeCount");
    paramStringBuilder.display(this.strPromptParams, "strPromptParams");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iOpenFlag, true);
    paramStringBuilder.displaySimple(this.iMedalCount, true);
    paramStringBuilder.displaySimple(this.iNewCount, true);
    paramStringBuilder.displaySimple(this.iUpgradeCount, true);
    paramStringBuilder.displaySimple(this.strPromptParams, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (TMedalWallInfo)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.iOpenFlag, paramObject.iOpenFlag))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.iMedalCount, paramObject.iMedalCount))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.iNewCount, paramObject.iNewCount))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.iUpgradeCount, paramObject.iUpgradeCount))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strPromptParams, paramObject.strPromptParams)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "SummaryCard.TMedalWallInfo";
  }
  
  public int getIMedalCount()
  {
    return this.iMedalCount;
  }
  
  public int getINewCount()
  {
    return this.iNewCount;
  }
  
  public int getIOpenFlag()
  {
    return this.iOpenFlag;
  }
  
  public int getIUpgradeCount()
  {
    return this.iUpgradeCount;
  }
  
  public String getStrPromptParams()
  {
    return this.strPromptParams;
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
    this.iOpenFlag = paramJceInputStream.read(this.iOpenFlag, 0, false);
    this.iMedalCount = paramJceInputStream.read(this.iMedalCount, 1, false);
    this.iNewCount = paramJceInputStream.read(this.iNewCount, 2, false);
    this.iUpgradeCount = paramJceInputStream.read(this.iUpgradeCount, 3, false);
    this.strPromptParams = paramJceInputStream.readString(4, false);
  }
  
  public void setIMedalCount(int paramInt)
  {
    this.iMedalCount = paramInt;
  }
  
  public void setINewCount(int paramInt)
  {
    this.iNewCount = paramInt;
  }
  
  public void setIOpenFlag(int paramInt)
  {
    this.iOpenFlag = paramInt;
  }
  
  public void setIUpgradeCount(int paramInt)
  {
    this.iUpgradeCount = paramInt;
  }
  
  public void setStrPromptParams(String paramString)
  {
    this.strPromptParams = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpenFlag, 0);
    paramJceOutputStream.write(this.iMedalCount, 1);
    paramJceOutputStream.write(this.iNewCount, 2);
    paramJceOutputStream.write(this.iUpgradeCount, 3);
    String str = this.strPromptParams;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.TMedalWallInfo
 * JD-Core Version:    0.7.0.1
 */