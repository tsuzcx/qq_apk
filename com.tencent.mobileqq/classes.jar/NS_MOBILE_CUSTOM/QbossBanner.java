package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QbossBanner
  extends JceStruct
{
  static int cache_eJumpType;
  public int eJumpType = 1;
  public String strH5JumpInfo = "";
  public String strPicUrl = "";
  public String strQbossTrace = "";
  public String strSchema = "";
  
  public QbossBanner() {}
  
  public QbossBanner(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.eJumpType = paramInt;
    this.strPicUrl = paramString1;
    this.strSchema = paramString2;
    this.strH5JumpInfo = paramString3;
    this.strQbossTrace = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eJumpType = paramJceInputStream.read(this.eJumpType, 0, false);
    this.strPicUrl = paramJceInputStream.readString(1, false);
    this.strSchema = paramJceInputStream.readString(2, false);
    this.strH5JumpInfo = paramJceInputStream.readString(3, false);
    this.strQbossTrace = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eJumpType, 0);
    String str = this.strPicUrl;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.strSchema;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.strH5JumpInfo;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
    str = this.strQbossTrace;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.QbossBanner
 * JD-Core Version:    0.7.0.1
 */