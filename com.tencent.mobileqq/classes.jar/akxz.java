import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.text.TextUtils;

public class akxz
{
  private static final int b = Color.rgb(123, 113, 30);
  private static final int c = Color.rgb(38, 87, 178);
  private static final int d = Color.argb(64, 125, 113, 30);
  private static final int e = Color.argb(64, 6, 59, 156);
  private static final int f = Color.rgb(162, 116, 4);
  private static final int g = Color.argb(64, 213, 185, 118);
  private static final int h = Color.argb(102, 213, 185, 118);
  public int a;
  private final aezn a;
  public QQAppInterface a;
  
  public akxz(aezn paramaezn, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Aezn = paramaezn;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private akyk a(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return null;
      if ((paramView.getParent() instanceof akyk)) {
        return (akyk)paramView.getParent();
      }
    } while (!(paramView instanceof akyk));
    return (akyk)paramView;
  }
  
  public void a(View paramView, akyc paramakyc)
  {
    akyk localakyk = a(paramView);
    if (localakyk == null) {}
    akym localakym;
    ChatMessage localChatMessage;
    do
    {
      return;
      localakym = localakyk.delegate();
      localChatMessage = AIOUtils.getMessage(paramView);
    } while ((localakym == null) || (!localakym.b()) || (localakyk.hasSelected()) || (localChatMessage == null));
    if (this.jdField_a_of_type_Int == 2) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localakym.c(f);
        localakym.b(g);
      }
    }
    for (;;)
    {
      localakym.a(paramakyc);
      localakyk.doSelecting(localChatMessage);
      return;
      localakym.c(f);
      localakym.b(h);
      continue;
      if (this.jdField_a_of_type_Int != 1) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin))
      {
        localakym.c(b);
        localakym.b(d);
      }
      else
      {
        localakym.c(c);
        localakym.b(e);
      }
    }
    paramView = paramView.getResources();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localChatMessage.selfuin)) {
      j = paramView.getColorStateList(2131166987).getDefaultColor();
    }
    for (int i = paramView.getColorStateList(2131166989).getDefaultColor();; i = paramView.getColorStateList(2131166988).getDefaultColor())
    {
      localakym.c(j);
      localakym.b(i);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ChatAdapterSelectableHelper", 0, "Load Select color, cursor=" + j + ", component=" + i);
      break;
      j = paramView.getColorStateList(2131166986).getDefaultColor();
    }
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    ChatMessage localChatMessage = AIOUtils.getMessage(paramView);
    boolean bool1;
    if (AppSetting.c)
    {
      bool1 = false;
      if (!bool1) {
        break label186;
      }
      paramView = a(paramView);
      if (paramView == null) {
        break label167;
      }
      if (paramView.contentLength() <= 0) {
        break label148;
      }
      bool1 = true;
    }
    label148:
    label167:
    label186:
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
          if ((localChatMessage instanceof MessageForPtt))
          {
            bool1 = true;
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
        } while (!akxv.a().c());
        akxv.a().d();
        return false;
        bool1 = bool2;
      } while (!akxv.a().c());
      akxv.a().d();
      return false;
      bool1 = bool2;
    } while (!akxv.a().c());
    akxv.a().d();
    return false;
  }
  
  public boolean a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramView = a(paramView);
    if (paramView == null) {}
    do
    {
      do
      {
        return false;
      } while ((!paramView.hasTouchSelectableArea((int)paramFloat1, (int)paramFloat2)) || (TextUtils.getNeoTextAfter(paramView.content().toString(), 0, paramInt2, false).length() < paramInt2));
      paramView = paramView.delegate();
    } while ((paramView == null) || (!paramView.f()) || (paramView.a(paramFloat1, paramFloat2, paramInt1, paramInt2) == -1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akxz
 * JD-Core Version:    0.7.0.1
 */