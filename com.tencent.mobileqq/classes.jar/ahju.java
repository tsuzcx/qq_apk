import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class ahju
  implements View.OnClickListener
{
  ahju(ahjt paramahjt) {}
  
  public void onClick(View paramView)
  {
    ahjv localahjv = (ahjv)paramView.getTag();
    if ((localahjv == null) || (!(localahjv instanceof ahjv))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    ahjt.a(this.a, localahjv.a);
    this.a.jdField_a_of_type_JavaUtilList.add(ahjt.a(this.a).remove(this.a.getCount() - localahjv.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahju
 * JD-Core Version:    0.7.0.1
 */