import NS_COMM.COMM.StCommonExt;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aaaz
  extends MSFServlet
{
  public String a()
  {
    String str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    try
    {
      Bundle localBundle = new Bundle();
      if (paramFromServiceMsg != null)
      {
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("KEY_FOR_AIO_STORY_FEED_DATA", paramFromServiceMsg);
          notifyObserver(paramIntent, 1010, true, localBundle, ayxo.class);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QzoneAioStoryFeedServlet", 2, new Object[] { "inform QzoneAioStoryFeedServlet isSuccess false:", paramFromServiceMsg.getBusinessFailMsg() });
        }
        notifyObserver(paramIntent, 1010, false, localBundle, ayxo.class);
        return;
      }
    }
    catch (Throwable paramIntent)
    {
      QLog.e("QzoneAioStoryFeedServlet", 1, paramIntent + "onReceive error");
      notifyObserver(null, 1010, false, null, ayxo.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l1 = paramIntent.getLongExtra("key_last_aio_story_create_time", 0L);
    long l2 = paramIntent.getLongExtra("key_friend_uid", -1L);
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("key_ext");
    Object localObject = null;
    if (arrayOfByte != null) {
      localObject = new COMM.StCommonExt();
    }
    try
    {
      ((COMM.StCommonExt)localObject).mergeFrom(arrayOfByte);
      arrayOfByte = new aaax((COMM.StCommonExt)localObject, l1, l2).encode(paramIntent, -1, a());
      localObject = arrayOfByte;
      if (arrayOfByte == null) {
        localObject = new byte[4];
      }
      paramPacket.setSSOCommand("LightAppSvc.qq_story_client.GetUserNewestStory");
      paramPacket.putSendData(bhuf.a((byte[])localObject));
      paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QzoneAioStoryFeedServlet", 2, "onSend. mergeFrom exception!");
        }
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaaz
 * JD-Core Version:    0.7.0.1
 */