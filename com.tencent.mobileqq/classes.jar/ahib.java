import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.1.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class ahib
  extends MqqHandler
{
  ahib(ahia paramahia) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof List)));
      this.a.a((List)paramMessage.obj);
      if ((ahia.a(this.a) == null) || (ahia.a(this.a).size() == 0))
      {
        ahia.a(this.a, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
        }
        this.a.a();
        this.a.jdField_a_of_type_JavaLangRunnable = new MultiForwardChatPie.1.1(this);
        ahia.a(this.a).postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 60000L);
        ThreadRegulator.a().b(1);
        awcm.a().a(this.a.app, this.a.b, this.a.app.getCurrentAccountUin(), this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curFriendUin, this.a.sessionInfo.curType, this.a.jdField_a_of_type_Long, 1035, this.a.a(ahia.a(this.a)));
        return;
      }
      paramMessage = ChatActivityUtils.a(ahia.a(this.a), this.a.sessionInfo, this.a.app);
      paramMessage = ChatActivityUtils.a(this.a.app, BaseApplicationImpl.getContext(), this.a.sessionInfo, paramMessage, -1L);
      ahia.a(this.a).setVisibility(8);
      ahia.a(this.a).setVisibility(0);
      ahia.a(this.a).setVisibility(0);
      ahia.a(this.a).a(ahia.a(this.a), paramMessage);
    } while (!QLog.isColorLevel());
    QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahib
 * JD-Core Version:    0.7.0.1
 */