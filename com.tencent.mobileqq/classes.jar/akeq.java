import android.content.ContentValues;
import android.os.Handler;
import android.os.Looper;
import com.dataline.mpfile.MpfileTaskRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.1;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.2;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.3;
import com.tencent.mobileqq.app.proxy.MpfileTaskProxy.4;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import java.util.ArrayList;
import java.util.List;

public class akeq
  extends akej
{
  List<MpfileTaskRecord> a;
  
  public akeq(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  private String a(long paramLong, int paramInt)
  {
    String str = MpfileTaskRecord.tableName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select * ").append("from " + str + " ");
    if (paramLong != -1L) {
      localStringBuilder.append("where " + str + ".msgId < ? ");
    }
    localStringBuilder.append("limit " + paramInt + " ");
    return localStringBuilder.toString();
  }
  
  public long a(MpfileTaskRecord paramMpfileTaskRecord)
  {
    eu localeu = new eu(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      a(paramMpfileTaskRecord, null);
      return 0L;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.4(this, paramMpfileTaskRecord, localeu));
    localeu.a(-1L);
    return 0L;
  }
  
  public List<MpfileTaskRecord> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      Object localObject = MpfileTaskRecord.tableName();
      atmp localatmp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localatmp.b("create index if not exists " + (String)localObject + "_index ON " + (String)localObject + "(fileId, msgId)");
      List localList = localatmp.a(MpfileTaskRecord.class, a(-1L, 15), null);
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      this.jdField_a_of_type_JavaUtilList = ((List)localObject);
      localatmp.a();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void a() {}
  
  public void a(atmo paramatmo, akes paramakes)
  {
    eu localeu = new eu(false, false);
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      paramatmo = ((MpfileTaskRecord)paramatmo).clone();
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, MpfileTaskRecord.tableName(), paramatmo, 0, paramakes);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.1(this, paramatmo, paramakes, localeu));
    localeu.a(-1L);
  }
  
  public void a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, akes paramakes)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramContentValues, paramString2, paramArrayOfString, 1, paramakes);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.2(this, paramString1, paramContentValues, paramString2, paramArrayOfString, paramakes));
  }
  
  public void a(String paramString1, String paramString2, String[] paramArrayOfString, akes paramakes)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() == localLooper.getThread())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.a(String.valueOf(0), 0, paramString1, paramString2, paramArrayOfString, 2, paramakes);
      return;
    }
    new Handler(localLooper).post(new MpfileTaskProxy.3(this, paramString1, paramString2, paramArrayOfString, paramakes));
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akeq
 * JD-Core Version:    0.7.0.1
 */