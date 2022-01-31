import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class agmb
  extends aglx
{
  aiul a;
  
  public agmb(QQAppInterface paramQQAppInterface, agmp paramagmp, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, aere paramaere)
  {
    super(paramQQAppInterface, paramagmp, paramQQWalletTransferMsgElem, paramInt, paramaere);
    this.jdField_a_of_type_Aiul = ((aiul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aiul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Agmp.b.setVisibility(0);
    this.jdField_a_of_type_Agmp.b.setTextColor(-8947849);
    this.jdField_a_of_type_Agmp.b.setText(agmc.d);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Agmp.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Agmp.a.setText(ajeu.a(this.jdField_a_of_type_Agmp.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Agmp.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agmb
 * JD-Core Version:    0.7.0.1
 */