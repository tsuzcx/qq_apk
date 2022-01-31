import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.qphone.base.util.QLog;

class alwc
  extends bbwt
{
  alwc(alvy paramalvy, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    QLog.d("ArkApp.ArkMultiProcUtil", 1, String.format("download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(parambbwu.a) }));
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(parambbwu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alwc
 * JD-Core Version:    0.7.0.1
 */