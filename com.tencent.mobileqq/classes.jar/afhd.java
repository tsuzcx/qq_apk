import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class afhd
  implements View.OnClickListener
{
  public afhd(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    aoeb localaoeb = (aoeb)this.a.app.getBusinessHandler(BusinessHandlerFactory.STRANGER_HANDLER);
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (!TextUtils.isEmpty(this.a.b)) {
        localArrayList.add(Long.valueOf(Long.parseLong(this.a.b)));
      }
      localaoeb.a(localArrayList);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.systemmsg.TroopRequestActivity", 2, "delete Stranger parseLong() error", localNumberFormatException);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afhd
 * JD-Core Version:    0.7.0.1
 */