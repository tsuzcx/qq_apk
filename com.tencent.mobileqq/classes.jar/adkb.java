import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;

class adkb
  implements View.OnClickListener
{
  adkb(adka paramadka) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (adka.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (adka.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (aqkh)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(adjy.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((aqkh)localObject).a(l1, adka.a(this.a).dateType);
    }
    for (;;)
    {
      if (adka.a(this.a) != null) {
        adka.a(this.a).a(paramView, adka.a(this.a));
      }
      return;
      if ((adka.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        axqy.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", adka.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bbeg localbbeg = bbex.a((QQAppInterface)localObject, this.a.a.a, adka.a(this.a).linkUrl);
        if (localbbeg != null) {
          localbbeg.c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + adka.a(this.a).linkUrl);
          break;
          if (adka.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bgyp.c(this.a.a.a, adka.a(this.a).linkUrl);
          } else {
            adjy.a(this.a.a.a, adka.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      axqy.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", adka.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (adjy.a(this.a.a) == null) {
        break;
      }
      adjy.a(this.a.a).a(adka.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkb
 * JD-Core Version:    0.7.0.1
 */