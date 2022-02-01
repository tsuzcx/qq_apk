import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class agsg
{
  private static agsg jdField_a_of_type_Agsg;
  private SparseArray<agsf> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private agsf a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size() - 1;
    while (i >= 0)
    {
      agsf localagsf = (agsf)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localagsf != null) && (localagsf.a(paramLong, paramBoolean))) {
        return localagsf;
      }
      i -= 1;
    }
    return null;
  }
  
  public static agsg a()
  {
    if (jdField_a_of_type_Agsg == null) {}
    try
    {
      if (jdField_a_of_type_Agsg == null) {
        jdField_a_of_type_Agsg = new agsg();
      }
      return jdField_a_of_type_Agsg;
    }
    finally {}
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "mapUniSeqId:: newSeq -> " + paramLong1 + ", originSeq -> " + paramLong2 + ", id -> " + paramInt);
    }
    agsf localagsf = (agsf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localagsf != null) {
      localagsf.a(paramLong1, paramLong2);
    }
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, int paramInt)
  {
    a(paramSessionInfo, paramString, new ArrayList(), 1, paramInt);
  }
  
  public void a(SessionInfo paramSessionInfo, String paramString, List<MessageRecord> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        localArrayList.add(Long.valueOf(localMessageRecord.uniseq));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOrderManager", 2, "onPreForward :: mr.uniseq -> " + localMessageRecord.uniseq + ", forwardID -> " + paramInt2);
        }
      }
    }
    if (paramInt1 == 1) {}
    for (paramList = new agsm();; paramList = new agsh())
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt2, paramList.a(paramSessionInfo, paramString, localArrayList, paramInt2));
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "onSendResult newSeq -> " + paramLong + ", mForwardEntities.size() => " + this.jdField_a_of_type_AndroidUtilSparseArray.size());
    }
    agsf localagsf = a(paramLong, false);
    if ((localagsf != null) && (localagsf.a(paramQQAppInterface, paramLong))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(localagsf.a);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    agsf localagsf = (agsf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localagsf != null) {
      localagsf.a(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      agsf localagsf = a(paramMessageRecord.uniseq, true);
      if (localagsf != null) {
        localagsf.a(paramQQAppInterface, paramMessageRecord);
      }
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            a(paramQQAppInterface, (MessageRecord)paramList.next());
          }
        }
      }
      finally {}
    }
  }
  
  public void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, int paramInt)
  {
    try
    {
      ((agsf)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsg
 * JD-Core Version:    0.7.0.1
 */