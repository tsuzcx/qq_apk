import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appcircle.widget.AppNewsTitleBar;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;

public class alkx
  implements View.OnClickListener
{
  public alkx(AppNewsTitleBar paramAppNewsTitleBar) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        return;
      } while (AppNewsTitleBar.a(this.a) == null);
      AppNewsTitleBar.a(this.a).finish();
      return;
    } while ((AppNewsTitleBar.a(this.a) != 0) || (AppNewsTitleBar.a(this.a) == null));
    AppNewsTitleBar.a(this.a).b(new SendMsg("onShareClick"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     alkx
 * JD-Core Version:    0.7.0.1
 */