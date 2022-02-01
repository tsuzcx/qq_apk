import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class afrf
  implements afrc
{
  private static Map<Pair<Integer, String>, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private ahqa jdField_a_of_type_Ahqa;
  private volatile avcq jdField_a_of_type_Avcq;
  private avcv jdField_a_of_type_Avcv = new afrg(this);
  private avcw jdField_a_of_type_Avcw;
  private avib jdField_a_of_type_Avib = new afrh(this);
  private volatile BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  afrf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Avcw = avcw.a(paramBaseChatPie.app);
  }
  
  private String a(avcq paramavcq, String paramString)
  {
    String str = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramString, 0);
    if (paramavcq.a() == 0) {
      str = ((amsw)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    while (paramavcq.a() != 1) {
      return str;
    }
    return ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, paramavcq.a(), paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Avcq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] null ");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] sessionType: " + this.jdField_a_of_type_Avcq.a() + " [mRoomKey] sessionUin: " + this.jdField_a_of_type_Avcq.a());
    }
    return this.jdField_a_of_type_Avcq.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Ahqa = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getLocationShareTipBar();
    this.jdField_a_of_type_Avcq = new avcq(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    if (avhg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + this.jdField_a_of_type_Avcq.a());
      }
      this.jdField_a_of_type_Avcw.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curType, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Avcq != null) && (!avhg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_Avcq.a(), this.jdField_a_of_type_Avcq.a())) && (this.jdField_a_of_type_Ahqa == this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getTipManager().a())) {
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
        bool = avhg.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, i, str);
        avhf.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, i, str, bool);
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
        this.jdField_a_of_type_Avcw.a(this.jdField_a_of_type_Avcv);
        avhu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().a(this.jdField_a_of_type_Avib);
        LocationShareHelper.3 local3 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post(local3);
        continue;
      }
      finally {}
      c();
      continue;
      b();
      continue;
      this.jdField_a_of_type_Avcw.b(this.jdField_a_of_type_Avcv);
      avhu.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app).a().b(this.jdField_a_of_type_Avib);
      apkh.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurFriendUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.getCurType());
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 8, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afrf
 * JD-Core Version:    0.7.0.1
 */