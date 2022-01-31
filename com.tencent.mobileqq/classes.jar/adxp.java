import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;

public class adxp
  extends aodp
{
  public adxp(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface) {}
  
  protected void a(aooa paramaooa)
  {
    long l = paramaooa.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localFileManagerEntity == null) {}
    adyh localadyh;
    do
    {
      return;
      localadyh = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Adyh;
    } while (localadyh == null);
    int i = 18;
    if (paramaooa.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (apdh.a(paramaooa.jdField_b_of_type_JavaLangString))
    {
      localadyh.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramaooa.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramaooa.jdField_b_of_type_JavaLangString);
      return;
    }
    localadyh.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, null, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(aooa paramaooa, int paramInt)
  {
    long l = paramaooa.a;
    paramaooa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (paramaooa == null) {}
    adyh localadyh;
    do
    {
      return;
      localadyh = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Adyh;
    } while ((localadyh == null) || (paramaooa == null));
    localadyh.a(paramaooa.uniseq, paramaooa.status, 18, paramInt, paramaooa.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString == null) {}
    adyh localadyh;
    do
    {
      do
      {
        return;
        localadyh = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Adyh;
      } while ((localadyh == null) || (paramString == null));
      if (paramString.nFileType == 0)
      {
        localadyh.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
        return;
      }
    } while (paramString.nFileType != 2);
    localadyh.a(paramLong1, 0, 1, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString1 == null) {}
    adyh localadyh;
    do
    {
      do
      {
        do
        {
          return;
          localadyh = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Adyh;
        } while (localadyh == null);
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localadyh.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        apck.a(BaseActivity.sTopActivity, paramString1.getFilePath());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
      }
      localadyh.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
      return;
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localadyh.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localadyh.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxp
 * JD-Core Version:    0.7.0.1
 */