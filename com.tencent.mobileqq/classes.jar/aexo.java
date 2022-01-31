import android.view.View;
import android.view.View.OnLongClickListener;

class aexo
  implements View.OnLongClickListener
{
  aexo(aexl paramaexl, aexr paramaexr) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Aexl.a != null)
    {
      int i = this.jdField_a_of_type_Aexr.getAdapterPosition();
      return this.jdField_a_of_type_Aexl.a.a(paramView, this.jdField_a_of_type_Aexr, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexo
 * JD-Core Version:    0.7.0.1
 */