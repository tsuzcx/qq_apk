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

public class akwm
{
  public static int a;
  public static akwk a;
  public static Object a;
  public static ArrayList<akwn> a;
  public static ArrayList<akwl> b = new ArrayList();
  public static ArrayList<akwl> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static akwl a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    akwl localakwl = null;
    ??? = localakwl;
    if (a(paramInt))
    {
      ??? = localakwl;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localakwl;
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
        localakwl = a(c, paramInt, paramString);
        if (localakwl != null) {
          a(paramMessageRecord, localakwl, paramInt, paramString, true);
        }
        ??? = localakwl;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localakwl);
        return localakwl;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new akwn(paramInt, paramString, paramMessageRecord));
        }
        ??? = localakwl;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static akwl a(akwl paramakwl1, akwl paramakwl2)
  {
    if ((paramakwl1 == null) || (paramakwl2 == null)) {}
    while ((paramakwl1.b != paramakwl2.b) || (paramakwl1.jdField_a_of_type_JavaLangString == null) || (!paramakwl1.jdField_a_of_type_JavaLangString.equals(paramakwl2.jdField_a_of_type_JavaLangString))) {
      return paramakwl2;
    }
    int i;
    if (paramakwl1.b == 1)
    {
      i = paramakwl2.a("state", 0);
      int j = paramakwl1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramakwl2.a("state", i);
      return paramakwl2;
      paramakwl2.jdField_a_of_type_OrgJsonJSONObject = paramakwl1.jdField_a_of_type_OrgJsonJSONObject;
      return paramakwl2;
    }
  }
  
  public static akwl a(ArrayList<akwl> paramArrayList, int paramInt, String paramString)
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
      akwl localakwl = (akwl)paramArrayList.get(i);
      if ((localakwl != null) && (localakwl.b == paramInt) && (localakwl.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localakwl;
        if (localakwl.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<akwl> a(int paramInt)
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
  
  protected static ArrayList<akwl> a(ArrayList<akwl> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      akwl localakwl = (akwl)paramArrayList.get(i);
      if ((localakwl != null) && (localakwl.b == paramInt)) {
        localArrayList.add(localakwl);
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
              paramGoldMsgTipsElem1 = albw.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new akwl(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((akwl)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (akwl)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(akwo.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, akwl paramakwl)
  {
    if ((paramakwl == null) || (!a(paramakwl.b)) || (TextUtils.isEmpty(paramakwl.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramakwl.b, paramakwl.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramakwl);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramakwl);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramakwl.b, paramakwl.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramakwl);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramakwl, (akwl)localObject);
        }
      }
    } while (paramakwl.b == 2);
    a(paramakwl, (akwl)localObject);
    paramakwl = new ArrayList();
    paramakwl.add(localObject);
    a(paramakwl, false);
  }
  
  public static void a(akwn paramakwn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramakwn != null) && (paramakwn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = albw.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramakwn.jdField_a_of_type_Int);
      localBundle.putString("bid", paramakwn.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(akwo.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramakwn.jdField_a_of_type_Int + " bid:" + paramakwn.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = albw.a();
    } while (localQQAppInterface == null);
    paramString2 = new akwl(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<akwl> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<akwn> paramList)
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
        akwn localakwn = (akwn)paramList.next();
        if ((localakwn != null) && (a(localakwn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localakwn.jdField_a_of_type_Int, localakwn.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localakwn);
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
        akwn localakwn = (akwn)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localakwn != null) && (localakwn.jdField_a_of_type_Int == paramInt) && (localakwn.jdField_a_of_type_JavaLangString != null) && (localakwn.jdField_a_of_type_JavaLangString.equals(paramString)) && (localakwn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, akwl paramakwl, int paramInt, String paramString, boolean paramBoolean)
  {
    akwl localakwl;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localakwl = paramakwl;
        if (paramakwl == null) {
          localakwl = a(c, paramInt, paramString);
        }
        if (localakwl == null) {
          break label241;
        }
        i = localakwl.a("state", -1);
        paramakwl = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramakwl)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramakwl).intValue();
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
      catch (Exception paramakwl)
      {
        if (QLog.isColorLevel()) {
          paramakwl.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localakwl = paramakwl;
        if (paramakwl == null) {
          localakwl = a(c, paramInt, paramString);
        }
        if ((localakwl != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramakwl = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramakwl.mQQWalletRedPacketMsg != null) && (paramakwl.mQQWalletRedPacketMsg.isOpened))
          {
            paramakwl.mQQWalletRedPacketMsg.isOpened = true;
            paramakwl.msgData = paramakwl.getBytes();
            paramString = albw.a();
            if (paramString != null) {
              paramString.getMessageFacade().updateMsgContentByUniseq(paramakwl.frienduin, paramakwl.istroop, paramakwl.uniseq, paramakwl.msgData);
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
    if (jdField_a_of_type_Akwk != null) {}
    try
    {
      jdField_a_of_type_Akwk.close();
      jdField_a_of_type_Akwk = null;
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
 * Qualified Name:     akwm
 * JD-Core Version:    0.7.0.1
 */