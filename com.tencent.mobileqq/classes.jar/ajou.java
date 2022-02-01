import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajou
  implements View.OnClickListener
{
  ajou(ajot paramajot) {}
  
  public void onClick(View paramView)
  {
    ajov localajov = (ajov)paramView.getTag();
    if ((localajov == null) || (!(localajov instanceof ajov))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).d();
      }
      ajot.a(this.a, localajov.a);
      this.a.jdField_a_of_type_JavaUtilList.add(ajot.a(this.a).remove(this.a.getCount() - localajov.b - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajou
 * JD-Core Version:    0.7.0.1
 */