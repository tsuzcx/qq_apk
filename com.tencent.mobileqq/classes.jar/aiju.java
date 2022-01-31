import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.RegionView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class aiju
  extends AsyncTask<Void, Void, Bitmap>
{
  private int jdField_a_of_type_Int;
  
  private aiju(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected Bitmap a(Void... paramVarArgs)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean) {}
      for (paramVarArgs = Bitmap.Config.ARGB_8888;; paramVarArgs = Bitmap.Config.RGB_565)
      {
        localOptions.inPreferredConfig = paramVarArgs;
        localOptions.inJustDecodeBounds = true;
        bdda.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, localOptions);
        localOptions.inSampleSize = ailp.a(localOptions, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.g, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.g);
        localOptions.inJustDecodeBounds = false;
        paramVarArgs = bdda.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString, localOptions);
        return new bauz(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_JavaLangString).a(paramVarArgs);
      }
      return null;
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      this.jdField_a_of_type_Int = 1;
      return null;
    }
    catch (Exception paramVarArgs)
    {
      this.jdField_a_of_type_Int = 2;
      QLog.d("PhotoCropActivity", 1, "LoadBitmapTask err " + paramVarArgs);
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.d);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageBitmap(paramBitmap);
      paramBitmap = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 250L);
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.getIntent().getBooleanExtra("open_chat_from_avator", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setRestrict(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.d);
      paramBitmap = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView = new RegionView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.f, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.h, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoRegionView, paramBitmap);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, alpo.a(2131708444), 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.finish();
      return;
      if (this.jdField_a_of_type_Int == 2) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, alpo.a(2131708445), 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, alpo.a(2131708443), 0).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiju
 * JD-Core Version:    0.7.0.1
 */