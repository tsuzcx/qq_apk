import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;

class aczb
  implements View.OnClickListener
{
  aczb(acza paramacza) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (acza.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (acza.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (apqq)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(acyy.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((apqq)localObject).a(l1, acza.a(this.a).dateType);
    }
    for (;;)
    {
      if (acza.a(this.a) != null) {
        acza.a(this.a).a(paramView, acza.a(this.a));
      }
      return;
      if ((acza.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        awqx.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", acza.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bacn localbacn = bade.a((QQAppInterface)localObject, this.a.a.a, acza.a(this.a).linkUrl);
        if (localbacn != null) {
          localbacn.c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + acza.a(this.a).linkUrl);
          break;
          if (acza.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bfpr.b(this.a.a.a, acza.a(this.a).linkUrl);
          } else {
            acyy.a(this.a.a.a, acza.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      awqx.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", acza.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (acyy.a(this.a.a) == null) {
        break;
      }
      acyy.a(this.a.a).a(acza.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aczb
 * JD-Core Version:    0.7.0.1
 */