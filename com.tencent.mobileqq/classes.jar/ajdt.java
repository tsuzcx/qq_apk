import android.view.View;
import android.view.View.OnLongClickListener;

class ajdt
  implements View.OnLongClickListener
{
  ajdt(ajdq paramajdq, ajdw paramajdw) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajdq.a != null)
    {
      int i = this.jdField_a_of_type_Ajdw.getAdapterPosition();
      return this.jdField_a_of_type_Ajdq.a.a(paramView, this.jdField_a_of_type_Ajdw, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdt
 * JD-Core Version:    0.7.0.1
 */