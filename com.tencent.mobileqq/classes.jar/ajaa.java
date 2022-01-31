import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class ajaa
  extends ajav
{
  ajaa(aizz paramaizz, bead parambead)
  {
    super(parambead);
  }
  
  public void onDoneFile(beae parambeae)
  {
    long l2 = -1L;
    super.onDoneFile(parambeae);
    if ((parambeae != null) && (parambeae.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambeae.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambeae.jdField_a_of_type_JavaUtilMap.get(parambeae.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (bbaa)((QQAppInterface)localObject).getManager(193);
          String str = parambeae.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambeae.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((bbaa)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajaa
 * JD-Core Version:    0.7.0.1
 */