import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qphone.base.util.QLog;

public class aekf
{
  public static void a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0) {
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg_TAG", 4, "BaseChatItemLayout onTouchEvent...down ");
      }
    }
    while ((paramMotionEvent.getAction() == 2) || (paramMotionEvent.getAction() != 1)) {
      return;
    }
    paramView = paramView.findViewById(2131364197);
    int i;
    label68:
    int j;
    if ((paramView != null) && ((paramView instanceof CheckBox)) && (paramView.getVisibility() == 0))
    {
      i = 1;
      paramMotionEvent = AIOLongShotHelper.a();
      j = i;
      if (paramMotionEvent != null)
      {
        j = i;
        if (paramMotionEvent.a())
        {
          if ((paramView == null) || (!(paramView instanceof CheckBox))) {
            break label128;
          }
          j = 1;
        }
      }
      label100:
      if (j == 0) {
        break label131;
      }
      paramView = (CheckBox)paramView;
      if (paramView.isChecked()) {
        break label133;
      }
    }
    for (;;)
    {
      paramView.setChecked(bool);
      return;
      i = 0;
      break label68;
      label128:
      j = 0;
      break label100;
      label131:
      break;
      label133:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekf
 * JD-Core Version:    0.7.0.1
 */