import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class akrz
  extends AccountObserver
{
  akrz(akry paramakry) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      akry.b(this.a, null);
      akry.a(this.a, null);
      this.a.b();
      return;
    }
    this.a.a(akry.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    akry.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrz
 * JD-Core Version:    0.7.0.1
 */