import android.util.SparseArray;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SwipListView;

public class ajlp
  implements szu
{
  public ajlp(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(szz paramszz)
  {
    int j;
    if (paramszz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriendSystemMsgListView", 2, "setStickHead onTabSelected : position = " + paramszz.a() + " tabid = " + (Integer)paramszz.a());
      }
      SystemMsgListView.a(this.a).a(((Integer)paramszz.a()).intValue(), paramszz.a());
      i = SystemMsgListView.a(this.a).b();
      paramszz = (ajjb)SystemMsgListView.a(this.a).get(i);
      if (paramszz == null) {
        break label141;
      }
      j = paramszz.b;
    }
    for (int i = paramszz.c;; i = SystemMsgListView.a(this.a).c)
    {
      SystemMsgListView.a(this.a).setSelectionFromTop(j, i);
      SystemMsgListView.a(this.a).a(0L);
      return;
      label141:
      j = SystemMsgListView.a(this.a).b;
    }
  }
  
  public void b(szz paramszz) {}
  
  public void c(szz paramszz) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajlp
 * JD-Core Version:    0.7.0.1
 */