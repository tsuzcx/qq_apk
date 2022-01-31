import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;

public class adbs
  extends Handler
{
  public adbs(RecordSoundPanel paramRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a.j(1);
    this.a.b();
    bcql.a(this.a.a.a(), this.a.a.a().getString(2131698553), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adbs
 * JD-Core Version:    0.7.0.1
 */