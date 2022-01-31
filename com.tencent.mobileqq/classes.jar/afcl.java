import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;
import com.tencent.qphone.base.util.QLog;

class afcl
  implements View.OnClickListener
{
  afcl(afck paramafck) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (afck.a(this.a) != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      long l1;
      switch (afck.a(this.a).jumpType)
      {
      default: 
        if (localObject != null)
        {
          localObject = (asdx)((QQAppInterface)localObject).a(153);
          l1 = 0L;
        }
        break;
      }
      try
      {
        long l2 = Long.valueOf(afci.a(this.a.a)).longValue();
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          QLog.e("intimate_relationship", 2, "valueOf string err");
        }
      }
      ((asdx)localObject).a(l1, afck.a(this.a).dateType);
    }
    for (;;)
    {
      if (afck.a(this.a) != null) {
        afck.a(this.a).a(paramView, afck.a(this.a));
      }
      return;
      if ((afck.a(this.a).linkUrl != null) && (this.a.a.a != null))
      {
        azmj.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", afck.a(this.a).dateType, 0, "", "", "", "");
        QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
        bddb localbddb = bdds.a((QQAppInterface)localObject, this.a.a.a, afck.a(this.a).linkUrl);
        if (localbddb != null) {
          localbddb.c();
        }
        while (QLog.isColorLevel())
        {
          QLog.d("intimate_relationship", 2, "click  scheme: " + afck.a(this.a).linkUrl);
          break;
          if (afck.a(this.a).linkUrl.toLowerCase().startsWith("mqzone://")) {
            bizm.c(this.a.a.a, afck.a(this.a).linkUrl);
          } else {
            afci.a(this.a.a.a, afck.a(this.a).linkUrl);
          }
        }
      }
      QLog.e("intimate_relationship", 2, "click  scheme: linkUrl or context is null");
      break;
      azmj.b(null, "dc00898", "", "", "0X800A208 ", "0X800A208 ", afck.a(this.a).dateType, 0, "", "", "", "");
      QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A208");
      if (afci.a(this.a.a) == null) {
        break;
      }
      afci.a(this.a.a).a(afck.a(this.a));
      break;
      QLog.e("intimate_relationship", 2, "click  mInfo is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcl
 * JD-Core Version:    0.7.0.1
 */