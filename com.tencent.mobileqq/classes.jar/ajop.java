import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class ajop
  implements View.OnClickListener
{
  public ajop(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext()) {
      ((EmoticonFromGroupEntity)localIterator.next()).status = -1;
    }
    this.a.a.clear();
    EmoticonGroupStoreFragment.a(this.a).setVisibility(8);
    EmoticonGroupStoreFragment.b(this.a).setVisibility(0);
    EmoticonGroupStoreFragment.a(this.a).a = false;
    EmoticonGroupStoreFragment.a(this.a).a(false);
    EmoticonGroupStoreFragment.a(this.a).notifyDataSetChanged();
    EmoticonGroupStoreFragment.e(this.a);
    this.a.a(true);
    this.a.resetLeftButton();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajop
 * JD-Core Version:    0.7.0.1
 */