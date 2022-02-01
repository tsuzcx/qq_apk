import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class agiq
  implements agin
{
  private static Map<Pair<Integer, String>, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private aikz jdField_a_of_type_Aikz;
  private volatile awit jdField_a_of_type_Awit;
  private awiy jdField_a_of_type_Awiy = new agir(this);
  private awiz jdField_a_of_type_Awiz;
  private awoe jdField_a_of_type_Awoe = new agis(this);
  private volatile BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  agiq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Awiz = awiz.a(paramBaseChatPie.app);
  }
  
  private String a(awit paramawit, String paramString)
  {
    String str = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramString, 0);
    if (paramawit.a() == 0) {
      str = ((anvk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString).getFriendNickWithAlias();
    }
    while (paramawit.a() != 1) {
      return str;
    }
    return ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramawit.a(), paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Awit == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] null ");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] sessionType: " + this.jdField_a_of_type_Awit.a() + " [mRoomKey] sessionUin: " + this.jdField_a_of_type_Awit.a());
    }
    return this.jdField_a_of_type_Awit.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aikz = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getLocationShareTipBar();
    this.jdField_a_of_type_Awit = new awit(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    if (awnj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + this.jdField_a_of_type_Awit.a());
      }
      this.jdField_a_of_type_Awiz.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Awit != null) && (!awnj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a())) && (this.jdField_a_of_type_Aikz == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin;
      if (TextUtils.isEmpty(str)) {
        if (QLog.isColorLevel()) {
          QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. empty uin, ignored. ", " friendUin: ", str });
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      boolean bool;
      do
      {
        int i;
        Pair localPair;
        do
        {
          return;
          localPair = new Pair(Integer.valueOf(i), str);
        } while (jdField_a_of_type_JavaUtilMap.containsKey(localPair));
        bool = awnj.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, i, str);
        awni.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, i, str, bool);
        jdField_a_of_type_JavaUtilMap.put(localPair, Boolean.valueOf(true));
      } while (!QLog.isColorLevel());
      QLog.d("LocationShareHelper", 2, new Object[] { "processRoamMessage: invoked. ", "[处理漫游消息，登录后首次进该会话aio，用资料位刷新消息字段] sessionSharingLocation: ", Boolean.valueOf(bool), " friendUin: ", str });
      return;
    }
    QLog.e("LocationShareHelper", 2, new Object[] { "processRoamMessage: failed. ", "empty session. " });
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      try
      {
        this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awiy);
        awnx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().a(this.jdField_a_of_type_Awoe);
        LocationShareHelper.3 local3 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post(local3);
        continue;
      }
      finally {}
      c();
      continue;
      b();
      continue;
      this.jdField_a_of_type_Awiz.b(this.jdField_a_of_type_Awiy);
      awnx.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().b(this.jdField_a_of_type_Awoe);
      aqnl.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType());
    }
  }
  
  public int[] a()
  {
    return new int[] { 4, 6, 9, 14 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agiq
 * JD-Core Version:    0.7.0.1
 */