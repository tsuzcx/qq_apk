package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

public final class GetMiniAppRsp
  extends JceStruct
{
  public static final int RES_FAIL = -1;
  public static final int RES_SUCC = 0;
  static ArrayList<ApkgConfig> cache_apkg_config_list = new ArrayList();
  public int action = 0;
  public ArrayList<ApkgConfig> apkg_config_list = null;
  public int err_code = 0;
  public String extra = "";
  
  static
  {
    ApkgConfig localApkgConfig = new ApkgConfig();
    cache_apkg_config_list.add(localApkgConfig);
  }
  
  public String getErrTips()
  {
    if (!TextUtils.isEmpty(this.extra)) {}
    try
    {
      String str = new JSONObject(this.extra).getString("err_tips");
      return str;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
    }
    return null;
  }
  
  public boolean isRemoveLocalConfig()
  {
    if (!TextUtils.isEmpty(this.extra)) {}
    try
    {
      boolean bool = new JSONObject(this.extra).optBoolean("is_remove_local_config");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      label29:
      break label29;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetMiniAppRsp{err_code=");
    localStringBuilder.append(this.err_code);
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.action);
    localStringBuilder.append(", apkg_config_list=");
    localStringBuilder.append(this.apkg_config_list);
    localStringBuilder.append(", extra='");
    localStringBuilder.append(this.extra);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.err_code, 0);
    paramJceOutputStream.write(this.action, 1);
    Object localObject = this.apkg_config_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 2);
    }
    localObject = this.extra;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     Wallet.GetMiniAppRsp
 * JD-Core Version:    0.7.0.1
 */