import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class afba
  implements View.OnClickListener
{
  afba(afaz paramafaz) {}
  
  public void onClick(View paramView)
  {
    afbb localafbb = (afbb)paramView.getTag();
    if ((localafbb == null) || (!(localafbb instanceof afbb))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    afaz.a(this.a, localafbb.a);
    this.a.jdField_a_of_type_JavaUtilList.add(afaz.a(this.a).remove(this.a.getCount() - localafbb.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afba
 * JD-Core Version:    0.7.0.1
 */