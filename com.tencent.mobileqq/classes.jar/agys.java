import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet;
import com.tencent.widget.ActionSheet;

public class agys
  implements View.OnClickListener
{
  public agys(ShareActionSheet paramShareActionSheet) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.isShowing())
    {
      this.a.a.cancel();
      this.a.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agys
 * JD-Core Version:    0.7.0.1
 */