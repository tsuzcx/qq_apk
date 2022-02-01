import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aapb
  implements View.OnClickListener
{
  aapb(aapa paramaapa, int paramInt, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void onClick(View paramView)
  {
    if (aapa.a(this.jdField_a_of_type_Aapa) != null) {
      aapa.a(this.jdField_a_of_type_Aapa).a(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizVideostoryWidgetViewSmartmusicviewVsMusicItemInfo);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */