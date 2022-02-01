import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.GetAioListCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class abyy
  implements QQMessageFacade.GetAioListCallback
{
  private SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy", Locale.CHINESE);
  
  private void a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQMessageFacade paramQQMessageFacade)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PaiYiPaiGetAioList", 2, "addGuideTips() called with: anchorMsg = [" + paramMessageForUniteGrayTip + "], facade = [" + paramQQMessageFacade + "]");
    }
    paramQQMessageFacade = paramQQMessageFacade.getApp();
    Object localObject1 = paramQQMessageFacade.getApp().getString(2131694292);
    Object localObject2 = paramQQMessageFacade.getApp().getString(2131694291);
    localObject2 = new aucf(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.senderuin, (String)localObject1 + (String)localObject2, paramMessageForUniteGrayTip.istroop, -5020, 656396, bbko.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 64);
    ((aucf)localObject2).a(0, ((String)localObject1).length(), localBundle);
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQMessageFacade, (aucf)localObject2);
    ((MessageForUniteGrayTip)localObject1).shmsgseq = paramMessageForUniteGrayTip.shmsgseq;
    aucg.a(paramQQMessageFacade, (MessageForUniteGrayTip)localObject1);
  }
  
  private boolean a(QQMessageFacade paramQQMessageFacade)
  {
    for (;;)
    {
      boolean bool;
      long l1;
      try
      {
        paramQQMessageFacade = paramQQMessageFacade.getApp();
        bool = ((afhv)paramQQMessageFacade.getManager(388)).a();
        if (bool)
        {
          bool = false;
          return bool;
        }
        paramQQMessageFacade = paramQQMessageFacade.getCurrentAccountUin();
        paramQQMessageFacade = BaseApplicationImpl.getApplication().getSharedPreferences("pai_yi_pai_add_guide_tip_info" + paramQQMessageFacade, 0);
        l1 = paramQQMessageFacade.getLong("totalTimes", 0L);
        if (!QLog.isColorLevel()) {
          break label245;
        }
        QLog.d("PaiYiPaiGetAioList", 2, "shouldAddGuideTip() called with: totalTimes = [" + l1 + "]");
      }
      finally {}
      Object localObject = new Date();
      localObject = this.a.format((Date)localObject);
      long l2 = paramQQMessageFacade.getLong((String)localObject, 0L);
      if (QLog.isColorLevel()) {
        QLog.d("PaiYiPaiGetAioList", 2, "shouldAddGuideTip() called with: times = [" + l2 + "] in " + (String)localObject);
      }
      if (l2 == 0L)
      {
        paramQQMessageFacade = paramQQMessageFacade.edit();
        paramQQMessageFacade.putLong((String)localObject, l2 + 1L);
        paramQQMessageFacade.putLong("totalTimes", l1 + 1L);
        paramQQMessageFacade.apply();
        bool = true;
      }
      else
      {
        bool = false;
        continue;
        label245:
        if (l1 >= 3L) {
          bool = false;
        }
      }
    }
  }
  
  public void onGetAioList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<ChatMessage> paramList, QQMessageFacade paramQQMessageFacade)
  {
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (ChatMessage)paramString.next();
      if ((paramList instanceof MessageForUniteGrayTip))
      {
        paramList = (MessageForUniteGrayTip)paramList;
        if ((TextUtils.equals(paramList.getExtInfoFromExtStr("uint64_busi_type"), "12")) && (TextUtils.equals(paramList.getExtInfoFromExtStr("uint64_busi_id"), "1061")) && (a(paramQQMessageFacade)))
        {
          a(paramList, paramQQMessageFacade);
          if (paramList.istroop == 0) {
            paramInt1 = 1;
          }
          for (;;)
          {
            bcef.b(null, "dc00898", "", "", "0X800B3A3", "0X800B3A3", paramInt1, 0, "", "", "", "");
            break;
            if (paramList.istroop == 1) {
              paramInt1 = 2;
            } else {
              paramInt1 = 10;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyy
 * JD-Core Version:    0.7.0.1
 */