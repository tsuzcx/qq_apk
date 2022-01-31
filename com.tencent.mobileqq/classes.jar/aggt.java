import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.mobileqq.qcall.QCallFacade;

public class aggt
  implements Runnable
{
  public aggt(QCallDetailActivity paramQCallDetailActivity) {}
  
  public void run()
  {
    int k = 0;
    if (this.a.app == null) {
      break label12;
    }
    label12:
    label142:
    label159:
    for (;;)
    {
      return;
      if (QCallDetailActivity.a(this.a, QCallDetailActivity.a(this.a)))
      {
        Object localObject = MsgProxyUtils.q;
        int m = localObject.length;
        int i = 0;
        int j = k;
        if (i < m)
        {
          j = localObject[i];
          if (QCallDetailActivity.a(this.a) == j) {
            j = 1;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          localObject = (PhoneContactManager)this.a.app.getManager(10);
          if (localObject != null) {
            break label142;
          }
        }
        for (localObject = null;; localObject = ((PhoneContactManager)localObject).c(QCallDetailActivity.a(this.a)))
        {
          if (localObject == null) {
            break label159;
          }
          QCallDetailActivity.a(this.a).a(((PhoneContact)localObject).mobileCode, 1006, QCallDetailActivity.a(this.a), QCallDetailActivity.a(this.a));
          return;
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aggt
 * JD-Core Version:    0.7.0.1
 */