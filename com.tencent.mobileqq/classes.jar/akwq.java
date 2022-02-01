import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import java.io.File;
import java.util.Map;

class akwq
  extends akxm
{
  akwq(akwp paramakwp, bhyn parambhyn)
  {
    super(parambhyn);
  }
  
  public void onDoneFile(bhyo parambhyo)
  {
    long l2 = -1L;
    super.onDoneFile(parambhyo);
    if ((parambhyo != null) && (parambhyo.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambhyo.jdField_a_of_type_JavaLangString)))
    {
      File localFile = (File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.jdField_a_of_type_JavaLangString);
      if (localFile != null)
      {
        Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null)
        {
          localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
          String str = parambhyo.jdField_a_of_type_JavaLangString;
          long l1 = l2;
          if (parambhyo.jdField_a_of_type_Int == 0)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akwq
 * JD-Core Version:    0.7.0.1
 */