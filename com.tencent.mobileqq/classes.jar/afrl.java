import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.messagesearch.BaseMessageSearchDialog.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.XListView;

public class afrl
  extends Dialog
  implements Handler.Callback
{
  protected int a;
  afss jdField_a_of_type_Afss;
  protected Context a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  bbms jdField_a_of_type_Bbms;
  protected beez a;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected MessageRecord a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow;
  public XListView a;
  boolean jdField_a_of_type_Boolean = false;
  
  public afrl(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    super(paramContext, 16973834);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Beez = new beez(Looper.getMainLooper(), this);
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2131493642);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    e();
  }
  
  private void e()
  {
    View localView;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 1))
    {
      Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
      localView = findViewById(2131303848);
      if (bjeh.b(localActivity)) {
        localView.post(new BaseMessageSearchDialog.1(this, localView, localActivity));
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseMessageSearchDialog", 2, "has no Notch, setPaddingTop 0");
    }
    localView.setPadding(localView.getPaddingLeft(), 0, localView.getPaddingRight(), localView.getPaddingBottom());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void a() {}
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bbms == null) {
      this.jdField_a_of_type_Bbms = new bbms(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131167766));
    }
    this.jdField_a_of_type_Bbms.setCancelable(false);
    this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(false);
    this.jdField_a_of_type_Bbms.c(paramInt);
    this.jdField_a_of_type_Bbms.show();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_Bbms != null) && (this.jdField_a_of_type_Bbms.isShowing())) {
      this.jdField_a_of_type_Bbms.dismiss();
    }
  }
  
  protected void c()
  {
    if (getContext().getResources().getConfiguration().orientation == 2) {
      this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(1, 0L);
    }
  }
  
  protected void d()
  {
    if (isShowing())
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
      localMotionEvent = MotionEvent.obtain(l, l, 1, 0.0F, 0.0F, 0);
      this.jdField_a_of_type_AndroidWidgetEditText.dispatchTouchEvent(localMotionEvent);
      localMotionEvent.recycle();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afrl
 * JD-Core Version:    0.7.0.1
 */