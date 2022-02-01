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

public class akat
{
  public static int a;
  public static akar a;
  public static Object a;
  public static ArrayList<akau> a;
  public static ArrayList<akas> b = new ArrayList();
  public static ArrayList<akas> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static akas a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    akas localakas = null;
    ??? = localakas;
    if (a(paramInt))
    {
      ??? = localakas;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localakas;
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
        localakas = a(c, paramInt, paramString);
        if (localakas != null) {
          a(paramMessageRecord, localakas, paramInt, paramString, true);
        }
        ??? = localakas;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localakas);
        return localakas;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new akau(paramInt, paramString, paramMessageRecord));
        }
        ??? = localakas;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static akas a(akas paramakas1, akas paramakas2)
  {
    if ((paramakas1 == null) || (paramakas2 == null)) {}
    while ((paramakas1.b != paramakas2.b) || (paramakas1.jdField_a_of_type_JavaLangString == null) || (!paramakas1.jdField_a_of_type_JavaLangString.equals(paramakas2.jdField_a_of_type_JavaLangString))) {
      return paramakas2;
    }
    int i;
    if (paramakas1.b == 1)
    {
      i = paramakas2.a("state", 0);
      int j = paramakas1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramakas2.a("state", i);
      return paramakas2;
      paramakas2.jdField_a_of_type_OrgJsonJSONObject = paramakas1.jdField_a_of_type_OrgJsonJSONObject;
      return paramakas2;
    }
  }
  
  public static akas a(ArrayList<akas> paramArrayList, int paramInt, String paramString)
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
      akas localakas = (akas)paramArrayList.get(i);
      if ((localakas != null) && (localakas.b == paramInt) && (localakas.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localakas;
        if (localakas.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<akas> a(int paramInt)
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
  
  protected static ArrayList<akas> a(ArrayList<akas> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      akas localakas = (akas)paramArrayList.get(i);
      if ((localakas != null) && (localakas.b == paramInt)) {
        localArrayList.add(localakas);
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
              paramGoldMsgTipsElem1 = akgd.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new akas(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((akas)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (akas)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(akav.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, akas paramakas)
  {
    if ((paramakas == null) || (!a(paramakas.b)) || (TextUtils.isEmpty(paramakas.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramakas.b, paramakas.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramakas);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramakas);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramakas.b, paramakas.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramakas);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramakas, (akas)localObject);
        }
      }
    } while (paramakas.b == 2);
    a(paramakas, (akas)localObject);
    paramakas = new ArrayList();
    paramakas.add(localObject);
    a(paramakas, false);
  }
  
  public static void a(akau paramakau)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramakau != null) && (paramakau.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = akgd.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramakau.jdField_a_of_type_Int);
      localBundle.putString("bid", paramakau.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(akav.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramakau.jdField_a_of_type_Int + " bid:" + paramakau.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = akgd.a();
    } while (localQQAppInterface == null);
    paramString2 = new akas(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<akas> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<akau> paramList)
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
        akau localakau = (akau)paramList.next();
        if ((localakau != null) && (a(localakau.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localakau.jdField_a_of_type_Int, localakau.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localakau);
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
        akau localakau = (akau)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localakau != null) && (localakau.jdField_a_of_type_Int == paramInt) && (localakau.jdField_a_of_type_JavaLangString != null) && (localakau.jdField_a_of_type_JavaLangString.equals(paramString)) && (localakau.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, akas paramakas, int paramInt, String paramString, boolean paramBoolean)
  {
    akas localakas;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localakas = paramakas;
        if (paramakas == null) {
          localakas = a(c, paramInt, paramString);
        }
        if (localakas == null) {
          break label241;
        }
        i = localakas.a("state", -1);
        paramakas = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramakas)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramakas).intValue();
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
      catch (Exception paramakas)
      {
        if (QLog.isColorLevel()) {
          paramakas.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localakas = paramakas;
        if (paramakas == null) {
          localakas = a(c, paramInt, paramString);
        }
        if ((localakas != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramakas = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramakas.mQQWalletRedPacketMsg != null) && (paramakas.mQQWalletRedPacketMsg.isOpened))
          {
            paramakas.mQQWalletRedPacketMsg.isOpened = true;
            paramakas.msgData = paramakas.getBytes();
            paramString = akgd.a();
            if (paramString != null) {
              paramString.getMessageFacade().updateMsgContentByUniseq(paramakas.frienduin, paramakas.istroop, paramakas.uniseq, paramakas.msgData);
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
    if (jdField_a_of_type_Akar != null) {}
    try
    {
      jdField_a_of_type_Akar.close();
      jdField_a_of_type_Akar = null;
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
 * Qualified Name:     akat
 * JD-Core Version:    0.7.0.1
 */