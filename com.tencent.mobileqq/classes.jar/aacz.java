import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class aacz
  implements View.OnLayoutChangeListener
{
  public aacz(BaseChatPie paramBaseChatPie) {}
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return (this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (paramInt2 - paramInt1 != paramInt4 - paramInt3);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onLayoutChange() called with: v = [" + paramView + "], left = [" + paramInt1 + "], top = [" + paramInt2 + "], right = [" + paramInt3 + "], bottom = [" + paramInt4 + "], oldLeft = [" + paramInt5 + "], oldTop = [" + paramInt6 + "], oldRight = [" + paramInt7 + "], oldBottom = [" + paramInt8 + "], scrollY=" + this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY() + ", diff=" + (paramInt6 - paramInt2));
    }
    paramInt3 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getTop();
    paramView = (acyp)this.a.a(23);
    if ((paramView != null) && (paramView.b()))
    {
      paramInt1 = paramView.a();
      paramInt3 += paramInt1;
    }
    for (;;)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() != paramInt3))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onLayoutChange() update list.paddingBottom from " + this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + paramInt3);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), paramInt3);
      }
      if (!a(paramInt2, paramInt4, paramInt6, paramInt8)) {
        break label341;
      }
      label341:
      while (this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() <= 0) {
        return;
      }
      paramInt7 = paramInt6 - paramInt1;
      paramInt5 = -1;
      paramInt6 = 0;
      paramInt3 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
      for (;;)
      {
        paramInt4 = paramInt6;
        paramInt2 = paramInt5;
        if (paramInt3 >= 0)
        {
          paramView = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(paramInt3);
          if ((paramInt7 > paramView.getTop()) && (paramInt7 <= paramView.getBottom()))
          {
            paramInt2 = this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() + paramInt3;
            paramInt4 = paramInt7 - paramView.getBottom();
          }
        }
        else
        {
          if (paramInt2 == -1) {
            break;
          }
          this.a.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(new aada(this, paramInt2, paramInt1 + paramInt4));
          return;
        }
        paramInt3 -= 1;
      }
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aacz
 * JD-Core Version:    0.7.0.1
 */