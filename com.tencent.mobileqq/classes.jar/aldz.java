import android.os.Bundle;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;

public class aldz
  implements Runnable
{
  public aldz(BaseJsCallBack paramBaseJsCallBack, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaLangString.equals("1")) {
      bool = true;
    }
    if (BaseJsCallBack.access$000(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack) != null)
    {
      SendMsg localSendMsg = new SendMsg("changeLoadingTip");
      localSendMsg.a.putBoolean("showLoadingView", bool);
      BaseJsCallBack.access$000(this.jdField_a_of_type_ComTencentOpenAppcommonJsBaseJsCallBack).b(localSendMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aldz
 * JD-Core Version:    0.7.0.1
 */