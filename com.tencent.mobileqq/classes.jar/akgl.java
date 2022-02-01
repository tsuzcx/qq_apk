import android.os.Message;
import com.tencent.mobileqq.activity.photo.SendWebPicActivity;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class akgl
  extends bdzm
{
  public akgl(SendWebPicActivity paramSendWebPicActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    bduk localbduk = (bduk)paramMessage.obj;
    if ((localbduk == null) || (localbduk.b != 24) || (localbduk.c != 51)) {}
    do
    {
      do
      {
        return;
      } while (localbduk.f.equals(SendWebPicActivity.a(this.a)));
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (QLog.isColorLevel()) {
          QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler send finished!" + SendWebPicActivity.a(this.a));
        }
        break;
      }
    } while (SendWebPicActivity.a(this.a));
    paramMessage = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramMessage.mergeFrom(localbduk.a, 0, localbduk.a.length);
      SendWebPicActivity.a(this.a, true);
      SendWebPicActivity.a(this.a, localbduk.f);
      SendWebPicActivity.b(this.a, paramMessage.bytes_file_resid.get().toStringUtf8());
      SendWebPicActivity.c(this.a, paramMessage.bytes_download_url.get().toStringUtf8());
      if (QLog.isColorLevel()) {
        QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler mUuid=" + SendWebPicActivity.b(this.a) + ", mImageMd5=" + SendWebPicActivity.a(this.a) + ", mImageUrl=" + SendWebPicActivity.c(this.a));
      }
      SendWebPicActivity.a(this.a).sendEmptyMessage(1001);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SendWebPicActivity", 2, "mPicTransProcessorHandler send error:" + localbduk.g);
    }
    SendWebPicActivity.a(this.a).sendEmptyMessage(1003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akgl
 * JD-Core Version:    0.7.0.1
 */