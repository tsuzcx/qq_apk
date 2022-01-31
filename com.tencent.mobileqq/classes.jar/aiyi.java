import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;

public class aiyi
  implements DialogInterface.OnClickListener
{
  public aiyi(ApolloWebGameActivity paramApolloWebGameActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ApolloWebGameActivity.a(this.a).dismiss();
    ApolloWebGameActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aiyi
 * JD-Core Version:    0.7.0.1
 */