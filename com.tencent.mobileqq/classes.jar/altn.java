import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.emoticon.VipComicEmoticonUploadManager;
import tencent.im.msg.im_msg_body.RichText;

public class altn
  implements UpCallBack
{
  public altn(VipComicEmoticonUploadManager paramVipComicEmoticonUploadManager) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if ((paramSendResult == null) || (this.a.a == null)) {
      return;
    }
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploader", 2, "Upload finish, id=" + paramSendResult.c);
      }
      localBundle = new Bundle();
      localBundle.putInt("result", 0);
      localBundle.putString("id", paramSendResult.c);
      this.a.a.onInvokeFinish(localBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicEmoticonUploader", 2, "Upload error");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 1);
    localBundle.putInt("errCode", paramSendResult.b);
    localBundle.putString("errMsg", paramSendResult.jdField_a_of_type_JavaLangString);
    this.a.a.onInvokeFinish(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     altn
 * JD-Core Version:    0.7.0.1
 */