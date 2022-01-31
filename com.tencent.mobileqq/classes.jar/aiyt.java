import android.os.Message;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadRsp;
import tencent.im.cs.cmd0x346.cmd0x346.DownloadInfo;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

public class aiyt
  extends aywb
{
  QQAppInterface a;
  
  public aiyt(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (ayqo)paramMessage.obj;
    if ((localObject == null) || (((ayqo)localObject).c != 36)) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          switch (paramMessage.what)
          {
          case 1002: 
          default: 
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.d("CmGameTemp_CmGameAudioManager", 0, "start upload cmshow record");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("CmGameTemp_CmGameAudioManager", 0, "finish upload cmshow record" + ((ayqo)localObject).g);
        }
        try
        {
          paramMessage = new cmd0x346.RspBody();
          paramMessage.mergeFrom(((ayqo)localObject).a);
          paramMessage = (cmd0x346.ApplyDownloadRsp)paramMessage.msg_apply_download_rsp.get();
          i = paramMessage.int32_ret_code.get();
          if (i != 0) {
            break;
          }
          paramMessage = (cmd0x346.DownloadInfo)paramMessage.msg_download_info.get();
          if ((paramMessage != null) && (paramMessage.str_download_url.has())) {}
          paramMessage = paramMessage.str_download_url.get();
          QLog.i("CmGameTemp_CmGameAudioManager", 1, "[uploadFile] url:" + paramMessage);
          localObject = (airx)this.a.getManager(153);
          aiyp localaiyp = ((airx)localObject).a();
          ((airx)localObject).a().a(this.a.c(), paramMessage, localaiyp.a);
          return;
        }
        catch (Exception paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.e("CmGameTemp_CmGameAudioManager", 0, "upload cmshow record response error e=" + paramMessage.toString());
      return;
      QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload fail," + i);
      paramMessage = ((airx)this.a.getManager(153)).a();
    } while ((paramMessage.b == null) || (paramMessage.b.get() == null));
    ((aiyu)paramMessage.b.get()).a(-1);
    return;
    QLog.e("CmGameTemp_CmGameAudioManager", 1, "[TransProcessorHandler] upload error:" + ((ayqo)localObject).g);
    return;
    QLog.i("CmGameTemp_CmGameAudioManager", 1, "upload cmshow cancel:" + ((ayqo)localObject).g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyt
 * JD-Core Version:    0.7.0.1
 */