import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.data.IntimateInfo.MemoryDayInfo;

class afcj
  implements afcm
{
  afcj(afci paramafci) {}
  
  public void a(View paramView, IntimateInfo.MemoryDayInfo paramMemoryDayInfo)
  {
    int j;
    int i;
    if (afci.a(this.a) != null)
    {
      j = afci.a(this.a).getChildCount();
      if (j > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        paramView = afci.a(this.a).getChildAt(i).getTag();
        if (((paramView instanceof IntimateInfo.MemoryDayInfo)) && (((IntimateInfo.MemoryDayInfo)paramView).dateType == paramMemoryDayInfo.dateType)) {
          afci.a(this.a).removeViewAt(i);
        }
      }
      else
      {
        if (afci.a(this.a).getChildCount() <= 0) {
          afci.a(this.a).setVisibility(8);
        }
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcj
 * JD-Core Version:    0.7.0.1
 */