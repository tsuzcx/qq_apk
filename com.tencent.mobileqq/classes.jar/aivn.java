import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;

public class aivn
  extends bdvu
{
  public aivn(PreloadManager paramPreloadManager, DownloadParam paramDownloadParam, aivw paramaivw, WeakReference paramWeakReference) {}
  
  public void onDoneFile(bdvv parambdvv)
  {
    super.onDoneFile(parambdvv);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "RealTime onDoneFile|" + parambdvv.jdField_a_of_type_Int + "|" + parambdvv.jdField_a_of_type_JavaLangString + "|" + ((File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.jdField_a_of_type_JavaLangString)).getAbsolutePath());
    }
    Object localObject2;
    Object localObject1;
    if ((parambdvv.jdField_a_of_type_Int == 0) && (parambdvv.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambdvv.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = (File)parambdvv.jdField_a_of_type_JavaUtilMap.get(parambdvv.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localObject1 = "";
        localObject1 = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localObject2 == null) || (!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label242;
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.md5ForChecked)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.md5ForChecked.equalsIgnoreCase((String)localObject1))) {
          break label224;
        }
        if (this.jdField_a_of_type_Aivw != null) {
          this.jdField_a_of_type_Aivw.onResult(2, PreloadManager.PathResult.getFailRes(parambdvv.jdField_a_of_type_JavaLangString));
        }
        PreloadManager.a(parambdvv.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
      }
    }
    label224:
    label242:
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((File)localObject2).getAbsolutePath();
          break;
          aiwy.a(parambdvv.jdField_a_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        } while (!PreloadManager.a((PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
        if (parambdvv.jdField_a_of_type_Int != 0) {
          break label339;
        }
        localObject1 = aiwy.a(parambdvv.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.isForceUnzip, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        localObject2 = new PreloadManager.PathResult();
        ((PreloadManager.PathResult)localObject2).url = parambdvv.jdField_a_of_type_JavaLangString;
        ((PreloadManager.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
        ((PreloadManager.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
      } while (this.jdField_a_of_type_Aivw == null);
      this.jdField_a_of_type_Aivw.onResult(0, (PreloadManager.PathResult)localObject2);
      return;
    } while (this.jdField_a_of_type_Aivw == null);
    label339:
    this.jdField_a_of_type_Aivw.onResult(1, PreloadManager.PathResult.getFailRes(parambdvv.jdField_a_of_type_JavaLangString, parambdvv.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aivn
 * JD-Core Version:    0.7.0.1
 */