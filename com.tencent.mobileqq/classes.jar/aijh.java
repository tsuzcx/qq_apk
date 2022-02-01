import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aijh
  implements View.OnClickListener
{
  aijh(aijg paramaijg) {}
  
  public void onClick(View paramView)
  {
    aijj localaijj = (aijj)paramView.getTag();
    if ((localaijj == null) || (!(localaijj instanceof aijj))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.resetSlideStatus();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).hideDirectly();
      }
      aijg.a(this.a, localaijj.a);
      this.a.jdField_a_of_type_JavaUtilList.add(aijg.a(this.a).remove(this.a.getCount() - localaijj.b - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijh
 * JD-Core Version:    0.7.0.1
 */