import android.view.View;
import android.view.View.OnLongClickListener;

class afje
  implements View.OnLongClickListener
{
  afje(afjb paramafjb, afjh paramafjh) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Afjb.a != null)
    {
      int i = this.jdField_a_of_type_Afjh.getAdapterPosition();
      return this.jdField_a_of_type_Afjb.a.a(paramView, this.jdField_a_of_type_Afjh, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afje
 * JD-Core Version:    0.7.0.1
 */