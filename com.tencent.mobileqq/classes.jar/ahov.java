import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable;
import com.tencent.mobileqq.activity.aio.item.CustomFrameAnimationDrawable.AnimationEndListener;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;

public class ahov
  implements CustomFrameAnimationDrawable.AnimationEndListener
{
  public ahov(RedBagVideoManager paramRedBagVideoManager, CustomFrameAnimationDrawable paramCustomFrameAnimationDrawable) {}
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager.c > 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    RedBagVideoManager localRedBagVideoManager = this.jdField_a_of_type_ComTencentMobileqqShortvideoRedbagRedBagVideoManager;
    localRedBagVideoManager.c += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahov
 * JD-Core Version:    0.7.0.1
 */