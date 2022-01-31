import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class agqg
  extends AccountObserver
{
  agqg(agqf paramagqf) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      agqf.b(this.a, null);
      agqf.a(this.a, null);
      this.a.b();
      return;
    }
    this.a.a(agqf.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    agqf.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqg
 * JD-Core Version:    0.7.0.1
 */