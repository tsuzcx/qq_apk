import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class adgf
{
  private static adgf jdField_a_of_type_Adgf;
  private SparseArray<adge> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private adge a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size() - 1;
    while (i >= 0)
    {
      adge localadge = (adge)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localadge != null) && (localadge.a(paramLong, paramBoolean))) {
        return localadge;
      }
      i -= 1;
    }
    return null;
  }
  
  public static adgf a()
  {
    if (jdField_a_of_type_Adgf == null) {}
    try
    {
      if (jdField_a_of_type_Adgf == null) {
        jdField_a_of_type_Adgf = new adgf();
      }
      return jdField_a_of_type_Adgf;
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
    adge localadge = (adge)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localadge != null) {
      localadge.a(paramLong1, paramLong2);
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
    for (paramList = new adgl();; paramList = new adgg())
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
    adge localadge = a(paramLong, false);
    if ((localadge != null) && (localadge.a(paramQQAppInterface, paramLong))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(localadge.a);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    adge localadge = (adge)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localadge != null) {
      localadge.a(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      adge localadge = a(paramMessageRecord.uniseq, true);
      if (localadge != null) {
        localadge.a(paramQQAppInterface, paramMessageRecord);
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
      ((adge)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgf
 * JD-Core Version:    0.7.0.1
 */