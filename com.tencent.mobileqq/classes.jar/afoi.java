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

public class afoi
  implements afrb, afrc, Handler.Callback, View.OnClickListener
{
  private aqbu jdField_a_of_type_Aqbu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private EmoticonGuideBubbleView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public afoi(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this);
  }
  
  private void a(aqbu paramaqbu)
  {
    if (paramaqbu == null) {}
    String str;
    boolean bool;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!a(paramaqbu)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmoPanel() == null));
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "realShowGuideBubble start.");
      }
      this.jdField_a_of_type_Aqbu = paramaqbu;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("aio_emoticon_guide.helper", 2, "showGuideBubble  mGuideBubbleView is new create.");
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView = new EmoticonGuideBubbleView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.mContext);
      }
      str = paramaqbu.a.a;
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, false, null)) {
        str = paramaqbu.a.b;
      }
      bool = ThemeUtil.isNowThemeIsSimple(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, false, null);
    } while (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.showGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.panelicons, str, paramaqbu.a.e, paramaqbu.a.f, bool));
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800AD4C", "0X800AD4C", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.setOnClickListener(this);
    bfyz.a("key_show_emoticon_guide", Boolean.valueOf(false));
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private boolean a(aqbu paramaqbu)
  {
    if (paramaqbu == null) {
      return false;
    }
    if ((((Boolean)bfyz.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) && (paramaqbu.a.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a()
  {
    if (!((Boolean)bfyz.a("key_show_emoticon_guide", Boolean.valueOf(true))).booleanValue()) {
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
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("aio_emoticon_guide.helper", 2, "removeGuideBubble ");
      }
      this.jdField_a_of_type_Aqbu = null;
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
    a((aqbu)paramMessage.obj);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getEmoPanel() == null) || (this.jdField_a_of_type_Aqbu == null)) {}
    label164:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGuideBubbleView.removeGuideBubble(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getContent());
      int i = this.jdField_a_of_type_Aqbu.a.c;
      int k = this.jdField_a_of_type_Aqbu.a.d;
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
          bcef.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "dc00898", "", "", "0X800AD4D", "0X800AD4D", 0, 0, "", "", "", "");
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
 * Qualified Name:     afoi
 * JD-Core Version:    0.7.0.1
 */