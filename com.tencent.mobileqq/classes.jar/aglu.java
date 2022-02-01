import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneHelper;

class aglu
  implements View.OnClickListener
{
  aglu(aglt paramaglt) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (aglt.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (aglt.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (auzb)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(aglr.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((auzb)localObject).a(l1, aglt.a(this.a).dateType);
    }
    for (;;)
    {
      if (aglt.a(this.a) != null) {
        aglt.a(this.a).a(paramView, aglt.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((aglt.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        bdla.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", aglt.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bheh localbheh = bhey.a((QQAppInterface)localObject, this.a.a.a, aglt.a(this.a).linkUrl);
        if (localbheh != null) {
          localbheh.a();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + aglt.a(this.a).linkUrl);
          break;
          if (aglt.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            QZoneHelper.onMQzoneSchema(this.a.a.a, aglt.a(this.a).linkUrl);
          } else {
            aglr.a(this.a.a.a, aglt.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      bdla.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", aglt.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (aglr.a(this.a.a) == null) {
        break;
      }
      aglr.a(this.a.a).a(aglt.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aglu
 * JD-Core Version:    0.7.0.1
 */