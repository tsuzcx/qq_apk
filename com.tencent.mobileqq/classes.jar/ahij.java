import VACDReport.ReportBody;
import VACDReport.ReportHeader;
import VACDReport.ReportInfo;
import VACDReport.ReportItem;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public final class ahij
  extends SQLiteOpenHelper
{
  public ahij(Context paramContext)
  {
    super(paramContext, "VACDReport.db", null, 7);
  }
  
  private ReportHeader a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(bbco.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportHeader localReportHeader = new ReportHeader();
      localReportHeader.platform = paramString.optString("platform");
      localReportHeader.version = paramString.optString("version");
      localReportHeader.seqno = paramString.optLong("seqno");
      localReportHeader.sAction = paramString.optString("sAction");
      localReportHeader.sModule = paramString.optString("sModule");
      localReportHeader.uin = paramString.optLong("uin");
      localReportHeader.iNetType = paramString.optInt("iNetType");
      localReportHeader.result = paramString.optInt("result");
      localReportHeader.createTime = paramString.optLong("createTime");
      localReportHeader.guid = paramString.optString("guid");
      localReportHeader.imei = paramString.optString("imei");
      localReportHeader.startTime = paramString.optLong("serverTime");
      localReportHeader.sKey = paramString.optString("skey");
      return localReportHeader;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private ReportItem a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new String(bbco.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new JSONObject(paramString);
      ReportItem localReportItem = new ReportItem();
      localReportItem.step = paramString.optString("step");
      localReportItem.createTime = paramString.optLong("createTime");
      localReportItem.params = paramString.optString("params");
      localReportItem.result = paramString.optInt("result");
      localReportItem.failReason = paramString.optString("failReason");
      localReportItem.seqno = paramString.optLong("seqno");
      localReportItem.isNormalEnd = paramString.optBoolean("isNormalEnd");
      return localReportItem;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private String a(ReportHeader paramReportHeader)
  {
    if (paramReportHeader == null) {}
    do
    {
      return null;
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("platform", paramReportHeader.platform);
        localJSONObject.put("version", paramReportHeader.version);
        localJSONObject.put("uin", paramReportHeader.uin);
        localJSONObject.put("seqno", paramReportHeader.seqno);
        localJSONObject.put("sModule", paramReportHeader.sModule);
        localJSONObject.put("sAction", paramReportHeader.sAction);
        localJSONObject.put("iNetType", paramReportHeader.iNetType);
        localJSONObject.put("result", paramReportHeader.result);
        localJSONObject.put("createTime", paramReportHeader.createTime);
        localJSONObject.put("guid", paramReportHeader.guid);
        localJSONObject.put("imei", paramReportHeader.imei);
        localJSONObject.put("serverTime", paramReportHeader.startTime);
        localJSONObject.put("skey", paramReportHeader.sKey);
        paramReportHeader = new String(bbco.encode(localJSONObject.toString().getBytes(), 0));
        return paramReportHeader;
      }
      catch (Exception paramReportHeader) {}
    } while (!QLog.isColorLevel());
    QLog.e("VACDReport", 2, "convertHeaderToString exception:  " + paramReportHeader.toString());
    return null;
  }
  
  private String a(ReportItem paramReportItem)
  {
    if (paramReportItem == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("step", paramReportItem.step);
      localJSONObject.put("createTime", paramReportItem.createTime);
      localJSONObject.put("params", paramReportItem.params);
      localJSONObject.put("result", paramReportItem.result);
      localJSONObject.put("failReason", paramReportItem.failReason);
      localJSONObject.put("seqno", paramReportItem.seqno);
      localJSONObject.put("isNormalEnd", paramReportItem.isNormalEnd);
      paramReportItem = new String(bbco.encode(localJSONObject.toString().getBytes(), 0));
      return paramReportItem;
    }
    catch (Exception paramReportItem) {}
    return null;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ").append("ReportItem");
    localStringBuilder.append(" (");
    localStringBuilder.append("seqno").append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("createTime").append(" INTEGER(16) NOT NULL, ");
    localStringBuilder.append("type").append(" INTEGER DEFAULT 0, ");
    localStringBuilder.append("content").append(" VARCHAR(255))");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE INDEX IF NOT EXISTS ").append("RTIndex");
    localStringBuilder.append(" ON ").append("ReportItem").append('(');
    localStringBuilder.append("seqno").append(',');
    localStringBuilder.append("createTime").append(',');
    localStringBuilder.append("type").append(')');
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  public Map<Long, ReportInfo> a(Map<Long, ReportInfo> paramMap)
  {
    for (;;)
    {
      Object localObject4;
      Cursor localCursor2;
      Object localObject2;
      Object localObject1;
      Cursor localCursor1;
      Object localObject3;
      try
      {
        long l1 = System.currentTimeMillis();
        ArrayList localArrayList = new ArrayList();
        localObject4 = null;
        localCursor2 = null;
        localObject2 = null;
        localObject1 = null;
        localCursor1 = localCursor2;
        localObject3 = localObject4;
        try
        {
          localSQLiteDatabase = getReadableDatabase();
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localObject4;
          localCursor2 = localSQLiteDatabase.rawQuery("SELECT i.* FROM ReportItem i ORDER BY i.seqno,i.createTime ASC", new String[0]);
          if (localCursor2 == null) {
            break label1254;
          }
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          if (localCursor2.getCount() <= 0) {
            break label1254;
          }
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          int i = localCursor2.getColumnIndexOrThrow("seqno");
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          int j = localCursor2.getColumnIndexOrThrow("content");
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          int k = localCursor2.getColumnIndexOrThrow("type");
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          localCursor2.moveToFirst();
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          if (localCursor2.isAfterLast()) {
            break label1254;
          }
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          l2 = localCursor2.getLong(i);
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          m = localCursor2.getInt(k);
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          localObject4 = localCursor2.getString(j);
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          localReportInfo = (ReportInfo)paramMap.get(Long.valueOf(l2));
          if (1 != m) {
            break label903;
          }
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          localObject5 = a((String)localObject4);
          if (localObject5 != null) {
            continue;
          }
          localObject1 = localSQLiteDatabase;
          localCursor1 = localCursor2;
          localObject2 = localSQLiteDatabase;
          localObject3 = localCursor2;
          if (QLog.isDevelopLevel())
          {
            localObject1 = localSQLiteDatabase;
            localCursor1 = localCursor2;
            localObject2 = localSQLiteDatabase;
            localObject3 = localCursor2;
            QLog.e("VACDReport", 4, "loadAllLocalInfos header convert exception,seqno=" + l2);
          }
        }
        catch (Throwable localThrowable)
        {
          SQLiteDatabase localSQLiteDatabase;
          localObject2 = localObject1;
          localObject3 = localCursor1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localObject2 = localObject1;
          localObject3 = localCursor1;
          QLog.e("VACDReport", 2, "loadAllLocalInfos exception:  " + localThrowable.toString());
          if (localObject1 == null) {
            continue;
          }
          try
          {
            localObject1.close();
            if (localCursor1 != null) {
              localCursor1.close();
            }
          }
          catch (Exception localException3)
          {
            continue;
          }
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.d("VACDReport", 4, "loadAllLocalInfos, costTime=" + (System.currentTimeMillis() - l1) + ", reportInfoSize=" + paramMap.size() + ", seqnoList=" + localArrayList);
          return paramMap;
          localObject4 = localReportInfo;
          if (localReportInfo != null) {
            continue;
          }
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          localObject4 = new ReportInfo();
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          paramMap.put(Long.valueOf(l2), localObject4);
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          ((ReportInfo)localObject4).header = ((ReportHeader)localObject5);
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          if (((ReportInfo)localObject4).body == null) {
            continue;
          }
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          ((ReportInfo)localObject4).body.sKey = ((ReportHeader)localObject5).sKey;
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          ((ReportInfo)localObject4).body.startTime = ((ReportHeader)localObject5).startTime;
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          if ((!QLog.isColorLevel()) || ((m != 0) && (1 != m))) {
            continue;
          }
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          if (localArrayList.contains(String.valueOf(l2))) {
            continue;
          }
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          localArrayList.add(String.valueOf(l2));
          continue;
        }
        finally
        {
          long l2;
          int m;
          ReportInfo localReportInfo;
          Object localObject5;
          if (localObject2 == null) {
            continue;
          }
          try
          {
            localObject2.close();
            if (localObject3 == null) {
              continue;
            }
            ((Cursor)localObject3).close();
          }
          catch (Exception localException2)
          {
            continue;
          }
        }
        localObject1 = localSQLiteDatabase;
        localCursor1 = localCursor2;
        localObject2 = localSQLiteDatabase;
        localObject3 = localCursor2;
        localCursor2.moveToNext();
        continue;
        if (m != 0) {
          continue;
        }
      }
      finally {}
      label903:
      if (localReportInfo == null)
      {
        localObject1 = localThrowable;
        localCursor1 = localCursor2;
        localObject2 = localThrowable;
        localObject3 = localCursor2;
        paramMap.put(Long.valueOf(l2), new ReportInfo());
      }
      else
      {
        localObject1 = localThrowable;
        localCursor1 = localCursor2;
        localObject2 = localThrowable;
        localObject3 = localCursor2;
        if (localReportInfo.body == null)
        {
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          localReportInfo.body = new ReportBody();
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          localReportInfo.body.reportItems = new ArrayList(32);
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          if (localReportInfo.header != null)
          {
            localObject1 = localThrowable;
            localCursor1 = localCursor2;
            localObject2 = localThrowable;
            localObject3 = localCursor2;
            localReportInfo.body.sKey = localReportInfo.header.sKey;
            localObject1 = localThrowable;
            localCursor1 = localCursor2;
            localObject2 = localThrowable;
            localObject3 = localCursor2;
            localReportInfo.body.startTime = localReportInfo.header.startTime;
          }
        }
        localObject1 = localThrowable;
        localCursor1 = localCursor2;
        localObject2 = localThrowable;
        localObject3 = localCursor2;
        localObject5 = a((String)localObject4);
        if (localObject5 == null)
        {
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          if (QLog.isDevelopLevel())
          {
            localObject1 = localThrowable;
            localCursor1 = localCursor2;
            localObject2 = localThrowable;
            localObject3 = localCursor2;
            QLog.e("VACDReport", 4, "loadAllLocalInfos, item convert exception,content=" + (String)localObject4);
          }
        }
        else
        {
          localObject1 = localThrowable;
          localCursor1 = localCursor2;
          localObject2 = localThrowable;
          localObject3 = localCursor2;
          localReportInfo.body.reportItems.add(localObject5);
          continue;
          label1254:
          if (localThrowable != null) {}
          try
          {
            localThrowable.close();
            if (localCursor2 != null) {
              localCursor2.close();
            }
          }
          catch (Exception localException1) {}
        }
      }
    }
  }
  
  /* Error */
  public void a(java.util.List<Long> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +16 -> 19
    //   6: aload_1
    //   7: invokeinterface 368 1 0
    //   12: istore 4
    //   14: iload 4
    //   16: ifeq +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 5
    //   28: aload_0
    //   29: invokevirtual 371	ahij:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 7
    //   34: aload 7
    //   36: astore 5
    //   38: aload 7
    //   40: astore 6
    //   42: aload 7
    //   44: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: aload 7
    //   49: astore 5
    //   51: aload 7
    //   53: astore 6
    //   55: aload_1
    //   56: invokeinterface 375 1 0
    //   61: istore_3
    //   62: aload 7
    //   64: astore 5
    //   66: aload 7
    //   68: astore 6
    //   70: new 173	java/lang/StringBuilder
    //   73: dup
    //   74: iload_3
    //   75: bipush 14
    //   77: imul
    //   78: invokespecial 376	java/lang/StringBuilder:<init>	(I)V
    //   81: astore 8
    //   83: iconst_0
    //   84: istore_2
    //   85: iload_2
    //   86: iload_3
    //   87: if_icmpge +57 -> 144
    //   90: aload 7
    //   92: astore 5
    //   94: aload 7
    //   96: astore 6
    //   98: aload 8
    //   100: aload_1
    //   101: iload_2
    //   102: invokeinterface 379 2 0
    //   107: checkcast 273	java/lang/Long
    //   110: invokevirtual 382	java/lang/Long:longValue	()J
    //   113: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: iload_2
    //   118: iload_3
    //   119: iconst_1
    //   120: isub
    //   121: if_icmpge +350 -> 471
    //   124: aload 7
    //   126: astore 5
    //   128: aload 7
    //   130: astore 6
    //   132: aload 8
    //   134: ldc_w 384
    //   137: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: goto +330 -> 471
    //   144: aload 7
    //   146: astore 5
    //   148: aload 7
    //   150: astore 6
    //   152: aload 7
    //   154: new 173	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 386
    //   164: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 8
    //   169: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   172: ldc_w 388
    //   175: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokevirtual 212	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   184: aload 7
    //   186: astore 5
    //   188: aload 7
    //   190: astore 6
    //   192: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   195: ifeq +41 -> 236
    //   198: aload 7
    //   200: astore 5
    //   202: aload 7
    //   204: astore 6
    //   206: ldc 171
    //   208: iconst_2
    //   209: new 173	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 390
    //   219: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload 8
    //   224: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 323	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 7
    //   238: astore 5
    //   240: aload 7
    //   242: astore 6
    //   244: aload 7
    //   246: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   249: aload 7
    //   251: ifnull -232 -> 19
    //   254: aload 7
    //   256: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   259: aload 7
    //   261: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   264: goto -245 -> 19
    //   267: astore_1
    //   268: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq -252 -> 19
    //   274: ldc 171
    //   276: iconst_2
    //   277: new 173	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   284: ldc_w 398
    //   287: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_1
    //   291: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   294: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: goto -284 -> 19
    //   306: astore_1
    //   307: aload_0
    //   308: monitorexit
    //   309: aload_1
    //   310: athrow
    //   311: astore_1
    //   312: aload 5
    //   314: astore 6
    //   316: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   319: ifeq +36 -> 355
    //   322: aload 5
    //   324: astore 6
    //   326: ldc 171
    //   328: iconst_2
    //   329: new 173	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 400
    //   339: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_1
    //   343: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload 5
    //   357: ifnull -338 -> 19
    //   360: aload 5
    //   362: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   365: aload 5
    //   367: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   370: goto -351 -> 19
    //   373: astore_1
    //   374: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq -358 -> 19
    //   380: ldc 171
    //   382: iconst_2
    //   383: new 173	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   390: ldc_w 398
    //   393: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_1
    //   397: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   400: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: goto -390 -> 19
    //   412: astore_1
    //   413: aload 6
    //   415: ifnull +13 -> 428
    //   418: aload 6
    //   420: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   423: aload 6
    //   425: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   428: aload_1
    //   429: athrow
    //   430: astore 5
    //   432: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq -7 -> 428
    //   438: ldc 171
    //   440: iconst_2
    //   441: new 173	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 398
    //   451: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 5
    //   456: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   459: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: goto -40 -> 428
    //   471: iload_2
    //   472: iconst_1
    //   473: iadd
    //   474: istore_2
    //   475: goto -390 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	478	0	this	ahij
    //   0	478	1	paramList	java.util.List<Long>
    //   84	391	2	i	int
    //   61	60	3	j	int
    //   12	3	4	bool	boolean
    //   26	340	5	localObject1	Object
    //   430	25	5	localException	Exception
    //   23	401	6	localObject2	Object
    //   32	228	7	localSQLiteDatabase	SQLiteDatabase
    //   81	142	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   254	264	267	java/lang/Exception
    //   6	14	306	finally
    //   254	264	306	finally
    //   268	303	306	finally
    //   360	370	306	finally
    //   374	409	306	finally
    //   418	428	306	finally
    //   428	430	306	finally
    //   432	468	306	finally
    //   28	34	311	java/lang/Exception
    //   42	47	311	java/lang/Exception
    //   55	62	311	java/lang/Exception
    //   70	83	311	java/lang/Exception
    //   98	117	311	java/lang/Exception
    //   132	141	311	java/lang/Exception
    //   152	184	311	java/lang/Exception
    //   192	198	311	java/lang/Exception
    //   206	236	311	java/lang/Exception
    //   244	249	311	java/lang/Exception
    //   360	370	373	java/lang/Exception
    //   28	34	412	finally
    //   42	47	412	finally
    //   55	62	412	finally
    //   70	83	412	finally
    //   98	117	412	finally
    //   132	141	412	finally
    //   152	184	412	finally
    //   192	198	412	finally
    //   206	236	412	finally
    //   244	249	412	finally
    //   316	322	412	finally
    //   326	355	412	finally
    //   418	428	430	java/lang/Exception
  }
  
  /* Error */
  public void b(java.util.List<ReportItem> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +14 -> 22
    //   11: aload_1
    //   12: invokeinterface 368 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: invokevirtual 371	ahij:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: aload 5
    //   33: astore_3
    //   34: aload 5
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore 4
    //   50: new 403	android/content/ContentValues
    //   53: dup
    //   54: invokespecial 404	android/content/ContentValues:<init>	()V
    //   57: astore 6
    //   59: aload 5
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: aload_1
    //   67: invokeinterface 408 1 0
    //   72: astore_1
    //   73: aload 5
    //   75: astore_3
    //   76: aload 5
    //   78: astore 4
    //   80: aload_1
    //   81: invokeinterface 413 1 0
    //   86: ifeq +242 -> 328
    //   89: aload 5
    //   91: astore_3
    //   92: aload 5
    //   94: astore 4
    //   96: aload_1
    //   97: invokeinterface 417 1 0
    //   102: checkcast 119	VACDReport/ReportItem
    //   105: astore 7
    //   107: aload 7
    //   109: ifnull -36 -> 73
    //   112: aload 5
    //   114: astore_3
    //   115: aload 5
    //   117: astore 4
    //   119: aload 6
    //   121: invokevirtual 420	android/content/ContentValues:clear	()V
    //   124: aload 5
    //   126: astore_3
    //   127: aload 5
    //   129: astore 4
    //   131: aload 6
    //   133: ldc 62
    //   135: aload 7
    //   137: getfield 135	VACDReport/ReportItem:seqno	J
    //   140: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   143: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   146: aload 5
    //   148: astore_3
    //   149: aload 5
    //   151: astore 4
    //   153: aload 6
    //   155: ldc 205
    //   157: aload_0
    //   158: aload 7
    //   160: invokespecial 425	ahij:a	(LVACDReport/ReportItem;)Ljava/lang/String;
    //   163: invokevirtual 428	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 5
    //   168: astore_3
    //   169: aload 5
    //   171: astore 4
    //   173: aload 6
    //   175: ldc 96
    //   177: aload 7
    //   179: getfield 125	VACDReport/ReportItem:createTime	J
    //   182: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   188: aload 5
    //   190: astore_3
    //   191: aload 5
    //   193: astore 4
    //   195: aload 6
    //   197: ldc 201
    //   199: iconst_0
    //   200: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   206: aload 5
    //   208: astore_3
    //   209: aload 5
    //   211: astore 4
    //   213: aload 5
    //   215: ldc 195
    //   217: aconst_null
    //   218: aload 6
    //   220: invokevirtual 440	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   223: pop2
    //   224: goto -151 -> 73
    //   227: astore_1
    //   228: aload_3
    //   229: astore 4
    //   231: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq +35 -> 269
    //   237: aload_3
    //   238: astore 4
    //   240: ldc 171
    //   242: iconst_4
    //   243: new 173	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 442
    //   253: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_1
    //   257: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   260: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: aload_3
    //   270: ifnull -248 -> 22
    //   273: aload_3
    //   274: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   277: aload_3
    //   278: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   281: goto -259 -> 22
    //   284: astore_1
    //   285: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq -266 -> 22
    //   291: ldc 171
    //   293: iconst_4
    //   294: new 173	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   301: ldc_w 444
    //   304: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload_1
    //   308: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   311: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   320: goto -298 -> 22
    //   323: astore_1
    //   324: aload_0
    //   325: monitorexit
    //   326: aload_1
    //   327: athrow
    //   328: aload 5
    //   330: astore_3
    //   331: aload 5
    //   333: astore 4
    //   335: aload 5
    //   337: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   340: aload 5
    //   342: ifnull -320 -> 22
    //   345: aload 5
    //   347: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   350: aload 5
    //   352: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   355: goto -333 -> 22
    //   358: astore_1
    //   359: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -340 -> 22
    //   365: ldc 171
    //   367: iconst_4
    //   368: new 173	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 444
    //   378: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_1
    //   382: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   385: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: goto -372 -> 22
    //   397: astore_1
    //   398: aload 4
    //   400: ifnull +13 -> 413
    //   403: aload 4
    //   405: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   408: aload 4
    //   410: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   413: aload_1
    //   414: athrow
    //   415: astore_3
    //   416: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -6 -> 413
    //   422: ldc 171
    //   424: iconst_4
    //   425: new 173	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 444
    //   435: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_3
    //   439: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   442: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: goto -38 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	ahij
    //   0	454	1	paramList	java.util.List<ReportItem>
    //   17	2	2	bool	boolean
    //   4	327	3	localObject1	Object
    //   415	24	3	localException	Exception
    //   1	408	4	localObject2	Object
    //   29	322	5	localSQLiteDatabase	SQLiteDatabase
    //   57	162	6	localContentValues	android.content.ContentValues
    //   105	73	7	localReportItem	ReportItem
    // Exception table:
    //   from	to	target	type
    //   25	31	227	java/lang/Exception
    //   38	43	227	java/lang/Exception
    //   50	59	227	java/lang/Exception
    //   66	73	227	java/lang/Exception
    //   80	89	227	java/lang/Exception
    //   96	107	227	java/lang/Exception
    //   119	124	227	java/lang/Exception
    //   131	146	227	java/lang/Exception
    //   153	166	227	java/lang/Exception
    //   173	188	227	java/lang/Exception
    //   195	206	227	java/lang/Exception
    //   213	224	227	java/lang/Exception
    //   335	340	227	java/lang/Exception
    //   273	281	284	java/lang/Exception
    //   11	18	323	finally
    //   273	281	323	finally
    //   285	320	323	finally
    //   345	355	323	finally
    //   359	394	323	finally
    //   403	413	323	finally
    //   413	415	323	finally
    //   416	451	323	finally
    //   345	355	358	java/lang/Exception
    //   25	31	397	finally
    //   38	43	397	finally
    //   50	59	397	finally
    //   66	73	397	finally
    //   80	89	397	finally
    //   96	107	397	finally
    //   119	124	397	finally
    //   131	146	397	finally
    //   153	166	397	finally
    //   173	188	397	finally
    //   195	206	397	finally
    //   213	224	397	finally
    //   231	237	397	finally
    //   240	269	397	finally
    //   335	340	397	finally
    //   403	413	415	java/lang/Exception
  }
  
  /* Error */
  public void c(java.util.List<ReportHeader> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +14 -> 22
    //   11: aload_1
    //   12: invokeinterface 368 1 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: invokevirtual 371	ahij:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: aload 5
    //   33: astore_3
    //   34: aload 5
    //   36: astore 4
    //   38: aload 5
    //   40: invokevirtual 374	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   43: aload 5
    //   45: astore_3
    //   46: aload 5
    //   48: astore 4
    //   50: new 403	android/content/ContentValues
    //   53: dup
    //   54: invokespecial 404	android/content/ContentValues:<init>	()V
    //   57: astore 6
    //   59: aload 5
    //   61: astore_3
    //   62: aload 5
    //   64: astore 4
    //   66: aload_1
    //   67: invokeinterface 408 1 0
    //   72: astore_1
    //   73: aload 5
    //   75: astore_3
    //   76: aload 5
    //   78: astore 4
    //   80: aload_1
    //   81: invokeinterface 413 1 0
    //   86: ifeq +233 -> 319
    //   89: aload 5
    //   91: astore_3
    //   92: aload 5
    //   94: astore 4
    //   96: aload_1
    //   97: invokeinterface 417 1 0
    //   102: checkcast 44	VACDReport/ReportHeader
    //   105: astore 7
    //   107: aload 5
    //   109: astore_3
    //   110: aload 5
    //   112: astore 4
    //   114: aload 6
    //   116: invokevirtual 420	android/content/ContentValues:clear	()V
    //   119: aload 5
    //   121: astore_3
    //   122: aload 5
    //   124: astore 4
    //   126: aload 6
    //   128: ldc 62
    //   130: aload 7
    //   132: getfield 69	VACDReport/ReportHeader:seqno	J
    //   135: invokestatic 277	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: invokevirtual 423	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   141: aload 5
    //   143: astore_3
    //   144: aload 5
    //   146: astore 4
    //   148: aload 6
    //   150: ldc 205
    //   152: aload_0
    //   153: aload 7
    //   155: invokespecial 448	ahij:a	(LVACDReport/ReportHeader;)Ljava/lang/String;
    //   158: invokevirtual 428	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: astore_3
    //   164: aload 5
    //   166: astore 4
    //   168: aload 6
    //   170: ldc 201
    //   172: iconst_1
    //   173: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   179: aload 5
    //   181: astore_3
    //   182: aload 5
    //   184: astore 4
    //   186: aload 6
    //   188: ldc 96
    //   190: iconst_0
    //   191: invokestatic 433	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: invokevirtual 436	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   197: aload 5
    //   199: astore_3
    //   200: aload 5
    //   202: astore 4
    //   204: aload 5
    //   206: ldc 195
    //   208: aconst_null
    //   209: aload 6
    //   211: invokevirtual 440	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   214: pop2
    //   215: goto -142 -> 73
    //   218: astore_1
    //   219: aload_3
    //   220: astore 4
    //   222: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +35 -> 260
    //   228: aload_3
    //   229: astore 4
    //   231: ldc 171
    //   233: iconst_2
    //   234: new 173	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 450
    //   244: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 181	java/lang/Exception:toString	()Ljava/lang/String;
    //   251: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_3
    //   261: ifnull -239 -> 22
    //   264: aload_3
    //   265: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   268: aload_3
    //   269: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: goto -250 -> 22
    //   275: astore_1
    //   276: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq -257 -> 22
    //   282: ldc 171
    //   284: iconst_2
    //   285: new 173	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 450
    //   295: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 301	java/lang/Throwable:toString	()Ljava/lang/String;
    //   302: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: goto -289 -> 22
    //   314: astore_1
    //   315: aload_0
    //   316: monitorexit
    //   317: aload_1
    //   318: athrow
    //   319: aload 5
    //   321: astore_3
    //   322: aload 5
    //   324: astore 4
    //   326: aload 5
    //   328: invokevirtual 393	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   331: aload 5
    //   333: ifnull -311 -> 22
    //   336: aload 5
    //   338: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   341: aload 5
    //   343: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   346: goto -324 -> 22
    //   349: astore_1
    //   350: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq -331 -> 22
    //   356: ldc 171
    //   358: iconst_2
    //   359: new 173	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 450
    //   369: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_1
    //   373: invokevirtual 301	java/lang/Throwable:toString	()Ljava/lang/String;
    //   376: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: goto -363 -> 22
    //   388: astore_1
    //   389: aload 4
    //   391: ifnull +13 -> 404
    //   394: aload 4
    //   396: invokevirtual 396	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   399: aload 4
    //   401: invokevirtual 304	android/database/sqlite/SQLiteDatabase:close	()V
    //   404: aload_1
    //   405: athrow
    //   406: astore_3
    //   407: invokestatic 169	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   410: ifeq -6 -> 404
    //   413: ldc 171
    //   415: iconst_2
    //   416: new 173	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   423: ldc_w 450
    //   426: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_3
    //   430: invokevirtual 301	java/lang/Throwable:toString	()Ljava/lang/String;
    //   433: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: goto -38 -> 404
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	this	ahij
    //   0	445	1	paramList	java.util.List<ReportHeader>
    //   17	2	2	bool	boolean
    //   4	318	3	localObject1	Object
    //   406	24	3	localThrowable	Throwable
    //   1	399	4	localObject2	Object
    //   29	313	5	localSQLiteDatabase	SQLiteDatabase
    //   57	153	6	localContentValues	android.content.ContentValues
    //   105	49	7	localReportHeader	ReportHeader
    // Exception table:
    //   from	to	target	type
    //   25	31	218	java/lang/Exception
    //   38	43	218	java/lang/Exception
    //   50	59	218	java/lang/Exception
    //   66	73	218	java/lang/Exception
    //   80	89	218	java/lang/Exception
    //   96	107	218	java/lang/Exception
    //   114	119	218	java/lang/Exception
    //   126	141	218	java/lang/Exception
    //   148	161	218	java/lang/Exception
    //   168	179	218	java/lang/Exception
    //   186	197	218	java/lang/Exception
    //   204	215	218	java/lang/Exception
    //   326	331	218	java/lang/Exception
    //   264	272	275	java/lang/Throwable
    //   11	18	314	finally
    //   264	272	314	finally
    //   276	311	314	finally
    //   336	346	314	finally
    //   350	385	314	finally
    //   394	404	314	finally
    //   404	406	314	finally
    //   407	442	314	finally
    //   336	346	349	java/lang/Throwable
    //   25	31	388	finally
    //   38	43	388	finally
    //   50	59	388	finally
    //   66	73	388	finally
    //   80	89	388	finally
    //   96	107	388	finally
    //   114	119	388	finally
    //   126	141	388	finally
    //   148	161	388	finally
    //   168	179	388	finally
    //   186	197	388	finally
    //   204	215	388	finally
    //   222	228	388	finally
    //   231	260	388	finally
    //   326	331	388	finally
    //   394	404	406	java/lang/Throwable
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
    b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      switch (paramInt1)
      {
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE VACDReport ADD sendTime INTEGER(16) DEFAULT 0");
        }
        catch (Exception localException1) {}
        continue;
        try
        {
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS VACDReport");
          try
          {
            a(paramSQLiteDatabase);
          }
          catch (Exception localException2) {}
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("VACDReport", 2, "createReportItemTable exception:" + localException2.toString());
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("VACDReport", 2, "VACDReport table is not exists");
            }
          }
        }
        try
        {
          paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN status INTEGER DEFAULT 1");
        }
        catch (Exception localException4) {}
        if (QLog.isColorLevel())
        {
          QLog.e("VACDReport", 2, " TABLE ReportItem add column status is exception=" + localException4.toString());
          continue;
          try
          {
            paramSQLiteDatabase.execSQL("ALTER TABLE ReportItem ADD COLUMN send_time INTEGER(16) DEFAULT 9");
          }
          catch (Exception localException5) {}
          if (QLog.isColorLevel())
          {
            QLog.e("VACDReport", 2, " TABLE ReportItem add column send_time is exception=" + localException5.toString());
            continue;
            try
            {
              b(paramSQLiteDatabase);
            }
            catch (Exception localException6) {}
            if (QLog.isColorLevel()) {
              QLog.e("VACDReport", 2, "createReportRecordTable exception=" + localException6.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahij
 * JD-Core Version:    0.7.0.1
 */