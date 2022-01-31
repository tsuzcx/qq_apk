import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class achw
  extends ExtendFriendObserver
{
  public achw(ExtendFriendEditFragment paramExtendFriendEditFragment) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      ExtendFriendEditFragment.a(this.a).setResult(8193);
      if (ExtendFriendEditFragment.a(this.a) != null) {
        ExtendFriendEditFragment.a(this.a).finish();
      }
      return;
    }
    ExtendFriendEditFragment.a(this.a).dismiss();
  }
  
  protected void a(boolean paramBoolean, Card paramCard)
  {
    super.a(paramBoolean, paramCard);
    if (paramBoolean)
    {
      paramCard = new ExtendFriendProfileEditFragment.ExtendFriendInfo(paramCard);
      if ((TextUtils.isEmpty(paramCard.a)) && (TextUtils.isEmpty(paramCard.b)))
      {
        ExtendFriendEditFragment.a(this.a, true);
        this.a.a.a(paramCard);
      }
    }
    for (;;)
    {
      ExtendFriendEditFragment.a(this.a).dismiss();
      return;
      ExtendFriendEditFragment.a(this.a, false);
      break;
      QQToast.a(ExtendFriendEditFragment.a(this.a), "获取扩列信息失败", 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achw
 * JD-Core Version:    0.7.0.1
 */