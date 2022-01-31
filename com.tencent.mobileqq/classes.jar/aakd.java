import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.ar.config.WorldCupConfigInfo;
import java.util.HashMap;

public class aakd
  extends aakq
{
  public int a;
  public BitmapDrawable a;
  public WorldCupConfigInfo a;
  public HashMap a;
  public int b;
  HashMap b;
  public int c = 1;
  public int d = 1;
  public int e = 1;
  public int f = 1;
  
  public aakd()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap(2);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap(2);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
    this.jdField_b_of_type_JavaUtilHashMap.clear();
  }
  
  boolean a(Resources paramResources)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.a(0) + "splash/";
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqArConfigWorldCupConfigInfo.b;
    int i = 0;
    while (i < 2)
    {
      localObject = RedBagUtil.a(paramResources, str1 + "splash" + i + ".png");
      if (localObject == null) {
        return false;
      }
      this.jdField_a_of_type_Int = ((Bitmap)localObject).getWidth();
      this.jdField_b_of_type_Int = ((Bitmap)localObject).getHeight();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), new BitmapDrawable((Bitmap)localObject));
      i += 1;
    }
    Object localObject = RedBagUtil.a(paramResources, str1 + "skip_button.png");
    if (localObject == null) {
      return false;
    }
    this.e = ((Bitmap)localObject).getWidth();
    this.f = ((Bitmap)localObject).getHeight();
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable((Bitmap)localObject);
    i = 0;
    while (i < 2)
    {
      String str2 = "img_" + i + ".png";
      if (bool) {}
      for (localObject = "img_" + i + ".png";; localObject = "no_" + i + ".png")
      {
        localObject = RedBagUtil.a(str1 + "images/" + (String)localObject, paramResources.getDisplayMetrics().densityDpi, paramResources.getDisplayMetrics().densityDpi);
        if (localObject != null) {
          break;
        }
        return false;
      }
      this.c = AIOUtils.a(((Bitmap)localObject).getWidth() / 2, paramResources);
      this.d = AIOUtils.a(((Bitmap)localObject).getHeight() / 2, paramResources);
      this.jdField_b_of_type_JavaUtilHashMap.put(str2, localObject);
      i += 1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aakd
 * JD-Core Version:    0.7.0.1
 */