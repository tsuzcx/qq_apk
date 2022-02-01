import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SearchMightKnowFragment;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeek
  implements View.OnClickListener
{
  public aeek(SearchMightKnowFragment paramSearchMightKnowFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setText("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeek
 * JD-Core Version:    0.7.0.1
 */