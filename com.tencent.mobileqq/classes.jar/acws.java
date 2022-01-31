import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.qphone.base.util.QLog;

public class acws
  extends FMObserver
{
  public acws(OfflinePreviewController paramOfflinePreviewController) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    label110:
    for (;;)
    {
      try
      {
        if (FMConfig.a)
        {
          paramString4 = "183.61.37.13";
          paramString5 = "443";
          if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback.a(paramBoolean, paramString4, paramString5, paramInt1, paramString1, paramString3, paramString2, this.a.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          if ((paramString4 == null) || (paramString4.length() <= 0)) {
            break label110;
          }
          paramString5 = String.valueOf(paramInt2);
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(this.a.b, 2, " callback is null");
          continue;
          paramString4 = paramString5;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acws
 * JD-Core Version:    0.7.0.1
 */