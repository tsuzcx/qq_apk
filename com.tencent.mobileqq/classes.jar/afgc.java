import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class afgc
  implements View.OnClickListener
{
  afgc(afga paramafga) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      afga.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgc
 * JD-Core Version:    0.7.0.1
 */