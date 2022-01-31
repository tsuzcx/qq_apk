import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aeio
  extends aouj
{
  public aeio(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface) {}
  
  protected void a(apev paramapev)
  {
    long l = paramapev.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localFileManagerEntity == null) {}
    aejg localaejg;
    do
    {
      return;
      localaejg = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aejg;
    } while (localaejg == null);
    int i = 18;
    if (paramapev.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (apvb.a(paramapev.jdField_b_of_type_JavaLangString))
    {
      localaejg.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramapev.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramapev.jdField_b_of_type_JavaLangString);
      return;
    }
    paramapev = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramapev = (apev)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localaejg.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramapev, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(apev paramapev, int paramInt)
  {
    long l = paramapev.a;
    paramapev = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (paramapev == null) {}
    aejg localaejg;
    do
    {
      return;
      localaejg = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aejg;
    } while ((localaejg == null) || (paramapev == null));
    localaejg.a(paramapev.uniseq, paramapev.status, 18, paramInt, paramapev.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString == null) {}
    aejg localaejg;
    do
    {
      do
      {
        return;
        localaejg = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aejg;
      } while ((localaejg == null) || (paramString == null));
      if (paramString.nFileType == 0)
      {
        localaejg.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
        return;
      }
    } while (paramString.nFileType != 2);
    localaejg.a(paramLong1, 0, 1, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString1 == null) {}
    aejg localaejg;
    do
    {
      do
      {
        do
        {
          return;
          localaejg = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aejg;
        } while (localaejg == null);
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localaejg.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        apue.a(BaseActivity.sTopActivity, paramString1.getFilePath());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
      }
      localaejg.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
      return;
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localaejg.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localaejg.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeio
 * JD-Core Version:    0.7.0.1
 */