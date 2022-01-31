import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.TimeChangeReceiver.1;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import mqq.os.MqqHandler;

public final class afdf
  extends BroadcastReceiver
{
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  
  private afdf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  private void a()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseChatPie != null)
    {
      if (this.jdField_a_of_type_JavaUtilCalendar == null) {
        this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
      }
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
      int i = this.jdField_a_of_type_JavaUtilCalendar.get(11);
      if ((i < 19) && (i >= 7)) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true; Looper.getMainLooper() == Looper.myLooper(); bool = false)
    {
      localBaseChatPie.a.b(bool);
      return;
    }
    localBaseChatPie.a().post(new AIOIconChangeByTimeHelper.TimeChangeReceiver.1(this, localBaseChatPie, bool));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.intent.action.TIME_TICK".equals(paramContext)) {
      a();
    }
    do
    {
      return;
      if ("android.intent.action.TIME_SET".equals(paramContext))
      {
        a();
        return;
      }
    } while (!"android.intent.action.TIMEZONE_CHANGED".equals(paramContext));
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdf
 * JD-Core Version:    0.7.0.1
 */