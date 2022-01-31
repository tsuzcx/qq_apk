import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aghm
  extends aghi
{
  aipw a;
  
  public aghm(QQAppInterface paramQQAppInterface, agia paramagia, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aemp paramaemp)
  {
    super(paramQQAppInterface, paramagia, paramQQWalletTransferMsgElem, paramInt, paramaemp);
    this.jdField_a_of_type_Aipw = ((aipw)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aipw.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
    {
      this.i = 0;
      return;
    }
    this.i = paramQQWalletTransferMsgElem.effectsId;
  }
  
  public boolean b()
  {
    boolean bool = super.b();
    if (bool) {
      return bool;
    }
    this.jdField_a_of_type_Agia.b.setVisibility(0);
    this.jdField_a_of_type_Agia.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agia.b.setText(aghn.d);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Agia.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Agia.a.setText(ajaf.a(this.jdField_a_of_type_Agia.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Agia.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aghm
 * JD-Core Version:    0.7.0.1
 */