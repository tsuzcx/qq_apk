import NS_COMM.COMM.StCommonExt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class aage
  implements View.OnClickListener
{
  aage(aagd paramaagd) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder(aaed.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.a.a() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(this.a.a().attachInfo.get(), "UTF-8"));
        abbe.b("auth_follow", "clk_more", 0, 0, new String[0]);
        aaej.a(localStringBuilder.toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(aagd.a, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aage
 * JD-Core Version:    0.7.0.1
 */