import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.GalleryManager.1;
import com.tencent.common.galleryactivity.GalleryManager.2;
import com.tencent.image.QQLiveImage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import com.tencent.widget.immersive.ImmersiveUtils;

public abstract class abkg
{
  public abjn a;
  public abjp a;
  protected abjt a;
  public abju a;
  private abkl jdField_a_of_type_Abkl;
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Abjt.a().a = this.jdField_a_of_type_Abju.a();
    this.jdField_a_of_type_Abjp.o();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Abjp.q();
    this.jdField_a_of_type_Abjp.a.setSelectionToNothing();
    QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public abjn a()
  {
    return this.jdField_a_of_type_Abjn;
  }
  
  public abjn a(Activity paramActivity, abjt paramabjt)
  {
    return new abkd(paramActivity, paramabjt);
  }
  
  public abjp a()
  {
    return this.jdField_a_of_type_Abjp;
  }
  
  public abstract abjp a(Activity paramActivity, abjt paramabjt);
  
  public abstract abjt a(Activity paramActivity);
  
  public abju a()
  {
    return this.jdField_a_of_type_Abju;
  }
  
  public abstract abju a(Activity paramActivity, abjt paramabjt);
  
  public abkl a()
  {
    return this.jdField_a_of_type_Abkl;
  }
  
  public RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidAppActivity.addContentView(localRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
    return localRelativeLayout;
  }
  
  public AnimationView a()
  {
    AnimationView localAnimationView = new AnimationView(this.jdField_a_of_type_AndroidAppActivity, null);
    localAnimationView.setId(2131362694);
    localAnimationView.setVisibility(4);
    return localAnimationView;
  }
  
  public void a()
  {
    if (!a()) {}
    label121:
    do
    {
      do
      {
        do
        {
          return;
        } while (a().a());
        if (this.jdField_a_of_type_Abkl != this.jdField_a_of_type_Abjp) {
          break label121;
        }
        if (this.jdField_a_of_type_Abju != null) {
          break;
        }
        this.jdField_a_of_type_Abju = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Abjt);
      } while (this.jdField_a_of_type_Abju == null);
      this.jdField_a_of_type_Abju.a(this);
      this.jdField_a_of_type_Abju.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Abju.a(this);
      this.jdField_a_of_type_Abju.m();
      this.jdField_a_of_type_Abjp.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Abkl = this.jdField_a_of_type_Abju;
      return;
    } while (this.jdField_a_of_type_Abkl != this.jdField_a_of_type_Abju);
    this.jdField_a_of_type_Abjp.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Abkl != null) {
      this.jdField_a_of_type_Abkl.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Abjt = a(paramActivity);
    this.jdField_a_of_type_Abjn = a(paramActivity, this.jdField_a_of_type_Abjt);
    if (this.jdField_a_of_type_Abjp == null)
    {
      this.jdField_a_of_type_Abjp = a(paramActivity, this.jdField_a_of_type_Abjt);
      this.jdField_a_of_type_Abjp.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Abjp.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Abjp.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Abkl = this.jdField_a_of_type_Abjp;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Abkl != null) {
      this.jdField_a_of_type_Abkl.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Abjp.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    abkf localabkf = this.jdField_a_of_type_Abjt.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Abjp.p();
      this.jdField_a_of_type_Abju.a();
      localabkf.a = this.jdField_a_of_type_Abju.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Abjp.b(paramBoolean);
      return;
      this.jdField_a_of_type_Abjp.k();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Abkl != null) {
      return this.jdField_a_of_type_Abkl.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Abkl.c();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Abkl == this.jdField_a_of_type_Abjp)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Abkl != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Abjn.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Abkl.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Abkl.h_();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Abjp != null) {
      this.jdField_a_of_type_Abjp.j();
    }
    if (this.jdField_a_of_type_Abju != null) {
      this.jdField_a_of_type_Abju.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abkg
 * JD-Core Version:    0.7.0.1
 */