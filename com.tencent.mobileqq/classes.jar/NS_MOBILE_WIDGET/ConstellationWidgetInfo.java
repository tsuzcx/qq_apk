package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ConstellationWidgetInfo
  extends JceStruct
{
  public String bad = "";
  public String color = "";
  public byte consid;
  public String date = "";
  public String desc = "";
  public String good = "";
  public byte health;
  public String icon = "";
  public String interval = "";
  public byte love;
  public byte lucky;
  public byte money;
  public String name = "";
  public String num = "";
  public byte work;
  
  public ConstellationWidgetInfo() {}
  
  public ConstellationWidgetInfo(byte paramByte1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5, String paramString8, byte paramByte6, String paramString9)
  {
    this.consid = paramByte1;
    this.name = paramString1;
    this.interval = paramString2;
    this.good = paramString3;
    this.bad = paramString4;
    this.desc = paramString5;
    this.color = paramString6;
    this.num = paramString7;
    this.love = paramByte2;
    this.work = paramByte3;
    this.money = paramByte4;
    this.health = paramByte5;
    this.date = paramString8;
    this.lucky = paramByte6;
    this.icon = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.consid = paramJceInputStream.read(this.consid, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.interval = paramJceInputStream.readString(2, false);
    this.good = paramJceInputStream.readString(3, false);
    this.bad = paramJceInputStream.readString(4, false);
    this.desc = paramJceInputStream.readString(5, false);
    this.color = paramJceInputStream.readString(6, false);
    this.num = paramJceInputStream.readString(7, false);
    this.love = paramJceInputStream.read(this.love, 8, false);
    this.work = paramJceInputStream.read(this.work, 9, false);
    this.money = paramJceInputStream.read(this.money, 10, false);
    this.health = paramJceInputStream.read(this.health, 11, false);
    this.date = paramJceInputStream.readString(12, false);
    this.lucky = paramJceInputStream.read(this.lucky, 13, false);
    this.icon = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.consid, 0);
    String str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.interval;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.good;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.bad;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    str = this.color;
    if (str != null) {
      paramJceOutputStream.write(str, 6);
    }
    str = this.num;
    if (str != null) {
      paramJceOutputStream.write(str, 7);
    }
    paramJceOutputStream.write(this.love, 8);
    paramJceOutputStream.write(this.work, 9);
    paramJceOutputStream.write(this.money, 10);
    paramJceOutputStream.write(this.health, 11);
    str = this.date;
    if (str != null) {
      paramJceOutputStream.write(str, 12);
    }
    paramJceOutputStream.write(this.lucky, 13);
    str = this.icon;
    if (str != null) {
      paramJceOutputStream.write(str, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_WIDGET.ConstellationWidgetInfo
 * JD-Core Version:    0.7.0.1
 */