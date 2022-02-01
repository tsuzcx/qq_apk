import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahrf
  implements View.OnClickListener
{
  ahrf(ahqw paramahqw) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      bcxc.a(paramView.getContext(), this.a.a.a, ((MessageForShortVideo)localObject).msgTailType);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrf
 * JD-Core Version:    0.7.0.1
 */