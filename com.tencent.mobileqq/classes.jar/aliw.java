import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.BindGroupConfirmActivity;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;

class aliw
  implements Runnable
{
  aliw(aliv paramaliv, GetAppInfoProto.MsgIconsurl paramMsgIconsurl) {}
  
  public void run()
  {
    Bitmap localBitmap = AuthorityActivity.a(this.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$MsgIconsurl.url.get());
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 4;
      this.jdField_a_of_type_Aliv.a.a.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aliw
 * JD-Core Version:    0.7.0.1
 */