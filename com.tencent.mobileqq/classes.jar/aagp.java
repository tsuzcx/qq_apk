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

public abstract class aagp
{
  public aafw a;
  public aafy a;
  protected aagc a;
  public aagd a;
  private aagu jdField_a_of_type_Aagu;
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    aago localaago = this.jdField_a_of_type_Aagc.a();
    if (localaago != null) {
      localaago.thubmRect = this.jdField_a_of_type_Aagd.a();
    }
    this.jdField_a_of_type_Aafy.o();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Aafy.q();
    this.jdField_a_of_type_Aafy.a.setSelectionToNothing();
    QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public aafw a()
  {
    return this.jdField_a_of_type_Aafw;
  }
  
  public aafw a(Activity paramActivity, aagc paramaagc)
  {
    return new aagm(paramActivity, paramaagc);
  }
  
  public aafy a()
  {
    return this.jdField_a_of_type_Aafy;
  }
  
  public abstract aafy a(Activity paramActivity, aagc paramaagc);
  
  public abstract aagc a(Activity paramActivity);
  
  public aagd a()
  {
    return this.jdField_a_of_type_Aagd;
  }
  
  public abstract aagd a(Activity paramActivity, aagc paramaagc);
  
  public aagu a()
  {
    return this.jdField_a_of_type_Aagu;
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
    localAnimationView.setId(2131362699);
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
        if (this.jdField_a_of_type_Aagu != this.jdField_a_of_type_Aafy) {
          break label121;
        }
        if (this.jdField_a_of_type_Aagd != null) {
          break;
        }
        this.jdField_a_of_type_Aagd = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aagc);
      } while (this.jdField_a_of_type_Aagd == null);
      this.jdField_a_of_type_Aagd.a(this);
      this.jdField_a_of_type_Aagd.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Aagd.a(this);
      this.jdField_a_of_type_Aagd.m();
      this.jdField_a_of_type_Aafy.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Aagu = this.jdField_a_of_type_Aagd;
      return;
    } while (this.jdField_a_of_type_Aagu != this.jdField_a_of_type_Aagd);
    this.jdField_a_of_type_Aafy.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aagu != null) {
      this.jdField_a_of_type_Aagu.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aagc = a(paramActivity);
    this.jdField_a_of_type_Aafw = a(paramActivity, this.jdField_a_of_type_Aagc);
    if (this.jdField_a_of_type_Aafy == null)
    {
      this.jdField_a_of_type_Aafy = a(paramActivity, this.jdField_a_of_type_Aagc);
      this.jdField_a_of_type_Aafy.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Aafy.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Aafy.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Aagu = this.jdField_a_of_type_Aafy;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aagu != null) {
      this.jdField_a_of_type_Aagu.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aafy.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    aago localaago = this.jdField_a_of_type_Aagc.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aafy.p();
      this.jdField_a_of_type_Aagd.a();
      if (localaago != null) {
        localaago.thubmRect = this.jdField_a_of_type_Aagd.a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aafy.b(paramBoolean);
      return;
      this.jdField_a_of_type_Aafy.k();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Aagu != null) {
      return this.jdField_a_of_type_Aagu.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aagu.c();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Aagu == this.jdField_a_of_type_Aafy)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aagu != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Aafw.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Aagu.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aagu.h_();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aafy != null) {
      this.jdField_a_of_type_Aafy.j();
    }
    if (this.jdField_a_of_type_Aagd != null) {
      this.jdField_a_of_type_Aagd.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aagp
 * JD-Core Version:    0.7.0.1
 */