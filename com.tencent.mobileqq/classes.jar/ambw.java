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
public class ambw
  extends acyo
{
  public long a;
  public acun a;
  public ambb a;
  public ambe a;
  private amcb jdField_a_of_type_Amcb;
  public AnimatorSet a;
  private final Resources jdField_a_of_type_AndroidContentResResources;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public View a;
  public QQAppInterface a;
  public BubbleManager a;
  public String a;
  public ArrayList<amcd> a;
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
  
  public ambw(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
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
    this.jdField_h_of_type_Int = actn.a(12.0F, paramListView.getContext().getResources());
    this.k = actn.a(50.0F, paramListView.getContext().getResources());
    this.l = actn.a(45.0F, paramListView.getContext().getResources());
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
        if (!((amcd)this.jdField_a_of_type_JavaUtilArrayList.get(i1)).jdField_a_of_type_JavaLangString.equals(paramString)) {}
      }
      for (;;)
      {
        if (i1 != -1)
        {
          paramString = (amcd)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (!(paramString instanceof amcf)) {
            break label113;
          }
        }
        label113:
        for (paramString = f((amcf)paramString);; paramString = null)
        {
          if ((paramAnimator != null) && (paramString != null))
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new amby(this, paramString));
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
  
  private ObjectAnimator a(amcf paramamcf)
  {
    if (paramamcf == null) {
      return null;
    }
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Ambb.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramamcf.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramamcf.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      amcb localamcb = new amcb();
      localamcb.jdField_b_of_type_JavaLangString = str;
      localamcb.jdField_a_of_type_JavaLangString = (paramamcf.jdField_a_of_type_JavaLangString + str);
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = paramamcf.jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        localamcb.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localamcb);
        i1 += 1;
        break;
        if (!paramamcf.jdField_b_of_type_Boolean) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(amcg paramamcg)
  {
    File localFile = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Ambb.jdField_a_of_type_JavaLangString);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    if (i1 < paramamcg.jdField_b_of_type_Int)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramamcg.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) });
      amcb localamcb = new amcb();
      localamcb.jdField_b_of_type_JavaLangString = str;
      localamcb.jdField_a_of_type_JavaLangString = (paramamcg.jdField_a_of_type_JavaLangString + str);
      if (this.jdField_a_of_type_Boolean) {}
      for (boolean bool = false;; bool = true)
      {
        localamcb.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        localArrayList.add(localamcb);
        i1 += 1;
        break;
      }
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List<amcb> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Amcb);
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
    ((PropertyValuesHolder)localObject).setEvaluator(new amcc(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator a(amcf paramamcf)
  {
    switch (paramamcf.jdField_e_of_type_Int)
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
  
  private ObjectAnimator b(amcf paramamcf)
  {
    int i2 = a(paramamcf.jdField_a_of_type_Float);
    int i3 = b(paramamcf.jdField_b_of_type_Float);
    int i4 = a(paramamcf.jdField_c_of_type_Float);
    int i5 = b(paramamcf.d);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      amcs localamcs = amcs.b(i2, i3);
      localamcs.jdField_c_of_type_Float = (paramamcf.jdField_h_of_type_Int * i1);
      localamcs.d = (paramamcf.jdField_f_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcs);
      localamcs = amcs.a(i4, i5);
      localamcs.jdField_c_of_type_Float = (i1 * paramamcf.i);
      localamcs.d = (paramamcf.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcs);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amct(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamcf));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramamcf.jdField_a_of_type_Long));
      return localObject;
    }
  }
  
  private ObjectAnimator b(amcg paramamcg)
  {
    ObjectAnimator localObjectAnimator = a(paramamcg);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new amca(this, paramamcg));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List<amcb> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f1 = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.jdField_a_of_type_Amcb);
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
    ((PropertyValuesHolder)localObject).setEvaluator(new amcc(this));
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private ObjectAnimator c(amcf paramamcf)
  {
    int i2 = a(paramamcf.jdField_a_of_type_Float);
    int i3 = b(paramamcf.jdField_b_of_type_Float);
    int i4 = a(paramamcf.jdField_c_of_type_Float);
    int i5 = b(paramamcf.d);
    int i6 = a(paramamcf.jdField_e_of_type_Float);
    int i7 = b(paramamcf.jdField_f_of_type_Float);
    int i8 = a(paramamcf.jdField_g_of_type_Float);
    int i9 = b(paramamcf.jdField_h_of_type_Float);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i1 = 1;; i1 = -1)
    {
      Object localObject = new ArrayList();
      amcs localamcs = amcs.b(i2, i3);
      localamcs.d = paramamcf.jdField_f_of_type_Int;
      localamcs.jdField_c_of_type_Float = (paramamcf.jdField_h_of_type_Int * i1);
      ((ArrayList)localObject).add(localamcs);
      localamcs = amcs.a(i6, i7, i8, i9, i4, i5);
      a("play circle points: " + amcs.a(i6, i7, i8, i9, i4, i5).toString());
      localamcs.jdField_c_of_type_Float = (paramamcf.i * i1);
      localamcs.d = (paramamcf.jdField_g_of_type_Int / 100.0F);
      ((ArrayList)localObject).add(localamcs);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amct(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamcf));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(i2 - i4) + Math.abs(i3 - i5)) * 1.0F / this.k * (float)paramamcf.jdField_a_of_type_Long * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator d(amcf paramamcf)
  {
    int i3 = a(paramamcf.jdField_a_of_type_Float);
    int i4 = b(paramamcf.jdField_b_of_type_Float);
    int i2 = a(paramamcf.jdField_c_of_type_Float);
    if (i4 != b(paramamcf.d)) {
      return null;
    }
    int i1;
    int i5;
    int i6;
    if (i2 > i3)
    {
      i1 = 1;
      i5 = this.k;
      i5 = paramamcf.j * i5;
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
      i6 = (int)(i3 + i5 * paramamcf.jdField_e_of_type_Float * i1);
      int i7 = (int)(i4 + i5 * paramamcf.jdField_f_of_type_Float);
      int i8 = (int)(i3 + i5 * paramamcf.jdField_g_of_type_Float * i1);
      int i9 = (int)(i4 + i5 * paramamcf.jdField_h_of_type_Float);
      int i10 = i3 + i5 * i1;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(amcs.b(i3, i4));
      ((ArrayList)localObject).add(amcs.a(i6, i7, i8, i9, i10, i4));
      a("next points: " + amcs.a(i6, i7, i8, i9, i10, i4).toString());
      i3 = 1;
      for (;;)
      {
        if (i3 < i2)
        {
          int i11 = i1 * i3 * i5 + i6;
          int i12 = i1 * i3 * i5 + i8;
          int i13 = i1 * i3 * i5 + i10;
          ((ArrayList)localObject).add(amcs.a(i11, i7, i12, i9, i13, i4));
          a("next points: " + amcs.a(i11, i7, i12, i9, i13, i4).toString());
          i3 += 1;
          continue;
          i1 = -1;
          break;
        }
      }
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new amct(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramamcf));
      a("duration: " + paramamcf.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D);
      ((ObjectAnimator)localObject).setDuration((paramamcf.jdField_a_of_type_Long * i2 * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator e(amcf paramamcf)
  {
    int i1 = a(paramamcf.jdField_a_of_type_Float);
    int i2 = b(paramamcf.jdField_b_of_type_Float);
    int i3 = a(paramamcf.jdField_c_of_type_Float);
    int i4 = b(paramamcf.d);
    if ((i1 == i3) || (i2 == i4)) {
      if (i2 == i4) {
        i1 = 1;
      }
    }
    while (i1 != 0)
    {
      return d(paramamcf);
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
        if ((localView.getId() == 2131364130) && (localView.getVisibility() == 0))
        {
          this.jdField_e_of_type_AndroidViewView = localView;
          this.jdField_d_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
          this.jdField_d_of_type_AndroidViewView.layout(0, 0, actn.a(50.0F, this.jdField_a_of_type_AndroidContentResResources), actn.a(59.0F, this.jdField_a_of_type_AndroidContentResResources));
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
  
  private ObjectAnimator f(amcf paramamcf)
  {
    ObjectAnimator localObjectAnimator1;
    if ((paramamcf.jdField_e_of_type_Float == 0.0F) && (paramamcf.jdField_f_of_type_Float == 0.0F) && (paramamcf.jdField_g_of_type_Float == 0.0F) && (paramamcf.jdField_h_of_type_Float == 0.0F)) {
      localObjectAnimator1 = b(paramamcf);
    }
    ObjectAnimator localObjectAnimator2;
    for (;;)
    {
      localObjectAnimator2 = a(paramamcf);
      if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null)) {
        break;
      }
      return null;
      if (paramamcf.jdField_c_of_type_Boolean) {
        localObjectAnimator1 = e(paramamcf);
      } else {
        localObjectAnimator1 = c(paramamcf);
      }
    }
    int i1;
    if ((paramamcf.jdField_a_of_type_Float == paramamcf.jdField_c_of_type_Float) && (paramamcf.jdField_b_of_type_Float == paramamcf.d))
    {
      localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
      if (paramamcf.jdField_a_of_type_Int - 1 >= 0)
      {
        i1 = paramamcf.jdField_a_of_type_Int - 1;
        localObjectAnimator1.setRepeatCount(i1);
      }
    }
    for (;;)
    {
      localObjectAnimator1.addListener(new ambz(this, localObjectAnimator2));
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
    this.jdField_f_of_type_Int += this.jdField_a_of_type_Ambb.jdField_h_of_type_Int / 2;
    this.jdField_g_of_type_Int -= this.jdField_a_of_type_Ambb.i / 2;
    this.jdField_d_of_type_Int += this.jdField_a_of_type_Ambb.jdField_f_of_type_Int / 2;
    this.jdField_e_of_type_Int -= this.jdField_a_of_type_Ambb.jdField_g_of_type_Int / 2;
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
      localObject1 = (amcd)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject1 instanceof amcf)) {}
    }
    for (Object localObject1 = (amcf)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        return;
        i1 += 1;
        break;
      }
      Object localObject2 = new File(this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false), this.jdField_a_of_type_Ambb.jdField_a_of_type_JavaLangString);
      localObject2 = ((File)localObject2).getAbsolutePath() + File.separatorChar + ((amcf)localObject1).jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(1) });
      Object localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      BubbleManager.a((String)localObject2, (BitmapFactory.Options)localObject3);
      this.i = bbbd.a(((BitmapFactory.Options)localObject3).outWidth, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      this.j = bbbd.a(((BitmapFactory.Options)localObject3).outHeight, 320, this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi);
      if (this.i > BaseChatItemLayout.i * 2)
      {
        i1 = BaseChatItemLayout.i * 2;
        this.j = ((int)(this.j * i1 * 1.0F / this.i));
        this.i = i1;
      }
      localObject3 = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      ((View)localObject3).layout(0, 0, this.i, this.j);
      ((View)localObject3).setVisibility(4);
      this.jdField_a_of_type_Amcb = new amcb();
      this.jdField_a_of_type_Amcb.jdField_b_of_type_JavaLangString = ((String)localObject2);
      this.jdField_a_of_type_Amcb.jdField_a_of_type_JavaLangString = (((amcf)localObject1).jdField_a_of_type_JavaLangString + (String)localObject2);
      localObject2 = this.jdField_a_of_type_Amcb;
      if (this.jdField_a_of_type_Boolean) {
        bool = ((amcf)localObject1).jdField_b_of_type_Boolean;
      }
      for (;;)
      {
        ((amcb)localObject2).jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
        this.jdField_c_of_type_AndroidViewView = ((View)localObject3);
        return;
        if (!((amcf)localObject1).jdField_b_of_type_Boolean) {
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
      localObject = (amcd)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (!(localObject instanceof amcf)) {
        break label134;
      }
    }
    label134:
    label273:
    label319:
    label328:
    for (Object localObject = (amcf)localObject;; localObject = null)
    {
      localObject = a((amcf)localObject);
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
          localObject = (amcd)this.jdField_a_of_type_JavaUtilArrayList.get(i2);
          if ((localObject instanceof amcf)) {
            localObject = f((amcf)localObject);
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
        if ((localObject instanceof amcg))
        {
          amcg localamcg = (amcg)localObject;
          localObject = b(localamcg);
          if (localObject != null) {
            if (localamcg.jdField_a_of_type_Int - 1 < 0) {
              break label273;
            }
          }
          for (i3 = localamcg.jdField_a_of_type_Int - 1;; i3 = 0)
          {
            ((ObjectAnimator)localObject).setRepeatCount(i3);
            if (TextUtils.isEmpty(localamcg.e)) {
              break label319;
            }
            i1 = a((Animator)localObject, localamcg.e);
            break;
          }
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.playSequentially(localArrayList);
          this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(new ambx(this));
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
      if (this.jdField_a_of_type_Acun != null)
      {
        if (this.jdField_a_of_type_Acun.jdField_a_of_type_Ambh != null) {}
        for (localObject = this.jdField_a_of_type_Acun.jdField_a_of_type_Ambh.a;; localObject = null)
        {
          if ((localObject == null) || (!this.jdField_a_of_type_Ambb.jdField_b_of_type_Boolean)) {
            break label90;
          }
          localObject = this.jdField_a_of_type_Acun.jdField_a_of_type_AndroidViewView.getBackground();
          if (!(localObject instanceof amcz)) {
            break;
          }
          if (!paramBoolean) {
            break label92;
          }
          ((amcz)localObject).c(true);
          return;
        }
      }
    }
    label92:
    ((amcz)localObject).c(false);
  }
  
  protected boolean a(int paramInt)
  {
    return true;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_Int = actn.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    Object localObject1 = actn.a(actn.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof acun)))
    {
      this.jdField_a_of_type_Acun = ((acun)localObject1);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Acun.jdField_a_of_type_AndroidViewView;
      this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
      if ((this.jdField_b_of_type_AndroidViewView != null) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)this.jdField_b_of_type_AndroidViewView;
        paramInt1 = 0;
        if (paramInt1 < ((ViewGroup)localObject2).getChildCount())
        {
          View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
          if (localView.getId() != 2131364130) {
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
    if (!bfni.e()) {
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
    this.jdField_a_of_type_Ambe = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, false);
    if (this.jdField_a_of_type_Ambe == null) {
      return false;
    }
    this.jdField_a_of_type_Ambb = this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_b_of_type_Int, this.n);
    if (this.jdField_a_of_type_Ambb == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_Ambb.jdField_a_of_type_JavaUtilArrayList;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)) {
      return false;
    }
    this.jdField_c_of_type_Int = actn.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
    paramVarArgs = actn.a(actn.a(this.jdField_a_of_type_ComTencentWidgetListView, this.jdField_c_of_type_Int));
    if ((paramVarArgs != null) && ((paramVarArgs instanceof acun)))
    {
      this.jdField_a_of_type_Acun = ((acun)paramVarArgs);
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Acun.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend();
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_Acun.jdField_a_of_type_AndroidViewView;
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
  
  public void setBitmapData(amcb paramamcb)
  {
    if (paramamcb == null) {}
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
        } while (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramamcb.jdField_a_of_type_JavaLangString));
        if (paramamcb.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ambd(paramamcb.jdField_a_of_type_AndroidGraphicsBitmap);
          ((ambd)localObject).jdField_a_of_type_Boolean = paramamcb.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_a_of_type_JavaLangString = paramamcb.jdField_a_of_type_JavaLangString;
          a("set bitmap path:" + paramamcb.jdField_a_of_type_JavaLangString);
          this.jdField_c_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramamcb.jdField_a_of_type_JavaLangString));
      a("get cache bitmap path:" + paramamcb.jdField_a_of_type_JavaLangString);
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamcb.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ambd((Bitmap)localObject);
    ((ambd)localObject).jdField_a_of_type_Boolean = paramamcb.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_a_of_type_JavaLangString = paramamcb.jdField_a_of_type_JavaLangString;
    this.jdField_c_of_type_AndroidViewView.invalidate();
  }
  
  public void setPathLocation(amcs paramamcs)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_c_of_type_AndroidViewView == null))
    {
      c();
      return;
    }
    this.jdField_b_of_type_AndroidViewView = ((View)this.jdField_a_of_type_AndroidViewView.getParent());
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    if (this.jdField_a_of_type_Boolean) {
      f1 = paramamcs.jdField_a_of_type_Float;
    }
    float f2;
    for (float f1 = i1 - this.m + f1;; f1 = paramamcs.jdField_a_of_type_Float)
    {
      f2 = paramamcs.jdField_b_of_type_Float + this.jdField_b_of_type_AndroidViewView.getTop() - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
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
    this.jdField_c_of_type_AndroidViewView.setAlpha(paramamcs.d);
    this.jdField_c_of_type_AndroidViewView.setRotation(paramamcs.jdField_c_of_type_Float);
  }
  
  public void setPendantBitmap(amcb paramamcb)
  {
    if (paramamcb == null) {}
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
        } while (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase(paramamcb.jdField_a_of_type_JavaLangString));
        if (paramamcb.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          localObject = new ambd(paramamcb.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_b_of_type_JavaLangString = paramamcb.jdField_a_of_type_JavaLangString;
          ((ambd)localObject).jdField_a_of_type_Boolean = paramamcb.jdField_a_of_type_JavaLangBoolean.booleanValue();
          this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
          this.jdField_d_of_type_AndroidViewView.invalidate();
          return;
        }
      } while (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramamcb.jdField_a_of_type_JavaLangString));
      localObject = (Bitmap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramamcb.jdField_a_of_type_JavaLangString);
    } while (localObject == null);
    Object localObject = new ambd((Bitmap)localObject);
    this.jdField_b_of_type_JavaLangString = paramamcb.jdField_a_of_type_JavaLangString;
    ((ambd)localObject).jdField_a_of_type_Boolean = paramamcb.jdField_a_of_type_JavaLangBoolean.booleanValue();
    this.jdField_d_of_type_AndroidViewView.setBackgroundDrawable((Drawable)localObject);
    this.jdField_d_of_type_AndroidViewView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambw
 * JD-Core Version:    0.7.0.1
 */