import android.view.View;
import android.view.View.OnLongClickListener;

class ajdc
  implements View.OnLongClickListener
{
  ajdc(ajcz paramajcz, ajdf paramajdf) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajcz.a != null)
    {
      int i = this.jdField_a_of_type_Ajdf.getAdapterPosition();
      return this.jdField_a_of_type_Ajcz.a.a(paramView, this.jdField_a_of_type_Ajdf, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdc
 * JD-Core Version:    0.7.0.1
 */