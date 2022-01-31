import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class agjr
  extends aqru
{
  public agjr(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface) {}
  
  protected void a(arcg paramarcg)
  {
    long l = paramarcg.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localFileManagerEntity == null) {}
    agkl localagkl;
    do
    {
      return;
      localagkl = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agkl;
    } while (localagkl == null);
    int i = 18;
    if (paramarcg.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (arso.a(paramarcg.jdField_b_of_type_JavaLangString))
    {
      localagkl.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramarcg.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramarcg.jdField_b_of_type_JavaLangString);
      return;
    }
    paramarcg = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramarcg = (arcg)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localagkl.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramarcg, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(arcg paramarcg, int paramInt)
  {
    long l = paramarcg.a;
    paramarcg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (paramarcg == null) {}
    agkl localagkl;
    do
    {
      return;
      localagkl = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agkl;
    } while ((localagkl == null) || (paramarcg == null));
    localagkl.a(paramarcg.uniseq, paramarcg.status, 18, paramInt, paramarcg.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString == null) {}
    agkl localagkl;
    do
    {
      do
      {
        return;
        localagkl = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agkl;
      } while ((localagkl == null) || (paramString == null));
      if (paramString.nFileType == 0)
      {
        localagkl.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
        return;
      }
    } while (paramString.nFileType != 2);
    localagkl.a(paramLong1, 0, 1, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString1 == null) {}
    agkl localagkl;
    label176:
    do
    {
      do
      {
        do
        {
          return;
          localagkl = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agkl;
        } while (localagkl == null);
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localagkl.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
        if (paramString2 == null) {
          break label176;
        }
        arrr.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localagkl.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localagkl.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localagkl.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */