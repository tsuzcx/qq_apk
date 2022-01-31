import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class aari
  extends aark
{
  public String a;
  HashMap a;
  String b;
  
  public aari(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  boolean a(Resources paramResources)
  {
    String str1 = this.jdField_a_of_type_JavaLangString + "menuicon_moving/";
    int i = 0;
    while (i < 4)
    {
      String str2 = "img_" + i + ".png";
      Bitmap localBitmap = RedBagUtil.a(str1 + "images/" + str2, paramResources.getDisplayMetrics().densityDpi, paramResources.getDisplayMetrics().densityDpi);
      if (localBitmap == null) {
        return false;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(str2, localBitmap);
      i += 1;
    }
    paramResources = new File(str1, "down.json");
    if (!paramResources.exists())
    {
      QLog.i(this.c, 1, "ResInfoForDownAni, json文件不存在");
      return false;
    }
    if (!new File(str1, "images").exists())
    {
      QLog.i(this.c, 1, "ResInfoForDownAni, image不存在");
      return false;
    }
    paramResources = WorldCupMgr.a(paramResources.getAbsolutePath());
    if (TextUtils.isEmpty(paramResources)) {
      QLog.i(this.c, 1, "ResInfoForDownAni, json读取失败");
    }
    this.b = paramResources;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aari
 * JD-Core Version:    0.7.0.1
 */