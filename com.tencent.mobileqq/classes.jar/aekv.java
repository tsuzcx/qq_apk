import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class aekv
  extends aekr
{
  agvx a;
  
  public aekv(QQAppInterface paramQQAppInterface, aelj paramaelj, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, acvf paramacvf)
  {
    super(paramQQAppInterface, paramaelj, paramQQWalletTransferMsgElem, paramInt, paramacvf);
    this.jdField_a_of_type_Agvx = ((agvx)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agvx.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Aelj.b.setVisibility(0);
    this.jdField_a_of_type_Aelj.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aelj.b.setText(aekw.d);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aelj.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Aelj.a.setText(ahiw.a(this.jdField_a_of_type_Aelj.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Aelj.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aekv
 * JD-Core Version:    0.7.0.1
 */