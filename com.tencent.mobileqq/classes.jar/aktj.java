import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.FTSMessageDelete;
import com.tencent.mobileqq.data.FTSMessageSync;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.mobileqq.data.fts.FTSMessageForDel;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.persistence.fts.FTSMsgCounter;
import com.tencent.mobileqq.utils.fts.FTSMessageCodec;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class aktj
  extends akti
{
  private aukv jdField_a_of_type_Aukv;
  private HashMap<String, FTSMsgCounter> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private CopyOnWriteArrayList<FTSEntity> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  long b;
  long c;
  private int d;
  private int e;
  
  public aktj(QQAppInterface paramQQAppInterface, aktm paramaktm)
  {
    super(paramQQAppInterface, paramaktm);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private long a()
  {
    return BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).getLong("key_last_msg_time", 0L);
  }
  
  private aukv a()
  {
    if ((this.jdField_a_of_type_Aukv == null) || (!this.jdField_a_of_type_Aukv.a())) {
      this.jdField_a_of_type_Aukv = ((aukv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
    }
    return this.jdField_a_of_type_Aukv;
  }
  
  private void a(long paramLong)
  {
    BaseApplication.getContext().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_msg_time", paramLong).commit();
  }
  
  private boolean a(long paramLong, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a())) {
      localArrayList = new ArrayList(50);
    }
    for (;;)
    {
      Object localObject3;
      int i;
      int j;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList)
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
          break label661;
        }
        localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
        i = 0;
        Object localObject4;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FTSEntity)((Iterator)localObject3).next();
          ((FTSEntity)localObject4).preWrite();
          try
          {
            localArrayList.add(localObject4);
            i += ((FTSEntity)localObject4).mSegmentCount;
          }
          catch (Throwable localThrowable)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase failure: ", localThrowable);
            }
            return false;
          }
        }
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
        if (!localThrowable.isEmpty())
        {
          j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(localThrowable, paramInt1, paramInt2);
          if (j == -1) {
            break label518;
          }
          if (paramInt1 != 2) {
            break label509;
          }
          this.jdField_b_of_type_Int = j;
          paramLong = System.currentTimeMillis() - paramLong;
          this.jdField_c_of_type_Int += localThrowable.size();
          this.jdField_a_of_type_Long += paramLong;
          if ((QLog.isColorLevel()) || (paramLong > 60000L))
          {
            long l = this.d;
            if (this.d == 0) {
              break label588;
            }
            localObject3 = new StringBuilder(50);
            localObject4 = ((StringBuilder)localObject3).append(getClass().getSimpleName());
            if (paramInt1 != 2) {
              break label605;
            }
            ??? = " Delete";
            ((StringBuilder)localObject4).append((String)???).append(" count:").append(localThrowable.size()).append(" cost:").append(paramLong).append(" indexCnt:").append(this.d).append(" preIndexCnt:").append(l).append(" segmentTotal:").append(i);
            if (paramInt1 == 1) {
              ((StringBuilder)localObject3).append(" assistTroopCount:").append(this.e);
            }
            l = a();
            if ((paramLong <= 30000L) || (System.currentTimeMillis() - l <= 86400000L)) {
              break label629;
            }
            QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
            localObject3 = new HashMap();
            if (paramInt1 != 2) {
              break label613;
            }
            ??? = " Delete";
            ((HashMap)localObject3).put("param_type", ???);
            ((HashMap)localObject3).put("param_count", String.valueOf(localThrowable.size()));
            ((HashMap)localObject3).put("param_stotal", String.valueOf(i));
            if (paramInt1 != 1) {
              break label621;
            }
            ??? = String.valueOf(this.e);
            ((HashMap)localObject3).put("param_assist_cnt", ???);
            axrl.a(BaseApplication.getContext()).a(null, "actFTSMsgCost", true, paramLong, 0L, (HashMap)localObject3, null, false);
            a(System.currentTimeMillis());
          }
        }
        return true;
      }
      label509:
      this.jdField_a_of_type_Int = j;
      continue;
      label518:
      if (paramInt1 == 2) {
        this.jdField_b_of_type_Int += paramInt2;
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label586;
        }
        QLog.d("Q.fts.FTSMsgOperator", 2, String.format("write fts failed mode=%d, cursorStep=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        break;
        this.jdField_a_of_type_Int += paramInt2;
      }
      label586:
      continue;
      label588:
      this.d = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("IndexContent");
      continue;
      label605:
      ??? = " Insert";
      continue;
      label613:
      ??? = " Insert";
      continue;
      label621:
      ??? = "0";
      continue;
      label629:
      QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
      continue;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase ftsDatabase not init");
        continue;
        label661:
        i = 0;
      }
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.a("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramSQLiteDatabase = ((aukn)localObject).a(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, "_id", String.valueOf(300));
    ((aukn)localObject).a();
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("transToDBForInsert size: ");
      if (paramSQLiteDatabase != null)
      {
        i = paramSQLiteDatabase.size();
        QLog.i("Q.fts.FTSMsgOperator", 2, i);
      }
    }
    else
    {
      this.e = 0;
      if ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.isEmpty())) {
        break label309;
      }
      i = 0;
      label154:
      if (i >= paramSQLiteDatabase.size()) {
        break label311;
      }
      localObject = FTSMessageCodec.a((FTSMessageSync)paramSQLiteDatabase.get(i));
      if ((((FTSMessage)localObject).mType != -1) && ((((FTSMessage)localObject).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessage)localObject).mContent))) && (((FTSMessage)localObject).mOId != -1L)) {
        break label233;
      }
    }
    for (;;)
    {
      i += 1;
      break label154;
      i = 0;
      break;
      label233:
      ((FTSMessage)localObject).msgCounter = a(String.valueOf(((FTSMessage)localObject).uin));
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(String.valueOf(((FTSMessage)localObject).uin)) == 2) {
          this.e += 1;
        }
      }
      catch (Throwable paramSQLiteDatabase)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "transToDBForInsert failure: ", paramSQLiteDatabase);
        }
      }
    }
    label309:
    return false;
    label311:
    return a(l, 1, paramSQLiteDatabase.size());
  }
  
  private boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    boolean bool2 = false;
    int j = 0;
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.a("msg_del_log", "_id<=?", new String[] { String.valueOf(this.jdField_b_of_type_Int) });
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramSQLiteDatabase = ((aukn)localObject1).a(FTSMessageDelete.class, "msg_del_log", false, "_id>?", new String[] { String.valueOf(this.jdField_b_of_type_Int) }, null, null, "_id", String.valueOf(50));
    ((aukn)localObject1).a();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("transToDBForDelete size: ");
      if (paramSQLiteDatabase == null) {
        break label248;
      }
    }
    Object localObject2;
    label248:
    for (int i = paramSQLiteDatabase.size();; i = 0)
    {
      QLog.i("Q.fts.FTSMsgOperator", 2, i);
      bool1 = bool2;
      if (paramSQLiteDatabase == null) {
        break label651;
      }
      bool1 = bool2;
      if (paramSQLiteDatabase.isEmpty()) {
        break label651;
      }
      localObject1 = new ArrayList(paramSQLiteDatabase.size());
      i = 0;
      for (;;)
      {
        if (i >= paramSQLiteDatabase.size()) {
          break label280;
        }
        localObject2 = (FTSMessageDelete)paramSQLiteDatabase.get(i);
        if ((((FTSMessageDelete)localObject2).mType != -1) && ((((FTSMessageDelete)localObject2).mOpt == 16) || (!TextUtils.isEmpty(((FTSMessageDelete)localObject2).mContent))) && (((FTSMessageDelete)localObject2).mOId != -1L)) {
          break;
        }
        i += 1;
      }
    }
    label280:
    label301:
    Object localObject3;
    String str;
    if (((FTSMessageDelete)localObject2).mode == 2) {
      if ((!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) || (!((ArrayList)localObject1).isEmpty()))
      {
        if (((ArrayList)localObject1).size() <= 0) {
          break label636;
        }
        localObject2 = new HashMap(10);
        i = j;
        if (i >= ((ArrayList)localObject1).size()) {
          break label584;
        }
        localObject3 = FTSMessageCodec.a((FTSMessageSync)((ArrayList)localObject1).get(i));
        str = FTSMessage.getExt1(((FTSMessage)localObject3).uin, ((FTSMessage)localObject3).istroop);
        if (!((HashMap)localObject2).containsKey(str)) {
          break label505;
        }
        ((FTSMessageForDel)((HashMap)localObject2).get(str)).appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
      }
    }
    for (;;)
    {
      i += 1;
      break label301;
      localObject3 = FTSMessageCodec.a((FTSMessageSync)localObject2);
      ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
      ((FTSMessageForDel)localObject3).msgCounter = ((FTSMessageDelete)localObject2).delCounter;
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
      break label280;
      if (((FTSMessageDelete)localObject2).mode == 4)
      {
        localObject3 = FTSMessageCodec.a((FTSMessageSync)localObject2);
        ((FTSMessageForDel)localObject3).mode = ((FTSMessageDelete)localObject2).mode;
        ((FTSMessageForDel)localObject3).deleteOpt();
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject3);
        break;
      }
      if (((FTSMessageDelete)localObject2).mOId == -9223372036854775808L)
      {
        localObject2 = FTSMessageCodec.a((FTSMessageSync)localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localObject2);
        break;
      }
      ((ArrayList)localObject1).add(localObject2);
      break;
      label505:
      FTSMessageForDel localFTSMessageForDel = new FTSMessageForDel();
      localFTSMessageForDel.mOpt = ((FTSMessage)localObject3).mOpt;
      localFTSMessageForDel.mType = ((FTSMessage)localObject3).mType;
      localFTSMessageForDel.msgtype = ((FTSMessage)localObject3).msgtype;
      localFTSMessageForDel.mExt1Key = str;
      localFTSMessageForDel.mode = 1;
      localFTSMessageForDel.appendOId((FTSMessageDelete)((ArrayList)localObject1).get(i));
      ((HashMap)localObject2).put(str, localFTSMessageForDel);
    }
    label584:
    localObject1 = ((HashMap)localObject2).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(((Map.Entry)localObject2).getValue());
    }
    label636:
    boolean bool1 = a(l, 2, paramSQLiteDatabase.size());
    label651:
    return bool1;
  }
  
  public int a()
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, null, null);
    if (localList != null) {
      i = localList.size();
    }
    return i;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("IndexContent");
    }
    return this.d;
  }
  
  public long a(String paramString)
  {
    long l1;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      long l2 = ((FTSMsgCounter)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).mCounter;
      l1 = l2;
      if (System.currentTimeMillis() - this.jdField_b_of_type_Long > 30000L)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounterForInsert uin:" + paramString + " ret:" + l2);
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          l1 = l2;
        }
      }
    }
    do
    {
      return l1;
      l1 = 0L;
    } while (!QLog.isColorLevel());
    QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounterForInsert uin:" + paramString + " not exist? why?");
    return 0L;
  }
  
  public ArrayList<FTSEntity> a(long paramLong, Pair<CharSequence, CharSequence> paramPair)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      Object localObject = akth.a(FTSMessage.class, String.valueOf(paramLong));
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a((aulw)localObject);
      if ((paramPair != null) && (localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          FTSEntity localFTSEntity = (FTSEntity)localIterator.next();
          if ((localFTSEntity instanceof FTSMessage))
          {
            ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
            ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
          }
        }
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a())) {
      if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {}
    }
    while (!QLog.isColorLevel())
    {
      long l1;
      do
      {
        return null;
        l1 = System.nanoTime();
        localObject = paramString.trim().toLowerCase();
        paramString = bbma.a((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
        }
      } while ((paramString == null) || (paramString.length == 0));
      long l2 = System.nanoTime();
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
      }
      Object localObject = bbma.a((String)localObject);
      paramString = akth.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
    }
    QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
        return null;
      }
      long l1 = System.nanoTime();
      Object localObject = paramString.trim().toLowerCase();
      paramString = bbma.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
      }
      if ((paramString == null) || (paramString.length == 0)) {
        return null;
      }
      long l2 = System.nanoTime();
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
      }
      localObject = bbma.a((String)localObject);
      paramString = akth.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString1, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase != null) && (this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a()))
    {
      if ((paramString1 == null) || (TextUtils.isEmpty(paramString1))) {
        return null;
      }
      Object localObject = paramString1.trim().toLowerCase();
      paramString1 = bbma.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString1));
      }
      if ((paramString1 == null) || (paramString1.length == 0)) {
        return null;
      }
      localObject = bbma.a((String)localObject);
      paramString1 = akth.a(paramString1, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt, paramString2);
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a(paramString1);
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.fts.FTSMsgOperator", 2, "ftsDatabase not init");
    }
    return null;
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, int paramInt)
  {
    return a(paramString, paramClass, paramBoolean1, paramBoolean2, 1, FTSMessage.getExt1(paramLong, paramInt));
  }
  
  public ArrayList<FTSEntity> a(String paramString, Class<? extends FTSEntity> paramClass, boolean paramBoolean1, boolean paramBoolean2, long paramLong, Pair<CharSequence, CharSequence> paramPair)
  {
    paramString = a(paramString, paramClass, paramBoolean1, paramBoolean2, 2, String.valueOf(paramLong));
    if ((paramPair != null) && (paramString != null) && (!paramString.isEmpty()))
    {
      paramClass = paramString.iterator();
      while (paramClass.hasNext())
      {
        FTSEntity localFTSEntity = (FTSEntity)paramClass.next();
        if ((localFTSEntity instanceof FTSMessage))
        {
          ((FTSMessage)localFTSEntity).matchTitle = ((CharSequence)paramPair.first);
          ((FTSMessage)localFTSEntity).matchSecondTitle = ((CharSequence)paramPair.second);
        }
      }
    }
    return paramString;
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_a_of_type_Aukv != null) && (this.jdField_a_of_type_Aukv.a())) {
      this.jdField_a_of_type_Aukv.a();
    }
  }
  
  public void a(aktd paramaktd, aukn paramaukn)
  {
    Object localObject1;
    Object localObject2;
    if ((paramaktd.c != null) && (!TextUtils.isEmpty(paramaktd.c)))
    {
      if (paramaktd.jdField_a_of_type_AndroidContentContentValues == null) {
        return;
      }
      localObject1 = "SELECT * FROM " + paramaktd.b + " WHERE " + paramaktd.c + ";";
      localObject2 = new String[paramaktd.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramaktd.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localObject2[i] = paramaktd.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      localObject1 = a().a((String)localObject1, paramaktd.b, paramaktd.c, (String[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject1 != null) && (bbma.a(paramaktd.jdField_a_of_type_AndroidContentContentValues))) {
        paramaktd = ((List)localObject1).iterator();
      }
    }
    while (paramaktd.hasNext())
    {
      localObject1 = (MessageRecord)paramaktd.next();
      if ((((MessageRecord)localObject1).isSupportFTS()) && (((MessageRecord)localObject1).isValid) && (((MessageRecord)localObject1).msgtype != -2006))
      {
        localObject1 = FTSMessageCodec.a((MessageRecord)localObject1);
        ((FTSMessage)localObject1).deleteOpt();
        paramaukn.b(FTSMessageCodec.a((FTSMessage)localObject1));
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "updateMessageSync 1 msg:" + ((FTSMessage)localObject1).toString());
          continue;
          if ((localObject1 != null) && (bbma.b(paramaktd.jdField_a_of_type_AndroidContentContentValues)))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject3 = (MessageRecord)((Iterator)localObject1).next();
              if ((((MessageRecord)localObject3).isSupportFTS()) && (((MessageRecord)localObject3).isValid) && (((MessageRecord)localObject3).msgtype != -2006))
              {
                if ((localObject3 instanceof MessageForStructing)) {
                  ((MessageForStructing)localObject3).parse();
                }
                localObject2 = FTSMessageCodec.a((MessageRecord)localObject3);
                ((FTSMessage)localObject2).deleteOpt();
                paramaukn.b(FTSMessageCodec.a((FTSMessage)localObject2));
                localObject3 = bbma.a(paramaktd.jdField_a_of_type_AndroidContentContentValues, (MessageRecord)localObject3);
                ((FTSMessage)localObject3).insertOpt();
                paramaukn.b(FTSMessageCodec.a((FTSMessage)localObject3));
                if (QLog.isColorLevel())
                {
                  QLog.d("Q.fts.FTSMsgOperator", 2, "updateMessageSync 2 msg:" + ((FTSMessage)localObject2).toString());
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.fts.FTSMsgOperator", 2, "UPDATE MESSAGE, whereClause null");
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void a(aukm paramaukm)
  {
    if (((paramaukm instanceof MessageRecord)) && (((MessageRecord)paramaukm).isSupportFTS()))
    {
      paramaukm = (MessageRecord)paramaukm;
      paramaukm.saveExtInfoToExtStr("ExtraFTSMsgCounter", String.valueOf(b(paramaukm.frienduin)));
    }
  }
  
  public void a(aukm paramaukm, aukn paramaukn)
  {
    if (((paramaukm instanceof MessageRecord)) && (((MessageRecord)paramaukm).isSupportFTS()) && (((MessageRecord)paramaukm).isValid) && (((MessageRecord)paramaukm).msgtype != -2006))
    {
      paramaukm = FTSMessageCodec.a((MessageRecord)paramaukm);
      paramaukm.insertOpt();
      paramaukn.b(FTSMessageCodec.a(paramaukm));
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    this.jdField_a_of_type_Aktp = new aktk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("IndexContent", true);
  }
  
  public long b(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
    {
      localObject = (FTSMsgCounter)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      ((FTSMsgCounter)localObject).mMsgCnt += 1L;
      if (((FTSMsgCounter)localObject).mMsgCnt > 1000L)
      {
        ((FTSMsgCounter)localObject).mCounter += 1L;
        ((FTSMsgCounter)localObject).mMsgCnt = 0L;
        this.jdField_a_of_type_Aukv.a((aukm)localObject);
      }
      for (;;)
      {
        long l = ((FTSMsgCounter)localObject).mCounter;
        if ((System.currentTimeMillis() - this.jdField_c_of_type_Long > 30000L) && (QLog.isColorLevel()))
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter uin:" + paramString + " counter:" + ((FTSMsgCounter)localObject).mCounter + " msgCnt:" + ((FTSMsgCounter)localObject).mMsgCnt);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
        }
        return l;
        if (((FTSMsgCounter)localObject).mMsgCnt % 300L == 0L)
        {
          this.jdField_a_of_type_Aukv.a((aukm)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter update curCounter msgCnt:" + ((FTSMsgCounter)localObject).mMsgCnt);
          }
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    FTSMsgCounter localFTSMsgCounter = new FTSMsgCounter();
    localFTSMsgCounter.mMsgUin = paramString;
    localFTSMsgCounter.mCounter = 0L;
    localFTSMsgCounter.mMsgCnt = 1L;
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localFTSMsgCounter);
    ((aukn)localObject).b(localFTSMsgCounter);
    ((aukn)localObject).a();
    if ((System.currentTimeMillis() - this.jdField_c_of_type_Long > 30000L) && (QLog.isColorLevel()))
    {
      QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter uin:" + paramString + " counter:" + localFTSMsgCounter.mCounter + " msgCnt:" + localFTSMsgCounter.mMsgCnt);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    return 0L;
  }
  
  public void b()
  {
    if (bbma.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
    {
      if (!a()) {
        break label30;
      }
      if (b()) {
        c();
      }
    }
    return;
    label30:
    c();
  }
  
  public void b(aktd paramaktd, aukn paramaukn)
  {
    Object localObject;
    if ((paramaktd.c != null) && (!TextUtils.isEmpty(paramaktd.c)))
    {
      localObject = "SELECT * FROM " + paramaktd.b + " WHERE " + paramaktd.c + ";";
      String[] arrayOfString = new String[paramaktd.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramaktd.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        arrayOfString[i] = paramaktd.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      try
      {
        paramaktd = a().a((String)localObject, paramaktd.b, paramaktd.c, arrayOfString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramaktd == null) {
          break label288;
        }
        paramaktd = paramaktd.iterator();
        while (paramaktd.hasNext())
        {
          localObject = (MessageRecord)paramaktd.next();
          if ((((MessageRecord)localObject).isSupportFTS()) && (((MessageRecord)localObject).isValid) && (((MessageRecord)localObject).msgtype != -2006))
          {
            localObject = FTSMessageCodec.a((MessageRecord)localObject);
            ((FTSMessage)localObject).deleteOpt();
            paramaukn.b(FTSMessageCodec.a((FTSMessage)localObject));
          }
        }
      }
      catch (OutOfMemoryError paramaktd)
      {
        for (;;)
        {
          QLog.e("Q.fts.FTSMsgOperator", 2, paramaktd, new Object[0]);
          paramaktd = null;
        }
      }
    }
    else
    {
      localObject = new FTSMessage();
      ((FTSMessage)localObject).mType = 1;
      ((FTSMessage)localObject).mContent = "DELETE TABLE";
      ((FTSMessage)localObject).mOId = -9223372036854775808L;
    }
    try
    {
      ((FTSMessage)localObject).uin = mqx.a(paramaktd.jdField_a_of_type_JavaLangString);
      ((FTSMessage)localObject).istroop = paramaktd.jdField_a_of_type_Int;
      ((FTSMessage)localObject).deleteOpt();
      paramaukn.b(FTSMessageCodec.a((FTSMessage)localObject));
      label288:
      return;
    }
    catch (NumberFormatException paramaktd) {}
  }
  
  public void c()
  {
    super.c();
    if (1 == bbma.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_a_of_type_Aktm.obtainMessage(1, this).sendToTarget();
    }
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      boolean bool2;
      try
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("SyncCursor");
        bool2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("DeleteCursor");
        if (!bool1) {
          if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("SyncCursor")) {
            return false;
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.FTSMsgOperator", 2, "mWokerThread: failure ", localThrowable1);
        }
        aktb.jdField_a_of_type_Boolean = false;
        return false;
      }
      for (int i = 0;; i = -1)
      {
        if (!bool2) {
          if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("DeleteCursor")) {
            break;
          }
        }
        for (int j = 0;; j = -1)
        {
          int k = i;
          if (i != 1) {
            k = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("SyncCursor");
          }
          this.jdField_a_of_type_Int = k;
          if (k == -1) {
            break;
          }
          i = j;
          if (j != 1) {
            i = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("DeleteCursor");
          }
          this.jdField_b_of_type_Int = i;
          if (i == -1) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.fts.FTSMsgOperator", 2, "startSyncStep: syncCursor = " + k + " delCursor = " + i);
          }
          this.jdField_a_of_type_Boolean = true;
          aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          Object localObject = localaukn.a(FTSMsgCounter.class, false, null, null, null, null, null, null);
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              FTSMsgCounter localFTSMsgCounter = (FTSMsgCounter)((Iterator)localObject).next();
              this.jdField_a_of_type_JavaUtilHashMap.put(localFTSMsgCounter.mMsgUin, localFTSMsgCounter);
            }
          }
          localaukn.a();
          try
          {
            if (this.d != 0) {
              break label343;
            }
            this.d = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("IndexContent");
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("Q.fts.FTSMsgOperator", 1, localThrowable2, new Object[0]);
          }
        }
      }
    }
    label343:
    return true;
  }
  
  public void e()
  {
    if ((!aktb.jdField_a_of_type_Boolean) && (bbma.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase ENABLE = " + aktb.jdField_a_of_type_Boolean + ", FTSUpgradeFlag = " + bbma.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      }
    }
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (a(localSQLiteDatabase));
    b(localSQLiteDatabase);
  }
  
  protected boolean e()
  {
    return true;
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: getstatic 722	aktb:jdField_a_of_type_Boolean	Z
    //   3: ifne +64 -> 67
    //   6: aload_0
    //   7: getfield 71	aktj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokestatic 734	bbma:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   13: ifeq +54 -> 67
    //   16: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +47 -> 66
    //   22: ldc 144
    //   24: iconst_2
    //   25: new 177	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 736
    //   35: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 722	aktb:jdField_a_of_type_Boolean	Z
    //   41: invokevirtual 739	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc_w 741
    //   47: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 71	aktj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokestatic 734	bbma:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   57: invokevirtual 739	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: aload_0
    //   68: getfield 71	aktj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 443	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   74: astore 9
    //   76: aload_0
    //   77: getfield 71	aktj:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   80: invokevirtual 77	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lauko;
    //   83: invokevirtual 300	auko:createEntityManager	()Laukn;
    //   86: astore 7
    //   88: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: aload 9
    //   94: ldc_w 290
    //   97: ldc_w 292
    //   100: iconst_1
    //   101: anewarray 241	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 263	aktj:jdField_a_of_type_Int	I
    //   110: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: aastore
    //   114: invokevirtual 297	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload 7
    //   120: ldc_w 302
    //   123: ldc_w 290
    //   126: iconst_0
    //   127: ldc_w 304
    //   130: iconst_1
    //   131: anewarray 241	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: getfield 263	aktj:jdField_a_of_type_Int	I
    //   140: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   143: aastore
    //   144: aconst_null
    //   145: aconst_null
    //   146: ldc_w 306
    //   149: aconst_null
    //   150: invokevirtual 311	aukn:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   153: astore 8
    //   155: aload 9
    //   157: ldc_w 374
    //   160: ldc_w 292
    //   163: iconst_1
    //   164: anewarray 241	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: aload_0
    //   170: getfield 158	aktj:jdField_b_of_type_Int	I
    //   173: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   176: aastore
    //   177: invokevirtual 297	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 376
    //   186: ldc_w 374
    //   189: iconst_0
    //   190: ldc_w 304
    //   193: iconst_1
    //   194: anewarray 241	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield 158	aktj:jdField_b_of_type_Int	I
    //   203: invokestatic 245	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: aastore
    //   207: aconst_null
    //   208: aconst_null
    //   209: ldc_w 306
    //   212: aconst_null
    //   213: invokevirtual 311	aukn:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   216: astore 9
    //   218: new 401	com/tencent/mobileqq/data/fts/FTSMessageForDel
    //   221: dup
    //   222: invokespecial 419	com/tencent/mobileqq/data/fts/FTSMessageForDel:<init>	()V
    //   225: astore 10
    //   227: aload 10
    //   229: iconst_4
    //   230: putfield 409	com/tencent/mobileqq/data/fts/FTSMessageForDel:mode	I
    //   233: aload 10
    //   235: invokevirtual 416	com/tencent/mobileqq/data/fts/FTSMessageForDel:deleteOpt	()V
    //   238: aload_0
    //   239: getfield 103	aktj:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   242: ifnull +269 -> 511
    //   245: aload_0
    //   246: getfield 103	aktj:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   249: invokevirtual 106	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()Z
    //   252: ifeq +259 -> 511
    //   255: new 108	java/util/ArrayList
    //   258: dup
    //   259: bipush 10
    //   261: invokespecial 109	java/util/ArrayList:<init>	(I)V
    //   264: astore 11
    //   266: aload 11
    //   268: aload 10
    //   270: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: aload 8
    //   276: ifnull +241 -> 517
    //   279: aload 8
    //   281: invokeinterface 319 1 0
    //   286: istore_1
    //   287: aload_0
    //   288: getfield 103	aktj:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   291: aload 11
    //   293: iconst_1
    //   294: iload_1
    //   295: invokevirtual 156	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   298: istore_2
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 263	aktj:jdField_a_of_type_Int	I
    //   304: iload_1
    //   305: iadd
    //   306: putfield 263	aktj:jdField_a_of_type_Int	I
    //   309: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +39 -> 351
    //   315: ldc 144
    //   317: iconst_2
    //   318: iconst_4
    //   319: anewarray 180	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: ldc_w 750
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: iload_1
    //   331: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: ldc_w 752
    //   340: aastore
    //   341: dup
    //   342: iconst_3
    //   343: iload_2
    //   344: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   351: aload 9
    //   353: ifnull +169 -> 522
    //   356: aload 9
    //   358: invokeinterface 319 1 0
    //   363: istore_1
    //   364: aload_0
    //   365: getfield 103	aktj:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   368: aload 11
    //   370: iconst_2
    //   371: iload_1
    //   372: invokevirtual 156	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   375: istore_2
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 158	aktj:jdField_b_of_type_Int	I
    //   381: iload_1
    //   382: iadd
    //   383: putfield 158	aktj:jdField_b_of_type_Int	I
    //   386: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +39 -> 428
    //   392: ldc 144
    //   394: iconst_2
    //   395: iconst_4
    //   396: anewarray 180	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc_w 757
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload_1
    //   408: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_2
    //   414: ldc_w 752
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: iload_2
    //   421: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   428: aload_0
    //   429: getfield 175	aktj:d	I
    //   432: i2l
    //   433: lstore 5
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 103	aktj:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   440: ldc_w 278
    //   443: invokevirtual 281	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	(Ljava/lang/String;)I
    //   446: putfield 175	aktj:d	I
    //   449: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +59 -> 511
    //   455: ldc 144
    //   457: iconst_2
    //   458: bipush 6
    //   460: anewarray 180	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: ldc_w 759
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   474: lload_3
    //   475: lsub
    //   476: invokestatic 764	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   479: aastore
    //   480: dup
    //   481: iconst_2
    //   482: ldc 208
    //   484: aastore
    //   485: dup
    //   486: iconst_3
    //   487: aload_0
    //   488: getfield 175	aktj:d	I
    //   491: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: aastore
    //   495: dup
    //   496: iconst_4
    //   497: ldc 210
    //   499: aastore
    //   500: dup
    //   501: iconst_5
    //   502: lload 5
    //   504: invokestatic 764	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: invokestatic 755	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   511: aload 7
    //   513: invokevirtual 313	aukn:a	()V
    //   516: return
    //   517: iconst_0
    //   518: istore_1
    //   519: goto -232 -> 287
    //   522: iconst_0
    //   523: istore_1
    //   524: goto -160 -> 364
    //   527: astore 8
    //   529: ldc 144
    //   531: iconst_1
    //   532: iconst_2
    //   533: anewarray 180	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: ldc_w 766
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: aload 8
    //   546: invokevirtual 767	java/lang/Exception:toString	()Ljava/lang/String;
    //   549: aastore
    //   550: invokestatic 769	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   553: aload 7
    //   555: invokevirtual 313	aukn:a	()V
    //   558: return
    //   559: astore 8
    //   561: aload 7
    //   563: invokevirtual 313	aukn:a	()V
    //   566: aload 8
    //   568: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	aktj
    //   286	238	1	i	int
    //   298	123	2	j	int
    //   91	384	3	l1	long
    //   433	70	5	l2	long
    //   86	476	7	localaukn	aukn
    //   153	127	8	localList	List
    //   527	18	8	localException	java.lang.Exception
    //   559	8	8	localObject1	Object
    //   74	283	9	localObject2	Object
    //   225	44	10	localFTSMessageForDel	FTSMessageForDel
    //   264	105	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   92	274	527	java/lang/Exception
    //   279	287	527	java/lang/Exception
    //   287	351	527	java/lang/Exception
    //   356	364	527	java/lang/Exception
    //   364	428	527	java/lang/Exception
    //   428	511	527	java/lang/Exception
    //   92	274	559	finally
    //   279	287	559	finally
    //   287	351	559	finally
    //   356	364	559	finally
    //   364	428	559	finally
    //   428	511	559	finally
    //   529	553	559	finally
  }
  
  public boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aktj
 * JD-Core Version:    0.7.0.1
 */