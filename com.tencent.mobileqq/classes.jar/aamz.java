import com.tencent.ark.ArkEnvironmentManager.LibraryLoader;
import com.tencent.mobileqq.ark.ArkAppCenter;

public final class aamz
  implements ArkEnvironmentManager.LibraryLoader
{
  public boolean Load()
  {
    ArkAppCenter.e();
    return ArkAppCenter.b;
  }
  
  public boolean isLibraryLoad()
  {
    return ArkAppCenter.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aamz
 * JD-Core Version:    0.7.0.1
 */