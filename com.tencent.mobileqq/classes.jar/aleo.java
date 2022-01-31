import android.os.IInterface;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArEffectConfig;

public abstract interface aleo
  extends IInterface
{
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(long paramLong1, long paramLong2);
  
  public abstract void a(ArConfigInfo paramArConfigInfo, ArEffectConfig paramArEffectConfig, ARCommonConfigInfo paramARCommonConfigInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */