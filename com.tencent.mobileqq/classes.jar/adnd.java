import com.tencent.biz.ui.RefreshView.OnRefreshListener;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public class adnd
  implements RefreshView.OnRefreshListener
{
  public adnd(UiApiPlugin paramUiApiPlugin) {}
  
  public void a()
  {
    this.a.dispatchJsEvent("qbrowserPullDown", null, null);
    this.a.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adnd
 * JD-Core Version:    0.7.0.1
 */