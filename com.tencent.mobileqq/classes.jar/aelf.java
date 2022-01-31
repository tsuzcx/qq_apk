import android.util.Log;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewScroll.LyricViewScrollListener;

public class aelf
  implements LyricViewScroll.LyricViewScrollListener
{
  public aelf(LyricViewController paramLyricViewController) {}
  
  public void a(int paramInt)
  {
    this.a.a = true;
    this.a.c(paramInt);
  }
  
  public void b(int paramInt)
  {
    Log.d("ModuleController", "onScrollStop -> top:" + paramInt);
    this.a.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aelf
 * JD-Core Version:    0.7.0.1
 */