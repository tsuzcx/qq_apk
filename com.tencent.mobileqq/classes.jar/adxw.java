import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class adxw
  implements View.OnClickListener
{
  adxw(adxv paramadxv) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      ahix.b(this.a.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxw
 * JD-Core Version:    0.7.0.1
 */