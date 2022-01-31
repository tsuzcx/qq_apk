import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;

public class akpt
  implements DialogInterface.OnClickListener
{
  public akpt(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", alef.Y);
    this.a.startActivity(paramDialogInterface);
    ApolloWebGameActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akpt
 * JD-Core Version:    0.7.0.1
 */