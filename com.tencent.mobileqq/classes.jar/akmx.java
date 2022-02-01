import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class akmx
  implements View.OnClickListener
{
  akmx(akmu paramakmu) {}
  
  public void onClick(View paramView)
  {
    this.a.onMagicStickClick(paramView, -1, new Bundle(), 2, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akmx
 * JD-Core Version:    0.7.0.1
 */