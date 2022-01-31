import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.search.model.ContactSearchModelPhoneContact;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.searchengine.PhoneContactBinedSearchEngine;
import java.util.Comparator;

public class ahii
  implements Comparator
{
  public ahii(PhoneContactBinedSearchEngine paramPhoneContactBinedSearchEngine) {}
  
  public int a(IContactSearchModel paramIContactSearchModel1, IContactSearchModel paramIContactSearchModel2)
  {
    int i = -1;
    Object localObject = (PhoneContactManager)this.a.a.getManager(10);
    paramIContactSearchModel1 = ((PhoneContactManager)localObject).c(((ContactSearchModelPhoneContact)paramIContactSearchModel1).e());
    paramIContactSearchModel2 = ((PhoneContactManager)localObject).c(((ContactSearchModelPhoneContact)paramIContactSearchModel2).e());
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
        return i;
        if (paramIContactSearchModel2 == null) {}
        for (i = -1;; i = 1) {
          return i;
        }
        if ((paramIContactSearchModel1.uin.equals("0")) && (paramIContactSearchModel2.uin.equals("0"))) {
          break;
        }
        if ((!paramIContactSearchModel1.uin.equals("0")) && (!paramIContactSearchModel2.uin.equals("0"))) {
          return 0;
        }
      } while (!paramIContactSearchModel2.uin.equals("0"));
      return 1;
      if (!paramIContactSearchModel1.uin.equals("0")) {
        break;
      }
      localObject = (FriendsManager)this.a.a.getManager(50);
      boolean bool1 = ((FriendsManager)localObject).a(paramIContactSearchModel1.unifiedCode, true);
      bool2 = ((FriendsManager)localObject).a(paramIContactSearchModel2.unifiedCode, true);
      if ((!bool1) && (!bool2)) {
        break;
      }
      if ((bool1) && (bool2)) {
        return 0;
      }
    } while (bool2);
    return 1;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahii
 * JD-Core Version:    0.7.0.1
 */