import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsgElem;

public class adzy
  extends adzu
{
  agjk a;
  
  public adzy(QQAppInterface paramQQAppInterface, aeam paramaeam, QQWalletTransferMsgElem paramQQWalletTransferMsgElem, int paramInt, ackq paramackq)
  {
    super(paramQQAppInterface, paramaeam, paramQQWalletTransferMsgElem, paramInt, paramackq);
    this.jdField_a_of_type_Agjk = ((agjk)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Agjk.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Aeam.b.setVisibility(0);
    this.jdField_a_of_type_Aeam.b.setTextColor(-8947849);
    this.jdField_a_of_type_Aeam.b.setText(adzz.d);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Aeam.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Aeam.a.setText(agwj.a(this.jdField_a_of_type_Aeam.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletTransferMsgElem.title, 330, this.jdField_a_of_type_Aeam.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzy
 * JD-Core Version:    0.7.0.1
 */