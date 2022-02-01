import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;

public class ahxg
  extends ahwx
{
  public ahxg(QQAppInterface paramQQAppInterface, ahxr paramahxr, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afrr paramafrr)
  {
    super(paramQQAppInterface, paramahxr, paramQQWalletBaseMsgElem, paramInt, paramafrr);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend()) {
      this.i = 0;
    }
    this.j = 2130847243;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Ahxr.b.setVisibility(0);
    this.jdField_a_of_type_Ahxr.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahxr.b.setText(ahxc.b);
    return false;
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.jdField_a_of_type_Ahxr.d.setVisibility(0);
      return;
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahxg
 * JD-Core Version:    0.7.0.1
 */