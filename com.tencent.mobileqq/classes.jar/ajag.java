import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ajag
  implements tja
{
  public ajag(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(tjf paramtjf)
  {
    int j;
    if (paramtjf != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramtjf.a() + " tabid = " + (Integer)paramtjf.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramtjf.a()).intValue(), paramtjf.a());
      i = SystemMsgListView.a(this.a).b();
      paramtjf = (aixs)SystemMsgListView.a(this.a).get(i);
      if (paramtjf == null) {
        break label141;
      }
      j = paramtjf.b;
    }
    for (int i = paramtjf.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(tjf paramtjf) {}
  
  public void c(tjf paramtjf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajag
 * JD-Core Version:    0.7.0.1
 */