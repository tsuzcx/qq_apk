import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class aksg
  extends Handler
{
  public aksg(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.b()) {
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "handleMessage:getActivity() == null || getActivity().isFinishing()");
      }
    }
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("RedPacketKuaKuaFragment", 2, "handleMessage() returned:输入完成");
      }
    } while (NetConnInfoCenter.getServerTime() - RedPacketKuaKuaFragment.b(this.a) < RedPacketKuaKuaFragment.c(this.a));
    if (TextUtils.isEmpty(RedPacketKuaKuaFragment.a(this.a).getText().toString()))
    {
      this.a.a(anvx.a(2131705449));
      return;
    }
    bmhg.a(this.a.getActivity().app, "tenpay.com", new aksh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aksg
 * JD-Core Version:    0.7.0.1
 */