import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter;
import com.tencent.qphone.base.util.QLog;

public class acod
  implements URLDrawableDownListener
{
  public acod(FavoriteEmotionAdapter paramFavoriteEmotionAdapter, EmoticonInfo paramEmoticonInfo, URLImageView paramURLImageView1, URLImageView paramURLImageView2) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable)
  {
    QLog.e("FavoriteEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavoriteEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmotionAdapter, this.jdField_a_of_type_ComTencentImageURLImageView, this.b);
  }
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("FavoriteEmotionAdapter", 1, "onLoadFailed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavoriteEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmotionAdapter, this.jdField_a_of_type_ComTencentImageURLImageView, this.b);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException)
  {
    QLog.e("FavoriteEmotionAdapter", 1, "onLoadInterrupted: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    FavoriteEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmotionAdapter, this.jdField_a_of_type_ComTencentImageURLImageView, this.b);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavoriteEmotionAdapter", 2, "onLoadProgressed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    FavoriteEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmotionAdapter, this.jdField_a_of_type_ComTencentImageURLImageView, this.b);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavoriteEmotionAdapter", 2, "onLoadSuccessed: " + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo.toString());
    }
    FavoriteEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFavoriteEmotionAdapter, this.jdField_a_of_type_ComTencentImageURLImageView, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acod
 * JD-Core Version:    0.7.0.1
 */