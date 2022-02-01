import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper.2;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel;
import com.tencent.mobileqq.emoticonview.relateemo.RelatedEmotionPanel.IAIORelatedEmotionExpandHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

public class afpc
  implements afrb, afrc, RelatedEmotionPanel.IAIORelatedEmotionExpandHelper
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected RelatedEmotionPanel a;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d;
  
  public afpc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.mContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.d = ((int)(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels * 0.6D));
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = null;
  }
  
  public int a()
  {
    int i = 0;
    if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
      i = ViewUtils.dip2px(15.0F);
    }
    return i + (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons.getHeight() + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getHeight() - this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar.getPaddingTop());
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
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().a(false);
        return;
      }
    } while (this.jdField_a_of_type_Int != 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().a(false);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 6) {
      ThreadManager.getFileThreadHandler().post(new AIORelatedEmotionHelper.1(this));
    }
    while (paramInt != 13) {
      return;
    }
    b();
  }
  
  public void a(ChatMessage paramChatMessage, URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORelatedEmotionHelper", 4, " showSearchRelatedEmotionPanel ");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mInputBar == null)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = ((RelatedEmotionPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558639, null));
      }
      this.c = ((Integer)bfyz.a(BaseApplication.getContext(), "", "sp_key_input_height", Integer.valueOf(0))).intValue();
      if (this.c == 0) {
        this.c = ((int)(XPanelContainer.b() * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
      }
      this.b = XPanelContainer.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel.init(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this);
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurrentPanel();
      int i = this.d;
      int j = a();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel.showEmotionSearchWindow(paramChatMessage, paramURLDrawable, i + j);
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().a(37);
        return;
      }
    } while (this.jdField_a_of_type_Int != 0);
    XPanelContainer.jdField_a_of_type_Int = this.d;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().postDelayed(new AIORelatedEmotionHelper.2(this), 150L);
  }
  
  public int[] a()
  {
    return new int[] { 13, 6 };
  }
  
  public void onClosePanel()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewRelateemoRelatedEmotionPanel = null;
  }
  
  public void updatePanelDistance(float paramFloat)
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
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().requestLayout();
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
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().requestLayout();
        }
        else if (i <= this.c)
        {
          if (XPanelContainer.jdField_a_of_type_Int != this.c)
          {
            XPanelContainer.jdField_a_of_type_Int = this.c;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().requestLayout();
          }
        }
        else
        {
          XPanelContainer.jdField_a_of_type_Int = i;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getRoot().requestLayout();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpc
 * JD-Core Version:    0.7.0.1
 */