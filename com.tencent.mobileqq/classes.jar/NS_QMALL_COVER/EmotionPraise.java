package NS_QMALL_COVER;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class EmotionPraise
  extends JceStruct
  implements Cloneable
{
  public int iItemId = -1;
  public String strEmotion = "";
  public String strItemSummary = "";
  public String strName = "";
  public String strPraiseListPic = "";
  public String strPraisePic = "";
  public String strPraiseZip = "";
  
  public EmotionPraise() {}
  
  public EmotionPraise(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.iItemId = paramInt;
    this.strName = paramString1;
    this.strItemSummary = paramString2;
    this.strPraisePic = paramString3;
    this.strPraiseListPic = paramString4;
    this.strPraiseZip = paramString5;
    this.strEmotion = paramString6;
  }
  
  public String className()
  {
    return "NS_QMALL_COVER.EmotionPraise";
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
    paramStringBuilder.display(this.iItemId, "iItemId");
    paramStringBuilder.display(this.strName, "strName");
    paramStringBuilder.display(this.strItemSummary, "strItemSummary");
    paramStringBuilder.display(this.strPraisePic, "strPraisePic");
    paramStringBuilder.display(this.strPraiseListPic, "strPraiseListPic");
    paramStringBuilder.display(this.strPraiseZip, "strPraiseZip");
    paramStringBuilder.display(this.strEmotion, "strEmotion");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.iItemId, true);
    paramStringBuilder.displaySimple(this.strName, true);
    paramStringBuilder.displaySimple(this.strItemSummary, true);
    paramStringBuilder.displaySimple(this.strPraisePic, true);
    paramStringBuilder.displaySimple(this.strPraiseListPic, true);
    paramStringBuilder.displaySimple(this.strPraiseZip, true);
    paramStringBuilder.displaySimple(this.strEmotion, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (EmotionPraise)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.iItemId, paramObject.iItemId))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.strName, paramObject.strName))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.strItemSummary, paramObject.strItemSummary))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.strPraisePic, paramObject.strPraisePic))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.strPraiseListPic, paramObject.strPraiseListPic))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.strPraiseZip, paramObject.strPraiseZip))
              {
                bool1 = bool2;
                if (JceUtil.equals(this.strEmotion, paramObject.strEmotion)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String fullClassName()
  {
    return "NS_QMALL_COVER.EmotionPraise";
  }
  
  public int getIItemId()
  {
    return this.iItemId;
  }
  
  public String getStrEmotion()
  {
    return this.strEmotion;
  }
  
  public String getStrItemSummary()
  {
    return this.strItemSummary;
  }
  
  public String getStrName()
  {
    return this.strName;
  }
  
  public String getStrPraiseListPic()
  {
    return this.strPraiseListPic;
  }
  
  public String getStrPraisePic()
  {
    return this.strPraisePic;
  }
  
  public String getStrPraiseZip()
  {
    return this.strPraiseZip;
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
    this.iItemId = paramJceInputStream.read(this.iItemId, 0, true);
    this.strName = paramJceInputStream.readString(1, false);
    this.strItemSummary = paramJceInputStream.readString(2, false);
    this.strPraisePic = paramJceInputStream.readString(3, false);
    this.strPraiseListPic = paramJceInputStream.readString(4, false);
    this.strPraiseZip = paramJceInputStream.readString(5, false);
    this.strEmotion = paramJceInputStream.readString(6, false);
  }
  
  public void setIItemId(int paramInt)
  {
    this.iItemId = paramInt;
  }
  
  public void setStrEmotion(String paramString)
  {
    this.strEmotion = paramString;
  }
  
  public void setStrItemSummary(String paramString)
  {
    this.strItemSummary = paramString;
  }
  
  public void setStrName(String paramString)
  {
    this.strName = paramString;
  }
  
  public void setStrPraiseListPic(String paramString)
  {
    this.strPraiseListPic = paramString;
  }
  
  public void setStrPraisePic(String paramString)
  {
    this.strPraisePic = paramString;
  }
  
  public void setStrPraiseZip(String paramString)
  {
    this.strPraiseZip = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iItemId, 0);
    String str = this.strName;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strItemSummary;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strPraisePic;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strPraiseListPic;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.strPraiseZip;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.strEmotion;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QMALL_COVER.EmotionPraise
 * JD-Core Version:    0.7.0.1
 */