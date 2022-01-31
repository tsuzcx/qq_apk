import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment.4.1;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

public class ahfs
  extends ampn
{
  public ahfs(AddContactViewPagerTroopFragment paramAddContactViewPagerTroopFragment, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, "getview onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0)
    {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, "getview onLocationFinish, errorCode=" + paramInt);
      this.a.a.post(new AddContactViewPagerTroopFragment.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfs
 * JD-Core Version:    0.7.0.1
 */