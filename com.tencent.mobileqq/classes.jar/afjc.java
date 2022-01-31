import android.view.View;
import android.view.View.OnLongClickListener;

class afjc
  implements View.OnLongClickListener
{
  afjc(afiz paramafiz, afjf paramafjf) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Afiz.a != null)
    {
      int i = this.jdField_a_of_type_Afjf.getAdapterPosition();
      return this.jdField_a_of_type_Afiz.a.a(paramView, this.jdField_a_of_type_Afjf, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afjc
 * JD-Core Version:    0.7.0.1
 */