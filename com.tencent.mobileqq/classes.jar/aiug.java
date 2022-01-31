import Wallet.SkinInfo;
import android.widget.EditText;
import com.tencent.mobileqq.activity.qwallet.SendHbActivity;
import com.tencent.mobileqq.activity.qwallet.fragment.UsualHbFragment;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;

public class aiug
  implements aiuz
{
  public aiug(UsualHbFragment paramUsualHbFragment) {}
  
  public void a(aiup paramaiup)
  {
    if ((paramaiup.jdField_a_of_type_WalletSkinInfo.skin_id == 0) || (paramaiup.jdField_a_of_type_WalletSkinInfo.skin_id == -2))
    {
      paramaiup = aiuo.a(this.a.channel, this.a.a, this.a.mActivity.a(), paramaiup.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title);
      this.a.c.setHint(paramaiup);
      return;
    }
    this.a.c.setHint(paramaiup.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketRedPacketInfoBase.title);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiug
 * JD-Core Version:    0.7.0.1
 */