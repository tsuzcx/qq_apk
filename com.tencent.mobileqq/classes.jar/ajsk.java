import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;

class ajsk
  implements Runnable
{
  ajsk(ajsj paramajsj, Pair paramPair) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ajsj.a.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof String))
    {
      String str = (String)this.jdField_a_of_type_Ajsj.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((this.jdField_a_of_type_AndroidUtilPair != null) && (str.endsWith(this.jdField_a_of_type_Ajsj.a.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Ajsj.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
        HotChatPostItemView.a(this.jdField_a_of_type_Ajsj.a.jdField_a_of_type_JavaLangString, (Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajsk
 * JD-Core Version:    0.7.0.1
 */