import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class ahpi
  implements IActionListener
{
  public ahpi(EditActivity paramEditActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 102) && (EditActivity.a(this.a).actionId != 0) && (" ".equals(EditActivity.a(this.a).actionText)))
    {
      ActionInfo localActionInfo = EditActivity.a(this.a).a(EditActivity.a(this.a).actionId);
      if (localActionInfo != null)
      {
        EditActivity.a(this.a).actionText = localActionInfo.d;
        EditActivity.a(this.a, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpi
 * JD-Core Version:    0.7.0.1
 */