import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class agpi
  extends BaseAdapter
{
  private final String jdField_a_of_type_JavaLangString = "VerticalPictureAdapter";
  
  public agpi(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity, Context paramContext)
  {
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.a.setRecyclerListener(new agpj(this));
  }
  
  private void a(agpk paramagpk, int paramInt)
  {
    agph localagph = (agph)getItem(paramInt);
    if (localagph == null)
    {
      QZLog.e("VerticalPictureAdapter", "photoInfo == null");
      return;
    }
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramagpk.a.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -2);
    }
    QZLog.d("VerticalPictureAdapter", 1, new Object[] { "photoInfo.heightWeightProportion:", Float.valueOf(localagph.jdField_a_of_type_Float) });
    if (localagph.jdField_a_of_type_Float != 0.0F)
    {
      float f = bbkx.a();
      localLayoutParams1.height = ((int)(localagph.jdField_a_of_type_Float * f));
    }
    paramagpk.a.setLayoutParams(localLayoutParams1);
    paramagpk.a.setImageDrawable(null);
  }
  
  private void b(agpk paramagpk, int paramInt)
  {
    Object localObject = (agph)getItem(paramInt);
    if ((localObject == null) || (TextUtils.isEmpty(((agph)localObject).jdField_a_of_type_JavaLangString))) {
      QZLog.e("VerticalPictureAdapter", "loadImageData: bigUrl is empty");
    }
    for (;;)
    {
      return;
      File localFile = new File(((agph)localObject).jdField_a_of_type_JavaLangString);
      if (localFile.exists())
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mRequestWidth = bbkx.a();
        float f = bbkx.a();
        localURLDrawableOptions.mRequestHeight = ((int)(((agph)localObject).jdField_a_of_type_Float * f));
        localURLDrawableOptions.mLoadingDrawable = aywk.a;
        try
        {
          localObject = localFile.toURI().toURL();
          if (localObject != null)
          {
            localObject = URLDrawable.getDrawable((URL)localObject, localURLDrawableOptions);
            if (localObject != null) {
              switch (((URLDrawable)localObject).getStatus())
              {
              default: 
                ((URLDrawable)localObject).startDownload();
              }
            }
            if (localObject != null)
            {
              paramagpk.a.setImageDrawable((Drawable)localObject);
              return;
            }
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localMalformedURLException.printStackTrace();
            localURLDrawable = null;
          }
        }
      }
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = bbkx.a();
    localURLDrawableOptions.mRequestHeight = ((int)(bbkx.a() * localURLDrawable.jdField_a_of_type_Float));
    localURLDrawableOptions.mLoadingDrawable = aywk.a;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(localURLDrawable.jdField_a_of_type_JavaLangString), localURLDrawableOptions);
    if (localURLDrawable == null) {
      QLog.w("PEAK", 2, "drawable == null");
    }
    paramagpk.a.setImageDrawable(localURLDrawable);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VerticalPictureAdapter", 2, "wywy getCount =" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size());
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.size()) && (paramInt >= 0)) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoQzonePhotoPreviewActivity.b.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    agpk localagpk = new agpk(this, null);
    if (paramView == null)
    {
      localagpk.a = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
      localagpk.a.setTag(localagpk);
    }
    for (paramView = localagpk;; paramView = (agpk)paramView.getTag())
    {
      a(paramView, paramInt);
      b(paramView, paramInt);
      return paramView.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agpi
 * JD-Core Version:    0.7.0.1
 */