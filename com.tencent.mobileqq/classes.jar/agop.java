import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.3;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;

public class agop
{
  public static int a;
  public static agon a;
  public static Object a;
  public static ArrayList<agoq> a;
  public static ArrayList<agoo> b = new ArrayList();
  public static ArrayList<agoo> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static agoo a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    agoo localagoo = null;
    ??? = localagoo;
    if (a(paramInt))
    {
      ??? = localagoo;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localagoo;
      }
    }
    for (;;)
    {
      return ???;
      label32:
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord btype:" + paramInt + " bid:" + paramString + " dbstate:" + jdField_a_of_type_Int);
      }
      if (jdField_a_of_type_Int == 2)
      {
        localagoo = a(c, paramInt, paramString);
        if (localagoo != null) {
          a(paramMessageRecord, localagoo, paramInt, paramString, true);
        }
        ??? = localagoo;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localagoo);
        return localagoo;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new agoq(paramInt, paramString, paramMessageRecord));
        }
        ??? = localagoo;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static agoo a(agoo paramagoo1, agoo paramagoo2)
  {
    if ((paramagoo1 == null) || (paramagoo2 == null)) {}
    while ((paramagoo1.b != paramagoo2.b) || (paramagoo1.jdField_a_of_type_JavaLangString == null) || (!paramagoo1.jdField_a_of_type_JavaLangString.equals(paramagoo2.jdField_a_of_type_JavaLangString))) {
      return paramagoo2;
    }
    int i;
    if (paramagoo1.b == 1)
    {
      i = paramagoo2.a("state", 0);
      int j = paramagoo1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramagoo2.a("state", i);
      return paramagoo2;
      paramagoo2.jdField_a_of_type_OrgJsonJSONObject = paramagoo1.jdField_a_of_type_OrgJsonJSONObject;
      return paramagoo2;
    }
  }
  
  public static agoo a(ArrayList<agoo> paramArrayList, int paramInt, String paramString)
  {
    Object localObject;
    if (paramArrayList == null)
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label75;
      }
      agoo localagoo = (agoo)paramArrayList.get(i);
      if ((localagoo != null) && (localagoo.b == paramInt) && (localagoo.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localagoo;
        if (localagoo.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<agoo> a(int paramInt)
  {
    if (!a(paramInt)) {}
    label68:
    do
    {
      return null;
      if (jdField_a_of_type_Int == 2)
      {
        ArrayList localArrayList = a(c, paramInt);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("queryRecordsInMemory size:");
          if (localArrayList == null) {
            break label68;
          }
        }
        for (paramInt = localArrayList.size();; paramInt = 0)
        {
          QLog.i("NotifyMsgManager", 2, paramInt);
          return localArrayList;
        }
      }
    } while (jdField_a_of_type_Int != 0);
    b();
    return null;
  }
  
  protected static ArrayList<agoo> a(ArrayList<agoo> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      agoo localagoo = (agoo)paramArrayList.get(i);
      if ((localagoo != null) && (localagoo.b == paramInt)) {
        localArrayList.add(localagoo);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Int == 0) {
      b();
    }
  }
  
  public static void a(int paramInt, TroopTips0x857.GoldMsgTipsElem paramGoldMsgTipsElem, oidb_0x858.GoldMsgTipsElem paramGoldMsgTipsElem1)
  {
    if ((paramInt == 3000) && (paramGoldMsgTipsElem1 != null)) {
      if (!paramGoldMsgTipsElem1.type.has()) {
        break label310;
      }
    }
    label300:
    label310:
    for (paramInt = paramGoldMsgTipsElem1.type.get();; paramInt = 0)
    {
      if (paramGoldMsgTipsElem1.billno.has()) {}
      for (paramGoldMsgTipsElem = paramGoldMsgTipsElem1.billno.get();; paramGoldMsgTipsElem = null)
      {
        int i = paramInt;
        Object localObject = paramGoldMsgTipsElem;
        if (paramGoldMsgTipsElem1.action.has())
        {
          i = paramGoldMsgTipsElem1.action.get();
          if (QLog.isColorLevel()) {
            QLog.i("NotifyMsgManager", 2, "onReceiveAAPaySysNotify type:" + paramInt + " billno:" + paramGoldMsgTipsElem + " action:" + i);
          }
          if (paramInt != 3)
          {
            label123:
            do
            {
              return;
            } while (((paramInt != 1) && (paramInt != 0)) || (paramGoldMsgTipsElem == null));
            if (!paramGoldMsgTipsElem.type.has()) {
              break label300;
            }
          }
        }
        for (paramInt = paramGoldMsgTipsElem.type.get();; paramInt = 0)
        {
          if (paramGoldMsgTipsElem.billno.has()) {}
          for (paramGoldMsgTipsElem1 = paramGoldMsgTipsElem.billno.get();; paramGoldMsgTipsElem1 = null)
          {
            i = paramInt;
            localObject = paramGoldMsgTipsElem1;
            if (paramGoldMsgTipsElem.action.has())
            {
              i = paramGoldMsgTipsElem.action.get();
              paramGoldMsgTipsElem = paramGoldMsgTipsElem1;
              break;
              paramGoldMsgTipsElem1 = agwj.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new agoo(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((agoo)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (agoo)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(agor.class, 1, true, (Bundle)localObject);
              return;
            }
            int j = 0;
            paramGoldMsgTipsElem = (TroopTips0x857.GoldMsgTipsElem)localObject;
            paramInt = i;
            i = j;
            break;
          }
        }
      }
    }
  }
  
  protected static void a(long paramLong, agoo paramagoo)
  {
    if ((paramagoo == null) || (!a(paramagoo.b)) || (TextUtils.isEmpty(paramagoo.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramagoo.b, paramagoo.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramagoo);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramagoo);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramagoo.b, paramagoo.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramagoo);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramagoo, (agoo)localObject);
        }
      }
    } while (paramagoo.b == 2);
    a(paramagoo, (agoo)localObject);
    paramagoo = new ArrayList();
    paramagoo.add(localObject);
    a(paramagoo, false);
  }
  
  public static void a(agoq paramagoq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramagoq != null) && (paramagoq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = agwj.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramagoq.jdField_a_of_type_Int);
      localBundle.putString("bid", paramagoq.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(agor.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramagoq.jdField_a_of_type_Int + " bid:" + paramagoq.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = agwj.a();
    } while (localQQAppInterface == null);
    paramString2 = new agoo(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<agoo> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<agoq> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        agoq localagoq = (agoq)paramList.next();
        if ((localagoq != null) && (a(localagoq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localagoq.jdField_a_of_type_Int, localagoq.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localagoq);
        }
      }
    } while (localArrayList.size() <= 0);
    ThreadManager.post(new NotifyMsgManager.2(localArrayList), 5, null, false);
  }
  
  protected static boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2);
  }
  
  protected static boolean a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < jdField_a_of_type_JavaUtilArrayList.size())
      {
        agoq localagoq = (agoq)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localagoq != null) && (localagoq.jdField_a_of_type_Int == paramInt) && (localagoq.jdField_a_of_type_JavaLangString != null) && (localagoq.jdField_a_of_type_JavaLangString.equals(paramString)) && (localagoq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord, agoo paramagoo, int paramInt, String paramString, boolean paramBoolean)
  {
    agoo localagoo;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localagoo = paramagoo;
        if (paramagoo == null) {
          localagoo = a(c, paramInt, paramString);
        }
        if (localagoo == null) {
          break label241;
        }
        i = localagoo.a("state", -1);
        paramagoo = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramagoo)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramagoo).intValue();
        if ((i == -1) || (i == paramInt)) {
          break label241;
        }
        paramMessageRecord.saveExtInfoToExtStr("qqpay_state", String.valueOf(i));
        bool = true;
        if ((bool) && (paramBoolean)) {
          ThreadManager.post(new NotifyMsgManager.3(paramMessageRecord), 5, null, false);
        }
        return bool;
      }
      catch (Exception paramagoo)
      {
        if (QLog.isColorLevel()) {
          paramagoo.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localagoo = paramagoo;
        if (paramagoo == null) {
          localagoo = a(c, paramInt, paramString);
        }
        if ((localagoo != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramagoo = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramagoo.mQQWalletRedPacketMsg != null) && (paramagoo.mQQWalletRedPacketMsg.isOpened))
          {
            paramagoo.mQQWalletRedPacketMsg.isOpened = true;
            paramagoo.msgData = paramagoo.getBytes();
            paramString = agwj.a();
            if (paramString != null) {
              paramString.a().a(paramagoo.frienduin, paramagoo.istroop, paramagoo.uniseq, paramagoo.msgData);
            }
          }
        }
      }
      label241:
      boolean bool = false;
    }
  }
  
  protected static void b()
  {
    jdField_a_of_type_Int = 1;
    ThreadManager.post(new NotifyMsgManager.1(), 10, null, false);
  }
  
  public static void c()
  {
    jdField_a_of_type_Int = 0;
    c.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
    b.clear();
    if (jdField_a_of_type_Agon != null) {}
    try
    {
      jdField_a_of_type_Agon.close();
      jdField_a_of_type_Agon = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     agop
 * JD-Core Version:    0.7.0.1
 */