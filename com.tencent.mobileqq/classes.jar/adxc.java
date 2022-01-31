import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class adxc
  implements RefreshView.OnRefreshListener
{
  public adxc(UiApiPlugin paramUiApiPlugin) {}
  
  public void a()
  {
    this.a.dispatchJsEvent("qbrowserPullDown", null, null);
    this.a.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adxc
 * JD-Core Version:    0.7.0.1
 */