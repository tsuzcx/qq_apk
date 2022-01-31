import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class adhj
  implements IForwardCallBack
{
  public adhj(QQAppInterface paramQQAppInterface, int paramInt) {}
  
  public long a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong, int paramInt3)
  {
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.fileUuid = paramString3;
    if (paramString2 != null) {
      localDataLineMsgRecord.uOwnerUin = Long.valueOf(paramString2).longValue();
    }
    localDataLineMsgRecord.selfuin = paramString1;
    localDataLineMsgRecord.filename = paramString4;
    if (paramString5 != null)
    {
      localDataLineMsgRecord.thumbPath = FileUtil.a(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication()), FileManagerUtil.a(paramString5));
      FileUtils.d(paramString5, localDataLineMsgRecord.thumbPath);
    }
    localDataLineMsgRecord.filesize = paramLong;
    localDataLineMsgRecord.busId = paramInt2;
    localDataLineMsgRecord.forwardTroopFileEntrance = paramInt3;
    if (paramInt1 == 0) {
      localDataLineMsgRecord.fileFrom = 1;
    }
    for (localDataLineMsgRecord.nOpType = 29;; localDataLineMsgRecord.nOpType = 31)
    {
      localDataLineMsgRecord.istroop = paramInt1;
      paramString1 = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      localDataLineMsgRecord.sessionid = paramString1.a(0, this.jdField_a_of_type_Int).longValue();
      localDataLineMsgRecord.msg = "";
      localDataLineMsgRecord.issend = 1;
      localDataLineMsgRecord.isread = true;
      localDataLineMsgRecord.issuc = false;
      ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localDataLineMsgRecord);
      localDataLineMsgRecord.time = MessageCache.a();
      localDataLineMsgRecord.progress = 0.2F;
      localDataLineMsgRecord.fileMsgStatus = 0L;
      localDataLineMsgRecord.msgtype = DataLineHandler.c(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(DataLineMsgRecord.getDevTypeBySeId(localDataLineMsgRecord.sessionid)).a(localDataLineMsgRecord, true);
      paramString1.b(7, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf((byte)DataLineHandler.d(localDataLineMsgRecord.msgtype)), Boolean.valueOf(false), Boolean.valueOf(false), Long.valueOf(localDataLineMsgRecord.filesize) });
      return localDataLineMsgRecord.sessionid;
      localDataLineMsgRecord.fileFrom = 2;
    }
  }
  
  public String a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "getDatalineProcessCallBack->onResult bSuccess[" + paramBoolean + "],nSessionId[" + paramLong + "],retCode[" + paramInt + "],retMsg[" + paramString1 + "],uuid[" + paramString2 + "],troopUin[" + paramString3 + "],strNewPath[" + paramString4 + "]");
    }
    if (paramInt != 0)
    {
      if (TextUtils.isEmpty(paramString1))
      {
        FMToastUtil.c(BaseApplicationImpl.getContext().getString(2131428330));
        paramBoolean = false;
      }
    }
    else
    {
      paramString1 = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8);
      if (paramBoolean) {
        break label158;
      }
      paramString1.OnSessionComplete(paramLong, 41, paramInt);
    }
    label158:
    do
    {
      do
      {
        return;
        FMToastUtil.c(paramString1);
        break;
        if (TextUtils.isEmpty(paramString4))
        {
          paramString1.OnSessionComplete(paramLong, 0, paramInt);
          return;
        }
        paramInt = DataLineMsgRecord.getDevTypeBySeId(paramLong);
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramInt).a(paramLong);
      } while (paramString2 == null);
      paramString2.serverPath = paramString4;
      paramString2.nOpType = 1;
      if (paramString2.entityID != 0L)
      {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString2.entityID);
        if (paramString3 != null)
        {
          paramString3.status = 1;
          paramString3.Uuid = paramString2.serverPath;
        }
      }
    } while (!paramString1.a(paramString2));
    paramString1.a(paramString2);
  }
  
  public void a(boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2, String paramString3, String paramString4) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adhj
 * JD-Core Version:    0.7.0.1
 */