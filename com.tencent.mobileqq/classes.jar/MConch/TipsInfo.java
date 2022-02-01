package MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class TipsInfo
  extends JceStruct
{
  public int askType = 0;
  public int bgColor = 0;
  public int iconType = 0;
  public String msg = "";
  public String title = "";
  public int type = 0;
  
  public JceStruct newInit()
  {
    return new TipsInfo();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.title = paramJceInputStream.readString(0, false);
    this.msg = paramJceInputStream.readString(1, false);
    this.type = paramJceInputStream.read(this.type, 2, false);
    this.askType = paramJceInputStream.read(this.askType, 3, false);
    this.iconType = paramJceInputStream.read(this.iconType, 4, false);
    this.bgColor = paramJceInputStream.read(this.bgColor, 5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 0);
    }
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.type != 0) {
      paramJceOutputStream.write(this.type, 2);
    }
    if (this.askType != 0) {
      paramJceOutputStream.write(this.askType, 3);
    }
    if (this.iconType != 0) {
      paramJceOutputStream.write(this.iconType, 4);
    }
    if (this.bgColor != 0) {
      paramJceOutputStream.write(this.bgColor, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     MConch.TipsInfo
 * JD-Core Version:    0.7.0.1
 */