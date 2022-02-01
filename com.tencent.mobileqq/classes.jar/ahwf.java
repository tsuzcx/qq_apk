import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahwf
  extends ahwb
{
  aklj a;
  
  public ahwf(QQAppInterface paramQQAppInterface, ahwv paramahwv, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afxp paramafxp)
  {
    super(paramQQAppInterface, paramahwv, paramQQWalletBaseMsgElem, paramInt, paramafxp);
    this.jdField_a_of_type_Aklj = ((aklj)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Aklj.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Ahwv.b.setVisibility(0);
    this.jdField_a_of_type_Ahwv.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahwv.b.setText(ahwg.m);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Ahwv.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Ahwv.a.setText(akww.a(this.jdField_a_of_type_Ahwv.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_Ahwv.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwf
 * JD-Core Version:    0.7.0.1
 */