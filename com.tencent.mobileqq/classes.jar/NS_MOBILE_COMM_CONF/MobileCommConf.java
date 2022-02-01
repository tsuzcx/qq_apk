package NS_MOBILE_COMM_CONF;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class MobileCommConf
  extends JceStruct
{
  static NewMobileGlobalConf cache_new_mobile_global_conf = new NewMobileGlobalConf();
  static NewMobileUserConf cache_new_mobile_user_conf = new NewMobileUserConf();
  static ArrayList<String> cache_vecAppList = new ArrayList();
  public int maxScanNum = 0;
  public NewMobileGlobalConf new_mobile_global_conf = null;
  public NewMobileUserConf new_mobile_user_conf = null;
  public ArrayList<String> vecAppList = null;
  
  static
  {
    cache_vecAppList.add("");
  }
  
  public MobileCommConf() {}
  
  public MobileCommConf(NewMobileGlobalConf paramNewMobileGlobalConf, NewMobileUserConf paramNewMobileUserConf, ArrayList<String> paramArrayList, int paramInt)
  {
    this.new_mobile_global_conf = paramNewMobileGlobalConf;
    this.new_mobile_user_conf = paramNewMobileUserConf;
    this.vecAppList = paramArrayList;
    this.maxScanNum = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.new_mobile_global_conf = ((NewMobileGlobalConf)paramJceInputStream.read(cache_new_mobile_global_conf, 0, false));
    this.new_mobile_user_conf = ((NewMobileUserConf)paramJceInputStream.read(cache_new_mobile_user_conf, 1, false));
    this.vecAppList = ((ArrayList)paramJceInputStream.read(cache_vecAppList, 2, false));
    this.maxScanNum = paramJceInputStream.read(this.maxScanNum, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    Object localObject = this.new_mobile_global_conf;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 0);
    }
    localObject = this.new_mobile_user_conf;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.vecAppList;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    paramJceOutputStream.write(this.maxScanNum, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MOBILE_COMM_CONF.MobileCommConf
 * JD-Core Version:    0.7.0.1
 */