import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;

class adrb
  implements View.OnClickListener
{
  adrb(adra paramadra) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aciy.a(paramView);
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
        aciy.n = true;
        localObject = bakz.a(((MessageForText)localObject).action);
        localObject = bade.a(this.a.a, paramView.getContext(), (String)localObject);
        if (localObject != null) {
          ((bacn)localObject).c();
        }
      }
    } while (!(paramView instanceof ETTextView));
    ((ETTextView)paramView).a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adrb
 * JD-Core Version:    0.7.0.1
 */