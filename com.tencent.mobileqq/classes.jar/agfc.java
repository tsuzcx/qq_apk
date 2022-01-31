import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class agfc
  extends aqnl
{
  public agfc(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface) {}
  
  protected void a(aqxx paramaqxx)
  {
    long l = paramaqxx.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (localFileManagerEntity == null) {}
    agfw localagfw;
    do
    {
      return;
      localagfw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agfw;
    } while (localagfw == null);
    int i = 18;
    if (paramaqxx.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (arof.a(paramaqxx.jdField_b_of_type_JavaLangString))
    {
      localagfw.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramaqxx.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramaqxx.jdField_b_of_type_JavaLangString);
      return;
    }
    paramaqxx = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramaqxx = (aqxx)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localagfw.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramaqxx, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(aqxx paramaqxx, int paramInt)
  {
    long l = paramaqxx.a;
    paramaqxx = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    if (paramaqxx == null) {}
    agfw localagfw;
    do
    {
      return;
      localagfw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agfw;
    } while ((localagfw == null) || (paramaqxx == null));
    localagfw.a(paramaqxx.uniseq, paramaqxx.status, 18, paramInt, paramaqxx.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString == null) {}
    agfw localagfw;
    do
    {
      do
      {
        return;
        localagfw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agfw;
      } while ((localagfw == null) || (paramString == null));
      if (paramString.nFileType == 0)
      {
        localagfw.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
        return;
      }
    } while (paramString.nFileType != 2);
    localagfw.a(paramLong1, 0, 1, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    if (paramString1 == null) {}
    agfw localagfw;
    label176:
    do
    {
      do
      {
        do
        {
          return;
          localagfw = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Agfw;
        } while (localagfw == null);
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localagfw.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
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
        arni.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localagfw.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localagfw.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localagfw.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfc
 * JD-Core Version:    0.7.0.1
 */