import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alhj
  implements View.OnClickListener
{
  public alhj(SpecifyGiftView paramSpecifyGiftView, bdyi parambdyi, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).a();
    if (this.jdField_a_of_type_Bdyi != null) {
      this.jdField_a_of_type_Bdyi.a();
    }
    QQAppInterface localQQAppInterface = alil.a();
    if (localQQAppInterface != null)
    {
      bgot localbgot = (bgot)localQQAppInterface.getManager(223);
      if (localbgot != null) {
        localbgot.a(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).frienduin);
      }
    }
    alil.a(localQQAppInterface, "212", "only.animation.close");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alhj
 * JD-Core Version:    0.7.0.1
 */