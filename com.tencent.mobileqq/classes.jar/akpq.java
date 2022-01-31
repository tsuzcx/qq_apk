import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class akpq
  implements View.OnClickListener
{
  public akpq(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler) {}
  
  public void onClick(View paramView)
  {
    paramView = "";
    Object localObject = Uri.parse(this.a.jdField_a_of_type_JavaLangString);
    try
    {
      localObject = ((Uri)localObject).getQueryParameter("article_id");
      paramView = (View)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.a.f(this.a.e);
    }
    localObject = paramView;
    if (paramView == null) {
      localObject = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject, "", "");
    PublicAccountReportUtils.a("0X8006A1D", "", "", (String)localObject, "", "");
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.b = true;
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438469, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akpq
 * JD-Core Version:    0.7.0.1
 */