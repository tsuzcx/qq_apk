import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;

public class admm
  implements View.OnClickListener
{
  public admm(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onClick(View paramView)
  {
    if (MusicFilePresenter.a(this.a))
    {
      MusicFilePresenter.a(this.a);
      return;
    }
    MusicFilePresenter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     admm
 * JD-Core Version:    0.7.0.1
 */