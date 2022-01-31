import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.intervideo.od.LoadingUI;

public class adlj
  implements View.OnClickListener
{
  public adlj(LoadingUI paramLoadingUI) {}
  
  public void onClick(View paramView)
  {
    LoadingUI.a(this.a).onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlj
 * JD-Core Version:    0.7.0.1
 */