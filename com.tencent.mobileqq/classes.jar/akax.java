import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import java.io.File;
import java.util.Map;

class akax
  extends akbt
{
  akax(akaw paramakaw, bgod parambgod)
  {
    super(parambgod);
  }
  
  public void onDoneFile(bgoe parambgoe)
  {
    long l2 = -1L;
    super.onDoneFile(parambgoe);
    if ((parambgoe != null) && (parambgoe.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambgoe.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambgoe.jdField_a_of_type_JavaUtilMap.get(parambgoe.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(193);
          String str = parambgoe.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambgoe.jdField_a_of_type_Int == 0)
          {
            l1 = l2;
            if (localFile.exists()) {
              l1 = localFile.length();
            }
          }
          ((PreDownloadController)localObject).preDownloadSuccess(str, l1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akax
 * JD-Core Version:    0.7.0.1
 */