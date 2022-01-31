import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.videodrawable.VideoDrawableHandler;

public class abdc
  implements Runnable
{
  public abdc(SelectCoverActivity paramSelectCoverActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = VideoDrawableHandler.a(this.a.a);
    if (this.a.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (localBitmap != null) {
        this.a.jdField_b_of_type_AndroidOsHandler.obtainMessage(4, localBitmap).sendToTarget();
      }
      while (this.a.d == 1)
      {
        SelectCoverActivity.a(this.a);
        return;
        this.a.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(6);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abdc
 * JD-Core Version:    0.7.0.1
 */