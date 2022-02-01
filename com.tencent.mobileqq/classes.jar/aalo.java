import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aalo
  implements View.OnClickListener
{
  aalo(aaln paramaaln, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < aaln.a(this.jdField_a_of_type_Aaln).size())
    {
      aaln.b(this.jdField_a_of_type_Aaln).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Aaln.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aaln.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Aaln.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Aaln.a).a(aaln.c(this.jdField_a_of_type_Aaln).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalo
 * JD-Core Version:    0.7.0.1
 */