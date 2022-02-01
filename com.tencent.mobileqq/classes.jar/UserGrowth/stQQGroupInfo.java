package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stQQGroupInfo
  extends JceStruct
{
  public String groupAuth = "";
  public String groupAvatar = "";
  public String groupCode = "";
  public String groupName = "";
  public String groupOpenID = "";
  public String openID = "";
  
  public stQQGroupInfo() {}
  
  public stQQGroupInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.openID = paramString1;
    this.groupCode = paramString2;
    this.groupOpenID = paramString3;
    this.groupName = paramString4;
    this.groupAvatar = paramString5;
    this.groupAuth = paramString6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.openID = paramJceInputStream.readString(0, false);
    this.groupCode = paramJceInputStream.readString(1, false);
    this.groupOpenID = paramJceInputStream.readString(2, false);
    this.groupName = paramJceInputStream.readString(3, false);
    this.groupAvatar = paramJceInputStream.readString(4, false);
    this.groupAuth = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.openID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.groupCode;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.groupOpenID;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.groupName;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.groupAvatar;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.groupAuth;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stQQGroupInfo
 * JD-Core Version:    0.7.0.1
 */