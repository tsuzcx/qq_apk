import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;

public class acez
  extends Handler
{
  public acez(TextPreviewActivity paramTextPreviewActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 100: 
    case 16: 
    case 18: 
    case 19: 
      do
      {
        do
        {
          return;
          if (this.a.jdField_a_of_type_JavaLangCharSequence != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.setText(this.a.jdField_a_of_type_JavaLangCharSequence);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetContainerView.a.setMovementMethod(bckk.a());
          return;
          this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.a.jdField_a_of_type_Ho.a(this.a.e));
          return;
        } while (!(paramMessage.obj instanceof Drawable));
        this.a.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)paramMessage.obj);
        return;
      } while (!(paramMessage.obj instanceof Bitmap));
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)paramMessage.obj);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acez
 * JD-Core Version:    0.7.0.1
 */