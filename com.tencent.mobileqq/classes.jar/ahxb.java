import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahxb
  extends ahwx
{
  akqe a;
  
  public ahxb(QQAppInterface paramQQAppInterface, ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afrr paramafrr)
  {
    super(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    this.jdField_a_of_type_Akqe = ((akqe)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER));
    if (a(this.jdField_a_of_type_Akqe.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.i = 0;
      return;
    }
    this.i = paramQQWalletBaseMsgElem.effectsId;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Ahxr.b.setVisibility(0);
    this.jdField_a_of_type_Ahxr.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahxr.b.setText(ahxc.m);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Ahxr.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Ahxr.a.setText(albw.a(this.jdField_a_of_type_Ahxr.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_Ahxr.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxb
 * JD-Core Version:    0.7.0.1
 */