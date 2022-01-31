import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aekx
  extends aekt
{
  agvz a;
  
  public aekx(QQAppInterface paramQQAppInterface, aell paramaell, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvj paramacvj)
  {
    super(paramQQAppInterface, paramaell, paramQQWalletTransferMsgElem, paramInt, paramacvj);
    this.jdField_a_of_type_Agvz = ((agvz)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvz.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Aell.b.setVisibility(0);
    this.jdField_a_of_type_Aell.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aell.b.setText(aeky.d);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aell.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Aell.a.setText(ahiy.a(this.jdField_a_of_type_Aell.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Aell.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekx
 * JD-Core Version:    0.7.0.1
 */