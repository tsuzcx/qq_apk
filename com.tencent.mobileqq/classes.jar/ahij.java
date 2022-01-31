import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import java.util.Comparator;

public final class ahij
  implements Comparator
{
  private final FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private final PhoneContactManager jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager;
  
  public ahij(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager = ((PhoneContactManager)paramQQAppInterface.getManager(10));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)paramQQAppInterface.getManager(50));
  }
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i = -1;
    paramIContactSearchModel1 = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.c(((ContactSearchModelPhoneContact)paramIContactSearchModel1).e());
    paramIContactSearchModel2 = this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager.c(((ContactSearchModelPhoneContact)paramIContactSearchModel2).e());
    if ((paramIContactSearchModel1 == null) || (paramIContactSearchModel2 == null)) {
      if ((paramIContactSearchModel1 == null) && (paramIContactSearchModel2 == null)) {
        i = 0;
      }
    }
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
          } while (paramIContactSearchModel2 == null);
          return 1;
          if ((paramIContactSearchModel1.uin.equals("0")) && (paramIContactSearchModel2.uin.equals("0"))) {
            break;
          }
          if ((!paramIContactSearchModel1.uin.equals("0")) && (!paramIContactSearchModel2.uin.equals("0"))) {
            return 0;
          }
        } while (!paramIContactSearchModel2.uin.equals("0"));
        return 1;
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramIContactSearchModel1.unifiedCode, true);
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.a(paramIContactSearchModel2.unifiedCode, true);
        if ((!bool1) && (!bool2)) {
          break;
        }
        if ((bool1) && (bool2)) {
          return 0;
        }
      } while (bool2);
      return 1;
      boolean bool1 = TextUtils.isEmpty(paramIContactSearchModel1.pinyinFirst);
      bool2 = TextUtils.isEmpty(paramIContactSearchModel2.pinyinFirst);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return paramIContactSearchModel1.pinyinFirst.toLowerCase().charAt(0) - paramIContactSearchModel2.pinyinFirst.toLowerCase().charAt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahij
 * JD-Core Version:    0.7.0.1
 */