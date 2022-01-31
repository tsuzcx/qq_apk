import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;

public class aizk
  implements View.OnClickListener
{
  public aizk(SpecifyGiftView paramSpecifyGiftView, baaa parambaaa, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).a();
    if (this.jdField_a_of_type_Baaa != null) {
      this.jdField_a_of_type_Baaa.a();
    }
    QQAppInterface localQQAppInterface = ajaf.a();
    if (localQQAppInterface != null)
    {
      bcfr localbcfr = (bcfr)localQQAppInterface.getManager(223);
      if (localbcfr != null) {
        localbcfr.a(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).frienduin);
      }
    }
    ajaf.a(localQQAppInterface, "212", "only.animation.close");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizk
 * JD-Core Version:    0.7.0.1
 */