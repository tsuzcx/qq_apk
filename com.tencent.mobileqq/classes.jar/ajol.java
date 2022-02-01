import android.view.View;
import android.view.View.OnLongClickListener;

class ajol
  implements View.OnLongClickListener
{
  ajol(ajoi paramajoi, ajoo paramajoo) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajoi.a != null)
    {
      int i = this.jdField_a_of_type_Ajoo.getAdapterPosition();
      return this.jdField_a_of_type_Ajoi.a.a(paramView, this.jdField_a_of_type_Ajoo, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajol
 * JD-Core Version:    0.7.0.1
 */