import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;

public class aify
  extends aifp
{
  public aify(QQAppInterface paramQQAppInterface, aigj paramaigj, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, aghj paramaghj)
  {
    super(paramQQAppInterface, paramaigj, paramQQWalletBaseMsgElem, paramInt, paramaghj);
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend()) {
      this.i = 0;
    }
    this.j = 2130847237;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Aigj.b.setVisibility(0);
    this.jdField_a_of_type_Aigj.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aigj.b.setText(aifu.b);
    return false;
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.isSend())
    {
      this.jdField_a_of_type_Aigj.d.setVisibility(0);
      return;
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aify
 * JD-Core Version:    0.7.0.1
 */