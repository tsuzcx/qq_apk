import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aewb
  implements aevu, aewa
{
  private aevi jdField_a_of_type_Aevi;
  private aevz jdField_a_of_type_Aevz;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public aewb(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    aevr.a().b(this);
  }
  
  public int a()
  {
    return adwj.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aevi = aevj.b(aevk.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    if (this.jdField_a_of_type_Aevi == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Aevi.jdField_a_of_type_JavaLangString;
    } while (str == null);
    aevr.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d, this.jdField_a_of_type_AndroidContentContext).a(aevk.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aevr.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    aevi localaevi = this.jdField_a_of_type_Aevi;
    if (localaevi != null)
    {
      aevk.a(localaevi, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localaevi, paramInt2), 10, null, false);
      axqy.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localaevi.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(aevz paramaevz)
  {
    this.jdField_a_of_type_Aevz = paramaevz;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton == null) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getLeft() > paramFloat1) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getRight() < paramFloat1)) {
        return true;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getTop() <= paramFloat2) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetImageButton.getBottom() >= paramFloat2));
    return true;
  }
  
  public void b()
  {
    d();
    if (this.jdField_a_of_type_Aevz != null) {
      this.jdField_a_of_type_Aevz.a();
    }
  }
  
  public void c()
  {
    aevk.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void d()
  {
    aevk.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aewb
 * JD-Core Version:    0.7.0.1
 */