import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.qphone.base.util.QLog;

public class akql
  extends Handler
{
  public akql(PhotoCropActivity paramPhotoCropActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      this.a.b();
      this.a.a.sendMessageDelayed(Message.obtain(this.a.a, 1003), 10000L);
      return;
    } while (this.a.isFinishing());
    if (QLog.isColorLevel()) {
      QLog.d("PhotoCropActivity", 2, "LOADING_TIMEOUT");
    }
    PhotoCropActivity.a(this.a, 2131716082);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akql
 * JD-Core Version:    0.7.0.1
 */