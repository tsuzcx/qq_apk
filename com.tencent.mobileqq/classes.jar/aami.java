import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.qphone.base.util.QLog;

public class aami
  extends aqwt<aamh>
{
  @NonNull
  public aamh a(int paramInt)
  {
    return new aamh();
  }
  
  @Nullable
  public aamh a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      aamh localaamh = aamh.a(paramArrayOfaqxa[0].a);
      a(localaamh);
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onParsed " + paramArrayOfaqxa[0].a);
      return localaamh;
    }
    return null;
  }
  
  public void a(aamh paramaamh)
  {
    QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate ");
    if (paramaamh != null)
    {
      QLog.i("Q.videostory.config.VSStickyNoteProcessor", 2, "onUpdate " + paramaamh.toString());
      VSConfigManager.getInstance().setValue("sticky_note_publish_entrance_config", paramaamh.a());
    }
  }
  
  public Class<aamh> clazz()
  {
    return aamh.class;
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
 * Qualified Name:     aami
 * JD-Core Version:    0.7.0.1
 */