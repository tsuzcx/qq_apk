package ResPackage;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class RspResOrder
  extends JceStruct
  implements Cloneable
{
  static int cache_Ret;
  public String ButtonDesc = "";
  public String ButtonUrl = "";
  public String ErrMsg = "";
  public int Ret = 0;
  public int SeqID = 0;
  public String Title = "";
  
  public RspResOrder() {}
  
  public RspResOrder(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.Ret = paramInt1;
    this.SeqID = paramInt2;
    this.Title = paramString1;
    this.ErrMsg = paramString2;
    this.ButtonDesc = paramString3;
    this.ButtonUrl = paramString4;
  }
  
  public String className()
  {
    return "ResPackage.RspResOrder";
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
    paramStringBuilder.display(this.Ret, "Ret");
    paramStringBuilder.display(this.SeqID, "SeqID");
    paramStringBuilder.display(this.Title, "Title");
    paramStringBuilder.display(this.ErrMsg, "ErrMsg");
    paramStringBuilder.display(this.ButtonDesc, "ButtonDesc");
    paramStringBuilder.display(this.ButtonUrl, "ButtonUrl");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.Ret, true);
    paramStringBuilder.displaySimple(this.SeqID, true);
    paramStringBuilder.displaySimple(this.Title, true);
    paramStringBuilder.displaySimple(this.ErrMsg, true);
    paramStringBuilder.displaySimple(this.ButtonDesc, true);
    paramStringBuilder.displaySimple(this.ButtonUrl, false);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    paramObject = (RspResOrder)paramObject;
    boolean bool1 = bool2;
    if (JceUtil.equals(this.Ret, paramObject.Ret))
    {
      bool1 = bool2;
      if (JceUtil.equals(this.SeqID, paramObject.SeqID))
      {
        bool1 = bool2;
        if (JceUtil.equals(this.Title, paramObject.Title))
        {
          bool1 = bool2;
          if (JceUtil.equals(this.ErrMsg, paramObject.ErrMsg))
          {
            bool1 = bool2;
            if (JceUtil.equals(this.ButtonDesc, paramObject.ButtonDesc))
            {
              bool1 = bool2;
              if (JceUtil.equals(this.ButtonUrl, paramObject.ButtonUrl)) {
                bool1 = true;
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
    return "ResPackage.RspResOrder";
  }
  
  public String getButtonDesc()
  {
    return this.ButtonDesc;
  }
  
  public String getButtonUrl()
  {
    return this.ButtonUrl;
  }
  
  public String getErrMsg()
  {
    return this.ErrMsg;
  }
  
  public int getRet()
  {
    return this.Ret;
  }
  
  public int getSeqID()
  {
    return this.SeqID;
  }
  
  public String getTitle()
  {
    return this.Title;
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
    this.Ret = paramJceInputStream.read(this.Ret, 0, true);
    this.SeqID = paramJceInputStream.read(this.SeqID, 1, true);
    this.Title = paramJceInputStream.readString(2, false);
    this.ErrMsg = paramJceInputStream.readString(3, false);
    this.ButtonDesc = paramJceInputStream.readString(4, false);
    this.ButtonUrl = paramJceInputStream.readString(5, false);
  }
  
  public void setButtonDesc(String paramString)
  {
    this.ButtonDesc = paramString;
  }
  
  public void setButtonUrl(String paramString)
  {
    this.ButtonUrl = paramString;
  }
  
  public void setErrMsg(String paramString)
  {
    this.ErrMsg = paramString;
  }
  
  public void setRet(int paramInt)
  {
    this.Ret = paramInt;
  }
  
  public void setSeqID(int paramInt)
  {
    this.SeqID = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.Title = paramString;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Ret, 0);
    paramJceOutputStream.write(this.SeqID, 1);
    String str = this.Title;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.ErrMsg;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.ButtonDesc;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.ButtonUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ResPackage.RspResOrder
 * JD-Core Version:    0.7.0.1
 */