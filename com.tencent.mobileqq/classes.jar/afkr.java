import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class afkr
  implements View.OnClickListener
{
  afkr(afkp paramafkp) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      afkp.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afkr
 * JD-Core Version:    0.7.0.1
 */