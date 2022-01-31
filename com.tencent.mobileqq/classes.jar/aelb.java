import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aelb
  extends aekt
{
  public aelb(QQAppInterface paramQQAppInterface, aell paramaell, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvj paramacvj)
  {
    super(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend()) {
      this.i = 0;
    }
    this.j = 2130846313;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aell.b.setVisibility(0);
    this.jdField_a_of_type_Aell.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aell.b.setText("QQ视频通话红包");
    return false;
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.jdField_a_of_type_Aell.d.setVisibility(0);
      return;
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aelb
 * JD-Core Version:    0.7.0.1
 */