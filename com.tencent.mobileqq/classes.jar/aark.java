import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;

class aark
  implements View.OnClickListener
{
  aark(aarf paramaarf, aobp paramaobp) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = anzr.o.replace("[epId]", this.jdField_a_of_type_Aobp.a.epId).replace("[eId]", this.jdField_a_of_type_Aobp.a.eId);
      if (this.jdField_a_of_type_Aarf.a.a == null) {
        this.jdField_a_of_type_Aarf.a.a = new aarq(this.jdField_a_of_type_Aarf.a);
      }
      this.jdField_a_of_type_Aarf.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aark
 * JD-Core Version:    0.7.0.1
 */