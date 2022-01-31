import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class ajhu
  implements View.OnClickListener
{
  ajhu(ajgb paramajgb) {}
  
  public void onClick(View paramView)
  {
    if (ajgb.a(this.a).app != null)
    {
      ((alpk)ajgb.a(this.a).app.a(2)).b(0, "", "not_disturb_from_conversation");
      azqs.b(ajgb.a(this.a).app, "CliOper", "", "", "0X8009EBA", "0X8009EBA", 0, 1, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhu
 * JD-Core Version:    0.7.0.1
 */