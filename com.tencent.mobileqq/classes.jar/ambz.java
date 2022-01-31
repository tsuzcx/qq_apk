import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ambz
{
  public static String a;
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  private SQLiteOpenHelper jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper;
  private awhg jdField_a_of_type_Awhg = new awhg();
  private com.tencent.mobileqq.app.SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  private com.tencent.mobileqq.app.SQLiteDatabase jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase;
  
  static
  {
    jdField_a_of_type_JavaLangString = alof.aX + "WalFlag";
  }
  
  public ambz(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper  helper = ", paramSQLiteOpenHelper, " this = ", this });
    if (QLog.isColorLevel()) {
      QLog.d("SQLiteOpenHelper", 1, new Object[] { " new SQLiteOpenHelper, db name = ", paramSQLiteOpenHelper.getDatabaseName() });
    }
    this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper = paramSQLiteOpenHelper;
  }
  
  public static final void a(Exception paramException) {}
  
  public com.tencent.mobileqq.app.SQLiteDatabase a()
  {
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getWritableDatabase();
        if ((jdField_a_of_type_Boolean) && (bhtb.e()) && (localSQLiteDatabase != null))
        {
          boolean bool = jdField_b_of_type_Boolean;
          if (bool) {}
        }
      }
      catch (Exception localException)
      {
        android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
        if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
          break label576;
        }
        Object localObject2 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "getWritableDatabase error, ", "dbW = ", localObject2, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
        QLog.e("SQLiteOpenHelper", 1, "getWritableDatabase", localException);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SQLiteOpenHelper", 1, new Object[] { " getWritableDatabase error, db name = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName() });
        a(localException);
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.enableWriteAheadLogging();
        if (localSQLiteDatabase == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SQLiteOpenHelper", 1, new Object[] { "wdbIsNull, ", Integer.valueOf(this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.hashCode()), new Exception(), " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a != localSQLiteDatabase))
          {
            if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
              break label582;
            }
            localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
            if (localSQLiteDatabase == null) {
              break label588;
            }
            Integer localInteger = Integer.valueOf(localSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "check dbWIsNull: ", localObject1, " dbIsNull: ", localInteger });
            this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = new com.tencent.mobileqq.app.SQLiteDatabase(localSQLiteDatabase, this.jdField_a_of_type_Awhg, this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName());
            if (this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
              break label570;
            }
            localObject1 = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "new dbW = ", localObject1, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
          }
          Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "try WAL enalbe exception ", localIllegalStateException, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
        if (QLog.isColorLevel()) {
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " try WAL enalbe exception, db name = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName() });
        }
        jdField_b_of_type_Boolean = true;
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("WriteWALException", "1");
        azri.a(BaseApplicationImpl.getApplication()).a(null, "actWALException", true, 0L, 0L, (HashMap)localObject2, null);
        continue;
      }
      QLog.e("SQLiteOpenHelper", 1, new Object[] { "wdbIsNull, ", Integer.valueOf(this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.hashCode()), " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
      continue;
      label570:
      String str1 = "null";
      continue;
      label576:
      str1 = "null";
      continue;
      label582:
      str1 = "null";
      continue;
      label588:
      String str2 = "null";
    }
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 172	ambz:jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   6: ifnull +94 -> 100
    //   9: aload_0
    //   10: getfield 172	ambz:jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   13: invokevirtual 98	java/lang/Object:hashCode	()I
    //   16: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   19: astore_1
    //   20: aload_0
    //   21: getfield 111	ambz:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   24: ifnull +82 -> 106
    //   27: aload_0
    //   28: getfield 111	ambz:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   31: invokevirtual 98	java/lang/Object:hashCode	()I
    //   34: invokestatic 104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: astore_2
    //   38: ldc 45
    //   40: iconst_1
    //   41: bipush 8
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: ldc 174
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_2
    //   57: ldc 176
    //   59: aastore
    //   60: dup
    //   61: iconst_3
    //   62: aload_2
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 107
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: aload_0
    //   72: getfield 68	ambz:jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   75: aastore
    //   76: dup
    //   77: bipush 6
    //   79: ldc 49
    //   81: aastore
    //   82: dup
    //   83: bipush 7
    //   85: aload_0
    //   86: aastore
    //   87: invokestatic 55	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   90: aload_0
    //   91: getfield 68	ambz:jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper	Landroid/database/sqlite/SQLiteOpenHelper;
    //   94: invokevirtual 179	android/database/sqlite/SQLiteOpenHelper:close	()V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 170
    //   102: astore_1
    //   103: goto -83 -> 20
    //   106: ldc 170
    //   108: astore_2
    //   109: goto -71 -> 38
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	ambz
    //   19	84	1	localObject1	Object
    //   112	4	1	localObject2	Object
    //   37	72	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	112	finally
    //   20	38	112	finally
    //   38	97	112	finally
  }
  
  public com.tencent.mobileqq.app.SQLiteDatabase b()
  {
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getReadableDatabase();
        if ((jdField_a_of_type_Boolean) && (bhtb.e()) && (localSQLiteDatabase != null))
        {
          boolean bool = jdField_b_of_type_Boolean;
          if (bool) {}
        }
      }
      catch (Exception localException)
      {
        android.database.sqlite.SQLiteDatabase localSQLiteDatabase;
        if (this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
          break label562;
        }
        Object localObject2 = Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "getReadableDatabase error, ", "dbR = ", localObject2, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
        QLog.e("SQLiteOpenHelper", 1, "getReadableDatabase", localException);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SQLiteOpenHelper", 1, new Object[] { " getReadableDatabase error, db name = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName() });
        a(localException);
        continue;
      }
      finally {}
      try
      {
        localSQLiteDatabase.enableWriteAheadLogging();
        if (localSQLiteDatabase == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("SQLiteOpenHelper", 1, new Object[] { "rdbIsNull, ", Integer.valueOf(this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.hashCode()), new Exception(), " this =", this });
          }
        }
        else
        {
          if ((this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase == null) || (this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase.a != localSQLiteDatabase))
          {
            if (this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
              break label568;
            }
            localObject1 = Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
            if (localSQLiteDatabase == null) {
              break label574;
            }
            Integer localInteger = Integer.valueOf(localSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "check dbRIsNull: ", localObject1, " dbIsNull: ", localInteger });
            this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase = new com.tencent.mobileqq.app.SQLiteDatabase(localSQLiteDatabase, this.jdField_a_of_type_Awhg, this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName());
            if (this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase == null) {
              break label556;
            }
            localObject1 = Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase.hashCode());
            QLog.d("SQLiteOpenHelper", 1, new Object[] { "new dbR = ", localObject1, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
          }
          Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppSQLiteDatabase;
          return localObject1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        QLog.e("SQLiteOpenHelper", 1, new Object[] { "try WAL enalbe exception ", localIllegalStateException, " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
        if (QLog.isColorLevel()) {
          QLog.d("SQLiteOpenHelper", 1, new Object[] { " try WAL enalbe exception, db name = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.getDatabaseName() });
        }
        jdField_b_of_type_Boolean = true;
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("ReadWALException", "1");
        azri.a(BaseApplicationImpl.getApplication()).a(null, "actWALException", true, 0L, 0L, (HashMap)localObject2, null);
        continue;
      }
      QLog.e("SQLiteOpenHelper", 1, new Object[] { "rdbIsNull, ", Integer.valueOf(this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper.hashCode()), " helper = ", this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper, " this = ", this });
      continue;
      label556:
      String str1 = "null";
      continue;
      label562:
      str1 = "null";
      continue;
      label568:
      str1 = "null";
      continue;
      label574:
      String str2 = "null";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambz
 * JD-Core Version:    0.7.0.1
 */