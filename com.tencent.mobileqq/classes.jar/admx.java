import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

class admx
  implements View.OnClickListener
{
  admx(admw paramadmw) {}
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView)) {
      agwi.b(this.a.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admx
 * JD-Core Version:    0.7.0.1
 */