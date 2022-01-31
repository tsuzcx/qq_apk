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

public class ahbi
  extends bbwt
{
  public ahbi(PreloadManager paramPreloadManager, DownloadParam paramDownloadParam, ahbr paramahbr, WeakReference paramWeakReference) {}
  
  public void onDoneFile(bbwu parambbwu)
  {
    super.onDoneFile(parambbwu);
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "RealTime onDoneFile|" + parambbwu.jdField_a_of_type_Int + "|" + parambbwu.jdField_a_of_type_JavaLangString + "|" + ((File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.jdField_a_of_type_JavaLangString)).getAbsolutePath());
    }
    Object localObject2;
    Object localObject1;
    if ((parambbwu.jdField_a_of_type_Int == 0) && (parambbwu.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(parambbwu.jdField_a_of_type_JavaLangString)))
    {
      localObject2 = (File)parambbwu.jdField_a_of_type_JavaUtilMap.get(parambbwu.jdField_a_of_type_JavaLangString);
      if (localObject2 == null)
      {
        localObject1 = "";
        localObject1 = MD5Coding.encodeFile2HexStr((String)localObject1);
        if ((localObject2 == null) || (!((File)localObject2).exists()) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label266;
        }
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.md5ForChecked)) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.md5ForChecked.equalsIgnoreCase((String)localObject1))) {
          break label236;
        }
        if (this.jdField_a_of_type_Ahbr != null) {
          this.jdField_a_of_type_Ahbr.onResult(2, PreloadManager.PathResult.getFailRes(parambbwu.jdField_a_of_type_JavaLangString));
        }
        PreloadManager.a(parambbwu.jdField_a_of_type_JavaLangString, false, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        ahia.a(2, parambbwu.c, parambbwu.jdField_a_of_type_Int);
      }
    }
    label236:
    label376:
    label378:
    do
    {
      for (;;)
      {
        return;
        localObject1 = ((File)localObject2).getAbsolutePath();
        break;
        ahcu.a(parambbwu.jdField_a_of_type_JavaLangString, (String)localObject1, NetConnInfoCenter.getServerTimeMillis(), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
        ahia.a(0, parambbwu.c, parambbwu.jdField_a_of_type_Int);
        for (;;)
        {
          if (!PreloadManager.a((PreloadManager)this.jdField_a_of_type_JavaLangRefWeakReference.get())) {
            break label376;
          }
          if (parambbwu.jdField_a_of_type_Int != 0) {
            break label378;
          }
          localObject1 = ahcu.a(parambbwu.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.isForceUnzip, 0, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadDownloadParam.filePos);
          localObject2 = new PreloadManager.PathResult();
          ((PreloadManager.PathResult)localObject2).url = parambbwu.jdField_a_of_type_JavaLangString;
          ((PreloadManager.PathResult)localObject2).filePath = ((ResourceInfo)localObject1).filePath;
          ((PreloadManager.PathResult)localObject2).folderPath = ((ResourceInfo)localObject1).folderPath;
          if (this.jdField_a_of_type_Ahbr == null) {
            break;
          }
          this.jdField_a_of_type_Ahbr.onResult(0, (PreloadManager.PathResult)localObject2);
          return;
          ahia.a(1, parambbwu.c, parambbwu.jdField_a_of_type_Int);
        }
      }
    } while (this.jdField_a_of_type_Ahbr == null);
    label266:
    this.jdField_a_of_type_Ahbr.onResult(1, PreloadManager.PathResult.getFailRes(parambbwu.jdField_a_of_type_JavaLangString, parambbwu.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahbi
 * JD-Core Version:    0.7.0.1
 */