import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aeli
  implements aelb, aelh
{
  private aekp jdField_a_of_type_Aekp;
  private aelg jdField_a_of_type_Aelg;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public aeli(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    aeky.a().b(this);
  }
  
  public int a()
  {
    return adll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Aekp = aekq.b(aekr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    if (this.jdField_a_of_type_Aekp == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Aekp.jdField_a_of_type_JavaLangString;
    } while (str == null);
    aeky.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d, this.jdField_a_of_type_AndroidContentContext).a(aekr.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    aeky.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    aekp localaekp = this.jdField_a_of_type_Aekp;
    if (localaekp != null)
    {
      aekr.a(localaekp, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localaekp, paramInt2), 10, null, false);
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localaekp.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(aelg paramaelg)
  {
    this.jdField_a_of_type_Aelg = paramaelg;
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
    if (this.jdField_a_of_type_Aelg != null) {
      this.jdField_a_of_type_Aelg.a();
    }
  }
  
  public void c()
  {
    aekr.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void d()
  {
    aekr.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeli
 * JD-Core Version:    0.7.0.1
 */