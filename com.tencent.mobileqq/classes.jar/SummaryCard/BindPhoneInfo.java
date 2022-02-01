package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class BindPhoneInfo
  extends JceStruct
{
  public String strName = "";
  
  public BindPhoneInfo() {}
  
  public BindPhoneInfo(String paramString)
  {
    this.strName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strName = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strName != null) {
      paramJceOutputStream.write(this.strName, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     SummaryCard.BindPhoneInfo
 * JD-Core Version:    0.7.0.1
 */