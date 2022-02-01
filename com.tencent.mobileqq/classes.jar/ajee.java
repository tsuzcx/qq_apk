import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajee
  implements View.OnClickListener
{
  ajee(ajed paramajed) {}
  
  public void onClick(View paramView)
  {
    ajeg localajeg = (ajeg)paramView.getTag();
    if ((localajeg == null) || (!(localajeg instanceof ajeg))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.resetSlideStatus();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).hideDirectly();
      }
      ajed.a(this.a, localajeg.a);
      this.a.jdField_a_of_type_JavaUtilList.add(ajed.a(this.a).remove(this.a.getCount() - localajeg.b - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajee
 * JD-Core Version:    0.7.0.1
 */