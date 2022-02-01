import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.PopupMenu.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aauo
  implements View.OnClickListener
{
  aauo(aaun paramaaun, String paramString, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Aaun.a != null) {
      this.jdField_a_of_type_Aaun.a.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 2);
    }
    paramView.post(new PopupMenu.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauo
 * JD-Core Version:    0.7.0.1
 */