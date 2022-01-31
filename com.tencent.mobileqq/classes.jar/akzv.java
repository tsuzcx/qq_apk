import android.content.res.Resources;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;

public class akzv
  implements Runnable
{
  public akzv(AuthorityActivity paramAuthorityActivity) {}
  
  public void run()
  {
    Object localObject = this.a;
    int i = ((AuthorityActivity)localObject).jdField_b_of_type_Int;
    ((AuthorityActivity)localObject).jdField_b_of_type_Int = (i - 1);
    if (i > 0)
    {
      localObject = (String)this.a.getResources().getText(2131435612);
      AuthorityActivity localAuthorityActivity = this.a;
      i = localAuthorityActivity.c;
      localAuthorityActivity.c = (i + 1);
      switch (i % 3)
      {
      }
      for (;;)
      {
        this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 500L);
        return;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·  ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "·· ");
        continue;
        this.a.jdField_a_of_type_AndroidWidgetButton.setText((String)localObject + "···");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.a.h = true;
    this.a.i = false;
    if (this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDKQQAgentPref", 2, "AutoAuth:" + SystemClock.elapsedRealtime());
      }
      localObject = this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.obtainMessage();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse;
      this.a.jdField_a_of_type_CooperationQqfavUtilHandlerPlus.sendMessage((Message)localObject);
      this.a.jdField_a_of_type_ComTencentProtofileSdkauthorizeSdkAuthorize$AuthorizeResponse = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SDKQQAgentPref", 2, "AutoAuth -- doAuthorize(): " + SystemClock.elapsedRealtime());
    }
    this.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     akzv
 * JD-Core Version:    0.7.0.1
 */