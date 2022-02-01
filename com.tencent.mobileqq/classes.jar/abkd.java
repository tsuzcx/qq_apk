import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class abkd
  extends abjn
{
  int jdField_a_of_type_Int;
  abjt jdField_a_of_type_Abjt;
  Activity jdField_a_of_type_AndroidAppActivity;
  protected View a;
  protected AnimationView a;
  View b;
  View c;
  
  public abkd(Activity paramActivity, abjt paramabjt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Abjt = paramabjt;
    this.jdField_a_of_type_Int = paramActivity.getResources().getDisplayMetrics().densityDpi;
  }
  
  private Drawable a(Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, abkf paramabkf, boolean paramBoolean)
  {
    if (paramabkf == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = paramabkf.c();
      paramRect1 = paramabkf.b();
    } while ((paramRect1 == null) || (localDrawable == null) || (!paramabkf.a(paramBoolean)));
    int i = this.jdField_a_of_type_AndroidViewView.getWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getHeight();
    int k = localDrawable.getIntrinsicWidth();
    int m = localDrawable.getIntrinsicHeight();
    paramRect2.set(0, 0, k, m);
    paramRect3.set(paramRect1);
    if ((paramabkf instanceof aidw)) {}
    for (paramRect2 = ((aidw)paramabkf).a;; paramRect2 = null)
    {
      if ((!VersionUtils.isHoneycomb()) && ((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable))) {}
      for (paramRect1 = abke.a(k, m, i, j, false, paramRect2);; paramRect1 = null)
      {
        if (paramRect1 == null) {
          paramRect1 = abke.a(k, m, i, j, paramRect2);
        }
        for (;;)
        {
          paramRect4.set(paramRect1);
          return localDrawable;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131367342);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView = ((AnimationView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131362694));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131376925);
    this.c = this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363243);
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    abkf localabkf = this.jdField_a_of_type_Abjt.a();
    if (localabkf == null) {
      return false;
    }
    Rect localRect3 = localabkf.a();
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(null, localRect4, localRect1, localRect2, localabkf, true);
    this.jdField_a_of_type_Boolean = true;
    if (localDrawable != null)
    {
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label126;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label126:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localabkf.c;
      if (localRect3 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect1, localRect2, localabkf.a(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect3, localRect4, localRect1, localRect2, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public boolean c()
  {
    if (a()) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      b();
    }
    Rect localRect2 = new Rect();
    Rect localRect3 = new Rect();
    abkf localabkf = this.jdField_a_of_type_Abjt.a();
    Rect localRect1 = null;
    if (localabkf != null) {
      localRect1 = localabkf.a();
    }
    Rect localRect4 = new Rect();
    Drawable localDrawable = a(localRect1, localRect4, localRect2, localRect3, localabkf, false);
    this.jdField_a_of_type_Boolean = true;
    boolean bool;
    if (localDrawable != null)
    {
      bool = true;
      this.jdField_b_of_type_Boolean = bool;
      if (this.jdField_b_of_type_Boolean) {
        break label127;
      }
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    }
    for (;;)
    {
      return this.jdField_b_of_type_Boolean;
      bool = false;
      break;
      label127:
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(0);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setAnimationListener(this);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.jdField_a_of_type_Boolean = localabkf.c;
      this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localabkf.a(), localabkf.c(), localabkf.d(), this.jdField_a_of_type_Long);
      if (localRect1 == null) {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.a(localDrawable, localRect2, localRect3, localabkf.a(), localabkf.c(), localabkf.d(), this.jdField_a_of_type_Long);
      } else {
        this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.b(localDrawable, localRect1, localRect4, localRect2, localRect3, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((abkc)localIterator.next()).f();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((abkc)localIterator.next()).g();
    }
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((abkc)localIterator.next()).h();
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonGalleryactivityAnimationView.setVisibility(4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((abkc)localIterator.next()).i();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     abkd
 * JD-Core Version:    0.7.0.1
 */