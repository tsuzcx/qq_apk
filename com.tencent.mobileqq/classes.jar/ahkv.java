import android.view.View;
import android.view.View.OnClickListener;

class ahkv
  implements View.OnClickListener
{
  ahkv(ahkt paramahkt, ahkz paramahkz) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ahkt.a != null)
    {
      int i = this.jdField_a_of_type_Ahkz.getAdapterPosition();
      this.jdField_a_of_type_Ahkt.a.a(paramView, this.jdField_a_of_type_Ahkz, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahkv
 * JD-Core Version:    0.7.0.1
 */