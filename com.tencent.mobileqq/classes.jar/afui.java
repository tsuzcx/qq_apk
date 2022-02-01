import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.HashMap;
import java.util.List;

public class afui
  extends afrl
{
  public afui(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener);
  }
  
  private afqz a()
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
    if (localChatFragment == null) {
      return null;
    }
    return localChatFragment.a().listAdapter;
  }
  
  protected void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, afqr paramafqr)
  {
    if ((!afok.a()) || (paramChatMessage == null) || (paramBaseChatItemLayout == null) || (paramBaseChatItemLayout.e == null)) {}
    while ((paramChatMessage.fakeSenderType != 0) || (paramChatMessage.istroop != 1)) {
      return;
    }
    if ((paramChatMessage.getQcircleRedDotFlag()) && (paramChatMessage.istroop == 1))
    {
      paramBaseChatItemLayout.e.setVisibility(0);
      a(paramBaseChatItemLayout.e);
      return;
    }
    paramBaseChatItemLayout.e.setVisibility(8);
  }
  
  public void b(View paramView)
  {
    super.b(paramView);
    if (paramView == null) {}
    ChatMessage localChatMessage;
    do
    {
      do
      {
        return;
      } while (paramView.getId() != 2131364563);
      localChatMessage = ((afrk)AIOUtils.getHolder(paramView)).a;
      localObject = a();
    } while ((localObject == null) || (localChatMessage == null));
    List localList = ((afqz)localObject).a();
    afok.a().a(localList, localChatMessage.senderuin);
    ((afqz)localObject).notifyDataSetChanged();
    new HashMap();
    Object localObject = localChatMessage.getQcircleRedDotJumpSchema();
    paramView = bhey.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.getContext(), (String)localObject);
    if (paramView != null) {
      paramView.a();
    }
    QCircleLpReportDc05504.report(localChatMessage.senderuin, 61, 1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afui
 * JD-Core Version:    0.7.0.1
 */