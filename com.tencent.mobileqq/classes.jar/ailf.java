import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import mqq.observer.AccountObserver;

class ailf
  extends AccountObserver
{
  ailf(aile paramaile) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      aile.b(this.a, null);
      aile.a(this.a, null);
      this.a.b();
      return;
    }
    this.a.a(aile.a(this.a), this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    aile.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ailf
 * JD-Core Version:    0.7.0.1
 */