import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aihk
  implements aihd, aihj
{
  private aigr jdField_a_of_type_Aigr;
  private aihi jdField_a_of_type_Aihi;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public aihk(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    aiha.a().b(this);
  }
  
  public int a()
  {
    return ahcw.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aigr = aigs.b(aigt.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()));
    if (this.jdField_a_of_type_Aigr == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Aigr.jdField_a_of_type_JavaLangString;
    } while (str == null);
    aiha.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot, this.jdField_a_of_type_AndroidContentContext).a(aigt.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aiha.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    aigr localaigr = this.jdField_a_of_type_Aigr;
    if (localaigr != null)
    {
      aigt.a(localaigr, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showStickerBubbleQuickButtonIfNeeded(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localaigr, paramInt2), 10, null, false);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, "0X80091A5", "0X80091A5", localaigr.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(aihi paramaihi)
  {
    this.jdField_a_of_type_Aihi = paramaihi;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mIconButtonInInputRight == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mIconButtonInInputRight.getLeft() > paramFloat1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mIconButtonInInputRight.getRight() < paramFloat1)) {
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mIconButtonInInputRight.getTop() <= paramFloat2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mIconButtonInInputRight.getBottom() >= paramFloat2));
    return true;
  }
  
  public void b()
  {
    d();
    if (this.jdField_a_of_type_Aihi != null) {
      this.jdField_a_of_type_Aihi.a();
    }
  }
  
  public void c()
  {
    aigt.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot);
  }
  
  public void d()
  {
    aigt.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aihk
 * JD-Core Version:    0.7.0.1
 */