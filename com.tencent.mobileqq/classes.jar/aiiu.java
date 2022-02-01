import android.view.View;
import android.view.View.OnLongClickListener;

class aiiu
  implements View.OnLongClickListener
{
  aiiu(aiir paramaiir, aiix paramaiix) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Aiir.a != null)
    {
      int i = this.jdField_a_of_type_Aiix.getAdapterPosition();
      return this.jdField_a_of_type_Aiir.a.a(paramView, this.jdField_a_of_type_Aiix, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiu
 * JD-Core Version:    0.7.0.1
 */