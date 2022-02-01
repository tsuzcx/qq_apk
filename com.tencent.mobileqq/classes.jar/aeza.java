import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class aeza
  implements bdpo
{
  public aeza(QQSettingMe paramQQSettingMe) {}
  
  public void a(Bundle paramBundle)
  {
    this.a.n();
  }
  
  public void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("start_status");
    if (i == 1) {
      this.a.n();
    }
    do
    {
      do
      {
        return;
        if (i == 2)
        {
          this.a.n();
          return;
        }
      } while (i != 3);
      if (!(this.a.jdField_b_of_type_AndroidWidgetImageView.getDrawable() instanceof Animatable)) {
        break;
      }
      i = paramBundle.getInt("percent");
      paramBundle = String.valueOf(i) + "%";
      this.a.jdField_b_of_type_AndroidWidgetTextView.setText(paramBundle);
    } while (!QLog.isDevelopLevel());
    QLog.d("QQSettingRedesign", 4, "NIGHTMODE_ACTION_DOWNLOADING: " + i);
    return;
    if (QQSettingMe.f(this.a)) {}
    for (Drawable localDrawable = this.a.a.getResources().getDrawable(2130846055);; localDrawable = this.a.a.getResources().getDrawable(2130846056))
    {
      this.a.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      if (!(localDrawable instanceof Animatable)) {
        break;
      }
      ((Animatable)localDrawable).start();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeza
 * JD-Core Version:    0.7.0.1
 */