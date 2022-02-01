import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class ahmq
  implements ahmj, ahmp
{
  private ahlx jdField_a_of_type_Ahlx;
  private ahmo jdField_a_of_type_Ahmo;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public ahmq(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    ahmg.a().b(this);
  }
  
  public int a()
  {
    return agkg.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ahlx = ahly.b(ahlz.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()));
    if (this.jdField_a_of_type_Ahlx == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Ahlx.jdField_a_of_type_JavaLangString;
    } while (str == null);
    ahmg.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot, this.jdField_a_of_type_AndroidContentContext).a(ahlz.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ahmg.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    ahlx localahlx = this.jdField_a_of_type_Ahlx;
    if (localahlx != null)
    {
      ahlz.a(localahlx, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.showStickerBubbleQuickButtonIfNeeded(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localahlx, paramInt2), 10, null, false);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getApp(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin, "0X80091A5", "0X80091A5", localahlx.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(ahmo paramahmo)
  {
    this.jdField_a_of_type_Ahmo = paramahmo;
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
    if (this.jdField_a_of_type_Ahmo != null) {
      this.jdField_a_of_type_Ahmo.a();
    }
  }
  
  public void c()
  {
    ahlz.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot);
  }
  
  public void d()
  {
    ahlz.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.afRoot);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahmq
 * JD-Core Version:    0.7.0.1
 */