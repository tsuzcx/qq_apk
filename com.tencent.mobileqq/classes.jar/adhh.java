import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.7.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class adhh
  extends akav
{
  adhh(adha paramadha) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = adha.a(this.a).a().e();
    adha.a(this.a).a().removeMessages(267387140);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject2 = paramList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ChatMessage)((Iterator)localObject2).next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + ((List)localObject1).size());
    }
    if (paramBoolean1)
    {
      adha.a(this.a).a().sendEmptyMessage(267387139);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        asty.a().a((List)localObject1);
        aaod.a((List)localObject1);
        aaod.b((List)localObject1);
        aegr.a((MessageRecord)((List)localObject1).get(0));
        localObject2 = (ChatMessage)((List)localObject1).get(0);
        adha.a(this.a).a().a((ChatMessage)localObject2);
        if (!(localObject2 instanceof MessageForPtt)) {
          break label407;
        }
        localObject1 = (MessageForPtt)((List)localObject1).get(0);
        localObject2 = MediaPlayerManager.a(adha.a(this.a)).a();
        if ((localObject2 == localObject1) || (((localObject2 instanceof MessageForPtt)) && (((ChatMessage)localObject2).frienduin != null) && (((ChatMessage)localObject2).frienduin.equals(((MessageForPtt)localObject1).frienduin)) && (((ChatMessage)localObject2).uniseq == ((MessageForPtt)localObject1).uniseq))) {
          MediaPlayerManager.a(adha.a(this.a)).a(true);
        }
      }
      if ((paramBoolean2) && (bool)) {
        axqw.b(adha.a(this.a), "CliOper", "", "", "0X80056B2", "0X80056B2", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      for (;;)
      {
        super.a(paramBoolean1, paramList, paramBoolean2);
        return;
        label407:
        if ((localObject2 instanceof MessageForShortVideo))
        {
          adha.a(this.a).e(131072);
          adzs.a(adha.a(this.a).a);
          break;
        }
        if ((localObject2 instanceof MessageForStructing))
        {
          localObject1 = ((MessageForStructing)((List)localObject1).get(0)).structingMsg;
          if ((localObject1 == null) || (!(localObject1 instanceof StructMsgForAudioShare)) || (!QQPlayerService.a((StructMsgForAudioShare)localObject1))) {
            break;
          }
          QQPlayerService.c(adha.a(this.a));
          break;
        }
        if ((localObject2 instanceof MessageForApollo))
        {
          localObject1 = (MessageForApollo)((List)localObject1).get(0);
          if (localObject1 == null) {
            break;
          }
          ajfa.a(((MessageForApollo)localObject1).uniseq, adha.a(this.a), "withdraw_msg");
          if (((MessageForApollo)localObject1).mApolloMessage == null) {
            break;
          }
          VipUtils.a(adha.a(this.a), "cmshow", "Apollo", "withdraw_success", ApolloUtil.b(adha.a(this.a).jdField_a_of_type_Int), 0, new String[] { Integer.toString(((MessageForApollo)localObject1).mApolloMessage.id) });
          break;
        }
        localObject1 = ((ChatMessage)localObject2).getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isColorLevel()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + (String)localObject1 + "],targetId[" + ((ChatMessage)localObject2).msgUid + "], hashCode:" + localObject2.hashCode());
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        try
        {
          long l = Long.parseLong((String)localObject1);
          adha.a(this.a).a().b(((ChatMessage)localObject2).frienduin, ((ChatMessage)localObject2).istroop, l, true);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          QLog.e("AIORevokeMsgHelper", 1, localException.toString());
        }
      }
      break;
      adha.a(this.a).a().sendEmptyMessage(267387140);
    }
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((adha.a(this.a) == null) || (adha.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    ((airv)adha.a(this.a).getManager(211)).a(3, adha.a(this.a).jdField_a_of_type_JavaLangString, adha.a(this.a).jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    if ((adha.a(this.a).jdField_a_of_type_Int == 0) || (adha.a(this.a).jdField_a_of_type_Int == 3000) || (adha.a(this.a).jdField_a_of_type_Int == 1)) {
      adha.a(this.a).a().post(new AIORevokeMsgHelper.7.1(this, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhh
 * JD-Core Version:    0.7.0.1
 */