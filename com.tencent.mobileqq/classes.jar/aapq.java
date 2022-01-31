import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.config.MainDownAni;
import com.tencent.widget.PopupMenuDialog;
import java.lang.ref.WeakReference;

public class aapq
  implements View.OnClickListener
{
  public aapq(MainDownAni paramMainDownAni, aapz paramaapz) {}
  
  public void onClick(View paramView)
  {
    paramView = (PopupMenuDialog)this.jdField_a_of_type_Aapz.d.get();
    if (paramView != null) {
      paramView.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapq
 * JD-Core Version:    0.7.0.1
 */