import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class agfm
  implements agim, agin, Handler.Callback, View.OnClickListener
{
  private arex jdField_a_of_type_Arex;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public agfm(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this);
  }
  
  private void a(arex paramarex)
  {
    if (paramarex == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!a(paramarex)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmoPanel() == null));
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_Arex = paramarex;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext);
      }
      str = paramarex.a.a;
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, false, null)) {
        str = paramarex.a.b;
      }
      bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, false, null);
    } while (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.showGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons, str, paramarex.a.e, paramarex.a.f, bool));
    bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.setOnClickListener(this);
    bhhr.a("key_show_emoticon_guide", Boolean.valueOf(false));
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean a(arex paramarex)
  {
    if (paramarex == null) {
      return false;
    }
    if ((((Boolean)bhhr.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) && (paramarex.a.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    if (!((Boolean)bhhr.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
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
    return new int[] { 10, 14 };
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_Arex = null;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.removeGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent());
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
    a((arex)paramMessage.obj);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmoPanel() == null) || (this.jdField_a_of_type_Arex == null)) {}
    label164:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.removeGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent());
      int i = this.jdField_a_of_type_Arex.a.c;
      int k = this.jdField_a_of_type_Arex.a.d;
      if (k == 1)
      {
        i = QQSysFaceUtil.convertToLocal(i);
        if (!QQSysFaceUtil.isValidFaceId(i)) {}
      }
      else
      {
        for (;;)
        {
          if (i == -1) {
            break label164;
          }
          bdla.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmoPanel().switchSystemEmojiTabLocationPos(k, i);
          break;
          if (k == 2)
          {
            int j = QQEmojiUtil.getEmojiLocalId(i);
            i = j;
            if (QQEmojiUtil.isValidEmojiId(j)) {
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
 * Qualified Name:     agfm
 * JD-Core Version:    0.7.0.1
 */