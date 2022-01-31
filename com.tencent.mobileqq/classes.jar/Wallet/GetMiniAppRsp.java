package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import org.json.JSONObject;

public final class GetMiniAppRsp
  extends JceStruct
{
  public static final int RES_FAIL = -1;
  public static final int RES_SUCC = 0;
  static ArrayList<ApkgConfig> cache_apkg_config_list = new ArrayList();
  public int action;
  public ArrayList<ApkgConfig> apkg_config_list;
  public int err_code;
  public String extra = "";
  
  static
  {
    ApkgConfig localApkgConfig = new ApkgConfig();
    cache_apkg_config_list.add(localApkgConfig);
  }
  
  public String getErrTips()
  {
    if (!TextUtils.isEmpty(this.extra)) {
      try
      {
        String str = new JSONObject(this.extra).getString("err_tips");
        return str;
      }
      catch (Throwable localThrowable) {}
    }
    return null;
  }
  
  public boolean isRemoveLocalConfig()
  {
    if (!TextUtils.isEmpty(this.extra)) {
      try
      {
        boolean bool = new JSONObject(this.extra).optBoolean("is_remove_local_config");
        return bool;
      }
      catch (Throwable localThrowable) {}
    }
    return false;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.err_code = paramJceInputStream.read(this.err_code, 0, false);
    this.action = paramJceInputStream.read(this.action, 1, false);
    this.apkg_config_list = ((ArrayList)paramJceInputStream.read(cache_apkg_config_list, 2, false));
    this.extra = paramJceInputStream.readString(3, false);
  }
  
  public String toString()
  {
    return "GetMiniAppRsp{err_code=" + this.err_code + ", action=" + this.action + ", apkg_config_list=" + this.apkg_config_list + ", extra='" + this.extra + '\'' + '}';
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.err_code, 0);
    paramJceOutputStream.write(this.action, 1);
    if (this.apkg_config_list != null) {
      paramJceOutputStream.write(this.apkg_config_list, 2);
    }
    if (this.extra != null) {
      paramJceOutputStream.write(this.extra, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     Wallet.GetMiniAppRsp
 * JD-Core Version:    0.7.0.1
 */