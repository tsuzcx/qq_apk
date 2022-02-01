import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

class ahbq
  implements View.OnClickListener
{
  ahbq(ahbp paramahbp, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ((PhotoListPanel)this.jdField_a_of_type_Ahbp.a.get()).a(paramView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahbq
 * JD-Core Version:    0.7.0.1
 */