import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

class akyx
  extends bdqc
{
  akyx(akyw paramakyw) {}
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "ApolloDressChange uin=" + paramObject);
      }
      if (akyw.a(this.a) != null) {
        akyw.a(this.a).e();
      }
      this.a.c();
    }
  }
  
  protected void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetZanCount(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null) || (akyw.a(this.a) == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsPresenter", 2, "get zanCount = " + paramObject);
    }
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
    int i = ((SharedPreferences)localObject).getInt("apollo_zan_count" + akyw.a(this.a), 0);
    ((SharedPreferences)localObject).edit().putInt("apollo_zan_count" + akyw.a(this.a), ((Integer)paramObject).intValue()).commit();
    if (((Integer)paramObject).intValue() > 99999) {
      paramObject = Integer.valueOf(99999);
    }
    for (;;)
    {
      localObject = String.valueOf(paramObject);
      if (((Integer)paramObject).intValue() >= 99999)
      {
        paramObject = Integer.valueOf(99999);
        localObject = paramObject + "+";
      }
      for (;;)
      {
        akyw.a(this.a).a((String)localObject, i, ((Integer)paramObject).intValue());
        return;
      }
    }
  }
  
  protected void onSetZanCount(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject == null) || (akyw.a(this.a) == null) || (akyw.a(this.a) == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGuestsPresenter", 2, "set zanCount = " + paramObject);
    }
    if (paramBoolean) {}
    label378:
    for (;;)
    {
      try
      {
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
        Calendar localCalendar = Calendar.getInstance();
        ((SharedPreferences)localObject).edit().putBoolean(akyw.a(this.a).getCurrentAccountUin() + "apollo_today_has_vote" + akyw.a(this.a) + localCalendar.get(1) + localCalendar.get(2) + localCalendar.get(5), true).commit();
        if (((Integer)paramObject).intValue() <= 99999) {
          break label378;
        }
        paramObject = Integer.valueOf(99999);
        akyw.a(this.a).b(((Integer)paramObject).intValue());
        return;
      }
      catch (Exception paramObject) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloGuestsPresenter", 2, "set zanCount error= " + paramObject.toString());
      return;
      if (((Long)paramObject).longValue() != -501010L) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "today has vote to " + akyw.a(this.a));
      }
      paramObject = BaseApplicationImpl.getApplication().getSharedPreferences("cmshow_zan", 0);
      Object localObject = Calendar.getInstance();
      paramObject.edit().putBoolean(akyw.a(this.a).getCurrentAccountUin() + "apollo_today_has_vote" + akyw.a(this.a) + ((Calendar)localObject).get(1) + ((Calendar)localObject).get(2) + ((Calendar)localObject).get(5), true).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyx
 * JD-Core Version:    0.7.0.1
 */