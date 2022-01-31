import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class afmo
  implements View.OnClickListener
{
  afmo(afmn paramafmn) {}
  
  public void onClick(View paramView)
  {
    afmp localafmp = (afmp)paramView.getTag();
    if ((localafmp == null) || (!(localafmp instanceof afmp))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    afmn.a(this.a, localafmp.a);
    this.a.jdField_a_of_type_JavaUtilList.add(afmn.a(this.a).remove(this.a.getCount() - localafmp.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afmo
 * JD-Core Version:    0.7.0.1
 */