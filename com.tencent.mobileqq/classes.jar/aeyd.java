import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aeyd
  extends Handler
{
  public aeyd(PressToChangeVoicePanel paramPressToChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @TargetApi(11)
  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1001: 
        this.a.b();
        return;
      }
    }
    catch (Exception paramMessage)
    {
      QLog.e("PressToChangeVoicePanel", 1, "uiHandler Error:" + paramMessage.getMessage());
      return;
    }
    this.a.c();
    return;
    Object localObject1 = (HashMap)paramMessage.obj;
    paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
    localObject1 = (QQRecorder.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
    this.a.g();
    this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(paramMessage, (QQRecorder.RecorderParam)localObject1);
    return;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b((String)paramMessage.obj, null);
    this.a.g();
    return;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("changevoice", 2, "recored end callback , pie is null !!");
      }
    }
    else
    {
      localObject1 = (HashMap)paramMessage.obj;
      paramMessage = (String)((HashMap)localObject1).get(Integer.valueOf(0));
      localObject1 = (QQRecorder.RecorderParam)((HashMap)localObject1).get(Integer.valueOf(1));
      this.a.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(paramMessage, (QQRecorder.RecorderParam)localObject1);
      awym.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a, (QQRecorder.RecorderParam)localObject1);
      Object localObject2 = (ListenChangeVoicePanel)this.a.f.findViewById(2131369563);
      ((ListenChangeVoicePanel)localObject2).g();
      ((ListenChangeVoicePanel)localObject2).setVisibility(0);
      ((ListenChangeVoicePanel)localObject2).setAudioPath(paramMessage, this.a.jdField_a_of_type_Double, (QQRecorder.RecorderParam)localObject1);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(4);
      this.a.setVisibility(8);
      this.a.setClickable(true);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agti)) {
        nrt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005850", "0X8005850", 0, 0, "", "", Double.toString(this.a.jdField_a_of_type_Double), "", false);
      }
      paramMessage = (ViewGroup)((ListenChangeVoicePanel)localObject2).findViewById(2131364107);
      if (bhtb.e())
      {
        localObject1 = ObjectAnimator.ofFloat(paramMessage, "scaleX", new float[] { 0.4F, 1.0F });
        localObject2 = ObjectAnimator.ofFloat(paramMessage, "scaleY", new float[] { 0.4F, 1.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramMessage, "alpha", new float[] { 0.4F, 1.0F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.play((Animator)localObject1).with((Animator)localObject2).with(localObjectAnimator);
        localAnimatorSet.setDuration(300L);
        localAnimatorSet.addListener(new aeye(this, paramMessage));
        localAnimatorSet.start();
        return;
      }
      paramMessage.setVisibility(0);
      return;
      this.a.b(paramMessage.arg1);
      PressToChangeVoicePanel.a(this.a).setText(AudioPanel.a(((Double)paramMessage.obj).doubleValue()));
      return;
      this.a.g();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyd
 * JD-Core Version:    0.7.0.1
 */