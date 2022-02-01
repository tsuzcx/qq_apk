import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ahac
  extends asbj
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahac(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    ahas localahas = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahas;
    if ((paramString1 == null) || (localahas == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString1 + "] callback[" + localahas + "]");
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
          localahas.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
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
        aszt.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localahas.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localahas.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localahas.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    ahas localahas = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahas;
    if ((paramString == null) || (localahas == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString + "] callback[" + localahas + "]");
    }
    while (paramString.nFileType != 0) {
      return;
    }
    localahas.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void onThumbDownLoadProgress(aslv paramaslv, int paramInt)
  {
    long l = paramaslv.a;
    paramaslv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    ahas localahas = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahas;
    if ((paramaslv == null) || (localahas == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramaslv + "] callback[" + localahas + "]");
      return;
    }
    localahas.a(paramaslv.uniseq, paramaslv.status, 18, paramInt, paramaslv.fileSize, false);
  }
  
  protected void onThumbDownLoadSuccess(aslv paramaslv)
  {
    long l = paramaslv.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    ahas localahas = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahas;
    if ((localFileManagerEntity == null) || (localahas == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + localFileManagerEntity + "] callback[" + localahas + "]");
      return;
    }
    int i = 18;
    if (paramaslv.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (FileUtil.isFileExists(paramaslv.jdField_b_of_type_JavaLangString))
    {
      localahas.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramaslv.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramaslv.jdField_b_of_type_JavaLangString);
      return;
    }
    paramaslv = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramaslv = (aslv)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localahas.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramaslv, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahac
 * JD-Core Version:    0.7.0.1
 */