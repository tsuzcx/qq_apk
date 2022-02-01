import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.4.1;
import com.tencent.qphone.base.util.QLog;

public class aaci
  implements zvm
{
  aaci(aacd paramaacd) {}
  
  public void a(boolean paramBoolean, Drawable paramDrawable)
  {
    if ((paramBoolean) && ((paramDrawable instanceof AnimationDrawable)))
    {
      paramDrawable = (AnimationDrawable)paramDrawable;
      if (aacd.g(this.a) != null) {
        aacd.m(this.a).runOnUiThread(new DetailBaseBlock.4.1(this, paramDrawable));
      }
      return;
    }
    QLog.d(aacd.a, 2, "showFollowTipView error, create animationDrawable error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaci
 * JD-Core Version:    0.7.0.1
 */