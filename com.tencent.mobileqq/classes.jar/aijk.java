import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class aijk
  implements DialogInterface.OnClickListener
{
  aijk(aijj paramaijj, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((anws)this.jdField_a_of_type_Aijj.a.a.getManager(53)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Aijj.a.a.a().a();
    RecentUser localRecentUser = (RecentUser)paramDialogInterface.findRecentUser(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.delRecentUser(localRecentUser);
    }
    this.jdField_a_of_type_Aijj.a.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aijk
 * JD-Core Version:    0.7.0.1
 */