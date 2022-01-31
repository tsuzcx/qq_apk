import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager;
import java.util.HashMap;
import java.util.List;

class aikd
  implements aijc
{
  aikd(aikb paramaikb, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = "key_special_sound_list" + this.jdField_a_of_type_Aikb.mRuntime.a().getCurrentAccountUin();
      localObject = (List)QvipSpecialSoundManager.a.get(localObject);
      aikb.a(this.jdField_a_of_type_Aikb, this.jdField_a_of_type_JavaLangString, (List)localObject);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        aikb.a(this.jdField_a_of_type_Aikb, this.jdField_a_of_type_JavaLangString, null);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    aikb.a(this.jdField_a_of_type_Aikb, this.jdField_a_of_type_JavaLangString, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aikd
 * JD-Core Version:    0.7.0.1
 */