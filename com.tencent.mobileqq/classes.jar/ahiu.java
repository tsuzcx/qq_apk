import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahiu
  implements View.OnClickListener
{
  ahiu(ahit paramahit) {}
  
  public void onClick(View paramView)
  {
    Object localObject = AIOUtils.getMessage(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (MessageForText)localObject;
      if (!this.a.a())
      {
        if (((MessageForText)localObject).msgtype == -1003)
        {
          AIOUtils.isUserOperatedInAIO = true;
          localObject = PkgTools.Decodecgi(((MessageForText)localObject).action);
          localObject = bhey.a(this.a.a, paramView.getContext(), (String)localObject);
          if (localObject != null) {
            ((bheh)localObject).a();
          }
        }
        if ((paramView instanceof ETTextView)) {
          ((ETTextView)paramView).startAnimation(true, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahiu
 * JD-Core Version:    0.7.0.1
 */