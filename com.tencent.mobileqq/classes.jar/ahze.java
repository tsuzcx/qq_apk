import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahze
  implements View.OnClickListener
{
  ahze(ahzc paramahzc) {}
  
  public void onClick(View paramView)
  {
    if (!amwn.e()) {
      ((amme)this.a.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a().a(this.a.getCurFriendUin(), 319);
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
 * Qualified Name:     ahze
 * JD-Core Version:    0.7.0.1
 */