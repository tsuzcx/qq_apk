import android.view.View;
import android.view.View.OnLongClickListener;

class ahkw
  implements View.OnLongClickListener
{
  ahkw(ahkt paramahkt, ahkz paramahkz) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Ahkt.a != null)
    {
      int i = this.jdField_a_of_type_Ahkz.getAdapterPosition();
      return this.jdField_a_of_type_Ahkt.a.a(paramView, this.jdField_a_of_type_Ahkz, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkw
 * JD-Core Version:    0.7.0.1
 */