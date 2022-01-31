import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;

class adkd
  implements View.OnClickListener
{
  adkd(adkc paramadkc) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (adkc.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (adkc.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (aqkf)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(adka.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((aqkf)localObject).a(l1, adkc.a(this.a).dateType);
    }
    for (;;)
    {
      if (adkc.a(this.a) != null) {
        adkc.a(this.a).a(paramView, adkc.a(this.a));
      }
      return;
      if ((adkc.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        axqw.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", adkc.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bbds localbbds = bbej.a((QQAppInterface)localObject, this.a.a.a, adkc.a(this.a).linkUrl);
        if (localbbds != null) {
          localbbds.c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + adkc.a(this.a).linkUrl);
          break;
          if (adkc.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bgxy.c(this.a.a.a, adkc.a(this.a).linkUrl);
          } else {
            adka.a(this.a.a.a, adkc.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      axqw.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", adkc.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (adka.a(this.a.a) == null) {
        break;
      }
      adka.a(this.a.a).a(adkc.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adkd
 * JD-Core Version:    0.7.0.1
 */