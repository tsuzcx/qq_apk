import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.TextPreviewSettingActivity;

public class aeba
  extends Handler
{
  public aeba(TextPreviewSettingActivity paramTextPreviewSettingActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ImageView localImageView = (ImageView)this.a.findViewById(2131366686);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        localImageView.setImageDrawable(TextPreviewSettingActivity.a(this.a).a(TextPreviewSettingActivity.a(this.a)));
        return;
      } while (!(paramMessage.obj instanceof Drawable));
      localImageView.setImageDrawable((Drawable)paramMessage.obj);
      return;
    } while (!(paramMessage.obj instanceof Bitmap));
    localImageView.setImageBitmap((Bitmap)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeba
 * JD-Core Version:    0.7.0.1
 */