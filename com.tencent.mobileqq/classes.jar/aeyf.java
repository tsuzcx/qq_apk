import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class aeyf
{
  private static aeyf jdField_a_of_type_Aeyf;
  private SparseArray<aeye> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private aeye a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size() - 1;
    while (i >= 0)
    {
      aeye localaeye = (aeye)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localaeye != null) && (localaeye.a(paramLong, paramBoolean))) {
        return localaeye;
      }
      i -= 1;
    }
    return null;
  }
  
  public static aeyf a()
  {
    if (jdField_a_of_type_Aeyf == null) {}
    try
    {
      if (jdField_a_of_type_Aeyf == null) {
        jdField_a_of_type_Aeyf = new aeyf();
      }
      return jdField_a_of_type_Aeyf;
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
    aeye localaeye = (aeye)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localaeye != null) {
      localaeye.a(paramLong1, paramLong2);
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
    for (paramList = new aeyl();; paramList = new aeyg())
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
    aeye localaeye = a(paramLong, false);
    if ((localaeye != null) && (localaeye.a(paramQQAppInterface, paramLong))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(localaeye.a);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    aeye localaeye = (aeye)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localaeye != null) {
      localaeye.a(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      aeye localaeye = a(paramMessageRecord.uniseq, true);
      if (localaeye != null) {
        localaeye.a(paramQQAppInterface, paramMessageRecord);
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
      ((aeye)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyf
 * JD-Core Version:    0.7.0.1
 */