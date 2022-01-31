import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class ahba
  extends amky
{
  ahba(ahaz paramahaz, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 2, "onclick tipswording3 grant onLocationFinish info = " + paramSosoLbsInfo);
    }
    if (paramInt != 0) {
      QLog.i("ac_ft.AddContactViewPagerTroopFragment", 1, "onclick tipswording3 grant onLocationFinish, errorCode=" + paramInt);
    }
    this.a.a.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahba
 * JD-Core Version:    0.7.0.1
 */