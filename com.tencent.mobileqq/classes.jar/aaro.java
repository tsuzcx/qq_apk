import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;

class aaro
  implements View.OnClickListener
{
  aaro(aarj paramaarj, aobk paramaobk) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = anzm.o.replace("[epId]", this.jdField_a_of_type_Aobk.a.epId).replace("[eId]", this.jdField_a_of_type_Aobk.a.eId);
      if (this.jdField_a_of_type_Aarj.a.a == null) {
        this.jdField_a_of_type_Aarj.a.a = new aaru(this.jdField_a_of_type_Aarj.a);
      }
      this.jdField_a_of_type_Aarj.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaro
 * JD-Core Version:    0.7.0.1
 */