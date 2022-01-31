import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.3.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class achb
  extends akim
{
  public achb(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_Achd.notifyDataSetChanged();
      if (this.a.jdField_a_of_type_Achd.getCount() != 0) {
        break label209;
      }
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.a.getSharedPreferences("last_update_time" + this.a.app.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.a.jdField_a_of_type_JavaLangString, System.currentTimeMillis()).commit();
      ThreadManager.post(new TroopGagActivity.3.1(this, (bakk)this.a.app.getManager(48)), 8, null, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopGagActivity", 2, "onUpdateTroopGetMemberList: isSuccess=" + paramBoolean);
      return;
      label209:
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     achb
 * JD-Core Version:    0.7.0.1
 */