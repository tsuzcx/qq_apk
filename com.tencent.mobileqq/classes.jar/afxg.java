import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.ChatItemAnimLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class afxg
  extends Handler
{
  public afxg(ChatItemAnimLayout paramChatItemAnimLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_START");
      }
      this.a.b.mMsgAnimTime = System.currentTimeMillis();
      this.a.e = 0.0F;
      this.a.f = 0.0F;
      sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(1), 10L);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_UPDADE");
      }
      this.a.b.mMsgAnimTime = System.currentTimeMillis();
      float f2 = (float)(this.a.b.mMsgAnimTime - this.a.jdField_a_of_type_Long) / 300.0F;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      this.a.e = (1.0F - (1.0F - f1) * (1.0F - f1) * (1.0F - f1));
      this.a.f = f1;
      if (this.a.e < 1.0F) {
        sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(1), 10L);
      }
      for (;;)
      {
        this.a.invalidate();
        return;
        this.a.e = 1.0F;
        sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(2), 0L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_END");
      }
      this.a.e = 1.0F;
      this.a.invalidate();
    } while (this.a.jdField_a_of_type_Afxh == null);
    this.a.jdField_a_of_type_Afxh.g(this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afxg
 * JD-Core Version:    0.7.0.1
 */