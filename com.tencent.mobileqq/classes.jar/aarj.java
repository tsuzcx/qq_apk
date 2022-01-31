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

public class aarj
  extends aark
{
  aaqg jdField_a_of_type_Aaqg;
  public Bitmap a;
  String jdField_a_of_type_JavaLangString;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  public JSONObject a;
  
  public aarj(String paramString)
  {
    super(paramString);
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_Aaqg = null;
  }
  
  public void a(String paramString, DragFrameLayout paramDragFrameLayout, View paramView)
  {
    this.jdField_a_of_type_Aaqg = MainEntryAni.a(paramView);
    if (this.jdField_a_of_type_Aaqg != null) {
      MainEntryAni.a(this.jdField_a_of_type_Aaqg, paramDragFrameLayout);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  boolean a(Resources paramResources)
  {
    if (this.jdField_a_of_type_Aaqg == null) {
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
      QLog.i(this.c, 1, "ResInfoForRollAni, json文件不存在");
      return false;
    }
    if (!new File(str, "images").exists())
    {
      QLog.i(this.c, 1, "ResInfoForRollAni, images不存在");
      return false;
    }
    str = WorldCupMgr.a(((File)localObject).getAbsolutePath());
    this.jdField_a_of_type_OrgJsonJSONObject = WorldCupMgr.a(this.c, str, (int)(this.jdField_a_of_type_Aaqg.a * 2 / paramResources.getDisplayMetrics().density), 0);
    if (this.jdField_a_of_type_OrgJsonJSONObject == null)
    {
      QLog.i(this.c, 1, "ResInfoForRollAni, json解析失败");
      return false;
    }
    if (QLog.isDevelopLevel()) {
      WorldCupMgr.a(this.c, this.jdField_a_of_type_OrgJsonJSONObject, ((File)localObject).getAbsolutePath() + "_.json");
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = RedBagUtil.a(this.jdField_a_of_type_JavaLangString + "addbtn_fixed/0.png", paramResources.getDisplayMetrics().densityDpi, paramResources.getDisplayMetrics().densityDpi);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.i(this.c, 1, "ResInfoForRollAni, Football不存在");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarj
 * JD-Core Version:    0.7.0.1
 */