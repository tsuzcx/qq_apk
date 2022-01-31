import Wallet.SkinInfo;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;

public class agnw
  implements agok
{
  public agnw(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(agoa paramagoa)
  {
    if ((paramagoa.jdField_a_of_type_WalletSkinInfo.skin_id == 0) || (paramagoa.jdField_a_of_type_WalletSkinInfo.skin_id == -2))
    {
      paramagoa = agnz.a(this.a.channel, this.a.a, this.a.mActivity.a(), paramagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title);
      this.a.c.setHint(paramagoa);
      return;
    }
    this.a.c.setHint(paramagoa.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agnw
 * JD-Core Version:    0.7.0.1
 */