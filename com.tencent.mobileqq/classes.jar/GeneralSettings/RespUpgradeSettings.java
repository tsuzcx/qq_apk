package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RespUpgradeSettings
  extends JceStruct
{
  public int Result;
  
  public RespUpgradeSettings() {}
  
  public RespUpgradeSettings(int paramInt)
  {
    this.Result = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Result = paramJceInputStream.read(this.Result, 0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Result, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GeneralSettings.RespUpgradeSettings
 * JD-Core Version:    0.7.0.1
 */