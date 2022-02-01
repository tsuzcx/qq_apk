import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.commodity.CommodityListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aapp
  implements View.OnClickListener
{
  aapp(aapo paramaapo, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int < aapo.a(this.jdField_a_of_type_Aapo).size())
    {
      aapo.b(this.jdField_a_of_type_Aapo).remove(this.jdField_a_of_type_Int);
      ((ArrayList)this.jdField_a_of_type_Aapo.a.a()).remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Aapo.notifyDataSetChanged();
      if (CommodityListView.a(this.jdField_a_of_type_Aapo.a) != null) {
        CommodityListView.a(this.jdField_a_of_type_Aapo.a).a(aapo.c(this.jdField_a_of_type_Aapo).size());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapp
 * JD-Core Version:    0.7.0.1
 */