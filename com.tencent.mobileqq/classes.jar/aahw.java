import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;

class aahw
  implements View.OnClickListener
{
  aahw(aahr paramaahr, anla paramanla) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      paramView = paramView.getTag();
      String str = anjd.o.replace("[epId]", this.jdField_a_of_type_Anla.a.epId).replace("[eId]", this.jdField_a_of_type_Anla.a.eId);
      if (this.jdField_a_of_type_Aahr.a.a == null) {
        this.jdField_a_of_type_Aahr.a.a = new aaic(this.jdField_a_of_type_Aahr.a);
      }
      this.jdField_a_of_type_Aahr.a.a.a(1, localView, paramView, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aahw
 * JD-Core Version:    0.7.0.1
 */