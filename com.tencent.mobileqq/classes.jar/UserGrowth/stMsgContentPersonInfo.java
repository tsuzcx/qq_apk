package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stMsgContentPersonInfo
  extends JceStruct
{
  public String PID = "";
  public int beFollow = 0;
  public int isFriend = 0;
  public int metaPersonMedal = 0;
  
  public stMsgContentPersonInfo() {}
  
  public stMsgContentPersonInfo(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.PID = paramString;
    this.beFollow = paramInt1;
    this.metaPersonMedal = paramInt2;
    this.isFriend = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.PID = paramJceInputStream.readString(0, false);
    this.beFollow = paramJceInputStream.read(this.beFollow, 1, false);
    this.metaPersonMedal = paramJceInputStream.read(this.metaPersonMedal, 2, false);
    this.isFriend = paramJceInputStream.read(this.isFriend, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.PID;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.beFollow, 1);
    paramJceOutputStream.write(this.metaPersonMedal, 2);
    paramJceOutputStream.write(this.isFriend, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stMsgContentPersonInfo
 * JD-Core Version:    0.7.0.1
 */