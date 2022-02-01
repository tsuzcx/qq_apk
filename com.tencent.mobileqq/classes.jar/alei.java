import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class alei
  implements View.OnClickListener
{
  alei(aldh paramaldh, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (aldh.a(this.jdField_a_of_type_Aldh) != null)
    {
      localObject1 = aldh.a(this.jdField_a_of_type_Aldh).obtainMessage(1134042);
      aldh.a(this.jdField_a_of_type_Aldh).sendMessage((Message)localObject1);
    }
    Object localObject1 = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(aldh.a(this.jdField_a_of_type_Aldh).getApplicationContext(), (Class)localObject1);
        String str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = (String)this.jdField_a_of_type_AndroidOsBundle.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_AndroidOsBundle.getInt("flags", 0));
        aldh.a(this.jdField_a_of_type_Aldh).startActivity((Intent)localObject1);
      }
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
 * Qualified Name:     alei
 * JD-Core Version:    0.7.0.1
 */