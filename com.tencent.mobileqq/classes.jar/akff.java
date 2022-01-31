import android.content.Context;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.ContextMenuTextView;
import com.tencent.widget.BubblePopupWindow;

public class akff
  implements View.OnLongClickListener, View.OnTouchListener
{
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  
  private akff(ContextMenuTextView paramContextMenuTextView) {}
  
  protected void a(View paramView)
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 3, 0.0F, 0.0F, 0);
    paramView.dispatchTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.setBackgroundColor(-1);
  }
  
  public boolean onLongClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.setBackgroundColor(-7829368);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b()))
    {
      a(paramView);
      return false;
    }
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(2131375342, ContextMenuTextView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView).getString(2131435076), 2130838301);
    this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = BubbleContextMenu.a(paramView, (int)this.jdField_a_of_type_AndroidGraphicsPointF.x, (int)this.jdField_a_of_type_AndroidGraphicsPointF.y, localQQCustomMenu, this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new akfe(this.jdField_a_of_type_ComTencentMobileqqWidgetContextMenuTextView));
    }
    a(paramView);
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPointF.x = paramMotionEvent.getRawX();
      this.jdField_a_of_type_AndroidGraphicsPointF.y = paramMotionEvent.getRawY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akff
 * JD-Core Version:    0.7.0.1
 */