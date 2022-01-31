import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.List;

class altg
  implements View.OnClickListener
{
  alte jdField_a_of_type_Alte;
  alti jdField_a_of_type_Alti;
  
  altg(alte paramalte, alti paramalti)
  {
    this.jdField_a_of_type_Alte = paramalte;
    this.jdField_a_of_type_Alti = paramalti;
  }
  
  public void onClick(View paramView)
  {
    alrv.a(paramView.getContext(), (ColorNote)alte.a(this.jdField_a_of_type_Alte).get(this.jdField_a_of_type_Alti.getAdapterPosition()));
    if (alte.a(this.jdField_a_of_type_Alte) != null) {
      alte.a(this.jdField_a_of_type_Alte).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     altg
 * JD-Core Version:    0.7.0.1
 */