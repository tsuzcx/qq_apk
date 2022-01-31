import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;

class ahnd
  implements View.OnClickListener
{
  ahnd(ahmx paramahmx) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
    RecentBaseData localRecentBaseData;
    do
    {
      do
      {
        int i;
        do
        {
          return;
          i = paramView.getId();
        } while ((i < 0) || (i >= this.a.getCount()));
        localObject1 = this.a.getItem(i);
      } while ((localObject1 == null) || (!(localObject1 instanceof RecentBaseData)));
      localRecentBaseData = (RecentBaseData)localObject1;
      Object localObject2 = null;
      localObject1 = localObject2;
      if ((paramView instanceof TextView))
      {
        paramView = ((TextView)paramView).getText();
        localObject1 = localObject2;
        if (paramView != null) {
          localObject1 = paramView.toString();
        }
      }
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    this.a.a(localRecentBaseData, (String)localObject1, "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahnd
 * JD-Core Version:    0.7.0.1
 */