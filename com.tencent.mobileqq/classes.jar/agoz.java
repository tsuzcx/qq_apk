import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class agoz
  extends BaseAdapter
  implements agpe
{
  int jdField_a_of_type_Int = -1;
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  public agoz(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList.size()) && (paramInt >= 0)) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoPreviewActivity", 2, "wywy getCount =" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList.size());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_JavaUtilArrayList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, " getView position=" + paramInt);
    }
    if (paramView != null) {}
    Object localObject2;
    int i;
    Object localObject4;
    Object localObject1;
    label233:
    label252:
    do
    {
      return paramView;
      localObject2 = a(paramInt);
      View localView;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a((String)localObject2) == 1)
      {
        i = 1;
        localObject4 = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        if (i == 0) {
          break label233;
        }
        localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.getLayoutInflater().inflate(2131560955, null);
        localView.setTag(2131296400, Boolean.valueOf(true));
        localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        localObject1 = (ImageView)localView.findViewById(2131371919);
      }
      for (;;)
      {
        Object localObject5 = new File((String)localObject2);
        localObject5 = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, (File)localObject5);
        if ((localObject4 == null) || (((URLDrawable)localObject4).getStatus() != 1) || (!((URLDrawable)localObject4).getURL().equals(localObject5))) {
          break label252;
        }
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject4);
        if (i == 0) {
          break label799;
        }
        ((ImageView)localObject1).setContentDescription(ajyc.a(2131708137) + paramInt);
        return localView;
        i = 0;
        break;
        localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
        localView = null;
      }
    } while (localObject2 == null);
    paramView = new File((String)localObject2);
    if (paramView.exists()) {
      if ((!"FromCamera".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.e)) && (!"FromFastImage".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.e))) {}
    }
    for (;;)
    {
      try
      {
        paramViewGroup = aywk.a;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.i != 103) {
          break label830;
        }
        localObject2 = BaseApplicationImpl.sImageCache.get((String)localObject2 + "#short_video_camera_preview_cache");
        if (!Bitmap.class.isInstance(localObject2)) {
          break label830;
        }
        paramViewGroup = (Bitmap)localObject2;
        localObject2 = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.getResources(), paramViewGroup);
        if (!QLog.isColorLevel()) {
          break label836;
        }
        QLog.d("PhotoPreviewActivity", 2, "shortVideo preview cache");
      }
      catch (Exception paramViewGroup)
      {
        paramView = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PhotoPreviewActivity", 2, paramViewGroup.getMessage());
        paramView = localObject3;
        continue;
      }
      localObject4 = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, paramView);
      paramView = localObject3;
      if (localObject4 != null) {
        paramView = URLDrawable.getDrawable((URL)localObject4, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.g, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.h, paramViewGroup, (Drawable)localObject2, true);
      }
      if (paramView != null)
      {
        ((ImageView)localObject1).setImageDrawable(paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        break;
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.E))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.b((String)localObject2);
          int k = paramViewGroup.getWidth();
          int j = paramViewGroup.getHeight();
          if (paramView.mediaWidth > paramView.mediaHeight)
          {
            k = paramViewGroup.getHeight();
            j = paramViewGroup.getWidth();
          }
          paramViewGroup = bbbj.a(paramView, "FLOW_THUMB");
          if (paramViewGroup != null)
          {
            ((ImageView)localObject1).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a(paramViewGroup.toString(), k, j, paramView));
            paramView = localObject3;
            continue;
          }
          QLog.d("PhotoPreviewActivity", 2, "url  is null ");
          paramView = localObject3;
          continue;
        }
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aywk.a;
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        paramViewGroup = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, paramView);
        paramView = localObject3;
        if (paramViewGroup == null) {
          continue;
        }
        paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject2);
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          continue;
        }
        paramView = paramViewGroup;
        switch (paramViewGroup.getStatus())
        {
        }
        paramViewGroup.setTag(Integer.valueOf(1));
        paramViewGroup.startDownload();
        paramView = paramViewGroup;
        continue;
      }
      break;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.M) || (!PhotoPreviewActivity.a((String)localObject2))) {
        break;
      }
      paramView = URLDrawable.URLDrawableOptions.obtain();
      paramView.mRequestWidth = paramViewGroup.getWidth();
      paramView.mRequestHeight = paramViewGroup.getHeight();
      paramView.mLoadingDrawable = aywk.a;
      paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl((String)localObject2), paramView);
      if (paramView == null) {
        QLog.w("PEAK", 2, "drawable == null");
      }
      ((ImageView)localObject1).setImageDrawable(paramView);
      break;
      label799:
      ((ImageView)localObject1).setContentDescription(ajyc.a(2131708135) + paramInt);
      return localObject1;
      label830:
      localObject2 = null;
      continue;
      label836:
      paramViewGroup = (ViewGroup)localObject2;
    }
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, a());
      }
      do
      {
        do
        {
          return null;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.E) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a(a(paramInt)) == 1));
        paramView = a(paramInt);
        if (!TextUtils.isEmpty(paramView)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PhotoPreviewActivity", 2, "Path is empty. position " + paramInt + ", size " + getCount());
      return null;
      File localFile = new File(paramView);
      if (localFile.exists())
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = paramViewGroup.getWidth();
        paramView.mRequestHeight = paramViewGroup.getHeight();
        paramView.mLoadingDrawable = aywk.a;
        paramView.mPlayGifImage = true;
        paramViewGroup = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, localFile);
        if (paramViewGroup != null)
        {
          paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        }
      }
    }
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, a());
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = (AbstractImageAdapter.URLImageView2)paramView;
          paramViewGroup = paramView.getDrawable();
          localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
        } while ((!(paramViewGroup instanceof URLDrawable)) || (!((URLDrawable)paramViewGroup).isFakeSize()) || (localObject != null));
        paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
      } while ((!"file".equals(paramViewGroup.getProtocol())) || (paramViewGroup.getRef() != null));
      if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
        break;
      }
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
    } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null));
    QLog.d("PEAK", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("PEAK", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "create rawDrawable, position:" + paramInt);
    }
    if (paramViewGroup.getStatus() == 1)
    {
      paramView.jdField_a_of_type_Boolean = true;
      paramView.setImageDrawable(paramViewGroup);
      paramView.jdField_a_of_type_Boolean = false;
      return;
    }
    paramView.setDecodingDrawble(paramViewGroup);
    paramViewGroup.startDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agoz
 * JD-Core Version:    0.7.0.1
 */