import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.qphone.base.util.QLog;

public class aidk
  implements atvu
{
  public aidk(AIOImageProviderService paramAIOImageProviderService, aufc paramaufc, long paramLong) {}
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localaiec == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: callback = null , ctxId[" + this.jdField_a_of_type_Aufc.a() + "] ");
      return;
    }
    paramInt1 = (int)((float)paramLong1 / (float)paramLong2 * 10000.0F);
    localaiec.a(this.jdField_a_of_type_Long, 0, 269484035, paramInt1, paramLong2, false);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localaiec == null)
    {
      QLog.i("AIOImageProviderService", 2, "onDownloadProgressUpdate: error, ctxId[" + this.jdField_a_of_type_Long + "] ");
      return;
    }
    if ((paramInt2 == -7003) || (paramInt2 == -6101)) {}
    for (paramInt1 = 16;; paramInt1 = 0)
    {
      localaiec.a(this.jdField_a_of_type_Long, paramInt1, 269484034, 2, paramString, false);
      return;
    }
  }
  
  public void a(String paramString)
  {
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localaiec == null)
    {
      QLog.i("AIOImageProviderServiceXOXO", 2, "onDownloadFinish callback = null , ctxId[" + this.jdField_a_of_type_Long + "] ");
      return;
    }
    QLog.i("AIOImageProviderService", 1, "-----------> notify download finish:" + this.jdField_a_of_type_Long);
    localaiec.a(this.jdField_a_of_type_Long, 1, 269484034, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidk
 * JD-Core Version:    0.7.0.1
 */