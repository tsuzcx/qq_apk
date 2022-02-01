import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class aidm
  extends atpa
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aidm(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void a(atzl paramatzl)
  {
    long l = paramatzl.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aiec;
    if ((localFileManagerEntity == null) || (localaiec == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + localFileManagerEntity + "] callback[" + localaiec + "]");
      return;
    }
    int i = 18;
    if (paramatzl.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (auog.a(paramatzl.jdField_b_of_type_JavaLangString))
    {
      localaiec.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramatzl.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramatzl.jdField_b_of_type_JavaLangString);
      return;
    }
    paramatzl = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramatzl = (atzl)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localaiec.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramatzl, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(atzl paramatzl, int paramInt)
  {
    long l = paramatzl.a;
    paramatzl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l);
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aiec;
    if ((paramatzl == null) || (localaiec == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramatzl + "] callback[" + localaiec + "]");
      return;
    }
    localaiec.a(paramatzl.uniseq, paramatzl.status, 18, paramInt, paramatzl.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aiec;
    if ((paramString == null) || (localaiec == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString + "] callback[" + localaiec + "]");
    }
    while (paramString.nFileType != 0) {
      return;
    }
    localaiec.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2);
    aiec localaiec = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Aiec;
    if ((paramString1 == null) || (localaiec == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString1 + "] callback[" + localaiec + "]");
    }
    label217:
    do
    {
      do
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (paramString1.nFileType == 0)
        {
          localaiec.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, paramString1.getFilePath());
          return;
        }
      } while (paramString1.nFileType != 2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramLong1)))
      {
        paramString2 = BaseApplicationImpl.sApplication.getBaseContext();
        if (paramString2 == null) {
          break label217;
        }
        aunj.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localaiec.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localaiec.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localaiec.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidm
 * JD-Core Version:    0.7.0.1
 */