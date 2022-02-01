import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agoi
  implements View.OnClickListener
{
  agoi(agoh paramagoh) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (agoh.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (agoh.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (auov)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(agof.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((auov)localObject).a(l1, agoh.a(this.a).dateType);
    }
    for (;;)
    {
      if (agoh.a(this.a) != null) {
        agoh.a(this.a).a(paramView, agoh.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((agoh.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        bcst.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", agoh.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bgmp localbgmp = bgng.a((QQAppInterface)localObject, this.a.a.a, agoh.a(this.a).linkUrl);
        if (localbgmp != null) {
          localbgmp.a();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + agoh.a(this.a).linkUrl);
          break;
          if (agoh.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            blsb.c(this.a.a.a, agoh.a(this.a).linkUrl);
          } else {
            agof.a(this.a.a.a, agoh.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      bcst.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", agoh.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (agof.a(this.a.a) == null) {
        break;
      }
      agof.a(this.a.a).a(agoh.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agoi
 * JD-Core Version:    0.7.0.1
 */