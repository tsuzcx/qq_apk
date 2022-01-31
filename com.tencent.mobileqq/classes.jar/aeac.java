import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aeac
  extends adzu
{
  public aeac(QQAppInterface paramQQAppInterface, aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, ackq paramackq)
  {
    super(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend()) {
      this.i = 0;
    }
    this.j = 2130846132;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aeam.b.setVisibility(0);
    this.jdField_a_of_type_Aeam.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aeam.b.setText("QQ视频通话红包");
    return false;
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.jdField_a_of_type_Aeam.d.setVisibility(0);
      return;
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeac
 * JD-Core Version:    0.7.0.1
 */