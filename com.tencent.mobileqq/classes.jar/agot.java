import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.File;
import java.util.Map;

class agot
  extends agpp
{
  agot(agos paramagos, batl parambatl)
  {
    super(parambatl);
  }
  
  public void onDoneFile(batm parambatm)
  {
    long l2 = -1L;
    super.onDoneFile(parambatm);
    if ((parambatm != null) && (parambatm.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambatm.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambatm.jdField_a_of_type_JavaUtilMap.get(parambatm.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (axxj)((QQAppInterface)localObject).getManager(193);
          String str = parambatm.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambatm.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((axxj)localObject).a(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agot
 * JD-Core Version:    0.7.0.1
 */