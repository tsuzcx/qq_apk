import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;

public class ahly
{
  public static ahlz a(String paramString)
  {
    return new ahlz(paramString);
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).getString("sv_md5_version_soname_key", "d000_1");
  }
  
  public static String a(File paramFile)
  {
    return FileUtils.a(paramFile);
  }
  
  public static String a(String paramString)
  {
    String str = b(paramString);
    Object localObject;
    if (str != null)
    {
      localObject = str;
      if (!"".equals(str)) {
        break label53;
      }
    }
    try
    {
      localObject = MD5.getFileMd5(paramString);
      VideoEnvironment.a("ShortVideoSoManager:computeMd5[MD5.getFileMd5]md5Data=" + localObject, null);
      localObject = HexUtil.bytes2HexStr((byte[])localObject);
      label53:
      return localObject;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VideoEnvironment.a("ShortVideoSoManager:computeMd5[MD5.getFileMd5] ", localUnsatisfiedLinkError);
    }
    return b(paramString);
  }
  
  public static final String a(String paramString1, String paramString2)
  {
    return paramString1 + '_' + paramString2;
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_mgr_sp", 4).edit();
    localEditor.putString("sv_md5_version_soname_key", paramString);
    boolean bool = localEditor.commit();
    VideoEnvironment.a("ShortVideoSoManager.storeSoNewVersion saveAVCodecOK=" + bool, null);
    return bool;
  }
  
  static String b(String paramString)
  {
    try
    {
      paramString = MD5FileUtil.a(new File(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      VideoEnvironment.a("ShortVideoSoManager:computeMd5[getFileMD5String]", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahly
 * JD-Core Version:    0.7.0.1
 */