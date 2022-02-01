import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aijt
  implements View.OnClickListener
{
  aijt(aijs paramaijs, View paramView) {}
  
  public void onClick(View paramView)
  {
    bcef.b(aijs.a(this.jdField_a_of_type_Aijs), "dc00899", "Grp_contacts_news", "", "notice", "verify_clk", 0, 0, "", "", "", "");
    aijs.a(this.jdField_a_of_type_Aijs, true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Aijs.notifyDataSetChanged();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijt
 * JD-Core Version:    0.7.0.1
 */