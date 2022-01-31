import android.os.Bundle;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxProtocol.LastFeedObserver;
import com.tencent.qphone.base.util.QLog;

public class acfl
  extends MsgBoxProtocol.LastFeedObserver
{
  public acfl(MsgBoxListActivity paramMsgBoxListActivity) {}
  
  protected void a(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.a.app.a().addMessage(paramString, 0, paramInt, paramLong, 1);
      }
      while (!this.a.isFinishing())
      {
        this.a.a();
        return;
        if (this.a.app.a().isInMsgBoxRecentList(AppConstants.ag, this.a.jdField_a_of_type_Int))
        {
          paramInt = this.a.app.a().a(AppConstants.ag, this.a.jdField_a_of_type_Int);
          this.a.app.a().a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, AppConstants.ag, this.a.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            RecentUtil.b(this.a.app, AppConstants.ag, this.a.jdField_a_of_type_Int);
            this.a.app.a().a(AppConstants.ag, this.a.jdField_a_of_type_Int, true, true);
          }
        }
      }
    }
  }
  
  protected void b(boolean paramBoolean1, String paramString, int paramInt, long paramLong, boolean paramBoolean2, Bundle paramBundle)
  {
    if (!paramBoolean1) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg_box", 2, "onGetInteractLastFeed = false");
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean2) {
        this.a.app.a().addMessage(paramString, 0, paramInt, paramLong, 2);
      }
      while (!this.a.isFinishing())
      {
        this.a.a();
        return;
        if (this.a.app.a().isInMsgBoxRecentList(AppConstants.ah, this.a.jdField_a_of_type_Int))
        {
          paramInt = this.a.app.a().a(AppConstants.ah, this.a.jdField_a_of_type_Int);
          this.a.app.a().a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int, AppConstants.ah, this.a.app.getCurrentAccountUin());
          if (paramInt > 0)
          {
            RecentUtil.b(this.a.app, AppConstants.ah, this.a.jdField_a_of_type_Int);
            this.a.app.a().a(AppConstants.ah, this.a.jdField_a_of_type_Int, true, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acfl
 * JD-Core Version:    0.7.0.1
 */