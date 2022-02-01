import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileImageActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;

public class aeau
  implements AdapterView.OnItemLongClickListener
{
  public aeau(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FriendProfileImageActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeau
 * JD-Core Version:    0.7.0.1
 */