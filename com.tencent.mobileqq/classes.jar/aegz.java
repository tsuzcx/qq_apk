import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.List;
import java.util.Map;

class aegz
  extends Handler
{
  aegz(aegy paramaegy) {}
  
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
                      return;
                    } while (((this.a.an) && ((!this.a.ao) || (((ajoy)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56)).c(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null))) || (this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()));
                    try
                    {
                      this.a.bs();
                      return;
                    }
                    catch (Exception paramMessage)
                    {
                      paramMessage.printStackTrace();
                      return;
                    }
                    paramMessage = this.a.jdField_a_of_type_Ncw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a());
                    this.a.c(paramMessage);
                  } while ((paramMessage == null) || (paramMessage.isEmpty()) || ((aegy.a(this.a)) && (apyq.a())));
                  this.a.t(true);
                  return;
                } while ((aegy.a(this.a)) && (apyq.a()));
                this.a.bq();
                this.a.bp();
                if (QLog.isColorLevel()) {
                  QZLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "setInitHeader in INIT_PUBLICACCOUNT_COVER_MENU");
                }
              } while (this.a.q == 1);
              this.a.t = 5;
              return;
            } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (this.a.d == null) || (!this.a.d.isShowing()));
            this.a.d.dismiss();
            bbmy.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131632732, 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
            return;
          } while ((this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) || (paramMessage.arg2 != 1));
          int i = paramMessage.arg1;
          aegy.a(this.a, babr.a(this.a.jdField_a_of_type_AndroidContentContext, 230, null, String.format(ajjy.a(2131642967), new Object[] { (String)paramMessage.obj }), ajjy.a(2131642981), ajjy.a(2131642977), new aeha(this, i), null));
          aegy.a(this.a).show();
          return;
          paramMessage = paramMessage.getData();
        } while (paramMessage == null);
        this.a.jdField_a_of_type_Aynx.a.put(paramMessage.getString("troopUin"), Integer.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessage.getString("troopUin"), 1)));
        this.a.jdField_a_of_type_Aynx.d();
        this.a.jdField_a_of_type_Aynx.e();
        this.a.jdField_a_of_type_Aynx.c();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aegz
 * JD-Core Version:    0.7.0.1
 */