import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.gdtad.views.image.GdtDrawableLoader.2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

public class aauk
{
  private int jdField_a_of_type_Int;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private WeakReference<aaum> jdField_a_of_type_JavaLangRefWeakReference;
  private URL jdField_a_of_type_JavaNetURL;
  private boolean jdField_a_of_type_Boolean;
  
  public aauk(String paramString, WeakReference<aaum> paramWeakReference)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_a_of_type_JavaNetURL = new URL(paramString);
        this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
      }
      return;
    }
    catch (MalformedURLException paramWeakReference)
    {
      aase.d("GdtDrawableLoader", "GdtDrawableLoader error " + paramString, paramWeakReference);
    }
  }
  
  private URLDrawable.URLDrawableListener a()
  {
    return new aaul(this);
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getURL() != null)) {
      return this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    }
    if (b()) {
      return this.jdField_a_of_type_JavaNetURL.toString();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
      return;
    }
    aase.b("GdtDrawableLoader", "notify " + paramBoolean + " " + a());
    this.jdField_a_of_type_Boolean = true;
    if (paramBoolean)
    {
      ((aaum)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(this.jdField_a_of_type_ComTencentImageURLDrawable);
      return;
    }
    ((aaum)this.jdField_a_of_type_JavaLangRefWeakReference.get()).b(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
  
  private boolean a()
  {
    if ((!b()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null) || (this.jdField_a_of_type_Int >= 3)) {
      return false;
    }
    aase.b("GdtDrawableLoader", "retry " + a());
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_ComTencentImageURLDrawable.restartDownload();
    return true;
  }
  
  private void b()
  {
    int j = 1;
    if ((!b()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
      aase.b("GdtDrawableLoader", "update error " + a());
    }
    for (;;)
    {
      return;
      int i;
      if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)
      {
        aase.b("GdtDrawableLoader", "drawable status is loading " + a());
        i = j;
        if (!this.jdField_a_of_type_ComTencentImageURLDrawable.isDownloadStarted())
        {
          this.jdField_a_of_type_ComTencentImageURLDrawable.startDownload(true);
          i = j;
        }
      }
      while ((i != 0) && (!this.jdField_a_of_type_Boolean))
      {
        new Handler(Looper.getMainLooper()).postDelayed(new GdtDrawableLoader.2(this), 100L);
        return;
        if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 4)
        {
          aase.b("GdtDrawableLoader", "drawable status is file downloaded " + a());
          i = j;
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 1)
        {
          aase.b("GdtDrawableLoader", "drawable status is successed " + a());
          a(true);
          i = 0;
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 2)
        {
          aase.d("GdtDrawableLoader", "drawable status is failed " + a());
          i = j;
          if (!a())
          {
            a(false);
            i = 0;
          }
        }
        else if (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 3)
        {
          aase.d("GdtDrawableLoader", "drawable status is cancled " + a());
          a(false);
          i = 0;
        }
        else
        {
          aase.d("GdtDrawableLoader", "drawable status is " + this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() + " " + a());
          i = 0;
        }
      }
    }
  }
  
  private boolean b()
  {
    return this.jdField_a_of_type_JavaNetURL != null;
  }
  
  public URLDrawable a()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawable;
  }
  
  public void a()
  {
    if (!b())
    {
      aase.d("GdtDrawableLoader", "load error");
      return;
    }
    aase.b("GdtDrawableLoader", "load " + a());
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mUseMemoryCache = true;
    this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaNetURL, localURLDrawableOptions);
    if (this.jdField_a_of_type_ComTencentImageURLDrawable == null)
    {
      aase.d("GdtDrawableLoader", "load error " + a());
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable.setURLDrawableListener(a());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauk
 * JD-Core Version:    0.7.0.1
 */