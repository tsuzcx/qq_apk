import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class agaa
  implements DialogInterface.OnClickListener
{
  agaa(afzy paramafzy, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((antp)this.jdField_a_of_type_Afzy.a.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Afzy.a.app.getProxyManager().a();
    RecentUser localRecentUser = (RecentUser)paramDialogInterface.findRecentUser(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.delRecentUser(localRecentUser);
    }
    ((antl)this.jdField_a_of_type_Afzy.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a();
    this.jdField_a_of_type_Afzy.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agaa
 * JD-Core Version:    0.7.0.1
 */