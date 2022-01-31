import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.qphone.base.util.QLog;

public class aejp
  extends RecyclerView.ItemDecoration
{
  private aejp(ReminderListFragment paramReminderListFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramRect.left = aekt.a(16.0F, this.a.getResources());
    paramRect.right = aekt.a(16.0F, this.a.getResources());
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = ReminderListFragment.a(this.a).getItemCount();
    if (QLog.isColorLevel()) {
      QLog.i(ReminderListFragment.a(), 2, "position: " + i + ", totalCnt: " + j);
    }
    paramRect.top = aekt.a(12.0F, this.a.getResources());
    if (i == j - 1) {
      paramRect.bottom = aekt.a(12.0F, this.a.getResources());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejp
 * JD-Core Version:    0.7.0.1
 */