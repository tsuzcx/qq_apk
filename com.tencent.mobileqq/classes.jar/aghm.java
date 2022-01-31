import com.tencent.mobileqq.qipc.QIPCServerModuleFactory;
import eipc.EIPCModule;
import eipc.EIPCModuleFactory;

public final class aghm
  implements EIPCModuleFactory
{
  public EIPCModule onCreateModule(String paramString)
  {
    return QIPCServerModuleFactory.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aghm
 * JD-Core Version:    0.7.0.1
 */