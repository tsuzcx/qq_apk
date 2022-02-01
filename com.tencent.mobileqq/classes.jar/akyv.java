import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.RedPacketKuaKuaFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

public class akyv
  extends Handler
{
  public akyv(RedPacketKuaKuaFragment paramRedPacketKuaKuaFragment) {}
  
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
    } while (NetConnInfoCenter.getServerTime() - this.a.c < this.a.b);
    if (TextUtils.isEmpty(this.a.a.getText().toString()))
    {
      this.a.a(anzj.a(2131704868));
      return;
    }
    bmrq.a(this.a.getActivity().app, "tenpay.com", new akyw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akyv
 * JD-Core Version:    0.7.0.1
 */