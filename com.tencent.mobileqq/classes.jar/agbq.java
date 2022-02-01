import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter;
import com.tencent.mobileqq.widget.QQToast;

public class agbq
  extends anuw
{
  public agbq(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      aolc.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      aolc.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    if (!this.a.isFinishing())
    {
      if (!paramBoolean1) {
        break label161;
      }
      ActivateFriendActivity.a(this.a, paramBoolean2);
      if (!ActivateFriendActivity.a(this.a)) {
        break label148;
      }
    }
    label148:
    for (String str = this.a.getString(2131689528);; str = this.a.getString(2131689529))
    {
      str = this.a.getString(2131689531, new Object[] { str });
      QQToast.a(this.a, 2, str, 0).b(this.a.getTitleBarHeight());
      if (ActivateFriendActivity.a(this.a) != null)
      {
        ActivateFriendActivity.a(this.a).c();
        ActivateFriendActivity.b(this.a);
      }
      return;
    }
    label161:
    QQToast.a(this.a, 1, this.a.getResources().getString(2131717966), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agbq
 * JD-Core Version:    0.7.0.1
 */