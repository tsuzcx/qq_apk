import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class ahbg
  extends ahcc
{
  ahbg(ahbf paramahbf, bbwt parambbwt)
  {
    super(parambbwt);
  }
  
  public void onDoneFile(bbwu parambbwu)
  {
    long l2 = -1L;
    super.onDoneFile(parambbwu);
    if ((parambbwu != null) && (parambbwu.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambbwu.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (ayxs)((QQAppInterface)localObject).getManager(193);
          String str = parambbwu.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambbwu.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((ayxs)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbg
 * JD-Core Version:    0.7.0.1
 */