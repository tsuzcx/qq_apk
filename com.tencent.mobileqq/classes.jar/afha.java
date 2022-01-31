import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;

class afha
  implements View.OnClickListener
{
  afha(afgz paramafgz) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (afgz.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (afgz.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (asig)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(afgx.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((asig)localObject).a(l1, afgz.a(this.a).dateType);
    }
    for (;;)
    {
      if (afgz.a(this.a) != null) {
        afgz.a(this.a).a(paramView, afgz.a(this.a));
      }
      return;
      if ((afgz.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        azqs.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", afgz.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bdhk localbdhk = bdib.a((QQAppInterface)localObject, this.a.a.a, afgz.a(this.a).linkUrl);
        if (localbdhk != null) {
          localbdhk.c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + afgz.a(this.a).linkUrl);
          break;
          if (afgz.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bjdt.c(this.a.a.a, afgz.a(this.a).linkUrl);
          } else {
            afgx.a(this.a.a.a, afgz.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      azqs.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", afgz.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (afgx.a(this.a.a) == null) {
        break;
      }
      afgx.a(this.a.a).a(afgz.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afha
 * JD-Core Version:    0.7.0.1
 */