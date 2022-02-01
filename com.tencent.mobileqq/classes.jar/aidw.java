import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aidw
  extends abkf
{
  public int a;
  public aidx a;
  public AIORichMediaData a;
  public boolean a;
  public int b;
  public Rect b;
  boolean b;
  Rect c;
  public int d;
  public boolean d;
  
  public aidw(AIORichMediaData paramAIORichMediaData)
  {
    this.jdField_b_of_type_Int = -2;
    this.jdField_a_of_type_Aidx = new aidx();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData = paramAIORichMediaData;
    this.jdField_c_of_type_Boolean = true;
  }
  
  private Drawable a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {}
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    do
    {
      File localFile2;
      do
      {
        File localFile1;
        do
        {
          return null;
          localFile1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18);
          localFile2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20);
          localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = beyq.a;
          localURLDrawableOptions.mFailedDrawable = beyq.a;
          if ((localFile1 == null) || (BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18)) == null)) {
            break;
          }
        } while (beyq.a(localFile1.getAbsolutePath()) != 0);
        return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(18), localURLDrawableOptions);
        if ((localFile2 == null) || (BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20)) == null)) {
          break;
        }
      } while (beyq.a(localFile2.getAbsolutePath()) != 0);
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(20), localURLDrawableOptions);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16) == null);
    return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(16), localURLDrawableOptions);
  }
  
  @Deprecated
  public static URLDrawable a(azqr paramazqr)
  {
    return beyq.b(paramazqr, 1);
  }
  
  private Drawable b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData == null) || (!AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData))) {
      return null;
    }
    Object localObject = (AIOFileVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
    File localFile = ((AIOFileVideoData)localObject).a(0);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = beyq.a;
    localURLDrawableOptions.mFailedDrawable = beyq.a;
    if ((localFile != null) && (BaseApplicationImpl.sImageCache.get(((AIOFileVideoData)localObject).a(0)) != null)) {
      return URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
    }
    if (localFile != null)
    {
      localObject = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
      ((URLDrawable)localObject).downloadImediatly();
      return localObject;
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public Rect b()
  {
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return this.jdField_b_of_type_AndroidGraphicsRect;
    }
    return super.b();
  }
  
  public int c()
  {
    return 0;
  }
  
  public Drawable c()
  {
    for (;;)
    {
      try
      {
        if (!AIOImageData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4);
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = beyq.a;
        localURLDrawableOptions.mFailedDrawable = beyq.a;
        if ((localObject1 == null) || (BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2)) == null)) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(2), localURLDrawableOptions);
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        if (!QLog.isColorLevel()) {
          break label397;
        }
        QLog.e("AIOImageInfo", 2, "getAnimationBitmap ", localThrowable);
        return null;
        if (!AIOShortVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        Object localObject2 = (AIOShortVideoData)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData;
        Object localObject3 = ((AIOShortVideoData)localObject2).a(0);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = beyq.a;
        localURLDrawableOptions.mFailedDrawable = beyq.a;
        if ((localObject3 == null) || (BaseApplicationImpl.sImageCache.get(((AIOShortVideoData)localObject2).a(0)) == null)) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
        continue;
        if (localObject3 == null) {
          continue;
        }
        localObject2 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(0), localURLDrawableOptions);
        ((URLDrawable)localObject2).downloadImediatly();
        continue;
        if (!AIOFilePicData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject2 = a();
        continue;
        if (!AIOFileVideoData.class.isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData)) {
          continue;
        }
        localObject2 = b();
        continue;
        return localObject2;
        localObject2 = null;
        continue;
        localObject2 = null;
        continue;
      }
      localObject3 = b();
      if ((localObject1 != null) && ((((Drawable)localObject1).getIntrinsicHeight() * 3 < ((Drawable)localObject1).getIntrinsicWidth()) || (((Drawable)localObject1).getIntrinsicWidth() * 3 < ((Drawable)localObject1).getIntrinsicHeight()))) {
        this.jdField_c_of_type_Boolean = false;
      }
      if ((localObject1 == null) || (localObject3 == null)) {
        break label397;
      }
      this.jdField_d_of_type_Int = a((Rect)localObject3, (Drawable)localObject1);
      if (((Drawable)localObject1).getIntrinsicHeight() == -1) {
        break label397;
      }
      if (((Drawable)localObject1).getIntrinsicWidth() != -1) {
        continue;
      }
      return null;
      if ((localObject3 != null) && (BaseApplicationImpl.sImageCache.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4)) != null))
      {
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(4), localURLDrawableOptions);
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1) == null) {
          continue;
        }
        localObject1 = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichMediaData.a(1), localURLDrawableOptions);
        ((URLDrawable)localObject1).downloadImediatly();
      }
    }
    label397:
    return null;
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aidw
 * JD-Core Version:    0.7.0.1
 */