import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class akrt
  extends akso
{
  akrt(akrs paramakrs, bhhe parambhhe)
  {
    super(parambhhe);
  }
  
  public void onDoneFile(bhhf parambhhf)
  {
    long l2 = -1L;
    super.onDoneFile(parambhhf);
    if ((parambhhf != null) && (parambhhf.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambhhf.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambhhf.jdField_a_of_type_JavaUtilMap.get(parambhhf.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (beaw)((QQAppInterface)localObject).getManager(193);
          String str = parambhhf.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambhhf.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((beaw)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrt
 * JD-Core Version:    0.7.0.1
 */