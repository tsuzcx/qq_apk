import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.TransactionActivity;

public class akzt
  extends anyu
{
  public akzt(TransactionActivity paramTransactionActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {
      return;
    }
    TransactionActivity.c(this.a, bhlg.c(this.a.app, TransactionActivity.c(this.a), false));
    paramString = alil.a(TransactionActivity.a(this.a), TransactionActivity.d(this.a), agej.a(TransactionActivity.c(this.a), TransactionActivity.a(this.a).getResources()), TransactionActivity.c(this.a).getPaint());
    TransactionActivity.c(this.a).setText(paramString + "(" + TransactionActivity.c(this.a) + ")");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akzt
 * JD-Core Version:    0.7.0.1
 */