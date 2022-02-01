import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aika
  extends aqkz<aijz>
{
  private QQAppInterface a;
  
  @NonNull
  public aijz a(int paramInt)
  {
    return new aijz();
  }
  
  @Nullable
  public aijz a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      aijz localaijz = aijz.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("AdEmoConfigProcessor", 2, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localaijz;
    }
    return null;
  }
  
  public void a(aijz paramaijz)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.a == null)
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onUpdate, runtime is null ?  ");
        if (localObject != null) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AdEmoConfigProcessor", 2, bool + " , runtime instanceof QQAppInterface ? " + (localObject instanceof QQAppInterface));
      if ((localObject instanceof QQAppInterface)) {
        this.a = ((QQAppInterface)localObject);
      }
      if (this.a != null)
      {
        localObject = this.a.c();
        aijy.a(this.a.getApp(), (String)localObject, paramaijz.a);
      }
      return;
    }
  }
  
  public Class<aijz> clazz()
  {
    return aijz.class;
  }
  
  public boolean isAccountRelated()
  {
    return super.isAccountRelated();
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
    return 657;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aika
 * JD-Core Version:    0.7.0.1
 */