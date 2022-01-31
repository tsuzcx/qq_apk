import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class aezw
  implements rhj
{
  public aezw(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(rho paramrho)
  {
    int j;
    if (paramrho != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramrho.a() + " tabid = " + (Integer)paramrho.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramrho.a()).intValue(), paramrho.a());
      i = SystemMsgListView.a(this.a).b();
      paramrho = (afat)SystemMsgListView.a(this.a).get(i);
      if (paramrho == null) {
        break label141;
      }
      j = paramrho.b;
    }
    for (int i = paramrho.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(rho paramrho) {}
  
  public void c(rho paramrho) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezw
 * JD-Core Version:    0.7.0.1
 */