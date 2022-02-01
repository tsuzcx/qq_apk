import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;

public class ajlu
  implements blih
{
  public ajlu(SystemMsgListView paramSystemMsgListView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    SystemMsgListView.a(this.a, paramInt1);
    SystemMsgListView.a(this.a, paramInt1 + paramInt2 - 1);
    if (SystemMsgListView.a(this.a).b() == 23)
    {
      if (paramInt1 >= 1)
      {
        paramAbsListView = (ajjr)SystemMsgListView.a(this.a).getItem(paramInt1 - 1);
        if ((paramAbsListView instanceof ajjn)) {
          ((ajjn)paramAbsListView).c();
        }
      }
      if (paramInt1 + paramInt2 < paramInt3)
      {
        paramAbsListView = (ajjr)SystemMsgListView.a(this.a).getItem(paramInt1 + paramInt2);
        if ((paramAbsListView instanceof ajjn)) {
          ((ajjn)paramAbsListView).c();
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 0;
    int j;
    int k;
    if (SystemMsgListView.a(this.a) != null)
    {
      if ((paramInt == 0) || (paramInt == 1)) {
        break label240;
      }
      SystemMsgListView.a(this.a).e();
      if (paramInt == 0)
      {
        SystemMsgListView.a(this.a).k();
        j = SystemMsgListView.a(this.a).b();
        if (SystemMsgListView.a(this.a) >= SystemMsgListView.a(this.a).getCount() - 2)
        {
          paramAbsListView = SystemMsgListView.a(this.a).a();
          if ((paramAbsListView != null) && (paramAbsListView.a()) && (paramAbsListView.a >= 0) && (SystemMsgListView.a(this.a).a(j)))
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("from", "4");
            SystemMsgListView.a(this.a).b(4, paramAbsListView.a, localBundle);
          }
        }
        k = SystemMsgListView.a(this.a).getFirstVisiblePosition();
        paramAbsListView = SystemMsgListView.a(this.a).getChildAt(0);
        if (paramAbsListView != null) {
          break label263;
        }
      }
    }
    label263:
    for (paramInt = i;; paramInt = paramAbsListView.getTop())
    {
      SystemMsgListView.a(this.a).remove(j);
      if (SystemMsgListView.a(this.a).isShown())
      {
        paramAbsListView = new ajjb(j, k, paramInt);
        SystemMsgListView.a(this.a).put(j, paramAbsListView);
      }
      return;
      label240:
      SystemMsgListView.a(this.a).g();
      SystemMsgListView.a(this.a).d();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlu
 * JD-Core Version:    0.7.0.1
 */