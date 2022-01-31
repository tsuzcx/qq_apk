import android.view.ViewGroup;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class aivf
  extends bbqu
{
  public aivf(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  protected void onGetExploreMsg(boolean paramBoolean, Object paramObject)
  {
    super.onGetExploreMsg(paramBoolean, paramObject);
    if (paramBoolean) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] get info end");
        }
        QQSettingMe localQQSettingMe = (QQSettingMe)SettingMeApolloViewController.a(this.a).get();
        if (localQQSettingMe == null) {
          return;
        }
        QQAppInterface localQQAppInterface = localQQSettingMe.a();
        if (localQQAppInterface == null) {
          return;
        }
        ViewGroup localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.a).get();
        if (localViewGroup == null) {
          return;
        }
        Object localObject = new JSONObject((String)paramObject);
        if (((JSONObject)localObject).optInt("entry_id", -1) != 1) {
          return;
        }
        localObject = new aixn(localQQAppInterface, (JSONObject)localObject, localQQSettingMe);
        this.a.jdField_a_of_type_Aixj.a((aixl)localObject);
        if ((localQQSettingMe.a()) && (SettingMeApolloViewController.a(this.a) > 0)) {
          this.a.jdField_a_of_type_Aixj.a(SettingMeApolloViewController.a(this.a), localViewGroup.getContext(), localQQAppInterface, this.a.jdField_a_of_type_Int);
        }
        QLog.d("SettingMeApolloViewController", 2, "[onGetExploreMsg] onGetExploreMsg data:" + paramObject.toString());
        return;
      }
      catch (Exception paramObject) {}
    } else {
      QLog.d("SettingMeApolloViewController", 1, "[onGetExploreMsg] result:" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aivf
 * JD-Core Version:    0.7.0.1
 */