import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class alde
  extends alea
{
  alde(aldd paramaldd, biht parambiht)
  {
    super(parambiht);
  }
  
  public void onDoneFile(bihu parambihu)
  {
    long l2 = -1L;
    super.onDoneFile(parambihu);
    if ((parambihu != null) && (parambihu.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambihu.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambihu.jdField_a_of_type_JavaUtilMap.get(parambihu.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (bezv)((QQAppInterface)localObject).getManager(193);
          String str = parambihu.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambihu.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((bezv)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */