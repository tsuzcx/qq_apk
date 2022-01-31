import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;

public class agst
  implements View.OnClickListener
{
  public agst(SpecifyGiftView paramSpecifyGiftView, axbz paramaxbz, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).a();
    if (this.jdField_a_of_type_Axbz != null) {
      this.jdField_a_of_type_Axbz.a();
    }
    QQAppInterface localQQAppInterface = agwj.a();
    if (localQQAppInterface != null)
    {
      azfo localazfo = (azfo)localQQAppInterface.getManager(223);
      if (localazfo != null) {
        localazfo.a(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).frienduin);
      }
    }
    agwj.a(localQQAppInterface, "212", "only.animation.close");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agst
 * JD-Core Version:    0.7.0.1
 */