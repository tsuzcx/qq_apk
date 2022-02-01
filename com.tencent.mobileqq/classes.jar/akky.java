import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.album.preview.PicPreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.PreviewBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;

public class akky
  extends PicPreviewPresent
{
  public akky(PreviewBean paramPreviewBean)
  {
    super(paramPreviewBean);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = this.mBean.getPath();
    paramView = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramViewGroup.getWidth();
    localURLDrawableOptions.mRequestHeight = paramViewGroup.getHeight();
    localURLDrawableOptions.mLoadingDrawable = bdzx.a;
    paramViewGroup = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), localURLDrawableOptions);
    if (paramViewGroup == null) {
      QLog.w("PEAK", 2, "drawable == null");
    }
    paramView.setImageDrawable(paramViewGroup);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akky
 * JD-Core Version:    0.7.0.1
 */