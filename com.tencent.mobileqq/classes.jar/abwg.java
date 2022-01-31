import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.database.corrupt.DBFixResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.HashMap;

public class abwg
  implements Runnable
{
  public abwg(DBFixLoadingDialog paramDBFixLoadingDialog) {}
  
  public void run()
  {
    DBFixLoadingDialog.a(this.a, DBFixLoadingDialog.c);
    if (DBFixLoadingDialog.a(this.a).exists()) {
      DBFixLoadingDialog.a(this.a).delete();
    }
    long l1 = System.currentTimeMillis();
    Object localObject = (DBFixManager)DBFixLoadingDialog.a(this.a).getManager(204);
    DBFixResult localDBFixResult = new DBFixResult();
    QLog.d(DBFixLoadingDialog.a(), 1, new Object[] { "repair start, ", Integer.valueOf(DBFixLoadingDialog.a) });
    boolean bool;
    if (DBFixLoadingDialog.a == 1)
    {
      bool = ((DBFixManager)localObject).dumpRepair(DBFixLoadingDialog.b(this.a).getAbsolutePath(), DBFixLoadingDialog.a(this.a).getAbsolutePath(), localDBFixResult);
      long l2 = System.currentTimeMillis();
      QLog.d(DBFixLoadingDialog.a(), 1, new Object[] { "repair result, dur:", Double.valueOf(localDBFixResult.duration), ", row:", Long.valueOf(localDBFixResult.rowCount), ", table:", Long.valueOf(localDBFixResult.tableCount), ", sucPage:", Long.valueOf(localDBFixResult.sucPageCount), ", failPage:", Long.valueOf(localDBFixResult.failPageCount) });
      if (!bool) {
        break label622;
      }
      long l3 = DBFixLoadingDialog.b(this.a).length();
      long l4 = DBFixLoadingDialog.a(this.a).length();
      String str = DBFixLoadingDialog.a();
      if (DBFixLoadingDialog.a != 1) {
        break label615;
      }
      localObject = "dump";
      label273:
      QLog.d(str, 1, String.format("修复方式：%s 修复成功，耗时%dms，源文件：%dkB，修复后：%dkB", new Object[] { localObject, Long.valueOf(l2 - l1), Long.valueOf(l3 / 1024L), Long.valueOf(l4 / 1024L) }));
      localObject = new HashMap();
      ((HashMap)localObject).put("fixType", String.valueOf(DBFixLoadingDialog.a));
      ((HashMap)localObject).put("duration_1", String.valueOf((int)(localDBFixResult.duration * 1000.0D)));
      ((HashMap)localObject).put("duration_2", String.valueOf(l2 - l1));
      ((HashMap)localObject).put("rowCount", String.valueOf(localDBFixResult.rowCount));
      ((HashMap)localObject).put("tableCount", String.valueOf(localDBFixResult.tableCount));
      ((HashMap)localObject).put("sucPage", String.valueOf(localDBFixResult.sucPageCount));
      ((HashMap)localObject).put("failPage", String.valueOf(localDBFixResult.failPageCount));
      ((HashMap)localObject).put("oldSize", String.valueOf(l3 / 1024L));
      ((HashMap)localObject).put("fixSize", String.valueOf(l4 / 1024L));
      ((HashMap)localObject).put("fixSpeed", String.valueOf((float)(l3 / 1024L) / (float)(l2 - l1)));
      StatisticCollector.a(BaseApplication.getContext()).a(null, DBFixManager.h, true, -1L, 0L, (HashMap)localObject, null, true);
      label530:
      localObject = this.a;
      if (!bool) {
        break label640;
      }
    }
    label640:
    for (int i = DBFixLoadingDialog.d;; i = DBFixLoadingDialog.e)
    {
      DBFixLoadingDialog.a((DBFixLoadingDialog)localObject, i);
      DBFixLoadingDialog.a(this.a).removeMessages(DBFixLoadingDialog.f);
      DBFixLoadingDialog.a(this.a).sendEmptyMessageDelayed(DBFixLoadingDialog.f, 100L);
      return;
      bool = ((DBFixManager)localObject).dbfixRepair(DBFixLoadingDialog.b(this.a).getAbsolutePath(), DBFixLoadingDialog.a(this.a).getAbsolutePath(), localDBFixResult);
      break;
      label615:
      localObject = "dbRepair";
      break label273;
      label622:
      ((DBFixManager)localObject).a(false);
      QLog.d(DBFixLoadingDialog.a(), 1, "db fix failed");
      break label530;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abwg
 * JD-Core Version:    0.7.0.1
 */