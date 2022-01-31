import android.graphics.drawable.Drawable;
import android.widget.ImageView;

class abqa
  implements Runnable
{
  abqa(abpz paramabpz, Drawable paramDrawable) {}
  
  public void run()
  {
    if (("KEY_SPLASH_BG_WEALTH_GOD_SLEEP".equals(this.jdField_a_of_type_Abpz.jdField_a_of_type_JavaLangString)) || ("KEY_SPLASH_BG_WEALTH_GOD_WORK".equals(this.jdField_a_of_type_Abpz.jdField_a_of_type_JavaLangString)) || ("KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG".equals(this.jdField_a_of_type_Abpz.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_Abpz.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
    }
    this.jdField_a_of_type_Abpz.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abqa
 * JD-Core Version:    0.7.0.1
 */