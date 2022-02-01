import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.LocationShareHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class agvf
  implements agvc
{
  private static Map<Pair<Integer, String>, Boolean> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private aivp jdField_a_of_type_Aivp;
  private volatile awpk jdField_a_of_type_Awpk;
  private awpp jdField_a_of_type_Awpp = new agvg(this);
  private awpq jdField_a_of_type_Awpq;
  private awuv jdField_a_of_type_Awuv = new agvh(this);
  private volatile BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  
  agvf(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Awpq = awpq.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private String a(awpk paramawpk, String paramString)
  {
    String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 0);
    if (paramawpk.a() == 0) {
      str = ((anyw)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    while (paramawpk.a() != 1) {
      return str;
    }
    return bhlg.h(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawpk.a(), paramString);
  }
  
  public static void a()
  {
    jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Awpk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] null ");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareHelper", 2, "[queryLocationRoom] isSameSession: invoked. sessionType: " + paramInt + " sessionUin: " + paramString + " [mRoomKey] sessionType: " + this.jdField_a_of_type_Awpk.a() + " [mRoomKey] sessionUin: " + this.jdField_a_of_type_Awpk.a());
    }
    return this.jdField_a_of_type_Awpk.a(paramInt, paramString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Aivp = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_Awpk = new awpk(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if (awua.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareHelper", 2, "[queryLocationRoom] requestQueryRoom: invoked. sessionUin: " + this.jdField_a_of_type_Awpk.a());
      }
      this.jdField_a_of_type_Awpq.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Awpk != null) && (!awua.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a())) && (this.jdField_a_of_type_Aivp == this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
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
        bool = awua.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str);
        awtz.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, str, bool);
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
        this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpp);
        awuo.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().a(this.jdField_a_of_type_Awuv);
        LocationShareHelper.3 local3 = new LocationShareHelper.3(this);
        ThreadManager.getSubThreadHandler().post(local3);
        continue;
      }
      finally {}
      c();
      continue;
      b();
      continue;
      this.jdField_a_of_type_Awpq.b(this.jdField_a_of_type_Awpp);
      awuo.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().b(this.jdField_a_of_type_Awuv);
      aqqy.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b());
    }
  }
  
  public int[] a()
  {
    return new int[] { 3, 5, 8, 13 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvf
 * JD-Core Version:    0.7.0.1
 */