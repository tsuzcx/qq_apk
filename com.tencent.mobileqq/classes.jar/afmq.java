import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class afmq
  implements View.OnClickListener
{
  afmq(afmp paramafmp) {}
  
  public void onClick(View paramView)
  {
    afmr localafmr = (afmr)paramView.getTag();
    if ((localafmr == null) || (!(localafmr instanceof afmr))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    afmp.a(this.a, localafmr.a);
    this.a.jdField_a_of_type_JavaUtilList.add(afmp.a(this.a).remove(this.a.getCount() - localafmr.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmq
 * JD-Core Version:    0.7.0.1
 */