import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aeim
  extends aoun
{
  public aeim(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface) {}
  
  protected void a(apez paramapez)
  {
    long l = paramapez.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localFileManagerEntity == null) {}
    aeje localaeje;
    do
    {
      return;
      localaeje = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aeje;
    } while (localaeje == null);
    int i = 18;
    if (paramapez.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (apvd.a(paramapez.jdField_b_of_type_JavaLangString))
    {
      localaeje.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramapez.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramapez.jdField_b_of_type_JavaLangString);
      return;
    }
    paramapez = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramapez = (apez)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localaeje.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramapez, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(apez paramapez, int paramInt)
  {
    long l = paramapez.a;
    paramapez = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (paramapez == null) {}
    aeje localaeje;
    do
    {
      return;
      localaeje = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aeje;
    } while ((localaeje == null) || (paramapez == null));
    localaeje.a(paramapez.uniseq, paramapez.status, 18, paramInt, paramapez.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString == null) {}
    aeje localaeje;
    do
    {
      do
      {
        return;
        localaeje = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aeje;
      } while ((localaeje == null) || (paramString == null));
      if (paramString.nFileType == 0)
      {
        localaeje.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
        return;
      }
    } while (paramString.nFileType != 2);
    localaeje.a(paramLong1, 0, 1, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString1 == null) {}
    aeje localaeje;
    do
    {
      do
      {
        do
        {
          return;
          localaeje = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aeje;
        } while (localaeje == null);
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localaeje.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        apug.a(BaseActivity.sTopActivity, paramString1.getFilePath());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
      }
      localaeje.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
      return;
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localaeje.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localaeje.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeim
 * JD-Core Version:    0.7.0.1
 */