package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UniBusiSimpleSigItem
  extends JceStruct
{
  public String desc = "";
  public String fontColor = "";
  public int materialVersion = 0;
  public String timeAndLocation = "";
  
  public UniBusiSimpleSigItem() {}
  
  public UniBusiSimpleSigItem(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.materialVersion = paramInt;
    this.fontColor = paramString1;
    this.desc = paramString2;
    this.timeAndLocation = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.materialVersion = paramJceInputStream.read(this.materialVersion, 0, false);
    this.fontColor = paramJceInputStream.readString(1, false);
    this.desc = paramJceInputStream.readString(2, false);
    this.timeAndLocation = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.materialVersion, 0);
    String str = this.fontColor;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.timeAndLocation;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.UniBusiSimpleSigItem
 * JD-Core Version:    0.7.0.1
 */