import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aedj
  implements View.OnClickListener
{
  aedj(aede paramaede, asre paramasre) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = asos.o.replace("[epId]", this.jdField_a_of_type_Asre.a.epId).replace("[eId]", this.jdField_a_of_type_Asre.a.eId);
      if (this.jdField_a_of_type_Aede.a.a == null) {
        this.jdField_a_of_type_Aede.a.a = new aedp(this.jdField_a_of_type_Aede.a);
      }
      this.jdField_a_of_type_Aede.a.a.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aedj
 * JD-Core Version:    0.7.0.1
 */