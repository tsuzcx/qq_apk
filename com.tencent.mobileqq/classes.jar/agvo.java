import com.tencent.mobileqq.qipc.QIPCServerModuleFactory;
import eipc.EIPCModule;
import eipc.EIPCModuleFactory;

public final class agvo
  implements EIPCModuleFactory
{
  public EIPCModule onCreateModule(String paramString)
  {
    return QIPCServerModuleFactory.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agvo
 * JD-Core Version:    0.7.0.1
 */