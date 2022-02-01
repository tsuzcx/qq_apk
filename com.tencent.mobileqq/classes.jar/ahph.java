import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;

public class ahph
  implements ahqq
{
  private aezn jdField_a_of_type_Aezn;
  private ahqs jdField_a_of_type_Ahqs;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ahph(QQAppInterface paramQQAppInterface, ahqs paramahqs, Activity paramActivity, SessionInfo paramSessionInfo, aezn paramaezn)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ahqs = paramahqs;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Aezn = paramaezn;
  }
  
  public int a()
  {
    return 40;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560935, null);
    ((TextView)paramVarArgs.findViewById(2131374036)).setText(2131691645);
    ((ImageView)paramVarArgs.findViewById(2131374034)).setImageResource(2130849770);
    paramVarArgs.findViewById(2131374033).setOnClickListener(new ahpi(this));
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscActiveTipsBar", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV =====>");
    }
    for (;;)
    {
      int i;
      int j;
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) {
          return;
        }
        if (aqlq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, 1)) {
          return;
        }
        paramVarArgs = this.jdField_a_of_type_Aezn.a();
        if (paramVarArgs == null) {
          return;
        }
        if (paramVarArgs.size() < 10)
        {
          paramVarArgs = "msgList size < 10, size = " + paramVarArgs.size();
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DiscActiveTipsBar", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        long l1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin).longValue();
        paramInt = mum.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a(paramInt, l1)) {
          return;
        }
        Object localObject2 = "voice_disc_chat_freq_bar_show_count" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        Object localObject1 = BaseApplication.getContext().getSharedPreferences("free_call", 0);
        paramInt = ((SharedPreferences)localObject1).getInt((String)localObject2, 0);
        if (paramInt >= 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DiscActiveTipsBar", 2, "discChatFreqBarShowCount : " + paramInt);
        }
        l1 = bbko.a() * 1000L;
        if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
          this.jdField_a_of_type_AndroidTextFormatTime = new Time();
        }
        this.jdField_a_of_type_AndroidTextFormatTime.set(l1);
        paramInt = this.jdField_a_of_type_AndroidTextFormatTime.year;
        i = this.jdField_a_of_type_AndroidTextFormatTime.month;
        j = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
        this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 20, j, i, paramInt);
        long l2 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        this.jdField_a_of_type_AndroidTextFormatTime.set(0, 0, 23, j, i, paramInt);
        long l3 = this.jdField_a_of_type_AndroidTextFormatTime.toMillis(false);
        if ((l1 < l2) || (l1 > l3))
        {
          paramVarArgs = "current time not in " + 20 + "-" + 23;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("DiscActiveTipsBar", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + paramVarArgs);
          return;
        }
        localObject2 = ((SharedPreferences)localObject1).getString("voice_disc_chat_freq_bar_show_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
        if (QLog.isColorLevel())
        {
          String str = paramInt + "-" + i + "-" + j;
          QLog.d("DiscActiveTipsBar", 2, "currDate is:" + str + ",curr hour is:" + this.jdField_a_of_type_AndroidTextFormatTime.hour + ",discPttFreqTipMsgInsertTime is:" + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.jdField_a_of_type_AndroidTextFormatTime.set(Long.parseLong((String)localObject2));
          int k = this.jdField_a_of_type_AndroidTextFormatTime.year;
          int m = this.jdField_a_of_type_AndroidTextFormatTime.month;
          int n = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          if ((paramInt == k) && (i == m) && (j == n)) {
            return;
          }
        }
        localObject1 = ((SharedPreferences)localObject1).getString("start_group_audio_time" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (l1 - Long.parseLong((String)localObject1) <= 600000L)) {
          return;
        }
        l1 = (l1 - 600000L) / 1000L;
        i = paramVarArgs.size();
        paramInt = 0;
        localObject1 = new HashSet();
        j = i - 1;
        if (j >= 0)
        {
          localObject2 = (ChatMessage)paramVarArgs.get(j);
          i = paramInt;
          if (((ChatMessage)localObject2).time >= l1)
          {
            i = paramInt;
            if (abwz.p(((ChatMessage)localObject2).msgtype))
            {
              i = paramInt;
              if (((ChatMessage)localObject2).extraflag == 0)
              {
                i = paramInt + 1;
                ((HashSet)localObject1).add(((ChatMessage)localObject2).senderuin);
              }
            }
          }
        }
        else
        {
          i = ((HashSet)localObject1).size();
          if (QLog.isColorLevel()) {
            QLog.d("DiscActiveTipsBar", 2, "basicMsgNum : " + paramInt + ", msgUinNum : " + i);
          }
          return;
        }
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscActiveTipsBar", 2, "onAIOEvent() : TYPE_ON_MSG_SENT_RECV <=====, step is:" + "");
        }
      }
      j -= 1;
      paramInt = i;
    }
  }
  
  public int[] a()
  {
    return new int[] { 2000 };
  }
  
  public int b()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahph
 * JD-Core Version:    0.7.0.1
 */