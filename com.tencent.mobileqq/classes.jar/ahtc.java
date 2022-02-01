import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class ahtc
  extends atfq
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahtc(AIOImageProviderService paramAIOImageProviderService, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected void a(atqb paramatqb)
  {
    long l = paramatqb.a;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahts;
    if ((localFileManagerEntity == null) || (localahts == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + localFileManagerEntity + "] callback[" + localahts + "]");
      return;
    }
    int i = 18;
    if (paramatqb.jdField_b_of_type_Int == 5) {
      i = 16;
    }
    if (FileUtil.isFileExists(paramatqb.jdField_b_of_type_JavaLangString))
    {
      localahts.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 1, paramatqb.jdField_b_of_type_JavaLangString, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, paramatqb.jdField_b_of_type_JavaLangString);
      return;
    }
    paramatqb = "";
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("errorType", "thumb_download");
      ((JSONObject)localObject).put("errorCode", localFileManagerEntity.thumbInvalidCode);
      localObject = ((JSONObject)localObject).toString();
      paramatqb = (atqb)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    localahts.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, 2, paramatqb, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(localFileManagerEntity.uniseq, localFileManagerEntity.status, i, "I:E");
  }
  
  protected void a(atqb paramatqb, int paramInt)
  {
    long l = paramatqb.a;
    paramatqb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l);
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahts;
    if ((paramatqb == null) || (localahts == null))
    {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramatqb + "] callback[" + localahts + "]");
      return;
    }
    localahts.a(paramatqb.uniseq, paramatqb.status, 18, paramInt, paramatqb.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahts;
    if ((paramString == null) || (localahts == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString + "] callback[" + localahts + "]");
    }
    while (paramString.nFileType != 0) {
      return;
    }
    localahts.a(paramLong1, 0, 20, (int)(paramString.fProgress * 10000.0F), paramString.fileSize, false);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramLong2);
    ahts localahts = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_Ahts;
    if ((paramString1 == null) || (localahts == null)) {
      QLog.i("AIOImageProviderService", 2, "OnFileTransferProgress: error, entity[" + paramString1 + "] callback[" + localahts + "]");
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
          localahts.a(paramLong1, paramString1.status, 20, 1, paramString1.getFilePath(), false);
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
        auea.a(paramString2, paramString1.getFilePath());
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(paramLong1));
        localahts.a(paramLong1, paramString1.status, 269484034, 1, paramString1.getFilePath(), false);
        return;
        QLog.i("AIOImageProviderService<QFile>", 1, "AIO gallery service error, get context is null [c2c file save album].");
      }
      if ((paramInt2 == -7003) || (paramInt2 == -6101)) {
        paramString1.status = 16;
      }
      if (paramString1.nFileType == 0)
      {
        localahts.a(paramLong1, paramString1.status, 20, 2, paramString2, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(paramLong1, paramString1.status, 20, "I:E");
        return;
      }
    } while (paramString1.nFileType != 2);
    localahts.a(paramLong1, paramString1.status, 269484034, 2, paramString2, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtc
 * JD-Core Version:    0.7.0.1
 */