import com.tencent.mobileqq.ar.ArNativeSoManager;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.ARResourceDownloadCallback;
import com.tencent.mobileqq.ar.arengine.ARPreSoResourceDownload.DownloadInfo;
import com.tencent.qphone.base.util.QLog;

public class aajl
  implements ARPreSoResourceDownload.ARResourceDownloadCallback
{
  public aajl(ArNativeSoManager paramArNativeSoManager, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localARResourceDownloadCallback != null) {
      localARResourceDownloadCallback.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, ARPreSoResourceDownload.DownloadInfo paramDownloadInfo)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramDownloadInfo.c + ", url = " + paramDownloadInfo.a);
    if (paramBoolean) {
      if (!ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c, paramDownloadInfo.b))
      {
        ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, paramDownloadInfo.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    ARPreSoResourceDownload.ARResourceDownloadCallback localARResourceDownloadCallback;
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager.a(paramDownloadInfo.d, paramDownloadInfo.c, paramDownloadInfo.b) == 0) {}
      localARResourceDownloadCallback = ArNativeSoManager.a(this.jdField_a_of_type_ComTencentMobileqqArArNativeSoManager, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localARResourceDownloadCallback == null);
    localARResourceDownloadCallback.a(paramBoolean, paramDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aajl
 * JD-Core Version:    0.7.0.1
 */