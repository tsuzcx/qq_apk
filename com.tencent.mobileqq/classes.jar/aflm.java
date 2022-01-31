import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class aflm
  implements rtz
{
  public aflm(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(rue paramrue)
  {
    int j;
    if (paramrue != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramrue.a() + " tabid = " + (Integer)paramrue.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramrue.a()).intValue(), paramrue.a());
      i = SystemMsgListView.a(this.a).b();
      paramrue = (afmj)SystemMsgListView.a(this.a).get(i);
      if (paramrue == null) {
        break label141;
      }
      j = paramrue.b;
    }
    for (int i = paramrue.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(rue paramrue) {}
  
  public void c(rue paramrue) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aflm
 * JD-Core Version:    0.7.0.1
 */