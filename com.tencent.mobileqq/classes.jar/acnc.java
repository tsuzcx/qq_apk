import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.widget.FileWebView;
import com.tencent.qphone.base.util.QLog;

class acnc
  implements Runnable
{
  acnc(acnb paramacnb) {}
  
  public void run()
  {
    this.a.a.a.c = System.currentTimeMillis();
    try
    {
      this.a.a.a.a.loadUrl("javascript:qpreview.onClientResponse('addMorePage',{})");
      QLog.i("<FileAssistant>FilePreviewActivity", 1, "javascript:qpreview.onClientResponse('addMorePage',{})");
      return;
    }
    catch (Exception localException)
    {
      QLog.e("<FileAssistant>FilePreviewActivity", 1, localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acnc
 * JD-Core Version:    0.7.0.1
 */