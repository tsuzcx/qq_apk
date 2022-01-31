import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class adnu
  implements View.OnClickListener
{
  adnu(adns paramadns) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      adns.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adnu
 * JD-Core Version:    0.7.0.1
 */