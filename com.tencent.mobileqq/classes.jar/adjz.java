import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;

class adjz
  implements adkc
{
  adjz(adjy paramadjy) {}
  
  public void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    int j;
    int i;
    if (adjy.a(this.a) != null)
    {
      j = adjy.a(this.a).getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramView = adjy.a(this.a).getChildAt(i).getTag();
        if (((paramView instanceof IntimateInfo.MemoryDayInfo)) && (((IntimateInfo.MemoryDayInfo)paramView).dateType == paramMemoryDayInfo.dateType)) {
          adjy.a(this.a).removeViewAt(i);
        }
      }
      else
      {
        if (adjy.a(this.a).getChildCount() <= 0) {
          adjy.a(this.a).setVisibility(8);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adjz
 * JD-Core Version:    0.7.0.1
 */