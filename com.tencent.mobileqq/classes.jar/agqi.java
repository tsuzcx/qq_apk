import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class agqi
  extends AccountObserver
{
  agqi(agqh paramagqh) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      agqh.b(this.a, null);
      agqh.a(this.a, null);
      this.a.b();
      return;
    }
    this.a.a(agqh.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    agqh.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agqi
 * JD-Core Version:    0.7.0.1
 */