import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.subaccount.AssociatedAccountOptPopBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

public class ahwi
  implements Observer
{
  public ahwi(AssociatedAccountOptPopBar paramAssociatedAccountOptPopBar) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountOptPopBar", 2, "update()");
    }
    if ((paramObject instanceof String[]))
    {
      paramObservable = (String[])paramObject;
      if ((paramObservable.length == 2) && (AppConstants.w.equals(paramObservable[0])) && (this.a.a != null) && (this.a.a.app != null) && (!this.a.a.isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AssociatedAccountOptPopBar", 2, "update() -> before update");
        }
        this.a.a.runOnUiThread(new ahwj(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahwi
 * JD-Core Version:    0.7.0.1
 */