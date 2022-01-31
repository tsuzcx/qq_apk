import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ServerInfo;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

public class adll
  extends BroadcastReceiver
{
  public adll(MPcFileModel paramMPcFileModel) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (paramIntent == null) {}
    Object localObject;
    label420:
    label452:
    label505:
    do
    {
      do
      {
        boolean bool;
        int i;
        do
        {
          long l1;
          do
          {
            do
            {
              for (;;)
              {
                return;
                localObject = paramIntent.getAction();
                if (localObject != null)
                {
                  if (!((String)localObject).equals("com.dataline.mpfile.download_progress")) {
                    break;
                  }
                  if (paramIntent.getLongExtra("token_task_id", 0L) == paramContext.uniseq)
                  {
                    l1 = paramIntent.getLongExtra("token_current_size", 0L);
                    l2 = paramIntent.getLongExtra("token_total_size", 0L);
                    paramContext.status = 2;
                    if (l2 != 0L) {}
                    for (paramContext.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null; paramContext.fProgress = 1.0F)
                    {
                      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(paramContext.fProgress);
                      return;
                    }
                  }
                }
              }
              if (!((String)localObject).equals("com.dataline.mpfile.download_completed")) {
                break;
              }
              l1 = paramIntent.getLongExtra("token_task_id", 0L);
            } while (l1 != paramContext.uniseq);
            MPcFileModel.a(this.a, NetConnInfoCenter.getServerTimeMillis());
            long l2 = paramIntent.getLongExtra("token_current_size", 0L);
            bool = paramIntent.getBooleanExtra("token_is_success", false);
            j = paramIntent.getIntExtra("token_http_code", 0);
            QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
            paramIntent = new ReportItem();
            paramIntent.uSessionID = l1;
            paramIntent.uChannelType = 6;
            paramIntent.bSend = false;
            paramIntent.uNotifyTime = MPcFileModel.a(this.a);
            paramIntent.uFileSize = l2;
            paramIntent.bFileExist = false;
            paramIntent.uStartPos = 0L;
            paramIntent.uTaskStart = MPcFileModel.a(this.a);
            paramIntent.uTaskEnd = MPcFileModel.b(this.a);
            paramIntent.uDuration = (MPcFileModel.b(this.a) - MPcFileModel.a(this.a));
            paramIntent.bUserRetry = false;
            paramIntent.sSuffix = "";
            if (bool)
            {
              i = 2;
              paramIntent.emResult = i;
              paramIntent.nFailCode = 0;
              paramIntent.nUserCode = j;
              localObject = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a();
              if (localObject == null) {
                break label631;
              }
              paramIntent.dwServerIP = DBNetworkUtil.a(((ServerInfo)localObject).jdField_a_of_type_JavaLangString);
              paramIntent.wServerPort = ((short)((ServerInfo)localObject).jdField_a_of_type_Int);
              paramIntent.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.a());
              localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramContext.peerDin != 0L) {
                break label644;
              }
              i = QualityReportUtil.b;
              QualityReportUtil.a((QQAppInterface)localObject, paramIntent, i);
              if (bool) {
                break label737;
              }
              paramContext.status = 3;
              if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
                break label651;
              }
              FMToastUtil.a(2131427621);
              if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
                this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
              }
            }
            for (;;)
            {
              ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().a(paramContext.strDataLineMPFileID);
              if (MPcFileModel.b(this.a)) {
                break label841;
              }
              paramContext.mContext = "needMPFileC2C";
              QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + MPcFileModel.b(this.a) + ",create mEntity.mContext");
              return;
              if (MPcFileModel.a(this.a))
              {
                i = 32;
                break;
              }
              i = 41;
              break;
              paramIntent.dwServerIP = 0;
              paramIntent.wServerPort = 0;
              break label420;
              i = QualityReportUtil.d;
              break label452;
              if (j == 1)
              {
                FMToastUtil.a(2131427626);
                break label505;
              }
              if (j == 1004)
              {
                FMToastUtil.a(2131427625);
                break label505;
              }
              if (j == 11)
              {
                QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
                break label505;
              }
              if (j == 12)
              {
                QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
                break label505;
              }
              MPcFileModel.a(this.a, j + 2100);
              break label505;
              paramContext.status = 1;
              paramIntent = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(8)).a().b();
              if (paramIntent == null) {
                if (QLog.isColorLevel()) {
                  QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
                }
              }
              for (;;)
              {
                if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) {
                  break label839;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
                break;
                paramContext.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramContext.fileName }));
                paramContext.setCloudType(3);
              }
            }
            QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + MPcFileModel.b(this.a) + "mEntity.mContext = null");
            paramContext.mContext = null;
            return;
            if (!MpFileConstant.d.equalsIgnoreCase((String)localObject)) {
              break;
            }
            paramContext = paramIntent.getExtras();
            l1 = paramIntent.getLongExtra(MpFileConstant.f, 0L);
            i = paramContext.getInt(MpFileConstant.e);
            j = paramContext.getInt("result");
            if ((i == 0) && (j == 0)) {
              MPcFileModel.a(this.a, true);
            }
            QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
          } while (MPcFileModel.c(this.a) != l1);
          if (i != 0) {
            break;
          }
          i = paramContext.getInt("result");
          paramIntent = paramContext.getByteArray("bytes_json");
          int j = paramContext.getInt("power");
          MPcFileModel.b(this.a, j);
          bool = paramContext.getBoolean("inputPwdError", false);
          switch (i)
          {
          default: 
            QLog.d("MPcFileModel<FileAssistant>", 1, "andorid 6.3.0 accept valid C2C response:" + i);
            return;
          case 0: 
            this.a.o();
            return;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            MPcFileModel.a(this.a, i + 2000);
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser == null);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
        return;
        this.a.a(paramIntent, bool);
        return;
        this.a.a(paramIntent);
        return;
        this.a.p();
        return;
        this.a.q();
        return;
        if (i == 1013)
        {
          FMToastUtil.a(2131427660);
          return;
        }
        if (i == 1014)
        {
          FMToastUtil.a(2131427629);
          return;
        }
        MPcFileModel.a(this.a, i);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser == null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
      return;
    } while (!MpFileConstant.g.equalsIgnoreCase((String)localObject));
    label631:
    MPcFileModel.a(this.a, false);
    label644:
    label651:
    label737:
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    label839:
    label841:
    FMToastUtil.a(2131427625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adll
 * JD-Core Version:    0.7.0.1
 */