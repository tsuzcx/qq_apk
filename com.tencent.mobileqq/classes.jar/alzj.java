import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity.QQSettingMeListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.RandomCoverView;
import com.tencent.widget.UpSideDownDrawable;

public final class alzj
  implements Runnable
{
  public alzj(BaseActivity paramBaseActivity, Bitmap paramBitmap, RandomCoverView paramRandomCoverView, boolean paramBoolean, FrameHelperActivity.QQSettingMeListener paramQQSettingMeListener, Card paramCard) {}
  
  public void run()
  {
    UpSideDownDrawable localUpSideDownDrawable = new UpSideDownDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.jdField_a_of_type_ComTencentMobileqqWidgetRandomCoverView.a().setImageDrawable(localUpSideDownDrawable);
    if (this.jdField_a_of_type_Boolean) {
      localUpSideDownDrawable.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$QQSettingMeListener.a(this.jdField_a_of_type_ComTencentMobileqqDataCard.strDrawerCardUrl, localUpSideDownDrawable);
      return;
      localUpSideDownDrawable.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alzj
 * JD-Core Version:    0.7.0.1
 */