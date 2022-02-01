import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ajdw
  implements View.OnClickListener
{
  ajdw(ajdv paramajdv, View paramView) {}
  
  public void onClick(View paramView)
  {
    bcst.b(ajdv.a(this.jdField_a_of_type_Ajdv), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    ajdv.a(this.jdField_a_of_type_Ajdv, true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Ajdv.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdw
 * JD-Core Version:    0.7.0.1
 */