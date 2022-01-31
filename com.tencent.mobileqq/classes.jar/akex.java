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
import mqq.app.MobileQQ;

public class akex
  extends akew
{
  private atmx jdField_a_of_type_Atmx;
  private HashMap<String, FTSMsgCounter> jdField_a_of_type_JavaUtilHashMap = new HashMap(20);
  private CopyOnWriteArrayList<FTSEntity> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  long b;
  long c;
  private int d;
  private int e;
  
  public akex(QQAppInterface paramQQAppInterface, akfa paramakfa)
  {
    super(paramQQAppInterface, paramakfa);
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  private long a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).getLong("key_last_msg_time_" + paramQQAppInterface.getAccount(), 0L);
  }
  
  private atmx a()
  {
    if ((this.jdField_a_of_type_Atmx == null) || (!this.jdField_a_of_type_Atmx.a())) {
      this.jdField_a_of_type_Atmx = ((atmx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createMessageRecordEntityManager());
    }
    return this.jdField_a_of_type_Atmx;
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface.getApp().getSharedPreferences("fts_sp_file", 0).edit().putLong("key_last_msg_time_" + paramQQAppInterface.getAccount(), paramLong).commit();
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
          break label675;
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
            break label532;
          }
          if (paramInt1 != 2) {
            break label523;
          }
          this.jdField_b_of_type_Int = j;
          paramLong = System.currentTimeMillis() - paramLong;
          this.jdField_c_of_type_Int += localThrowable.size();
          this.jdField_a_of_type_Long += paramLong;
          if ((QLog.isColorLevel()) || (paramLong > 60000L))
          {
            long l = this.d;
            if (this.d == 0) {
              break label602;
            }
            localObject3 = new StringBuilder(50);
            localObject4 = ((StringBuilder)localObject3).append(getClass().getSimpleName());
            if (paramInt1 != 2) {
              break label619;
            }
            ??? = " Delete";
            ((StringBuilder)localObject4).append((String)???).append(" count:").append(localThrowable.size()).append(" cost:").append(paramLong).append(" indexCnt:").append(this.d).append(" preIndexCnt:").append(l).append(" segmentTotal:").append(i);
            if (paramInt1 == 1) {
              ((StringBuilder)localObject3).append(" assistTroopCount:").append(this.e);
            }
            l = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            if ((paramLong <= 30000L) || (System.currentTimeMillis() - l <= 86400000L)) {
              break label643;
            }
            QLog.e("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
            localObject3 = new HashMap();
            if (paramInt1 != 2) {
              break label627;
            }
            ??? = " Delete";
            ((HashMap)localObject3).put("param_type", ???);
            ((HashMap)localObject3).put("param_count", String.valueOf(localThrowable.size()));
            ((HashMap)localObject3).put("param_stotal", String.valueOf(i));
            if (paramInt1 != 1) {
              break label635;
            }
            ??? = String.valueOf(this.e);
            ((HashMap)localObject3).put("param_assist_cnt", ???);
            awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actFTSMsgCost", true, paramLong, 0L, (HashMap)localObject3, null, false);
            a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, System.currentTimeMillis());
          }
        }
        return true;
      }
      label523:
      this.jdField_a_of_type_Int = j;
      continue;
      label532:
      if (paramInt1 == 2) {
        this.jdField_b_of_type_Int += paramInt2;
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label600;
        }
        QLog.d("Q.fts.FTSMsgOperator", 2, String.format("write fts failed mode=%d, cursorStep=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        break;
        this.jdField_a_of_type_Int += paramInt2;
      }
      label600:
      continue;
      label602:
      this.d = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("IndexContent");
      continue;
      label619:
      ??? = " Insert";
      continue;
      label627:
      ??? = " Insert";
      continue;
      label635:
      ??? = "0";
      continue;
      label643:
      QLog.d("Q.fts.BgCpu", 1, ((StringBuilder)localObject3).toString());
      continue;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.fts.FTSMsgOperator", 2, "internalTransToDatabase ftsDatabase not init");
        continue;
        label675:
        i = 0;
      }
    }
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    paramSQLiteDatabase.a("msg_sync_log", "_id<=?", new String[] { String.valueOf(this.jdField_a_of_type_Int) });
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramSQLiteDatabase = ((atmp)localObject).a(FTSMessageSync.class, "msg_sync_log", false, "_id>?", new String[] { String.valueOf(this.jdField_a_of_type_Int) }, null, null, "_id", String.valueOf(300));
    ((atmp)localObject).a();
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
    paramSQLiteDatabase = ((atmp)localObject1).a(FTSMessageDelete.class, "msg_del_log", false, "_id>?", new String[] { String.valueOf(this.jdField_b_of_type_Int) }, null, null, "_id", String.valueOf(50));
    ((atmp)localObject1).a();
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
      Object localObject = akev.a(FTSMessage.class, String.valueOf(paramLong));
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a((atny)localObject);
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
        paramString = bakq.a((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString));
        }
      } while ((paramString == null) || (paramString.length == 0));
      long l2 = System.nanoTime();
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query: segments cost = " + (l2 - l1) / 1000000L + "ms");
      }
      Object localObject = bakq.a((String)localObject);
      paramString = akev.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2);
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
      paramString = bakq.a((String)localObject);
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
      localObject = bakq.a((String)localObject);
      paramString = akev.a(paramString, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt);
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
      paramString1 = bakq.a((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.FTSMsgOperator", 2, "query segments = " + Arrays.toString(paramString1));
      }
      if ((paramString1 == null) || (paramString1.length == 0)) {
        return null;
      }
      localObject = bakq.a((String)localObject);
      paramString1 = akev.a(paramString1, (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]), paramClass, paramBoolean1, paramBoolean2, paramInt, paramString2);
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
    if ((this.jdField_a_of_type_Atmx != null) && (this.jdField_a_of_type_Atmx.a())) {
      this.jdField_a_of_type_Atmx.a();
    }
  }
  
  public void a(aker paramaker, atmp paramatmp)
  {
    Object localObject1;
    Object localObject2;
    if ((paramaker.c != null) && (!TextUtils.isEmpty(paramaker.c)))
    {
      if (paramaker.jdField_a_of_type_AndroidContentContentValues == null) {
        return;
      }
      localObject1 = "SELECT * FROM " + paramaker.b + " WHERE " + paramaker.c + ";";
      localObject2 = new String[paramaker.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramaker.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localObject2[i] = paramaker.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      localObject1 = a().a((String)localObject1, paramaker.b, paramaker.c, (String[])localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((localObject1 != null) && (bakq.a(paramaker.jdField_a_of_type_AndroidContentContentValues))) {
        paramaker = ((List)localObject1).iterator();
      }
    }
    while (paramaker.hasNext())
    {
      localObject1 = (MessageRecord)paramaker.next();
      if ((((MessageRecord)localObject1).isSupportFTS()) && (((MessageRecord)localObject1).isValid) && (((MessageRecord)localObject1).msgtype != -2006))
      {
        localObject1 = FTSMessageCodec.a((MessageRecord)localObject1);
        ((FTSMessage)localObject1).deleteOpt();
        paramatmp.b(FTSMessageCodec.a((FTSMessage)localObject1));
        if (QLog.isColorLevel())
        {
          QLog.d("Q.fts.FTSMsgOperator", 2, "updateMessageSync 1 msg:" + ((FTSMessage)localObject1).toString());
          continue;
          if ((localObject1 != null) && (bakq.b(paramaker.jdField_a_of_type_AndroidContentContentValues)))
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
                paramatmp.b(FTSMessageCodec.a((FTSMessage)localObject2));
                localObject3 = bakq.a(paramaker.jdField_a_of_type_AndroidContentContentValues, (MessageRecord)localObject3);
                ((FTSMessage)localObject3).insertOpt();
                paramatmp.b(FTSMessageCodec.a((FTSMessage)localObject3));
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
  
  public void a(atmo paramatmo)
  {
    if (((paramatmo instanceof MessageRecord)) && (((MessageRecord)paramatmo).isSupportFTS()))
    {
      paramatmo = (MessageRecord)paramatmo;
      paramatmo.saveExtInfoToExtStr("ExtraFTSMsgCounter", String.valueOf(b(paramatmo.frienduin)));
    }
  }
  
  public void a(atmo paramatmo, atmp paramatmp)
  {
    if (((paramatmo instanceof MessageRecord)) && (((MessageRecord)paramatmo).isSupportFTS()) && (((MessageRecord)paramatmo).isValid) && (((MessageRecord)paramatmo).msgtype != -2006))
    {
      paramatmo = FTSMessageCodec.a((MessageRecord)paramatmo);
      paramatmo.insertOpt();
      paramatmp.b(FTSMessageCodec.a(paramatmo));
    }
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    super.a(paramFTSDatatbase, paramFTSDatabase);
    this.jdField_a_of_type_Akfd = new akey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
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
        this.jdField_a_of_type_Atmx.a((atmo)localObject);
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
          this.jdField_a_of_type_Atmx.a((atmo)localObject);
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
    ((atmp)localObject).b(localFTSMsgCounter);
    ((atmp)localObject).a();
    if ((System.currentTimeMillis() - this.jdField_c_of_type_Long > 30000L) && (QLog.isColorLevel()))
    {
      QLog.d("Q.fts.FTSMsgOperator", 2, "getMsgCounter uin:" + paramString + " counter:" + localFTSMsgCounter.mCounter + " msgCnt:" + localFTSMsgCounter.mMsgCnt);
      this.jdField_c_of_type_Long = System.currentTimeMillis();
    }
    return 0L;
  }
  
  public void b()
  {
    if (bakq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 1)
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
  
  public void b(aker paramaker, atmp paramatmp)
  {
    Object localObject;
    if ((paramaker.c != null) && (!TextUtils.isEmpty(paramaker.c)))
    {
      localObject = "SELECT * FROM " + paramaker.b + " WHERE " + paramaker.c + ";";
      String[] arrayOfString = new String[paramaker.jdField_a_of_type_ArrayOfJavaLangString.length];
      int i = 0;
      while (i < paramaker.jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        arrayOfString[i] = paramaker.jdField_a_of_type_ArrayOfJavaLangString[i];
        i += 1;
      }
      try
      {
        paramaker = a().a((String)localObject, paramaker.b, paramaker.c, arrayOfString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramaker == null) {
          break label288;
        }
        paramaker = paramaker.iterator();
        while (paramaker.hasNext())
        {
          localObject = (MessageRecord)paramaker.next();
          if ((((MessageRecord)localObject).isSupportFTS()) && (((MessageRecord)localObject).isValid) && (((MessageRecord)localObject).msgtype != -2006))
          {
            localObject = FTSMessageCodec.a((MessageRecord)localObject);
            ((FTSMessage)localObject).deleteOpt();
            paramatmp.b(FTSMessageCodec.a((FTSMessage)localObject));
          }
        }
      }
      catch (OutOfMemoryError paramaker)
      {
        for (;;)
        {
          QLog.e("Q.fts.FTSMsgOperator", 2, paramaker, new Object[0]);
          paramaker = null;
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
      ((FTSMessage)localObject).uin = mfy.a(paramaker.jdField_a_of_type_JavaLangString);
      ((FTSMessage)localObject).istroop = paramaker.jdField_a_of_type_Int;
      ((FTSMessage)localObject).deleteOpt();
      paramatmp.b(FTSMessageCodec.a((FTSMessage)localObject));
      label288:
      return;
    }
    catch (NumberFormatException paramaker) {}
  }
  
  public void c()
  {
    super.c();
    if (1 == bakq.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      this.jdField_a_of_type_Akfa.obtainMessage(1, this).sendToTarget();
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
        akep.jdField_a_of_type_Boolean = false;
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
          atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          Object localObject = localatmp.a(FTSMsgCounter.class, false, null, null, null, null, null, null);
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              FTSMsgCounter localFTSMsgCounter = (FTSMsgCounter)((Iterator)localObject).next();
              this.jdField_a_of_type_JavaUtilHashMap.put(localFTSMsgCounter.mMsgUin, localFTSMsgCounter);
            }
          }
          localatmp.a();
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
    if ((!akep.jdField_a_of_type_Boolean) && (bakq.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.FTSMsgOperator", 2, "transToDatabase ENABLE = " + akep.jdField_a_of_type_Boolean + ", FTSUpgradeFlag = " + bakq.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
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
    //   0: getstatic 733	akep:jdField_a_of_type_Boolean	Z
    //   3: ifne +64 -> 67
    //   6: aload_0
    //   7: getfield 87	akex:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10: invokestatic 745	bakq:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   13: ifeq +54 -> 67
    //   16: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +47 -> 66
    //   22: ldc 165
    //   24: iconst_2
    //   25: new 56	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 747
    //   35: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: getstatic 733	akep:jdField_a_of_type_Boolean	Z
    //   41: invokevirtual 750	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: ldc_w 752
    //   47: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: getfield 87	akex:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokestatic 745	bakq:d	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   57: invokevirtual 750	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   60: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 242	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: return
    //   67: aload_0
    //   68: getfield 87	akex:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   74: astore 9
    //   76: aload_0
    //   77: getfield 87	akex:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   80: invokevirtual 91	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Latmq;
    //   83: invokevirtual 312	atmq:createEntityManager	()Latmp;
    //   86: astore 7
    //   88: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: aload 9
    //   94: ldc_w 302
    //   97: ldc_w 304
    //   100: iconst_1
    //   101: anewarray 253	java/lang/String
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 275	akex:jdField_a_of_type_Int	I
    //   110: invokestatic 257	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: aastore
    //   114: invokevirtual 309	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload 7
    //   120: ldc_w 314
    //   123: ldc_w 302
    //   126: iconst_0
    //   127: ldc_w 316
    //   130: iconst_1
    //   131: anewarray 253	java/lang/String
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: getfield 275	akex:jdField_a_of_type_Int	I
    //   140: invokestatic 257	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   143: aastore
    //   144: aconst_null
    //   145: aconst_null
    //   146: ldc_w 318
    //   149: aconst_null
    //   150: invokevirtual 323	atmp:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   153: astore 8
    //   155: aload 9
    //   157: ldc_w 385
    //   160: ldc_w 304
    //   163: iconst_1
    //   164: anewarray 253	java/lang/String
    //   167: dup
    //   168: iconst_0
    //   169: aload_0
    //   170: getfield 179	akex:jdField_b_of_type_Int	I
    //   173: invokestatic 257	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   176: aastore
    //   177: invokevirtual 309	com/tencent/mobileqq/app/SQLiteDatabase:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   180: pop
    //   181: aload 7
    //   183: ldc_w 387
    //   186: ldc_w 385
    //   189: iconst_0
    //   190: ldc_w 316
    //   193: iconst_1
    //   194: anewarray 253	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload_0
    //   200: getfield 179	akex:jdField_b_of_type_Int	I
    //   203: invokestatic 257	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   206: aastore
    //   207: aconst_null
    //   208: aconst_null
    //   209: ldc_w 318
    //   212: aconst_null
    //   213: invokevirtual 323	atmp:a	(Ljava/lang/Class;Ljava/lang/String;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   216: astore 9
    //   218: new 412	com/tencent/mobileqq/data/fts/FTSMessageForDel
    //   221: dup
    //   222: invokespecial 430	com/tencent/mobileqq/data/fts/FTSMessageForDel:<init>	()V
    //   225: astore 10
    //   227: aload 10
    //   229: iconst_4
    //   230: putfield 420	com/tencent/mobileqq/data/fts/FTSMessageForDel:mode	I
    //   233: aload 10
    //   235: invokevirtual 427	com/tencent/mobileqq/data/fts/FTSMessageForDel:deleteOpt	()V
    //   238: aload_0
    //   239: getfield 124	akex:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   242: ifnull +269 -> 511
    //   245: aload_0
    //   246: getfield 124	akex:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   249: invokevirtual 127	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	()Z
    //   252: ifeq +259 -> 511
    //   255: new 129	java/util/ArrayList
    //   258: dup
    //   259: bipush 10
    //   261: invokespecial 130	java/util/ArrayList:<init>	(I)V
    //   264: astore 11
    //   266: aload 11
    //   268: aload 10
    //   270: invokevirtual 155	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   273: pop
    //   274: aload 8
    //   276: ifnull +241 -> 517
    //   279: aload 8
    //   281: invokeinterface 330 1 0
    //   286: istore_1
    //   287: aload_0
    //   288: getfield 124	akex:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   291: aload 11
    //   293: iconst_1
    //   294: iload_1
    //   295: invokevirtual 177	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   298: istore_2
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 275	akex:jdField_a_of_type_Int	I
    //   304: iload_1
    //   305: iadd
    //   306: putfield 275	akex:jdField_a_of_type_Int	I
    //   309: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +39 -> 351
    //   315: ldc 165
    //   317: iconst_2
    //   318: iconst_4
    //   319: anewarray 200	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: ldc_w 761
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: iload_1
    //   331: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: ldc_w 763
    //   340: aastore
    //   341: dup
    //   342: iconst_3
    //   343: iload_2
    //   344: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   347: aastore
    //   348: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   351: aload 9
    //   353: ifnull +169 -> 522
    //   356: aload 9
    //   358: invokeinterface 330 1 0
    //   363: istore_1
    //   364: aload_0
    //   365: getfield 124	akex:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   368: aload 11
    //   370: iconst_2
    //   371: iload_1
    //   372: invokevirtual 177	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;II)I
    //   375: istore_2
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 179	akex:jdField_b_of_type_Int	I
    //   381: iload_1
    //   382: iadd
    //   383: putfield 179	akex:jdField_b_of_type_Int	I
    //   386: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   389: ifeq +39 -> 428
    //   392: ldc 165
    //   394: iconst_2
    //   395: iconst_4
    //   396: anewarray 200	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: ldc_w 768
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload_1
    //   408: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: dup
    //   413: iconst_2
    //   414: ldc_w 763
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: iload_2
    //   421: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   428: aload_0
    //   429: getfield 197	akex:d	I
    //   432: i2l
    //   433: lstore 5
    //   435: aload_0
    //   436: aload_0
    //   437: getfield 124	akex:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   440: ldc_w 290
    //   443: invokevirtual 293	com/tencent/mobileqq/persistence/fts/FTSDatatbase:b	(Ljava/lang/String;)I
    //   446: putfield 197	akex:d	I
    //   449: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +59 -> 511
    //   455: ldc 165
    //   457: iconst_2
    //   458: bipush 6
    //   460: anewarray 200	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: ldc_w 770
    //   468: aastore
    //   469: dup
    //   470: iconst_1
    //   471: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   474: lload_3
    //   475: lsub
    //   476: invokestatic 775	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   479: aastore
    //   480: dup
    //   481: iconst_2
    //   482: ldc 223
    //   484: aastore
    //   485: dup
    //   486: iconst_3
    //   487: aload_0
    //   488: getfield 197	akex:d	I
    //   491: invokestatic 282	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   494: aastore
    //   495: dup
    //   496: iconst_4
    //   497: ldc 225
    //   499: aastore
    //   500: dup
    //   501: iconst_5
    //   502: lload 5
    //   504: invokestatic 775	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: invokestatic 766	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   511: aload 7
    //   513: invokevirtual 325	atmp:a	()V
    //   516: return
    //   517: iconst_0
    //   518: istore_1
    //   519: goto -232 -> 287
    //   522: iconst_0
    //   523: istore_1
    //   524: goto -160 -> 364
    //   527: astore 8
    //   529: ldc 165
    //   531: iconst_1
    //   532: iconst_2
    //   533: anewarray 200	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: ldc_w 777
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: aload 8
    //   546: invokevirtual 778	java/lang/Exception:toString	()Ljava/lang/String;
    //   549: aastore
    //   550: invokestatic 780	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   553: aload 7
    //   555: invokevirtual 325	atmp:a	()V
    //   558: return
    //   559: astore 8
    //   561: aload 7
    //   563: invokevirtual 325	atmp:a	()V
    //   566: aload 8
    //   568: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	akex
    //   286	238	1	i	int
    //   298	123	2	j	int
    //   91	384	3	l1	long
    //   433	70	5	l2	long
    //   86	476	7	localatmp	atmp
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
 * Qualified Name:     akex
 * JD-Core Version:    0.7.0.1
 */