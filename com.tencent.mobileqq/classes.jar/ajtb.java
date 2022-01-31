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

public class ajtb
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.rgb(38, 87, 178);
  private static final int d = Color.argb(64, 125, 113, 30);
  private static final int e = Color.argb(64, 6, 59, 156);
  private static final int f = Color.rgb(162, 116, 4);
  private static final int g = Color.argb(64, 213, 185, 118);
  private static final int h = Color.argb(102, 213, 185, 118);
  public int a;
  private final aelz a;
  public QQAppInterface a;
  
  public ajtb(aelz paramaelz, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aelz = paramaelz;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ajtm a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof ajtm)) {
        return (ajtm)paramView.getParent();
      }
    } while (!(paramView instanceof ajtm));
    return (ajtm)paramView;
  }
  
  public void a(View paramView, ajte paramajte)
  {
    ajtm localajtm = a(paramView);
    if (localajtm == null) {}
    ajto localajto;
    ChatMessage localChatMessage;
    do
    {
      return;
      localajto = localajtm.delegate();
      localChatMessage = aekt.a(paramView);
    } while ((localajto == null) || (!localajto.b()) || (localajtm.hasSelected()) || (localChatMessage == null));
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localajto.c(f);
        localajto.b(g);
      }
    }
    for (;;)
    {
      localajto.a(paramajte);
      localajtm.doSelecting(localChatMessage);
      return;
      localajto.c(f);
      localajto.b(h);
      continue;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localajto.c(b);
        localajto.b(d);
      }
      else
      {
        localajto.c(c);
        localajto.b(e);
      }
    }
    paramView = paramView.getResources();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131166878).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131166880).getDefaultColor();; i = paramView.getColorStateList(2131166879).getDefaultColor())
    {
      localajto.c(j);
      localajto.b(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131166877).getDefaultColor();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = aekt.a(paramView);
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
        } while (!ajsx.a().c());
        ajsx.a().d();
        return false;
        bool1 = bool2;
      } while (!ajsx.a().c());
      ajsx.a().d();
      return false;
      bool1 = bool2;
    } while (!ajsx.a().c());
    ajsx.a().d();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtb
 * JD-Core Version:    0.7.0.1
 */