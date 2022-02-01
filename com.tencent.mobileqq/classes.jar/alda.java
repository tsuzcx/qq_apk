import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.2;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.3;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

public class alda
{
  public static int a;
  public static alcy a;
  public static Object a;
  public static ArrayList<aldb> a;
  public static ArrayList<alcz> b = new ArrayList();
  public static ArrayList<alcz> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static alcz a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    alcz localalcz = null;
    ??? = localalcz;
    if (a(paramInt))
    {
      ??? = localalcz;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localalcz;
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
        localalcz = a(c, paramInt, paramString);
        if (localalcz != null) {
          a(paramMessageRecord, localalcz, paramInt, paramString, true);
        }
        ??? = localalcz;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localalcz);
        return localalcz;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new aldb(paramInt, paramString, paramMessageRecord));
        }
        ??? = localalcz;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static alcz a(alcz paramalcz1, alcz paramalcz2)
  {
    if ((paramalcz1 == null) || (paramalcz2 == null)) {}
    while ((paramalcz1.b != paramalcz2.b) || (paramalcz1.jdField_a_of_type_JavaLangString == null) || (!paramalcz1.jdField_a_of_type_JavaLangString.equals(paramalcz2.jdField_a_of_type_JavaLangString))) {
      return paramalcz2;
    }
    int i;
    if (paramalcz1.b == 1)
    {
      i = paramalcz2.a("state", 0);
      int j = paramalcz1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramalcz2.a("state", i);
      return paramalcz2;
      paramalcz2.jdField_a_of_type_OrgJsonJSONObject = paramalcz1.jdField_a_of_type_OrgJsonJSONObject;
      return paramalcz2;
    }
  }
  
  public static alcz a(ArrayList<alcz> paramArrayList, int paramInt, String paramString)
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
      alcz localalcz = (alcz)paramArrayList.get(i);
      if ((localalcz != null) && (localalcz.b == paramInt) && (localalcz.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localalcz;
        if (localalcz.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<alcz> a(int paramInt)
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
  
  protected static ArrayList<alcz> a(ArrayList<alcz> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      alcz localalcz = (alcz)paramArrayList.get(i);
      if ((localalcz != null) && (localalcz.b == paramInt)) {
        localArrayList.add(localalcz);
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
              paramGoldMsgTipsElem1 = alil.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new alcz(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((alcz)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (alcz)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(aldc.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, alcz paramalcz)
  {
    if ((paramalcz == null) || (!a(paramalcz.b)) || (TextUtils.isEmpty(paramalcz.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramalcz.b, paramalcz.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramalcz);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramalcz);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramalcz.b, paramalcz.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramalcz);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramalcz, (alcz)localObject);
        }
      }
    } while (paramalcz.b == 2);
    a(paramalcz, (alcz)localObject);
    paramalcz = new ArrayList();
    paramalcz.add(localObject);
    a(paramalcz, false);
  }
  
  public static void a(aldb paramaldb)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramaldb != null) && (paramaldb.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = alil.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramaldb.jdField_a_of_type_Int);
      localBundle.putString("bid", paramaldb.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(aldc.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramaldb.jdField_a_of_type_Int + " bid:" + paramaldb.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = alil.a();
    } while (localQQAppInterface == null);
    paramString2 = new alcz(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<alcz> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<aldb> paramList)
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
        aldb localaldb = (aldb)paramList.next();
        if ((localaldb != null) && (a(localaldb.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localaldb.jdField_a_of_type_Int, localaldb.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localaldb);
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
        aldb localaldb = (aldb)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localaldb != null) && (localaldb.jdField_a_of_type_Int == paramInt) && (localaldb.jdField_a_of_type_JavaLangString != null) && (localaldb.jdField_a_of_type_JavaLangString.equals(paramString)) && (localaldb.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, alcz paramalcz, int paramInt, String paramString, boolean paramBoolean)
  {
    alcz localalcz;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localalcz = paramalcz;
        if (paramalcz == null) {
          localalcz = a(c, paramInt, paramString);
        }
        if (localalcz == null) {
          break label241;
        }
        i = localalcz.a("state", -1);
        paramalcz = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramalcz)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramalcz).intValue();
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
      catch (Exception paramalcz)
      {
        if (QLog.isColorLevel()) {
          paramalcz.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localalcz = paramalcz;
        if (paramalcz == null) {
          localalcz = a(c, paramInt, paramString);
        }
        if ((localalcz != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramalcz = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramalcz.mQQWalletRedPacketMsg != null) && (paramalcz.mQQWalletRedPacketMsg.isOpened))
          {
            paramalcz.mQQWalletRedPacketMsg.isOpened = true;
            paramalcz.msgData = paramalcz.getBytes();
            paramString = alil.a();
            if (paramString != null) {
              paramString.a().a(paramalcz.frienduin, paramalcz.istroop, paramalcz.uniseq, paramalcz.msgData);
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
    if (jdField_a_of_type_Alcy != null) {}
    try
    {
      jdField_a_of_type_Alcy.close();
      jdField_a_of_type_Alcy = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alda
 * JD-Core Version:    0.7.0.1
 */