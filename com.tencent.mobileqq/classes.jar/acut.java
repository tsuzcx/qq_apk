import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader;
import com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader.PicSession;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class acut
  extends FileTransferObserver
{
  public acut(DiscPicThumbDownloader paramDiscPicThumbDownloader) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List paramList, int paramInt, String paramString5, long paramLong2)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramList = DiscPicThumbDownloader.a(this.a, paramLong2, false);
    if (paramList == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      this.a.a(paramLong2, false, null, 0, null, null, paramString2);
      return;
    }
    if (paramLong1 != 0L)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      if (paramLong1 == -100001L) {}
      for (;;)
      {
        this.a.a.a().a(false, 51, new Object[] { paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramList.jdField_a_of_type_Int) });
        this.a.a(paramLong2);
        this.a.a(paramLong2, false, null, 0, null, null, paramString2);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.a.a.a().c(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
      }
    }
    if ((paramString3 == null) || (paramByteStringMicro == null))
    {
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "]  get DiscdownLoad info Url is null ");
      if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
      {
        paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        this.a.a.a().c(paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
      if (paramLong1 == 0L) {}
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, null, 0, null, null, paramString2);
      return;
    }
    switch (paramList.jdField_a_of_type_Int)
    {
    default: 
      new StringBuilder().append("http://").append(paramString3).append(":").append(String.valueOf(paramShort)).append(paramString4).toString();
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramList.toString());
      this.a.a.a().a(false, 51, new Object[] { paramList.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramList.jdField_a_of_type_Int) });
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, paramString3, paramShort, paramString4, null, paramString2);
      return;
    case 0: 
      paramString1 = "?pictype=scaled&size=16*16";
    }
    for (;;)
    {
      paramString1 = paramString4 + paramString1;
      this.a.a(paramLong2, true, paramString3, paramShort, paramString1, null, paramString2);
      return;
      paramString1 = "?pictype=scaled&size=32*32";
      continue;
      paramString1 = "?pictype=scaled&size=64*64";
      continue;
      paramString1 = "?pictype=scaled&size=128*128";
      continue;
      paramString1 = "?pictype=scaled&size=320*320";
      continue;
      paramString1 = "?pictype=scaled&size=384*384";
      continue;
      paramString1 = "?pictype=scaled&size=640*640";
      continue;
      paramString1 = "?pictype=scaled&size=750*750";
      continue;
      paramString1 = "?pictype=scaled&size=1024*1024";
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo");
    paramString2 = DiscPicThumbDownloader.a(this.a, paramLong2, false);
    if (paramString2 == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "OnDiscDownloadInfo, mapDowload is not existed taskid[" + String.valueOf(paramLong2) + "]");
      FileManagerUtil.a(this.a.a, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      FileManagerUtil.a(this.a.a, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      this.a.a(paramLong2, false, null, 0, null, null, paramString5);
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  ID[" + paramLong2 + "] OnDiscDownloadInfo isSuccess[false],retCode[" + String.valueOf(paramLong1) + "],retMsg[" + String.valueOf(paramString1) + "]");
      long l = 0L;
      if (paramLong1 == -100001L) {
        l = 9043L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramString2.b, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramString2.b, "", paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), 0L, 0L, 0L, "", "", 0, "ret error", null);
        this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramString2.jdField_a_of_type_Int) });
        this.a.a(paramLong2);
        this.a.a(paramLong2, false, null, 0, null, null, paramString5);
        return;
        if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
        {
          paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          this.a.a.a().c(paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        }
        else
        {
          l = 9045L;
        }
      }
    }
    paramString2.jdField_a_of_type_JavaLangString = paramString5;
    switch (paramString2.jdField_a_of_type_Int)
    {
    default: 
      paramString1 = "http://" + paramString3 + ":" + String.valueOf(paramInt1) + "/ftn_handler/" + paramString4;
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong2 + "] unknow thumbSize!!!info:" + paramString2.toString());
      this.a.a.a().a(false, 50, new Object[] { paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramString2.jdField_a_of_type_Int) });
      FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", paramString2.b, paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      FileManagerUtil.a(this.a.a, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", paramString2.b, paramString1, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramString2.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      this.a.a(paramLong2);
      this.a.a(paramLong2, false, paramString3, paramInt1, "/ftn_handler/" + paramString4, null, paramString5);
      return;
    case 0: 
      paramString1 = "?pictype=scaled&size=16*16";
    }
    for (;;)
    {
      paramString1 = "/ftn_handler/" + paramString4 + paramString1;
      this.a.a(paramLong2, true, paramString3, paramInt1, paramString1, null, paramString5);
      return;
      paramString1 = "?pictype=scaled&size=32*32";
      continue;
      paramString1 = "?pictype=scaled&size=64*64";
      continue;
      paramString1 = "?pictype=scaled&size=128*128";
      continue;
      paramString1 = "?pictype=scaled&size=320*320";
      continue;
      paramString1 = "?pictype=scaled&size=384*384";
      continue;
      paramString1 = "?pictype=scaled&size=640*640";
      continue;
      paramString1 = "?pictype=scaled&size=750*750";
      continue;
      paramString1 = "?pictype=scaled&size=1024*1024";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     acut
 * JD-Core Version:    0.7.0.1
 */