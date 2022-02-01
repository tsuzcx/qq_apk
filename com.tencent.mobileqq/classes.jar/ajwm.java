import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletBaseMsgElem;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;

public class ajwm
  implements TextWatcher
{
  public ajwm(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (RedPacketKuaKuaFragment.a(this.a) > 0) {
      RedPacketKuaKuaFragment.a(this.a).setText(paramEditable.length() + "/" + RedPacketKuaKuaFragment.a(this.a));
    }
    if (paramEditable.toString().trim().length() > 0)
    {
      this.a.a(amtj.a(2131705096));
      RedPacketKuaKuaFragment.a(this.a).removeCallbacks(RedPacketKuaKuaFragment.a(this.a));
      RedPacketKuaKuaFragment.a(this.a).postDelayed(RedPacketKuaKuaFragment.a(this.a), RedPacketKuaKuaFragment.a(this.a) * 1000L);
      return;
    }
    this.a.a(amtj.a(2131705098));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt3 > paramInt1)) {
      bcef.b(null, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "kuakua.get.begin", 0, 0, RedPacketKuaKuaFragment.a(this.a).mQQWalletRedPacketMsg.elem.title, "", "", "");
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwm
 * JD-Core Version:    0.7.0.1
 */