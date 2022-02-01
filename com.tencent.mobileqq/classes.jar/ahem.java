import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahem
  implements View.OnClickListener
{
  ahem(ahek paramahek) {}
  
  public void onClick(View paramView)
  {
    if (!alvx.e()) {
      ((alnr)this.a.app.getManager(153)).a().a(this.a.getCurFriendUin(), 319);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "[onClick] click audio button too fast.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahem
 * JD-Core Version:    0.7.0.1
 */