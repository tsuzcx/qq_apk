import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopRequestActivity;

public class acle
  extends Handler
{
  public acle(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.i();
      bcql.a(this.a, this.a.getString(2131719275), 0).b(this.a.getTitleBarHeight());
      this.a.finish();
      return;
    case 1: 
      this.a.a(true);
      this.a.i();
      bcql.a(this.a, this.a.getString(2131719262), 0).b(this.a.getTitleBarHeight());
      return;
    }
    paramMessage = (String)paramMessage.obj;
    this.a.o.setText(paramMessage + "");
    this.a.o.setContentDescription(paramMessage + "");
    this.a.o.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acle
 * JD-Core Version:    0.7.0.1
 */