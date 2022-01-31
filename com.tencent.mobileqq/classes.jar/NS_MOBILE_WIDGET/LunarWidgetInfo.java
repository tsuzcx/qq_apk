package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class LunarWidgetInfo
  extends JceStruct
{
  public byte animal;
  public String cheng = "";
  public String chong = "";
  public String ji = "";
  public String jiex = "";
  public String lunar_d = "";
  public String lunar_ex = "";
  public String lunar_m = "";
  public String sha = "";
  public String solar = "";
  public String taishen = "";
  public String week = "";
  public String yi = "";
  public String yiex = "";
  public String zhengchong = "";
  
  public LunarWidgetInfo() {}
  
  public LunarWidgetInfo(byte paramByte, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14)
  {
    this.animal = paramByte;
    this.lunar_m = paramString1;
    this.lunar_d = paramString2;
    this.lunar_ex = paramString3;
    this.solar = paramString4;
    this.week = paramString5;
    this.yi = paramString6;
    this.ji = paramString7;
    this.chong = paramString8;
    this.sha = paramString9;
    this.cheng = paramString10;
    this.zhengchong = paramString11;
    this.taishen = paramString12;
    this.yiex = paramString13;
    this.jiex = paramString14;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.animal = paramJceInputStream.read(this.animal, 0, false);
    this.lunar_m = paramJceInputStream.readString(1, false);
    this.lunar_d = paramJceInputStream.readString(2, false);
    this.lunar_ex = paramJceInputStream.readString(3, false);
    this.solar = paramJceInputStream.readString(4, false);
    this.week = paramJceInputStream.readString(5, false);
    this.yi = paramJceInputStream.readString(6, false);
    this.ji = paramJceInputStream.readString(7, false);
    this.chong = paramJceInputStream.readString(8, false);
    this.sha = paramJceInputStream.readString(9, false);
    this.cheng = paramJceInputStream.readString(10, false);
    this.zhengchong = paramJceInputStream.readString(11, false);
    this.taishen = paramJceInputStream.readString(12, false);
    this.yiex = paramJceInputStream.readString(13, false);
    this.jiex = paramJceInputStream.readString(14, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.animal, 0);
    if (this.lunar_m != null) {
      paramJceOutputStream.write(this.lunar_m, 1);
    }
    if (this.lunar_d != null) {
      paramJceOutputStream.write(this.lunar_d, 2);
    }
    if (this.lunar_ex != null) {
      paramJceOutputStream.write(this.lunar_ex, 3);
    }
    if (this.solar != null) {
      paramJceOutputStream.write(this.solar, 4);
    }
    if (this.week != null) {
      paramJceOutputStream.write(this.week, 5);
    }
    if (this.yi != null) {
      paramJceOutputStream.write(this.yi, 6);
    }
    if (this.ji != null) {
      paramJceOutputStream.write(this.ji, 7);
    }
    if (this.chong != null) {
      paramJceOutputStream.write(this.chong, 8);
    }
    if (this.sha != null) {
      paramJceOutputStream.write(this.sha, 9);
    }
    if (this.cheng != null) {
      paramJceOutputStream.write(this.cheng, 10);
    }
    if (this.zhengchong != null) {
      paramJceOutputStream.write(this.zhengchong, 11);
    }
    if (this.taishen != null) {
      paramJceOutputStream.write(this.taishen, 12);
    }
    if (this.yiex != null) {
      paramJceOutputStream.write(this.yiex, 13);
    }
    if (this.jiex != null) {
      paramJceOutputStream.write(this.jiex, 14);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MOBILE_WIDGET.LunarWidgetInfo
 * JD-Core Version:    0.7.0.1
 */