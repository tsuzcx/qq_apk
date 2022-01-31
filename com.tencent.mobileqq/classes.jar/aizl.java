import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView;
import com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyRedPacketAnimMsg.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aizl
  implements bcgf
{
  public WindowManager a;
  public SpecifyGiftView a;
  public MessageForQQWalletMsg a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  
  public aizl(MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg = paramMessageForQQWalletMsg;
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord.saveExtInfoToExtStr("specify_redpack_is_reply", "1");
      ajaf.a(paramQQAppInterface, paramMessageRecord);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    if ((paramQQAppInterface == null) || (paramMessageForQQWalletMsg == null)) {
      return false;
    }
    boolean bool = a(paramMessageForQQWalletMsg, paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "tryScheduleSpecifyAnim isValidAnim=" + bool);
    }
    if (bool)
    {
      ((bcfr)paramQQAppInterface.getManager(223)).a(new aizl(paramMessageForQQWalletMsg), false);
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      try
      {
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("specify_redpack_is_reply"));
        if (i == 1) {
          return true;
        }
      }
      catch (Throwable paramMessageRecord)
      {
        for (;;)
        {
          int i = 0;
        }
      }
      return false;
    }
    return false;
  }
  
  public static boolean a(Object paramObject, QQAppInterface paramQQAppInterface)
  {
    if (!(paramObject instanceof MessageForQQWalletMsg)) {
      return false;
    }
    paramObject = (MessageForQQWalletMsg)paramObject;
    int i = paramObject.messageType;
    if ((i == 7) || (i == 8) || (i == 11) || (i == 12))
    {
      if (TextUtils.isEmpty(paramObject.mQQWalletRedPacketMsg.body.feedId)) {
        return false;
      }
      if (paramObject.isRedPackExpired()) {
        return false;
      }
      if ((!aixf.a().a()) && (!paramQQAppInterface.c().equals(paramObject.senderuin)))
      {
        if (paramObject.mQQWalletRedPacketMsg.specifyUinList == null) {
          break label176;
        }
        paramObject = paramObject.mQQWalletRedPacketMsg.specifyUinList.iterator();
        Long localLong;
        do
        {
          if (!paramObject.hasNext()) {
            break;
          }
          localLong = (Long)paramObject.next();
        } while (!paramQQAppInterface.c().equals(localLong + ""));
      }
    }
    label176:
    for (i = 1;; i = 0)
    {
      return i != 0;
      return false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView.removeAllViews();
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketSpecifySpecifyGiftView = null;
      this.jdField_a_of_type_AndroidViewWindowManager = null;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troop.send_gift", 2, "closeRedPackGiftAnimation exception ", localException);
        }
      }
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, baaa parambaaa)
  {
    ajaf.a(ajaf.a(), "212", "only.animation.show");
    String str = aizj.a() + this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.mQQWalletRedPacketMsg.body.feedId + ".zip";
    WeakReference localWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg);
    paramBaseChatPie = new WeakReference(paramBaseChatPie);
    if (QLog.isColorLevel()) {
      QLog.i("SpecifyRedPacketAnimMsg", 2, "showAnim start");
    }
    parambaaa = new aizm(this, parambaaa);
    this.jdField_a_of_type_JavaLangRunnable = new SpecifyRedPacketAnimMsg.2(this, parambaaa);
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    PreloadManager.a().c(str, new aizn(this, localWeakReference, parambaaa, paramBaseChatPie));
  }
  
  public String getFriendUin()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.frienduin;
  }
  
  public int getLimitType()
  {
    return 1;
  }
  
  public long getSenderUin()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.senderuin);
      return l;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 0L;
  }
  
  public long getShmsgseq()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForQQWalletMsg.shmsgseq;
  }
  
  public boolean isReaded()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizl
 * JD-Core Version:    0.7.0.1
 */