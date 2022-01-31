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

public class ahbe
{
  public static int a;
  public static ahbc a;
  public static Object a;
  public static ArrayList<ahbf> a;
  public static ArrayList<ahbd> b = new ArrayList();
  public static ArrayList<ahbd> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ahbd a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    ahbd localahbd = null;
    ??? = localahbd;
    if (a(paramInt))
    {
      ??? = localahbd;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localahbd;
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
        localahbd = a(c, paramInt, paramString);
        if (localahbd != null) {
          a(paramMessageRecord, localahbd, paramInt, paramString, true);
        }
        ??? = localahbd;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localahbd);
        return localahbd;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new ahbf(paramInt, paramString, paramMessageRecord));
        }
        ??? = localahbd;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static ahbd a(ahbd paramahbd1, ahbd paramahbd2)
  {
    if ((paramahbd1 == null) || (paramahbd2 == null)) {}
    while ((paramahbd1.b != paramahbd2.b) || (paramahbd1.jdField_a_of_type_JavaLangString == null) || (!paramahbd1.jdField_a_of_type_JavaLangString.equals(paramahbd2.jdField_a_of_type_JavaLangString))) {
      return paramahbd2;
    }
    int i;
    if (paramahbd1.b == 1)
    {
      i = paramahbd2.a("state", 0);
      int j = paramahbd1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramahbd2.a("state", i);
      return paramahbd2;
      paramahbd2.jdField_a_of_type_OrgJsonJSONObject = paramahbd1.jdField_a_of_type_OrgJsonJSONObject;
      return paramahbd2;
    }
  }
  
  public static ahbd a(ArrayList<ahbd> paramArrayList, int paramInt, String paramString)
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
      ahbd localahbd = (ahbd)paramArrayList.get(i);
      if ((localahbd != null) && (localahbd.b == paramInt) && (localahbd.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localahbd;
        if (localahbd.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<ahbd> a(int paramInt)
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
  
  protected static ArrayList<ahbd> a(ArrayList<ahbd> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ahbd localahbd = (ahbd)paramArrayList.get(i);
      if ((localahbd != null) && (localahbd.b == paramInt)) {
        localArrayList.add(localahbd);
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
              paramGoldMsgTipsElem1 = ahiy.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new ahbd(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((ahbd)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (ahbd)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(ahbg.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, ahbd paramahbd)
  {
    if ((paramahbd == null) || (!a(paramahbd.b)) || (TextUtils.isEmpty(paramahbd.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramahbd.b, paramahbd.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramahbd);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramahbd);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramahbd.b, paramahbd.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramahbd);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramahbd, (ahbd)localObject);
        }
      }
    } while (paramahbd.b == 2);
    a(paramahbd, (ahbd)localObject);
    paramahbd = new ArrayList();
    paramahbd.add(localObject);
    a(paramahbd, false);
  }
  
  public static void a(ahbf paramahbf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramahbf != null) && (paramahbf.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = ahiy.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramahbf.jdField_a_of_type_Int);
      localBundle.putString("bid", paramahbf.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(ahbg.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramahbf.jdField_a_of_type_Int + " bid:" + paramahbf.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ahiy.a();
    } while (localQQAppInterface == null);
    paramString2 = new ahbd(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<ahbd> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<ahbf> paramList)
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
        ahbf localahbf = (ahbf)paramList.next();
        if ((localahbf != null) && (a(localahbf.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localahbf.jdField_a_of_type_Int, localahbf.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localahbf);
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
        ahbf localahbf = (ahbf)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localahbf != null) && (localahbf.jdField_a_of_type_Int == paramInt) && (localahbf.jdField_a_of_type_JavaLangString != null) && (localahbf.jdField_a_of_type_JavaLangString.equals(paramString)) && (localahbf.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, ahbd paramahbd, int paramInt, String paramString, boolean paramBoolean)
  {
    ahbd localahbd;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localahbd = paramahbd;
        if (paramahbd == null) {
          localahbd = a(c, paramInt, paramString);
        }
        if (localahbd == null) {
          break label241;
        }
        i = localahbd.a("state", -1);
        paramahbd = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramahbd)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramahbd).intValue();
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
      catch (Exception paramahbd)
      {
        if (QLog.isColorLevel()) {
          paramahbd.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localahbd = paramahbd;
        if (paramahbd == null) {
          localahbd = a(c, paramInt, paramString);
        }
        if ((localahbd != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramahbd = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramahbd.mQQWalletRedPacketMsg != null) && (paramahbd.mQQWalletRedPacketMsg.isOpened))
          {
            paramahbd.mQQWalletRedPacketMsg.isOpened = true;
            paramahbd.msgData = paramahbd.getBytes();
            paramString = ahiy.a();
            if (paramString != null) {
              paramString.a().a(paramahbd.frienduin, paramahbd.istroop, paramahbd.uniseq, paramahbd.msgData);
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
    if (jdField_a_of_type_Ahbc != null) {}
    try
    {
      jdField_a_of_type_Ahbc.close();
      jdField_a_of_type_Ahbc = null;
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
 * Qualified Name:     ahbe
 * JD-Core Version:    0.7.0.1
 */