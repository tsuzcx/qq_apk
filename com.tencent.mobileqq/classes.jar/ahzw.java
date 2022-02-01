import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class ahzw
  implements DialogInterface.OnClickListener
{
  ahzw(ahzv paramahzv, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ankw)this.jdField_a_of_type_Ahzv.a.a.getManager(53)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Ahzv.a.a.a().a();
    RecentUser localRecentUser = (RecentUser)paramDialogInterface.findRecentUser(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.delRecentUser(localRecentUser);
    }
    this.jdField_a_of_type_Ahzv.a.I();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahzw
 * JD-Core Version:    0.7.0.1
 */