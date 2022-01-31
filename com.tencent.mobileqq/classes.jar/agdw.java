import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder;

public class agdw
  implements View.OnClickListener
{
  public agdw(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder) {}
  
  public void onClick(View paramView)
  {
    agea localagea = (agea)aepi.a(paramView);
    if (paramView == localagea.jdField_a_of_type_AndroidWidgetFrameLayout) {
      this.a.b(localagea);
    }
    while (paramView != localagea.jdField_a_of_type_AndroidWidgetRelativeLayout) {
      return;
    }
    this.a.a(localagea);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdw
 * JD-Core Version:    0.7.0.1
 */