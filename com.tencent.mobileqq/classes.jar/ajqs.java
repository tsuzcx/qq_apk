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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.photo.DragGallery;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewBaseData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ajqs
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private NewPhotoPreviewActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ajqs(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity = paramNewPhotoPreviewActivity;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDrawable(2130847755);
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
    ajqt localajqt;
    Object localObject2;
    String str;
    if (paramView == null)
    {
      localajqt = new ajqt(this);
      localObject2 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localajqt.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localajqt.jdField_a_of_type_ComTencentImageURLImageView.setPadding(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      ((RelativeLayout)localObject2).addView(localajqt.jdField_a_of_type_ComTencentImageURLImageView, AIOUtils.dp2px(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localajqt.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localajqt.jdField_a_of_type_AndroidWidgetImageView.setPadding(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, 0);
      localajqt.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841518);
      ((RelativeLayout)localObject2).addView(localajqt.jdField_a_of_type_AndroidWidgetImageView, AIOUtils.dp2px(63.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      localajqt.b = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity);
      localajqt.b.setImageResource(2130839396);
      localajqt.b.setPadding(AIOUtils.dp2px(8.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), 0, 0, AIOUtils.dp2px(1.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView = new RelativeLayout.LayoutParams(AIOUtils.dp2px(26.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()), AIOUtils.dp2px(19.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources()));
      paramView.addRule(12);
      paramView.addRule(9);
      localajqt.b.setLayoutParams(paramView);
      localajqt.b.setVisibility(4);
      ((RelativeLayout)localObject2).addView(localajqt.b);
      ((View)localObject2).setTag(localajqt);
      str = (String)getItem(paramInt);
      if (str != null) {
        break label774;
      }
      str = "";
    }
    label774:
    for (;;)
    {
      LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getMediaInfoTemp(str);
      localLocalMediaInfo.path = str;
      localLocalMediaInfo.thumbWidth = AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      localLocalMediaInfo.thumbHeight = AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
      paramView = (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.gallery.getSelectedItem();
      Object localObject1;
      int i;
      if (paramView != null)
      {
        localObject1 = localajqt.jdField_a_of_type_AndroidWidgetImageView;
        if (paramView.equals(str))
        {
          i = 0;
          label438:
          ((ImageView)localObject1).setVisibility(i);
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getMediaType(str) != 1) {
          break label539;
        }
        if (!localLocalMediaInfo.isSystemMeidaStore) {
          break label525;
        }
        paramView = a(localLocalMediaInfo, "VIDEO");
        i = 0;
      }
      for (;;)
      {
        if ((paramView == null) && (i == 0))
        {
          EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
          return localObject2;
          localajqt = (ajqt)paramView.getTag();
          localObject2 = paramView;
          break;
          i = 4;
          break label438;
          label525:
          paramView = a(localLocalMediaInfo, "APP_VIDEO");
          i = 0;
          continue;
          label539:
          if (new File(str).exists())
          {
            paramView = a(localLocalMediaInfo, "DEFAULT");
            i = 0;
            continue;
          }
          if (!AlbumUtil.isNetUrl(str)) {
            break label766;
          }
          i = 1;
          paramView = null;
          continue;
        }
        URLDrawable localURLDrawable = localajqt.jdField_a_of_type_ComTencentImageURLDrawable;
        localObject1 = null;
        if (i != 0)
        {
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mRequestWidth = AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
          paramView.mRequestHeight = AIOUtils.dp2px(55.0F, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources());
          paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          localObject1 = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(str), paramView);
        }
        label655:
        label764:
        for (;;)
        {
          if (localObject1 != null)
          {
            ((URLDrawable)localObject1).setTag(localLocalMediaInfo);
            localajqt.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
            localajqt.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.mPhotoPreviewData.editPathMap.containsValue(str)) {
            localajqt.b.setVisibility(0);
          }
          for (;;)
          {
            break;
            if ((localURLDrawable != null) && (localURLDrawable.getURL().toString().equals(paramView.toString()))) {
              break label764;
            }
            localObject1 = URLDrawableHelper.getDrawable(paramView, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            break label655;
            localajqt.b.setVisibility(4);
          }
        }
        label766:
        paramView = null;
        i = 0;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.mPhotoPreviewData.paths.indexOf(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.gallery.setSelection(i);
    notifyDataSetChanged();
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajqs
 * JD-Core Version:    0.7.0.1
 */