import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;

class afvv
  implements View.OnClickListener
{
  afvv(afvt paramafvt) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof MessageForShortVideo))
    {
      localObject = (MessageForShortVideo)localObject;
      ayzc.a(paramView.getContext(), this.a.a.a, ((MessageForShortVideo)localObject).msgTailType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afvv
 * JD-Core Version:    0.7.0.1
 */