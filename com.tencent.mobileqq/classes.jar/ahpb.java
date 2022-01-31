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

public class ahpb
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.rgb(38, 87, 178);
  private static final int d = Color.argb(64, 125, 113, 30);
  private static final int e = Color.argb(64, 6, 59, 156);
  private static final int f = Color.rgb(162, 116, 4);
  private static final int g = Color.argb(64, 213, 185, 118);
  private static final int h = Color.argb(102, 213, 185, 118);
  public int a;
  private final acka a;
  public QQAppInterface a;
  
  public ahpb(acka paramacka, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Acka = paramacka;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ahpm a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof ahpm)) {
        return (ahpm)paramView.getParent();
      }
    } while (!(paramView instanceof ahpm));
    return (ahpm)paramView;
  }
  
  public void a(View paramView, ahpe paramahpe)
  {
    ahpm localahpm = a(paramView);
    if (localahpm == null) {}
    ahpo localahpo;
    ChatMessage localChatMessage;
    do
    {
      return;
      localahpo = localahpm.a();
      localChatMessage = aciy.a(paramView);
    } while ((localahpo == null) || (!localahpo.b()) || (localahpm.h()) || (localChatMessage == null));
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localahpo.c(f);
        localahpo.b(g);
      }
    }
    for (;;)
    {
      localahpo.a(paramahpe);
      localahpm.a(localChatMessage);
      return;
      localahpo.c(f);
      localahpo.b(h);
      continue;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localahpo.c(b);
        localahpo.b(d);
      }
      else
      {
        localahpo.c(c);
        localahpo.b(e);
      }
    }
    paramView = paramView.getResources();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131101237).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131101239).getDefaultColor();; i = paramView.getColorStateList(2131101238).getDefaultColor())
    {
      localahpo.c(j);
      localahpo.b(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131101236).getDefaultColor();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = aciy.a(paramView);
    boolean bool1;
    if (AppSetting.c)
    {
      bool1 = false;
      if (!bool1) {
        break label173;
      }
      paramView = a(paramView);
      if (paramView == null) {
        break label154;
      }
      if (paramView.a() <= 0) {
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
        } while (!ahox.a().c());
        ahox.a().d();
        return false;
        bool1 = bool2;
      } while (!ahox.a().c());
      ahox.a().d();
      return false;
      bool1 = bool2;
    } while (!ahox.a().c());
    ahox.a().d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahpb
 * JD-Core Version:    0.7.0.1
 */