package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stGetAllABTestPolicyReq
  extends JceStruct
{
  public boolean hasInstalledWeishi = true;
  public String uin = "";
  
  public stGetAllABTestPolicyReq() {}
  
  public stGetAllABTestPolicyReq(String paramString, boolean paramBoolean)
  {
    this.uin = paramString;
    this.hasInstalledWeishi = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.readString(0, false);
    this.hasInstalledWeishi = paramJceInputStream.read(this.hasInstalledWeishi, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.uin;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    paramJceOutputStream.write(this.hasInstalledWeishi, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     UserGrowth.stGetAllABTestPolicyReq
 * JD-Core Version:    0.7.0.1
 */