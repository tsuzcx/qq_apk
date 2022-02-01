import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class afua
  implements View.OnClickListener
{
  afua(aftz paramaftz) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (aftz.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (aftz.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (atub)((QQAppInterface)localObject).getBusinessHandler(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(aftx.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((atub)localObject).a(l1, aftz.a(this.a).dateType);
    }
    for (;;)
    {
      if (aftz.a(this.a) != null) {
        aftz.a(this.a).a(paramView, aftz.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aftz.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        bcef.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", aftz.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bfvp localbfvp = bfwg.a((QQAppInterface)localObject, this.a.a.a, aftz.a(this.a).linkUrl);
        if (localbfvp != null) {
          localbfvp.a();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + aftz.a(this.a).linkUrl);
          break;
          if (aftz.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            QZoneHelper.onMQzoneSchema(this.a.a.a, aftz.a(this.a).linkUrl);
          } else {
            aftx.a(this.a.a.a, aftz.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      bcef.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", aftz.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (aftx.a(this.a.a) == null) {
        break;
      }
      aftx.a(this.a.a).a(aftz.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afua
 * JD-Core Version:    0.7.0.1
 */