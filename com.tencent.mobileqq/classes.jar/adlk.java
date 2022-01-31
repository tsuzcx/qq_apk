import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.od.LoadingUI;
import com.tencent.mobileqq.intervideo.od.LoadingUI.Event;

public class adlk
  implements View.OnClickListener
{
  public adlk(LoadingUI paramLoadingUI) {}
  
  public void onClick(View paramView)
  {
    if (LoadingUI.a(this.a) != null) {
      LoadingUI.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlk
 * JD-Core Version:    0.7.0.1
 */