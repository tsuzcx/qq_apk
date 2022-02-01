import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class abal
  extends arac<abak>
{
  @NonNull
  public abak a(int paramInt)
  {
    return new abak();
  }
  
  @Nullable
  public abak a(araj[] paramArrayOfaraj)
  {
    if ((paramArrayOfaraj != null) && (paramArrayOfaraj.length > 0))
    {
      abak localabak = abak.a(paramArrayOfaraj[0].a);
      a(localabak);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaraj[0].a);
      return localabak;
    }
    return null;
  }
  
  public void a(abak paramabak)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramabak != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramabak.toString());
      abac.a().a("sticky_note_publish_entrance_config", paramabak.a());
    }
  }
  
  public Class<abak> clazz()
  {
    return abak.class;
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
 * Qualified Name:     abal
 * JD-Core Version:    0.7.0.1
 */