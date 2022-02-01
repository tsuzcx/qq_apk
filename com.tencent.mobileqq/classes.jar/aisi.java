import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class aisi
  implements aisb, aish
{
  private airp jdField_a_of_type_Airp;
  private aisg jdField_a_of_type_Aisg;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public aisi(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    airy.a().b(this);
  }
  
  public int a()
  {
    return ahnt.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Airp = airq.b(airr.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    if (this.jdField_a_of_type_Airp == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Airp.jdField_a_of_type_JavaLangString;
    } while (str == null);
    airy.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d, this.jdField_a_of_type_AndroidContentContext).a(airr.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    airy.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    airp localairp = this.jdField_a_of_type_Airp;
    if (localairp != null)
    {
      airr.a(localairp, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localairp, paramInt2), 10, null, false);
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localairp.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(aisg paramaisg)
  {
    this.jdField_a_of_type_Aisg = paramaisg;
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
    if (this.jdField_a_of_type_Aisg != null) {
      this.jdField_a_of_type_Aisg.a();
    }
  }
  
  public void c()
  {
    airr.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void d()
  {
    airr.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aisi
 * JD-Core Version:    0.7.0.1
 */