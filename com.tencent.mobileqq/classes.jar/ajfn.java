import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajfn
{
  private static List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static List<MessageRecord> jdField_b_of_type_JavaUtilList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static List<MessageRecord> c = new ArrayList();
  private static List<MessageRecord> d = new ArrayList();
  
  public static long a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (MessageRecord)paramList.get(0);
      if ((paramList instanceof MessageForSystemMsg))
      {
        paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
        if ((paramList != null) && (paramList.msg_seq.has()))
        {
          long l = paramList.msg_seq.get();
          if (l > 0L) {
            return l;
          }
        }
      }
    }
    return 0L;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg)
  {
    if ((paramStructMsg != null) && (paramStructMsg.msg.has())) {
      return String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_code.get()) + String.valueOf(paramStructMsg.req_uin.get()) + String.valueOf(((structmsg.SystemMsg)paramStructMsg.msg.get()).group_msg_type.get());
    }
    return "";
  }
  
  public static ArrayList<MessageRecord> a(List<MessageRecord> paramList)
  {
    if ((QLog.isColorLevel()) && (paramList != null)) {
      QLog.d("TroopNotifyCacheHelper", 2, "noti size is " + paramList.size());
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (localArrayList == null)) {
      return localArrayList;
    }
    HashSet localHashSet = new HashSet();
    HashMap localHashMap = new HashMap();
    aqlz localaqlz = (aqlz)aqlk.a().a(634);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if ((localMessageRecord instanceof MessageForSystemMsg))
      {
        structmsg.StructMsg localStructMsg1 = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
        String str = a(localStructMsg1);
        if (((localStructMsg1 == null) || (localStructMsg1.msg_time == null) || (!localStructMsg1.msg_time.has()) || (localaqlz == null) || (System.currentTimeMillis() - localStructMsg1.msg_time.get() * 1000L <= localaqlz.b * 1000L)) && (localStructMsg1 != null) && (localStructMsg1.msg_seq != null) && (localStructMsg1.msg_seq.has()))
        {
          int i;
          if (localHashSet.contains(Long.valueOf(localStructMsg1.msg_seq.get())))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "duplicateMessages", "Repeat Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
            }
            structmsg.StructMsg localStructMsg2 = (structmsg.StructMsg)localHashMap.get(str);
            if ((localStructMsg2 != null) && (localStructMsg1.msg.sub_type.get() != 1))
            {
              i = 0;
              label319:
              Object localObject;
              int j;
              if (i < localArrayList.size())
              {
                localObject = (MessageRecord)localArrayList.get(i);
                if (localObject != null) {
                  break label359;
                }
                localArrayList.remove(i);
                j = i - 1;
              }
              for (;;)
              {
                i = j + 1;
                break label319;
                break;
                label359:
                localObject = ((MessageForSystemMsg)localObject).getSystemMsg();
                j = i;
                if (localStructMsg2.msg_seq != null)
                {
                  j = i;
                  if (localObject != null)
                  {
                    j = i;
                    if (((structmsg.StructMsg)localObject).msg_seq != null)
                    {
                      j = i;
                      if (((structmsg.StructMsg)localObject).msg_seq.get() == localStructMsg2.msg_seq.get())
                      {
                        localArrayList.remove(i);
                        localArrayList.add(i, localMessageRecord);
                        localHashMap.put(str, localStructMsg1);
                        j = i;
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            if (localHashMap.containsKey(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "duplicateMessages", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
              }
              if (localStructMsg1.msg_seq.get() > ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "duplicateMessages", "New Repeat Undeal Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()), "Old Repeat Undeal Msg Seq =", Long.valueOf(((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get()) });
                }
                i = 0;
                while (i < localArrayList.size())
                {
                  if (((MessageForSystemMsg)localArrayList.get(i)).getSystemMsg().msg_seq.get() == ((structmsg.StructMsg)localHashMap.get(str)).msg_seq.get())
                  {
                    localArrayList.remove(i);
                    localArrayList.add(localMessageRecord);
                    localHashMap.put(str, localStructMsg1);
                  }
                  i += 1;
                }
              }
            }
            else
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "duplicateMessages", "No Repeat Msg Seq =", Long.valueOf(localStructMsg1.msg_seq.get()) });
              }
              localHashMap.put(str, localStructMsg1);
              localArrayList.add(localMessageRecord);
            }
            localHashSet.add(Long.valueOf(localStructMsg1.msg_seq.get()));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<MessageRecord> a()
  {
    return jdField_b_of_type_JavaUtilList;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    return a(b(paramList1, paramList2));
  }
  
  public static void a()
  {
    d.clear();
    jdField_a_of_type_JavaUtilList.clear();
    c.clear();
    jdField_b_of_type_JavaUtilList.clear();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
  }
  
  public static void a(List<MessageRecord> paramList, int paramInt)
  {
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        jdField_b_of_type_JavaUtilList.clear();
        c.clear();
        d.clear();
        Object localObject = (aqlz)aqlk.a().a(634);
        jdField_a_of_type_JavaUtilList = a(jdField_a_of_type_JavaUtilList, paramList);
        if (!((aqlz)localObject).jdField_a_of_type_Boolean)
        {
          d = jdField_a_of_type_JavaUtilList;
          return;
        }
        paramList = jdField_a_of_type_JavaUtilList.iterator();
        i = 0;
        if (paramList.hasNext())
        {
          localObject = (MessageRecord)paramList.next();
          if (!(localObject instanceof MessageForSystemMsg)) {
            break label273;
          }
          structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localObject).getSystemMsg();
          if ((localStructMsg == null) || (!localStructMsg.msg.has())) {
            break label273;
          }
          int j = ((structmsg.SystemMsg)localStructMsg.msg.get()).group_msg_type.get();
          int k = ((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get();
          if ((j == 13) || (j == 6))
          {
            jdField_b_of_type_JavaUtilList.add(localObject);
            if ((i < paramInt) && (!jdField_a_of_type_Boolean)) {
              jdField_a_of_type_Boolean = true;
            }
            if (k != 1) {
              break label273;
            }
            c.add(localObject);
            if ((i >= paramInt) || (jdField_b_of_type_Boolean)) {
              break label273;
            }
            jdField_b_of_type_Boolean = true;
            break label273;
          }
          d.add(localObject);
        }
      }
      return;
      label273:
      i += 1;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_b_of_type_Boolean;
  }
  
  public static List<MessageRecord> b()
  {
    return c;
  }
  
  public static List<MessageRecord> b(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return paramList1;
    }
    if (a(paramList1) >= a(paramList2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "insertAddedMessageToOri", "insertAddedMessageToOri pull" });
      }
      paramList1.addAll(paramList2);
      return paramList1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotifyCacheHelper", 2, new Object[] { "insertAddedMessageToOri", "insertAddedMessageToOri push" });
    }
    paramList2.addAll(paramList1);
    return paramList2;
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static List<MessageRecord> c()
  {
    return d;
  }
  
  public static List<MessageRecord> d()
  {
    return jdField_a_of_type_JavaUtilList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfn
 * JD-Core Version:    0.7.0.1
 */