import android.view.View;
import android.view.View.OnClickListener;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.qphone.base.util.QLog;

class agdb
  implements View.OnClickListener
{
  agdb(agda paramagda) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aepi.a(paramView);
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
        aepi.n = true;
        localObject = bdqa.a(((MessageForText)localObject).action);
        localObject = bdib.a(this.a.a, paramView.getContext(), (String)localObject);
        if (localObject != null) {
          ((bdhk)localObject).c();
        }
      }
    } while (!(paramView instanceof ETTextView));
    ((ETTextView)paramView).startAnimation(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agdb
 * JD-Core Version:    0.7.0.1
 */