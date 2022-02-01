import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.tencent.mobileqq.activity.activateFriend.ReminderListFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class aevv
  extends RecyclerView.ItemDecoration
{
  private aevv(ReminderListFragment paramReminderListFragment) {}
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
    paramRect.left = AIOUtils.dp2px(16.0F, this.a.getResources());
    paramRect.right = AIOUtils.dp2px(16.0F, this.a.getResources());
    int i = paramRecyclerView.getChildAdapterPosition(paramView);
    int j = ReminderListFragment.a(this.a).getItemCount();
    if (QLog.isColorLevel()) {
      QLog.i(ReminderListFragment.a(), 2, "position: " + i + ", totalCnt: " + j);
    }
    paramRect.top = AIOUtils.dp2px(12.0F, this.a.getResources());
    if (i == j - 1) {
      paramRect.bottom = AIOUtils.dp2px(12.0F, this.a.getResources());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevv
 * JD-Core Version:    0.7.0.1
 */