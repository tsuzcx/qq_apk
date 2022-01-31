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
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class aimh
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private NewPhotoPreviewActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public aimh(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity = paramNewPhotoPreviewActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDrawable(2130847294);
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
    aimi localaimi;
    Object localObject;
    String str;
    LocalMediaInfo localLocalMediaInfo;
    if (paramView == null)
    {
      localaimi = new aimi(this);
      localObject = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localaimi.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localaimi.jdField_a_of_type_ComTencentImageURLImageView.setPadding(aekt.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      ((RelativeLayout)localObject).addView(localaimi.jdField_a_of_type_ComTencentImageURLImageView, aekt.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localaimi.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localaimi.jdField_a_of_type_AndroidWidgetImageView.setPadding(aekt.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      localaimi.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841168);
      ((RelativeLayout)localObject).addView(localaimi.jdField_a_of_type_AndroidWidgetImageView, aekt.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localaimi.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localaimi.b.setImageResource(2130839177);
      localaimi.b.setPadding(aekt.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, aekt.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView = new RelativeLayout.LayoutParams(aekt.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), aekt.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView.addRule(12);
      paramView.addRule(9);
      localaimi.b.setLayoutParams(paramView);
      localaimi.b.setVisibility(4);
      ((RelativeLayout)localObject).addView(localaimi.b);
      ((View)localObject).setTag(localaimi);
      str = (String)getItem(paramInt);
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getMediaInfoTemp(str);
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.thumbWidth = aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      localLocalMediaInfo.thumbHeight = aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.gallery.getSelectedItem();
      if (paramView != null)
      {
        paramViewGroup = localaimi.jdField_a_of_type_AndroidWidgetImageView;
        if (!paramView.equals(str)) {
          break label489;
        }
        paramInt = 0;
        label427:
        paramViewGroup.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getMediaType(str) != 1) {
        break label507;
      }
      if (!localLocalMediaInfo.isSystemMeidaStore) {
        break label494;
      }
      paramView = a(localLocalMediaInfo, "VIDEO");
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramView == null) && (paramInt == 0))
      {
        return localObject;
        localaimi = (aimi)paramView.getTag();
        localObject = paramView;
        break;
        label489:
        paramInt = 4;
        break label427;
        label494:
        paramView = a(localLocalMediaInfo, "APP_VIDEO");
        paramInt = 0;
        continue;
        label507:
        if (new File(str).exists())
        {
          paramView = a(localLocalMediaInfo, "DEFAULT");
          paramInt = 0;
          continue;
        }
        if (!bdar.isNetUrl(str)) {
          break label723;
        }
        paramInt = 1;
        paramView = null;
        continue;
      }
      URLDrawable localURLDrawable = localaimi.jdField_a_of_type_ComTencentImageURLDrawable;
      paramViewGroup = null;
      if (paramInt != 0)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
        paramView.mRequestHeight = aekt.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
        paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      for (paramViewGroup = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), paramView);; paramViewGroup = baul.a(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        do
        {
          if (paramViewGroup != null)
          {
            paramViewGroup.setTag(localLocalMediaInfo);
            localaimi.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewGroup);
            localaimi.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.mPhotoPreviewData.editPathMap.containsValue(str)) {
            break;
          }
          localaimi.b.setVisibility(0);
          return localObject;
        } while ((localURLDrawable != null) && (localURLDrawable.getURL().toString().equals(paramView.toString())));
      }
      localaimi.b.setVisibility(4);
      return localObject;
      label723:
      paramView = null;
      paramInt = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.mPhotoPreviewData.paths.indexOf(paramAdapterView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.gallery.setSelection(paramInt);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aimh
 * JD-Core Version:    0.7.0.1
 */