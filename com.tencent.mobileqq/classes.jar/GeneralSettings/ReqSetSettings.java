package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqSetSettings
  extends JceStruct
{
  static ArrayList<Setting> cache_Settings;
  public ArrayList<Setting> Settings = null;
  
  public ReqSetSettings() {}
  
  public ReqSetSettings(ArrayList<Setting> paramArrayList)
  {
    this.Settings = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_Settings == null)
    {
      cache_Settings = new ArrayList();
      Setting localSetting = new Setting();
      cache_Settings.add(localSetting);
    }
    this.Settings = ((ArrayList)paramJceInputStream.read(cache_Settings, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Settings, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     GeneralSettings.ReqSetSettings
 * JD-Core Version:    0.7.0.1
 */