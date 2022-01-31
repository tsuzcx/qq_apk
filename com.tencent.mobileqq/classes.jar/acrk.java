import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;

public class acrk
  extends RecyclerView.ViewHolder
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  public acrk(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362724));
  }
  
  public void a(acrk paramacrk, acrq paramacrq)
  {
    paramacrk.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).getHeight();
    paramacrq = URLDrawable.URLDrawableOptions.obtain();
    paramacrq.mLoadingDrawable = URLDrawableHelper.a;
    paramacrq.mFailedDrawable = URLDrawableHelper.a;
    paramacrq = ExtendFriendResourceUtil.a("expand_square_blank.png");
    if (new File(paramacrq).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramacrq = ExtendFriendResourceUtil.a(paramacrq, localOptions);
      paramacrk.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramacrq));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrk
 * JD-Core Version:    0.7.0.1
 */