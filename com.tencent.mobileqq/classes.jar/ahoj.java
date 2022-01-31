import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.List;

class ahoj
  implements View.OnClickListener
{
  ahoj(ahoi paramahoi) {}
  
  public void onClick(View paramView)
  {
    ahok localahok = (ahok)paramView.getTag();
    if ((localahok == null) || (!(localahok instanceof ahok))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)paramView).d();
    }
    ahoi.a(this.a, localahok.a);
    this.a.jdField_a_of_type_JavaUtilList.add(ahoi.a(this.a).remove(this.a.getCount() - localahok.b - 1));
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahoj
 * JD-Core Version:    0.7.0.1
 */