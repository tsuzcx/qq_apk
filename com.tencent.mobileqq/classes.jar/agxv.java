import android.content.Context;
import android.graphics.Point;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class agxv
  implements agxo, agxu
{
  private agxc jdField_a_of_type_Agxc;
  private agxt jdField_a_of_type_Agxt;
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  public agxv(Context paramContext, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    agxl.a().b(this);
  }
  
  public int a()
  {
    return afxl.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 10);
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(float paramFloat1, float paramFloat2) {}
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Agxc = agxd.b(agxe.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    if (this.jdField_a_of_type_Agxc == null) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_Agxc.jdField_a_of_type_JavaLangString;
    } while (str == null);
    agxl.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d, this.jdField_a_of_type_AndroidContentContext).a(agxe.b(new Point((int)paramFloat1, (int)paramFloat2), str, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    agxl.a().d(this.jdField_a_of_type_AndroidContentContext).a();
    agxc localagxc = this.jdField_a_of_type_Agxc;
    if (localagxc != null)
    {
      agxe.a(localagxc, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.c(null);
      ThreadManager.post(new StickerBubbleTouchDelegateCallbackForAIO.1(this, localagxc, paramInt2), 10, null, false);
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80091A5", "0X80091A5", localagxc.jdField_a_of_type_Int, 0, Integer.toString(paramInt2), "", "", "");
    }
  }
  
  public void a(agxt paramagxt)
  {
    this.jdField_a_of_type_Agxt = paramagxt;
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
    if (this.jdField_a_of_type_Agxt != null) {
      this.jdField_a_of_type_Agxt.a();
    }
  }
  
  public void c()
  {
    agxe.b(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void d()
  {
    agxe.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.d);
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agxv
 * JD-Core Version:    0.7.0.1
 */