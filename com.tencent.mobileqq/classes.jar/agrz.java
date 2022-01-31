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
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class agrz
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private NewPhotoPreviewActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public agrz(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity = paramNewPhotoPreviewActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDrawable(2130846920);
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
    agsa localagsa;
    Object localObject;
    String str;
    LocalMediaInfo localLocalMediaInfo;
    if (paramView == null)
    {
      localagsa = new agsa(this);
      localObject = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localagsa.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localagsa.jdField_a_of_type_ComTencentImageURLImageView.setPadding(actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      ((RelativeLayout)localObject).addView(localagsa.jdField_a_of_type_ComTencentImageURLImageView, actn.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localagsa.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localagsa.jdField_a_of_type_AndroidWidgetImageView.setPadding(actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      localagsa.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841052);
      ((RelativeLayout)localObject).addView(localagsa.jdField_a_of_type_AndroidWidgetImageView, actn.a(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localagsa.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localagsa.b.setImageResource(2130839096);
      localagsa.b.setPadding(actn.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, actn.a(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView = new RelativeLayout.LayoutParams(actn.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), actn.a(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView.addRule(12);
      paramView.addRule(9);
      localagsa.b.setLayoutParams(paramView);
      localagsa.b.setVisibility(4);
      ((RelativeLayout)localObject).addView(localagsa.b);
      ((View)localObject).setTag(localagsa);
      str = (String)getItem(paramInt);
      localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.a(str);
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.thumbWidth = actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      localLocalMediaInfo.thumbHeight = actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.getSelectedItem();
      if (paramView != null)
      {
        paramViewGroup = localagsa.jdField_a_of_type_AndroidWidgetImageView;
        if (!paramView.equals(str)) {
          break label489;
        }
        paramInt = 0;
        label427:
        paramViewGroup.setVisibility(paramInt);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.a(str) != 1) {
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
        localagsa = (agsa)paramView.getTag();
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
        if (!bbbj.a(str)) {
          break label723;
        }
        paramInt = 1;
        paramView = null;
        continue;
      }
      URLDrawable localURLDrawable = localagsa.jdField_a_of_type_ComTencentImageURLDrawable;
      paramViewGroup = null;
      if (paramInt != 0)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
        paramView.mRequestHeight = actn.a(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
        paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      for (paramViewGroup = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), paramView);; paramViewGroup = aywk.a(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)) {
        do
        {
          if (paramViewGroup != null)
          {
            paramViewGroup.setTag(localLocalMediaInfo);
            localagsa.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramViewGroup);
            localagsa.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilHashMap.containsValue(str)) {
            break;
          }
          localagsa.b.setVisibility(0);
          return localObject;
        } while ((localURLDrawable != null) && (localURLDrawable.getURL().toString().equals(paramView.toString())));
      }
      localagsa.b.setVisibility(4);
      return localObject;
      label723:
      paramView = null;
      paramInt = 0;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_Agsq.jdField_a_of_type_JavaUtilArrayList.indexOf(paramAdapterView);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoDragGallery.setSelection(paramInt);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agrz
 * JD-Core Version:    0.7.0.1
 */