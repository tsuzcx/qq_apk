import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;

public class adje
  implements View.OnClickListener
{
  public adje(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    if (SendBottomBar.a(this.a).isChecked())
    {
      SendBottomBar.a(this.a).r();
      SendBottomBar.a(this.a).setText("取消全选");
      return;
    }
    SendBottomBar.a(this.a).s();
    SendBottomBar.a(this.a).setText("全选");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adje
 * JD-Core Version:    0.7.0.1
 */