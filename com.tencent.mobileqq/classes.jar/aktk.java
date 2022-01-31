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

public class aktk
  extends aktm
{
  public aktk(QQAppInterface paramQQAppInterface, aktl paramaktl)
  {
    super(paramQQAppInterface, paramaktl);
    this.d = true;
  }
  
  protected FTSOptSync a(int paramInt, long paramLong1, long paramLong2)
  {
    return new FTSNewTroopSync(paramInt, paramLong1, paramLong2);
  }
  
  protected List<FTSOptSync> a(SQLiteDatabase paramSQLiteDatabase, aukp paramaukp)
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
      paramaukp = paramaukp.a(FTSNewTroopSync.class, FTSNewTroopSync.class.getSimpleName(), false, "_id>?", new String[] { String.valueOf(this.a) }, null, null, null, "300");
      if (paramaukp == null) {
        break label291;
      }
      paramSQLiteDatabase = new ArrayList(paramaukp.size());
      try
      {
        paramaukp = paramaukp.iterator();
        while (paramaukp.hasNext()) {
          paramSQLiteDatabase.add(((FTSNewTroopSync)paramaukp.next()).transTroopSync());
        }
        QLog.e("Q.fts.troop.operator.new", 1, paramaukp, new Object[0]);
      }
      catch (Throwable paramaukp) {}
    }
    catch (Throwable paramaukp)
    {
      for (;;)
      {
        int i;
        paramSQLiteDatabase = localObject;
        continue;
        paramSQLiteDatabase = null;
      }
    }
    paramaukp = new HashMap();
    paramaukp.put("type", "2");
    axrn.a(BaseApplicationImpl.getApplication().getApplicationContext()).a(null, "actGetOptFailed", true, 0L, 0L, paramaukp, null);
    paramaukp = paramSQLiteDatabase;
    label225:
    return paramaukp;
    paramaukp = paramSQLiteDatabase;
    for (;;)
    {
      try
      {
        if (!QLog.isColorLevel()) {
          break label225;
        }
        paramaukp = new StringBuilder().append("getOptSyncList size:");
        if (paramSQLiteDatabase == null) {
          break label279;
        }
        i = paramSQLiteDatabase.size();
        QLog.d("Q.fts.troop.operator.new", 2, i);
        return paramSQLiteDatabase;
      }
      catch (Throwable paramaukp) {}
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
 * Qualified Name:     aktk
 * JD-Core Version:    0.7.0.1
 */