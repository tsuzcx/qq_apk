import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.AccountObserver;

class aipz
  extends AccountObserver
{
  aipz(aipw paramaipw) {}
  
  public void onUpdateSKey(String paramString1, String paramString2)
  {
    int i = this.a.jdField_a_of_type_JavaUtilArrayList.size();
    if (paramString1 == null)
    {
      for (;;)
      {
        int j = i - 1;
        if (i <= 0) {
          break;
        }
        paramString1 = aipw.a(this.a, ((TroopClipPic)this.a.jdField_a_of_type_JavaUtilArrayList.get(j)).ts);
        if (paramString1 == null)
        {
          i = j;
        }
        else
        {
          this.a.jdField_a_of_type_JavaUtilList.remove(paramString1);
          this.a.b(paramString1);
          i = j;
        }
      }
      this.a.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
    this.a.a(this.a.jdField_a_of_type_JavaUtilArrayList, this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopcode, paramString1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipz
 * JD-Core Version:    0.7.0.1
 */