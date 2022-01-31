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

public class acjd
  extends RecyclerView.ViewHolder
{
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  
  public acjd(ExtendFriendSquareFragment paramExtendFriendSquareFragment, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131362719));
  }
  
  public void a(acjd paramacjd, acjj paramacjj)
  {
    paramacjd.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).getHeight();
    paramacjj = URLDrawable.URLDrawableOptions.obtain();
    paramacjj.mLoadingDrawable = URLDrawableHelper.a;
    paramacjj.mFailedDrawable = URLDrawableHelper.a;
    paramacjj = ExtendFriendResourceUtil.a("expand_square_blank.png");
    if (new File(paramacjj).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      paramacjj = ExtendFriendResourceUtil.a(paramacjj, localOptions);
      paramacjd.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new BitmapDrawable(paramacjj));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjd
 * JD-Core Version:    0.7.0.1
 */