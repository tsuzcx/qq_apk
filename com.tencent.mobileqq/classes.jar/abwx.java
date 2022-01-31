import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.dating.HotChatFlashPicActivity;

class abwx
  implements View.OnClickListener
{
  abwx(abww paramabww) {}
  
  public void onClick(View paramView)
  {
    if ((HotChatFlashPicActivity.a(this.a.a) != null) && (!this.a.a.isFinishing()))
    {
      HotChatFlashPicActivity.a(this.a.a).dismiss();
      HotChatFlashPicActivity.a(this.a.a, null);
      this.a.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abwx
 * JD-Core Version:    0.7.0.1
 */