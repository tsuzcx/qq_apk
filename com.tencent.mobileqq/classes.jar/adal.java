import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.WeiYunPreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.qphone.base.util.QLog;

public class adal
  extends FMObserver
{
  public adal(WeiYunPreviewController paramWeiYunPreviewController) {}
  
  protected void c(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("PreviewStep_1", 4, "SUCCESS OnFileWeiYunPreview harcode[" + FMConfig.a + "]");
    }
    if (FMConfig.a)
    {
      paramString4 = "183.61.37.13";
      paramString5 = "443";
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback != null) {}
    }
    else
    {
      if ((paramString4 != null) && (paramString4.length() > 0)) {}
      for (;;)
      {
        paramString5 = String.valueOf(paramInt2);
        break;
        paramString4 = paramString5;
      }
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback.a(paramBoolean, paramString4, paramString5, paramInt1, paramString1, paramString2, paramString3, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adal
 * JD-Core Version:    0.7.0.1
 */