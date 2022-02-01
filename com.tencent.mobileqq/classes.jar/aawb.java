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

public abstract class aawb
{
  public aavi a;
  public aavk a;
  protected aavo a;
  public aavp a;
  private aawg jdField_a_of_type_Aawg;
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    aawa localaawa = this.jdField_a_of_type_Aavo.a();
    if (localaawa != null) {
      localaawa.thubmRect = this.jdField_a_of_type_Aavp.a();
    }
    this.jdField_a_of_type_Aavk.o();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Aavk.q();
    this.jdField_a_of_type_Aavk.a.setSelectionToNothing();
    QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public aavi a()
  {
    return this.jdField_a_of_type_Aavi;
  }
  
  public aavi a(Activity paramActivity, aavo paramaavo)
  {
    return new aavy(paramActivity, paramaavo);
  }
  
  public aavk a()
  {
    return this.jdField_a_of_type_Aavk;
  }
  
  public abstract aavk a(Activity paramActivity, aavo paramaavo);
  
  public abstract aavo a(Activity paramActivity);
  
  public aavp a()
  {
    return this.jdField_a_of_type_Aavp;
  }
  
  public abstract aavp a(Activity paramActivity, aavo paramaavo);
  
  public aawg a()
  {
    return this.jdField_a_of_type_Aawg;
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
    localAnimationView.setId(2131362714);
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
        if (this.jdField_a_of_type_Aawg != this.jdField_a_of_type_Aavk) {
          break label121;
        }
        if (this.jdField_a_of_type_Aavp != null) {
          break;
        }
        this.jdField_a_of_type_Aavp = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aavo);
      } while (this.jdField_a_of_type_Aavp == null);
      this.jdField_a_of_type_Aavp.a(this);
      this.jdField_a_of_type_Aavp.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Aavp.a(this);
      this.jdField_a_of_type_Aavp.m();
      this.jdField_a_of_type_Aavk.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Aawg = this.jdField_a_of_type_Aavp;
      return;
    } while (this.jdField_a_of_type_Aawg != this.jdField_a_of_type_Aavp);
    this.jdField_a_of_type_Aavk.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Aawg != null) {
      this.jdField_a_of_type_Aawg.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aavo = a(paramActivity);
    this.jdField_a_of_type_Aavi = a(paramActivity, this.jdField_a_of_type_Aavo);
    if (this.jdField_a_of_type_Aavk == null)
    {
      this.jdField_a_of_type_Aavk = a(paramActivity, this.jdField_a_of_type_Aavo);
      this.jdField_a_of_type_Aavk.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Aavk.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Aavk.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Aawg = this.jdField_a_of_type_Aavk;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Aawg != null) {
      this.jdField_a_of_type_Aawg.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Aavk.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    aawa localaawa = this.jdField_a_of_type_Aavo.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aavk.p();
      this.jdField_a_of_type_Aavp.a();
      if (localaawa != null) {
        localaawa.thubmRect = this.jdField_a_of_type_Aavp.a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aavk.b(paramBoolean);
      return;
      this.jdField_a_of_type_Aavk.k();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Aawg != null) {
      return this.jdField_a_of_type_Aawg.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aawg.c();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Aawg == this.jdField_a_of_type_Aavk)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Aawg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Aavi.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Aawg.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Aawg.i_();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Aavk != null) {
      this.jdField_a_of_type_Aavk.j();
    }
    if (this.jdField_a_of_type_Aavp != null) {
      this.jdField_a_of_type_Aavp.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aawb
 * JD-Core Version:    0.7.0.1
 */