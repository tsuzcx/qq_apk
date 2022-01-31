import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;

class aeok
  implements DialogInterface.OnClickListener
{
  aeok(aeoj paramaeoj, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ajvi)this.jdField_a_of_type_Aeoj.a.a.getManager(53)).c(this.jdField_a_of_type_JavaLangString);
    paramDialogInterface = this.jdField_a_of_type_Aeoj.a.a.a().a();
    RecentUser localRecentUser = paramDialogInterface.b(this.jdField_a_of_type_JavaLangString, 3000);
    if (localRecentUser != null) {
      paramDialogInterface.b(localRecentUser);
    }
    this.jdField_a_of_type_Aeoj.a.H();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeok
 * JD-Core Version:    0.7.0.1
 */