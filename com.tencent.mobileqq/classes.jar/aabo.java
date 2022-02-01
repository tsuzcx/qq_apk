import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aabo
  implements View.OnClickListener
{
  aabo(aabn paramaabn, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < aabn.a(this.jdField_a_of_type_Aabn).size())
    {
      aabn.b(this.jdField_a_of_type_Aabn).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Aabn.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aabn.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Aabn.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Aabn.a).a(aabn.c(this.jdField_a_of_type_Aabn).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aabo
 * JD-Core Version:    0.7.0.1
 */