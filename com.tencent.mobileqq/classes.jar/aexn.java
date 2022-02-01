import android.widget.CompoundButton;
import com.tencent.mobileqq.activity.ShowReactiveActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;

public class aexn
  extends CardObserver
{
  public aexn(ShowReactiveActivity paramShowReactiveActivity) {}
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    Switch localSwitch;
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      localObject = this.a;
      localSwitch = this.a.a.a();
      if (paramBoolean2) {
        break label118;
      }
    }
    label118:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ShowReactiveActivity.a((ShowReactiveActivity)localObject, localSwitch, paramBoolean1);
      if (QLog.isColorLevel())
      {
        localObject = ((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.a.app.getCurrentAccountUin());
        QLog.d("interactive", 2, " ShowReactiveActivity onGetCalReactiveDays isAllow= " + paramBoolean2 + "card.allowCalInteractive=" + ((Card)localObject).allowCalInteractive);
      }
      return;
    }
  }
  
  public void onSetCalReactiveDays(boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if (!paramBoolean)
    {
      QQToast.a(this.a.app.getApp(), 1, this.a.getString(2131718593), 3000).b(this.a.getTitleBarHeight());
      localObject1 = this.a;
      localObject2 = this.a.a.a();
      if (this.a.a.a().isChecked()) {
        break label218;
      }
      bool1 = true;
      ShowReactiveActivity.a((ShowReactiveActivity)localObject1, (CompoundButton)localObject2, bool1);
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, "ShowReactiveActivity onSetCalReactiveDays isSuccess false= ");
      }
    }
    Switch localSwitch;
    if ((paramBoolean) && (!this.a.isFinishing()))
    {
      localObject1 = ((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.a.app.getCurrentAccountUin());
      localObject2 = this.a;
      localSwitch = this.a.a.a();
      if (((Card)localObject1).allowCalInteractive) {
        break label223;
      }
    }
    label218:
    label223:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ShowReactiveActivity.a((ShowReactiveActivity)localObject2, localSwitch, paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, "ShowReactiveActivity onSetCalReactiveDays allowCalInteractive= " + ((Card)localObject1).allowCalInteractive);
      }
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aexn
 * JD-Core Version:    0.7.0.1
 */