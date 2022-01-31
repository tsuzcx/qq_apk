import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.LightVideoItemBuilder.ChatVideoView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;

public class aful
  extends aeqi
{
  public ImageView a;
  public TextView a;
  public LightVideoItemBuilder.ChatVideoView a;
  public MessageProgressView a;
  public TextView b;
  
  public aful(LightVideoItemBuilder paramLightVideoItemBuilder) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder.c(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) {
      if (QLog.isColorLevel()) {
        QLog.i("LightVideoItemBuilder", 2, String.format("onScrollOutScreen but not recycle, message:%d is playing", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq) }));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getStatus() != 1) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable() instanceof QQLiveDrawable))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LightVideoItemBuilder", 2, "onScrollOutScreen(): recyleAndKeepPostion ");
    }
    ((QQLiveDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemLightVideoItemBuilder$ChatVideoView.b.getCurrDrawable()).recyleAndKeepPostion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aful
 * JD-Core Version:    0.7.0.1
 */