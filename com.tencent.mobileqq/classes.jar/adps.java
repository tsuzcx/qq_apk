import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.UUID;

public final class adps
  implements IForwardCallBack
{
  public adps(QQAppInterface paramQQAppInterface) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    return 0L;
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    if (paramInt1 == 3000) {
      paramInt1 = 106;
    }
    TroopFileTransferManager localTroopFileTransferManager;
    for (;;)
    {
      localTroopFileTransferManager = TroopFileTransferManager.a(this.a, Long.valueOf(paramString2).longValue());
      if (localTroopFileTransferManager != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "send2Troop: troopuin error");
      }
      return null;
      if (paramInt1 == 6000) {
        paramInt1 = 38;
      } else {
        paramInt1 = 3;
      }
    }
    paramInt2 = Math.abs(new Random().nextInt());
    FileManagerEntity localFileManagerEntity = this.a.a().a(paramLong2);
    paramString1 = localTroopFileTransferManager.a(paramString3, paramString4, null, paramLong1, paramInt1, paramInt2, Long.valueOf(paramString1).longValue(), paramLong2, localFileManagerEntity);
    long l = 0L;
    paramInt1 = FileManagerUtil.a(paramString1.jdField_a_of_type_JavaLangString);
    if ((FileUtil.a(paramString1.jdField_a_of_type_JavaLangString)) && ((paramInt1 == 0) || (paramInt1 == 2))) {
      if (paramInt1 == 0)
      {
        paramString3 = new BitmapFactory.Options();
        paramString3.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString1.jdField_a_of_type_JavaLangString, paramString3);
        paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString1.g, paramString1.b, paramString1.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(paramString1.jdField_a_of_type_Long), paramLong2, paramString3.outWidth, paramString3.outHeight);
      }
    }
    for (;;)
    {
      if (localFileManagerEntity != null)
      {
        localFileManagerEntity.structMsgSeq = paramLong1;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerUtil<FileAssistant>", 2, "prepareForward2Troop==>InsertAIOMsg, msgSeq:" + paramLong1);
        }
      }
      return paramString1.jdField_a_of_type_JavaUtilUUID.toString();
      paramLong1 = l;
      if (paramInt1 == 2)
      {
        paramString3 = ShortVideoUtils.a(paramString1.jdField_a_of_type_JavaLangString);
        paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString1.g, paramString1.b, paramString1.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(paramString1.jdField_a_of_type_Long), paramLong2, paramString3[0], paramString3[1], paramString3[2]);
        continue;
        if (localFileManagerEntity != null) {
          paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString4, paramLong1, paramString1.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(8888L), paramLong2, localFileManagerEntity.imgWidth, localFileManagerEntity.imgHeight, 0);
        } else {
          paramLong1 = TroopFileUtils.a(this.a, paramString2, paramString4, paramLong1, paramString1.jdField_a_of_type_JavaUtilUUID.toString(), paramInt2, String.valueOf(8888L), paramLong2);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 2, "getTroopProcessCallback->onResult2Troop{bSuccess[" + paramBoolean + "],troopFileUuid[" + paramString1 + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString2 + "],troopUin[" + paramString3 + "],newFilePath[" + paramString4 + "]}");
    }
    paramString3 = TroopFileTransferManager.a(this.a, Long.valueOf(paramString3).longValue());
    if (paramString3 != null) {
      paramString3.a(paramLong, UUID.fromString(paramString1), null, paramInt, paramString4, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adps
 * JD-Core Version:    0.7.0.1
 */