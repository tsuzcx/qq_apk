import com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class acti
  implements INetEventHandler
{
  public acti(MPcFileModel paramMPcFileModel) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (AppNetConnInfo.isWifiConn())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "网络切换到Wifi网络");
      }
      QQToast.a(this.a.a, 2131427641, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acti
 * JD-Core Version:    0.7.0.1
 */