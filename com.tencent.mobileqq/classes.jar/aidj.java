import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aidj
  implements View.OnClickListener
{
  aidj(aidd paramaidd) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.a.sessionInfo.curFriendUin;
      if (this.a.sessionInfo.curType == 1006) {
        str = this.a.sessionInfo.contactUin;
      }
      aidd.a(this.a, (Integer)localObject, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */