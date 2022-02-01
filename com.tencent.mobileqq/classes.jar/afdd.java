import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
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

public class afdd
  extends aezz
{
  public afdd(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener);
  }
  
  private aezn a()
  {
    if (!(this.a instanceof FragmentActivity)) {
      return null;
    }
    ChatFragment localChatFragment = ((FragmentActivity)this.a).getChatFragment();
    if (localChatFragment == null) {
      return null;
    }
    return localChatFragment.a().listAdapter;
  }
  
  protected void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, aezf paramaezf)
  {
    if ((paramChatMessage == null) || (paramBaseChatItemLayout == null) || (paramBaseChatItemLayout.e == null)) {}
    while ((paramChatMessage.fakeSenderType != 0) || (paramChatMessage.istroop != 1)) {
      return;
    }
    boolean bool = paramChatMessage.getQcircleRedDotFlag();
    if ((aewz.a()) && (bool) && (paramChatMessage.istroop == 1))
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
    do
    {
      do
      {
        return;
      } while (paramView.getId() != 2131364481);
      paramView = ((aezy)AIOUtils.getHolder(paramView)).a;
      localObject = a();
    } while ((localObject == null) || (paramView == null));
    List localList = ((aezn)localObject).a();
    aewz.a().a(localList, paramView.senderuin);
    ((aezn)localObject).notifyDataSetChanged();
    Object localObject = new HashMap();
    ((HashMap)localObject).put("uin", paramView.senderuin);
    vgn.a(BaseApplicationImpl.context, "openmainpage", (HashMap)localObject);
    QCircleLpReportDc05504.report(paramView.senderuin, 61, 1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdd
 * JD-Core Version:    0.7.0.1
 */