import com.tencent.mobileqq.activity.contact.addcontact.AddContactViewPagerTroopFragment;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class afdv
  extends akui
{
  afdv(afdu paramafdu, String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afdv
 * JD-Core Version:    0.7.0.1
 */