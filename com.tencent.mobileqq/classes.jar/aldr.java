import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import java.util.TimerTask;

public class aldr
  extends TimerTask
{
  public aldr(BaseInterface paramBaseInterface, WebView paramWebView, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.optLef <= 0)
    {
      cancel();
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.firstIn = true;
    }
    if (this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallbackQueue.size() > 0) {
      this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseInterface.batchCallback(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aldr
 * JD-Core Version:    0.7.0.1
 */