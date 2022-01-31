import android.view.View;
import android.view.View.OnClickListener;

class aexn
  implements View.OnClickListener
{
  aexn(aexl paramaexl, aexr paramaexr) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aexl.a != null)
    {
      int i = this.jdField_a_of_type_Aexr.getAdapterPosition();
      this.jdField_a_of_type_Aexl.a.a(paramView, this.jdField_a_of_type_Aexr, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aexn
 * JD-Core Version:    0.7.0.1
 */