import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class agek
  extends AccountObserver
{
  agek(agej paramagej) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      agej.b(this.a, null);
      agej.a(this.a, null);
      this.a.b();
      return;
    }
    this.a.a(agej.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    agej.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agek
 * JD-Core Version:    0.7.0.1
 */