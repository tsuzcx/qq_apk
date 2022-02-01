import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController.5.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class alqz
  implements ambf
{
  public alqz(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_Altc == null) {}
    Object localObject;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQSettingMe)SettingMeApolloViewController.a(this.a).get();
        } while (localObject == null);
        localObject = ((QQSettingMe)localObject).a();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.a).get();
    } while ((localViewGroup == null) || (this.a.jdField_a_of_type_Altc.a(SettingMeApolloViewController.a(this.a), this.a.jdField_a_of_type_Int, (AppInterface)localObject, localViewGroup.getContext()) != 0));
    this.a.jdField_a_of_type_Altc.a(SettingMeApolloViewController.a(this.a), localViewGroup.getContext(), (QQAppInterface)localObject, this.a.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onApolloClick] ", "apolloStatus:", Integer.valueOf(paramInt1), ",clickPart:", Integer.valueOf(paramInt2), ",apolloId:", paramString });
    }
    Object localObject = (QQSettingMe)SettingMeApolloViewController.a(this.a).get();
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localObject = ((QQSettingMe)localObject).a();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.a).get();
    } while ((localViewGroup == null) || (paramInt1 == 0));
    ThreadManager.getUIHandler().post(new SettingMeApolloViewController.5.1(this, paramInt2, localViewGroup, (QQAppInterface)localObject, paramString));
  }
  
  public void b()
  {
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alqz
 * JD-Core Version:    0.7.0.1
 */