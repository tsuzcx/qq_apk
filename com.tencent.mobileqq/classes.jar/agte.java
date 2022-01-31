import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.qphone.base.util.QLog;

public class agte
  implements Handler.Callback, GestureDetector.OnGestureListener
{
  private static boolean jdField_a_of_type_Boolean;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final agtf jdField_a_of_type_Agtf;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private final View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_sticker40";
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  
  public agte(agtf paramagtf, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Agtf = paramagtf;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramView.getContext(), this);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "finishSendingAction: " + paramInt);
    }
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_Agtf.a(paramInt, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    this.jdField_c_of_type_Boolean = true;
    jdField_a_of_type_Boolean = false;
  }
  
  private void b()
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidViewView.getLocationInWindow(arrayOfInt);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    this.jdField_b_of_type_Int = arrayOfInt[1];
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 2) && (this.jdField_d_of_type_Int > -1) && (this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      a(this.jdField_d_of_type_Int);
      return true;
    }
    return false;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "handleActionUp: " + paramMotionEvent);
      }
      if (this.jdField_d_of_type_Int <= -1) {
        break label80;
      }
      a(this.jdField_d_of_type_Int);
    }
    label80:
    for (bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Agtf.e();
      return bool1;
    }
  }
  
  public void a()
  {
    if (this.jdField_d_of_type_Int > -1) {
      a(this.jdField_d_of_type_Int);
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool2 = c(paramMotionEvent);
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = b(paramMotionEvent);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.jdField_d_of_type_Int != ((Integer)paramMessage.obj).intValue());
      if (this.jdField_c_of_type_Int >= this.jdField_a_of_type_Agtf.a())
      {
        a(this.jdField_d_of_type_Int);
        return true;
      }
      this.jdField_c_of_type_Int += 1;
      this.jdField_a_of_type_Agtf.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int);
      if (this.jdField_d_of_type_Boolean) {
        HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
      }
      for (;;)
      {
        if ((this.jdField_c_of_type_Int > 2) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Agtf.c();
          this.jdField_b_of_type_Boolean = true;
        }
        if (this.jdField_c_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
          this.jdField_c_of_type_Boolean = false;
        }
        paramMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, paramMessage.obj);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessage, 80L);
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("StickerBubbleGesture", 2, "handleMessage isTouchEffectSupport = " + this.jdField_d_of_type_Boolean);
        }
      }
    } while (!this.jdField_c_of_type_Boolean);
    this.jdField_a_of_type_Agtf.d();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onDown: " + paramMotionEvent);
    }
    this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onFling: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onLongPress: " + paramMotionEvent + " on idx: " + i);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onScroll: " + paramFloat1 + " / " + paramFloat2);
    }
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    int i = this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleGesture", 2, "onShowPress: " + paramMotionEvent + " on idx: " + i);
    }
    if ((i > -1) && (!jdField_a_of_type_Boolean))
    {
      if (this.jdField_d_of_type_Int > -1) {
        a(this.jdField_d_of_type_Int);
      }
      this.jdField_d_of_type_Int = i;
      b();
      this.jdField_a_of_type_Float = (paramMotionEvent.getX() + this.jdField_a_of_type_Int);
      this.jdField_b_of_type_Float = (paramMotionEvent.getY() + this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Agtf.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, i, 1);
      if (!this.jdField_d_of_type_Boolean) {
        break label203;
      }
      HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      jdField_a_of_type_Boolean = true;
      paramMotionEvent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, Integer.valueOf(i));
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMotionEvent, 80L);
      return;
      label203:
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onShowPress isTouchEffectSupport = " + this.jdField_d_of_type_Boolean);
      }
    }
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    long l = SystemClock.uptimeMillis();
    int i;
    if (l - this.jdField_a_of_type_Long > 300L)
    {
      i = this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onSingleTapUp: " + paramMotionEvent + " on idx: " + i);
      }
      if (i > -1)
      {
        b();
        this.jdField_a_of_type_Agtf.a(paramMotionEvent.getX() + this.jdField_a_of_type_Int, paramMotionEvent.getY() + this.jdField_b_of_type_Int, i, 1);
        if (!this.jdField_d_of_type_Boolean) {
          break label153;
        }
        HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Agtf.a(i, 1);
      this.jdField_a_of_type_Long = l;
      return true;
      label153:
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleGesture", 2, "onSingleTapUp isTouchEffectSupport = " + this.jdField_d_of_type_Boolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agte
 * JD-Core Version:    0.7.0.1
 */