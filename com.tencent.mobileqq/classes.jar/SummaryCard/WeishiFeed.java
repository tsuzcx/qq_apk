package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class WeishiFeed
  extends JceStruct
  implements Cloneable
{
  public String strCoverUrl = "";
  public String strDynamicCover = "";
  public String strVideoUrl = "";
  
  public WeishiFeed() {}
  
  public WeishiFeed(String paramString1, String paramString2, String paramString3)
  {
    this.strVideoUrl = paramString1;
    this.strCoverUrl = paramString2;
    this.strDynamicCover = paramString3;
  }
  
  public String className()
  {
    return "SummaryCard.WeishiFeed";
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
    paramStringBuilder.display(this.strVideoUrl, "strVideoUrl");
    paramStringBuilder.display(this.strCoverUrl, "strCoverUrl");
    paramStringBuilder.display(this.strDynamicCover, "strDynamicCover");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.strVideoUrl, true);
    paramStringBuilder.displaySimple(this.strCoverUrl, true);
    paramStringBuilder.displaySimple(this.strDynamicCover, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (WeishiFeed)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.strVideoUrl, paramObject.strVideoUrl))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strCoverUrl, paramObject.strCoverUrl))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.strDynamicCover, paramObject.strDynamicCover)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "SummaryCard.WeishiFeed";
  }
  
  public String getStrCoverUrl()
  {
    return this.strCoverUrl;
  }
  
  public String getStrDynamicCover()
  {
    return this.strDynamicCover;
  }
  
  public String getStrVideoUrl()
  {
    return this.strVideoUrl;
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
    this.strVideoUrl = paramJceInputStream.readString(0, false);
    this.strCoverUrl = paramJceInputStream.readString(1, false);
    this.strDynamicCover = paramJceInputStream.readString(2, false);
  }
  
  public void setStrCoverUrl(String paramString)
  {
    this.strCoverUrl = paramString;
  }
  
  public void setStrDynamicCover(String paramString)
  {
    this.strDynamicCover = paramString;
  }
  
  public void setStrVideoUrl(String paramString)
  {
    this.strVideoUrl = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.strVideoUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.strCoverUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strDynamicCover;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.WeishiFeed
 * JD-Core Version:    0.7.0.1
 */