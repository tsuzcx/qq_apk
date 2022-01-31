import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.model.ChatBackgroundManager.BgThemeColorExtractListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Vector;

public class aeho
  implements ChatBackgroundManager.BgThemeColorExtractListener
{
  public aeho(ChatBackgroundManager paramChatBackgroundManager, Context paramContext) {}
  
  public void a(boolean paramBoolean, Vector paramVector)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
    {
      paramVector = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment();
      if ((paramVector != null) && (paramVector.a() != null) && (paramVector.a().a != null))
      {
        ChatXListView localChatXListView = paramVector.a().a;
        int i = localChatXListView.getFirstVisiblePosition();
        int j = localChatXListView.getLastVisiblePosition();
        while (i <= j)
        {
          Object localObject = AIOUtils.a(localChatXListView, i);
          if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseBubbleBuilder.ViewHolder)))
          {
            localObject = (BaseBubbleBuilder.ViewHolder)((View)localObject).getTag();
            if ((((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo != null) && (!((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.a) && (((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo.b))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ChatBackgroundManager", 2, "BgThemeColorExtractListener.onBgThemeColorExtracted: success=true, refresh AIO.");
              }
              paramVector.a().a(((BaseBubbleBuilder.ViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage, 1);
            }
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeho
 * JD-Core Version:    0.7.0.1
 */