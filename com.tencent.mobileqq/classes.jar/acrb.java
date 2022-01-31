import android.content.res.Resources;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter;

public class acrb
  extends ajto
{
  public acrb(ActivateFriendActivity paramActivateFriendActivity) {}
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      akju.a(this.a.app, false, true, false, true);
      this.a.a();
    }
    ActivateFriendActivity.a(this.a, paramBoolean2);
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((ActivateFriendActivity.a(this.a) != paramBoolean2) && (paramBoolean2 == true))
    {
      akju.a(this.a.app, false, true, false, true);
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
    for (String str = this.a.getString(2131689603);; str = this.a.getString(2131689604))
    {
      str = this.a.getString(2131689606, new Object[] { str });
      bcql.a(this.a, 2, str, 0).b(this.a.getTitleBarHeight());
      if (ActivateFriendActivity.a(this.a) != null)
      {
        ActivateFriendActivity.a(this.a).c();
        ActivateFriendActivity.b(this.a);
      }
      return;
    }
    label161:
    bcql.a(this.a, 1, this.a.getResources().getString(2131719386), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acrb
 * JD-Core Version:    0.7.0.1
 */