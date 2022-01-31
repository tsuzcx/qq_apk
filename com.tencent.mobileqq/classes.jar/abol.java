import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.database.corrupt.DBFixConfigActivity;

public class abol
  implements View.OnClickListener
{
  public abol(DBFixConfigActivity paramDBFixConfigActivity) {}
  
  public void onClick(View paramView)
  {
    ThreadManager.post(this.a.a, 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abol
 * JD-Core Version:    0.7.0.1
 */