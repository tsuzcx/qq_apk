import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ajax
  implements trf
{
  public ajax(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(trk paramtrk)
  {
    int j;
    if (paramtrk != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramtrk.a() + " tabid = " + (Integer)paramtrk.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramtrk.a()).intValue(), paramtrk.a());
      i = SystemMsgListView.a(this.a).b();
      paramtrk = (aiyj)SystemMsgListView.a(this.a).get(i);
      if (paramtrk == null) {
        break label141;
      }
      j = paramtrk.b;
    }
    for (int i = paramtrk.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(trk paramtrk) {}
  
  public void c(trk paramtrk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajax
 * JD-Core Version:    0.7.0.1
 */