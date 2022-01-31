import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.util.HashMap;
import java.util.List;

class akbm
  implements akam
{
  akbm(akbl paramakbl, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = "key_special_sound_list" + this.jdField_a_of_type_Akbl.mRuntime.a().getCurrentAccountUin();
      localObject = (List)QvipSpecialSoundManager.a.get(localObject);
      akbl.a(this.jdField_a_of_type_Akbl, this.jdField_a_of_type_JavaLangString, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        akbl.a(this.jdField_a_of_type_Akbl, this.jdField_a_of_type_JavaLangString, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    akbl.a(this.jdField_a_of_type_Akbl, this.jdField_a_of_type_JavaLangString, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akbm
 * JD-Core Version:    0.7.0.1
 */