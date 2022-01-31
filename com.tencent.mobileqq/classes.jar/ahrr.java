import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.emogroupstore.EmoticonGroupStoreFragment;

public class ahrr
  extends RecyclerView.OnScrollListener
{
  public ahrr(EmoticonGroupStoreFragment paramEmoticonGroupStoreFragment) {}
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    paramInt1 = paramRecyclerView.findFirstVisibleItemPosition();
    String str = EmoticonGroupStoreFragment.a(this.a).a(paramInt1);
    if ((str != null) && (paramInt2 != 0))
    {
      EmoticonGroupStoreFragment.a(this.a).setTextSize(16.0F);
      EmoticonGroupStoreFragment.a(this.a).setTextColor(Color.parseColor("#FF000000"));
      EmoticonGroupStoreFragment.a(this.a).setText(str);
    }
    if (paramInt2 < 0)
    {
      paramRecyclerView = paramRecyclerView.findViewByPosition(paramInt1);
      if (paramRecyclerView != null)
      {
        float f = paramRecyclerView.getY();
        if ((paramInt1 == 0) && (0.0F == f))
        {
          EmoticonGroupStoreFragment.a(this.a).setTextSize(14.0F);
          EmoticonGroupStoreFragment.a(this.a).setTextColor(Color.parseColor("#FF777777"));
          EmoticonGroupStoreFragment.a(this.a).setText(EmoticonGroupStoreFragment.a(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahrr
 * JD-Core Version:    0.7.0.1
 */