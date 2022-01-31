import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.2.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ailh
  implements View.OnLayoutChangeListener
{
  ailh(ailf paramailf) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    View localView = paramView.findViewById(2131365289);
    TextView localTextView = (TextView)paramView.findViewById(2131365288);
    paramInt1 = ((ImageView)paramView.findViewById(2131376736)).getRight() - localView.getWidth();
    if (paramInt1 > 0) {
      ThreadManager.getUIHandler().post(new AvatarPendantAdapter.2.1(this, localTextView, paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ailh
 * JD-Core Version:    0.7.0.1
 */