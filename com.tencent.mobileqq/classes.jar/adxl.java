import com.tencent.mobileqq.activity.EmosmActivity;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.ArrayList;

public class adxl
  implements asit
{
  public adxl(EmosmActivity paramEmosmActivity) {}
  
  public void onPackageAdded(EmoticonPackage paramEmoticonPackage)
  {
    int i = 0;
    while (i < this.a.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((EmoticonPackage)this.a.jdField_a_of_type_JavaUtilArrayList.get(i)).epId.equals(paramEmoticonPackage.epId)) {
        return;
      }
      i += 1;
    }
    this.a.runOnUiThread(this.a.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void onPackageDeleted(EmoticonPackage paramEmoticonPackage) {}
  
  public void onPackageMoved(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxl
 * JD-Core Version:    0.7.0.1
 */