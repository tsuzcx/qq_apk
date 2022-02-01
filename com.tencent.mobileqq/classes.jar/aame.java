import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class aame
{
  private static ActivityOptions jdField_a_of_type_AndroidAppActivityOptions;
  private static final Property<ImageView, Matrix> jdField_a_of_type_AndroidUtilProperty = new aami(Matrix.class, "animatedTransform");
  private static final AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private int jdField_a_of_type_Int;
  private aamd jdField_a_of_type_Aamd;
  private aaml jdField_a_of_type_Aaml;
  private aamm jdField_a_of_type_Aamm;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private File jdField_a_of_type_JavaIoFile;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private int c;
  private int d;
  
  public aame(Bundle paramBundle, aamm paramaamm)
  {
    if ((paramBundle == null) || (paramaamm == null)) {
      return;
    }
    this.jdField_a_of_type_Aamm = paramaamm;
    a(paramBundle);
    a();
    b();
    c();
    e();
  }
  
  public static Intent a(URLImageView paramURLImageView, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    if (a())
    {
      Bundle localBundle = new Bundle();
      Object localObject = new int[2];
      paramURLImageView.getLocationInWindow((int[])localObject);
      paramURLImageView.getLocationOnScreen((int[])localObject);
      localBundle.putParcelable("bundle_key_trans_anim_rect", new Rect(localObject[0], localObject[1], localObject[0] + paramURLImageView.getWidth(), localObject[1] + paramURLImageView.getHeight()));
      for (;;)
      {
        try
        {
          localObject = ((URLDrawable)paramURLImageView.getDrawable()).getFileInLocal().getPath();
          String str = ((URLDrawable)paramURLImageView.getDrawable()).getURL().toString();
          if (jdField_a_of_type_JavaUtilMap == null) {
            jdField_a_of_type_JavaUtilMap = new HashMap();
          }
          jdField_a_of_type_JavaUtilMap.clear();
          jdField_a_of_type_JavaUtilMap.put(str, localObject);
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            break;
          }
          if (Build.VERSION.SDK_INT >= 16)
          {
            jdField_a_of_type_AndroidAppActivityOptions = ActivityOptions.makeScaleUpAnimation(paramURLImageView, 0, 0, paramURLImageView.getWidth(), paramURLImageView.getHeight());
            localBundle.putString("bundle_key_source_image_param", new aaml((String)localObject, paramInt1, paramInt2).a());
            localBundle.putSerializable("bundle_key_image_scale_type", paramURLImageView.getScaleType());
            localIntent.putExtra("bundle_key_parms_extra", localBundle);
            return localIntent;
          }
        }
        catch (Exception paramURLImageView)
        {
          paramURLImageView.printStackTrace();
          QLog.e("TransitionAnimHelper", 1, "generatePrams getImagePath error!" + paramURLImageView.toString());
          return localIntent;
        }
        jdField_a_of_type_AndroidAppActivityOptions = null;
      }
    }
    jdField_a_of_type_AndroidAppActivityOptions = null;
    return localIntent;
  }
  
  public static Matrix a(ImageView paramImageView)
  {
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, imageView " + paramImageView);
    int i = paramImageView.getLeft();
    int j = paramImageView.getTop();
    int k = paramImageView.getRight();
    int m = paramImageView.getBottom();
    Rect localRect = new Rect(i, j, k, m);
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, left" + i + ",top:" + j + ",right:" + k + ",bottom:" + m);
    Drawable localDrawable = paramImageView.getDrawable();
    ImageView.ScaleType localScaleType = paramImageView.getScaleType();
    QLog.d("TransitionAnimHelper", 4, "getImageMatrix, scaleType " + localScaleType);
    if (localScaleType == ImageView.ScaleType.FIT_XY)
    {
      paramImageView = paramImageView.getImageMatrix();
      if (!paramImageView.isIdentity()) {
        return new Matrix(paramImageView);
      }
      i = localDrawable.getIntrinsicWidth();
      j = localDrawable.getIntrinsicHeight();
      if ((i > 0) && (j > 0))
      {
        float f1 = localRect.width() / i;
        float f2 = localRect.height() / j;
        paramImageView = new Matrix();
        paramImageView.setScale(f1, f2);
        return paramImageView;
      }
      return null;
    }
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  @RequiresApi(api=16)
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    if (jdField_a_of_type_AndroidAppActivityOptions != null)
    {
      localBundle = jdField_a_of_type_AndroidAppActivityOptions.toBundle();
      jdField_a_of_type_AndroidAppActivityOptions = null;
    }
    return localBundle;
  }
  
  public static String a(String paramString)
  {
    if ((jdField_a_of_type_JavaUtilMap != null) && (jdField_a_of_type_JavaUtilMap.containsKey(paramString))) {
      return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Aamd != null) {
      this.jdField_a_of_type_Aamd.a(2);
    }
    Object localObject1 = PropertyValuesHolder.ofInt("left", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getLeft(), paramInt1 });
    Object localObject2 = PropertyValuesHolder.ofInt("top", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getTop(), paramInt2 });
    Object localObject3 = PropertyValuesHolder.ofInt("right", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getRight(), paramInt1 + paramInt3 });
    PropertyValuesHolder localPropertyValuesHolder = PropertyValuesHolder.ofInt("bottom", new int[] { this.jdField_a_of_type_AndroidWidgetImageView.getBottom(), paramInt2 + paramInt4 });
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(this.jdField_a_of_type_AndroidWidgetImageView, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localPropertyValuesHolder });
    ((ObjectAnimator)localObject1).addListener(new aamg(this, paramInt4, paramInt3, paramInt1, paramInt2));
    localObject2 = a(this.jdField_a_of_type_AndroidWidgetImageView);
    localObject3 = a(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.MATRIX);
    localObject2 = ObjectAnimator.ofObject(this.jdField_a_of_type_AndroidWidgetImageView, jdField_a_of_type_AndroidUtilProperty, new aamj(), new Matrix[] { localObject2, localObject3 });
    localObject3 = ObjectAnimator.ofInt(this.jdField_a_of_type_AndroidViewView, "backgroundColor", new int[] { -1, 16777215 });
    ((ValueAnimator)localObject3).setEvaluator(new ArgbEvaluator());
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.setInterpolator(jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new aamh(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject1, localObject2, localObject3 });
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Aamd = new aamd();
    this.jdField_a_of_type_AndroidGraphicsRect = ((Rect)paramBundle.getParcelable("bundle_key_trans_anim_rect"));
    String str = paramBundle.getString("bundle_key_source_image_param");
    this.jdField_a_of_type_Aaml = new aaml();
    this.jdField_a_of_type_Aaml.a(str);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Aaml.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_Aaml.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Aaml.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ((ImageView.ScaleType)paramBundle.getSerializable("bundle_key_image_scale_type"));
    d();
    if (!b()) {
      this.jdField_a_of_type_Aamd.a();
    }
  }
  
  public static boolean a()
  {
    return QzoneConfig.getInstance().getConfig("qqsubscribe", "secondaryEnableJumpDetailTransanimate", 1) > 0;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.containsKey("bundle_key_trans_anim_rect");
    }
    return false;
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {}
    while (this.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.width = this.jdField_a_of_type_AndroidGraphicsRect.width();
    localLayoutParams.height = this.jdField_a_of_type_AndroidGraphicsRect.height();
    localLayoutParams.setMargins(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top, 0, 0);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {}
    while ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaIoFile.isFile()) || (!this.jdField_a_of_type_JavaIoFile.exists()) || (this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == null) || (this.c == 0) || (this.d == 0)) {
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Aamd != null) && (this.jdField_a_of_type_Aamd.a())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidWidgetFrameLayout.getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.c, this.d);
      localLayoutParams.gravity = 1;
      localLayoutParams.topMargin = this.jdField_a_of_type_Aamm.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(this.jdField_a_of_type_AndroidWidgetImageView$ScaleType);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageURI(Uri.fromFile(this.jdField_a_of_type_JavaIoFile));
    this.jdField_a_of_type_Aamd.a(1);
  }
  
  private void d()
  {
    int[] arrayOfInt = this.jdField_a_of_type_Aamm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    if ((arrayOfInt != null) && (arrayOfInt.length == 2))
    {
      this.c = arrayOfInt[0];
      this.d = arrayOfInt[1];
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Aamd == null) || (!this.jdField_a_of_type_Aamd.b())) {
      QLog.d("TransitionAnimHelper", 1, "initImageEnterAnimation error!");
    }
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnPreDrawListener(new aamf(this));
  }
  
  public FrameLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a(aamn paramaamn)
  {
    if (this.jdField_a_of_type_Aamd != null) {
      this.jdField_a_of_type_Aamd.a(paramaamn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aame
 * JD-Core Version:    0.7.0.1
 */