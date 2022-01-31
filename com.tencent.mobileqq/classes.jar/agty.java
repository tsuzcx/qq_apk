import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class agty
  extends aofy<agtx>
{
  public int a()
  {
    return 410;
  }
  
  @NonNull
  public agtx a(int paramInt)
  {
    return new agtx();
  }
  
  @Nullable
  public agtx a(aogf[] paramArrayOfaogf)
  {
    if ((paramArrayOfaogf != null) && (paramArrayOfaogf.length > 0))
    {
      agtx localagtx = agtx.a(paramArrayOfaogf[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("StickerRecConfigProcessor", 2, "onParsed " + paramArrayOfaogf[0].a);
      }
      return localagtx;
    }
    return null;
  }
  
  public Class<agtx> a()
  {
    return agtx.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(agtx paramagtx)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      String str = ((QQAppInterface)localObject).c();
      agug.a(BaseApplicationImpl.getApplication(), str, paramagtx.a());
      agug.a((QQAppInterface)localObject, paramagtx.a());
    }
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agty
 * JD-Core Version:    0.7.0.1
 */