import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;

class acmx
  implements View.OnClickListener
{
  acmx(acms paramacms, apxv paramapxv) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = apvx.o.replace("[epId]", this.jdField_a_of_type_Apxv.a.epId).replace("[eId]", this.jdField_a_of_type_Apxv.a.eId);
      if (this.jdField_a_of_type_Acms.a.a == null) {
        this.jdField_a_of_type_Acms.a.a = new acnd(this.jdField_a_of_type_Acms.a);
      }
      this.jdField_a_of_type_Acms.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmx
 * JD-Core Version:    0.7.0.1
 */