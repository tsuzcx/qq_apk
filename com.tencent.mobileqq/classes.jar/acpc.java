import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;

class acpc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  acpc(acox paramacox, ImageView paramImageView) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    acvl.a().a(this.jdField_a_of_type_AndroidWidgetImageView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpc
 * JD-Core Version:    0.7.0.1
 */