import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.qphone.base.util.QLog;

public class ahta
  implements atmk
{
  public ahta(AIOImageProviderService paramAIOImageProviderService, atvt paramatvt, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localahts == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: callback = null , ctxId[" + this.jdField_a_of_type_Atvt.a() + "] ");
      return;
    }
    paramInt1 = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    localahts.a(this.jdField_a_of_type_Long, 0, 269484035, paramInt1, paramLong2, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localahts == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: error, ctxId[" + this.jdField_a_of_type_Long + "] ");
      return;
    }
    if ((paramInt2 == -7003) || (paramInt2 == -6101)) {}
    for (paramInt1 = 16;; paramInt1 = 0)
    {
      localahts.a(this.jdField_a_of_type_Long, paramInt1, 269484034, 2, paramString, false);
      return;
    }
  }
  
  public void a(String paramString)
  {
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localahts == null)
    {
      QLog.i("AIOImageProviderServiceXOXO", 2, "onDownloadFinish callback = null , ctxId[" + this.jdField_a_of_type_Long + "] ");
      return;
    }
    QLog.i("AIOImageProviderService", 1, "-----------> notify download finish:" + this.jdField_a_of_type_Long);
    localahts.a(this.jdField_a_of_type_Long, 1, 269484034, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahta
 * JD-Core Version:    0.7.0.1
 */