package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetPluginSettings
  extends JceStruct
{
  static ArrayList<PluginInfo> cache_PluginInfoList;
  public ArrayList<PluginInfo> PluginInfoList = null;
  
  public RespGetPluginSettings() {}
  
  public RespGetPluginSettings(ArrayList<PluginInfo> paramArrayList)
  {
    this.PluginInfoList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_PluginInfoList == null)
    {
      cache_PluginInfoList = new ArrayList();
      PluginInfo localPluginInfo = new PluginInfo();
      cache_PluginInfoList.add(localPluginInfo);
    }
    this.PluginInfoList = ((ArrayList)paramJceInputStream.read(cache_PluginInfoList, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PluginInfoList, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     KQQ.RespGetPluginSettings
 * JD-Core Version:    0.7.0.1
 */