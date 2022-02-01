import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aawi
  extends aqkz<aawh>
{
  @NonNull
  public aawh a(int paramInt)
  {
    return new aawh();
  }
  
  @Nullable
  public aawh a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aawh localaawh = aawh.a(paramArrayOfaqlg[0].a);
      a(localaawh);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      return localaawh;
    }
    return null;
  }
  
  public void a(aawh paramaawh)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramaawh != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramaawh.toString());
      aavz.a().a("sticky_note_publish_entrance_config", paramaawh.a());
    }
  }
  
  public Class<aawh> clazz()
  {
    return aawh.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aawi
 * JD-Core Version:    0.7.0.1
 */