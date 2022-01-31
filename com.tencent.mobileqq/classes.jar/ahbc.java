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

public class ahbc
{
  public static int a;
  public static ahba a;
  public static Object a;
  public static ArrayList<ahbd> a;
  public static ArrayList<ahbb> b = new ArrayList();
  public static ArrayList<ahbb> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static ahbb a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    ahbb localahbb = null;
    ??? = localahbb;
    if (a(paramInt))
    {
      ??? = localahbb;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localahbb;
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
        localahbb = a(c, paramInt, paramString);
        if (localahbb != null) {
          a(paramMessageRecord, localahbb, paramInt, paramString, true);
        }
        ??? = localahbb;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localahbb);
        return localahbb;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new ahbd(paramInt, paramString, paramMessageRecord));
        }
        ??? = localahbb;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static ahbb a(ahbb paramahbb1, ahbb paramahbb2)
  {
    if ((paramahbb1 == null) || (paramahbb2 == null)) {}
    while ((paramahbb1.b != paramahbb2.b) || (paramahbb1.jdField_a_of_type_JavaLangString == null) || (!paramahbb1.jdField_a_of_type_JavaLangString.equals(paramahbb2.jdField_a_of_type_JavaLangString))) {
      return paramahbb2;
    }
    int i;
    if (paramahbb1.b == 1)
    {
      i = paramahbb2.a("state", 0);
      int j = paramahbb1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramahbb2.a("state", i);
      return paramahbb2;
      paramahbb2.jdField_a_of_type_OrgJsonJSONObject = paramahbb1.jdField_a_of_type_OrgJsonJSONObject;
      return paramahbb2;
    }
  }
  
  public static ahbb a(ArrayList<ahbb> paramArrayList, int paramInt, String paramString)
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
      ahbb localahbb = (ahbb)paramArrayList.get(i);
      if ((localahbb != null) && (localahbb.b == paramInt) && (localahbb.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localahbb;
        if (localahbb.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<ahbb> a(int paramInt)
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
  
  protected static ArrayList<ahbb> a(ArrayList<ahbb> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      ahbb localahbb = (ahbb)paramArrayList.get(i);
      if ((localahbb != null) && (localahbb.b == paramInt)) {
        localArrayList.add(localahbb);
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
              paramGoldMsgTipsElem1 = ahiw.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new ahbb(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((ahbb)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (ahbb)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(ahbe.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, ahbb paramahbb)
  {
    if ((paramahbb == null) || (!a(paramahbb.b)) || (TextUtils.isEmpty(paramahbb.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramahbb.b, paramahbb.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramahbb);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramahbb);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramahbb.b, paramahbb.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramahbb);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramahbb, (ahbb)localObject);
        }
      }
    } while (paramahbb.b == 2);
    a(paramahbb, (ahbb)localObject);
    paramahbb = new ArrayList();
    paramahbb.add(localObject);
    a(paramahbb, false);
  }
  
  public static void a(ahbd paramahbd)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramahbd != null) && (paramahbd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = ahiw.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramahbd.jdField_a_of_type_Int);
      localBundle.putString("bid", paramahbd.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(ahbe.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramahbd.jdField_a_of_type_Int + " bid:" + paramahbd.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ahiw.a();
    } while (localQQAppInterface == null);
    paramString2 = new ahbb(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<ahbb> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<ahbd> paramList)
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
        ahbd localahbd = (ahbd)paramList.next();
        if ((localahbd != null) && (a(localahbd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localahbd.jdField_a_of_type_Int, localahbd.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localahbd);
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
        ahbd localahbd = (ahbd)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localahbd != null) && (localahbd.jdField_a_of_type_Int == paramInt) && (localahbd.jdField_a_of_type_JavaLangString != null) && (localahbd.jdField_a_of_type_JavaLangString.equals(paramString)) && (localahbd.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, ahbb paramahbb, int paramInt, String paramString, boolean paramBoolean)
  {
    ahbb localahbb;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localahbb = paramahbb;
        if (paramahbb == null) {
          localahbb = a(c, paramInt, paramString);
        }
        if (localahbb == null) {
          break label241;
        }
        i = localahbb.a("state", -1);
        paramahbb = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramahbb)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramahbb).intValue();
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
      catch (Exception paramahbb)
      {
        if (QLog.isColorLevel()) {
          paramahbb.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localahbb = paramahbb;
        if (paramahbb == null) {
          localahbb = a(c, paramInt, paramString);
        }
        if ((localahbb != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramahbb = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramahbb.mQQWalletRedPacketMsg != null) && (paramahbb.mQQWalletRedPacketMsg.isOpened))
          {
            paramahbb.mQQWalletRedPacketMsg.isOpened = true;
            paramahbb.msgData = paramahbb.getBytes();
            paramString = ahiw.a();
            if (paramString != null) {
              paramString.a().a(paramahbb.frienduin, paramahbb.istroop, paramahbb.uniseq, paramahbb.msgData);
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
    if (jdField_a_of_type_Ahba != null) {}
    try
    {
      jdField_a_of_type_Ahba.close();
      jdField_a_of_type_Ahba = null;
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
 * Qualified Name:     ahbc
 * JD-Core Version:    0.7.0.1
 */