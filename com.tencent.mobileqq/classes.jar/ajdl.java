import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ajdl
  implements View.OnClickListener
{
  ajdl(ajdk paramajdk) {}
  
  public void onClick(View paramView)
  {
    ajdm localajdm = (ajdm)paramView.getTag();
    if ((localajdm == null) || (!(localajdm instanceof ajdm))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).d();
      }
      ajdk.a(this.a, localajdm.a);
      this.a.jdField_a_of_type_JavaUtilList.add(ajdk.a(this.a).remove(this.a.getCount() - localajdm.b - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajdl
 * JD-Core Version:    0.7.0.1
 */