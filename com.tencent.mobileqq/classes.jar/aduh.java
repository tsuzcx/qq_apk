import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aduh
  implements View.OnClickListener
{
  aduh(aduc paramaduc, asbq paramasbq) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) && ((paramView instanceof ImageView)))
    {
      View localView = (View)paramView.getParent();
      Object localObject = paramView.getTag();
      String str = arze.o.replace("[epId]", this.jdField_a_of_type_Asbq.a.epId).replace("[eId]", this.jdField_a_of_type_Asbq.a.eId);
      if (this.jdField_a_of_type_Aduc.a.a == null) {
        this.jdField_a_of_type_Aduc.a.a = new adun(this.jdField_a_of_type_Aduc.a);
      }
      this.jdField_a_of_type_Aduc.a.a.a(1, localView, localObject, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduh
 * JD-Core Version:    0.7.0.1
 */