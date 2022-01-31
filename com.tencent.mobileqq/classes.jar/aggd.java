import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class aggd
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private NewPhotoPreviewActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public aggd(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity = paramNewPhotoPreviewActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDrawable(2130846730);
    this.jdField_a_of_type_Boolean = paramNewPhotoPreviewActivity.getIntent().getBooleanExtra("PhotoConst.USE_URL_PATH", false);
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoSelectedThumbAdapter", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    Object localObject1;
    String str;
    LocalMediaInfo localLocalMediaInfo;
    Object localObject2;
    if (paramView == null)
    {
      paramViewGroup = new agge(this);
      localObject1 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setPadding(aciy.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      ((RelativeLayout)localObject1).addView(paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView, aciy.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setPadding(aciy.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840975);
      ((RelativeLayout)localObject1).addView(paramViewGroup.jdField_a_of_type_AndroidWidgetImageView, aciy.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      ((View)localObject1).setTag(paramViewGroup);
      str = (String)getItem(paramInt);
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.a(str);
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.thumbWidth = aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      localLocalMediaInfo.thumbHeight = aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getSelectedItem();
      if (paramView != null)
      {
        localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
        if (!paramView.equals(str)) {
          break label349;
        }
        paramInt = 0;
        label287:
        ((ImageView)localObject2).setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.a(str) != 1) {
        break label367;
      }
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label354;
      }
      paramView = a(localLocalMediaInfo, "VIDEO");
      paramInt = 0;
    }
    for (;;)
    {
      label324:
      if ((paramView == null) && (paramInt == 0)) {}
      for (;;)
      {
        return localObject1;
        paramViewGroup = (agge)paramView.getTag();
        localObject1 = paramView;
        break;
        label349:
        paramInt = 4;
        break label287;
        label354:
        paramView = a(localLocalMediaInfo, "APP_VIDEO");
        paramInt = 0;
        break label324;
        label367:
        if (new File(str).exists())
        {
          paramView = a(localLocalMediaInfo, "DEFAULT");
          paramInt = 0;
          break label324;
        }
        if ((!this.jdField_a_of_type_Boolean) || (!PhotoPreviewActivity.a(str))) {
          break label552;
        }
        paramView = null;
        paramInt = i;
        break label324;
        localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
        if (paramInt != 0)
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mRequestWidth = aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
          paramView.mRequestHeight = aciy.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
          paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), paramView);
        }
        while (paramView != null)
        {
          paramView.setTag(localLocalMediaInfo);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramView);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = paramView;
          return localObject1;
          if ((localObject2 == null) || (!((URLDrawable)localObject2).getURL().toString().equals(paramView.toString()))) {
            paramView = axwd.a(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          } else {
            paramView = null;
          }
        }
      }
      label552:
      paramInt = 0;
      paramView = null;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_Aggs.jdField_a_of_type_JavaUtilArrayList.indexOf(paramAdapterView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aggd
 * JD-Core Version:    0.7.0.1
 */