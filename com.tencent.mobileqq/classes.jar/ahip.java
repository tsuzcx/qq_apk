import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ahip
  implements skj
{
  public ahip(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(sko paramsko)
  {
    int j;
    if (paramsko != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramsko.a() + " tabid = " + (Integer)paramsko.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramsko.a()).intValue(), paramsko.a());
      i = SystemMsgListView.a(this.a).b();
      paramsko = (ahjm)SystemMsgListView.a(this.a).get(i);
      if (paramsko == null) {
        break label141;
      }
      j = paramsko.b;
    }
    for (int i = paramsko.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(sko paramsko) {}
  
  public void c(sko paramsko) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahip
 * JD-Core Version:    0.7.0.1
 */