import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.1;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.3;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class ambv
  extends acyl
{
  public long a;
  public acuj a;
  public amba a;
  public ambd a;
  private amca jdField_a_of_type_Amca;
  public AnimatorSet a;
  private final Resources jdField_a_of_type_AndroidContentResResources;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public View a;
  public QQAppInterface a;
  public BubbleManager a;
  public String a;
  public ArrayList<amcc> a;
  public ConcurrentHashMap<String, Bitmap> a;
  public boolean a;
  public int b;
  public View b;
  public String b;
  private boolean b;
  public int c;
  public View c;
  public int d;
  public View d;
  public int e;
  public View e;
  public int f;
  public int g;
  public int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n = -1;
  
  public ambv(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_AndroidContentResResources = paramListView.getResources();
    this.jdField_h_of_type_Int = actj.a(12.0F, paramListView.getContext().getResources());
    this.k = actj.a(50.0F, paramListView.getContext().getResources());
    this.l = actj.a(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_e_of_type_Int - this.jdField_d_of_type_Int);
    if (paramFloat == 0.1F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (i1 = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int;; i1 = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int) {
        return i1 - this.i / 2;
      }
    }
    if (paramFloat == 0.9F)
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (paramFloat = this.jdField_d_of_type_Int + this.jdField_h_of_type_Int;; paramFloat = this.jdField_e_of_type_Int - this.jdField_h_of_type_Int)
      {
        i1 = (int)paramFloat;
        break;
      }
    }
    paramFloat = i1 * paramFloat;
    if (this.jdField_a_of_type_Boolean) {}
    for (paramFloat = this.jdField_e_of_type_Int - paramFloat;; paramFloat += this.jdField_d_of_type_Int)
    {
      i1 = (int)paramFloat;
      break;
    }
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        if (!((amcc)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (;;)
      {
        if (i1 != -1)
        {
          paramString = (amcc)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!(paramString instanceof amce)) {
            break label113;
          }
        }
        label113:
        for (paramString = f((amce)paramString);; paramString = null)
        {
          if ((paramAnimator != null) && (paramString != null))
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new ambx(this, paramString));
          }
          return i1;
          i1 += 1;
          break;
        }
        i1 = -1;
      }
    }
    return -1;
  }
  
  private ObjectAnimator a(amce paramamce)
  {
    if (paramamce == null) {
      return null;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Amba.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramamce.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramamce.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      amca localamca = new amca();
      localamca.jdField_b_of_type_JavaLangString = str;
      localamca.jdField_a_of_type_JavaLangString = (paramamce.jdField_a_of_type_JavaLangString + str);
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = paramamce.jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        localamca.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localamca);
        i1 += 1;
        break;
        if (!paramamce.jdField_b_of_type_Boolean) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(amcf paramamcf)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Amba.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramamcf.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramamcf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      amca localamca = new amca();
      localamca.jdField_b_of_type_JavaLangString = str;
      localamca.jdField_a_of_type_JavaLangString = (paramamcf.jdField_a_of_type_JavaLangString + str);
      if (this.jdField_a_of_type_Boolean) {}
      for (boolean bool = false;; bool = true)
      {
        localamca.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localamca);
        i1 += 1;
        break;
      }
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List<amca> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Amca);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("bitmapData", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new amcb(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator a(amce paramamce)
  {
    switch (paramamce.jdField_e_of_type_Int)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new AccelerateInterpolator();
    }
    return new DecelerateInterpolator();
  }
  
  private int b(float paramFloat)
  {
    int i1 = Math.abs(this.jdField_f_of_type_Int - this.jdField_g_of_type_Int);
    if (paramFloat == 0.1F) {
      i1 = this.jdField_f_of_type_Int + this.jdField_h_of_type_Int;
    }
    for (;;)
    {
      return i1 - this.j / 2;
      if (paramFloat == 0.9F)
      {
        i1 = this.jdField_g_of_type_Int - this.jdField_h_of_type_Int;
      }
      else
      {
        float f1 = this.jdField_f_of_type_Int;
        i1 = (int)(i1 * paramFloat + f1);
      }
    }
  }
  
  private ObjectAnimator b(amce paramamce)
  {
    int i2 = a(paramamce.jdField_a_of_type_Float);
    int i3 = b(paramamce.jdField_b_of_type_Float);
    int i4 = a(paramamce.jdField_c_of_type_Float);
    int i5 = b(paramamce.d);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      amcr localamcr = amcr.b(i2, i3);
      localamcr.jdField_c_of_type_Float = (paramamce.jdField_h_of_type_Int * i1);
      localamcr.d = (paramamce.jdField_f_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcr);
      localamcr = amcr.a(i4, i5);
      localamcr.jdField_c_of_type_Float = (i1 * paramamce.i);
      localamcr.d = (paramamce.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcr);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amcs(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamce));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramamce.jdField_a_of_type_Long));
      return localObject;
    }
  }
  
  private ObjectAnimator b(amcf paramamcf)
  {
    ObjectAnimator localObjectAnimator = a(paramamcf);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new ambz(this, paramamcf));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List<amca> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Amca);
    int i1 = 0;
    if (i1 < paramList.size())
    {
      if (i1 != paramList.size() - 1) {
        localObject[(i1 + 1)] = Keyframe.ofObject((i1 + 1) * f1, paramList.get(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        localObject[(i1 + 1)] = Keyframe.ofObject(1.0F, paramList.get(i1));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("pendantBitmap", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new amcb(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private ObjectAnimator c(amce paramamce)
  {
    int i2 = a(paramamce.jdField_a_of_type_Float);
    int i3 = b(paramamce.jdField_b_of_type_Float);
    int i4 = a(paramamce.jdField_c_of_type_Float);
    int i5 = b(paramamce.d);
    int i6 = a(paramamce.jdField_e_of_type_Float);
    int i7 = b(paramamce.jdField_f_of_type_Float);
    int i8 = a(paramamce.jdField_g_of_type_Float);
    int i9 = b(paramamce.jdField_h_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      amcr localamcr = amcr.b(i2, i3);
      localamcr.d = paramamce.jdField_f_of_type_Int;
      localamcr.jdField_c_of_type_Float = (paramamce.jdField_h_of_type_Int * i1);
      ((ArrayList)localObject).add(localamcr);
      localamcr = amcr.a(i6, i7, i8, i9, i4, i5);
      a("play circle points: " + amcr.a(i6, i7, i8, i9, i4, i5).toString());
      localamcr.jdField_c_of_type_Float = (paramamce.i * i1);
      localamcr.d = (paramamce.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcr);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amcs(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamce));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramamce.jdField_a_of_type_Long * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator d(amce paramamce)
  {
    int i3 = a(paramamce.jdField_a_of_type_Float);
    int i4 = b(paramamce.jdField_b_of_type_Float);
    int i2 = a(paramamce.jdField_c_of_type_Float);
    if (i4 != b(paramamce.d)) {
      return null;
    }
    int i1;
    int i5;
    int i6;
    if (i2 > i3)
    {
      i1 = 1;
      i5 = this.k;
      i5 = paramamce.j * i5;
      i6 = Math.abs(i3 - i2);
      i2 = (int)(Math.abs(i3 - i2) * 1.0F / i5 + 0.5F);
      if (i2 != 0) {
        break label558;
      }
      i2 = 1;
    }
    label558:
    for (;;)
    {
      a("playPeriodicalCircleAnim, periodLen: " + i5 + ", period: " + i2 + ", resize periodLen: " + i6 / i2);
      i5 = i6 / i2;
      i6 = (int)(i3 + i5 * paramamce.jdField_e_of_type_Float * i1);
      int i7 = (int)(i4 + i5 * paramamce.jdField_f_of_type_Float);
      int i8 = (int)(i3 + i5 * paramamce.jdField_g_of_type_Float * i1);
      int i9 = (int)(i4 + i5 * paramamce.jdField_h_of_type_Float);
      int i10 = i3 + i5 * i1;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(amcr.b(i3, i4));
      ((ArrayList)localObject).add(amcr.a(i6, i7, i8, i9, i10, i4));
      a("next points: " + amcr.a(i6, i7, i8, i9, i10, i4).toString());
      i3 = 1;
      for (;;)
      {
        if (i3 < i2)
        {
          int i11 = i1 * i3 * i5 + i6;
          int i12 = i1 * i3 * i5 + i8;
          int i13 = i1 * i3 * i5 + i10;
          ((ArrayList)localObject).add(amcr.a(i11, i7, i12, i9, i13, i4));
          a("next points: " + amcr.a(i11, i7, i12, i9, i13, i4).toString());
          i3 += 1;
          continue;
          i1 = -1;
          break;
        }
      }
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amcs(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamce));
      a("duration: " + paramamce.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D);
      ((ObjectAnimator)localObject).setDuration((paramamce.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator e(amce paramamce)
  {
    int i1 = a(paramamce.jdField_a_of_type_Float);
    int i2 = b(paramamce.jdField_b_of_type_Float);
    int i3 = a(paramamce.jdField_c_of_type_Float);
    int i4 = b(paramamce.d);
    if ((i1 == i3) || (i2 == i4)) {
      if (i2 == i4) {
        i1 = 1;
      }
    }
    while (i1 != 0)
    {
      return d(paramamce);
      i1 = 0;
      continue;
      return null;
    }
    return null;
  }
  
  private void e()
  {
    ViewGroup localViewGroup;
    int i1;
    if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i1);
        if ((localView.getId() == 2131364129) && (localView.getVisibility() == 0))
        {
          this.jdField_e_of_type_AndroidViewView = localView;
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          this.jdField_d_of_type_AndroidViewView.layout(0, 0, actj.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), actj.a(59.0F, this.jdField_a_of_type_AndroidContentResResources));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jdField_d_of_type_AndroidViewView);
        }
      }
      else
      {
        return;
      }
      i1 += 1;
    }
  }
  
  private ObjectAnimator f(amce paramamce)
  {
    ObjectAnimator localObjectAnimator1;
    if ((paramamce.jdField_e_of_type_Float == 0.0F) && (paramamce.jdField_f_of_type_Float == 0.0F) && (paramamce.jdField_g_of_type_Float == 0.0F) && (paramamce.jdField_h_of_type_Float == 0.0F)) {
      localObjectAnimator1 = b(paramamce);
    }
    ObjectAnimator localObjectAnimator2;
    for (;;)
    {
      localObjectAnimator2 = a(paramamce);
      if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null)) {
        break;
      }
      return null;
      if (paramamce.jdField_c_of_type_Boolean) {
        localObjectAnimator1 = e(paramamce);
      } else {
        localObjectAnimator1 = c(paramamce);
      }
    }
    int i1;
    if ((paramamce.jdField_a_of_type_Float == paramamce.jdField_c_of_type_Float) && (paramamce.jdField_b_of_type_Float == paramamce.d))
    {
      localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
      if (paramamce.jdField_a_of_type_Int - 1 >= 0)
      {
        i1 = paramamce.jdField_a_of_type_Int - 1;
        localObjectAnimator1.setRepeatCount(i1);
      }
    }
    for (;;)
    {
      localObjectAnimator1.addListener(new amby(this, localObjectAnimator2));
      return localObjectAnimator1;
      i1 = 0;
      break;
      localObjectAnimator2.setRepeatCount(-1);
    }
  }
  
  private void f()
  {
    this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i);
    this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i);
    this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int);
    this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int);
    this.jdField_f_of_type_Int += this.jdField_a_of_type_Amba.jdField_h_of_type_Int / 2;
    this.jdField_g_of_type_Int -= this.jdField_a_of_type_Amba.i / 2;
    this.jdField_d_of_type_Int += this.jdField_a_of_type_Amba.jdField_f_of_type_Int / 2;
    this.jdField_e_of_type_Int -= this.jdField_a_of_type_Amba.jdField_g_of_type_Int / 2;
    if (this.jdField_g_of_type_Int <= this.jdField_f_of_type_Int)
    {
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int);
    }
    if (this.jdField_e_of_type_Int <= this.jdField_d_of_type_Int)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i);
    }
    if (this.jdField_b_of_type_Int == 160)
    {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i - this.i / 3);
      this.jdField_e_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i + this.i / 3);
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getTop() + BaseChatItemLayout.jdField_g_of_type_Int - this.j / 3);
      this.jdField_g_of_type_Int = (this.jdField_a_of_type_AndroidViewView.getBottom() - BaseChatItemLayout.jdField_h_of_type_Int + this.j / 3);
    }
  }
  
  private void g()
  {
    boolean bool = false;
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = (amcc)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject1 instanceof amce)) {}
    }
    for (Object localObject1 = (amce)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        return;
        i1 += 1;
        break;
      }
      Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Amba.jdField_a_of_type_JavaLangString);
      localObject2 = ((File)localObject2).getAbsolutePath() + File.separatorChar + ((amce)localObject1).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(1) });
      Object localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      BubbleManager.a((String)localObject2, (BitmapFactory.Options)localObject3);
      this.i = bbbr.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      this.j = bbbr.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      if (this.i > BaseChatItemLayout.i * 2)
      {
        i1 = BaseChatItemLayout.i * 2;
        this.j = ((int)(this.j * i1 * 1.0F / this.i));
        this.i = i1;
      }
      localObject3 = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      ((View)localObject3).layout(0, 0, this.i, this.j);
      ((View)localObject3).setVisibility(4);
      this.jdField_a_of_type_Amca = new amca();
      this.jdField_a_of_type_Amca.jdField_b_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_Amca.jdField_a_of_type_JavaLangString = (((amce)localObject1).jdField_a_of_type_JavaLangString + (String)localObject2);
      localObject2 = this.jdField_a_of_type_Amca;
      if (this.jdField_a_of_type_Boolean) {
        bool = ((amce)localObject1).jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        ((amca)localObject2).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
        this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
        return;
        if (!((amce)localObject1).jdField_b_of_type_Boolean) {
          bool = true;
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    int i1;
    if (this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() == 0)
    {
      i1 = 0;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label328;
      }
      localObject = (amcc)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject instanceof amce)) {
        break label134;
      }
    }
    label134:
    label273:
    label319:
    label328:
    for (Object localObject = (amce)localObject;; localObject = null)
    {
      localObject = a((amce)localObject);
      if (localObject != null)
      {
        ((ObjectAnimator)localObject).setDuration(200L);
        localArrayList.add(localObject);
      }
      int i2 = 0;
      i1 = -1;
      int i3;
      for (;;)
      {
        if (i2 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (i2 == i1)
          {
            i3 = i1;
            i2 += 1;
            i1 = i3;
            continue;
            i1 += 1;
            break;
          }
          localObject = (amcc)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if ((localObject instanceof amce)) {
            localObject = f((amce)localObject);
          }
        }
      }
      for (;;)
      {
        i3 = i1;
        if (localObject == null) {
          break;
        }
        localArrayList.add(localObject);
        i3 = i1;
        break;
        if ((localObject instanceof amcf))
        {
          amcf localamcf = (amcf)localObject;
          localObject = b(localamcf);
          if (localObject != null) {
            if (localamcf.jdField_a_of_type_Int - 1 < 0) {
              break label273;
            }
          }
          for (i3 = localamcf.jdField_a_of_type_Int - 1;; i3 = 0)
          {
            ((ObjectAnimator)localObject).setRepeatCount(i3);
            if (TextUtils.isEmpty(localamcf.e)) {
              break label319;
            }
            i1 = a((Animator)localObject, localamcf.e);
            break;
          }
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ambw(this));
          this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.3(this));
          return;
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
  
  private void i()
  {
    ThreadManager.post(new BubbleNewAIOAnim.7(this), 5, null, true);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_c_of_type_AndroidViewView.setTranslationY(this.jdField_c_of_type_AndroidViewView.getTranslationY() + paramInt);
    }
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView != null))
    {
      paramInt = (int)(this.jdField_d_of_type_AndroidViewView.getTranslationY() + paramInt);
      this.jdField_d_of_type_AndroidViewView.setTranslationY(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleNewAIOAnim", 4, paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean == paramBoolean) {}
    Object localObject;
    label90:
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Acuj != null)
      {
        if (this.jdField_a_of_type_Acuj.jdField_a_of_type_Ambg != null) {}
        for (localObject = this.jdField_a_of_type_Acuj.jdField_a_of_type_Ambg.a;; localObject = null)
        {
          if ((localObject == null) || (!this.jdField_a_of_type_Amba.jdField_b_of_type_Boolean)) {
            break label90;
          }
          localObject = this.jdField_a_of_type_Acuj.jdField_a_of_type_AndroidViewView.getBackground();
          if (!(localObject instanceof amcy)) {
            break;
          }
          if (!paramBoolean) {
            break label92;
          }
          ((amcy)localObject).c(true);
          return;
        }
      }
    }
    label92:
    ((amcy)localObject).c(false);
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = actj.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject1 = actj.a(actj.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof acuj)))
    {
      this.jdField_a_of_type_Acuj = ((acuj)localObject1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Acuj.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
        paramInt1 = 0;
        if (paramInt1 < ((ViewGroup)localObject2).getChildCount())
        {
          View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
          if (localView.getId() != 2131364129) {
            break label193;
          }
          this.jdField_e_of_type_AndroidViewView = localView;
        }
      }
      label143:
      localObject2 = new StringBuilder().append("relayout children,  p : ").append(this.jdField_c_of_type_Int).append(", get object: ");
      if (localObject1 == null) {
        break label207;
      }
    }
    label193:
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      a(paramBoolean);
      return false;
      paramInt1 += 1;
      break;
      c();
      break label143;
    }
  }
  
  protected boolean a(Object... paramVarArgs)
  {
    if ((this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning())) {
      return false;
    }
    if (!bfnz.e()) {
      return false;
    }
    this.n = ((Integer)paramVarArgs[0]).intValue();
    this.jdField_a_of_type_Long = ((Long)paramVarArgs[1]).longValue();
    this.jdField_b_of_type_Int = ((Integer)paramVarArgs[2]).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramVarArgs[3]);
    a("start msg id " + this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(44));
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager == null) || (this.jdField_a_of_type_Long == 0L)) {
      return false;
    }
    this.jdField_a_of_type_Ambd = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false);
    if (this.jdField_a_of_type_Ambd == null) {
      return false;
    }
    this.jdField_a_of_type_Amba = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, this.n);
    if (this.jdField_a_of_type_Amba == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Amba.jdField_a_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return false;
    }
    this.jdField_c_of_type_Int = actj.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    paramVarArgs = actj.a(actj.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    if ((paramVarArgs != null) && ((paramVarArgs instanceof acuj)))
    {
      this.jdField_a_of_type_Acuj = ((acuj)paramVarArgs);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Acuj.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend();
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Acuj.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      this.m = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      i();
      g();
      f();
      e();
      h();
      return true;
    }
    return false;
  }
  
  protected void c()
  {
    a("now stop new bubble animation conf!");
    this.jdField_a_of_type_AndroidOsHandler.post(new BubbleNewAIOAnim.1(this));
  }
  
  public void setBitmapData(amca paramamca)
  {
    if (paramamca == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
        } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramamca.jdField_a_of_type_JavaLangString));
        if (paramamca.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ambc(paramamca.jdField_a_of_type_AndroidGraphicsBitmap);
          ((ambc)localObject).jdField_a_of_type_Boolean = paramamca.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_a_of_type_JavaLangString = paramamca.jdField_a_of_type_JavaLangString;
          a("set bitmap path:" + paramamca.jdField_a_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramamca.jdField_a_of_type_JavaLangString));
      a("get cache bitmap path:" + paramamca.jdField_a_of_type_JavaLangString);
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamca.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ambc((Bitmap)localObject);
    ((ambc)localObject).jdField_a_of_type_Boolean = paramamca.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramamca.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidViewView.invalidate();
  }
  
  public void setPathLocation(amcr paramamcr)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
    {
      c();
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramamcr.jdField_a_of_type_Float;
    }
    float f2;
    for (float f1 = i1 - this.m + f1;; f1 = paramamcr.jdField_a_of_type_Float)
    {
      f2 = paramamcr.jdField_b_of_type_Float + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
      if (f2 >= this.jdField_a_of_type_ComTencentWidgetListView.getTop() - this.jdField_c_of_type_AndroidViewView.getHeight()) {
        break;
      }
      a("setPathLocation: now scroll over sreen, stop bubble animatorset!");
      a("now listview firstVisible postion: " + this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition() + ", last postion: " + this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition() + ", now msg pos: " + this.jdField_c_of_type_Int);
      c();
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setTranslationX(f1);
    this.jdField_c_of_type_AndroidViewView.setTranslationY(f2);
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramamcr.d);
    this.jdField_c_of_type_AndroidViewView.setRotation(paramamcr.jdField_c_of_type_Float);
  }
  
  public void setPendantBitmap(amca paramamca)
  {
    if (paramamca == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_e_of_type_AndroidViewView == null))
          {
            c();
            return;
          }
          int i1 = this.jdField_e_of_type_AndroidViewView.getLeft();
          this.jdField_d_of_type_AndroidViewView.setTranslationX(i1);
          i1 = this.jdField_e_of_type_AndroidViewView.getTop();
          int i2 = this.jdField_b_of_type_AndroidViewView.getTop();
          int i3 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
          this.jdField_d_of_type_AndroidViewView.setTranslationY(i1 + i2 - i3);
          if ((this.jdField_c_of_type_Int > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()) || (this.jdField_c_of_type_Int < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()))
          {
            a("setPendantBitmap: now scroll over sreen, stop pendant animatorset!");
            c();
            return;
          }
        } while (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramamca.jdField_a_of_type_JavaLangString));
        if (paramamca.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ambc(paramamca.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_b_of_type_JavaLangString = paramamca.jdField_a_of_type_JavaLangString;
          ((ambc)localObject).jdField_a_of_type_Boolean = paramamca.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_d_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramamca.jdField_a_of_type_JavaLangString));
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamca.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ambc((Bitmap)localObject);
    this.jdField_b_of_type_JavaLangString = paramamca.jdField_a_of_type_JavaLangString;
    ((ambc)localObject).jdField_a_of_type_Boolean = paramamca.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */