import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.1;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.2;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.SwipeUpAndDragListener.3;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class agln
  implements View.OnTouchListener
{
  private static int jdField_e_of_type_Int = 60;
  private static int jdField_f_of_type_Int = 300;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  public long a;
  aglm jdField_a_of_type_Aglm;
  public agls a;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  public PhotoListPanel a;
  public AtomicBoolean a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  agls jdField_b_of_type_Agls;
  public AtomicBoolean b;
  public float c;
  public int c;
  public agls c;
  public float d;
  int d;
  float jdField_e_of_type_Float;
  float jdField_f_of_type_Float = 0.7F;
  float g;
  
  public agln(Context paramContext, ViewGroup paramViewGroup, int[] paramArrayOfInt, int paramInt, aglm paramaglm, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Aglm = paramaglm;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = paramPhotoListPanel;
    this.jdField_e_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    jdField_e_of_type_Int = (int)(30.0F * this.jdField_e_of_type_Float);
    switch (PhotoListPanel.g())
    {
    }
    for (this.jdField_b_of_type_Agls = new aglq(this, paramContext, paramViewGroup);; this.jdField_b_of_type_Agls = new agls(this, paramContext, paramViewGroup))
    {
      this.jdField_c_of_type_Agls = new aglo(this, paramContext, paramViewGroup);
      return;
    }
  }
  
  float a(int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Agli.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Agli.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 1168.0F / (paramInt2 * this.jdField_e_of_type_Float);
    }
    for (;;)
    {
      awiw.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight + ",sideLength = " + paramInt2);
      return f1;
      f1 = localLocalMediaInfo.mediaHeight * 1.0F / localLocalMediaInfo.mediaWidth;
      if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100))
      {
        if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
          f1 = 1168.0F / (f1 * paramInt2 * this.jdField_e_of_type_Float);
        } else {
          f1 = f1 * 1168.0F / (paramInt2 * this.jdField_e_of_type_Float);
        }
      }
      else if (localLocalMediaInfo.mediaHeight > localLocalMediaInfo.mediaWidth) {
        f1 = paramInt2 * 2336.0F / (f1 * this.jdField_e_of_type_Float);
      } else {
        f1 = f1 * 2336.0F / (paramInt2 * this.jdField_e_of_type_Float);
      }
    }
  }
  
  float a(int paramInt1, int paramInt2, int paramInt3)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Agli.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Agli.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 160.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
    }
    for (;;)
    {
      awiw.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight);
      return f1;
      if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100)) {
        f1 = 135.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      } else {
        f1 = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      }
    }
  }
  
  agls a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_a_of_type_Boolean = true;
      i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
      f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
      if (-f1 > 1500.0F)
      {
        bool1 = true;
        if (paramFloat2 >= 0.0F) {
          break label384;
        }
        bool2 = true;
        label81:
        if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
          break label390;
        }
      }
      label384:
      label390:
      for (bool3 = true;; bool3 = false)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) {
          bool4 = true;
        }
        awiw.a("PhotoListPanel", "detectGesture", "Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4 + ",mGestureHandler = " + this.jdField_a_of_type_Agls);
        awiw.a("PhotoListPanel", "detectGesture", "mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        if ((this.jdField_a_of_type_Agls != null) || (!bool2) || (!bool3) || (!bool4)) {
          break label775;
        }
        awiw.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.jdField_c_of_type_Agls;
        bool1 = false;
        break;
        bool2 = false;
        break label81;
      }
    }
    int i = paramMotionEvent.findPointerIndex(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    float f1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(i);
    if (-f1 > 3000.0F)
    {
      bool1 = true;
      if (paramFloat2 >= 0.0F) {
        break label763;
      }
      bool2 = true;
      label457:
      if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
        break label769;
      }
    }
    label769:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 1)
      {
        bool4 = bool5;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 0) {}
      }
      else
      {
        bool4 = true;
      }
      awiw.a("PhotoListPanel", "detectGesture", "2 Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4);
      awiw.a("PhotoListPanel", "detectGesture", "2 mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      if ((this.jdField_a_of_type_Agls != null) || (!bool2) || (!bool3) || (!bool4) || (!bool1)) {
        break label775;
      }
      this.jdField_a_of_type_Boolean = true;
      awiw.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
      return this.jdField_b_of_type_Agls;
      bool1 = false;
      break;
      label763:
      bool2 = false;
      break label457;
    }
    label775:
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Agls != null)
    {
      this.jdField_a_of_type_Agls.b();
      this.jdField_a_of_type_Agls = null;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findChildViewUnder(f1, f2);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(localView);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_d_of_type_Int = paramMotionEvent.getPointerId(0);
      awiw.a("PhotoListPanel", "onTouch", " touchFirstActtion,mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      this.jdField_a_of_type_Agls = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.2(this), 100L);
      if (PhotoListPanel.g() == 1)
      {
        ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.3(this), jdField_f_of_type_Int);
        paramMotionEvent = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 0) {
          break label219;
        }
      }
    }
    for (;;)
    {
      paramMotionEvent.set(bool);
      return;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
      break;
      label219:
      bool = false;
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Agls != null) && (this.jdField_c_of_type_Agls.a())) {
      this.jdField_c_of_type_Agls.b();
    }
    while ((this.jdField_b_of_type_Agls == null) || (!this.jdField_b_of_type_Agls.a())) {
      return;
    }
    this.jdField_b_of_type_Agls.b();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    awiw.a("PhotoListPanel", "onTouch", "x = " + f1 + ",y = " + f2 + ",event = " + paramMotionEvent + ", mPanel.mDisableGuestrueSend = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      return bool1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      awiw.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + f1 + ",y = " + f2);
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean)
      {
        awiw.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + paramMotionEvent.getX() + ",y = " + paramMotionEvent.getY());
        a(paramMotionEvent);
        continue;
        awiw.a("PhotoListPanel", "onTouch", " ACTION_MOVE,x = " + f1 + ",y = " + f2 + ",mGestureHandler = " + this.jdField_a_of_type_Agls);
        if ((this.jdField_c_of_type_Float == f1) && (this.jdField_d_of_type_Float == f2)) {
          return false;
        }
        float f3 = this.jdField_a_of_type_Float;
        float f4 = this.jdField_b_of_type_Float;
        if (PhotoListPanel.g() == 1)
        {
          if ((SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long < jdField_f_of_type_Int) && ((Math.abs(this.jdField_c_of_type_Float - paramMotionEvent.getX()) > this.jdField_b_of_type_Int) || (Math.abs(this.jdField_d_of_type_Float - paramMotionEvent.getY()) > this.jdField_b_of_type_Int))) {
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          }
          if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
            return false;
          }
        }
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
        }
        paramView = (aglk)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(this.jdField_c_of_type_Int);
        if (paramView == null) {
          return false;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          if (PhotoListPanel.g() == 0)
          {
            this.jdField_a_of_type_Agls = a(paramMotionEvent, f1 - f3, f2 - f4);
            if (this.jdField_a_of_type_Agls != null) {
              return this.jdField_a_of_type_Agls.a(paramView, this.jdField_c_of_type_Int);
            }
          }
        }
        else if (this.jdField_a_of_type_Agls != null) {
          return this.jdField_a_of_type_Agls.a(paramMotionEvent);
        }
        awiw.a("PhotoListPanel", "onTouch", "f ACTION_MOVE,x = " + f1 + ",y = " + f2);
        continue;
        if (PhotoListPanel.g() == 1) {
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
        if (this.jdField_a_of_type_Agls != null)
        {
          boolean bool2 = this.jdField_a_of_type_Agls.b(paramMotionEvent);
          this.jdField_a_of_type_Agls = null;
          bool1 = bool2;
          if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
            break;
          }
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
          return bool2;
        }
        long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
        {
          this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
          this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        }
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 0)) && (Math.abs(f2 - this.jdField_b_of_type_Float) > Math.abs(f1 - this.jdField_a_of_type_Float)) && ((l > 200L) || (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_b_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)))
        {
          awiw.a("PhotoListPanel", "onTouch", " ACTION_UP,eat up event.dx = " + Math.abs(f1 - this.jdField_a_of_type_Float) + ",dy = " + Math.abs(f2 - this.jdField_b_of_type_Float) + ",duration = " + l);
          return true;
        }
        awiw.a("PhotoListPanel", "onTouch", "f ACTION_UP,x = " + f1 + ",y = " + f2);
        continue;
        if (PhotoListPanel.g() == 1) {
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        }
        ThreadManagerV2.getUIHandlerV2().post(new PhotoListPanel.SwipeUpAndDragListener.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agln
 * JD-Core Version:    0.7.0.1
 */