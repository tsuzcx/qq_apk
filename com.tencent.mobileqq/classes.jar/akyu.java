import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class akyu
  implements TextWatcher
{
  public akyu(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.jdField_c_of_type_Int > 0) {
      this.a.jdField_c_of_type_AndroidWidgetTextView.setText(paramEditable.length() + "/" + this.a.jdField_c_of_type_Int);
    }
    if (paramEditable.length() > 0)
    {
      this.a.a(anzj.a(2131704866));
      RedPacketKuaKuaFragment.a(this.a).removeCallbacks(RedPacketKuaKuaFragment.a(this.a));
      RedPacketKuaKuaFragment.a(this.a).postDelayed(RedPacketKuaKuaFragment.a(this.a), this.a.jdField_a_of_type_Long * 1000L);
      return;
    }
    this.a.a(anzj.a(2131704868));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt3 > paramInt1)) {
      bdll.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.begin", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.elem.title, "", "", "");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyu
 * JD-Core Version:    0.7.0.1
 */