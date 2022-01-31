import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class adns
  implements View.OnClickListener
{
  adns(adnq paramadnq) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      adnq.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adns
 * JD-Core Version:    0.7.0.1
 */