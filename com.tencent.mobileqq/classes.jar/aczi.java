import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class aczi
  implements View.OnClickListener
{
  public aczi(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    paramView = "是否彻底删除 " + FMDataCache.a() + " 个已下载的文件?";
    this.a.a = DialogUtil.a(SendBottomBar.a(this.a), 230, null, paramView, "取消", "删除", new aczj(this), new aczk(this));
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aczi
 * JD-Core Version:    0.7.0.1
 */