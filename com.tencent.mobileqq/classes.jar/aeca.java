import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;

class aeca
  implements View.OnClickListener
{
  aeca(aebz paramaebz) {}
  
  public void onClick(View paramView)
  {
    Object localObject = actn.a(paramView);
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
        actn.n = true;
        localObject = bbmj.a(((MessageForText)localObject).action);
        localObject = bbej.a(this.a.a, paramView.getContext(), (String)localObject);
        if (localObject != null) {
          ((bbds)localObject).c();
        }
      }
    } while (!(paramView instanceof ETTextView));
    ((ETTextView)paramView).startAnimation(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeca
 * JD-Core Version:    0.7.0.1
 */