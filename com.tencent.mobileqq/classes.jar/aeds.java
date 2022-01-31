import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.od.LoadingUI;

public class aeds
  implements View.OnClickListener
{
  public aeds(LoadingUI paramLoadingUI) {}
  
  public void onClick(View paramView)
  {
    LoadingUI.a(this.a).onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeds
 * JD-Core Version:    0.7.0.1
 */