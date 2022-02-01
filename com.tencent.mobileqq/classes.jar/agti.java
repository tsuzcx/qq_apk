import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper.2;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class agti
  implements agvb, agvc, astn
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  protected RelatedEmotionPanel a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d;
  
  public agti(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.d = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels * 0.6D));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    b();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingTop();
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = null;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel == null) {}
    label186:
    for (;;)
    {
      return;
      int j = (int)(this.d - paramFloat);
      int i;
      if (j >= this.d)
      {
        i = this.d;
        if (!this.jdField_a_of_type_Boolean) {
          break label101;
        }
        if ((this.jdField_a_of_type_Int != 0) && (i >= this.b) && (XPanelContainer.jdField_a_of_type_Int <= this.d))
        {
          XPanelContainer.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().requestLayout();
        }
      }
      for (;;)
      {
        if (i < this.d) {
          break label186;
        }
        this.jdField_a_of_type_Boolean = false;
        return;
        i = j;
        if (j > 0) {
          break;
        }
        i = 0;
        break;
        label101:
        if ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1))
        {
          XPanelContainer.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().requestLayout();
        }
        else if (i <= this.c)
        {
          if (XPanelContainer.jdField_a_of_type_Int != this.c)
          {
            XPanelContainer.jdField_a_of_type_Int = this.c;
            this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().requestLayout();
          }
        }
        else
        {
          XPanelContainer.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().requestLayout();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 6) {
      ThreadManager.getFileThreadHandler().post(new AIORelatedEmotionHelper.1(this));
    }
    while (paramInt != 13) {
      return;
    }
    c();
  }
  
  public void a(ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " showSearchRelatedEmotionPanel ");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = ((RelatedEmotionPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558635, null));
      }
      this.c = ((Integer)bhsi.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
      if (this.c == 0) {
        this.c = ((int)(XPanelContainer.b() * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      }
      this.b = XPanelContainer.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.g();
      int i = this.d;
      int j = a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel.a(paramChatMessage, paramURLDrawable, i + j);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(37);
        return;
      }
    } while (this.jdField_a_of_type_Int != 0);
    XPanelContainer.jdField_a_of_type_Int = this.d;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().postDelayed(new AIORelatedEmotionHelper.2(this), 150L);
  }
  
  public int[] a()
  {
    return new int[] { 13, 6 };
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " resetLastStatus ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel == null) {}
    do
    {
      return;
      if ((this.b >= this.d) || (this.b <= this.c)) {
        this.b = this.c;
      }
      XPanelContainer.jdField_a_of_type_Int = this.b;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(false);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agti
 * JD-Core Version:    0.7.0.1
 */