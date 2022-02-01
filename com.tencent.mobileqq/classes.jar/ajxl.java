import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;
import com.tencent.mobileqq.utils.ContactUtils;

public class ajxl
  extends amsu
{
  public ajxl(TransactionActivity paramTransactionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    TransactionActivity.c(this.a, ContactUtils.getBuddyNickName(this.a.app, TransactionActivity.c(this.a), false));
    paramString = akgd.a(TransactionActivity.a(this.a), TransactionActivity.d(this.a), AIOUtils.dp2px(TransactionActivity.c(this.a), TransactionActivity.a(this.a).getResources()), TransactionActivity.c(this.a).getPaint());
    TransactionActivity.c(this.a).setText(paramString + "(" + TransactionActivity.c(this.a) + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxl
 * JD-Core Version:    0.7.0.1
 */