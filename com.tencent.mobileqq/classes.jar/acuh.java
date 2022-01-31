import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.MusicFilePresenter;

public class acuh
  implements SeekBar.OnSeekBarChangeListener
{
  public acuh(MusicFilePresenter paramMusicFilePresenter) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.a.a(paramInt);
      this.a.b(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    if ((this.a.a != null) && (!this.a.a.b(MusicFilePresenter.a(this.a)))) {
      this.a.a.d();
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acuh
 * JD-Core Version:    0.7.0.1
 */