import com.tencent.gdtad.aditem.GdtPreLoader.1;
import com.tencent.mobileqq.mini.entry.MiniAppPrePullManager.IPrePullListener;
import org.json.JSONObject;

public class acan
  implements MiniAppPrePullManager.IPrePullListener
{
  public acan(GdtPreLoader.1 param1) {}
  
  public void onPrePullCallback(boolean paramBoolean, JSONObject paramJSONObject)
  {
    acho.b("GdtPreLoader", String.format("MiniAppPrePullManager.getInstance().prePullAppinfoByLink end:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acan
 * JD-Core Version:    0.7.0.1
 */