import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Map;

class agou
  extends Handler
{
  agou(agot paramagot) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 5: 
    case 8: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 7: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return;
                      } while (((this.a.an) && ((!this.a.ao) || (((aluw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))) || ((agot.a(this.a)) && (nvd.c()) && (agot.a(this.a) != null) && (agot.b(this.a).findViewWithTag("echopCustomTabView") != null)) || (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()));
                      try
                      {
                        this.a.bx();
                        return;
                      }
                      catch (Exception paramMessage)
                      {
                        paramMessage.printStackTrace();
                        return;
                      }
                      paramMessage = this.a.jdField_a_of_type_Nrc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
                      this.a.c(paramMessage);
                    } while ((paramMessage == null) || (paramMessage.isEmpty()));
                    if ((!agot.b(this.a)) || (!asjb.a())) {
                      this.a.t(true);
                    }
                  } while ((agot.a(this.a)) && (nvd.a()));
                  this.a.t(true);
                  return;
                } while (((agot.b(this.a)) && (asjb.a())) || ((agot.a(this.a)) && (nvd.a())));
                this.a.bv();
                this.a.bu();
                if (QLog.isColorLevel()) {
                  QZLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
                }
              } while (this.a.q == 1);
              this.a.t = 5;
              return;
            } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.a.d == null) || (!this.a.d.isShowing()));
            this.a.d.dismiss();
            QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131698773, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
            return;
          } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (paramMessage.arg2 != 1));
          int i = paramMessage.arg1;
          agot.a(this.a, bdcd.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, String.format(alpo.a(2131709135), new Object[] { (String)paramMessage.obj }), alpo.a(2131709149), alpo.a(2131709145), new agov(this, i), null));
          agot.a(this.a).show();
          return;
          paramMessage = paramMessage.getData();
        } while (paramMessage == null);
        this.a.jdField_a_of_type_Bbmy.a.put(paramMessage.getString("troopUin"), Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.getString("troopUin"), 1)));
        this.a.jdField_a_of_type_Bbmy.d();
        this.a.jdField_a_of_type_Bbmy.e();
        this.a.jdField_a_of_type_Bbmy.c();
        return;
      } while (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null);
      this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
      this.a.ab = false;
      return;
    }
    if (!(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      return;
    }
    paramMessage = new Intent(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, SplashActivity.class);
    paramMessage.putExtra("tab_index", MainFragment.b);
    paramMessage.putExtra("fragment_id", 1);
    paramMessage.setFlags(67108864);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agou
 * JD-Core Version:    0.7.0.1
 */