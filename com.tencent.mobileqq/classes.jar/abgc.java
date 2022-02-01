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

public abstract class abgc
{
  public abfj a;
  public abfl a;
  protected abfp a;
  public abfq a;
  private abgh jdField_a_of_type_Abgh;
  private Activity jdField_a_of_type_AndroidAppActivity;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public boolean a;
  public boolean b;
  private boolean c;
  
  private void d()
  {
    this.jdField_a_of_type_Abfp.a().a = this.jdField_a_of_type_Abfq.a();
    this.jdField_a_of_type_Abfl.o();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startImageListScene");
    }
    this.jdField_a_of_type_Abfl.q();
    this.jdField_a_of_type_Abfl.a.setSelectionToNothing();
    QQLiveImage.releaseAll(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public abfj a()
  {
    return this.jdField_a_of_type_Abfj;
  }
  
  public abfj a(Activity paramActivity, abfp paramabfp)
  {
    return new abfz(paramActivity, paramabfp);
  }
  
  public abfl a()
  {
    return this.jdField_a_of_type_Abfl;
  }
  
  public abstract abfl a(Activity paramActivity, abfp paramabfp);
  
  public abstract abfp a(Activity paramActivity);
  
  public abfq a()
  {
    return this.jdField_a_of_type_Abfq;
  }
  
  public abstract abfq a(Activity paramActivity, abfp paramabfp);
  
  public abgh a()
  {
    return this.jdField_a_of_type_Abgh;
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
    localAnimationView.setId(2131362678);
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
        if (this.jdField_a_of_type_Abgh != this.jdField_a_of_type_Abfl) {
          break label121;
        }
        if (this.jdField_a_of_type_Abfq != null) {
          break;
        }
        this.jdField_a_of_type_Abfq = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Abfp);
      } while (this.jdField_a_of_type_Abfq == null);
      this.jdField_a_of_type_Abfq.a(this);
      this.jdField_a_of_type_Abfq.a(this.jdField_a_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_Abfq.a(this);
      this.jdField_a_of_type_Abfq.m();
      this.jdField_a_of_type_Abfl.a().post(new GalleryManager.1(this));
      this.jdField_a_of_type_Abgh = this.jdField_a_of_type_Abfq;
      return;
    } while (this.jdField_a_of_type_Abgh != this.jdField_a_of_type_Abfq);
    this.jdField_a_of_type_Abfl.a().post(new GalleryManager.2(this));
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_Abgh != null) {
      this.jdField_a_of_type_Abgh.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Abfp = a(paramActivity);
    this.jdField_a_of_type_Abfj = a(paramActivity, this.jdField_a_of_type_Abfp);
    if (this.jdField_a_of_type_Abfl == null)
    {
      this.jdField_a_of_type_Abfl = a(paramActivity, this.jdField_a_of_type_Abfp);
      this.jdField_a_of_type_Abfl.a(this);
    }
    if (a()) {
      this.jdField_a_of_type_AndroidViewViewGroup = a();
    }
    this.jdField_a_of_type_Abfl.a(this.jdField_a_of_type_AndroidViewViewGroup);
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_Abfl.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(a());
    }
    this.jdField_a_of_type_Abgh = this.jdField_a_of_type_Abfl;
    this.b = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.jdField_a_of_type_AndroidViewViewGroup != null) && (!this.b) && (Build.VERSION.SDK_INT >= 16)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setSystemUiVisibility(4);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (this.jdField_a_of_type_Abgh != null) {
      this.jdField_a_of_type_Abgh.a(paramConfiguration);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Abfl.m();
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "startGalleryScene jumpFromImageList:" + paramBoolean);
    }
    abgb localabgb = this.jdField_a_of_type_Abfp.a();
    if (paramBoolean)
    {
      this.jdField_a_of_type_Abfl.p();
      this.jdField_a_of_type_Abfq.a();
      localabgb.a = this.jdField_a_of_type_Abfq.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Abfl.b(paramBoolean);
      return;
      this.jdField_a_of_type_Abfl.k();
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Abgh != null) {
      return this.jdField_a_of_type_Abgh.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Abgh.c();
  }
  
  public void b(Activity paramActivity)
  {
    if ((!this.c) && (this.jdField_a_of_type_Abgh == this.jdField_a_of_type_Abfl)) {
      a(false);
    }
    this.c = true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Abgh != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GalleryManager", 2, "onBackEvent, isAnimating: " + this.jdField_a_of_type_Abfj.a());
      }
      if ((!a().a()) && (!this.jdField_a_of_type_Abgh.e())) {}
      return true;
    }
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Abgh.h_();
  }
  
  public void c(Activity paramActivity)
  {
    if (this.jdField_a_of_type_Abfl != null) {
      this.jdField_a_of_type_Abfl.j();
    }
    if (this.jdField_a_of_type_Abfq != null) {
      this.jdField_a_of_type_Abfq.j();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abgc
 * JD-Core Version:    0.7.0.1
 */