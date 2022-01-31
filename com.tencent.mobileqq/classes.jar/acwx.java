import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader;
import com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader.VideoSession;
import com.tencent.qphone.base.util.QLog;

public class acwx
  extends FMObserver
{
  public acwx(OfflineVideoThumbDownLoader paramOfflineVideoThumbDownLoader) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong)
  {
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo, bSuccess[" + paramBoolean + " retCode:" + paramInt1 + " downloadIp:" + paramString4 + " downloadDomain:" + paramString5 + " port:" + paramInt2 + " url:" + paramString6);
    OfflineVideoThumbDownLoader.VideoSession localVideoSession = OfflineVideoThumbDownLoader.a(this.a, paramLong, false);
    if (localVideoSession == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo no this session");
      this.a.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    if (!paramBoolean)
    {
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo url=null");
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2);
      return;
    }
    paramString6 = null;
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      paramString1 = paramString4;
    }
    while ((paramString1 == null) || (paramString1.length() < 0))
    {
      this.a.a.a().a(false, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2);
      return;
      paramString1 = paramString6;
      if (paramString5 != null)
      {
        paramString1 = paramString6;
        if (paramString5.length() > 0) {
          paramString1 = paramString5;
        }
      }
    }
    if ((paramString3 == null) || (paramString3.length() < 0)) {
      QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] OnGetOfflineVideoThumbInfo downloadKey invaild");
    }
    paramString3 = "/ftn_video_pic/rkey=" + paramString3 + "&filetype=" + localVideoSession.b + "&size=" + this.a.a(localVideoSession.jdField_a_of_type_Int) + "&";
    this.a.a(paramLong, true, paramString1, paramInt2, paramString3, null, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acwx
 * JD-Core Version:    0.7.0.1
 */