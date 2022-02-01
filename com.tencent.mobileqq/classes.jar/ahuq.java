import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class ahuq
  implements View.OnClickListener
{
  ahuq(ahup paramahup, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((PhotoListPanel)this.jdField_a_of_type_Ahup.a.get()).a(paramView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahuq
 * JD-Core Version:    0.7.0.1
 */