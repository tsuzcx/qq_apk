import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.PlayActionConfig;
import com.tencent.mobileqq.apollo.sdk.CmShowTest.4;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ajgn
{
  private static int a;
  
  private static void b(RelativeLayout paramRelativeLayout)
  {
    QLog.i("CmShowTest", 1, "init relativeLayout:" + paramRelativeLayout);
    CmShowRenderView localCmShowRenderView = new CmShowRenderView(paramRelativeLayout.getContext());
    paramRelativeLayout.addView(localCmShowRenderView, new RelativeLayout.LayoutParams(-1, -1));
    localCmShowRenderView.a(new ajgp(localCmShowRenderView), "1725000451", "1174992642");
  }
  
  private static void d(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testMainAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.a = 3000272;
    localPlayActionConfig.jdField_b_of_type_Int = 101;
    localPlayActionConfig.c = 2;
    localPlayActionConfig.jdField_b_of_type_Boolean = false;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void e(CmShowRenderView paramCmShowRenderView)
  {
    QLog.i("CmShowTest", 1, "testPostAction");
    CmShowRenderView.PlayActionConfig localPlayActionConfig = new CmShowRenderView.PlayActionConfig();
    localPlayActionConfig.a = 3000272;
    localPlayActionConfig.jdField_b_of_type_Int = 102;
    localPlayActionConfig.jdField_b_of_type_Boolean = false;
    localPlayActionConfig.c = 3;
    paramCmShowRenderView.a(localPlayActionConfig);
  }
  
  private static void f(CmShowRenderView paramCmShowRenderView)
  {
    ThreadManager.getUIHandler().postDelayed(new CmShowTest.4(paramCmShowRenderView), 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajgn
 * JD-Core Version:    0.7.0.1
 */