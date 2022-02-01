import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage;
import com.tencent.qphone.base.util.QLog;

public class aevl
  implements URLDrawable.URLDrawableListener
{
  public aevl(ReminderCardItemPage paramReminderCardItemPage, boolean paramBoolean, ImageView paramImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadSuccess");
    try
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if (this.jdField_a_of_type_Boolean)
      {
        int j = ReminderCardItemPage.a();
        int i = j;
        if (j == 0) {
          i = this.jdField_a_of_type_AndroidWidgetImageView.getWidth();
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix localMatrix = new Matrix();
        float f = i * 1.0F / paramURLDrawable.getIntrinsicWidth();
        localMatrix.setScale(f, f);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(localMatrix);
      }
      return;
    }
    catch (Throwable paramURLDrawable)
    {
      QLog.e("ReminderCardItemPage", 1, "setImageFromUrl: with a error: ", paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevl
 * JD-Core Version:    0.7.0.1
 */