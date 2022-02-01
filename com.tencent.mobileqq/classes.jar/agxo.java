import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agxo
  implements View.OnClickListener
{
  agxo(agxn paramagxn) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (agxn.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (agxn.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (avgv)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(agxl.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((avgv)localObject).a(l1, agxn.a(this.a).dateType);
    }
    for (;;)
    {
      if (agxn.a(this.a) != null) {
        agxn.a(this.a).a(paramView, agxn.a(this.a));
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((agxn.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        bdll.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", agxn.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bhmr localbhmr = bhni.a((QQAppInterface)localObject, this.a.a.a, agxn.a(this.a).linkUrl);
        if (localbhmr != null) {
          localbhmr.a();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + agxn.a(this.a).linkUrl);
          break;
          if (agxn.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bmtd.c(this.a.a.a, agxn.a(this.a).linkUrl);
          } else {
            agxl.a(this.a.a.a, agxn.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      bdll.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", agxn.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (agxl.a(this.a.a) == null) {
        break;
      }
      agxl.a(this.a.a).a(agxn.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxo
 * JD-Core Version:    0.7.0.1
 */