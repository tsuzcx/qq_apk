import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class aify
  implements tdu
{
  public aify(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(tdz paramtdz)
  {
    int j;
    if (paramtdz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramtdz.a() + " tabid = " + (Integer)paramtdz.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramtdz.a()).intValue(), paramtdz.a());
      i = SystemMsgListView.a(this.a).b();
      paramtdz = (aidk)SystemMsgListView.a(this.a).get(i);
      if (paramtdz == null) {
        break label141;
      }
      j = paramtdz.b;
    }
    for (int i = paramtdz.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(tdz paramtdz) {}
  
  public void c(tdz paramtdz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aify
 * JD-Core Version:    0.7.0.1
 */