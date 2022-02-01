import android.graphics.Color;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ahcj
  extends ahcf
{
  ajul a;
  
  public ahcj(QQAppInterface paramQQAppInterface, ahcz paramahcz, QQWalletBaseMsgElem paramQQWalletBaseMsgElem, int paramInt, afaf paramafaf)
  {
    super(paramQQAppInterface, paramahcz, paramQQWalletBaseMsgElem, paramInt, paramafaf);
    this.jdField_a_of_type_Ajul = ((ajul)paramQQAppInterface.getManager(125));
    if (a(this.jdField_a_of_type_Ajul.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.redPacketId)))
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
    this.jdField_a_of_type_Ahcz.b.setVisibility(0);
    this.jdField_a_of_type_Ahcz.b.setTextColor(-8947849);
    this.jdField_a_of_type_Ahcz.b.setText(ahck.m);
    return true;
  }
  
  public void f()
  {
    super.f();
    try
    {
      this.jdField_a_of_type_Ahcz.a.setTextColor(Color.parseColor("#604121"));
      this.jdField_a_of_type_Ahcz.a.setText(akgd.a(this.jdField_a_of_type_Ahcz.a.getContext(), this.jdField_a_of_type_ComTencentMobileqqDataQQWalletBaseMsgElem.title, 330, this.jdField_a_of_type_Ahcz.a.getPaint()));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahcj
 * JD-Core Version:    0.7.0.1
 */