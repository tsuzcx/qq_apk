import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class aivl
  extends aiwg
{
  aivl(aivk paramaivk, bdvu parambdvu)
  {
    super(parambdvu);
  }
  
  public void onDoneFile(bdvv parambdvv)
  {
    long l2 = -1L;
    super.onDoneFile(parambdvv);
    if ((parambdvv != null) && (parambdvv.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambdvv.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (bavr)((QQAppInterface)localObject).getManager(193);
          String str = parambdvv.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambdvv.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((bavr)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivl
 * JD-Core Version:    0.7.0.1
 */