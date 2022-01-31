import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;

public class aibr
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.rgb(38, 87, 178);
  private static final int d = Color.argb(64, 125, 113, 30);
  private static final int e = Color.argb(64, 6, 59, 156);
  private static final int f = Color.rgb(162, 116, 4);
  private static final int g = Color.argb(64, 213, 185, 118);
  private static final int h = Color.argb(102, 213, 185, 118);
  public int a;
  private final acup a;
  public QQAppInterface a;
  
  public aibr(acup paramacup, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Acup = paramacup;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private aicc a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof aicc)) {
        return (aicc)paramView.getParent();
      }
    } while (!(paramView instanceof aicc));
    return (aicc)paramView;
  }
  
  public void a(View paramView, aibu paramaibu)
  {
    aicc localaicc = a(paramView);
    if (localaicc == null) {}
    aice localaice;
    ChatMessage localChatMessage;
    do
    {
      return;
      localaice = localaicc.delegate();
      localChatMessage = actj.a(paramView);
    } while ((localaice == null) || (!localaice.b()) || (localaicc.hasSelected()) || (localChatMessage == null));
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localaice.c(f);
        localaice.b(g);
      }
    }
    for (;;)
    {
      localaice.a(paramaibu);
      localaicc.doSelecting(localChatMessage);
      return;
      localaice.c(f);
      localaice.b(h);
      continue;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localaice.c(b);
        localaice.b(d);
      }
      else
      {
        localaice.c(c);
        localaice.b(e);
      }
    }
    paramView = paramView.getResources();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131166831).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131166833).getDefaultColor();; i = paramView.getColorStateList(2131166832).getDefaultColor())
    {
      localaice.c(j);
      localaice.b(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131166830).getDefaultColor();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = actj.a(paramView);
    boolean bool1;
    if (AppSetting.d)
    {
      bool1 = false;
      if (!bool1) {
        break label173;
      }
      paramView = a(paramView);
      if (paramView == null) {
        break label154;
      }
      if (paramView.contentLength() <= 0) {
        break label135;
      }
      bool1 = true;
    }
    label135:
    label154:
    label173:
    do
    {
      do
      {
        do
        {
          return bool1;
          if ((localChatMessage instanceof MessageForText))
          {
            if ((!(localChatMessage instanceof MessageForWantGiftMsg)) && (!(localChatMessage instanceof MessageForFoldMsg)))
            {
              bool1 = true;
              break;
            }
            bool1 = false;
            break;
          }
          if ((localChatMessage instanceof MessageForMixedMsg))
          {
            bool1 = ((MessageForMixedMsg)localChatMessage).canSelectable();
            break;
          }
          if ((localChatMessage instanceof MessageForReplyText))
          {
            bool1 = true;
            break;
          }
          if ((localChatMessage instanceof MessageForLongMsg))
          {
            bool1 = ((MessageForLongMsg)localChatMessage).canSelectable();
            break;
          }
          bool1 = false;
          break;
          bool1 = bool2;
        } while (!aibn.a().c());
        aibn.a().d();
        return false;
        bool1 = bool2;
      } while (!aibn.a().c());
      aibn.a().d();
      return false;
      bool1 = bool2;
    } while (!aibn.a().c());
    aibn.a().d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aibr
 * JD-Core Version:    0.7.0.1
 */