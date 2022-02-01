import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips.1;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aikv
  implements aikq
{
  private volatile long jdField_a_of_type_Long = -1L;
  private afqz jdField_a_of_type_Afqz;
  private ailr jdField_a_of_type_Ailr;
  private Time jdField_a_of_type_AndroidTextFormatTime;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final String[] jdField_a_of_type_ArrayOfJavaLangString = { anvx.a(2131704998), anvx.a(2131704999), anvx.a(2131705000) };
  
  public aikv(QQAppInterface paramQQAppInterface, ailr paramailr, Activity paramActivity, SessionInfo paramSessionInfo, afqz paramafqz)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Ailr = paramailr;
    this.jdField_a_of_type_Afqz = paramafqz;
  }
  
  private void a(ChatMessage paramChatMessage)
  {
    boolean bool = a(paramChatMessage);
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "detect : matchKeywords=" + bool);
    }
    SharedPreferences localSharedPreferences;
    long l1;
    if (bool)
    {
      paramChatMessage = "key_hongbao_keyword_gray_tips" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localSharedPreferences = BaseApplication.getContext().getSharedPreferences("free_call", 0);
      String str = localSharedPreferences.getString(paramChatMessage, "");
      l1 = bcrg.a() * 1000L;
      if (TextUtils.isEmpty(str)) {
        break label303;
      }
      long l2 = Long.parseLong(str);
      this.jdField_a_of_type_AndroidTextFormatTime.set(l2);
      int i = this.jdField_a_of_type_AndroidTextFormatTime.year;
      int j = this.jdField_a_of_type_AndroidTextFormatTime.month;
      int k = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
      int m = this.jdField_a_of_type_AndroidTextFormatTime.hour;
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "lastShowDate :" + i + " - " + (j + 1) + " - " + k + " - " + m);
      }
      if (l1 - l2 > 86400000L) {
        break label249;
      }
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "has show in a day, just return;");
      }
    }
    label249:
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips show time interval > 1day, can show.");
        }
      } while (!this.jdField_a_of_type_Ailr.a(this, new Object[0]));
      localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("HongbaoKeywordGrayTips", 2, "GrayTips has never been shown, can show.");
      }
    } while (!this.jdField_a_of_type_Ailr.a(this, new Object[0]));
    label303:
    localSharedPreferences.edit().putString(paramChatMessage, String.valueOf(l1)).commit();
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (!(paramChatMessage instanceof MessageForText))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("HongbaoKeywordGrayTips", 2, "match : not MessageForText");
        bool2 = bool1;
      }
      return bool2;
    }
    bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (!TextUtils.isEmpty(paramChatMessage.msg))
    {
      arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        String str = arrayOfString[i];
        if (paramChatMessage.msg.contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        bool2 = bool1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("HongbaoKeywordGrayTips", 2, "match : ret=" + bool1);
        return bool1;
      }
      i += 1;
    }
  }
  
  public MessageRecord a(Object... paramVarArgs)
  {
    paramVarArgs = bcsa.a(-1045);
    long l = bcrg.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramVarArgs.init(str, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, str, "", l, -1045, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, l);
    paramVarArgs.isread = true;
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int j = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1)) {}
    label104:
    long l;
    int i;
    Object localObject;
    label204:
    label355:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 1) {
              break;
            }
            paramVarArgs = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          } while ((paramVarArgs != null) && (paramVarArgs.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin)));
        } while ((paramInt != 1000) && (paramInt != 1001));
        if (paramInt == 1000)
        {
          paramInt = 1;
          l = bcrg.a();
          if (this.jdField_a_of_type_AndroidTextFormatTime == null) {
            this.jdField_a_of_type_AndroidTextFormatTime = new Time();
          }
          this.jdField_a_of_type_AndroidTextFormatTime.set(l * 1000L);
          i = this.jdField_a_of_type_AndroidTextFormatTime.year;
          int k = this.jdField_a_of_type_AndroidTextFormatTime.month + 1;
          int m = this.jdField_a_of_type_AndroidTextFormatTime.monthDay;
          int n = this.jdField_a_of_type_AndroidTextFormatTime.hour;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("onAIOEvent() :");
            if (paramInt == 0) {
              break label311;
            }
            paramVarArgs = " TYPE_ON_SHOW ";
            QLog.d("HongbaoKeywordGrayTips", 2, paramVarArgs + ", curDate :" + i + " - " + k + " - " + m + " - " + n);
          }
          if ((i != 2015) || (k != 2) || (m > 21) || (m < 18)) {
            break label317;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label322;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HongbaoKeywordGrayTips", 2, "time not match, just return");
          return;
          paramInt = 0;
          break label104;
          paramVarArgs = " TYPE_ON_MSG_SENT_RECV";
          break label204;
        }
        if (paramInt != 0)
        {
          ThreadManager.getSubThreadHandler().post(new HongbaoKeywordGrayTips.1(this));
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType != 0) {
          break;
        }
        paramInt = j;
        l = this.jdField_a_of_type_Long;
        paramVarArgs = this.jdField_a_of_type_Afqz.a();
        i = paramVarArgs.size();
      } while (i <= 0);
      i -= 1;
      if (i < 0) {
        break;
      }
      localObject = (ChatMessage)paramVarArgs.get(i);
      if (paramInt == 0) {
        break label504;
      }
    } while (((ChatMessage)localObject).time <= l);
    label311:
    label317:
    label322:
    if (QLog.isColorLevel()) {
      QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
    }
    label384:
    if ((((ChatMessage)localObject).isSendFromLocal()) && (((ChatMessage)localObject).extraflag != 0)) {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : msg send not success");
      }
    }
    for (;;)
    {
      i -= 1;
      break label384;
      break;
      paramInt = 0;
      break label355;
      a((ChatMessage)localObject);
      if (((ChatMessage)localObject).time > this.jdField_a_of_type_Long)
      {
        this.jdField_a_of_type_Long = ((ChatMessage)localObject).time;
        continue;
        label504:
        if (((ChatMessage)localObject).shmsgseq <= l) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("HongbaoKeywordGrayTips", 2, "TYPE_ON_MSG_SENT_RECV : new message =====>");
        }
        a((ChatMessage)localObject);
        if (((ChatMessage)localObject).shmsgseq > this.jdField_a_of_type_Long) {
          this.jdField_a_of_type_Long = ((ChatMessage)localObject).shmsgseq;
        }
      }
    }
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 1004;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aikv
 * JD-Core Version:    0.7.0.1
 */