import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class agem
  extends Handler
{
  public agem(ListenChangeVoicePanel paramListenChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    case 102: 
    default: 
    case 101: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                ListenChangeVoicePanel.a(this.a, -1);
                this.a.jdField_a_of_type_Agej.b = 0;
                this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = null;
                synchronized (this.a.b)
                {
                  this.a.jdField_a_of_type_Agej.a = this.a.b;
                  this.a.jdField_a_of_type_Agej.notifyDataSetChanged();
                  return;
                }
              } while ((???.obj == null) || (!(???.obj instanceof Bundle)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null));
              ??? = (Bundle)???.obj;
            } while (??? == null);
            this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(???.getInt("progress"), ???.getInt("playTime"), ???.getInt("level"));
            return;
          } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
          return;
          if (ListenChangeVoicePanel.a(this.a).get() != null) {
            QQToast.a(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), "播放变音error", 0);
          }
        } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
        return;
      } while ((ListenChangeVoicePanel.a(this.a).get() == null) || (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
      bhkp.a(((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).getApp(), ListenChangeVoicePanel.a(this.a), PressToChangeVoicePanel.a, this.a);
      int k = (int)ListenChangeVoicePanel.a(this.a);
      String str;
      QQRecorder.RecorderParam localRecorderParam;
      if (!azub.a((QQAppInterface)ListenChangeVoicePanel.a(this.a).get()).a((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), ListenChangeVoicePanel.a(this.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "presend not hit, do origin logic");
        }
        ??? = (BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
        str = ListenChangeVoicePanel.a(this.a);
        localRecorderParam = ListenChangeVoicePanel.a(this.a);
        if (ListenChangeVoicePanel.a(this.a) <= 0) {
          break label677;
        }
      }
      label677:
      for (int i = 1;; i = 0)
      {
        ???.a(str, 4, 0, localRecorderParam, i, false, 0);
        ((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).b(ListenChangeVoicePanel.a(this.a), null);
        if (ListenChangeVoicePanel.jdField_a_of_type_Aztn != null)
        {
          ListenChangeVoicePanel.jdField_a_of_type_Aztn.a((QQAppInterface)ListenChangeVoicePanel.a(this.a).get(), ListenChangeVoicePanel.a(this.a));
          if (ListenChangeVoicePanel.a(this.a) > 0) {
            bcst.b((QQAppInterface)ListenChangeVoicePanel.a(this.a).get(), "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, "" + ((BaseChatPie)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).a.a, "" + ListenChangeVoicePanel.a(this.a), "", "");
          }
        }
        this.a.g();
        int j = ListenChangeVoicePanel.b(this.a);
        i = j;
        if (this.a.jdField_a_of_type_Boolean) {
          i = j + 10;
        }
        j = ListenChangeVoicePanel.a(this.a);
        int m = ListenChangeVoicePanel.c(this.a);
        this.a.a(j, m, k, i);
        return;
      }
    }
    this.a.a(???.arg1, ???.arg2, ???.obj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agem
 * JD-Core Version:    0.7.0.1
 */