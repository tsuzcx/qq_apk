import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class agza
  implements View.OnClickListener
{
  agza(agxq paramagxq, int paramInt1, String paramString, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(agxq.a(this.jdField_a_of_type_Agxq), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    paramView = bant.a(agxq.a(this.jdField_a_of_type_Agxq), "theme", "mvip.gongneng.android.theme.index_dynamic_tab");
    Object localObject = new StringBuilder().append(paramView);
    if (paramView.contains("?"))
    {
      paramView = "&";
      paramView = paramView;
      localObject = paramView + "dialog_source=other&authresult=" + this.jdField_a_of_type_Int;
      paramView = (View)localObject;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        if (!((String)localObject).contains("id=[id]")) {
          break label266;
        }
      }
    }
    label266:
    for (paramView = ((String)localObject).replace("[id]", this.jdField_a_of_type_JavaLangString);; paramView = (String)localObject + "&id=" + this.jdField_a_of_type_JavaLangString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "theme market url: " + paramView);
      }
      VasWebviewUtil.openQQBrowserWithoutAD(agxq.a(this.jdField_a_of_type_Agxq), paramView, 32L, localIntent, true, -1);
      awqx.b(null, "CliOper", "", "", "theme", "0X8007233", 0, 0, String.valueOf(this.b), "", "", "");
      agxq.a(this.jdField_a_of_type_Agxq).obtainMessage(16).sendToTarget();
      awqx.a(agxq.a(this.jdField_a_of_type_Agxq).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 15, 0, "", "", "", "");
      return;
      paramView = "?";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agza
 * JD-Core Version:    0.7.0.1
 */