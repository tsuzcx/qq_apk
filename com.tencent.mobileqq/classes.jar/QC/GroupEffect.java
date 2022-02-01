package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GroupEffect
  extends JceStruct
{
  static ArrayList<UserConfig> cache_vUserConfig = new ArrayList();
  public int global_effect_id = 0;
  public ArrayList<UserConfig> vUserConfig = null;
  
  static
  {
    UserConfig localUserConfig = new UserConfig();
    cache_vUserConfig.add(localUserConfig);
  }
  
  public GroupEffect() {}
  
  public GroupEffect(ArrayList<UserConfig> paramArrayList, int paramInt)
  {
    this.vUserConfig = paramArrayList;
    this.global_effect_id = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vUserConfig = ((ArrayList)paramJceInputStream.read(cache_vUserConfig, 0, false));
    this.global_effect_id = paramJceInputStream.read(this.global_effect_id, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    ArrayList localArrayList = this.vUserConfig;
    if (localArrayList != null) {
      paramJceOutputStream.write(localArrayList, 0);
    }
    paramJceOutputStream.write(this.global_effect_id, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     QC.GroupEffect
 * JD-Core Version:    0.7.0.1
 */