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

public class aizw
{
  public static int a;
  public static aizu a;
  public static Object a;
  public static ArrayList<aizx> a;
  public static ArrayList<aizv> b = new ArrayList();
  public static ArrayList<aizv> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static aizv a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    aizv localaizv = null;
    ??? = localaizv;
    if (a(paramInt))
    {
      ??? = localaizv;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localaizv;
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
        localaizv = a(c, paramInt, paramString);
        if (localaizv != null) {
          a(paramMessageRecord, localaizv, paramInt, paramString, true);
        }
        ??? = localaizv;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localaizv);
        return localaizv;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new aizx(paramInt, paramString, paramMessageRecord));
        }
        ??? = localaizv;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static aizv a(aizv paramaizv1, aizv paramaizv2)
  {
    if ((paramaizv1 == null) || (paramaizv2 == null)) {}
    while ((paramaizv1.b != paramaizv2.b) || (paramaizv1.jdField_a_of_type_JavaLangString == null) || (!paramaizv1.jdField_a_of_type_JavaLangString.equals(paramaizv2.jdField_a_of_type_JavaLangString))) {
      return paramaizv2;
    }
    int i;
    if (paramaizv1.b == 1)
    {
      i = paramaizv2.a("state", 0);
      int j = paramaizv1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramaizv2.a("state", i);
      return paramaizv2;
      paramaizv2.jdField_a_of_type_OrgJsonJSONObject = paramaizv1.jdField_a_of_type_OrgJsonJSONObject;
      return paramaizv2;
    }
  }
  
  public static aizv a(ArrayList<aizv> paramArrayList, int paramInt, String paramString)
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
      aizv localaizv = (aizv)paramArrayList.get(i);
      if ((localaizv != null) && (localaizv.b == paramInt) && (localaizv.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localaizv;
        if (localaizv.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<aizv> a(int paramInt)
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
  
  protected static ArrayList<aizv> a(ArrayList<aizv> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      aizv localaizv = (aizv)paramArrayList.get(i);
      if ((localaizv != null) && (localaizv.b == paramInt)) {
        localArrayList.add(localaizv);
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
              paramGoldMsgTipsElem1 = ajeu.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new aizv(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((aizv)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (aizv)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(aizy.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, aizv paramaizv)
  {
    if ((paramaizv == null) || (!a(paramaizv.b)) || (TextUtils.isEmpty(paramaizv.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramaizv.b, paramaizv.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramaizv);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramaizv);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramaizv.b, paramaizv.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramaizv);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramaizv, (aizv)localObject);
        }
      }
    } while (paramaizv.b == 2);
    a(paramaizv, (aizv)localObject);
    paramaizv = new ArrayList();
    paramaizv.add(localObject);
    a(paramaizv, false);
  }
  
  public static void a(aizx paramaizx)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramaizx != null) && (paramaizx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = ajeu.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramaizx.jdField_a_of_type_Int);
      localBundle.putString("bid", paramaizx.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(aizy.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramaizx.jdField_a_of_type_Int + " bid:" + paramaizx.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = ajeu.a();
    } while (localQQAppInterface == null);
    paramString2 = new aizv(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<aizv> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<aizx> paramList)
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
        aizx localaizx = (aizx)paramList.next();
        if ((localaizx != null) && (a(localaizx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localaizx.jdField_a_of_type_Int, localaizx.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localaizx);
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
        aizx localaizx = (aizx)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localaizx != null) && (localaizx.jdField_a_of_type_Int == paramInt) && (localaizx.jdField_a_of_type_JavaLangString != null) && (localaizx.jdField_a_of_type_JavaLangString.equals(paramString)) && (localaizx.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, aizv paramaizv, int paramInt, String paramString, boolean paramBoolean)
  {
    aizv localaizv;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localaizv = paramaizv;
        if (paramaizv == null) {
          localaizv = a(c, paramInt, paramString);
        }
        if (localaizv == null) {
          break label241;
        }
        i = localaizv.a("state", -1);
        paramaizv = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramaizv)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramaizv).intValue();
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
      catch (Exception paramaizv)
      {
        if (QLog.isColorLevel()) {
          paramaizv.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localaizv = paramaizv;
        if (paramaizv == null) {
          localaizv = a(c, paramInt, paramString);
        }
        if ((localaizv != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramaizv = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramaizv.mQQWalletRedPacketMsg != null) && (paramaizv.mQQWalletRedPacketMsg.isOpened))
          {
            paramaizv.mQQWalletRedPacketMsg.isOpened = true;
            paramaizv.msgData = paramaizv.getBytes();
            paramString = ajeu.a();
            if (paramString != null) {
              paramString.a().a(paramaizv.frienduin, paramaizv.istroop, paramaizv.uniseq, paramaizv.msgData);
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
    if (jdField_a_of_type_Aizu != null) {}
    try
    {
      jdField_a_of_type_Aizu.close();
      jdField_a_of_type_Aizu = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aizw
 * JD-Core Version:    0.7.0.1
 */