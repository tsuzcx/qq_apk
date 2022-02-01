import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alav
  implements View.OnClickListener
{
  public alav(SpecifyGiftView paramSpecifyGiftView, bdyy parambdyy, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).a();
    if (this.jdField_a_of_type_Bdyy != null) {
      this.jdField_a_of_type_Bdyy.a();
    }
    QQAppInterface localQQAppInterface = albw.a();
    if (localQQAppInterface != null)
    {
      bggl localbggl = (bggl)localQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localbggl != null) {
        localbggl.a(SpecifyGiftView.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView).frienduin);
      }
    }
    albw.a(localQQAppInterface, "212", "only.animation.close");
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alav
 * JD-Core Version:    0.7.0.1
 */