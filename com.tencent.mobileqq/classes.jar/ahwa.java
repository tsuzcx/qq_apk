import android.util.SparseArray;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class ahwa
{
  private final SparseArray<Class<? extends ahvv>> a = new SparseArray();
  
  public ahwa()
  {
    a();
  }
  
  private void a()
  {
    this.a.put(1000, ahwm.class);
    this.a.put(1004, ahwm.class);
    this.a.put(1008, ahwb.class);
    this.a.put(1024, ahwb.class);
    this.a.put(1020, ahvq.class);
    this.a.put(1005, ahvq.class);
    this.a.put(1003, ahvq.class);
    this.a.put(1022, ahvq.class);
    this.a.put(1009, ahvq.class);
    this.a.put(1023, ahvq.class);
    this.a.put(3000, ahvu.class);
    this.a.put(10004, ahwn.class);
    this.a.put(1006, ahwk.class);
    this.a.put(1025, ahwi.class);
    this.a.put(1001, ahwo.class);
    this.a.put(10002, ahwp.class);
    this.a.put(1010, ahwl.class);
    this.a.put(1021, ahwj.class);
    this.a.put(6000, ahvr.class);
    this.a.put(9501, ahvt.class);
  }
  
  ahvv a(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramBaseChatPie = paramBaseChatPie.sessionInfo;
    HotChatManager localHotChatManager = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((localHotChatManager != null) && (localHotChatManager.b(paramBaseChatPie.curFriendUin))) {
      return new ahws();
    }
    if (nty.a().a(paramBaseChatPie.curFriendUin)) {
      return new ahwq();
    }
    if (TroopInfo.isQidianPrivateTroop(localQQAppInterface, paramBaseChatPie.curFriendUin)) {
      return new ahwt();
    }
    return new ahwr();
  }
  
  public ahvv a(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    int i = paramBaseChatPie.sessionInfo.curType;
    if ((i == 0) || (ChatActivityUtils.a(localQQAppInterface, paramBaseChatPie.sessionInfo.curFriendUin))) {
      return b(paramBaseChatPie, paramBoolean);
    }
    if (i == 1) {
      return a(paramBaseChatPie);
    }
    try
    {
      paramBaseChatPie = (Class)this.a.get(i);
      if (paramBaseChatPie != null)
      {
        paramBaseChatPie = (ahvv)paramBaseChatPie.newInstance();
        return paramBaseChatPie;
      }
    }
    catch (Throwable paramBaseChatPie)
    {
      QLog.d("PlusPanelLoaderFactory", 1, paramBaseChatPie, new Object[0]);
    }
    return new ahvs();
  }
  
  ahvv b(BaseChatPie paramBaseChatPie, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    paramBaseChatPie = paramBaseChatPie.sessionInfo;
    if (bghs.b(localQQAppInterface, paramBaseChatPie.curFriendUin)) {
      return new ahwg();
    }
    if (nut.b(paramBaseChatPie.curFriendUin)) {
      return new ahwc();
    }
    if (paramBoolean) {
      return new ahwf();
    }
    if (localQQAppInterface.getCurrentUin().equals(paramBaseChatPie.curFriendUin)) {
      return new ahwh();
    }
    return new ahwe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwa
 * JD-Core Version:    0.7.0.1
 */