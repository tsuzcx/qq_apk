import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;

class acii
  implements View.OnClickListener
{
  acii(acid paramacid, aptm paramaptm) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = apro.o.replace("[epId]", this.jdField_a_of_type_Aptm.a.epId).replace("[eId]", this.jdField_a_of_type_Aptm.a.eId);
      if (this.jdField_a_of_type_Acid.a.a == null) {
        this.jdField_a_of_type_Acid.a.a = new acio(this.jdField_a_of_type_Acid.a);
      }
      this.jdField_a_of_type_Acid.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acii
 * JD-Core Version:    0.7.0.1
 */