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
    if (this.openID != null) {
      paramJceOutputStream.write(this.openID, 0);
    }
    if (this.groupCode != null) {
      paramJceOutputStream.write(this.groupCode, 1);
    }
    if (this.groupOpenID != null) {
      paramJceOutputStream.write(this.groupOpenID, 2);
    }
    if (this.groupName != null) {
      paramJceOutputStream.write(this.groupName, 3);
    }
    if (this.groupAvatar != null) {
      paramJceOutputStream.write(this.groupAvatar, 4);
    }
    if (this.groupAuth != null) {
      paramJceOutputStream.write(this.groupAuth, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     UserGrowth.stQQGroupInfo
 * JD-Core Version:    0.7.0.1
 */