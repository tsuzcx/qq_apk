import android.widget.ImageView;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.qphone.base.util.QLog;

public class aduo
  implements ahag
{
  public aduo(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public void a()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ArkFullScreenAppActivity", 2, "arkview loadSucc: " + ArkFullScreenAppActivity.a(this.a));
    }
    Object localObject;
    boolean bool;
    if (ArkFullScreenAppActivity.a(this.a) != null)
    {
      localObject = ArkFullScreenAppActivity.a(this.a).jdField_a_of_type_Agyw;
      if (localObject != null)
      {
        if ((!((agyw)localObject).checkShare()) || (!ArkFullScreenAppActivity.a(this.a).jdField_a_of_type_Boolean)) {
          break label135;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("ArkFullScreenAppActivity", 2, "supportShare: " + bool);
        }
        localObject = this.a.rightViewImg;
        if (!bool) {
          break label140;
        }
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      return;
      label135:
      bool = false;
      break;
      label140:
      i = 4;
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduo
 * JD-Core Version:    0.7.0.1
 */