import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class agso
  implements agvb, agvc, Handler.Callback, View.OnClickListener
{
  private arib jdField_a_of_type_Arib;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public agso(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this);
  }
  
  private void a(arib paramarib)
  {
    if (paramarib == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!a(paramarib)) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null));
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_Arib = paramarib;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext);
      }
      str = paramarib.a.a;
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        str = paramarib.a.b;
      }
      bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
    } while (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, str, paramarib.a.e, paramarib.a.f, bool));
    bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.setOnClickListener(this);
    bhsi.a("key_show_emoticon_guide", Boolean.valueOf(false));
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean a(arib paramarib)
  {
    if (paramarib == null) {
      return false;
    }
    if ((((Boolean)bhsi.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) && (paramarib.a.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    if (!((Boolean)bhsi.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new AIOEmoticonGuideHelper.1(this));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    b();
  }
  
  public int[] a()
  {
    return new int[] { 9, 13 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_Arib = null;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      b();
    }
    while (paramMessage.what != 2) {
      return true;
    }
    a((arib)paramMessage.obj);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Arib == null)) {}
    label164:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
      int i = this.jdField_a_of_type_Arib.a.c;
      int k = this.jdField_a_of_type_Arib.a.d;
      if (k == 1)
      {
        i = asle.b(i);
        if (!asle.c(i)) {}
      }
      else
      {
        for (;;)
        {
          if (i == -1) {
            break label164;
          }
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a(k, i);
          break;
          if (k == 2)
          {
            int j = askx.b(i);
            i = j;
            if (askx.a(j)) {
              continue;
            }
            break;
          }
          i = -1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agso
 * JD-Core Version:    0.7.0.1
 */