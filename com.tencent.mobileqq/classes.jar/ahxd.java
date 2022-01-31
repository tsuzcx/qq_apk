import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.QQVoiceExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.search.activity.VADActivity;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ahxd
  extends TransProcessorHandler
{
  public ahxd(VADActivity paramVADActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (VADActivity.a(this.a)) {}
    Object localObject1;
    do
    {
      return;
      localObject1 = (FileMsg)paramMessage.obj;
    } while ((localObject1 == null) || (((FileMsg)localObject1).c != 40));
    String[] arrayOfString = new String[2];
    String str1 = "";
    label80:
    int i;
    switch (paramMessage.what)
    {
    default: 
      localObject1 = "";
      i = 0;
    }
    label85:
    while (QLog.isColorLevel())
    {
      for (;;)
      {
        QLog.i("VADActivity", 2, "VADTransferListener result: msg.waht = " + paramMessage.what + " vadUploadResultCode = " + i + " vadUploadResultString = " + (String)localObject1 + " key = " + str1);
        return;
        localObject1 = "";
        i = 0;
        break label85;
        VADHelper.b("voice_search_server_cost");
        Object localObject2 = ((FileMsg)localObject1).a;
        if (localObject2 == null) {
          break label80;
        }
        localObject1 = new Bdh_extinfo.QQVoiceExtRsp();
        try
        {
          ((Bdh_extinfo.QQVoiceExtRsp)localObject1).mergeFrom((byte[])localObject2);
          i = ((Bdh_extinfo.QQVoiceExtRsp)localObject1).int32_retcode.get();
          if (i == 0)
          {
            str1 = ((Bdh_extinfo.QQVoiceExtRsp)localObject1).bytes_qid.get().toStringUtf8();
            if (!str1.equalsIgnoreCase(VADActivity.a(this.a))) {
              break;
            }
            localObject1 = ((Bdh_extinfo.QQVoiceExtRsp)localObject1).msg_result.get();
            VADHelper.a("voice_search_pre_cost");
            arrayOfString = this.a.a((List)localObject1);
            VADHelper.b("voice_search_pre_cost");
            localObject1 = arrayOfString[0];
            if (QLog.isColorLevel()) {
              QLog.i("VADActivity", 2, "server return : vadUploadResultString = " + (String)localObject1);
            }
            VADActivity.a(this.a).removeMessages(6);
            localObject2 = VADActivity.a(this.a).obtainMessage(3);
            ((Message)localObject2).obj = arrayOfString;
            VADActivity.a(this.a).sendMessage((Message)localObject2);
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
            continue;
            localObject1 = " server return happen error";
            String str2 = "";
          }
        }
      }
      VADHelper.b("voice_search_server_cost");
      VADActivity.a(this.a).removeMessages(6);
      localObject1 = VADActivity.a(this.a).obtainMessage(3);
      ((Message)localObject1).obj = arrayOfString;
      VADActivity.a(this.a).sendMessage((Message)localObject1);
      localObject1 = "";
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahxd
 * JD-Core Version:    0.7.0.1
 */