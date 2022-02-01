import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajeq
  implements View.OnClickListener
{
  ajeq(ajep paramajep, View paramView) {}
  
  public void onClick(View paramView)
  {
    bdla.b(ajep.a(this.jdField_a_of_type_Ajep), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    ajep.a(this.jdField_a_of_type_Ajep, true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Ajep.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajeq
 * JD-Core Version:    0.7.0.1
 */