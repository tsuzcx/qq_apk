import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.ar.config.MainEntryAni;
import com.tencent.mobileqq.ar.config.WorldCupMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class aakp
  extends aakq
{
  aajp jdField_a_of_type_Aajp;
  public Bitmap a;
  String jdField_a_of_type_JavaLangString;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  public JSONObject a;
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Aajp = null;
  }
  
  public void a(String paramString, DragFrameLayout paramDragFrameLayout, View paramView)
  {
    this.jdField_a_of_type_Aajp = MainEntryAni.a(paramView);
    if (this.jdField_a_of_type_Aajp != null) {
      MainEntryAni.a(this.jdField_a_of_type_Aajp, paramDragFrameLayout);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  boolean a(Resources paramResources)
  {
    if (this.jdField_a_of_type_Aajp == null) {
      return false;
    }
    String str = this.jdField_a_of_type_JavaLangString + "addbtn_moving/";
    int i = 0;
    for (;;)
    {
      if (i >= 4) {
        break label132;
      }
      localObject = "img_" + i + ".png";
      Bitmap localBitmap = RedBagUtil.a(str + "images/" + (String)localObject, paramResources.getDisplayMetrics().densityDpi, paramResources.getDisplayMetrics().densityDpi);
      if (localBitmap == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put(localObject, localBitmap);
      i += 1;
    }
    label132:
    Object localObject = new File(str, "roll.json");
    if (!((File)localObject).exists())
    {
      QLog.i("WorldCupMgr", 1, "ResInfoForRollAni, json文件不存在");
      return false;
    }
    if (!new File(str, "images").exists())
    {
      QLog.i("WorldCupMgr", 1, "ResInfoForRollAni, images不存在");
      return false;
    }
    this.jdField_a_of_type_OrgJsonJSONObject = WorldCupMgr.a(WorldCupMgr.a(((File)localObject).getAbsolutePath()), (int)(this.jdField_a_of_type_Aajp.a * 2 / paramResources.getDisplayMetrics().density), 0);
    if (this.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      QLog.i("WorldCupMgr", 1, "ResInfoForRollAni, json解析失败");
      return false;
    }
    if (QLog.isDevelopLevel()) {
      WorldCupMgr.a(this.jdField_a_of_type_OrgJsonJSONObject, ((File)localObject).getAbsolutePath() + "_.json");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = RedBagUtil.a(this.jdField_a_of_type_JavaLangString + "addbtn_fixed/0.png", paramResources.getDisplayMetrics().densityDpi, paramResources.getDisplayMetrics().densityDpi);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.i("WorldCupMgr", 1, "ResInfoForRollAni, Football不存在");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakp
 * JD-Core Version:    0.7.0.1
 */