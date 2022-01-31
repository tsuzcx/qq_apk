import android.util.SparseArray;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class adgc
{
  private static adgc jdField_a_of_type_Adgc;
  private SparseArray<adgb> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  private adgb a(long paramLong, boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseArray.size() - 1;
    while (i >= 0)
    {
      adgb localadgb = (adgb)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if ((localadgb != null) && (localadgb.a(paramLong, paramBoolean))) {
        return localadgb;
      }
      i -= 1;
    }
    return null;
  }
  
  public static adgc a()
  {
    if (jdField_a_of_type_Adgc == null) {}
    try
    {
      if (jdField_a_of_type_Adgc == null) {
        jdField_a_of_type_Adgc = new adgc();
      }
      return jdField_a_of_type_Adgc;
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
    adgb localadgb = (adgb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localadgb != null) {
      localadgb.a(paramLong1, paramLong2);
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
    for (paramList = new adgi();; paramList = new adgd())
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
    adgb localadgb = a(paramLong, false);
    if ((localadgb != null) && (localadgb.a(paramQQAppInterface, paramLong))) {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(localadgb.a);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    adgb localadgb = (adgb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localadgb != null) {
      localadgb.a(paramQQAppInterface, paramLong);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      adgb localadgb = a(paramMessageRecord.uniseq, true);
      if (localadgb != null) {
        localadgb.a(paramQQAppInterface, paramMessageRecord);
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
      ((adgb)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).b(paramMessageRecord1.uniseq, paramMessageRecord2.uniseq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgc
 * JD-Core Version:    0.7.0.1
 */