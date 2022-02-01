import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity.8.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class adnh
  extends anmu
{
  public adnh(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  void a(String paramString, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramView == null)) {
      return;
    }
    this.a.runOnUiThread(new AssociatedAccountManageActivity.8.1(this, paramString, paramView));
  }
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    do
    {
      return;
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 0);
      if (localView != null) {
        a(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 1);
    } while (localView == null);
    a(paramString, localView);
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountManage", 2, "onUpdateFriendInfo  uin = " + paramString + " isSuccess = " + paramBoolean);
    }
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString))) {}
    View localView;
    do
    {
      return;
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 0);
      if (localView != null)
      {
        ((SingleLineTextView)localView.findViewById(2131371539)).setText(bglf.h(this.a.app, paramString));
        a(paramString, localView);
      }
      localView = AssociatedAccountManageActivity.a(this.a, paramString, 1);
    } while (localView == null);
    ((SingleLineTextView)localView.findViewById(2131371539)).setText(bglf.h(this.a.app, paramString));
    a(paramString, localView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adnh
 * JD-Core Version:    0.7.0.1
 */