import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.mobileqq.troop.widget.HotChatPostItemView;

class ajeg
  implements Runnable
{
  ajeg(ajef paramajef, Pair paramPair) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Ajef.a.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof String))
    {
      String str = (String)this.jdField_a_of_type_Ajef.a.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((this.jdField_a_of_type_AndroidUtilPair != null) && (str.endsWith(this.jdField_a_of_type_Ajef.a.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Ajef.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
        HotChatPostItemView.a(this.jdField_a_of_type_Ajef.a.jdField_a_of_type_JavaLangString, (Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajeg
 * JD-Core Version:    0.7.0.1
 */