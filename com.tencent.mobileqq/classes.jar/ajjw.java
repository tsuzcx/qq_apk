import android.view.View;
import com.tencent.mobileqq.troop.homework.recite.ui.SelectReciteParagraphFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Set;

public class ajjw
  implements AdapterView.OnItemClickListener
{
  public ajjw(SelectReciteParagraphFragment paramSelectReciteParagraphFragment) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (SelectReciteParagraphFragment.a(this.a).contains(Integer.valueOf(paramInt))) {
      SelectReciteParagraphFragment.a(this.a).remove(Integer.valueOf(paramInt));
    }
    for (;;)
    {
      SelectReciteParagraphFragment.a(this.a).notifyDataSetChanged();
      SelectReciteParagraphFragment.a(this.a);
      return;
      SelectReciteParagraphFragment.a(this.a).add(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjw
 * JD-Core Version:    0.7.0.1
 */