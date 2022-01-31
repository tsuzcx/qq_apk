import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class aflk
  implements rtw
{
  public aflk(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(rub paramrub)
  {
    int j;
    if (paramrub != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramrub.a() + " tabid = " + (Integer)paramrub.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramrub.a()).intValue(), paramrub.a());
      i = SystemMsgListView.a(this.a).b();
      paramrub = (afmh)SystemMsgListView.a(this.a).get(i);
      if (paramrub == null) {
        break label141;
      }
      j = paramrub.b;
    }
    for (int i = paramrub.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(rub paramrub) {}
  
  public void c(rub paramrub) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflk
 * JD-Core Version:    0.7.0.1
 */