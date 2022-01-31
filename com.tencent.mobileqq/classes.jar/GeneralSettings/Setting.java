package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Setting
  extends JceStruct
{
  public String Path = "";
  public String Value = "";
  
  public Setting() {}
  
  public Setting(String paramString1, String paramString2)
  {
    this.Path = paramString1;
    this.Value = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Path = paramJceInputStream.readString(0, true);
    this.Value = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Path, 0);
    if (this.Value != null) {
      paramJceOutputStream.write(this.Value, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GeneralSettings.Setting
 * JD-Core Version:    0.7.0.1
 */