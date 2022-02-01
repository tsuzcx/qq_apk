package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqUpgradeSettings
  extends JceStruct
{
  static ArrayList<Setting> cache_Settings;
  public ArrayList<Setting> Settings = null;
  public int Type = 0;
  
  public ReqUpgradeSettings() {}
  
  public ReqUpgradeSettings(int paramInt, ArrayList<Setting> paramArrayList)
  {
    this.Type = paramInt;
    this.Settings = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Type = paramJceInputStream.read(this.Type, 0, true);
    if (cache_Settings == null)
    {
      cache_Settings = new ArrayList();
      Setting localSetting = new Setting();
      cache_Settings.add(localSetting);
    }
    this.Settings = ((ArrayList)paramJceInputStream.read(cache_Settings, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Type, 0);
    ArrayList localArrayList = this.Settings;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     GeneralSettings.ReqUpgradeSettings
 * JD-Core Version:    0.7.0.1
 */