import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class abfj
  implements biqk
{
  abfj(abff paramabff, long paramLong, String paramString) {}
  
  public void onCheckOfflineFinish(int paramInt)
  {
    this.jdField_a_of_type_Abff.c = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + this.jdField_a_of_type_Abff.c + ", url: " + noe.b(this.jdField_a_of_type_JavaLangString, new String[0]));
    }
    this.jdField_a_of_type_Abff.a(this.jdField_a_of_type_JavaLangString, paramInt);
    CustomWebView localCustomWebView = this.jdField_a_of_type_Abff.mRuntime.a();
    if (localCustomWebView != null)
    {
      localCustomWebView.loadUrlOriginal(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfj
 * JD-Core Version:    0.7.0.1
 */