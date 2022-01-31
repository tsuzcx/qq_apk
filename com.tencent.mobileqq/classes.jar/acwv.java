import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileUploader;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class acwv
  extends FileTransferObserver
{
  public acwv(OfflineSendWorker paramOfflineSendWorker) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [CC Replay] nSessionId[" + paramLong2 + "] SendCC [" + paramBoolean + "], retCode[" + paramLong1 + "]");
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 5, null);
      paramInt = 90460;
      if (-100001L == paramLong1) {
        paramInt = 9043;
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, paramInt, "sendCCFaild");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, paramInt, "sendCCFaild");
      return;
    }
    if (58L == paramLong1)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, 5, null);
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, 58, "ServerMasking");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, 58, "ServerMasking");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (OfflineSendWorker.a(this.a) != null)
    {
      localObject1 = localObject2;
      if (OfflineSendWorker.a(this.a).a() > 0) {
        localObject1 = "ChanedUrlCount[" + OfflineSendWorker.a(this.a).a() + "]";
      }
    }
    if (OfflineSendWorker.a(this.a) != null)
    {
      FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUp", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), OfflineSendWorker.a(this.a).a(), OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).b(), (String)localObject1);
      FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUpDetail", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), OfflineSendWorker.a(this.a).a(), OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).b(), (String)localObject1);
      return;
    }
    FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUp", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), null, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, 0, (String)localObject1);
    FileManagerUtil.a(OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a).nSessionId, "actFileUpDetail", OfflineSendWorker.a(this.a) - OfflineSendWorker.b(this.a), null, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).Uuid, OfflineSendWorker.a(this.a).strFileMd5, 1L, OfflineSendWorker.a(this.a).fileSize, OfflineSendWorker.a(this.a).fileSize, 0, (String)localObject1);
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,onUpdateSetOfflineFileState-->failed");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      int i = 9045;
      if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
        i = 9043;
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, "setSuccFaild");
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, "setSuccFaild");
      return;
    }
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^> [SetFileStatus Step]Id[" + OfflineSendWorker.a(this.a).nSessionId + "]onUpdateSetOfflineFileState success, send CC!");
    OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a), OfflineSendWorker.a(this.a));
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("OfflineSendWorker<FileAssistant>", 2, "=_= ^! Id[" + OfflineSendWorker.a(this.a).nSessionId + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    int i;
    if (!paramBoolean)
    {
      QLog.i("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,onUpdateSendOfflineFile-->failed");
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      i = 9045;
      if (-100001 == paramFileUploadInfo.jdField_a_of_type_Int) {
        i = 9043;
      }
      paramStatictisInfo = "server retError";
      if (paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) {
        paramStatictisInfo = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("OfflineSendWorker<FileAssistant>", 2, "Id[" + OfflineSendWorker.a(this.a).nSessionId + "]wk,handleSendOfflineFileResp");
    }
    if ((paramFileUploadInfo.b == null) || (paramFileUploadInfo.b.length() == 0))
    {
      OfflineSendWorker.a(this.a, 1005);
      OfflineSendWorker.a(this.a).a().a(OfflineSendWorker.a(this.a).uniseq, OfflineSendWorker.a(this.a).nSessionId, OfflineSendWorker.a(this.a).peerUin, OfflineSendWorker.a(this.a).peerType, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      QLog.w("OfflineSendWorker<FileAssistant>", 1, "=_= ^! Id[" + String.valueOf(OfflineSendWorker.a(this.a).nSessionId) + "]ResultCodeNoServerAddr ip = 0");
      i = paramFileUploadInfo.jdField_a_of_type_Int;
      paramStatictisInfo = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
      if (paramFileUploadInfo.jdField_a_of_type_Int == 0)
      {
        i = 9048;
        paramStatictisInfo = "onUpSend ip url error";
      }
      OfflineSendWorker.a(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
      OfflineSendWorker.b(this.a, OfflineSendWorker.a(this.a).fileSize, i, paramStatictisInfo);
      return;
    }
    paramStatictisInfo = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        paramStatictisInfo.add(str + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
      }
    }
    paramStatictisInfo.add(0, paramFileUploadInfo.b + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
    ThreadManager.post(new acww(this, paramFileUploadInfo, paramStatictisInfo), 5, null, false);
  }
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.a.a()) {}
    while (paramFileUploadInfo.jdField_a_of_type_Int != 0) {
      return;
    }
    if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      OfflineSendWorker.a(this.a).Uuid = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.a.c();
      OfflineSendWorker.b(this.a);
      return;
    }
    QLog.e("OfflineSendWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acwv
 * JD-Core Version:    0.7.0.1
 */