import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class afgr
  extends Observable
  implements affa
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = true;
  private int d;
  
  public afgr(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    if (paramBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "chatPie is null");
      }
    }
    SessionInfo localSessionInfo;
    do
    {
      return false;
      localSessionInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (localSessionInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "sessionInfo is null");
    return false;
    if ((paramBaseChatPie instanceof TroopChatPie)) {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if ((paramBaseChatPie instanceof agps))
    {
      boolean bool4 = bdeu.b(localSessionInfo.jdField_a_of_type_JavaLangString);
      boolean bool5 = bclg.b(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo.jdField_a_of_type_JavaLangString);
      bool2 = bool1;
      if (!bool4)
      {
        bool2 = bool1;
        if (!bool5) {
          bool2 = true;
        }
      }
    }
    if ((paramBaseChatPie instanceof agvf)) {
      bool2 = a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if ((paramBaseChatPie instanceof agsy)) {}
    for (bool1 = bool3;; bool1 = bool2) {
      return bool1;
    }
  }
  
  private boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.ae();
      }
      this.jdField_c_of_type_Boolean = false;
      notifyObservers();
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "onScrollOutScreen");
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 0: 
      return 1;
    }
    return 2;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838256);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "resume button to unread mode");
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie))) {
      a(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    paramInt4 = 0;
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)) {
      return;
    }
    if (paramInt1 == 0)
    {
      this.jdField_b_of_type_Boolean = true;
      label27:
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
        break label235;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
      if (paramInt7 <= 0)
      {
        if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_b_of_type_Int - this.jdField_a_of_type_AndroidViewView.getTop() < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          if (QLog.isColorLevel()) {
            QLog.d("UnreadBackBottomHelper", 2, "scroll to bottom, button gone");
          }
        }
        this.jdField_c_of_type_Int = paramInt1;
        this.d = (paramInt3 - paramInt5 - paramInt1);
        View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localView != null) {
          this.jdField_a_of_type_AndroidViewView = localView;
        }
      }
      if (paramInt1 + paramInt2 >= paramInt3 - paramInt5 - this.d) {
        break label237;
      }
    }
    label235:
    label237:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramInt2 = paramInt4;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramInt2 = paramInt4;
        if (this.jdField_a_of_type_AndroidViewView.getTop() > this.jdField_b_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight()) {
          paramInt2 = 1;
        }
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label242;
      }
      c();
      return;
      this.jdField_b_of_type_Boolean = false;
      break label27;
      break;
    }
    label242:
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if ((paramTextView == null) && (QLog.isColorLevel())) {
        QLog.e("UnreadBackBottomHelper", 1, "button is null");
      }
      this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "attachButton success");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "switch is off. reportType: " + paramString + ", aioType: " + paramInt);
      }
      return;
    }
    azqs.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "state changed from: " + this.jdField_a_of_type_Boolean + " to: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {}
    while (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 0) {
      return false;
    }
    return true;
  }
  
  public int[] a()
  {
    return new int[] { 1 };
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    View localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
    if (localView != null)
    {
      this.jdField_a_of_type_AndroidViewView = localView;
      this.jdField_b_of_type_Int = localView.getTop();
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "firstView != null. top: " + this.jdField_b_of_type_Int);
      }
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "unread count is 0, core button gone");
      }
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramInt < 0);
      this.jdField_a_of_type_Int = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("UnreadBackBottomHelper", 2, "update unread count: " + paramInt);
  }
  
  public void d(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    label228:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("UnreadBackBottomHelper", 2, "delta: " + paramInt);
      }
      if (Math.abs(paramInt) >= 20) {
        if (paramInt > 0)
        {
          if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0)) {
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          }
        }
        else if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_Int == 0) && (!this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
        {
          Object localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
          {
            localObject = (AIOLongShotHelper)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(15);
            if ((localObject != null) && (((AIOLongShotHelper)localObject).a())) {
              paramInt = 1;
            }
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() != 8) || (paramInt != 0)) {
              break label228;
            }
            this.jdField_a_of_type_AndroidWidgetTextView.setText("");
            this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130837738);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
              break;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
            if (localObject == null) {
              break;
            }
            paramInt = a(((SessionInfo)localObject).jdField_a_of_type_Int);
            if (paramInt == -1) {
              break;
            }
            a("0X800AC88", paramInt);
            return;
            paramInt = 0;
            continue;
            paramInt = 0;
          }
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (paramView != null)
      {
        int i = a(paramView.jdField_a_of_type_Int);
        if (i != -1) {
          a("0X800AC89", i);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnreadBackBottomHelper", 2, "core button on click");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afgr
 * JD-Core Version:    0.7.0.1
 */