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
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class adzk
  implements View.OnTouchListener
{
  private static int jdField_e_of_type_Int = 60;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  adzj jdField_a_of_type_Adzj;
  adzp jdField_a_of_type_Adzp;
  VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  public PhotoListPanel a;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  adzp jdField_b_of_type_Adzp;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  adzp jdField_c_of_type_Adzp;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  float jdField_e_of_type_Float;
  float f = 0.7F;
  float g;
  
  public adzk(Context paramContext, ViewGroup paramViewGroup, int[] paramArrayOfInt, int paramInt, adzj paramadzj, PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Adzj = paramadzj;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = paramPhotoListPanel;
    this.jdField_e_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    jdField_e_of_type_Int = (int)(30.0F * this.jdField_e_of_type_Float);
    switch (PhotoListPanel.e())
    {
    }
    for (this.jdField_b_of_type_Adzp = new adzn(this, paramContext, paramViewGroup);; this.jdField_b_of_type_Adzp = new adzp(this, paramContext, paramViewGroup))
    {
      this.jdField_c_of_type_Adzp = new adzl(this, paramContext, paramViewGroup);
      return;
    }
  }
  
  float a(int paramInt1, int paramInt2)
  {
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 1168.0F / (paramInt2 * this.jdField_e_of_type_Float);
    }
    for (;;)
    {
      atpg.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight + ",sideLength = " + paramInt2);
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
    LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.a(paramInt1);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Adzf.getItemViewType(paramInt1);
    float f1;
    if (i == 1) {
      f1 = 160.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
    }
    for (;;)
    {
      atpg.a("PhotoListPanel", "calcuEndScale", "position = " + paramInt1 + ",scale = " + f1 + ",mediaType = " + i + ",info.mediaWidth = " + localLocalMediaInfo.mediaWidth + ",info.mediaHeight = " + localLocalMediaInfo.mediaHeight);
      return f1;
      if ((localLocalMediaInfo.mediaWidth > 100) || (localLocalMediaInfo.mediaHeight > 100)) {
        f1 = 135.0F * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      } else {
        f1 = Math.max(localLocalMediaInfo.mediaWidth, localLocalMediaInfo.mediaHeight) * this.jdField_e_of_type_Float / Math.max(paramInt2, paramInt3);
      }
    }
  }
  
  adzp a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2)
  {
    boolean bool4 = false;
    boolean bool5 = true;
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
          break label375;
        }
        bool2 = true;
        label81:
        if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
          break label381;
        }
        bool3 = true;
        label95:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l != 1) {
          break label387;
        }
      }
      label387:
      for (bool4 = bool5;; bool4 = false)
      {
        atpg.a("PhotoListPanel", "detectGesture", "Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4 + ",mGestureHandler = " + this.jdField_a_of_type_Adzp);
        atpg.a("PhotoListPanel", "detectGesture", "mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
        if ((this.jdField_a_of_type_Adzp != null) || (!bool2) || (!bool3) || (!bool4)) {
          break label758;
        }
        atpg.a("PhotoListPanel", "detectGesture", "return mDragHandler.");
        return this.jdField_c_of_type_Adzp;
        bool1 = false;
        break;
        label375:
        bool2 = false;
        break label81;
        label381:
        bool3 = false;
        break label95;
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
        break label746;
      }
      bool2 = true;
      label454:
      if (Math.abs(paramFloat1 / paramFloat2) >= 1.0F) {
        break label752;
      }
    }
    label746:
    label752:
    for (boolean bool3 = true;; bool3 = false)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) {
        bool4 = true;
      }
      atpg.a("PhotoListPanel", "detectGesture", "2 Xvelocity=" + this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) + "Yvelocity=" + f1 + ",delX = " + paramFloat1 + ", delY = " + paramFloat2 + "tanA = " + Math.abs(paramFloat1 / paramFloat2) + ",Angle A = " + Math.toDegrees(Math.atan(Math.abs(paramFloat1 / paramFloat2))) + ",Velocity Angle = " + Math.toDegrees(Math.atan(Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity(i) / f1))) + " vThresh = " + bool1 + ",direction = " + bool2 + ",anc = " + bool3 + ",satate = " + bool4);
      atpg.a("PhotoListPanel", "detectGesture", "2 mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      if ((this.jdField_a_of_type_Adzp != null) || (!bool2) || (!bool3) || (!bool4) || (!bool1)) {
        break label758;
      }
      this.jdField_a_of_type_Boolean = true;
      atpg.a("PhotoListPanel", "detectGesture", "return mFlingHandler.");
      return this.jdField_b_of_type_Adzp;
      bool1 = false;
      break;
      bool2 = false;
      break label454;
    }
    label758:
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Adzp != null)
    {
      this.jdField_a_of_type_Adzp.a();
      this.jdField_a_of_type_Adzp = null;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Float = f1;
    this.jdField_c_of_type_Float = f1;
    this.jdField_b_of_type_Float = f2;
    this.jdField_d_of_type_Float = f2;
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findChildViewUnder(f1, f2);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getChildAdapterPosition(localView);
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
      this.jdField_d_of_type_Int = paramMotionEvent.getPointerId(0);
      atpg.a("PhotoListPanel", "onTouch", " touchFirstActtion,mActivePointerId x = " + paramMotionEvent.getX() + ",mActivePointerId y = " + paramMotionEvent.getY());
      this.jdField_a_of_type_Adzp = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      ThreadManager.getUIHandler().postDelayed(new PhotoListPanel.SwipeUpAndDragListener.2(this), 100L);
      return;
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
  }
  
  public void b()
  {
    if ((this.jdField_c_of_type_Adzp != null) && (this.jdField_c_of_type_Adzp.a())) {
      this.jdField_c_of_type_Adzp.a();
    }
    while ((this.jdField_b_of_type_Adzp == null) || (!this.jdField_b_of_type_Adzp.a())) {
      return;
    }
    this.jdField_b_of_type_Adzp.a();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = true;
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    atpg.a("PhotoListPanel", "onTouch", "x = " + f1 + ",y = " + f2 + ",event = " + paramMotionEvent + ", mPanel.mDisableGuestrueSend = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_Boolean) {
      return bool1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      atpg.a("PhotoListPanel", "onTouch", " ACTION_DOWN,x = " + f1 + ",y = " + f2);
      continue;
      atpg.a("PhotoListPanel", "onTouch", " ACTION_MOVE,x = " + f1 + ",y = " + f2 + ",mGestureHandler = " + this.jdField_a_of_type_Adzp);
      float f3 = this.jdField_a_of_type_Float;
      float f4 = this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
        this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
      }
      paramView = (adzh)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.findViewHolderForAdapterPosition(this.jdField_c_of_type_Int);
      if (paramView == null) {
        return false;
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Adzp = a(paramMotionEvent, f1 - f3, f2 - f4);
        if (this.jdField_a_of_type_Adzp != null) {
          return this.jdField_a_of_type_Adzp.a(paramView, this.jdField_c_of_type_Int);
        }
      }
      else if (this.jdField_a_of_type_Adzp != null)
      {
        return this.jdField_a_of_type_Adzp.a(paramMotionEvent);
      }
      atpg.a("PhotoListPanel", "onTouch", "f ACTION_MOVE,x = " + f1 + ",y = " + f2);
      continue;
      if (this.jdField_a_of_type_Adzp != null)
      {
        boolean bool2 = this.jdField_a_of_type_Adzp.b(paramMotionEvent);
        this.jdField_a_of_type_Adzp = null;
        bool1 = bool2;
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return bool2;
      }
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.l == 1) && (Math.abs(f2 - this.jdField_b_of_type_Float) > Math.abs(f1 - this.jdField_a_of_type_Float)) && ((l > 200L) || (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_b_of_type_Int) || (Math.abs(f1 - this.jdField_a_of_type_Float) > this.jdField_b_of_type_Int)))
      {
        atpg.a("PhotoListPanel", "onTouch", " ACTION_UP,eat up event.dx = " + Math.abs(f1 - this.jdField_a_of_type_Float) + ",dy = " + Math.abs(f2 - this.jdField_b_of_type_Float) + ",duration = " + l);
        if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
          break;
        }
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
        return true;
      }
      atpg.a("PhotoListPanel", "onTouch", "f ACTION_UP,x = " + f1 + ",y = " + f2);
      continue;
      if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
      {
        this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
        this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      }
      ThreadManagerV2.getUIHandlerV2().post(new PhotoListPanel.SwipeUpAndDragListener.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adzk
 * JD-Core Version:    0.7.0.1
 */