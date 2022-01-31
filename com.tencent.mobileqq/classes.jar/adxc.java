import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class adxc
  extends AsyncTask<Void, Void, Boolean>
{
  adxc(File paramFile1, File paramFile2, Activity paramActivity, adxe paramadxe) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    try
    {
      if (ew.a(this.jdField_a_of_type_JavaIoFile, this.b))
      {
        bacm.a(this.jdField_a_of_type_AndroidAppActivity, this.b.getAbsolutePath());
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryUtils", 2, "savePhoto  OOM ");
      }
    }
    return Boolean.valueOf(false);
  }
  
  protected void a(Boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {}
    for (int i = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();; i = 0)
    {
      if (paramBoolean.booleanValue()) {}
      for (String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131629482);; str = this.jdField_a_of_type_AndroidAppActivity.getString(2131629508))
      {
        bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 2, str, 0).b(i);
        if (this.jdField_a_of_type_Adxe != null) {
          this.jdField_a_of_type_Adxe.a(paramBoolean.booleanValue());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxc
 * JD-Core Version:    0.7.0.1
 */