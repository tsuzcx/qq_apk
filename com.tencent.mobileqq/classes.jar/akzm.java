import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class akzm
  implements View.OnClickListener
{
  akzm(akyh paramakyh, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (akyh.a(this.jdField_a_of_type_Akyh) != null)
    {
      localObject1 = akyh.a(this.jdField_a_of_type_Akyh).obtainMessage(30);
      akyh.a(this.jdField_a_of_type_Akyh).sendMessageDelayed((Message)localObject1, 2500L);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(akyh.a(this.jdField_a_of_type_Akyh).getApplicationContext(), (Class)localObject1);
        String str = this.jdField_a_of_type_AndroidOsBundle.getString("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).putExtra("url", str);
        }
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        ((Intent)localObject1).putExtra("force_no_reload", true);
        akyh.a(this.jdField_a_of_type_Akyh).startActivity((Intent)localObject1);
      }
      bcst.a(akyh.a(this.jdField_a_of_type_Akyh).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzm
 * JD-Core Version:    0.7.0.1
 */