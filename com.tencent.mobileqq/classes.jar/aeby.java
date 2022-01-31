import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;

class aeby
  implements View.OnClickListener
{
  aeby(aebx paramaebx) {}
  
  public void onClick(View paramView)
  {
    Object localObject = actj.a(paramView);
    if (!(localObject instanceof MessageForText)) {
      if (QLog.isColorLevel()) {
        QLog.w("ChatItemBuilder", 2, "TextItemBuilder onClickListener: AIOUtils.getMessage(v) is not MessageForText");
      }
    }
    do
    {
      do
      {
        return;
        localObject = (MessageForText)localObject;
      } while (this.a.a());
      if (((MessageForText)localObject).msgtype == -1003)
      {
        actj.n = true;
        localObject = bbmx.a(((MessageForText)localObject).action);
        localObject = bbex.a(this.a.a, paramView.getContext(), (String)localObject);
        if (localObject != null) {
          ((bbeg)localObject).c();
        }
      }
    } while (!(paramView instanceof ETTextView));
    ((ETTextView)paramView).startAnimation(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeby
 * JD-Core Version:    0.7.0.1
 */