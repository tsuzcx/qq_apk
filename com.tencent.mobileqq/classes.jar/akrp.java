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

public class akrp
{
  public static int a;
  public static akrn a;
  public static Object a;
  public static ArrayList<akrq> a;
  public static ArrayList<akro> b = new ArrayList();
  public static ArrayList<akro> c = new ArrayList(128);
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static akro a(int paramInt, String paramString, MessageRecord paramMessageRecord)
  {
    akro localakro = null;
    ??? = localakro;
    if (a(paramInt))
    {
      ??? = localakro;
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramMessageRecord != null) {
          break label32;
        }
        ??? = localakro;
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
        localakro = a(c, paramInt, paramString);
        if (localakro != null) {
          a(paramMessageRecord, localakro, paramInt, paramString, true);
        }
        ??? = localakro;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("NotifyMsgManager", 2, "queryGoldMsgRecord check in cache:" + localakro);
        return localakro;
      }
      if (paramInt != 2) {}
      synchronized (jdField_a_of_type_JavaUtilArrayList)
      {
        if (!a(paramInt, paramString, paramMessageRecord)) {
          jdField_a_of_type_JavaUtilArrayList.add(new akrq(paramInt, paramString, paramMessageRecord));
        }
        ??? = localakro;
        if (jdField_a_of_type_Int != 0) {
          continue;
        }
        b();
        return null;
      }
    }
  }
  
  public static akro a(akro paramakro1, akro paramakro2)
  {
    if ((paramakro1 == null) || (paramakro2 == null)) {}
    while ((paramakro1.b != paramakro2.b) || (paramakro1.jdField_a_of_type_JavaLangString == null) || (!paramakro1.jdField_a_of_type_JavaLangString.equals(paramakro2.jdField_a_of_type_JavaLangString))) {
      return paramakro2;
    }
    int i;
    if (paramakro1.b == 1)
    {
      i = paramakro2.a("state", 0);
      int j = paramakro1.a("state", 0);
      if (i == 2) {
        break label92;
      }
      i = j;
    }
    label92:
    for (;;)
    {
      paramakro2.a("state", i);
      return paramakro2;
      paramakro2.jdField_a_of_type_OrgJsonJSONObject = paramakro1.jdField_a_of_type_OrgJsonJSONObject;
      return paramakro2;
    }
  }
  
  public static akro a(ArrayList<akro> paramArrayList, int paramInt, String paramString)
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
      akro localakro = (akro)paramArrayList.get(i);
      if ((localakro != null) && (localakro.b == paramInt) && (localakro.jdField_a_of_type_JavaLangString != null))
      {
        localObject = localakro;
        if (localakro.jdField_a_of_type_JavaLangString.equals(paramString)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  public static ArrayList<akro> a(int paramInt)
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
  
  protected static ArrayList<akro> a(ArrayList<akro> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      akro localakro = (akro)paramArrayList.get(i);
      if ((localakro != null) && (localakro.b == paramInt)) {
        localArrayList.add(localakro);
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
              paramGoldMsgTipsElem1 = akww.a();
              if (paramGoldMsgTipsElem1 == null) {
                break label123;
              }
              localObject = new akro(0, paramGoldMsgTipsElem1.getLongAccountUin(), 1, paramGoldMsgTipsElem, 0L, null);
              ((akro)localObject).a("state", i);
              a(paramGoldMsgTipsElem1.getLongAccountUin(), (akro)localObject);
              localObject = new Bundle();
              ((Bundle)localObject).putInt("btype", 1);
              ((Bundle)localObject).putString("bid", paramGoldMsgTipsElem);
              paramGoldMsgTipsElem1.notifyObservers(akrr.class, 1, true, (Bundle)localObject);
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
  
  protected static void a(long paramLong, akro paramakro)
  {
    if ((paramakro == null) || (!a(paramakro.b)) || (TextUtils.isEmpty(paramakro.jdField_a_of_type_JavaLangString))) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = a(c, paramakro.b, paramakro.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        if (jdField_a_of_type_Int == 2)
        {
          c.add(paramakro);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramakro);
          a((ArrayList)localObject, true);
          return;
        }
        localObject = a(b, paramakro.b, paramakro.jdField_a_of_type_JavaLangString);
        if (localObject == null) {
          b.add(paramakro);
        }
        while (jdField_a_of_type_Int == 0)
        {
          b();
          return;
          a(paramakro, (akro)localObject);
        }
      }
    } while (paramakro.b == 2);
    a(paramakro, (akro)localObject);
    paramakro = new ArrayList();
    paramakro.add(localObject);
    a(paramakro, false);
  }
  
  public static void a(akrq paramakrq)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NotifyMsgManager", 2, "notifyUI start");
    }
    QQAppInterface localQQAppInterface;
    if ((paramakrq != null) && (paramakrq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null))
    {
      localQQAppInterface = akww.a();
      if (localQQAppInterface != null) {
        break label34;
      }
    }
    label34:
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("btype", paramakrq.jdField_a_of_type_Int);
      localBundle.putString("bid", paramakrq.jdField_a_of_type_JavaLangString);
      localQQAppInterface.notifyObservers(akrr.class, 1, true, localBundle);
    } while (!QLog.isColorLevel());
    QLog.i("NotifyMsgManager", 2, "notifyUI btype:" + paramakrq.jdField_a_of_type_Int + " bid:" + paramakrq.jdField_a_of_type_JavaLangString);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (((paramInt != 1) && (paramInt != 3000)) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = akww.a();
    } while (localQQAppInterface == null);
    paramString2 = new akro(0, localQQAppInterface.getLongAccountUin(), 2, paramString2, 0L, null);
    paramString2.a("groupUin", paramString1);
    paramString2.a("groupType", paramInt);
    a(localQQAppInterface.getLongAccountUin(), paramString2);
  }
  
  public static void a(ArrayList<akro> paramArrayList, boolean paramBoolean)
  {
    ThreadManager.post(new NotifyMsgManager.4(paramBoolean, paramArrayList), 5, null, false);
  }
  
  public static void a(List<akrq> paramList)
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
        akrq localakrq = (akrq)paramList.next();
        if ((localakrq != null) && (a(localakrq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null, localakrq.jdField_a_of_type_Int, localakrq.jdField_a_of_type_JavaLangString, false))) {
          localArrayList.add(localakrq);
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
        akrq localakrq = (akrq)jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localakrq != null) && (localakrq.jdField_a_of_type_Int == paramInt) && (localakrq.jdField_a_of_type_JavaLangString != null) && (localakrq.jdField_a_of_type_JavaLangString.equals(paramString)) && (localakrq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == paramMessageRecord)) {
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
  
  public static boolean a(MessageRecord paramMessageRecord, akro paramakro, int paramInt, String paramString, boolean paramBoolean)
  {
    akro localakro;
    int i;
    if ((paramMessageRecord != null) && (paramString != null)) {
      if (paramInt == 1)
      {
        localakro = paramakro;
        if (paramakro == null) {
          localakro = a(c, paramInt, paramString);
        }
        if (localakro == null) {
          break label241;
        }
        i = localakro.a("state", -1);
        paramakro = paramMessageRecord.getExtInfoFromExtStr("qqpay_state");
        if (TextUtils.isEmpty(paramakro)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramInt = Integer.valueOf(paramakro).intValue();
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
      catch (Exception paramakro)
      {
        if (QLog.isColorLevel()) {
          paramakro.printStackTrace();
        }
      }
      paramInt = -1;
      continue;
      if (paramInt == 2)
      {
        localakro = paramakro;
        if (paramakro == null) {
          localakro = a(c, paramInt, paramString);
        }
        if ((localakro != null) && ((paramMessageRecord instanceof MessageForQQWalletMsg)))
        {
          paramakro = (MessageForQQWalletMsg)paramMessageRecord;
          if ((paramakro.mQQWalletRedPacketMsg != null) && (paramakro.mQQWalletRedPacketMsg.isOpened))
          {
            paramakro.mQQWalletRedPacketMsg.isOpened = true;
            paramakro.msgData = paramakro.getBytes();
            paramString = akww.a();
            if (paramString != null) {
              paramString.a().a(paramakro.frienduin, paramakro.istroop, paramakro.uniseq, paramakro.msgData);
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
    if (jdField_a_of_type_Akrn != null) {}
    try
    {
      jdField_a_of_type_Akrn.close();
      jdField_a_of_type_Akrn = null;
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
 * Qualified Name:     akrp
 * JD-Core Version:    0.7.0.1
 */