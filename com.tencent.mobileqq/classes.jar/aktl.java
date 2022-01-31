import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.fts.FTSNewTroopSync;
import com.tencent.mobileqq.persistence.fts.FTSOptSync;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class aktl
  extends aktn
{
  public aktl(QQAppInterface paramQQAppInterface, aktm paramaktm)
  {
    super(paramQQAppInterface, paramaktm);
    this.d = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, aukn paramaukn)
  {
    localObject = null;
    try
    {
      if (this.a > 0)
      {
        i = paramSQLiteDatabase.a(FTSNewTroopSync.class.getSimpleName(), "_id<=?", new String[] { String.valueOf(this.a) });
        if ((QLog.isColorLevel()) && (i > 0)) {
          QLog.d("Q.fts.troop.operator.new", 2, "delete " + FTSNewTroopSync.class.getSimpleName() + " row=" + i);
        }
      }
      paramaukn = paramaukn.a(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
      if (paramaukn == null) {
        break label291;
      }
      paramSQLiteDatabase = new ArrayList(paramaukn.size());
      try
      {
        paramaukn = paramaukn.iterator();
        while (paramaukn.hasNext()) {
          paramSQLiteDatabase.add(((FTSNewTroopSync)paramaukn.next()).transTroopSync());
        }
        QLog.e("Q.fts.troop.operator.new", 1, paramaukn, new Object[0]);
      }
      catch (Throwable paramaukn) {}
    }
    catch (Throwable paramaukn)
    {
      for (;;)
      {
        int i;
        paramSQLiteDatabase = localObject;
        continue;
        paramSQLiteDatabase = null;
      }
    }
    paramaukn = new HashMap();
    paramaukn.put("type", "2");
    axrl.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actGetOptFailed", true, 0L, 0L, paramaukn, null);
    paramaukn = paramSQLiteDatabase;
    label225:
    return paramaukn;
    paramaukn = paramSQLiteDatabase;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        paramaukn = new StringBuilder().append("getOptSyncList size:");
        if (paramSQLiteDatabase == null) {
          break label279;
        }
        i = paramSQLiteDatabase.size();
        QLog.d("Q.fts.troop.operator.new", 2, i);
        return paramSQLiteDatabase;
      }
      catch (Throwable paramaukn) {}
      break;
      label279:
      i = 0;
    }
  }
  
  protected String b()
  {
    return "NewTroopCursor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aktl
 * JD-Core Version:    0.7.0.1
 */