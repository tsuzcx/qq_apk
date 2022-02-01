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

public class akws
  extends bhyn
{
  public akws(PreloadManager paramPreloadManager, DownloadParam paramDownloadParam, akxc paramakxc, WeakReference paramWeakReference) {}
  
  public void onDoneFile(bhyo parambhyo)
  {
    super.onDoneFile(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "RealTime onDoneFile|" + parambhyo.jdField_a_of_type_Int + "|" + parambhyo.jdField_a_of_type_JavaLangString + "|" + ((File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.jdField_a_of_type_JavaLangString)).getAbsolutePath());
    }
    Object localObject2;
    Object localObject1;
    if ((parambhyo.jdField_a_of_type_Int == 0) && (parambhyo.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambhyo.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = (File)parambhyo.jdField_a_of_type_JavaUtilMap.get(parambhyo.jdField_a_of_type_JavaLangString);
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
        if (this.jdField_a_of_type_Akxc != null) {
          this.jdField_a_of_type_Akxc.onResult(2, PreloadManager.PathResult.getFailRes(parambhyo.jdField_a_of_type_JavaLangString));
        }
        PreloadManager.a(parambhyo.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
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
          akyh.a(parambhyo.jdField_a_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        } while (!PreloadManager.a((PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get()));
        if (parambhyo.jdField_a_of_type_Int != 0) {
          break label339;
        }
        localObject1 = akyh.a(parambhyo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.isForceUnzip, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        localObject2 = new PreloadManager.PathResult();
        ((PreloadManager.PathResult)localObject2).url = parambhyo.jdField_a_of_type_JavaLangString;
        ((PreloadManager.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
        ((PreloadManager.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
      } while (this.jdField_a_of_type_Akxc == null);
      this.jdField_a_of_type_Akxc.onResult(0, (PreloadManager.PathResult)localObject2);
      return;
    } while (this.jdField_a_of_type_Akxc == null);
    label339:
    this.jdField_a_of_type_Akxc.onResult(1, PreloadManager.PathResult.getFailRes(parambhyo.jdField_a_of_type_JavaLangString, parambhyo.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akws
 * JD-Core Version:    0.7.0.1
 */