import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;

class agls
  implements aglv
{
  agls(aglr paramaglr) {}
  
  public void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    int j;
    int i;
    if (aglr.a(this.a) != null)
    {
      j = aglr.a(this.a).getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramView = aglr.a(this.a).getChildAt(i).getTag();
        if (((paramView instanceof IntimateInfo.MemoryDayInfo)) && (((IntimateInfo.MemoryDayInfo)paramView).dateType == paramMemoryDayInfo.dateType)) {
          aglr.a(this.a).removeViewAt(i);
        }
      }
      else
      {
        if (aglr.a(this.a).getChildCount() <= 0) {
          aglr.a(this.a).setVisibility(8);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agls
 * JD-Core Version:    0.7.0.1
 */