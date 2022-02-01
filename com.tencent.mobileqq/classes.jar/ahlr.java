import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.AccountObserver;

class ahlr
  extends AccountObserver
{
  ahlr(ahlo paramahlo) {}
  
  public void onRefreshDA2(boolean paramBoolean, String paramString1, String paramString2)
  {
    int i;
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onRefrshDA2 result: ").append(paramBoolean).append(", da2 length: ");
      if (paramString2 == null)
      {
        i = 0;
        QLog.d("C2CMsgRoamProxy", 2, i);
      }
    }
    else
    {
      if ((!paramBoolean) || (TextUtils.isEmpty(paramString2))) {
        break label98;
      }
      i = 1;
      label64:
      if (i == 0) {
        break label104;
      }
      ahlo.a(this.a, true);
    }
    for (;;)
    {
      ahlo.c(this.a).b();
      return;
      i = paramString2.length();
      break;
      label98:
      i = 0;
      break label64;
      label104:
      ahlo.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahlr
 * JD-Core Version:    0.7.0.1
 */