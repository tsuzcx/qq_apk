import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class ahbi
  extends ahce
{
  ahbi(ahbh paramahbh, bbwf parambbwf)
  {
    super(parambbwf);
  }
  
  public void onDoneFile(bbwg parambbwg)
  {
    long l2 = -1L;
    super.onDoneFile(parambbwg);
    if ((parambbwg != null) && (parambbwg.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambbwg.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambbwg.jdField_a_of_type_JavaUtilMap.get(parambbwg.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (ayxq)((QQAppInterface)localObject).getManager(193);
          String str = parambbwg.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambbwg.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((ayxq)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbi
 * JD-Core Version:    0.7.0.1
 */