import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;

public class acek
  extends FrameLayout
{
  public acek(GameCenterAPIJavaScript paramGameCenterAPIJavaScript, Context paramContext, CustomWebView paramCustomWebView)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView instanceof View)) {
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acek
 * JD-Core Version:    0.7.0.1
 */