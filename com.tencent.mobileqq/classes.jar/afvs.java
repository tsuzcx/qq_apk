import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;

public class afvs
  extends AsyncTask<String, Void, Boolean>
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  
  public afvs(View paramView)
  {
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
      paramView.setDrawingCacheEnabled(true);
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramView.getDrawingCache();
      ScreenCapture.setSnapFile(localContext, false);
    }
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    Boolean localBoolean = Boolean.FALSE;
    if (isCancelled()) {}
    while ((this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return localBoolean;
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    paramVarArgs = new File(paramVarArgs[0]);
    File localFile = paramVarArgs.getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    try
    {
      paramVarArgs = new FileOutputStream(paramVarArgs);
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramVarArgs);
      paramVarArgs.flush();
      paramVarArgs.close();
      paramVarArgs = Boolean.TRUE;
      return paramVarArgs;
    }
    catch (IOException paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return localBoolean;
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      View localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localView != null)
      {
        if (paramBoolean.booleanValue()) {
          ScreenCapture.setSnapFile(localView.getContext(), true);
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        localView.setDrawingCacheEnabled(false);
        localView.destroyDrawingCache();
      }
    }
  }
  
  protected void onCancelled() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afvs
 * JD-Core Version:    0.7.0.1
 */